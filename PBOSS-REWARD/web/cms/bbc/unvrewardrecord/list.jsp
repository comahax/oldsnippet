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
    <title><bean:message bundle="unvrewardrecord" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
    <script type="text/javascript" src="<%= contextPath%>/js/jquery/jquery-1.3.2.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('_se_rewardmonth','<bean:message bundle="unvrewardrecord" key="rewardmonth"/>','c',false,'6');
            addfield('_se_batchno','批次号','c',false,'8');
            return checkval(window);
        }
		function exports(){
			if(ev_check() == false ) {
	       	 	return ;
	       	 }
			var form=document.forms[0];
			form.action="<%=contextPath%>/cms/bbc/unvrewardrecord.do?CMD=DOWNLOAD";
			form.submit();
			form.action="<%=contextPath%>/cms/bbc/unvrewardrecord.do?CMD=LIST";
		}
		function getOpnId() {
			var arg = new Array();
			var strUrl ="<%=contextPath%>/cms/bbc/operation.do?CMD=SELECT";
			return window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
		}
		
		 function selectRcno(){
        	var strUrl ="<%=contextPath%>/cms/employee.do?CMD=SELECTTEL";
			var arg = new Array();
			var returnValue= window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
			return returnValue;
		 }
		 
		 function chooseCity(){
		 	var city = $("#citycompid").val();
		 	if(city.toString()=="provAgent"){
		 		//$(".query").attr("disabled","true");
		 		$(".query").hide();
		 	}
		 	else{
		 		//$(".query").attr("disabled","false");
		 		$(".query").show();
		 	}
		 }
		 
		$(document).ready(function(){
			//业务编号无对应名称则翻译为空
			$("#Table2 .opnidTD").each(function(i){
				if($(this).html()==$(this).next().html())
				{
					$(this).next().html("");
				}
				
			});
			
			//根据是否有全省权限对地市选框进行控制
			var hasPurview = $("#hasPurview").val();
			var hasProvAgentView = $("#hasProvAgentView").val();
			if(hasPurview!="true" && hasProvAgentView!="true")
			{
				$("#citycompid").attr("disabled", true);
			}
		}); 
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/bbc/unvrewardrecord.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="hasPurview" styleId="hasPurview"/>
    <html:hidden property="hasProvAgentView" styleId="hasProvAgentView"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="unvrewardrecord" key="titleList"/>
   			</td>
    	</tr>
    </table>
    </div>
    <div class="table_div">	
   		 <table width="100%" class="error_text">
    		<html:errors/><s:Msg />
    	</table>
    </div>
	<div class="table_div">
        <table class="form_table">
        	<tr>
				<td width="80" height="20" align="right" class="form_table_right">
					<bean:message bundle="unvrewardrecord" key="rewardmonth"/>:
				</td>
				<td class="form_table_left">
					<html:text styleClass="form_input_1x" property="_se_rewardmonth" onclick="this.value=selectDateYYYYMM(this.value);" readonly="true"></html:text>
				</td>
				<td width="80" height="20" align="right" class="form_table_right">
					<bean:message bundle="unvrewardrecord" key="rcno"/>:
				</td>
				<td class="form_table_left">
					<html:text styleClass="form_input_1x" property="_se_telephone"></html:text><input type="button" value="..." class="clickbutton"
									onclick="_se_telephone.value=selectRcno();">
				</td>
			</tr>
			<tr>
				<td width="80" height="20" align="right" class="form_table_right">
					<bean:message bundle="unvrewardrecord" key="opnid"/>:
				</td>
				<td class="form_table_left">
					<html:text styleClass="form_input_1x" property="_se_opnid"></html:text>
					<input type="button" value="..." class="clickbutton" onclick="_se_opnid.value=getOpnId();"/>
				</td>
				<td width="80" height="20" align="right" class="form_table_right">
					<bean:message bundle="unvrewardrecord" key="ossrc"/>:
				</td>
				<td class="form_table_left">
					<html:select  property="_se_ossrc">
	                   	<option/>
	                   	<s:Options definition="#CH_UNV_OSSRC" />
	                   	<html:option value="4">新数据业务</html:option>
	                 </html:select> 
				</td>
			</tr>
			<tr>
				<td width="80" height="20" align="right" class="form_table_right">
							<bean:message bundle="unvrewardtotal" key="wayid1"/>:
						</td>
				<td class="form_table_left">
							<s:zoom definition="#WAY" property="_se_wayid" condition="waytype:AG;" styleClass="form_input_1x" nameOnly="false" readonly="false"/>
						</td>
				<td width="80" height="20" align="right" class="form_table_right">
							<bean:message bundle="unvrewardrecord" key="batchno"/>:
						</td>
				<td>
					<html:text styleClass="form_input_1x" property="_se_batchno"></html:text>
					<font color=red>格式为:yyyymm加上00或01,例如：20120900</font>
				</td>
			</tr>
			
			<tr>
				<td width="80" height="20" align="right" class="form_table_right" >
	               	<bean:message bundle="Wayproemployee" key="citycompany"/>:
	           	</td>
	           	<td class="form_table_left">
	           		<html:select property="_ne_citycompid" styleId="citycompid" onchange="chooseCity()">
						<option />
						<c:if test="${requestScope.provAgent}">
							<option value="provAgent"><bean:message bundle="unvrewardrecord" key="provAgent"/></option>
						</c:if>	
						<c:if test="${requestScope.provAgent && !requestScope.B2MProv}">
							<s:Options definition="#CITYCOMPANY" condition="citycompid:${requestScope.cityid};"/>
						</c:if>
						<c:if test="${!requestScope.provAgent || requestScope.B2MProv}">
							<s:Options definition="#CITYCOMPANY" />
						</c:if>
					</html:select>
	           	</td>
			</tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <input type="button" class="button_2" onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="unvrewardrecord" key="export"/>" onclick="exports();"/>
                        <input type="submit" class="query"onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>
                    <a href="javascript:doOrderby('rewardlistid')"><bean:message bundle="unvrewardrecord" key="rewardlistid"/></a>
                    <s:OrderImg form="/cms/bbc/UnvRewardrecordForm" field="rewardlistid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('operseq')"><bean:message bundle="unvrewardrecord" key="operseq"/></a>
                    <s:OrderImg form="/cms/bbc/UnvRewardrecordForm" field="operseq"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('datasrc')"><bean:message bundle="unvrewardrecord" key="datasrc"/></a>
                    <s:OrderImg form="/cms/bbc/UnvRewardrecordForm" field="datasrc"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="unvrewardrecord" key="opnid"/></a>
                    <s:OrderImg form="/cms/bbc/UnvRewardrecordForm" field="opnid"/>
                </td>
                <td>
                    业务名称
                </td>
                <td>	
                	<a href="javascript:doOrderby('wayid')"><bean:message bundle="unvrewardrecord" key="wayid1"/></a>
                    <s:OrderImg form="/cms/bbc/UnvRewardrecordForm" field="wayid"/>
                </td>
                <td>	
                	<bean:message bundle="unvrewardrecord" key="wayid2"/>
                    <s:OrderImg form="/cms/bbc/UnvRewardrecordForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayoprcode')"><bean:message bundle="unvrewardrecord" key="employeeid"/></a>
                    <s:OrderImg form="/cms/bbc/UnvRewardrecordForm" field="wayoprcode"/>
                </td>
                <td>
                    <bean:message bundle="unvrewardrecord" key="employeeid1"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardstd')"><bean:message bundle="unvrewardrecord" key="rewardstd"/></a>
                    <s:OrderImg form="/cms/bbc/UnvRewardrecordForm" field="rewardstd"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardmonth')"><bean:message bundle="unvrewardrecord" key="rewardmonth"/></a>
                    <s:OrderImg form="/cms/bbc/UnvRewardrecordForm" field="rewardmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('runtime')"><bean:message bundle="unvrewardrecord" key="runtime"/></a>
                    <s:OrderImg form="/cms/bbc/UnvRewardrecordForm" field="runtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('totalsum')"><bean:message bundle="unvrewardrecord" key="totalsum"/></a>
                    <s:OrderImg form="/cms/bbc/UnvRewardrecordForm" field="totalsum"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ossrc')"><bean:message bundle="unvrewardrecord" key="ossrc"/></a>
                    <s:OrderImg form="/cms/bbc/UnvRewardrecordForm" field="ossrc"/>
                </td>
                 <td>
                    <a href="javascript:doOrderby('batchno')"><bean:message bundle="unvrewardrecord" key="batchno"/></a>
                    <s:OrderImg form="/cms/bbc/UnvRewardrecordForm" field="batchno"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mobile')"><bean:message bundle="unvrewardrecord" key="mobile"/></a>
                    <s:OrderImg form="/cms/bbc/UnvRewardrecordForm" field="mobile"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/bbc/unvrewardrecord.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.rewardlistid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td><c:out value="${item.rewardlistid}"/></td>
                     <td><c:out value="${item.operseq}"/></td>
                     <td><c:out value="${item.datasrc}"/></td>
                     <td><c:out value="${item.opnid}"/></td>
                     <td><s:Code2Name code="${item.opnid}"  definition="#BBC_OPERATION"/></td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><s:Code2Name code="${item.wayid}" definition="#WAY"/></td>
                     <td class="opnidTD"><c:out value="${item.wayoprcode}"/></td>
                     <td><c:out value="${item.rcno}"/></td>
                     <td><c:out value="${item.rewardstd}"/></td>
                     <td><c:out value="${item.rewardmonth}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"  value="${item.runtime}" /></td>
                     <td><c:out value="${item.totalsum}"/></td>
                     <td><s:Code2Name code="${item.ossrc}" definition="#CH_UNV_OSSRC" /></td>
                     <td><c:out value="${item.batchno}"/></td>
                     <td><c:out value="${item.mobile}"/></td>
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
