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
    <title><bean:message bundle="bbcrewardrecord" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('_ne_rewardid','<bean:message bundle="bbcrewardrecord" key="rewardid"/>','i','true','14');
			addfield('_se_rewardmonth','<bean:message bundle="bbcrewardrecord" key="rewardmonth"/>','c',false,'6');
			addfield('_se_wayoprcode','<bean:message bundle="bbcrewardrecord" key="wayoprcode"/>','c','true','18');
			addfield('_se_opnid','<bean:message bundle="bbcrewardrecord" key="opnid"/>','c','true','18');
			addfield('_se_batchno','<bean:message bundle="bbcrewardrecord" key="batchno"/>','i','true','18');
            return checkval(window);
        }
        
		function exports(cmd){
             var hasRight=0;
        	 <s:RewardPurChk controlid="<%=ID_1%>">hasRight=1;</s:RewardPurChk>
        	 if(　ev_check() == false ) {
        	 	return ;
        	 }
			var form=document.forms[0];
			form.action="<%=contextPath%>/cms/bbc/bbcrewardrecord.do?CMD=EXCEL";
			form.submit();
			form.action="<%=contextPath%>/cms/bbc/bbcrewardrecord.do?CMD=LIST";
		}
		
		function getOpnId() {
			var arg = new Array();
			var strUrl ="<%=contextPath%>/cms/bbc/operation.do?CMD=SELECT";
			return window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/bbc/bbcrewardrecord.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="bbcrewardrecord" key="titleList"/>
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
						<td width="126" height="20" align="right" class="form_table_right">
							<bean:message bundle="bbcrewardrecord" key="wayid"/>:
						</td>
						<td class="form_table_left">
							<html:text styleClass="form_input_1x" property="_se_wayid"  />
						</td>
						<td width="126" height="20" align="right" class="form_table_right">
							<bean:message bundle="bbcrewardrecord" key="rewardid"/>:
						</td>
						<td class="form_table_left">
							<html:text styleClass="form_input_1x" property="_ne_rewardid"></html:text> 
						</td>
						<td width="126" height="20" align="right" class="form_table_right">
							<bean:message bundle="bbcrewardrecord" key="rewardtype"/>:
						</td>
						<td class="form_table_left">
							<html:select  property="_ne_rewardtype">
		                    	<option/>
		                    	<s:Options definition="$CH_BBCREWARDTYPE" />
                    		</html:select> 
						</td>
				</tr>
				<tr>
						<td width="126" height="20" align="right" class="form_table_right">
							<bean:message bundle="bbcrewardrecord" key="rewardmonth"/>:
						</td>
						<td class="form_table_left">
						<html:text styleClass="form_input_1x" property="_se_rewardmonth" onclick="this.value=selectDateYYYYMM(this.value);" readonly="true"></html:text>
						</td>
						<td width="126" height="20" align="right" class="form_table_right">
							<bean:message bundle="bbcrewardrecord" key="wayoprcode"/>:
						</td>
						<td class="form_table_left">
						<html:text styleClass="form_input_1x" property="_se_wayoprcode"></html:text>
						</td>
						<td width="126" height="20" align="right" class="form_table_right">
							<bean:message bundle="bbcrewardrecord" key="opnid"/>:
						</td>
						<td class="form_table_left">
							<html:text styleClass="form_input_1x" property="_se_opnid"></html:text>
							<input type="button" value="..." class="clickbutton"
										onclick="_se_opnid.value=getOpnId();"/>
						</td>
				</tr>
				<tr>
						<td width="126" height="20" align="right" class="form_table_right">
							<bean:message bundle="bbcrewardrecord" key="ossrc"/>:
						</td>
						<td class="form_table_left">
							<html:select  property="_se_ossrc">
		                    	<option/>
		                    	<s:Options definition="#CH_BBC_OSSRC" />
                    		</html:select> 
						</td>
						<td width="126" height="20" align="right" class="form_table_right">
							<bean:message bundle="bbcrewardrecord" key="batchno"/>:
						</td>
						<td class="form_table_left">
							<html:text styleClass="form_input_1x" property="_se_batchno"></html:text>
						</td>
						<td width="126" height="20" align="right" class="form_table_right">
						</td>
						<td class="form_table_left">
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
                                value="<bean:message bundle="bbcrewardrecord" key="export"/>" onclick="exports();"/>
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
                    <a href="javascript:doOrderby('rewardlistid')"><bean:message bundle="bbcrewardrecord" key="rewardlistid"/></a>
                    <s:OrderImg form="/cms/bbq/bbcrewardrecordForm" field="rewardlistid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="bbcrewardrecord" key="opnid"/></a>
                    <s:OrderImg form="/cms/bbq/bbcrewardrecordForm" field="opnid"/>
                </td>
                <td>
                    业务名称
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="bbcrewardrecord" key="wayid"/></a>
                    <s:OrderImg form="/cms/bbq/bbcrewardrecordForm" field="wayid"/>
                </td>
                <td>
                    渠道名称
                </td>
                <td>
                    <a href="javascript:doOrderby('countycompname')"><bean:message bundle="bbcrewardrecord" key="countycompname"/></a>
                    <s:OrderImg form="/cms/bbq/bbcrewardrecordForm" field="countycompname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('starlevel')"><bean:message bundle="bbcrewardrecord" key="starlevel"/></a>
                    <s:OrderImg form="/cms/bbq/bbcrewardrecordForm" field="starlevel"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayoprcode')"><bean:message bundle="bbcrewardrecord" key="wayoprcode"/></a>
                    <s:OrderImg form="/cms/bbq/bbcrewardrecordForm" field="wayoprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardid')"><bean:message bundle="bbcrewardrecord" key="rewardid"/></a>
                    <s:OrderImg form="/cms/bbq/bbcrewardrecordForm" field="rewardid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardtype')"><bean:message bundle="bbcrewardrecord" key="rewardtype"/></a>
                    <s:OrderImg form="/cms/bbq/bbcrewardrecordForm" field="rewardtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardstd')"><bean:message bundle="bbcrewardrecord" key="rewardstd"/></a>
                    <s:OrderImg form="/cms/bbq/bbcrewardrecordForm" field="rewardstd"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardmonth')"><bean:message bundle="bbcrewardrecord" key="rewardmonth"/></a>
                    <s:OrderImg form="/cms/bbq/bbcrewardrecordForm" field="rewardmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('noncyc')"><bean:message bundle="bbcrewardrecord" key="noncyc"/></a>
                    <s:OrderImg form="/cms/bbq/bbcrewardrecordForm" field="noncyc"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtime')"><bean:message bundle="bbcrewardrecord" key="oprtime"/></a>
                    <s:OrderImg form="/cms/bbq/bbcrewardrecordForm" field="oprtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('totalsum')"><bean:message bundle="bbcrewardrecord" key="totalsum"/></a>
                    <s:OrderImg form="/cms/bbq/bbcrewardrecordForm" field="totalsum"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('runtime')"><bean:message bundle="bbcrewardrecord" key="runtime"/></a>
                    <s:OrderImg form="/cms/bbq/bbcrewardrecordForm" field="runtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ossrc')"><bean:message bundle="bbcrewardrecord" key="ossrc"/></a>
                    <s:OrderImg form="/cms/bbq/bbcrewardrecordForm" field="ossrc"/>
                </td>
                 <td>
                	<bean:message bundle="bbcrewardrecord" key="mobile"/>
                </td>
                <td>
                	<bean:message bundle="bbcrewardrecord" key="batchno"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/bbc/bbcrewardrecord.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.rewardlistid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     
                     <td>
                         <c:out value="${item.rewardlistid}"/>
                     </td>
                    <td><c:out value="${item.opnid}"/></td>
                    <td><s:Code2Name code="${item.opnid}"  definition="#BBC_OPERATION"/></td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><c:out value="${item.wayname}"/></td>
                     <td><c:out value="${item.countycompname}"/></td>
                     <td><s:Code2Name code="${item.starlevel}" definition="#CH_STARLEVEL" /></td>
                     <td><c:out value="${item.wayoprcode}"/></td>
                     <td><c:out value="${item.rewardid}"/></td>
                     <td><s:Code2Name code="${item.rewardtype}"  definition="$CH_BBCREWARDTYPE"/></td>
                     <td><c:out value="${item.rewardstd}"/></td>
                     <td><c:out value="${item.rewardmonth}"/></td>
                     <td><s:Code2Name code="${item.noncyc}" definition="$CH_REWARDNONCYC" /></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.oprtime}" /></td>
                     <td><c:out value="${item.totalsum}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.runtime}" /></td>
                     <td><s:Code2Name code="${item.ossrc}" definition="#CH_BBC_OSSRC" /></td>
                     <td><c:out value="${item.mobile}" /></td>
                     <td><c:out value="${item.batchno}" /></td>
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
