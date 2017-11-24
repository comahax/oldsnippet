var rtn;//the retun value of the window of comidtree.jsp
var elName ="";	
var codeValue ="";
var codeName="";
var _disabled;
var _onchange;
var _nQuerypage;
//set the value of atrribute 'innerHTML' for the specificied html element
//add by cwl
function setInnerHTML(el, htmlCode) {
		    var ua = navigator.userAgent.toLowerCase();
		    if (ua.indexOf('msie') >= 0 && ua.indexOf('opera') < 0) {
		        htmlCode = '<div style="display:none">for IE</div>' + htmlCode;
		        htmlCode = htmlCode.replace(/<script([^>]*)>/gi,
		                                    '<script$1 defer="true">');
		        el.innerHTML = "";
		        el.innerHTML = htmlCode;
		        el.removeChild(el.firstChild);
		    }
		    else {
		        var el_next = el.nextSibling;
		        var el_parent = el.parentNode;
		        el_parent.removeChild(el);
		        el.innerHTML = htmlCode;
		        if (el_next) {
		            el_parent.insertBefore(el, el_next);
		        } else {
		            el_parent.appendChild(el);
		        }
		    }
	  }
	  
	//get The comidtree
	function showSelectComid(control) {    
	  var url = contextPath + "/resmanage/com/selectcomidtree.jsp";
	  rtn = window.showModalDialog(url , "" , 'dialogWidth=405px;dialogHeight=430px;status:no;scroll=yes;');     
	  if (rtn != null && rtn.length){
			document.all(elName).value = rtn[0];
			document.all("show_elem").value = rtn[0]+"  "+rtn[1];
			if (document.all("show_elem").onchange != null && codeValue != rtn[0]){
				codeValue = rtn[0];
				document.all("show_elem").fireEvent("onchange");
			}
		}
	}
	
	
	
	 function createHtmlcode(){	  	
	 	//alert("begin creating htmlcode");
	  	var ht = '<input type="hidden" name=\"'+elName+'\"></input><input type="text" class="form_input_1x" name="show_elem" onclick="showSelectComid(this);" readonly="true"></input>';
	  	if(_nQuerypage == true){
	  		ht +="<font color=red>&nbsp;*</font>";
	  	}
	  	ht += '<script language="JavaScript" type="text/JavaScript">'+'setElem();'+'</'+'script>';
	  	setInnerHTML( document.getElementById("selectcomid"),ht);
	  	//alert("the setted html code is:\n"+document.getElementById("selectcomid").innerHTML);
	}
	
	function setElem(){
		document.all(elName).value = codeValue;
		document.all("show_elem").value = codeValue + "  " + codeName;
		document.all("show_elem").disabled=_disabled;
		document.all("show_elem").onchange = _onchange;
	}
	
	function initParams(comidName,name,nQuerypage){
		_nQuerypage = nQuerypage;
		codeName = name;
		elName = comidName;
		codeValue = document.all(comidName).value;
		_disabled = document.all(comidName).disabled;
		_onchange = document.all(comidName).onchange;	
		//alert("属性名:"+comidName+"\ncode 值:"+codeValue+"\n翻译值:"+name);
		createHtmlcode();
	}
	
	
	function doMyReturn(cmdReturn){
		var url = contextPath + cmdReturn;
		window.location = url;
	}
	
	
var jumpstr = true;
   function closeIt(){
   		if (jumpstr) {
	   		if (document.all("Button6").disabled == true || document.all("Button7").disabled == true){
			}else {
					event.returnValue = "请确认数据是否已提交!";
			}
			jumpstr = false;
   		}
   }
   
