var objectAllNum,objectNowNum,cErs,cDrs;
cDrs=document.all(0); 

document.onkeydown=function () {
endloadgic ();

intobound();
cErs=document.all(objectNowNum);

if (window.event.keyCode == 13) { //enter
cDrs.click();
while ((cErs.tagName.toLowerCase() != "input" && cErs.tagName.toLowerCase() != "select" && cErs.tagName.toLowerCase() != "textarea") || cDrs == cErs || cDrs.sourceIndex-objectNowNum == 1 || cErs.type.toLowerCase() == "hidden" || cErs.disabled == true) {
objectNowNum=objectNowNum+1;intobound();

cErs=document.all(objectNowNum);}

somethinghappen (cErs);
cDrs=cErs;

objectNowNum=objectNowNum+1;


return false;

}else if(window.event.keyCode == 192){ //`
while ((cErs.tagName.toLowerCase() != "input" && cErs.tagName.toLowerCase() != "select" && cErs.tagName.toLowerCase() != "textarea") || cDrs == cErs || objectNowNum-cDrs.sourceIndex == 1 || cErs.type.toLowerCase() == "hidden" || cErs.disabled == true) {
objectNowNum=objectNowNum-1;intobound();

cErs=document.all(objectNowNum);}

somethinghappen (cErs);
cDrs=cErs;

objectNowNum=objectNowNum-1;

return false;

}else if(window.event.keyCode == 9) { //tab
while ((cErs.tagName.toLowerCase() != "input" && cErs.tagName.toLowerCase() != "select" && cErs.tagName.toLowerCase() != "textarea") || cDrs == cErs || cDrs.sourceIndex-objectNowNum == 1 || cErs.type.toLowerCase() == "hidden" || cErs.disabled == true) {
objectNowNum=objectNowNum+1;intobound();

cErs=document.all(objectNowNum);}

somethinghappen (cErs);
cDrs=cErs;

objectNowNum=objectNowNum+1;

return false;

}else if (window.event.keyCode == 32) {
switch (cDrs.type) {
	case "file":
	//window.status = "file";
	cDrs.click();break;
	
	case "select-one":
	//window.status = "select";
	cDrs.click(); break;
	
	case "submit":
	//window.status = "submit";
	alldisabled();
	cDrs.click();
	break;
	
	case "textarea":
	//window.status = "textarea";
	break;
	
	case "checkbox":
	//window.status = "checkbox";
	if (cDrs.status){cDrs.status = false;}else{cDrs.status = true;}
	return false; break;
	
	case "button":
	//window.status = "button";
	cDrs.click(); 
	cDrs.blur();
	break;
	
	case "radio":
	//window.status = "radio";
	if (cDrs.status){cDrs.status = false;}else{cDrs.status = true;}
	return false; break;
	
	case "image":
	//window.status = "image";
	cDrs.click(); break;
	
	case "reset":
	//window.status = "reset";
	cDrs.click(); break;
	
	case "text": 
	//window.status = "reset"; 
	cDrs.click(); break;
	
	default:
	//window.status = "###"
	break;
}
}
return;
}

function somethinghappen(objc) {
switch (objc.type) {
case "text":
objc.focus();
unbeautify();
beautify(objc);break;
case "file":
objc.focus();
unbeautify();
beautify(objc);break;
case "textarea":
objc.focus();
unbeautify();
beautify(objc);break;
default:
objc.focus();
unbeautify();
beautify(objc);break;
}
}
function beautify(objc) {
objc.style.backgroundColor = "#327AC5"; 
if (objc.type == "button" || objc.type == "submit" || objc.type == "reset") {
	objc.style.color = "#000000";
	}else{
	objc.style.color = "#FFFFFF";
	}
}
function unbeautify() {
if ( cDrs != cErs) {
cDrs.style.backgroundColor = "";
if (cDrs.type == "button" || cDrs.type == "submit" || cDrs.type == "reset") {
	cDrs.style.color = "#FFFFFF";
	}else{
	cDrs.style.color = "#000000";
	}
}
}
document.onmousedown=function () {
objectNowNum = event.srcElement.sourceIndex;
cErs=document.all(objectNowNum);

unbeautify();
cDrs=cErs;
if (cErs.tagName.toLowerCase() == "input" || cErs.tagName.toLowerCase() == "select" || cErs.tagName.toLowerCase() == "textarea"){
beautify(cErs);

}
}
function intobound() {
if (objectNowNum<0){objectNowNum=objectAllNum-1;}
if (objectNowNum>=objectAllNum) {objectNowNum=0;}
}
function endloadgic() {
if (objectAllNum == null) {
objectAllNum=document.all.length;
objectNowNum=0;	
	}
}
function alldisabled () {
	for (i=0;i<document.all.length;i++) {
		if (document.all(i).tagName.toLowerCase() == "input" && document.all(i).type == "file") {
			document.all(i).disabled = true;
			}
		}
	}

