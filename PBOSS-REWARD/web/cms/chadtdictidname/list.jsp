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
    <title><bean:message bundle="chadtdictidname" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_sk_description', '<bean:message bundle="chadtdictidname" key="_sk_description"/>', 'c', 'false', '128');
            return checkval(window);
        }
        
        function doSavechadtdictidname(vv){
         var valu = document.getElementById(vv).value;
          
           formList.action="<%=contextPath%>/cms/chadtdictidname.do?CMD=SAVE&&"+vv+"&&dictnameidlimin="+valu;
			formList.submit();
			formList.action="<%=contextPath%>/cms/chadtdictidname.do?CMD=LIST";
        
          
        }
        
        
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/chadtdictidname.do?CMD=LIST" styleId="formList" method="post" onsubmit="return en_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/chadtdictidname/ChadtdictidnameForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chadtdictidname" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtdictidname" key="_se_groupid"/>:</td>
                <td width="30%" class="form_table_left">
                 <html:select property="_se_groupid">
	                   		    <s:Options definition="#CHADTDICTIDNAME"/>
                     		</html:select>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtdictidname" key="_sk_description"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_description"></html:text>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                   
                        <input type="submit" class="query" 
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
                    <a href="javascript:doOrderby('groupid')"><bean:message bundle="chadtdictidname" key="dictitemgroupid"/></a>
                    <s:OrderImg form="/cms/chadtdictidname/ChadtdictidnameForm" field="groupid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('dictid')"><bean:message bundle="chadtdictidname" key="dictitemdictid"/></a>
                    <s:OrderImg form="/cms/chadtdictidname/ChadtdictidnameForm" field="dictid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('dictname')"><bean:message bundle="chadtdictidname" key="dictitemdictname"/></a>
                    <s:OrderImg form="/cms/chadtdictidname/ChadtdictidnameForm" field="dictname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('description')"><bean:message bundle="chadtdictidname" key="description"/></a>
                    <s:OrderImg form="/cms/chadtdictidname/ChadtdictidnameForm" field="description"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('dictname')"><bean:message bundle="chadtdictidname" key="dictname"/></a>
                    <s:OrderImg form="/cms/chadtdictidname/ChadtdictidnameForm" field="dictname"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/chadtdictidname.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.dictid}|${item.groupid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                    
                     <td>
                     
                     <s:Code2Name definition="#CHADTDICTIDNAME" code="${item.groupid}" />
                       <!--  <a href='<c:out value="${urlContent}"/>'><c:out value="${item.groupid}"/></a> -->
                     </td>
                     <td>
                     <c:out value="${item.dictid}"/>
                         <!-- <a href='<c:out value="${urlContent}"/>'><c:out value="${item.dictid}"/></a> -->
                     </td>
                     <td><c:out value="${item.dictitemdictname}"/></td>
                     <td><c:out value="${item.description}"/></td>
                     <td><input type="text" name="dictname" id="<c:out value="dictid=${item.dictid}&&groupid=${item.groupid}"/>" value="<c:out value="${item.dictname}"/>" class="form_input_1x"> 
                     <input type="button"  name="btnSave"  value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSavechadtdictidname('<c:out value="dictid=${item.dictid}&&groupid=${item.groupid}"/>')"/>
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
