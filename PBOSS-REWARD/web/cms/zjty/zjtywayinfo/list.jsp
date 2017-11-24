<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa" %>
<%
    String ID_1 = "CH_PW_SVWAY_QUERY";
    String ID_2 = "CH_PW_SVWAY_ADD";
    String ID_3 = "CH_PW_SVWAY_DELETE";
    String ID_4 = "CH_PW_SVWAY_EDIT";
    String ID_5 = "CH_PW_SVWAY_BATCHIMPORT";
    String ID_6 = "CH_PW_SVWAY_EXPORT";
    String ID_7 = "CH_PW_SVWAY_AUDIT";
%>
<html>
	<head>
		<title><bean:message bundle="zjtywayinfo" key="titleList"/></title>
	</head>
	<script type="text/javascript" src="<%= contextPath %>/js/bus/waycommon.js"></script>
	<script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
	<script type="text/javascript" language="javascript">
	function checks(){
	var form=document.forms[0];
	form.all['_pageno'].value=1;
	form.action="<%=contextPath%>/cms/zjty/zjtywayinfo.do?CMD=LIST";
	form.submit();
	}
	
	function add(){
	var form=document.forms[0];
	form.action="<%=contextPath%>/cms/zjty/zjtywayinfo.do?CMD=NEW";
	form.submit();
	}
	
	function deletes(){
	var form=document.forms[0];
	
	var TO = true;
    var sis = formList.all("_selectitem");
	if(forincheck(TO,sis,'<bean:message bundle="zjtywayinfo" key="isdelete"/>')){
	  form.action="<%=contextPath%>/cms/zjty/zjtywayinfo.do?CMD=DELETE";
	  form.submit();
	 }
	}
	
	function upload(){
	var form=document.forms[0];
	form.action="<%=contextPath%>/cms/zjty/zjtywayinfo/batchupfile.jsp";
	form.submit();
	}
	function exports(){
	var form=document.forms[0];
	form.action="<%=contextPath%>/cms/zjty/zjtywayinfo.do?CMD=TOEXCEL";
	form.submit();
	form.action="<%=contextPath%>/cms/zjty/zjtywayinfo.do?CMD=LIST";
	}
	function doselectAjax(ctype){
	var form=document.forms[0];
	ajaxAnywhere.submitByURL("/cms/zjty/zjtywayinfo.do?CMD=GETCOUNTID&cmdstates=<c:out value="${requestScope['/cms/svwayinfo/SvwayinfoForm'].cmdState}"/>&ctype="+ctype+""); 
	}
	
	</script>
		
		<body onload="loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/zjty/zjtywayinfo.do?CMD=LIST" styleId="formList" method="POST">
			<html:hidden property="_orderby"/>
    		<html:hidden property="_desc"/>
    		<html:hidden property="_pageno"/>
    		<html:hidden property="_pagesize"/>
    		<html:hidden property="basewayid"/>
    		<input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="zjtywayinfo" key="titleList"/>
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="form_table">
						<tr>
							<td class="form_table_right">
								<bean:message bundle="zjtywayinfo" key="wayid" />
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_wayid" /><input type="button" value="..." class="clickbutton"
									onclick="showSelectWay3(this,'_se_wayid','','','AG','ZJTY','1');this.value='...';" />
							</td>
							<td class="form_table_right">
								<bean:message bundle="zjtywayinfo" key="wayname"/>
							</td>
							<td class="form_table_left">
								<html:text property="_sk_wayname" styleClass="form_input_1x"></html:text>
							</td>
						</tr>
						<tr>
							<td class="form_table_right">
								<bean:message bundle="zjtywayinfo" key="waystate"/>
							</td>
							<td class="form_table_left" colspan="8">
								<html:select property="_ne_waystate">
                            	<option/>
		                		<s:Options  definition="$CH_VALIDFLAG"/>
		            		</html:select>

							</td>
							
						</tr>
					</table>
				</div>
				
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td width="100%" class="form_table_right">
								<input type="button" value="<bean:message bundle="guarm" key="query"/>" class="comfir" onclick="checks();" onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)">
								<input type="button" value="<bean:message bundle="zjtywayinfo" key="add"/>" class="comfir" onclick="add();" onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)">
								<input type="button" value="<bean:message bundle="zjtywayinfo" key="delete"/>" class="comfir" onclick="deletes();" onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)">
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style">
							<THEAD>
								<tr class="table_style_head">
									<td title="<bean:message bundle="public" key="list_title_select"/>">
                    				<input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                					</td>
                					<td>
										²Ù×÷
									</td>
									<td>
										<bean:message bundle="revsumpaybill" key="wayid" />
									</td>
									<td>
										<bean:message bundle="zjtywayinfo" key="wayname"/>
									</td>
									<td>
										<bean:message bundle="zjtywayinfo" key="upperwayid"/>
									</td>
									<td>
										<bean:message bundle="zjtywayinfo" key="chainhead"/>
									</td>
									<td>
										<bean:message bundle="zjtywayinfo" key="svbrchcode"/>
									</td>
									<td>
										<bean:message bundle="zjtywayinfo" key="bchlevel"/>
									</td>
									<td>
										<bean:message bundle="zjtywayinfo" key="waysubtype"/>
									</td>
									<td>
										<bean:message bundle="zjtywayinfo" key="cityid"/>
									</td>
									<td>
										<bean:message bundle="zjtywayinfo" key="countyid"/>
									</td>
									<td>
										<bean:message bundle="zjtywayinfo" key="svccode"/>
									</td>
									<td>
										<bean:message bundle="zjtywayinfo" key="mareacode"/>
									</td>
									<td>
										<bean:message bundle="zjtywayinfo" key="starlevel"/>
									</td>
									<td>
										<bean:message bundle="zjtywayinfo" key="runmode"/>
									</td>
									<td>
										<bean:message bundle="zjtywayinfo" key="isconnected"/>
									</td>
									<td>
										<bean:message bundle="zjtywayinfo" key="connecttype"/>
									</td>
									<td>
										<bean:message bundle="zjtywayinfo" key="prtsource"/>
									</td>
									
									<td>
										<bean:message bundle="zjtywayinfo" key="buztypecode"/>
									</td>
									<td>
										<bean:message bundle="zjtywayinfo" key="adtypecode"/>
									</td>
									<td>
										<bean:message bundle="zjtywayinfo" key="buzphoneno"/>
									</td>
									<td>
										<bean:message bundle="zjtywayinfo" key="adacode"/>
									</td>
									<td>
										<bean:message bundle="Way" key="isshare"/>
									</td>
								</tr>
							<THEAD>
							<TBODY>
								<c:forEach items="${requestScope.LIST.datas}" var="item">
									<c:url value="/cms/zjty/zjtywayinfo.do?CMD=EDIT" var="editurl">
									<c:param name="PK" value="${item.wayid}"/>
									</c:url>
									<tr class="table_style_content">
										<td>
                         				<input type="checkbox" name="_selectitem" value="<c:out value='${item.wayid}'/>"
                                					onclick="checkOne();" class="table_checkbox">
                     					</td>
                     					<td>
                     					</td>
										<td>
										<a href='<c:out value="${editurl}"/>'>
											<c:out value="${item.wayid}" />
										</a>
										</td>
										<td>
											<c:out value="${item.wayname}" />
										</td>
										<td>
											<s:Code2Name definition="#WAY" code="${item.upperwayid}"/>
										</td>
										<td>
											<s:Code2Name definition="#WAY" code="${item.chainhead}"/>
										</td>
										<td>
											<s:Code2Name definition="$CH_SVBRCHTYPE" code="${item.svbrchcode}"/>
										</td>
										<td>
											<c:out value="${item.bchlevel }"></c:out>
											<s:Code2Name definition="$CH_BCHLEVEL" code="${item.bchlevel}"/>
										</td>
										<td>
											<s:Code2Name definition="#WAYTYPE" code="${item.waysubtype }"/>
										</td>
										<td>
											<c:out value="${item.cityid}"></c:out>
											<s:Code2Name definition="#CITYCOMPANY" code="${item.cityid }"/>
										</td>
										<td>
											<c:out value="${item.countyid}"></c:out>
											<s:Code2Name definition="#CNTYCOMPANY" code="${item.countyid }"/>
										</td>
										<td>
											<c:out value="${item.svccode }"></c:out>
											<s:Code2Name definition="#SERVCENT" code="${item.svccode }"/>
										</td>
										<td>
											<c:out value="${item.mareacode }"></c:out>
											<s:Code2Name definition="#MICROAREA" code="${item.mareacode }"/>
										</td>
										<td>
											<c:out value="${item.starlevel }"></c:out>
											<s:Code2Name definition="$CH_STARLEVEL" code="${item.starlevel }"/>
										</td>
										<td>
											<c:out value="${item.runmode }"></c:out>
											<s:Code2Name definition="$CH_RUNMODE" code="${item.runmode }"/>
										</td>
										<td>
											<c:out value="${item.isconnected }"></c:out>
											<s:Code2Name definition="$CH_ISCONNECTED" code="${item.isconnected }"/>
										</td>
										<td>
											<c:out value="${item.connecttype }"></c:out>
											<s:Code2Name definition="$CH_CONNECTTYPE" code="${item.connecttype }"/>
										</td>
										<td>
											<c:out value="${item.prtsource }"></c:out>
											<s:Code2Name definition="$CH_PRTSOURCE" code="${item.prtsource }"/>
										</td>
										
										<td>
											<c:out value="${item.buztypecode}"></c:out>
											<s:Code2Name definition="$CH_BUZTYPE" code="${item.buztypecode }"/>
										</td>
										<td><c:out value="${item.adtypecode }"></c:out>
										<s:Code2Name definition="$CH_ADTYPE" code="${item.adtypecode }"/>
										</td>
										<td><c:out value="${item.buzphoneno }"></c:out>
										</td>
										<td><c:out value="${item.adacode }"></c:out>
										<s:Code2Name definition="#CH_ADIMAREA" code="${item.adacode }"/>
										</td>
										<td>
											<s:Code2Name code="${item.isshare}"  definition="$CH_DSTISKEYSTEP"/>
										</td>
									</tr>
								</c:forEach>
						</table>
					</div>
				</div>
			 <div class="table_div">	
	 			<s:PageNav dpName="LIST"/>
   			</div>
			</html:form>
		</div>
	</body>
</html>

