<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:directive.page import="org.ajaxanywhere.AAUtils"/>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa" %>

<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
    
    if(AAUtils.isAjaxRequest(request))
    	AAUtils.addZonesToRefresh(request,"listZone");
%>
<html>
<head>
    <title><bean:message bundle="logincase" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container"> 

	<div class="table_div">
		<td>
			（这个只是展示页面所以没有用到国际化，大家注意在正式页面上要用国际化的写法）
		</td>
		<br />
		<br />
		<td>
			该登陆界面用于生成一个User,并把User保存到session里面。很简单，大家点登陆就可以了。
		</td>
		<br />
		<br />
		<form name="loginForm" action="<%=contextPath%>/login.do" method="post">
			<table>
				<tr>
					<td>
						操作员：
					</td>
					<td>
						<input type="text" maxlength="20" value="testcode" name="opercode">
					</td>
				</tr>
				<tr>
					<td>
						渠道:
					</td>
					<td>
						<input type="text" maxlength="20" value="JFJM00000" name="wayid">
					</td>
				</tr>
				<tr>
					<td>
						市标识:
					</td>
					<td>
						<input type="text" maxlength="20" value="750" name="cityid">
					</td>
				</tr>
				
				<tr>
				<td>
						模块:
					</td>
					<td>
						<select name="module" class="form_input_1x">
							<option value="">---所有---</option>
							<option value="CH">渠道</option>
							<option value="FEE">帐务</option>
							<option value="RES">资源</option>
						</select>
					</td>
				<tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="登陆"   class="add" name="login">
					</td>
				</tr>
					
			</table>
		</form>
	</div>
		
<html:form action="/admin/logincase.do?CMD=LIST" styleId="formList" method="post" >
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
    			<bean:message bundle="logincase" key="titleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="logincase" key="module"/>:</td>
                <td class="form_table_left">
                    <html:select styleClass="form_input_1x" property="_se_module" onchange="ajaxAnywhere.submitAJAX();">
							<option value="">---所有---</option>
							<option value="CH">渠道</option>
							<option value="FEE">帐务</option>
							<option value="RES">资源</option>
                    </html:select>
                    
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="logincase" key="operid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_operid"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="logincase" key="wayid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_wayid"></html:text>
                </td>
            </tr>
            <tr>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="logincase" key="cityid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_cityid"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" >
                	 &nbsp;
                </td>
                <td class="form_table_left">
                    &nbsp;
                </td>
    			<td width="80" height="20" align="right" class="form_table_right" >
                	&nbsp;
            	</td>
            	<td class="form_table_left">
               	 &nbsp;
            	</td>
            </tr>
        </table>
    </div>
	<div class="table_div">	
		<table class="table_button_list">
			<tr> 
                <td align=right>         
						  <input type="submit" id="queryButton" class="query"onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                                            
                          <input type="button" id="deleteButton" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/admin/logincase.do')">    
                            
                             <input type="reset" id="queryButton" class="query"onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_reset"/>" />
                    
                </td>
			</tr>
		</table>
	</div>

 <aa:zone name="listZone">
    <div class="table_div">
   
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                	<td>
									&nbsp;
					</td>
                  <td>
                    <a href="javascript:doOrderby('operid')"><bean:message bundle="logincase" key="operid"/></a>
                    <s:OrderImg form="/admin/logincase/logincaseForm" field="operid"/>
                </td>
                 <td>
                    <a href="javascript:doOrderby('roleid')"><bean:message bundle="logincase" key="roleid"/></a>
                    <s:OrderImg form="/admin/logincase/logincaseForm" field="roleid"/>
                </td>
                
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="logincase" key="wayid"/></a>
                    <s:OrderImg form="/admin/logincase/logincaseForm" field="wayid"/>
                </td>
                 <td>
                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="logincase" key="cityid"/></a>
                    <s:OrderImg form="/admin/logincase/logincaseForm" field="cityid"/>
                </td>
                
                <td>
                    <a href="javascript:doOrderby('module')"><bean:message bundle="logincase" key="module"/></a>
                    <s:OrderImg form="/admin/logincase/logincaseForm" field="module"/>
                </td>
              
               
                <td>
                    <a href="javascript:doOrderby('createtime')"><bean:message bundle="logincase" key="createtime"/></a>
                    <s:OrderImg form="/admin/logincase/logincaseForm" field="createtime"/>
                </td>
               
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/admin/logincase.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.cityid}|${item.operid}|${item.wayid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.cityid}|${item.operid}|${item.wayid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     
                    <td>
							 <a href="javascript:quickLogin('<c:out value="${item.operid}"/>', '<c:out value="${item.wayid}"/>' , '<c:out value="${item.cityid}"/>', '<c:out value="${item.module}"/>');">登录</a>
					</td>
                       <td>
                         <c:out value="${item.operid}"/>
                     </td>
                        <td><c:out value="${item.roleid}"/></td>
                      <td>
                        <c:out value="${item.wayid}"/> <s:Code2Name code="${item.wayid}"  definition="#WAY"/> 
                     </td>
                     <td>
                        <c:out value="${item.cityid}"/>
                     </td>
                     <td>
                        <c:out value="${item.module}"/>
                     </td>                    
                     <td><c:out value="${item.createtime}"/></td>
                     
                 </tr>
             </c:forEach>
        </table>
     </div>     
   </div>

   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
   </aa:zone>
</html:form>
<script type="text/javascript">
function quickLogin(operid,wayid,cityid,module) {
	document.loginForm.opercode.value = operid;
	document.loginForm.wayid.value = wayid;
	document.loginForm.cityid.value = cityid;
	document.loginForm.module.value = module;
	
	document.loginForm.submit();
}
</script>

<script type="text/javascript">
	  ajaxAnywhere.formName ="formList";  //如果页面只有一个Form此行可以不要
	  ajaxAnywhere.substituteFormSubmitFunction();
	  ajaxAnywhere.substituteSubmitButtonsBehavior(true);	
</script>
</div>
</body>
</html>
