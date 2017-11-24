<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		addfield('param._dnm_smsntime', '<s:text name="smsntime"/>', 'dt', true, '7');
		addfield('param._dnl_smsntime', '<s:text name="smsntime"/>', 'dt', true, '7');
		addfield('param._se_state', '<s:text name="state"/>', 'c', true, '32');
		return checkval(window);
	}
	
	
	function checkBoxOne() {
	
		
	  var sis =[];  
	  $('input[name="param._selectitem"]:checked').each(function(){  
	  	 sis.push($(this).val());  
	  });  
		//  alert(sis.length==0 ?'你还没有选择任何内容！':chk_value);  
		
	
	
	
    //var sis = document.getElementsByName('param._selectitem');
    if (sis != null) {
        if (sis.length != null) {
        	if(sis.length == 0){
        		alert("请选择审核记录！");
        		return;
        	}
        
        	if(sis.length>1){
        		alert("只允许选择一条记录进行审核!");
        		return;
        	}
        	var resultArray = sis[0].split(',');
        	
        	if(resultArray[1]!=resultArray[3]){
        		alert("只能审核审核人为该工号的审核记录!");
        		return ;
        	}
        	
        	
        	if(resultArray[2]!=0){
        		alert("只能审核状态为待审核的记录!");        	
        		return ;
        	}
        	
        	//<s:property value="seqid"/>,<s:property value="auditor"/>,<s:property value="state"/>,${requestScope.user}
        	window.location.href="<%=contextPath%>/channel/bondaudit_edit.do?form.seqid="+resultArray[0];
        } else{
        	alert("请选择审核记录！");
        	return;
        }
    }
}
	
	function toSP(seqid,auditor,user){
			if(auditor!=user){
        		alert("只能审核审核人为该工号的审核记录!");
        		return ;
        	}
		window.location.href="<%=contextPath%>/channel/bondaudit_edit.do?form.seqid="+seqid;
	}
	
	
</script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="bondaudit_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
               
                <td align="center"><s:text name="_dnl_smsntime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_smsntime"  onclick="selectDatetime()" />
                </td>
                 <td align="center"><s:text name="_dnm_smsntime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_smsntime"  onclick="selectDatetime()" />
                </td>
                <td align="center"><s:text name="_se_state"/>:</td>
                <td align="left">
                    <j:selector definition="$CH_AUDITSTATE" name="param._se_state" mode="selector"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/channel/bondaudit_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_2" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="审核" onClick="checkBoxOne();">
                    <!-- 
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/channel/bondaudit_delete.do')">
                         -->
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
                    <j:orderByImg href="javascript:doOrderby('seqid')"><s:text name="seqid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('presenter')"><s:text name="presenter"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('smsntime')"><s:text name="smsntime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('state')"><s:text name="state"/></j:orderByImg>                 
                </td>
                 <td>
                    <j:orderByImg href="javascript:doOrderby('memo')"><s:text name="memo"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('auditor')"><s:text name="auditor"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('audittime')"><s:text name="audittime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('opinion')"><s:text name="opinion"/></j:orderByImg>                 
                </td>
                
               
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="seqid"/>,<s:property value="auditor"/>,<s:property value="state"/>,${requestScope.user}" onclick="checkOne();">
                     </td>
                     <td><a href='javascript:toSP("<s:property value="seqid"/>","<s:property value="auditor"/>","${requestScope.user}");'>
							<s:property value="seqid"/>
                         </a>
					 </td>
                     <td><j:code2Name code="presenter" definition="#OPERATOR" /></td>
                     <td><s:date name="smsntime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><j:code2Name code="state" definition="$CH_AUDITSTATE" /></td>
                     <td><s:property value="memo" /></td>
                     <td><j:code2Name code="auditor" definition="#OPERATOR" /></td>
                     <td><s:date name="audittime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><s:property value="opinion" /></td>
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
