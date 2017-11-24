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
    <title><bean:message bundle="zjtyrewardrecord" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_rewardlistid', '<bean:message bundle="zjtyrewardrecord" key="rewardlistid"/>', 'f', 'false', '14');
            addfield('_se_opnid', '<bean:message bundle="zjtyrewardrecord" key="opnid"/>', 'c', 'false', '18');
            addfield('_se_wayid', '<bean:message bundle="zjtyrewardrecord" key="wayid"/>', 'c', 'false', '32');
            addfield('_se_batchno', '<bean:message bundle="zjtyrewardrecord" key="batchno"/>', 'c', 'false', '6');
            addfield('_se_mobile', '<bean:message bundle="zjtyrewardrecord" key="mobile"/>', 'c', 'false', '11');
            addfield('_se_oid', '<bean:message bundle="zjtyrewardrecord" key="oid"/>', 'c', 'false', '32');
            addfield('_se_ruleid', '<bean:message bundle="zjtyrewardrecord" key="ruleid"/>', 'c', 'false', '32');
            addfield('_ne_rewardid', '<bean:message bundle="zjtyrewardrecord" key="rewardid"/>', 'f', 'false', '14');
            addfield('_ne_rewardtype', '<bean:message bundle="zjtyrewardrecord" key="rewardtype"/>', 'f', 'false', '3');
            addfield('_se_rewardmonth', '<bean:message bundle="zjtyrewardrecord" key="rewardmonth"/>', 'c', 'false', '6');
            return checkval(window);
        }
        function doExport(url){
			formList.action = contextPath + url + "?CMD=TXT";
  			formList.submit();
  			formList.action="<%=contextPath%>/cms/zjty/zjtyrewardrecord.do?CMD=LIST";
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/zjty/zjtyrewardrecord.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="zjtyrewardrecord" key="titleList"/>
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
            <tr>
            	<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="zjtyrewardrecord" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text><input type="button" value="..." class="clickbutton" 
                    onclick="showSelectWay3(this,'_se_wayid','','','AG','ZJTY');this.value='...';" />
                </td>            
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="zjtyrewardrecord" key="opnid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_opnid"></html:text><input type="button" value="..." class="clickButton"
					onclick="showZjtyOpnTree(this, '_se_opnid','busi')">
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="zjtyrewardrecord" key="rewardtype"/>:</td>
                <td width="30%" class="form_table_left">
                	<html:select property="_ne_rewardtype">
						<option />
						<s:Options definition="$ZJTY_REWARDTYPE"/>
					</html:select>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="zjtyrewardrecord" key="rewardmonth"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_rewardmonth" onclick="this.value=selectDateYYYYMM(this.value)"></html:text>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="zjtyrewardrecord" key="mobile"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_mobile"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="zjtyrewardrecord" key="batchno"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_batchno"></html:text>
                </td>
            </tr>            
             <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="zjtyrewardrecord" key="rewardid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_ne_rewardid"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="zjtyrewardrecord" key="noncyc"/>:</td>
            	<td width="30%" class="form_table_left">
                    <html:select property="_ne_noncyc">
						<option />
						<s:Options definition="$ZJTY_NONCYC"/>
					</html:select>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        <input type="button" class="button_2" onmouseover="buttonover(this);" onclick="doExport('/cms/zjty/zjtyrewardrecord.do')" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_export"/>" /> 
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
<!--                <td title="<bean:message bundle="public" key="list_title_select"/>">-->
<!--                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">-->
<!--                </td>-->
                <td>
                    <a href="javascript:doOrderby('rewardlistid')"><bean:message bundle="zjtyrewardrecord" key="rewardlistid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="rewardlistid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('operseq')"><bean:message bundle="zjtyrewardrecord" key="operseq"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="operseq"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="zjtyrewardrecord" key="opnid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="opnid"/>
                </td>
                <td>
                   		业务名称
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="zjtyrewardrecord" key="wayid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="wayid"/>
                </td>
                <td>
                   		渠道名称
                </td>
                <td>
                    <a href="javascript:doOrderby('wayoprcode')"><bean:message bundle="zjtyrewardrecord" key="wayoprcode"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="wayoprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('totalsum')"><bean:message bundle="zjtyrewardrecord" key="totalsum"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="totalsum"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('paysum')"><bean:message bundle="zjtyrewardrecord" key="paysum"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="paysum"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('coef1')"><bean:message bundle="zjtyrewardrecord" key="coef1"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="coef1"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('coef2')"><bean:message bundle="zjtyrewardrecord" key="coef2"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="coef2"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('coef3')"><bean:message bundle="zjtyrewardrecord" key="coef3"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="coef3"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('coef4')"><bean:message bundle="zjtyrewardrecord" key="coef4"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="coef4"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('batchno')"><bean:message bundle="zjtyrewardrecord" key="batchno"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="batchno"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('runtime')"><bean:message bundle="zjtyrewardrecord" key="runtime"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="runtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mobile')"><bean:message bundle="zjtyrewardrecord" key="mobile"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="mobile"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oid')"><bean:message bundle="zjtyrewardrecord" key="oid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="oid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ruleid')"><bean:message bundle="zjtyrewardrecord" key="ruleid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="ruleid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardid')"><bean:message bundle="zjtyrewardrecord" key="rewardid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="rewardid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardtype')"><bean:message bundle="zjtyrewardrecord" key="rewardtype"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="rewardtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardstd')"><bean:message bundle="zjtyrewardrecord" key="rewardstd"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="rewardstd"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardmonth')"><bean:message bundle="zjtyrewardrecord" key="rewardmonth"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="rewardmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('isbudget')"><bean:message bundle="zjtyrewardrecord" key="isbudget"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="isbudget"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('paymonth1')"><bean:message bundle="zjtyrewardrecord" key="paymonth1"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="paymonth1"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('paymoney1')"><bean:message bundle="zjtyrewardrecord" key="paymoney1"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="paymoney1"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('paymonth2')"><bean:message bundle="zjtyrewardrecord" key="paymonth2"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="paymonth2"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('paymoney2')"><bean:message bundle="zjtyrewardrecord" key="paymoney2"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="paymoney2"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('paymonth3')"><bean:message bundle="zjtyrewardrecord" key="paymonth3"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="paymonth3"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('paymoney3')"><bean:message bundle="zjtyrewardrecord" key="paymoney3"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="paymoney3"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('acctype')"><bean:message bundle="zjtyrewardrecord" key="acctype"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="acctype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('assegrade')"><bean:message bundle="zjtyrewardrecord" key="assegrade"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="assegrade"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtime')"><bean:message bundle="zjtyrewardrecord" key="oprtime"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="oprtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('busivalue')"><bean:message bundle="zjtyrewardrecord" key="busivalue"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="busivalue"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardflag')"><bean:message bundle="zjtyrewardrecord" key="rewardflag"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="rewardflag"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('noncyc')"><bean:message bundle="zjtyrewardrecord" key="noncyc"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrewardrecord/ZjtyrewardrecordForm" field="noncyc"/>
                </td>
                <td><bean:message bundle="zjtyrewardrecord" key="bakinfo"/></td>
                <td><bean:message bundle="zjtyrewardrecord" key="bakinfo2"/></td>
                <td><bean:message bundle="zjtyrewardrecord" key="bakinfo3"/></td>
                <td><bean:message bundle="zjtyrewardrecord" key="wrapfee"/></td>
                <td>稽核结果标识</td>
                <td>考核系数2</td>
                <td>商品名称</td>
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
                 <c:url value="/cms/zjty/zjtyrewardrecord.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.rewardlistid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
