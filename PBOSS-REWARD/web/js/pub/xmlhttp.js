var xmlHttp; 
var xmlHttpUrl = null;
var xmlHttpAsynch = true;
var mypoint = null;
var xmlHttpMethod = "POST"; 
var xmlHttpFuncObj = "startRebulid()"; 
var xmlRequestObjtype = "XML"; 
var xmlPostString = ""; 
function creatXmlHttpRequest () {
	if (window.ActiveXObject) {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		//window.status = "new ActiveXObject(\"Microsoft.XMLHTTP\")";
	}else if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
		//winodw.status = "new XMLHttpRequest()";
	}
}
function startXmlHttp () { 
	creatXmlHttpRequest();
	xmlHttp.onreadystatechange = startChange;
	xmlHttp.open(xmlHttpMethod,xmlHttpUrl,xmlHttpAsynch);
	if (xmlHttpMethod == "GET") {
		xmlHttp.send(null);	
	}else if (xmlHttpMethod == "POST") {
		xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;")
		xmlHttp.send(xmlPostString);
	}
	
}
function startChange () {
	//startLoading();
	if (xmlHttp.readyState == 4) {
		if(xmlHttp.status == 200) {
			endLoading();
			if (xmlRequestObjtype == "XML"){
					mypoint = xmlHttp.responseXML;
				}else if (xmlRequestObjtype == "TEXT") {
					mypoint = xmlHttp.responseText;	
				}else{
					mypoint = xmlHttp.responseXML;
				}
			eval(xmlHttpFuncObj);
		}else {
			endLoading();
			alert("error:" + xmlHttp.status);
			}
	}
}
function startLoading () {
	loading.className = "loading_on";
	loading.innerHTML = "loading...";
}
function endLoading () {
	loading.className = "loading_off";
}
function addLoading () {
	if (document.all("loading") == null){
		var addl;
		addl = document.createElement("<div id=\"loading\" class=\"loading_off\"></div>");
		document.body.appendChild(addl);
		}
	}
//----------------------------------------------------------
function startAjax(JMurl,JMfunc,JMtype,JMmethod,JMasynch) { 
 
	addLoading();
	xmlHttpUrl = cutCache(JMurl);
	if (JMmethod.toUpperCase() == "POST" || JMmethod.toUpperCase() == "GET" ||JMmethod.toUpperCase() == "PUT"){
		xmlHttpMethod = JMmethod.toUpperCase(); 
		}
	if (JMasynch == true || JMasynch == false) {
		xmlHttpAsynch = JMasynch; 
		}
	if (JMfunc != "") {
		if (JMfunc == 0){
			xmlHttpFuncObj = ""; 
			}else{
			xmlHttpFuncObj = JMfunc; 
			}
		
		}
	if (JMtype.toUpperCase() == "TEXT") {
		xmlRequestObjtype = "TEXT";
		}else if(JMtype.toUpperCase() == "XML"){
		xmlRequestObjtype = "XML";
		}
	startXmlHttp();
	}
function startRebulid() {
	try {
		mydiv.innerHTML = mypoint;
		more.value = mypoint;
	}catch(exception){
		alert("error no return func");
	}
}
function cutCache (str) {
	var strp = "";
	if (str.indexOf("?") == -1) {
		strp = str + "?" + Math.random();
		}else{
		strp = str + "&" + Math.random();
		}
	return strp;
	}
