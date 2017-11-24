<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
	<head>
		<title><s:text name="titleUpdate" />
		</title>
		<script type="text/javascript" src="<%=contextPath%>/js/pub/list.js"></script>
		<script language="JavaScript">
        function ev_checkval() {
			addfield('form.recename', '<s:text name="recename"/>', 'c', true, 32);
			addfield('form.recetel', '<s:text name="recetel"/>', 'c', true, 12);
			addfield('form.receadd', '<s:text name="receadd"/>', 'c', true, 256);
			addfield('form.discomcode', '<s:text name="discomcode"/>', 'c', true, 18);
			addfield('form.disstate', '<s:text name="disstate"/>', 'c', true, 16);
			addfield('form.memo', '<s:text name="memo"/>', 'c', true, 256);
            return checkval(window);
        }
        
        function doSave(str) {
    		var ret = ev_checkval();   
    		if ( ret ) {
        		formList.action = "<%=contextPath%>/sales/disform_save.do?form.recid=" + str;
        		formList.submit();
    		}
    		return false;
		}
		
		function doReturn(cmdReturn) {
    		formList.action = "<%=contextPath%>/sales/disform_list.do";
    		formList.submit();
		}
		
		function doExport(){
			formList.action="<%=contextPath%>/sales/disform_exportExcel.do";
    		formList.submit();
    		formList.action="<%=contextPath%>/sales/disform_showrecord.do";
		}
		
		function doPrint(str){
			var url = contextPath + "/sales/disform_print.do?form.orderid=" + str;
			var hWnd = window.showModalDialog(url,new Array(),"dialogWidth:768px; dialogHeight:1024px; status:no;resizable:no;");
		}
    </script>
	</head>
	<body>
		<div class="table_container">
			<s:form action="disform_edit.do" cssStyle="formList" key="formList"
				method="post" theme="simple" onsubmit="return ev_checkval();">

				<s:hidden name="CMD" />
				<s:hidden name="param._orderby" />
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				<s:hidden name="param._pk" />
				<s:hidden name="param._se_discomcode" />
				<s:hidden name="param._ne_recid" />
				<s:hidden name="param._se_orderid" />
				<s:hidden name="param._se_disstate" />
				<s:hidden name="param._se_paytype" />
				<s:hidden name="param._se_countyid" />
				<s:hidden name="param._dnl_createtime" />
				<s:hidden name="param._dnm_createtime" />
				<s:hidden name="form.orderid" />
				<s:hidden name="form.paytype" />
				<s:hidden name="form.signstate" />
				<s:hidden name="form.orderinfo" />
				
				<input type="hidden" name="_rowcount"
					value="<s:property value="dp.rowCount" />" />
				<div class="table_top">
					<div class="table_topleft"></div>
					<div class="table_toparea_w">
						<s:i18n name="public">
							<span class="table_toparea"><s:text name="currentPos" /> </span>
							<span class="table_toparea_xi">></span>
							<span class="table_toparea"><s:text name="sales" /> </span>
							<span class="table_toparea_xi">></span>
						</s:i18n>
						<span class="table_toparea_h"><s:text name="titleList" />
						</span>
						<span class="button_Help"
							onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n
								name="public">
								<s:text name="help" />
							</s:i18n>
						</span>
					</div>
				</div>

				<div class="error_text">
					<table class="error_text">
						<s:actionerror />
						<s:actionmessage />
					</table>
				</div>
				
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td width="100%" align="center">
							<input type="button" class="button_4" onmouseover="buttonover(this);"
			                      	onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                   		value="导出EXCEL" onClick="doExport();"/>
			                <input type="button" class="button_4" onmouseover="buttonover(this);"
			                      	onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                   		value="打印" onClick="doPrint('<s:property value="form.orderid" />');"/>
							<s:i18n name="public">
							<s:if test="form.disstate=='CANCEL' or form.disstate=='DISOVER'">
								
									<input type="button" id="btnSave" name="btnSave"
										class="button_Save" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="<s:text name="button_save"/>"
										onclick="doSave('<s:property value="form.recid" />')" disabled="true"
										<s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           				/>
                           	</s:if>
                           	<s:else>
                           			<input type="button" id="btnSave" name="btnSave"
										class="button_Save" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="<s:text name="button_save"/>"
										onclick="doSave('<s:property value="form.recid" />')" 
										<s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           				/>
                           	</s:else>
									<input type="button" id="btnReturn" name="btnReturn"
										class="button_Back" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_return"/>"
										onclick="doReturn()">
								</s:i18n>
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table class="table_normal">
						<tr>
							<td align="right" width="25%">
								<s:text name="recid" />
								:&nbsp
							</td>
							<td align="left" width="25%">
								<s:property value="form.recid" />
							</td>
							<td align="right" width="25%">
								<s:text name="orderid" />
								:&nbsp
							</td>
							<td align="left" width="25%">
								<s:property value="form.orderid" />
							</td>
						</tr>
						<tr>
							<td align="right" width="25%">
								<s:text name="createtime" />
								:&nbsp
							</td>
							<td align="left" width="25%">
								<s:date name="form.createtime" format="yyyy-MM-dd"/>
							</td>
							<td align="right" width="25%">
								<s:text name="arrivetime" />
								:&nbsp
							</td>
							<td align="left" width="25%">
								<s:date name="form.arrivetime" format="yyyy-MM-dd"/>
							</td>
						</tr>
						<tr>
							<td align="right" width="25%">
								<s:text name="recewayid" />
								:&nbsp
							</td>
							<td align="left" width="25%">
								<j:code2Name definition="#WAYIDINFO" code="form.recewayid" />
							</td>
							<td align="right" width="25%">
								<s:text name="discomcode" />
								:&nbsp
							</td>
							<td align="left" width="25%">
								<j:code2Name definition="#WAYIDINFO" code="form.discomcode" />
							</td>
						</tr>
						<tr>
							<td align="right" width="25%">
								<s:text name="paytype" />
								:&nbsp
							</td>
							<td align="left" width="25%">
								<j:code2Name definition="$FX_PAYTYPE" code="form.paytype" />
							</td>
							<td align="right" width="25%">
								<s:text name="recamt" />
								:&nbsp
							</td>
							<td align="left" width="25%">
								<s:property value="form.recamt" />
							</td>
						</tr>
						<tr>
							<td align="right" width="25%">
								<s:text name="disstate" />
								:&nbsp
							</td>
							<td align="left" width="25%">
								<j:code2Name definition="$FX_DISFORMSTATE" code="form.disstate" />
							</td>
							<td align="right" width="25%">
								<s:text name="signstate" />
								:&nbsp
							</td>
							<td align="left" colspan="3">
								<j:code2Name definition="$FX_SIGNSTATE" code="form.signstate" />
							</td>
						</tr>
						<tr>
							<td align="right">
								<s:text name="orderinfo" />
								:&nbsp
							</td>
							<td align="left" colspan="3">
								<s:property value="form.orderinfo" />
							</td>
						</tr>
						<tr>
						    <td align="right">
								<s:text name="logisticsno" />
								:&nbsp
							</td>
							<td align="left" width="25%" colspan="3">
								<s:if test="CMD == WEB_CMD_EDIT">
								<s:textfield cssStyle="style_input" name="form.logisticsno"
									maxlength="32" />
									</s:if>
									<s:else>
									<s:textfield cssStyle="style_input" name="form.logisticsno"
									maxlength="32" disabled="true"/>
									</s:else>
							</td> 
						</tr>
						<tr>
							<td align="right" width="25%">
								<s:text name="recename" />
								:&nbsp
							</td>
							<td align="left" width="25%">
								<s:if test="CMD == WEB_CMD_EDIT">
								<s:textfield cssStyle="style_input" name="form.recename"
									maxlength="32" />
									</s:if>
									<s:else>
									<s:textfield cssStyle="style_input" name="form.recename"
									maxlength="32" disabled="true"/>
									</s:else>
							</td>
							<td align="right" width="25%">
								<s:text name="recetel" />
								:&nbsp
							</td>
							<td align="left" width="25%">
								<s:if test="CMD == WEB_CMD_EDIT">
								<s:textfield cssStyle="style_input" name="form.recetel"
									maxlength="12" />
								</s:if>
								<s:else>
									<s:textfield cssStyle="style_input" name="form.recetel"
									maxlength="12" disabled="true"/>
								</s:else>
							</td>
						</tr>
						<tr>
							<td align="right" width="25%">
								<s:text name="receadd" />
								:&nbsp
							</td>
							<td align="left" width="25%" colspan="3">
								<s:if test="CMD == WEB_CMD_EDIT">
								<s:textfield cssStyle="width:600px;height:20px" name="form.receadd"
									maxlength="256" />
								</s:if>
								<s:else>
									<s:textfield cssStyle="width:600px;height:20px" name="form.receadd"
									maxlength="256" disabled="true"/>
								</s:else>
							</td>
						</tr>
						<tr>
							<td align="right" width="25%">
								<s:text name="memo" />
								:&nbsp
							</td>
							<td align="left" width="25%" colspan="3">
								<s:if test="CMD == WEB_CMD_EDIT">
								<s:textfield cssStyle="width:600px;height:20px" name="form.memo"
									maxlength="256" />
								</s:if>
								<s:else>
									<s:textfield cssStyle="width:600px;height:20px" name="form.memo"
									maxlength="256" disabled="true"/>
								</s:else>
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
					<tr>
					</tr>
					</table>
				</div>
	<aa:zone name="listZone">	
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style">
            <tr class="table_style_head">
            				<td>序号</td>
                			<td><s:text name="detid" /></td>	
							<td><s:text name="comcategory" /></td>	
							<td><s:text name="comid" /></td>	
							<td><s:text name="comid1" /></td>	
							<td><s:text name="batchno" /></td>
							<td><s:text name="boxnum" /></td>
							<td><s:text name="comresid" /></td>
            </tr>
            <s:iterator value="dp.datas" status="state">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
					 		<td>
					 			 <s:text name="#state.count"/>
					 		</td>
							<td>
								<s:property value="detid" />
							</td>
							<td>
								<j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory" />
							</td>
							<td>
								<s:property value="comid" />
							</td>
							<td>
								<j:code2Name definition="#COMSYSTEM" code="comid" />
							</td>
							<td>
								<s:property value="batchno" />
							</td>
							<td>
								<s:property value="boxnum" />
							</td>
							<td>
								<s:property value="comresid" />
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
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script>
	</body>
</html>
