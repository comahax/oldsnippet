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
    <title><bean:message bundle="ywjfjlmxb" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_wayid', '<bean:message bundle="ywjfjlmxb" key="wayid"/>', 'c', 'true', '18');
            addfield('_se_calcmonth', '<bean:message bundle="ywjfjlmxb" key="calcmonth"/>', 'c', false, '6');
            addfield('_se_flag', '业务类型', 'c', false, '6000');
            return checkval(window);
        }
        function selectDateYYYYMMDD() {
			var arg = new Object();
			var strTime = "";
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
		function showSelectFlag(){
			var arg = new Object();
			var rtn = window.showModalDialog("<%=contextPath%>/cms/reward/salepointflag.do?CMD=LIST", arg, "dialogWidth=405px;dialogHeight=430px;status:no;scroll=yes;");
			if (document.getElementsByName("_se_flag") != null) {
	//		alert("44444");
	//		alert(rtn[0]+rtn[1]);
	//		alert(rtn);
			var idandnames=rtn.split('|');
			var exh="";
	//		alert(idandnames.length);
			var chk= new Object();
			for(var i=1;i<idandnames.length-1;i++){
	//			chk =document.createElement("<input type=checkbox name='"+idandnames[i]+"' value='"+idandnames[i+1]+"' >"); 
	//			alert("LLLL:"+idandnames[i]);
				exh=exh+idandnames[i]+"|";
	//			if(i%2==0){
	//				exh=exh+"|";
	//			}
			}
			document.getElementsByName("_se_flag")[0].innerHTML=exh;   
			}
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
  			formList.action="<%=contextPath%>/cms/reward/ywjfjlmxb.do?CMD=LIST";
		}
    </script>
    <script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
	<script type="text/javascript"
		src="<%=contextPath%>/js/bus/rescommon.js"></script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/ywjfjlmxb.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/ywjfjlmxb/YwjfjlmxbForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="ywjfjlmxb" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="ywjfjlmxb" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text>
                    <input type="button" value="..." class="clickbutton"
									onclick="showSelectWay3(this,'_se_wayid','','','AG');this.value='...';" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="ywjfjlmxb" key="calcmonth"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_calcmonth"
                    onclick="this.value=selectDateYYYYMM(this.value);" maxlength="6" ></html:text>
                </td>
            </tr>
            <tr>
    			<td width="10%" height="20" align="right" class="form_table_right" >
                	业务类型:
            	</td>
            	<td  width="40%" class="form_table_left">
               		<html:textarea   property="_se_flag" rows="4" cols="30"></html:textarea>
                    <input type="button" value="..." class="clickbutton"
									onclick="showSelectFlag();this.value='...';" />
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
                        <input type="button" class="button_2" onmouseover="buttonover(this);" onclick="doExport('/cms/reward/ywjfjlmxb.do')" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_export"/>" /> 
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
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="ywjfjlmxb" key="wayid"/></a>
                    <s:OrderImg form="/cms/reward/ywjfjlmxb/YwjfjlmxbForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayname')"><bean:message bundle="ywjfjlmxb" key="wayname"/></a>
                    <s:OrderImg form="/cms/reward/ywjfjlmxb/YwjfjlmxbForm" field="wayname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('starlevel')"><bean:message bundle="ywjfjlmxb" key="starlevel"/></a>
                    <s:OrderImg form="/cms/reward/ywjfjlmxb/YwjfjlmxbForm" field="starlevel"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('calcmonth')"><bean:message bundle="ywjfjlmxb" key="calcmonth"/></a>
                    <s:OrderImg form="/cms/reward/ywjfjlmxb/YwjfjlmxbForm" field="calcmonth"/>
                </td>
                <td>
                	业务类型
                </td>
                <td>
                	业务量
                </td>
                 <td>
                	积分标准
                </td>
                 <td>
                	积分
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/reward/ywjfjlmxb.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.wayid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <%-- 
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.wayid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     --%>
                     <td>
                         <c:out value="${item.wayid}"/>
                     </td>
                     <td><c:out value="${item.wayname}"/></td>
                     <td><s:Code2Name code="${item.starlevel}" definition="#CH_STARLEVEL" /></td>
                     <td><c:out value="${item.calcmonth}"/></td>
                     <td>
                     <s:Code2Name code="${item.flag}" definition="$CH_SALEPOINT"/>
                     </td>
                     <td><c:out value="${item.busivalue}"/></td>
                     <td><c:out value="${item.creditstd}"/></td>
                     <td><c:out value="${item.creditaccount}"/></td>
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
