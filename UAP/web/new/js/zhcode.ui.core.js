//定义UI包结构
zhcode.ui = {
	//factory method for creating component
	createComponent : function(cn, config, domRef){
		var	lastSplitIdx = cn.lastIndexOf("."),
			type = cn.substring(
					lastSplitIdx > 0 ? lastSplitIdx + 1 : lastSplitIdx,
					cn.length),
			ns = cn.substring(0, lastSplitIdx);

		if(lastSplitIdx > 0){
			var package = zhcode.util.parseNamespace(ns);
			if(package!=null&&package[type]!=undefined){
				return package[type](config, domRef);
			}
			else{
				alert("ERROR: Can not find " + cn + " namespace.\n\nDomElement: " + domRef.id );
			}
		}
		else{
			return this[type](config, domRef);
		}
	},
	
	Component : function(){
		var _initCompleted = false,
				_srcElement = null,
				context = null,
				_baseconfig =
				{
					id: config.id,
					resizable: config.resizable ? config.resizable : false,
					cssClass: config.cssClass ? config.cssClass : null
				},
				_initFailure = function(msg){
					alert(msg);
				};
				_buildContext = function(){};
				
			return {
				
			//解析HTML的DOM结构
			//返回值： 返回组件的根元素。
			//overwrite
			parseHTML : function(){
				//return zhcode.get(_baseconfig.id);
			},
			
			//分析config结构
			//成功返回true，不成功返回false
			analyzeConfig : function(){
				
			},
			//event - 完成组件渲染
			onRenderCompleted : function(e, c){},
			
			//event - 完成组件初始化
			onInitCompleted : function(e, c){},
			
			//构建组件
			//overwrite
			buildComponent : function(){},
			
			//初始化组件
			init : function(){},
			
			//渲染组件
			//overwrite
			render : function(){
				try{
					
					if(!this.analyzeConfig()){
						_initFailure("component error: failure to analyze config set.");
					}
					
					_srcElement = this.parseHTML();                //解析组件HTML结构
					context = _buildContext();                  //建立上下文
					this.init(context);                         //初始化组件
					_srcElement = this.buildComponent(_srcElement);   //为dom元素包装组件功能
					this.onInitCompleted(_srcElement.event, context);
				}
				catch(e){
					_srcElement = null;
					context = null;
					this.destory();
					_initFailure("component error: failure to construt.");
					return;
				}
			},
			
			//销毁组件
			destory : function(){}
			
		}
	}
}

//重写DOM类的getElement方法
var baseMethod = zhcode.dom.getElement;
zhcode.dom.getElement = function(id){
	var el = baseMethod(id);
	if(zhcode.ui !== undefined){
		el.component = function(type){
			var config = {};
			if(arguments.length == 1 || arguments[1] == undefined){
				config["domId"] = id;
			}
			else if(arguments.length == 2 || arguments[1] != undefined){
				//初始化配置属性
				config = arguments[1];
				config["domId"] = id;
			}
			return zhcode.ui.createComponent(type, config, this);
		}
	}
	return el;
};

window.$ = zhcode.dom.getElement;