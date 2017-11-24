<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="com.sunrise.boss.delegate.cms.way.WayDelegate"%>
<%@ page import="com.sunrise.boss.ui.commons.User"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa"%>
<%
//    head.inc是List.jsp的文件头，声明了JS、CSS等的引用，所有list.jsp必须引用这个文件头
%>
<%@ include file="/inc/listhead.inc"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="2B1A3C" />
</jsp:include>
<%
	String ID_1 = "CH_PW_SALEWAY_QUERY";
	String ID_2 = "CH_PW_SALEWAY_DELETE";
	String ID_3 = "CH_PW_SALEWAY_BATCHIMPORT";
	String ID_4 = "CH_PW_SALEWAY_EXPORT";
	String ID_5 = "CH_PW_SALEWAY_ADD";
	String ID_6 = "CH_PW_SALEWAY_AUDIT";
	String ID_7 = "CH_PW_SALEWAY_BATCHSERVICE";
	String ID_8 = "CH_PW_SALEWAY_SERVICE";
%>
<html>
	<head>
		<title><bean:message bundle="saleway" key="titleList" /></title>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<SCRIPT>
			function doImport(url){
				formList.action = contextPath + url + "?CMD=IMPORT";
          		formList.submit();
			}
			
			function doExport(url){
				formList.action = contextPath + url + "?CMD=EXCEL";
      			formList.submit();
      			formList.action = contextPath + url + "?CMD=LIST";
			}
			
			function doEDIT(){
				formList.action = contextPath + "/cms/saleway/saleway.do?CMD=EDIT";
          		formList.submit();
			}
			function doOpen(wayid){
				formList.action = contextPath + "/cms/saleway/saleway.do?CMD=SETSERVICE&wayid=" + wayid;
				formList.submit();
			}
			function upload(){
				var form=document.forms[0];
				form.action="<%=contextPath%>/cms/saleway/batchopen.jsp";
				form.submit();
			}
			function showWindow()
	    	{
	      		var url='<%=contextPath%>/cms/saleway/select.jsp';
	    		var rtn=window.showModalDialog(url , 1 , "dialogWidth=300px;dialogHeight=550px;status:no;scroll=yes;");
	    		if(rtn=="" || rtn==null)
	    		{
	    		 alert('至少选择一列');
	    		 return false;
	    		}
    		    formList.action = '<%=contextPath%>/cms/saleway/saleway.do?CMD=EXCEL&rtn='+rtn;
    			formList.submit();
     			formList.action="<%=contextPath%>/cms/saleway/saleway.do?CMD=LIST";
	    	}
	    	function doQuery(){
				trimAllSpaces();
				resetPage();
				if(document.formList.onsubmit == null || document.formList.onsubmit())
				document.formList.submit();
			}
			function trimAllSpaces()
			{
				for(var i=0;i<document.forms[0].elements.length;i++)
				{
				  if(formList.elements[i].type=='text')
				  {
				   formList.elements[i].value=trim(formList.elements[i].value);
				  }
				}
			}
		</SCRIPT>
	</head>

	<body>
		<div class="table_container">

			<html:form action="/cms/saleway/saleway.do?CMD=LIST"
				styleId="formList" method="post">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<input type="hidden" name="_rowcount"
					value="<c:out value='${requestScope.LIST.rowCount}' />">

				<!--##################################添加标题内容，里面可以放置按钮##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="saleway" key="titleList" />
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

				<!--#################################添加标题内容，里面可以放置按钮###################################################-->
				<div class="table_div">
					<table class="form_table">
						<tr>
							<td width="100" height="20" align="right"
								class="form_table_right" nowrap>
								<bean:message bundle="saleway" key="wayid" />
								:
							</td>
							<td class="form_table_left">
								<html:text property="_sk_wayid" styleClass="form_input_1x" />
							</td>
							<td width="100" height="20" align="right"
								class="form_table_right" nowrap>
								<bean:message bundle="saleway" key="wayname" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_sk_wayname" />
							</td>
						</tr>
						<tr>
							<td width="100" height="20" align="right"
								class="form_table_right" nowrap>
								<bean:message bundle="saleway" key="cityid" />
								:
							</td>
							<td class="form_table_left">
								<html:text property="_se_cityid" styleClass="form_input_1x" />
								<input type="button" value="..." class="clickbutton"
									name="buttn3"
									onclick="showOrgTree(this,'_se_cityid','Citycom');">
							</td>
							<td width="100" height="20" align="right"
								class="form_table_right" nowrap>
								<bean:message bundle="saleway" key="countyid" />
								:
							</td>
							<td class="form_table_left">
								<html:text property="_se_countyid" styleClass="form_input_1x"></html:text>
								<input type="button" name="button2" class="clickbutton"
									value="..."
									onclick="showOrgTree(this,'_se_countyid','Cntycom');">
							</td>
						</tr>
						<tr>
							<td width="100" height="20" align="right"
								class="form_table_right" nowrap>
								<bean:message bundle="saleway" key="_se_svccode" />
								:
							</td>
							<td class="form_table_left">
								<html:text property="_se_svccode" styleClass="form_input_1x"></html:text>
								<input type="button" name="button1" class="clickbutton"
									value="..." onclick="showOrgTree(this,'_se_svccode','Svc');">
							</td>
							<td width="100" height="20" align="right"
								class="form_table_right" nowrap>
								<bean:message bundle="saleway" key="_se_mareacode" />
								:
							</td>
							<td class="form_table_left">
								<html:text property="_se_mareacode" styleClass="form_input_1x"></html:text>
								<input type="button" name="button" class="clickbutton"
									value="..." onclick="showOrgTree(this,'_se_mareacode','Ma');">
							</td>
						</tr>
						<tr>
							<td width="100" height="20" align="right"
								class="form_table_right" nowrap>
								<bean:message bundle="saleway" key="_se_waysubtype" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_se_waysubtype">
									<option />
										<s:Options definition="#WAYTYPE"
											condition="waytypecode:${'STRB'}" />
										<s:Options definition="#WAYTYPE"
											condition="waytypecode:${'PSAL'}" />
										<s:Options definition="#WAYTYPE"
											condition="waytypecode:${'SAGT'}" />
										<s:Options definition="#WAYTYPE"
											condition="waytypecode:${'FD'}" />	
								</html:select>
							</td>
							<td width="100" height="20" align="right"
								class="form_table_right" nowrap>
								<bean:message bundle="saleway" key="upperwayid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_upperwayid"
									onclick="showSelectWay(this)" />
							</td>
						</tr>
						<tr>
							<td width="100" height="20" align="right"
								class="form_table_right" nowrap>
								<bean:message bundle="saleway" key="starlevel" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_starlevel">
									<option />
									<s:Options definition="$CH_STARLEVEL"/>
								</html:select>
							</td>
							<td width="100" height="20" align="right"
								class="form_table_right" nowrap>
								状态
							</td>
							<td class="form_table_left">
								<html:select property="_ne_waystate">
									<option />
									<s:Options definition="$CH_VALIDFLAG" />
								</html:select>
							</td>
						</tr>
						<tr>
							<td width="100" height="20" align="right"
								class="form_table_right" nowrap>
								<bean:message bundle="Way" key="_se_chainhead" />
								:
							</td>
							<td class="form_table_left">
								<s:WayPicker property="_se_chainhead" waytype="AG" waysubtype='DIS'/>
							</td>
							<td width="100" height="20" align="right"
								class="form_table_right" nowrap>
								&nbsp;
							</td>
							<td class="form_table_left">
								&nbsp;
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<!--按钮的左中右位置分别为 form_table_left、form_table_center、form_table_right-->
								<s:PurChk2 controlid="<%=ID_1%>" disableChild="true">
									<input type="button" class="query" onclick="doQuery();" 
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_search"/>">
								</s:PurChk2>
								<s:PurChk2 controlid="<%=ID_4%>" disableChild="true">
									<input type="button" class="button_6"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="saleway" key="button_exp"/>"
										onClick="showWindow()">
								</s:PurChk2>
								<s:PurChk2 controlid="<%=ID_5%>" disableChild="true">
									<input type="button" name="btnNew" class="add"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_new"/>"
										onClick="doEDIT()">
								</s:PurChk2>
								<s:PurChk2 controlid="<%=ID_3%>" disableChild="true">
									<input type="button" name="btnNew" class="query"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="saleway" key="button_imp"/>"
										onClick="doImport('/cms/saleway/saleway.do')">
								</s:PurChk2>
								<s:PurChk2 controlid="<%=ID_2%>" disableChild="true">
									<input type="button" name="btnDelete" class="delete"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_delete"/>"
										onClick="doDelete('/cms/saleway/saleway.do')">
								</s:PurChk2>
								
								 <input type="reset" class="query"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_reset"/>">

								<s:PurChk2 controlid="<%=ID_7%>" disableChild="true">	
								 <input type="button" class="button_6"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="批量开通" onclick="upload();">
								</s:PurChk2>
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">
							<tr class="table_style_head">
								<td
									title="<bean:message bundle="public" key="list_title_select"/>">
									<input type="checkbox" name="allbox" onclick="checkAll();"
										class="table_checkbox">
								</td>
								<td>
									<bean:message bundle="saleway" key="operation" />
								</td>
								<td nowrap>
									<a href="javascript:doOrderby('wayid')"> <bean:message
											bundle="saleway" key="wayid" /> </a>
									<s:OrderImg form="/cms/way/SalewayForm" field="wayid" />
								</td>
								<td nowrap>
									<a href="javascript:doOrderby('wayname')"> <bean:message
											bundle="saleway" key="wayname" /> </a>
									<s:OrderImg form="/cms/way/SalewayForm" field="wayname" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="officetel" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="openservice" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="isopen" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="waysubtype" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="upperwayid" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="latitude" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="longtitude" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="starlevel" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="pt" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="isstraitprd" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="catetype" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="cityid" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="countyid" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="svccode" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="mareacode" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="adtypecode" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="adacode" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="formtype" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="starttime" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="logiscode" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="waymagcode" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="bchlevel" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="waystate" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="address" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="istietong" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/cms/saleway/saleway.do?CMD=EDIT" var="urlContent">
									<c:param name="PK" value="${item.wayid}" />
								</c:url>
								<tr class="table_style_content" align="center">
									<td>
										<input type="checkbox" name="_selectitem"
											value="<c:out value='${item.wayid}' />" onclick="checkOne();"
											class="table_checkbox">
									</td>
									<td nowrap="nowrap">
										<s:PurChk2 controlid="<%=ID_6%>" disableChild="true">
											<s:WayAudit typename="CH_PW_SALEWAY" pk="${item.wayid}"
												url="/cms/saleway/saleway.do?CMD=LIST" />
										</s:PurChk2>
									</td>
									<td>
										<a href='<c:out value="${urlContent}"/>'> <c:out
												value="${item.wayid}" /> </a>
									</td>
									<td nowrap="nowrap">
										<c:out value="${item.wayname}" />
									</td>
									<td>
										<c:out value="${item.officetel}" />
									</td>
									<td nowrap="nowrap">
     								  <s:PurChk2 controlid="<%=ID_8%>" disableChild="true">
										<c:if test="${item.isopen eq 0}">
										<input type="button" name="openservice" class="delete"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="saleway" key="openservice"/>"
										onClick="doOpen('<c:out value="${item.wayid}" />')">
										</c:if>
									  </s:PurChk2>	
									</td>
									<td nowrap="nowrap">
										<s:Code2Name code="${item.isopen}" definition="$CH_ISOPEN" />
									</td> 							
									<td>
										<s:Code2Name code="${item.waysubtype}" definition="#WAYTYPE" />
									</td>
									<td>
										<s:Code2Name code="${item.upperwayid}" definition="#WAY" />
									</td>
									<td>
										<c:out value="${item.latitude}" />
									</td>
									<td>
										<c:out value="${item.longtitude}" />
									</td>
									<td>
										<s:Code2Name code="${item.starlevel}"
											definition="$CH_STARLEVEL" />
									</td>
									<td>
										<s:Code2Name code="${item.pt}" definition="$CH_PT" />
									</td>
									<td>
										<s:Code2Name code="${item.isstraitprd}" definition="$CH_STRAITPRD" />
									</td>
									<td>
										<s:Code2Name code="${item.catetype}" definition="$CH_CATETYPE" />
									</td>
									<td>
										<s:Code2Name code="${item.cityid}" definition="#CITYCOMPANY" />
									</td>
									<td>
										<s:Code2Name code="${item.countyid}" definition="#CNTYCOMPANY" />
									</td>
									<td>
										<s:Code2Name code="${item.svccode}" definition="#CH_SERVCENT" />
									</td>
									<td>
										<s:Code2Name code="${item.mareacode}"
											definition="#CH_MICROAREA" />
									</td>
									<td>
										<s:Code2Name code="${item.adtypecode}" definition="$CH_ADTYPE" />
									</td>
									<td>
										<s:Code2Name code="${item.adacode}" definition="#CH_ADIMAREA" />
									</td>
									<td>
										<s:Code2Name code="${item.formtype}" definition="$CH_FORMTYPE" />
									</td>
									<td>
										<fmt:formatDate value="${item.starttime}" pattern="yyyy-MM-dd" />
									</td>
									<td>
										<c:out value="${item.logiscode}" />
									</td>
									<td>
										<c:out value="${item.waymagcode}" />
									</td>
									<td>
										<s:Code2Name code="${item.bchlevel}" definition="$CH_BCHLEVEL" />
									</td>
									<td>
										<s:Code2Name code="${item.waystate}"
											definition="$CH_VALIDFLAG" />
									</td>
									<td>
										<c:out value="${item.address}" />
									</td>
									<td>
										<s:Code2Name code="${item.istietong}" definition="$CH_SPECWAYFLAG" />
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
