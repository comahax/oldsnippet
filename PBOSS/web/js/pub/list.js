/*
 * public method for the page: list.jsp
 *
 * notice! the list.jsp must have global var :
 *      contextPath, formList,
 *      _orderby, _desc,
 *      _pageno, _pagesize, _rowcount
 */
 
function doReturn(cmdReturn) {
    formList.action = contextPath + cmdReturn;
    formList.submit();
}

function doReturnInFrame(cmdReturn) {
	var str = self.parent.location.toString();
    if(str.indexOf("frame.jsp")==-1){
        doReturn(cmdReturn)
    }else{
        self.parent.location=contextPath+cmdReturn;
    }
}

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
                	if(e.disabled == false){
                    	e.checked = event.srcElement.checked;
                    }
                }
            }
        } else {
            var e = sis;
            if (e.type == 'checkbox') {
            	if(e.disabled == false){
                	e.checked = event.srcElement.checked;
                }
            }
        }
    }
}

function checkOne(FO,BO,CO) {
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
                	if(e.disabled == false){
	                    TB++;
	                    if (e.checked)
	                        TO++;
	                }
                }
            }
            if (TO == TB){
                $("input[name='allbox']").each(function(){
            		$(this).attr("checked",true);
            	});
                }
            else{
                $("input[name='allbox']").each(function(){
            		$(this).attr("checked",false);
            	});
                }
        } else {
            var e = sis;
            if (e.type == 'checkbox') {
            	if(e.disabled == false){
	                $("input[name='allbox']").each(function(){
	            		$(this).attr("checked",e.checked);
	            	});
            	}
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

function doQuery(cmdQuery){
	resetPage();		
	if(cmdQuery != null && cmdQuery !="")
		formList.action = contextPath + cmdQuery;
	//	formList.submit();
		
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
     if (document.formList.onsubmit == null || document.formList.onsubmit()){
        document.formList.submit();
     }
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
        if (document.formList.onsubmit == null || document.formList.onsubmit()){
            document.formList.submit();
        }
    }
}

function firstPage() {
    if (isNaN(parseInt(document.getElementsByName('param._pageno')[0].value)) ||
        isNaN(parseInt(document.getElementsByName('param._pagesize')[0].value)) ||
        isNaN(parseInt(document.getElementsByName('_rowcount')[0].value))) {
        return;
    }

        document.getElementsByName('param._pageno')[0].value = 1;
        if (document.formList.onsubmit == null || document.formList.onsubmit()){
            document.formList.submit();
        }
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
		if (document.formList.onsubmit == null || document.formList.onsubmit()){
            document.formList.submit();
        }
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
        if (document.formList.onsubmit == null || document.formList.onsubmit()){
            document.formList.submit();
        }
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
        if (document.formList.onsubmit == null || document.formList.onsubmit()){
            document.formList.submit();
        }
 
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
        if (document.formList.onsubmit == null || document.formList.onsubmit()){
            document.formList.submit();
        }
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
        if (document.formList.onsubmit == null || document.formList.onsubmit()){
            document.formList.submit();
        }
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
        if (document.formList.onsubmit == null || document.formList.onsubmit()){
            document.formList.submit();
        }
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
        
 