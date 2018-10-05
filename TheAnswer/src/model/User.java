package model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//用户
@Entity
@Table(name="t_User")
public class User {
	
	@Id
	@GeneratedValue
	private int id;//主键
	
	private String username;//用户名
	
	private String password;//密码
	
	private String truename;//姓名
	
	private String sex;//性别
	
	private String yuanxi;//院系
	
	private String phone;//联系电话
	
	private String email;//邮箱
	
	private int role;//角色 (1学生，2教师)
	
	private Date createtime;//添加时间

	private int deletestatus;// 删除状态 0表示未删除 1表示已删除
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public int getDeletestatus() {
		return deletestatus;
	}

	public void setDeletestatus(int deletestatus) {
		this.deletestatus = deletestatus;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getYuanxi() {
		return yuanxi;
	}

	public void setYuanxi(String yuanxi) {
		this.yuanxi = yuanxi;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	
	
	
	
	
}
