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
    <title><bean:message bundle="exmnaudit" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/jquery/jquery-1.3.2.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('seqid', '<bean:message bundle="exmnaudit" key="seqid"/>', 'f', false, '14');
            addfield('presenter', '<bean:message bundle="exmnaudit" key="presenter"/>', 'c', false, '16');
            addfield('submissiontime', '<bean:message bundle="exmnaudit" key="submissiontime"/>', 't', false, '7');
            addfield('auditor', '<bean:message bundle="exmnaudit" key="auditor"/>', 'c', false, '16');
            addfield('auditopinion', '<bean:message bundle="exmnaudit" key="auditopinion"/>', 'c', false, '512');
            addfield('itemgradedid', '<bean:message bundle="exmnaudit" key="itemgradedid"/>', 'f', false, '14');
            addfield('state', '<bean:message bundle="exmnaudit" key="state"/>', 'c', false, '32');

            return checkval(window);
        }
          function closeWin(){
        	window.close();
        }
        function confirm(){
        	var state=$(":radio[name='state']:checked").val();
        	var auditopinion=$(":textarea[name='auditopinion']").val();
        	if(state==undefined){
        		alert("请选择批示!");
        		return;
        	}
        	if(state==2){
        		if(auditopinion==''){
        			alert("请填写审核意见!");
        			return;
        		}
        	}
        	window.returnValue=state+","+auditopinion;
        	window.close();
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/examine/exmnaudit.do?CMD=SAVE" styleId="formItem" method="post">
   

    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="exmnaudit" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="exmnaudit" key="approve"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                 	通过： <input type="radio" name="state" value="1" class="table_radio">
                 	不通过： <input type="radio" name="state" value="2" class="table_radio">
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="exmnaudit" key="audieAttitude"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <textarea class="form_textarea_on_4" name="auditopinion"></textarea>
                </td>
            </tr>
           
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" class="form_table_center">
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_confirm"/>" onclick="confirm()"/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_close"/>" onclick="closeWin();">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
