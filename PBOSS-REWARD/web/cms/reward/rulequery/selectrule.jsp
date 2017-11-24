<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<title><bean:message bundle="rule2" key="title" />
		</title>
		<base target="_self">
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_ruleid', '<bean:message bundle="rule2" key="ruleid"/>', 'c', true, '18');
            addfield('_sk_rulename', '<bean:message bundle="rule2" key="rulename"/>', 'c', true, '60');
            addfield('_se_opnid', '<bean:message bundle="rule2" key="opnid"/>', 'c', true, '18');
            return checkval(window);
        }
	    
	    function selectRuleid(ruleid) {
	    	ruleid = ruleid==null?"":ruleid;
	    	window.returnValue = ruleid;
	    	window.close();
	    }
    </script>
	</head>

	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/reward/rule2.do?CMD=SELECTRULE" styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table width="100%" class="error_text">
						<html:errors />
						<s:Msg />
					</table>
				</div>
				<div class="table_div">
					<table class="form_table">
						<tr>
							<td width="20%" height="20" align="right" class="form_table_right">
								<bean:message bundle="rule2" key="opnid" />
								:
							</td>
							<td width="80%" class="form_table_left" colspan="3">
								<html:text styleClass="form_input_1x" property="_se_opnid" readonly="true" />
							</td>
						</tr>
						<tr>
							<td width="20%" height="20" align="right" class="form_table_right">
								<bean:message bundle="rule2" key="ruleid" />
								:
							</td>
							<td width="25%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_ruleid"></html:text>
							</td>
							<td width="20%"  height="20" align="right" class="form_table_right">
								<bean:message bundle="rule2" key="rulename" />
								:
							</td>
							<td width="25%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="_sk_rulename"></html:text>
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>
								<input type="button" value="<bean:message bundle="public" key="button_search"/>" onclick="doQuery();" class="comfir" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this);" onblur="buttonout(this)"  />
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">
							<tr class="table_style_head">
								<td>
									<bean:message bundle="rule2" key="ruleid" />
								</td>
								<td>
									<bean:message bundle="rule2" key="rulename" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<tr class="table_style_content" style="cursor:hand" align="center" onclick="selectRuleid('<c:out value="${item.ruleid}"/>')">
									<td>
										<c:out value="${item.ruleid}" />
									</td>
									<td>
										<c:out value="${item.rulename}" />
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>

				<div class="table_div">
					<s:PageNav dpName="LIST" />
				</div>
			</html:form>
		</div>
	</body>
</html>
