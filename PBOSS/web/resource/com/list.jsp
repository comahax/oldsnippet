<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._ne_comid', '<s:text name="comid"/>', 'f', true, '18');
            addfield('param._ne_comclassid', '<s:text name="comclassid"/>', 'f', true, '6');
            addfield('param._ne_comtype', '<s:text name="comtype"/>', 'f', true, '6');
            addfield('param._sk_comname', '<s:text name="comname"/>', 'c', true, '128');
            return checkval(window);
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="com_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea"><s:text name="resource"/> </span>
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
                <td align="center"><s:text name="comid"/>:</td>
                <td align="left">
                    <j:Comidtree name="param._ne_comid" condition="comclassid:0;comclassid:1;comclassid:2;comclassid:3;comclassid:4;comclassid:5;comclassid:6;comclassid:99" definition="#COMSYSTEM" nameOnly="true" readonly="true"/>
                </td>
                <td align="center"><s:text name="comname"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._sk_comname" />
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="comclassid"/>:</td>
                <td align="left">
                     <j:selector definition="$IM_COMCLASS" name="param._ne_comclassid"  cssStyle="style_input"/>
                </td>
                <td align="center"><s:text name="comtype"/>:</td>
                <td align="left">
                    <j:selector definition="$IM_COMTYPE" name="param._ne_comtype"  cssStyle="style_input" mode="picker"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/resource/com_list.do');">
                	
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
                    <j:orderByImg href="javascript:doOrderby('comid')"><s:text name="comid"/></j:orderByImg>                 
                </td>
                  <td>
                    <j:orderByImg href="javascript:doOrderby('comname')"><s:text name="comname"/></j:orderByImg>                 
                </td>
               
                <td>
                    <j:orderByImg href="javascript:doOrderby('comclassid')"><s:text name="comclassid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comtype')"><s:text name="comtype"/></j:orderByImg>                 
                </td>
                 <td>
                    <j:orderByImg href="javascript:doOrderby('comprice')"><s:text name="comprice"/>(元)</j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('cityid')"><s:text name="cityid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comcode')"><s:text name="comcode"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
                     <td>
							<s:property value="comid"/>
					 </td>
                     
                     <td><s:property value="comname" /></td>
                     <td><j:code2Name definition="$IM_COMCLASS" code="comclassid"/></td>
                     <td><j:code2Name definition="$IM_COMTYPE" code="comtype"/></td>
                     <td>
                     <s:i18n name="public">
	                     <s:text name="format.double">
	                     <s:param value="%{comprice/100.0}"/>
	                     </s:text>
	                 </s:i18n>
                     </td>
                     <td><s:property value="cityid" /></td>
                     <td><s:property value="comcode" /></td>
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
