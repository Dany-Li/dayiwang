package dao.impl;
import java.sql.SQLException;
import java.util.List;

import model.Luntan;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.LuntanDao;

public class LuntanDaoImpl extends HibernateDaoSupport implements LuntanDao {

	

	public void deleteBean(Luntan bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertBean(Luntan bean) {
		this.getHibernateTemplate().save(bean);
		
	}

	@SuppressWarnings("unchecked")
	public Luntan selectBean(String where) {
		List<Luntan> list = this.getHibernateTemplate().find("from Luntan "+where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public long selectBeanCount(final String where) {
		long count = (Long)this.getHibernateTemplate().find(" select count(*) from Luntan  "+where).get(0);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<Luntan> selectBeanList(final int start,final int limit,final String where) {
		return (List<Luntan>)this.getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(final Session session) throws HibernateException, SQLException {
				List<Luntan> list = session.createQuery(" from Luntan"+where).setFirstResult(start).setMaxResults(limit).list();
				return list;
			}
		});
		
	}

	public void updateBean(Luntan bean) {
		this.getHibernateTemplate().update(bean);
		
	}
	
	
	
	
	
	
	
}
