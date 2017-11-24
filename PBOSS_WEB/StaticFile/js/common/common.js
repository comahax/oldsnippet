/////////////////////////////这里放常用变量 Start///////////////////////////////////
var _REGEX_WAVE = "~";
var _REGEX_SIDELONG = "|";
var _ROLE_DELIVERY_MAN = 3;
var _ROLE_MANAGER =4;

/////////////////////////////这里放常用变量 Finish///////////////////////////////////
/**
 * 信息浏览窗口打开函数
 */
function f_openDetl(url,title){
	openDlg(url,title,750,550,true);
}
//调试用
function f_alertArray(a){
	for(var i=0; i<a.length; i++){
		alert(a[i]);
	}
}
//使用了jQuery方法，使用本库之前必须先引用jQuery类库 - 引用jQuery.min和jQuery.extend
function f_getObjById(id){
	//使用jQuery
	return $("#"+id);
}
function f_getObjByName(name){
	return document.getElementsByName(name);
}
function f_getValueById(id){
	return f_getObjById(id)[0].value;
}
/**
 * 限定输入栏最多字数
 */
function f_countlen(id,n){
	var o = document.getElementById(id);
	var v = o.value;
	if (v.length > n){
		o.value = v.substring(0,n)   
     } 
}   
/**
 * 当前页面跳转到另一个地址
 * url
 */
function f_jumpToURL(url){
	if(f_isNullOrEmpty(url))
		url = '#';
	window.location.href = url;
}
/**
 * 添加内容
 * id;	标识
 * str;	内容
 */
function f_innerHTML(id,str){
	var o = document.getElementById(id);
	//alert(o != null);
	//alert(str);
	if(o != null ){
		document.getElementById(id).innerHTML = str;
	}
	//
}
//focus by id
function f_focusById(id){
	f_getObjById(id)[0].focus();
}
//按r拆分字符串
function f_split(s,r){
	var t = s.split(r);
	for(var i=0; i<t.length; i++){
		if(f_isNullOrEmpty(t[i])){
			t.remove(i);
		}
	}
	//alert(" Str Split Size = " + t.length);
	return t;
}
//////////////////////////Menu/////////////////////////////////
//_DEFAULT_MENU = "商品订购~/goods/begin.do~100|酬金明细查询~/reward/rewardRecordQuery.do~100";//默认菜单
_DEFAULT_MENU="";
/**
 * 写菜单cookies,并跳到相应的URL
 * u:渠道编码
 * mn:菜单名称
 * mu:菜单链接
 */
function f_writeMenuCookie(u,mn,mu){
	//判断是否在默认菜单中
	if(_DEFAULT_MENU.indexOf(mn) > -1){
		f_jumpToURL(mu);
		return;
	}
	
	if(f_isNullOrEmpty(u) ||f_isNullOrEmpty(mn) || f_isNullOrEmpty(mu) ){
		f_jumpToURL(mu);
		return;
	}
	
	var t = 15 * 24 * 60//保存时间为15天
	
	var m = f_getMenuClickTimes(u,mn,mu);
	
	var c =  parseInt(m.mc) + 1;
	//alert("This["+ mn + "] Click Times = " + c);
	
	var v = f_updateCookieValue(u,mn,mu,c,m.mp);
	
	f_writeCookie(u,v,t);
	f_jumpToURL(mu);
	
}
/**
 * 获得菜单的点击次数
 * n：用戶名
 * mn：菜单名称
 * mu：菜单链接
 */
function f_getMenuClickTimes(n,mn,mu){
	var c = 0;
	var s = -1;
	
	var f = mn + _REGEX_WAVE + mu ;
	var v = f_readCookie(n);
	
	var s1 = f_split(v,_REGEX_SIDELONG);
	
	for(var i=0; i<s1.length; i++){
		var t = s1[i];
		
		//alert(t+".indexOf("+f+") = " + t.indexOf(f) );
		
		if( t.indexOf(f) > -1){
			s = i + 1;
			var s2 = f_split(t,_REGEX_WAVE);
			c = s2[2];
			break;
		}
		
	}
	var m = new Menu();
	m.mp = s;
	m.mc = c;
	
	//alert("Menu Postion = " + s + " " + m.mp);
	return m;
}
/**
 * 展示常用链接
 */
