<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
       function ev_check() {
            addfield('param._dnm_optime', '<s:text name="optime"/>', 'dt', true, '7');
            addfield('param._dnl_optime', '<s:text name="optime"/>', 'dt', true, '7');
            addfield('param._se_oprcode', '<s:text name="oprcode"/>', 'c', true, '16');
            addfield('param._se_oprtype', '<s:text name="oprtype"/>', 'c', true, '8');
           return (checkval(window) && compareDate());
        }
         function compareDate(){
        	var dnmOptime = document.getElementById('param._dnm_optime').value;
        	var dnlOptime = document.getElementById('param._dnl_optime').value;
        	
        	if(dnmOptime != '' && dnlOptime != '' && dnlOptime>dnmOptime){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnl_optime"/> ]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnm_optime"/>]</span>';
				errorMessageShow(alertstr);
				return false;
        	}
        	return true;
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="ruleitemlog_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea"><s:text name="promotion"/> </span>
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
            	<td align="center"><s:text name="optime"/>>=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_optime" onclick="selectDatetime();"/>
                </td>
                <td align="center"><s:text name="optime"/><=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_optime" onclick="selectDatetime();"/>
                </td>
            </tr>
            <tr>
            	<td align="center"><s:text name="oprcode"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_oprcode" />
                </td>
                <td align="center"><s:text name="oprtype"/>:</td>
                <td align="left">
                	<j:selector definition="$OPRTYPE" name="param._se_oprtype"  cssStyle="style_input"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/promotion/ruleitemlog_list.do');">
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
                <td>
                    <j:orderByImg href="javascript:doOrderby('logid')"><s:text name="logid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('optime')"><s:text name="optime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('oprcode')"><s:text name="oprcode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('oprtype')"><s:text name="oprtype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('success')"><s:text name="success"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('itemid')"><s:text name="itemid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('ruleid')"><s:text name="ruleid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('optexpression')"><s:text name="optexpression"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('datatype')"><s:text name="datatype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('filtermode')"><s:text name="filtermode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('matching')"><s:text name="matching"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
							<s:property value="logid"/>
					 </td>
                     <td><s:date name="optime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><s:property value="oprcode" /></td>
                     <td><j:code2Name definition="$OPRTYPE" code="oprtype"/></td>
                     <td><j:code2Name definition="SUCCESS" code="success"/></td>
                     <td><s:property value="itemid" /></td>
                     <td><s:property value="ruleid" /></td>
                     <td><s:property value="optexpression" /></td>
                     <td><j:code2Name definition="$CH_DATATYPE" code="${datatype}"/></td>
                     <td><j:code2Name definition="FILTERMODE" code="${filtermode}"/></td>
                     <td><s:property value="matching" /></td>
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
