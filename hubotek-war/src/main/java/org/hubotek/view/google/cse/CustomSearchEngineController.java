package org.hubotek.view.google.cse;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hubotek.service.ejb.cse.GoogleCseKeyService;
import org.hubotek.view.cse.GoogleCustomSearchEngineKey;
import org.hubotek.web.Controller;

@Controller
@ManagedBean
@RequestScoped
public class CustomSearchEngineController {
	
	@EJB
	GoogleCseKeyService googleCseKeyService;
	
	@Inject @Named("googleCustomSearchEngineKey")
	GoogleCustomSearchEngineKey googleCustomSearchEngineKey;
	
	private Boolean isListing;
	
	private List<?> googleCustomSearchKeys;
	
	public CustomSearchEngineController() {
		super();
	}
	
	@PostConstruct
	public void prepare(){
		isListing = false;
	}
	
	public void list()
	{ 
		googleCustomSearchKeys = googleCseKeyService.getKeys();
		isListing = true;
	}
	
	public void update()
	{ 
		googleCseKeyService.saveKey(googleCustomSearchEngineKey);
		clear();
	}
	
	public void updateAndList()
	{ 
		update();
		list();
	}
	
	public void delete()
	{ 
		googleCseKeyService.delete();
	}

	public List<?> getGoogleCustomSearchKeys() {
		return googleCustomSearchKeys;
	}

	public void setKey(String key) {
		googleCustomSearchEngineKey.setKey(key);
	}

	public void setDateCreated(Date dateCreated) {
		googleCustomSearchEngineKey.setDateCreated(dateCreated);
	}

	public String getKey() {
		return googleCustomSearchEngineKey.getKey();
	}

	public Date getDateCreated() {
		return googleCustomSearchEngineKey.getDateCreated();
	}

	public Boolean getIsListing() {
		return isListing;
	}

	public void setIsListing(Boolean isListing) {
		this.isListing = isListing;
	}

	void clear(){
		googleCustomSearchEngineKey.setDateCreated(null);
		googleCustomSearchEngineKey.setKey(null);
	}
	
}
