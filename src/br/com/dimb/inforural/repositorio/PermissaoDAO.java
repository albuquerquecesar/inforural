package br.com.dimb.inforural.repositorio;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import br.com.dimb.inforural.business.Permissao;


@Repository
@Lazy(value=true)
public class PermissaoDAO  extends GenericDAOImp<Permissao, Long>{

}
