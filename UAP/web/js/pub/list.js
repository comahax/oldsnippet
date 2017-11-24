/*
 * public method for the page: list.jsp
 *
 * notice! the list.jsp must have global var :
 *      contextPath, formList,
 *      _orderby, _desc,
 *      _pageno, _pagesize, _rowcount
 */
function checkAll(FO,BO,CO) {
    if (FO == null) {
        FO = "document.formList";
    }else{
    	FO = "document." + FO;
    }
    if (BO == null) {
        BO = "param._selectitem";
    }
    if (CO == null) {
    	CO = FO + ".allbox";
    	}else{
    	CO = FO + "." + CO;
    	}
    var sis = eval(FO).all(BO);
    
    if (sis != null) {
        if (sis.length != null) {
            for (var i = 0; i < sis.length; i++) {
                var e = sis[i];
                if (e.type == 'checkbox') {
                    e.checked = eval(CO).checked;
                    /*
                    if (e.checked)
                        hL(e);
                    else
                        dL(e);
                        */
                }
            }
        } else {
            var e = sis;
            if (e.type == 'checkbox') {
                e.checked = eval(CO).checked;
                /*
                if (e.checked)
                    hL(e);
                else
                    dL(e);
                    */
            }
        }
    }
}

function checkOne(FO,BO,CO) {
	/*
    if (CB.checked)
        hL(CB);
    else
        dL(CB);
     */
    if (FO == null) {
        FO = "document.formList";
    }else{
    	FO = "document." + FO;
    }
    if (BO == null) {
//        BO = "param._selectitem";
        BO = "getElementsByName('param._selectitem')";
    }
    if (CO == null) {
    	CO = FO + ".allbox";
    	}else{
    	CO = FO + "." + CO;
    	}

    var TB = TO = 0;
//    var sis = eval(FO + "." + BO);
    var sis = eval("document.getElementsByName('param._selectitem')");
    if (sis != null) {
        if (sis.length != null) {
            for (var i = 0; i < sis.length; i++) {
                var e = sis[i];
                if (e.type == 'checkbox') {
                    TB++;
                    if (e.checked)
                        TO++;
                }
            }
            if (TO == TB){
                eval(CO).checked = true;
                }
            else{
                eval(CO).checked = false;
                }
        } else {
            var e = sis;
            if (e.type == 'checkbox') {
                eval(CO).checked = e.checked;
            }
        }
    }
}

function doNew(cmdNew) {
//    var url = addParam(contextPath + cmdNew, 'CMD', 'NEW');
    var url = contextPath + cmdNew;
    formList.action = url;  
    formList.submit();
}

function doDelete(cmdDelete) {
    var TO = true;
    var sis = formList.all("param._selectitem");   
    if (forincheck(TO,sis,msgConfirmDelete)){    
    	formList.action = contextPath + cmdDelete;
    	formList.submit();    	
    
    } 
}

function doCancel(cmdCancel,msgConfirmCancle){
    var TO = true;
    var sis = formList.all("param._selectitem");   
    if (forincheck(TO,sis,msgConfirmCancle)){    
    	formList.action = contextPath + cmdCancel;
    	formList.submit();    	
    
    } 
}

function doQuery(cmdQuery){
	resetPage();		
	if(cmdQuery != null && cmdQuery !="")
		formList.action = contextPath + cmdQuery;
		
	if(document.formList.onsubmit == null || document.formList.onsubmit())
		document.formList.submit();
}
function doExcelOut(url) {
    if(ev_check()){
     	setExcelOutPage(url);	
     }        	
}

function forincheck(TO,sis,msg){
    if (sis != null) {
        if (sis.length != null) {
            for (var i = 0; i < sis.length; i++) {
                var e = sis[i];
                if (e.type == 'checkbox') {
                    if (e.checked)
                        TO = false;
                }
            }
        } else {
            var e = sis;
            if (e.type == 'checkbox') {
                if (e.checked)
                    TO = false;
            }
        }
    }

    if (TO) {
        alert(msgNoSelected);
        return false;
    }

    if (!confirm(msg)) {
        return false;
    }
    return true;
}

function forincheckByRadio(TO,sis,msg){
    if (sis != null) {
        if (sis.length != null) {
            for (var i = 0; i < sis.length; i++) {
                var e = sis[i];
                if (e.type == 'radio') {
                    if (e.checked)
                        TO = false;
                }
            }
        } else {
            var e = sis;
            if (e.type == 'radio') {
                if (e.checked)
                    TO = false;
            }
        }
    }

    if (TO) {
        alert(msgNoSelected);
        return false;
    }
	if (msg != null && msg != "") {
    	if (!confirm(msg)) {
        	return false;
    	}
    }
    return true;
}

