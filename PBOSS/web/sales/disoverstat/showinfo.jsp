<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
	 function doExcel(ss){
        var	str="<%=contextPath%>"+ss;
        	window.navigate(str);
        }
        
</script>
</head>
<body>
<div class="table_container">
<s:form action="disoverstat_showdialog.do" cssStyle="formList" key="formList"
			method="post" theme="simple">
	<aa:zone name="listZone">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
	<input type="hidden" name="param._pk"
						value="${sessionScope.statseqid }" />
	<input type="hidden" name="param.countt1"
						value="${sessionScope.countt1 }" />
	<input type="hidden" name="_rowcount"
						value="<s:property value="dp.rowCount" />" />
						
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style">
            <tr class="table_style_head">
                <td>
                   序号  
                </td>
                <td>
                    分公司                 
                </td>
                <td>
                    微区域                 
                </td>
                <td>
                    统计日期                 
                </td>
                <td>
                    超时时间(小时)                 
                </td>
                <td>
                   订单号                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                   
                     <td>
							<s:property value="seqid"/>
					 </td>
					<td>
						<j:code2Name code="form.countyid" definition="#CNTYCOMPANY" />
					</td>
					<td>
						<j:code2Name code="form.mareacode" definition="#MICROAREA" />
					</td>
					<td>
						<s:date name="form.statdate" format="yyyy-MM-dd" />
					</td>
                     <td><s:property value="overhour" /></td>
                     <td><s:property value="orderid" /></td>
                 </tr>
             </s:iterator>
        </table>
        </div>
    </div>
    <div class="table_div">
		<%@ include file="/common/pageNav.jsp"%>
   	</div>
    <div class="table_div">
		<s:i18n name="public">
		<input type="button" id="btnExportexcel" name="btnExportexcel"
			class="button_4" onmouseover="buttonover(this);"
			onmouseout="buttonout(this);" onfocus="buttonover(this)"
			onblur="buttonout(this)"
			value="<s:text name="button_exportexcel"/>"
			onClick="doExcel('/sales/disoverstat_exportExcel.do')">
			
		<input type="button" 
			class="button_4" onmouseover="buttonover(this);"
			onmouseout="buttonout(this);" onfocus="buttonover(this)"
			onblur="buttonout(this)"
			value="关闭"
			onClick="javascript:window.close();">			
			</s:i18n>
   	</div>
    </aa:zone>
</s:form>
</div>
</body>
</html>