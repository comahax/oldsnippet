<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>

<html>
	<head>
		<title><bean:message bundle="zjtyrewardcoef" key="titleList" />
		</title>
		<base target="_self">

		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            
            return checkval(window);
        }
        window.returnValue = "";
        function getValue(){
			window.returnValue = formList.ispass.value;
	   		window.close();
 		}
       
    </script>
	</head>

	<body onload="loadforiframe();"
		onclose="javascript:window.returnValue = ''">
		<div class="table_container">
			<html:form action="/cms/zjty/zjtyrewardcoef.do?CMD=AUDIT"
				styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<input type="hidden" name="_rowcount"
					value="<c:out value='${requestScope.LIST.rowCount}' />">

				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="zjtyrewardcoef" key="titleList" />
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="form_table">
						<tr>

							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="zjtyrewardcoef" key="ispass" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="ispass">
									<html:option value="">
									</html:option>
									<html:option value="0">
										<bean:message bundle="zjtyrewardcoef" key="failure" />
									</html:option>
									<html:option value="1">
										<bean:message bundle="zjtyrewardcoef" key="pass" />
									</html:option>
			

								</html:select>
							</td>
							<td>
								<input type=button class="button_5"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="È·¶¨"
									onclick="getValue()">
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
	</body>
</html>