function doOrderby(field) {   
    if (document.getElementsByName('param._orderby')[0].value != field) { // asc
        document.getElementsByName('param._orderby')[0].value = field;
        document.getElementsByName('param._desc')[0].value = "";
    }
    else if (document.getElementsByName('param._desc')[0].value == "") { // desc
        document.getElementsByName('param._desc')[0].value = "1";
    } else { // don't order
        document.getElementsByName('param._orderby')[0].value = "";
        document.getElementsByName('param._desc')[0].value = "";
    }
     if (document.formList.onsubmit == null || document.formList.onsubmit())
        document.formList.submit();
}

function showFirstPage() {
    if (isNaN(parseInt(document.getElementsByName('param._pageno')[0].value)) ||
        isNaN(parseInt(document.getElementsByName('param._pagesize')[0].value)) ||
        isNaN(parseInt(document.getElementsByName('_rowcount')[0].value))) {
        return;
    }

    //  var pageNo = parseInt(document.formList._pageno.value);
    var pageCount = Math.ceil(parseInt(document.getElementsByName('_rowcount')[0].value) /
                              parseInt(document.getElementsByName('param._pagesize')[0].value));

    if (pageCount > 1) {
        document.getElementsByName('param._pageno')[0].value = 1;
        if (document.formList.onsubmit == null || document.formList.onsubmit())
            document.formList.submit();
    }
}

function firstPage() {
    if (isNaN(parseInt(document.getElementsByName('param._pageno')[0].value)) ||
        isNaN(parseInt(document.getElementsByName('param._pagesize')[0].value)) ||
        isNaN(parseInt(document.getElementsByName('_rowcount')[0].value))) {
        return;
    }

        document.getElementsByName('param._pageno')[0].value = 1;
        if (document.formList.onsubmit == null || document.formList.onsubmit())
            document.formList.submit();
}

function showPreviousPage() {
    if (isNaN(parseInt(document.getElementsByName('param._pageno')[0].value)) ||
        isNaN(parseInt(document.getElementsByName('param._pagesize')[0].value)) ||
        isNaN(parseInt(document.getElementsByName('_rowcount')[0].value))) {
        return;
    }

    var pageNo = parseInt(document.getElementsByName('param._pageno')[0].value);
    //  var pageCount = Math.ceil(parseInt(document.formList._rowcount.value) /
    //                            parseInt(document.formList._pagesize.value));

    if (pageNo > 1) {
        document.getElementsByName('param._pageno')[0].value = pageNo - 1;
        if (document.formList.onsubmit == null || document.formList.onsubmit())
            document.formList.submit();
    }
}

function showNextPage() {
    if (isNaN(parseInt(document.getElementsByName('param._pageno')[0].value)) ||
        isNaN(parseInt(document.getElementsByName('param._pagesize')[0].value)) ||
        isNaN(parseInt(document.getElementsByName('_rowcount')[0].value))) {
        return;
    }

    var pageNo = parseInt(document.getElementsByName('param._pageno')[0].value);
    var pageCount = Math.ceil(parseInt(document.getElementsByName('_rowcount')[0].value) /
                              parseInt(document.getElementsByName('param._pagesize')[0].value));

    if (pageCount > 1 && pageCount > pageNo) {
        document.getElementsByName('param._pageno')[0].value = pageNo + 1;
        if (document.formList.onsubmit == null || document.formList.onsubmit())
            document.formList.submit();
    }
}

function nextPage() {
    if (isNaN(parseInt(document.getElementsByName('param._pageno')[0].value)) ||
        isNaN(parseInt(document.getElementsByName('param._pagesize')[0].value)) ||
        isNaN(parseInt(document.getElementsByName('_rowcount')[0].value))) {
        return;
    }

    var pageNo = parseInt(document.getElementsByName('param._pageno')[0].value);
        document.getElementsByName('param._pageno')[0].value = pageNo + 1;
        if (document.formList.onsubmit == null || document.formList.onsubmit())
            document.formList.submit();
 
}
function goPage() {
    if (isNaN(parseInt(document.getElementsByName('param._pageno')[0].value)) ||
        isNaN(parseInt(document.getElementsByName('param._pagesize')[0].value)) ||
        isNaN(parseInt(document.getElementsByName('_rowcount')[0].value))) {
        return;
    }

	var pageGoal = parseInt(document.getElementsByName('param.goto_page')[0].value);//Ŀ��ҳ��
		
    var pageNo = parseInt(document.getElementsByName('param._pageno')[0].value);
                       
        document.getElementsByName('param._pageno')[0].value = pageGoal;
        if (document.formList.onsubmit == null || document.formList.onsubmit())
            document.formList.submit();
}
//��ҳ��ת����,��ת��ָ��ҳ��
//author woden
function gotoPage() {
    if (isNaN(parseInt(document.getElementsByName('param._pageno')[0].value)) ||
        isNaN(parseInt(document.getElementsByName('param._pagesize')[0].value)) ||
        isNaN(parseInt(document.getElementsByName('_rowcount')[0].value))) {
        return;
    }

	var pageGoal = parseInt(document.getElementsByName('param.goto_page')[0].value);//Ŀ��ҳ��
		
    var pageNo = parseInt(document.getElementsByName('param._pageno')[0].value);
    var pageCount = Math.ceil(parseInt(document.getElementsByName('_rowcount')[0].value) /
                              parseInt(document.getElementsByName('param._pagesize')[0].value));
                       
	if(isNaN(pageGoal)||pageGoal>pageCount||pageGoal<1)
		pageGoal = 1;
	

    if (pageCount > 1) {
        document.getElementsByName('param._pageno')[0].value = pageGoal;
        if (document.formList.onsubmit == null || document.formList.onsubmit())
            document.formList.submit();
    }
}

