<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
	String ID_1 = "00010701";
	String ID_2 = "00010702";
	String ID_3 = "00010703";
	String ID_4 = "00010704";
%>
<html>
	<head>
		<title><bean:message bundle="vchpwoperation" key="titleList" />
		</title>
		<script type="text/javascript"
			src="<%=contextPath%>/js/jquery/jquery-1.3.2.js"></script>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_opnid', '<bean:message bundle="vchpwoperation" key="opnid"/>', 'c', 'false', '18');
            addfield('_se_name', '<bean:message bundle="vchpwoperation" key="name"/>', 'c', 'false', '50');
            addfield('_se_opnid2', '<bean:message bundle="vchpwoperation" key="opnid2"/>', 'c', 'false', '18');
            addfield('_se_opnid5', '<bean:message bundle="vchpwoperation" key="opnid5"/>', 'c', 'false', '18');
            addfield('_dnm_startdate', '<bean:message bundle="vchpwoperation" key="startdate"/>', 't', 'false', '7');
            addfield('_dnl_startdate', '<bean:message bundle="vchpwoperation" key="startdate"/>', 't', 'false', '7');
            addfield('_dnm_enddate', '<bean:message bundle="vchpwoperation" key="enddate"/>', 't', 'false', '7');
            addfield('_dnl_enddate', '<bean:message bundle="vchpwoperation" key="enddate"/>', 't', 'false', '7');
            addfield('_se_busibelong', '<bean:message bundle="vchpwoperation" key="busibelong"/>', 'c', 'false', '32');
            return checkval(window);
        }
        
        function doExcel() {  
           if(ev_check()){ 
           formList.action = contextPath+'/cms/vchpwoperation.do?CMD=EXCEL';
       	   formList.submit();
       	   formList.action = "<%=contextPath%>/cms/vchpwoperation.do?CMD=LIST";
       	   }
        }
        
        function doLoadSub(value){//AJAX请求获取二级业务编码业务小类
			var success = function(data){//AJAX请求处理成功后回调函数
				if(data!=null && data!=''){
					var htmlstr = '';
					var opnArray = data.split(',');
					for(var i=0; i<opnArray.length; i++){
						var opn_name = opnArray[i].split(':');
						var opnid = opn_name[0];
						var name = opn_name[1];
						htmlstr += '<option value="'+opnid+'">'+name+'</option>'
					}
					jQuery('#_se_opnid2').append(htmlstr);
				}	
			};
			jQuery('#_se_opnid2').empty().append('<option/>');
			var url = contextPath + '/cms/dcord.do?CMD=LOADSUB';
			if(value!=null && value!=''){
				jQuery.post(url, {'upperopnid':value}, success, "text");
			}
		}
		  		function doQuery(){
			var html = jQuery('#_se_opnid2').html();
			jQuery('#_subopnids').val(html);
			resetPage();
			if(document.formList.onsubmit == null || document.formList.onsubmit()){
				document.formList.submit();
			}
		}
		
		
		
				jQuery(document).ready(function(){
			var html = jQuery('#_subopnids').val();
			if(html!=null && html!=''){
				jQuery('#_se_opnid2').empty();
				jQuery('#_se_opnid2').append(html);
			}
		});	
        
        
        	 function getOpnId() {
			var arg = new Array();
			var strUrl ="<%=contextPath%>/cms/bbc/operation.do?CMD=SELECT";
			return window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
		}
        
        
    </script>
	</head>

	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/vchpwoperation.do?CMD=LIST"
				styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="_subopnids" styleId="_subopnids" />
				<input type="hidden" name="_rowcount"
					value="<c:out value='${requestScope.LIST.rowCount}' />">
				<c:set var="form" scope="request"
					value="${requestScope['/cms/vchpwoperation/VchpwoperationForm']}" />

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="vchpwoperation" key="titleList" />
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table width="100%" class="error_text">
						<html:errors />
						<s:Msg />
					</table>
				</div>
				<div class="table_div">
					<table class="form_table">
						<tr>
							<td width="20%" height="20" align="right"
								class="form_table_right">
								业务编码:
							</td>
							<td width="30%" class="form_table_left">
								<html:text property="_se_opnid5" styleClass="form_input_1x" />
								<input type="button" value="..." class="clickbutton"
									onclick="_se_opnid5.value=getOpnId();">
							</td>
							<td width="20%" height="20" align="right"
								class="form_table_right">
								业务名称:
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="_sk_name5"></html:text>
							</td>
						</tr>
						<tr>
							<td width="20%" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="vchpwoperation" key="opnid2" />
								:
							</td>
							<td width="30%" class="form_table_left"> 
								 
                              <html:select property="_se_opnid" onchange="doLoadSub(this.value);">
                    	<option />
                    	<s:Options definition="#OPERATION" condition="opnlevel:1"/>
                    </html:select>
								
							</td>
							<td width="20%" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="vchpwoperation" key="opnid5" />
								:
							</td>
							<td width="30%" class="form_table_left"> 
								   <html:select property="_se_opnid2" styleId="_se_opnid2">
                    	<option />
                    </html:select>
							</td>
						</tr>
						<tr>
							<td width="20%" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="vchpwoperation" key="startdate" />
								>=:
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnl_startdate"
									onclick="this.value=selectDate();"></html:text>
							</td>
							<td width="20%" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="vchpwoperation" key="startdate" />
								<=:
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnm_startdate"
									onclick="this.value=selectDate();"></html:text>
							</td>
						</tr>
						<tr>
							<td width="20%" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="vchpwoperation" key="enddate" />
								>=:
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnl_enddate"
									onclick="this.value=selectDate();"></html:text>
							</td>
							<td width="20%" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="vchpwoperation" key="enddate" />
								<=:
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnm_enddate"
									onclick="this.value=selectDate();"></html:text>
							</td>
						</tr>
						<tr>
							<td width="20%" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="vchpwoperation" key="busibelong" />
								:
							</td>
							<td width="30%" class="form_table_left">
								<html:select property="_se_busibelong">
									<option />
										<s:Options definition="$CH_CBBUSIBELONG" />
								</html:select>
							</td>
							<td width="30%" class="form_table_left" colspan="2">
								&nbsp;
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>

								<input type="button" class="query"
									onmouseover="buttonover(this);" onclick="doQuery();"
									onmouseout="buttonout(this);" onfocus="buttonover(this)"
									onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_search"/>" />
								<input type="button" class="button_4"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="导出EXCEL" onclick="doExcel()" />
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">
							<tr class="table_style_head">
								<td>
									<a href="javascript:doOrderby('opnid')"><bean:message
											bundle="vchpwoperation" key="opnid" />
									</a>
									<s:OrderImg form="/cms/vchpwoperation/VchpwoperationForm"
										field="opnid" />
								</td>
								<td>
									<a href="javascript:doOrderby('name')"><bean:message
											bundle="vchpwoperation" key="name" />
									</a>
									<s:OrderImg form="/cms/vchpwoperation/VchpwoperationForm"
										field="name" />
								</td>
								<td>
									<a href="javascript:doOrderby('opnid2')"><bean:message
											bundle="vchpwoperation" key="opnid2" />
									</a>
									<s:OrderImg form="/cms/vchpwoperation/VchpwoperationForm"
										field="opnid2" />
								</td>
								<td>
									<a href="javascript:doOrderby('opnid5')"><bean:message
											bundle="vchpwoperation" key="opnid5" />
									</a>
									<s:OrderImg form="/cms/vchpwoperation/VchpwoperationForm"
										field="opnid5" />
								</td>
								<td>
									<a href="javascript:doOrderby('startdate')"><bean:message
											bundle="vchpwoperation" key="startdate" />
									</a>
									<s:OrderImg form="/cms/vchpwoperation/VchpwoperationForm"
										field="startdate" />
								</td>
								<td>
									<a href="javascript:doOrderby('enddate')"><bean:message
											bundle="vchpwoperation" key="enddate" />
									</a>
									<s:OrderImg form="/cms/vchpwoperation/VchpwoperationForm"
										field="enddate" />
								</td>
								<td>
									<a href="javascript:doOrderby('busibelong')"><bean:message
											bundle="vchpwoperation" key="busibelong" />
									</a>
									<s:OrderImg form="/cms/vchpwoperation/VchpwoperationForm"
										field="busibelong" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<tr class="table_style_content" align="center" onMouseMove="this.bgColor='#99FFCC'" onMouseOut="this.bgColor='#ffffff'">
									<td>
										<c:out value="${item.opnid5}" />
									</td>
									<td>
										<c:out value="${item.name5}" />
									</td>
									<td>
										<s:Code2Name code="${item.opnid}" definition="#OPERATION" ></s:Code2Name>
									</td>
									<td>
										<c:out value="${item.name2}" />
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd" value="${item.startdate}" />
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd" value="${item.enddate}" />
									</td>
									<td>
										<s:Code2Name code="${item.busibelong}"
											definition="$CH_CBBUSIBELONG" />
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>

				<div class="table_div">
					<s:PageNav dpName="LIST" />
				</div>
			</html:form>
		</div>
	</body>
</html>
