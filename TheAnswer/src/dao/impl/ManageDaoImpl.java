package dao.impl;

import java.sql.SQLException;
import java.util.List;


import model.Manage;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.ManageDao;



public class ManageDaoImpl extends HibernateDaoSupport implements ManageDao {

	

	public void deleteBean(Manage bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertBean(Manage bean) {
		this.getHibernateTemplate().save(bean);
		
	}

	@SuppressWarnings("unchecked")
	public Manage selectBean(String where) {
		List<Manage> list = this.getHibernateTemplate().find("from Manage "+where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public long selectBeanCount(final String where) {
		long count = (Long)this.getHibernateTemplate().find(" select count(*) from Manage  "+where).get(0);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<Manage> selectBeanList(final int start,final int limit,final String where) {
		return (List<Manage>)this.getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(final Session session) throws HibernateException, SQLException {
				List<Manage> list = session.createQuery(" from Manage"+where).setFirstResult(start).setMaxResults(limit).list();
				return list;
			}
		});
		
	}

	public void updateBean(Manage bean) {
		this.getHibernateTemplate().update(bean);
		
	}
	
	
	
	
	
	
	
}
