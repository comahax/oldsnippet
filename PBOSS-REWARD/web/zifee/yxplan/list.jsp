<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa" %>
<%@ include file="/inc/listhead.inc"%>
<%@ page import="com.sunrise.boss.ui.commons.User"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="3C3C1A" />
</jsp:include>

<%
	String ID_1 = "3C3C1ABT1";
	String ID_2 = "3C3C1ABT2";
	String ID_3 = "3C3C1ABT3";
	String ID_4 = "3C3C1ABT4";

	String AREACODE_A = "AREACODE_A";
	String AREACODE_B = "AREACODE_B";
	String AREACODE_C = "AREACODE_C";
	String BATCH_SYN = "PC_PS_YXPLAN_SYNTY";
%>
<html:html>
<head>
	<title><bean:message bundle="yxplan" key="titleList" /></title>
	<style>
    	.form_input_1x {
			width:120px;
			height:18px;
			padding-left:2px;
			padding-top:2px;
			behavior:expression('url(' + contextPath + '/css/css_1/insertiontable.htc)');
		}
		.form_select_on {
			width:210px;
		}
    </style>
   	<script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
	<script language="JavaScript" type="text/JavaScript">
      
        function ev_check() {
            //addfield('_ne_yxplanid', '<bean:message bundle="yxplan" key="yxplanid"/>', 'l', true, 14);
            addfield('_nnm_yxplanid', '<bean:message bundle="yxplan" key="yxplanidend"/>', 'l', true, 14);
            addfield('_nnl_yxplanid', '<bean:message bundle="yxplan" key="yxplanidbegin"/>', 'l', true, 14);
            addfield('_sk_yxplanname', '<bean:message bundle="yxplan" key="yxplanname"/>', 'c', true, 64);
            addfield('startdate', '<bean:message bundle="yxplan" key="startdate"/>', 't', true, 20);
            addfield('stopdate', '<bean:message bundle="yxplan" key="stopdate"/>', 't', true, 20);
            addfield('_se_checkercode', '<bean:message bundle="yxplan" key="checkercode"/>', 'c', true, 15);
            addfield('_se_operatorcode', '<bean:message bundle="yxplan" key="operatorcode"/>', 'c', true, 15);
            addfield('_se_plankind', '<bean:message bundle="yxplan" key="plankind"/>', 'c', true, 32);
            addfield('_sk_discscope', '<bean:message bundle="yxplan" key="discscope"/>', 'c', true, 8);
            addfield('_sk_feecomment', '<bean:message bundle="yxplan" key="feecomment"/>', 'c', true, 255);
           	addfield('_sk_remark', '<bean:message bundle="yxplan" key="remark"/>', 'c', true, 255);
            addfield('_se_areacode', '<bean:message bundle="yxplan" key="areacode"/>', 'c', true, 32);
            return checkval(window);
        }
         function selectYxplan(){
			var arg = new Array();
			var strUrl ="<%=contextPath%>/zifee/yxplan.do?CMD=SELECT";
			var returnValue= window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
			return returnValue;
		 }
		 
        function doBatch(cmdStr) {
            formList.action = contextPath + cmdStr;
            formList.submit();
        } 
        function doSinglecopy(cmdStr) {
            formList.action = contextPath + cmdStr;
            formList.submit();
        }
        
        function excelout() {
        	formList.action=contextPath+"/zifee/yxplan.do?CMD=EXCELOUT";
        	formList.submit();
        	formList.action =contextPath + "/zifee/yxplan.do?CMD=LIST";
        }
        function doQuery(){
       		resetPage();
       		document.all("_ne_yxplanid").value="";
        	formList.action=contextPath+"/zifee/yxplan.do?CMD=LIST";
        	formList.submit();
        }    
        function getAreacode(){	
			var strUrl;
			var arg = new Array();
			strUrl = "<%=contextPath%>/admin/dictitem.do?CMD=LIST";
			strUrl = strUrl + "&_pagesize=0&_se_groupid=PC_YXPLANAREACODE";            
            <%
            	String pid = "1";  //1  2 3 
            	if(pid.equals("1")) {
            	User user = (User)request.getSession().getAttribute( WebConstant.SESSION_ATTRIBUTE_USER);
            	if(user.isProvinceUser()){    
            	%>
            		   
            		   	 var strUrl0 = strUrl;
            		   	 strUrl0 = strUrl0;
            		   
            		   
            		  <%}else{%>
            		   
            		   
            	
            		   	  var strUrl0 = strUrl;
            		   	  strUrl0 = strUrl0 + "&_se_dictid=" + "<%=user.getCityid()%>";
            				 
            	<%
            	}
            	}
            %>
            
            var hWnd = window.showModalDialog(strUrl0,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
			if(hWnd != null && hWnd != ""){						
				document.all._se_areacode.value = hWnd;	
			}else{
				document.all._se_areacode.value = "";	
			}	
        }
        function goTo(cmdNew) {
		    var url = contextPath + cmdNew;
		    formList.action = url;
		    formList.submit();
		}
        function changeBig(){
        	ajaxAnywhere.submitByURL("/zifee/yxplan.do?CMD=CHANGEBIG"); 
        }
        function batchSyn(){
		var form=document.forms[0];
		form.action="<%=contextPath%>/zifee/yxplansynlog/batch.jsp";
		form.submit();
        }
    </script>
</head>
<body>
	<div class="table_container">
		<html:form action="/zifee/yxplan.do?CMD=LIST" styleId="formList"
			method="post" onsubmit="return ev_check();">
			<html:hidden property="_orderby" />
			<html:hidden property="_desc" />
			<html:hidden property="_pageno" />
			<html:hidden property="_pagesize" />
			<input type=hidden name="_ne_yxplanid"
			value='<c:out value="${requestScope['/zifee/yxplan/YxPlanActionForm']._ne_yxplanid}" />'/>
			<input type="hidden" name="_rowcount"
				value="<c:out value='${requestScope.LIST.rowCount}' />">


			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="yxplan" key="titleList" />
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
						<td align="right">
							<bean:message bundle="yxplan" key="yxplanidbegin" />
							:
						</td>
						<td>
							<html:text styleClass="form_input_1x" property="_nnl_yxplanid"></html:text>
							<input type="button" value="..." class="clickbutton"
								onclick="_nnl_yxplanid.value=selectYxplan()">
						</td>
						<td align="right">
							<bean:message bundle="yxplan" key="yxplanidend" />
							:
						</td>
						<td>
							<html:text styleClass="form_input_1x" property="_nnm_yxplanid"></html:text>
							<input type="button" value="..." class="clickbutton"
								onclick="_nnm_yxplanid.value=selectYxplan()">
						</td>
						<td align="right">
							<bean:message bundle="yxplan" key="yxplanname" />
							:
						</td>
						<td>
							<html:text styleClass="form_input_1x" property="_sk_yxplanname"></html:text>
						</td>
					</tr>
					<tr>
						<td align="right">
							<bean:message bundle="yxplan" key="discscope" />
							:
						</td>
						<td class="form_table_left">
							<html:text styleClass="form_input_1x" property="_sk_discscope"></html:text>
						</td>
						<td align="right">
							<bean:message bundle="yxplan" key="startdate" />>=
							:
						</td>
						<td>
							<html:text styleClass="form_input_1x" property="_dnl_startdate"
								onclick="this.value=selectDate();"></html:text>
						</td>
						<td align="right">
							<bean:message bundle="yxplan" key="startdate" /><=
							:
						</td>
						<td>
						<html:text styleClass="form_input_1x" property="_dnm_startdate"
								onclick="this.value=selectDate();"></html:text>
						</td>
					</tr>
					<tr>
						<td align="right">
							<bean:message bundle="yxplan" key="checkercode" />
							:
						</td>
						<td>
							<html:text styleClass="form_input_1x" property="_se_checkercode"></html:text>
						</td>
						<td align="right">
							<bean:message bundle="yxplan" key="stopdate" />>=
							:
						</td>
						<td>
							<html:text styleClass="form_input_1x" property="_dnl_stopdate"
								onclick="this.value=selectDate();"></html:text>
						</td>
						<td align="right">
							<bean:message bundle="yxplan" key="stopdate" /><=
							:
						</td>
						<td>
							<html:text styleClass="form_input_1x" property="_dnm_stopdate"
								onclick="this.value=selectDate();"></html:text>
						</td>
					</tr>
					
					<tr>
						<td align="right">
							<bean:message bundle="yxplan" key="feecomment" />
							:
						</td>
						<td>
							<html:text styleClass="form_input_1x" property="_sk_feecomment"></html:text>
						</td>
						<td align="right">
							<bean:message bundle="yxplan" key="operatorcode" />
							:
						</td>
						<td>
							<html:text styleClass="form_input_1x" property="_se_operatorcode"></html:text>
						</td>
						<td align="right">
							<bean:message bundle="yxplan" key="remark" />
							:
						</td>
						<td>
							<html:text styleClass="form_input_1x" property="_sk_remark"></html:text>
						</td>
					</tr>
					<tr>
						<td align="right">
							<bean:message bundle="yxplan" key="areacode" />
							:
						</td>
						<td>
							<html:text styleClass="form_input_1x" property="_se_areacode"
								readonly="true" onclick="getAreacode()"></html:text>
						</td>
						<td align="right">
							<bean:message bundle="yxplan" key="checkus" />
							:
						</td>
						<td>
							<html:select property="_ne_checkus">
								<option value=""></option>
								<s:Options definition="#ZIFEE_YON" />
							</html:select>
						</td>
						<td align="right">
							<bean:message bundle="yxplan" key="planbigkind" />
							:
						</td>
						<td>
							<html:select property="_ne_planbigkind" onchange="changeBig()">
								<option value=""></option>
								<s:Options definition="$PC_BIGKIND" />
							</html:select>
						</td>
					</tr>
					<tr>
						<td align="right">
							<bean:message bundle="yxplan" key="plankind" />
							:
						</td>
						<td align="left" colspan="9">
						   <aa:zone name="big"> 
							  <c:choose>
								<c:when
									test="${requestScope.FLAG==1}">
									<html:select property="_ne_planbigkind">
										<option value=""></option>
										<s:Options definition="#CH_DICTITEM" condition="description:1;groupid:PC_YXPLANKIND"/>
									</html:select>
								</c:when>
								<c:when
									test="${requestScope.FLAG==2}">
									<html:select property="_ne_planbigkind">
										<option value=""></option>
										<s:Options definition="#CH_DICTITEM" condition="description:2;groupid:PC_YXPLANKIND"/>
									</html:select>
								</c:when>
								<c:when
									test="${requestScope.FLAG==99}">
									<html:select property="_ne_planbigkind">
										<option value=""></option>
										<s:Options definition="#CH_DICTITEM" condition="description:99;groupid:PC_YXPLANKIND"/>
									</html:select>
								</c:when>
								<c:otherwise>
									<html:select property="_ne_plankind">
										<option value=""></option>
										<s:Options definition="#CH_DICTITEM" condition="groupid:PC_YXPLANKIND"/>
									</html:select>
								</c:otherwise>
							 </c:choose>
						  </aa:zone>
						</td>
						
						
					</tr>
				</table>
			</div>
			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
							<input type="button" name="btnNew" class="button_4"
								onmouseover="buttonover(this);" onmouseout="buttonout(this);"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="yxplan" key="button_batchCopy"/>"
								onClick="goTo('/zifee/yxplan/batchcopy.jsp')">


							<s:PurChk controlid="<%=ID_1%>">
								<input type="button" name="btnNew" class="button_4"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="yxplan" key="button_singleCopy"/>"
									onClick="doSinglecopy('/zifee/yxplan.do?CMD=SINGLE')">
							</s:PurChk>
							<s:PurChk controlid="<%=ID_1%>">
								<input type="button" name="btnNew" class="add"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_new"/>"
									onClick="doNew('/zifee/yxplan.do')">
							</s:PurChk>
							<s:PurChk controlid="<%=ID_2%>">
								<input type="button" class="query"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_search"/>"
									onClick="doQuery();" />
							</s:PurChk>
							<s:PurChk controlid="<%=ID_3%>">
								<input type="button" class="button_4"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle='yxplan' key='batch'/>"
									onClick="doBatch('/zifee/yxplan.do?CMD=BATCH');" />
							</s:PurChk>
							<s:PurChk controlid="<%=ID_4%>">
								<input type="button" class="button_5"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_export"/>"
									onClick="excelout();" />
							</s:PurChk>
							<s:PurChk2 controlid="<%=BATCH_SYN%>" disableChild="true">           
								<input type="button" class="button_8"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="yxplan" key="batchPlan"/>"
									onClick="batchSyn();" />
							</s:PurChk2>
						</td>
					</tr>
				</table>
			</div>

			<div class="table_div">
				<div class="table_LongTable">
					<table class="table_style" ID="Table2">
						<tr class="table_style_head">
							<td nowrap>
								<bean:message bundle="public" key="column_operate" />
							</td>
							<td nowrap>
								<a href="javascript:doOrderby('yxplanid')"><bean:message
										bundle="yxplan" key="yxplanid" /> </a>
								<s:OrderImg form="/zifee/yxplan/YxPlanActionForm"
									field="yxplanid" />
							</td>
							<td nowrap>
								<a href="javascript:doOrderby('yxplanname')"><bean:message
										bundle="yxplan" key="yxplanname" /> </a>
								<s:OrderImg form="/zifee/yxplan/YxPlanActionForm"
									field="yxplanname" />
							</td>
							<td nowrap>
								<bean:message bundle="yxplan" key="areacode" />
							</td>
							<td nowrap>
								<bean:message bundle="yxplan" key="yxplancode" />
							</td>
							<td nowrap>
								<bean:message bundle="yxplan" key="planbigkind" />
							</td>
							<td nowrap>
								<bean:message bundle="yxplan" key="plankind" />
							</td>
							<td nowrap>
								<bean:message bundle="yxplan" key="specialflag" />
							</td>
							<td nowrap>
								<bean:message bundle="yxplan" key="checkercode" />
							</td>
							<td nowrap>
								<bean:message bundle="yxplan" key="operatorcode" />
							</td>
							<td nowrap>
								<bean:message bundle="yxplan" key="startdate" />
							</td>
							<td nowrap>
								<bean:message bundle="yxplan" key="stopdate" />
							</td>
							<td nowrap>
								<bean:message bundle="yxplan" key="discscope" />
							</td>
							<td nowrap>
								<bean:message bundle="yxplan" key="feecomment" />
							</td>
							<td nowrap>
								<bean:message bundle="yxplan" key="checkus" />
							</td>
							<td nowrap>
								<bean:message bundle="yxplan" key="remark" />
							</td>
						
						</tr>
						<c:forEach var="item" items="${requestScope.LIST.datas}">
							<c:url value="/zifee/yxplan.do?CMD=EDIT" var="urlContent">
								<c:param name="PK" value="${item.yxplanid}" />
								<c:param name="_ne_yxplanid" value="${item.yxplanid}" />
							</c:url>
							<c:url value="/zifee/yxplan/frame.jsp" var="urlContent2">
								<c:param name="PK" value="${item.yxplanid}" />
								<c:param name="_ne_yxplanid" value="${item.yxplanid}" />
								<c:param name="yxplanid" value="${item.yxplanid}" />
								<c:param name="areacode" value="${item.areacode}" />
							</c:url>
							<tr class="table_style_content" align="center">
								<td>
									<a href='<c:out value="${urlContent2}"/>'> <bean:message
											bundle="yxplan" key="yxplanmag" /> </a>
								</td>
								<td>
									<a href='<c:out value="${urlContent}"/>'><c:out
											value="${item.yxplanid}" /> </a>
								</td>
								<td>
									<c:out value="${item.yxplanname}" />
								</td>
								<td>
									<c:out value="${item.areacode}" />
								</td>
								<td>
									<c:out value="${item.yxplancode}" />
								</td>
								<td>
									<s:Code2Name code="${item.planbigkind}" definition="$PC_BIGKIND" /> 
								</td>
								<td>
									<s:Code2Name code="${item.plankind}"
										definition="$PC_YXPLANKIND" />
								</td>
								<td>
									<s:MoreCode2Name code="${item.specialflag}"
										definition="$PC_SPECIALPLAN" />
								</td>
								<td>
									<c:out value="${item.checkercode}" />
								</td>
								<td>
									<c:out value="${item.operatorcode}" />
								</td>
								<td>
									<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
										value="${item.startdate}" />
								</td>
								<td>
									<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
										value="${item.stopdate}" />
								</td>
								<td>
									<c:out value="${item.discscope}" />
								</td>
								<td>
									<c:out value="${item.feecomment}" />
								</td>
								<td>
									<s:Code2Name code="${item.checkus}" definition="#ZIFEE_YON" />
								</td>
								<td>
									<c:out value="${item.remark}" />
								</td>
								
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="table_div">
					<s:PageNav dpName="LIST" />
				</div>
		</html:form>
	</div>
</body>
</html:html>
