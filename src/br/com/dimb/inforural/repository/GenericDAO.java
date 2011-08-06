package br.com.dimb.inforural.repository;

import java.io.Serializable;
import java.util.List;

import net.priuli.filter.Filter;

import br.com.dimb.inforural.util.RowBounds;

public interface GenericDAO<T,ID extends Serializable>{
	
	public void delete(T entity) ;

	public List<T> findAll() ;

	public List<T> findAll(RowBounds rowBounds);
	
	public List<T> findAllBy(Filter filter,  RowBounds rowBounds);
	
	public List<T> findAllBy(Filter filter) ;

	public T getId(ID id);

	public T save(T entity);
	
	public void saveOrUpdateAll(List<T> entity);

	public void update(T entity);
	
	public Long countRows();
	
	//public Integer countRows(RowBounds rowsBound);
}
