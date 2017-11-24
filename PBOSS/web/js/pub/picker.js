       
/* used for picker component , 2007-11 He Kun,Congxing */
function openPicker(control,definition,condition,sqlName,mapParam) {		
	    if(definition == null || definition =="") {	  	    			
	   		alert("definition is required!");
	   		return ;
	    }

	    definition = window.encodeURIComponent(definition);	    
	    var url = contextPath +"/common/picker_list.do?definition=" + definition;	

	    if(condition!=null) {
	    	condition = window.encodeURIComponent(condition);
	    	url = url +"&condition=" + condition;
	    }
	    
	    url = url +"&" + new Date();

	    if(sqlName != null && sqlName != ''){
	    	url = url+"&sqlName="+sqlName;
	    	if(mapParam != null && mapParam != ''){
	    		url = url +"&mapParam="+mapParam;
	    	}
	    }
		var rtn = window.showModalDialog(url, control, "dialogWidth:750px; dialogHeight:550px; status:no;resizable:no;");
		
		if( rtn == null) 
			return false;
			
		var buttonID = control.name;		
		if(buttonID == null || buttonID == "") {
			alert("Must set the name property for this selector control!");
			return false;
		} 
			
		var selectorID = buttonID.substring(0, buttonID.indexOf("_button"));
		var selectorTextID = selectorID + "_text";
		
		var codeCtrl = document.getElementById( selectorID );
		var nameCtrl = document.getElementById( selectorTextID ); 
		 
		if(codeCtrl!=null) {
			codeCtrl.value = rtn[0];
			//codeCtrl.focus();
		}
		if(nameCtrl!=null) nameCtrl.value = rtn[1];   		
	}

/* used for morecheck component , 2009-11 Linli,Congxing */
function getMoreCheck(definition, condition, property) {
	var property_button = property + "_button";
	var code = eval("document.all('" + property + "').value");
	
	definition = window.encodeURIComponent(definition);
	var strUrl = contextPath + "/common/morecheck_list.do?definition=" + definition;
	
	if(condition!=null) {
		condition = window.encodeURIComponent(condition);
		strUrl += "&condition=" + condition
	}
	if(code!=null || code!=""){
		code = window.encodeURIComponent(code);
		strUrl += "&code=" + code;
	}
	
	strUrl = strUrl +"&" + new Date();
	var arg = new Array();
	var hWnd = window.showModalDialog(strUrl, arg, "dialogWidth:550px; dialogHeight:500px; status:no;resizable:no;");
	if (hWnd != null) {
		if (hWnd == "") {
			eval("document.all('" + property + "').value =\"\" ");
			//eval("document.all('" + property_button + "').value =\"\" ");
		} else {
			var codeAndName = hWnd.split("|");
			eval("document.all('" + property + "').value = codeAndName[0]");
			//eval("document.all('" + property_button + "').value = codeAndName[1]");
		}
	}
}	



/* used for multicheckbox component , 2009-11 Linli,Congxing */
function isMultiSelectAll(targetName,targetID){
	var selectAll = document.all('selectAll'+targetID);
	if(selectAll != null){
		var array = document.getElementsByName(targetName);
		var flag = true;
		for(var i = 0;i<array.length;i++){
	    	if(!array[i].checked){
	    		flag = false;
	    		break;
	    	}
	    }
	    selectAll.checked = flag;
	}
}
function multiSelectAll(control,targetName){
 	if(control.type == 'checkbox'){
 		var array = document.getElementsByName(targetName);
	  	for(var i = 0;i<array.length;i++){
	  		if(array[i].type == 'checkbox')
	  			array[i].checked = control.checked;
	  	}
 	}
}
