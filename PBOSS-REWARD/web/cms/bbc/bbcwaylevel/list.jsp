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
    <title><bean:message bundle="bbcwaylevel" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('_se_wayid','<bean:message bundle="bbcwaylevel" key="wayid"/>','c',true,'18');
            return checkval(window);
        }
        
        function exports(){
			var form=document.forms[0];
			form.action="<%=contextPath%>/cms/bbc/bbcwaylevel.do?CMD=EXCEL";
			form.submit();
			form.action="<%=contextPath%>/cms/bbc/bbcwaylevel.do?CMD=LIST";
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/bbc/bbcwaylevel.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/bbc/bbcwaylevel/BbcWaylevelForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="bbcwaylevel" key="titleList"/>
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
                	<bean:message bundle="bbcwaylevel" key="wayid"/>:
            	</td>
            	<td width="30%" class="form_table_left">
               	 	<html:text styleClass="form_input_1x" property="_se_wayid" />
            	</td>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="bbcwaylevel" key="waylevel"/>:
            	</td>
            	<td width="30%" class="form_table_left">
               		<html:select  property="_se_waylevel">
		                    	<option/>
		                    	<s:Options definition="$CH_BBCUNPBLEVEL" />
                    		</html:select>
            	</td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <input type="button" class="button_2" onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="bbcwaylevel" key="export"/>" onclick="exports();"/>
                        <input type="submit" class="query"onmouseover="buttonover(this);"
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
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="bbcwaylevel" key="wayid"/></a>
                    <s:OrderImg form="/cms/bbc/bbcwaylevel/BbcWaylevelForm" field="wayid"/>
                </td>
                 <td>
                    <a href="javascript:doOrderby('waylevel')"><bean:message bundle="bbcwaylevel" key="waylevel"/></a>
                    <s:OrderImg form="/cms/bbc/bbcwaylevel/BbcWaylevelForm" field="waylevel"/>
                </td>
                 <td>
                    <bean:message bundle="bbcwaylevel" key="chagtime"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/bbc/bbcwaylevel.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.wayid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <c:out value="${item.wayid}"/>
                     </td>
                     <td>
                     	<s:Code2Name code="${item.waylevel}" definition="$CH_BBCUNPBLEVEL" />
                     </td>
                        <td>
                        <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
								value="${item.chagtime}" />
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
