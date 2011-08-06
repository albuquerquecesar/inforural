package br.com.dimb.inforural.util;

import java.util.List;
import java.util.Map;

import net.priuli.filter.Filter;

import org.zkoss.zul.Paging;

import br.com.dimb.inforural.services.IBaseService;

public class Paginacao {
	
	public static void calcularPaginacao(Paging paging, IBaseService service){
		Long total=service.countRows();
		paging.setTotalSize(total.intValue());
	}
	
	public static List paginar(Paging paging,IBaseService service){
		Integer pagina=paging.getActivePage();
		//pagina-=1;
		int limit=paging.getPageSize();
		int offSet=pagina*limit;
		return service.findAll(new RowBounds(offSet, limit));
	}
	
	public static List paginar(Paging paging,IBaseService service,Filter filter){
		Integer pagina=paging.getActivePage();
		//pagina-=1;
		int limit=paging.getPageSize();
		int offSet=pagina*limit;
		return service.findAllBy(filter,new RowBounds(offSet, limit));
	}

}
