package org.hubotek.view.google.news;

import java.util.Map;

import javax.annotation.PostConstruct;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hubotek.view.View;

@SuppressWarnings("serial")
@ManagedBean(name="searchBean")
@RequestScoped
public class SearchView implements View{

	Map<String,Object> applicationMap;
	
	private String beanName; 
	
	public SearchView(){}
	
	@PostConstruct
	private void prepare()
	{ 
		this.beanName = "Bean Name";
	}
	
	public String executeAction()
	{ 
		return "back_home";
	}
	
	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	
	public String jumpToResult()
	{ 
		return "result_page";
	}
	
	@Override
	public SearchView get() {
		return this;
	}
	
}