function f_showCommonMenu(u,id,r,isShowReward,isShowRewardLocal){
	if(r == _ROLE_DELIVERY_MAN || r == _ROLE_MANAGER)return;
	
	var c = "";
	
	var v = f_readCookie(u);
	var d = f_split(_DEFAULT_MENU,_REGEX_SIDELONG);//默认菜单
	var st = f_split(v,_REGEX_SIDELONG);
	
	//合并默认菜单
	var s = st.concat(d);
	
	//排序
	s.sort(f_sortMenuByClick);
	
	
	//显示的个数
	var l = 10;
	for(var i=0; i<s.length; i++){
		if(i < l){
			var t = f_split(s[i],_REGEX_WAVE);
			if((t[0]=="酬金明细查询"||t[0]=="月应发酬金报表"||t[0]=="月实际支付酬金报表"||t[0]=="酬金余额查询"||t[0]=="酬金明细查询"||t[0]=="酬金校验失败明细查询") 
				&& isShowReward==1 && isShowRewardLocal==0){
				c += "<li><a href=\""+t[1]+"\" class=\"a6\">" + t[0] + "</a></li>";
			}else if(t[0]=="酬金查询" && isShowReward==1 && isShowRewardLocal==1){
				c += "<li><a href=\""+t[1]+"\" class=\"a6\">" + t[0] + "</a></li>";
			}else if(!(t[0]=="酬金明细查询"||t[0]=="月应发酬金报表"||t[0]=="月实际支付酬金报表"||t[0]=="酬金余额查询"||t[0]=="酬金明细查询"||t[0]=="酬金校验失败明细查询"|| t[0]=="酬金查询")){
				c += "<li><a href=\""+t[1]+"\" class=\"a6\">" + t[0] + "</a></li>";
			}
		}
	}//end for
	
	f_innerHTML(id,c);
	
}
/**
 * 对菜单排序（点击次数）
 */
function f_sortMenuByClick(a,b){
	var s1 = f_split(a, _REGEX_WAVE);
	var s2 = f_split(b, _REGEX_WAVE);
	
	return parseInt(s2[2]) - parseInt(s1[2]); 
}
/**
 * 更新Cookie中value的值
 * ov：旧值
 */
function f_updateCookieValue(n,mn,mu,mc,mp){
	var ov = f_readCookie(n);
	//alert("Old Value = " + ov + " Menu Position = " + mp);
	
	var tv = mn + _REGEX_WAVE + mu + _REGEX_WAVE + mc;
	
	if(mp > -1 ){
		var s1 = f_split(ov, _REGEX_SIDELONG);
		s1[mp - 1] =  tv;
		ov = s1.join(_REGEX_SIDELONG);
	}
	else if(ov == ""){
		ov =  tv;
	}
	else if(ov != ""){
		ov = ov + _REGEX_SIDELONG  + tv;
	}
	//alert("New Value = " + ov + " Menu Position = " + mp);
	return ov;
}
/**
 * 菜单
 */
function Menu(){
	var mn;//名称
	var mu;//链接
	var mc;//点击次数
	var mp;//位置
}
//////////////////////////COOKIE/////////////////////////////////
/***
 * 写Cookie
 * n:cookie名称
 * v:值
 * t:保存时间（分钟）
 */
function f_writeCookie(n,v, t){
	if(!f_cookieIsForbidden()){
		//过期时间15分钟
		var expiration = new Date((new Date()).getTime() + t * 60000);
		//写入Cookie
		document.cookie = n + "=" + escape(v) + "; " +
						  "expires =" + expiration.toGMTString() + "; " +
						  "path=" + "/";
	}
}

/**
 * 根据n找cookies的值
 */
function f_readCookie(n){
	var value = "";
	// 如果找到了索引，就代表cookie存在，
	// 反之，就说明不存在。
	if(!f_cookieIsForbidden() && !f_isNullOrEmpty(n)){
		var allcookies = document.cookie;
		var cookie_pos = allcookies.indexOf(n);
		if (cookie_pos != -1){
	  		// 把cookie_pos放在值的开始，只要给值加1即可。
	  		cookie_pos += n.length + 1;
	  		var cookie_end = allcookies.indexOf(";", cookie_pos);
	
	  		if (cookie_end == -1){
	   			cookie_end = allcookies.length;
	  		}
	
	  		value = unescape(allcookies.substring(cookie_pos, cookie_end));
		}
	}
	//alert("The name["+n+"] in cookie is " + value);
	return value;
}
/**
 * 判断Cookie是否被禁止
 */
 function f_cookieIsForbidden(){
 	return (document.cookie == "");
 }
 /**
  * 删除某个Cookie
  * 为了删除指定名称的cookie，可以将其过期时间设定为一个过去的时间
  */
