package br.com.dimb.inforural.services;

import java.io.Serializable;
import java.util.List;

import org.jfree.data.Range;

import br.com.dimb.inforural.util.RowBounds;

public interface IBaseService<T,ID extends Serializable>{
	
	public void delete(T entity) ;

	public List<T> findAll() ;

	public List<T> findAll(RowBounds rowsBound);
	
	public List<T> findAllBy(T entity, RowBounds rowsBound);
	
	public List<T> findAllBy(T entity) ;

	public T getId(ID id);

	public T save(T entity);

	public void update(T entity);

	public Long countRows();
}
