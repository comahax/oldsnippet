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
    <title><bean:message bundle="chpdrewardadc" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_cityid', '<bean:message bundle="chpdrewardadc" key="cityid"/>', 'c', false, '4');
            addfield('_se_provagentid', '<bean:message bundle="chpdrewardadc" key="provagentid"/>', 'c', 'false', '15');
            addfield('_se_prodno', '<bean:message bundle="chpdrewardadc" key="prodno"/>', 'c', 'false', '18');
            addfield('_se_rewardmonth', '<bean:message bundle="chpdrewardadc" key="rewardmonth"/>', 'c', 'false', '8');
            addfield('_ne_isreleaseadc', '<bean:message bundle="chpdrewardadc" key="isreleaseadc"/>', 'f', 'false', '1');
            return checkval(window);
        }
         function doExport(url){
			if (ev_check()) {
				formList.action = contextPath + url + "?CMD=EXCEL";
	  			formList.submit();
	  			formList.action="<%=contextPath%>/cms/provagent/chpdrewardadc.do?CMD=LIST";
			}
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/provagent/chpdrewardadc.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="query" value="true"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/provagent/chpdrewardadc/ChPdRewardadcForm']}"/>

    <!--##################################��ӱ�������##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chpdrewardadc" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpdrewardadc" key="cityid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select styleClass="form_input_1x" property="_se_cityid">
                        <option/>
						<s:Options definition="#REGIONNAME"/>
					</html:select>&nbsp;<font color='red'>*</font>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpdrewardadc" key="provagentid"/>:</td>
                <td width="30%" class="form_table_left">
					 <html:select styleClass="form_input_1x" property="_se_provagentid">
                    	<option></option>
						<s:Options definition="#CH_PD_AGENT"/>
					</html:select>
                </td>
            </tr>
            <tr>
                 <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpdrewardadc" key="_se_prodid"/>:</td>
                <td width="30%" class="form_table_left">
                    <s:myzoom definition="#CH_PD_ENTPRODUCT" property="_se_prodid" styleClass="form_input_1x" readonly="false" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpdrewardadc" key="rewardmonth"/>:</td>
                <td width="30%" class="form_table_left">
                   <html:text styleClass="form_input_1x" property="_se_rewardmonth" onclick="this.value=selectDateYYYYMM();"></html:text>
                </td>
            </tr> 
              <tr>
                 <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpdrewardadc" key="_ne_isreleaseadc"/>:</td>
                <td width="30%" class="form_table_left"> 
                    <html:select styleClass="form_input_1x" property="_ne_isreleaseadc">
                    	 <option></option>
						<s:Options definition="#PD_YESORNO"/> 
                    </html:select> 	
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" colspan="2" ></td>
                 
            </tr> 
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right> 
                            <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" /> 
                                
                            <input type="button" class="button_4" onmouseover="buttonover(this);" 
            		        onclick="doExport('/cms/provagent/chpdrewardadc.do')" 
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_export_excel"/>" /> 
                         
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
               
                <td>
                    <a href="javascript:doOrderby('rewardid')"><bean:message bundle="chpdrewardadc" key="rewardid"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardadc/ChpdrewardadcForm" field="rewardid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="chpdrewardadc" key="cityid"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardadc/ChpdrewardadcForm" field="cityid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('provagentid')"><bean:message bundle="chpdrewardadc" key="provagentid"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardadc/ChpdrewardadcForm" field="provagentid"/>
                </td>
                 <td>
                    ����������
                </td>
                 <td>
                    <a href="javascript:doOrderby('prodno')"><bean:message bundle="chpdrewardadc" key="prodno"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardadc/ChpdrewardadcForm" field="prodno"/>
                </td> 
                <td>
                    <a href="javascript:doOrderby('prodid')"><bean:message bundle="chpdrewardadc" key="prodid"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardadc/ChpdrewardadcForm" field="prodid"/>
                </td>
                <td>���Ų�Ʒ����</td>
                <td>
                    <a href="javascript:doOrderby('custid')"><bean:message bundle="chpdrewardadc" key="custid"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardadc/ChpdrewardadcForm" field="custid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('custname')"><bean:message bundle="chpdrewardadc" key="custname"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardadc/ChpdrewardadcForm" field="custname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('phase')"><bean:message bundle="chpdrewardadc" key="phase"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardadc/ChpdrewardadcForm" field="phase"/>
                </td>
                 <td>
                    <a href="javascript:doOrderby('rewardmonth')"><bean:message bundle="chpdrewardadc" key="rewardmonth"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardadc/ChpdrewardadcForm" field="rewardmonth"/>
                </td> 
                <td>
                    <a href="javascript:doOrderby('rewardmoney')"><bean:message bundle="chpdrewardadc" key="rewardmoney"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardadc/ChpdrewardadcForm" field="rewardmoney"/>
                </td> 
                <td>
                    <a href="javascript:doOrderby('rpmoney')"><bean:message bundle="chpdrewardadc" key="rpmoney"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardadc/ChpdrewardadcForm" field="rpmoney"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('supplemoney')"><bean:message bundle="chpdrewardadc" key="supplemoney"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardadc/ChpdrewardadcForm" field="supplemoney"/>
                </td>
                
                <td>
                    <a href="javascript:doOrderby('inbossmonth')"><bean:message bundle="chpdrewardadc" key="inbossmonth"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardadc/ChpdrewardadcForm" field="inbossmonth"/>
                </td>
                 <td>
                    <a href="javascript:doOrderby('version')"><bean:message bundle="chpdrewardadc" key="version"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardadc/ChpdrewardadcForm" field="version"/>
                </td>
               
                <td>
                    <a href="javascript:doOrderby('reason')"><bean:message bundle="chpdrewardadc" key="reason"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardadc/ChpdrewardadcForm" field="reason"/>
                </td>
               
                <td>
                    <a href="javascript:doOrderby('ruledesc')"><bean:message bundle="chpdrewardadc" key="ruledesc"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardadc/ChpdrewardadcForm" field="ruledesc"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('isreleaseadc')"><bean:message bundle="chpdrewardadc" key="isreleaseadc"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardadc/ChpdrewardadcForm" field="isreleaseadc"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/provagent/chpdrewardadc.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.rewardid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url> 
                 <tr class="table_style_content" align="center"> 
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.rewardid}"/></a>
                     </td>
                     <td><s:Code2Name code="${item.cityid}" definition="#REGIONNAME"/></td>   
                     <td><c:out value="${item.provagentid}"/></td>
                     <td><s:Code2Name code="${item.provagentid}" definition="#CH_PD_AGENT"/></td>
                     <td><c:out value="${item.prodno}"/></td>
                     <td><c:out value="${item.prodid}"/></td>
                     <td><s:Code2Name code="${item.prodid}" definition="#CH_PD_ENTPRODUCT"/></td> 
                     <td><c:out value="${item.custid}"/></td>
                     <td><c:out value="${item.custname}"/></td> 
                     <td><c:out value="${item.phase}"/></td>
                     <td><c:out value="${item.rewardmonth}"/></td>
                     <td><c:out value="${item.rewardmoney}"/></td>
                     <td><c:out value="${item.rpmoney}"/></td>
                     <td><c:out value="${item.supplemoney}"/></td> 
                     <td><c:out value="${item.inbossmonth}"/></td>
                     <td><c:out value="${item.version}"/></td>
                     <td><c:out value="${item.reason}"/></td> 
                     <td><c:out value="${item.ruledesc}"/></td>
                     <td><s:Code2Name code="${item.isreleaseadc}" definition="#PD_YESORNO"  /></td>
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
