var plsQuery = false;
//elCell - ��Ԫ�����(JQ),oRecord - ����Դ,oData - ԭ����,oColumnSet - ��ʾ�ж��� 
//@@����һ��Ҫ��ʹ��֮ǰ
var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
	var rtn = oData;
	var Temp;
	if(oColumnSet.key=="orderid"){
		rtn = "<a href=\"javascript:openDtl('"+ contextRootPath +"/delivery/detail.do?recid="+ oRecord.recid   +"');\" >"+ oData +"</a>";
	}else if(oColumnSet.key=="recid"){
		rtn = "<a href=\"javascript:openDtl('"+ contextRootPath +"/delivery/detail.do?recid="+ oRecord.recid   +"');\" >"+ oData +"</a>";
	}else if(oColumnSet.key=="sel"){
		var canModify = isInArray(oRecord.disstate ,nonShow);
		if (canModify){
			Temp = ' disabled="true"'
		}else{
			Temp = '';
		}
		rtn = '<input type="checkbox" name="recids" id="recids_'+ oRecord.recid +'" value="'+ oRecord.recid  +'"'+ Temp +' state="'+ oRecord.disstate +'">';
	}else if(oColumnSet.key=="oper"){
		var canModify = isInArray(oRecord.disstate ,nonShow);
		var name;
		if (canModify){
			Temp = ' disabled="true"';
			name = '_none';
		}else{
			Temp = '';name='';
		}
		rtn = '<input type="button" name="btnModify" id="btnModify'+ name +'" value="�޸�״̬"'+ Temp +' class="btn_blue" onclick="DisstateMdfone(\''+ oRecord.recid  +'\',this)" style="width:80px;">';
	}else if(oColumnSet.key=="createtime"){
		rtn = handlerdate(oData, 2);
	}else if(oColumnSet.key=="arrivetime"){
		rtn = handlerdate(oData, 2);
	}

	return rtn;
}
//���ˢ��֮��
var successFncn = function(jsonObj){
	if (jsonObj.datas.length > 0){
		setMdfBtn(false);//�ָ�����
	}
	changeStyle();
}

var openDtl=function(url){
	openDlg(url,"������ϸ",800,600,true);
};

var doQuery = function() {
	// ����ʱ��>=����Ϊ��
	if ($("#startDate").val() == ""){
		alert("�����봴��ʱ��>=!");
		return;
	}
	// ����ʱ��<=����Ϊ��
	if ($("#endDate").val() == ""){
		alert("�����봴��ʱ��<=!");
		return;
	}
	var startdate = $("#startDate").val();
	var enddate = $("#endDate").val();
	if (startdate > enddate) {
		alert("������ʱ��>=���������ڡ�����ʱ��<=��!");
		return;
	}
	var cnt = DateDiff(startdate, enddate);
	if (cnt > 30) {
		alert("����ʱ���ѯ���䲻�ܳ���31��!");
		return;
	}
	
	//��֤����
//	if ($("#opnname").val() == ""){
//		alert("������ҵ������!");
//		return;
//	}
//	//��֤�ֻ�
//	var oprMobile = $("#mobile").val();
//	if (oprMobile != ""){
//		if (!f_isMobile(oprMobile)){
//			alert("��Ա�ֻ���ֻ�����ƶ��ֻ�����!");
//			return;
//		}
//	}
	//��װ�ύ����
	setMdfBtn(true);//���ΰ�ť
	$("#showTbl").queryTable(optin);
}
function DateDiff(sDate1, sDate2){  //sDate1 and sDate2 is string
	var aDate, oDate1, oDate2, iDays;
	aDate = sDate1.replace(/-/g, "/");
	oDate1 = new Date(aDate); //change to date
	aDate = sDate2.replace(/-/g, "/");
	oDate2 = new Date(aDate);
	iDays = parseInt(Math.abs(oDate1 - oDate2)/1000/60/60/24);  //day
	return iDays;
}
function f_exportExcel(){
	if($("#recid").val()!=""){
		if(isNaN($("#recid").val())){
			f_showEMsg("���͵��ű���Ϊ����");
			$("#recid").val("");
			return ;
		}
		if($("#recid").val().indexOf(".")>-1){
			f_showEMsg("���͵��źű���Ϊ����");
			$("#recid").val("");
			return ;
		}
	}
	document.getElementById('frmQuery').action = "exportExcel.do"
	document.getElementById('frmQuery').target = "content";
	document.getElementById('frmQuery').submit();
}

