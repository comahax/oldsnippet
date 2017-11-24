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
    <title><bean:message bundle="exmnitemdtl" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_seqid', '<bean:message bundle="exmnitemdtl" key="seqid"/>', 'f', 'false', '10');
            addfield('_ne_exmnid', '<bean:message bundle="exmnitemdtl" key="exmnid"/>', 'f', 'false', '6');
            addfield('_ne_exmnstdid', '<bean:message bundle="exmnitemdtl" key="exmnstdid"/>', 'f', 'false', '6');
            addfield('_se_cityid', '<bean:message bundle="exmnitemdtl" key="cityid"/>', 'c', 'false', '3');
            return checkval(window);
        }
         function doReturn(cmdReturn) {
        	document.getElementsByName("_ne_exmnstdid")[0].value="";
		    formList.action = contextPath + cmdReturn;
		    formList.submit();
		}
		function doMyDelete(url){
			var provincialright=document.getElementById("provincialright").value;
     		var exmncityid=document.getElementById("exmncityid").value;
     		if(provincialright=='YES' && exmncityid!='GD'){//省公司，但不是省公司考核
     			var alertstr="<span class=\'errorkey\'>该考核记录为地市特有，您无法删除！</span>";
				errorMessageShow(alertstr);
				return false;
     		}else
     		 if(provincialright!='YES'&& exmncityid=='GD'){//不是省公司，是省公司的考核
     			var alertstr="<span class=\'errorkey\'>该考核记录为省公司设置，您无法删除</span>";
				errorMessageShow(alertstr);
				return false;
     		}else
     		if(provincialright=='YES' && exmncityid=='GD'){//省公司，是省公司考核
     			if(confirm("删除该考核项明细记录的同时，将删除地市公司针对该考核项明细设置的指标值?"))
     				doDelete(url+"?cityid="+exmncityid);
     		}else{
     			doDelete(url+"?cityid="+exmncityid);
     		}
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/examine/exmnitemdtl.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_exmnid"/>
    <html:hidden property="_ne_exmnstdid"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/examine/exmnitemdtl/ExmnitemdtlForm']}"/>
	<input type="hidden" id="provincialright" name="provincialright" value="<c:out value="${provincialright}"/>">
	<input type="hidden" id="exmncityid" name="exmncityid" value="<c:out value="${exmncityid}"/>">
    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="exmnitemdtl" key="titleList"/>
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
		<table class="table_button_list">
			<tr> 
                <td align=right>
                		 <c:if test="${(provincialright=='YES' and exmncityid=='GD') or (provincialright!='YES' and exmncityid!='GD')}">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/examine/exmnitemdtl.do')">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doMyDelete('/cms/examine/exmnitemdtl.do')">
                        </c:if>
                          <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                            name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_return"/>" class="close"
                            onclick="doReturn('/cms/examine/exmnitem.do?CMD=LIST')">
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
                    <a href="javascript:doOrderby('seqid')"><bean:message bundle="exmnitemdtl" key="seqid"/></a>
                    <s:OrderImg form="/cms/examine/exmnitemdtl/ExmnitemdtlForm" field="seqid"/>
                </td>
               
               
                <td>
                    <a href="javascript:doOrderby('marktype')"><bean:message bundle="exmnitemdtl" key="marktype"/></a>
                    <s:OrderImg form="/cms/examine/exmnitemdtl/ExmnitemdtlForm" field="marktype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('basemk')"><bean:message bundle="exmnitemdtl" key="basemkinfo"/></a>
                    <s:OrderImg form="/cms/examine/exmnitemdtl/ExmnitemdtlForm" field="basemk"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('leastcrtcl')"><bean:message bundle="exmnitemdtl" key="leastcrtcl"/></a>
                    <s:OrderImg form="/cms/examine/exmnitemdtl/ExmnitemdtlForm" field="leastcrtcl"/>
                </td>
                 <td>
                    <a href="javascript:doOrderby('largestcrtcl')"><bean:message bundle="exmnitemdtl" key="largestcrtcl"/></a>
                    <s:OrderImg form="/cms/examine/exmnitemdtl/ExmnitemdtlForm" field="largestcrtcl"/>
                </td>
                <c:if test="${provincialright!='YES' and exmncityid=='GD'}">
                	 <td>
                    	<bean:message bundle="exmnitemdtl" key="city_stcrtcl"/>
                	</td>
                </c:if>
               <c:if test="${provincialright=='YES'}">
                <td>
                    <a href="javascript:doOrderby('pseqid')"><bean:message bundle="exmnitemdtl" key="citystcrtcl"/></a>
                    <s:OrderImg form="/cms/examine/exmnitemdtl/ExmnitemdtlForm" field="pseqid"/>
                </td>
                </c:if>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/examine/exmnitemdtl.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seqid}"/>
                     <c:param name="_ne_exmnid" value="${item.exmnid}"/>
                     <c:param name="_ne_exmnstdid" value="${item.exmnstdid}"/>
                 </c:url>
                  <c:url value="/cms/examine/exmnitemdtl.do?CMD=Citylist" var="urlCitylist">
                     <c:param name="_ne_pseqid" value="${item.seqid}"/>
                     <c:param name="_ne_exmnid" value="${item.exmnid}"/>
                     <c:param name="_ne_exmnstdid" value="${item.exmnstdid}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.seqid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.seqid}"/></a>
                     </td>
                     <td><s:Code2Name definition="$CH_MARKTYPE" code="${item.marktype}"/></td>
                     <c:if test="${item.marktype==0}"> 
                     <td><c:out value="${item.basemk}"/></td>
                     </c:if>
                     <c:if test="${item.marktype==1}">
                     <td><c:out value="${item.basemk}"/>:<c:out value="${item.dynamicmk}"/></td>
                     </c:if>
                     <td><c:out value="${item.leastcrtcl}"/></td>
                     <td><c:out value="${item.largestcrtcl}"/></td>
                     <c:if test="${provincialright!='YES' and exmncityid=='GD'}">
                     	<td>&nbsp;
                     	<c:forEach var="ctr" items="${MAP}">
                     		<c:if test="${item.seqid==ctr.key }">
                     			<c:out value="${ctr.value[0]}"/>/<c:out value="${ctr.value[1]}"/>
                     		</c:if>
                     	</c:forEach>
                     	</td>
                     </c:if>
                     	
                     <c:if test="${provincialright=='YES'}">
                    	 <td><a href='<c:out value="${urlCitylist}"/>'><bean:message bundle="exmnitemdtl" key="show"/></a></td>
                     </c:if>
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
