<%@ page language="java" contentType="text/html;charset=GBK"%>
<%//  contenthead.inc��content.jsp���ļ�ͷ��������JS��CSS�ȵ����ã�����content.jsp������������ļ�ͷ%>
<%@ include file="/inc/contenthead.inc"%>

<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="2B1A3CBB70" />
</jsp:include>
<%
	String ID_1 = "CH_PW_SALEWAY_EDIT";
%>

<html:html>
<head>
	<BASE target="_parent">
	<title>
		<bean:message bundle="saleway" key="titleUpdate" />
	</title>
	<script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
	<script language="JavaScript">
        <%//¼�����ݵ�У��%>
        function ev_checkval() {
            //way
            addfield('wayid', '<bean:message bundle="saleway" key="wayid"/>', 'c', false , 18);
            
            //contact    
            addfield('principal', '<bean:message bundle="saleway" key="principal"/>', 'c', false, 64);
            addfield('principaltel', '<bean:message bundle="saleway" key="principaltel"/>', 'c', false, 20);
            addfield('principalphone', '<bean:message bundle="saleway" key="principalphone"/>', 'c', true, 20);
            addfield('principalemail', '<bean:message bundle="saleway" key="principalemail"/>', 'c', true, 128);
                 
            return checkval(window);
        }
        
        function bodyOnload(){
        	if(window.loadforiframe){
        		loadforiframe();
        	}
        }
        
        function doReturnList(cmdReturn) {
    		formItem.action =contextPath + cmdReturn;
    		formItem.target = "_parent";
    		formItem.submit();
		}
    </script>
</head>
<body onload="bodyOnload()">
	<div class="table_container">
		<html:form action="/cms/saleway/contact.do?CMD=SAVE" styleId="formItem" method="post" target="_self">
			<html:hidden property="cmdState" />
			<%//��ѯҳ��Ĳ�����������Щ���������ӣ��༭ʱ���ر༭ǰ����ȷҳ��%>
			<html:hidden property="_orderby" />
			<html:hidden property="_desc" />
			<html:hidden property="_pageno" />
			<html:hidden property="_pagesize" />
			<c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW' or param.CMD eq 'EDITNEW')}" />
			<c:set var="item" scope="request" value="${requestScope['/cms/bchcontact/BchcontactForm']}"/>
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="saleway" key="titleList" />
						</td>
					</tr>
				</table>
			</div>
			<div class="table_div">
				<table width="100%" class="error_text">
					<s:Msg />
				</table>
			</div>
			<div>
				<table class="form_table">
					<tr>
						<td align=left colspan="4">
							&nbsp;&nbsp;
							<bean:message bundle="public" key="msgRequired" />
						</td>
					</tr>
				</table>
			</div>
			<div class="table_div">						
				<table class="form_table">
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="wayid" />
								:
							</div>
						</td>
						<td width="25%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="wayid" maxlength="18" readonly="true"/>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="wayid" disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="wayname" />
								:
							</div>
						</td>
						<td width="25%" align="left" class="form_table_left">
							<s:Code2Name code="${item.wayid}" definition="#WAY"/>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="principal" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="principal" maxlength="24" />
									<font color=red>
										&nbsp;*
									</font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="principal" disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="principaltel" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="principaltel" maxlength="24" />
									<font color=red>
										&nbsp;*
									</font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="principaltel" disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="principalphone" />
								:
							</div>
						</td>
						<td width="25%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="principalphone" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="principalphone" disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="principalemail" />
								:
							</div>
						</td>
						<td width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="principalemail" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="principalemail" disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</table>
			</div>
			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
							<s:PurChk2 controlid="<%=ID_1%>" disableChild="true">
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_save"/>" class="submit"
									onclick="doSave('/cms/saleway/contact.do?CMD=SAVE')" />
							</s:PurChk2>
							<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_return"/>" class="close"
								onclick="doReturnList('/cms/saleway/saleway.do?CMD=LIST')">
						</td>
					</tr>
				</table>
			</div>
		</html:form>
	</div>
</body>
</html:html>
