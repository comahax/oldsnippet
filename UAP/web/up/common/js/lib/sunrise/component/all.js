var sunrise = {};
sunrise.ui = {};

//tab
sunrise.ui.tab = function(config, domEl){
	/**
	 *	初始化属性
	 */
	var tabSelectedClass = 
			config.tabSelectedClass == undefined ? 
				"selected" : config.tabSelectedClass,
				
		contentSelectedClass = 
			config.contentSelectedClass == undefined ? 
				"selected" : config.contentSelectedClass,
		
		contentClass = 
			config.contentClass == undefined ? 
				"tab_content" : config.contentClass;
		
		config.moveable = 
			config.moveable == undefined ? false : true;
	
		
	function initAction(){
		
		for(var i=0; i<domEl.headers.length; i++){
			
			if(domEl.headers[i].className.indexOf(tabSelectedClass) != -1){
				domEl.active = i;
			}
			
			domEl.headers[i].setAttribute("index", i);
			$su(domEl.headers[i]).bindEvent("click", function(){
				var iIndex = parseInt(this.getAttribute("index"));
				domEl.select(iIndex);
			});
		}
	}
	
	//function: Parsing html structure that use to organize the component
	function parseHTML(){
		//tab标题
		domEl.headers = domEl.getElementsByTagName("ul")[0].childNodes;
		//tab内容区
		domEl.contents = (function(){
			var contents = [], contentRoot = domEl.childNodes[1];
			for(var i=0; i<contentRoot.childNodes.length; i++){
				if(contentRoot.childNodes[i].className.indexOf(contentClass) > -1)
					contents.push(contentRoot.childNodes[i]);
				$su(contentRoot.childNodes[i]);
			}
			return contents;
		})();
	}
	
	//当前活动tab的索引
	domEl.active = 0;
	
	//方法:选择tab
	domEl.select = function(i){
		//alert(this.contents[i].length);
		if(this.active !== i)
		{	//选中
			if(this.contents[i]){
				this.headers[i].addClass(tabSelectedClass);
				this.contents[i].addClass(contentSelectedClass);
				this.headers[this.active].removeClass(tabSelectedClass);
				this.contents[this.active].removeClass(contentSelectedClass);
				this.active = i;
			}
		}
	}
	//解析组件DOM结构
	parseHTML();
	//初始化动作
	initAction();
	
	/**
	 *	初始化控制tag移动的触发元素
	 */
	if(config.moveable){
		var firstIndex = 0;
		
		domEl.moveToLeftTrigger = config.movingTrigger.toLeft;
		domEl.moveToRightTrigger = config.movingTrigger.toRight;
		
		domEl.moveToLeftTrigger.onclick = function(){
			if(firstIndex < 0){
				var toIndex = -firstIndex-1;
				domEl.headers[toIndex].style.display = "";
				++firstIndex;
			}
		}
		
		domEl.moveToRightTrigger.onclick = function(){
			if(firstIndex <= 0){
				var toIndex = -firstIndex;
				domEl.headers[toIndex].style.display = "none";
				--firstIndex;
			}
		}
		
		domEl.tabsMoveTo = function(x){
			this.headers[0].style.marginLeft = x;
		}
	}

	return domEl;
}

//数据表格
sunrise.ui.grid = function(config, domEl){
	
	//domEl.header = null;
	//domEl.data = null;
		
		
	//private function: Parsing html structure that use to organize the component
	function parseHTML(){
		var grid_head = domEl.getElementsByTagName("div")[0],
			grid_data = domEl.getElementsByTagName("div")[1],
			headTable = grid_head.getElementsByTagName("table")[0],
			dataTable = grid_data.getElementsByTagName("table")[0];
			
		var dataRows = dataTable.getElementsByTagName("tr"),
			ths = headTable.getElementsByTagName("tr")[0].getElementsByTagName("td"),
			tds = dataRows[0].getElementsByTagName("td");
			
		var onRowHover = function(){
			//alert(this.getAttribute("index"));
			//domEl.onrowhover(this);
			
		}
		
		
		for(var i=0; i<dataRows.length; i++){
			$su(dataRows[i]);
			dataRows[i].setAttribute("index", i+1);
			dataRows[i].bindEvent("mouseover", onRowHover);
		}
		//headTable.style.left = "1px";
		
		grid_head.style.width = domEl.offsetWidth - 19 + "px";

		for(var i=0; i<ths.length; i++)
			tds[i].setAttribute("width", ths[i].offsetWidth);
			
		grid_data.onscroll = function(){
			/*
			var x = event.srcElement.scrollLeft;
			if(x===0){
				headTable.style.left = "1px";
			}else{
				headTable.style.left = "-"+ (x-1) + "px";
			}
			*/
			
			grid_head.scrollLeft = event.srcElement.scrollLeft;
		}
	}
	
	function initAction(){
		
	}
	
	parseHTML();
	
	return domEl;
}

