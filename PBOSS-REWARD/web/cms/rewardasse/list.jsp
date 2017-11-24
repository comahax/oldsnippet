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
    <title><bean:message bundle="rewardasse" key="titleList"/></title>
    <script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	var form=document.forms[0];
        	var time1=form.all['_snl_assemonth'].value;
        	var time2=form.all['_snm_assemonth'].value;
        	if(time1.length>0&&!isDateYYYYMM(time1)){
        	alert("请输入正确的日期格式:YYYYMM");
        	return false;
        	}
        	if(time2.length>0&&!isDateYYYYMM(time2)){
        	alert("请输入正确的日期格式:YYYYMM");
        	return false;
        	}
            return checkval(window);
        }
		
		function isDateYYYYMM(str) {
		var reg = /^(\d{1,4})(\d{1,2})/;
		var r = str.match(reg);
		if (r == null) {
		return false;
		} else {
		var d = new Date(r[1], r[2] - 1);
		if (d.getFullYear() == r[1] && (d.getMonth() + 1) == r[2]) {
			return true;
		} else {
			return false;
		}
		}
		}
		
		function upload(){
		var form=document.forms[0];
		form.action="<%=contextPath%>/cms/rewardasse/batchupfile.jsp";
		form.submit();
		}
    </script>
    <script type="text/javascript" src="<%= contextPath %>/js/bus/waycommon.js"></script>
	<script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/rewardasse.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
	<c:set var="ISONE" scope="request" value="${invalid}" />
    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="rewardasse" key="titleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="rewardasse" key="wayid"/>:</td>
                <td class="form_table_left">
 					<html:text styleClass="form_input_1x" property="_se_wayid" /><input type="button" value="..." class="clickbutton" onclick="showSelectWay(this,'_se_wayid');this.value='...';"/>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="rewardasse" key="assemonth"/>>=:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_snl_assemonth" onclick="this.value=selectDateYYYYMM(this.value);"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="rewardasse" key="assemonth"/><=:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_snm_assemonth" onclick="this.value=selectDateYYYYMM(this.value);"></html:text>
                </td>
            </tr>
            <tr>
            	<td width="126" height="20" align="right" class="form_table_right" nowrap>
                	<bean:message bundle="rewardasse" key="wayid2"/>:
                </td>
                <td class="form_table_left" title="本树只显示合作商类别">
                	<html:text styleClass="form_input_1x" property="_sk_wayid" /><input type="button" value="..." class="clickbutton" onclick="showSelectWay(this,'_sk_wayid',false,true,'AG','DIS');this.value='...';"/>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="rewardasse" key="rewardtype"/>:</td>
                <td class="form_table_left">
                    <html:select property="_ne_rewardtype">
                    	<option />
                    	<s:Options definition="#CH_DICTITEM" condition="_sne_dictid:-1;groupid:CH_REWARDTYPE"/>
                        			<!-- <html:option value=""></html:option>
                        			<html:option value="0">标准卡固定酬金</html:option>
									<html:option value="1">标准卡积分酬金</html:option>
									<html:option value="2">标准卡专门津贴</html:option>
									<html:option value="3">数据业务基本酬金</html:option>
									<html:option value="4">数据业务奖励酬金</html:option>
									<html:option value="5">服务业务基本酬金</html:option>
									<html:option value="6">服务业务奖励酬金</html:option>
									<html:option value="7">星级酬金</html:option>
									<html:option value="8">项目启动金</html:option>
									<html:option value="51">合作专营酬金</html:option>
									<html:option value="52">销售达标酬金</html:option>
									<html:option value="53">销售超额酬金</html:option>
									<html:option value="30">合作年限奖</html:option> -->
		                		</html:select>
                    
                </td>
    			<td width="80" height="20" align="right" class="form_table_right" >
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
				<c:choose>
					<c:when test="${ISONE eq 'A'}">
                	<td align=right>
                            <input type="button" name="btnImport"  class="button_2" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="导入" onClick="upload();">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/rewardasse.do')">
                        	<input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_search"/>" />
                	</td>
                	</c:when>
                	<c:otherwise>
                	<td align=right>
                            <input type="button" name="btnImport"  class="button_2" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="导入" onClick="upload();">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/rewardasse.do')">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/rewardasse.do')">
                        	<input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_search"/>" />
                	</td>
                	</c:otherwise>
                	</c:choose>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="rewardasse" key="wayid"/></a>
                    <s:OrderImg form="/cms/rewardasse/rewardasseForm" field="wayid3"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('assemonth')"><bean:message bundle="rewardasse" key="assemonth"/></a>
                    <s:OrderImg form="/cms/rewardasse/rewardasseForm" field="assemonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardtype')"><bean:message bundle="rewardasse" key="rewardtype"/></a>
                    <s:OrderImg form="/cms/rewardasse/rewardasseForm" field="rewardtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('assegrade')"><bean:message bundle="rewardasse" key="assegrade"/></a>
                    <s:OrderImg form="/cms/rewardasse/rewardasseForm" field="assegrade"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('memo')"><bean:message bundle="rewardasse" key="memo"/></a>
                    <s:OrderImg form="/cms/rewardasse/rewardasseForm" field="memo"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/rewardasse.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.assemonth}|${item.rewardtype}|${item.wayid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.assemonth}|${item.rewardtype}|${item.wayid}' />"
                                onclick="checkOne(this);" class="table_checkbox">
                     </td>
                     <td>
                     	 <a href='<c:out value="${urlContent}"/>'><c:out value="${item.wayid}"/></a>
                         
                     </td>
                     <td>
                     	<c:out value="${item.assemonth}"/>
                     </td>
                     <td>
                         <s:Code2Name code="${item.rewardtype}" definition="$CH_REWARDTYPE"/>
                     </td>
                     <td><fmt:formatNumber pattern="0.000000" value="${item.assegrade}"/></td>
                     <td><c:out value="${item.memo}"/></td>
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
