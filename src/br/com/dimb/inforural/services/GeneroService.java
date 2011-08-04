package br.com.dimb.inforural.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import br.com.dimb.inforural.business.Genero;
import br.com.dimb.inforural.repositorio.GeneroDAO;

@Service
@Lazy(value=true)
public class GeneroService extends BaseService<Genero, Long>{
	
	@Autowired
	public GeneroService(GeneroDAO DAO) {
		super(DAO);
		// TODO Auto-generated constructor stub
	}

}
