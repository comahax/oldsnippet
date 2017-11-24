<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/inc/listhead.inc" %>
<html>
	<head>
	    <title><s:text name="titleList"/></title>
	</head>
	
	<body>
		<s:form action="paymentlog_list.do" name="formList" id="formList" theme="simple">
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
						<s:text name="reward" />>
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
		            <td class="content_table_td_left"><s:text name="optime"/>:</td>
		            <td class="content_table_td_right">
		                <s:textfield cssClass="form_text" name="param._dnm_optime" />
		            </td>
		            <td class="content_table_td_left"><s:text name="optime"/>:</td>
		            <td class="content_table_td_right">
		                <s:textfield cssClass="form_text" name="param._dnl_optime" />
		            </td>
		            <td class="content_table_td_left"><s:text name="oprcode"/>:</td>
		            <td class="content_table_td_right">
		                <s:textfield cssClass="form_text" name="param._se_oprcode" />
		            </td>
		            <td class="content_table_td_left"><s:text name="oprtype"/>:</td>
		            <td class="content_table_td_right">
		                <s:textfield cssClass="form_text" name="param._se_oprtype" />
		            </td>
		            <td class="content_table_td_left"><s:text name="optype"/>:</td>
		            <td class="content_table_td_right">
		                <s:textfield cssClass="form_text" name="param._se_optype" />
		            </td>
		            <td class="content_table_td_left"><s:text name="opmonth"/>:</td>
		            <td class="content_table_td_right">
		                <s:textfield cssClass="form_text" name="param._snm_opmonth" />
		            </td>
		            <td class="content_table_td_left"><s:text name="opmonth"/>:</td>
		            <td class="content_table_td_right">
		                <s:textfield cssClass="form_text" name="param._snl_opmonth" />
		            </td>
		            <td class="content_table_td_left"><s:text name="paymonth"/>:</td>
		            <td class="content_table_td_right">
		                <s:textfield cssClass="form_text" name="param._snm_paymonth" />
		            </td>
		            <td class="content_table_td_left"><s:text name="paymonth"/>:</td>
		            <td class="content_table_td_right">
		                <s:textfield cssClass="form_text" name="param._snl_paymonth" />
		            </td>
		        </tr>
		    </table>
		    
			<div class="title_center_div">
				<s:i18n name="public">
					<input type="button" class="form_button" value="<s:text name="button_search"/>"
						onclick="doQuery('/reward/paymentlog_list.do')">
					<input type="button" class="form_button" value="<s:text name="button_new"/>"
						onclick="doNew('/reward/paymentlog_new.do')">
					<input type="button" class="form_button" value="<s:text name="button_delete"/>"
						onclick="doDelete('/reward/paymentlog_delete.do')">
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
			                    <s:text name="optime" />
			                </td>
			                <td>
			                    <s:text name="oprcode" />
			                </td>
			                <td>
			                    <s:text name="oprtype" />
			                </td>
			                <td>
			                    <s:text name="success" />
			                </td>
			                <td>
			                    <s:text name="optype" />
			                </td>
			                <td>
			                    <s:text name="opmonth" />
			                </td>
			                <td>
			                    <s:text name="paymonth" />
			                </td>
			                <td>
			                    <s:text name="stype" />
			                </td>
			                <td>
			                    <s:text name="payee" />
			                </td>
			                <td>
			                    <s:text name="paysum" />
			                </td>
			                <td>
			                    <s:text name="rewardstd" />
			                </td>
			                <td>
			                    <s:text name="rule" />
			                </td>
			                <td>
			                    <s:text name="deduction" />
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
			                     <td><a href='<s:url action="paymentlog_edit.do">
				                         <s:param name="param._pk" value="logid"/>
				                     	</s:url>'>
										<s:property value="logid"/>
			                         </a>
								 </td>
			                     <td><s:property value="optime" /></td>
			                     <td><s:property value="oprcode" /></td>
			                     <td><s:property value="oprtype" /></td>
			                     <td><s:property value="success" /></td>
			                     <td><s:property value="optype" /></td>
			                     <td><s:property value="opmonth" /></td>
			                     <td><s:property value="paymonth" /></td>
			                     <td><s:property value="stype" /></td>
			                     <td><s:property value="payee" /></td>
			                     <td><s:property value="paysum" /></td>
			                     <td><s:property value="rewardstd" /></td>
			                     <td><s:property value="rule" /></td>
			                     <td><s:property value="deduction" /></td>
			                 </tr>
			             </s:iterator>
		        	</table>
		        </div>
				<%@ include file="/common/pageNav.jsp"%>
		    </aa:zone>
		</s:form>
	</body>
</html>

