package br.com.dimb.inforural.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;


import net.priuli.filter.Filter;
import net.priuli.filter.utils.HibernateUtils;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import br.com.dimb.inforural.util.RowBounds;


public abstract class GenericDAOImp<T,ID extends Serializable> implements GenericDAO<T, Serializable>{
	
	private Class<T> persistentClass;
	private HibernateTemplate hibernateTemplate;
	

	public Class<T> getPersistentClass() {
		return persistentClass;
	}
	
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@SuppressWarnings("unchecked")
	public GenericDAOImp(){
		this.persistentClass=(Class<T>) ((ParameterizedType)
			      getClass().getGenericSuperclass()).getActualTypeArguments()[0]; 
	}

	@Override
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
		
	}

	@Override
	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
		
	}

	@Override
	public List<T> findAll() {	
		return this.getHibernateTemplate().loadAll(this.getPersistentClass());
	}

	@Override
	public List<T> findAll( RowBounds rowBounds) {
		Session se=this.getSession();
		List<T> list=null;
		try{
			Criteria crit = se.createCriteria(this.getPersistentClass());
			ProjectionList proList= Projections.projectionList();
			//proList.add(Projections.)
			crit.setFirstResult(rowBounds.getOffset());
			crit.setMaxResults(rowBounds.getLimit());
			list=crit.list();
		}catch(Exception ex){
			System.out.println(ex.toString());
		}
		finally{
			if(se!=null){
				se.flush();
				se.close();
			}
			return list;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAllBy(final Filter filter, RowBounds rowBounds) {
		return (List<T>)this.getHibernateTemplate().executeFind(new HibernateCallback() {

			@SuppressWarnings("finally")
			@Override
			public Object doInHibernate(Session arg0){
				Criteria cri=null;
				try{
					if(arg0==null){
						System.out.println("Sessao esta fudida!");
					}
					cri=HibernateUtils.buildCriteria(filter, arg0,getClass());
				}catch(Exception e){
					System.out.println("Deu erro no find!");
				}
				finally{
					if(cri!=null)
					return cri.list();
					return null;
				}
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAllBy(final Filter filter) {
		return (List<T>)this.getHibernateTemplate().executeFind(new HibernateCallback() {

			@SuppressWarnings("finally")
			@Override
			public Object doInHibernate(Session arg0){
				Criteria cri=null;
				try{
					if(arg0==null){
						System.out.println("Sessao esta fudida!");
					}
					cri=HibernateUtils.buildCriteria(filter, arg0, GenericDAOImp.this.getClass());
				}catch(Exception e){
					System.out.println("Deu erro no find!");
				}
				finally{
					if(cri!=null)
					return cri.list();
					return null;
				}
			}
		});
	}

	@Override
	public T getId(Serializable id) {
		return this.getHibernateTemplate().get(this.getPersistentClass(), id);
	}

	@Override
	public T save(T entity) {
		this.getHibernateTemplate().save(entity);
		return entity;
	}

	public Long countRows(){
		Session se=this.getHibernateTemplate().getSessionFactory().openSession();
		Long total=0L;
		try{
			Criteria crit = se.createCriteria(this.getPersistentClass());
			crit.setProjection(Projections.rowCount());
			total = (Long) crit.uniqueResult();
		}catch(Exception ex){
			System.out.println(ex.toString());
		}
		finally{
			if(se!=null){
				se.flush();
				se.close();
			}
			return total;
		}
	}
	
	public Integer countRows(RowBounds rowsBound){
		return 0;
	}
	public Session getSession(){
		return this.getHibernateTemplate().getSessionFactory().openSession();
	}

	@Override
	public void saveOrUpdateAll(List<T> entity) {
		this.hibernateTemplate.saveOrUpdateAll(entity);
	}

	
}
