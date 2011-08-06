package br.com.dimb.inforural.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import br.com.dimb.inforural.business.Cor;
import br.com.dimb.inforural.repository.CorDAO;

@Service
@Lazy(value=true)
public class CorService extends BaseService<Cor, Long> {

	@Autowired
	public CorService(CorDAO DAO) {
		super(DAO);
		// TODO Auto-generated constructor stub
	}

}
