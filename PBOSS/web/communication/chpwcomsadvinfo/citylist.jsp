<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title><s:text name="titleList"/></title>
<script language="JavaScript" type="text/JavaScript">
function ev_check() {
	addfield('param._sk_title', '<s:text name="title"/>', 'c', true, '256');
	addfield('param._dnm_releasetime', '<s:text name="releasetime"/>', 't', true, '7');
	addfield('param._dnl_releasetime', '<s:text name="releasetime"/>', 't', true, '7');
	addfield('param._ne_state', '<s:text name="state"/>', 'f', true, '3');
	return checkval(window);
}
function doShow(advinfoid, rvcobjid) {
	var url = "<%=contextPath%>/communication/chpwcomsadvinfo_show.do?param._pk=" 
		+ advinfoid + "&param._rvcobjid=" + rvcobjid + "&rand=" + Math.random();
	window.open(url, "_blank", "height=600, width=1000, toolbar=no, menubar=no, scrollbars=yes, resizable=no,location=no, status=no");
}
</script>
</head>

<body leftmargin="5" topmargin="0" bottommargin="0">
<s:form action="chpwcomsadvinfo_cityList.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
	<aa:zone name="hiddenZone">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <s:hidden name="param._advinfoid" id="_advinfoid"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
	</aa:zone>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
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
                    <j:selector name="param._ne_state" definition="COMSRCVOBJ_STATE" cssStyle="select" />
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="_dnl_releasetime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_releasetime" onclick="selectDate();" />
                </td>
                <td align="center"><s:text name="_dnm_releasetime"/>:</td>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/communication/chpwcomsadvinfo_cityList.do');">
                   </s:i18n>
				</td>
			</tr>
		</table>
	</div>

	<aa:zone name="listZone">
    <div class="table_div">
        <table class="table_style">
            <tr class="table_style_head">
                <td>
                    <j:orderByImg href="javascript:doOrderby('title')"><s:text name="title"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('releasetime')"><s:text name="releasetime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('rcvobjtype')"><s:text name="rcvobjtype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('smsnotify')"><s:text name="smsnotify"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('releasecode')"><s:text name="releasecode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('state')"><s:text name="state"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
                     <td><a href='javascript:doShow("<s:property value="advinfoid" />", "<s:property value="rvcobjid" />")'>
							<s:property value="title" />
                         </a>
					 </td>
                     <td><s:date name="releasetime" format="yyyy-MM-dd"/></td>
                     <td><j:code2Name definition="COMSRCVOBJ_RCVOBJTYPE" code="rcvobjtype" /></td>
                     <td><j:code2Name definition="SMSNOTIFY" code="smsnotify" /></td>
                     <td><j:code2Name definition="#OPERATOR" code="releasecode" /></td>
                     <td><j:code2Name definition="COMSRCVOBJ_STATE" code="state" /></td>
                 </tr>
             </s:iterator>
        </table>
    </div>
    <div class="table_div">
		<%@ include file="/common/pageNav.jsp"%>
   	</div>
    </aa:zone>
</s:form>
</body>
</html>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();  
	ajaxAnywhere.formURL = formList.action;
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
