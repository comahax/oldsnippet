<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="4D1A1A" />
</jsp:include>
<%
	String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL";
    String ID_2 = "CH_PW_REWARD||CH_PW_REWARD_CIVIC";
    String ID_3 = "4D1A1ABT3";
%>
<html>
	<head>
		<title><bean:message bundle="cbopnacctmap" key="titleList" /></title>
		<script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_sk_opnid', '<bean:message bundle="cbopnacctmap" key="opnid"/>', 'c', true, '18');
            addfield('_sk_acctid', '<bean:message bundle="cbopnacctmap" key="acctid"/>', 'c', true, '14');
            addfield('_se_cityid', '<bean:message bundle="cbopnacctmap" key="cityid"/>', 'c', true, '4');
            formList._se_cityid.disabled=false;
            return checkval(window);
        }
		 function getAcctId() {
			var arg = new Array();
			var strUrl ="<%=contextPath%>/cms/reward/cbopnacctmap.do?CMD=SELECT";
			return window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
		}
		 function showOpnname(){
		 	ajaxAnywhere.submitByURL('/cms/reward/cbopnacctmap.do?CMD=LIST');
		 }
    </script>
	</head>

	<body onload="loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/reward/cbopnacctmap.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				
				<input type="hidden" name="_rowcount"
					value="<c:out value='${requestScope.LIST.rowCount}' />">

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="cbopnacctmap" key="titleList" />
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
				<aa:zone name="showopnname">
				<div class="table_div">
					<table class="form_table">
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="cbopnacctmap" key="opnid" />
								:
							</td>
							<td class="form_table_left">
							    <html:text  property="_sk_opnid" styleClass="form_input_1x" />
							    <input type="button" value="..." class="clickButton"
							   onclick="showOpnTree2(this, '_sk_opnid','busi' );showOpnname();"> 
                 		    </td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="cbopnacctmap" key="opnname" />
								:
							</td>
							<td class="form_table_left">
									<div>
										<html:text styleClass="form_input_1x" property="_sk_opnname" readonly="true" />
									</div>
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="cbopnacctmap" key="acctid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_sk_acctid" />
								<input type="button" value="..." class="clickbutton"
								onclick="_sk_acctid.value=getAcctId();showOpnname();">
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="cbopnacctmap" key="acctname" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_sk_acctname" readonly="true" />
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="cbopnacctmap" key="cityid" />
								:
							</td>
							<td class="form_table_left">
								<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true" >
								<html:select property="_se_cityid">
									<html:option value=""></html:option>
										<s:Options definition="$region" />
								</html:select>
								</s:RewardPurChk>
							</td>
							<td width="126" height="20" align="right" class="form_table_right"></td>
							<td class="form_table_left"></td>
						</tr>
					</table>
				</div>
				</aa:zone>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>
								<s:PurChk2 controlid="<%=ID_2%>" disableChild="true">
		                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
		                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/reward/cbopnacctmap.do')">
    	                        </s:PurChk2>
    	                        <s:PurChk2 controlid="<%=ID_2%>" disableChild="true">
		                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
		                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/reward/cbopnacctmap.do')">
		                        </s:PurChk2>
		                        <s:PurChk controlid="<%=ID_3%>">
		                    	    <input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
		                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                            value="<bean:message bundle="public" key="button_search"/>" />
		                        </s:PurChk>
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
			      <div class="table_LongTable">
			        <table class="table_style" ID="Table2">
			            <tr class="table_style_head">
			                 <td nowrap title="<bean:message bundle="public" key="list_title_select"/>">
			                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
			                </td>
			                 <td nowrap>
			                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="cbopnacctmap" key="opnid"/></a>
			                    <s:OrderImg form="/cms/reward/cbopnacctmap/CbopnacctmapForm" field="opnid"/>
			                </td>
			                 <td nowrap>
			                    <a href="javascript:doOrderby('opnname')"><bean:message bundle="cbopnacctmap" key="opnname"/></a>
			                    <s:OrderImg form="/cms/reward/cbopnacctmap/CbopnacctmapForm" field="opnname"/>
			                </td>
			                <td nowrap>
			                    <a href="javascript:doOrderby('acctid')"><bean:message bundle="cbopnacctmap" key="acctid"/></a>
			                    <s:OrderImg form="/cms/reward/cbopnacctmap/CbopnacctmapForm" field="acctid"/>
			                </td>
			                <td nowrap>
			                    <a href="javascript:doOrderby('acctname')"><bean:message bundle="cbopnacctmap" key="acctname"/></a>
			                    <s:OrderImg form="/cms/reward/cbopnacctmap/CbopnacctmapForm" field="acctname"/>
			                </td>
			                <td nowrap>
			                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="cbopnacctmap" key="cityid"/></a>
			                    <s:OrderImg form="/cms/reward/cbopnacctmap/CbopnacctmapForm" field="cityid"/>
			                </td>
			            </tr>
			            <c:forEach var="item" items="${requestScope.LIST.datas}">
			                 <c:url value="/cms/bbc/opnacctmap.do?CMD=EDIT" var="urlContent">
			                     <%//this param name must "PK" %>
			                     <c:param name="PK" value="${item.opnid}|${item.acctid}|${item.cityid}"/>
			                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
			                 </c:url>
			                 <tr class="table_style_content" align="center">
			                     <td>
								 <c:if test="${item.cityid eq '999'}">
								 	<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true" >
			                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.opnid}|${item.acctid}|${item.cityid}' />"
			                                onclick="checkOne();" class="table_checkbox">
	                                </s:RewardPurChk>
			                     </c:if>
			                     <c:if test="${item.cityid ne '999'}">
			                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.opnid}|${item.acctid}|${item.cityid}' />"
			                                onclick="checkOne();" class="table_checkbox">
			                     </c:if>
			                     </td>
			                     <td>
			                     	<c:out value="${item.opnid}"/>
			                     </td>
			                     <td><c:out value="${item.opnname}"/></td>
			 					 <td><c:out value="${item.acctid}"/></td>
			                     <td><s:Code2Name definition="#ACCTNAME" code="${item.acctid}" dbFlag="DB_COMMON"/></td>
			                     <td><s:Code2Name code="${item.cityid}" definition="$region" /></td>
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
