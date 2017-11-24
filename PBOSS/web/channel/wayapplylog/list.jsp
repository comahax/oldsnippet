<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="wayapplylog_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea"><s:text name="base"/> </span>
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
                <td align="center"><s:text name="logid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_logid" />
                </td>
                <td align="center"><s:text name="oprcode"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_opncode" />
                </td>
             </tr>
             <tr>
                <td align="center"><s:text name="opntime"/>>=</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_opntime" onclick="selectDatetime()" readonly="true"/>
                </td>
                <td align="center"><s:text name="opntime"/><=</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_opntime" onclick="selectDatetime()" readonly="true"/>
                </td>
			  </tr>
			  <tr>                
                <td align="center"><s:text name="oprtype"/>:</td>
                <td align="left">
                    <j:selector   name="param._se_oprtype" definition="$OPRTYPE" />
                </td>
                <td align="center"></td>
                <td align="left">
                </td>
            </tr>
            <tr>                
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_wayid" onclick="pshowSelectWay3(this,'param._se_wayid');" />
                </td>
                <td align="center"><s:text name="wayname"/>:</td>
                <td align="left">
                	<s:textfield cssStyle="style_input" name="param._sk_wayname" />
                </td>
            </tr>
            <tr>                
                <td align="center"><s:text name="auditstatus"/>:</td>
                <td align="left">
                	<j:selector   name="param._ne_auditstatus" definition="$CH_AUDITSTATUS" />
                </td>
                <td align="center"><s:text name="applyno"/>:</td>
                <td align="left">
                	<s:textfield cssStyle="style_input" name="param._se_applyno" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/channel/wayapplylog_list.do');">
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
                    <j:orderByImg href="javascript:doOrderby('opntime')"><s:text name="opntime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('opncode')"><s:text name="opncode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('oprtype')"><s:text name="oprtype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('applyno')"><s:text name="applyno"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('optime')"><s:text name="optime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('auditstatus')"><s:text name="auditstatus"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('description')"><s:text name="description"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayname')"><s:text name="wayname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('waysubtype')"><s:text name="waysubtype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('upperwayid')"><s:text name="upperwayid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('starlevel')"><s:text name="starlevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('pt')"><s:text name="pt"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('waystate')"><s:text name="waystate"/></j:orderByImg>                 
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
                    <j:orderByImg href="javascript:doOrderby('mareacode')"><s:text name="mareacode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('isstraitprd')"><s:text name="isstraitprd"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('adtypecode')"><s:text name="adtypecode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('adacode')"><s:text name="adacode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('formtype')"><s:text name="formtype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('starttime')"><s:text name="starttime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('buzarea')"><s:text name="buzarea"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('logiscode')"><s:text name="logiscode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('waymagcode')"><s:text name="waymagcode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('bchlevel')"><s:text name="bchlevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('officetel')"><s:text name="officetel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('alarmbizamount')"><s:text name="alarmbizamount"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('address')"><s:text name="address"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('latitude')"><s:text name="latitude"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('longtitude')"><s:text name="longtitude"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('principal')"><s:text name="principal"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('principaltel')"><s:text name="principaltel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('principalphone')"><s:text name="principalphone"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('principalemail')"><s:text name="principalemail"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('sendaddr')"><s:text name="sendaddr"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('acctno')"><s:text name="acctno"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('acctname')"><s:text name="acctname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('bankname')"><s:text name="bankname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('acctfid')"><s:text name="acctfid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('deacctno')"><s:text name="deacctno"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('deacctname')"><s:text name="deacctname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('debankname')"><s:text name="debankname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('accttype')"><s:text name="accttype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('intime')"><s:text name="intime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('catetype')"><s:text name="catetype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('chainhead')"><s:text name="chainhead"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('recpers')"><s:text name="recpers"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('recconntel')"><s:text name="recconntel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('reccertno')"><s:text name="reccertno"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('signstatus')"><s:text name="signstatus"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('provcode')"><s:text name="provcode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('bailtype')"><s:text name="bailtype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('servbound')"><s:text name="servbound"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('compactno')"><s:text name="compactno"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('compactname')"><s:text name="compactname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('begintime')"><s:text name="begintime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('endtime')"><s:text name="endtime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('signtime')"><s:text name="signtime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('compacttype')"><s:text name="compacttype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('licenceno')"><s:text name="licenceno"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('bail')"><s:text name="bail"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('baillwrlmt')"><s:text name="baillwrlmt"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('licvalidate')"><s:text name="licvalidate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('bailstatus')"><s:text name="bailstatus"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('isb2m')"><s:text name="isb2m"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('smsmobileno')"><s:text name="smsmobileno"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td><s:property value="logid"/></td>
                     <td><s:date name="opntime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><s:property value="opncode" /></td>
                     <td>
                     <j:code2Name code="oprtype" definition="$OPRTYPE"/>
                     </td>
                     <td><s:property value="applyno" /></td>
                     <td><s:date name="optime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td>
                     <j:code2Name code="auditstatus" definition="$CH_AUDITSTATUS"/>
                     </td>
                     <td><s:property value="description" /></td>
                     <td><s:property value="wayid" /></td>
                     <td><s:property value="wayname" /></td>
                     <td>
                     <j:code2Name code="waysubtype" definition="WAYSUBTYPE"/>
                     </td>
                     <td><s:property value="upperwayid" /></td>
                     <td>
                     <j:code2Name code="starlevel" definition="$CH_STARLEVEL"/>
                     </td>
                     <td>
                     <j:code2Name code="pt" definition="$CH_PT"/>
                     </td>
                     <td>
                     <j:code2Name code="waystate" definition="$CH_VALIDFLAG"/>
                     </td>
                     <td><j:code2Name code="cityid" definition="#CITYCOMPANY" /></td>
                     <td><j:code2Name code="countyid" definition="#CNTYCOMPANY" /></td>
                     <td><j:code2Name code="svccode" definition="#SERVCENT" /></td>
                     <td><j:code2Name code="mareacode" definition="#MICROAREA" /></td>
                     <td><j:code2Name code="isstraitprd" definition="$CH_STRAITPRD" /></td>
                     <td><j:code2Name code="adtypecode" definition="$CH_ADTYPE" /></td>
                     <td><j:code2Name code="adacode" definition="#ADIMAREA" /></td>
                     <td><j:code2Name code="formtype" definition="$CH_FORMTYPE" /></td>
                     <td><s:date name="starttime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><s:property value="buzarea" /></td>
                     <td><s:property value="logiscode" /></td>
                     <td><s:property value="waymagcode" /></td>
                     <td>
                     <j:code2Name code="bchlevel" definition="$CH_BCHLEVEL" />
                     </td>
                     <td><s:property value="officetel" /></td>
                     <td><s:property value="alarmbizamount" /></td>
                     <td><s:property value="address" /></td>
                     <td><s:property value="latitude" /></td>
                     <td><s:property value="longtitude" /></td>
                     <td><s:property value="principal" /></td>
                     <td><s:property value="principaltel" /></td>
                     <td><s:property value="principalphone" /></td>
                     <td><s:property value="principalemail" /></td>
                     <td><s:property value="sendaddr" /></td>
                     <td><s:property value="acctno" /></td>
                     <td><s:property value="acctname" /></td>
                     <td><s:property value="bankname" /></td>
                     <td><s:property value="acctfid" /></td>
                     <td><s:property value="deacctno" /></td>
                     <td><s:property value="deacctname" /></td>
                     <td><s:property value="debankname" /></td>
                     <td>
                     <j:code2Name code="accttype" definition="$CH_ACCOUNTTYPE" />
                     </td>
                     <td><s:date name="intime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td>
                     <j:code2Name code="catetype" definition="$CH_CATETYPE" />
                     </td>
                     <td><s:property value="chainhead" /></td>
                     <td><s:property value="recpers" /></td>
                     <td><s:property value="recconntel" /></td>
                     <td><s:property value="reccertno" /></td>
                     <td>
                     <j:code2Name code="signstatus" definition="$CH_SIGNSTATUS" />
                     </td>
                     <td><s:property value="provcode" /></td>
                     <td>
                     <j:code2Name code="bailtype" definition="$CH_SIGNSTATUS" />
                     </td>
                     <td>
                     <j:code2Name code="servbound" definition="$CH_SERVBOUND" />
                     </td>
                     <td><s:property value="compactno" /></td>
                     <td><s:property value="compactname" /></td>
                     <td><s:date name="begintime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><s:date name="endtime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><s:date name="signtime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td>
                     <j:code2Name code="compacttype" definition="$CH_COMPACTTYPE" />
                     </td>
                     <td><s:property value="licenceno" /></td>
                     <td><s:property value="bail" /></td>
                     <td><s:property value="baillwrlmt" /></td>
                     <td><s:date name="licvalidate" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td>
                     <j:code2Name code="bailstatus" definition="$CH_BAILSTATUS"/>
                     </td>
                     <td><j:code2Name code="isb2m" definition="$IM_YESNO10"/> </td>
                     <td><s:property value="smsmobileno" /></td>
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
</body>
</html>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction(); ajaxAnywhere.formURL = formList.action;   
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
<script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		return checkval(window);
	}
</script>
