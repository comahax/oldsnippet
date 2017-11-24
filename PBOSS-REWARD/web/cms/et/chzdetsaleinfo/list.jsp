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
    <title><bean:message bundle="chzdetsaleinfo" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_city', '<bean:message bundle="chzdetsaleinfo" key="city"/>', 'c', 'false', '8');
            addfield('_se_wayid', '<bean:message bundle="chzdetsaleinfo" key="wayid"/>', 'c', 'false', '32');
            addfield('_se_oprcode', '<bean:message bundle="chzdetsaleinfo" key="oprcode"/>', 'c', 'false', '32');
            addfield('_se_zdplatform', '<bean:message bundle="chzdetsaleinfo" key="zdplatform"/>', 'c', 'false', '32');
            addfield('_se_producttype', '<bean:message bundle="chzdetsaleinfo" key="producttype"/>', 'c', 'false', '32');
            addfield('_se_imei', '<bean:message bundle="chzdetsaleinfo" key="imei"/>', 'c', 'false', '32');
            addfield('_nnm_salenum', '<bean:message bundle="chzdetsaleinfo" key="salenum"/>', 'f', 'false', '8');
            addfield('_nnl_salenum', '<bean:message bundle="chzdetsaleinfo" key="salenum"/>', 'f', 'false', '8');
            addfield('_dnm_saleday', '<bean:message bundle="chzdetsaleinfo" key="saleday"/>', 't', 'false', '7');
            addfield('_dnl_saleday', '<bean:message bundle="chzdetsaleinfo" key="saleday"/>', 't', 'false', '7');
            addfield('_se_batchno', '<bean:message bundle="chzdetsaleinfo" key="batchno"/>', 'c', 'false', '8');

            var b_month=document.getElementById('b_month').value;
            var b_no=document.getElementById('b_no').value;
            //var re = /^\d*$/;
    		//alert(b_month.length == 0 && b_no.length == 0);
    		if((b_month.length > 0 && b_no.length > 0) || (b_month.length == 0 && b_no.length == 0)) {
        		
    		}else{
    			errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="chzdetsaleinfo" key="batchno"/>]下拉框选择不正确：若选择，请同时选择；或可同时留空。</span>');
    			return false;
    		}
            
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/et/chzdetsaleinfo.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/et/chzdetsaleinfo/ChZdEtsaleinfoForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chzdetsaleinfo" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chzdetsaleinfo" key="city"/>:</td>
                <td width="30%" class="form_table_left">
						<html:select property="_se_city" disabled="true">
							<s:Options definition="#CITYNAME_ZH_CN" />
						</html:select>							
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chzdetsaleinfo" key="zdplatform"/>:</td>
                <td width="30%" class="form_table_left">
<%--                    <html:text styleClass="form_input_1x" property="_se_zdplatform"></html:text>--%>
					<html:select   property="_se_zdplatform" >
                    <option value=""></option>
                    <html:options collection="zdplatformset" property="code" labelProperty="name"/>
                    </html:select>
                </td>
            </tr>            
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chzdetsaleinfo" key="producttype"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select   property="_se_producttype" >
                    <option value=""></option>
					<html:options collection="producttypeset" property="code" labelProperty="name"/>
                    </html:select>
                </td>           
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chzdetsaleinfo" key="batchno"/>:</td>
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
<%--                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/et/chzdetsaleinfo.do')">--%>
<%--                        </s:PurChk>--%>
<%--                        <s:PurChk controlid="<%=ID_2%>">--%>
<%--                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"--%>
<%--                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"--%>
<%--                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/et/chzdetsaleinfo.do')">--%>
<%--                        </s:PurChk>--%>
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:PurChk>
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
<%--                <td>--%>
<%--                    <a href="javascript:doOrderby('seq')"><bean:message bundle="chzdetsaleinfo" key="seq"/></a>--%>
<%--                    <s:OrderImg form="/cms/et/chzdetsaleinfo/ChzdetsaleinfoForm" field="seq"/>--%>
<%--                </td>--%>
                <td>
                    <a href="javascript:doOrderby('city')"><bean:message bundle="chzdetsaleinfo" key="city"/></a>
                    <s:OrderImg form="/cms/et/chzdetsaleinfo/ChzdetsaleinfoForm" field="city"/>
                </td>
