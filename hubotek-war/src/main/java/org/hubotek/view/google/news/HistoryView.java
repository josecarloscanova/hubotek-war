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

@ManagedBean(name="historyView")
@RequestScoped
public class HistoryView implements View{

	@EJB
	SearchHistoryProvider searchHistoryProvider;
	
	List<HistoryDocument>  historyDocuments;
	
	List<HistoryDocumentItem> historyDocumentItems;
	
	private Long currentDocumentId;
	
	private Integer offSet;
	
	private Integer limit;
	
	public HistoryView(){}
	
	@PostConstruct
	public void prepare()
	{
		offSet = 0;
		limit = 0;
	}
	
	@Override
	public HistoryView get() {
		return this;
	}

	public List<HistoryDocument> getHistoryDocuments() {
		return searchHistoryProvider.findHistoryDocuments(offSet , limit);
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

	public Integer getOffSet() {
		return offSet;
	}

	public void setOffSet(Integer offSet) {
		this.offSet = offSet;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

}
