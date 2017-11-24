<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<title><s:text name="titleList" /></title>
		<script language="JavaScript" type="text/JavaScript">
		
	function ev_check() {
		addfield('param._se_countyid', '<s:text name="countyid"/>', 'c', true, '14');
		addfield('param._se_mareacode', '<s:text name="mareacode"/>', 'c', true, '14');
		addfield('param._de_statdate', '<s:text name="statdate"/>', 't', true, '7');
		return checkval(window);
	}
	
	function opendMareacode(aObj,formWhere){
	     var countyid = document.getElementById('countyid').value;
	     if(countyid == ''){
		     alert("请先输入分公司");
                    return;
	     }else{
		     openPicker(aObj,formWhere,null,'boss.cms.microarea.queryBycountyid','COUNTYID:'+countyid);
	    }
    }
    
     function doExcel(){
        	formList.action="<%=contextPath%>/sales/disoverstat_excel.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/sales/disoverstat_list.do";
        }
        
        
   
     function putCountyID(countyid){
	     document.getElementById('countyid').value=countyid;
	}
	
	function doshowdialog(road){
		var strUrl = contextPath + road;
	   	var ret = window.showModalDialog(strUrl, self, "dialogWidth:800px; dialogHeight:280px; status:no; resizable:no;");
	   	} 
	
</script>
	</head>

	<body class="list_body"
		onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<s:form action="disoverstat_list.do" key="formList"
				cssStyle="formList" theme="simple" >
				<%
					//下面的控件给Action提供数据，用来分页
				%>
				<aa:zone name="hiddenZone">
					<s:hidden name="param._orderby" />
					<s:hidden name="param._desc" />
					<s:hidden name="param._pageno" />
					<s:hidden name="param._pagesize" />
					<s:hidden name="param.queryAll" />
					
					    <input type="hidden" id="countyid" value="${requestScope.countyid }"/>
					<input type="hidden" name="_rowcount"
						value="<s:property value="dp.rowCount" />" />
				</aa:zone>

				<div class="table_top">
					<div class="table_topleft"></div>
					<div class="table_toparea_w">
						<s:i18n name="public">
							<span class="table_toparea"><s:text name="currentPos" />
							</span>
							<span class="table_toparea_xi">></span>
							<span class="table_toparea"><s:text name="sales" /> </span>
							<span class="table_toparea_xi">></span>
						</s:i18n>
						<span class="table_toparea">配送单管理</span>
							<span class="table_toparea_xi">></span>
						<span class="table_toparea_h"><s:text name="titleList" />
						</span>
						<span class="button_Help"
							onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n
								name="public">
								<s:text name="help" />
							</s:i18n> </span>
					</div>
				</div>

				<aa:zone name="errorZone">
					<div class="error_text">
						<table class="error_text">
							<s:actionerror />
							<s:actionmessage />
						</table>
					</div>
				</aa:zone>

				<div class="table_div">
					<table class="table_normal">
						<tr>
							<td align="center">
								<s:text name="countyid" />
								:
							</td>
							<td align="left">
								<j:selector definition="#CNTYCOMPANY" name="param._se_countyid"
									mode="selector" condition="citycompid:${dBAccessUser.cityid }"
									onchange="putCountyID(this.value);" />
							</td>
							<td align="center">
								<s:text name="mareacode" />
								:
							</td>
							<td align="left">
								<s:textfield name="param._se_mareacode" />
								<input class="picker_button"
									onclick="javascript:opendMareacode(this,'#MICROAREA');"
									type="button" value="..." name="param._se_mareacode_button" />
							</td>
						</tr>
						<tr>
							<td align="center">
								<s:text name="statdate" />
								:
							</td>
							<td align="left">
								<s:textfield cssStyle="style_input" name="param._de_statdate"
									onclick="selectDate()" readonly="true" />
							</td>
							<td align="center"></td>
							<td align="left"></td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<s:i18n name="public">
									<input type="button" id="btnQuery" name="btnQuery"
										class="button_Query" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_search"/>"
										onClick="doQuery('/sales/disoverstat_list.do');">
									<input type="button" id="btnExportexcel" name="btnExportexcel"
										class="button_4" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_exportexcel"/>"
										onClick="doExcel()">

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
										<j:orderByImg href="javascript:doOrderby('seqid')">
											<s:text name="seqid" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('countyid')">
											<s:text name="countyid" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('mareacode')">
											<s:text name="mareacode" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('statdate')">
											<s:text name="statdate" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('countt1')">
											超时大于${sessionScope.count1 }小时的订单数
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('countt2')">
											超时大于${sessionScope.count2 }小时的订单数
										</j:orderByImg>
									</td>
								</tr>
								<s:iterator value="dp.datas">
									<tr class="table_style_content" align="center"
										onMouseMove="this.bgColor='F0F5F9'"
										onMouseOut="this.bgColor='#ffffff'">
										<%-- 复合主键用“|”间隔开 --%>

										<td>
											<s:property value="seqid" />
										</td>
										<td>
											<j:code2Name code="countyid" definition="#CNTYCOMPANY" />
										</td>
										<td>
											<j:code2Name code="mareacode" definition="#MICROAREA" />
										</td>
										<td>
											<s:date name="statdate" format="yyyy-MM-dd" />
										</td>
										<td>
											<s:if test="countt1 != null && countt1 != 0">
												<a
													href='javascript:doshowdialog("/sales/disoverstat_showdialog.do?param._pk=<s:property  value="seqid"/>&form.countt1=<s:property value="countt1"/>")'>
													<s:property value="countt1" /> </a>

											</s:if>
											<s:else>
												<s:property value="countt1" />
											</s:else>


										</td>
										<td>
											<s:if test="countt2 != null && countt2 != 0">
												<a
													href='javascript:doshowdialog("/sales/disoverstat_showdialog.do?param._pk=<s:property  value="seqid"/>&form.countt2=<s:property value="countt2"/>")'>
													<s:property value="countt2" /> </a>
											</s:if>
											<s:else>
												<s:property value="countt2" />
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
	ajaxAnywhere.substituteFormSubmitFunction();  
	ajaxAnywhere.formURL = formList.action;
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script>
