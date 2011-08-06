package br.com.dimb.inforural.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import br.com.dimb.inforural.business.Situacao;
import br.com.dimb.inforural.repository.SituacaoDAO;

@Service
@Lazy
public class SituacaoService extends BaseService<Situacao, Long>{

	@Autowired
	public SituacaoService(SituacaoDAO DAO) {
		super(DAO);
		// TODO Auto-generated constructor stub
	}

}
