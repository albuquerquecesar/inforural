package br.com.dimb.inforural.repository;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import br.com.dimb.inforural.business.Animal;

@Repository
@Lazy(value=true)
public class AnimalDAO extends GenericDAOImp<Animal, Long>{

}
