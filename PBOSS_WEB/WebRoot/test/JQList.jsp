<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
<%@ include file="/common/meta_allcss.jsp"%>
	</head>
	<body>
		<form name="fmQuery" id="fmQuery" action="test/ajaxQuery.do">
        	<input name="query" type="text" id="query" size="5" maxlength="5" />
        	 <input name="btnQuery" type="button" id="btnQuery" value="��ť" />
        </form>
		<div id="showTbl" style="width:600px;"></div>
        <div id="navigation"></div>
	</body>
</html>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/jquery.form.js" ></script> 
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.debug.js" ></script> 
<SCRIPT LANGUAGE="JavaScript">
<!--
// ��ѯ��ʾ����Ϣ
//var showCols = ${ShowCols}//ȡ��̨�����������飬��Ӧ����
var showCols = [{"dataKey":"code","key":"code","name":"code","width":"10%"},{"dataKey":"name","key":"name","name":"�û���","width":"20%"}]

	var doQuery = function() {
//		var ajaxOpn = { 
//			target:'#rslTbl',
//			dataType:'json',
//			success:function(josnObj) { 
//				if (!josnObj["isSuccess"]) {
//					alert(josnObj["message"]);
//					return;
//				}
//				//�������ö���
//				var optin = {
//					cols:cols,
//					showCols:showCols,
//					queryFrom: $("#fmQuery"),
//					datas:josnObj["datas"]
//				}
//				$("#showTbl").queryTable(optin);
//			}
//			
//		}; 
		//$("#fmQuery").ajaxSubmit(ajaxOpn);
		//alert(json.totalRecords)
				//�������ö���
				var optin = {
					//cols:cols,
					tableClass:"",//����CSS
					tHeadClass:"",//��ͷ��CSS
					tBodyClass:"",//����CSS
					showCols:showCols,//��ʾ��
					fmtLink:fmtLink,//�û��Զ��嵥Ԫ������
					pageNo:1,//�ֶ�����ҳ���ҳ�ڴ�С(ҳ��Ϊ��ʼ��ҳ��)
					pageSize:2,//ҳ�ڴ�С
					navigation:$("#navigation"),//��ҳλ�� jq����
					queryFrom: $("#fmQuery")//��ѯ��
				}
				$("#showTbl").queryTable(optin);
	}

	//elCell - ��Ԫ�����(JQ),oRecord - ����Դ,oData - ԭ����,oColumnSet - ��ʾ�ж���
	var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
		var rtn = oData;
	    if(oColumnSet.key=="id"){
			rtn = "<a href=\"Load.do?user.id="+ oData +"\" >"+ oData +"</a>";
		}
		if(oColumnSet.key=="name"){
			if(oRecord.code=='1')
				rtn="<font color='red'>"+oData +"</font>"
		}
		return rtn;
	}
	$(document).ready(function() { 
		//�󶨰�ť
		$("#btnQuery").click(doQuery);
	});
//-->
</SCRIPT>