sunrise.ui.hoverpanel = function(config, domEl){
	
	var hoverTrigger = null,
	
		triggerHoverClass = 
			config.triggerHoverClass == undefined ? 
				"trigger_hover" : config.triggerHoverClass,
				
		panelHoverClass = 
			config.triggerHoverClass == undefined ? 
				"panel_hover" : config.panelHoverClass,
				
		eventType = 
			config.triggerMethod == undefined ? "click" : config.triggerMethod,
			
		triggerDefaultHandle = function(){
			//domEl.style.display = "none";
			domEl.removeClass(panelHoverClass);
			this.removeClass(triggerHoverClass);
		},
		
		triggerHoverHandle = function(){
			//domEl.style.display = "block";
			domEl.addClass(panelHoverClass);
			this.addClass(triggerHoverClass);
		},
		
		panelDefaultHandle = function(){
			domEl.removeClass(panelHoverClass);
			hoverTrigger.removeClass(triggerHoverClass);
		},
		
		panelHoverHandle = function(){
			domEl.addClass(panelHoverClass);
			hoverTrigger.addClass(triggerHoverClass);
		}
						
	if(config.hoverTrigger == undefined){
		alert("ERROR: Incorrect config\n\nsettings: hoverTrigger is not define");
		return;
	}
	
	if(typeof config.hoverTrigger == "string"){
		hoverTrigger = $su(config.hoverTrigger);
	}
	else if(typeof config.hoverTrigger == "object"){
		hoverTrigger = config.hoverTrigger
	}
	
	//鼠标移到触发器上面时触发
	hoverTrigger.bindEvent("mouseover", triggerHoverHandle);
	
	//鼠标离开触发器时触发
	hoverTrigger.bindEvent("mouseout", triggerDefaultHandle);
	
	//鼠标离开panel时触发
	domEl.bindEvent("mouseout", panelDefaultHandle);
	
	//鼠标从hoverTrigger下移到panel的时候触发
	domEl.bindEvent("mouseover", panelHoverHandle);
}

sunrise.ui.switchpanel = function(config, domEl){
	var switchActions = {},
		next = 1,
		itemClass = 
			config.itemClass == undefined ? 
				"rollItem" : config.itemClass,
				
		switchType = 
			config.switchType == undefined ? 
				"normal" : config.switchType ;

	function parseHTML(){
		
		//解析子元素
		for(var i=0; i<domEl.childNodes.length; i++){
			if(domEl.childNodes[i].className.indexOf(itemClass) > -1){
				domEl.childNodes[i].setAttribute("index", i);
				domEl.items.push(domEl.childNodes[i]);
			}
			$su(domEl.childNodes[i]);
		}
	}
	
	function getNext(index){
		return index < domEl.items.length - 1 ? index + 1 : 0;
	}
	
	function doSwitch(){
		domEl.switchTo(next);
	}
	
	domEl.items = [];
	
	domEl.interval = 5000;
	
	domEl.active = 0;
	
	domEl.run = function(){
		//检查撤换类型
		if(switchActions[switchType] == undefined){
			alert("ERROR: Incorrect switchType\n\nid:"+ domEl.id);
			return;
		}
		setTimeout(doSwitch, this.interval);
	}

	//解析HTML结构
	parseHTML();
	
	domEl.switchTo = function(index){
		switchActions[switchType](domEl.items[domEl.active], domEl.items[index]);
		domEl.active = index;
		next = getNext(index);
	}

	domEl.setAction = function(type, fn){
		switchActions[type] = fn;
	}
	
	domEl.setAction("normal", function(fromElem, toElem){
		fromElem.style.display = "none";
		toElem.style.display = "";
	});
	
	domEl.setAction("rollup", function(fromElem, toElem){
		var switchSpeed = 5, rollCompleted = false;
		if(fromElem.style.top == "")
			fromElem.style.top = 0;

		toElem.style.top = 0;
	
		function rollup(){
			var fromUnitIdx = fromElem.style.top.indexOf("px"),
				toUnitIdx = toElem.style.top.indexOf("px"),
				nFromTop = fromUnitIdx > 0 ? parseInt(fromElem.style.top.substring(0, fromUnitIdx)) : parseInt(fromUnitIdx.style.top),
				nToTop = toUnitIdx > 0 ? parseInt(toElem.style.top.substring(0, toUnitIdx)) : parseInt(toElem.style.top);
				
			
			if(rollCompleted){ //一次滚动结束
				domEl.removeChild(fromElem);
				domEl.appendChild(fromElem);
				toElem.style.top = 0;
				fromElem.style.top = 0;
				setTimeout(doSwitch, domEl.interval);
			}
			else{
				
				fromElem.style.top = nFromTop - 10;
				nToTop = nToTop - 10;
				rollCompleted = nToTop <= -toElem.offsetHeight ? true : false;
				toElem.style.top = nToTop;
				setTimeout(rollup, switchSpeed);
			}
		}
		
		rollup();
	});
}