var dlgThis,setIds;
//�����޸�
var DisstateMdfone = function(id,btnObj){
	//�ÿ�ȫ��
	$("input[name='recids']").each(function() {
		this.checked = false;
	});
	//ѡ��Ȼ
	$("#recids_"+id).attr("checked",true);
	//ִ��ѡ�����
	showDisstateMdf();
	//����ƿ�Ч��
	btnObj.className='btn_blue';
}
var showDisstateMdf = function(){
	//��װ�ύ����
	setMdfBtn(true);//���ΰ�ť
	var ids="",nonFirest=false;
	//��֤ѡ��
	var selSum=0;
	$("input[name='recids']").each(function() {    
		var thisObj = $(this);
		if (thisObj.attr("checked")) {
			selSum++;
			ids +=(nonFirest?",":"") + thisObj.val();
			nonFirest=true;
		}
		thisObj = null;
	});
	if (selSum<=0){
		alert("��ѡ����Ҫ�޸�״̬�����͵�!");
		setMdfBtn(false);//�ָ�����
		return;
	}
	setIds = ids;

	var optn = {
			showButton: false,
			showClose: true,
			title: "�޸�״̬",//����
			width:300,//���
			height:150,//�߶�
			onopen:function(box){
				dlgThis = box;
			},
			onclose:function(box){
				setMdfBtn(false);//�ָ�����
			},
			contentType:'selector'
		}
	$.weeboxs.open('#selDisstate',optn);

}
var closeDisstateMdf = function(){
	dlgThis.close();
	setMdfBtn(false);//�ָ�����
}
var doDisstateMdf = function() {
	//��֤ѡ��
	var disstate = $("input[name=parameter.disstate]:checked").val();
	if (!disstate || disstate==""){
		alert("��ѡ����Ҫ�޸�״̬!");
		setMdfBtn(false);//�ָ�����
		return;
	}
	setMdfForm(setIds,disstate);
	dlgThis.close();//�ر�ѡ��Ի���
	setMdfBtn(true);//�����޸İ�ť
	var _o_li = f_showPlan("�����У����Ժ�")
	//AJAX�ύ
	var fromSuccuss = function(josnObj) {
		if (josnObj["isSuccess"]) {
			//�޸ĳɹ�
			alert("�޸ĳɹ�");
			//$("#disstate").val("");
			doQuery();
			setMdfForm("","");
		}else{
			alert(josnObj["message"]);
		}
		_o_li.close();
		setMdfBtn(false);//�ָ�����
	}//fromSuccuss
	//ajaxForm ����
	var ajaxOpn = {
		dataType:'json',
		//url:formUrl,
		success:fromSuccuss
	}
	$("#frmModify").ajaxSubmit(ajaxOpn);
	//ajax
}
//�����޸İ�ť������
var setMdfBtn = function(setBln){
	$("#btnDisstate").attr("disabled",setBln);//���ΰ�ť
	$("#btnOpenDis").attr("disabled",setBln);//�������Ͱ�ť
	$("#btnFinishDis").attr("disabled",setBln);//������Ͱ�ť
	$("#btnModify").attr("disabled",setBln);//���ΰ�ť
}
//�����޸�Form��ֵ
var setMdfForm = function(ids,disstate){
	$("#frmModify > input").each(function() {
		var thisObj = $(this);
		if (thisObj.attr("name")=='parameter.recids'){
			thisObj.val(ids);
		}else if (thisObj.attr("name")=='parameter.disstate'){
			thisObj.val(disstate);
		}
	});
}
//�������ͷ���
var doOpenDis =  function (){
	//״̬���
	var chk = chkDisState(WAITDIS);
	if (chk == 0 ){
		alert("��ѡ�����͵�!");
		return false;
	}else if (chk == -1) {
		alert("�������͵����͵����붼�ǡ������͡�״̬!");
		return false;
	};

	//��������
	
	setMdfForm(setIds,DISING);
	doAJAXMdf("�������ʹ���ɹ�!");
}
//Ajax�ύ���̣�msgΪ�ɹ�����ʾ����Ϣ
var doAJAXMdf = function(msg){
	setMdfBtn(true);//�����޸İ�ť
	var _o_li = f_showPlan("�����У����Ժ�")
	//AJAX�ύ
	var fromSuccuss = function(josnObj) {
		_o_li.close();
		if (josnObj["isSuccess"]) {
			//�޸ĳɹ�
			alert(msg);
			//$("#disstate").val("");
			doQuery();
			setMdfForm("","");
		}else{
			alert(josnObj["message"]);
			setMdfBtn(false);//�ָ�����
		}
	}//fromSuccuss
	//ajaxForm ����
	var ajaxOpn = {
		dataType:'json',
		//url:formUrl,
		success:fromSuccuss
	}
	$("#frmModify").ajaxSubmit(ajaxOpn);
	//ajax
}

