package dao;
import java.util.List;

import model.Taolun;

public interface TaolunDao {

	
	//插入新纪录
	public void insertBean(Taolun bean);
	
	//根据用户id删除纪录
	public void deleteBean(Taolun bean);
	
	//根据用户id更新纪录
	public void updateBean(Taolun bean);

	//获取信息列表,带查询功能，start 表示当前页，limit表示每页显示的条数 start=1,lmit=10
	public List<Taolun> selectBeanList(final int start,final int limit,final String where);
	
	
	//查询记录的总的条数
	public long selectBeanCount(final String where);
	
	//查询用户信息
	public Taolun selectBean(String where);
	

}
