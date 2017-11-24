<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ include file="/inc/listhead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B7G1A4D" />
</jsp:include>


<html:html>
<head>
	<title><bean:message bundle="accmon" key="title" /></title>
	<script language="JavaScript" type="text/JavaScript">
	
	
	function ev_check() {
		addfield('_ne_tabtype', '<bean:message bundle="chghis" key="tabtype"/>', 'l', true, 11);
       	addfield('_se_tabname', '<bean:message bundle="chghis" key="tabname"/>', 'c', true, 40);
        addfield('_se_oprtype', '<bean:message bundle="chghis" key="oprtype"/>', 'c', true, 18);
        addfield('_se_oprcode', '<bean:message bundle="chghis" key="oprcode"/>', 'c', true, 15);
        addfield('_dnl_oprtime', '<bean:message bundle="chgreq" key="starttime"/>', 'dt', true, 7);
        addfield('_dnm_oprtime', '<bean:message bundle="chgreq" key="endtime"/>', 'dt', true, 7);
        addfield('_ne_chgtype', '<bean:message bundle="chghis" key="chgtype"/>', 'i', true, 3);
        addfield('_ne_matchid', '<bean:message bundle="chghis" key="matchid"/>', 'l', true, 14);
        addfield('_sk_mainvalue', '<bean:message bundle="chghis" key="mainvalue"/>', 'c', true, 40);
        addfield('_ne_oprstate', '<bean:message bundle="chghis" key="_ne_oprstate"/>', 'l', true, 14);
            //开始日期不能大于结束日期,有一方为空则不比较
			//date_compare('开始时间input名字','开始时间input名字','中文出错信息');
        if(date_compare('_dnl_oprtime','_dnm_oprtime','<bean:message bundle="res" key="timecompare1"/>')) return;
        return checkval(window);
    }
    function getEndWith(str){
        	var tmp = str.substring(str.length-2,str.length);
        	var tmp2 = str.substring(0,str.length-2);
        	if(validDateStr(tmp2+"31") == true){
       			return "31";
       		}else if(validDateStr(tmp2+"30") == true){
       			return "30";
       		}else if(validDateStr(tmp2+"29") == true){
       			return "29";
       		}else if(validDateStr(tmp2+"28") == true){
       			return "28";
       		}
        }
    
    function validDateStr(str){
			var reg =  /^(\d{1,4})(\d{1,2})(\d{1,2})$/;
			var r = str.match(reg);
			if(r==null){
				return false;
			}
			else{
				var d = new Date(r[1],r[2]-1,r[3]);
				if(d.getFullYear()==r[1]&&(d.getMonth()+1)==r[2]&&d.getDate()==r[3]){
					return true;
				}
				else{
					return false; 
				}   
			}
		}
		
	function doBatch(){
		if(forincheck2(true,formList.all._selectitem)){
			formList.action="<%=contextPath%>/qsmanage/paramsmanage/chgreq.do?CMD=BATCHDIS";
			formList.submit();
		}	
	}
	
	function doEditreq(url){
		formList.action = url;
		formList.submit();
	}		
