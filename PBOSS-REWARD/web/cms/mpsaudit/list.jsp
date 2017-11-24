<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_QUERY = "00010703";
    String ID_EXPORT = "CH_PW_REWARD_CIVIC";
%>
<html>
<head>
    <title><bean:message bundle="mpsaudit" key="titlelist"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_snl_adtdate', '<bean:message bundle="mpsaudit" key="adtdate"/>', 'i', true, '8');
            addfield('_snm_adtdate', '<bean:message bundle="mpsaudit" key="adtdate"/>', 'i', true, '8');
            var d1=document.all("_snl_adtdate").value;
        	var d2=document.all("_snm_adtdate").value;
        	if(d1!="" && !isDate(d1))
        	{
        	 return false;
        	}
            if(d2!="" && !isDate(d2))
            {
             return false;
            }
            return checkval(window);
        }
        function isDate(date)
        {
        	if(date!="")
        	{
        	    date=trim(date);
        		if(""==date)
        		{
        		 return true;
        		}
        	    var msg="日期格式为YYYYMMDD,长度必须为8位!";
        	    var msg1="月份格式不对!";
        	    var msg2="日期格式不对!";        	    
	        	var vaChar=trim(date);
        		if(date=="") return true;
        		if(date.length!=8)
        		{
        		 alert(msg);
        		 return false;
        		}
        		var month=date.substr(4,2);
        		if(month*1<0 || month*1>12)
        		{
        		 alert(msg1);
        		 return false;
        		}
        		var day=date.substr(6,2);
        		if(day*1<0 || day*1>31)
        		{
        		alert(msg2);
        		return false;
        		}
        	}
        	return true;
        }
        function exports(){
				var form=document.forms[0];
				form.action="<%=contextPath%>/cms/mpsaudit.do?CMD=EXCEL";
				form.submit();
				form.action="<%=contextPath%>/cms/mpsaudit.do?CMD=LIST";
			}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/mpsaudit.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="mpsaudit" key="titlelist"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="mpsaudit" key="adtdate"/>&gt;=:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_snl_adtdate" onclick="selectDateYYYYMMDD();"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="mpsaudit" key="adtdate"/>&lt;=:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_snm_adtdate" onclick="selectDateYYYYMMDD();"></html:text>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                
                        <input type="submit" class="query" onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        <s:PurChk2 controlid="<%=ID_EXPORT%>">
                        <input type="button" class="button_2" onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="导出" onclick="exports()"/>
                        </s:PurChk2>
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>
                    <a href="javascript:doOrderby('adtdate')"><bean:message bundle="mpsaudit" key="adtdate"/></a>
                    <s:OrderImg form="/cms/mpsaudit/mpsauditForm" field="adtdate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('iodnum')"><bean:message bundle="mpsaudit" key="iodnum"/></a>
                    <s:OrderImg form="/cms/mpsaudit/mpsauditForm" field="iodnum"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mpsnum')"><bean:message bundle="mpsaudit" key="mpsnum"/></a>
                    <s:OrderImg form="/cms/mpsaudit/mpsauditForm" field="mpsnum"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mpsvalid')"><bean:message bundle="mpsaudit" key="mpsvalid"/></a>
                    <s:OrderImg form="/cms/mpsaudit/mpsauditForm" field="mpsvalid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('percent')"><bean:message bundle="mpsaudit" key="percent"/></a>
                    <s:OrderImg form="/cms/mpsaudit/mpsauditForm" field="percent"/>
                </td>
                 <td>
                   <bean:message bundle="mpsaudit" key="success"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/mpsaudit.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.adtdate}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                        <c:out value="${item.adtdate}"/>
                     </td>
                     <td><c:out value="${item.iodnum}"/></td>
                     <td><c:out value="${item.mpsnum}"/></td>
                     <td><c:out value="${item.mpsvalid}"/></td>
                     <td><c:out value="${item.percent*100}"/>%</td>
                     <td>
                     	<c:choose>
	                        <c:when test="${item.successFlag=='yes'}">
	                        	通过
	                        </c:when>
	                        <c:when test="${item.successFlag=='no'}">
	                        	不通过
	                        </c:when>
	                        <c:otherwise>
	                           
	                        </c:otherwise>
                    	</c:choose>
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