<!--                     <td>-->
<!--                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.rewardlistid}' />"-->
<!--                                onclick="checkOne();" class="table_checkbox">-->
<!--                     </td>-->
                     <td>
<!--                         <a href='<c:out value="${urlContent}"/>'>-->
                         <c:out value="${item.rewardlistid}"/>
<!--                         </a>-->
                     </td>
                     <td><c:out value="${item.operseq}"/></td>
                     <td><c:out value="${item.opnid}"/></td>
                     <td><s:Code2Name code="${item.opnid }" definition="#ZJTY_OPERATION" /></td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><s:Code2Name code="${item.wayid }" definition="#WAY" /></td>
                     <td><c:out value="${item.wayoprcode}"/></td>
                     <td><c:out value="${item.totalsum}"/></td>
                     <td><c:out value="${item.paysum}"/></td>
                     <td><c:out value="${item.coef1}"/></td>
                     <td><c:out value="${item.coef2}"/></td>
                     <td><c:out value="${item.coef3}"/></td>
                     <td><c:out value="${item.coef4}"/></td>
                     <td><c:out value="${item.batchno}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.runtime}" /></td>
                     <td><c:out value="${item.mobile}"/></td>
                     <td><c:out value="${item.oid}"/></td>
                     <td><c:out value="${item.ruleid}"/></td>
                     <td><c:out value="${item.rewardid}"/></td>
                     <td><s:Code2Name code="${item.rewardtype}" definition="$ZJTY_REWARDTYPE" /></td>
                     <td><c:out value="${item.rewardstd}"/></td>
                     <td><c:out value="${item.rewardmonth}"/></td>
                     <td><c:out value="${item.isbudget}"/></td>
                     <td><c:out value="${item.paymonth1}"/></td>
                     <td><c:out value="${item.paymoney1}"/></td>
                     <td><c:out value="${item.paymonth2}"/></td>
                     <td><c:out value="${item.paymoney2}"/></td>
                     <td><c:out value="${item.paymonth3}"/></td>
                     <td><c:out value="${item.paymoney3}"/></td>
                     <td><c:out value="${item.acctype}"/></td>
                     <td><c:out value="${item.assegrade}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.oprtime}" /></td>
                     <td><c:out value="${item.busivalue}"/></td>
                     <td><c:out value="${item.rewardflag}"/></td>
                     <td><c:out value="${item.noncyc}"/></td>
                     <td><c:out value="${item.bakinfo}"/></td>
                     <td><c:out value="${item.bakinfo2}"/></td>
                     <td><c:out value="${item.bakinfo3}"/></td>
                     <td><c:out value="${item.wrapfee}"/></td>
                     <td><c:out value="${item.adtflag}"/></td>
                     <td><c:out value="${item.assegrade2}"/></td>
                     <td><s:Code2Name code="${item.bakinfo2}" definition="#IM_PR_COM" /></td>
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
		<s:PageNav dpName="LIST"/>
   </div>
</html:form>
</div>
</body>
</html>
