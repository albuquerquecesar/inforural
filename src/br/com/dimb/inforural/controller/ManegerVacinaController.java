package br.com.dimb.inforural.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Button;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Paging;


import br.com.dimb.inforural.business.Vacina;
import br.com.dimb.inforural.services.IBaseService;
import br.com.dimb.inforural.services.VacinaService;

public class ManegerVacinaController extends ManegerBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*private static final int EDITION=0;
	private static final int BROWSER=1;
	private static final int INSERTION=2;*/
	private Vacina cur;
	private VacinaService vacinaService;
	private List<Vacina> listVacina=new ArrayList<Vacina>();
	private Listbox box;
	private Paging paging;
	private Button salvar;
	private Button novo;
	private Button editar;
	private Button cancelar;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		this.iniciarPaginacao();
		System.out.println("Criou controlador");
		/*this.calcularPaginacao(this.paging, this.vacinaService);
		//adiciona paginação
		this.paging.addEventListener("onPaging", new EventListener() {
			
			@Override
			public void onEvent(Event event) throws Exception {
				ManegerVacinaController.this.listVacina=ManegerVacinaController.this.paginar(
						ManegerVacinaController.this.paging,
						ManegerVacinaController.this.vacinaService);
			}
		});
		//faz a primeira busca
		RowBounds row= new RowBounds(0, this.paging.getPageSize());
		this.listVacina=this.getVacinaService().findAll(row);
		this.setState(ManegerVacinaController.BROWSER);*/
		
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
    	this.onNovo(new Vacina());
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
    
    public List<Vacina> getListVacina(){
		return this.listVacina;
	}
    
    public void setListVacina(List<Vacina> listVacina){
    	this.listVacina=listVacina;
    }
    
    public Vacina getCur(){
    	return this.cur;
    }
    
    public void setCur(Vacina Cur){
    	this.cur=Cur;
    }

    @Autowired
	public void setVacinaService(VacinaService vacinaService) {
		this.vacinaService = vacinaService;
	}

	public VacinaService getVacinaService() {
		return vacinaService;
	}

	//metodos sobrescritos da superclasse
	@Override
	public IBaseService getBaseService() {
		return this.getVacinaService();
	}

	@Override
	public Button getBtnCancelar() {
		return this.cancelar;
	}

	@Override
	public Button getBtnEditar(){
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
		return this.getListVacina();
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
		return this.cur;
	}


	@Override
	public void setListBase(List listBaseManeger) {
		this.setListVacina(listBaseManeger);
		
	}

	@Override
	public void setSelectedItem(Object item) {
		this.setCur((Vacina)item);
		
	}

	
	/*public void setState(Integer state){
		switch(state){
		case ManegerVacinaController.EDITION:
				this.add.setDisabled(true);
				this.cancel.setDisabled(false);
				this.novo.setDisabled(true);
				this.update.setDisabled(false);
				this.state=ManegerVacinaController.EDITION;
				break;
		case ManegerVacinaController.BROWSER:
				this.add.setDisabled(true);
				this.cancel.setDisabled(true);
				this.novo.setDisabled(false);
				this.update.setDisabled(true);
				this.state=ManegerVacinaController.BROWSER;
				this.setCur(null);
				break;
		case ManegerVacinaController.INSERTION:
			this.add.setDisabled(false);
			this.cancel.setDisabled(false);
			this.novo.setDisabled(true);
			this.update.setDisabled(true);
			this.state=ManegerVacinaController.INSERTION;
			break;
				
		}
	}*/
	
	/*public int getState(){
		return this.state;
	}

	public void calcularPaginacao(Paging paging, IBaseService service){
		Long total=service.countRows();
		paging.setTotalSize(total.intValue());
	}
	
	public List paginar(Paging paging,IBaseService service){
		Integer pagina=paging.getActivePage();
		//pagina-=1;
		int limit=paging.getPageSize();
		int offSet=pagina*limit;
		return service.findAll(new RowBounds(offSet, limit));
	}*/

}
