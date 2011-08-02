package br.com.dimb.inforural.repositorio;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import br.com.dimb.inforural.business.Usuario;

@Repository
@Lazy(value=true)
public class UsuarioDAO  extends GenericDAOImp<Usuario, Long>{

}
