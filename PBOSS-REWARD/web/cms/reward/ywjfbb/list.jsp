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
    <title><bean:message bundle="ywjfbb" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_wayid', '<bean:message bundle="ywjfbb" key="wayid"/>', 'c', 'true', '36');
            addfield('_se_calcmonth', '<bean:message bundle="ywjfbb" key="calcmonth"/>', 'c', false, '6');
            
            return checkval(window);
        }
        function selectDateYYYYMMDD() {
			var arg = new Object();
			strTime = "";
			valTime = event.srcElement.value;
			if (isDateYYYYMMDD(valTime) == false) {
			strTime = "";
			} else {
			strTime = valTime.substring(0, 4) + "-" + valTime.substring(4, 6) + "-01";
			}
			arg.str_datetime = strTime;
			arg.time_comp = false;
			var rtn = window.showModalDialog("<%=contextPath%>/js/pub/calendar.html", arg, "dialogWidth=210px;dialogHeight=240px;status:no;scroll=no;");
			if (rtn != null) {
			rtn = rtn.split("-")[0] + rtn.split("-")[1];
			}
			return (rtn == null ? valTime : rtn);
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
        function doExport(url){
        	if(ev_check() == false ) {
	       	 	return ;
	       	 }
			formList.action = contextPath + url + "?CMD=EXCEL";
  			formList.submit();
  			formList.action="<%=contextPath%>/cms/reward/ywjfbb.do?CMD=LIST";
		}
    </script>
    <script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
	<script type="text/javascript"
		src="<%=contextPath%>/js/bus/rescommon.js"></script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/ywjfbb.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/ywjfbb/YwjfbbForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="ywjfbb" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="ywjfbb" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text><input type="button" value="..." class="clickbutton"
									onclick="showSelectWay3(this,'_se_wayid','','','AG');this.value='...';" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="ywjfbb" key="calcmonth"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_calcmonth" 
                    onclick="this.value=selectDateYYYYMM(this.value);" maxlength="6"></html:text>
                </td>
            </tr>
            <tr>
    			<td width="20%" height="20" align="right" class="form_table_right" >
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
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:PurChk>
                         <input type="button" class="button_2" onmouseover="buttonover(this);" onclick="doExport('/cms/reward/ywjfbb.do')" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_export"/>" /> 
                       <%-- 
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/reward/ywjfbb.do')">
                        </s:PurChk>
                        --%>
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
            <%-- 
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                 --%>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="ywjfbb" key="wayid"/></a>
                    <s:OrderImg form="/cms/reward/ywjfbb/YwjfbbForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('countycompid')"><bean:message bundle="ywjfbb" key="countycompid"/></a>
                    <s:OrderImg form="/cms/reward/ywjfbb/YwjfbbForm" field="countycompid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayname')"><bean:message bundle="ywjfbb" key="wayname"/></a>
                    <s:OrderImg form="/cms/reward/ywjfbb/YwjfbbForm" field="wayname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('chainhead')"><bean:message bundle="ywjfbb" key="chainhead"/></a>
                    <s:OrderImg form="/cms/reward/ywjfbb/YwjfbbForm" field="chainhead"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('countycompname')"><bean:message bundle="ywjfbb" key="countycompname"/></a>
                    <s:OrderImg form="/cms/reward/ywjfbb/YwjfbbForm" field="countycompname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('starlevel')"><bean:message bundle="ywjfbb" key="starlevel"/></a>
                    <s:OrderImg form="/cms/reward/ywjfbb/YwjfbbForm" field="starlevel"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('calcmonth')"><bean:message bundle="ywjfbb" key="calcmonth"/></a>
                    <s:OrderImg form="/cms/reward/ywjfbb/YwjfbbForm" field="calcmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('dzzd')"><bean:message bundle="ywjfbb" key="dzzd"/></a>
                    <s:OrderImg form="/cms/reward/ywjfbb/YwjfbbForm" field="dzzd"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('sr')"><bean:message bundle="ywjfbb" key="sr"/></a>
                    <s:OrderImg form="/cms/reward/ywjfbb/YwjfbbForm" field="sr"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('fsr')"><bean:message bundle="ywjfbb" key="fsr"/></a>
                    <s:OrderImg form="/cms/reward/ywjfbb/YwjfbbForm" field="fsr"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('czjf')"><bean:message bundle="ywjfbb" key="czjf"/></a>
                    <s:OrderImg form="/cms/reward/ywjfbb/YwjfbbForm" field="czjf"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('yckb')"><bean:message bundle="ywjfbb" key="yckb"/></a>
                    <s:OrderImg form="/cms/reward/ywjfbb/YwjfbbForm" field="yckb"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('jtdh')"><bean:message bundle="ywjfbb" key="jtdh"/></a>
                    <s:OrderImg form="/cms/reward/ywjfbb/YwjfbbForm" field="jtdh"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('dhjq')"><bean:message bundle="ywjfbb" key="dhjq"/></a>
                    <s:OrderImg form="/cms/reward/ywjfbb/YwjfbbForm" field="dhjq"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('lxw')"><bean:message bundle="ywjfbb" key="lxw"/></a>
                    <s:OrderImg form="/cms/reward/ywjfbb/YwjfbbForm" field="lxw"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ajh')"><bean:message bundle="ywjfbb" key="ajh"/></a>
                    <s:OrderImg form="/cms/reward/ywjfbb/YwjfbbForm" field="ajh"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/reward/ywjfbb.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.wayid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                    <%-- <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.wayid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                      --%>
                     <td>
                         <c:out value="${item.wayid}"/>
                     </td>
                     <td><c:out value="${item.countycompid}"/></td>
                     <td><c:out value="${item.wayname}"/></td>
                     <td><c:out value="${item.chainhead}"/></td>
                     <td><c:out value="${item.countycompname}"/></td>
                     <td><s:Code2Name code="${item.starlevel}" definition="#CH_STARLEVEL" /></td>
                     <td><c:out value="${item.calcmonth}"/></td>
                     <td><c:out value="${item.dzzd}"/></td>
                     <td><c:out value="${item.sr}"/></td>
                     <td><c:out value="${item.fsr}"/></td>
                     <td><c:out value="${item.czjf}"/></td>
                     <td><c:out value="${item.yckb}"/></td>
                     <td><c:out value="${item.jtdh}"/></td>
                     <td><c:out value="${item.dhjq}"/></td>
                     <td><c:out value="${item.lxw}"/></td>
                     <td><c:out value="${item.ajh}"/></td>
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
