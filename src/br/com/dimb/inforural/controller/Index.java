package br.com.dimb.inforural.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Window;

import br.com.dimb.inforural.business.Cor;
import br.com.dimb.inforural.repositorio.CorDAO;
import br.com.dimb.inforural.services.AnimalService;

public class Index extends GenericForwardComposer{
	
	private Window winLogin;
	private AnimalService animalService;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
	}
	
	public void onClick$menItemLogin(){
		//this.winLogin=(Window)Executions.createComponents("login.zul", null, null);
		Executions.sendRedirect("Login.zul");
		SpringUtil util=new SpringUtil();
		CorDAO tem=(CorDAO)util.getBean("corDAO");
		this.animalService=(AnimalService) util.getBean("animalService");
		if(this.animalService==null){
    		System.out.println("Não criou o hibernateTemplate!");
    	}
    	else{
    		System.out.println("criou o hibernateTemplate!");
    	}
		///CorDAO dao= new CorDAO();
		Cor cor= new Cor();
		cor.setNome("SEM COR");
		//tem.save(cor);
	}


}
