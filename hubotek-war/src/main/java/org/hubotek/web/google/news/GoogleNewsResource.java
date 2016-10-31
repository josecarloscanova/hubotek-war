package org.hubotek.web.google.news;

import java.io.IOException;
import java.io.OutputStream;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
//@PathParam("topic") String topic
	@GET
	@Path("/top")
	@Produces(MediaType.APPLICATION_XML)
	public StreamingOutput getNewsTopic()
	{ 
		return new StreamingOutput() {
			public void write(OutputStream outputStream)
					throws IOException, WebApplicationException {
				outputStream.write(googleNewsService.processRequestTop().getBytes());
			}
		};
	}
	
	@GET
	@Path("/tc")
	@Produces(MediaType.APPLICATION_XML)
	public StreamingOutput getNewsTcTopic()
	{ 
		return new StreamingOutput() {
			public void write(OutputStream outputStream)
					throws IOException, WebApplicationException {
				outputStream.write(googleNewsService.processRequest().getBytes());
			}
		};
	}
	
	@GET
	@Path("/w")
	@Produces(MediaType.APPLICATION_XML)
	public StreamingOutput getNewsWTopic()
	{ 
		return new StreamingOutput() {
			public void write(OutputStream outputStream)
					throws IOException, WebApplicationException {
				outputStream.write(googleNewsService.processRequestWorld().getBytes());
			}
		};
	}
	
	@GET
	@Path("/e")
	@Produces(MediaType.APPLICATION_XML)
	public StreamingOutput getNewsETopic()
	{ 
		return new StreamingOutput() {
			public void write(OutputStream outputStream)
					throws IOException, WebApplicationException {
				outputStream.write(googleNewsService.processRequestEntertainement().getBytes());
			}
		};
	}

	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_XML)
	public StreamingOutput searc(@QueryParam("s") String search)
	{ 
		return new StreamingOutput() {
			public void write(OutputStream outputStream)
					throws IOException, WebApplicationException {
				outputStream.write(googleNewsService.processRequestSearch(search).getBytes());
			}
		};
	}
}
