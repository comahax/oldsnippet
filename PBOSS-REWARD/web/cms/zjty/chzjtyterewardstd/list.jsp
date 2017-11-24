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
    <title><bean:message bundle="chzjtyterewardstd" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_rewardtype', '<bean:message bundle="chzjtyterewardstd" key="rewardtype"/>', 'f', 'false', '2');
            //addfield('_ne_citycode', '<bean:message bundle="chzjtyterewardstd" key="citycode"/>', 'f', 'false', '3');
            return checkval(window);
        }
        function doImport(url){
        	formList.action = contextPath + url + "?CMD=IMPORT";
			formList.submit();
		}
        function changecity(){
			var region = document.getElementsByName("region")[0].value;
			var citycode = document.getElementsByName("_ne_citycode")[0].value;		
			
			if(region == citycode){
				document.getElementById("divdisplay2").style.display = "none";
				document.getElementById("divdisplay1").style.display = "block";
			} else {
				document.getElementById("divdisplay1").style.display = "none";
				document.getElementById("divdisplay2").style.display = "block";
			}
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();changecity();">
<div class="table_container">
<html:form action="/cms/zjty/chzjtyterewardstd.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="region"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/chzjtyterewardstd/ChZjtyTerewardstdForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chzjtyterewardstd" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chzjtyterewardstd" key="rewardtype"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_ne_rewardtype">
						<option />
						<s:Options definition="$ZJTY_TERREWARDTYPE"/>
					</html:select>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chzjtyterewardstd" key="citycode"/>:</td>
                <td width="30%" class="form_table_left">
                    <c:choose>
                        <c:when test="${form.region == '999'}">
								<html:select property="_ne_citycode" onchange="changecity()">
									<s:Options definition="#CITYIDNUM2NMAME" />
								</html:select>
							</c:when>
                       	 <c:otherwise>
	                        <html:select property="_ne_citycode" onchange="changecity()">
								<option value="<c:out value='${form.region}'/>"><s:Code2Name definition="#CITYIDNUM2NMAME" code="${form.region}"/></option>
								<c:choose>
			                      <c:when test="${form._ne_citycode == '999'}">
									<option value="999" selected="selected">全省</option>
								  </c:when>
			                   	  <c:otherwise>
			                   	  	<option value="999">全省</option>
			                   	  </c:otherwise>
			                   	</c:choose>
								
							</html:select>
                          </c:otherwise>
                    </c:choose>
                </td> 
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                  <div id = "divdisplay1">
                	<input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_search"/>" />
                    <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/zjty/chzjtyterewardstd.do')">
                    <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/zjty/chzjtyterewardstd.do')">
                    <input type="button" class="button_4" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                      	value="<bean:message bundle="costcard" key="buttonBatch"/>" 
                        onclick="doImport('/cms/zjty/chzjtyterewardstd.do')"/>
                  </div>
                  <div id = "divdisplay2" style = "display:none">
                  	<input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_search"/>" />
                  </div>
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                	<c:choose>
                      <c:when test="${form.region == form._ne_citycode}">
						<input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
					  </c:when>
                   	  <c:otherwise>
                   	  	<input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox" disabled="disabled">
                   	  </c:otherwise>
                   	</c:choose>
                </td>
                <td><bean:message bundle="chzjtyterewardstd" key="comid"/></td>
                <td><bean:message bundle="chzjtyterewardstd" key="rewardstd"/></td>
                <td><bean:message bundle="chzjtyterewardstd" key="rewardtype"/></td>
                <td><bean:message bundle="chzjtyterewardstd" key="acctype"/></td>
                <td><bean:message bundle="chzjtyterewardstd" key="adtremark"/></td>
                <td><bean:message bundle="chzjtyterewardstd" key="createtime"/></td>
                <td><bean:message bundle="chzjtyterewardstd" key="citycode"/></td>
                <td>基准价</td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/zjty/chzjtyterewardstd.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.citycode}|${item.comid}|${item.rewardtype}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <c:choose>
                          <c:when test="${form.region == item.citycode}">
							<input type="checkbox" name="_selectitem" value="<c:out value='${item.citycode}|${item.comid}|${item.rewardtype}' />"
                                onclick="checkOne();" class="table_checkbox">
						  </c:when>
                       	  <c:otherwise>
                       	  	<input type="checkbox" name="_selectitem" value="<c:out value='${item.citycode}|${item.comid}|${item.rewardtype}' />"
                                onclick="checkOne();" class="table_checkbox" disabled="disabled">
                       	  </c:otherwise>
                    	</c:choose>
                     </td>
                     <td>
                     	<c:choose>
                          <c:when test="${form.region == item.citycode}">
								<a href='<c:out value="${urlContent}"/>'><c:out value="${item.comid}"/></a>
						  </c:when>
                       	  <c:otherwise><c:out value="${item.comid}"/></c:otherwise>
                    	</c:choose>
                     </td>
                     <td><c:out value="${item.rewardstd}"/></td>
                     <td><s:Code2Name code="${item.rewardtype }" definition="$ZJTY_TERREWARDTYPE" /></td>
                     <td><s:Code2Name code="${item.acctype}" definition="#CH_ACCTYPE" /></td>
                     <td><c:out value="${item.adtremark}"/></td>
                     <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><s:Code2Name code="${item.citycode}" definition="#CITYIDNUM2NMAME"/></td>
                     <td><c:out value="${item.standardprice}"/></td>
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
