//�ύʱ�����ύ�Ի���
//@author Jimmy

var submitDlg;
function saveInDlg(frmObj,headerTitle,widthDlg,heightDlg,isCloseBtn){
	 //
	 submitDlg = null;
	isCloseBtn = isCloseBtn?true:false;
	if(widthDlg==undefined){//��ʾ���ڿ��
		widthDlg=600;
	}
	if(heightDlg==undefined){//��ʾ���ڸ߶�
		heightDlg=300;
	}

	var optn = {
			showButton: false,
			showClose: isCloseBtn,
			title: headerTitle,//����
			width:widthDlg,//���
			height:heightDlg,//�߶�
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
	//����Panelʱ�޸���target
	frmObj.target='jqDlgForm';
}

/**
*�򿪶Ի���,
URL:ֻ�ܰ�ȫ·����ת
*/
var jqDlgJumpUrl = "";
function openDlg(url,headerTitle,widthDlg,heightDlg,isCloseBtn){
	 //
	 jqDlgJumpUrl = ""
	 submitDlg = null;
	isCloseBtn = isCloseBtn?true:false;
	if(widthDlg==undefined){//��ʾ���ڿ��
		widthDlg=600;
	}
	if(heightDlg==undefined){//��ʾ���ڸ߶�
		heightDlg=300;
	}

	var optn = {
			showButton: false,
			showClose: isCloseBtn,
			title: headerTitle,//����
			width:widthDlg,//���
			height:heightDlg,//�߶�
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



function refreshPage(){//ˢ��
	window.location.reload();
}

function closePage(){//�ر�
	//submitDlg.hide();
	submitDlg.close();
}

/**
�Ի�����ʾ
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
			title: headerTitle,//����
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
�Ի�����ʾ
*/
function confirmDlg(message,headerTitle,ok,cancle){
	 //
	var optn = {
			title: headerTitle,//����
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
				box.close();//�����¼����������ֶ��رյ���
			},
			oncancel:function(box){
				
				if ($.isFunction(cancle)){
					cancle(box);
				}
				box.close();//�����¼����������ֶ��رյ���
			}
		}//optn
	$.weeboxs.open(message,
		optn
	);
}
//��ʾ��ʾ��Ϣ,һ���ڿͻ�����֤����ʱ���ø÷���
function jAlert(m){
	
	var c = f_getContent(m,1);
	return alertDlg(c,"��ʾ��Ϣ:",true,false,false);
}
//��ʾ������ʾ��Ϣ
function jWarning(m){
	var c = f_getContent(m,5);
	return alertDlg(c,"������Ϣ:",true,false,false,"warning");
}
//��ʾ�ɹ���ʾ��Ϣ
function jSuccess(m){
	var c = f_getContent(m,2);
	return alertDlg(c,"�ɹ���Ϣ:",true,false,false,"success");
}
//��ʾʧ����ʾ��Ϣ
function jError(m,b){
	var c = f_getContent(m,3);
	return alertDlg(c,"������Ϣ:",true,false,false,"error",b);
}
//��ʾ������Ϣ
function f_showPlan(m){
	var c = f_getContent(m,4);
	return alertDlg(c,"���Ժ�:",false,false,false);
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
//�����ύʱ��ת���¸��ڵ�

function toNextNode(nextNodeUrl)
{
	window.parent.location.href(nextNodeUrl);
}
//*/