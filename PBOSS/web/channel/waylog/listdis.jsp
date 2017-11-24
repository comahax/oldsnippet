<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%@ taglib prefix="j" uri="/jop-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, '18');
            addfield('param._ne_waystate', '<s:text name="waystate"/>', 'f', true, '3');
            return checkval(window);
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="waylog_listdis.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//����Ŀؼ���Action�ṩ���ݣ�������ҳ%>
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
			<span class="table_toparea_h">
				<s:if test="wayType=='AG'">
					<s:text name="titleAG"/>
                </s:if>
                <s:elseif test="wayType=='DIS'">
                	<s:text name="titleDIS" />
                </s:elseif>
                <s:else>
                	<s:text name="title" />
                </s:else>
			
			</span>
			<span class="button_Help" onclick="openword('<s:text name="titleDIS"/>','<s:text name="contentDIS"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
                    <j:selector   name="param._se_success" definition="SUCCESS" />
                </td>
            </tr>
            <tr>                
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                   <s:textfield cssStyle="style_input" name="param._se_wayid" /><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_wayid');this.value='...';" />
                </td>
                <td align="center"><s:text name="wayname"/>:</td>
                <td align="left">
                   <s:textfield cssStyle="style_input" name="param._sk_wayname"  />
                </td>
            </tr>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
                	<s:i18n name="public">
                	<s:if test="wayType=='AG'">
                		<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_search"/>" onClick="doQuery('/channel/waylog_listag.do');">
                	</s:if>
                	<s:elseif test="wayType=='DIS'">
                		<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
                		onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_search"/>" onClick="doQuery('/channel/waylog_listdis.do');">
                	</s:elseif>
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
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid2"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayname')"><s:text name="wayname2"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('upperwayid')"><s:text name="upperwayid"/></j:orderByImg>                 
                </td>
                 <td>
                    <j:orderByImg href="javascript:doOrderby('cityid')"><s:text name="cityid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('countyid')"><s:text name="cityid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('svccode')"><s:text name="svccode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('mareacode')"><s:text name="mareacode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('mainlayer')"><s:text name="mainlayer2"/></j:orderByImg>                 
                </td>
                 <td>
                    <j:orderByImg href="javascript:doOrderby('chainhead')"><s:text name="chainhead2"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('latitude')"><s:text name="latitude"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('longtitude')"><s:text name="longtitude"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('waystate')"><s:text name="waystate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('signstatus')"><s:text name="signstatus"/></j:orderByImg>                 
                </td>
                 <td>
                    <j:orderByImg href="javascript:doOrderby('taxtype')"><s:text name="taxtype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('address')"><s:text name="address"/></j:orderByImg>                 
                </td>
                
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- ���������á�|������� --%>
                     <td> 
							<s:property value="logid"/>
					 </td>
                     <td>
                     <s:date name="optime" format="yyyy-MM-dd HH:mm:ss"/>
                     </td>
                     <td><s:property value="oprcode" /></td>
                     <td>
                     <j:code2Name code="oprtype" definition="$OPRTYPE"/>
                     </td>
                     <td>
                     <j:code2Name code="success" definition="SUCCESS"/> 
                     </td>
                     <td>
                     <s:property value="wayid" /> 
                     </td>
                     <td>
                     	<s:property value="wayname" /> 
                     </td>
                     <td><s:property value="upperwayid" /> </td>
                     <td><j:code2Name code="cityid" definition="#CITYCOMPANY" /></td>
                     <td><j:code2Name code="countyid" definition="#CNTYCOMPANY" /></td>
                     <td><j:code2Name code="svccode" definition="#SERVCENT" /></td>
                     <td><j:code2Name code="mareacode" definition="#MICROAREA" /></td>
                     <td>
                     <j:code2Name code="mainlayer" definition="$CH_COPLAYER"/>
                     </td>
                     <td><s:property value="chainhead" /></td>
                     <td><s:property value="latitude" /></td>
                     <td><s:property value="longtitude" /></td>
                     <td><j:code2Name code="waystate" definition="$CH_VALIDFLAG" /></td>
                     <td>
                     <j:code2Name definition="$CH_SIGNSTATUS" code="signstatus"/> 
					 </td>
                     <td>
                     <j:code2Name definition="$CH_STTAXTYPE" code="taxtype"/>	
					 </td>
                     <td><s:property value="address" /></td>
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
