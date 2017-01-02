package org.hubotek.view.google.cse.rest;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hubotek.service.ejb.cse.GoogleCseEngineService;
import org.hubotek.view.cse.GoogleCustomSearchEngine;

@Path("/cse")
public class CseRestService {

	@EJB
	GoogleCseEngineService googleCseEngineService;
	
	
	public CseRestService() {
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void saveCseEngine(@FormParam("identification") String identification , @FormParam("description") String description , @FormParam("dateCreated") Date dateCreated){ 
		googleCseEngineService.saveEngine(new GoogleCustomSearchEngine(identification, description, dateCreated));
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<GoogleCustomSearchEngine> listCseEngines(){ 
		return googleCseEngineService.getEngines();
	}

}
