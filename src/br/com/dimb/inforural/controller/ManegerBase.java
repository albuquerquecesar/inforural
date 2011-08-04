package br.com.dimb.inforural.controller;

import java.util.List;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Paging;

import br.com.dimb.inforural.business.Vacina;
import br.com.dimb.inforural.services.IBaseService;
import br.com.dimb.inforural.util.RowBounds;

public abstract class ManegerBase extends GenericForwardComposer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int EDITION=0;
	private static final int BROWSER=1;
	private static final int INSERTION=2; 
	private int state=-1;

	public abstract IBaseService getBaseService();
	
	public abstract Paging getPaging();
	
	public abstract List getListBase();
	
	public abstract void setListBase(List listBaseManeger);
	
	public abstract Button getBtnSalvar();
	
	public abstract Button getBtnCancelar();
	
	public abstract Button getBtnEditar();
	
	public abstract Button getBtnNovo();
	
	public  void setState(int state){
		this.state=state;
	}
	
	public int getState(){
		return this.state;
	}
	
	public abstract void setSelectedItem(Object item);
	
	public abstract Object getSelectedItem();
	
	public abstract Listbox getListbox();
	
	public void iniciarPaginacao(){
		this.calcularPaginacao(this.getPaging(), this.getBaseService());
		//adiciona paginação
		this.getPaging().addEventListener("onPaging", new EventListener() {
			
			@Override
			public void onEvent(Event event) throws Exception {
				setListBase(paginar(
						getPaging(),
						getBaseService()));
			}
		});
		//faz a primeira busca
		RowBounds row= new RowBounds(0, this.getPaging().getPageSize());
		this.setListBase(this.getBaseService().findAll(row));
		this.defineState(ManegerBase.BROWSER);
	}
	
	public void defineState(Integer state){
		switch(state){
		case ManegerBase.EDITION:
			this.getBtnSalvar().setDisabled(false);
			this.getBtnCancelar().setDisabled(false);
			this.getBtnNovo().setDisabled(true);
			this.getBtnEditar().setDisabled(true);
			this.setState(ManegerBase.EDITION);
			break;
		case ManegerBase.BROWSER:
			this.getBtnSalvar().setDisabled(true);
			this.getBtnCancelar().setDisabled(true);
			this.getBtnNovo().setDisabled(false);
			this.getBtnEditar().setDisabled(false);
			this.setState(ManegerBase.BROWSER);
			this.setSelectedItem(null);
			break;
		case ManegerBase.INSERTION:
			this.getBtnSalvar().setDisabled(false);
			this.getBtnCancelar().setDisabled(false);
			this.getBtnNovo().setDisabled(true);
			this.getBtnEditar().setDisabled(true);
			this.setState(ManegerBase.INSERTION);
			break;
				
		}
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
	}
	
	public void onSalvar() {
		if(this.getSelectedItem()!=null){
			if(this.getState()==ManegerBase.this.INSERTION){
				this.setSelectedItem(this.getBaseService().save(this.getSelectedItem()));
    			this.getListBase().add(this.getSelectedItem());
    			this.defineState(ManegerBase.BROWSER);
    			this.getPaging().setTotalSize(this.getPaging().getTotalSize()+1);
			}
			else if(this.getState()==ManegerBase.this.EDITION){
				this.getBaseService().update(this.getSelectedItem());
				this.defineState(ManegerBase.BROWSER);
			}
    	}
    }
 
    public void onAtulizar() {
    	if(this.getSelectedItem()!=null){
    		if(this.getListBase().size()>0){
        		this.defineState(ManegerBase.EDITION);
			}
    	}
    }
    
    public void onNovo(Object bean) {
    	this.setSelectedItem(bean);
    	this.getListbox().setSelectedIndex(-1);
    	this.defineState(ManegerBase.INSERTION);
    }
    
    public void onCancelar(){
    	if(this.getState()==ManegerBase.INSERTION){
    		this.setSelectedItem(null);
    	}
    	this.defineState(ManegerBase.BROWSER);
    }
    
    public void onSelecaoListbox(){
    	this.setSelectedItem((this.getListBase().get(this.getListbox().getSelectedIndex())));
    	
    }
    
}
