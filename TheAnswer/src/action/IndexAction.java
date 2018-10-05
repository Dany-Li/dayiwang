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
import model.Taolun;
import model.User;

import org.apache.struts2.ServletActionContext;
import util.Pager;
import com.opensymphony.xwork2.ActionSupport;


import dao.FenleiDao;
import dao.GonggaoDao;
import dao.LuntanDao;
import dao.TaolunDao;
import dao.UserDao;

public class IndexAction extends ActionSupport {
 
	private static final long serialVersionUID = 1L;

	private String url = "./";
	private File uploadfile;

	 public File getUploadfile() {
			return uploadfile;
		}
	
	 public void setUploadfile(File uploadfile) {
			this.uploadfile = uploadfile;
		}

    private UserDao userDao;
    private LuntanDao luntanDao;
    private TaolunDao taolunDao;
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

	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	
	private GonggaoDao gonggaoDao;



	public GonggaoDao getGonggaoDao() {
		return gonggaoDao;
	}

	public void setGonggaoDao(GonggaoDao gonggaoDao) {
		this.gonggaoDao = gonggaoDao;
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
	


	
	//首页
	public  String  index(){
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
		String where = sb.toString();
		int currentpage = 1;
		int pagesize = 15;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		long total = luntanDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		List<Luntan> list = luntanDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "indexmethod!index", "共有"+total+"条记录");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("index.jsp");
		return SUCCESS;
	
	}

	
	
/*******************************用户登录注册************************/
	// 用户注册操作
	public void register() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String username = request.getParameter("username");
		String yuanxi = request.getParameter("yuanxi");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String role = request.getParameter("role");
		String truename = request.getParameter("truename");
		String sex = request.getParameter("sex");
		User bean = userDao.selectBean("  where deletestatus=0 and username='"+ username + "'");
		if (bean == null) {
			bean = new User();
			bean.setYuanxi(yuanxi);
			bean.setCreatetime(new Date());
			bean.setEmail(email);
			bean.setPassword(password);
			bean.setPhone(phone);
			bean.setRole(Integer.parseInt(role));
			bean.setTruename(truename);
			bean.setUsername(username);
			bean.setSex(sex);
			userDao.insertBean(bean);
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("注册成功，您的用户名:"+bean.getUsername()+"");
		} else {
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('用户名已经存在，注册失败！');window.location.href='register.jsp'; </script>");
		}

	}
	
	// 用户登录操作
	public void login() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Integer role = Integer.parseInt(request.getParameter("role"));
		User bean = userDao.selectBean("  where deletestatus=0 and username='"+username+"' and password='"+password+"' and role="+role+" ");
		if (bean != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", bean);
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('登录成功！');window.location.href='indexmethod!index'; </script>");
		} else {
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('用户名或者密码或者角色错误！登录失败');window.location.href='indexmethod!index'; </script>");
		}

	}

	// 用户退出操作
	public void loginout() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('退出成功！');window.location.href='index'; </script>");

	}
	
	
	//个人信息查询
	public String useradd() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest(); 
		String id = request.getParameter("id");
		User bean =userDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("useradd.jsp");
		return SUCCESS;
	}
	
	
	//跳转到更新用户页面
	public String userupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");	
		User bean =userDao.selectBean(" where id= "+user.getId());
		request.setAttribute("bean", bean);
		this.setUrl("userupdate.jsp");
		return SUCCESS;
	}
	
	
	//更新用户操作
	public void userupdate2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String yuanxi = request.getParameter("yuanxi");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String truename = request.getParameter("truename");
		String sex = request.getParameter("sex");
		String id = request.getParameter("id");
		User bean =userDao.selectBean(" where id= "+id);
		bean.setYuanxi(yuanxi);
		bean.setCreatetime(new Date());
		bean.setEmail(email);
		bean.setPassword(password);
		bean.setPhone(phone);
		bean.setTruename(truename);
		bean.setSex(sex);
		bean.setCreatetime(new Date());
		userDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("个人信息修改成功");
	}
	
	
	
	/*******************帮助中心信息************************/
	//帮助中心列表
	public String sy_gonggaolist(){
		HttpServletRequest request = ServletActionContext.getRequest();
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
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
		this.setUrl("sy_gonggaolist.jsp");
		return SUCCESS;
	}
	
	
	
	//跳转到查看帮助中心页面
	public String xq_gonggaoupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Gonggao bean =gonggaoDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("xq_gonggaoupdate.jsp");
		return SUCCESS;
	}
	
	

	
	
	/***************************************发帖*********************************************/
	
	//发帖信息（首页）
	public String sy_luntanlist(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id=request.getParameter("id");
		Fenlei fenlei=fenleiDao.selectBean(" where id="+id);
		String biaoti=request.getParameter("biaoti");
        StringBuffer sb = new StringBuffer();
        sb.append(" where ");
        if(biaoti!=null&&!"".equals(biaoti) ){
        	sb.append("biaoti like '%"+biaoti+"%'");
        	sb.append(" and ");
        	request.setAttribute("biaoti", biaoti);
        }
        sb.append(" fenlei.deletestatus=0 	and luntanlock=0 and fenlei="+fenlei.getId()+"  order by id desc ");
		int currentpage = 1;
		int pagesize = 16;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		String where =sb.toString();
		long total = luntanDao.selectBeanCount(where.replaceAll(" order by id desc", ""));
		List<Luntan> list = luntanDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		request.setAttribute("fenlei", fenlei.getName());
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!sy_luntanlist?fenlei="+fenlei.getId()+"", "共有"+total+"条记录");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("sy_luntanlist.jsp");
		return SUCCESS;
	}
	
	
	//发帖信息（我的）
	public String my_luntanlist() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");	
		if(user==null){
		    response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('请先登录');window.location.href='indexmethod!index'; </script>");
			return null ;
		}
        StringBuffer sb = new StringBuffer();
        sb.append(" where ");
        sb.append("  luntanlock=0 and user="+user.getId()+"  order by id desc");
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		String where =sb.toString();
		long total = luntanDao.selectBeanCount(where.replaceAll(" order by id desc", ""));
		List<Luntan> list = luntanDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "indexmethod!my_luntanlist", "共有"+total+"条记录");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("my_luntanlist.jsp");
		return SUCCESS;
	}
	
	//跳转到添加发帖主题(前台)
	public String my_luntanadd(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Fenlei> list = fenleiDao.selectBeanList(0, 99, " where deletestatus=0 ");
		request.setAttribute("list", list);
		this.setUrl("my_luntanadd.jsp");
		return SUCCESS;
	}
	

	//添加发帖主题操作（前台）
	public void my_luntanadd2()throws IOException{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");	
		String biaoti = request.getParameter("biaoti");
		String content = request.getParameter("content");
		String fenlei = request.getParameter("fenlei");
		Date createtime=new Date();
	
			    Luntan  bean=new Luntan();
			    bean.setBiaoti(biaoti);
			    bean.setContent(content);
			    bean.setFenlei(fenleiDao.selectBean(" where id="+fenlei));
			    bean.setUser(user);
				bean.setCreatetime(createtime);
				luntanDao.insertBean(bean);
				response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
				PrintWriter writer=response.getWriter();
				writer.print("<script language='javascript'>alert('提交成功');window.location.href='indexmethod!my_luntanlist'; </script> ");
			
		}
	
	//删除发帖主题操作(用户)
	public void my_luntandelete() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		Luntan bean =luntanDao.selectBean(" where id= "+id);
		bean.setLuntanlock(1);
		luntanDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('提交成功');window.location.href='indexmethod!my_luntanlist'; </script>");
		
	}
	
	
	
	//发帖答疑(回帖)列表(首页)
	public String sy_taolunlist() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Luntan bean2 =luntanDao.selectBean(" where id= "+id);
        StringBuffer sb = new StringBuffer();
        sb.append(" where ");
        sb.append(" user.deletestatus=0 and taolunlock=0 and luntanid="+bean2.getId()+" order by goods desc,id desc");
		int currentpage = 1;
		int pagesize = 15;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		String where =sb.toString();
		long total = taolunDao.selectBeanCount(where.replaceAll(" order by id desc", ""));
		List<Taolun> list = taolunDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		request.setAttribute("bean2", bean2);
		request.setAttribute("num", taolunDao.selectBeanCount(" where taolunlock=0 and luntanid="+bean2.getId()+""));
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "indexmethod!sy_taolunlist", "共有"+total+"条记录");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("sy_taolunlist.jsp");
		return SUCCESS;
	}
	
	//发帖答疑(回帖)操作(首页)
	public void sy_taolunadd2()throws IOException{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			writer.print("<script  language='javascript'>alert('请先登录');window.location.href='index'; </script> ");
			return;
		}
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		Date createtime=new Date();
		Taolun bean=new Taolun();	   
	    bean.setContent(content);
		bean.setCreatetime(createtime);
		bean.setLuntan(luntanDao.selectBean(" where id="+id ));
		bean.setUser(user);
		taolunDao.insertBean(bean);
		writer.print("<script language='javascript'>alert('提交成功');window.location.href='indexmethod!sy_taolunlist?id="+bean.getLuntan().getId() +"'; </script> ");
	}
	
	
	//设置最佳答案(用户)
	public void goods() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		Taolun bean =taolunDao.selectBean(" where id= "+id);
		bean.setGoods(1);
		taolunDao.updateBean(bean);
		Luntan l=luntanDao.selectBean(" where id="+bean.getLuntan().getId());
		l.setGoods(1);
		luntanDao.updateBean(l);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('提交成功');window.location.href='indexmethod!sy_taolunlist?id="+bean.getLuntan().getId()+"'; </script>");
		
	}
	
	
	
	
}
