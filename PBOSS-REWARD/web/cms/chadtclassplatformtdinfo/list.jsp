<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.sunrise.boss.common.base.db.DataPackage"%>
<%@ page
	import="com.sunrise.boss.business.cms.chadtclassplatformbrandinfo.persistent.ChAdtClassplatformbrandinfoVO"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
	<head>
		<title><bean:message bundle="chadtclassplatformtdinfo"
				key="titleList" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_tdbrandid', '<bean:message bundle="chadtclassplatformtdinfo" key="tdbrandid"/>', 'f', 'true', '8');
            addfield('_dnl_startdate', '<bean:message bundle="chadtclassplatformtdinfo" key="startdate"/>', 't', 'true', '7');
            return checkval(window);
        }
        
        
        function changecity(){
			var region = document.getElementsByName("region")[0].value;
			var citycode = document.getElementsByName("_ne_citycode")[0].value;		
			
			if(region == citycode){
			document.getElementById("divdisplay2").style.display = "none";
			document.getElementById("divdisplay1").style.display = "block";
			}else{
			document.getElementById("divdisplay1").style.display = "none";
			document.getElementById("divdisplay2").style.display = "block";
			}
		}
		
		
	 function doImport(){
        	formList.action="<%=contextPath%>/cms/chadtclassplatformtdinfo.do?CMD=IMPORT";
			formList.submit();
		}
		
	 function doExcel(){
	    	formList.action="<%=contextPath%>/cms/chadtclassplatformtdinfo.do?CMD=EXCEL";
	    	formList.submit();
	    	formList.action="<%=contextPath%>/cms/chadtclassplatformtdinfo.do?CMD=LIST";
	    }
    </script>
	</head>

	<body onload="if(window.loadforiframe) loadforiframe();changecity();">
		<div class="table_container">
			<html:form action="/cms/chadtclassplatformtdinfo.do?CMD=LIST"
				styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="region"/>
				<input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
				<c:set var="form" scope="request" value="${requestScope['/cms/chadtclassplatformtdinfo/ChAdtClassplatformtdinfoForm']}" />

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="chadtclassplatformtdinfo" key="titleList" />
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
								<bean:message bundle="chadtclassplatformtdinfo" key="tdbrandid" />
								:
							</td>
							<td width="30%" class="form_table_left">

								<select name="_ne_tdbrandid">
								<option value=""></option>
									<% DataPackage dpp = (DataPackage)request.getAttribute("CH_ADT_CLASSPLATFORMBRAND"); 
                	if (dpp != null && dpp.getDatas() != null && dpp.getDatas().size()>0) {
						for (int i = 0; i < dpp.getDatas().size(); i++) {
						List list = (ArrayList)dpp.getDatas();
						ChAdtClassplatformbrandinfoVO chAdtClassplatformbrandinfoVO = (ChAdtClassplatformbrandinfoVO)list.get(i);
						
						%>
						<option value="<% out.print(chAdtClassplatformbrandinfoVO.getBrandid()); %>">
										<% out.print(chAdtClassplatformbrandinfoVO.getBrandname()); %>
									</option>
						<% 
						}
					}
                %>
								</select>

							</td>
							<td width="20%" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="chadtclassplatformtdinfo" key="startdate" />
								:
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnl_startdate"
									onclick="this.value=selectDate();" readonly="true"></html:text>
							</td>
						</tr>
						
						<tr>
							 <td width="20%" height="20" align="right" class="form_table_right" >地市标识:</td>
                <td width="30%" class="form_table_left">
                 <c:choose>
                        <c:when test="${form.region == '999'}">
								<html:select property="_ne_citycode" onchange="changecity()">
									<s:Options definition="#CITYIDNUM2NMAME" />
								</html:select>
							</c:when>
                       	 <c:otherwise>
	                        <html:select property="_ne_citycode" onchange="changecity()">
										<option value="<c:out value='${form.region}'/>"/><s:Code2Name definition="#CITYIDNUM2NMAME" code="${form.region}"/>
									</html:select>
                          </c:otherwise>
                    </c:choose>
				</td>
							<td width="20%" height="20" align="right"
								class="form_table_right">
								&nbsp;
							</td>
							<td width="30%" class="form_table_left">
								&nbsp;
							</td>
						</tr>
						
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>
							
							 <div id = "divdisplay1">
							<input type="button" class="query"
									onmouseover="buttonover(this);" onclick="doQuery();"
									onmouseout="buttonout(this);" onfocus="buttonover(this)"
									onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_search"/>" />
								<input type="button" name="btnNew" class="add"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_new"/>"
									onClick="doNew('/cms/chadtclassplatformtdinfo.do')">
								<input type="button" name="btnDelete" class="delete"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_delete"/>"
									onClick="doDelete('/cms/chadtclassplatformtdinfo.do')">
									<input type="button" class="button_4" onmouseover="buttonover(this);" onclick="doExcel();"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_export_excel"/>" />
                        <input type="button" class="button_4" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                              	value="批量导入" 
                                onclick="doImport()"/>
									 </div>
                  <div id = "divdisplay2" style = "display:none">
                  	<input type="button" class="query"
									onmouseover="buttonover(this);" onclick="doQuery();"
									onmouseout="buttonout(this);" onfocus="buttonover(this)"
									onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_search"/>" />
									<input type="button" class="button_4" onmouseover="buttonover(this);" onclick="doExcel();"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_export_excel"/>" />
                  </div>
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
									<c:choose>
										<c:when test="${form._ne_citycode == form.region}">
											<input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
										</c:when>
								 		<c:otherwise>
								 			<input type="checkbox" name="allbox" class="table_checkbox" disabled="disabled">
								 		</c:otherwise>
								 	</c:choose>
								</td>
								<td>
									<a href="javascript:doOrderby('tdbrandid')"><bean:message
											bundle="chadtclassplatformtdinfo" key="tdbrandid" />
									</a>
									<s:OrderImg
										form="/cms/chadtclassplatformtdinfo/ChAdtClassplatformtdinfoForm"
										field="tdbrandid" />
								</td>
								<td>
									<a href="javascript:doOrderby('productid')"><bean:message
											bundle="chadtclassplatformtdinfo" key="productid" />
									</a>
									<s:OrderImg
										form="/cms/chadtclassplatformtdinfo/ChAdtClassplatformtdinfoForm"
										field="productid" />
								</td>
								<td>
									<a href="javascript:doOrderby('comid')"><bean:message
											bundle="chadtclassplatformtdinfo" key="comid" />
									</a>
									<s:OrderImg
										form="/cms/chadtclassplatformtdinfo/ChAdtClassplatformtdinfoForm"
										field="comid" />
								</td>
								<td>
									<a href="javascript:doOrderby('comname')"><bean:message
											bundle="chadtclassplatformtdinfo" key="comname" />
									</a>
									<s:OrderImg
										form="/cms/chadtclassplatformtdinfo/ChAdtClassplatformtdinfoForm"
										field="comname" />
								</td>
								<td>
									<a href="javascript:doOrderby('startdate')"><bean:message
											bundle="chadtclassplatformtdinfo" key="startdate" />
									</a>
									<s:OrderImg
										form="/cms/chadtclassplatformtdinfo/ChAdtClassplatformtdinfoForm"
										field="startdate" />
								</td>
								<td>
									<a href="javascript:doOrderby('enddate')"><bean:message
											bundle="chadtclassplatformtdinfo" key="enddate" />
									</a>
									<s:OrderImg
										form="/cms/chadtclassplatformtdinfo/ChAdtClassplatformtdinfoForm"
										field="enddate" />
								</td>
								<td>
									<a href="javascript:doOrderby('citycode')"><bean:message
											bundle="chadtclassplatformtdinfo" key="citycode" />
									</a>
									<s:OrderImg
										form="/cms/chadtclassplatformtdinfo/ChAdtClassplatformtdinfoForm"
										field="citycode" />
								</td>
								<td>
									<a href="javascript:doOrderby('adtremark')"><bean:message
											bundle="chadtclassplatformtdinfo" key="adtremark" />
									</a>
									<s:OrderImg
										form="/cms/chadtclassplatformtdinfo/ChAdtClassplatformtdinfoForm"
										field="adtremark" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/cms/chadtclassplatformtdinfo.do?CMD=EDIT"
									var="urlContent">
									<%//this param name must "PK" %>
									<c:param name="PK" value="${item.seq}" />
									<%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
								</c:url>
								<c:choose>
                        <c:when test="${item.citycode == form.region}">
								<tr class="table_style_content" align="center">
									<td>
										<input type="checkbox" name="_selectitem"
											value="<c:out value='${item.seq}' />" onclick="checkOne();"
											class="table_checkbox">
									</td>
									<td>
										 <a href='<c:out value="${urlContent}"/>'><c:out value="${item.tdbrandname}" /></a>
									</td>
									<td>
										<c:out value="${item.productid}" />
									</td>
									
									 <td>
				                         <c:out value="${item.comid}"/>
				                     </td>
				                     <td>
					                	 <s:Code2Name code="${item.comid}" definition="#COMSYSTEM" />
					                 </td>
									<td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.startdate}"/></td>
                     				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.enddate}"/></td>
									<td>
										<s:Code2Name code="${item.citycode}" definition="#CITYIDNUM2NMAME" />
									</td>
									<td>
										<c:out value="${item.adtremark}" />
									</td>
								</tr>
								</c:when>
								 <c:otherwise>
								 <tr class="table_style_content" align="center">
									<td>
									<input type="checkbox" name="_selectitem"
											value="<c:out value='${item.seq}' />" onclick="checkOne();"
											class="table_checkbox" disabled = "true">
									</td>
									<td>
										<c:out value="${item.tdbrandname}" />
									</td>
									<td>
										<c:out value="${item.productid}" />
									</td>
									
									 <td>
				                         <c:out value="${item.comid}"/>
				                     </td>
				                     <td>
					                	 <s:Code2Name code="${item.comid}" definition="#COMSYSTEM" />
					                 </td>
									<td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.startdate}"/></td>
                     				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.enddate}"/></td>
									<td>
										<s:Code2Name code="${item.citycode}" definition="#CITYIDNUM2NMAME" />
									</td>
									<td>
										<c:out value="${item.adtremark}" />
									</td>
								</tr>
								  </c:otherwise>
                    </c:choose>
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
