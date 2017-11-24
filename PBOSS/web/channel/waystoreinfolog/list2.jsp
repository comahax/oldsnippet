<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/inc/listhead2.inc"%>
<html>
	<head>
		<title><s:text name="titleList" />
		</title>
	</head>

	<body>
		<%@ include file="/common/dialog.jsp"%>
		<s:form action="waystoreinfolog_list.do" name="formList" id="formList" theme="simple">
			<div id="paramListDiv" style="display:none">
			</div>
			
			<table id="dataTable" style="display:none">
				<tr id="dataTr">
					<td class="ckboxTd" dataTdWidth="40">
						<input type="checkbox"  name="_selectitem" class="ckbox"
							value="<s:property value="logid"/>" onclick="checkOne()">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="logid" id="data_logid" class="form_text" maxlength="14" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="logid"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="oprcode" id="data_oprcode" class="form_text" maxlength="15" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="oprcode"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="optime" id="data_optime" class="form_text" maxlength="7" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="optime"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="oprtype" id="data_oprtype" class="form_text" maxlength="8" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="oprtype"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="success" id="data_success" class="form_text" maxlength="8" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="success"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="wayid" id="data_wayid" class="form_text" maxlength="18" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="wayid"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="area" id="data_area" class="form_text" maxlength="14" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="area"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="cityid" id="data_cityid" class="form_text" maxlength="14" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="cityid"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="zqtype" id="data_zqtype" class="form_text" maxlength="2" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="zqtype"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="zqpic" id="data_zqpic" class="form_text" maxlength="225" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="zqpic"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="zqarea" id="data_zqarea" class="form_text" maxlength="14" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="zqarea"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="zqpanel" id="data_zqpanel" class="form_text" maxlength="2" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="zqpanel"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="zqcupboard" id="data_zqcupboard" class="form_text" maxlength="4" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="zqcupboard"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="zqcards" id="data_zqcards" class="form_text" maxlength="4" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="zqcards"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="zqpricetag" id="data_zqpricetag" class="form_text" maxlength="4" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="zqpricetag"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="zqrack" id="data_zqrack" class="form_text" maxlength="4" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="zqrack"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="zqinad" id="data_zqinad" class="form_text" maxlength="2" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="zqinad"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="zqoutad" id="data_zqoutad" class="form_text" maxlength="2" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="zqoutad"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="zqhead" id="data_zqhead" class="form_text" maxlength="2" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="zqhead"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="zqpaste" id="data_zqpaste" class="form_text" maxlength="2" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="zqpaste"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="zqtablecard" id="data_zqtablecard" class="form_text" maxlength="4" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="zqtablecard"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="zqdecca" id="data_zqdecca" class="form_text" maxlength="4" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="zqdecca"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="zqbill" id="data_zqbill" class="form_text" maxlength="4" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="zqbill"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="doorpic" id="data_doorpic" class="form_text" maxlength="225" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="doorpic"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="doortype" id="data_doortype" class="form_text" maxlength="2" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="doortype"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="outwallad" id="data_outwallad" class="form_text" maxlength="14" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="outwallad"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="outwallpic" id="data_outwallpic" class="form_text" maxlength="2" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="outwallpic"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="tdmonopoly" id="data_tdmonopoly" class="form_text" maxlength="2" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="tdmonopoly"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="busimonopoly" id="data_busimonopoly" class="form_text" maxlength="2" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="busimonopoly"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="storeconduct" id="data_storeconduct" class="form_text" maxlength="4" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="storeconduct"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="modulus" id="data_modulus" class="form_text" maxlength="4" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="modulus"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="unit" id="data_unit" class="form_text" maxlength="2" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="unit"/>">
					</td>
					<td dataTdWidth="150"><!-- change dataTdWidth if you need -->
						<input name="createtime" id="data_createtime" class="form_text" maxlength="7" disabled="true">
						<input type="hidden" name="msg" class="msg" value="<s:text name="createtime"/>">
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
				<input type="hidden" name="checkUrl" id="checkUrl" value="/channel/waystoreinfolog_check.do"/>
				<input type="hidden" name="saveUrl" id="saveUrl" value="/channel/waystoreinfolog_saveAll.do"/>
			</aa:zone>

			<div class="title_div">
				<div class="title_left_div">
					<s:i18n name="public">
						<s:text name="currentPos" />>
						<s:text name="channel" />>
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
						<s:text name="logid" />:
					</lable>
					<s:textfield cssClass="form_text searchParam" name="param._ne_logid" />
					<lable>
						<s:text name="optime" />:
					</lable>
					<s:textfield cssClass="form_text searchParam" name="param._dnm_optime" />
					<lable>
						<s:text name="optime" />:
					</lable>
					<s:textfield cssClass="form_text searchParam" name="param._dnl_optime" />
					<lable>
						<s:text name="oprtype" />:
					</lable>
					<s:textfield cssClass="form_text searchParam" name="param._se_oprtype" />
					<lable>
						<s:text name="success" />:
					</lable>
					<s:textfield cssClass="form_text searchParam" name="param._se_success" />
					<lable>
						<s:text name="wayid" />:
					</lable>
					<s:textfield cssClass="form_text searchParam" name="param._se_wayid" />
					<lable>
						<s:text name="cityid" />:
					</lable>
					<s:textfield cssClass="form_text searchParam" name="param._se_cityid" />
					<lable>
						<s:text name="zqtype" />:
					</lable>
					<s:textfield cssClass="form_text searchParam" name="param._ne_zqtype" />
					<lable>
						<s:text name="doortype" />:
					</lable>
					<s:textfield cssClass="form_text searchParam" name="param._ne_doortype" />
					<lable>
						<s:text name="createtime" />:
					</lable>
					<s:textfield cssClass="form_text searchParam" name="param._dnm_createtime" />
					<lable>
						<s:text name="createtime" />:
					</lable>
					<s:textfield cssClass="form_text searchParam" name="param._dnl_createtime" />
					<s:i18n name="public">
						<input type="button" class="form_button" value="<s:text name="button_search"/>" 
							onclick="doQuery('/channel/waystoreinfolog_list.do')">
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
								<j:orderByImg href="javascript:doOrderby('logid')">
									<s:text name="logid" />
								</j:orderByImg>
							</td>
							<td>
								<s:text name="oprcode" />
							</td>
							<td>
								<s:text name="optime" />
							</td>
							<td>
								<s:text name="oprtype" />
							</td>
							<td>
								<s:text name="success" />
							</td>
							<td>
								<s:text name="wayid" />
							</td>
							<td>
								<s:text name="area" />
							</td>
							<td>
								<s:text name="cityid" />
							</td>
							<td>
								<s:text name="zqtype" />
							</td>
							<td>
								<s:text name="zqpic" />
							</td>
							<td>
								<s:text name="zqarea" />
							</td>
							<td>
								<s:text name="zqpanel" />
							</td>
							<td>
								<s:text name="zqcupboard" />
							</td>
							<td>
								<s:text name="zqcards" />
							</td>
							<td>
								<s:text name="zqpricetag" />
							</td>
							<td>
								<s:text name="zqrack" />
							</td>
							<td>
								<s:text name="zqinad" />
							</td>
							<td>
								<s:text name="zqoutad" />
							</td>
							<td>
								<s:text name="zqhead" />
							</td>
							<td>
								<s:text name="zqpaste" />
							</td>
							<td>
								<s:text name="zqtablecard" />
							</td>
							<td>
								<s:text name="zqdecca" />
							</td>
							<td>
								<s:text name="zqbill" />
							</td>
							<td>
								<s:text name="doorpic" />
							</td>
							<td>
								<s:text name="doortype" />
							</td>
							<td>
								<s:text name="outwallad" />
							</td>
							<td>
								<s:text name="outwallpic" />
							</td>
							<td>
								<s:text name="tdmonopoly" />
							</td>
							<td>
								<s:text name="busimonopoly" />
							</td>
							<td>
								<s:text name="storeconduct" />
							</td>
							<td>
								<s:text name="modulus" />
							</td>
							<td>
								<s:text name="unit" />
							</td>
							<td>
								<s:text name="createtime" />
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
										value="<s:property value="logid"/>" onclick="checkOne()">
								</td>
								<td>
									<input type="hidden" class="infoHid" key="logid" value="<s:property value="logid"/>" show="<s:property value="logid"/>" selector="data_logid"/>
									<span class="showSpan">
										<s:property value="logid"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="oprcode" value="<s:property value="oprcode"/>" show="<s:property value="oprcode"/>" selector="data_oprcode" showFlag="0"/>
									<span class="showSpan">
										<s:property value="oprcode"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="optime" value="<s:property value="optime"/>" show="<s:property value="optime"/>" selector="data_optime" showFlag="0"/>
									<span class="showSpan">
										<s:property value="optime"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="oprtype" value="<s:property value="oprtype"/>" show="<s:property value="oprtype"/>" selector="data_oprtype" showFlag="0"/>
									<span class="showSpan">
										<s:property value="oprtype"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="success" value="<s:property value="success"/>" show="<s:property value="success"/>" selector="data_success" showFlag="0"/>
									<span class="showSpan">
										<s:property value="success"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="wayid" value="<s:property value="wayid"/>" show="<s:property value="wayid"/>" selector="data_wayid" showFlag="0"/>
									<span class="showSpan">
										<s:property value="wayid"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="area" value="<s:property value="area"/>" show="<s:property value="area"/>" selector="data_area" showFlag="0"/>
									<span class="showSpan">
										<s:property value="area"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="cityid" value="<s:property value="cityid"/>" show="<s:property value="cityid"/>" selector="data_cityid" showFlag="0"/>
									<span class="showSpan">
										<s:property value="cityid"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="zqtype" value="<s:property value="zqtype"/>" show="<s:property value="zqtype"/>" selector="data_zqtype" showFlag="0"/>
									<span class="showSpan">
										<s:property value="zqtype"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="zqpic" value="<s:property value="zqpic"/>" show="<s:property value="zqpic"/>" selector="data_zqpic" showFlag="0"/>
									<span class="showSpan">
										<s:property value="zqpic"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="zqarea" value="<s:property value="zqarea"/>" show="<s:property value="zqarea"/>" selector="data_zqarea" showFlag="0"/>
									<span class="showSpan">
										<s:property value="zqarea"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="zqpanel" value="<s:property value="zqpanel"/>" show="<s:property value="zqpanel"/>" selector="data_zqpanel" showFlag="0"/>
									<span class="showSpan">
										<s:property value="zqpanel"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="zqcupboard" value="<s:property value="zqcupboard"/>" show="<s:property value="zqcupboard"/>" selector="data_zqcupboard" showFlag="0"/>
									<span class="showSpan">
										<s:property value="zqcupboard"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="zqcards" value="<s:property value="zqcards"/>" show="<s:property value="zqcards"/>" selector="data_zqcards" showFlag="0"/>
									<span class="showSpan">
										<s:property value="zqcards"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="zqpricetag" value="<s:property value="zqpricetag"/>" show="<s:property value="zqpricetag"/>" selector="data_zqpricetag" showFlag="0"/>
									<span class="showSpan">
										<s:property value="zqpricetag"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="zqrack" value="<s:property value="zqrack"/>" show="<s:property value="zqrack"/>" selector="data_zqrack" showFlag="0"/>
									<span class="showSpan">
										<s:property value="zqrack"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="zqinad" value="<s:property value="zqinad"/>" show="<s:property value="zqinad"/>" selector="data_zqinad" showFlag="0"/>
									<span class="showSpan">
										<s:property value="zqinad"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="zqoutad" value="<s:property value="zqoutad"/>" show="<s:property value="zqoutad"/>" selector="data_zqoutad" showFlag="0"/>
									<span class="showSpan">
										<s:property value="zqoutad"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="zqhead" value="<s:property value="zqhead"/>" show="<s:property value="zqhead"/>" selector="data_zqhead" showFlag="0"/>
									<span class="showSpan">
										<s:property value="zqhead"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="zqpaste" value="<s:property value="zqpaste"/>" show="<s:property value="zqpaste"/>" selector="data_zqpaste" showFlag="0"/>
									<span class="showSpan">
										<s:property value="zqpaste"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="zqtablecard" value="<s:property value="zqtablecard"/>" show="<s:property value="zqtablecard"/>" selector="data_zqtablecard" showFlag="0"/>
									<span class="showSpan">
										<s:property value="zqtablecard"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="zqdecca" value="<s:property value="zqdecca"/>" show="<s:property value="zqdecca"/>" selector="data_zqdecca" showFlag="0"/>
									<span class="showSpan">
										<s:property value="zqdecca"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="zqbill" value="<s:property value="zqbill"/>" show="<s:property value="zqbill"/>" selector="data_zqbill" showFlag="0"/>
									<span class="showSpan">
										<s:property value="zqbill"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="doorpic" value="<s:property value="doorpic"/>" show="<s:property value="doorpic"/>" selector="data_doorpic" showFlag="0"/>
									<span class="showSpan">
										<s:property value="doorpic"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="doortype" value="<s:property value="doortype"/>" show="<s:property value="doortype"/>" selector="data_doortype" showFlag="0"/>
									<span class="showSpan">
										<s:property value="doortype"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="outwallad" value="<s:property value="outwallad"/>" show="<s:property value="outwallad"/>" selector="data_outwallad" showFlag="0"/>
									<span class="showSpan">
										<s:property value="outwallad"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="outwallpic" value="<s:property value="outwallpic"/>" show="<s:property value="outwallpic"/>" selector="data_outwallpic" showFlag="0"/>
									<span class="showSpan">
										<s:property value="outwallpic"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="tdmonopoly" value="<s:property value="tdmonopoly"/>" show="<s:property value="tdmonopoly"/>" selector="data_tdmonopoly" showFlag="0"/>
									<span class="showSpan">
										<s:property value="tdmonopoly"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="busimonopoly" value="<s:property value="busimonopoly"/>" show="<s:property value="busimonopoly"/>" selector="data_busimonopoly" showFlag="0"/>
									<span class="showSpan">
										<s:property value="busimonopoly"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="storeconduct" value="<s:property value="storeconduct"/>" show="<s:property value="storeconduct"/>" selector="data_storeconduct" showFlag="0"/>
									<span class="showSpan">
										<s:property value="storeconduct"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="modulus" value="<s:property value="modulus"/>" show="<s:property value="modulus"/>" selector="data_modulus" showFlag="0"/>
									<span class="showSpan">
										<s:property value="modulus"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="unit" value="<s:property value="unit"/>" show="<s:property value="unit"/>" selector="data_unit" showFlag="0"/>
									<span class="showSpan">
										<s:property value="unit"/>
									</span>
								</td>
                 				<td>
									<input type="hidden" class="infoHid" key="createtime" value="<s:property value="createtime"/>" show="<s:property value="createtime"/>" selector="data_createtime" showFlag="0"/>
									<span class="showSpan">
										<s:property value="createtime"/>
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
