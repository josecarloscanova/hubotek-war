(function ($) {
	$.fn.hubotek_search_submit = function (opt) {
		var conf = $.extend({
			form:'hubotek_search',
			target_element:'search_result',
			MaxCount: 10,
			logConsole:false,
			search_target: "http://localhost:8080/hubotek-war/hub/google/news/search"
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
	          //$("#" + id).append('<ul class="feedEkList">' + s + '</ul>');
	            	}
	            });
		};
		
		var processDataFeed = function(data){ 
            $("#" + id).empty();
            var inc = 0;
            if (data.rssItems instanceof Array && data.rssItems.length > conf.MaxCount){
            	conf.rssData = data.rssItems.slice(conf.MaxCount-1);
            }
            $.each(conf.rssData, function (e, itm) {
            	inc++;
                s += '<div class="itemTitle"><a href="' + itm.link + '" target="new" >' + itm.title + '</a></div>';
                
                if (conf.ShowDesc) {
                    s += '<div class="itemContent">';
                     if (conf.DescCharacterLimit > 0 && itm.length > conf.DescCharacterLimit) {
                        s += itm.description.substring(0, conf.DescCharacterLimit) + '...';
                    }
                    else {
                        s += itm.description;
                     }
                     s += '</div>';
                }
            });
            $("#" + id).append('<div class="row">' + s + '</div>');
        };
        
        
	};
})(jQuery);