<%--                <td>--%>
<%--                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="chzdetsaleinfo" key="wayid"/></a>--%>
<%--                    <s:OrderImg form="/cms/et/chzdetsaleinfo/ChzdetsaleinfoForm" field="wayid"/>--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                    <a href="javascript:doOrderby('wayname')"><bean:message bundle="chzdetsaleinfo" key="wayname"/></a>--%>
<%--                    <s:OrderImg form="/cms/et/chzdetsaleinfo/ChzdetsaleinfoForm" field="wayname"/>--%>
<%--                </td>--%>
				<td>
					营业厅
				</td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="chzdetsaleinfo" key="oprcode"/></a>
                    <s:OrderImg form="/cms/et/chzdetsaleinfo/ChzdetsaleinfoForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('zdplatform')"><bean:message bundle="chzdetsaleinfo" key="zdplatform"/></a>
                    <s:OrderImg form="/cms/et/chzdetsaleinfo/ChzdetsaleinfoForm" field="zdplatform"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('producttype')"><bean:message bundle="chzdetsaleinfo" key="producttype"/></a>
                    <s:OrderImg form="/cms/et/chzdetsaleinfo/ChzdetsaleinfoForm" field="producttype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('imei')"><bean:message bundle="chzdetsaleinfo" key="imei"/></a>
                    <s:OrderImg form="/cms/et/chzdetsaleinfo/ChzdetsaleinfoForm" field="imei"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('saleprice')"><bean:message bundle="chzdetsaleinfo" key="saleprice"/></a>
                    <s:OrderImg form="/cms/et/chzdetsaleinfo/ChzdetsaleinfoForm" field="saleprice"/>
                </td>
<%--                <td>--%>
<%--                    <a href="javascript:doOrderby('lsaleprice')"><bean:message bundle="chzdetsaleinfo" key="lsaleprice"/></a>--%>
<%--                    <s:OrderImg form="/cms/et/chzdetsaleinfo/ChzdetsaleinfoForm" field="lsaleprice"/>--%>
<%--                </td>--%>
                <td>
                    <a href="javascript:doOrderby('salenum')"><bean:message bundle="chzdetsaleinfo" key="salenum"/></a>
                    <s:OrderImg form="/cms/et/chzdetsaleinfo/ChzdetsaleinfoForm" field="salenum"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('saleday')"><bean:message bundle="chzdetsaleinfo" key="saleday"/></a>
                    <s:OrderImg form="/cms/et/chzdetsaleinfo/ChzdetsaleinfoForm" field="saleday"/>
                </td>
<%--                <td>--%>
<%--                    <a href="javascript:doOrderby('batchno')"><bean:message bundle="chzdetsaleinfo" key="batchno"/></a>--%>
<%--                    <s:OrderImg form="/cms/et/chzdetsaleinfo/ChzdetsaleinfoForm" field="batchno"/>--%>
<%--                </td>--%>
                <td>
                    <a href="javascript:doOrderby('note')"><bean:message bundle="chzdetsaleinfo" key="note"/></a>
                    <s:OrderImg form="/cms/et/chzdetsaleinfo/ChzdetsaleinfoForm" field="note"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/et/chzdetsaleinfo.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seq}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.seq}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
<%--                     <td>--%>
<%--                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.seq}"/></a>--%>
<%--                     </td>--%>
                     <td><c:out value="${item.city}"/></td>
<%--                     <td><c:out value="${item.wayid}"/></td>--%>
<%--                     <td><c:out value="${item.wayname}"/></td>--%>
					 <td><c:out value="${item.wayid}"/><c:out value="${item.wayname}"/></td>
                     <td><c:out value="${item.oprcode}"/></td>
                     <td><c:out value="${item.zdplatform}"/></td>
                     <td><c:out value="${item.producttype}"/></td>
                     <td><c:out value="${item.imei}"/></td>
                     <td><c:out value="${item.saleprice}"/></td>
<%--                     <td><c:out value="${item.lsaleprice}"/></td>--%>
                     <td><c:out value="${item.salenum}"/></td>
                     <td><fmt:formatDate value="${item.saleday}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
<%--                     <td><c:out value="${item.batchno}"/></td>--%>
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
