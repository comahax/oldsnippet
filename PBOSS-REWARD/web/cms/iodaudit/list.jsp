<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_QUERY = "00010701";
    String ID_EXPORT = "CH_PW_REWARD_CIVIC";
%>
<html>
<head>
    <title><bean:message bundle="iodaudit" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_mobile', '<bean:message bundle="iodaudit" key="mobile"/>', 'c', true, '15');
            addfield('_dnl_iodtime', '<bean:message bundle="iodaudit" key="iodtime"/>', 'dt', false, '7');
            addfield('_dnm_iodtime', '<bean:message bundle="iodaudit" key="iodtime"/>', 'dt', false, '7');
            addfield('_se_officetel', '<bean:message bundle="iodaudit" key="officetel"/>', 'c', true, '18');
            addfield('_ne_adtcode', '<bean:message bundle="iodaudit" key="adtcode"/>', 'i', true, '1');
            addfield('_ne_compare', '<bean:message bundle="iodaudit" key="compare"/>', 'i', true, '3');
            return (checkval(window) && compareDate());
        }
    function compareDate(){
        var startTime2 = document.getElementById('_dnl_iodtime').value;
        var endTime2 = document.getElementById('_dnm_iodtime').value;

        if (startTime2 == '') {
        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[起始时间]</span> 不能为空';
        	errorMessageShow(alertstr);
	        return false;
        }
        if (endTime2 == '') {
        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[结束时间]</span> 不能为空';
        	errorMessageShow(alertstr);
	        return false;
        }
       
        if(startTime2 != '' && endTime2 != '' &&  startTime2>endTime2){
	        var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[起始时间]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[结束时间]</span>';
			errorMessageShow(alertstr);
	        return false;
       	}
        
   		return true;	
    }
        
        function exports(){
			var form=document.forms[0];
			form.action="<%=contextPath%>/cms/iodaudit.do?CMD=EXCEL";
			form.submit();
			form.action="<%=contextPath%>/cms/iodaudit.do?CMD=LIST";
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/iodaudit.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			<bean:message bundle="iodaudit" key="titlelist"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="iodaudit" key="mobile"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_mobile"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="iodaudit" key="officetel"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_officetel"></html:text>
                </td>
             </tr> 
             <tr>
             	<td width="126" height="20" align="right" class="form_table_right" >起始时间<!-- <bean:message bundle="iodaudit" key="iodtime"/> -->&gt;=</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_iodtime" onclick="this.value=selectDatetime()"></html:text>
                    <font color="red">*</font>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" >结束时间<!-- <bean:message bundle="iodaudit" key="iodtime"/>  --> &lt;=</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_iodtime" onclick="this.value=selectDatetime()"></html:text>
                	<font color="red">*</font>
                </td>
                
              </tr>
              <tr>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="iodaudit" key="adtcode"/>:</td>
                <td class="form_table_left">
                    <html:select  property="_ne_adtcode">
                    	<option/>
                    	<s:Options definition="#CH_ADT_RULEREL_VALID" />
                    </html:select> 
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="iodaudit" key="compare"/>:</td>
                <td class="form_table_left">
                    <html:select  property="_ne_compare">
                    	<option/>
                    	<s:Options definition="$CH_COMPARE" />
                    </html:select> 
                </td>
            </tr>
            <tr>
                <td width="126" height="20" align="right" class="form_table_right" >补登记标识:</td>
                <td class="form_table_left">
                    <html:select  property="_ne_mendflag">
                    	<option/>
                    	<s:Options definition="$CH_MENDFLAG" />
                    </html:select> 
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ></td>
                <td class="form_table_left">
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
                    <a href="javascript:doOrderby('seq')"><bean:message bundle="iodaudit" key="seq"/></a>
                    <s:OrderImg form="/cms/iodaudit/iodauditForm" field="seq"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adtcontent')"><bean:message bundle="iodaudit" key="adtcontent"/></a>
                    <s:OrderImg form="/cms/iodaudit/iodauditForm" field="adtcontent"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mobile')"><bean:message bundle="iodaudit" key="mobile"/></a>
                    <s:OrderImg form="/cms/iodaudit/iodauditForm" field="mobile"/>
                </td>
                <!-- 
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="iodaudit" key="opnid2"/></a>
                    <s:OrderImg form="/cms/iodaudit/iodauditForm" field="opnid"/>
                </td>
                 -->
                <td>
                    <a href="javascript:doOrderby('iodtime')"><bean:message bundle="iodaudit" key="iodtime"/></a>
                    <s:OrderImg form="/cms/iodaudit/iodauditForm" field="iodtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('sucess')"><bean:message bundle="iodaudit" key="sucess"/></a>
                    <s:OrderImg form="/cms/iodaudit/iodauditForm" field="sucess"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('officetel')"><bean:message bundle="iodaudit" key="officetel"/></a>
                    <s:OrderImg form="/cms/iodaudit/iodauditForm" field="officetel"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adtcode')"><bean:message bundle="iodaudit" key="adtcode"/></a>
                    <s:OrderImg form="/cms/iodaudit/iodauditForm" field="adtcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adtremark')"><bean:message bundle="iodaudit" key="adtremark"/></a>
                    <s:OrderImg form="/cms/iodaudit/iodauditForm" field="adtremark"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('compare')"><bean:message bundle="iodaudit" key="compare"/></a>
                    <s:OrderImg form="/cms/iodaudit/iodauditForm" field="compare"/>
                </td>
                <td>
                	补登标识
                </td>
                <td>
                	补登记处理时间
                </td>
                
                
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/iodaudit.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seq}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <c:out value="${item.seq}"/>
                     </td>
                     <td><c:out value="${item.adtcontent}"/></td>
                     <td><c:out value="${item.mobile}"/></td>
                     <!-- 
                     <td><c:out value="${item.opnid}"/></td>
                      -->
                     <td>
                     	<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.iodtime}" />
                     </td>
                     <td>
                     <s:Code2Name code="${item.sucess}"  definition="$IB_SUCCFLAG" />
                     <td><c:out value="${item.officetel}"/></td>
                     <td>
                      <s:Code2Name code="${item.adtcode}"  definition="#CH_ADT_RULEREL_VALID" />
                     </td>
                     <td><c:out value="${item.adtremark}"/></td>
                     <td>
                      <s:Code2Name code="${item.compare}"  definition="$CH_COMPARE" />
                     </td>
                     <td>
                      <s:Code2Name code="${item.mendflag}"  definition="$CH_MENDFLAG" />
                     </td>
                     <td>
                     	<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.mendtime}" />
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
