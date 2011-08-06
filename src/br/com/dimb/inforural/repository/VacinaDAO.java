package br.com.dimb.inforural.repository;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import br.com.dimb.inforural.business.Vacina;


@Repository
@Lazy(value=true)
public class VacinaDAO  extends GenericDAOImp<Vacina, Long>{

}