function showLastPage() {
    if (isNaN(parseInt(document.getElementsByName('param._pageno')[0].value)) ||
        isNaN(parseInt(document.getElementsByName('param._pagesize')[0].value)) ||
        isNaN(parseInt(document.getElementsByName('_rowcount')[0].value))) {
        return;
    }

    //  var pageNo = parseInt(document.formList._pageno.value);
    var pageCount = Math.ceil(parseInt(document.getElementsByName('_rowcount')[0].value) /
                              parseInt(document.getElementsByName('param._pagesize')[0].value));

    if (pageCount > 0) {
        document.getElementsByName('param._pageno')[0].value = pageCount;
        if (document.formList.onsubmit == null || document.formList.onsubmit())
            document.formList.submit();
    }
}

function resetPage() {
    document.getElementsByName('param._pageno')[0].value = '1';
}

function resetForm() {
    document.getElementsByName('param._orderby')[0].value = '';
    document.getElementsByName('param._desc')[0].value = '';
    document.getElementsByName('param._pageno')[0].value = '1';
}

var ie = document.all ? 1 : 0;

function hL(E){
  if (ie) {
    while (E.tagName!="TR")
      E=E.parentElement;
  } else {
    while (E.tagName!="TR")
      E=E.parentNode;
  }
}

function dL(E){
  if (ie) {
    while (E.tagName!="TR")
      E=E.parentElement;
  } else {
    while (E.tagName!="TR")
      E=E.parentNode;
  }
}
function toallcheck(str2,str3) {
       	if (eval("document.all."+ str2+".length") != null) {
       		for (var n = 0 ; n < eval("document.all."+ str2+".length") ; n++) {
        		if(!(eval("document.all."+ str2+"[n].checked"))) {return}
        	}
       	}else{
       		if(!(eval("document.all."+ str2+".checked"))) {return}
       	}
        	eval("document.all."+ str3+".checked = true")
        }
        
function openPicker(control,definition) {	
        openPicker(control,definition,null)
}
/* used for picker component , 2007-11 He Kun */
/* modify , 2009-01-19 ymf */
function openPicker(control,definition,condition) {		
	    if(definition == null || definition =="") {	  	    			
	   		alert("definition is required!");
	   		return ;
	    }
	    definition = window.encodeURIComponent(definition);
	    var url = contextPath +"/common/picker_list.do?definition=" + definition + "&_pageno=1&_pagesize=15";	
	    if(condition != null && condition !="") {	 
	        condition = window.encodeURIComponent(condition);
	        url = url + "&condition=" + condition;
	    }
		var rtn = window.showModalDialog(url, control, "dialogWidth=550px;dialogHeight=440px;status:no;scroll=yes;");
		
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
		 
		if(codeCtrl!=null) codeCtrl.value = rtn[0];		
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
		strUrl += "&condition=" + condition;
	}
	if(code!=null || code!=""){
		code = window.encodeURIComponent(code);
		strUrl += "&code=" + code;
	}
	
	strUrl = strUrl +"&" + new Date();
	var arg = new Array();
	//ShowModalDialog   showModalDialog
	var hWnd = window.showModalDialog(strUrl, arg, "dialogWidth:550px; dialogHeight:500px; status:no;resizable:no;");
	//var hWnd = window.open(strUrl, '', "width=550px,height=500,left=200,status:no,resizable:no;");
	if (hWnd != null) {
		if (hWnd[0] == "" && hWnd[0] == "") {
			eval("document.all('" + property + "').value =\"\" ");
			eval("document.all('" + property + "_text').value =\"\" ");
		} else {
			//alert(hWnd[0] + ","+ hWnd[1]);
			eval("document.all('" + property + "').value = hWnd[0]");
			eval("document.all('" + property + "_text').value = hWnd[1]");
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
 