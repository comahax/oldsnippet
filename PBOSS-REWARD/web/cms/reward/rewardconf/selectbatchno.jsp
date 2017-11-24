<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<title><bean:message bundle="batchno" key="title" />
		</title>
		<base target="_self">
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
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
			<html:form action="/cms/reward/batchno.do?CMD=Selectbatchno" styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				
				<html:hidden property="_rewardmonth" />
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
								<bean:message bundle="batchno" key="batchno" />
								:
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_batchno"></html:text>
							</td>
							<td width="20%"  height="20" align="right" class="form_table_right">
								<bean:message bundle="batchno" key="name" />
								:
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="_sk_name"></html:text>
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
									<bean:message bundle="batchno" key="batchno" />
								</td>
								<td>
									<bean:message bundle="batchno" key="name" />
								</td>
								<td>
									<bean:message bundle="batchno" key="remark" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<tr class="table_style_content" style="cursor:hand" align="center" onclick="selectRuleid('<c:out value="${item.batchno}"/>')">
									<td>
										<c:out value="${item.batchno}" />
									</td>
									<td>
										<c:out value="${item.name}" />
									</td>
									<td>
										<c:out value="${item.remark}" />
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
