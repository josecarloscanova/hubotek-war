package org.hubotek.web.google.news;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.json.bind.spi.JsonbProvider;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;

import org.hubotek.service.ejb.SearchHistoryProvider;
import org.hubotek.view.search.history.HistoryDocument;
import org.hubotek.view.search.history.HistoryDocumentItem;

@Path("/news")
public class GoogleHistoryNewsResource {

	@EJB
	SearchHistoryProvider searchHistoryProvider;

	private Integer offSet;

	private Integer limit;


	@PostConstruct
	public void prepare()
	{
		offSet = 0;
		limit = 100;
	}

	public List<HistoryDocument> getHistoryDocuments() {
		return searchHistoryProvider.findHistoryDocuments(offSet , limit);
	}
	
	public List<HistoryDocumentItem> findHistoryDocumentItems(Long documentId)
	{ 
		return searchHistoryProvider.findItemByDocumentId(documentId);
	}
	
	@GET
	@Path("/history")
	@Produces(MediaType.APPLICATION_JSON)
	public StreamingOutput history()
	{
		return new StreamingOutput() {
			public void write(OutputStream outputStream)
					throws IOException, WebApplicationException {
				outputStream.write(JsonbProvider.provider().create().build().toJson(getHistoryDocuments()).getBytes());
				outputStream.flush();
			}
		};
	}
}
