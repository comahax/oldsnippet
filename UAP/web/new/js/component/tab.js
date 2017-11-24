var component = component || {
	getObject: function(compname){
		var object = {};
		object[compname] = component[compname];
		return object
	}
}

//----------------
// 下拉列表组件 v1.0
//----------------
component.tab = function(){
	var config = arguments.length > 0 ? arguments[0] : null;
	var domEl = this[0];
	var _this = this;
			
	_this.config = {
		tabSelectedClass: config.tabSelectedClass == undefined ? "selected" : config.tabSelectedClass,
		contentSelectedClass: config.contentSelectedClass == undefined ? "selected" : config.contentSelectedClass,
		contentClass: config.contentClass == undefined ? "tab_content" : config.contentClass,
		moveable: config.moveable == undefined ? false : true
	}
	
	//当前活动tab的索引
	_this.active = 0;
	
	_this.headers = null;
	_this.contents = null;
	
	_this.onselect = function(e){}
	_this.onAddTab = function(lastIndex){}
	
	//方法:选择tab
	_this.select = function(i){
		
		if(_this.active !== i)
		{	//选中
			_this.headers[i].className = _this.headers[i].className + " " + _this.config.tabSelectedClass;
			_this.contents[i].className = _this.contents[i].className + " " + _this.config.contentSelectedClass;
			
			if(_this.headers.length > 1 && _this.headers[_this.active] != undefined){
				_this.headers[_this.active].className = _this.headers[_this.active].className.replace(new RegExp("\\b"+_this.config.tabSelectedClass+"\\b"), "");
				_this.contents[_this.active].className = _this.contents[_this.active].className.replace(new RegExp("\\b"+_this.config.contentSelectedClass+"\\b"), "");
				if(_this.headers[_this.active].className.substring(_this.headers[_this.active].className.length - 2) == " ")
					_this.headers[_this.active].className = _this.headers[_this.active].className.substring(0, _this.headers[_this.active].className.length - 2)
			}
			
			_this.active = i;
			
			_this.onselect(/*zhcode.event.get()*/)
		}
	}
	
	//增加tab
	//parms:
	//	config(object)
	//  [property]
	//	-- title ->
	//  -- src ->
	_this.addTab = function(cfg){
		//检查tab是否已经添加进来
		// -1表示未添加进来
		// 大于-1的任何整数值代表已存在tab的索引
		var index = _this.getTabIndex(cfg.title);
		if(index > -1){
			_this.select(index);
			return;	
		}
		
		var tabHeader = createTabHeader(), tabContent = createTabContent();
		
		//添加tab节点
		_this.headers[0].parentNode.appendChild(tabHeader[0]);
		_this.contents[0].parentNode.appendChild(tabContent[0]);

		//设置索引
		var lastIndex = _this.headers.length - 1;
		tabHeader.attr("index", lastIndex);
		_this.select(lastIndex);
	
		tabHeader.html(tabHeader.html().replace("{0}", cfg.title));
		if(config.fetchTabTitleElementHandle){
			var titleEl = config.fetchTabTitleElementHandle(_this.headers[lastIndex]);
			titleEl.innerHTML = cfg.title;
		}
		
		//初始化tab内容
		if(cfg.src == undefined){
			
		} else {
			var ifrm = document.createElement("iframe");
			if(cfg.width != undefined) ifrm.setAttribute("width", cfg.width);
			if(cfg.height != undefined) ifrm.setAttribute("height", cfg.height);
			ifrm.setAttribute("frameborder", "0");
			tabContent[0].appendChild(ifrm);
			//loading for url
			ifrm.setAttribute("src", cfg.src);
		}
		
		tabHeader.bind("click", function(){
			var iIndex = parseInt(this.getAttribute("index"));
			_this.select(iIndex);
		});
		
		//绑定关闭tab项的触发器
		if(config.fetchCloseTabTriggerHandle !== undefined
			&& typeof(config.fetchCloseTabTriggerHandle) == "function"){
			
			var closeTrigger = config.fetchCloseTabTriggerHandle(_this.headers[lastIndex]);
			closeTrigger.setAttribute("index", lastIndex);
			$(closeTrigger).bind("click", function(){
				var iIndex = parseInt(this.getAttribute("index"));
				if(_this.headers.length > 1)
					_this.closeTab(iIndex);
			});
		}
		
		this.onAddTab(lastIndex);
	}
	
	_this.closeTab = function(i){
	
		//note:tab被删除后会自动在headers和contents的dom数组清除
		_this.headers[i]
			.parentNode
			.removeChild(_this.headers[i]);
		
		_this.contents[i]
			.parentNode
			.removeChild(_this.contents[i]);

		//重建tab索引
		for(var s=i; s<_this.headers.length; s++){
			_this.headers[s].setAttribute("index", s);
			if(config.fetchCloseTabTriggerHandle !== undefined
			   	&& typeof(config.fetchCloseTabTriggerHandle) == "function"){
				var closeTrigger = config.fetchCloseTabTriggerHandle(_this.headers[s]);
				closeTrigger.setAttribute("index", s);
			}
		}
		
		if(_this.active == i){
			//_this.active--;
			//if(_this.active == 0) _this.active--;
			//if(_this.headers.length > 0)
			_this.select(i-1);
		} else if(_this.active > i){
			_this.active--;
			_this.select(_this.active);
		}
	}
	
	_this.getTabIndex = function(tabId){
		if(config.fetchTabTitleElementHandle){
			for(var i=0; i<_this.headers.length; i++)
				if(tabId == config.fetchTabTitleElementHandle(_this.headers[i]).innerHTML)
					return i;
			return -1;
		} else {
			//其它方法待定
		}
	}
	
	
	function clearWhiteSpaceNodes(nodelist){
		
		for(var i=0; i<nodelist.length; i++){
			
			if(nodelist[i].nodeType == 3){ //清除文本节点
				nodelist[i].parentNode.removeChild(nodelist[i]);
			}
			
			if(nodelist[i] == undefined) break;
		}
		
		return nodelist
	}
	
	function createTabHeader(){
		if(config.createHeaderHandle !== undefined){
			return config.createTabHeaderHandle();
		} else if(_this.headers.length > 0){

			var head = $(_this.headers[_this.active]).clone();
			head.removeClass(_this.config.tabSelectedClass);
			return head;
		}
	}
	
	function createTabContent(){
		if(config.createTabContentHandle !== undefined){
			return config.createTabContentHandle();
		} else if(_this.headers.length > 0){
			var content = $(_this.contents[_this.active]).clone();
			content.removeClass(_this.config.contentSelectedClass);
			content.html("");
			
			return content;
		}
	}
	
	function parseHTML(){
		
		clearWhiteSpaceNodes(domEl.childNodes);
		
		_this.headers = clearWhiteSpaceNodes(domEl.childNodes[0].childNodes);

		//tab内容区
		_this.contents = clearWhiteSpaceNodes(domEl.childNodes[1].childNodes);
		
	}
	
	function initAction(){
		
		for(var i=0; i<_this.headers.length; i++){
			
			if(_this.headers[i].className.indexOf(_this.config.tabSelectedClass) != -1){
				_this.active = i;
			}
			
			_this.headers[i].setAttribute("index", i);
		
			$(_this.headers[i]).bind("click", function(e){
				var iIndex = parseInt(this.getAttribute("index"));
				_this.select(iIndex);
				
			});
		}
	}
	
	parseHTML();
	initAction();
}