<%@ page language="java" contentType="text/html;charset=GBK"%>

<%@ include file="/inc/listhead.inc"%>
<script type="text/javascript" src="<%=contextPath%>/js/pub/xmlhttp.js"></script>
<link href="<%=contextPath%>/css/css_1/xmlhttp.css" rel="stylesheet"
	type="text/css" media="all" />
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="1A2BA0G0" />
</jsp:include>
<html>
	<head>
		<title><bean:message bundle="acctgroup" key="titleList" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('matchid', '<bean:message bundle="acctgroup" key="matchid"/>', 'c', false, 14);
            addfield('chgreason', '<bean:message bundle="acctgroup" key="chgreason"/>', 'c', false, 256);
            if(formList.matchid.value == null || formList.matchid.value == ""){
            	alert("请选择关联标识");
            	return false;
            }
            return checkval(window);
        }
        
        function doSet(){
        	if(ev_check()){
        		formList.action="<%=contextPath%>/qsmanage/paramsmanage/acctgroup.do?CMD=SET";
        		formList.submit();
        	}
        }
		
		 function doajax(myself,myurl,myobj) {
		 	myurl = contextPath + myurl;
			startAjax(myurl,"get('"+myobj+"')","text","get")
		}
		
		function get(obj) {
			var mc=unescape(mypoint);
			formList.matchid.value=mc;
		}
		
    </script>
	</head>

	<body onload="doajax(this,'/qsmanage/paramsmanage/acctgroup.do?CMD=MATCHID','matchid');loadforiframe();">
		<div class="table_container">
			<html:form action="/qsmanage/paramsmanage/acctgroup.do?CMD=SET"
				styleId="formList" method="post" onsubmit="return ev_check();">


				<div class="table_div">
					<table class="error_text">
						<html:errors />
						<s:Msg />
					</table>
				</div>

				<DIV class=table_div>
					<TABLE class=top_table>
						<TBODY>
							<TR>
								<TD>
									<bean:message bundle="acctgroup" key="titleList" />
								</TD>
							</TR>
						</TBODY>
					</TABLE>
				</DIV>


				<div class="table_div">
					<table class="form_table">

						<tr>
							<td class="form_table_right">
								<div class="field-require">
									<bean:message bundle="acctgroup" key="chgreason" />
									:
								</div>
							</td>
							<td class="form_table_left" colspan="3">
								<html:textarea property="chgreason"
									styleClass="form_textarea_on" />
								<bean:message bundle="fee" key="redStar" />
							</td>
						</tr>

						<tr>
							<td class="form_table_right">
								<bean:message bundle="acctgroup" key="matchid" />
								:
								<div class="field-require"></div>
							</td>
							<td class="form_table_left">
								<div id="matchid">
									<html:text styleClass="form_input_1x" property="matchid"
										onclick="doajax(this,'/qsmanage/paramsmanage/acctgroup.do?CMD=MATCHID','matchid')" />
									<bean:message bundle="fee" key="redStar" />
								</div>
							</td>
						</tr>
					</table>
				</div>

				<DIV class=table_div>
					<TABLE class=table_button_list>
						<TBODY>
							<TR>
								<TD>
									<input type="button" class="button_4"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_set"/>"
										onclick="doSet();" />
								</TD>
							</TR>
						</TBODY>
					</TABLE>
				</DIV>

			</html:form>
		</div>
	</body>
</html>
