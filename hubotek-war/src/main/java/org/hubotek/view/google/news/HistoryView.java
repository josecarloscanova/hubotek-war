package org.hubotek.view.google.news;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hubotek.service.ejb.SearchHistoryProvider;
import org.hubotek.service.ejb.document.HubDocumentProvider;
import org.hubotek.view.View;
import org.hubotek.view.search.history.HistoryDocument;

@SuppressWarnings("serial")
@ManagedBean(name="searchBean")
@RequestScoped
public class HistoryView implements View<HistoryView>{

	@EJB
	SearchHistoryProvider searchHistoryProvider;
	
	List<HistoryDocument>  historyDocuments; 
	
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
		return historyDocuments;
	}

	public void setHistoryDocuments(List<HistoryDocument> historyDocuments) {
		this.historyDocuments = historyDocuments;
	}

}
