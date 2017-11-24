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
        	var reward=document.all("form.reward").value;
        	if(reward*1-0<0)
        	{
        		alert("酬金标准不能小于0");
        		return false;
        	}
            addfield('form.comcategory', '<s:text name="comcategory"/>', 'c', false, 32);
			addfield('form.reward', '<s:text name="reward"/>', 'd', false, 16,2);
            return checkval(window);
        }
        
        function doSave(str){
        	var ret = ev_checkval(); 
        	if(ret){
        		enable();
        		formItem.action ="<%=contextPath%>/promotion/rewardstd_save.do?pk1="+str;
   				formItem.submit();
   			}else{
   				return false;
   			}
        }
        
        function doReturn(str, str1) {
   		 	formItem.action ="<%=contextPath%>/promotion/rewardstd_list.do?pk="+str + "&pk1=" + str1;
   			formItem.submit();
		}
    </script>
</head>
<body class="list_body"
		onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="rewardstd_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
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
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
                        <s:textfield name="form.ruleid"  cssStyle="style_input" readonly="true"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield name="form.ruleid"  cssStyle="style_input" disabled="true"/>
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
			         <s:if test="CMD == WEB_CMD_NEW">
                        <j:selector definition="$IM_FXCOMCATEGORY" name="form.comcategory" mode="picker" cssStyle="style_input" />
                        <font color=red>*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<j:selector definition="$IM_FXCOMCATEGORY" name="form.comcategory" mode="picker" disabled="true"  cssStyle="style_input" />
                        <font color=red>*</font>
			        </s:elseif>
			        <s:else>
						<j:selector definition="$IM_FXCOMCATEGORY" name="form.comcategory" mode="picker" disabled="true"  cssStyle="style_input" />
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="reward"/>:&nbsp</td>
                <td align="left">
                <s:i18n name="public">
                	 <s:if test="CMD == WEB_CMD_NEW">
						<s:textfield cssStyle="style_input" name="form.reward" />		
						<font color=red>*</font>		
					</s:if>
					<s:elseif test="CMD == WEB_CMD_EDIT">
						<s:textfield cssStyle="style_input" name="form.reward"  value="%{getText('format.double',{form.reward})}"   />
						<font color=red>*</font>
					</s:elseif>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.reward"  value="%{getText('format.double',{form.reward})}"  disabled="true" />
						<font color=red>*</font>
					</s:else>
				</s:i18n>	
	                	
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
                           value="<s:text name="button_save"/>" onclick="doSave(document.all['form.pid'].value); loadforiframe();"
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
