<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
	String ID_1 = "1A2B8H40AABT1";
	String ID_2 = "1A2B8H40AABT2";
	String ID_3 = "1A2B8H40AABT3";
%>
<%
	
%>
<html:html>
<head>
	<title><bean:message bundle="operright" key="titleUpdate" /></title>
	<script language="JavaScript">
        function ev_checkval() {
			addfield('operid', '<bean:message bundle="operright" key="operid"/>', 'c', false, 32);
            addfield('rightid', '<bean:message bundle="operright" key="rightid"/>', 'c', false, 32);
            addfield('createdate2', '<bean:message bundle="operright" key="createdate"/>', 't', false);
            addfield('status', '<bean:message bundle="operright" key="status"/>', 'i', false, 1);
            addfield('statusdate2', '<bean:message bundle="operright" key="statusdate"/>', 't', true);
            				
          	return checkval(window);
        }
        
       //去掉字符串中的空格
       function ignoreSpaces(string) {
		var temp = "";
		string = '' + string;
		splitstring = string.split(" "); 
		for(i = 0; i < splitstring.length; i++)
		temp += splitstring[i];
		return temp;
	   }
        
    </script>
</head>
<body onload="loadforiframe()">
<div class="table_container">
	<html:form action="/operright.do?CMD=SAVE" styleId="formItem" method="post">
        <html:hidden property="cmdState"/>
		<html:hidden property="_orderby" />
		<html:hidden property="_desc" />
		<html:hidden property="_pageno" />
		<html:hidden property="_pagesize" />
		<c:set var="newState" scope="request" value="${!empty param.CMD and (param.CMD eq 'NEW')}" />
		<c:set var="edtState" scope="request" value="${!empty param.CMD and param.CMD eq 'EDIT'}" />
		<div class="table_div">
		
		<table class="top_table" border=0>
					<tr>
						<td>
							<bean:message bundle="operright" key="titleUpdate" />
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
					<td colspan="4">
						<bean:message bundle="fee" key="redStarExplain" />
					</td>
			    </tr>
				<tr>
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">    
							<bean:message bundle="operright" key="operid" />
							:
						</div>
					</td>
					<td width="30%" align="left" class="form_table_left">
						<c:choose>
							<c:when test="${newState}">
								<html:text styleClass="form_input_1x" property="operid" onblur="this.value=ignoreSpaces(this.value);" />
								<bean:message bundle="fee" key="redStar" />
							</c:when>
							<c:when test="${edtState}">
								<html:text styleClass="form_input_1x" property="operid" disabled="true" onblur="this.value=ignoreSpaces(this.value);"/>
								<bean:message bundle="fee" key="redStar" />
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="operid" disabled="true" onblur="this.value=ignoreSpaces(this.value);"/>
								<bean:message bundle="fee" key="redStar" />
							</c:otherwise>
						</c:choose>
					</td>

					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">   
							<bean:message bundle="operright" key="rightid" />
							:
						</div>
					</td>
					<td width="30%" align="left" class="form_table_left">
						<c:choose>
							<c:when test="${newState}">
								<html:text styleClass="form_input_1x" property="rightid" onblur="this.value=ignoreSpaces(this.value);"/>
								<bean:message bundle="fee" key="redStar" />
							</c:when>
							<c:when test="${edtState}">
								<html:text styleClass="form_input_1x" property="rightid" disabled="true" onblur="this.value=ignoreSpaces(this.value);"/>
								<bean:message bundle="fee" key="redStar" />
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="rightid" disabled="true" onblur="this.value=ignoreSpaces(this.value);"/>
								<bean:message bundle="fee" key="redStar" />
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				
				<tr>
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">  
							<bean:message bundle="operright" key="createdate" />
							:
						</div>
					</td>
					<td width="30%" align="left" class="form_table_left">
						<c:choose>
							<c:when test="${newState}">
								<html:text styleClass="form_input_1x" property="createdate2" onclick="this.value=selectDate()"/>
								<bean:message bundle="fee" key="redStar" />
							</c:when>
							<c:when test="${edtState}">
								<html:text styleClass="form_input_1x" property="createdate2" onclick="this.value=selectDate()"	 disabled="true"/>
								<bean:message bundle="fee" key="redStar" />
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="createdate2" disabled="true" />
								<bean:message bundle="fee" key="redStar" />
							</c:otherwise>
						</c:choose>
					</td>

					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">  
							<bean:message bundle="operright" key="status" />
							:
						</div>
					</td>
					<td width="30%" align="left" class="form_table_left">
						<c:choose>
							<c:when test="${newState}">                                              
								<html:text styleClass="form_input_1x" property="status" value="1" readonly="true"/>
								<bean:message bundle="fee" key="redStar" />
							</c:when>
							<c:when test="${edtState}">
								<html:text styleClass="form_input_1x" property="status"  disabled="true"/>
								<bean:message bundle="fee" key="redStar" />
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="status" disabled="true" />
								<bean:message bundle="fee" key="redStar" />
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
		
				<tr>
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">  
							<bean:message bundle="operright" key="statusdate" />
							:
						</div>
					</td>
					<td width="30%" align="left" class="form_table_left">
						<c:choose>
							<c:when test="${newState}">
								<html:text styleClass="form_input_1x" property="statusdate2" onclick="this.value=selectDate()"/>
								<bean:message bundle="fee" key="redStar" />
							</c:when>
							<c:when test="${edtState}">
								<html:text styleClass="form_input_1x" property="statusdate2"  onclick="this.value=selectDate()" />
								<bean:message bundle="fee" key="redStar" />
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="statusdate2" disabled="true" />
								<bean:message bundle="fee" key="redStar" />
							</c:otherwise>
						</c:choose>
					</td>
				<td width="20%" align="right" class="form_table_right">
						<div class="field-require">  
							SORTORDER
							:
						</div>
					</td>					
					<td>
						<c:choose>
							<c:when test="${newState}">                                              
								<html:text styleClass="form_input_1x" property="sortorder" value="1" readonly="true"/>
								<bean:message bundle="fee" key="redStar" />
							</c:when>
							<c:when test="${edtState}">
								<html:text styleClass="form_input_1x" property="sortorder" />
								<bean:message bundle="fee" key="redStar" />
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="sortorder" disabled="true" />
								<bean:message bundle="fee" key="redStar" />
							</c:otherwise>
						</c:choose>
					</td>
					</tr>
					<tr>
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">  
							FLAG
							:
						</div>
					</td>
						<td width="30%" align="left" class="form_table_left">
						<c:choose>
							<c:when test="${newState}">                                              
								<html:text styleClass="form_input_1x" property="flag" value="1" readonly="true"/>
								<bean:message bundle="fee" key="redStar" />
							</c:when>
							<c:when test="${edtState}">
								<html:text styleClass="form_input_1x" property="flag" />
								<bean:message bundle="fee" key="redStar" />
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="flag" disabled="true" />
								<bean:message bundle="fee" key="redStar" />
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
						<c:choose>
								<c:when test="${newState or edtState}">
									<s:PurChk controlid="<%=ID_1%>">
										<input type="button" onmouseover="buttonover(this);"
											   onmouseout="buttonout(this);" name="btnSave" 
										 	  onfocus="buttonover(this)" onblur="buttonout(this)"
										 	  value="<bean:message bundle="public" key="button_save"/>"
										  	 class="submit"
										  	 onclick="doSave('/operright.do?CMD=SAVE')" />
									</s:PurChk>
								</c:when>
							</c:choose>		
																	
						<s:PurChk controlid="<%=ID_2%>">
						<input type="button" onmouseover="buttonover(this);"
						       onmouseout="buttonout(this);" name="btnPrint"
						       onfocus="buttonover(this)" onblur="buttonout(this)" 
						       value="<bean:message bundle="public" key="button_print"/>"
						       class="print" onclick="doPrint()"/>
						</s:PurChk>
						
						<s:PurChk controlid="<%=ID_3%>">
						<input type="button" onmouseover="buttonover(this);"
						       onmouseout="buttonout(this);" name="btnReturn"
						       onfocus="buttonover(this)" onblur="buttonout(this)" 
						       value="<bean:message bundle="public" key="button_return"/>"
						       class="close"
							   onclick="doReturn('/operright.do?CMD=LIST')"/>
						</s:PurChk>
						
					</td>
				</tr>
			</table>
		</div>
		
	</html:form>
	</div>
</body>
</html:html>
