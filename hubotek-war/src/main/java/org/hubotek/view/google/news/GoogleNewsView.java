package org.hubotek.view.google.news;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hubotek.model.HubDocument;
import org.hubotek.service.google.news.GoogleNewsService;
import org.hubotek.view.BaseView;
import org.hubotek.view.View;

@ManagedBean(name="googleNewsView")
@RequestScoped
public class GoogleNewsView extends BaseView{

	@EJB
	GoogleNewsService googleNewsService;
	
	public GoogleNewsView(){}
	
	@PostConstruct
	public void prepare()
	{ 
	}
	
	
	public HubDocument searchNews(String news_topic)
	{   
		HubDocument hubDocument = null;
		switch(news_topic){ 
		case "w": 
			hubDocument = googleNewsService.processRequestWorld();
			break;
		}
		return hubDocument;
	}
	
	@Override
	public View get() {
		return this;
	}

}
