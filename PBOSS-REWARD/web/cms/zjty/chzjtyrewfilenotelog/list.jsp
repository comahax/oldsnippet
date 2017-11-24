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
    <title><bean:message bundle="chzjtyrewfilenotelog" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/zjty/chzjtyrewfilenotelog.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/chzjtyrewfilenotelog/ChzjtyrewfilenotelogForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chzjtyrewfilenotelog" key="titleList"/>
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
                	&nbsp;
            	</td>
            	<td width="30%" class="form_table_left">
               	 &nbsp;
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
                        <s:PurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/zjty/chzjtyrewfilenotelog.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/zjty/chzjtyrewfilenotelog.do')">
                        </s:PurChk>
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
                <td>
                    <a href="javascript:doOrderby('logid')"><bean:message bundle="chzjtyrewfilenotelog" key="logid"/></a>
                    <s:OrderImg form="/cms/zjty/chzjtyrewfilenotelog/ChzjtyrewfilenotelogForm" field="logid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('optime')"><bean:message bundle="chzjtyrewfilenotelog" key="optime"/></a>
                    <s:OrderImg form="/cms/zjty/chzjtyrewfilenotelog/ChzjtyrewfilenotelogForm" field="optime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="chzjtyrewfilenotelog" key="oprcode"/></a>
                    <s:OrderImg form="/cms/zjty/chzjtyrewfilenotelog/ChzjtyrewfilenotelogForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtype')"><bean:message bundle="chzjtyrewfilenotelog" key="oprtype"/></a>
                    <s:OrderImg form="/cms/zjty/chzjtyrewfilenotelog/ChzjtyrewfilenotelogForm" field="oprtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('success')"><bean:message bundle="chzjtyrewfilenotelog" key="success"/></a>
                    <s:OrderImg form="/cms/zjty/chzjtyrewfilenotelog/ChzjtyrewfilenotelogForm" field="success"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('seqid')"><bean:message bundle="chzjtyrewfilenotelog" key="seqid"/></a>
                    <s:OrderImg form="/cms/zjty/chzjtyrewfilenotelog/ChzjtyrewfilenotelogForm" field="seqid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('filename')"><bean:message bundle="chzjtyrewfilenotelog" key="filename"/></a>
                    <s:OrderImg form="/cms/zjty/chzjtyrewfilenotelog/ChzjtyrewfilenotelogForm" field="filename"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('filepath')"><bean:message bundle="chzjtyrewfilenotelog" key="filepath"/></a>
                    <s:OrderImg form="/cms/zjty/chzjtyrewfilenotelog/ChzjtyrewfilenotelogForm" field="filepath"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('uploadcode')"><bean:message bundle="chzjtyrewfilenotelog" key="uploadcode"/></a>
                    <s:OrderImg form="/cms/zjty/chzjtyrewfilenotelog/ChzjtyrewfilenotelogForm" field="uploadcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('uploadtime')"><bean:message bundle="chzjtyrewfilenotelog" key="uploadtime"/></a>
                    <s:OrderImg form="/cms/zjty/chzjtyrewfilenotelog/ChzjtyrewfilenotelogForm" field="uploadtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardmonth')"><bean:message bundle="chzjtyrewfilenotelog" key="rewardmonth"/></a>
                    <s:OrderImg form="/cms/zjty/chzjtyrewfilenotelog/ChzjtyrewfilenotelogForm" field="rewardmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('memo')"><bean:message bundle="chzjtyrewfilenotelog" key="memo"/></a>
                    <s:OrderImg form="/cms/zjty/chzjtyrewfilenotelog/ChzjtyrewfilenotelogForm" field="memo"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/zjty/chzjtyrewfilenotelog.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.logid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.logid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.logid}"/></a>
                     </td>
                     <td><c:out value="${item.optime}"/></td>
                     <td><c:out value="${item.oprcode}"/></td>
                     <td><c:out value="${item.oprtype}"/></td>
                     <td><c:out value="${item.success}"/></td>
                     <td><c:out value="${item.seqid}"/></td>
                     <td><c:out value="${item.filename}"/></td>
                     <td><c:out value="${item.filepath}"/></td>
                     <td><c:out value="${item.uploadcode}"/></td>
                     <td><c:out value="${item.uploadtime}"/></td>
                     <td><c:out value="${item.rewardmonth}"/></td>
                     <td><c:out value="${item.memo}"/></td>
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
