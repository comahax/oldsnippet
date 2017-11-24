<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib prefix="j" uri="/jop-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
	    <title><s:text name="titleList"/></title>
	    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
	    <script type="text/javascript" src="<%= contextPath %>/js/pub/list.js"></script>
	    <script language="JavaScript" type="text/JavaScript">
	        function ev_checkval() {
            	addfield('form.recid', '<s:text name="recid"/>', 'f', false, 14);
            	return checkval(window);
        	}
        	
			$(document).ready(function(){
				//显示序号
        		$(".indexTd").each(function(i){
					$(this).html(i+1);
				});
				
				//订购列表商品种类编码转换
				/*var comcategoryStr = "";
				$(".comc").each(function(i){
					comcategoryStr = mapSelect("comcategory",this.value);
					$(this).after(comcategoryStr);
				});*/
			}); 
				
			//从选择框的值获取选择的显示内容
			function mapSelect(objid,val)
			{
				var str = "";
				$("#"+objid).children().each(function(i){
					if(this.value == val)
					{
						str = this.innerText;
					}
				});
				return str;
			}
	    </script>
	</head>

	<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<s:form action="comorder_step1.do" id="formList" name="formItem" method="post" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_checkval();">
				<s:hidden name="form.wayid"/>
				<s:hidden name="isurgent"/>
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
			        		<td align="center" width="15%"><s:text name="orderid"/>：</td>
			                <td align="left" width="18%">
			                	<s:property value="form.orderid"/>
			                </td>
			                <td align="center" width="15%"><s:text name="wayid"/>：</td>
			                <td align="left" width="18%">
			                	<s:property value="form.wayid"/>
			                </td>
			                <td align="center" width="15%"><s:text name="wayname"/>：</td>
			                <td align="left" width="19%">
			                	<s:property value="form.wayname"/>
			                	<j:selector definition="$IM_FXCOMCATEGORY" name="comcategory" id="comcategory" cssStyle="display:none"/>
			                </td>
			            </tr>
			        </table>
			        
			        <table class="table_normal" id="orderTable">
			        	<tr>
			                <td align="center" width="10%"><s:text name="index"/></td>
			                <td align="center" width="36%"><s:text name="comcategory"/></td>
			                <td align="center" width="15%"><s:text name="orderamount"/></td>
			                <td align="center" width="15%"><s:text name="unitprice"/></td>
			                <td align="center" width="20%"><s:text name="totalprice"/></td>
			            </tr>
			            <s:iterator value="form.comorderList" status="status">
			            	<tr>
			            		<td align="center" class="indexTd">&nbsp;</td>
								<td align="center"><j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory"/><s:hidden name="form.comorderList[%{#status.index}].comcategory" cssClass="comc"/></td>
								<td align="center"><s:property value="orderamount"/></td>
								<td align="center"><s:property value="unitprice"/></td>
								<td align="center"><s:property value="totalprice"/></td>
							</tr>
			            </s:iterator>
			            <tr>
			                <td align="center">&nbsp;</td>
							<td align="center"><s:text name="total"/></td>
							<td align="center"><s:property value="form.allamount"/></td>
							<td align="center">&nbsp;</td>
							<td align="center"><s:property value="form.allprice"/></td>
			            </tr>
			        </table>
			    </div>
			    
			    <div class="table_div">
				        <table class="table_button_list">
				            <tr>
				                <td width="100%" align="center">
				                   	<s:i18n name="public">
				                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
				                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
				                           value="<s:text name="button_return"/>" onclick="doReturn('/sales/comorder_step1.do')">
									</s:i18n>
				                </td>
				            </tr>
				        </table>
				    </div>
			    
			</s:form>
		</div>
	</body>
</html>
