<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/inc/listhead2.inc"%>
<html>
	<head>
		<title><s:text name="titleList" />
		</title>
	</head>

	<body>
		<%@ include file="/common/dialog.jsp"%>
		<s:form action="ibdatabusiinfo_list.do" name="formList" id="formList" theme="simple">
			<div id="paramListDiv" style="display:none">
			</div>
			
			<table id="dataTable" style="display:none">
				<tr id="dataTr">
					<td class="ckboxTd" dataTdWidth="40">
						<input type="checkbox"  name="_selectitem" class="ckbox"
							value="<s:property value="billcycle + '|' + chargingtype + '|' + filetype + '|' + opCode + '|' + port + '|' + spCode"/>" onclick="checkOne()">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="billcycle" id="data_billcycle" class="form_text" maxlength="6" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="billcycle"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="filetype" id="data_filetype" class="form_text" maxlength="2" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="filetype"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="spCode" id="data_spCode" class="form_text" maxlength="16" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="spCode"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="opCode" id="data_opCode" class="form_text" maxlength="16" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="opCode"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="port" id="data_port" class="form_text" maxlength="24" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="port"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="chargingtype" id="data_chargingtype" class="form_text" maxlength="2" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="chargingtype"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="fee" id="data_fee" class="form_text" maxlength="16" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="fee"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="acctitemIdlv1" id="data_acctitemIdlv1" class="form_text" maxlength="14" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="acctitemIdlv1"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="acctitemIdlv2" id="data_acctitemIdlv2" class="form_text" maxlength="14" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="acctitemIdlv2"/>">
					</td>
				</tr>
			</table>
	
			<aa:zone name="hiddenZone">
				<s:hidden name="param._orderby" />
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				<s:hidden name="param.queryAll" />
				<input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />" />
				<input type="hidden" id="maxRowCount" value="10"/><!-- change it if you need -->
				<input type="hidden" name="ajaxFlag" id="ajaxFlag"/>
				<input type="hidden" name="searchFlag" id="searchFlag"/>
				<input type="hidden" name="submitFlag" id="submitFlag"/>
				<input type="hidden" name="checkUrl" id="checkUrl" value="/monternet/ibdatabusiinfo_check.do"/>
				<input type="hidden" name="saveUrl" id="saveUrl" value="/monternet/ibdatabusiinfo_saveAll.do"/>
			</aa:zone>

			<div class="title_div">
				<div class="title_left_div">
					<s:i18n name="public">
						<s:text name="currentPos" />>
						<s:text name="monternet" />>
					</s:i18n>
					<s:text name="titleList" />
				</div >
		        <div class="title_right_div">
		        	<s:i18n name="public">
		        		<input type="button" class="form_button" value="<s:text name="help"/>" 
		        			onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')">
		        	</s:i18n>
		        </div>
			</div>

			<aa:zone name="errorZone">
				<div id="errorDiv" class="message_div" style="display:none">
					<s:actionerror />
					<s:actionmessage />
				</div>
			</aa:zone>
			
			<div class="list_oper_div">
		  		<div class="layout_left">
		  			<s:i18n name="public">
		  				<input type="button" class="form_button" value="<s:text name="button_new"/>" onclick="doNew()">
						<input type="button" class="form_button" value="<s:text name="button_copy"/>" onclick="doCopy()">
						<input type="button" class="form_button" value="<s:text name="button_delete"/>" onclick="doDelete()">
						<input type="button" class="form_button" value="<s:text name="button_save"/>" onclick="doSave()">
		  			</s:i18n>
				</div>
				
				<div id="paramDiv" class="layout_right">
					<lable>
						<s:text name="billcycle" />:
					</lable>
					<s:textfield cssClass="form_text searchParam" name="param._ne_billcycle" />
					<lable>
						<s:text name="filetype" />:
					</lable>
					<s:textfield cssClass="form_text searchParam" name="param._se_filetype" />
					<lable>
						<s:text name="spCode" />:
					</lable>
					<s:textfield cssClass="form_text searchParam" name="param._se_spCode" />
					<lable>
						<s:text name="opCode" />:
					</lable>
					<s:textfield cssClass="form_text searchParam" name="param._se_opCode" />
					<lable>
						<s:text name="port" />:
					</lable>
					<s:textfield cssClass="form_text searchParam" name="param._se_port" />
					<lable>
						<s:text name="chargingtype" />:
					</lable>
					<s:textfield cssClass="form_text searchParam" name="param._ne_chargingtype" />
					<lable>
						<s:text name="fee" />:
					</lable>
					<s:textfield cssClass="form_text searchParam" name="param._ne_fee" />
					<lable>
						<s:text name="acctitemIdlv1" />:
					</lable>
					<s:textfield cssClass="form_text searchParam" name="param._ne_acctitemIdlv1" />
					<lable>
						<s:text name="acctitemIdlv2" />:
					</lable>
					<s:textfield cssClass="form_text searchParam" name="param._ne_acctitemIdlv2" />
					<s:i18n name="public">
						<input type="button" class="form_button" value="<s:text name="button_search"/>" 
							onclick="doQuery('/monternet/ibdatabusiinfo_list.do')">
					</s:i18n>
				</div>
			</div>

			<aa:zone name="listZone">
				<div id="headDiv" class="list_head_div_1">
		            <table id="headTable" class="list_head_table_1" cellpadding="0" cellspacing="0">
						<tr>
							<s:i18n name="public">
								<td class="ckboxTd" title="<s:text name="list_title_select"/>">
									<input type="checkbox" name="allbox" onclick="checkAll()" />
								</td>
							</s:i18n>
							<td>
								<j:orderByImg href="javascript:doOrderby('billcycle')">
									<s:text name="billcycle" />
								</j:orderByImg>
							</td>
							<td>
								<j:orderByImg href="javascript:doOrderby('filetype')">
									<s:text name="filetype" />
								</j:orderByImg>
							</td>
							<td>
								<j:orderByImg href="javascript:doOrderby('spCode')">
									<s:text name="spCode" />
								</j:orderByImg>
							</td>
							<td>
								<j:orderByImg href="javascript:doOrderby('opCode')">
									<s:text name="opCode" />
								</j:orderByImg>
							</td>
							<td>
								<j:orderByImg href="javascript:doOrderby('port')">
									<s:text name="port" />
								</j:orderByImg>
							</td>
							<td>
								<j:orderByImg href="javascript:doOrderby('chargingtype')">
									<s:text name="chargingtype" />
								</j:orderByImg>
							</td>
							<td>
								<s:text name="fee" />
							</td>
							<td>
								<s:text name="acctitemIdlv1" />
							</td>
							<td>
								<s:text name="acctitemIdlv2" />
							</td>
						</tr>
					</table>
            	</div>
            	
				<div id="contentDiv" class="list_content_div" onscroll="doScrollTable()">
        			<table id="contentTable" class="list_content_table" cellpadding="0" cellspacing="0">
						<s:iterator value="dp.datas" status="status">
							<tr class="editTr" trIndex="${status.index}">
								<td class="ckboxTd">
									<input type="checkbox" name="param._selectitem" class="ckbox"
										value="<s:property value="billcycle + '|' + chargingtype + '|' + filetype + '|' + opCode + '|' + port + '|' + spCode"/>" onclick="checkOne()">
								</td>
								<td>
									<input type="hidden" class="infoHid" key="billcycle" value="<s:property value="billcycle"/>" show="<s:property value="billcycle"/>" selector="data_billcycle"/>
									<span class="showSpan">
										<s:property value="billcycle"/>
									</span>
								</td>
								<td>
									<input type="hidden" class="infoHid" key="filetype" value="<s:property value="filetype"/>" show="<s:property value="filetype"/>" selector="data_filetype"/>
									<span class="showSpan">
										<s:property value="filetype"/>
									</span>
								</td>
								<td>
									<input type="hidden" class="infoHid" key="spCode" value="<s:property value="spCode"/>" show="<s:property value="spCode"/>" selector="data_spCode"/>
									<span class="showSpan">
										<s:property value="spCode"/>
									</span>
								</td>
								<td>
									<input type="hidden" class="infoHid" key="opCode" value="<s:property value="opCode"/>" show="<s:property value="opCode"/>" selector="data_opCode"/>
									<span class="showSpan">
										<s:property value="opCode"/>
									</span>
								</td>
								<td>
									<input type="hidden" class="infoHid" key="port" value="<s:property value="port"/>" show="<s:property value="port"/>" selector="data_port"/>
									<span class="showSpan">
										<s:property value="port"/>
									</span>
								</td>
								<td>
									<input type="hidden" class="infoHid" key="chargingtype" value="<s:property value="chargingtype"/>" show="<s:property value="chargingtype"/>" selector="data_chargingtype"/>
									<span class="showSpan">
										<s:property value="chargingtype"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="fee" value="<s:property value="fee"/>" show="<s:property value="fee"/>" selector="data_fee" showFlag="0"/>
									<span class="showSpan">
										<s:property value="fee"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="acctitemIdlv1" value="<s:property value="acctitemIdlv1"/>" show="<s:property value="acctitemIdlv1"/>" selector="data_acctitemIdlv1" showFlag="0"/>
									<span class="showSpan">
										<s:property value="acctitemIdlv1"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="acctitemIdlv2" value="<s:property value="acctitemIdlv2"/>" show="<s:property value="acctitemIdlv2"/>" selector="data_acctitemIdlv2" showFlag="0"/>
									<span class="showSpan">
										<s:property value="acctitemIdlv2"/>
									</span>
								</td>
							</tr>
						</s:iterator>
					</table>
				</div>
			</aa:zone>
		</s:form>
	</body>
</html>
