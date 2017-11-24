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
        
        function getEndWith(str){
        	var tmp = str.substring(str.length-2,str.length);
        	var tmp2 = str.substring(0,str.length-2);
        	if(validDateStr(tmp2+"31") == true){
       			return "31";
       		}else if(validDateStr(tmp2+"30") == true){
       			return "30";
       		}else if(validDateStr(tmp2+"29") == true){
       			return "29";
       		}else if(validDateStr(tmp2+"28") == true){
       			return "28";
       		}
        }
     
        function validDateStr(str){
			var reg =  /^(\d{1,4})(\d{1,2})(\d{1,2})$/;
			var r = str.match(reg);
			if(r==null){
				return false;
			}
			else{
				var d = new Date(r[1],r[2]-1,r[3]);
				if(d.getFullYear()==r[1]&&(d.getMonth()+1)==r[2]&&d.getDate()==r[3]){
					return true;
				}
				else{
					return false;
				}   
			}
		}
		
		function checkState(){
         if( document.all.oprstate.value==2||document.all.oprstate.value==3){
          alert("<bean:message bundle="chgreq" key="message" />");
         return false;
         }
         return true;
       }
       
       function showDeta(){
       	var condition = '&reqid=' + document.all.reqid.value;
       	var url = contextPath + '/qsmanage/paramsmanage/chgreq.do?CMD=SHOWDETA' + condition ;
		var hWnd = window.showModalDialog(url,new Array(),"dialogWidth:620px; dialogHeight:250px; status:no;resizable:yes;");
       }
    </script>
</head>
<body>
	<div class="table_container">
		<html:form action="/qsmanage/paramsmanage/chgreq.do?CMD=SAVE"
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
			
			<c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}" />
			<c:set var="newState" scope="request" value="${!empty param.CMD and (param.CMD eq 'NEW')}" />
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
								<bean:message bundle="chgreq" key="reqid" />:
							</div>
						</td>
						<td width="30%" align="left" class="form_table_left">
							<html:text styleClass="form_input_1x" property="reqid"
										disabled="true" />
						</td>
						<td width="20%" align="right" class="form_table_right">
							<div class="field-require">
								<bean:message bundle="chgreq" key="tabname" />:
							</div>
						</td>
						<td width="30%" align="left" class="form_table_left">
							<html:text styleClass="form_input_1x" property="tabnamestr"
										disabled="true" />
						</td>
					</tr>
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
								<bean:message bundle="chgreq" key="oprtype" />:
							</div>
						</td>
						<td width="30%" align="left" class="form_table_left">
							<html:select property="oprtype" disabled="true">
								<s:Options definition="$QSCS_OPRTYPE"></s:Options>
							</html:select>
						</td>
					</tr>
					<tr>
						<td width="20%" align="right" class="form_table_right">
							<div class="field-require">
								<bean:message bundle="chgreq" key="mainkey" />:
							</div>
						</td>
						<td width="30%" align="left" class="form_table_left" colspan="3" >
							<html:text styleClass="form_input_3x" property="mainkeystr"
										disabled="true" />
						</td>
					</tr>
					<tr>
						<td width="20%" align="right" class="form_table_right">
							<div class="field-require">
								<bean:message bundle="chgreq" key="mainvalue" />:
							</div>
						</td>
						<td width="30%" align="left" class="form_table_left" colspan="3" >
							<html:text styleClass="form_input_3x" property="mainvalue"
										disabled="true" />
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
								<bean:message bundle="chgreq" key="oprstate" />:
							</div>
						</td>
						<td width="30%" align="left" class="form_table_left"  >
							<html:select property="oprstate" disabled="true">
								<s:Options definition="$QSCS_OPRSTATE"></s:Options>
							</html:select>
						</td>
						
						<td width="20%" align="right" class="form_table_right">
							<div class="field-require">
								<bean:message bundle="chgreq" key="matchid" />:
							</div>
						</td>
						<td width="30%" align="left" class="form_table_left">
							<html:text styleClass="form_input_1x" property="matchid" disabled="true"/>
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
								onclick="doSave('/qsmanage/paramsmanage/chgreq.do?CMD=SAVE&OPRT=4')" />
							</s:PurChk2>
							
							
							<s:PurChk2 controlid="QSCS_APPROVE_WITHDRAW" disableChild="true">
							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnSave"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="撤消变更"
								class="button_4"
								onclick="doSave('/qsmanage/paramsmanage/chgreq.do?CMD=SAVE&OPRT=3')" />		
							</s:PurChk2>
							
							<s:PurChk2 controlid="QSCS_APPROVE_ISSUE" disableChild="true">
							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnSave"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="正式发布"
								class="button_4"
								onclick="doSave('/qsmanage/paramsmanage/chgreq.do?CMD=SAVE&OPRT=2')" />
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