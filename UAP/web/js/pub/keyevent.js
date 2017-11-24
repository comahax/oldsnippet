/*
 * 功能说明：本js脚本用于处理前台页面表单元素的键盘拦截事件，拦截元素包括 input, textarea, select 和 button 元素
 * 实现功能：拦截表单元素的回车事件，在文本框中完成输入内容后按回车键
 * 			1. 如果元素是提交按钮，回车按钮触发提交事件
 * 			2. 如果非提交按钮，则回车事件将光标焦点移向下一个表单元素
 * @author 罗志辉[luozhh],time 2011/03/24
 */

//进入页面时控制
$(document).ready(function(){
	//查找表单的 input, textarea, select 和 button 元素，
	var inputObj = $(":input");
	var inputFocus = false;
	inputObj.each(function(i){
		if(!inputFocus && $(this).attr("type") != "button"){
			$(this).focus();
			inputFocus = true;//进入页面鼠标焦点定位在第一个输入域中
		}
		//为这些表单元素添加tabindex属性，值从1递增
		$(this).attr({tabindex: i});
	});
	//注册keypress事件
	$(":input").bind("keypress",enterEvent);
});

function enterEvent(nsEvent){
	//屏蔽浏览器差异
	var event = nsEvent ? nsEvent : window.event;
	var ctrlKey = event.ctrlKey;//是否按下Ctrl键
	var keyCode = event.keyCode;
	
	if(ctrlKey && (keyCode==13 || keyCode == 10)){//Ctrl+Enter组件键
		var defaultSubmitFlag = false;
		var firstBtn = null;//临时记录第一个非[帮助]、[返回]按钮
		$(":input[type='button']").each(function(i){
			var classValue = $(this).attr("class");
			if(classValue.indexOf("defaultSubmit") != -1){
				defaultSubmitFlag = true;
				$(this).click();
				return;
			}
			if(!defaultSubmitFlag){
				var btnValue = $(this).attr("value");
				if(btnValue != "帮助" && btnValue != "返回"){
					firstBtn = $(this);
					defaultSubmitFlag = true;
				}
			}
		});
		if(defaultSubmitFlag){
			firstBtn.click();
		}
		return;
	}
	
	switch(keyCode){//Enter键
	case 13:
		var eleType = $(this).attr("type");
		if(eleType != null && eleType == "button"){
			$(this).click();
		}else{
			var tabindex = $(this).attr("tabindex");
			tabindex++;
			$(":input[tabindex="+tabindex+"]").focus();
		}
		return false;
	}
}