//***************
//查询导出
//*****************
 function setResExcelOutPage(fileType,formName,resName) {
	var arg = new Array();
	var args = new Array();
   	var form = document.forms[0];
	var elements = form.elements;
	for (var i = 0;i < elements.length;i++){
		var pClassName = elements[i].parentNode.className;
		if(pClassName.indexOf("form_table") != -1){
			if (elements[i].type == "text" || elements[i].type == "hidden" 
				|| elements[i].nodeName.toUpperCase() == "SELECT" || (elements[i].type == "checkbox" && elements[i].checked)){
	   			if (trim(elements[i].value) != ""){
	   				arg.push(elements[i].name+"="+elements[i].value);
	   			} 			
   			}	
		}  		    		
	}
	args.push(arg);
	args.push(fileType);
	var actionUrl = formList.action;
	var setPageUrl = contextPath + "/resmanage/common/selectpage.jsp";
	if (formName && formName != '')
		setPageUrl += "?formName="+formName;
	if (resName){
		if (formName && formName != '')
			setPageUrl += "&newResName="+resName;
		else
			setPageUrl += "?newResName="+resName;
	}
		
	var hWnd = window.showModalDialog(setPageUrl, args, "dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
	if (hWnd != null && hWnd.length > 0) {
		var excelUrl = contextPath+"/resmanage/excelout.do?CMD=EXCELOUT&fileType="+fileType;
		if(formName && formName != '')
			excelUrl += "&formName="+formName;
		if (resName){
			excelUrl += "&newResName="+resName;
		}
		var infoPage = hWnd[0].split("|");
		arg.push("startindex="+infoPage[0]);
		arg.push("endindex="+infoPage[1]);
		if (hWnd.length > 1){		
			var property = hWnd[1].toString();			
			arg.push("property="+property);
		}
		formList.action = excelUrl+ "&queryString="+arg.join(";");
		formList.submit();
		formList.action = actionUrl;
	}
}

//***************
//查询导出2
//*****************
 function setResExcelOutPageNew(fileType,voName) {

	var arg = new Array();
	var args = new Array();
   	var form = document.forms[0];
	var elements = form.elements;
	for (var i = 0;i < elements.length;i++){
		var pClassName = elements[i].parentNode.className;
		if(pClassName.indexOf("form_table") != -1){
			if (elements[i].type == "text" || elements[i].type == "hidden" 
				|| elements[i].nodeName.toUpperCase() == "SELECT" || (elements[i].type == "checkbox" && elements[i].checked)){
	   			if (trim(elements[i].value) != ""){
	   				arg.push(elements[i].name+"="+encodeValue(elements[i].value));
	   			} 			
   			}	
		}  		    		
	}
	args.push(arg);
	args.push(fileType);
	var actionUrl = formList.action;
	var setPageUrl = contextPath + "/resmanage/common/selectpage2.jsp?voName="+voName;
	var hWnd = window.showModalDialog(setPageUrl, args, "dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
	if (hWnd != null && hWnd.length > 0) {
		var excelUrl = contextPath+"/resmanage/common/excelout.do?CMD=EXCELOUT&fileType="+fileType+"&voName="+voName;
		var infoPage = hWnd[0].split("|");
		arg.push("startindex="+infoPage[0]);
		arg.push("endindex="+infoPage[1]);
		if (hWnd.length > 1){		
			var property = hWnd[1].toString();			
			arg.push("property="+property);
		}
		//var queryStr = encodeURI(arg.join(";"));
		formList.action = excelUrl+ "&queryString="+arg.join(";");
		formList.submit();
		formList.action = actionUrl;
	}
}

//用于导出EXCEL时,对element的值中的特殊字符进行编码,编码字符包括("%","&","+","#","/","?","=")
function encodeValue(eleValue){
	if(eleValue == null || eleValue ==''){
		return eleValue;
	}
	eleValue = eleValue.replace(/\%/g,"%25");
	eleValue = eleValue.replace(/\&/g,"%26");
	eleValue = eleValue.replace(/\+/g,"%20");
	eleValue = eleValue.replace(/\#/g,"%23");
	eleValue = eleValue.replace(/\//g,"%2F");
	eleValue = eleValue.replace(/\?/g,"%3F");
	eleValue = eleValue.replace(/\=/g,"%3D");
	return eleValue;
}


//************
//动态改变商品标识树的限制条件
//************
var oldCondition = "";
var condition = "";
var conditionName = "";
var conditionValue = "";

//动态改变商品标识树的限制条件,根据操作类型参数oprType确定是增加限制条件(值为"add")还是删除限制条件(值为"del")
//del操作需中add操作后调用才有效
//参数name为添加限制的属性的名称(目前只支持comclassid,comtype),value为属性的限制值,该值为一个字符数组
function changeCondition(name,valueArray,oprType){	
	if (condition != null && condition.charAt(condition.length-1) != ';'){
		condition +=";";//保证condition以分号结尾
	}
	if (name != null && name != "" && valueArray != null && valueArray.length > 0 && oprType != null){
		conditionName = name;
		conditionValues = valueArray;
		if (oprType == "add"){
			addCondition();	
		}		
		if (oprType == "del"){
			delCondition();
		}
	}
}

//增加限制条件
function addCondition(){
	var len = conditionValues.length;
	var limit ;
	for (var i = 0;i < len;i++){
		limit = conditionName + ":"+ conditionValues[i]+";";
		if (condition.indexOf(limit) == -1){
			condition += limit;
		}			
	}
}

//删除限制条件
function delCondition(){
	var len = conditionValues.length;
	var limit = "";
	for (var i = 0;i < len;i++){
		limit = conditionName + ":"+ conditionValues[i]+";";
		condition = condition.replace(limit,"");	
	}
}


//**********************
//获得复选框的值
//**********************
function getReportChbx(items){
	var id = 0;
	var values = new Array();
	if (items != null) {
		if (items.length != null) {
	  		for (var i = 0; i < items.length; i++) {
     			var e = items[i];
     			if (e.type == 'checkbox') {
     				if (e.checked){
						values[id++] = e.value;
     				}
     			}
			}
       }else {
       		 if (items.type == 'checkbox'){
       		 	if (items.checked){
						values[id++] = items.value;
     				}
       		 }
       }
	}
	if(id==0){
		errorMessageShow('<B><font color="red" >请选择至少一条记录</font></B>');
		return false;
	}
	return values;
}

//**********************
//动态创建表格,缓存提交数据
//**********************
		var comDatas = new Array();
		var comTable;
		var tBody;
		var fieldNames;
		var titleArray;
		var fieldValues;
		var clearErrorObj = false;
		var inObj;
		
		//初始化数据,
		function dataInit(){
			titleArray = new Array();
			fieldValues = new Array();
			for (var i = 0; i < fieldNames.length; i++){
				var field = eval("document.forms[0]."+fieldNames[i]);
				var fieldValue = eval("document.forms[0]."+fieldNames[i]+".value");
				fieldValues.push(fieldValue);
				var textNode = field.parentNode.previousSibling.innerText;
				var title = trim(textNode.toString());
				if (title.charAt(title.length-1) == ':'){
					title = title.slice(0,-1);
				}
				titleArray.push(title);
			}
			return checkInterSection();
		}
		
		//点击页面"添加"按钮时,调用该函数,names参数为包含字段名字的数组
		function addDatas(names,obj){
			if (obj){
				inObj = obj;
			}
			if (!checkData()){
				return false;
			}
			clearErrorObj = false;
			fieldNames = names;
			var rValue = dataInit();
			if (!rValue){
				return false;
			}else {
				if (comDatas.length < 1){
					createTable();					
				}
				addItem();
				comDatas.push(fieldValues);
				loadforiframe();
			}
		}
		
		//创建表格
		function createTable(){
			comTable = document.createElement("table");
			comTable.className = "form_table";
			tBody = document.createElement("tbody");
			comTable.appendChild(tBody);
			tBody.insertRow(0);
			for (var i = 0; i < titleArray.length; i++){
				tBody.rows[0].insertCell(i);
				tBody.rows[0].cells[i].appendChild(document.createTextNode(titleArray[i]));
				tBody.rows[0].cells[i].align = "center";
			}
			if (inObj){
				inObj.appendChild(comTable);			
			}else {
				document.forms[0].appendChild(comTable);
			}
		}
		
		//在表中添加一行
		function addItem(){
			if (!clearErrorObj)
			  	errorobj.innerHTML = "";
			var datas = fieldValues;
			var len = tBody.rows.length;
			tBody.insertRow(len);
			for (var i = 0; i < datas.length; i++){
				tBody.rows[len].insertCell(i);
				tBody.rows[len].cells[i].appendChild(document.createTextNode(datas[i]));
				tBody.rows[len].cells[i].align = "center";
			}			
			tBody.rows[len].insertCell(datas.length);
			tBody.rows[len].cells[datas.length].align = "center";
			tBody.rows[len].cells[datas.length].style.width = "50px";
			tBody.rows[len].cells[datas.length].style.height = "20px";
			var anchor = document.createElement("a");//用"span"和"input"设置:anchor.onclick = "javascript:delItem("+len+")";,无效
			var text = document.createTextNode("删除");
			anchor.appendChild(text);
			anchor.style.paddingTop = "4px";
			anchor.style.cursor = "hand";
			anchor.href = "javascript:delItem("+len+")";//竟然不能传递对象..若传this(即delItem(this)),this.parentNode为undefined,而不是cell
			tBody.rows[len].cells[datas.length].appendChild(anchor);		
		}

		//删除表格的一行,若缓存的数据为空,则删除整个表格
		function delItem(idx){
			comDatas.splice(idx-1,1);
			tBody.deleteRow(idx);
			resetPosition(idx);
			if (comDatas.length < 1){
				document.forms[0].removeChild(comTable);
			}
		}
		
		//从idx+1行开始,重置行数位置标识		
		function resetPosition(idx){
			var cellLen = tBody.rows[0].cells.length;
			for (var i = idx; i < tBody.rows.length;i++){
				var anchor = tBody.rows[i].cells[cellLen].firstChild;
				anchor.href ="javascript:delItem("+i+")";
			}
		}
		
		function checkData(){
			addfields();
            return checkval(window);
		}
		
		//在页面重载该函数,添加自定义字段限制,函数内容类似下面:
		//addfield('begno', '<bean:message bundle="oprresmanage" key="begno"/>', 'c', false, 21);
		//addfield('endno', '<bean:message bundle="oprresmanage" key="endno"/>', 'c', false, 21);
		function addfields(){
		}
		 
		//特定限制逻辑,可根据需要在页面重写该方法
		function checkInterSection(){
			var begno = fieldValues[0];
			var endno = fieldValues[1];
			if (begno > endno){
				errorMessageShow('<font color="red"><b>起始编号不能大于终止编号!</b></font>');
				return false;
			}
			for (var i = 0; i < comDatas.length;i++){
				var tBegno = comDatas[i][0];
				var tEndno = comDatas[i][1];
				if (begno > tEndno || endno < tBegno){
					continue;
				}else {
					errorMessageShow('<font color="red"><b>编号范围('+begno+"->"+endno+")与编号范围("+tBegno+"->"+tEndno+")存在重复的编号!</b></font>");
					return false;
				}
			}
			return true;
		}
		
		function setTableContent(fieldNames,datas){
			 clearErrorObj = true;
			var dataArray = composeArray(datas);
			titleArray = new Array();
			for (var i = 0; i < fieldNames.length; i++){
				var field = eval("document.forms[0]."+fieldNames[i]);
				var textNode = field.parentNode.previousSibling.innerText;
				var title = trim(textNode.toString());
				if (title.charAt(title.length-1) == ':'){
					title = title.slice(0,-1);
				}
				titleArray.push(title);
			}
			
			for (var i = 0; i < dataArray.length; i++){
				fieldValues = dataArray[i];
				if (comDatas.length < 1){
					createTable();	
				}
				addItem();
				comDatas.push(fieldValues);
				loadforiframe();
			}
		}
		
		function composeArray(str){
			var rArray = new Array();
			var datas = str.split("|");
			for (var i = 0; i < datas.length; i++){
				rArray.push(datas[i].split(","));
			}
			return rArray;
		}



/***********************
数据导入加密交换密钥增强型函数
************************/
var seedKey;
function exKeySeedKey(info,fileKeyText){
	var EvoucherAX = document.all("EvoucherAX1");
	if (typeof(EvoucherAX.BAXGetHandler)=='undefined'){
		errorMessageShow('<font color="red"><b>EvoucherAX.ocx控件加载不成功!\n请按以下步骤设置ie.\n 工具-> internet 选项->安全->受信任站点->站点,添加访问的IP地址为受信任站点</b></font>');
		return ;
	}
	var managerHandle = EvoucherAX.BAXGetHandler("Boss Manager", "WatchData Cryptographic Provider v3.0");
	if ( managerHandle == 0){
		errorMessageShow('<font color="red"><b>获取管理员卡句柄失败!管理员卡未插入或有误!</b></font>');
		return ;
	}
	
	var keyPair = EvoucherAX.AXIFgetKeyPair("Boss Manager", "WatchData Cryptographic Provider v3.0");
	if ( keyPair == 0){
		errorMessageShow('<font color="red"><b>获取管理员卡的密钥对句柄失败!</b></font>');
		return ;
	}
	
	var manager_publickey = EvoucherAX.BAXGetPubkeyB64str(managerHandle);
	if ( keyPair == ""){
		errorMessageShow('<font color="red"><b>获取管理员卡的公钥失败!</b></font>');
		return ;
	}
	
	//var keyText = EvoucherAX.BAXGetvExKeyFromFile(fileName);
	//if (keyText == ""){
	//	errorMessageShow('<font color="red"><b>从文件中获取密钥失败!</b></font>');
	//}
	//alert("文件密钥\n\r:"+keyText);
	var fileKeys = fileKeyText.split("|");
	var keyText = fileKeys[1];
	var managerPublickey = fileKeys[0];
	//alert("文件密钥\n\r:"+keyText);
	//alert("管理员卡公钥\n\r:"+managerPublickey);
	if (manager_publickey != managerPublickey){
		errorMessageShow('<font color="red"><b>管理员卡不匹配,请插入正确的管理员卡!</b></font>');
		return ;
	}
	var decodekey = EvoucherAX.AXIFdeCryptBase64Str(trim(keyText), keyPair);
	var codekey = EvoucherAX.BAXEnCryptExKey(manager_publickey,decodekey);
	//alert("文件密钥解密\n\r:"+decodeKey);
	if (codekey == ""){
		errorMessageShow('<font color="red"><b>从文件中获取的密钥验证失败!</b></font>');
		return;
	}
	
	seedKey = codekey;
	var pubKey_check_flag = true;
	var crypt_exKey_flag = true;
	var recid_cryptExKeys = new Array();
	if (info.charAt(info.length-1) == '|'){
		info = info.substring(0,info.length-1);
	}
	var recid_key_signs = info.split("|");
	for (var i = 0; i < recid_key_signs.length; i++){
		var recid_key_sign = recid_key_signs[i].split(";");
		var recid = recid_key_sign[0];
		var pubKey = recid_key_sign[1];
		var sign = recid_key_sign[2];
		//alert("终端号:"+recid);
		//alert("销售员公钥:"+pubKey);
		//alert("销售员公钥签字:"+sign);
		if (EvoucherAX.BAXVerifSign(managerHandle,pubKey,sign) == 1){
			//alert("验证成功!");
			pubKey_check_flag = false;
			var cryptExKey = EvoucherAX.BAXEnCryptExKey(pubKey,decodekey);
			//alert("jia mi:"+cryptExKey);
			if (cryptExKey != ""){
				crypt_exKey_flag = false;
				var recid_cryptExKey = new Array();
				recid_cryptExKey.push(recid);
				recid_cryptExKey.push(cryptExKey);
				recid_cryptExKeys.push(recid_cryptExKey);				
			}
		}
	}
	
	if (pubKey_check_flag){
		errorMessageShow('<font color="red"><b>公钥验证失败!</b></font>');
		return;
	}
	
	if (crypt_exKey_flag){
		errorMessageShow('<font color="red"><b>重新加密交换密钥失败!</b></font>');
		return;
	}

	//alert("recid_cryptExKeys:"+recid_cryptExKeys);
	return recid_cryptExKeys;
}

//空中选号相关
function selectAgentid(objectInputId) {
	var arg = new Array();
	var strUrl = contextPath + "/resmanage/airno/agentnopoolrela.do?CMD=SELECTAGENTID";
	var returnValue = window.showModalDialog(strUrl, arg, "dialogWidth:600px; dialogHeight:500px; status:no;resizable:yes;");
	if (returnValue != null && returnValue != "") {
		objectInputId.value = returnValue;
	}
	return;
}

function selectNopool(objectInputId,inputType,condition){
	var type = "";
	if (inputType)
		type = inputType;
	var ret = "";
	var oldVal = "";
	if (objectInputId.value)
		oldVal = objectInputId.value;
	if (!condition)
		condition = "";
	var arg = new Array();
	var strUrl = contextPath + "/resmanage/airno/common/fr.jsp?type=" + type + "&oldvalue=" + oldVal + "&condition=" + condition;
	var returnValue = window.showModalDialog(strUrl, arg, "dialogWidth:600px; dialogHeight:470px; status:no;resizable:yes;");
	if (returnValue != null && returnValue != "") {
		objectInputId.value = returnValue;
	}
	return;
}

//选择SCP
function selectScpid(objectInputId) {
	var arg = new Array();
	var strUrl = contextPath + "/resmanage/scpinfo.do?CMD=SELECTSCPID";
	var returnValue = window.showModalDialog(strUrl, arg, "dialogWidth:600px; dialogHeight:500px; status:no;resizable:yes;");
	if(returnValue == null){
		return;
	}else{
		objectInputId.value = returnValue;
	}
	return;
}

function createRule(objId){
	var url = contextPath + "/resmanage/airno/norule.do?CMD=CREATERULE";
	var retVal = window.showModalDialog(url, "", "dialogWidth:600px; dialogHeight:420px; status:no;resizable:yes;");
	if (retVal && objId){
		objId.value = retVal;
	}	
}

function checkRulelist(ruleStr,obj){
	if (ruleStr && obj){
		if (!/^[0-9_%]+$|^[A-D]{4}$/.test(ruleStr)){
			alert("规则编码含有非法字符，只能由数字（0-9）、百分号(%)、下划线(_)组成或由四位字母(A-D)组成");
			obj.focus();
		}
	}
}


function selectDateYYYYMM(date) {
	var retDate = window.showModalDialog(contextPath + "/js/bus/selectmon.html", date, "dialogWidth=240px;dialogHeight=170px;status:no;scroll=no;resizable:yes;");
	if (!retDate){
		retDate = "";
	}
	return retDate ;
}

function selectValidbillcyc(date){
	var retDate = selectDateYYYYMM(date.slice(0,-2));
	if (retDate !== "")
		retDate += "00";
	return retDate
}

function isValidValidbillcyc(validbillcyc,isnull){
	if (isnull && !validbillcyc){
		return true;
	}else if (validbillcyc && validbillcyc.length == 8 && validbillcyc.substring(6,8) == '00'){
		var date = validbillcyc.slice(0,-2);
		if (isValidYYYYMM(date)){
			return true;
		}
	}
	errorMessageShow('<font color="red"><b>帐务周期无效,请确认!</b></font>');
	return false;
}

function isValidYYYYMM(date) {
	if (date.length != 6) {
		return false;
	}
	var ma = date.match(/^\d{4}(0[1-9]|1[0-2])$/);
	if (ma) {
		return true;
	}
	return false;
}

//效率太低,弃用
function getNum(begno,endno){
	var  num = 1;
	if (endno > begno){
		while (endno  > begno){
			var str = addChar(begno);
			if (str == -1){
				return -1;
				break;
			}
			begno = str;
			num++;
		}	
	}
	return num;
}

function addChar(str){
	var charArr = toCharArray(str);
	var i = str.length-1 ; 
	for (; i >= 0; i--){
			var c = str.charAt(i);
			if (c == '9'){
				charArr[i] = 0;
			}else {
				if (c > '9' || c < '0'){
					return -1;
				}
				charArr[i] = parseInt(c) + 1;
				return charArr.join("");
			}
		}
		if ( i == -1){
			return -1;
		}
		return charArr.join("");
}

function getNum2(begno,endno){
	var num = 1;
	var tArr = new Array();
	if (endno > begno){
		//var begArr = toCharArray(begno);
		var endArr = toCharArray(endno);
		for (var i = endno.length - 1; i >= 0; i--){
			var bc = begno.charAt(i);
			var ec = endArr[i].toString();
			if (!isDigit(ec) || !isDigit(bc)){
				if (bc != ec) 
				return -1;
			}else {
				if (bc > ec){
					tArr[i] = 10 + parseInt(ec) - parseInt(bc);
					endArr[i-1] = parseInt(endArr[i-1]) -1;
				}else {
					tArr[i] = parseInt(ec) - parseInt(bc);
				}
			}
		}
		for (var j =0; j < tArr.length; j++){
			if (tArr[j] == '0'){
				continue;
			}else {
				num = parseInt(tArr.join("").slice(j,tArr.length)) + 1;
				break;
			}
		}
	}else if (begno == endno){
		num = 1;
	}else {
		num = -1;
	}
	return num;
}


function toCharArray(str){
	var charArr = new Array(str.length);
	for (var i = 0; i < str.length; i++){
		charArr[i] = str.charAt(i);
	}
	return charArr;
}


function isDigit(c){
	if (c){
		if (/^[0-9]$|^-[0-9]$/.test(c)){
			return true;
		}
	}
	return false;
}

//*******
//设置输入框为当前时间
//control:目标控件名称
//separator:分隔符,默认-
//*******
function setDefaultDate(control,separator){
	if( control == null || control == "" || !document.all(control)){
		alert("目标控件不存在!");
		return ;
	}
	if(separator == null || separator == undefined){
		separator = "-"
	}
	
	var nowDate = new Date(); 
	var dateStr = nowDate.getYear() + separator									
		    + (nowDate.getMonth() < 9 ? '0' : '') + (nowDate.getMonth() + 1) + separator
		    + (nowDate.getDate() < 10 ? '0' : '') + nowDate.getDate();
	if(document.all(control).value == ""){
		document.all(control).value = dateStr;
	}
}

