<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript" src="/js/pub/json2.js"></script>
    
    <script language="JavaScript" type="text/JavaScript">
    function getElementByTabId(tabName){
	    return document.getElementById(tabName);
	}
    
	function ev_check() {
		addfield('param._sk_payee', '<s:text name="payee"/>', 'c', true, '128');
		return checkval(window);
	}
	
	function copyTabIdValue(src,dist){
		getElementByTabId(dist).value=getElementByTabId(src).value;
	}
	
	function compareValue(paramTab,hidTab){
		if(getElementByTabId(paramTab).value!=getElementByTabId(hidTab).value){
			return true;
		}
		return false;
	}

	function setBtnDisabled(tabId,state){
	    document.getElementById(tabId).disabled=state;
	}
	
	function chkSwitchflag(){
		var switchflag = getElementByTabId("_switchflag").value;
		if(switchflag=="open"){
			return true;
		}
		return false;
	}
	
	function doQueryList(url){
		setBtnDisabled("btnBatchDelete",false);
		setBtnDisabled("btnBatchSend",false);

		copyTabIdValue("param._se_optype","hid_se_optype");
		copyTabIdValue("param._sk_payee","hid_sk_payee");
		copyTabIdValue("param._sk_ltype","hid_sk_ltype");
		copyTabIdValue("param._sk_stype","hid_sk_stype");
		copyTabIdValue("param._se_paymonth","hid_se_paymonth");
		copyTabIdValue("param._sk_batch","hid_sk_batch");
		copyTabIdValue("param._se_pubpri","hid_se_pubpri");
		copyTabIdValue("param._se_calcmonth","hid_se_calcmonth");
		
		if(chkSwitchflag()){
		    copyTabIdValue("param._se_checkedflag","hid_se_checkedflag");
		    copyTabIdValue("param._se_upoprcode","hid_se_upoprcode");
		}

		getElementByTabId("resCounts").value = "-1";
		
		doQuery(url);
	}
	
	function doCheckDelete(cmdDelete){
		if(chkSwitchflag()){
			var checkedflag = getElementByTabId("param._se_checkedflag").value;
			if(checkedflag == "CHECKED"){
				alert("ֻ����ɾ��δ��˵����ݣ���������˱�ʶ������Ϊ'δ���'��");
				return false;
			}
		}

		doDelete(cmdDelete);
	}
	
	function doExport(url){
		// У���ѯ�����Ƿ�ı�
		var msg = checkQryParams();
		if(msg!=""){
			alert(msg);
			return;
		}
		
		formList.action = contextPath + url;
		formList.submit();
		formList.action = contextPath + "/payment/payment_list.do";
	}

	function doImport(){
		formList.action = "<%=contextPath%>/rewards/payment/batch.jsp";
  		formList.submit();
	}
	
	function checkQryParams(){
		if(compareValue("param._se_optype","hid_se_optype")){
			return "��ҵ�����͡������Ѹı䣬�����������������ѯ����ý��";
		}
		
		if(compareValue("param._sk_payee","hid_sk_payee")){
			return "���տλ�������Ѹı䣬�����������������ѯ����ý��";
		}
		
		if(compareValue("param._sk_ltype","hid_sk_ltype")){
			return "�������ࡿ�����Ѹı䣬�����������������ѯ����ý��";
		}
		
		if(compareValue("param._sk_stype","hid_sk_stype")){
			return "�����С�ࡿ�����Ѹı䣬�����������������ѯ����ý��";
		}
		
		if(compareValue("param._se_paymonth","hid_se_paymonth")){
			return "�������·ݡ������Ѹı䣬�����������������ѯ����ý��";
		}
		
		if(compareValue("param._sk_batch","hid_sk_batch")){
			return "�����Ρ������Ѹı䣬�����������������ѯ����ý��";
		}
		
		if(compareValue("param._se_pubpri","hid_se_pubpri")){
			msg="���Թ���˽�������Ѹı䣬�����������������ѯ����ý��";
		}
		
		if(compareValue("param._se_calcmonth","hid_se_calcmonth")){
			return "�������·ݡ������Ѹı䣬�����������������ѯ����ý��";
		}
		
		if(chkSwitchflag()){
			if(compareValue("param._se_checkedflag","hid_se_checkedflag")){
				return "����˱�ʶ�������Ѹı䣬�����������������ѯ����ý��";
			}
			
			if(compareValue("param._se_upoprcode","hid_se_upoprcode")){
				return "���ϴ����š������Ѹı䣬�����������������ѯ����ý��";
			}
		}
		
		return "";
	}

	// ����ɾ�����������͵ĵ�������
	function doShowModalDialog(cmdType,cmdBtn,cmdAction) {
		var msg = checkQryParams();
		if(msg!=""){
			alert(msg);
			return;
		}
		
		var optype = getElementByTabId("param._se_optype").value;
		var payee = getElementByTabId("param._sk_payee").value;
		var ltype = getElementByTabId("param._sk_ltype").value;
		var stype = getElementByTabId("param._sk_stype").value;
		var paymonth = getElementByTabId("param._se_paymonth").value;
		var batch = getElementByTabId("param._sk_batch").value;
		var pubpri = getElementByTabId("param._se_pubpri").value;
		var calcmonth = getElementByTabId("param._se_calcmonth").value;
		
		var checkedflag = "";
		var upoprcode = "";
		if(chkSwitchflag()){
			checkedflag = getElementByTabId("param._se_checkedflag").value;
			upoprcode = getElementByTabId("param._se_upoprcode").value;
		}
		
		// ������ѡ������������ɾ������
		if(optype==""&&payee==""&&ltype==""&&stype==""
				&&paymonth==""&&batch==""&&pubpri==""
				&&checkedflag==""&&upoprcode==""&&calcmonth==""){
			alert("��ѯ�������ܶ�Ϊ�գ�����ѡ�������������ѯ��");
			return;
		}
		
		var switchflag = getElementByTabId("_switchflag").value;
		if(switchflag=="open"&&cmdType=="batchSend"){
			if(checkedflag != "CHECKED"){
				alert("ֻ����������������˵����ݣ���������˱�ʶ������Ϊ����ˣ�");
				return;
			}	
		}
		
		// ��˿���δ��Ҳ������ɾ������˵�����
		if(cmdType=="batchDelete"&&checkedflag == "CHECKED"){
			alert("ֻ��������ɾ��δ��˵����ݣ���������˱�ʶ������Ϊ�ջ�δ��ˣ�");
			return;
		}
		
		var rowcount = getElementByTabId("_rowcount").value;
		if(rowcount == 0){
			alert("��ѯ���Ϊ�գ������������������ѯ��");
			return;
		}
		
		var resCounts = getElementByTabId("resCounts").value;
		if(resCounts == "-1"){
			return;
		}
		if(resCounts == 0){
			if(cmdType=="batchDelete"){
				alert("�ѷ��ͻ�����˵ļ�¼����ɾ�������ϴ������Ĳ�ѯ���Ϊ�գ������������������ѯ��");
			}
			
			if(cmdType=="batchSend"){
				alert("�ѷ��ͻ�δ��˵ļ�¼�����ٷ��ͣ����ϴ������Ĳ�ѯ���Ϊ�գ������������������ѯ��");
			}
			
			return;
		}
		
		if(cmdType=="batchSend"){
			if(rowcount > 200){
		    	alert("�������˵����ܳ���200������");
				return;
			}
		}
		
		var send = new Object();
		send.switchflag = switchflag;
		send.cmdType = cmdType;
        send.optype = optype;
        send.payee = payee;
        send.ltype = ltype;
        send.stype = stype;
        send.paymonth = paymonth;
        send.batch = batch;
        send.pubpri = pubpri;
        send.rowcount = rowcount;
        send.checkedflag = checkedflag;
        send.upoprcode = upoprcode;
        send.calcmonth = calcmonth;
        send.resCounts = resCounts;

        var dirurl = "<%=contextPath%>/rewards/payment/batchDelDialog.jsp";
        var ret = window.showModalDialog(dirurl,send,"dialogHeight:300px;dialogWidth:550px;status:no;help:no");
        if(ret == "ok"){
        	setBtnDisabled(cmdBtn,true);
			formList.action = contextPath + cmdAction;
		    formList.submit();
		}
	}
	
	function setAjaxParams(){
		var dataStr = "";
		var optype = getElementByTabId("param._se_optype").value;
		if(optype!=""){
			dataStr = dataStr + "'optype':'" + optype + "',";
		}

		var payee = getElementByTabId("param._sk_payee").value;
		if(payee!=""){
			dataStr = dataStr + "'payee':'" + payee + "',";
		}
		
		var ltype = getElementByTabId("param._sk_ltype").value;
		if(ltype!=""){
			dataStr = dataStr + "'ltype':'" + ltype + "',";
		}
		
		var stype = getElementByTabId("param._sk_stype").value;
		if(stype!=""){
			dataStr = dataStr + "'stype':'" + stype + "',";
		}
		
		var paymonth = getElementByTabId("param._se_paymonth").value;
		if(paymonth!=""){
			dataStr = dataStr + "'paymonth':'" + paymonth + "',";
		}
		
		var batch = getElementByTabId("param._sk_batch").value;
		if(batch!=""){
			dataStr = dataStr + "batch:'" + batch + "',";
		}
		
		var pubpri = getElementByTabId("param._se_pubpri").value;
		if(pubpri!=""){
			dataStr = dataStr + "'pubpri':'" + pubpri + "',";
		}
		
		var calcmonth = getElementByTabId("param._se_calcmonth").value;
		if(calcmonth!=""){
			dataStr = dataStr + "'calcmonth':'" + calcmonth + "',";
		}
		
		if(chkSwitchflag()){
			var checkedflag = getElementByTabId("param._se_checkedflag").value;
			if(checkedflag!=""){
				dataStr = dataStr + "'checkedflag':'" + checkedflag + "',";
			}
			
			var upoprcode = getElementByTabId("param._se_upoprcode").value;
			if(upoprcode!=""){
				dataStr = dataStr + "'upoprcode':'" + upoprcode + "',";
			}
		}

		if(dataStr!=""){
			dataStr = "{" + dataStr.substr(0,dataStr.length-1) + "}";
		}
		
		return dataStr;
	}
	
	function getDeleteCount(){
		var dataStr = setAjaxParams();
		if(dataStr == ""){
			alert("����ɾ���Ĳ�ѯ�������ܶ�Ϊ�գ�����ѡ������");
			return false;
		}
		
		jQuery.ajax({
			type:"POST",
			url:"<%=contextPath %>/payment/payment_batchDelQry.do",
			async:true,
			data:eval('(' + dataStr + ')'),
			//data:{optype:'����ҵ��',payee:'�ͨ��'},
			datatype:"json",
			//�ɹ�����֮����õĺ���  
			success: function(data){
				var msg = eval(data);
				getElementByTabId("resCounts").value = msg[0].counts;
			},
            //����ִ�к���õĺ���
            complete: function(XMLHttpRequest, textStatus){
                // alert(XMLHttpRequest.responseText);
                // alert(textStatus);
            },
            //���ó���ִ�еĺ���
            error: function(){
            }
		});
		
		return true;
	}
	
    function getSendCount(){
    	var dataStr = setAjaxParams();
    	if(dataStr == ""){
			alert("�������͵Ĳ�ѯ�������ܶ�Ϊ�գ�����ѡ������");
			return false;
		}
    	
		jQuery.ajax({
			type:"POST",
			url:"<%=contextPath %>/payment/payment_batchSendQry.do",
			async:true,
			data:eval('(' + dataStr + ')'),
			datatype:"text",
			//�ɹ�����֮����õĺ���  
			success: function(msg){
				getElementByTabId("resCounts").value = msg;
			},
            //����ִ�к���õĺ���
            complete: function(XMLHttpRequest, textStatus){
            },
            //���ó���ִ�еĺ���
            error: function(){
            }
		});
		
		return true;
	}
    
    function chkAjaxResCounts(cmdType,cmdBtn,cmdAction){
    	var resCounts = getElementByTabId("resCounts").value;
    	if(resCounts == "-1") {
        	setTimeout( function(){chkAjaxResCounts(cmdType,cmdBtn,cmdAction);}, 1000);
        }
        else {
        	doShowModalDialog(cmdType,cmdBtn,cmdAction);
        }
    }

	function doBatchDelete(cmdDelete) {
		getElementByTabId("resCounts").value = "-1";
		if(getDeleteCount()){
			chkAjaxResCounts("batchDelete","btnBatchDelete",cmdDelete);
		}
	}
	
	function doBatchSend(cmdSend) {
		getElementByTabId("resCounts").value = "-1";
		if(getSendCount()){
			var employeeNum = getElementByTabId("param._se_employeeNum").value;
		    if (employeeNum != null && "" != employeeNum) {
		    	chkAjaxResCounts("batchSend","btnBatchSend",cmdSend);
		    } else {
		    	alert("�����뱨��ƽ̨��Ա��Ϣ");
		    }
		}
	}
	
	function forincheck2(TO,sis){
		var count = 0;
	    if (sis != null) {
	        if (sis.length != null) {
	            for (var i = 0; i < sis.length; i++) {
	                var e = sis[i];
	                if (e.type == 'checkbox') {
	                    if (e.checked){
	                        TO = false;
	                        count=count+1;
	                    }
	                }
	            }
	        } else {
	            var e = sis;
	            if (e.type == 'checkbox') {
	            	if (e.checked){
                        TO = false;
                        count=count+1;
                    }
	            }
	        }
	    }

	    if (TO) {
	        alert(msgNoSelected);
	        return false;
	    }
	    
	    if(count == 0){
	    	alert("��ѡ��Ҫ���͵�����");
	    	return false;
	    }
	    
	    if(count > 200){
	    	alert("�������˵����ܳ���200������");
	    	return false;
	    }

	    var msg = "��ѡ" + count + "����¼���Ƿ��ͣ�"
	    if (!confirm(msg)) {
	        return false;
	    }
	    return true;
	}
	
	function doSend(cmd) {
		if(chkSwitchflag()){
			var checkedflag = getElementByTabId("param._se_checkedflag").value;
			if(checkedflag != "CHECKED"){
				alert("ֻ����������˵����ݣ������������˱�ʶ�Ĳ�ѯ����Ϊ'�����'��");
				return false;
			}
		}
		
	   var employeeNum = getElementByTabId("param._se_employeeNum").value;
	    if (employeeNum!=null && "" != employeeNum) {
	    	var TO = true;
		    var sis = formList.all("param._selectitem");
		    if (forincheck2(TO,sis)){
		    	formList.action = cmd;
	    		formList.submit();
		    }
	    } else {
	    	alert("�����뱨��ƽ̨��Ա��Ϣ");
	    }
	}
	
	//��ʼ��ִ��
	(function(){
		getElementByTabId("resCounts").value = "-1";
	})();

