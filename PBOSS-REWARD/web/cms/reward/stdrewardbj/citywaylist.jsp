<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<base target="_self"/>
<head>
    <title><bean:message bundle="stdrewardbj" key="waytitleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        
        function doNew(cmdNew) {
		    formList.action = contextPath + cmdNew;
		    formList.submit();
		}
        
        function doDeleteCityWay(cmdDelete) {
		    var TO = true;
		    var sis = formList.all("_selectitem");
		    if (forincheck(TO,sis,msgConfirmDelete)){
		    	formList.action = contextPath + cmdDelete;
		    	formList.submit();
		    }
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/stdrewardbj.do?CMD=SHOWCITYWAY" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm']}"/>
    
    <html:hidden property="s_opnid" />
    <html:hidden property="s_rewardid" />
    <html:hidden property="s_acctype" />
    <html:hidden property="s_ruleid" />
    <html:hidden property="s_rewardstd" />

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="stdrewardbj" key="waytitleList"/>
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
                	<bean:message bundle="stdrewardbj" key="wayid"/>
                	:
            	</td>
            	<td width="80%" class="form_table_left">
               	 	<html:text styleClass="form_input_1x" property="s_wayid" />
               	 	<input type="button" value="..." class="clickbutton" onclick="showSelectWay3(this,'s_wayid','','','AG');this.value='...';" />
            	</td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
		                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                        value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/reward/stdrewardbj.do?CMD=NEWCITYWAY')">
                        <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
		                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                        value="<bean:message bundle="public" key="button_delete"/>" onClick="doDeleteCityWay('/cms/reward/stdrewardbj.do?CMD=DELETECITYWAY')">
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
                    <bean:message bundle="stdrewardbj" key="wayid"/>
                </td>
                <td>
                       渠道名称
                </td>
                <td>
                    <bean:message bundle="stdrewardbj" key="rewardstd"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/reward/stdrewardbj.do?CMD=EDITCITYWAY" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.region}|${item.rewardid}|${item.wayid}|${item.opnid}|${item.acctype}|${item.ruleid}|${item.rewardstd}"/>
                     <c:param name="s_rewardstd" value="${form.s_rewardstd}" />
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.region}|${item.rewardid}|${item.wayid}|${item.opnid}|${item.acctype}|${item.ruleid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.wayid}"/></a>
                     </td>
                     <td>
                     	 <s:Code2Name code="${item.wayid}" definition="#WAY" />
                     </td>
                     <td><c:out value="${item.rewardstd}"/></td>
                 </tr>
             </c:forEach>
        </table>
     </div>
   </div>
</html:form>
</div>
</body>
</html>
