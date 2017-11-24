<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%@ taglib prefix="j" uri="/jop-tags" %>
<%
	String ID_10 = "CH_EDITWAYINFO";
%>
<html>
<head>
    <title><s:text name="titleList"/></title>
     <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_employeeid', '<s:text name="employeeid"/>', 'c', true, '15');
            addfield('param._se_employeename', '<s:text name="employeename"/>', 'c', true, '30');
            addfield('param._ne_empstatus', '<s:text name="empstatus"/>', 'f', true, '2');
            addfield('param._se_svccode', '<s:text name="svccode"/>', 'c', true, '14');
            addfield('param._sk_wayid', '<s:text name="wayid"/>', 'c', true, '18');
            addfield('param._dnm_intime', '<s:text name="intime"/>', 't', true, '7');
            addfield('param._dnl_intime', '<s:text name="intime"/>', 't', true, '7');
            addfield('param._se_officetel', '<s:text name="officetel2"/>', 'i', true, '11');
            addfield('param._ne_isnet', '<s:text name="isnet"/>', 'f', true, '2');
          //  addfield('param._ne_isopen', '<s:text name="isopen"/>', 'i', true, '2');
            addfield('param._se_selectmobile', '<s:text name="selectmobile"/>', 'i', true, '11');
            return checkval(window);
        }
        function doBatch(){
        	formList.action= "<%=contextPath%>/channel/employee_import.do";
        	formList.submit();
        }
        function doTxt(cmdQuery){
        	<%--formList.action="<%=contextPath%>/channel/employee_exporttxt.do";
        	formList.submit();--%>
        	var url='<%=contextPath%>/channel/employee/select.jsp';
    		var rtn=window.showModalDialog(url , 1 , "dialogWidth=300px;dialogHeight=550px;status:no;scroll=yes;");
    		if(rtn=="")
    		{
    		 alert('至少选择一列');
    		 return false;
    		}
    		if(rtn == null) {
        		return false;
    		}
		
			formList.action = contextPath + cmdQuery + "?selectedFields="+rtn;
			formList.submit();
        }
        function cancelService(employeeID,mobile,button){
			var url=contextPath + "/channel/employee_cancelservice.do?employeeID="+employeeID+"&mobile="+mobile;
			formList.action=url;
			button.disabled=true;
			formList.submit();
		}
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="employee_societylist.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="button_Help" onclick="openword('<s:text name="titleList"/>','<s:text name="helpList"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
                <td align="center"><s:text name="employeeid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_employeeid" />
                </td>
                <td align="center"><s:text name="employeename"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_employeename" />
                </td>
            </tr>
            <tr>
            	<td align="center"><s:text name="intime"/>&gt;=:</td>
                <td align="left">
                	<s:textfield cssStyle="style_input" name="param._dnl_intime" onclick="selectDate();"/>
                </td>
                <td align="center"><s:text name="intime"/>&lt;=:</td>
                <td align="left">
                	<s:textfield cssStyle="style_input" name="param._dnm_intime" onclick="selectDate();"/>
                </td>
            </tr>
            <tr>
            	<td align="center"><s:text name="wayid3"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_wayid" /><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_wayid','','','AG');this.value='...';" />
                </td>
                <td align="center"><s:text name="svccode"/>:</td>
                <td align="left">
                     <j:selector definition="#SERVCENT" name="param._se_svccode"/>
                </td>
            </tr>
            <tr>
            	<td align="center">公务机号码:</td>
            	<!-- <s:text name="officetel2"/> -->
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_officetel" maxlength="11"/>
                </td>
                <td align="center"><s:text name="isnet"/>:</td>
                <td align="left">
                    <j:selector definition="$CH_ISNET" name="param._ne_isnet" condition="_sne_dictid:${'2'}" />
                </td>
            </tr>
            <tr>
            <!-- 
                <td align="center"><s:text name="isopen"/>:</td>
                <td align="left">
                    <j:selector definition="$CH_ISOPEN" name="param._ne_isopen" />
                </td>
                 -->
                <td align="center"><s:text name="empstatus"/>:</td>
                <td align="left">
                    <j:selector definition="$CH_EMPSTATUS" name="param._ne_empstatus" />
                </td>
                 <td align="center"><s:text name="selectmobile"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_selectmobile" maxlength="11"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/channel/employee_societylist.do');">
                        
                	<j:purChk permid="<%=ID_10%>" disableChild="true">
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/channel/employee_new.do')">
                        
                    <input type="button" id="btnBatch" name="btnBatch"
										class="button_New" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="导入" onClick="doBatch();">

					<input type="button" id="btnExporttxt" name="btnExporttxt"
										class="button_4" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_exporttxt"/>" onClick="doTxt('/channel/employee_exporttxt.do');">
                    
                      <input type="button" id="btnExport" name="btnExport" class="button_4" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="<s:text name="button_exportexcel"/>" onClick="doTxt('/channel/employee_exportExcel.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/channel/employee_delete.do')">
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
                    <j:orderByImg href="javascript:doOrderby('employeeid')"><s:text name="employeeid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('employeename')"><s:text name="employeename"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('birthday')"><s:text name="birthday"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('sex')"><s:text name="sex"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('empstatus')"><s:text name="empstatus"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('cardid')"><s:text name="cardid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('telephone')"><s:text name="telephone"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('cityid')"><s:text name="cityid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('countyid')"><s:text name="countyid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('svccode')"><s:text name="svccode"/></j:orderByImg>                 
                </td>
                 <td>渠道名称</td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
               
                <td>
                    <j:orderByImg href="javascript:doOrderby('intime')"><s:text name="intime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('employtype')"><s:text name="employtype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('bail')"><s:text name="bail"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('officetel')"><s:text name="officetel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('isnet')"><s:text name="isnet"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('netpass')"><s:text name="netpass"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('selectmobile')"><s:text name="selectmobile"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="employeeid"/>" onclick="checkOne();">
                     </td>
                     <td>
                     <j:purChk permid="<%=ID_10%>" disableChild="true">
                     	 <a href='<s:url action="employee_edit.do">
	                         <s:param name="param._pk" value="employeeid"/>
	                     	</s:url>'>
							<s:property value="employeeid"/>
                         </a>
                     </j:purChk>
					 </td>
                     <td><s:property value="employeename" /></td>
                     <td><s:date name="birthday" format="yyyy-MM-dd"/></td>
                     <td><j:code2Name definition="$CH_SEX" code="sex"/></td>
                     <td><j:code2Name definition="$CH_EMPSTATUS" code="empstatus"/></td>
                     <td><s:property value="cardid" /></td>
                     <td><s:property value="telephone" /></td>
                     <td><j:code2Name definition="#CITYCOMPANY" code="cityid"/></td>
                     <td><j:code2Name definition="#CNTYCOMPANY" code="countyid"/></td>
                     <td><j:code2Name definition="#SERVCENT" code="svccode"/></td>
                     <td><j:code2Name definition="#WAY" code="wayid"/></td>
                     <td><s:property value="wayid"/></td>
                     <td><s:date name="intime" format="yyyy-MM-dd"/></td>
                     <td><j:code2Name definition="$CH_EMPLOYTYPE" code="employtype"/></td>
                     <td>
                      <s:i18n name="public">
						<s:property value="bail!=null?getText('format.double',{bail}):''"/>
                      </s:i18n>
                     </td>
                     <td><s:property value="officetel" /></td>
                     <td><j:code2Name definition="$CH_ISNET" code="isnet"/></td>
                     <td><s:property value="netpass" /></td>
                     <td><s:property value="selectmobile" /></td>
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
