package org.hubotek.view.google.news;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hubotek.service.ejb.SearchHistoryProvider;
import org.hubotek.view.View;
import org.hubotek.view.search.history.HistoryDocument;
import org.hubotek.view.search.history.HistoryDocumentItem;

@SuppressWarnings("serial")
@ManagedBean(name="historyView")
@RequestScoped
public class HistoryView implements View<HistoryView>{

	@EJB
	SearchHistoryProvider searchHistoryProvider;
	
	List<HistoryDocument>  historyDocuments;
	
	List<HistoryDocumentItem> historyDocumentItems;
	
	private Long currentDocumentId;
	
	public HistoryView(){}
	
	@PostConstruct
	public void prepare()
	{
		historyDocuments = searchHistoryProvider.findHistoryDocuments();
	}
	
	@Override
	public HistoryView get() {
		return this;
	}

	public List<HistoryDocument> getHistoryDocuments() {
		return searchHistoryProvider.findHistoryDocuments();
	}

	public void processSomething()
	{ 
		System.out.println("something as executed");
	}

	public String findHistoryDocumentItems(Long documentId)
	{ 
		historyDocumentItems = searchHistoryProvider.findItemByDocumentId(documentId);
		return "history_documents_items";
	}
	
	public Long getCurrentDocumentId() {
		return currentDocumentId;
	}

	public void setCurrentDocumentId(Long currentDocumentId) {
		this.currentDocumentId = currentDocumentId;
	}

	public List<HistoryDocumentItem> getHistoryDocumentItems() {
		return historyDocumentItems;
	}

}
