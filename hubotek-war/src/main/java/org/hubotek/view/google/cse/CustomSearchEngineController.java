package org.hubotek.view.google.cse;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hubotek.service.ejb.cse.GoogleCseEngineService;
import org.hubotek.view.cse.GoogleCustomSearchEngine;
import org.hubotek.web.Controller;

@Controller
@ManagedBean
@RequestScoped
public class CustomSearchEngineController {

	
	@EJB
	GoogleCseEngineService googleCseEngineService;
	
	@Inject @Named("googleCustomSearchEngine")
	GoogleCustomSearchEngine googleCustomSearchEngine;
	
	public CustomSearchEngineController(){}
	
	@PostConstruct
	public void prepare(){
	}

	public void update()
	{ 
		googleCseEngineService.saveEngine(googleCustomSearchEngine);
	}
	
	public void findEngine(String identification)
	{ 
		GoogleCustomSearchEngine result = googleCseEngineService.findByValue(identification);
		googleCustomSearchEngine.setIdentification(result.getIdentification());
		googleCustomSearchEngine.setDescription(result.getDescription());
		googleCustomSearchEngine.setDateCreated(result.getDateCreated());
		
//		return "google_cseengine_view";
	}
	
	public void delete()
	{ 
		googleCseEngineService.delete();
	}
	
	public String getIdentification() {
		return googleCustomSearchEngine.getIdentification();
	}

	public void setIdentification(String identification) {
		googleCustomSearchEngine.setIdentification(identification);
	}

	public String getDescription() {
		return googleCustomSearchEngine.getDescription();
	}

	public void setDescription(String description) {
		googleCustomSearchEngine.setDescription(description);
	}

	public Date getDateCreated() {
		return googleCustomSearchEngine.getDateCreated();
	}

	public void setDateCreated(Date dateCreated) {
		googleCustomSearchEngine.setDateCreated(dateCreated);
	}

}
