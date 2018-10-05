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

//答疑(回帖)
@Entity
@Table(name="t_answering ")
public class Taolun implements Serializable{

	private static final long serialVersionUID = -7141419035239709511L;

	private long id;
	 
	private Luntan luntan;//关联发帖
	
	@Column(name="content", columnDefinition="TEXT")
	private String content;//发布内容
	
	private User user;//关联用户
	
	private int stauts;//设置可见（0可见，1不可见）
	
	private int goods;//评为最佳 (0未评，1最佳答案)

	private Date createtime;
	
	private int taolunlock;
	
	

	
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

	@ManyToOne
	@JoinColumn(name="userid")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@ManyToOne
	@JoinColumn(name="luntanid")
	public Luntan getLuntan() {
		return luntan;
	}

	public void setLuntan(Luntan luntan) {
		this.luntan = luntan;
	}

	public int getTaolunlock() {
		return taolunlock;
	}

	public void setTaolunlock(int taolunlock) {
		this.taolunlock = taolunlock;
	}

	public int getStauts() {
		return stauts;
	}

	public void setStauts(int stauts) {
		this.stauts = stauts;
	}

	public int getGoods() {
		return goods;
	}

	public void setGoods(int goods) {
		this.goods = goods;
	}

	
}
