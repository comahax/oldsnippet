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
        BO = "_selectitem";
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
        BO = "_selectitem";
    }
    if (CO == null) {
    	CO = FO + ".allbox";
    	}else{
    	CO = FO + "." + CO;
    	}

    var TB = TO = 0;
    var sis = eval(FO + "." + BO);
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
            if (TO == TB)
                eval(CO).checked = true;
            else
                eval(CO).checked = false;
        } else {
            var e = sis;
            if (e.type == 'checkbox') {
                eval(CO).checked = e.checked;
            }
        }
    }
}

function doNew(cmdNew) {
//    var url = addParam(contextPath + cmdNew, 'ISEDIT', 'TRUE');
    var url = addParam(contextPath + cmdNew, 'CMD', 'NEW');
    formList.action = url;
    formList.submit();
}

function doDelete(cmdDelete) {
    var TO = true;
    var sis = formList.all("_selectitem");
    if (forincheck(TO,sis,msgConfirmDelete)){
    	formList.action = addParam(contextPath + cmdDelete, 'CMD', 'DELETE');
    	formList.submit();
    	}  
}

function doOther(url,item) {
	var TO = true;
	if(item != null){		
		var sis = eval("document.formList." + item);
		TO = forincheck(TO,sis,msgConfirmDelete);
	}    
    if (TO){
    	formList.action = contextPath + url;
    	formList.submit();
    }         
}

function doQuery(){
	resetPage();
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
	
	if(msg.length>0){
    if (!confirm(msg)) {
        return false;
    }
    }
    return true;
}

function forincheck2(TO,sis){
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
    if (document.formList._orderby.value != field) { // asc
        document.formList._orderby.value = field;
        document.formList._desc.value = "";
    }
    else if (document.formList._desc.value == "") { // desc
        document.formList._desc.value = "1";
    } else { // don't order
        document.formList._orderby.value = "";
        document.formList._desc.value = "";
    }
    if(document.formList.onsubmit == null || document.formList.onsubmit())
    document.formList.submit();
}

function showFirstPage() {
    if (isNaN(parseInt(document.formList._pageno.value)) ||
        isNaN(parseInt(document.formList._pagesize.value)) ||
        isNaN(parseInt(document.formList._rowcount.value))) {
        return;
    }

    //  var pageNo = parseInt(document.formList._pageno.value);
    var pageCount = Math.ceil(parseInt(document.formList._rowcount.value) /
                              parseInt(document.formList._pagesize.value));

    if (pageCount > 1) {
        document.formList._pageno.value = 1;
        if (document.formList.onsubmit == null || document.formList.onsubmit())
            document.formList.submit();
    }
}

function firstPage() {
    if (isNaN(parseInt(document.formList._pageno.value)) ||
        isNaN(parseInt(document.formList._pagesize.value)) ||
        isNaN(parseInt(document.formList._rowcount.value))) {
        return;
    }

        document.formList._pageno.value = 1;
        if (document.formList.onsubmit == null || document.formList.onsubmit())
            document.formList.submit();
}

function showPreviousPage() {
    if (isNaN(parseInt(document.formList._pageno.value)) ||
        isNaN(parseInt(document.formList._pagesize.value)) ||
        isNaN(parseInt(document.formList._rowcount.value))) {
        return;
    }

    var pageNo = parseInt(document.formList._pageno.value);
    //  var pageCount = Math.ceil(parseInt(document.formList._rowcount.value) /
    //                            parseInt(document.formList._pagesize.value));

    if (pageNo > 1) {
        document.formList._pageno.value = pageNo - 1;
        if (document.formList.onsubmit == null || document.formList.onsubmit())
            document.formList.submit();
    }
}

function showNextPage() {
    if (isNaN(parseInt(document.formList._pageno.value)) ||
        isNaN(parseInt(document.formList._pagesize.value)) ||
        isNaN(parseInt(document.formList._rowcount.value))) {
        return;
    }

    var pageNo = parseInt(document.formList._pageno.value);
    var pageCount = Math.ceil(parseInt(document.formList._rowcount.value) /
                              parseInt(document.formList._pagesize.value));

    if (pageCount > 1 && pageCount > pageNo) {
        document.formList._pageno.value = pageNo + 1;
        if (document.formList.onsubmit == null || document.formList.onsubmit())
            document.formList.submit();
    }
}

function nextPage() {
    if (isNaN(parseInt(document.formList._pageno.value)) ||
        isNaN(parseInt(document.formList._pagesize.value)) ||
        isNaN(parseInt(document.formList._rowcount.value))) {
        return;
    }

    var pageNo = parseInt(document.formList._pageno.value);
        document.formList._pageno.value = pageNo + 1;
        if (document.formList.onsubmit == null || document.formList.onsubmit())
            document.formList.submit();
 
}
function goPage() {
    if (isNaN(parseInt(document.formList._pageno.value)) ||
        isNaN(parseInt(document.formList._pagesize.value)) ||
        isNaN(parseInt(document.formList._rowcount.value))) {
        return;
    }

	var pageGoal = parseInt(document.formList.goto_page.value);//目标页码
		
    var pageNo = parseInt(document.formList._pageno.value);
                       
        document.formList._pageno.value = pageGoal;
        if (document.formList.onsubmit == null || document.formList.onsubmit())
            document.formList.submit();
}
//分页跳转函数,跳转到指定页数
//author woden
function gotoPage() {
    if (isNaN(parseInt(document.formList._pageno.value)) ||
        isNaN(parseInt(document.formList._pagesize.value)) ||
        isNaN(parseInt(document.formList._rowcount.value))) {
        return;
    }

	var pageGoal = parseInt(document.formList.goto_page.value);//目标页码
		
    var pageNo = parseInt(document.formList._pageno.value);
    var pageCount = Math.ceil(parseInt(document.formList._rowcount.value) /
                              parseInt(document.formList._pagesize.value));
                       
	if(isNaN(pageGoal)||pageGoal>pageCount||pageGoal<1)
		pageGoal = 1;
	

    if (pageCount > 1) {
        document.formList._pageno.value = pageGoal;
        if (document.formList.onsubmit == null || document.formList.onsubmit())
            document.formList.submit();
    }
}

