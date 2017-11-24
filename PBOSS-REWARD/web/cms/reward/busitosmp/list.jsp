<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "CH_PW_REWARD || CH_PW_REWARD_PROVINCIAL";
%>
<html>
<head>
    <title><bean:message bundle="busitosmp" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/busitosmp.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/busitosmp/BusitosmpForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="busitosmp" key="titleList"/>
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
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="busitosmp" key="opnid" />:
            	</td>
            	<td width="30%" class="form_table_left">
               	 	<html:text  property="_se_opnid" styleClass="form_input_1x"/>
                    <input type="button" value="..." class="clickbutton" onclick="showOpnTree2(this, '_se_opnid' , 'busi' )">
            	</td>
            	<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="busitosmp" key="comclassid" />:
            	</td>
            	<td width="30%" class="form_table_left">
               		<html:select property="_se_comclassid">
						<option />
						<s:Options definition="$IM_COMTYPE" />
					</html:select>
            	</td>
            </tr>
            <tr>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="busitosmp" key="brand" />:
            	</td>
            	<td width="30%" class="form_table_left">
               	 	<html:select property="_se_brand">
						<option />
						<s:Options definition="#BUSI_BRAND" />
					</html:select>
            	</td>
            	<td width="20%" height="20" align="right" class="form_table_right" >
            		商品标识:
            	</td>
            	<td width="30%" class="form_table_left">
            	<html:text  property="_se_comid" styleClass="form_input_1x"/>
            	</td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                	<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
                        <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/reward/busitosmp.do')">
                        <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/reward/busitosmp.do')">
                    </s:RewardPurChk>
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_search"/>" />
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
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="busitosmp" key="opnid"/></a>
                    <s:OrderImg form="/cms/reward/busitosmp/BusitosmpForm" field="opnid"/>
                </td>
                <td>
                  	业务名称
                </td>
                <td>
                    <a href="javascript:doOrderby('comclassid')"><bean:message bundle="busitosmp" key="comclassid"/></a>
                    <s:OrderImg form="/cms/reward/busitosmp/BusitosmpForm" field="comclassid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('brand')"><bean:message bundle="busitosmp" key="brand"/></a>
                    <s:OrderImg form="/cms/reward/busitosmp/BusitosmpForm" field="brand"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('comprice')"><bean:message bundle="busitosmp" key="comprice"/></a>
                    <s:OrderImg form="/cms/reward/busitosmp/BusitosmpForm" field="comprice"/>
                </td>
                <td>
                  	商品标识
                </td>
                <td>
                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="busitosmp" key="cityid"/></a>
                    <s:OrderImg form="/cms/reward/busitosmp/BusitosmpForm" field="cityid"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/reward/busitosmp.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.cityid}|${item.comclassid}|${item.comprice}|${item.opnid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.cityid}|${item.comclassid}|${item.comprice}|${item.opnid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <c:out value="${item.opnid}"/>
                     </td>
                     <td>
                         <s:Code2Name code="${item.opnid}" definition="#OPERATION" />
                     </td>
                     <td>
                         <s:Code2Name code="${item.comclassid}" definition="$IM_COMTYPE" />
                     </td>
                     <td><s:Code2Name code="${item.brand}" definition="#BUSI_BRAND" /></td>
                     <td>
                     	 <fmt:formatNumber pattern="0.00" value="${item.comprice / 100}"/>
                     </td>
                     <td>
                         <c:out value="${item.comid}"/>
                     </td>
                     <td>
                     	 <s:Code2Name code="${item.cityid}" definition="#CITYIDNUM2NMAME" />
                     </td>
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
