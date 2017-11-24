<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
	String pk = request.getParameter("pk");
 %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.prodid', '<s:text name="prodid"/>', 'c', false, 32);
			addfield('form.incat', '<s:text name="incat"/>', 'c', true, 32);
			addfield('form.incratio', '<s:text name="incratio"/>', 'f', false, 1, 2);
            return (checkval(window) && compareIncratio());
        }
        
         function compareIncratio(){
        	var incratio = document.getElementById('form.incratio').value;
        	if (incratio<0){
        		var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="incratio"/> ]</span> 必须为 <span style=\'color:#F00; font-size:12px;\'>大于零的实数</span>';
        		errorMessageShow(alertstr);
				return false;
        	}
        	return true;
        }
        
        function doSave(str){
        	var ret = ev_checkval(); 
        	if(ret){
        		enable();
        		formItem.action ="<%=contextPath%>/promotion/pquantity_save.do?pk1="+str;
   				formItem.submit();
   			}else{
   				return false;
   			}
        }
        
        function doReturn(str, str1) {
   		 	formItem.action ="<%=contextPath%>/promotion/pquantity_list.do?pk="+str+"&pk1="+str1;
   			formItem.submit();
		}
    </script>
</head>
<body class="list_body"
		onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="pquantity_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="form.pid"/>
	<input type="hidden" name="pk" value="<%=pk%>"/>
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="promotion"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent1"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
		</div>
	</div>

	<div class="error_text" >
		<table class="error_text">
			<s:actionerror /><s:actionmessage/>
		</table>
	</div>
	
    <div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="right"><s:text name="ruleid"/>:&nbsp</td>
                <td align="left">
			         <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.ruleid" maxlength="6" readonly="true" />
                        <font color=red>*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        <s:textfield cssStyle="style_input" name="form.ruleid" maxlength="6" disabled="true" />
                        <font color=red>*</font>
                    </s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.ruleid"  readonly="true" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="prodid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <p:smpBrand name="form.prodid" mode="of" cssStyle="style_input" />
                        <font color=red>*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<p:smpBrand name="form.prodid" mode="of" cssStyle="style_input" />
                        <font color=red>*</font>
			        </s:elseif>
			        <s:else>
						<p:smpBrand name="form.prodid" mode="of" cssStyle="style_input" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="incratio"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD == WEB_CMD_NEW">
					<s:textfield cssStyle="style_input" name="form.incratio" />
					<font color=red>*</font>
					</s:if>
					<s:elseif test="CMD == WEB_CMD_EDIT">
					<s:textfield cssStyle="style_input" name="form.incratio" />
					<font color=red>*</font>
					</s:elseif>
					<s:else>
					<s:textfield cssStyle="style_input" name="form.incratio" disabled="true"/>
					<font color=red>*</font>
					</s:else>
                </td>
            </tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="doSave(document.all['form.pid'].value);loadforiframe();"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn(document.all['form.ruleid'].value, document.all['form.pid'].value)">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
