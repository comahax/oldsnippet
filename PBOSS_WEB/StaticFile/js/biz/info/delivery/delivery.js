var plsQuery = false;
//elCell - 单元格对象(JQ),oRecord - 数据源,oData - 原数据,oColumnSet - 显示列对象 
//@@声用一定要在使用之前
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
		rtn = '<input type="button" name="btnModify" id="btnModify'+ name +'" value="修改状态"'+ Temp +' class="btn_blue" onclick="DisstateMdfone(\''+ oRecord.recid  +'\',this)" style="width:80px;">';
	}else if(oColumnSet.key=="createtime"){
		rtn = handlerdate(oData, 2);
	}else if(oColumnSet.key=="arrivetime"){
		rtn = handlerdate(oData, 2);
	}

	return rtn;
}
//表格刷新之后
var successFncn = function(jsonObj){
	if (jsonObj.datas.length > 0){
		setMdfBtn(false);//恢复屏蔽
	}
	changeStyle();
}

var openDtl=function(url){
	openDlg(url,"订单明细",800,600,true);
};

var doQuery = function() {
	// 创建时间>=不能为空
	if ($("#startDate").val() == ""){
		alert("请输入创建时间>=!");
		return;
	}
	// 创建时间<=不能为空
	if ($("#endDate").val() == ""){
		alert("请输入创建时间<=!");
		return;
	}
	var startdate = $("#startDate").val();
	var enddate = $("#endDate").val();
	if (startdate > enddate) {
		alert("“创建时间>=”必须早于“创建时间<=”!");
		return;
	}
	var cnt = DateDiff(startdate, enddate);
	if (cnt > 30) {
		alert("创建时间查询区间不能超过31天!");
		return;
	}
	
	//验证输入
//	if ($("#opnname").val() == ""){
//		alert("请输入业务名称!");
//		return;
//	}
//	//验证手机
//	var oprMobile = $("#mobile").val();
//	if (oprMobile != ""){
//		if (!f_isMobile(oprMobile)){
//			alert("人员手机号只能是移动手机号码!");
//			return;
//		}
//	}
	//封装提交参数
	setMdfBtn(true);//屏蔽按钮
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
			f_showEMsg("配送单号必须为数字");
			$("#recid").val("");
			return ;
		}
		if($("#recid").val().indexOf(".")>-1){
			f_showEMsg("配送单号号必须为整数");
			$("#recid").val("");
			return ;
		}
	}
	document.getElementById('frmQuery').action = "exportExcel.do"
	document.getElementById('frmQuery').target = "content";
	document.getElementById('frmQuery').submit();
}

