<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%@ page import="com.sunrise.jop.ui.User"%>
<%@ page import="com.sunrise.jop.ui.struts2.WebConstant"%>
<%
	User user = (User)request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
	String opercode = user.getOprcode();
%>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('param._dnl_smsntime', '<s:text name="state"/>', 'dt', true, '7');
        	addfield('param._dnm_smsntime', '<s:text name="state"/>', 'dt', true, '7');
            addfield('param._se_state', '<s:text name="state"/>', 'c', true, '32');
            return (checkval(window) && compareDate());
        }
        function compareDate(){
	        var startTime = document.getElementById('param._dnl_smsntime').value;
	        var endTime = document.getElementById('param._dnm_smsntime').value;
	        if(startTime != '' && endTime != '' &&  startTime>endTime){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnl_smsntime"/> ]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnm_smsntime"/>]</span>';
				errorMessageShow(alertstr);
	        	return false;
	        }
        	return true;
        }
    </script>
</head>

<body class="list_body">
<div class="table_container">
<s:form action="audit_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
	<aa:zone name="hiddenZone">
	<s:hidden name="param._ne_seqid"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
    </aa:zone>
        
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
		</div>
	</div>
    
    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>

	<div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="center"><s:text name="_dnl_smsntime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_smsntime" onclick="selectDatetime();" readOnly="true"/>
                </td>
                <td align="center"><s:text name="_dnm_smsntime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_smsntime" onclick="selectDatetime();" readOnly="true"/>
                </td>
                <td align="center"><s:text name="state"/>:</td>
                <td align="left">
                    <j:selector name="param._se_state" definition="$CH_AUDITSTATE"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/audit_list.do');">
                     <input type="button" id="btnBatchaudit" name="btnBatchaudit" class="button_2" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="审核" onClick="doBatchAudit();">
                	 <input type="button" id="btnBatchsubmit" name="btnBatchsubmit" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="提交上级" onClick="doSubmit();">
                   </s:i18n>
				</td>
			</tr>
		</table>
	</div>

	<aa:zone name="listZone">
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style">
            <tr class="table_style_head">
               	<s:i18n name="public">
                <td title="<s:text name="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();"/>
                </td>
                </s:i18n>
                <td>
                    <j:orderByImg href="javascript:doOrderby('seqid')"><s:text name="seqid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('presenter')"><s:text name="presenter"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('smsntime')"><s:text name="smsntime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('state')"><s:text name="state"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('memo')"><s:text name="memo"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('auditor')"><s:text name="auditor"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('audittime')"><s:text name="audittime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('opinion')"><s:text name="opinion"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="seqid"/>|<s:property value="auditor"/>|<s:property value="state"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="audit_showAuditPage.do"><s:param name="seqid" value="seqid"/></s:url>'><s:property value="seqid"/></a></td>
					 <td><j:code2Name code="presenter" definition="#OPERATOR"/></td>
					 <td><s:date name="smsntime" format="yyyy-MM-dd HH:mm:ss"/></td>
					 <td><j:code2Name code="state" definition="$CH_AUDITSTATE"/></td>
					 <td><s:property value="memo"/></td>
					 <td><j:code2Name code="auditor" definition="#OPERATOR"/></td>
					 <td><s:date name="audittime" format="yyyy-MM-dd HH:mm:ss"/></td>
					 <td><s:property value="opinion"/></td>
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
<script language="javascript"> 
		 /*
	     *提交
	     */
	     function doSubmit(){
	    	 var opercode="<%=opercode%>";
	    	 var checkedBoxs=$(":checkbox[name='param._selectitem']:checked");
				if(checkedBoxs.length==0){
					var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[请选择要提交的信息]</span>';
					errorMessageShow(alertstr);
					return false;
				}
				if(checkedBoxs.length>1){
					var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[只允许选择一条记录进行提交]</span>';
					errorMessageShow(alertstr);
					return false;
				}
				var vals=$(checkedBoxs[0]).val().split("|");
				if(vals[1]!=opercode){
					var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[非当前记录审核人，不允许提交上级审核]</span>';
					errorMessageShow(alertstr);
					isSubmit=false;
					return;
					}
				if(vals[2]!=1){
					var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[只有审核通过后才允许提交上级审核，请检查。]</span>';
					errorMessageShow(alertstr);
					isSubmit=false;
					return;
				}
				
	     		//var returnValue=window.showModalDialog('<%=contextPath %>/sales/audit_selectUpper.do?seqid='+vals[0],window,"dialogWidth=500px;dialogHeight=180px;status:no;scroll=no;");
			    formList.action="<%=contextPath %>/sales/audit_selectUpper.do?seqid="+vals[0];
			    formList.submit();
		     	<%--var returnValue=getAuditingRoleList();
		     	if(returnValue!=undefined){
		     		var strs=returnValue.split(",");
		     		//formList.action="<%=contextPath%>/sales/audit_submit.do?seqid="+vals[0]+"&operid="+vals[1];
		     		//formList.submit();
		     		window.location.href="<%=contextPath%>/sales/audit_submit.do?seqid="+vals[0]+"&operid="+strs[0];
		     		window.location.reload();
		     	}--%>
	     	
	     }
	     //批量提交
	     function doBatchSubmit(){
	     
	     	var checkedBoxs=$(":checkbox[name='param._selectitem']:checked");
			if(checkedBoxs.length==0){
				var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[请选择要提交的记录]</span>';
				errorMessageShow(alertstr);
				return false;
			}
			var isSubmit=true;
			var selectitems="";
			checkedBoxs.each(function(i) {
				var vals=$(this).val().split("|");
				if(vals[2]==0 || vals[2]==2){
					var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[只允许提交状态“通过”的记录]</span>';
					errorMessageShow(alertstr);
					isSubmit=false;
					return;
				}
				if(selectitems=="")
					selectitems=vals[1];
				else
					selectitems+="|"+vals[1]
			});
			var isSubmit2=false;
			jQuery.ajax({
				type:"POST",
				url:"<%=contextPath %>/sales/audit_checkAudit.do",
				async:false, //同步
				data:"selectitems="+selectitems,			
				success:function(msg){
					if(msg=='no'){
						var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[存在异常状态记录，不允许提交审核]</span>';
						errorMessageShow(alertstr);
						isSubmit2= false;
					}else{
						isSubmit2=true;
					}
				}
			});
			if(isSubmit && isSubmit2){
				var returnValue=getAuditingRoleList();
		     	if(returnValue!=undefined){
		     		var strs=returnValue.split(",");
		     		formList.action="<%=contextPath%>/sales/audit_doSubmit.do?operid="+strs[0];
	        		formList.submit();
		     	}
	     	}
			
	     }
	      /*
	     *审核
	     */
	     function doAudit(seqid){
	     	var returnValue=window.showModalDialog('<%=contextPath %>/sales/audit/audit.jsp',window,"dialogWidth=500px;dialogHeight=430px;status:no;scroll=yes;");
		    if(returnValue!=undefined){
		    	var strs=returnValue.split(",");
		    	window.location.href="<%=contextPath%>/sales/audit_audit.do?seqid="+seqid+"&state="+strs[0]+"&opinion="+strs[1];
				window.location.reload();
			}
			
	     }
	     /*
	     *点击列表中审核序号链接,跳转至审核界面
	     */
	     function doSeqidAudit(seqid){
	    	 formList.action="<%=contextPath%>/sales/audit_showAuditPage.do?seqid="+seqid;
		     formList.submit();
	     }
	     
	      /*
	     *审核
	     */
	     
	     function doBatchAudit(){
	    	 var opercode="<%=opercode%>";
	    	 var checkedBoxs=$(":checkbox[name='param._selectitem']:checked");
	    	 if(checkedBoxs.length==0){
					var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[请选择要审核的记录]</span>';
					errorMessageShow(alertstr);
					return false;
				}
			 if(checkedBoxs.length>1){
					var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[只允许选择一条记录进行审核]</span>';
					errorMessageShow(alertstr);
					return false;
				}

	    	 var vals=$(checkedBoxs[0]).val().split("|");
			 if(vals[1]!=opercode){
					var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[只有审核人才有权限进行审核操作]</span>';
					errorMessageShow(alertstr);
					return;
				}
			 if(vals[2]==1){
					var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[该记录已审核通过，不允许重复审核]</span>';
					errorMessageShow(alertstr);
					return;
				}
	    	formList.action="<%=contextPath%>/sales/audit_showAuditPage.do?seqid="+vals[0];
	    	formList.submit();
		     }
	     //审批人弹出框
	     function getAuditingRoleList(){
	     	var returnValue=window.showModalDialog('<%=contextPath %>/base/operator_auditingRoleList.do',window,"dialogWidth=500px;dialogHeight=430px;status:no;scroll=yes;");
		    if(returnValue!=undefined){
		    	return returnValue;
			}
	     }
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery");
	
</script> 
</body>
</html>
