<%@ page language="java" contentType="text/html;charset=GBK"%>
<%//    head.inc是List.jsp的文件头，声明了JS、CSS等的引用，所有list.jsp必须引用这个文件头%>
<%@ include file="/inc/listhead.inc" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A4D" />
</jsp:include>
<%
	//业务控制点标识，暂时没用上，先保留  
    String PID = "2B1A4D";
    String ID_1 = PID + "BT1";
    String ID_2 = PID + "BT2";
    String ID_3 = PID + "BT3";    
%>
<html>
<head>
    <title><bean:message bundle="Wayhierarchy" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        <%//查询条件的校检%>
        function ev_check() {
            addfield('_se_parwayid', '<bean:message bundle="Wayhierarchy" key="parwayid"/>', 'c', true, 18);
            addfield('_sk_subwayid', '<bean:message bundle="Wayhierarchy" key="subwayid"/>', 'c', true, 18);
            addfield('baseWayId', '<bean:message bundle="Wayhierarchy" key="baseWayId"/>', 'c', false, 18);
            return checkval(window);
        }
    </script>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
</head>

<body onload="document.formList._se_parwayid.focus()">
<div class="table_container">

<html:form action="/cms/wayhierarchy.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    
<!--##################################添加标题内容，里面可以放置按钮##################################################-->		
	<div class="table_div">				
		<table class="top_table">
			<tr> 
				<td>
					<bean:message bundle="Wayhierarchy" key="titleList"/>
				</td>
			</tr>
		</table>
	</div>
	
	<div class="table_div">	
		<table width="100%" class="error_text">
		    <html:errors/><s:Msg />
	    </table>	
    </div>
	
	<!--#################################添加标题内容，里面可以放置按钮###################################################-->
	<div class="table_div">
        <table class="form_table">
        	 <tr>
                 <td width="80" height="20" align="right" class="form_table_right" nowrap>
                	<bean:message bundle="Wayhierarchy" key="parwayid"/>:
               	</td>
                <td class="form_table_left">
                   <html:text styleClass="form_input_1x" property="_se_parwayid" onclick="showSelectWay(this);"/>
                   <html:hidden styleClass="form_input_1x" property="parwayid"/>
                </td>
                <td width="80" height="20" align="right" class="form_table_right" nowrap>
                	<bean:message bundle="Wayhierarchy" key="subwayid"/>:
                </td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_subwayid" onclick="showSelectWay(this);"/>
                     <html:hidden styleClass="form_input_1x" property="subwayid"/>
                </td>
                
                <td width="80" height="20" align="right" class="form_table_right" nowrap>
                	<bean:message bundle="Wayhierarchy" key="hichyoffset"/>:
               	</td>
                <td class="form_table_left" colspan="3">
                    <html:text styleClass="form_input_1x" property="_ne_hichyoffset" />
                    <html:hidden styleClass="form_input_1x" property="hichyoffset" />
                </td>   
            </tr>
            
             <tr>
                 <td width="80" height="20" align="right" class="form_table_right" nowrap>
                	<bean:message bundle="Wayhierarchy" key="baseWayId"/>:
               	</td>
                <td class="form_table_left">
                   <html:text styleClass="form_input_1x" property="baseWayId" onclick="showSelectWay(this);"/>
                   <html:hidden styleClass="form_input_1x" property="baseWayId"/>
                </td>
                <td width="80" height="20" align="right" class="form_table_right" nowrap>
                	&nbsp;
                </td>
                <td class="form_table_left">
                    &nbsp;
                </td>
                
                <td width="80" height="20" align="right" class="form_table_right" nowrap>
                	&nbsp;
               	</td>
                <td class="form_table_left" colspan="3">
                   &nbsp;
                </td>   
            </tr>
        </table>
    </div>  
	
	<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>			
                     <s:PurChk controlid="<%=ID_1%>">
                        <input type="button" class="query"onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" onclick="doQuery();" />						
					 </s:PurChk>
					 	
                                
                     <s:PurChk controlid="<%=ID_2%>">
                        <input type="button" class="query"onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_check"/>"  onclick="doCheckWayhierarchy();"/>						
					 </s:PurChk>
					 
					 <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query"onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_build"/>"  onclick="doBuildWayhierarchy();"/>						
					 </s:PurChk>
					 
                   
				</tr>
			</table>
	</div>
	
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
               
                <td nowrap>
                    <a href="javascript:doOrderby('parwayid')"><bean:message bundle="Wayhierarchy" key="parwayid"/></a>
                    <s:OrderImg form="/cms/wayhierarchy/WayhierarchyForm" field="parwayid"/>
                </td>
                <td nowrap>
                    <bean:message bundle="Wayhierarchy" key="parway"/>                   
                </td>
                <td nowrap>
                    <a href="javascript:doOrderby('subwayid')"><bean:message bundle="Wayhierarchy" key="subwayid"/></a>
                    <s:OrderImg form="/cms/wayhierarchy/WayhierarchyForm" field="subwayid"/>
                </td>
                <td nowrap>
                    <bean:message bundle="Wayhierarchy" key="subway"/>                   
                </td>
                <td nowrap><bean:message bundle="Wayhierarchy" key="hichyoffset"/></td>
                <td nowrap><bean:message bundle="Wayhierarchy" key="createtime"/></td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/wayhierarchy.do?CMD=EDIT" var="urlContent">
                     <%//这个param名称必须是“PK”%>
                     <c:param name="PK" value="${item.parwayid}|${item.subwayid}"/>
                     <%//如果是复合主键，需要这样写”%>
                     <%--<c:param name="PK" value="'${item.id}|${item.id2}'"/>--%>
                 </c:url>
                 <tr class="table_style_content" align="center">                     
                     <td> <c:out value="${item.parwayid}"/> </td>
                     <td>  <s:Code2Name code="${item.parwayid}" definition="#WAY"/> </td>
                     <td> <c:out value="${item.subwayid}"/> </td>
                     <td> <s:Code2Name code="${item.subwayid}" definition="#WAY"/></td>
                     <td> <c:out value="${item.hichyoffset}"/> </td>
                     <td>  <fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>   
                               
                 </tr>
             </c:forEach>
        </table>
        </div>
    </div>
    
   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>    
   
</html:form>
<SCRIPT>
	function doCheckWayhierarchy() {
		var ret = false;
		ret = confirm("检查渠道层次完整性需要较长时间, 是否要继续? ");
		if(!ret) return false;
		
		var url = contextPath + '/cms/wayhierarchy.do?CMD=CHECK';
		document.formList.action = url;
		document.formList.submit();
	}
	
	function doBuildWayhierarchy() {
		var ret = false;
		ret = confirm("构建渠道层次需要较长时间, 是否要继续? ");
		if(!ret) return false;
		
		var url = contextPath + '/cms/wayhierarchy.do?CMD=BUILD';
		document.formList.action = url;
		document.formList.submit();
	}
	
	function doClear() {		
		document.formList.parwayid.value= "";
		document.formList.subwayid.value= "";
		document.formList.hichyoffset.value= "";
	}
	
</SCRIPT>
</body>
</html>
