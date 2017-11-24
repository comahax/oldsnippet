<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%@ taglib prefix="j" uri="/jop-tags" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
    </script>
</head>
<%
	String ID_EDIT="CH_PW_FLOWNAME_SET";
%>
<body class="list_body">
<div class="table_container">
<s:form action="flowname_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpList"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
                <td align="center"><s:text name="stepid"/>:</td>
                <td align="left">
                   <!-- <j:selector definition="$CH_STEPID" mode="selector" name="param._se_stepid" /> --> 
                    <s:if test="flag == 'yes'">
		        		<j:selector definition="$CH_STEPIDNEW" mode="selector" name="param._se_stepid" />
			        </s:if>
			        <s:else>
			        	<j:selector definition="$CH_STEPID" mode="selector" name="param._se_stepid" />
				    </s:else>
                </td>
                <td align="center"><s:text name="stepname"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._sk_stepname" />
                </td>
             </tr>
             <tr>
                <td align="center"><s:text name="oprcode"/>:</td>
                <td align="left">
                    <j:selector definition="#OPERATOR" name="param._se_oprcode" onclick="document.getElementById('param._se_oprcode').value=document.getElementById('param._se_oprcode').value;"/>
                </td>
                <td align="center"> &nbsp;</td>
                <td align="left">
                    &nbsp;
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/channel/flowname_list.do');">
                	<j:purChk permid="<%=ID_EDIT%>" disableChild="true">
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/channel/flowname_new.do')">
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/channel/flowname_delete.do')">
                      </j:purChk>
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
                    <j:orderByImg href="javascript:doOrderby('stepid')"><s:text name="stepid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('stepname')"><s:text name="stepname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('oprcode')"><s:text name="oprcode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('issms')"><s:text name="issms"/></j:orderByImg>                 
                </td><%--
                <td>
                    <j:orderByImg href="javascript:doOrderby('sendtime')"><s:text name="sendtime"/></j:orderByImg>                 
                </td>
                --%><td>
                    <j:orderByImg href="javascript:doOrderby('nextstepid')"><s:text name="nextstepid"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="stepid"/>" onclick="checkOne();">
                     </td>
                     <td>
                     <j:purChk permid="<%=ID_EDIT%>" disableChild="true"><a href='<s:url action="flowname_edit.do">
	                         <s:param name="param._pk" value="stepid"/>
	                     	</s:url>'>
							<s:property value="stepid"/>
                         </a>
                      </j:purChk>
					 </td>
                     <td><s:property value="stepname" /></td>
                     <td><s:property value="oprcode" /></td>
                     <td>
                     <j:code2Name definition="$IM_YESNO10" code="issms"/>
                     </td><%--
                     <td>
                     <s:property value="sendtime" />
                     </td>
                     --%><td>
                     <!--<j:code2Name code="nextstepid" definition="$CH_STEPID"/>-->
                     <s:if test="flag == 'yes'">
		        		<j:code2Name code="nextstepid" definition="$CH_STEPIDNEW"/>
			        </s:if>
			        <s:else>
			        	<j:code2Name code="nextstepid" definition="$CH_STEPID"/>
				    </s:else>
                     </td>
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
