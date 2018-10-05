package action;





import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Fenlei;
import model.Gonggao;
import model.Luntan;
import model.Manage;
import model.Taolun;
import model.User;

import org.apache.struts2.ServletActionContext;
import util.Pager;
import com.opensymphony.xwork2.ActionSupport;

import dao.FenleiDao;
import dao.GonggaoDao;
import dao.LuntanDao;
import dao.ManageDao;
import dao.TaolunDao;
import dao.UserDao;



public class ManageAction extends ActionSupport{

	
	private static final long serialVersionUID = 1L;
	
	
	private String url="./";
	
	    private GonggaoDao gonggaoDao;
	    private LuntanDao luntanDao;
	    private TaolunDao taolunDao;
	    private UserDao userDao;
	    private FenleiDao fenleiDao;
		
	

		public FenleiDao getFenleiDao() {
			return fenleiDao;
		}

		public void setFenleiDao(FenleiDao fenleiDao) {
			this.fenleiDao = fenleiDao;
		}




		public UserDao getUserDao() {
			return userDao;
		}


		public void setUserDao(UserDao userDao) {
			this.userDao = userDao;
		}


		
		 private File uploadfile;
			
			
		 public File getUploadfile() {
				return uploadfile;
			}

			
		 public void setUploadfile(File uploadfile) {
				this.uploadfile = uploadfile;
			}
	    
	
	
	public GonggaoDao getGonggaoDao() {
		return gonggaoDao;
	}

