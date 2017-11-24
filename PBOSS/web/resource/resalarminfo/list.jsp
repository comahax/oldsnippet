<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._dnm_alarmdate', '<s:text name="_dnm_alarmdate"/>', 't', true, '20');
            addfield('param._dnl_alarmdate', '<s:text name="_dnl_alarmdate"/>', 't', true, '20');
            addfield('param._se_countyid', '<s:text name="countyid"/>', 'c', true, '14');
            addfield('param._se_comcategory', '<s:text name="comcategory"/>', 'c', true, '20');
            addfield('param._se_alarmsignal', '<s:text name="alarmsignal"/>', 'c', true, '20');
            return (checkval(window) && compareDate());
        }
        
         function compareDate(){
        	var dnmOptime = document.getElementById('param._dnm_alarmdate').value;
        	var dnlOptime = document.getElementById('param._dnl_alarmdate').value;
        	
        	if(dnmOptime != '' && dnlOptime != '' && dnlOptime>dnmOptime){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnl_alarmdate"/> ]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnm_alarmdate"/>]</span>';
				errorMessageShow(alertstr);
				return false;
        	}
        	return true;
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="resalarminfo_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea"><s:text name="resource"/> </span>
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
                <td align="center"><s:text name="countyid"/>:</td>
                <td align="left">
                     <j:selector definition="#CNTYCOMPANY"  condition="citycompid:${USER.cityid}" name="param._se_countyid" mode="selector" />
                </td>
                <td align="center"  colspan="2">&nbsp;</td>
                
             </tr>
             
             <tr>
               <td align="center"><s:text name="comcategory"/>:</td>
                <td align="left">
                    <j:selector name="param._se_comcategory" definition="$IM_FXCOMCATEGORY" mode="picker"/>
                </td>
                <td align="center"><s:text name="alarmsignal"/>:</td>
                <td align="left">
                    <j:selector name="param._se_alarmsignal" definition="$IM_ALARMSIGNAL" mode="selector"/>
                </td>
            </tr>
            <tr>  
             <td align="center"><s:text name="_dnl_alarmdate"/>:</td>
                <td align="left">
                    <s:textfield id="param._dnl_alarmdate" cssStyle="style_input" name="param._dnl_alarmdate" onclick="selectDate();"/>
                </td> 
                <td align="center"><s:text name="_dnm_alarmdate"/>:</td>
                <td align="left">
                    <s:textfield id="param._dnm_alarmdate" cssStyle="style_input" name="param._dnm_alarmdate" onclick="selectDate();"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/resource/resalarminfo_list.do');">
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
                    <a href="javascript:doOrderby('recid')"><s:text name="recid"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('alarmdate')"><s:text name="alarmdate"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('countyid')"><s:text name="countyid"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('comcategory')"><s:text name="comcategory"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('stockamt')"><s:text name="stockamt"/><s:text name="union"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('saledamt')"><s:text name="saledamt"/><s:text name="union"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('actedamt')"><s:text name="actedamt"/><s:text name="union"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('actrate')"><s:text name="actrate"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('alarmsignal')"><s:text name="alarmsignal"/></a>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="recid"/>" onclick="checkOne();">
                     </td>
                     <td>
							<s:property value="recid"/>
					 </td>
                     <td><s:date name="alarmdate" format="yyyy-MM-dd"/></td>
                     <td><j:code2Name definition="#CNTYCOMPANY" code="countyid"/></td>
                     <td><j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory"/></td>
                     <td><s:property value="stockamt" /></td>
                     <td><s:property value="saledamt" /></td>
                     <td><s:property value="actedamt" /></td>
                     <td><s:property value="actrate" /></td>
                     <td><j:code2Name definition="$IM_ALARMSIGNAL" code="alarmsignal"/></td>
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
