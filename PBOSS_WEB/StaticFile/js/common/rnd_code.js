//随机短信验证码
var _o_ti = null; 
function getSMSRndCode(mid){
	
	if(checkMobile(mid)){
		var a = {
				dataType:'json',
				success:handleRndSMSCode
			}
		_o_ti = f_showPlan("正在发生短信验证码，请稍候。");
		
		//document.LoginForm.action="/sms/RndCode.do";
		$('#smsofflceTel').val( $('#officeTel').val() );
		$('#smsForm').ajaxSubmit(a);
	}
}
function handleRndSMSCode(json){
		if(_o_ti != null)
			_o_ti.close();
		f_showMsg(json.message);
}
function checkMobile(mid){
	var b_s = true;
	var m = f_getValueById(mid);
	
	if(f_isNullOrEmpty(m)){//|| !f_isMobile(m)
		f_showMsg("请输入正确的移动手机号码。");
		b_s = false;
		return b_s;
	}
	return b_s;
}

//验证码
//干掉验证码
var verifyCounter=[];

function hiddenVerify(isImme){
	if(!verifyCounter[0])
		return;
	if(!isImme)
		verifyCounter[0].timeout=setTimeout(function(){verifyCounter[0].killMe()},500);
	else
		verifyCounter[0].killMe();
}
function VerifyImage(eleID,x,y){
	//alert('VerifyImage Function');
	var c=verifyCounter.length;
	this.timeout=null;
	this.ipt = null;
	if(!eleID)
		this.eleID=eleID="verifyIMG_"+c;
	this.od=document.getElementById("_rndImageDIV");//document.createElement("div");
	with(this.od){
		style.position="absolute";
		style.backgroundColor="#E8FBFF";
		style.border="solid 1px #545454";
		style.padding="3px";
		id=eleID+"_anchor";
		style.zIndex = 3000;
	}
	this.templete=('<img id="'+eleID+'" class="validateCodePic" onclick="getVerify(\''+eleID+'\','+c+')" style="cursor:pointer;margin-bottom:5px" src="/image?sds={{_random_}}" alt="获取中..." title="点击更换" width="102" height="42" /><br /><span id="anotherPic" class="validateCodePic" onclick="getVerify(\''+eleID+'\','+c+')" style="color:black;cursor:pointer">看不清楚?换一个</span>');
	this.seed=Math.random();
	this.appended=false;

	verifyCounter[c]=this;
}

//获取验证码
function getVerify(s,n){
	//alert("getVerify Functions " + s);
	clearTimeout(verifyCounter[n].timeout);
	verifyCounter[n].change(s);
	//var i=$("verifycode");
	if(verifyCounter[n].ipt){
		verifyCounter[n].ipt.value="";
		verifyCounter[n].ipt.focus();
	}
}
//获取验证码
function focusGetVerify(o){
	//alert("FocusGetVerify Functions");
    if(o==undefined){
    	return ;
    }
	var pos = getPosition(o);
	var e = (verifyCounter.length>0)?(verifyCounter[0]):(new VerifyImage());
	e.ipt = o;
	e.showMe(pos.left,pos.top);
	o.value="";
}
function   getPosition(obj)   {   
          var   top=105;   
          var   left=obj.offsetWidth;   
          var   width=obj.offsetWidth;   
          var   height=obj.offsetHeight;   
  while   (obj.offsetParent)   {   
          top   +=   obj.offsetTop;   
          left   +=   obj.offsetLeft;   
          obj   =   obj.offsetParent;   
          }   
          return   {"top":top,"left":left,"width":width,"height":height};   
}

VerifyImage.prototype.change=function(s){
	//var o=$(this.eleID);
	var _o_icode = document.getElementById(s);
	this.seed=Math.random();
	//alert(_o_icode == null);
	_o_icode.src="/image?sds="+this.seed;
}

VerifyImage.prototype.killMe=function(){
	this.od.style.display="none";
}

VerifyImage.prototype.showMe=function(x,y){
	with(this.od){
		style.top=(y-85)+"px";
		style.left=(x+1)+"px";
	}
	if(!this.appended){
		 this.od.innerHTML=this.templete.replace(/\{\{_random_\}\}/g,this.seed); 
		 this.appended=true;
	}
	this.od.style.display="";
}//end function


