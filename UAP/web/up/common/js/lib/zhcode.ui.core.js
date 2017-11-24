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
	}
}

//重写DOM类的getElement方法
var baseMethod = zhcode.dom.getElement;
zhcode.dom.getElement = function(id){
	var el = baseMethod(id);
	if(zhcode.ui !== undefined){
		if(el){
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
	}
	return el;
};

window.$ = zhcode.dom.getElement;