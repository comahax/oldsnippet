<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._sk_title', '<s:text name="title"/>', 'c', true, '256');
            addfield('param._ne_state', '<s:text name="state"/>', 'f', true, '3');
            return checkval(window);
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="advinfo_qalist.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
    
    <s:hidden name="param._ne_type"/>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="communication"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea"><s:text name="knowledgeManage"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h"><s:text name="qa_online"/></span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent6"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
                    <j:selector definition="$CH_ADVINFOSTATE" name="param._ne_state" cssStyle="style_input" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/communication/advinfo_qalist.do');">
                	
                    <%--<input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/communication/advinfo_delete.do')">
                   	--%>
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
                <%--<td title="<s:text name="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();"/>
                </td>
                --%>
                </s:i18n>
                <td>
                    <a href="javascript:doOrderby('title')"><s:text name="title"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('releasetime')"><s:text name="releasetime"/></a>                 
                </td>
                 <td>
                    <a href="javascript:doOrderby('state')"><s:text name="state"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><s:text name="q_wayid"/></a>                 
                </td>
                 <td>
                    <a href="javascript:doOrderby('oprcode')"><s:text name="q_code"/></a>                 
                </td>
                 <td>
                    <a href="javascript:doOrderby('waymagcode')"><s:text name="way_manager"/></a>                 
                </td>
                
                 <td>
                    <a href="javascript:"><s:text name="reply"/></a>                 
                </td>
            </tr>
            <s:iterator value="dp.datas" var="qainfo">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
					 <%--
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="advinfoid"/>" onclick="checkOne();">
                     </td>
                     --%>
                     <!-- 
                     <td><a href='<s:url action="advinfo_edit.do">
	                         <s:param name="param._pk" value="advinfoid"/>
	                     	</s:url>'>
							<s:property value="advinfoid"/>
                         </a>
					 </td>
					 -->
                     <td><a href='<s:url action="advinfo_qareply.do">
                     			<s:param name="param._ne_advinfoid" value="%{advinfoid}"/>
                     			<s:param name="mode" value="'view'"/>
                     			
                     		</s:url>'>
                     		<s:property value="title" />
                     	</a>
                     </td>
                     <td><s:date name="releasetime" format="yyyy-MM-dd"/></td>
                     <td><j:code2Name definition="$CH_ADVINFOSTATE" code="state"/></td>
                     <td><s:property value="wayid" />(<s:property value="wayname"/>)</td>
                     <td><s:property value="oprcode"/></td>
                     <td><s:property value="opername"/></td>
                     <td>
                     	<s:if test="dBAccessUser.oprcode == waymagcode">
                     		<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
		                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                        value="<s:text name="button_reply"/>" onClick="window.location.href='/communication/advinfo_qareply.do?param._ne_advinfoid=<s:property value="advinfoid"/>&mode=reply';" 
		                    	<s:if test="#qainfo.state == 4">disabled = "true"</s:if>    
		                    >
                     	</s:if>
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
		return "errorZone,listZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
</body>
</html>
