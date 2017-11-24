<%@ page language="java" contentType="text/html;charset=GBK"%>
<%//  contenthead.inc是content.jsp的文件头，声明了JS、CSS等的引用，所有content.jsp必须引用这个文件头%>
<%@ include file="/inc/contenthead.inc"%>

<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="2B1A3CBB70" />
</jsp:include>
<%
	String ID_1 = "CH_PW_SALEWAY_EDIT";
%>

<html:html>
<head>
	<title>
		<bean:message bundle="saleway" key="titleUpdate" />
	</title>
	<script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
	<script language="JavaScript">
        <%//录入数据的校检%>
        function ev_checkval() {
        	if(date_compare('begintime', 'endtime', "合同到期日不能早于生效时间")){
            	return false;
            }
            if(document.all("compactpath").value == ""){
            	document.all("compactpath").value = document.all("compactfile").value;
            }
            if(document.all("licencepath").value == ""){
            	document.all("licencepath").value = document.all("licencefile").value;
            }
            //way
            addfield('wayid', '<bean:message bundle="saleway" key="wayid"/>', 'c', false , 18);
            
            //compact
            addfield('compactno', '<bean:message bundle="saleway" key="compactno"/>', 'c', false, 17);
            addfield('compactname', '<bean:message bundle="saleway" key="compactname"/>', 'c', false, 255);
            addfield('begintime', '<bean:message bundle="saleway" key="begintime"/>', 't', false);
            addfield('endtime', '<bean:message bundle="saleway" key="endtime"/>', 't', false);
            addfield('signtime', '<bean:message bundle="saleway" key="signtime"/>', 't', false);
            addfield('coptype', '<bean:message bundle="saleway" key="coptype"/>', 'i', true, 3);
            addfield('licenceno', '<bean:message bundle="saleway" key="licenceno"/>', 'c', false, 64);       
            addfield('bail', '<bean:message bundle="saleway" key="bail"/>', 'd', true, 18, 2);
            addfield('compactpath', '<bean:message bundle="saleway" key="compactpath"/>', 'c', false, 128);
            addfield('licencepath', '<bean:message bundle="saleway" key="licencepath"/>', 'c', false, 128);       
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
		<html:form action="/cms/saleway/compact.do?CMD=SAVE" styleId="formItem" method="post" enctype="multipart/form-data">
			<html:hidden property="cmdState" />
			<%//查询页面的参数，有了这些就能在增加，编辑时返回编辑前的正确页面%>
			<html:hidden property="_orderby" />
			<html:hidden property="_desc" />
			<html:hidden property="_pageno" />
			<html:hidden property="_pagesize" />
			<html:hidden property="compactpath" />
			<html:hidden property="licencepath" />
			<c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW' or param.CMD eq 'EDITNEW')}" />
			<c:set var="item" scope="request" value="${requestScope['/cms/waycompact/WaycompactForm']}"/>
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
								<bean:message bundle="saleway" key="compactno" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="compactno" maxlength="24" />
									<font color=red>
										&nbsp;*
									</font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="compactno" disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="compactname" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="compactname" maxlength="24" />
									<font color=red>
										&nbsp;*
									</font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="compactname" disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="begintime" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<input class="form_input_1x" name="begintime" value="<fmt:formatDate value="${item.begintime}" pattern="yyyy-MM-dd"/>" readonly onclick="this.value=selectDate();">
									<font color=red>
										&nbsp;*
									</font>
								</c:when>
								<c:otherwise>
									<input class="form_input_1x" name="begintime" value="<fmt:formatDate value="${item.begintime}" pattern="yyyy-MM-dd"/>" disabled>
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="endtime" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<input class="form_input_1x" name="endtime" value="<fmt:formatDate value="${item.endtime}" pattern="yyyy-MM-dd"/>" readonly onclick="this.value=selectDate();">
									<font color=red>
										&nbsp;*
									</font>
								</c:when>
								<c:otherwise>
									<input class="form_input_1x" name="endtime" value="<fmt:formatDate value="${item.endtime}" pattern="yyyy-MM-dd"/>" disabled>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="signtime" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<input class="form_input_1x" name="signtime" value="<fmt:formatDate value="${item.signtime}" pattern="yyyy-MM-dd"/>" readonly onclick="this.value=selectDate();">
									<font color=red>
										&nbsp;*
									</font>
								</c:when>
								<c:otherwise>
									<input class="form_input_1x" name="signtime" value="<fmt:formatDate value="${item.signtime}" pattern="yyyy-MM-dd"/>" disabled>
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="coptype" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:select property="coptype">
										<s:Options definition="$CH_COPTYPE"></s:Options>
									</html:select>
								</c:when>
								<c:otherwise>
									<html:select property="coptype" disabled="true">
										<s:Options definition="$CH_COPTYPE"></s:Options>
									</html:select>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="compactpath" />
								:
							</div>
						</td>
						<td nowrap align="left" colspan="3">
							<c:choose>
								<c:when test="${edtState}">
									<!--<html:file styleClass="form_input_files" property="compactfile" />-->
									<input class="form_input_2x" type="file" name="compactfile">
									<font color=red>
										&nbsp;*
									</font>
									<c:if test="${!empty item.compactpath}">
										<br/>
										<a href='<%=contextPath%>/cms/saleway/compact.do?CMD=DOWNLOAD&file=<c:out value="${item.compactpath}"/>' target="_blank">
											<c:out value="${item.compactpath}"/>
										</a>
									</c:if>
								</c:when>
								<c:otherwise>
									<c:if test="${!empty item.compactpath}">
										<a href='<%=contextPath%>/cms/saleway/compact.do?CMD=DOWNLOAD&file=<c:out value="${item.compactpath}"/>' target="_blank">
											<c:out value="${item.compactpath}"/>
										</a>
									</c:if>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="licencepath" />
								:
							</div>
						</td>
						<td nowrap align="left" colspan="3">
							<c:choose>
								<c:when test="${edtState}">
									<!--<html:file styleClass="form_input_files" property="licencefile" />-->
									<input class="form_input_2x" type="file" name="licencefile">
									<font color=red>
										&nbsp;*
									</font>
									<c:if test="${!empty item.licencepath}">
										<br/>
										<a href='<%=contextPath%>/cms/saleway/compact.do?CMD=DOWNLOAD&file=<c:out value="${item.licencepath}"/>' target="_blank">
											<c:out value="${item.licencepath}"/>
										</a>
									</c:if>
								</c:when>
								<c:otherwise>
									<c:if test="${!empty item.licencepath}">
										<a href='<%=contextPath%>/cms/saleway/compact.do?CMD=DOWNLOAD&file=<c:out value="${item.licencepath}"/>' target="_blank">
											<c:out value="${item.licencepath}"/>
										</a>
									</c:if>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="licenceno" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="licenceno" />
									<font color=red>
										&nbsp;*
									</font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="licenceno" disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="bail" />
								:
							</div>
						</td>
						<td width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="bail" />
									<font color=red></font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="bail" disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="bailstatus" />
								:
							</div>
						</td>
						<td width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:select property="bailstatus">
										<s:Options definition="$CH_BAILSTATUS"></s:Options>
									</html:select>
								</c:when>
								<c:otherwise>
									<html:select property="bailstatus" disabled="true">
										<s:Options definition="$CH_BAILSTATUS"></s:Options>
									</html:select>
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">&nbsp;</td>
						<td width="25%" align="left">&nbsp;</td>
					</tr>
				</table>
			</div>
			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
							<s:PurChk2 controlid="<%=ID_1%>" disableChild="true">
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_save"/>" class="submit"
									onclick="doSave('/cms/saleway/compact.do?CMD=SAVE')" />
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
