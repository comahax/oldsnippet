<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%String seqid = request.getParameter("seqid");%>
<html>
	<base  target="_self">
	<head>
		<title><s:text name="提交审核" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            //addfield('param._se_operid', '<s:text name="operid"/>', 'c', true, '16');
            //addfield('param._se_password', '<s:text name="password"/>', 'c', true, '30');
            return checkval(window);
        }

        function doRoleSelect(){
        	var seqid=<%=seqid%>;
        	var returnValue=getAuditingRoleList();
	     	if(returnValue!=undefined){
	     		var strs=returnValue.split(",");
	     		document.all('operid').value = strs[0];
	     	}
        }
        function doSubmit1(){
        	var seqid=<%=seqid%>;
        	var memo = document.getElementsByName('memo')[0].value;
        	var operid = document.getElementsByName('operid')[0].value;
        	if(operid==undefined||operid==''){
        		alert("请选择上级审核人!");
        		return;
        	}
        	//window.location.href="<%=contextPath%>/sales/audit_submit.do?seqid="+seqid+"&operid="+operid+"&memo="+memo;
     		//window.location.reload();
        	formList.action="<%=contextPath%>/sales/audit_submit.do?seqid="+seqid+"&operid="+operid+"&memo="+memo;
        	formList.submit();
        	formList.action="<%=contextPath%>/sales/audit_list.do";
        }
        function Close(){
        	window.close();
        }
      //审批人弹出框
	     function getAuditingRoleList(){
	     	var returnValue=window.showModalDialog('<%=contextPath %>/base/operator_auditingRoleList.do',window,"dialogWidth=500px;dialogHeight=430px;status:no;scroll=yes;");
		    if(returnValue!=undefined){
		    	return returnValue;
			}
	     }
    </script>
	</head>

	<body>
		<div class="table_container">
		<s:form action="audit_selectUpper.do" key="formList" cssStyle="formList"
			theme="simple" onsubmit="return ev_check();">
					<s:hidden name="param._orderby" />
			<s:hidden name="param._desc" />
			<s:hidden name="param._pageno" />
			<s:hidden name="param._pagesize" />
			<s:hidden name="param.queryAll" />
			<s:hidden name="seqid" />
			<input type="hidden" name="_rowcount"
				value="<s:property value="dp.rowCount" />" />

			<div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="right"><s:text name="upperauditor"/>:&nbsp</td>
                <td align="left">
                        <s:textfield class="style_input" name="operid" readonly="true"/><input type="button" class="picker_button" value="..." onClick="doRoleSelect();"/>
                        <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="memo"/>:&nbsp</td>
                <td align="left">
					<s:textfield style="width:400px" name="memo" maxlength="512"/>
                </td>
            </tr>
        </table>
    </div>
    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                    <input type="button" id="btnSave" name="btnSave" class="button_2" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="确定" onclick="doSubmit1()"
                           />
                    <!--  <input type="button" id="btnReturn" name="btnReturn" class="button_2" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="关闭" onclick="Close()">-->
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/sales/audit_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
		</s:form>
	</div>
	</body>
</html>
