<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
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
            addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, '18');
            addfield('param._dnl_intime', '入职时间>=', 't', true, '7');
            addfield('param._dnm_intime', '入职时间<=', 't', true, '7');
            return checkval(window);
        }
        function doTxt(cmdQuery){
        	<%--formList.action="<%=contextPath%>/channel/employee_exporttxt.do";
        	formList.submit();--%>
        	var url='<%=contextPath%>/channel/employee/selectopr.jsp';
    		var rtn=window.showModalDialog(url , 1 , "dialogWidth=800px;dialogHeight=500px;status:no;scroll=yes;");
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
        function doManagerStationExport(exportID){
        document.getElementById(exportID).click();
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="employee_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//????????????Action?á????????????·???%>
	
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <s:hidden name="processType" value="MANAGER"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h">渠道经理管理</span>
			<span class="button_Help" onclick="openword('渠道经理管理','<s:text name="helpList"/><s:text name="stationDesc" />')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
                 <td align="center"><s:text name="oprcode"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_oprcode2" />
                </td>
              </tr>
              <tr>
                <td align="center"><s:text name="employeename"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._sk_employeename" />
                </td>
                <td align="center"><s:text name="svccode"/>:</td>
                <td align="left">
                    <j:selector definition="#SERVCENT" name="param._se_svccode"/>
                </td>
              </tr>
              <tr> 
                <td align="center"><s:text name="wayid2"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_wayid" /><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_wayid',null,null,'ET');this.value='...';" />
                </td>
                
                <td align="center"><s:text name="station"/>:</td>
                <td align="left">
                    <j:selector definition="POSTINFO" name="param._ne_station" mode="selector"/>
                </td>
              </tr>
              <tr>  
                <td align="center">入职时间>=:</td>
                <td align="left">
                	<s:textfield cssStyle="style_input" name="param._dnl_intime" onclick="selectDate();"/>
                </td>
                 <td align="center">入职时间<=:</td>
                <td align="left">
                	<s:textfield cssStyle="style_input" name="param._dnm_intime" onclick="selectDate();"/>
                </td>
            </tr>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr> 
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
	                    <td align=right>
	                    	<s:i18n name="public">
	                    	<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="<s:text name="button_search"/>" onClick="doQuery('/channel/employee_list.do');">
	                    	
	                    	<j:purChk permid="<%=ID_10%>" disableChild="true">
	                        <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="<s:text name="button_new"/>" onClick="doNew('/channel/employee_new.do')">
	                        
	                        <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="<s:text name="button_delete"/>" onClick="doDelete('/channel/employee_delete.do')">	                       
	                       <!--  <input type="button" id="btnExport" name="btnExport" class="button_4" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="批量导出" onClick="doNew('/channel/employee_mgrExcel.do')">-->
	                       <input type="button" id="btnExport" name="btnExport" class="button_4" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="批量导出" onClick="doTxt('/channel/employee_mgrExcel.do')">
	                        <input type="button" id="btnImport" name="btnImport" class="button_4" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="导入" onClick="window.location.href='/channel/employee/import.jsp'">
	                        </j:purChk>
	                        </s:i18n>
	                    </td>
	                    </tr>
					</table>
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
                     <j:orderByImg href="javascript:doOrderby('oprcode2')"><s:text name="oprcode3"/></j:orderByImg>                 
                </td>
                <td>
                     <j:orderByImg href="javascript:doOrderby('employeename')"><s:text name="employeename"/></j:orderByImg>                 
                </td>
                <td>
                     <j:orderByImg href="javascript:doOrderby('sex')"><s:text name="sex"/></j:orderByImg>                 
                </td>
                <!-- 
                <td>
                    <a href="javascript:doOrderby('edulevel')"><s:text name="edulevel"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('nativehome')"><s:text name="nativehome"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('polivisage')"><s:text name="polivisage"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('department')"><s:text name="department"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('servoffice')"><s:text name="servoffice"/></a>                 
                </td>
                
                <td>
                    <a href="javascript:doOrderby('joblevel')"><s:text name="joblevel"/></a>                 
                </td>
                
                <td>
                    <a href="javascript:doOrderby('worktime')"><s:text name="worktime"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('hereworktime')"><s:text name="hereworktime"/></a>                 
                </td>
                
                <td>
                    <a href="javascript:doOrderby('company')"><s:text name="company"/></a>                 
                </td>
                 -->
                <td>
                     <j:orderByImg href="javascript:doOrderby('telephone')"><s:text name="telephone"/></j:orderByImg>                 
                </td>
                <!-- 
                <td>
                    <a href="javascript:doOrderby('officetel')"><s:text name="officetel"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('outtime')"><s:text name="outtime"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('outresult')"><s:text name="outresult"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('homeaddr')"><s:text name="homeaddr"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('cardid')"><s:text name="cardid"/></a>                 
                </td>
                
                <td>
                    <a href="javascript:doOrderby('waytype')"><s:text name="waytype"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('pvtemail')"><s:text name="pvtemail"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('ofcphone')"><s:text name="ofcphone"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('ofcemail')"><s:text name="ofcemail"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('speciality')"><s:text name="speciality"/></a>                 
                </td>
                 -->
                <td>
                     <j:orderByImg href="javascript:doOrderby('cityid')"><s:text name="cityid"/></j:orderByImg>                 
                </td>
                <td>
                     <j:orderByImg href="javascript:doOrderby('countyid')"><s:text name="countyid"/></j:orderByImg>                 
                </td>
                <td>
                     <j:orderByImg href="javascript:doOrderby('svccode')"><s:text name="svccode"/></j:orderByImg>                 
                </td>
                <td>
                     <j:orderByImg href="javascript:doOrderby('mareacode')"><s:text name="mareacode"/></j:orderByImg>                 
                </td>
                <td>
                     <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid2"/></j:orderByImg>                 
                </td>
                <td>
                     <j:orderByImg href="javascript:doOrderby('station')"><s:text name="station"/></j:orderByImg>                 
                </td>
                <td>
                     <j:orderByImg href="javascript:doOrderby('intime')"><s:text name="intime"/></j:orderByImg>                 
                </td>
                <td>
                     <j:orderByImg href="javascript:doOrderby('employtype')"><s:text name="employtype"/></j:orderByImg>                 
                </td>
                <td>
                     <j:orderByImg href="javascript:doOrderby('empstatus')"><s:text name="empstatus"/></j:orderByImg>                 
                </td>
                <td>
                    管辖网点信息导出               
                </td>
                <!-- 
                <td>
                    <a href="javascript:doOrderby('posittype')"><s:text name="posittype"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('contacttype')"><s:text name="contacttype"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('empstatus')"><s:text name="empstatus"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('actbank')"><s:text name="actbank"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('actno')"><s:text name="actno"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('actname')"><s:text name="actname"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('actpid')"><s:text name="actpid"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('bail')"><s:text name="bail"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('gradschool')"><s:text name="gradschool"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('gradtime')"><s:text name="gradtime"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('ismarried')"><s:text name="ismarried"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('outreason')"><s:text name="outreason"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('trainlevel')"><s:text name="trainlevel"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('hobby')"><s:text name="hobby"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('character')"><s:text name="character"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('asses')"><s:text name="asses"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('workhistry')"><s:text name="workhistry"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('prizeorpunish')"><s:text name="prizeorpunish"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('empass')"><s:text name="empass"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('right')"><s:text name="right"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('isnet')"><s:text name="isnet"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('netpass')"><s:text name="netpass"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('isopen')"><s:text name="isopen"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('selectmobile')"><s:text name="selectmobile"/></a>                 
                </td>
                 -->
                 
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- ?????÷?ü???°|?±?????? --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="employeeid"/>" onclick="checkOne();">
                     </td>
                     <td>
                     <j:purChk permid="<%=ID_10%>" disableChild="true">
                     	 <a href='<s:url action="employee_edit.do">
	                         <s:param name="param._pk" value="employeeid"/>
	                     	</s:url>&processType=MANAGER'>	                     	
							<s:property value="employeeid"/>
                         </a>
                     </j:purChk>
					 </td>
                     <td><s:property value="oprcode2" /></td>
                     <td><s:property value="employeename" /></td>
                     <!-- 
                     <td><s:property value="birthday" /></td>
                      -->
                     <td><j:code2Name definition="$CH_SEX" code="sex"/></td>
                     <!-- 
                     <td><s:property value="edulevel" /></td>
                     <td><s:property value="nativehome" /></td>
                     <td><s:property value="polivisage" /></td>
                     <td><s:property value="department" /></td>
                     <td><s:property value="servoffice" /></td>
                     
                     <td><s:property value="joblevel" /></td>
                     
                     <td><s:property value="worktime" /></td>
                     <td><s:property value="hereworktime" /></td>
                     
                     <td><s:property value="company" /></td>
                      -->
                     <td><s:property value="telephone" /></td>
                     <!-- 
                     <td><s:property value="officetel" /></td>
                     <td><s:property value="outtime" /></td>
                     <td><s:property value="outresult" /></td>
                     <td><s:property value="homeaddr" /></td>
                     <td><s:property value="cardid" /></td>
                     
                     <td><s:property value="waytype" /></td>
                     <td><s:property value="pvtemail" /></td>
                     <td><s:property value="ofcphone" /></td>
                     <td><s:property value="ofcemail" /></td>
                     <td><s:property value="speciality" /></td>
                      -->
                     <td><j:code2Name definition="#CITYCOMPANY" code="cityid"/></td>
                     <td><j:code2Name definition="#CNTYCOMPANY" code="countyid"/></td>
                     <td><j:code2Name definition="#SERVCENT" code="svccode"/></td>
                     <td><j:code2Name definition="#MICROAREA" code="mareacode"/></td>
                     <td><s:property value="wayid" /> <j:code2Name definition="#WAYIDINFO" code="wayid"/></td>
                     <td><j:code2Name definition="POSTINFO" code="station"/></td>
                     <td><s:date name="intime" format="yyyy-MM-dd"/></td>
                     <td><j:code2Name definition="$CH_EMPLOYTYPE" code="employtype"/></td>
                     <td><j:code2Name definition="$CH_EMPSTATUS" code="empstatus"/></td>
                     <td>
                     <a id="export<s:property value="employeeid" />" href="<%=basePath%>channel/employee_mgrWayExcel.do?processType=MANAGER&param._se_employeeid=<s:property value="employeeid" />">
                     	
                     </a>
                     <input type="button" class="button_New" value="导出" onclick="doManagerStationExport('export<s:property value="employeeid" />')">
                     </td>
                     <!-- 
                     <td><s:property value="posittype" /></td>
                     <td><s:property value="contacttype" /></td>
                     <td><s:property value="empstatus" /></td>
                     <td><s:property value="actbank" /></td>
                     <td><s:property value="actno" /></td>
                     <td><s:property value="actname" /></td>
                     <td><s:property value="actpid" /></td>
                     <td><s:property value="bail" /></td>
                     <td><s:property value="gradschool" /></td>
                     <td><s:property value="gradtime" /></td>
                     <td><s:property value="ismarried" /></td>
                     <td><s:property value="outreason" /></td>
                     <td><s:property value="trainlevel" /></td>
                     <td><s:property value="hobby" /></td>
                     <td><s:property value="character" /></td>
                     <td><s:property value="asses" /></td>
                     <td><s:property value="workhistry" /></td>
                     <td><s:property value="prizeorpunish" /></td>
                     <td><s:property value="empass" /></td>
                     <td><s:property value="right" /></td>
                     <td><s:property value="isnet" /></td>
                     <td><s:property value="netpass" /></td>
                     <td><s:property value="isopen" /></td>
                     <td><s:property value="selectmobile" /></td>
                     <td>
                     </td>
                      -->
                 </tr>
             </s:iterator>
        </table>
    </div></div>
    <div class="table_div">
		<%@ include file="/common/pageNav.jsp"%>
   	</div>
    </aa:zone>
</s:form>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnDelete");
</script> 
</div>
</body>
</html>
