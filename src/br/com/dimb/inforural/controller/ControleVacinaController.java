package br.com.dimb.inforural.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Auxheader;

import br.com.dimb.inforural.business.Animal;
import br.com.dimb.inforural.business.Vacina;
import br.com.dimb.inforural.services.AnimalService;
import br.com.dimb.inforural.services.AnimalTemVacinaService;
import br.com.dimb.inforural.services.VacinaService;

public class ControleVacinaController extends GenericForwardComposer{
	
	private List<Animal> listAnimal;
	private AnimalService animalService;
	private VacinaService vacinaService;
	private AnimalTemVacinaService animalTemVacinaService;
	private Auxheader headerTit;
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		this.listAnimal= new ArrayList<Animal>();
		String s=this.headerTit.getLabel();
		this.headerTit.setLabel(s);
	}
	
	public void onClick$btnPesquisar(){
		this.listAnimal=this.pesquisar();
	}
	
	/*public void onClick$btnVacine(){
		Vacina v=this.getVacinaService().getId(1L);
		v.set
		this.getVacinaService().update(entity)
	}*/
	
	public List<Animal> pesquisar(){
		return this.getAnimalService().findAll();
	}

	public void setListAnimal(List<Animal> listAnimal) {
		this.listAnimal = listAnimal;
	}

	public List<Animal> getListAnimal() {
		return listAnimal;
	}

	@Autowired
	public void setAnimalService(AnimalService animalService) {
		this.animalService = animalService;
	}

	public AnimalService getAnimalService() {
		return animalService;
	}

	@Autowired
	public void setVacinaService(VacinaService vacinaService) {
		this.vacinaService = vacinaService;
	}

	public VacinaService getVacinaService() {
		return vacinaService;
	}

	@Autowired
	public void setAnimalTemVacinaService(AnimalTemVacinaService animalTemVacinaService) {
		this.animalTemVacinaService = animalTemVacinaService;
	}

	public AnimalTemVacinaService getAnimalTemVacinaService() {
		return animalTemVacinaService;
	}
	
	


}
