package br.com.dimb.inforural.services;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import br.com.dimb.inforural.business.AnimalTemVacina;
import br.com.dimb.inforural.repositorio.AnimalTemVacinaDAO;

@Service
@Lazy(value=true)
public class AnimalTemVacinaService extends BaseService<AnimalTemVacina, Long>{

	public AnimalTemVacinaService(AnimalTemVacinaDAO DAO) {
		super(DAO);
		// TODO Auto-generated constructor stub
	}

}
