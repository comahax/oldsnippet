<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList2"/></title>

</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="adpaysum_detail.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList2"/></span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
		</div>
	</div>
    
    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>
    
    <div class="table_div">
    	
        <table class="table_normal">
    		<tr class="table_style_content" align="center" >
    			<td align="right">汇总单号：</td>
    			<td align="left"><s:property value="form.sumid"/></td>
    			<td align="right">配送商：</td>
    			<td><j:code2Name code="form.discomcode" definition="#WAYIDINFO"/></td>
    		</tr>
			<tr class="table_style_content" align="center" >
    			<td align="right">开始时间：</td>
    			<td><s:date format="yyyy-MM-dd HH:mm:ss" name="form.begintime"/></td> 
    			<td align="right">结束时间：</td>
    			<td><s:date format="yyyy-MM-dd HH:mm:ss" name="form.endtime"/></td>
    		</tr>
    	</table>
    	
    </div>    	

	<aa:zone name="listZone">
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style">
            <tr class="table_style_head">
                <td> 序号</td><td>订单编号</td><td>合作商</td><td>订购时间</td><td>应收金额</td>
            </tr>
            <s:iterator value="dp.datas" status="state">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td><s:text name="#state.count"/></td>
                     <td><s:property value="orderid" /></td>
                     <td><j:code2Name code="wayid" definition="#WAYIDINFO"/></td>
                     <td><s:date format="yyyy-MM-dd HH:mm:ss" name="createtime"/></td>
                     <td><s:property value="recamt" /></td>
                 </tr>
             </s:iterator>
        </table>
        </div>
    </div>
    <div class="table_div">
		<%@ include file="/common/pageNav.jsp"%>
   	</div>
    </aa:zone>
</s:form>
</div>
</body>
</html>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 

