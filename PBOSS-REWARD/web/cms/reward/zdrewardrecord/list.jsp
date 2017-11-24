<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@page import="com.sunrise.boss.common.base.db.DataPackage"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<%
	DataPackage bean1 = (DataPackage) pageContext.getRequest().getAttribute("LIST");
	if (null != bean1 && null != bean1.getDatas()) {
		int currentPage1 = bean1.getPageNo();
		int rowCount1 = bean1.getRowCount();
		int totalPage1 = (int) Math.ceil(((double) rowCount1) / ((double) bean1.getPageSize()));
		request.setAttribute("currentPage1", currentPage1);
		request.setAttribute("rowCount1", rowCount1);
		request.setAttribute("totalPage1", totalPage1);
	}
 %>
<html>
<head>
    <title>终端酬金结果查询</title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('_se_calcmonth', '结算月份', 'c', false, '6');
            addfield('_se_wayid', '渠道编码', 'c', true, '18');
            addfield('_se_oprcode', '业务发生工号', 'c', true, '15');
            addfield('_se_mobile', '业务发生号码', 'c', true, '15');
            addfield('_dnm_oprtime', '业务发生时间<=', 'dt', true, '7');
            addfield('_dnl_oprtime', '业务发生时间>=', 'dt', true, '7');
            addfield('_se_batchno', '批次号', 'c', true, '18');
            addfield('_se_bakinfo', 'IMEI', 'c', true, '18');
            addfield('_se_zdreward', '终端类型', 'c', false, '15');
            addfield('_ne_noncyc', '酬金类型', 'f', false, '3');
            addfield('_se_repairmonth', '补算月份', 'c', true, '6');
            return checkval(window);
        }
        
        function exports(mothed){
        	if (ev_check()) {
        		errorobj.innerHTML = "";
        		var form = document.forms[0];
				form.action = "<%=contextPath%>/cms/reward/zdrewardrecord.do?CMD=" + mothed;
				form.submit();
				form.action = "<%=contextPath%>/cms/reward/zdrewardrecord.do?CMD=LIST";
        	}
		}
		
		function zdRewardChange() {
			document.getElementById("query").value = false;
			document.forms[0].submit();
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/zdrewardrecord.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="query" styleId="query" value="true"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/zdrewardrecord/ZdrewardrecordForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>终端酬金结果查询</td>
    	</tr>
    </table>
    </div>
    <div class="table_div">	
   		 <table width="100%" class="error_text">
    		<html:errors/><s:Msg />
    	</table>
    </div>
	<div class="table_div">
        <table class="form_table">
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" >结算月份:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_calcmonth" onclick="this.value=selectDateYYYYMM(this.value);"></html:text>
                <font color=red>*</font></td>
                <td width="20%" height="20" align="right" class="form_table_right" >渠道编码:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid" onclick="showSelectWay(this,'_se_wayid')"></html:text>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" >业务发生时间>=:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_oprtime" onclick="this.value=selectDatetime();"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" >业务发生时间<=:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_oprtime" onclick="this.value=selectDatetime();"></html:text>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" >业务发生号码:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_mobile"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" >批次号:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_batchno"></html:text>
                </td>
            </tr>
            <tr>
                
                <td width="20%" height="20" align="right" class="form_table_right" >IMEI:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_bakinfo"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" >业务发生工号:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_oprcode"></html:text>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" >终端类型:</td>
            	<td width="30%" class="form_table_left">
               		<html:select styleClass="form_input_1x" property="_se_zdreward" onchange="zdRewardChange()">
						<html:options collection="zdrewardList" property="code" labelProperty="name"/>
					</html:select>
            	</td>
                <td width="20%" height="20" align="right" class="form_table_right" >结算期数:</td>
                <td width="30%" class="form_table_left">
                    <html:select styleClass="form_input_1x" property="_ne_noncyc">
						<html:options collection="noncycList" property="code" labelProperty="name"/>
					</html:select>
                </td>
            </tr>
             <tr>
               <td width="20%" height="20" align="right" class="form_table_right" >补算月份:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_repairmonth" onclick="this.value=selectDateYYYYMM(this.value);"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ></td>
                <td width="30%" class="form_table_left">
                </td>
                </tr>
        </table>
    </div>
	<div class="table_div">
		<table style="width: 98%; font-size: 12px; border:#72FF00 solid 0px; margin-bottom:3px;">
			<tr> 
                <td align="left">
                <c:choose>
				    <c:when test="${!empty requestScope.LIST.datas}">
						<bean:message bundle="public" key="button_total_page" />
						<font color="red"><c:out value='${rowCount1}' /></font> 项数据
						&nbsp;
						<bean:message bundle="public" key="button_total_page" />
						<font color="red"><c:out value="${totalPage1}" /></font>
						<bean:message bundle="public" key="button_page" />
						&nbsp;
						<bean:message bundle="public" key="button_current_page" />
						<font color="red"><c:out value="${currentPage1}" /></font>
						<bean:message bundle="public" key="button_page" />
				    </c:when>
				</c:choose>
				</td>
                <td align=right>
					<input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
						onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
						value="<bean:message bundle="public" key="button_search"/>" />
					<input type="button" class="button_2" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="导出" onclick="exports('TOTXT')"/>
                    <input type="button" class="button_6" value="一键打包下载" class="comfir"  
                   		onmouseover="buttonover(this)" onclick="exports('DOWNLOAD');"
                   		onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)" >
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>流水号</td>
				<td>结算月份</td>
				<td>全省业务编码</td>
				<td>业务名称</td>
				<td>渠道编码</td>
				<td>渠道名称</td>
				<td>业务发生工号</td>
				<td>业务发生号码</td>
				<td>业务发生时间</td>
				<td>校验时间</td>
				<td>校验规则编码</td>
				<td>成功失败结果标识</td>
				<td>稽核结果标识</td>
				<td>校验结果编码</td>
				<td>校验结果描述</td>
				<td>酬金类型</td>
				<td>计算标识</td>
				<td>补算月份</td>
				<td>批次号</td>
				<td>IMEI</td>
				<td>商品ID</td>
				<td>商品名称</td>
				<td>商品协议价</td>
				<td>承诺低消</td>
				<td>酬金期数</td>
				<td>应发酬金</td>
				<td>计算酬金</td>
				<td>实发酬金</td>
				<td>考核系数2</td>
				<td>产品ID</td>
				<td>基准价</td>
				<td>酬金点数</td>
				<td>终端制式</td>
				<td>流量</td>
				<td>ARPU值</td>
				<td>优质客户</td>
				<td>终端类型</td>
				
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center">
                     <td><c:out value="${item.seq}"/></td>
                     <td><c:out value="${item.calcmonth}"/></td>
                     <td><c:out value="${item.opnid}"/></td>
                     <td><c:out value="${item.name}"/></td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><c:out value="${item.wayname}"/></td>
                     <td><c:out value="${item.oprcode}"/></td>
                     <td><c:out value="${item.mobile}"/></td>
                     <td><c:out value="${item.oprtime}"/></td>
                     <td><c:out value="${item.runtime}"/></td>
                     <td><c:out value="${item.ruleid}"/></td>
                     <td><c:out value="${item.resultflag}"/></td>
                     <td><c:out value="${item.adtflag}"/></td>
                     <td><c:out value="${item.adtcode}"/></td>
                     <td><c:out value="${item.adtremark}"/></td>
                     <td><c:out value="${item.rewardtype}"/></td>
                     <td><c:out value="${item.rewardflag}"/></td>
                     <td><c:out value="${item.repairmonth}"/></td>
                     <td><c:out value="${item.batchno}"/></td>
                     <td><c:out value="${item.bakinfo}"/></td>
                     <td><c:out value="${item.bakinfo2}"/></td>
                     <td><s:Code2Name code="${item.bakinfo2 }" definition="#IM_PR_COM" /></td>
                     <td><c:out value="${item.bakinfo3}"/></td>
                     <td><c:out value="${item.wrapfee}"/></td>
                     <td><c:out value="${item.noncyc}"/></td>
                     <td><c:out value="${item.totalsum}"/></td>
                     <td><c:out value="${item.paysum}"/></td>
                     <td><c:out value="${item.paymoney1}"/></td>
                      <td><c:out value="${item.assegrade2}"/></td>
                      <td><c:out value="${item.prodid}"/></td>
                      <td><c:out value="${item.bakinfo4}"/></td>
                      <td><c:out value="${item.bakinfo5}"/></td>
                      <td><s:Code2Name code="${item.bakinfo6}" definition="$ZD_SYSTEM" /></td>
                      <td><c:out value="${item.bakinfo7}"/></td>
                      <td><c:out value="${item.bakinfo8}"/></td>
                      <td><c:out value="${item.bakinfo9}"/></td>
                      <td><s:Code2Name code="${item.bakinfo10}" definition="$ZD_TYPE" /></td> 
                 </tr>
             </c:forEach>
        </table>
     </div>
   </div>

   <div class="table_div">
		<%@ include file="/commons/pageCountNav.jsp"%>
   </div>
</html:form>
</div>
</body>
</html>
