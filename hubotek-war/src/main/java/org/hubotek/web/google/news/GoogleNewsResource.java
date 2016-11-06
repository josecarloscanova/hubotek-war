package org.hubotek.web.google.news;

import java.io.IOException;
import java.io.OutputStream;

import javax.ejb.EJB;
import javax.json.bind.spi.JsonbProvider;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;

import org.hubotek.service.google.news.GoogleNewsService;

@Path("google/news")
public class GoogleNewsResource {

	@EJB 
	GoogleNewsService googleNewsService; 
	
	@GET
	@Path("/top")
	@Produces(MediaType.APPLICATION_JSON)
	public StreamingOutput newsTop()
	{ 
		return new StreamingOutput() {
			public void write(OutputStream outputStream)
					throws IOException, WebApplicationException {
				outputStream.write(JsonbProvider.provider().create().build().toJson(googleNewsService.processRequestTop()).getBytes());
				outputStream.flush();
			}
		};
	}
	
	@GET
	@Path("/tc")
	@Produces(MediaType.APPLICATION_JSON)
	public StreamingOutput newsTcTopic()
	{ 
		return new StreamingOutput() {
			public void write(OutputStream outputStream)
					throws IOException, WebApplicationException {
				outputStream.write(JsonbProvider.provider().create().build().toJson(googleNewsService.processRequest()).getBytes());
				outputStream.flush();
			}
		};
	}
	

	@GET
	@Path("/n")
	@Produces(MediaType.APPLICATION_JSON)
	public StreamingOutput newsCountryTopic()
	{ 
		return new StreamingOutput() {
			public void write(OutputStream outputStream)
					throws IOException, WebApplicationException {
				outputStream.write(JsonbProvider.provider().create().build().toJson(googleNewsService.processRequestCountry()).getBytes());
				outputStream.flush();
			}
		};
	}
	
	@GET
	@Path("/m")
	@Produces(MediaType.APPLICATION_JSON)
	public StreamingOutput newsHealthTopic()
	{ 
		return new StreamingOutput() {
			public void write(OutputStream outputStream)
					throws IOException, WebApplicationException {
				outputStream.write(JsonbProvider.provider().create().build().toJson(googleNewsService.processRequestHealth()).getBytes());
				outputStream.flush();
			}
		};
	}

	@GET
	@Path("/s")
	@Produces(MediaType.APPLICATION_JSON)
	public StreamingOutput newsSportsTopic()
	{ 
		return new StreamingOutput() {
			public void write(OutputStream outputStream)
					throws IOException, WebApplicationException {
				outputStream.write(JsonbProvider.provider().create().build().toJson(googleNewsService.processRequestSports()).getBytes());
				outputStream.flush();
			}
		};
	}
	
	@GET
	@Path("/w")
	@Produces(MediaType.APPLICATION_JSON)
	public StreamingOutput newsWTopic()
	{ 
		return new StreamingOutput() {
			public void write(OutputStream outputStream)
					throws IOException, WebApplicationException {
				outputStream.write(JsonbProvider.provider().create().build().toJson(googleNewsService.processRequestWorld()).getBytes());
				outputStream.flush();
			}
		};
	}
	
	@GET
	@Path("/e")
	@Produces(MediaType.APPLICATION_JSON)
	public StreamingOutput newsEntertaimentTopic()
	{ 
		return new StreamingOutput() {
			public void write(OutputStream outputStream)
					throws IOException, WebApplicationException {
				outputStream.write(JsonbProvider.provider().create().build().toJson(googleNewsService.processRequestEntertainement()).getBytes());
			}
		};
	}

	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	public StreamingOutput search(@QueryParam("s") String search)
	{ 
		return new StreamingOutput() {
			public void write(OutputStream outputStream)
					throws IOException, WebApplicationException {
				outputStream.write(JsonbProvider.provider().create().build().toJson(googleNewsService.processRequestSearch(search)).getBytes());
				outputStream.flush();
			}
		};
	}
	
}
