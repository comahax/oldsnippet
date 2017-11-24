<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="registersimvw" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        function doReturn(){
			formList.action ="<%=contextPath%>/cms/regnewwayemptotal.do?CMD=LIST&flg=true";
			formList.submit();
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/regnewwayemptotal.do?CMD=SELECTLIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"  value="20" />
    <html:hidden property="_se_wayid"/>
    <html:hidden property="_se_waymagcode"/>
    <html:hidden property="_ne_brand"/>
    <html:hidden property="_se_countyid"/>
    <html:hidden property="_se_svccode"/>
    <html:hidden property="_dnm_oprtime"/>
    <html:hidden property="_dnl_oprtime"/>
    
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/registersimcnt/RegistersimcntForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			新业务销售明细
   			</td>
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
           
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <input type="button" id="btnReturn" name="btnReturn" class="button_88" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="返回新业务销售汇总" onClick="doReturn()">
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="regnewwayemptotal" key="wayid"/></a>
                    <s:OrderImg form="/cms/regnewwayemptotal/RegNewWayEmpTotalForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayname')"><bean:message bundle="regnewwayemptotal" key="wayname"/></a>
                    <s:OrderImg form="/cms/regnewwayemptotal/RegNewWayEmpTotalForm" field="wayname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('name')">所属渠道经理</a>
                    <s:OrderImg form="/cms/regnewwayemptotal/RegNewWayEmpTotalForm" field="name"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('countyid')"><bean:message bundle="regnewwayemptotal" key="countyid"/></a>
                    <s:OrderImg form="/cms/regnewwayemptotal/RegNewWayEmpTotalForm" field="countyid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('starlevel')"><bean:message bundle="regnewwayemptotal" key="starlevel"/></a>
                    <s:OrderImg form="/cms/regnewwayemptotal/RegNewWayEmpTotalForm" field="starlevel"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('employeename')">店员</a>
                    <s:OrderImg form="/cms/regnewwayemptotal/RegNewWayEmpTotalForm" field="employeename"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('officetel')">捆绑号码</a>
                    <s:OrderImg form="/cms/regnewwayemptotal/RegNewWayEmpTotalForm" field="officetel"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mobile')">套卡号码</a>
                    <s:OrderImg form="/cms/regnewwayemptotal/RegNewWayEmpTotalForm" field="mobile"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('brand')"><bean:message bundle="regnewwayemptotal" key="brand"/></a>
                    <s:OrderImg form="/cms/regnewwayemptotal/RegNewWayEmpTotalForm" field="brand"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')">业务编码</a>
                    <s:OrderImg form="/cms/regnewwayemptotal/RegNewWayEmpTotalForm" field="opnid"/>
                </td>
                <td>
                    业务名称
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtime')">登记时间</a>
                    <s:OrderImg form="/cms/regnewwayemptotal/RegNewWayEmpTotalForm" field="oprtime"/>
                </td>
               
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center">
                     <td><c:out value="${item.wayid}"/></td>
                     <td><c:out value="${item.wayname}"/></td>
                     <td><c:out value="${item.name}"/></td>
                     <td><s:Code2Name code="${item.countyid}" definition="#CNTYCOMPANY"/></td>
                     <td><s:Code2Name code="${item.starlevel}" definition="$CH_STARLEVEL"/></td>
                     <td><c:out value="${item.employeename}"/></td>
                     <td><c:out value="${item.officetel}"/></td>
                     <td><c:out value="${item.mobile}"/></td>
                     <td><s:Code2Name code="${item.brand}" definition="$CH_SIMBRAND"/></td>
                     <td><c:out value="${item.opnid}"/></td>
                     <td><c:out value="${item.opnname}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.oprtime}" /></td>
                 </tr>
             </c:forEach>
        </table>
     </div>
   </div>

   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
</html:form>
</div>
</body>
</html>
