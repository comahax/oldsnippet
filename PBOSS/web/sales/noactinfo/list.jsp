<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	if(document.all("param._se_mobileno").value!="" && document.all("param._se_mobileno").value.length!=11)
        	{
        	  alert("手机号码必须为11位!");
        	  return false;
        	}
            addfield('param._se_mobileno', '<s:text name="mobileno"/>', 'i', true, '11');
            addfield('param._dnm_activedate', '<s:text name="activedate"/>', 't', true, '7');
            addfield('param._dnl_activedate', '<s:text name="activedate"/>', 't', true, '7');
            addfield('param._dnm_creattime', '<s:text name="creattime"/>', 'dt', true, '7');
            addfield('param._dnl_creattime', '<s:text name="creattime"/>', 'dt', true, '7');
            if(date_compare('param._dnl_activedate','param._dnm_activedate','[激活日期<=]必须大于[激活日期>=]'))
            {
             return false;
            }
            if(date_compare('param._dnl_creattime','param._dnm_creattime','[录入时间<=]必须大于[录入时间>=]'))
            {
             return false;
            }
            return checkval(window);
        }
        function doExcel(cmdNew) {
		//    var url = addParam(contextPath + cmdNew, 'CMD', 'NEW');
		    var url = contextPath + cmdNew;
		    formList.action = url;  
		    formList.submit();
		    formList.action="<%=contextPath%>/sales/noactinfo_list.do";
		}
    </script>
</head>

<body class="list_body"  onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="noactinfo_list.do" key="formList" cssStyle="formList" theme="simple">
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
			<span class="table_toparea"><s:text name="sales"/> </span>
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
                <td align="center"><s:text name="activedate"/>>=</td>
                <td align="left">
                	<s:textfield cssStyle="style_input" name="param._dnl_activedate" onclick="selectDate();"/>
                </td>
                <td align="center"><s:text name="activedate"/><=</td>
                <td align="left">
              		<s:textfield cssStyle="style_input" name="param._dnm_activedate" onclick="selectDate();"/>
                </td>
                 <td align="center"><s:text name="mobileno"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_mobileno" />
                </td>
             </tr>
             <tr>
                <td align="center"><s:text name="creattime"/>>=</td>
                <td align="left">
                	<s:textfield cssStyle="style_input" name="param._dnl_creattime" onclick="selectDatetime();"/>
                </td>
                <td align="center"><s:text name="creattime"/><=</td>
                <td align="left">
                	<s:textfield cssStyle="style_input" name="param._dnm_creattime" onclick="selectDatetime();"/>
                </td>
                <td></td>
                <td></td>
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
                        value="<s:text name="button_search"/>" onClick="return ev_check();doQuery('/sales/noactinfo_list.do');">
                	
                   <input type="button" id="btnExcel" name="btnExcel" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_exportexcel"/>" onClick="doExcel('/sales/noactinfo_excel.do')">
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
                    <j:orderByImg href="javascript:doOrderby('recid')"><s:text name="recid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('mobileno')"><s:text name="mobileno"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('activedate')"><s:text name="activedate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('creattime')"><s:text name="creattime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('memo')"><s:text name="memo"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
							<s:property value="recid"/>
					 </td>
                     <td><s:property value="mobileno" /></td>
                     <td>
                     	<s:date name="activedate" format="yyyy-MM-dd" />
                     </td>
                     <td>
                     	<s:date name="creattime" format="yyyy-MM-dd HH:mm:ss" />
                     </td>
                     <td><s:property value="memo" /></td>
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
