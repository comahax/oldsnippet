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
    <title><bean:message bundle="zjtyfailrecord" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_seq', '<bean:message bundle="zjtyfailrecord" key="seq"/>', 'f', 'false', '14');
            addfield('_se_cityid', '<bean:message bundle="zjtyfailrecord" key="cityid"/>', 'c', 'false', '4');
            addfield('_se_opnid', '<bean:message bundle="zjtyfailrecord" key="opnid"/>', 'c', 'false', '32');
            addfield('_se_wayid', '<bean:message bundle="zjtyfailrecord" key="wayid"/>', 'c', 'false', '18');
            addfield('_se_mobile', '<bean:message bundle="zjtyfailrecord" key="mobile"/>', 'c', 'false', '11');
            addfield('_se_ruleid', '<bean:message bundle="zjtyfailrecord" key="ruleid"/>', 'c', 'false', '32');
            addfield('_se_ruleitemid', '<bean:message bundle="zjtyfailrecord" key="ruleitemid"/>', 'c', 'false', '32');
            addfield('_se_oid', '<bean:message bundle="zjtyfailrecord" key="oid"/>', 'c', 'false', '32');
            addfield('_se_batchno', '<bean:message bundle="zjtyfailrecord" key="batchno"/>', 'c', 'false', '6');
            addfield('_se_calcopnid', '<bean:message bundle="zjtyfailrecord" key="calcopnid"/>', 'c', 'false', '18');
            addfield('_se_calcmonth', '<bean:message bundle="zjtyfailrecord" key="calcmonth"/>', 'c', 'false', '8');
            return checkval(window);
        }
        function doExport(url){
			formList.action = contextPath + url + "?CMD=TXT";
  			formList.submit();
  			formList.action="<%=contextPath%>/cms/zjty/zjtyfailrecord.do?CMD=LIST";
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/zjty/zjtyfailrecord.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/zjtyfailrecord/ZjtyfailrecordForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="zjtyfailrecord" key="titleList"/>
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
            	<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="zjtyfailrecord" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text><input type="button" value="..." class="clickbutton" 
                    onclick="showSelectWay3(this,'_se_wayid','','','AG','ZJTY');this.value='...';" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="zjtyfailrecord" key="opnid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_opnid"></html:text><input type="button" value="..." class="clickButton"
					onclick="showZjtyOpnTree(this, '_se_opnid','busi');this.value='...';">
                </td>                
            </tr>
            <tr>
            	<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="zjtyfailrecord" key="calcmonth"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_calcmonth" onclick="this.value=selectDateYYYYMM(this.value)"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="zjtyfailrecord" key="mobile"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_mobile"></html:text>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="zjtyfailrecord" key="rewardtype"/>:</td>
                <td width="30%" class="form_table_left">
                	<html:select property="_ne_rewardtype">
						<option />
						<s:Options definition="$ZJTY_REWARDTYPE"/>
					</html:select>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="zjtyfailrecord" key="noncyc"/>:</td>
            	<td width="30%" class="form_table_left">
               		<html:select property="_ne_noncyc">
						<option />
						<s:Options definition="$ZJTY_NONCYC"/>
					</html:select>
            	</td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="zjtyfailrecord" key="batchno"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_batchno"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" >
                	&nbsp;
                </td>
            	<td width="30%" class="form_table_left">
               		&nbsp;
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
                        <input type="button" class="button_2" onmouseover="buttonover(this);" onclick="doExport('/cms/zjty/zjtyfailrecord.do')" 
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
                    <a href="javascript:doOrderby('seq')"><bean:message bundle="zjtyfailrecord" key="seq"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyfailrecord/ZjtyfailrecordForm" field="seq"/>
                </td>
<!--                <td>-->
<!--                    <a href="javascript:doOrderby('srcseq')"><bean:message bundle="zjtyfailrecord" key="srcseq"/></a>-->
<!--                    <s:OrderImg form="/cms/zjty/zjtyfailrecord/ZjtyfailrecordForm" field="srcseq"/>-->
<!--                </td>-->
<!--                <td>-->
<!--                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="zjtyfailrecord" key="cityid"/></a>-->
<!--                    <s:OrderImg form="/cms/zjty/zjtyfailrecord/ZjtyfailrecordForm" field="cityid"/>-->
<!--                </td>-->
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="zjtyfailrecord" key="opnid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyfailrecord/ZjtyfailrecordForm" field="opnid"/>
                </td>
                <td>
                   		业务名称
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="zjtyfailrecord" key="wayid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyfailrecord/ZjtyfailrecordForm" field="wayid"/>
                </td>
                <td>
                   		渠道名称
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="zjtyfailrecord" key="oprcode"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyfailrecord/ZjtyfailrecordForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtime')"><bean:message bundle="zjtyfailrecord" key="oprtime"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyfailrecord/ZjtyfailrecordForm" field="oprtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mobile')"><bean:message bundle="zjtyfailrecord" key="mobile"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyfailrecord/ZjtyfailrecordForm" field="mobile"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('busivalue')"><bean:message bundle="zjtyfailrecord" key="busivalue"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyfailrecord/ZjtyfailrecordForm" field="busivalue"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('brand')"><bean:message bundle="zjtyfailrecord" key="brand"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyfailrecord/ZjtyfailrecordForm" field="brand"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('creattime')"><bean:message bundle="zjtyfailrecord" key="creattime"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyfailrecord/ZjtyfailrecordForm" field="creattime"/>
                </td>
