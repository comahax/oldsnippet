<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%@ taglib prefix="j" uri="/jop-tags" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_tablename', '<s:text name="tablename"/>', 'c', true, '32');
            addfield('param._se_tablechname', '<s:text name="tablechname"/>', 'c', true, '64');
            addfield('param._se_typename', '<s:text name="typename"/>', 'c', true, '32');
            addfield('param._se_typechname', '<s:text name="typechname"/>', 'c', true, '64');
            addfield('param._se_field', '<s:text name="field"/>', 'c', true, '32');
            addfield('param._se_fieldchname', '<s:text name="fieldchname"/>', 'c', true, '64');
            addfield('param._ne_state', '<s:text name="state"/>', 'f', true, '2');
            return checkval(window);
        }
        function doEnable(cmd)
        {
        	var TO = true;
        	var sis = formList.all("param._selectitem");  
        	if (forincheck(TO,sis,msgConfirmDelete)){
        		var url="/channel/fdauditdef_enable.do";
	        	document.all("enable").value=cmd;
	        	formList.action=url;
	        	formList.submit();
	        	formList.action="/channel/fdauditdef_list.do";
        	}
        }
		function forincheck(TO,sis,msg){
		    if (sis != null) {
		        if (sis.length != null) {
		            for (var i = 0; i < sis.length; i++) {
		                var e = sis[i];
		                if (e.type == 'checkbox') {
		                    if (e.checked)
		                        TO = false;
		                }
		            }
		        } else {
		            var e = sis;
		            if (e.type == 'checkbox') {
		                if (e.checked)
		                    TO = false;
		            }
		        }
		    }
		    if (TO) {
		        alert('请选择一条记录');
		        return false;
		    }
		    return true;
		}
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="fdauditdef_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
    <aa:zone name="hiddenZone"><s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <s:hidden name="enable"/>
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
                <td align="center"><s:text name="typename"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_typename" />
                </td>
                <td align="center"><s:text name="tablename"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._sk_tablename" />
                </td>
               </tr>
               <tr>
                <td align="center"><s:text name="field"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_field" />
                </td>
                <td align="center"><s:text name="state"/>:</td>
                <td align="left">
                    <j:selector definition="CH_STARTSTATE"  name="param._ne_state"/>
                </td>
                </tr>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
					<input type="button" id="btnEnable" name="btnDelete" class="button_2" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="enable"/>" onClick="doEnable('true')">
                        
                    <input type="button" id="btnDisabled" name="btnDelete" class="button_2" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="disable"/>" onClick="doEnable('false')">
                        
                	<s:i18n name="public">
                	<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_search"/>" onClick="doQuery('/channel/fdauditdef_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/channel/fdauditdef_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/channel/fdauditdef_delete.do')">
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
                    <j:orderByImg href="javascript:doOrderby('tablechname')"><s:text name="tablechname"/></j:orderByImg>                 
                </td>
            
                <td>
                    <j:orderByImg href="javascript:doOrderby('typechname')"><s:text name="typechname"/></j:orderByImg>                 
                </td>
           
                <td>
                    <j:orderByImg href="javascript:doOrderby('fieldchname')"><s:text name="fieldchname"/></j:orderByImg>                 
                </td>
                
                <td>
                    <j:orderByImg href="javascript:doOrderby('state')"><s:text name="state"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="field + '|' + tablename + '|' + typename"/>" onclick="checkOne();">
                     </td>
                     <%--1<td><a href='<s:url action="fdauditdef_edit.do">
	                         <s:param name="param._pk" value="field + '|' + tablename + '|' + typename"/>
	                     	</s:url>'>
							<s:property value="tablename"/>
                         </a>
					 </td>
					  --%>
                     <td>
                     		<a href='<s:url action="fdauditdef_edit.do">
	                         <s:param name="param._pk" value="field + '|' + tablename + '|' + typename"/>
	                     	</s:url>'><s:property value="tablechname" />
	                     	</a>
	                 </td>
                     <td><s:property value="typechname" /></td>
                     <td><s:property value="fieldchname" /></td>
                     
                     <td>
                     <j:code2Name code="state" definition="CH_STARTSTATE"/>
                     </td>
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
