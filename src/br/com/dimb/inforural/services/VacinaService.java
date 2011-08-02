package br.com.dimb.inforural.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import br.com.dimb.inforural.business.Vacina;
import br.com.dimb.inforural.repositorio.VacinaDAO;

@Service
@Lazy(value=true)
public class VacinaService extends BaseService<Vacina, Long>{

	@Autowired
	public VacinaService(VacinaDAO DAO) {
		super(DAO);
		// TODO Auto-generated constructor stub
	}

}
