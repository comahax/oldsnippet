/////////////////////////////����ų��ñ��� Start///////////////////////////////////
var _REGEX_WAVE = "~";
var _REGEX_SIDELONG = "|";
var _ROLE_DELIVERY_MAN = 3;
var _ROLE_MANAGER =4;

/////////////////////////////����ų��ñ��� Finish///////////////////////////////////
/**
 * ��Ϣ������ڴ򿪺���
 */
function f_openDetl(url,title){
	openDlg(url,title,750,550,true);
}
//������
function f_alertArray(a){
	for(var i=0; i<a.length; i++){
		alert(a[i]);
	}
}
//ʹ����jQuery������ʹ�ñ���֮ǰ����������jQuery��� - ����jQuery.min��jQuery.extend
function f_getObjById(id){
	//ʹ��jQuery
	return $("#"+id);
}
function f_getObjByName(name){
	return document.getElementsByName(name);
}
function f_getValueById(id){
	return f_getObjById(id)[0].value;
}
/**
 * �޶��������������
 */
function f_countlen(id,n){
	var o = document.getElementById(id);
	var v = o.value;
	if (v.length > n){
		o.value = v.substring(0,n)   
     } 
}   
/**
 * ��ǰҳ����ת����һ����ַ
 * url
 */
function f_jumpToURL(url){
	if(f_isNullOrEmpty(url))
		url = '#';
	window.location.href = url;
}
/**
 * �������
 * id;	��ʶ
 * str;	����
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
//��r����ַ���
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
//_DEFAULT_MENU = "��Ʒ����~/goods/begin.do~100|�����ϸ��ѯ~/reward/rewardRecordQuery.do~100";//Ĭ�ϲ˵�
_DEFAULT_MENU="";
/**
 * д�˵�cookies,��������Ӧ��URL
 * u:��������
 * mn:�˵�����
 * mu:�˵�����
 */
function f_writeMenuCookie(u,mn,mu){
	//�ж��Ƿ���Ĭ�ϲ˵���
	if(_DEFAULT_MENU.indexOf(mn) > -1){
		f_jumpToURL(mu);
		return;
	}
	
	if(f_isNullOrEmpty(u) ||f_isNullOrEmpty(mn) || f_isNullOrEmpty(mu) ){
		f_jumpToURL(mu);
		return;
	}
	
	var t = 15 * 24 * 60//����ʱ��Ϊ15��
	
	var m = f_getMenuClickTimes(u,mn,mu);
	
	var c =  parseInt(m.mc) + 1;
	//alert("This["+ mn + "] Click Times = " + c);
	
	var v = f_updateCookieValue(u,mn,mu,c,m.mp);
	
	f_writeCookie(u,v,t);
	f_jumpToURL(mu);
	
}
/**
 * ��ò˵��ĵ������
 * n���Ñ���
 * mn���˵�����
 * mu���˵�����
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
 * չʾ��������
 */
function f_showCommonMenu(u,id,r,isShowReward,isShowRewardLocal){
	if(r == _ROLE_DELIVERY_MAN || r == _ROLE_MANAGER)return;
	
	var c = "";
	
	var v = f_readCookie(u);
	var d = f_split(_DEFAULT_MENU,_REGEX_SIDELONG);//Ĭ�ϲ˵�
	var st = f_split(v,_REGEX_SIDELONG);
	
	//�ϲ�Ĭ�ϲ˵�
	var s = st.concat(d);
	
	//����
	s.sort(f_sortMenuByClick);
	
	
	//��ʾ�ĸ���
	var l = 10;
	for(var i=0; i<s.length; i++){
		if(i < l){
			var t = f_split(s[i],_REGEX_WAVE);
			if((t[0]=="�����ϸ��ѯ"||t[0]=="��Ӧ����𱨱�"||t[0]=="��ʵ��֧����𱨱�"||t[0]=="�������ѯ"||t[0]=="�����ϸ��ѯ"||t[0]=="���У��ʧ����ϸ��ѯ") 
				&& isShowReward==1 && isShowRewardLocal==0){
				c += "<li><a href=\""+t[1]+"\" class=\"a6\">" + t[0] + "</a></li>";
			}else if(t[0]=="����ѯ" && isShowReward==1 && isShowRewardLocal==1){
				c += "<li><a href=\""+t[1]+"\" class=\"a6\">" + t[0] + "</a></li>";
			}else if(!(t[0]=="�����ϸ��ѯ"||t[0]=="��Ӧ����𱨱�"||t[0]=="��ʵ��֧����𱨱�"||t[0]=="�������ѯ"||t[0]=="�����ϸ��ѯ"||t[0]=="���У��ʧ����ϸ��ѯ"|| t[0]=="����ѯ")){
				c += "<li><a href=\""+t[1]+"\" class=\"a6\">" + t[0] + "</a></li>";
			}
		}
	}//end for
	
	f_innerHTML(id,c);
	
}
/**
 * �Բ˵����򣨵��������
 */
