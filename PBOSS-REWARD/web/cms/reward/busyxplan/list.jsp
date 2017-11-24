<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ page import="com.sunrise.boss.ui.commons.User"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<%
	String ID_1="CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL";
	String ID_2="CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL||CH_PW_REWARD_CIVIC";
	String ID_3="CH_PW_REWARD||CH_PW_REWARD_CIVIC";
%>
<%
	request.setAttribute("defaultcityid",((User)request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER)).getCityid());
%>
<html>
<head>
    <title><bean:message bundle="busyxplan" key="titleList"/></title>
    <script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_yxplanid', '<bean:message bundle="busyxplan" key="yxplanid"/>', 'f', true, '14');
            addfield('_se_cityid', '<bean:message bundle="busyxplan" key="cityid"/>', 'c', true, '4');
            var hasRight = 0;
            if(checkval(window)){
            	<s:RewardPurChk controlid="<%=ID_1%>">hasRight = 1;</s:RewardPurChk>
            	var strUrl ="<%=contextPath%>/cms/reward/busyxplan.do?CMD=LIST&RIGHT="+hasRight;
            	formList._se_cityid.disabled = false ;
            	formList.action = strUrl;
            	formList.submit();
            }
            else{
                return ;
            }
        }
        function selectYxplan(){
			var arg = new Array();
			var strUrl ="<%=contextPath%>/cms/reward/busyxplan.do?CMD=SHOWYXPLANID";
			var returnValue= window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
			return returnValue;
		 }
		function passGrade(url){
			var grade = 0;
			<s:RewardPurChk controlid="<%=ID_2%>">grade = 1;</s:RewardPurChk>
			<s:RewardPurChk controlid="<%=ID_3%>">grade = 2;</s:RewardPurChk>
			<s:RewardPurChk controlid="<%=ID_1%>">grade = 3;</s:RewardPurChk>
			formList.action = url+"&GRADE2="+grade;
			formList.submit();
		}
//		function doImport(){
//			var form=document.forms[0];
//			form.action="<%=contextPath%>/cms/reward/busyxplan/batchupfile.jsp";
//			form.submit();
//		}
		
		function doImport(url){
        	formList.action=contextPath + url + "?CMD=IMPORT";
			formList.submit();
		}
			function doTxt(url){
        	formList.action=contextPath + url + "?CMD=TXT";
			formList.submit();
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/busyxplan.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
	<c:set var="defaultcityid" scope="request" value="${defaultcityid}" />
    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="busyxplan" key="titleList"/>
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
            	<td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="busyxplan" key="opnid"/>:</td>
                <td class="form_table_left">
                	<html:text styleClass="form_input_1x" property="_se_opnid"></html:text>
						<input type="button" value="..." class="clickButton"
							   onclick="showOpnTree2(this, '_se_opnid','busi' )"> 
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="busyxplan" key="yxplanid"/>:</td>
                <td class="form_table_left">
                	<html:text styleClass="form_input_1x" property="_ne_yxplanid"></html:text>
                	<input type="button"  value="..." class="clickbutton"  onclick="_ne_yxplanid.value=selectYxplan()">
                </td>
            </tr>
    		 <tr>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="busyxplan" key="_se_cityid"/>:</td>
                <td class="form_table_left">
                <s:RewardPurChk controlid="<%=ID_1%>" disableChild="true" >
                	<html:select property="_se_cityid">
					  	<html:option value=""></html:option>
                  	 	<s:Options definition="$region"/>
                  	</html:select>
               	</s:RewardPurChk>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" >
                产品标识:
                </td>
              
                  <td class="form_table_left"> 
							<html:text styleClass="form_input_1x" property="_se_prodid"></html:text>
                </td>
              
            </tr>	
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                            <input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                                
                                 <input type="button" class="button_4"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="导出TXT"
										onclick="doTxt('/cms/reward/busyxplan.do');"/> 
							<s:RewardPurChk controlid="<%=ID_2%>" disableChild="true" > 
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/reward/busyxplan.do')">

                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/reward/busyxplan.do')">
                            
                            <input type="button" class="button_2"onmouseover="buttonover(this);"  onclick="doImport('/cms/reward/busyxplan.do');"  
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_import"/>" />
                                
                                
							</s:RewardPurChk>
                       

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
                <td>序列</td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="busyxplan" key="opnid"/></a>
                    <s:OrderImg form="/cms/reward/busyxplan/busyxplanForm" field="opnid"/>
                </td>
                <td>
                    <bean:message bundle="busyxplan" key="opnname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wrapfee')"><bean:message bundle="busyxplan" key="yxplanid"/></a>
                    <s:OrderImg form="/cms/reward/busyxplan/busyxplanForm" field="yxplanid"/>
                </td>
                <td>
					<bean:message bundle="busyxplan" key="yxplanname"/>
                </td>
                <td>产品标识</td>
                <td>
					<bean:message bundle="busyxplan" key="cityid"/>
                </td>
                <td>
					<bean:message bundle="busyxplan" key="noncyc"/>
                </td>
                 <td>
					<bean:message bundle="Way" key="wayid"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
           		 <c:if test="${item.cityid eq defaultcityid}">
            	 	<c:url value="/cms/reward/busyxplan.do?CMD=EDIT&GRADE=2" var="urlContent">
            	 		<c:param name="PK" value="${item.seq}"/>
            	 	</c:url>
            	 </c:if>
            	 <c:if test="${item.cityid ne defaultcityid}">
            	 	<c:url value="/cms/reward/busyxplan.do?CMD=EDIT&GRADE=3" var="urlContent">
            	 		<c:param name="PK" value="${item.seq}"/>
            	 	</c:url>
            	 </c:if>
                     <%//this param name must "PK" %>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 <tr class="table_style_content" align="center">
                    
                     <td>
                     <c:if test="${item.cityid eq defaultcityid}">
                     	<s:RewardPurChk controlid="<%=ID_2%>" disableChild="true" >
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.seq}' />"
                                onclick="checkOne();" class="table_checkbox">
                        </s:RewardPurChk>
                     </c:if>
                     <c:if test="${item.cityid ne defaultcityid}">
                     	<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true" >
	                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.seq}' />"
	                                onclick="checkOne();" class="table_checkbox">
                        </s:RewardPurChk>
                     </c:if>
                     </td>
                      <td><c:out value="${item.seq}"/></td>
                     <td>
                    	 <span onclick="passGrade('<c:out value="${urlContent}"/>');" style="cursor:hand;color: blue;"><c:out value="${item.opnid}" /></span>
                     </td>
                     
                     <td><s:Code2Name code="${item.opnid}"  definition="#OPERATION"/></td>
                     <td>
                     	<c:out value="${item.yxplanid}"/>
                         <%--<a href='<c:out value="${urlContent}"/>'><c:out value="${item.yxplanid}"/></a>--%>
                     </td>
                     <td><s:Code2Name code="${item.yxplanid}"  definition="#ZIFEE-YXPLAN"/></td> 
                    <td> <c:out value="${item.prodid}"/></td>
                     <td><c:out value="${item.cityid}"/></td>
                      <td><c:out value="${item.noncyc}"/></td>
                     <td><c:out value="${item.wayid}"/></td>
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
