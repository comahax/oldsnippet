<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ page import="org.ajaxanywhere.*"%>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa"%>
<%
	String ID_1 = "CH_B2M_REWARD_ADJIMPORT||CH_B2M_REWARD";//导入按钮和删除按钮和查询令牌为省级令牌
	String ID_2 = "CH_B2M_REWARD_ADJAUDIT||CH_B2M_REWARD";//审核令牌
	String ID_3 = "00010703";
	String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="bbcadjust" key="titleUnpbList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/bus/rescommon.js"></script>
	<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_adjustkind', '<bean:message bundle="bbcadjust" key="adjustkind"/>', 'c', true, '32');
            addfield('_se_wayid', '<bean:message bundle="bbcadjust" key="wayid"/>', 'c', true, '18');
            addfield('_snl_eftmonth', '<bean:message bundle="bbcadjust" key="eftmonth"/>', 'c', true, '6');
            addfield('_snm_eftmonth', '<bean:message bundle="bbcadjust" key="eftmonth"/>', 'c', true, '6');
            addfield('_se_adjusttype', '<bean:message bundle="bbcadjust" key="adjusttype"/>', 'c', true, '32');
            addfield('_se_reasontype', '<bean:message bundle="bbcadjust" key="reasontype"/>', 'c', true, '32');
            addfield('_ne_islock', '<bean:message bundle="bbcadjust" key="islock"/>', 'f', true, '3');
            addfield('_se_srcmonth', '<bean:message bundle="bbcadjust" key="srcmonth"/>', 'c', true, '6');
            return checkval(window);
        }
        
         function loadDataInContent(){
         	var form=document.forms[0];
        	form.submit();
        }
        
        function upload(){
			var form=document.forms[0];
			form.action="<%=contextPath%>/cms/bbc/bbcadjust/batchunpbupfile.jsp";
			form.submit();
		}
		
		function doAuditing(){
        		var url = '<%=contextPath%>/cms/waitaudit.do?CMD=LIST&ISAUDIT=UNPB';
		    	formList.action = url;
		    	formList.submit();
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/bbc/bbcadjust.do?CMD=UNPBLIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/bbc/bbcadjust/BbcadjustForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="bbcadjust" key="titleUnpbList"/>
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
				<td width="126" height="20" align="right"
					class="form_table_right">
					<bean:message bundle="bbcadjust" key="adjustkind" />:
				</td>
				<td class="form_table_left">
					<html:select property="_se_adjustkind"
						onchange="loadDataInContent();">
						<option />
							<s:Options definition="$CH_BBCADJUSTKIND" />
					</html:select>
				</td>
				<td width="126" height="20" align="right"
					class="form_table_right">
					<bean:message bundle="bbcadjust" key="wayid" />:
				</td>
				<td class="form_table_left">
					<html:text styleClass="form_input_1x"
						onclick="showSelectWay(this,'_se_wayid')" property="_se_wayid" />
				</td>
				<td width="126" height="20" align="right"
					class="form_table_right">
					<bean:message bundle="bbcadjust" key="_snl_eftmonth" />:
				</td>
				<td class="form_table_left">
					<html:text styleClass="form_input_1x" property="_snl_eftmonth"></html:text>
				</td>
			</tr>
			<tr>
				<td width="126" height="20" align="right"
					class="form_table_right">
					<bean:message bundle="bbcadjust" key="_snm_eftmonth" />:
				</td>
				<td class="form_table_left">
					<html:text styleClass="form_input_1x" property="_snm_eftmonth"></html:text>
				</td>
				<td width="126" height="20" align="right"
					class="form_table_right">
					<bean:message bundle="bbcadjust" key="islock" />:
				</td>
				<td class="form_table_left">
					<html:select property="_ne_islock">
						<option />
						<option value="1">未锁定（已审核）</option>
						<option value="2">已锁定（已审核）</option>
					</html:select>
				</td>
				<td width="126" height="20" align="right"
					class="form_table_right">
					<bean:message bundle="bbcadjust" key="reasontype" />:
				</td>
				<td class="form_table_left">
					<aa:zone name="zone1">
						<html:select property="_sk_reasontype">
							<option />
								<s:Options definition="#CH_DICTITEM"
									condition="_sk_dictid:${form.dictid};groupid:CH_BBCREASONTYPE" />
						</html:select>
					</aa:zone>
				</td>
			</tr>
			<tr>
				<td width="126" height="20" align="right" class="form_table_right">
					<bean:message bundle="bbcadjust" key="srcmonth" />:
				</td>
				<td class="form_table_left">
					<html:text styleClass="form_input_1x" property="_se_srcmonth" onclick="this.value=selectDateYYYYMM();"></html:text>
				</td>
				<td width="126" height="20" align="right"
					class="form_table_right">
				</td>
				<td class="form_table_left">
				</td>
				<td width="80" height="20" align="right" class="form_table_right">
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
					<s:RewardPurChk controlid="<%=ID_2%>" disableChild="true">
					<input type="button" name="btnAuditing" class="button_2"
						onmouseover="buttonover(this);" onmouseout="buttonout(this);"
						onfocus="buttonover(this)" onblur="buttonout(this)"
						value='<bean:message bundle="bbcadjust" key="auditing"/>'
						onClick="doAuditing();">
					</s:RewardPurChk>
					<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
					<input type="button" name="btnDelete" class="delete"
						onmouseover="buttonover(this);" onmouseout="buttonout(this);"
						onfocus="buttonover(this)" onblur="buttonout(this)"
						value="<bean:message bundle="public" key="button_delete"/>"
						onClick="doDelete('/cms/bbc/bbcadjust.do?CMD=UNPBDELETE')">
					</s:RewardPurChk>
					<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
						<input type="submit" class="query"
							onmouseover="buttonover(this);" onmouseout="buttonout(this);"
							onfocus="buttonover(this)" onblur="buttonout(this)"
							value="<bean:message bundle="public" key="button_search"/>" />
					</s:RewardPurChk>
					<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
					<input type="button" name="btnImport" class="button_2"
						onmouseover="buttonover(this);" onmouseout="buttonout(this);"
						onfocus="buttonover(this)" onblur="buttonout(this)" value="导入"
						onClick="upload();" />
					</s:RewardPurChk>
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
						<a href="javascript:doOrderby('seq')"><bean:message
								bundle="bbcadjust" key="seq" /> </a>
						<s:OrderImg form="/cms/bbc/bbcadjust/BbcadjustForm"
							field="seq" />
					</td>
					<td>
						<a href="javascript:doOrderby('adjustkind')"><bean:message
								bundle="bbcadjust" key="adjustkind" /> </a>
						<s:OrderImg form="/cms/bbc/bbcadjust/BbcadjustForm"
							field="adjustkind" />
					</td>
					<td>
						<a href="javascript:doOrderby('wayid')"><bean:message
								bundle="bbcadjust" key="wayid" /> </a>
						<s:OrderImg form="/cms/bbc/bbcadjust/BbcadjustForm"
							field="wayid" />
					</td>
					<td>
						渠道名称
					</td>
					<td>
						<a href="javascript:doOrderby('eftmonth')"><bean:message
								bundle="bbcadjust" key="eftmonth" /> </a>
						<s:OrderImg form="/cms/bbc/bbcadjust/BbcadjustForm"
							field="eftmonth" />
					</td>
					<td>
						<a href="javascript:doOrderby('adjmoney')"><bean:message
								bundle="bbcadjust" key="adjmoney" /> </a>
						<s:OrderImg form="/cms/bbc/bbcadjust/BbcadjustForm"
							field="adjmoney" />
					</td>
					<td>
						<a href="javascript:doOrderby('actualmoney')"><bean:message
								bundle="bbcadjust" key="actualmoney" /> </a>
						<s:OrderImg form="/cms/bbc/bbcadjust/BbcadjustForm"
							field="actualmoney" />
					</td>
					<td>
						<a href="javascript:doOrderby('rewardtype')"><bean:message
								bundle="bbcadjust" key="rewardtype" /> </a>
						<s:OrderImg form="/cms/bbc/bbcadjust/BbcadjustForm"
							field="rewardtype" />
					</td>
					<td>
						<a href="javascript:doOrderby('adjusttype')"><bean:message
								bundle="bbcadjust" key="adjusttype" /> </a>
						<s:OrderImg form="/cms/bbc/bbcadjust/BbcadjustForm"
							field="adjusttype" />
					</td>
					<td>
						<a href="javascript:doOrderby('reasontype')"><bean:message
								bundle="bbcadjust" key="reasontype" /> </a>
						<s:OrderImg form="/cms/bbc/bbcadjust/BbcadjustForm"
							field="reasontype" />
					</td>
					<td>
						<a href="javascript:doOrderby('remark')"><bean:message
								bundle="bbcadjust" key="remark" /> </a>
						<s:OrderImg form="/cms/bbc/bbcadjust/BbcadjustForm"
							field="remark" />
					</td>
					<td>
						<a href="javascript:doOrderby('srcmonth')"><bean:message
								bundle="bbcadjust" key="srcmonth" /> </a>
						<s:OrderImg form="/cms/bbc/bbcadjust/BbcadjustForm"
							field="srcmonth" />
					</td>
					<td>
						<a href="javascript:doOrderby('relateseq')"><bean:message
								bundle="bbcadjust" key="relateseq" /> </a>
						<s:OrderImg form="/cms/bbc/bbcadjust/BbcadjustForm"
							field="relateseq" />
					</td>
					<td>
						<a href="javascript:doOrderby('islock')"><bean:message
								bundle="bbcadjust" key="islock" /> </a>
						<s:OrderImg form="/cms/bbc/bbcadjust/BbcadjustForm"
							field="islock" />
					</td>
					<td>
						<a href="javascript:doOrderby('createoprcode')"><bean:message
								bundle="bbcadjust" key="createoprcode" /> </a>
						<s:OrderImg form="/cms/bbc/bbcadjust/BbcadjustForm"
							field="createoprcode" />
					</td>
					<td>
						<a href="javascript:doOrderby('createtime')"><bean:message
								bundle="bbcadjust" key="createtime" /> </a>
						<s:OrderImg form="/cms/bbc/bbcadjust/BbcadjustForm"
							field="createtime" />
					</td>
					<td>
						<a href="javascript:doOrderby('adtoprcode')"><bean:message
								bundle="bbcadjust" key="adtoprcode" /> </a>
						<s:OrderImg form="/cms/bbc/bbcadjust/BbcadjustForm"
							field="adtoprcode" />
					</td>
					<td>
						<a href="javascript:doOrderby('adttime')"><bean:message
								bundle="bbcadjust" key="adttime" /> </a>
						<s:OrderImg form="/cms/bbc/bbcadjust/BbcadjustForm"
							field="adttime" />
					</td>
					<td>
						<a href="javascript:doOrderby('updateoprcode')"><bean:message
								bundle="bbcadjust" key="updateoprcode" /> </a>
						<s:OrderImg form="/cms/bbc/bbcadjust/BbcadjustForm"
							field="updateoprcode" />
					</td>
					<td>
						<a href="javascript:doOrderby('updatetime')"><bean:message
								bundle="bbcadjust" key="updatetime" /> </a>
						<s:OrderImg form="/cms/bbc/bbcadjust/BbcadjustForm"
							field="updatetime" />
					</td>
				</tr>
				<c:forEach var="item" items="${requestScope.LIST.datas}">
					<c:url value="/cms/bbc/bbcadjust.do?CMD=EDIT" var="urlContent">
						<c:param name="PK" value="${item.seq}" />
						<%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
					</c:url>
					<tr class="table_style_content" align="center">
						<td>
							<c:choose>
								<c:when
									test="${item.islock eq '2' or item.createoprcode eq 'REWARD-SYSTEM'}">
									<input type="checkbox" name="_selectitem"
										value="<c:out value='${item.seq}' />" onclick="checkOne();"
										class="table_checkbox" disabled="true">

								</c:when>
								<c:otherwise>
									<input type="checkbox" name="_selectitem"
										value="<c:out value='${item.seq}' />" onclick="checkOne();"
										class="table_checkbox">
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:out value="${item.seq}" />
						</td>
						<td>
							<s:Code2Name code="${item.adjustkind}"
								definition="$CH_BBCADJUSTKIND" />
						</td>
						<td>
							<c:out value="${item.wayid}" />
						</td>
						<td>
							<s:Code2Name code="${item.wayid}" definition="#WAY" />
						</td>
						<td>
							<c:out value="${item.eftmonth}" />
						</td>
						<td>
							<fmt:formatNumber pattern="0.00" value="${item.adjmoney}" />
						</td>
						<td>
							<fmt:formatNumber pattern="0.00" value="${item.actualmoney}" />
						</td>
						<td>
							<s:Code2Name code="${item.rewardtype}"
								definition="$CH_BBCREWARDTYPE" />
						</td>
						<td>
							<s:Code2Name code="${item.adjusttype}"
								definition="$CH_RWADJUSTTYPE" />
						</td>
						<td>
							<s:MoreCode2Name code="${item.reasontype}"
								definition="$CH_BBCREASONTYPE" />
						</td>
						<td>
							<c:out value="${item.remark}" />
						</td>
						<td>
							<c:out value="${item.srcmonth}" />
						</td>
						<td>
							<c:out value="${item.relateseq}" />
						</td>
						<td>
							<s:Code2Name code="${item.islock}" definition="#ISLOCK" />
						</td>
						<td>
							<c:out value="${item.createoprcode}" />
						</td>
						<td>
							<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
								value="${item.createtime}" />
						</td>
						<td>
							<c:out value="${item.adtoprcode}" />
						</td>
						<td>
							<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.adttime}" />
						</td>
						<td>
							<c:out value="${item.updateoprcode}" />
						</td>
						<td>
							<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
								value="${item.updatetime}" />
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
