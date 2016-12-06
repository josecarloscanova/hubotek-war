package org.hubotek.web.google.search;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.ejb.EJB;
import javax.json.bind.spi.JsonbProvider;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;

import org.hubotek.model.google.search.SearchParameterTemplate;
import org.hubotek.service.google.search.GoogleSearchService;

@Path("google/search")
public class GoogleSearchResource {

	@EJB 
	GoogleSearchService googleSearchService; 
	
	/**
	 * @param search
	 * @return
	 */
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public StreamingOutput search(@QueryParam("s") String search ,
			@DefaultValue("json") @QueryParam("alt") String alt,
	        @DefaultValue("partner-pub-6996754678263425:6706236868") @QueryParam("cx") String cx,
	        @DefaultValue("us") @QueryParam("language") String language,           
	        @DefaultValue("off") @QueryParam("safe") String safe,
	        @DefaultValue("date") @QueryParam("sort") String sort)
	{ 
		SearchParameterTemplate spt = new SearchParameterTemplate();
		spt.setSearchTerms(URLEncoder.encode(search));
		spt.setAlt(alt);
		spt.setCx(cx);
		spt.setLanguage(language);
		spt.setSafe(safe);
		spt.setSort(sort);
		return new StreamingOutput() {
			public void write(OutputStream outputStream)
					throws IOException, WebApplicationException {
				outputStream.write(JsonbProvider.provider().create().build().toJson(googleSearchService.doSearch(spt)).getBytes());
				outputStream.flush();
			}
		};
	}
	
}
