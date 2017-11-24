<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._ne_smstype', '<s:text name="smstype"/>', 'f', true, '3');
            addfield('param._se_sendno', '<s:text name="sendno"/>', 'c', true, '20');
            addfield('param._se_recno', '<s:text name="recno"/>', 'c', true, '20');
            return checkval(window);
        }
    </script>
</head>

<body class="list_body">
<div class="table_container">
<s:form action="result_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
    
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
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
                <td align="center"><s:text name="smstype"/>:</td>
                <td align="left">
                    <j:selector cssStyle="style_input"  name="param._ne_smstype" definition="$CH_STYPE" mode="selector" />
                </td>
                <td align="center"><s:text name="sendno"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_sendno" />
                </td>
            </tr>
            <tr>
            	<td align="center"><s:text name="issuccess"/>:</td>
            	<td align="left">
                    <j:selector cssStyle="style_input"  name="param._ne_issuccess" definition="$CH_SMSISSUCCESS" mode="selector" />
                </td>
                <td align="center"><s:text name="recno"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_recno" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/channel/result_list.do');">
                	<!-- 
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/channel/result_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/channel/result_delete.do')">
                         -->
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
                    <a href="javascript:doOrderby('streamno')"><s:text name="streamno"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('smstype')"><s:text name="smstype"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('areacode')"><s:text name="areacode"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('creattime')"><s:text name="creattime"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('dealtime')"><s:text name="dealtime"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('message')"><s:text name="message"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('sendno')"><s:text name="sendno"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('recno')"><s:text name="recno"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('dealcount')"><s:text name="dealcount"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('issuccess')"><s:text name="issuccess"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('resultcode')"><s:text name="resultcode"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('resultdesc')"><s:text name="resultdesc"/></a>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="streamno"/>" onclick="checkOne();">
                     </td>
                     <td>
						<s:property value="streamno"/>
					 </td>
                     <td><j:code2Name definition="$CH_STYPE" code="smstype"/></td>
                     <td><s:property value="areacode" /></td>
                     <td><s:date name="creattime" format="yyyy-MM-dd HH:mm"/></td>
                     <td><s:date name="dealtime" format="yyyy-MM-dd HH:mm"/></td>
                     <td><s:property value="message" /></td>
                     <td><s:property value="sendno" /></td>
                     <td><s:property value="recno" /></td>
                     <td><s:property value="dealcount" /></td>
                     <td><j:code2Name definition="$CH_SMSISSUCCESS" code="issuccess"/></td>
                     <td><s:property value="resultcode" /></td>
                     <td><s:property value="resultdesc" /></td>
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
	ajaxAnywhere.substituteFormSubmitFunction();  
	ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
</body>
</html>
