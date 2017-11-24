<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		addfield('param._se_oprcode', '<s:text name="oprcode"/>', 'c', true, '32');
		//addfield('param._dnm_logintime', '<s:text name="logintime"/>', 't', true, '7');
		//addfield('param._dnl_logintime', '<s:text name="logintime"/>', 't', true, '7');
		addfield('param._se_ipaddress', '<s:text name="ipaddress"/>', 'c', true, '32');
		return checkval(window);
	}
	
        function doTxt(){
        	formList.action="<%=contextPath%>/base/dbloginlog_txt.do";
        	formList.submit();
        	//formList.action="<%=contextPath%>/base/role_list.do";
        }
        
        
        function doExcel(){
        	formList.action="<%=contextPath%>/base/dbloginlog_excel.do";
        	formList.submit();
        	//formList.action="<%=contextPath%>/base/role_list.do";
        }
</script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="dbloginlog_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
	<aa:zone name="hiddenZone">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
	</aa:zone>
    
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
                <td align="center"><s:text name="oprcode"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_oprcode" />
                </td>
                <td align="center"><s:text name="ipaddress"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_ipaddress" />
                </td>
            </tr>
             <tr>               
                <td align="center"><s:text name="_dnl_logintime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_logintime"  onclick="selectDatetime();" readonly="true"/>
                </td>
                 <td align="center"><s:text name="_dnm_logintime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_logintime"  onclick="selectDatetime();" readonly="true"/>
                </td>
            </tr>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
                	<s:i18n name="public">
	                	<j:purChk permid="CH_PW_SYSTEM_LOGINLOG"> 
		                   	<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
		                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                        value="<s:text name="button_search"/>" onClick="doQuery('/base/dbloginlog_list.do');">
		                    <input type="button" id="btnExporttxt" name="btnExporttxt" class="button_4" onmouseover="buttonover(this);" 
		                    	onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                    	value="<s:text name="button_exporttxt"/>" onClick="doTxt();">
		                    <input type="button" id="btnExportexcel" name="btnExportexcel" class="button_4" onmouseover="buttonover(this);" 
		                    	onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                    	value="<s:text name="button_exportexcel"/>" onClick="doExcel();">
	               	    
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
                
                </s:i18n>
                <td>
                    <j:orderByImg href="javascript:doOrderby('logid')"><s:text name="logid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('oprcode')"><s:text name="oprcode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('cityid')"><s:text name="cityid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('logintime')"><s:text name="logintime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('ipaddress')"><s:text name="ipaddress"/></j:orderByImg>                 
                </td>
               
                <td>
                    <j:orderByImg href="javascript:doOrderby('issuccess')"><s:text name="issuccess"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('memo')"><s:text name="memo"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                    
                     <td>
							<s:property value="logid"/>
                        
					 </td>
                     <td><s:property value="oprcode" /></td>
                     <td><j:code2Name definition="#WAY" code="wayid" /></td>
                     <td><j:code2Name definition="#CITYCOMPANY" code="cityid" /></td>
                     <td><s:property value="logintime" /></td>
                     <td><s:property value="ipaddress" /></td>
                     <td><j:code2Name definition="DBLOGINLOG" code="issuccess" /></td>
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
</body>
</html>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();  
	ajaxAnywhere.formURL = formList.action;
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