	public void setGonggaoDao(GonggaoDao gonggaoDao) {
		this.gonggaoDao = gonggaoDao;
	}
	
	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}
	
	private ManageDao manageDao;


	public ManageDao getManageDao() {
		return manageDao;
	}


	public void setManageDao(ManageDao manageDao) {
		this.manageDao = manageDao;
	}
	
	

	public LuntanDao getLuntanDao() {
		return luntanDao;
	}
	public void setLuntanDao(LuntanDao luntanDao) {
		this.luntanDao = luntanDao;
	}
	public TaolunDao getTaolunDao() {
		return taolunDao;
	}
	public void setTaolunDao(TaolunDao taolunDao) {
		this.taolunDao = taolunDao;
	}
	
	
	//管理员后台登陆
	public void login() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Manage bean = manageDao.selectBean(" where username='"+username+"' and password ='"+password+"' ");
		if(bean!=null){
			HttpSession session = request.getSession();
			session.setAttribute("manage", bean);
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('登陆成功');window.location.href='index.jsp'; </script>");
		}else{
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('用户名或者密码错误');window.location.href='login.jsp'; </script>");
		}
		
		
	}
	
	//用户退出操作
	public void loginout() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("manage");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('退出成功');window.location.href='login.jsp'; </script>");
	}
	
	
	public String changepwd(){
		this.setUrl("user/password.jsp");
		return SUCCESS;
		
	}
	
	
	//修改密码
	public void changepwd2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		HttpSession session = request.getSession();
		Manage user = (Manage)session.getAttribute("manage");
		
		Manage bean = manageDao.selectBean(" where username='"+user.getUsername()+"' and password ='"+password1+"' ");
		if(bean!=null){
			bean.setPassword(password2);
			manageDao.updateBean(bean);
			
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('操作成功');</script>");
		}else{
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('原密码错误');window.location.href='method!changepwd'; </script>");
		}
	}
	
	

	


	//用户列表
	public String userlist(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String role = request.getParameter("role");
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		if(username !=null &&!"".equals(username)){
			sb.append(" username like '%"+username+"%' ");
			sb.append(" and ");
			request.setAttribute("username", username);
		}
		if(role !=null &&!"".equals(role)){
			sb.append(" role like '%"+role+"%' ");
			sb.append(" and ");
			request.setAttribute("role", role);
		}
		sb.append(" deletestatus=0 order by id desc ");
		String where = sb.toString();
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		long total = userDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		List<User> list = userDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!userlist", "共有"+total+"条记录");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("user/userlist.jsp");
		return SUCCESS;
	}
	
	
	
	
	
	
	
	//用户删除操作
	public void userdelete() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		User bean =userDao.selectBean(" where id= "+id);
		bean.setDeletestatus(1);
		userDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('提交成功');window.location.href='method!userlist'; </script>");
		
	}
	
	
	
	
	
	//帮助中心列表
	public String gonggaolist(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String biaoti = request.getParameter("biaoti");
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		if(biaoti !=null &&!"".equals(biaoti)){
			sb.append(" biaoti like '%"+biaoti+"%' ");
			sb.append(" and ");
			request.setAttribute("biaoti", biaoti);
		}
		sb.append(" deletestatus=0 order by id desc ");
		String where = sb.toString();
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		long total = gonggaoDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		List<Gonggao> list = gonggaoDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!gonggaolist", "共有"+total+"条记录");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("gonggao/gonggaolist.jsp");
		return SUCCESS;
	}
	
	
	//跳转到添加帮助中心页面
	public String gonggaoadd(){
		this.setUrl("gonggao/gonggaoadd.jsp");
		return SUCCESS;
	}
	
	
	//添加帮助中心操作
	public void gonggaoadd2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String biaoti = request.getParameter("biaoti");
		String content = request.getParameter("content");
		Gonggao bean = new Gonggao();
		bean.setBiaoti(biaoti);
		bean.setContent(content);
		bean.setCreatetime(new Date());
		gonggaoDao.insertBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('提交成功');window.location.href='method!gonggaolist'; </script>");
		
	}
	
	
	
	//删除帮助中心操作
	public void gonggaodelete() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		Gonggao bean =gonggaoDao.selectBean(" where id= "+id);
		bean.setDeletestatus(1);
		gonggaoDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('提交成功');window.location.href='method!gonggaolist'; </script>");
		
	}
	
	//跳转到更新帮助中心页面
	public String gonggaoupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Gonggao bean =gonggaoDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("gonggao/gonggaoupdate.jsp");
		return SUCCESS;
	}
	
	
	//更新帮助中心操作
	public void gonggaoupdate2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String biaoti = request.getParameter("biaoti");
		String content = request.getParameter("content");
		String id = request.getParameter("id");
		Gonggao bean =gonggaoDao.selectBean(" where id= "+id);
		bean.setBiaoti(biaoti);
		bean.setContent(content);
		gonggaoDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('提交成功');window.location.href='method!gonggaolist'; </script>");
		
	}
	
	//跳转到查看帮助中心页面
	public String gonggaoupdate3(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Gonggao bean =gonggaoDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("gonggao/gonggaoupdate3.jsp");
		return SUCCESS;
	}
	

	
	/****发帖******/
	//发帖信息管理(后台管理)
	public String luntanlist(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String name=request.getParameter("name");
		String biaoti=request.getParameter("biaoti");
        StringBuffer sb = new StringBuffer();
        sb.append(" where ");
        if(name!=null&&!"".equals(name) ){
        	sb.append("fenlei.name like '%"+name+"%'");
        	sb.append(" and ");
        	request.setAttribute("name", name);
        }
        if(biaoti!=null&&!"".equals(biaoti) ){
        	sb.append("biaoti like '%"+biaoti+"%'");
        	sb.append(" and ");
        	request.setAttribute("biaoti", biaoti);
        }
        sb.append(" luntanlock=0 and fenlei.deletestatus=0  order by ziding desc,createtime desc");
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		String where =sb.toString();
		long total = luntanDao.selectBeanCount(where.replaceAll(" order by id desc", ""));
		List<Luntan> list = luntanDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!luntanlist", "共有"+total+"条记录");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("luntan/luntanlist.jsp");
		return SUCCESS;
	}
	

	
	//删除发帖操作
	public void luntandelete() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		Luntan bean =luntanDao.selectBean(" where id= "+id);
		bean.setLuntanlock(1);
		luntanDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('提交成功');window.location.href='method!luntanlist'; </script>");
		
	}
	

	
	//答疑(回帖)信息管理(后台)
	public String taolunlist(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String name=request.getParameter("name");
		String biaoti=request.getParameter("biaoti");
        StringBuffer sb = new StringBuffer();
        sb.append(" where ");
        if(name!=null&&!"".equals(name) ){
        	sb.append("luntan.fenlei.name like '%"+name+"%'");
        	sb.append(" and ");
        	request.setAttribute("name", name);
        }
        if(biaoti!=null&&!"".equals(biaoti) ){
        	sb.append("luntan.biaoti like '%"+biaoti+"%'");
        	sb.append(" and ");
        	request.setAttribute("biaoti", biaoti);
        }
        sb.append(" user.deletestatus=0 and taolunlock=0 and luntan.luntanlock=0 and luntan.fenlei.deletestatus=0 order by id desc");
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		String where =sb.toString();
		long total = taolunDao.selectBeanCount(where.replaceAll(" order by id desc", ""));
		List<Taolun> list = taolunDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
	
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!taolunlist", "共有"+total+"条记录");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("taolun/taolunlist.jsp");
		return SUCCESS;
	}
	


	
	//删除答疑(回帖)操作（后台）
	public void taolundelete() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		Taolun bean =taolunDao.selectBean(" where id= "+id);
		bean.setTaolunlock(1);
		taolunDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('删除成功');window.location.href='method!taolunlist'; </script>");
		
	}	


	//版块信息列表(后台)
	public String fenleilist(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String name = request.getParameter("name");
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		if(name !=null &&!"".equals(name)){
			sb.append(" name like '%"+name+"%' ");
			sb.append(" and ");
			request.setAttribute("name", name);
		}
		sb.append(" deletestatus=0 order by id desc ");
		String where = sb.toString();
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		long total = fenleiDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		List<Fenlei> list = fenleiDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!fenleilist", "共有"+total+"条记录");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("fenlei/fenleilist.jsp");
		return SUCCESS;
	}
	
	
	//跳转到添加版块页面(后台)
	public String fenleiadd(){
		this.setUrl("fenlei/fenleiadd.jsp");
		return SUCCESS;
	}
	
	
	//添加版块操作(后台)
	public void fenleiadd2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String name = request.getParameter("name");
		String person = request.getParameter("person");
		Fenlei bean = new Fenlei();
		bean.setName(name);
		bean.setPerson(person);
		bean.setCreatetime(new Date());
		fenleiDao.insertBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('提交成功');window.location.href='method!fenleilist'; </script>");
		
	}
	
	
	
	//删除版块操作(后台)
	public void fenleidelete() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		Fenlei bean =fenleiDao.selectBean(" where id= "+id);
		bean.setDeletestatus(1);
		fenleiDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('提交成功');window.location.href='method!fenleilist'; </script>");
		
	}
	
	//跳转到更新版块页面(后台)
	public String fenleiupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Fenlei bean =fenleiDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("fenlei/fenleiupdate.jsp");
		return SUCCESS;
	}
	
	
	//更新版块操作(后台)
	public void fenleiupdate2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String name = request.getParameter("name");
		String person = request.getParameter("person");
		String id = request.getParameter("id");
		Fenlei bean =fenleiDao.selectBean(" where id= "+id);
		bean.setName(name);
		bean.setPerson(person);
		bean.setCreatetime(new Date());
		fenleiDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('提交成功');window.location.href='method!fenleilist'; </script>");
		
	}
	
	
	
	//置顶操作
	public void zhiding() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		Luntan bean =luntanDao.selectBean(" where id= "+id);
		bean.setZiding(1);
		luntanDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('提交成功');window.location.href='method!luntanlist'; </script>");
		
	}
	
	//取消置顶操作
	public void zhiding2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		Luntan bean =luntanDao.selectBean(" where id= "+id);
		bean.setZiding(0);
		luntanDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('取消成功');window.location.href='method!luntanlist'; </script>");
		
	}
	
	
	//不可见操作
	public void kejian() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		Taolun bean =taolunDao.selectBean(" where id= "+id);
		bean.setStauts(1);
		taolunDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('提交成功');window.location.href='method!taolunlist'; </script>");
		
	}
	
	//取消不可见操作
	public void kejian2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		Taolun bean =taolunDao.selectBean(" where id= "+id);
		bean.setStauts(0);
		taolunDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('取消成功');window.location.href='method!taolunlist'; </script>");
		
	}
	
	
	
}
