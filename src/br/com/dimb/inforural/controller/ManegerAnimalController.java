package br.com.dimb.inforural.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Paging;

import br.com.dimb.inforural.business.Animal;
import br.com.dimb.inforural.business.Cor;
import br.com.dimb.inforural.business.Genero;
import br.com.dimb.inforural.business.Situacao;
import br.com.dimb.inforural.services.AnimalService;
import br.com.dimb.inforural.services.CorService;
import br.com.dimb.inforural.services.GeneroService;
import br.com.dimb.inforural.services.IBaseService;
import br.com.dimb.inforural.services.SituacaoService;

public class ManegerAnimalController extends ManegerBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Button salvar;
	private Button cancelar;
	private Button editar;
	private Button novo;
	private Paging paging;
	private Listbox box;
	private Combobox comboGenero;
	private Combobox comboSituacao;
	private Combobox comboCor;
	
	private AnimalService animalService;
	private CorService corService;
	private SituacaoService situacaoService;
	private GeneroService generoService;
	private List<Animal> listAnimal= new ArrayList<Animal>();
	private List<Cor> listCor;
	private List<Situacao> listSituacao;
	private List<Genero>   listGenero;
	private Animal currentAnimal;
	
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);
		this.iniciarPaginacao();
		this.init();
	}
	
	private void init(){
		this.listCor=corService.findAll();
		this.listGenero=this.generoService.findAll();
		this.listSituacao=this.situacaoService.findAll();
	}
	
	public void onClick$salvar() {
		/*if(this.getCur()!=null){
    		this.setCur(this.vacinaService.save(this.getCur()));
    		this.getListVacina().add(this.getCur());
    		this.setState(ManegerVacinaController.BROWSER);
    	}*/
		this.onSalvar();
    }
 
    public void onClick$editar() {
    	/*if(this.getCur()!=null){
    		this.vacinaService.update(this.getCur());
    		this.setState(ManegerVacinaController.BROWSER);
    	}*/
    	this.onAtulizar();
    }
    
    public void onClick$novo() {
    	/*this.box.setSelectedIndex(-1);
    	this.setCur(new Vacina());
    	this.setState(ManegerVacinaController.INSERTION);
    	this.paging.setTotalSize(this.paging.getTotalSize()+1);*/
    	this.onNovo(new Animal());
    }
    
    public void onClick$cancelar(){
    	/*if(this.getState()==ManegerVacinaController.INSERTION){
    		this.cur=null;
    	}
    	this.setState(ManegerVacinaController.BROWSER);*/
    	this.onCancelar();
    }
    
    public void onSelect$box(){
    	/*this.setCur(this.listVacina.get(this.box.getSelectedIndex()));
    	if(this.getState()!=ManegerVacinaController.EDITION){
    		this.setState(ManegerVacinaController.EDITION);
    	}*/
    	this.onSelecaoListbox();
    }

	@Override
	public IBaseService getBaseService() {
		return this.getAnimalService();
	}

	@Override
	public Button getBtnCancelar() {
		return this.cancelar;
	}

	@Override
	public Button getBtnEditar() {
		return this.editar;
	}

	@Override
	public Button getBtnNovo() {
		return this.novo;
	}

	@Override
	public Button getBtnSalvar() {
		return this.salvar;
	}

	@Override
	public List getListBase() {
		return this.getListAnimal();
	}

	@Override
	public Listbox getListbox() {
		return this.box;
	}

	@Override
	public Paging getPaging() {
		return this.paging;
	}

	@Override
	public Object getSelectedItem() {
		return this.getCurrentAnimal();
	}

	@Override
	public void setListBase(List listBaseManeger) {
		this.setListAnimal(listBaseManeger);
		
	}

	@Override
	public void setSelectedItem(Object item) {
		this.setCurrentAnimal((Animal)item);
		
	}
	@Autowired
	public void setAnimalService(AnimalService animalService) {
		this.animalService = animalService;
	}

	public AnimalService getAnimalService() {
		return animalService;
	}

	@Autowired
	public void setCorService(CorService corService) {
		this.corService = corService;
	}

	public CorService getCorService() {
		return corService;
	}

	public void setListCor(List<Cor> listCor) {
		this.listCor = listCor;
	}

	public List<Cor> getListCor() {
		return listCor;
	}

	public void setListAnimal(List<Animal> listAnimal) {
		this.listAnimal = listAnimal;
	}

	public List<Animal> getListAnimal() {
		return listAnimal;
	}

	public List<Situacao> getListSituacao() {
		return listSituacao;
	}

	public void setListSituacao(List<Situacao> listSituacao) {
		this.listSituacao = listSituacao;
	}

	public List<Genero> getListGenero() {
		return listGenero;
	}

	public void setListGenero(List<Genero> listGenero) {
		this.listGenero = listGenero;
	}
	
	@Autowired
	public void setSituacaoService(SituacaoService situacaoService) {
		this.situacaoService = situacaoService;
	}
	
	@Autowired
	public void setGeneroService(GeneroService generoService) {
		this.generoService = generoService;
	}

	public void setCurrentAnimal(Animal currentAnimal) {
		this.currentAnimal = currentAnimal;
	}

	public Animal getCurrentAnimal() {
		return currentAnimal;
	}

}
