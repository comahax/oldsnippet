<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B7G1A4DAA" />
</jsp:include>


<html:html>
<head>
	<title><bean:message bundle="chgreq" key="title" /></title>
	<script language="JavaScript">
        function ev_checkval() {
        	addfield('oprstate', '<bean:message bundle="chgreq" key="oprstate"/>', 'i', false, 2);
        	addfield('chkinfo', '<bean:message bundle="chgreq" key="chkinfo"/>', 'c', false, 256);
        	addfield('matchid', '<bean:message bundle="chgreq" key="matchid"/>', 'l', false, 14);
            return checkval(window);
        }
        function showDeta(){
        	if(document.all.matchid.value == null || document.all.matchid.value == ""){
        		alert("请先填写批量关联标识！！");
        		return false;
        	}
       		var condition = '&matchid=' + document.all.matchid.value;
       		var url = contextPath + '/qsmanage/paramsmanage/chgreq.do?CMD=SHOWBATCH' + condition ;
			var hWnd = window.showModalDialog(url,new Array(),"dialogWidth:620px; dialogHeight:300px; status:no;resizable:yes;");
       }
        
    </script>
</head>
<body>
	<div class="table_container">
		<html:form action="/qsmanage/paramsmanage/chgreq.do?CMD=BATCH"
			styleId="formItem" method="post">
			<html:hidden property="cmdState" />
			<html:hidden property="_orderby" />
			<html:hidden property="_desc" />
			<html:hidden property="_pageno" />
			<html:hidden property="_pagesize" />
			
			<html:hidden property="_ne_tabtype" />
			<html:hidden property="_se_tabname" />
			<html:hidden property="_se_oprtype" />
			<html:hidden property="_se_oprcode" />
			<html:hidden property="_dnl_oprtime" />
			<html:hidden property="_dnm_oprtime" />
			<html:hidden property="_ne_chgtype" />
			<html:hidden property="_ne_matchid" />
			<html:hidden property="_sk_mainvalue" />
			<html:hidden property="_ne_oprstate" />
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="chgreq" key="title" />
						</td>
					</tr>
				</table>
			</div>
			<div class="table_div">
				<table width="100%" class="error_text">
					<html:errors />
					<s:Msg />
				</table>
			</div>
			<div class="table_div">
				<table class="form_table">
					<tr>
						<td width="20%" align="right" class="form_table_right">
							<div class="field-require">
								<bean:message bundle="chgreq" key="tabtype" />:
							</div>
						</td>
						<td width="30%" align="left" class="form_table_left">
							<html:select property="tabtype" disabled="true">
								<s:Options definition="$QSCS_TABTYPE"></s:Options>
							</html:select>
						</td>
						<td width="20%" align="right" class="form_table_right">
							<div class="field-require">
								<bean:message bundle="chgreq" key="oprstate" />:
							</div>
						</td>
						<td width="30%" align="left" class="form_table_left"  >
							<html:select property="oprstate" disabled="true">
										<s:Options definition="$QSCS_OPRSTATE"></s:Options>
									</html:select>
						</td>
					</tr>
					<tr>
							<td class="form_table_right">
									<bean:message bundle="chghis" key="chgreason" />
									:
							</td>
							<td class="form_table_left" colspan="3">
								<html:textarea property="chgreason"
									styleClass="form_textarea_on" disabled="true" />
							</td>
					</tr>
						
					<tr>
						<td width="20%" align="right" class="form_table_right">
							<div class="field-require">
								<bean:message bundle="chgreq" key="oprtime" />:
							</div>
						</td>
						<td width="30%" align="left" class="form_table_left"  >
							<html:text styleClass="form_input_1x" property="oprtdate"
										disabled="true" />
						</td>
						<td width="20%" align="right" class="form_table_right">
							<div class="field-require">
								<bean:message bundle="chgreq" key="oprcode" />:
							</div>
						</td>
						<td width="30%" align="left" class="form_table_left" >
							<html:text styleClass="form_input_1x" property="oprcode"
										disabled="true" />
						</td>
					</tr>
						
					<tr>
						<td width="20%" align="right" class="form_table_right">
							<div class="field-require">
								<bean:message bundle="chgreq" key="matchid" />:
							</div>
						</td>
						<td width="30%" align="left" class="form_table_left">
							<html:text styleClass="form_input_1x" property="matchid" disabled="true" />
						</td>
						<td width="20%" align="right" class="form_table_right">
						</td>
						<td width="30%" align="left" class="form_table_left" >
						</td>
					</tr>
					
					<tr>
						<td class="form_table_right">
							<bean:message bundle="chghis" key="chkinfo" />
							:
						</td>
						<td class="form_table_left" colspan="3">
							<html:textarea property="chkinfo"
									styleClass="form_textarea_on" />
							<font color=red>&nbsp;*</font>		
						</td>
					</tr>
				</table>
			</div>
			
			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnSave"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="请求明细" class="button_4" onclick="showDeta()" />
							
							<s:PurChk2 controlid="QSCS_APPROVE_NOTPASS" disableChild="true">	
							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnSave"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="审批不通过"
								class="button_5"
								onclick="doSave('/qsmanage/paramsmanage/chgreq.do?CMD=BATCH&OPRT=4')" />
							</s:PurChk2>
							
							<s:PurChk2 controlid="QSCS_APPROVE_WITHDRAW" disableChild="true">
							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnSave"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="撤消变更"
								class="button_4"
								onclick="doSave('/qsmanage/paramsmanage/chgreq.do?CMD=BATCH&OPRT=3')" />
							</s:PurChk2>			
							
							<s:PurChk2 controlid="QSCS_APPROVE_ISSUE" disableChild="true">
							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnSave"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="正式发布"
								class="button_4"
								onclick="doSave('/qsmanage/paramsmanage/chgreq.do?CMD=BATCH&OPRT=2')" />	
							</s:PurChk2>	
							
							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnReturn"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="public" key="button_return"/>"
								class="close"
								onclick="doReturn('/qsmanage/paramsmanage/chgreq.do?CMD=LIST')">
						
						</td>
					</tr>
				</table>
			</div>
		</html:form>
	</div>
</body>
</html:html>