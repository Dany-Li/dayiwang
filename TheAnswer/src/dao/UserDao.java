package dao;

import java.util.List;

import model.User;



public interface UserDao {

	
	//插入新纪录
	public void insertBean(User bean);
	
	//根据id删除纪录
	public void deleteBean(User bean);
	
	//根据id更新纪录
	public void updateBean(User bean);

	//获取信息列表,带查询功能，start 表示当前页，limit表示每页显示的条数 start=1,lmit=10
	public List<User> selectBeanList(final int start,final int limit,final String where);
	
	
	//查询记录的总的条数
	public long selectBeanCount(final String where);
	
	//查询信息
	public User selectBean(String where);
	

}
