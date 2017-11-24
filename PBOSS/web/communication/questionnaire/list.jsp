<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('param._dnl_releasetime', '<s:text name="releasetime"/>', 't', true, 7);
        	addfield('param._dnm_releasetime', '<s:text name="releasetime"/>', 't', true, 7);
            return checkval(window);
        }
        
        function doView(cmdView,advinfoid)
        {
        	var url = contextPath + cmdView + "?param._pk=" + advinfoid;
		    formList.action = url;  
		    formList.submit();
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="questionnaire_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
    <aa:zone name="hiddenZone"><s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/></aa:zone>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="communication"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent2"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
		</div>
	</div>
    
    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>
	
	<div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="center"><s:text name="title"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._sk_title" />
                </td>
                <td align="center"><s:text name="state"/>:</td>
                <td align="left">
                	<j:selector definition="$CH_ADVINFOSTATE" name="param._ne_state"/>
                </td>
            </tr>
            <tr>
            	<td align="center"><s:text name="releasetime"/>>=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_releasetime" onclick="selectDate();"/>
                </td>
                <td align="center"><s:text name="releasetime"/><=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_releasetime" onclick="selectDate();"/>
                </td>
            </tr>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
                	<s:i18n name="public">
                	<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_search"/>" onClick="doQuery('/communication/questionnaire_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/communication/questionnaire_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/communication/questionnaire_delete.do')">
                   </s:i18n>
				</td>
			</tr>
		</table>
	</div>

	<aa:zone name="listZone">
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style">
            <tr class="table_style_head">
               	<s:i18n name="public">
                <td title="<s:text name="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();"/>
                </td>
                </s:i18n>
                <td>
                    <j:orderByImg href="javascript:doOrderby('title')"><s:text name="title"/></j:orderByImg>                 
                </td>
                <td>
                    <s:text name="view"/>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('releasetime')"><s:text name="releasetime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('desttype')"><s:text name="desttype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('smsnotify')"><s:text name="smsnotify"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('state')"><s:text name="state"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                     	<s:if test="state==3">
                     		<input type="checkbox" name="param._selectitem" value="<s:property value="advinfoid"/>" onclick="checkOne();">
                     	</s:if>
                     	<s:else>
                     		<input type="checkbox" name="param._selectitem2" disabled="disabled" value="<s:property value="advinfoid"/>">
                     	</s:else>
                         
                     </td>
                     <td>
						<s:if test="state==3">
	                     	<a href='<s:url action="questionnaire_edit.do">
		                         <s:param name="param._pk" value="advinfoid"/>
		                     	 </s:url>'>
		                     	 <span STYLE="overflow:hidden; text-overflow:ellipsis; white-space:nowrap;width:300px" title="<s:property value="title"/>"/>
								 	<s:property value="title"/>
								 </span>
	                        	 </a>
	                      </s:if>
	                      <s:else>
								<span STYLE="overflow:hidden; text-overflow:ellipsis; white-space:nowrap;width:300px" title="<s:property value="title"/>"/>
									<s:property value="title"/>
								</span>
				          </s:else>
                     </td>
                     <td>
                     <input type="button" name="btnView" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="view"/>" onClick="doView('/communication/questionnaire_view.do','<s:property value="advinfoid"/>')">
                     </td>
                     <td><s:date name="releasetime" format="yyyy-MM-dd"/></td>
                     <td><j:code2Name definition="$CH_ADVINFODESTTYPE" code="desttype" /></td>
                     
                     <td><j:code2Name definition="SMSNOTIFY" code="smsnotify" /></td>
                 	<td><j:code2Name definition="$CH_ADVINFOSTATE" code="state" /></td>
                 </tr>
             </s:iterator>
        </table>
    	</div>
    </div>
    <div class="table_div">
		<%@ include file="/common/pageNav.jsp"%>
   	</div>
	</aa:zone>
</s:form>
</div>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
</body>
</html>
