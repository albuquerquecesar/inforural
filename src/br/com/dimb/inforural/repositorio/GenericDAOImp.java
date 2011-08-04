package br.com.dimb.inforural.repositorio;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
		System.out.println(this.persistentClass.toString());
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
		Session se=this.getHibernateTemplate().getSessionFactory().openSession();
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

	@Override
	public List<T> findAllBy(T entity, RowBounds rowBounds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAllBy(T entity) {
		// TODO Auto-generated method stub
		return null;
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
	public Session getSessionCurrent(){
		return this.getHibernateTemplate().getSessionFactory().getCurrentSession();
	}

	@Override
	public void saveOrUpdateAll(List<T> entity) {
		this.hibernateTemplate.saveOrUpdateAll(entity);
	}

	
}
