//-----------------------------------------------------------------------------------------------------
//           2011.10.09 测试版本 适合于所有页面的数据表格 ZHI
//           欢迎提交bug
//           sgrid 0.1
//-----------------------------------------------------------------------------------------------------

zhcode.ui.grid = function(config, domEl){
	
	//解析html结构;
	var grid_head = domEl.getElementsByTagName("div")[0],
		grid_data = domEl.getElementsByTagName("div")[1],
		headTable = grid_head.getElementsByTagName("table")[0],
		dataTable = grid_data.getElementsByTagName("table")[0];
		
	var ths = headTable.getElementsByTagName("tr")[0].getElementsByTagName("td"),
		tds = dataTable.getElementsByTagName("tr")[0].getElementsByTagName("td");
		
	headTable.style.left = "1px";
	
	grid_head.style.width = domEl.offsetWidth + "px";
	
	for(var i=0; i<ths.length; i++){
		/*
		var hWidth = parseInt(headTable.getAttribute("width")),
			a = ths[i], b = tds[i], w = ths[i].getAttribute("width");
		
		//百份比
		if(w.indexOf("%") === w.length-1){
			w = w.substr(0, w.length-1);
			w = (parseInt(w)/100) * hWidth;
		}
		*/
		tds[i].setAttribute("width", ths[i].offsetWidth);
	}

	grid_data.onscroll = function(){
		var x = event.srcElement.scrollLeft;	
		if(x===0){
			headTable.style.left = "1px";
		}else{
			headTable.style.left = "-"+ (x-1) + "px";
		}
	}
	
	return domEl;
}