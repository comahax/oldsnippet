<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="4D1A1AAA" />
</jsp:include>
<%@ include file="/inc/contenthead.inc"%>
<html:html>
<head>
	<title><bean:message bundle="brandmode" key="title2" />
	</title>
	<script language="JavaScript">
        function ev_checkval() {  
           	addfield('brand', '<bean:message bundle="brandmode" key="brand"/>', 'c', false, 16);
            addfield('prodid', '<bean:message bundle="brandmode" key="prodid"/>', 'c', false, 32);
            addfield('segid', '<bean:message bundle="brandmode" key="brand"/>', 'c', false, 32);
            addfield('mode', '<bean:message bundle="brandmode" key="mode"/>', 'c', false, 16);
            addfield('memo', '<bean:message bundle="brandmode" key="memo"/>', 'c', true, 128);
            return checkval(window);
        }
    </script>
</head>
<body onload="loadforiframe();">
	<div class="table_container">
		<html:form action="/fee/woff/brandmode.do?CMD=SAVE"
			styleId="formItem" method="post">

			<html:hidden property="cmdState" />

			<html:hidden property="_orderby" />
			<html:hidden property="_desc" />
			<html:hidden property="_pageno" />
			<html:hidden property="_pagesize" />

			<input type="hidden" name="_rowcount" />



			<c:set var="edtState" scope="request"
				value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}" />
			<c:set var="new" scope="request"
				value="${!empty param.CMD and param.CMD eq 'NEW'}" />

			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="brandmode" key="title2" />
						</td>

					</tr>
				</table>
			</div>
			<div class="table_div">
				<table class="error_text">
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
						<td class="form_table_right">
							<bean:message bundle="brandmode" key="brand" />
							:
							<div class="field-require"></div>
						</td>
						<td class="form_table_left">

							<c:choose>
								<c:when test="${edtState and new}">
									 <s:zoom definition="$ProductBrand" property="brand" styleClass="form_input_1x"/>
									<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:otherwise>
									 <s:zoom definition="$ProductBrand" property="brand" styleClass="form_input_1x" disabled="true" />
									<bean:message bundle="fee" key="redStar" />
								</c:otherwise>
							</c:choose>


						</td>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="brandmode" key="prodid" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState and new}">
								<s:zoom definition="#PRODUCT" property="prodid" styleClass="form_input_1x" condition="mainprod:${1};"/>
								<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:otherwise>
								<s:zoom definition="#PRODUCT" property="prodid" styleClass="form_input_1x"  condition="mainprod:${1};" disabled="true" />
								<bean:message bundle="fee" key="redStar" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					
					
					<tr>
						<td class="form_table_right">
							<bean:message bundle="brandmode" key="segid" />
							:
							<div class="field-require"></div>
						</td>
						<td class="form_table_left">

							<c:choose>
								<c:when test="${edtState and new}">
									 <html:text styleClass="form_input_1x" property="segid"></html:text>
									<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:otherwise>
									 <html:text styleClass="form_input_1x" property="segid" disabled="true" ></html:text>
									<bean:message bundle="fee" key="redStar" />
								</c:otherwise>
							</c:choose>


						</td>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="brandmode" key="mode" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
								<html:select property="mode">
								<html:option value=" "></html:option>
								<s:Options definition="#BRANDMODE" />
							</html:select>
							<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:otherwise>
								<html:select property="mode" disabled="true" >
								<html:option value=" "></html:option>
								<s:Options definition="#BRANDMODE" />
									</html:select>
									<bean:message bundle="fee" key="redStar" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>  
            	<td class="form_table_right"><div class="field-require"><bean:message bundle="brandmode" key="memo"/>:</div></td>
                <td colspan="4">                    
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:textarea  property="memo" styleClass="form_textarea_on"/>
                        </c:when>
                        <c:otherwise>
                            <html:textarea  property="memo" styleClass="form_textarea_on" disabled="true"/>
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
							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnSave"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="public" key="button_submit"/>"
								class="submit"
								onclick="doSave('/fee/woff/brandmode.do?CMD=SAVE')" />
							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnReturn"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="public" key="button_return"/>"
								class="close"
								onclick="doReturn('/fee/woff/brandmode.do?CMD=LIST')">
						</td>
					</tr>
				</table>
			</div>
		</html:form>
	</div>
</body>
</html:html>
