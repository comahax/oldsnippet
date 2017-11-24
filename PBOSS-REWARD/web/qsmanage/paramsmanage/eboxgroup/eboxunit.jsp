<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="4D6F1A2BAA" />
</jsp:include>
<%
	String ID_1 = "4D6F1A2BAABT1";
	String ID_2 = "4D6F1A2BAABT2";
	String ID_3 = "4D6F1A2BAABT3";
%>
<html:html>
<head>
	<title><bean:message bundle="eboxunit" key="titleUpdate" />
	</title>
	<script language="JavaScript">
        function ev_checkval() {
            addfield('eboxunitid', '<bean:message bundle="eboxunit" key="eboxunitid"/>', 'l', false, 14);
            addfield('eboxunitname', '<bean:message bundle="eboxunit" key="eboxunitname"/>', 'c', false, 256);
            addfield('eboxunittype', '<bean:message bundle="eboxunit" key="eboxunittype"/>', 'i', false, 3);
            addfield('eboxunitstate', '<bean:message bundle="eboxunit" key="eboxunitstate"/>', 'i', false, 1);
            addfield('canwithd', '<bean:message bundle="eboxunit" key="canwithd"/>', 'i', false, 1);
            addfield('canprintinv', '<bean:message bundle="eboxunit" key="canprintinv"/>', 'i', false, 1);
            addfield('isneedpayway', '<bean:message bundle="eboxunit" key="isneedpayway"/>', 'i', false, 1);
            addfield('canjiezhuan', '<bean:message bundle="eboxunit" key="canjiezhuan"/>', 'i', false, 1);
            addfield('iscommon', '<bean:message bundle="eboxunit" key="iscommon"/>', 'i', false, 1);
            addfield('canwoff', '<bean:message bundle="eboxunit" key="canwoff"/>', 'i', false, 1);
            addfield('woffpri', '<bean:message bundle="eboxunit" key="woffpri"/>', 'l', false, 14);
            addfield('canpaybehalf', '<bean:message bundle="eboxunit" key="canpaybehalf"/>', 'i', false, 1);
            addfield('brand', '<bean:message bundle="eboxunit" key="brand"/>', 'c', true, 16);
            return checkval(window);
        }
        
        function doNext(url){
      		var isnew = document.formItem.cmdState.value ;
      		if(isnew == 'NEW'){
      			if(confirm("本菜单尚未进行参数设置，是否放弃进入下一步？")){
      				formItem.action = contextPath + url;
      				formItem.submit();
      			}
      		}else{
      			formItem.action = contextPath + url;
      			formItem.submit();
      		}
      	}
    </script>
</head>
<body onload="loadforiframe();">
	<div class="table_container">
		<html:form action="/qsmanage/paramsmanage/eboxgroup.do?CMD=EBOXUNIT"
			styleId="formItem" method="post">
			<html:hidden property="cmdState" />

			<html:hidden property="_orderby" />
			<html:hidden property="_desc" />
			<html:hidden property="_pageno" />
			<html:hidden property="_pagesize" />
			<html:hidden property="curmenu" />
			<html:hidden property="menulist" />
			<html:hidden property="matchid" />
			<html:hidden property="chgreason" />
			<c:set var="edtState" scope="request"
				value="${!empty CMD and CMD eq 'EBOXUNIT' }" />

			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="eboxunit" key="custMsg" />
						</td>
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
						<td align=left colspan=6>
							<bean:message bundle="fee" key="redStarExplain" />
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="eboxunit" key="eboxunitid" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<html:text styleClass="form_input_1x" property="eboxunitid"
								maxlength="14" />
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="eboxunit" key="eboxunitname" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<html:text styleClass="form_input_1x" property="eboxunitname"
								maxlength="256" />
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="eboxunit" key="eboxunittype" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<html:select property="eboxunittype">
								<html:option value=" "></html:option>
								<s:Options definition="$IB_EBOXUNITTYPE" nameOnly="false" />
							</html:select>
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="eboxunit" key="eboxunitstate" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<html:select property="eboxunitstate">
								<html:option value=" "></html:option>
								<s:Options definition="$IB_USABLEFLAG" nameOnly="false" />
							</html:select>
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="eboxunit" key="canwithd" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<html:select property="canwithd">
								<html:option value=" "></html:option>
								<s:Options definition="$IM_YESNO10" nameOnly="false" />
							</html:select>
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="eboxunit" key="canprintinv" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<html:select property="canprintinv">
								<html:option value=" "></html:option>
								<s:Options definition="$IM_YESNO10" nameOnly="false" />
							</html:select>
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="eboxunit" key="isneedpayway" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<html:select property="isneedpayway">
								<html:option value=" "></html:option>
								<s:Options definition="$IM_YESNO10" nameOnly="false" />
							</html:select>
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="eboxunit" key="canjiezhuan" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<html:select property="canjiezhuan">
								<html:option value=" "></html:option>
								<s:Options definition="$IM_YESNO10" nameOnly="false" />
							</html:select>
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="eboxunit" key="iscommon" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<html:select property="iscommon">
								<html:option value=" "></html:option>
								<s:Options definition="$IB_ISCOMMON" nameOnly="false" />
							</html:select>
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="eboxunit" key="canwoff" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<html:select property="canwoff">
								<html:option value=" "></html:option>
								<s:Options definition="$IM_YESNO10" nameOnly="false" />
							</html:select>
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="eboxunit" key="woffpri" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<html:text styleClass="form_input_1x" property="woffpri"
								maxlength="14" />
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="eboxunit" key="canpaybehalf" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<html:select property="canpaybehalf">
								<html:option value=" "></html:option>
								<s:Options definition="$IM_YESNO10" nameOnly="false" />
							</html:select>
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="eboxunit" key="billitemid" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<s:zoom definition="#PRINT-BILLITEMNAME" property="billitemid"
								condition="type:3" styleClass="form_input_1x" />
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="eboxunit" key="brand" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<html:select property="brand">
								<html:option value=" "></html:option>
								<s:Options definition="$ProductBrand" nameOnly="false" />
							</html:select>
						</td>
					</tr>
				</table>
			</div>

			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td width="100%" class="form_table_center">

							<c:choose>
								<c:when test="${edtState}">
									<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnSave"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_save"/>"
										class="submit"
										onclick="doSave('/qsmanage/paramsmanage/eboxgroup.do?CMD=EBOXUNIT')" />
								</c:when>
								<c:otherwise>
									<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnSave"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_save"/>"
										class="submit" disabled="true"
										onclick="doSave('/qsmanage/paramsmanage/eboxgroup.do?CMD=EBOXUNIT')" />
								</c:otherwise>
							</c:choose>

									<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnReturn"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_nextstep"/>"
										class="button_3"
										onclick="doNext('/qsmanage/paramsmanage/eboxgroup.do?CMD=NEXT')">
						</td>
					</tr>
				</table>
			</div>

		</html:form>
	</div>
</body>
</html:html>
