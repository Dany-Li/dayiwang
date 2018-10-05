package dao;


import model.Gonggao;

import java.util.List;



public interface GonggaoDao {

	
	//插入新纪录
	public void insertBean(Gonggao bean);
	
	//根据id删除纪录
	public void deleteBean(Gonggao bean);
	
	//根据id更新纪录
	public void updateBean(Gonggao bean);

	//获取信息列表,带查询功能，start 表示当前页，limit表示每页显示的条数 start=1,lmit=10
	public List<Gonggao> selectBeanList(final int start,final int limit,final String where);
	
	
	//查询记录的总的条数
	public long selectBeanCount(final String where);
	
	//查询信息
	public Gonggao selectBean(String where);
	

}
