//包定义
var zhcode = new (function(){
	//xhr异步请求
	this.ajax = null;
	//ui
	this.ui = null;
	//辅助工具集
	this.util = null;
	
	this.web = null;
	
	this.dom = null;
	
	//浏览器信息对象
	this.brower = {
		
		//类型常量
		IE:      1,
		FIREFOX: 2,
		CHROME:  3,
		OPERA:   4,
		SAFARI:  5,
		
		//浏览器类型
		type: 0
	};
	//构造浏览器信息
	(function(r){
		var ua = navigator.userAgent.toLowerCase();
        if (window.ActiveXObject)
			r.brower.type = r.brower.IE;
        else if(document.getBoxObjectFor)
			r.brower.type = r.brower.FIREFOX;
		else if(window.opera)
			r.brower.type = r.brower.OPERA;
        else if(window.MessageEvent && !document.getBoxObjectFor)
			r.brower.type = r.brower.CHROME;
        else if(window.openDatabase)
			r.brower.type = r.brower.SAFARI;
	})(this);
})
//事件处理包
zhcode.event = {
	bind : function(elem,type,fn){
		if(elem.attachEvent){
			var typeRef = "_" + type;
			if(!elem[typeRef]){
				elem[typeRef] = [];
			}
			for(var i in elem[typeRef]){
				if(elem[typeRef][i] == fn){
					return;
				}
			}
			elem[typeRef].push(fn);
			elem["on"+type] = function(){
				for(var i in this[typeRef]){
					this[typeRef][i].apply(this,arguments);
				}
			}	
		}else{
			elem.addEventListener(type,fn,false);
		}
	},
	
	//移除事件绑定
	remove : function(elem,type,fn){
		if(elem.detachEvent){
			if(elem["_"+type]){
				for(var i in elem["_"+type]){
					if(elem["_"+type][i] == fn){
						elem["_"+type].splice(i,1);
						break;
					}
				}
			}
		}else{
			elem.removeEventListener(type,fn,false);
		}
	}
}

zhcode.util = new (function(){
	
	this.parseNamespace = function(ns){
		ns = ns.split(".");
		function loadPackage(obj, i){
			if(i < ns.length){
				if(obj[ns[i]] !== undefined){
					return loadPackage(obj[ns[i]], i+1);
				}
				else{
					return null;
				}
			}
			else{
				return obj;
			}
		}
		return loadPackage(window, 0);
	}
})();

//dom
zhcode.dom = new (function(){
	var e = zhcode.event;
	this.getElement = function(o){
		var domEl = typeof(o) == "string" ? document.getElementById(o) : o;
		
		if(domEl){
			//add a css class
			domEl.addClass = function(className){
				if(this.className.indexOf(className) == -1)
					this.className = this.className.concat(" " + className);
				return this;
			}
			//remove a css class
			domEl.removeClass = function(className){
				this.className = this.className.replace(className, "");
				return this;
			}
			
			domEl.bindEvent = function(type,fn){
				e.bind(this, type, fn);
			}
			domEl.removeEvent = function(type,fn){
				e.remove(this, type, fn);
			}
		}
		
		return domEl;
	}
});