function showLastPage() {
    if (isNaN(parseInt(document.formList._pageno.value)) ||
        isNaN(parseInt(document.formList._pagesize.value)) ||
        isNaN(parseInt(document.formList._rowcount.value))) {
        return;
    }

    //  var pageNo = parseInt(document.formList._pageno.value);
    var pageCount = Math.ceil(parseInt(document.formList._rowcount.value) /
                              parseInt(document.formList._pagesize.value));

    if (pageCount > 0) {
        document.formList._pageno.value = pageCount;
        if (document.formList.onsubmit == null || document.formList.onsubmit())
            document.formList.submit();
    }
}

function resetPage() {
    document.formList._pageno.value = '1';
    if(document.formList._hispageno != undefined){
    	document.formList._hispageno.value = -1;
    }
}

function resetForm() {
    document.formList._orderby.value = '';
    document.formList._desc.value = '';
    document.formList._pageno.value = '1';
    if(document.formList._hispageno != undefined){
    	document.formList._hispageno.value = -1;
    }
}

//-- page for history DB data (start)---------------------------------

function firstPageHis() {
    if (isNaN(parseInt(document.formList._pageno.value)) ||
        isNaN(parseInt(document.formList._pagesize.value)) ||
        isNaN(parseInt(document.formList._rowcount.value))) {
        return;
    }

    document.formList._pageno.value = 1;
    document.formList._hispageno.value = -1;
    if (document.formList.onsubmit == null || document.formList.onsubmit())
        document.formList.submit();
}

function previousPageHis() {
    if (isNaN(parseInt(document.formList._pageno.value)) ||
        isNaN(parseInt(document.formList._pagesize.value)) ||
        isNaN(parseInt(document.formList._rowcount.value))) {
        return;
    }
	var hisPageNo = parseInt(document.formList._hispageno.value);
    var pageNo = parseInt(document.formList._pageno.value);
    if(hisPageNo>-1){
    	document.formList._hispageno.value = hisPageNo - 1;
    	if(hisPageNo==0){
    		document.formList._pageno.value = pageNo - 1;
    	}
    }else{
        document.formList._pageno.value = pageNo - 1;
    }
	if (document.formList.onsubmit == null || document.formList.onsubmit()){
        document.formList.submit();
    }
}

function nextPageHis() {
    if (isNaN(parseInt(document.formList._pageno.value)) ||
        isNaN(parseInt(document.formList._pagesize.value)) ||
        isNaN(parseInt(document.formList._rowcount.value))) {
        return;
    }
	var hisPageNo = parseInt(document.formList._hispageno.value);
    var pageNo = parseInt(document.formList._pageno.value);
    if(hisPageNo>-1){
    	document.formList._hispageno.value = hisPageNo + 1;
    }else{
        document.formList._pageno.value = pageNo + 1;
    }
	if (document.formList.onsubmit == null || document.formList.onsubmit()){
        document.formList.submit();
    }
 
}
//--page for history DB data (end)-----------------------------------


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
 //add by wangguangying for multi timesten db      
function ttprePage() {
    if (isNaN(parseInt(document.formList._pageno.value)) ||
        isNaN(parseInt(document.formList._pagesize.value)) ||
        isNaN(parseInt(document.formList._rowcount.value))) {
        return;
    }

    var pageNo = parseInt(document.formList._pageno.value);
    var totalpage = parseInt(document.formList._totalpage.value);
    
    if(document.formList._totalpage.value == 1){
    	document.formList._totalpage.value == 1;
    	document.formList._pageno.value = 1 ;
    }else{
    	document.formList._pageno.value = pageNo - 1;
        document.formList._totalpage.value  = totalpage - 1;
    }
        
        if (document.formList.onsubmit == null || document.formList.onsubmit())
            document.formList.submit();
}    

function ttnextPage() {
    if (isNaN(parseInt(document.formList._pageno.value)) ||
        isNaN(parseInt(document.formList._pagesize.value)) ||
        isNaN(parseInt(document.formList._rowcount.value))) {
        return;
    }

    var pageNo = parseInt(document.formList._pageno.value);
    var totalpage = parseInt(document.formList._totalpage.value);
        document.formList._pageno.value = pageNo + 1;
        document.formList._totalpage.value  = totalpage + 1;
        if (document.formList.onsubmit == null || document.formList.onsubmit())
            document.formList.submit();
 
}    