       
/* used for picker component , 2007-11 He Kun,Congxing */
function openPicker(control,definition,condition) {		
	    if(definition == null || definition =="") {	  	    			
	   		alert("definition is required!");
	   		return ;
	    }

	    definition = window.encodeURIComponent(definition);	    
	    var url = contextPath +"/common/picker_list.do?definition=" + definition + "&_pageno=1&_pagesize=15";	

	    if(condition!=null) {
	    	condition = window.encodeURIComponent(condition);
	    	url = url +"&condition=" + condition;
	    }
	    
	    url = url +"&" + new Date();

		var rtn = window.showModalDialog(url, control, "dialogWidth=425px;dialogHeight=560px;status:no;scroll=yes;");
		
		if( rtn == null) 
			return false;
			
		var buttonID = control.name;		
		if(buttonID == null || buttonID == "") {
			alert("Must set the name property for this selector business!");
			return false;
		} 
			
		var selectorID = buttonID.substring(0, buttonID.indexOf("_button"));
		var selectorTextID = selectorID + "_text";
		
		var codeCtrl = document.getElementById( selectorID );
		var nameCtrl = document.getElementById( selectorTextID ); 
		 
		if(codeCtrl!=null) codeCtrl.value = rtn[0];		
		if(nameCtrl!=null) nameCtrl.value = rtn[1];   		
	}
