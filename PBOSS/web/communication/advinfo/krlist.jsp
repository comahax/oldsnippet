<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>

<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._sk_title', '<s:text name="title"/>', 'c', true, '256');
            addfield('param._ne_type', '<s:text name="type"/>', 'f', true, '3');
            addfield('param._dnl_releasetime', '<s:text name="releasetime"/>', 't', true, '7');
            addfield('param._dnm_releasetime', '<s:text name="releasetime"/>', 't', true, '7');
            return checkval(window);
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="advinfo_krlist.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//����Ŀؼ���Action�ṩ���ݣ�������ҳ%>
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
			<span class="table_toparea_h"><s:text name="study_online"/></span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent5"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
                <td align="center"><s:text name="releasetime"/>&gt;=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_releasetime" onclick="selectDate();" />
                </td>
                <td align="center"><s:text name="releasetime"/>&lt;=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_releasetime" onclick="selectDate();" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/communication/advinfo_krlist.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/communication/advinfo_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/communication/advinfo_krdelete.do')">
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
                    <a href="javascript:doOrderby('title')"><s:text name="title"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('releasetime')"><s:text name="releasetime"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('content')"><s:text name="content"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('desttype')"><s:text name="desttype"/></a>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- ���������á�|������� --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="advinfoid"/>" onclick="checkOne();">
                     </td>
                     <td>
	                     <a href='<s:url action="advinfo_krOrAdvedit.do">
	                     		<s:param name="param._pk" value="advinfoid"/>
	                         	<s:param name="param._ne_type" value="4"/>
	                     		</s:url>'>
	                     <s:property value="title" />
	                     </a>
                     </td>
                     <td>
                     <s:date name="releasetime" format="yyyy-MM-dd"/>
                     </td>
                     <td><s:property value="content" escape="false" /></td>
                     <td><j:code2Name definition="$CH_ADVINFODESTTYPE" code="desttype"/></td>
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
