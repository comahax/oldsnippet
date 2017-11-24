<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<title><s:text name="titleList" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
    </script>
    
<style type="text/css"> 
.table_style {
	width:100%;
	border:#CDCDCD solid 0px;
	border-collapse:collapse;
}
</style>
	</head>

	<body leftmargin="5" topmargin="0" bottommargin="0">
		<s:form action="advinfo_list.do" key="formList" cssStyle="formList"
			theme="simple" onsubmit="return ev_check();">
			<%
			//下面的控件给Action提供数据，用来分页
			%>
			<aa:zone name="hiddenZone"><s:hidden name="param._orderby"/>
			<s:hidden name="param._desc" />
			<s:hidden name="param._pageno" />
			<s:hidden name="param._pagesize" />
			<s:hidden name="param.queryAll" />
			<input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/></aa:zone>

			<div class="table_top">
				<div class="table_topleft"></div>
				<div class="table_toparea_w">
					<s:i18n name="public">
						<span class="table_toparea"><s:text name="currentPos" /> </span>
						<span class="table_toparea_xi">></span>
					</s:i18n>
					<span class="table_toparea_h">待办任务</span>
				</div>
			</div>


			<div class="table_div">
					<table class="table_style">
						<tr class="table_style_head">
							<td>
								<s:text name="title" />
							</td>
							<td>
								<j:orderByImg href="javascript:doOrderby('releasetime')"><s:text name="releasetime" /></j:orderByImg>   
							</td>
							<td>
								<j:orderByImg href="javascript:doOrderby('plantime')"><s:text name="plantime" /></j:orderByImg>   
							</td>
							<td>
								<s:text name="smsnotify" />
							</td>
							<%--<td>
								<s:text name="ndapproval" />
							</td>
							--%><td>
								<s:text name="oprcode" />
							</td>
							<td>
								<s:text name="state" />
							</td>
						</tr>
						<s:iterator value="dp.datas">
							<tr class="table_style_content"align="center">
								<%-- 复合主键用“|”间隔开 --%>
								<td>
									<span STYLE="overflow:hidden; text-overflow:ellipsis; white-space:nowrap;width:300px" title="<s:property value="title"/>"/>
									<a href='<s:property value="url" />&formType=ADVINFO'><s:property value="title" /></a>
									</span>
								</td>
								<td>
									<s:date name="releasetime" format="yyyy-MM-dd" />
								</td>
								<td>
									<s:date name="plantime" format="yyyy-MM-dd" />
								</td>
								<td>
									<j:code2Name definition="SMSNOTIFY" code="smsnotify" />
								</td>
								<%--<td>
									<j:code2Name definition="NDAPPROVAL" code="ndapproval" />
								</td>
								--%><td>
									<s:property value="oprcode" />
								</td>
								<td>
									<j:code2Name definition="$CH_ADVRVCTYPE" code="state" />
								</td>

							</tr>
						</s:iterator>
					</table>
			</div>
			<div class="table_div">
				<%@ include file="/common/pageNav.jsp"%>
			</div>
			
		</s:form>
	</body>
</html>
