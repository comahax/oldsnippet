<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/inc/listhead.inc" %>
<html>
	<head>
	    <title><s:text name="titleList"/></title>
	</head>
	
	<body>
		<%@ include file="/common/dialog.jsp"%>
		<s:form action="waystoreinfolog_list.do" name="formList" id="formList" theme="simple">
			<aa:zone name="hiddenZone">
			    <s:hidden name="param._orderby"/>
			    <s:hidden name="param._desc"/>
			    <s:hidden name="param._pageno"/>
			    <s:hidden name="param._pagesize"/>
			    <s:hidden name="param.queryAll"/>
			    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
			    <input type="hidden" id="maxRowCount" value="10"/><!--change it if you need-->
			    <input type="hidden" name="ajaxFlag" id="ajaxFlag"/>
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
					<s:actionmessage/>
				</div>
		    </aa:zone>
		
		    <table id="paramTable" class="content_table">
		        <tr>
		            <td class="content_table_td_left"><s:text name="logid"/>:</td>
		            <td class="content_table_td_right">
		                <s:textfield cssClass="form_text" name="param._ne_logid" />
		            </td>
		            <td class="content_table_td_left"><s:text name="optime"/>:</td>
		            <td class="content_table_td_right">
		                <s:textfield cssClass="form_text" name="param._dnm_optime" />
		            </td>
		            <td class="content_table_td_left"><s:text name="optime"/>:</td>
		            <td class="content_table_td_right">
		                <s:textfield cssClass="form_text" name="param._dnl_optime" />
		            </td>
		            <td class="content_table_td_left"><s:text name="oprtype"/>:</td>
		            <td class="content_table_td_right">
		                <s:textfield cssClass="form_text" name="param._se_oprtype" />
		            </td>
		            <td class="content_table_td_left"><s:text name="success"/>:</td>
		            <td class="content_table_td_right">
		                <s:textfield cssClass="form_text" name="param._se_success" />
		            </td>
		            <td class="content_table_td_left"><s:text name="wayid"/>:</td>
		            <td class="content_table_td_right">
		                <s:textfield cssClass="form_text" name="param._se_wayid" />
		            </td>
		            <td class="content_table_td_left"><s:text name="cityid"/>:</td>
		            <td class="content_table_td_right">
		                <s:textfield cssClass="form_text" name="param._se_cityid" />
		            </td>
		            <td class="content_table_td_left"><s:text name="zqtype"/>:</td>
		            <td class="content_table_td_right">
		                <s:textfield cssClass="form_text" name="param._ne_zqtype" />
		            </td>
		            <td class="content_table_td_left"><s:text name="doortype"/>:</td>
		            <td class="content_table_td_right">
		                <s:textfield cssClass="form_text" name="param._ne_doortype" />
		            </td>
		            <td class="content_table_td_left"><s:text name="createtime"/>:</td>
		            <td class="content_table_td_right">
		                <s:textfield cssClass="form_text" name="param._dnm_createtime" />
		            </td>
		            <td class="content_table_td_left"><s:text name="createtime"/>:</td>
		            <td class="content_table_td_right">
		                <s:textfield cssClass="form_text" name="param._dnl_createtime" />
		            </td>
		        </tr>
		    </table>
		    
			<div class="title_center_div">
				<s:i18n name="public">
					<input type="button" class="form_button" value="<s:text name="button_search"/>"
						onclick="doQuery('/channel/waystoreinfolog_list.do')">
					<input type="button" class="form_button" value="<s:text name="button_new"/>"
						onclick="doNew('/channel/waystoreinfolog_new.do')">
					<input type="button" class="form_button" value="<s:text name="button_delete"/>"
						onclick="doDelete('/channel/waystoreinfolog_delete.do')">
				</s:i18n>
			</div>
		
			<aa:zone name="listZone">
				<div id="headDiv" class="list_head_div">
					<table id="headTable" class="list_head_table" cellpadding="0" cellspacing="0">
			            <tr>
			               	<s:i18n name="public">
				                <td class="ckboxTd" title="<s:text name="list_title_select"/>">
				                    <input type="checkbox" name="allbox" onclick="checkAll()"/>
				                </td>
			                </s:i18n>
			                <td>
			                    <j:orderByImg href="javascript:doOrderby('logid')"><s:text name="logid"/></j:orderByImg>
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
			            <s:iterator value="dp.datas">
			                 <tr>
			                     <td class="ckboxTd">
			                         <input type="checkbox" name="param._selectitem" class="ckbox" value="<s:property value="logid"/>" onclick="checkOne()">
			                     </td>
			                     <td><a href='<s:url action="waystoreinfolog_edit.do">
				                         <s:param name="param._pk" value="logid"/>
				                     	</s:url>'>
										<s:property value="logid"/>
			                         </a>
								 </td>
			                     <td><s:property value="oprcode" /></td>
			                     <td><s:property value="optime" /></td>
			                     <td><s:property value="oprtype" /></td>
			                     <td><s:property value="success" /></td>
			                     <td><s:property value="wayid" /></td>
			                     <td><s:property value="area" /></td>
			                     <td><s:property value="cityid" /></td>
			                     <td><s:property value="zqtype" /></td>
			                     <td><s:property value="zqpic" /></td>
			                     <td><s:property value="zqarea" /></td>
			                     <td><s:property value="zqpanel" /></td>
			                     <td><s:property value="zqcupboard" /></td>
			                     <td><s:property value="zqcards" /></td>
			                     <td><s:property value="zqpricetag" /></td>
			                     <td><s:property value="zqrack" /></td>
			                     <td><s:property value="zqinad" /></td>
			                     <td><s:property value="zqoutad" /></td>
			                     <td><s:property value="zqhead" /></td>
			                     <td><s:property value="zqpaste" /></td>
			                     <td><s:property value="zqtablecard" /></td>
			                     <td><s:property value="zqdecca" /></td>
			                     <td><s:property value="zqbill" /></td>
			                     <td><s:property value="doorpic" /></td>
			                     <td><s:property value="doortype" /></td>
			                     <td><s:property value="outwallad" /></td>
			                     <td><s:property value="outwallpic" /></td>
			                     <td><s:property value="tdmonopoly" /></td>
			                     <td><s:property value="busimonopoly" /></td>
			                     <td><s:property value="storeconduct" /></td>
			                     <td><s:property value="modulus" /></td>
			                     <td><s:property value="unit" /></td>
			                     <td><s:property value="createtime" /></td>
			                 </tr>
			             </s:iterator>
		        	</table>
		        </div>
				<%@ include file="/common/pageNav.jsp"%>
		    </aa:zone>
		</s:form>
	</body>
</html>

