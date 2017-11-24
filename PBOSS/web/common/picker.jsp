<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib prefix="j" uri="/jop-tags"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<base target="_self">
	<head>
		<title>��ѡ��</title>
		<script language="JavaScript" type="text/JavaScript">  
    	function selectCode(code,name) {
    	    var a = new Array(2);
    	    a[0] =code; 
    	    a[1] =name;
    	    
    		window.returnValue = a; 
			window.close();
    	}
    </script>
<style>
.table_style_content {
	
}
.table_style_content td {
	border-right:#FFFFFF inset 2px;
	border-bottom-width: 1px;
	border-bottom-style: solid;
	border-bottom-color: #D7D7D7;
	font-family: "����";
	font-size: 12px;
	font-weight: normal;
	font-color: #666666;
	height: 24px;
	vertical-align: middle;
	<!--text-align:center;-->
	padding:0px 8px 0px 8px;
	word-break:break-all;
	white-space:nowrap;
}
</style>
	</head>

	<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
		<s:form key="formList" cssStyle="formList" theme="simple">
			<%
			//����Ŀؼ���Action�ṩ���ݣ�������ҳ
			%>
			<s:hidden name="param._orderby" />
			<s:hidden name="param._desc" />
			<s:hidden name="param._pageno" />
			<s:hidden name="param._pagesize" />
			<s:hidden name="param._queryexpress" />
			<s:hidden name="sqlName" />
			<s:hidden name="mapParam" />
			
			<s:hidden name="definition" key="definition" />
			<s:hidden name="condition" key="condition" />
			<!-- textfield name="condition" key="condition"/ -->
			<s:hidden name="dbFlag" key="dbFlag" />

			<input type="hidden" name="_rowcount"
				value="<s:property value="dp.rowCount" />" />

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
						<td height="20" align="right" class="form_table_right">
							����:
						</td>
						<td class="form_table_left">
							<s:textfield name="code" cssStyle="style_input"/>
						</td>
						<td height="20" align="right" class="form_table_right">
							����:
						</td>
						<td class="form_table_left">
							<s:textfield name="name" cssStyle="style_input"/>
						</td>
					</tr>
				</table>
			</div>

			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td align=right>
							<s:i18n name="public">
								<input type="submit" id="btnQuery" class="button_Query"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<s:text name="button_search"/>" onClick="doQuery();">
							</s:i18n>

						</td>
					</tr>
				</table>
			</div>
			
		

			<aa:zone name="listZone">
				<div class="table_div">
					<div class="table_LongTable1">
						<table class="table_style">
							<tr class="table_style_head">
								<td aligh="center">
									����
								</td>
								<td align="center">
									����
								</td>
							</tr>
							<tr class="table_style_content" align="center"
							onMouseMove="this.bgColor='F0F5F9'"
									onMouseOut="this.bgColor='#ffffff'">
								<td>
									<a href="javascript:selectCode( '' ,'');"> ��ֵ </a>
								</td>
								<td>
									&nbsp;
								</td>
							</tr>
							<s:iterator value="dp.datas">
								<tr class="table_style_content" align="center"
									onMouseMove="this.bgColor='F0F5F9'"
									onMouseOut="this.bgColor='#ffffff'">
									<td>
										<a
											href="javascript:selectCode('<s:property value="code"/>','<s:property value="name"/>');">
											<s:property value="code" /> </a>
									</td>
									<td>
										<s:property value="name" />
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



<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		//�ж��߼�,���ݰ�ť����url���ж�Ҫˢ���ĸ�zone
		return "errorZone,listZone";  //����zon id��
	}
</script>
		<script language="javascript">
	/*���ñ��ύͨ��ajax����*/
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  

	/*������Щ��ť��Ҫʹ��ajaxЧ��,����ťID */
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery");
</script>

	</body>
</html>
