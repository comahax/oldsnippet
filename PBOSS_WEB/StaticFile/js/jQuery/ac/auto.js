function cusAc($txt,$hid,optn){
	var allAlert = 0;//记录是否已经显示过出错信息
	var url = "/common/ajaxQuery.do";
	
	 //设置默认配置
	this._defaults = {
		minChars: 1,
        max: 20,
        type: 'POST',
		autoFill: false,
		mustMatch: true,//必须录入
		matchContains: true,
		cacheLength: 10,
		matchSubset: 1,
        dataType: 'json',	//处理类型
        extraParams: {ajaxPost:"1"},
        parse: function(data) {
			var parsed = [];
        	if (!data) return parsed;
			if (data.isSuccess==false){
				if (allAlert++<1){
					alert("Error:"+ data.message);
				}
				return parsed;
			}

        	for (var i = 0; i < data.length; i++) {
        		parsed[parsed.length] = {
        			data: data[i],
        			value: data[i].name,
        			result: data[i].name
        		};
        	}
        	return parsed;
        },
        formatItem: function(item,i, total) {
        	return item.name;
        }
	};
	var options  =  $.extend({}, this._defaults, optn);
	if (optn.type){
		options.extraParams = $.extend({}, options.extraParams, {type:optn.type});
	}

	$txt.autocomplete(url, options).result(function(event, item, formatted) {
		$hid.val(item.code);
	});
}