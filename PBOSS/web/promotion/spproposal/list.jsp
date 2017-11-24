<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('param._de_pstarttime', '<s:text name="pstarttime"/>', 't', true, 16);
            return checkval(window);
        }
        function goTo(str){
        var form=document.forms[0];
		form.action="<%=contextPath%>/promotion/spproposal/frame.jsp?pk="+str;
		form.submit();
        
        }
        
        function goToView(str,str1){
        var form=document.forms[0];
		form.action="<%=contextPath%>/promotion/spproposal/frame.jsp?pk="+str + "&isActive=" + str1;
		form.submit();
        
        }
        
        msgConfirmDelete = "此操作会删除该选中方案下的所有相关记录(如方案与规则, 方案与参与者)等全部记录, 确定删除吗?";
        function doDelete() {
    		var TO = true;
    		var sis = formList.all("param._selectitem");   
    		if (forincheck(TO,sis,msgConfirmDelete)){    
    			formList.action="<%=contextPath%>/promotion/spproposal_delete.do";
    			formList.submit();
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
        		alert(msgNoSelected);
        		return false;
    		}

   	 		if (!confirm(msg)) {
        		return false;
    		}
    		return true;
		}		
		
        function doDeleteAll(){
 		var sis = formList.all("param._selectitem");
 		if(sis!=null){
 			alert("无选中的记录!");
 			return false;
 		}
 		var TO = true;
 		var e = sis[i];
 		
 		for (var i = 0; i < sis.length; i++) {
                var e = sis[i];
                if (e.type == 'checkbox') {
                    if (e.checked)
                        TO = false;
                }
        }
        if(TO){
 		
    		if(confirm("确定删除选中的记录吗?")){
   				if(confirm("此操作会删除该选中方案下的所有相关记录(如方案与规则, 方案与参与者)等全部记录, 确定吗?")){
   				
    			formList.action="<%=contextPath%>/promotion/spproposal_delete.do";
    			formList.submit();
    			}else{
    				return false;
    			}
    			
    		}else{
    			return false;
    		}
    	}
    }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="spproposal_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
   	<aa:zone name="hiddenZone">
   	<s:hidden name="param._orderby"/>
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
			<span class="table_toparea"><s:text name="promotion"/> </span>
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
                <td align="center"><s:text name="pname"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._sk_pname" />
                </td>
                <td align="center"><s:text name="ptype"/>:</td>
                <td align="left">
                    <j:selector definition="$CH_PTYPE" name="param._se_ptype" cssStyle="style_input" />
                </td>
            </tr>
             <tr>
                <td align="center"><s:text name="ptime"/>:</td>
                <td align="left">
                	<s:textfield cssStyle="style_input" name="param._de_pstarttime"
									onclick="selectDate();" readonly="true" />
                </td>
                <td align="center"><s:text name="pfrtmode"/>:</td>
                <td align="left">
                    <j:selector definition="$CH_PFRTMODE" name="param._se_pfrtmode" cssStyle="style_input" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/promotion/spproposal_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/promotion/spproposal_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete()">
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
                <td width="15px" title="<s:text name="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();"/>
                </td>
                </s:i18n>
                <td width="5%">
                    <j:orderByImg href="javascript:doOrderby('pid')"><s:text name="pid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('pname')"><s:text name="pname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('ptype')"><s:text name="ptype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('pstarttime')"><s:text name="pstarttime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('pendtime')"><s:text name="pendtime"/></j:orderByImg>                 
                </td>
                <td width="5%">
                    <j:orderByImg href="javascript:doOrderby('pfrtmode')"><s:text name="pfrtmode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('memo')"><s:text name="memo"/></j:orderByImg>                 
                </td>
                <td>方案管理
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
                     <td>
                     	<s:if test="isDeletable == 'true'">
                         	<input type="checkbox" name="param._selectitem" value="<s:property value="pid"/>" onclick="checkOne();">
                        </s:if>
                        <s:else>
                         	<input type="checkbox" name="param._selectitem" value="<s:property value="pid"/>" disabled="disabled" title="该方案已经生效,不能修改删除!">
                        </s:else>
                     </td>
                     <td width="5%"><a href='<s:url action="spproposal_edit.do">
	                         <s:param name="param._pk" value="pid"/>
	                     	</s:url>'>
							<s:property value="pid"/>
                         </a>
					 </td>
                     <td><span style="overflow:hidden; text-overflow:ellipsis; white-space:nowrap;width:100px" title="<s:property value="pname" />">
                     		<s:property value="pname" />
                     	</span></td>
                     <td><j:code2Name definition='$CH_PTYPE' code="ptype"/></td>
                     <td><s:date format="yyyy-MM-dd" name="pstarttime"/></td>
                     <td><s:date format="yyyy-MM-dd" name="pendtime"/></td>
                     <td width="5%"><j:code2Name definition='$CH_PFRTMODE' code="pfrtmode"/></td>
                     <td><span style="overflow:hidden; text-overflow:ellipsis; white-space:nowrap;width:100px" title="<s:property value="memo" />">
                     		<s:property value="memo" />
                     	</span></td>
                     <td width="50px">
                     	<s:if test="isDeletable == 'true'">
	                     	<input type="button" name="btnSet" class="button_4" onmouseover="buttonover(this);"
	                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                        value="方案设置" onClick="goTo('<s:property value="pid"/>')">
	                    </s:if>
	                    <s:else>
	                    	<input type="button" name="btnSet" class="button_4" onmouseover="buttonover(this);"
	                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                        value="方案设置" onClick="goToView('<s:property value="pid"/>','isActive')" title="该方案已经生效,只允许查看,不允许修改删除!">
	                    </s:else>
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
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 

