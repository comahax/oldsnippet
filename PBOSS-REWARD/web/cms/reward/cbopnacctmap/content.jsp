<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa"%>
<%
	String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL";
	String ID_2 = "CH_PW_REWARD||CH_PW_REWARD_CIVIC";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="cbopnacctmap" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('opnid', '<bean:message bundle="cbopnacctmap" key="opnid"/>', 'c', false, '14');
          	addfield('batchacctid', '<bean:message bundle="cbopnacctmap" key="acctid"/>', 'c', false,'1024');
          	addfield('cityid', '<bean:message bundle="cbopnacctmap" key="cityid"/>', 'c', false,'1024');
            return checkval(window);
        }
        function selectAcctid(){
			var arg = new Array();
			var strUrl ="<%=contextPath%>/cms/reward/cbopnacctmap.do?CMD=SELECT";
			var returnValue= window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
			return returnValue;
		}
    </script>
    <script type="text/javascript" src="<%= contextPath %>/js/bus/waycommon.js"></script>
	<script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/reward/cbopnacctmap.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="cbopnacctmap" key="titleList"/>
   			</td>
    	</tr>
    </table>
    </div>
    <div class="table_div">	
   		 <table width="100%" class="error_text">
    		<html:errors/><s:Msg />
    	</table>
    </div>
    <div class="table_div">
        <table class="form_table">
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="cbopnacctmap" key="opnid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                   <html:text styleClass="form_input_1x" property="opnid" /><font color=red>&nbsp;*</font>
                     <input type="button" value="..." class="clickButton"
							   onclick="showOpnTree2(this, 'opnid','busi' );"> 
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="cbopnacctmap" key="acctid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
              	   <html:text styleClass="form_input_1x" property="batchacctid" /><font color=red>&nbsp;*</font>
                     <input type="button" value="..." class="clickbutton" onclick="batchacctid.value=selectAcctid();">
                     </br><font color="red">该按钮支持多选,如果人工输入多个编码请用,(逗号)分割开.例如:02000000,153520000</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="cbopnacctmap" key="cityid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                   <s:RewardPurChk controlid="<%=ID_1%>" disableChild="true" >
                   <html:select property="cityid">
						<option />
					 		<s:Options definition="$region" />
				   </html:select>
              	   <font color=red>*</font>
              	   </s:RewardPurChk>
                </td>
            </tr>
             <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="cbopnacctmap" key="resultstr"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <html:textarea styleClass="form_textarea_on_4" property="resultstr" readonly="true"/>
                </td>
            </tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td>
                		<s:PurChk2 controlid="<%=ID_2%>">
						<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnSave"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="public" key="button_save"/>"
								class="submit" onclick="doSave('/cms/reward/cbopnacctmap.do?CMD=SAVE')" />
						</s:PurChk2>
	                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="<bean:message bundle="public" key="button_return"/>" class="close"
	                           onclick="doReturn('/cms/reward/cbopnacctmap.do?CMD=SHOW')">
	            </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
