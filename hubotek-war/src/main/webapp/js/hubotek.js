(function ($) {
	$.fn.hubotek_search_submit = function (opt) {
		var conf = $.extend({
			form:'hubotek_search',
			target_element:'search_result',
			MaxCount: 10,
			logConsole:false,
			search_target: "/hubotek/hub/google/news/search"
		}, opt);

		var id = $('#' + conf.target_element).attr("id"), i, s = "", dt;
        $("#" + conf.target_element).empty();
        
		$(this).click (function(event)
				{ 
					event.preventDefault();
					executeAjax();
				});
		
		var executeAjax = function()
		{ 
			$.ajax({
	            url: conf.search_target,
	            dataType: "json",
	            type: 'get',
	            data: $("#hubotek_search").serialize(),
	            success: function (data) {
	            	if (conf.logConsole){ console.log(data);}
	            	processDataFeed(data);	
	            	processFeedLinks();
	          //$("#" + id).append('<ul class="feedEkList">' + s + '</ul>');
	            	}
	            });
		};
		
		var processFeedLinks = function()
		{
			$('div.itemContent a').attr('target' , '_blank');
		};
		
		var processDataFeed = function(data){ 
            var inc = 0;
            if (data.rssItems instanceof Array && data.rssItems.length > 0){
            	conf.rssData = data.rssItems.length > conf.MaxCount?  data.rssItems.slice(conf.MaxCount-1):data.rssItems;
	            s = '';
            	$.each(conf.rssData, function (e, itm) {
	            	inc++;
	                s += '<div  class="itemTitle"><a href="' + itm.link + '" target="_blank" >' + itm.title + '</a></div>';
	                
	                if (conf.showPubDate){
	                    dt = new Date(itm.pubDate);
	                    s += '<div class="itemDate" style="text-align:center" >';
	                    s += itm.pubDate;
	                    s += '</div>';
	                }
	                
	                if (conf.showDesc) {
	                    s += '<div class="itemContent">';
	                     if (conf.DescCharacterLimit > 0 && itm.length > conf.DescCharacterLimit) {
	                        s += itm.rssItemDescription.description.substring(0, conf.DescCharacterLimit) + '...';
	                    }
	                    else {
	                        s += itm.rssItemDescription.description;
	                     }
	                     s += '</div>';
	                }
	            });
	            $("#search_result").empty().html('<div class="feedResult row" style="width:98%">' + s + '</div>');
            }else { 
            	$("#search_result").empty().html('<div class="feedResult row" style="width:98%">' + '<a href="#">NO RESULTS</a>' + '</div>');
            }
        };
	};
	
	
})(jQuery);