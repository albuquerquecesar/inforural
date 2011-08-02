package br.com.dimb.inforural.repositorio;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import br.com.dimb.inforural.business.TipoAnimal;


@Repository
@Lazy(value=true)
public class TipoAnimalDAO extends GenericDAOImp<TipoAnimal, Long> {

}
