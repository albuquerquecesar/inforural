package br.com.dimb.inforural.controller;

import java.util.List;

import net.priuli.filter.Filter;
import net.priuli.filter.utils.FactoryFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Window;

import br.com.dimb.inforural.business.Animal;
import br.com.dimb.inforural.services.AnimalService;

public class Index extends GenericForwardComposer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		System.out.println("teste");
		Filter filter= FactoryFilter.createFilter();
		//filter.addRestriction("apelido","V" );
		List<Animal> it=this.getAnimalService().findAllBy(filter);
		for (int i = 0; i < it.size(); i++) {
			System.out.println(it.get(i).getApelido());
		}
	}

	@Autowired
	public void setAnimalService(AnimalService animalService) {
		this.animalService = animalService;
	}

	public AnimalService getAnimalService() {
		return animalService;
	}


}
