package br.com.dimb.inforural.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import br.com.dimb.inforural.business.TipoAnimal;
import br.com.dimb.inforural.repository.TipoAnimalDAO;

@Service
@Lazy(value=true)
public class TipoAnimalService extends BaseService<TipoAnimal, Long>{

	@Autowired
	public TipoAnimalService(TipoAnimalDAO DAO) {
		super(DAO);
		// TODO Auto-generated constructor stub
	}

}
