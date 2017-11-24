<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="creditstd3g" key="titleUpdatestdset"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('cityid', '<bean:message bundle="creditstd3g" key="cityid"/>', 'f', false, '3');
            addfield('wayattr', '<bean:message bundle="creditstd3g" key="wayattr"/>', 'c', false, '3');
            addfield('rewardstd', '<bean:message bundle="creditstd3g" key="rewardstd"/>', 'f', false, '8','2',null,'0');
            addfield('creditstd', '<bean:message bundle="creditstd3g" key="creditstd"/>', 'f', false, '8','2',null,'0');
            addfield('terminalstd', '<bean:message bundle="creditstd3g" key="terminalstd"/>', 'f', false, '8','2',null,'0');
            addfield('zcterminalstd', '<bean:message bundle="creditstd3g" key="zcterminalstd"/>', 'f', false, '8','2',null,'0');
            addfield('intvmonth', '<bean:message bundle="creditstd3g" key="intvmonth"/>', 'f', false, '3','0',null,'0');
            addfield('gtnstd', '<bean:message bundle="creditstd3g" key="gtnstd"/>', 'f', false, '3','0',null,'0');
            return (checkval(window) && checkRewardstdup());
        }
        
        function checkRewardstdup(){
        	var rewardstd = parseFloat(document.getElementById('rewardstd').value);        	
        	var rewardstdup = parseFloat(document.getElementById('rewardstdup').value);        	
        	if(rewardstd>rewardstdup){
        	    var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[门店补贴酬金标准]</span> 不能超过省公司设置酬金上限 ';
				errorMessageShow(alertstr);
				return false;
        	}
        	return true;
        }
        function doSavestdset(cmdSave){
		    if (ev_checkval()) {
		        formItem.action = contextPath + cmdSave;
		        formItem.submit();
		    }
		    return false;
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/reward/creditstd3g.do?CMD=SAVESTDSET" styleId="formItem" method="post">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/> 
    <html:hidden property="rewardstdup" styleId="rewardstdup"/>   
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/creditstd3g/Creditstd3gForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="creditstd3g" key="titleUpdatestdset"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="creditstd3g" key="cityid2"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">                    
                    <html:text styleClass="form_input_1x" property="cityid" readonly="true" />                        
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="creditstd3g" key="wayattr"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="wayattr" readonly="true" />                    
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="creditstd3g" key="rewardstd"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="rewardstd" />
                    <font color='red'>上限:<fmt:formatNumber pattern="0.00" value="${form.rewardstdup}" /></font>                                       
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="creditstd3g" key="creditstd"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="creditstd" />
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="creditstd3g" key="terminalstd"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="terminalstd" />
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="creditstd3g" key="zcterminalstd"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="zcterminalstd" />
                </td>
            </tr>
             <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require">全球通开户保底要求:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="gtnstd" />
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="creditstd3g" key="intvmonth"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="intvmonth" />
                </td>
            </tr>
            
             
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" class="form_table_center">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSavestdset('/cms/reward/creditstd3g.do?CMD=SAVESTDSET')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/reward/creditstd3g.do?CMD=LISTSTDSET')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
