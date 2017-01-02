package org.hubotek.view.google.cse.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hubotek.service.ejb.cse.GoogleCseEngineService;
import org.hubotek.view.cse.GoogleCustomSearchEngine;

@ManagedBean(name="cseListView")
@ViewScoped
public class GoogleCustomSearchEngineView {

	@EJB
	GoogleCseEngineService googleCseEngineService;
	private List<GoogleCustomSearchEngine> engines;
	
	public GoogleCustomSearchEngineView(){}
	
	@PostConstruct
	void prepare()
	{ 
		list();
	}
	
	public void list()
	{ 
		engines =  googleCseEngineService.getEngines();
	}

	public List<GoogleCustomSearchEngine> getEngines() {
		return engines;
	}

	public void setEngines(List<GoogleCustomSearchEngine> engines) {
		this.engines = engines;
	}
}
