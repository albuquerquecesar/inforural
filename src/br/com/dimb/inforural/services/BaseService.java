package br.com.dimb.inforural.services;

import java.io.Serializable;
import java.util.List;

import org.jfree.data.Range;

import br.com.dimb.inforural.repositorio.GenericDAO;
import br.com.dimb.inforural.util.RowBounds;

public class BaseService <T,ID extends Serializable> 
implements IBaseService<T,ID>{
	
	private GenericDAO genericDAO;
	
	public BaseService(GenericDAO DAO){
		this.genericDAO=DAO;
	}

	@Override
	public void delete(T entity) {
		this.genericDAO.delete(entity);
		
	}

	@Override
	public List<T> findAll() {
		return this.genericDAO.findAll();
	}

	@Override
	public List<T> findAll(RowBounds rowsBound) {
		return this.genericDAO.findAll(rowsBound);
	}

	@Override
	public List<T> findAllBy(T entity, RowBounds rowsBound) {
		return this.genericDAO.findAllBy(entity,rowsBound);
	}

	@Override
	public List<T> findAllBy(T entity) {
		return this.genericDAO.findAllBy(entity);
	}

	@Override
	public T getId(ID id) {
		return (T) this.genericDAO.getId(id);
	}

	@Override
	public T save(T entity) {
		// TODO Auto-generated method stub
		return (T) this.genericDAO.save(entity);
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		this.genericDAO.update(entity);
	}
	
	public Long countRows(){
		return this.genericDAO.countRows();
	}

	@Override
	public void saveOrUpdateAll(List<T> entity) {
		this.genericDAO.saveOrUpdateAll(entity);
		
	}

}
