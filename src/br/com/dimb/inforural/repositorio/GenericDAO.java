package br.com.dimb.inforural.repositorio;

import java.io.Serializable;
import java.util.List;

import net.priuli.filter.Filter;
import net.priuli.filter.utils.HibernateUtils;
import net.priuli.filter.utils.ScannerJPAEntity;

import org.hibernate.Criteria;
import org.jfree.data.Range;

import br.com.dimb.inforural.util.RowBounds;

public interface GenericDAO<T,ID extends Serializable>{
	
	public void delete(T entity) ;

	public List<T> findAll() ;

	public List<T> findAll(RowBounds rowBounds);
	
	public List<T> findAllBy(T entity,  RowBounds rowBounds);
	
	public List<T> findAllBy(T entity) ;

	public T getId(ID id);

	public T save(T entity);

	public void update(T entity);
	
	public Long countRows();
	
	//public Integer countRows(RowBounds rowsBound);
}
