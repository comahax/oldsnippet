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
<style type="text/css">
   a:link,a:visited{text-decoration:none;}
</style>
<html>
	<head>
		<title><s:text name="titleList"/></title>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
	
	<script type="text/javascript" src="<%= contextPath %>/js/bus/waycommon.js"></script>
	<script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
	<script type="text/javascript" language="javascript">
	function ev_check() {
            return checkval(window);
        }
	function exports11(cmdQuery){
		
		formList.action = contextPath + cmdQuery;
		formList.submit();
		
		formList.action=contextPath+"channel/zjtywayinfo_list.do";
		}
	  function goTo(cmdNew) {
		    var url = contextPath + cmdNew;
		    formList.action = url;
		    formList.submit();
		}
	function checks(url){
	formList.action = contextPath + url
	form.submit();
	}
	
	function add(){
	var form=document.forms[0];
	form.action="<%=contextPath%>/channel/zjty/zjtywayinfo.do?CMD=NEW";
	form.submit();
	}
	
	function deletes(){
	var form=document.forms[0];
	
	var TO = true;
    var sis = formList.all("_selectitem");
	if(forincheck(TO,sis,'<bean:message bundle="zjtywayinfo" key="isdelete"/>')){
	  form.action="<%=contextPath%>/channel/zjty/zjtywayinfo.do?CMD=DELETE";
	  form.submit();
	 }
	}
	
	function upload(){
	var form=document.forms[0];
	form.action="<%=contextPath%>/channel/zjty/zjtywayinfo/batchupfile.jsp";
	form.submit();
	}
	function exports(){
	var form=document.forms[0];
	form.action="<%=contextPath%>/channel/zjty/zjtywayinfo.do?CMD=TOEXCEL";
	form.submit();
	form.action="<%=contextPath%>/channel/zjty/zjtywayinfo.do?CMD=LIST";
	}
	<%--function doselectAjax(ctype){
	var form=document.forms[0];
	ajaxAnywhere.submitByURL("/channel/zjty/zjtywayinfo.do?CMD=GETCOUNTID&cmdstates=<c:out value="${requestScope['/channel/svwayinfo/SvwayinfoForm'].cmdState}"/>&ctype="+ctype+""); 
	}
	--%>
	</script>
	</head>	
		<body onload="loadforiframe();">
		<div class="table_container">
			 <s:form action="zjtywayinfo_list.do"  key="formList"  styleId="formList" cssStyle="formList"
				theme="simple" onsubmit="return ev_check();"> 
				<!--<form action="zjtywayinfo_do" onsubmit="return ev_check();" name="formList">-->
			<aa:zone name="param.hiddenZone">
			<s:hidden name="param._orderby"/>
    		<s:hidden name="param._desc"/>
    		<s:hidden name="param._pageno"/>
    		<s:hidden name="param._pagesize"/>
    		<s:hidden name="param.basewayid"/>
    		<input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
    		</aa:zone>
    		
				<!--##################################添加标题内容，里面可以放置按钮##################################################-->
				<div class="table_top">
					<div class="table_topleft"></div>
					<div class="table_toparea_w">
						<s:i18n name="public">
							<span class="table_toparea"><s:text name="currentPos" />
							</span>
							<span class="table_toparea_xi">></span>
							<span class="table_toparea"><s:text name="channel" /> </span>
							<span class="table_toparea_xi">></span>
						</s:i18n>
						<span class="table_toparea_h"><s:text name="titleList" />
						</span>
						<span class="button_Help"
							onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpList"/>')"><s:i18n
								name="public">
								<s:text name="help" />
							</s:i18n> </span>
					</div>
				</div>

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
							<td align="center">
								<s:text name="wayid" />:
							</td>
							<td align="left">
								<s:textfield  cssStyle="style_input"  name="param._se_wayid" /><input type="button" value="..." class="picker_button"
									onclick="pshowSelectWay3(this,'param._se_wayid','','','AG','ZJTY');this.value='...';" />
							</td>
							<td align="center">
								<s:text name="wayname" />:
							</td>
							<td align="left">
								<s:textfield  name="param._sk_wayname" styleClass="form_input_1x"/>
							</td>
						</tr>
						<tr>
							<td align="center">
								<s:text name="waystate" />:
							</td>
							<td align="left">
								<j:selector definition="$CH_WAYSTATE"
									name="param._ne_waystate" />
							</td>
							<td align="center">
							</td>
							<td align="left">
							</td>
						</tr>
					</table>
				</div>
				
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td width="100%" class="form_table_right">
								<input type="button" value="<s:text name="button_search"/>"  id="btnQuery" name="btnQuery" class="button_Query" onClick="doQuery('/channel/zjtywayinfo_list.do');" onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)">
								<input type="button" value="<s:text name="button_new"/>"  id="btnNew" name="btnNew" class="button_New" onClick="doNew('/channel/zjtywayinfo_new.do')" onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)">
								<input type="button" value="<s:text name="button_delete"/>"  id="btnDelete" name="btnDelete" class="button_Delete"  onClick="doDelete('/channel/zjtywayinfo_delete.do')" onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)">
								<input type="button" name="btnNew" class="button_4" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" value="批量导入" onClick="goTo('/channel/zjty/zjtywayinfo/batch.jsp')">
								<input type="button" value="导出" class="button_4"  onClick="exports11('/channel/zjtywayinfo_excel.do')" onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)">
							</td>
						</tr>
					</table>
				</div>

				<aa:zone name="listZone">
				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style">
								<tr class="table_style_head">
									<s:i18n name="public">
										<td title="<s:text name="list_title_select"/>">
											<input type="checkbox" name="allbox" onclick="checkAll();" />
										</td>
									</s:i18n>
									<td>
										<j:orderByImg href="javascript:doOrderby('wayid')">
											<s:text name="wayid" />
										</j:orderByImg>
									</td>
									<td>
										渠道名称
									</td>
									<td>
										渠道状态
									</td>
									<td>
									<s:text name="upperwayid" />
									</td>
									<td>
									<s:text name="chainhead" />
									</td>
									<td>
									<s:text name="svbrchcode" />
									</td>
									<td>
									<s:text name="bchlevel" />
									</td>
									<td>
									<s:text name="waysubtype" />
									</td>
									<td>
									<s:text name="cityid" />
									</td>
									<td>
									<s:text name="countyid" />
									</td>
									<td>
									<s:text name="svccode" />
									</td>
									<td>
									<s:text name="mareacode" />
									</td>
									<td>
									<s:text name="starlevel" />
									</td>
									<td>
									<s:text name="runmode" />
									</td>
									<td>
									<s:text name="isconnected" />
									</td>
									<td>
									<s:text name="connecttype" />
									</td>
									<td>
									<s:text name="prtsource" />
									</td>
									
									<td>
									<s:text name="buztypecode" />
									</td>
									<td>
									<s:text name="adtypecode" />
									</td>
									<td>
									<s:text name="buzphoneno" />
									</td>
									<td>
									<s:text name="adacode" />
									</td>
									<td>
									是否共享
									</td>
								</tr>
								<s:iterator value="dp.datas">
									<tr class="table_style_content" align="center"
										onMouseMove="this.bgColor='F0F5F9'"
										onMouseOut="this.bgColor='#ffffff'">
										<td>
											<input type="checkbox" name="param._selectitem"
												value="<s:property value="wayid"/>" onclick="checkOne();">
										</td>
										<td>
										<a href='<s:url action="zjtywayinfo_edit.do"> <s:param name="param._pk" value="wayid"/></s:url>'>
												<s:property value="wayid" /> </a>
										</td>
										<td>
											<s:property value="wayname" />
										</td>
										<td>
											<j:code2Name code="waystate" definition="$CH_WAYSTATE" />
										</td>
										<td>
											<j:code2Name code="upperwayid" definition="#WAY" />
										</td>
										<td>
											<j:code2Name code="chainhead" definition="#WAY" />
										</td>
										<td>
											<j:code2Name code="svbrchcode" definition="$CH_SVBRCHTYPE" />
										</td>
										<td>
											<j:code2Name code="bchlevel" definition="$CH_BCHLEVEL" />
										</td>
										<td>
											<j:code2Name code="waysubtype" definition="#WAYTYPE" />
										</td>
										<td>
											<j:code2Name code="cityid" definition="#CITYCOMPANY" />
										</td>
										<td>
											<j:code2Name code="countyid" definition="#CNTYCOMPANY" />
										</td>
										<td>
											<j:code2Name code="svccode" definition="#SERVCENT" />
										</td>
										<td>
											<j:code2Name code="mareacode" definition="#MICROAREA" />
										</td>
										<td>
											<j:code2Name code="starlevel" definition="$CH_STARLEVEL" />
										</td>
										<td>
											<j:code2Name code="runmode" definition="$CH_RUNMODE" />
										</td>
										<td>
											<j:code2Name code="isconnected" definition="$CH_ISCONNECTED" />
										</td>
										<td>
											<j:code2Name code="connecttype" definition="$CH_CONNECTTYPE" />
										</td>
										<td>
											<j:code2Name code="prtsource" definition="$CH_PRTSOURCE" />
										</td>
										
										<td>
											<j:code2Name code="buztypecode" definition="$CH_BUZTYPE" />
										</td>
										<td>
										<j:code2Name code="adtypecode" definition="$CH_ADTYPE" />
										</td>
										<td>
										<s:property value="buzphoneno" />
										</td>
										<td>
										<j:code2Name code="adacode" definition="#CH_ADIMAREA" />
										</td>
										<td>
											<j:code2Name code="isshare" definition="$CH_DSTISKEYSTEP" />
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
		</div>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script>		
	</body>
</html>