</script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();initBatchDelBtn();">
<div class="table_container">
<s:form action="payment_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//����Ŀؼ���Action�ṩ���ݣ�������ҳ%>
	<aa:zone name="hiddenZone">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
    <input type="hidden" name="_switchflag" value="<s:property value="switchflag" />"/>
    <input type="hidden" id="resCounts" name="resCounts" />
    </aa:zone>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="������"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
		</div>
	</div>
    
    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror />
			</table>
			<table class="message_text">
				<s:actionmessage/>
			</table>
		</div>
    </aa:zone>

	<div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="center"><s:text name="optype"/>:</td>
                <td align="left">
                    <j:selector name="param._se_optype" definition="LTYPEOPTYPE" />
                    <input type="hidden" name="hid_se_optype" />
                </td>
                <td align="center"><s:text name="payee"/>:</td>
                <td align="left">
                    <input type="text" id="param._sk_payee" name="param._sk_payee" value="<s:property value="param._sk_payee"/>" maxlength="128" />
                    <input type="hidden" name="hid_sk_payee" />
                </td>
            </tr>
            
            <tr>
                <td align="center"><s:text name="ltype"/>:</td>
                <td align="left">
                    <j:selector name="param._sk_ltype" definition="#LTYPE" />
                    <input type="hidden" name="hid_sk_ltype" />
                </td>
                <td align="center"><s:text name="stype"/>:</td>
                <td align="left">
                    <j:selector name="param._sk_stype" definition="#STYPE" />
                    <input type="hidden" name="hid_sk_stype" />
                </td>
             </tr>
             
             <tr>
                <td align="center"><s:text name="paymonth"/>:</td>
                <td align="left">
                    <input type="text" id="param._se_paymonth" name="param._se_paymonth" value="<s:property value="param._se_paymonth!=null?getText('format.date',{param._se_paymonth}):''"/>" onclick="selectDateYYYYMM();"/>
                    <input type="hidden" name="hid_se_paymonth" />
                </td>
                <td align="center"><s:text name="batch"/>:</td>
                <td align="left">
                    <input type="text" id="param._sk_batch" name="param._sk_batch" value="<s:property value="param._sk_batch"/>" maxlength="32" />
                    <input type="hidden" name="hid_sk_batch" />
                </td>
             </tr>
             
             <tr>
                <td align="center"><s:text name="pubpri"/>:</td>
                <td align="left">
                    <j:selector name="param._se_pubpri" definition="PUBPRI"/>
                    <input type="hidden" name="hid_se_pubpri" />
                </td>
                <td align="center"><s:text name="calcmonth"/>:</td>
                <td align="left">
                    <input type="text" id="param._se_calcmonth" name="param._se_calcmonth" value="<s:property value="param._se_calcmonth!=null?getText('format.date',{param._se_calcmonth}):''"/>" onclick="selectDateYYYYMM();"/>
                    <input type="hidden" name="hid_se_calcmonth" />
                </td>
             </tr>
            
             <s:if test="switchflag=='open'">
             <tr>
                 <td align="center"><s:text name="upoprcode"/>:</td>
                 <td align="left">
                     <input type="text" id="param._se_upoprcode" name="param._se_upoprcode" value="<s:property value="param._se_upoprcode"/>" maxlength="15" />
                     <!--<j:selector name="param._se_upoprcode" definition="#UPOPRCODE"/>  -->
                     <input type="hidden" name="hid_se_upoprcode" />
                 </td>
                 <td align="center"><s:text name="checkedflag"/>:</td>
                 <td align="left">
                     <j:selector name="param._se_checkedflag" definition="CHECKEDFLAG"/>
                     <input type="hidden" name="hid_se_checkedflag" />
                 </td>
             </tr>
             </s:if>
        </table>
    </div>
    
    <div class="table_div">
        <table class="table_normal">
        	<tr>
                <td align="center"><s:text name="employeeNum"/>:</td>
                <td align="left">
                    <j:selector name="param._se_employeeNum" definition="#CHCWEMPLOYEE" />
                </td>
            </tr>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
				    <s:i18n name="public">
                	<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_search"/>" onClick="doQueryList('/payment/payment_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/payment/payment_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doCheckDelete('/payment/payment_delete.do')">
                    
                    <input type="button" id="btnBatchDelete" name="btnBatchDelete" class="button_2" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_batchdelete"/>" onClick="doBatchDelete('/payment/payment_batchDelete.do')">
                    
                    <input type="button" id="btnExport" name="btnExport"
						class="button_4" onmouseover="buttonover(this);"
						onmouseout="buttonout(this);" onfocus="buttonover(this)"
						onblur="buttonout(this)"
						value="<s:text name="button_exportexcel"/>"
						onClick="doExport('/payment/payment_exportExcel.do')">
										
                    <input type="button" id="btnBatch" name="btnBatch"
						class="button_2" onmouseover="buttonover(this);"
						onmouseout="buttonout(this);" onfocus="buttonover(this)"
						onblur="buttonout(this)" value="��������" onClick="doImport();">
                   
                    <input type="button" id="btnSend" name="btnSend" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_send"/>" onClick="doSend('/payment/payment_send.do')">
                    
                    <input type="button" id="btnBatchSend" name="btnBatchSend" class="button_2" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_batchsend"/>" onClick="doBatchSend('/payment/payment_batchsend.do')">
                   </s:i18n>
				</td>
			</tr>
		</table>
	</div>
	
	<div class="table_div">
        
    </div>

	<aa:zone name="listZone">
    <div class="table_div">
        <s:if test="amounts != '-1.0'">
            <table class="table_normal">
        	    <tr>
                    <td align="center" width="10%"><s:text name="amounts"/>:</td>
                    <td align="left">
                        <s:property value="amounts"/>
                    </td>
                </tr>
            </table>
        </s:if>
        
    	<div class="table_LongTable">
        <table class="table_style">
            <tr class="table_style_head" align="left">
               	<s:i18n name="public">
                <td title="<s:text name="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();"/>
                </td>
                </s:i18n>
                <td>
                    <j:orderByImg href="javascript:doOrderby('optype')"><s:text name="optype"/></j:orderByImg>                 
                </td>
                <td>
					<j:orderByImg href="javascript:doOrderby('ltype')"><s:text name="ltype"/></j:orderByImg> 
				</td>
				<td>
                    <j:orderByImg href="javascript:doOrderby('stype')"><s:text name="stype"/></j:orderByImg>                 
                </td>
                <td>
					<j:orderByImg href="javascript:doOrderby('payee')"><s:text name="payee"/></j:orderByImg> 
				</td>
				<td>
					<j:orderByImg href="javascript:doOrderby('bkactname')"><s:text name="bkactname"/></j:orderByImg> 
				</td>
                <td>
					<j:orderByImg href="javascript:doOrderby('bank')"><s:text name="bank"/></j:orderByImg> 
				</td>
				<td align="left">
                    <j:orderByImg href="javascript:doOrderby('depositbank')"><s:text name="depositbank"/></j:orderByImg>                 
                </td>
                 <td>
                    <j:orderByImg href="javascript:doOrderby('account')"><s:text name="account"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('billnumber')"><s:text name="billnumber"/></j:orderByImg>                 
                </td>
                 <td>
                    <j:orderByImg href="javascript:doOrderby('countyid')"><s:text name="countyid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('paymonth')"><s:text name="paymonth"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('paysum')"><s:text name="paysum"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('batch')"><s:text name="batch"/></j:orderByImg>                 
                </td>
                <td><s:text name="pubpri"/></td>
                <td><s:text name="note"/></td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('calcmonth')"><s:text name="calcmonth"/></j:orderByImg>                 
                </td>
                
                <s:if test="switchflag=='open'">
                    <td><s:text name="upoprcode"/></td>
                    <td><s:text name="checkedflag"/></td>
                </s:if>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- ���������á�|������� --%>
                     <s:if test="sendstate=='SENT'">
                         <td title="�ü�¼�ѷ��ͣ�����ɾ��/����">
                             <input type="checkbox" name="param._selectitem" disabled="disabled">
                         </td>
                     </s:if>
			         <s:else>
			             <td>
			                 <input type="checkbox" name="param._selectitem" value="<s:property value="seq"/>_<s:property value="checkedflag"/>" onclick="checkOne();">
			             </td>
			         </s:else>
                     
                     <td>
                         <a href='<s:url action="payment_edit.do"><s:param name="param._pk" value="seq"/></s:url>'>
                             <s:property value="optype" />
					     </a>
					 </td>

					 <td><s:property value="ltype"/></td> 
                     <td><s:property value="stype"/></td>
					 <td><s:property value="payee"/></td>
					 <td><s:property value="bkactname"/></td>
					 <td><s:property value="bank"/></td>
					 <td><s:property value="depositbank"/></td>
					 
					 <td><s:property value="account"/></td> 
					 <td><s:property value="billnumber"/></td>
					 <td><s:property value="countyid"/></td>
                     <td><s:property value="paymonth"/></td>
                     <td><s:property value="paysum"/></td>
					 <td><s:property value="batch"/></td>
					 <td><s:property value="pubpri"/></td>
                     <td><s:property value="note"/></td>
                     <td><s:property value="calcmonth"/></td>
                     <s:if test="switchflag=='open'">
                         <td><s:property value="upoprcode"/></td>
                         <td><j:code2Name definition="CHECKEDFLAG" code="checkedflag"/></td>
                     </s:if>
                 </tr>
             </s:iterator>
        </table>
        </div>
    </div>
    <div class="table_div">
		<%@ include file="/common/pageNav.jsp"%>
   	</div>
    </aa:zone>
</s:form>
</div>
</body>
</html>
<script language="javascript">
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();  
	ajaxAnywhere.formURL = formList.action;
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
