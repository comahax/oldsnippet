//提交时弹出提交对话框
//@author Jimmy

var submitDlg;
function saveInDlg(frmObj,headerTitle,widthDlg,heightDlg,isCloseBtn){
	 //
	 submitDlg = null;
	isCloseBtn = isCloseBtn?true:false;
	if(widthDlg==undefined){//提示窗口宽度
		widthDlg=600;
	}
	if(heightDlg==undefined){//提示窗口高度
		heightDlg=300;
	}

	var optn = {
			showButton: false,
			showClose: isCloseBtn,
			title: headerTitle,//标题
			width:widthDlg,//宽度
			height:heightDlg,//高度
			onopen:function(box){
				//alert('opened!');
				submitDlg = box;
			},
			onclose:function(){
				//alert('closed!');
			}
		}
	$.weeboxs.open("<iframe name='jqDlgForm' src='"+contextRootPath+"/html/loading/loading.html' frameborder='0' style='margin:0; padding:0; width:98%; height: 90%;z-index:1'></iframe>",
		optn
	);
	//构建Panel时修改其target
	frmObj.target='jqDlgForm';
}

/**
*打开对话框,
URL:只能按全路径跳转
*/
var jqDlgJumpUrl = "";
function openDlg(url,headerTitle,widthDlg,heightDlg,isCloseBtn){
	 //
	 jqDlgJumpUrl = ""
	 submitDlg = null;
	isCloseBtn = isCloseBtn?true:false;
	if(widthDlg==undefined){//提示窗口宽度
		widthDlg=600;
	}
	if(heightDlg==undefined){//提示窗口高度
		heightDlg=300;
	}

	var optn = {
			showButton: false,
			showClose: isCloseBtn,
			title: headerTitle,//标题
			width:widthDlg,//宽度
			height:heightDlg,//高度
			onopen:function(box){
				//alert('opened!');
				submitDlg = box;
			},
			onclose:function(){
				//alert('closed!');
			}
		}
	$.weeboxs.open("<iframe name='jqDlgForm' src='"+contextRootPath+"/html/loading/loading.html' frameborder='0' style='margin:0; padding:0; width:98%; height: 90%;z-index:1'></iframe>",
		optn
	);
	jqDlgJumpUrl = url;
}



function refreshPage(){//刷新
	window.location.reload();
}

function closePage(){//关闭
	//submitDlg.hide();
	submitDlg.close();
}

/**
对话框提示
*/
function alertDlg(message,headerTitle,isOkBtn,isCancleBtn,isCloseBtn,type,ok){
	 //
	isCloseBtn = isCloseBtn?true:false;
	var dlgObj = null;
	if (!type && type == ""){
		type = 'alert'
	}
	if(!ok && ok == ""){
		ok = null;
	}
	var optn = {
			showOk: isOkBtn,
			showCancel:isCancleBtn,
			showClose: isCloseBtn,
			title: headerTitle,//标题
			onopen:function(box){
				//alert('opened!');
				dlgObj = box;
			},
			onok:ok,
			type:type
		}
	$.weeboxs.open(
		message,
		optn
	);
	return dlgObj;
}

/**
对话框提示
*/
function confirmDlg(message,headerTitle,ok,cancle){
	 //
	var optn = {
			title: headerTitle,//标题
			onopen:function(box){
				//alert('opened!');
			},
			onclose:function(box){
				//alert('closed!');
			},
			onok:function(box){
				if ($.isFunction(ok)){
					ok(box);
				}
				box.close();//增加事件方法后需手动关闭弹窗
			},
			oncancel:function(box){
				
				if ($.isFunction(cancle)){
					cancle(box);
				}
				box.close();//增加事件方法后需手动关闭弹窗
			}
		}//optn
	$.weeboxs.open(message,
		optn
	);
}
//显示提示信息,一般在客户端验证出错时调用该方法
function jAlert(m){
	
	var c = f_getContent(m,1);
	return alertDlg(c,"提示信息:",true,false,false);
}
//显示警告提示信息
function jWarning(m){
	var c = f_getContent(m,5);
	return alertDlg(c,"警告信息:",true,false,false,"warning");
}
//显示成功提示信息
function jSuccess(m){
	var c = f_getContent(m,2);
	return alertDlg(c,"成功信息:",true,false,false,"success");
}
//显示失败提示信息
function jError(m,b){
	var c = f_getContent(m,3);
	return alertDlg(c,"错误信息:",true,false,false,"error",b);
}
//显示进度信息
function f_showPlan(m){
	var c = f_getContent(m,4);
	return alertDlg(c,"请稍候:",false,false,false);
}
function f_getContent(m,v){
	var i = '';
	var cl = '';
	switch(v){
		case 1 :
		i = "/images/warring.gif";
		cl = "class=\"alertText\"";
		break;
		case 2 :
		i = "/images/icon_right.gif";
		cl = "class=\"successText\"";
		break;
		case 3 :
		i = "/images/icon_wrong.gif";
		cl = "class=\"errorText\"";
		break;
		case 4 :
		i = "/images/loading.gif";
		cl = "class=\"loadText\"";
		break;
		case 5 :
		i = "/images/icon_wrong.gif";
		cl = "class=\"warningText\"";
	}
	var c = "<table align='center'>";
	c += "<tr>";
	c += "<td><b "+cl+">"+m+"</b></td>";
	c += "</tr>";
	c += "</table>";
	
	return c;
}
/*
//内容提交时跳转到下个节点

function toNextNode(nextNodeUrl)
{
	window.parent.location.href(nextNodeUrl);
}
//*/