var dlgThis,setIds;
//单条修改
var DisstateMdfone = function(id,btnObj){
	//置空全部
	$("input[name='recids']").each(function() {
		this.checked = false;
	});
	//选择当然
	$("#recids_"+id).attr("checked",true);
	//执行选择过程
	showDisstateMdf();
	//鼠标移开效果
	btnObj.className='btn_blue';
}
var showDisstateMdf = function(){
	//封装提交参数
	setMdfBtn(true);//屏蔽按钮
	var ids="",nonFirest=false;
	//验证选择
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
		alert("请选择需要修改状态的配送单!");
		setMdfBtn(false);//恢复屏蔽
		return;
	}
	setIds = ids;

	var optn = {
			showButton: false,
			showClose: true,
			title: "修改状态",//标题
			width:300,//宽度
			height:150,//高度
			onopen:function(box){
				dlgThis = box;
			},
			onclose:function(box){
				setMdfBtn(false);//恢复屏蔽
			},
			contentType:'selector'
		}
	$.weeboxs.open('#selDisstate',optn);

}
var closeDisstateMdf = function(){
	dlgThis.close();
	setMdfBtn(false);//恢复屏蔽
}
var doDisstateMdf = function() {
	//验证选择
	var disstate = $("input[name=parameter.disstate]:checked").val();
	if (!disstate || disstate==""){
		alert("请选择需要修改状态!");
		setMdfBtn(false);//恢复屏蔽
		return;
	}
	setMdfForm(setIds,disstate);
	dlgThis.close();//关闭选择对话框
	setMdfBtn(true);//屏蔽修改按钮
	var _o_li = f_showPlan("处理中，请稍候。")
	//AJAX提交
	var fromSuccuss = function(josnObj) {
		if (josnObj["isSuccess"]) {
			//修改成功
			alert("修改成功");
			//$("#disstate").val("");
			doQuery();
			setMdfForm("","");
		}else{
			alert(josnObj["message"]);
		}
		_o_li.close();
		setMdfBtn(false);//恢复屏蔽
	}//fromSuccuss
	//ajaxForm 配置
	var ajaxOpn = {
		dataType:'json',
		//url:formUrl,
		success:fromSuccuss
	}
	$("#frmModify").ajaxSubmit(ajaxOpn);
	//ajax
}
//批量修改按钮的属性
var setMdfBtn = function(setBln){
	$("#btnDisstate").attr("disabled",setBln);//屏蔽按钮
	$("#btnOpenDis").attr("disabled",setBln);//启动配送按钮
	$("#btnFinishDis").attr("disabled",setBln);//完成配送按钮
	$("#btnModify").attr("disabled",setBln);//屏蔽按钮
}
//设置修改Form的值
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
//启动配送方法
var doOpenDis =  function (){
	//状态检查
	var chk = chkDisState(WAITDIS);
	if (chk == 0 ){
		alert("请选择配送单!");
		return false;
	}else if (chk == -1) {
		alert("启动配送的配送单必须都是“待配送”状态!");
		return false;
	};

	//启动配送
	
	setMdfForm(setIds,DISING);
	doAJAXMdf("启动配送处理成功!");
}
//Ajax提交过程，msg为成功后提示的信息
var doAJAXMdf = function(msg){
	setMdfBtn(true);//屏蔽修改按钮
	var _o_li = f_showPlan("处理中，请稍候。")
	//AJAX提交
	var fromSuccuss = function(josnObj) {
		_o_li.close();
		if (josnObj["isSuccess"]) {
			//修改成功
			alert(msg);
			//$("#disstate").val("");
			doQuery();
			setMdfForm("","");
		}else{
			alert(josnObj["message"]);
			setMdfBtn(false);//恢复屏蔽
		}
	}//fromSuccuss
	//ajaxForm 配置
	var ajaxOpn = {
		dataType:'json',
		//url:formUrl,
		success:fromSuccuss
	}
	$("#frmModify").ajaxSubmit(ajaxOpn);
	//ajax
}

//完成配送方法
var doFinishDis = function(){
	//状态检查
	var chk = chkDisState(DISING);
	if (chk == 0 ){
		alert("请选择配送单!");
		return false;
	}else if (chk == -1) {
		alert("完成配送的配送单必须都是“配送中”状态!");
		return false;
	};
	//完成配送
	setMdfForm(setIds,DISOVER);
	doAJAXMdf("完成配送处理成功!");
}
//检查所选择的配送单状态，
// return : 1: 为正确的状态;-1: 为不正确的状态; 0: 没有记录
var chkDisState = function(state){
	var ids = '',nonFirst = false;
	setIds = '';
	var chkSucc=true,intAllSel=0;
	$("input[name='recids']").each(function() {   
		var thisObj = $(this);
		if (thisObj.attr("checked")) { //只考虑选中的情况
			intAllSel++;//记录选中的个数
			if (thisObj.attr("state") != state){
				chkSucc = false;
				return false;
			}else{
				//记录其ID
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
	//绑定按钮
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
	//生成日期下拉
//	getMouthSelect($("#selMonth"),3,true);
	getMouthSelect($("#selMonth"),3,true);
	//页面启动按钮
	queryBtn.attr("disabled",false);
	btnDisstate.attr("disabled",false);
	btnDisstate
	//打开页面默认查询
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
//子窗口关闭时，调用查询
function closePage(){//关闭
	//submitDlg.hide();
	submitDlg.close();
	if (plsQuery){		
		doQuery();
	}
}
