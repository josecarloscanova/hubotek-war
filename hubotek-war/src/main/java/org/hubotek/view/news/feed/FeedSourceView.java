package org.hubotek.view.news.feed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hubotek.service.news.feed.Feed;
import org.hubotek.service.news.feed.FeedSourceService;
import org.hubotek.view.View;

/* Manages the feed sources*/
//TODO paginate the list.
@ManagedBean(name="feedSourceView")
@RequestScoped
public class FeedSourceView implements View{

	@Inject @Named(value="feedSourceService")
	private FeedSourceService feedSourceService;
	
	private List<Feed> feedSources;
	
	public FeedSourceView() {
	}

	@PostConstruct
	void init()
	{ 
		feedSources = feedSourceService.listFeedSources();
	}
	
	@Override
	public View get() {
		return this;
	}

	public List<Feed> getFeedSources() {
		return feedSources;
	}

	public void setFeedSources(List<Feed> feedSources) {
		this.feedSources = feedSources;
	}

	public void addNewFeed(Feed feed)
	{ 
		feedSourceService.addFeedSource(feed);
	}
	
	public void removeFeed(Feed feed)
	{ 
		feedSourceService.removeFeedSource(feed);
	}
	
	public void updateFeed(Feed feed)
	{ 
		feedSourceService.updateFeedSource(feed);
	}
	
}
