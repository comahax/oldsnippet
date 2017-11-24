<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
   
        function ev_check() {
        	addfield('form.batchno', '<s:text name="batchno"/>', 'c', false, 30);
        	return checkval(window);
        }
        
        function doStart(actionUrl){
            if(ev_check()){
        		if (confirm("确定启用该批次的商品资源?")){
        			formList.action=contextPath + actionUrl;
        			formList.submit();
        		}
        	}
        }

     <%--   $(document).ready(function(){
        	var allamount = 0;
        	$(".countclass").each(function(i){
				allamount = allamount + parseInt($(this).val());
				alert(allamount);
			});  
    		$("#allamountTd").html(allamount);
    		$("#allamount").val(allamount);
        });--%>
                
        
        //返回指定名称下的多选框,选中的数量
        function chooseCount(anObjectName){
        	var count = 0;
	        var objArray= document.getElementsByName(anObjectName);
	        for(var i = 0;i<objArray.length;i++){
		        var e = objArray[i];
	                if (e.type == 'checkbox') {
	                    if (e.checked)
	                        count++;
	                }
	        }
	        return count;
        }
        
        //返回选中项的值并且多个之间形式为 &属性名=值1&属性名=值2
        function chooseValue(anObjectName){
        var result = "";
        var objArray= document.getElementsByName(anObjectName);
	        for(var i = 0;i<objArray.length;i++){
		        var e = objArray[i];
	                if (e.type == 'checkbox') {
	                    if (e.checked)
	                        result += '&'+anObjectName+'='+objArray[i].value;
	                }
	        }
	        return result;
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="orderresstart_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
    <aa:zone name="hiddenZone"><s:hidden name="param._orderby"/>
    <s:hidden name="form.buttonflag"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <s:hidden name="isQuery" value="true"></s:hidden>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/></aa:zone>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="resource"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
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
                <td align="center"><s:text name="restype"/>:</td>
                <td align="left">
                    <select name="form.restype" style="select">
    					<option value="taoka">套卡</option>
    					<option value="chongzhika">充值卡</option>
    					<option value="kongbaisimka">空白SIM卡</option>
                    </select>
                    <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="batchno"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="form.batchno"/>
                    <font color=red>*</font>
                </td>
                
            </tr>
        </table>
    </div>
    
    <div class="table_div">
    <aa:zone name="refreshTable">
		<table class="table_button_list">
			<tr>
				<td>
                	<s:i18n name="public">
                	<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_search"/>" onClick="doQuery('/resource/orderresstart_list.do');">
                    
                    <input type="button" id="btnDeplay" name="btnDeplay" class="button_2" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="启用" onClick="doStart('/resource/orderresstart_start.do')" <s:if test="form.buttonflag == 'disable'" >disabled = "true"</s:if>/>
                   </s:i18n>
				</td>
			</tr>
		</table>
	</aa:zone>
	</div>

	<aa:zone name="listZone">
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style">
            <tr class="table_style_head">
            	<td><s:text name="seqid"/></td>
          	 	<s:if test='form.restype == "kongbaisimka"'>
	                <td><s:text name="simtype"/></td>
	            	<td><s:text name="simtypename"/></td>
		        </s:if>
		        <s:else>
					<td><s:text name="comid"/></td>
	           		<td><s:text name="comname"/></td>
		        </s:else>
            	<td><s:text name="ncount"/></td>
            </tr>
            <s:iterator value="dp.datas" status="state">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
                     <td><s:text name="#state.count"/></td>
                     <s:if test='form.restype == "kongbaisimka"'>
		               <td><s:property value="comid" /></td>
                       <td><j:code2Name code="comid" definition="$SIMCOMCATEGORY"/></td>
			        </s:if>
			        <s:else>
						  <td><s:property value="comid" /></td>
                    	 <td><j:code2Name code="comid" definition="#COMSYSTEM"/></td>
			        </s:else>
			           <td cssClass="countclass"><s:property value="count" /></td>
                 </tr>
             </s:iterator>
             <tr class="table_style_content" align="center">
             	<td><s:text name="total"/></td>
             	<td >&nbsp;</td>
             	<td >&nbsp;</td>
             	<td id="allamountTd"><s:property value="form.allcount" /></td>
             </tr>
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
		return "errorZone,listZone,hiddenZone,refreshTable";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete,refreshTable");
</script> 
</body>
</html>