<!--                <td>-->
<!--                    <a href="javascript:doOrderby('src')"><bean:message bundle="zjtyfailrecord" key="src"/></a>-->
<!--                    <s:OrderImg form="/cms/zjty/zjtyfailrecord/ZjtyfailrecordForm" field="src"/>-->
<!--                </td>-->
                <td>
                    <a href="javascript:doOrderby('ruleid')"><bean:message bundle="zjtyfailrecord" key="ruleid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyfailrecord/ZjtyfailrecordForm" field="ruleid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ruleitemid')"><bean:message bundle="zjtyfailrecord" key="ruleitemid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyfailrecord/ZjtyfailrecordForm" field="ruleitemid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adtcode')"><bean:message bundle="zjtyfailrecord" key="adtcode"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyfailrecord/ZjtyfailrecordForm" field="adtcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adtremark')"><bean:message bundle="zjtyfailrecord" key="adtremark"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyfailrecord/ZjtyfailrecordForm" field="adtremark"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oid')"><bean:message bundle="zjtyfailrecord" key="oid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyfailrecord/ZjtyfailrecordForm" field="oid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('noncyc')"><bean:message bundle="zjtyfailrecord" key="noncyc"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyfailrecord/ZjtyfailrecordForm" field="noncyc"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('batchno')"><bean:message bundle="zjtyfailrecord" key="batchno"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyfailrecord/ZjtyfailrecordForm" field="batchno"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('calcopnid')"><bean:message bundle="zjtyfailrecord" key="calcopnid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyfailrecord/ZjtyfailrecordForm" field="calcopnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('calcmonth')"><bean:message bundle="zjtyfailrecord" key="calcmonth"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyfailrecord/ZjtyfailrecordForm" field="calcmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adtttime')"><bean:message bundle="zjtyfailrecord" key="adtttime"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyfailrecord/ZjtyfailrecordForm" field="adtttime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adtflag')"><bean:message bundle="zjtyfailrecord" key="adtflag"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyfailrecord/ZjtyfailrecordForm" field="adtflag"/>
                </td>
                <td><bean:message bundle="zjtyrewardrecord" key="rewardtype"/></td>
                <td><bean:message bundle="zjtyrewardrecord" key="bakinfo"/></td>
                <td><bean:message bundle="zjtyrewardrecord" key="bakinfo2"/></td>
                <td><bean:message bundle="zjtyrewardrecord" key="bakinfo3"/></td>
                <td><bean:message bundle="zjtyrewardrecord" key="wrapfee"/></td>
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
                 <c:url value="/cms/zjty/zjtyfailrecord.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seq}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
<!--                     <td>-->
<!--                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.seq}' />"-->
<!--                                onclick="checkOne();" class="table_checkbox">-->
<!--                     </td>-->
                     <td>
<!--                         <a href='<c:out value="${urlContent}"/>'>-->
                         <c:out value="${item.seq}"/>
<!--                         </a>-->
                     </td>
<!--                     <td><c:out value="${item.srcseq}"/></td>-->
<!--                     <td><c:out value="${item.cityid}"/></td>-->
                     <td><c:out value="${item.opnid}"/></td>
                     <td><s:Code2Name code="${item.opnid }" definition="#ZJTY_OPERATION" /></td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><s:Code2Name code="${item.wayid }" definition="#WAY" /></td>
                     <td><c:out value="${item.oprcode}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.oprtime}" /></td>
                     <td><c:out value="${item.mobile}"/></td>
                     <td><c:out value="${item.busivalue}"/></td>
                     <td><c:out value="${item.brand}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.creattime}" /></td>
<!--                     <td><c:out value="${item.src}"/></td>-->
                     <td><c:out value="${item.ruleid}"/></td>
                     <td><c:out value="${item.ruleitemid}"/></td>
                     <td><c:out value="${item.adtcode}"/></td>
                     <td><c:out value="${item.adtremark}"/></td>
                     <td><c:out value="${item.oid}"/></td>
                     <td><c:out value="${item.noncyc}"/></td>
                     <td><c:out value="${item.batchno}"/></td>
                     <td><c:out value="${item.calcopnid}"/></td>
                     <td><c:out value="${item.calcmonth}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.adtttime}" /></td>
                     <td><c:out value="${item.adtflag}"/></td>
                     <td><s:Code2Name code="${item.rewardtype}" definition="$ZJTY_REWARDTYPE" /></td>
                     <td><c:out value="${item.bakinfo}"/></td>
                     <td><c:out value="${item.bakinfo2}"/></td>
                     <td><c:out value="${item.bakinfo3}"/></td>
                     <td><c:out value="${item.wrapfee}"/></td>
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
