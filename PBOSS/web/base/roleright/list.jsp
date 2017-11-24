<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<% String ID_ADD = "CH_PW_SYSTEMROLE"; %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_itemid', '<s:text name="itemid"/>', 'c', true, '32');
            addfield('param._se_rightid', '<s:text name="rightid"/>', 'c', true, '32');
            return checkval(window);
        }
        function doTxt(){
        	formList.action="<%=contextPath%>/base/roleright_txt.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/base/roleright_list.do";
        }
        function doExcel(){
        	formList.action="<%=contextPath%>/base/roleright_excel.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/base/roleright_list.do";
        }
        function doBatchSave(){
			formList.action = '<%=contextPath%>/base/roleright_batchlist.do';
			formList.submit();
        }
        function doRoleSelect(){
        	var url="<%=contextPath%>/base/role_rolequerys.do";
        	var rtn=window.showModalDialog(url , self , "dialogWidth:800px; dialogHeight:500px; status:no; resizable:no;");
        	if (rtn != null && rtn.length) {
        		document.all('param._se_itemid').value = rtn;
        		return rtn;
        	}
		}
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="roleright_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//????????????Action?��????????????��???%>
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
                <td align="center"><s:text name="itemid"/>:</td>
                <td align="left">
					<s:textfield class="style_input" name="param._se_itemid" /><input type="button" class="picker_button" value="..." onClick="doRoleSelect();"/>
				</td>
                <td align="center"><s:text name="rightid"/>:</td>
                <td align="left">
                    <j:selector definition="#RIGHTITEM" name="param._se_rightid" />
                </td>
            </tr>
            <tr>
            	<td align="center"><s:text name="statusdate"/>&gt;=:</td>
            	<td align="left">
            		<s:textfield cssStyle="style_input" name="param._dnl_statusdate" onclick="selectDate();"/>
            	</td>
            	<td align="center"><s:text name="statusdate"/>&lt;=:</td>
            	<td align="left">
            		<s:textfield cssStyle="style_input" name="param._dnm_statusdate" onclick="selectDate();"/>
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
	                    <td align="right">
	                    	<s:i18n name="public">
	                    	<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="<s:text name="button_search"/>" onClick="doQuery('/base/roleright_list.do');">
	                        
	                        <j:purChk permid="<%=ID_ADD%>">    
	                        <input type="button" id="btnExporttxt" name="btnExporttxt" class="button_4" onmouseover="buttonover(this);"
                        		onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        		value="<s:text name="button_exporttxt"/>" onClick="doTxt();">
                        		
                        	<input type="button" id="btnExportexcel" name="btnExportexcel" class="button_4" onmouseover="buttonover(this);"
                        		onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        		value="<s:text name="button_exportexcel"/>" onClick="doExcel()">
	                    	
	                        <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="<s:text name="button_new"/>" onClick="doNew('/base/roleright_new.do')">
	                            
	                        <input type="button" id="btnNew" name="btnNew" class="button_4" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="������Ȩ" onClick="doBatchSave()">
	                        
	                        <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="<s:text name="button_delete"/>" onClick="doDelete('/base/roleright_delete.do')">
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
                    <j:orderByImg href="javascript:doOrderby('itemid')"><s:text name="itemid"/></j:orderByImg>                 
                </td>
                <td>��ɫ����</td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('rightid')"><s:text name="rightid"/></j:orderByImg>                 
                </td>
                <td>��������</td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('createdate')"><s:text name="createdate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('status')"><s:text name="status"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('statusdate')"><s:text name="statusdate"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- ?????��?��???��|?��?????? --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="itemid + '|' + rightid"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="roleright_edit.do">
	                         <s:param name="param._pk" value="itemid + '|' + rightid"/>
	                     	</s:url>'>
							<s:property value="itemid"/>
                         </a>
					 </td>
					 <td><j:code2Name definition="#ROLE" code="itemid" /></td>
                     <td><a href='<s:url action="roleright_edit.do">
	                         <s:param name="param._pk" value="itemid + '|' + rightid"/>
	                     	</s:url>'>
							<s:property value="rightid"/>
                         </a>
					 </td>
					 <td><j:code2Name definition="#RIGHTITEM" code="rightid" /></td>
                     <td><s:date name="createdate" format="yyyy-MM-dd"/></td>
                     <td><j:code2Name definition="$CH_OPRSTATUS" code="status" /></td>
                     <td><s:date name="statusdate" format="yyyy-MM-dd"/></td>
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
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
</div>
</body>
</html>
