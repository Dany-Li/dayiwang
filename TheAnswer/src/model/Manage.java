package model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//管理员表
@Entity
@Table(name="t_Manage")
public class Manage {
	
	@Id
	@GeneratedValue
	private int id;//主键
	
	private String username;//用户名
	
	private String password;//密码


	
	
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

	

	

	
	
	
	
	
}
