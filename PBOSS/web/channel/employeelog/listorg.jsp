<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="employeelog_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<s:hidden name="employeeType" />
			<span class="table_toparea_h">
			<s:if  test="employeeType=='MG'">
				<s:text name="titleList"/>
			</s:if>
			<s:else>
				<s:text name="titleAG"/>
			</s:else>
			</span>
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
                <td align="center"><s:text name="logid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_logid" />
                </td>
                <td align="center"><s:text name="oprcode"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_oprcode" />
                </td>
             </tr>
             <tr>
                <td align="center"><s:text name="optime"/>>=</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_optime" onclick="selectDatetime()" readonly="true"/>
                </td>
                <td align="center"><s:text name="optime"/><=</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_optime" onclick="selectDatetime()" readonly="true"/>
                </td>
			  </tr>
			  <tr>                
                <td align="center"><s:text name="oprtype"/>:</td>
                <td align="left">
                    <j:selector   name="param._se_oprtype" definition="$OPRTYPE" />
                </td>
                <td align="center"><s:text name="success"/>:</td>
                <td align="left">
                    <j:selector   name="param._se_success" definition="$OPRRESULT" />
                </td>
            </tr>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
                	<s:i18n name="public">
                	<s:if  test="employeeType=='MG'">
                		 <input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_search"/>" onClick="doQuery('/channel/employeelog_listmg.do');">
                	</s:if>
                	<s:else >
                		 <input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_search"/>" onClick="doQuery('/channel/employeelog_list.do');">
                	</s:else>
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
                    <j:orderByImg href="javascript:doOrderby('oprcode2')"><s:text name="oprcode2"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('oprtype')"><s:text name="oprtype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('success')"><s:text name="success"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('employeeid')"><s:text name="employeeid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('oprcode')"><s:text name="oprcode"/></j:orderByImg>                 
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
                    <j:orderByImg href="javascript:doOrderby('edulevel')"><s:text name="edulevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('nativehome')"><s:text name="nativehome"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('polivisage')"><s:text name="polivisage"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('department')"><s:text name="department"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('servoffice')"><s:text name="servoffice"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('station')"><s:text name="station"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('joblevel')"><s:text name="joblevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('intime')"><s:text name="intime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('worktime')"><s:text name="worktime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('hereworktime')"><s:text name="hereworktime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('employtype')"><s:text name="employtype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('company')"><s:text name="company"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('telephone')"><s:text name="telephone"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('officetel')"><s:text name="officetel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('outtime')"><s:text name="outtime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('outresult')"><s:text name="outresult"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('homeaddr')"><s:text name="homeaddr"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('cardid')"><s:text name="cardid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('waytype')"><s:text name="waytype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('pvtemail')"><s:text name="pvtemail"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('ofcphone')"><s:text name="ofcphone"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('ofcemail')"><s:text name="ofcemail"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('speciality')"><s:text name="speciality"/></j:orderByImg>                 
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
                <td>
                    <j:orderByImg href="javascript:doOrderby('posittype')"><s:text name="posittype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('contacttype')"><s:text name="contacttype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('empstatus')"><s:text name="empstatus"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('actbank')"><s:text name="actbank"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('actno')"><s:text name="actno"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('actname')"><s:text name="actname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('actpid')"><s:text name="actpid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('bail')"><s:text name="bail"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('gradschool')"><s:text name="gradschool"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('gradtime')"><s:text name="gradtime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('ismarried')"><s:text name="ismarried"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('outreason')"><s:text name="outreason"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('trainlevel')"><s:text name="trainlevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('hobby')"><s:text name="hobby"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('character')"><s:text name="character"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('asses')"><s:text name="asses"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('workhistry')"><s:text name="workhistry"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('prizeorpunish')"><s:text name="prizeorpunish"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('empass')"><s:text name="empass"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('right')"><s:text name="right"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('isnet')"><s:text name="isnet"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('netpass')"><s:text name="netpass"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('isopen')"><s:text name="isopen"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('selectmobile')"><s:text name="selectmobile"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                    <td> 
							<s:property value="logid"/>
					 </td>
                     <td>
                     <s:date name="optime" format="yyyy-MM-dd HH:mm:ss"/>
                     </td>
                     <td><s:property value="oprcode2" /></td>
                     <td>
                     <j:code2Name code="oprtype" definition="$OPRTYPE"/>
                     </td>
                     <td>
                     <j:code2Name code="success" definition="$OPRRESULT"/> 
                     </td>
                     <td><s:property value="employeeid" /></td>
                     <td><s:property value="oprcode" /></td>
                     <td><s:property value="employeename" /></td>
                     <td>
                     <s:date name="birthday" format="yyyy-MM-dd"/>
                     </td>
                     <td><s:property value="sex" /></td>
                     <td><s:property value="edulevel" /></td>
                     <td><s:property value="nativehome" /></td>
                     <td><s:property value="polivisage" /></td>
                     <td><s:property value="department" /></td>
                     <td><s:property value="servoffice" /></td>
                     <td><s:property value="station" /></td>
                     <td><s:property value="joblevel" /></td>
                     <td>
                     <s:date name="intime" format="yyyy-MM-dd"/>
                     </td>
                     <td>
                     <s:property value="worktime" />
                     </td>
                     <td><s:property value="hereworktime" /></td>
                     <td><s:property value="employtype" /></td>
                     <td><s:property value="company" /></td>
                     <td><s:property value="telephone" /></td>
                     <td><s:property value="officetel" /></td>
                     <td><s:property value="outtime" /></td>
                     <td><s:property value="outresult" /></td>
                     <td><s:property value="homeaddr" /></td>
                     <td><s:property value="cardid" /></td>
                     <td><s:property value="wayid" /></td>
                     <td><s:property value="waytype" /></td>
                     <td><s:property value="pvtemail" /></td>
                     <td><s:property value="ofcphone" /></td>
                     <td><s:property value="ofcemail" /></td>
                     <td><s:property value="speciality" /></td>
                     <td><s:property value="cityid" /></td>
                     <td><s:property value="countyid" /></td>
                     <td><s:property value="svccode" /></td>
                     <td><s:property value="posittype" /></td>
                     <td><s:property value="contacttype" /></td>
                     <td><s:property value="empstatus" /></td>
                     <td><s:property value="actbank" /></td>
                     <td><s:property value="actno" /></td>
                     <td><s:property value="actname" /></td>
                     <td><s:property value="actpid" /></td>
                     <td><s:property value="bail" /></td>
                     <td><s:property value="gradschool" /></td>
                     <td><s:property value="gradtime" />
                     <s:date name="gradtime" format="yyyy-MM-dd"/>
                     </td>
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
