<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_3 = "00010703";
%>
<html>
<head>
    <title><bean:message bundle="yxplancplog" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_dnl_createtime', '<bean:message bundle="yxplancplog" key="createtime"/>', 't', true, '25');
            addfield('_dnm_createtime', '<bean:message bundle="yxplancplog" key="createtime"/>', 't', true, '25');
            addfield('_sk_oprcode', '<bean:message bundle="yxplancplog" key="oprcode"/>', 'c', true, '15');
            addfield('_se_oprtype', '<bean:message bundle="yxplancplog" key="oprtype"/>', 'c', true, '32');
            addfield('_sk_batchno', '<bean:message bundle="yxplancplog" key="batchno"/>', 'c', true, '32');
            addfield('_se_oprresulte', '<bean:message bundle="yxplancplog" key="oprresulte"/>', 'c', true, '32');
            addfield('_se_oprstate', '<bean:message bundle="yxplancplog" key="oprstate"/>', 'c', true, '32');
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/zifee/yxplancplog.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			<bean:message bundle="yxplancplog" key="titleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="yxplancplog" key="_dnl_createtime"/>:</td>
                <td class="form_table_left">
                <html:text styleClass="form_input_1x" property="_dnl_createtime" onclick="this.value=selectDate();"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="yxplancplog" key="_dnm_createtime"/>:</td>
                <td class="form_table_left">
                <html:text styleClass="form_input_1x" property="_dnm_createtime" onclick="this.value=selectDate();"></html:text>
               </td>
               </tr>
            <tr>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="yxplancplog" key="oprcode"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_oprcode"></html:text>
                </td>
            <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="yxplancplog" key="batchno"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_batchno"></html:text>
                </td>
               
               </tr>
            <tr>

                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="yxplancplog" key="oprtype"/>:</td>
                <td class="form_table_left">
                <html:select property="_se_oprtype">
		                		<option value=""  ></option>		                		
		                		<s:Options  definition="#PC_OPRTYPE"/>
		            </html:select>   
               </td>
           
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="yxplancplog" key="oprstate"/>:</td>
                <td class="form_table_left" >
                 <html:select property="_se_oprstate">
		                		<option value=""  ></option>		                		
		                		<s:Options  definition="#OPRSTATE"/>
		            </html:select>
                </td>
                </tr>
            <tr>
    			
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        
                        <s:PurChk controlid="<%=ID_3%>">
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
               
                <td>
                    <a href="javascript:doOrderby('logid')"><bean:message bundle="yxplancplog" key="logid"/></a>
                    <s:OrderImg form="/zifee/yxplancplog/yxplancplogForm" field="logid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('createtime')"><bean:message bundle="yxplancplog" key="createtime"/></a>
                    <s:OrderImg form="/zifee/yxplancplog/yxplancplogForm" field="createtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('modifytime')"><bean:message bundle="yxplancplog" key="modifytime"/></a>
                    <s:OrderImg form="/zifee/yxplancplog/yxplancplogForm" field="modifytime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="yxplancplog" key="oprcode"/></a>
                    <s:OrderImg form="/zifee/yxplancplog/yxplancplogForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtype')"><bean:message bundle="yxplancplog" key="oprtype"/></a>
                    <s:OrderImg form="/zifee/yxplancplog/yxplancplogForm" field="oprtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('orgyxplanid')"><bean:message bundle="yxplancplog" key="orgyxplanid"/></a>
                    <s:OrderImg form="/zifee/yxplancplog/yxplancplogForm" field="orgyxplanid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('newyxplanid')"><bean:message bundle="yxplancplog" key="newyxplanid"/></a>
                    <s:OrderImg form="/zifee/yxplancplog/yxplancplogForm" field="newyxplanid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('copyitem')"><bean:message bundle="yxplancplog" key="copyitem"/></a>
                    <s:OrderImg form="/zifee/yxplancplog/yxplancplogForm" field="copyitem"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('batchno')"><bean:message bundle="yxplancplog" key="batchno"/></a>
                    <s:OrderImg form="/zifee/yxplancplog/yxplancplogForm" field="batchno"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprresulte')"><bean:message bundle="yxplancplog" key="oprresulte"/></a>
                    <s:OrderImg form="/zifee/yxplancplog/yxplancplogForm" field="oprresulte"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprstate')"><bean:message bundle="yxplancplog" key="oprstate"/></a>
                    <s:OrderImg form="/zifee/yxplancplog/yxplancplogForm" field="oprstate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprobject')"><bean:message bundle="yxplancplog" key="oprobject"/></a>
                    <s:OrderImg form="/zifee/yxplancplog/yxplancplogForm" field="oprobject"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('remark')"><bean:message bundle="yxplancplog" key="remark"/></a>
                    <s:OrderImg form="/zifee/yxplancplog/yxplancplogForm" field="remark"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center">
                     <td>
                         <c:out value="${item.logid}"/>
                     </td>
                     <td><c:out value="${item.createtime}"/></td>
                     <td><c:out value="${item.modifytime}"/></td>
                     <td><c:out value="${item.oprcode}"/></td>
                     <td><s:Code2Name code="${item.oprtype}" definition="#PC_OPRTYPE"/></td>
                     <td><c:out
												value="${item.orgyxplanid}" /> - <s:Code2Name
												code="${item.orgyxplanid}" definition="#ZIFEE-YXPLAN" /></td>
                    <td><c:out
												value="${item.newyxplanid}" /> - <s:Code2Name
												code="${item.newyxplanid}" definition="#ZIFEE-YXPLAN" /></td>
                     
                  
                     <td><c:out value="${item.copyitem}"/></td>
                     <td><c:out value="${item.batchno}"/></td>
                     <td><s:Code2Name code="${item.oprresulte}" definition="$OPRRESULT"/></td>
                     <td><s:Code2Name code="${item.oprstate}" definition="#OPRSTATE"/></td>
                     <td><c:out value="${item.oprobject}"/></td>
                     <td><c:out value="${item.remark}"/></td>
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