</script>
</head>
<body onload="loadforiframe()">
	<div class="table_container">
		<html:form action="/qsmanage/paramsmanage/chgreq.do?CMD=LIST" styleId="formList"
			method="post" onsubmit="return ev_check();">
			<html:hidden property="_orderby" />
			<html:hidden property="_desc" />
			<html:hidden property="_pageno" />
			<html:hidden property="_pagesize" />
			<input type="hidden" name="_rowcount"
				value="<c:out value='${requestScope.LIST.rowCount}' />">

			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="chgreq" key="title" />
						</td>
					</tr>
				</table>
			</div>
			<div class="table_div">
				<table width="100%" class="error_text">
					<s:Msg />
					<html:errors />
				</table>
			</div>
			<div class="table_div">
				<table class="form_table">
					<tr>
						<td class="form_table_right">
							<bean:message bundle="chgreq" key="tabname" />
							:
						</td>
						<td class="form_table_left">
							<html:select property="_se_tabname">
								<html:option value=""/>
								<s:Options definition="#QS_TABLENAME"></s:Options>
							</html:select>
						</td>
						<td class="form_table_right">
							<bean:message bundle="chgreq" key="tabtype" />
							:
						</td>
						<td class="form_table_left">
						
							<html:select property="_ne_tabtype">
								<html:option value=""/>
								<s:Options definition="$QSCS_TABTYPE"></s:Options>
							</html:select>
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<bean:message bundle="chgreq" key="oprtype" />
							:
						</td>
						<td class="form_table_left">
							<html:select property="_se_oprtype">
								<html:option value="">
								</html:option>
								<s:Options definition="$QSCS_OPRTYPE"></s:Options>
							</html:select>
						</td>
						<td class="form_table_right">
							<bean:message bundle="chgreq" key="matchid" />
							:
						</td>
						<td class="form_table_left">
							<html:text styleClass="form_input_1x" property="_ne_matchid"></html:text>
						</td>
					</tr>
					
					<tr>
						<td class="form_table_right">
							<bean:message bundle="chgreq" key="chgtype" />
							:
						</td>
						<td class="form_table_left">
							<html:select property="_ne_chgtype">
								<html:option value="">
								</html:option>
								<s:Options definition="#QSCHGTYPE"></s:Options>
							</html:select>
						</td>
						<td class="form_table_right">
							<bean:message bundle="chgreq" key="oprcode" />
							:
						</td>
						<td class="form_table_left">
							<html:text styleClass="form_input_1x" property="_se_oprcode"></html:text>
						</td>
					</tr>
					
					<tr>
						<td class="form_table_right">
							<bean:message bundle="chgreq" key="mainvalue" />
							:
						</td>
						<td class="form_table_left">
							<html:text styleClass="form_input_1x" property="_sk_mainvalue"></html:text>
						</td>
						<td class="form_table_right">
							<bean:message bundle="chgreq" key="oprstate" />
							:
						</td>
						<td class="form_table_left">
							<html:select property="_ne_oprstate">
								<html:option value="">
								</html:option>
								<s:Options definition="$QSCS_OPRSTATE"></s:Options>
							</html:select>
						</td>
					</tr>
					
					<tr>
						<td class="form_table_right">
							<bean:message bundle="chgreq" key="starttime" />
							:
						</td>
						<td class="form_table_left">
							<html:text styleClass="form_input_1x" property="_dnl_oprtime" onclick="this.value=selectDatetime()"></html:text>
						</td>
						<td class="form_table_right">
							<bean:message bundle="chgreq" key="endtime" />
							:
						</td>
						<td class="form_table_left">
							<html:text styleClass="form_input_1x" property="_dnm_oprtime" onclick="this.value=selectDatetime()"></html:text>
						</td>
					</tr>
					
				</table>
			</div>
			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
							<input type="submit" class="query"
								onmouseover="buttonover(this);" onmouseout="buttonout(this);"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="public" key="button_search"/>" />
								
							<s:PurChk2 controlid="QSCS_APPROVE_BATAPP" disableChild="true">	
							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnReturn"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="批量审批" class="button_4" onclick="doBatch()">
							</s:PurChk2>		
						</td>
					</tr>
				</table>
			</div>
			<div class="table_div">
				<div class="table_LongTable">
					<table class="table_style">
							<tr class="table_style_head">
								<td
									title="<bean:message bundle="public" key="list_title_select"/>">
									<input type="checkbox" name="allbox" onclick="checkAll();"
										class="table_checkbox">
								</td>
								<td>
									<a href="javascript:doOrderby('reqid')"><bean:message
											bundle="chgreq" key="reqid" /> </a>
									<s:OrderImg form="/qsmanage/paramsmanage/chgreq/ChgReqForm" field="reqid" />
								</td>
								<td >
									<a href="javascript:doOrderby('matchid')"><bean:message bundle="chghis" key="matchid" /> </a>
									<s:OrderImg form="/qsmanage/paramsmanage/chgreq/ChgReqForm" field="matchid" />
								</td>
								<td>
									<a href="javascript:doOrderby('tabname')"><bean:message
											bundle="chgreq" key="tabname" /> </a>
									<s:OrderImg form="/qsmanage/paramsmanage/chgreq/ChgReqForm" field="tabname" />
								</td>
								<td>
									<a href="javascript:doOrderby('tabtype')"><bean:message
											bundle="chgreq" key="tabtype" /> </a>
									<s:OrderImg form="/qsmanage/paramsmanage/chgreq/ChgReqForm" field="tabtype" />
								</td>
								<td>
									<a href="javascript:doOrderby('oprtype')"><bean:message
											bundle="chgreq" key="oprtype" /> </a>
									<s:OrderImg form="/qsmanage/paramsmanage/chgreq/ChgReqForm" field="oprtype" />
								</td>
								<td>
									<a href="javascript:doOrderby('mainkey')"><bean:message
											bundle="chgreq" key="mainkey" /> </a>
									<s:OrderImg form="/qsmanage/paramsmanage/chgreq/ChgReqForm" field="mainkey" />
								</td>
								<td>
									<bean:message bundle="chgreq" key="mainkeyname" /> 
								</td>
								<td>
									<a href="javascript:doOrderby('mainvalue')"><bean:message
											bundle="chgreq" key="mainvalue" /> </a>
									<s:OrderImg form="/qsmanage/paramsmanage/chgreq/ChgReqForm" field="mainvalue" />
								</td>
								<td>
									<a href="javascript:doOrderby('oprtime')"><bean:message
											bundle="chgreq" key="oprtime" /> </a>
									<s:OrderImg form="/qsmanage/paramsmanage/chgreq/ChgReqForm" field="oprtime" />
								</td>
								<td>
									<a href="javascript:doOrderby('oprcode')"><bean:message
											bundle="chgreq" key="oprcode" /> </a>
									<s:OrderImg form="/qsmanage/paramsmanage/chgreq/ChgReqForm" field="oprcode" />
								</td>
								<td>
									<a href="javascript:doOrderby('oprstate')"><bean:message
											bundle="chgreq" key="oprstate" /> </a>
									<s:OrderImg form="/qsmanage/paramsmanage/chgreq/ChgReqForm" field="oprstate" />
								</td>
								
								<td>
									<a href="javascript:doOrderby('chgtype')"><bean:message
											bundle="chghis" key="chgtype" /> </a>
									<s:OrderImg form="/qsmanage/paramsmanage/chgreq/ChgReqForm"
										field="chgtype" />
								</td>
								<td>
									<a href="javascript:doOrderby('chgreason')"><bean:message
											bundle="chghis" key="chgreason" /> </a>
									<s:OrderImg form="/qsmanage/paramsmanage/chgreq/ChgReqForm"
										field="chgreason" />
								</td>
								<td>
									<a href="javascript:doOrderby('chkinfo')"><bean:message
											bundle="chghis" key="chkinfo" /> </a>
									<s:OrderImg form="/qsmanage/paramsmanage/chgreq/ChgReqForm"
										field="chkinfo" />
								</td>
								
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/qsmanage/paramsmanage/chgreq.do?CMD=EDIT" var="urlContent">
									<c:param name="PK" value="${item.reqid}" />
								</c:url>
								<tr class="table_style_content" align="center">
								<c:choose>
									<c:when test="${item.oprstate eq '0' or item.oprstate eq '4'}">
									<td>
										<input type="checkbox" name="_selectitem"
											value="<c:out value='${item.reqid}' />"
											onclick="checkOne();" class="table_checkbox">
									</td>
									<td>
										
										<a href="javascript:doEditreq('<c:out value="${urlContent}"/>')" > <c:out
											value="${item.reqid}" /> </a>
									</td>			
									</c:when>
									<c:otherwise>
										<td>
										<input type="checkbox" name="_selectitem"
											value="<c:out value='${item.reqid}' />"
											onclick="checkOne();" class="table_checkbox" disabled="true">
									</td>
										<td>
										<c:out value="${item.reqid}" />
										</td>
									</c:otherwise>
								</c:choose>
									
									<td>
										<c:out value="${item.matchid}" />
									</td>
									<td>
										<s:Code2Name definition="#QS_TABLENAME" code="${item.tabname}" />
									</td>
									<td>
										<s:Code2Name definition="$QSCS_TABTYPE" code="${item.tabtype}" />
									</td>
									<td>
										<s:Code2Name definition="$QSCS_OPRTYPE" code="${item.oprtype}" />
									</td>
									<td>
									<c:out value="${item.mainkey}" />
									</td>
									<td>
									<s:Code2Name definition="#QS_MAINKEYSTR" code="${item.tabname}" />
									</td>
									<td>
									<c:out value="${item.mainvalue}" />
									</td>
									<td>
									<fmt:formatDate value="${item.oprtime}" pattern="yyyy-MM-dd hh:mm:ss"/>
									</td>
									<td>
									<c:out value="${item.oprcode}" />
									</td>
									<td>
									<s:Code2Name definition="$QSCS_OPRSTATE" code="${item.oprstate}" />
									</td>
									<td>
										<s:Code2Name code="${item.chgtype}" definition="#QSCHGTYPE" />
									</td>
									<td>
										<c:out value="${item.chgreason}" />
									</td>
									<td>
										<c:out value="${item.chkinfo}" />
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
</html:html>
