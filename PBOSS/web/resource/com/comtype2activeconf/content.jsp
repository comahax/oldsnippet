<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
	String ID_1 = "COMTYPE2ACTIVE";
%>
<html:html>
<head>
	<title><bean:message bundle="com" key="comtype2activeconf2" /></title>
	<script language="JavaScript">
        function ev_checkval() {
        	addfield('comtype', '<bean:message bundle="com" key="comtype" />', 'i', false, 6);
        	addfield('activeconfig', '<bean:message bundle="com" key="activeconfig" />', 'i', false, 3);
          	return checkval(window);
        }
    </script>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
</head>

<body onload="loadforiframe()">
	<div class="table_container">
		<html:form action="/resmanage/com/comtype2activeconf.do?CMD=SAVE" styleId="formItem" method="post" onsubmit="return ev_check();">

			<html:hidden property="cmdState" />
			<html:hidden property="_orderby" />
			<html:hidden property="_desc" />
			<html:hidden property="_pageno" />
			<html:hidden property="_pagesize" />
			
			<c:set var="newState" scope="request" value="${!empty param.CMD and param.CMD eq  'NEW'}" />
			<c:set var="edtState" scope="request" value="${!empty param.CMD and param.CMD eq 'EDIT'}" />

			<div class="table_div">
				<table class="top_table" border=0>
					<tr>
						<td>
							<bean:message bundle="com" key="comtype2activeconf2" />
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
								<bean:message bundle="com" key="comtype" />
								:
							</div>
						</td>
						<td width="30%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${newState}">
									<html:select property="comtype">
										<option value="" />
										<s:Options definition='$IM_COMTYPE' nameOnly="false" />
									</html:select>
								</c:when>
								<c:when test="${edtState}">
									<html:select property="comtype" disabled="true">
										<s:Options definition='$IM_COMTYPE' nameOnly="false" />
									</html:select>
								</c:when>
								<c:otherwise>
									<html:select property="comtype" disabled="true">
										<s:Options definition='$IM_COMTYPE' nameOnly="false" />
									</html:select>
								</c:otherwise>
							</c:choose>
							<bean:message bundle="fee" key="redStar" />
						</td>
						
						
						<td width="20%" align="right" class="form_table_right">
							<div class="field-require">
								<bean:message bundle="com" key="activeconfig" />
								:
							</div>
						</td>
						<td width="30%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${newState}">
									<html:select property="activeconfig" >
										<html:option value=""></html:option>
										<html:option value="0">0 否(不可配置)</html:option>
									    <html:option value="1">1 是(不可配置)</html:option>
									    <s:FramePurChk pageid="<%=ID_1%>">
									    	<html:option value="2">2 是(可配置)</html:option>
									    	<html:option value="3">3 否(可配置)</html:option>
									    </s:FramePurChk>
									</html:select>
								</c:when>
								<c:when test="${edtState}">
									<html:select property="activeconfig" >
										<html:option value=""></html:option>
										<html:option value="0">0 否(不可配置)</html:option>
									    <html:option value="1">1 是(不可配置)</html:option>
									    <s:FramePurChk pageid="<%=ID_1%>">
									    	<html:option value="2">2 是(可配置)</html:option>
									    	<html:option value="3">3 否(可配置)</html:option>
									    </s:FramePurChk>
									</html:select>
								</c:when>
								<c:otherwise>
									<html:select property="activeconfig" disabled="true">
										<html:option value=""></html:option>
										<html:option value="0">0 否(不可配置)</html:option>
									    <html:option value="1">1 是(不可配置)</html:option>
									    <s:FramePurChk pageid="<%=ID_1%>">
									    	<html:option value="2">2 是(可配置)</html:option>
									    	<html:option value="3">3 否(可配置)</html:option>
									    </s:FramePurChk>
									</html:select>
								</c:otherwise>
							</c:choose>
							<bean:message bundle="fee" key="redStar" />
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
							 	   value="<bean:message bundle="public" key="button_save"/>"
							  	   class="submit" onclick="doSave('/resmanage/com/comtype2activeconf.do?CMD=SAVE')" />

							<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnReturn"
								   onfocus="buttonover(this)" onblur="buttonout(this)" 
								   value="<bean:message bundle="public" key="button_return"/>"
								   class="close" onclick="doReturn('/resmanage/com/comtype2activeconf/list.jsp')" />
					
						</td>
					</tr>
				</table>
			</div>
		</html:form>
	</div>
</body>
</html:html>
