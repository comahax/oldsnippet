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
		
		copyTabIdValue("param._se_wayid","hid_se_wayid");
		copyTabIdValue("param._se_calcmonth","hid_se_calcmonth");
		copyTabIdValue("param._se_paymonth","hid_se_paymonth");
		copyTabIdValue("param._se_optype","hid_se_optype");
		copyTabIdValue("param._sk_ltype","hid_sk_ltype");
		copyTabIdValue("param._sk_stype","hid_sk_stype");

		copyTabIdValue("param._se_mobile","hid_se_mobile");
		copyTabIdValue("param._se_imei","hid_se_imei");

		if(chkSwitchflag()){
		    copyTabIdValue("param._se_checkedflag","hid_se_checkedflag");
		    copyTabIdValue("param._se_upoprcode","hid_se_upoprcode");
		}
		
		getElementByTabId("resCounts").value = "-1";
		
		doQuery(url);
	}
	
	function checkQryParams(){
		if(compareValue("param._se_wayid","hid_se_wayid")){
			return "【渠道编码】条件已改变，请重设条件点击【查询】获得结果";
		}
		
		if(compareValue("param._se_calcmonth","hid_se_calcmonth")){
			return "【结算月份】条件已改变，请重设条件点击【查询】获得结果";
		}
		
		if(compareValue("param._se_optype","hid_se_optype")){
			return "【业务类型】条件已改变，请重设条件点击【查询】获得结果";
		}
		
		if(compareValue("param._sk_ltype","hid_sk_ltype")){
			return "【酬金大类】条件已改变，请重设条件点击【查询】获得结果";
		}
		
		if(compareValue("param._sk_stype","hid_sk_stype")){
			return "【酬金小类】条件已改变，请重设条件点击【查询】获得结果";
		}
		
		if(compareValue("param._se_paymonth","hid_se_paymonth")){
			return "【付款月份】条件已改变，请重设条件点击【查询】获得结果";
		}
		
		if(compareValue("param._se_mobile","hid_se_mobile")){
			return "【手机号码】条件已改变，请重设条件点击【查询】获得结果";
		}
		
		if(compareValue("param._se_imei","hid_se_imei")){
			return "【IMEI号】条件已改变，请重设条件点击【查询】获得结果";
		}
		
		if(chkSwitchflag()){
			if(compareValue("param._se_checkedflag","hid_se_checkedflag")){
				return "【审核标识】条件已改变，请重设条件点击【查询】获得结果";
			}
			
			if(compareValue("param._se_upoprcode","hid_se_upoprcode")){
				return "【上传工号】条件已改变，请重设条件点击【查询】获得结果";
			}
		}
		
		return "";
	}

	function doExport(url){
		// 校验查询条件是否改变
		var msg = checkQryParams();
		if(msg!=""){
			alert(msg);
			return;
		}
		
		formList.action = contextPath + url;
		formList.submit();
		formList.action = contextPath + "/paymentsc/paymentsc_list.do";
	}

	function doImport(){
		formList.action = "<%=contextPath%>/rewards/paymentsc/batch.jsp";
  		formList.submit();
	}

	// 批量删除的弹出窗口
	function doShowModalDialog(cmdType,cmdBtn,cmdAction) {
		var msg = checkQryParams();
		if(msg!=""){
			alert(msg);
			return;
		}
		var wayid = getElementByTabId("param._se_wayid").value;
		var calcmonth = getElementByTabId("param._se_calcmonth").value;
		var paymonth = getElementByTabId("param._se_paymonth").value;
		var optype = getElementByTabId("param._se_optype").value;
		var ltype = getElementByTabId("param._sk_ltype").value;
		var stype = getElementByTabId("param._sk_stype").value;
		
		var mobile = getElementByTabId("param._se_mobile").value;
		var imei = getElementByTabId("param._se_imei").value;

		var checkedflag = "";
		var upoprcode = "";
		if(chkSwitchflag()){
			checkedflag = getElementByTabId("param._se_checkedflag").value;
			upoprcode = getElementByTabId("param._se_upoprcode").value;
		}
		
		// 不允许不选择条件做整表删除或发送
		if(wayid==""&&calcmonth==""&&optype==""
				&&ltype==""&&stype==""&&paymonth==""
				&&checkedflag==""&&upoprcode==""
				&&mobile==""&&imei==""){
			alert("查询条件不能都为空，请先选择条件点击【查询】");
			return;
		}
		
		var switchflag = getElementByTabId("_switchflag").value;
		// 审核开关未打开也不允许删除已审核的数据
		if(cmdType == "batchDelete" && checkedflag == "CHECKED"){
			alert("只允许批量删除未审核的数据，请设置审核标识的条件为空或未审核！");
			return;
		}
		
		var rowcount = getElementByTabId("_rowcount").value;
		if(rowcount == 0){
			alert("查询结果为空，请重设条件点击【查询】");
			return;
		}
		
		var resCounts = getElementByTabId("resCounts").value;
		if(resCounts == "-1"){
			return;
		}
		if(resCounts == 0){
			if(cmdType=="batchDelete"){
				alert("已审核的记录不可删除；符合此条件的查询结果为空，请重设条件点击【查询】");
			}
			return;
		}
		
		var send = new Object();
		send.switchflag = switchflag;
		send.cmdType = cmdType;
        send.wayid = wayid;
        send.calcmonth = calcmonth;
        send.optype = optype;
        send.ltype = ltype;
        send.stype = stype;
        send.paymonth = paymonth;
        send.checkedflag = checkedflag;
        send.upoprcode = upoprcode;
        send.mobile = mobile;
        send.imei = imei;
        
        send.rowcount = rowcount;
        send.resCounts = resCounts;

        var dirurl = "<%=contextPath%>/rewards/paymentsc/batchDelDialog.jsp";
        var ret = window.showModalDialog(dirurl,send,"dialogHeight:300px;dialogWidth:550px;status:no;help:no");
        if(ret == "ok"){
        	setBtnDisabled(cmdBtn,true);
			formList.action = contextPath + cmdAction;
		    formList.submit();
		}
	}
	
	function setAjaxParams(){
		var dataStr = "";
		
		var wayid = getElementByTabId("param._se_wayid").value;
		if(wayid!=""){
			dataStr = dataStr + "'wayid':'" + wayid + "',";
		}
		
		var calcmonth = getElementByTabId("param._se_calcmonth").value;
		if(calcmonth!=""){
			dataStr = dataStr + "'calcmonth':'" + calcmonth + "',";
		}
		
		var optype = getElementByTabId("param._se_optype").value;
		if(optype!=""){
			dataStr = dataStr + "'optype':'" + optype + "',";
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
		
		var mobile = getElementByTabId("param._se_mobile").value;
		if(mobile!=""){
			dataStr = dataStr + "'mobile':'" + mobile + "',";
		}
		
		var imei = getElementByTabId("param._se_imei").value;
		if(imei!=""){
			dataStr = dataStr + "'imei':'" + imei + "',";
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
			dataStr="{" + dataStr.substr(0,dataStr.length-1) + "}";
		}
		
		return dataStr;
	}
	
	function getDeleteCount(){
		var dataStr = setAjaxParams();
		if(dataStr == ""){
			alert("批量删除的查询条件不能都为空，请先选择条件");
			return false;
		}
		
		jQuery.ajax({
			type:"POST",
			url:"<%=contextPath %>/paymentsc/paymentsc_batchDelQry.do",
			async:true,
			data:eval('(' + dataStr + ')'),
			datatype:"json",
			//成功返回之后调用的函数  
			success: function(data){
				var msg = eval(data);
				getElementByTabId("resCounts").value = msg[0].counts;
			},
            //调用执行后调用的函数
            complete: function(XMLHttpRequest, textStatus){
                // alert(XMLHttpRequest.responseText);
                // alert(textStatus);
            },
            //调用出错执行的函数
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
	    	alert("请选择要删除的数据");
	    	return false;
	    }
	    
	    var msg = "已选" + count + "条记录，是否删除？"
	    if (!confirm(msg)) {
	        return false;
	    }
	    return true;
	}
	
	function doCheckDelete(cmdDelete){
		if(chkSwitchflag()){
			var checkedflag = getElementByTabId("param._se_checkedflag").value;
			if(checkedflag == "CHECKED"){
				alert("只允许删除未审核的数据，请设置审核标识的条件为'未审核'！");
				return false;
			}
		}
		
		var TO = true;
	    var sis = formList.all("param._selectitem");
	    if (forincheck2(TO,sis)){
	    	formList.action = cmdDelete;
    		formList.submit();
	    }
	}

	//初始化执行
	(function(){
		getElementByTabId("resCounts").value = "-1";
	})();

</script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();initBatchDelBtn();">
<div class="table_container">
<s:form action="paymentsc_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
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
			<span class="table_toparea"><s:text name="酬金管理"/> </span>
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
                <td align="right"><s:text name="wayid"/>:&nbsp;</td>
                <td align="left">
                    <j:selector name="param._se_wayid" definition="#WAYIDINFO" />
                    <input type="hidden" name="hid_se_wayid" />
                </td>
                <td align="right"><s:text name="optype"/>:&nbsp;</td>
                <td align="left">
                    <j:selector name="param._se_optype" definition="LTYPEOPTYPE" />
                    <input type="hidden" name="hid_se_optype" />
                </td>
            </tr>
            
            <tr>
                <td align="right"><s:text name="calcmonth"/>:&nbsp;</td>
                <td align="left">
                    <input type="text" id="param._se_calcmonth" name="param._se_calcmonth" value="<s:property value="param._se_calcmonth!=null?getText('format.date',{param._se_calcmonth}):''"/>" onclick="selectDateYYYYMM();"/>
                    <input type="hidden" name="hid_se_calcmonth" />
                </td>
                <td align="right"><s:text name="paymonth"/>:&nbsp;</td>
                <td align="left">
                    <input type="text" id="param._se_paymonth" name="param._se_paymonth" value="<s:property value="param._se_paymonth!=null?getText('format.date',{param._se_paymonth}):''"/>" onclick="selectDateYYYYMM();"/>
                    <input type="hidden" name="hid_se_paymonth" />
                </td>
            </tr>
             
            <tr>
                <td align="right"><s:text name="ltype"/>:&nbsp;</td>
                <td align="left">
                    <j:selector name="param._sk_ltype" definition="#LTYPE" />
                    <input type="hidden" name="hid_sk_ltype" />
                </td>
                <td align="right"><s:text name="stype"/>:&nbsp;</td>
                <td align="left">
                    <j:selector name="param._sk_stype" definition="#STYPE" />
                    <input type="hidden" name="hid_sk_stype" />
                </td>
            </tr>
            
            <tr>
                <td align="right"><s:text name="mobile"/>:&nbsp;</td>
                <td align="left">
                    <input type="text" id="param._se_mobile" name="param._se_mobile" value="<s:property value="param._se_mobile"/>" maxlength="20" />
                    <input type="hidden" name="hid_se_mobile" />
                </td>
                <td align="right"><s:text name="imei"/>:&nbsp;</td>
                <td align="left">
                    <input type="text" id="param._se_imei" name="param._se_imei" value="<s:property value="param._se_imei"/>" maxlength="15" />
                    <input type="hidden" name="hid_se_imei" />
                </td>
            </tr>
             
            <s:if test="switchflag=='open'">
            <tr>
                <td align="right"><s:text name="upoprcode"/>:&nbsp;</td>
                <td align="left">
                    <input type="text" id="param._se_upoprcode" name="param._se_upoprcode" value="<s:property value="param._se_upoprcode"/>" maxlength="15" />
                    <input type="hidden" name="hid_se_upoprcode" />
                </td>
                <td align="right"><s:text name="checkedflag"/>:&nbsp;</td>
                <td align="left">
                    <j:selector name="param._se_checkedflag" definition="CHECKEDFLAG"/>
                    <input type="hidden" name="hid_se_checkedflag" />
                </td>
            </tr>
            </s:if>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
				    <s:i18n name="public">
                	<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_search"/>" onClick="doQueryList('/paymentsc/paymentsc_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/paymentsc/paymentsc_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doCheckDelete('/paymentsc/paymentsc_delete.do')">
                    
                    <input type="button" id="btnBatchDelete" name="btnBatchDelete" class="button_2" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_batchdelete"/>" onClick="doBatchDelete('/paymentsc/paymentsc_batchDelete.do')">
                    
                    <input type="button" id="btnExport" name="btnExport"
						class="button_4" onmouseover="buttonover(this);"
						onmouseout="buttonout(this);" onfocus="buttonover(this)"
						onblur="buttonout(this)"
						value="<s:text name="button_exportexcel"/>"
						onClick="doExport('/paymentsc/paymentsc_exportExcel.do')">
										
                    <input type="button" id="btnBatch" name="btnBatch"
						class="button_2" onmouseover="buttonover(this);"
						onmouseout="buttonout(this);" onfocus="buttonover(this)"
						onblur="buttonout(this)" value="批量导入" onClick="doImport();">
                   
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
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('calcmonth')"><s:text name="calcmonth"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('paymonth')"><s:text name="paymonth"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('optype')"><s:text name="optype"/></j:orderByImg>                 
                </td>
                <td>
					<s:text name="ltype"/>
				</td>
				<td>
                    <s:text name="stype"/>           
                </td> 
                
                <td>
					<s:text name="mobile"/>
				</td>
				<td>
                    <s:text name="imei"/>                 
                </td>

                <td>
                    <s:text name="paysum"/>               
                </td>
                <td>
                    <s:text name="settleperiods"/>            
                </td>
                
                <td><s:text name="note"/></td>
                
                <s:if test="switchflag=='open'">
                    <td><s:text name="checkedflag"/></td>
                    <td><s:text name="upoprcode"/></td>
                </s:if>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
			         <td>
			             <input type="checkbox" name="param._selectitem" value="<s:property value="seq"/>_<s:property value="checkedflag"/>" onclick="checkOne();">
			         </td>
                     
                     <td>
                         <a href='<s:url action="paymentsc_edit.do"><s:param name="param._pk" value="seq"/></s:url>'>
                             <s:property value="wayid" />
					     </a>
					 </td>
                     <td><s:property value="calcmonth"/></td>
                     <td><s:property value="paymonth"/></td>
                     <td><s:property value="optype"/></td>
					 <td><s:property value="ltype"/></td>
                     <td><s:property value="stype"/></td>
                     <td><s:property value="mobile"/></td>
                     <td><s:property value="imei"/></td>
                     <td><s:property value="paysum"/></td>
                     <td><s:property value="settleperiods"/></td>
                     <td><s:property value="note"/></td>
                     
                     <s:if test="switchflag=='open'">
                         <td><j:code2Name definition="CHECKEDFLAG" code="checkedflag"/></td>
                         <td><s:property value="upoprcode"/></td>
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
