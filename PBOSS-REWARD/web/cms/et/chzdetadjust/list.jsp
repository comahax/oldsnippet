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
    <title><bean:message bundle="chzdetadjust" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_wayid', '<bean:message bundle="chzdetadjust" key="wayid"/>', 'c', 'false', '32');
            addfield('_se_platform', '<bean:message bundle="chzdetadjust" key="platform"/>', 'c', 'false', '32');
            addfield('_se_producttype', '<bean:message bundle="chzdetadjust" key="producttype"/>', 'c', 'false', '32');
            addfield('_se_batchno', '<bean:message bundle="chzdetadjust" key="batchno"/>', 'c', 'false', '8');
            
            var b_month=document.getElementById('b_month').value;
            var b_no=document.getElementById('b_no').value;
            //var re = /^\d*$/;
    		//alert(b_month.length == 0 && b_no.length == 0);
    		if((b_month.length > 0 && b_no.length > 0) || (b_month.length == 0 && b_no.length == 0)) {
        		
    		}else{
    			errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="chzdetadjust" key="batchno"/>]下拉框选择不正确：若选择，请同时选择；或可同时留空。</span>');
    			return false;
    		}
    		
            return checkval(window);
        }

    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/et/chzdetadjust.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/et/chzdetadjust/ChZdEtadjustForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chzdetadjust" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chzdetadjust" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text><input type="button" value="..." class="clickbutton" 
                    onclick="showSelectWay3(this,'_se_wayid','','','ET','');this.value='...';" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chzdetadjust" key="platform"/>:</td>
                <td width="30%" class="form_table_left">
<%--                    <html:text styleClass="form_input_1x" property="_se_platform"></html:text>--%>
                    <html:select   property="_se_platform" >
                    <option value=""></option>
                    <html:options collection="zdplatformset" property="code" labelProperty="name"/>
                    </html:select>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chzdetadjust" key="producttype"/>:</td>
                <td width="30%" class="form_table_left">
<%--                    <html:text styleClass="form_input_1x" property="_se_producttype"></html:text>--%>
                    <html:select   property="_se_producttype" >
                    <option value=""></option>
<%--	                    <c:forEach var="item" items="${requestScope.producttypedb.datas}">--%>
<%--		                	<option value="<c:out value="${item}"/>"><c:out value="${item}"/></option>--%>
<%--	                    </c:forEach>--%>
						<html:options collection="producttypeset" property="code" labelProperty="name"/>
                    </html:select>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chzdetadjust" key="batchno"/>:</td>
                <td width="30%" class="form_table_left">
<%--                    <html:text styleClass="form_input_1x" property="_se_batchno"></html:text>--%>
					<html:text styleClass="form_input_1x" property="b_month" onclick="this.value=selectDateYYYYMM(this.value)"></html:text>
					<html:select   property="b_no" >
						<option value="" SELECTED></option>
						<html:options collection="bnoset" property="code" labelProperty="name"/>
					</html:select>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
<%--                        <s:PurChk controlid="<%=ID_1%>">--%>
<%--                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"--%>
<%--                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"--%>
<%--                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/et/chzdetadjust.do')">--%>
<%--                        </s:PurChk>--%>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/et/chzdetadjust.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:PurChk>
                        <input type="button" class="button_4" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                              	value="<bean:message bundle="costcard" key="buttonBatch"/>" 
                                onclick="doOther('/cms/et/chzdetadjust.do?CMD=IMPORT')"/>
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="chzdetadjust" key="wayid"/></a>
                    <s:OrderImg form="/cms/et/chzdetadjust/ChzdetadjustForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('platform')"><bean:message bundle="chzdetadjust" key="platform"/></a>
                    <s:OrderImg form="/cms/et/chzdetadjust/ChzdetadjustForm" field="platform"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('producttype')"><bean:message bundle="chzdetadjust" key="producttype"/></a>
                    <s:OrderImg form="/cms/et/chzdetadjust/ChzdetadjustForm" field="producttype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('money')"><bean:message bundle="chzdetadjust" key="money"/></a>
                    <s:OrderImg form="/cms/et/chzdetadjust/ChzdetadjustForm" field="money"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('batchno')"><bean:message bundle="chzdetadjust" key="batchno"/></a>
                    <s:OrderImg form="/cms/et/chzdetadjust/ChzdetadjustForm" field="batchno"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('note')"><bean:message bundle="chzdetadjust" key="note"/></a>
                    <s:OrderImg form="/cms/et/chzdetadjust/ChzdetadjustForm" field="note"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/et/chzdetadjust.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seq}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.seq}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <c:out value="${item.wayid}"/></a>
                     </td>
                     <td><c:out value="${item.platform}"/></td>
                     <td>
                         <c:out value="${item.producttype}"/></a>
                     </td>
                     <td><c:out value="${item.money}"/></td>
                     <td>
                         <c:out value="${item.batchno}"/></a>
                     </td>
                     <td><c:out value="${item.note}"/></td>
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
