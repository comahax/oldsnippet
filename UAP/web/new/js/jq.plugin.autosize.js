var plugin = {}

function parseCssInt(value){
	if(value=="auto"){
		value = 0;
	} else {
		unitPos = value.indexOf("px");
		value = unitPos > 0 ? parseInt(value.substring(0, unitPos)) : parseInt(value);
	}
	return value;
}

plugin.autosize = {
	autoHeight: function(){
		var relElements = arguments.length > 0 ? arguments[0] : [],
			relParent = arguments.length < 2 ? $(window) : $(arguments[1]),
			parentHeight = relParent.height(),
			fixedHeight = 0;
		
		for(var i=0; i<relElements.length; i++){
			var marginTop = relElements[i].css("marginTop"),
				marginBottom= relElements[i].css("marginBottom");
			
			marginTop = parseCssInt(marginTop);
			marginBottom = parseCssInt(marginBottom);
			fixedHeight = fixedHeight + relElements[i].height() + marginTop + marginBottom;
			
		}
		
		var selfMarginTop = this.css("marginTop"), selfMarginBottom = this.css("marginBottom");
		selfMarginTop = parseCssInt(selfMarginTop);
		selfMarginBottom = parseCssInt(selfMarginBottom);
		fixedHeight = fixedHeight + selfMarginTop + selfMarginBottom;
		
		if(parentHeight > fixedHeight)//窗口文档高度必须小于固定高度元素的总和
			this.height(parentHeight - fixedHeight);
	},
	
	autoWidth: function(){
		var relElements = null, relParent = null,
			parentWidth = -1, parentMinWidth = 0, fixedWidth = 0, minWidth = 0, unitPos = -1;
		
		
		//过滤参数
		if(arguments.length>0){
			
			if(arguments.length==1){
				if(typeof(arguments[0]) == "number"){ fixedWidth = arguments[0]; }
				else if(typeof(arguments[0]) == "object"){ relElements = arguments[0];}
			} else if(arguments.length>2){
				minWidth = arguments[1];
				relParent = arguments[2];
			} else if(typeof(arguments[1]) == "number") {
				minWidth = arguments[1];
			} else if(typeof(arguments[1]) == "object"){
				relParent = $(arguments[1]);
			}
		}
		
		if(relParent != null && relParent.document != undefined){
			parentMinWidth = $(relParent.document.body).css("minWidth");
			parentMinWidth = parseCssInt(parentMinWidth);
		}
		
		if(relElements != null){
			for(var i=0; i<relElements.length; i++){
				var marginLeft = relElements[i].css("marginLeft"),
					marginRight= relElements[i].css("marginRight");
				
				marginLeft = parseCssInt(marginLeft);
				marginRight = parseCssInt(marginRight);
				fixedWidth = fixedWidth + relElements[i].width() + marginLeft + marginRight;
			}
			
			var selfMarginLeft = this.css("marginLeft"), selfMarginRight = this.css("marginRight");
			var selfBorderLeft = this.css("borderLeftWidth"), selfBorderRight = this.css("borderRightWidth");
			
			selfMarginLeft = parseCssInt(selfMarginLeft);
			selfMarginRight = parseCssInt(selfMarginRight);
			
			if(selfBorderLeft == "medium") selfBorderLeft = 0
			else selfBorderLeft = parseCssInt(selfBorderLeft); 
			
			if(selfBorderRight == "medium") selfBorderRight = 0
			else selfBorderRight = parseCssInt(selfBorderRight);
			
			fixedWidth = fixedWidth + selfMarginLeft + selfMarginRight + selfBorderLeft + selfBorderRight;
			
		}
	
		
		
		if(relParent != null){
			
			parentWidth = $(relParent).width();
			if(parentWidth > parentMinWidth){
				
				this.width(parentWidth - fixedWidth);
			} else {
				this.width(parentMinWidth - fixedWidth);
			}
			
		} else {
			//alert(document.documentElement.offsetWidth + " : " + fixedWidth + " : " + this.width() );
			this.width(document.documentElement.offsetWidth - fixedWidth);
		}
		
		
	}
}
