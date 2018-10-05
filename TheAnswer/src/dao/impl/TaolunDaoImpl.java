package dao.impl;
import java.sql.SQLException;
import java.util.List;

import model.Taolun;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.TaolunDao;

public class TaolunDaoImpl extends HibernateDaoSupport implements TaolunDao {

	

	public void deleteBean(Taolun bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertBean(Taolun bean) {
		this.getHibernateTemplate().save(bean);
		
	}

	@SuppressWarnings("unchecked")
	public Taolun selectBean(String where) {
		List<Taolun> list = this.getHibernateTemplate().find("from Taolun "+where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public long selectBeanCount(final String where) {
		long count = (Long)this.getHibernateTemplate().find(" select count(*) from Taolun  "+where).get(0);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<Taolun> selectBeanList(final int start,final int limit,final String where) {
		return (List<Taolun>)this.getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(final Session session) throws HibernateException, SQLException {
				List<Taolun> list = session.createQuery(" from Taolun"+where).setFirstResult(start).setMaxResults(limit).list();
				return list;
			}
		});
		
	}

	public void updateBean(Taolun bean) {
		this.getHibernateTemplate().update(bean);
		
	}
	
	
	
	
	
	
	
}
