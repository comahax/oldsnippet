<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.comcategory', '<s:text name="comcategory"/>', 'c', false, 32);
			addfield('form.quantity', '<s:text name="quantity"/>', 'i', false, 3);
			addfield('form.tcomcategory', '<s:text name="tcomcategory"/>', 'c', false, 32);
			addfield('form.tquantity', '<s:text name="tquantity"/>', 'i', false, 3);
            return (checkval(window) && compareQuantity());
        }
        
        function compareQuantity(){
        	var quantity = document.getElementById('form.quantity').value;
        	var tquantity = document.getElementById('form.tquantity').value;
        	if (quantity<0||tquantity<0){
        		var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="quantity"/>]��[<s:text name="tquantity"/>]</span> ����Ϊ <span style=\'color:#F00; font-size:12px;\'>�����������</span>';
        		errorMessageShow(alertstr);
				return false;
        	}
        	return true;
        }
        
        function doSave(str){
        	var ret = ev_checkval(); 
        	if(ret){
        		enable();
        		formItem.action ="<%=contextPath%>/promotion/tieinsale_save.do?pk1="+str;
   				formItem.submit();
   			}
   			else{
   				return false;
   			}
        }
        
        function doReturn(str, str1) {
   		 	formItem.action ="<%=contextPath%>/promotion/tieinsale_list.do?pk="+str + "&pk1=" + str1;
   			formItem.submit();
		}
    </script>
</head>
<body class="list_body"
		onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="tieinsale_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_comcategory"/>
    <s:hidden name="param._se_tcomcategory"/>
    <s:hidden name="form.pid"/>
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
			        <s:if test="CMD==WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.ruleid" maxlength="6" readonly="true"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.ruleid" maxlength="6" disabled="true"/>
                        <font color=red>*</font>
			        </s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.ruleid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comcategory"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD==WEB_CMD_NEW">
                        <j:selector definition="$IM_FXCOMCATEGORY" name="form.comcategory" mode="picker" cssStyle="select" />
                        <font color=red>*</font>
			        </s:if>
			         <s:elseif test="CMD == WEB_CMD_EDIT">
			         	<j:selector definition="$IM_FXCOMCATEGORY" name="form.comcategory" mode="picker" cssStyle="select" disabled="true"/>
                        <font color=red>*</font>
			         </s:elseif>
			        <s:else>
						<j:selector definition="$IM_FXCOMCATEGORY" name="form.comcategory" mode="picker" cssStyle="select" disabled="true" />
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="quantity"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD==WEB_CMD_NEW">
					<s:textfield cssStyle="style_input" name="form.quantity" maxlength="3"/>
					<font color=red>*</font>
				</s:if>
				<s:elseif test="CMD == WEB_CMD_EDIT">
					<s:textfield cssStyle="style_input" name="form.quantity" maxlength="3"/>
					<font color=red>*</font>
				</s:elseif>
				 <s:else>
				 	<s:textfield cssStyle="style_input" name="form.quantity" maxlength="3" disabled="true"/>
				 	<font color=red>*</font>
				 </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="tcomcategory"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD==WEB_CMD_NEW">
					<j:selector definition="$IM_FXCOMCATEGORY" name="form.tcomcategory" mode="picker" cssStyle="select" />
					<font color=red>*</font>
				</s:if>
				<s:elseif test="CMD == WEB_CMD_EDIT">
					<j:selector definition="$IM_FXCOMCATEGORY" name="form.tcomcategory" mode="picker" cssStyle="select" />
					<font color=red>*</font>
				</s:elseif>
				<s:else>
					<j:selector definition="$IM_FXCOMCATEGORY" name="form.tcomcategory" mode="picker" cssStyle="select" disabled="true"/>
					<font color=red>*</font>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="tquantity"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD==WEB_CMD_NEW">
					<s:textfield cssStyle="style_input" name="form.tquantity" maxlength="3"/>
                	<font color=red>*</font>
                </s:if>
                <s:elseif test="CMD == WEB_CMD_EDIT">
                	<s:textfield cssStyle="style_input" name="form.tquantity" maxlength="3"/>
                	<font color=red>*</font>
                </s:elseif>
                <s:else>
                	<s:textfield cssStyle="style_input" name="form.tquantity" maxlength="3" disabled="true"/>
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
