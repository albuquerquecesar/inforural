package br.com.dimb.inforural.repository;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;


import br.com.dimb.inforural.business.Genero;

@Repository
@Lazy(value=true)
public class GeneroDAO  extends GenericDAOImp<Genero, Long>{

}