//������ͷ���
var doFinishDis = function(){
	//״̬���
	var chk = chkDisState(DISING);
	if (chk == 0 ){
		alert("��ѡ�����͵�!");
		return false;
	}else if (chk == -1) {
		alert("������͵����͵����붼�ǡ������С�״̬!");
		return false;
	};
	//�������
	setMdfForm(setIds,DISOVER);
	doAJAXMdf("������ʹ���ɹ�!");
}
//�����ѡ������͵�״̬��
// return : 1: Ϊ��ȷ��״̬;-1: Ϊ����ȷ��״̬; 0: û�м�¼
var chkDisState = function(state){
	var ids = '',nonFirst = false;
	setIds = '';
	var chkSucc=true,intAllSel=0;
	$("input[name='recids']").each(function() {   
		var thisObj = $(this);
		if (thisObj.attr("checked")) { //ֻ����ѡ�е����
			intAllSel++;//��¼ѡ�еĸ���
			if (thisObj.attr("state") != state){
				chkSucc = false;
				return false;
			}else{
				//��¼��ID
				ids +=(nonFirst?",":"") + thisObj.val();
				nonFirst = true;
			}
		}//if
	});//
	if (intAllSel < 1 )	return 0;
	if (chkSucc){
		setIds = ids;
		return 1;
	}else {
		return -1;
	}
}
//
$(document).ready(function() { 
	initDate("startDate");
	initDate("endDate");
	//�󶨰�ť
	dTable = getTable($("#showTbl"),optin);
	var _tBodyMark = dTable.find("#jqTblBodyMark tr td");
	_tBodyMark.hide();
	var queryBtn = $("#btnQuery");
	queryBtn.click(doQuery);
	$("#btnExport").click(f_exportExcel);
	var btnDisstate = $("#btnDisstate");
	var btnOpenDis = $("#btnOpenDis");
	var btnFinishDis = $("#btnFinishDis");
//	btnDisstate.click(doDisstateMdf);

	btnDisstate.click(showDisstateMdf);
	btnOpenDis.click(doOpenDis);
	btnFinishDis.click(doFinishDis);
	//������������
//	getMouthSelect($("#selMonth"),3,true);
	getMouthSelect($("#selMonth"),3,true);
	//ҳ��������ť
	queryBtn.attr("disabled",false);
	btnDisstate.attr("disabled",false);
	btnDisstate
	//��ҳ��Ĭ�ϲ�ѯ
	doQuery();
});

var changeStyle = function(){
	$('#showTbl .btn_blue').hover(function() {
		this.className='btn_blue_02';
	}, function() {
		this.className='btn_blue';
	}
	);
}
//�Ӵ��ڹر�ʱ�����ò�ѯ
function closePage(){//�ر�
	//submitDlg.hide();
	submitDlg.close();
	if (plsQuery){		
		doQuery();
	}
}