function f_delCookie(name){
   var date = new Date();
   date.setTime(date.getTime() - 10000);
   document.cookie = name + "=a; expires=" + date.toGMTString();
} 
//////////////////////////COOKIE/////////////////////////////////
//隐藏或显示某个div.t:true显示，false隐藏
function f_isDisplay(id, t){
	//document.getElementById("tabMenu").style.display = "none";
	if(t)
		f_getObjById(id)[0].style.display = "";
	else
		f_getObjById(id)[0].style.display = "none";
}
//退出
function f_logout(){
	var ok = function(){
		alertDlg("正在退出中，请稍候。","信息提示",false,false);
		f_jumpToURL('/logout.do');
	}

	var cancle = function(){
	}
	confirmDlg("您确定要退出吗？","请确认",ok,cancle);
}
//使某个按钮变灰
function f_disabled(id,t){
	var c = (t)?"":"disabled";
	f_getObjById(id)[0].disabled  = c;
}
//判断某个文本域是否为空
function f_isEmptyText(id){
	var v = f_getValueById(id);
	return f_isNullOrEmpty(v);
}
// 给文本域赋值
function f_setValueById(id,v){
	f_getObjById(id)[0].value = v;
}
function shover(o,className){
	if(!o) return;
	o.className = className;		
}
//根据checkbox的名称获得用户选择的值，并按r连接。
function f_getCheckValue(n,r){
	var result = new Object;
	result.isCheckAll = false;	//是否全选
	result.value = "";	//所选值
	
	var o = document.getElementsByName(n);
	var c = "";
	var l = o.length;
	var t = 0;

	for(var i=0;i<l;i++){
		if(o[i].checked){
			c += o[i].value;
			c += r;
			t ++ ;
		}
	}//end for
	result.isCheckAll = (t == l);
	result.value = c;
	return result;
}
//是否为空
function f_isNullOrEmpty(s){
	return (s == null || s == "")?true:false;
}
//判断是否是移动手机号码
function f_isMobile(m){
	var pattern = /^1(34|35|36|37|38|39|47|50|51|52|57|58|59|82|87|88)[0-9]{8}$/;
	var result = pattern.exec(m);
	if(result==null){
		return false;
	}
	return true;
}
//判断是否是电子邮箱
function f_isEmail(e){
	var r = e.match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/);
    if(r == null)
    	 return false;
    return true;
}
//匹配身份证(15位或18位)
function f_checkIDCard (str) {
        //身份证正则表达式(15位) 
        isIDCard1 = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/; 
        //身份证正则表达式(18位) 
        isIDCard2 = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/; 
        //验证身份证，返回结果 
        return (isIDCard1.test(str)||isIDCard2.test(str));
}
//渠道跳转
function toWayType(id,v,url){
	var i = f_getValueById(id);
	if(i == v){
		window.location = url;
	}
}
function textdown(e,id,m){
    textevent = e ;
    //达到指定字数后，只允许退格键其它都不可执行
    //如需扩展keyCode请参照“keyCode数值大全”
    if(textevent.keyCode == 8)
    {
      return;
    }
    //如果当前文本域字数超过m个停止输入
    if(f_getValueById(id).length >= m)  
    {
      if(!document.all)
      {
        textevent.preventDefault();
      }
      else
      {
        textevent.returnValue = false;
      }
    }
  }
 function textup(id,m){
    var s = f_getValueById(id);
    //判断当前文本域字数是否超过30个（主要是针对输入中文的情况）
    if(s.length > m){
     	f_getValueById(id).value=s.substring(0,m);
    }
  }

function f_reSet(ids){
	var t = f_split(ids, '|');
	var f = '';
	for(var i=0; i<t.length; i++){
		if(i == 0)f = t[i];
		f_getObjById(t[i])[0].value = "";
	}
	f_focusById(f);
}
/** 
 *  方法:Array.remove(dx) 
 *  功能:删除数组元素. 
 *  参数:dx删除元素的下标. 
 *  返回:在原数组上修改数组 
 */  
Array.prototype.remove=function(dx){
  if(isNaN(dx)||dx>this.length){return false;} 
  for(var i=0,n=0;i<this.length;i++) 
  { 
      if(this[i]!=this[dx]) 
      { 
          this[n++]=this[i] 
      } 
  }
  this.length-=1 
}
/**
 * HasMap
 */
function HashMap(){
	/** Map 大小 **/  
     var size = 0; 
     /** 对象 **/  
     var entry = new Object(); 
	/** 存 **/  
     this.put = function (key , value)   
     {   
         if(!this.containsKey(key))   
         {   
             size ++ ;   
         }   
         entry[key] = value;   
     }
     /** 取 **/  
     this.get = function (key)   
     {   
         return this.containsKey(key) ? entry[key] : null;   
     }
     /** 是否包含 Key **/  
     this.containsKey = function ( key )   
     {   
         return (key in entry);   
     }
}
	
