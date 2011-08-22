package br.com.dimb.inforural.controller;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;

public class HomeController extends GenericForwardComposer{

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
	}
	
	public void onClick$menuAnimal(){
		Executions.sendRedirect("/pages/geral/manegerAnimal.zul");
	}
	public void onClick$menuVacina(){
		Executions.sendRedirect("/pages/geral/manegerVacina.zul");
	}
}
