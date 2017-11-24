var sunrise = {};
sunrise.ui = {};

sunrise.ui.tab = function(config, domEl){
	
	/**
	 *	初始化属性
	 */
	var tabSelectedClass = 
			config.tabSelectedClass == undefined ? 
				"tag_selected" : config.tabSelectedClass,
	
	domEl.initAction = function(){
		for(var i=0; i<this.headers.length; i++){
					
			if(this.headers[i].className.indexOf("active") != -1){
				this.active = i;
			}
			
			this.headers[i].setAttribute("index", i);						
			this.headers[i].onselect = function(){
				var iIndex = parseInt(this.getAttribute("index"));
				tabRoot.select(iIndex);
			}
			
			bindEvent(this.headers[i], "mouseover", this.headers[i].onselect);
			
		}
	}
	//当前活动tab的索引
	domEl.active = 0;
	//tab标题
	domEl.headers = domEl.getElementsByTagName("ul")[0].getElementsByTagName("li");
	//tab内容区
	domEl.contents = (function(){
		var contents = [];
		for(var i=0; i<this.childNodes.length; i++){
			
			if(this.childNodes[i].className.indexOf("tag_content") != -1)
				contents.push(this.childNodes[i]);
		}
		return contents;
	})();
	//方法:选择tab
	domEl.select = function(i){
		if(this.active !== i)
		{	//选中
			this.headers[i].removeClass("thB");
			this.contents[i].style.display="";
			this.headers[this.active].addClass("thB");
			this.contents[this.active].style.display="none";
			this.active = i;
		}
	}
	
	/**
	 *	初始化控制tag移动的触发元素
	 */
	var movingTriggers = document.getElementById("mfbar").getElementsByTagName("a"),
		firstIndex = 0;
		
	domEl.posX = 0;
	domEl.headers = [];

	//过滤子节点，保证子节点是li元素
	var head = domEl.childNodes[0].childNodes[0];
	for(var i=0; i<head.childNodes.length; i++)
	{
		if(head.childNodes[i].tagName == "LI")
			domEl.headers.push(head.childNodes[i]);
	}
	
	if(config.moveable){
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
	}

	domEl.tabsMoveTo = function(x){
		this.headers[0].style.marginLeft = x;
	}
	
	
	return domEl;
}