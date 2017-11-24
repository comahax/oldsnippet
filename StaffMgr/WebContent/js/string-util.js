/*
函数名称：strLenthByByte 
函数功能：计算字符串的字节长度，即英文算一个，中文算两个字节 
函数参数：str,为需要计算长度的字符串*/
function strLenthByByte(str) {
	var len;
	var i;
	len = 0;
	for (i = 0; i < str.length; i++) {
		if (str.charCodeAt(i) > 255)
			len += 2;
		else
			len++;
	}
	return len;
}

/*
 * 函数名称：trim 函数功能：去除字符串两边的空格 函数参数：str,需要处理的字符串
 */
function trim(str) {
	return str.replace(/(^ *)|( *$)/g, "");
}
/*
 * 函数名称：lTrim 函数功能：去除左边的空格 函数参数：str,需要处理的字符串
 */
function lTrim(str) {
	return str.replace(/(^ *)/g, "");
}

/*
 * 函数名称：rTrim 函数功能：去除右边的空格 函数参数：str,需要处理的字符串
 */
function rTrim(str) {
	return this.replace(/( *$)/g, "");
}

/*
 * 函数名称：IsNull 函数功能：判断给定字符串是否为空 函数参数：str,需要处理的字符串
 */
function isNull( str ) {
	if(str==null)
		return true;
	var i=0;
	var sch="";
	str=str.toString();
	for ( i = str.length-1; i >= 0; i--){
		sch=str.charAt(i);
		if ( sch!=" " && sch!="\t" && sch!="\r" && sch!="\n") return false;
	}
	return true;
}

function html_encode(str)   
{   
  var s = "";   
  if (str.length == 0) return "";   
  s = str.replace(/&/g, "&gt;");   
  s = s.replace(/</g, "&lt;");   
  s = s.replace(/>/g, "&gt;");   
  s = s.replace(/ /g, "&nbsp;");   
  s = s.replace(/\'/g, "&#39;");   
  s = s.replace(/\"/g, "&quot;");   
  s = s.replace(/\n/g, "<br>");   
  return s;   
}   

function html_decode(str)   
{   
  var s = "";   
  if (str.length == 0) return "";   
  s = str.replace(/&gt;/g, "&");   
  s = s.replace(/&lt;/g, "<");   
  s = s.replace(/&gt;/g, ">");   
  s = s.replace(/&nbsp;/g, " ");   
  s = s.replace(/&#39;/g, "\'");   
  s = s.replace(/&quot;/g, "\"");   
  s = s.replace(/<br>/g, "\n");   
  return s;   
}

function formatDate(date,format)
{
    var o =
    {
        "M+" : date.getMonth()+1, //month
        "d+" : date.getDate(),    //day
        "h+" : date.getHours(),   //hour
        "m+" : date.getMinutes(), //minute
        "s+" : date.getSeconds(), //second
        "q+" : Math.floor((date.getMonth()+3)/3),  //quarter
        "S" : date.getMilliseconds() //millisecond
    }
    if(/(y+)/.test(format))
    format=format.replace(RegExp.$1,(date.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)
    if(new RegExp("("+ k +")").test(format))
    format = format.replace(RegExp.$1,RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
    return format;
}

function formatText(text,args){
	for(var i=0;i<args.length;i++){
		var reg=new RegExp("\\{"+(i+1)+"\\}","g"); 
		text = text.replace(reg,args[i]);
	}
	return text;
}