package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_post")//发帖
public class Luntan implements Serializable{

	private static final long serialVersionUID = -7141419035239709511L;

	private long id;
	 
	private String biaoti;//主题
	
	@Column(name="content", columnDefinition="TEXT")
	private String content;//主题描述
	
	private Fenlei  fenlei;//用户 关联版块
	
    private User user;//用户 关联用户的ID 
    
    private int ziding;//是否置顶    1置顶  0null 
    
    private int goods;//最佳答案是否设置（0未设置，1已设置）

	private Date createtime;//添加时间
	
	private int luntanlock;
	


	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getBiaoti() {
		return biaoti;
	}

	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}

	public int getLuntanlock() {
		return luntanlock;
	}

	public void setLuntanlock(int luntanlock) {
		this.luntanlock = luntanlock;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@ManyToOne
	@JoinColumn(name="userid")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name="fenleiid")
	public Fenlei getFenlei() {
		return fenlei;
	}

	public void setFenlei(Fenlei fenlei) {
		this.fenlei = fenlei;
	}

	public int getZiding() {
		return ziding;
	}

	public void setZiding(int ziding) {
		this.ziding = ziding;
	}

	public int getGoods() {
		return goods;
	}

	public void setGoods(int goods) {
		this.goods = goods;
	}
	

}