function f_sortMenuByClick(a,b){
	var s1 = f_split(a, _REGEX_WAVE);
	var s2 = f_split(b, _REGEX_WAVE);
	
	return parseInt(s2[2]) - parseInt(s1[2]); 
}
/**
 * ����Cookie��value��ֵ
 * ov����ֵ
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
 * �˵�
 */
function Menu(){
	var mn;//����
	var mu;//����
	var mc;//�������
	var mp;//λ��
}
//////////////////////////COOKIE/////////////////////////////////
/***
 * дCookie
 * n:cookie����
 * v:ֵ
 * t:����ʱ�䣨���ӣ�
 */
function f_writeCookie(n,v, t){
	if(!f_cookieIsForbidden()){
		//����ʱ��15����
		var expiration = new Date((new Date()).getTime() + t * 60000);
		//д��Cookie
		document.cookie = n + "=" + escape(v) + "; " +
						  "expires =" + expiration.toGMTString() + "; " +
						  "path=" + "/";
	}
}

/**
 * ����n��cookies��ֵ
 */
function f_readCookie(n){
	var value = "";
	// ����ҵ����������ʹ���cookie���ڣ�
	// ��֮����˵�������ڡ�
	if(!f_cookieIsForbidden() && !f_isNullOrEmpty(n)){
		var allcookies = document.cookie;
		var cookie_pos = allcookies.indexOf(n);
		if (cookie_pos != -1){
	  		// ��cookie_pos����ֵ�Ŀ�ʼ��ֻҪ��ֵ��1���ɡ�
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
 * �ж�Cookie�Ƿ񱻽�ֹ
 */
 function f_cookieIsForbidden(){
 	return (document.cookie == "");
 }
 /**
  * ɾ��ĳ��Cookie
  * Ϊ��ɾ��ָ�����Ƶ�cookie�����Խ������ʱ���趨Ϊһ����ȥ��ʱ��
  */
function f_delCookie(name){
   var date = new Date();
   date.setTime(date.getTime() - 10000);
   document.cookie = name + "=a; expires=" + date.toGMTString();
} 
//////////////////////////COOKIE/////////////////////////////////
//���ػ���ʾĳ��div.t:true��ʾ��false����
function f_isDisplay(id, t){
	//document.getElementById("tabMenu").style.display = "none";
	if(t)
		f_getObjById(id)[0].style.display = "";
	else
		f_getObjById(id)[0].style.display = "none";
}
//�˳�
function f_logout(){
	var ok = function(){
		alertDlg("�����˳��У����Ժ�","��Ϣ��ʾ",false,false);
		f_jumpToURL('/logout.do');
	}

	var cancle = function(){
	}
	confirmDlg("��ȷ��Ҫ�˳���","��ȷ��",ok,cancle);
}
//ʹĳ����ť���
function f_disabled(id,t){
	var c = (t)?"":"disabled";
	f_getObjById(id)[0].disabled  = c;
}
//�ж�ĳ���ı����Ƿ�Ϊ��
function f_isEmptyText(id){
	var v = f_getValueById(id);
	return f_isNullOrEmpty(v);
}
// ���ı���ֵ
function f_setValueById(id,v){
	f_getObjById(id)[0].value = v;
}
function shover(o,className){
	if(!o) return;
	o.className = className;		
}
//����checkbox�����ƻ���û�ѡ���ֵ������r���ӡ�
function f_getCheckValue(n,r){
	var result = new Object;
	result.isCheckAll = false;	//�Ƿ�ȫѡ
	result.value = "";	//��ѡֵ
	
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
//�Ƿ�Ϊ��
function f_isNullOrEmpty(s){
	return (s == null || s == "")?true:false;
}
//�ж��Ƿ����ƶ��ֻ�����
function f_isMobile(m){
	var pattern = /^1(34|35|36|37|38|39|47|50|51|52|57|58|59|82|87|88)[0-9]{8}$/;
	var result = pattern.exec(m);
	if(result==null){
		return false;
	}
	return true;
}
//�ж��Ƿ��ǵ�������
function f_isEmail(e){
	var r = e.match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/);
    if(r == null)
    	 return false;
    return true;
}
//ƥ�����֤(15λ��18λ)
function f_checkIDCard (str) {
        //���֤������ʽ(15λ) 
        isIDCard1 = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/; 
        //���֤������ʽ(18λ) 
        isIDCard2 = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/; 
        //��֤���֤�����ؽ�� 
        return (isIDCard1.test(str)||isIDCard2.test(str));
}
//������ת
function toWayType(id,v,url){
	var i = f_getValueById(id);
	if(i == v){
		window.location = url;
	}
}
function textdown(e,id,m){
    textevent = e ;
    //�ﵽָ��������ֻ�����˸������������ִ��
    //������չkeyCode����ա�keyCode��ֵ��ȫ��
    if(textevent.keyCode == 8)
    {
      return;
    }
    //�����ǰ�ı�����������m��ֹͣ����
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
    //�жϵ�ǰ�ı��������Ƿ񳬹�30������Ҫ������������ĵ������
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
 *  ����:Array.remove(dx) 
 *  ����:ɾ������Ԫ��. 
 *  ����:dxɾ��Ԫ�ص��±�. 
 *  ����:��ԭ�������޸����� 
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
	/** Map ��С **/  
     var size = 0; 
     /** ���� **/  
     var entry = new Object(); 
	/** �� **/  
     this.put = function (key , value)   
     {   
         if(!this.containsKey(key))   
         {   
             size ++ ;   
         }   
         entry[key] = value;   
     }
     /** ȡ **/  
     this.get = function (key)   
     {   
         return this.containsKey(key) ? entry[key] : null;   
     }
     /** �Ƿ���� Key **/  
     this.containsKey = function ( key )   
     {   
         return (key in entry);   
     }
}
	
/***
* date: 2008-11-06 04:19:00.0
* type: 1��2008-11-06
*		2��2008-11-06 04:19
*		3��2008-11-06 04:19:00
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
��ǰ
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
	var orgValue = $setSelect.attr("orgval"); //��ȡԭֵ
	var hasInit = true
//	debugger;
	for (var i=length;i>0;i--){
		getYear = giYear;
		getMonth = giMonth-i;
		while(getMonth<=0){
			getMonth = 12 + getMonth;
			getYear--;
		}//while ������ת
		nowMonth = getMonth;//������ǰ�£���������ִ��������ݶ�ʧ
		//debugger;
		if (!hasInit && (giMonth-length)>1){
			//���ɵ�ǰ��
			for (var j=1;j<giMonth-length;j++){
				getMonth = ("0"+j);
				getMonth = getMonth.substring(getMonth.length,getMonth.length-2);
				setVal = getYear + getMonth;
				if (orgValue == setVal|| ((i==1 && orgValue == "") && !isIncThisMm) ){
					isSelectd = " selected";
				}else{
					isSelectd = "";
				}
				srtn += "<option value='"+ setVal+"'"+ isSelectd +">"+ getYear + "��" + getMonth+"��</option>\n";
			}//for
		}//if

		hasInit = true;
		//���λ��
		//getMonth = giMonth-i;
		getMonth = ("0"+nowMonth);
		getMonth = getMonth.substring(getMonth.length,getMonth.length-2);
		setVal = getYear + getMonth;
		if ( (orgValue == setVal)|| ((i==1 && orgValue == "") && !isIncThisMm) ) {
			isSelectd = " selected";
		}else{
			isSelectd = "";
		}
		srtn += "<option value='"+ setVal+"'"+ isSelectd +">"+ getYear + "��" + getMonth+"��</option>\n";
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
		srtn += "<option value='"+ setVal+"'"+ isSelectd +">"+ giYear + "��" + getMonth+"��</option>\n";
	}
	$setSelect.html(srtn);
}

/**
 * �жϽ����Ƿ����ָ�������·�����
*/
function getMouthSelectChkNow($setSelect,length,chkDate,incThisMm){
	//debugger
	if (typeof incThisMm === 'undefined') incThisMm = false;
	var nowDate = new Date();
	var giYear = nowDate.getFullYear();
	var giMonth = nowDate.getMonth()+1;
	var giDate = nowDate.getDate();
	//10��֮ǰ
	if (giDate >chkDate){
		getMouthSelect($setSelect,length,incThisMm);
	}else{
		getMouthSelect($setSelect,length,incThisMm,giYear+"/"+(giMonth-1)+"/01");
	}
}

/**
* ͳһ������Ϣ����
*/
function showError(errMap){
	var s="";
	//��ʾ������Ϣ
	for (var i=0;i<errMap.length;i++){
		s+=errMap[i].msg+"<br>"
	}
	f_showEMsg(s);
}

 //�ж�һ��ֵ�Ƿ���������
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
 