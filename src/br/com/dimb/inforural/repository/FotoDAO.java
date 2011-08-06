package br.com.dimb.inforural.repository;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;


import br.com.dimb.inforural.business.Foto;

@Repository
@Lazy(value=true)
public class FotoDAO  extends GenericDAOImp<Foto, Long>{

}
