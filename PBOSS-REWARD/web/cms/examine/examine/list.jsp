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
    <title><bean:message bundle="examine" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_sk_exmnname', '<bean:message bundle="examine" key="exmnname"/>', 'c', 'false', '50');
            addfield('_se_state', '<bean:message bundle="examine" key="state"/>', 'c', 'false', '32');
            addfield('_sk_adtype', '<bean:message bundle="examine" key="adtype"/>', 'c', 'false', '32');
            addfield('_sk_starlevel', '<bean:message bundle="examine" key="starlevel"/>', 'c', 'false', '32');
            return checkval(window);
        }
        function doMyDelete(url){
        	var selectitem=document.getElementsByName("_selectitem");
        	var provincialright=document.getElementById("provincialright").value;
        	var isGDright=false;
        	for(var i=0;i<selectitem.length;i++){
        		if(selectitem[i].checked==true){
	        		var strs=selectitem[i].value.split("|");
	        		var exmncityid=strs[1];
	        		if(provincialright=='YES' && exmncityid!='GD'){//省公司，但不是省公司考核
		     			var alertstr="<span class=\'errorkey\'>所有的考核记录含有地市特有，您无法删除！</span>";
						errorMessageShow(alertstr);
						return false;
		     		}else
		     		 if(provincialright!='YES'&& exmncityid=='GD'){//不是省公司，是省公司的考核
		     			var alertstr="<span class=\'errorkey\'>所有的考核记录含有省公司设置，您无法删除</span>";
						errorMessageShow(alertstr);
						return false;
		     		}else
		     		if(provincialright=='YES' && exmncityid=='GD'){//省公司，是省公司考核
		     			isGDright=true;
		     		}
		     	}
        	}
        	if(isGDright){
        		if(confirm("所有的考核记录含有属于省公司的考核，删除考核项明细记录的同时，将删除地市公司针对该考核项明细设置的指标值?"))
	     				doDelete(url);
        	}else
     			doDelete(url);
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/examine/examine.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
     <input type="hidden" id="provincialright" name="provincialright" value="<c:out value="${provincialright}"/>">
    <c:set var="form" scope="request" value="${requestScope['/cms/examine/examine/ExamineForm']}"/>
   

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="examine" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="examine" key="exmnname"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_exmnname"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="examine" key="state"/>:</td>
                <td width="30%" class="form_table_left">
                     <html:select property="_se_state">
                   		    <option/>
                   		    <s:Options definition="$CH_KHSTATE"/>
                     </html:select>
                </td>
            </tr>
           
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="examine" key="adtype"/>:</td>
                <td width="30%" class="form_table_left">
                     <html:select property="_sk_adtype">
                   		    <option/>
                   		    <s:Options definition="$CH_ADTYPE"/>
                     </html:select>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="examine" key="starlevel"/>:</td>
                <td width="30%" class="form_table_left">
                     <html:select property="_sk_starlevel">
                   		    <option/>
                   		    <s:Options definition="$CH_STARLEVEL"/>
                     </html:select>
                </td>
            </tr>
            <c:if test="${provincialright=='YES'}">
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="examine" key="cityid"/>:</td>
                <td width="30%" class="form_table_left">
                     <html:select property="_se_cityid">
                   		    <option/>
                   		    <s:Options definition="#CITYNAME"/>
                     </html:select>
                </td>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	&nbsp;
            	</td>
            	<td width="30%" class="form_table_left">
               	 &nbsp;
            	</td>
            </tr>
            </c:if>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/examine/examine.do')">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doMyDelete('/cms/examine/examine.do')">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
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
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td>
                    <a href="javascript:doOrderby('exmnid')"><bean:message bundle="examine" key="exmnid"/></a>
                    <s:OrderImg form="/cms/examine/examine/ExamineForm" field="exmnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('exmnname')"><bean:message bundle="examine" key="exmnname"/></a>
                    <s:OrderImg form="/cms/examine/examine/ExamineForm" field="exmnname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('state')"><bean:message bundle="examine" key="state"/></a>
                    <s:OrderImg form="/cms/examine/examine/ExamineForm" field="state"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="examine" key="city"/></a>
                    <s:OrderImg form="/cms/examine/examine/ExamineForm" field="cityid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adtype')"><bean:message bundle="examine" key="adtype"/></a>
                    <s:OrderImg form="/cms/examine/examine/ExamineForm" field="adtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('starlevel')"><bean:message bundle="examine" key="starlevel"/></a>
                    <s:OrderImg form="/cms/examine/examine/ExamineForm" field="starlevel"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('memo')"><bean:message bundle="examine" key="exmnperiod"/></a>
                    <s:OrderImg form="/cms/examine/examine/ExamineForm" field="exmnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rights')"><bean:message bundle="examine" key="examinestd"/></a>
                    <s:OrderImg form="/cms/examine/examine/ExamineForm" field="exmnid"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/examine/examine.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.exmnid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                  <c:url value="/cms/examine/exmnperiod.do?CMD=LIST" var="urlExmnperiodList">
                     <c:param name="_ne_exmnid" value="${item.exmnid}"/>
                 </c:url>
                 <c:url value="/cms/examine/exmnitem.do?CMD=LIST" var="urlExmnitemList">
                     <c:param name="_ne_exmnid" value="${item.exmnid}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.exmnid}' />|<c:out value='${item.cityid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.exmnid}"/></a>
                     </td>
                     <td><c:out value="${item.exmnname}"/></td>
                     <td><s:Code2Name definition="$CH_KHSTATE" code="${item.state}"/></td>
                     <td><s:Code2Name definition="#CITYNAME" code="${item.cityid}"/></td>
                     <td>
                   		<span STYLE="overflow:hidden; text-overflow:ellipsis; white-space:nowrap;width:120px" title="<s:MoreCode2Name definition="$CH_ADTYPE" code="${item.adtype}"/>">
                   			<s:MoreCode2Name definition="$CH_ADTYPE" code="${item.adtype}"/>
                   		</span>
                     </td>
                     <td>
                     	<span STYLE="overflow:hidden; text-overflow:ellipsis; white-space:nowrap;width:120px" title="<s:MoreCode2Name definition="$CH_STARLEVEL" code="${item.starlevel}"/>">
                     		<s:MoreCode2Name definition="$CH_STARLEVEL" code="${item.starlevel}"/>
                     	</span>
                     </td>
                     		
                     <td>
                     	<a href='<c:out value="${urlExmnperiodList}"/>'>
                     		<bean:message bundle="examine" key="setexmnperiod"/>
                     	</a>
                     </td>
                     <td>
                     	<a href='<c:out value="${urlExmnitemList}"/>'>
                     		<bean:message bundle="examine" key="modexaminestd"/>
                     	</a>
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
