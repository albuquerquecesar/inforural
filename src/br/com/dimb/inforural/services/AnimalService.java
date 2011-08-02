package br.com.dimb.inforural.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import br.com.dimb.inforural.business.Animal;
import br.com.dimb.inforural.repositorio.AnimalDAO;

@Service
@Lazy(value=true)
public class AnimalService extends BaseService<Animal, Long>{

	@Autowired
	public AnimalService(AnimalDAO DAO) {
		super(DAO);
		// TODO Auto-generated constructor stub
	}

}
