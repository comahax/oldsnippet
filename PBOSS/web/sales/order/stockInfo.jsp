<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>订单审核分配量提示</title>
    <script language="JavaScript" type="text/JavaScript">
       
    	
	    
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="order_appList.do" key="formList" cssStyle="formList" theme="simple" >
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
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h">订单审核分配量提示</span>
		</div>
	</div>
    
   
    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>

    
	 <br>
	<aa:zone name="listZone">
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style">
            <tr class="table_style_head">
            	
                <td >
                    序号
                </td>
                <td>
                   <s:text name="countyid"/>                
                </td>
                <td>
                    <s:text name="svccode"/>                 
                </td>
                  <td>
                    <s:text name="ordercomtype"/>                
                </td>
                <td>
                    <s:text name="comcategory"/>              
                </td>
                <td>
                    可售库存(套/张)                 
                </td>
                <td>
                    可分配库存(套/张)                 
                </td>
                <td>
                    分配量(套/张)                 
                </td>
            </tr>
            <s:iterator value="dp.datas" status="state">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
                     <td>
                        <s:text name="#state.count"/>
                     </td>
                     <td>
							<j:code2Name definition="#CNTYCOMPANY" code="countyid"/>
					 </td>
                     <td><j:code2Name definition="#SERVCENT" code="svccode"/></td>
                     <td><j:code2Name definition="$FX_ORDERCOMTYPE" code="ordercomtype"/></td>
                     <td><j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory"/></td>
                     <td><s:property value="stocks" /></td>
                     <td><s:property value="assignStocks" /></td>
                     <td><s:property value="orderamt" /></td>
                    
                 </tr>
               
             </s:iterator>
             
        </table>
        </div>
        
		
    </div>
    <%-- 
    <div class="table_div">
		<%@ include file="/common/pageNav.jsp"%>
   	</div>--%>
   	 <div class="table_div">
   	<table class="table_button_list">
			<tr>
				<td>
                	<s:i18n name="public">
                		<input type="button" id="buttonApp" name="buttonApp" class="button_2" onmouseover="buttonover(this);" 
	                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="<s:text name="button_confirm"/>" onclick="doAppPass()" 
	                           <s:if test="!form.appPass">disabled = "true"</s:if>/>
	                    <input type="button" id="buttonCancel" name="buttonCancel" class="button_2" onmouseover="buttonover(this);" 
	                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="<s:text name="button_cancel"/>" onclick="JavaScript:window.close();" />
	                   
                   </s:i18n>
				</td>
			</tr>
			
		</table>
	</div>
    </aa:zone>
</s:form>
</div>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	function doAppPass(){
		window.returnValue='pass';
		window.close();
	}
	

	//ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	//ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnDelete");
</script> 
</body>
</html>
