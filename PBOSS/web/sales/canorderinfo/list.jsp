<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', false, '18');
            return checkval(window);
        }
        
        function doImport(){
			formList.action = "<%=contextPath%>/sales/canorderinfo/batchNotice.jsp";
      		formList.submit();
		}
        
        <%!
        Boolean sendSmsFlag = false;
        %>
        function  doNoticeOne(){
        	<%
        	sendSmsFlag = (Boolean)request.getAttribute("sendSmsFlag");
        	
        	if(sendSmsFlag != null && !"".equals(sendSmsFlag) && sendSmsFlag){%>
        		
        		var returnValue=window.showModalDialog('<%=contextPath %>/sales/canorderinfo_noticeOneConfirm.do',window,"dialogWidth=650px;dialogHeight=300px;status:no;scroll=yes;");
        		
        	<%}
        	%>
        }
        
 		function doBatch(){
        	formList.action="<%=contextPath%>/sales/canorderinfo/batchimport.jsp";
        	formList.submit();
        }
        
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();doNoticeOne();">
<div class="table_container">
<s:form action="canorderinfo_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea"><s:text name="sales"/> </span>
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
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                	<s:textfield cssStyle="style_input" name="param._se_wayid" /><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_wayid',null,null,'AG');this.value='...';" />
                	<font color=red>*</font>
                </td>
            </tr>            
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
                	<s:i18n name="public">
                	<input type="button" id="btnQuery" name="btnQuery" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/canorderinfo_list.do');">
                        
                    <input type="button" id="batchlist" name="batchlist" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="批量查询" onClick="doBatch();">
                    
                    <input type="button" id="noticeOne" name="noticeOne" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="短信通知" onClick="doQuery('/sales/canorderinfo_noticeOne.do');">
                   
                   <input type="button" id="noticeBatch" name="noticeBatch"
						class="button_4" onmouseover="buttonover(this);"
						onmouseout="buttonout(this);" onfocus="buttonover(this)"
						onblur="buttonout(this)" value="批量通知" onClick="doImport();">
                   	
                   </s:i18n>
				</td>
			</tr>
		</table>
	</div>

	<aa:zone name="listZone">
	<tr style="align:left">套卡订购信息   单位：套</tr>
    <div class="table_div">
    	<div>    	
        <table class="table_style" id="dataTable">        	
            <tr class="table_style_head">
                <td>
                    <s:text name="brand"/>
                </td>
                <td>
                    <s:text name="canorder"/>
                </td>
                <td>
                    <s:text name="maxorder"/>
                </td>
                <td>
                    <s:text name="curorder"/>
                </td>
                <td>
                    <s:text name="thrmonavg"/>
                </td>
                <td>
                    <s:text name="sixmonavg"/>
                </td>
                <td>
                    <s:text name="referdata"/>
                </td>
                
            </tr>
            
            <s:iterator value="brandList">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
                     
                     <td><s:property value="brandName"/></td>
                     <td><s:property value="canorder"/></td>
                     <td><s:property value="maxorder"/></td>
                     <td><s:property value="curorder"/></td>
                     <td><s:property value="thrmonavg"/></td>
                     <td><s:property value="sixmonavg"/></td>
                     <td>
                     	<div align='left'>
                     		<table id="dataTable2">
                     		<s:iterator value="referdataList">
                     			<s:property value="referdata"/><br>
                     		</s:iterator>
                     		</table>
                     	</div>
                     </td>
                 </tr>
             </s:iterator>
        </table>
        
        </div>
    </div>
    <br>
    
    <tr style="align:left">充值卡订购信息   单位：张</tr>
    <div class="table_div">
    	<div>        
        <table class="table_style" id="dataTable1">        	            
            <tr class="table_style_head">
                <td>
                    <s:text name="cardtype"/>
                </td>
                <td>
                    <s:text name="cardcanorder"/>
                </td>
                <td>
                    <s:text name="cardmonlim"/>
                </td>
                <td>
                    <s:text name="carddaylim"/>
                </td>
                <td>
                    <s:text name="cardtimelim"/>
                </td>
                <td>
                    <s:text name="cardmonordered"/>
                </td>
                <td>
                    <s:text name="carddayordered"/>
                </td>
                
            </tr>
                        
            <s:iterator value="cardList">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
                     <td><j:code2Name definition="$IM_FXCOMCATEGORY" code="cardtype"/></td>
                     <td><s:property value="cardcanorder"/></td>
                     <td><s:property value="cardmonlim"/></td>
                     <td><s:property value="carddaylim"/></td>
                     <td><s:property value="cardtimelim"/></td>
                     <td><s:property value="cardmonordered"/></td>
                     <td><s:property value="carddayordered"/></td>
                 </tr>
             </s:iterator>
             
        </table>
        </div>
    </div>
    <br>
				        <tr style="align:left"><s:text name="info5"/>&nbsp;<s:text name="unit"/></tr>
			        	 <div class="table_div">
			        	<table class="table_style">
				        	<tr>
				            </tr>
				        	 <tr class="table_style_head">
				                <td><s:text name="comcategory"/></td>
								<td><s:text name="curmaxstock"/></td>
								<td><s:text name="maxStock"/></td>
								<td><s:text name="curstock"/></td>
								<td><s:text name="usecount"/></td>
								<td><s:text name="badcount"/></td>
								<td><s:text name="orderedMonth"/></td>
				            </tr>
				            <s:iterator value="emptyList" status="status">
				            	 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
									<td><j:code2Name definition="$IM_FXCOMCATEGORY" code="restype"/></td>
									<td><s:property value="curmaxstock"/></td>
									<td><s:property value="maxstock"/></td>
									<td><s:property value="curstock"/></td>
									<td><s:property value="usecount"/></td>
									<td><s:property value="badcount"/></td>
									<td><s:property value="orderedMonth"/></td>
								</tr>
				            </s:iterator>
			        	</table>
        </div>
    </div>
    </aa:zone>
</s:form>
</div>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
</body>
</html>
