<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="4D1A1AAA" />
</jsp:include>
<%@ include file="/inc/contenthead.inc"%>
<html:html>
<head>
	<title><bean:message bundle="acctincome" key="title3" />
	</title>
	<script language="JavaScript">
        function ev_checkval() {  
            addfield('acctid', '<bean:message bundle="acctincome" key="acctid"/>', 'l', false, 14);
            addfield('accttype', '<bean:message bundle="acctincome" key="accttype"/>', 'l', false, 3);
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
		<html:form
			action="/qsmanage/paramsmanage/acctgroup.do?CMD=ACCTTYPEREL"
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
			

			<input type="hidden" name="_rowcount" />



			<c:set var="edtState" scope="request"
				value="${!empty CMD and CMD eq 'ACCTTYPEREL'}" />

			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="acctincome" key="title3" />
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
							<bean:message bundle="acctincome" key="acctid" />
							:
							<div class="field-require"></div>
						</td>
						<td class="form_table_left">

							<html:text styleClass="form_input_1x" property="acctid" maxlength="14" />
							<bean:message bundle="fee" key="redStar" />


						</td>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="acctincome" key="accttype" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<html:select property="accttype">
								<html:option value=" "></html:option>
								<s:Options definition="$IB_ACCTTYPEREL" />
							</html:select>
							<bean:message bundle="fee" key="redStar" />
						</td>
					</tr>

				</table>
			</div>


			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>

							<c:choose>
								<c:when test="${edtState}">
									<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnSave"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_save"/>"
										class="submit"
										onclick="doSave('/qsmanage/paramsmanage/acctgroup.do?CMD=ACCTTYPEREL')" />
								</c:when>
								<c:otherwise>
									<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnSave"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_save"/>"
										class="submit" disabled="true"
										onclick="doSave('/qsmanage/paramsmanage/acctgroup.do?CMD=ACCTTYPEREL')" />
								</c:otherwise>
							</c:choose>

									<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnReturn"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_nextstep"/>"
										class="button_3"
										onclick="doNext('/qsmanage/paramsmanage/acctgroup.do?CMD=NEXT')">
						</td>
					</tr>
				</table>
			</div>
		</html:form>
	</div>
</body>
</html:html>
