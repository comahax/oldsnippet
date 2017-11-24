<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="waychecked_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
	<aa:zone name="hiddenZone">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <s:hidden name="form.APPSTATUS_MULTI"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
	</aa:zone>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea" ><s:text name="currentPos"/> </span>
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
	<div id="mydialog"></div>


	<div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="center"><s:text name="applyno"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_applyno" />
                </td> 
                  <td align="center"><s:text name="applytype"/>:</td>
                <td align="left">
                    <j:selector definition="$CH_CHECKTYPE" name="param._se_applytype"/> 
                </td>
            </tr>
            <tr>
                <td align="center">申请状态:</td> 
                <td align="left">
                	<s:if test="form.APPSTATUS_MULTI">
	                  <j:selector definition="$CH_APPSTATUS_GZ" name="param._se_status"/> 
                    </s:if>
                    <s:else>
                      <j:selector definition="$CH_APPSTATUS" name="param._se_status"/> 
                    </s:else>                    
                </td>
                  <td align="center"><s:text name="oprcode"/>:</td>
                <td align="left">
                 <j:selector definition="#OPERATOR" name="param._se_oprcode" condition='region:${dBAccessUser.hwcityid };'/>
                </td>
            </tr>
            <tr>    
                <td align="center"><s:text name="aptime"/>>=:</td>
                <td align="left">
                  <s:textfield cssStyle="style_input" name="param._dnl_aptime" onclick="selectDatetime()" readonly="true" /> 
                </td>
                <td align="center"><s:text name="aptime"/><=:</td>
                <td align="left">
                   <s:textfield cssStyle="style_input" name="param._dnm_aptime" onclick="selectDatetime()" readonly="true"/> 
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/channel/waychecked_list.do');">
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
                    <j:orderByImg href="javascript:doOrderby('applyno')"><s:text name="applyno"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('cityid')"><s:text name="cityid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('aptime')"><s:text name="aptime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('oprcode')"><s:text name="oprcode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('mobileno')"><s:text name="mobileno"/></j:orderByImg>                 
                </td> 
                <td>
                    <j:orderByImg href="javascript:doOrderby('applytype')"><s:text name="applytype"/></j:orderByImg>                 
                </td>
                <td>
                    申请状态                
                </td> 
                <td>
                    审核意见                
                </td> 
            </tr>
            <s:iterator value="dp.datas" status="state">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'"> 
                     <td>
                      	 <s:if test="form.CH_CHECKED_CITY || form.hasCH_CHECKED_MIDCITY">
	                     	<a href='<s:url action="waychecked_edit.do">
		                       	<s:param name="param._pk" value="applyno"/>
		                    	</s:url>'>
								<s:property value="applyno"/>
	                         </a>
                         </s:if>
                         <s:else>
                         	<s:property value="applyno"/>
                         </s:else>
					 </td>
                     <td><j:code2Name code="cityid" definition="#CITYCOMPANY" /></td>
                     <td><s:date name="aptime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><s:property value="oprcode" /></td>
                     <td><s:property value="mobileno" /></td> 
                     <td><j:code2Name definition="$CH_CHECKTYPE" code="applytype" /></td>
                     <td>
	                    <s:if test="form.APPSTATUS_MULTI">
		                  <j:code2Name definition="$CH_APPSTATUS_GZ" code="status" /> 
	                    </s:if>
	                    <s:else>
	                      <j:code2Name definition="$CH_APPSTATUS" code="status" />
	                    </s:else>                    
                     </td>
					                      
                      <td><a id="aid<s:property value="#state.count"/>" href="javascript:void(0);" 
                      onClick="setMydialogVal('<s:property value="chkmemo"/>');">
                      <s:property value="chkmemo2"/></a></td>    
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
<script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		addfield('param._ne_applyno', '<s:text name="applyno"/>', 'f', true, '14');
		addfield('param._se_applytype', '<s:text name="applytype"/>', 'c', true, '2');
		return checkval(window);
	}
	
	function openword2 (elementid,title,str) {
		 var tdiv = document.getElementById(elementid);
		 var xx = tdiv.offsetLeft,yy = tdiv.offsetTop;  
		    while(tdiv=tdiv.offsetParent)   
			 {   
			   xx += tdiv.offsetLeft;     
			   yy += tdiv.offsetTop;  
			 } 
		newin = new messagePopup(xx+225,yy+190,w_word/2,h_word/2,title,str);
		newin.toshow();
}


$(document).ready(
	function showdialog(){
	$("#mydialog").dialog({
				height: 200,
				width: 300,
				title: '审核意见',
				autoOpen: false,
				modal: false,
				closeOnEscape:true
			});
	});
	
	
	function setMydialogVal(val){
		document.getElementById('mydialog').innerText = val;
		$('#mydialog').dialog('open');
	}
</script>