/***
* date: 2008-11-06 04:19:00.0
* type: 1：2008-11-06
*		2：2008-11-06 04:19
*		3：2008-11-06 04:19:00
*/
function handlerdate(date, type) {
	if (date == null || date == "") {
		return date;
	} else {
		if (type == 1) {
			return date.substring(0, 10);
		} else if (type == 2) {
			return date.substring(0, 16);
		} else if (type == 3) {
			return date.substring(0, 19);
		}
	}
}

/**
当前
*/
function getMouthSelect($setSelect,length,incThisMm,setDate){
	var nowDate = new Date();
	if (!$.isUndefined(setDate)){
		nowDate = new Date(setDate);
	}
	
	var isIncThisMm = !(typeof incThisMm === 'undefined') && incThisMm;
	var giYear = nowDate.getFullYear();
	var giMonth = nowDate.getMonth()+1;
	var srtn = '',setVal;
	var getYear,getMonth,isSelectd = "",nowMonth;
	var orgValue = $setSelect.attr("orgval"); //提取原值
	var hasInit = true
//	debugger;
	for (var i=length;i>0;i--){
		getYear = giYear;
		getMonth = giMonth-i;
		while(getMonth<=0){
			getMonth = 12 + getMonth;
			getYear--;
		}//while 日期跳转
		nowMonth = getMonth;//保留当前月，以免下面执行造成数据丢失
		//debugger;
		if (!hasInit && (giMonth-length)>1){
			//生成当前年
			for (var j=1;j<giMonth-length;j++){
				getMonth = ("0"+j);
				getMonth = getMonth.substring(getMonth.length,getMonth.length-2);
				setVal = getYear + getMonth;
				if (orgValue == setVal|| ((i==1 && orgValue == "") && !isIncThisMm) ){
					isSelectd = " selected";
				}else{
					isSelectd = "";
				}
				srtn += "<option value='"+ setVal+"'"+ isSelectd +">"+ getYear + "年" + getMonth+"月</option>\n";
			}//for
		}//if

		hasInit = true;
		//组件位数
		//getMonth = giMonth-i;
		getMonth = ("0"+nowMonth);
		getMonth = getMonth.substring(getMonth.length,getMonth.length-2);
		setVal = getYear + getMonth;
		if ( (orgValue == setVal)|| ((i==1 && orgValue == "") && !isIncThisMm) ) {
			isSelectd = " selected";
		}else{
			isSelectd = "";
		}
		srtn += "<option value='"+ setVal+"'"+ isSelectd +">"+ getYear + "年" + getMonth+"月</option>\n";
	}//for
	if (isIncThisMm){
		getMonth = ("0"+giMonth);
		getMonth = getMonth.substring(getMonth.length,getMonth.length-2);
		setVal = giYear + getMonth;
		if ((orgValue == setVal) || (orgValue == "") ){
			isSelectd = " selected";
		}else{
			isSelectd = "";
		}
		srtn += "<option value='"+ setVal+"'"+ isSelectd +">"+ giYear + "年" + getMonth+"月</option>\n";
	}
	$setSelect.html(srtn);
}

/**
 * 判断今日是否大于指天生成月分下拉
*/
function getMouthSelectChkNow($setSelect,length,chkDate,incThisMm){
	//debugger
	if (typeof incThisMm === 'undefined') incThisMm = false;
	var nowDate = new Date();
	var giYear = nowDate.getFullYear();
	var giMonth = nowDate.getMonth()+1;
	var giDate = nowDate.getDate();
	//10号之前
	if (giDate >chkDate){
		getMouthSelect($setSelect,length,incThisMm);
	}else{
		getMouthSelect($setSelect,length,incThisMm,giYear+"/"+(giMonth-1)+"/01");
	}
}

/**
* 统一出错信息处理
*/
function showError(errMap){
	var s="";
	//显示错误信息
	for (var i=0;i<errMap.length;i++){
		s+=errMap[i].msg+"<br>"
	}
	f_showEMsg(s);
}

 //判断一个值是否在数组中
 function isInArray(field,arrayObj){
	if (arrayObj){
		var testString = arrayObj;
		if ($.isArray(arrayObj)){
			testString = arrayObj.join(",");
			testString = testString+",";
		}//if
		if (testString.indexOf(field)>-1)
			return true;
		else 
			return false;
	
	}else {
		return false;
	}//if
 }

function sumbitExportExcel(action,target){
	var org = document.getElementById("frmQuery").action;
	document.getElementById("frmQuery").action = action;
	document.getElementById("frmQuery").target = target;
	document.getElementById("frmQuery").submit();
	document.getElementById("frmQuery").action = org;
}
 