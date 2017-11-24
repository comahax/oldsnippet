<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="com.sunrise.boss.ui.commons.User"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<%@ include file="/inc/listhead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="3C3C1A" />
</jsp:include>
<%
   
    String ID_1 = "3C3C1ABT1";
    String AREACODE_A = "AREACODE_A";
	String AREACODE_B = "AREACODE_B";
	String AREACODE_C = "AREACODE_C";
%>
<html:html>
<head>
    <title><bean:message bundle="yxplan" key="titleList"/></title>
    <base target="_self">
    <script language="JavaScript" type="text/JavaScript">
      	
        function ev_check() {
            addfield('_ne_yxplanid', '<bean:message bundle="yxplan" key="yxplanid"/>', 'c', true, 10);
            addfield('_sk_yxplanname', '<bean:message bundle="yxplan" key="yxplanname"/>', 'c', true, 128);
            addfield('_se_plankind', '<bean:message bundle="yxplan" key="plankind"/>', 'c', true, 32);
            addfield('_se_areacode', '<bean:message bundle="yxplan" key="areacode"/>', 'c', true, 32);
            //alert("test");
            formList.action=contextPath+"/zifee/yxplan.do?CMD=SELECT";
            //alert(formList.action);
            formList.submit();
            //return checkval(window);
        }
        
       window.returnValue = ""; 
       function doOK(value) {
	   		window.returnValue = value;
	   		window.close();
	   }
	     function getAreacode(){	
			var strUrl;
			var arg = new Array();
			strUrl = "<%=contextPath%>/admin/dictitem.do?CMD=LIST";
			strUrl = strUrl + "&_pagesize=0&_se_groupid=PC_YXPLANAREACODE";            
            <%
            	String pid = "1";  //1  2 3 
            	if(pid.equals("1")) {
            	User user = (User)request.getSession().getAttribute( WebConstant.SESSION_ATTRIBUTE_USER);
            	if(user.isProvinceUser()){    
            	%>
            		   
            		   	 var strUrl0 = strUrl;
            		   	 strUrl0 = strUrl0;
            		   
            		   
            		  <%}else{%>
            		   
            		   
            	
            		   	  var strUrl0 = strUrl;
            		   	  strUrl0 = strUrl0 + "&_se_dictid=" + "<%=user.getCityid()%>";
            				 
            	<%
            	}
            	}
            %>
            
            var hWnd = window.showModalDialog(strUrl0,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
			if(hWnd != null && hWnd != ""){						
				document.all._se_areacode.value = hWnd;	
			}else{
				document.all._se_areacode.value = "";	
			}	
        }
	   
	  
    </script>
</head>

<body onload="document.formList._ne_yxplanid.focus()">
<div class="table_container">
<html:form action="/zifee/yxplan.do?CMD=SELECT" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    
    
    <div class="table_div">
		<table class="top_table">
			<tr>
				<td>
					<bean:message bundle="yxplan" key="titleList"/>
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
       			<td width="126" height="20" align="right" class="form_table_right">
       					<bean:message bundle="yxplan" key="yxplanid"/>:</td>
                <td class="form_table_left">
                	<html:text styleClass="form_input_1x" property="_ne_yxplanid"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="yxplan" key="yxplanname"/>:</td>
                <td class="form_table_left">
                	<html:text styleClass="form_input_1x" property="_sk_yxplanname"></html:text>
                </td>
            </tr>
			<tr>
				<td width="150" height="20" align="right" class="form_table_right"><bean:message bundle="yxplan" key="areacode"/>:</td>
				<td class="form_table_left">
			    	<html:text styleClass="form_input_1x" property="_se_areacode" readonly="true" onclick="getAreacode()"></html:text>
			   </td> 
			   <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="yxplan" key="plankind"/>:</td>
				<td class="form_table_left">
					<html:select property="_se_plankind">
						<option value=""  ></option>		                		
						<s:Options  definition="$PC_YXPLANKIND"/>
				    </html:select>
				</td> 
			</tr>
        </table>
    </div>
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
				<s:PurChk controlid="<%=ID_1%>">
                   <input type="submit" class="query"onmouseover="buttonover(this);"
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
                <td nowrap>
                    <a href="javascript:doOrderby('yxplanid')"><bean:message bundle="yxplan" key="yxplanid"/></a>
                    <s:OrderImg form="/zifee/yxplan/YxPlanActionForm" field="yxplanid"/>
                </td>
                <td nowrap>
                    <a href="javascript:doOrderby('yxplanname')"><bean:message bundle="yxplan" key="yxplanname"/></a>
                    <s:OrderImg form="/zifee/yxplan/YxPlanActionForm" field="yxplanname"/>
                </td>
                <td nowrap>
                    <a href="javascript:doOrderby('areacode')"><bean:message bundle="yxplan" key="areacode"/></a>
                    <s:OrderImg form="/zifee/yxplan/YxPlanActionForm" field="areacode"/>
                </td>
             </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr style="cursor:hand" class="table_style_content" align="center" onclick="doOK('<c:out value="${item.yxplanid}"/>');">
                     <td >
                        <c:out value="${item.yxplanid}"/>
                     </td>
                     <td >
                     	<c:out value="${item.yxplanname}"/>
                     </td>
                     <td >
                     	<c:out value="${item.areacode}"/>
                     </td>
                 </tr>
             </c:forEach>
        </table>
    </div>
   <div class="table_div">
		<s:PageNav dpName="LIST"/>
  </div>
</html:form>
</div>
</body>
</html:html>
