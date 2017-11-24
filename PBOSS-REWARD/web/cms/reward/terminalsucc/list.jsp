<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="terminalsucc" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
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
			var rtn = window.showModalDialog("../../js/pub/calendar.html", arg, "dialogWidth=210px;dialogHeight=240px;status:no;scroll=no;");
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
		
		var cityFlag;
		function selectCity(){
      		var flag = 0;
	      	<s:RewardPurChk controlid="<%=ID_1%>">flag = 1</s:RewardPurChk>
	      	if(flag == 0){
	      		formList._se_cityid.disabled = false;
	      		cityFlag = formList._se_cityid.value;
	      		formList._se_cityid.disabled = true;
      		}else{
      			formList._se_cityid.disabled = false;
	      		cityFlag = formList._se_cityid.value;
      		}
      	}
      	
      	function doExport(){
			var form=document.forms[0];
			form.action="<%=contextPath%>/cms/reward/terminalsucc.do?CMD=TXT";
			form.submit();
			form.action="<%=contextPath%>/cms/reward/terminalsucc.do?CMD=LIST";
		}
    </script>
    <script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
	<script type="text/javascript"
			src="<%=contextPath%>/js/bus/rescommon.js"></script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();selectCity();">
<div class="table_container">
<html:form action="/cms/reward/terminalsucc.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/terminalsucc/TerminalsuccForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="terminalsucc" key="titleList"/>
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
       			<td width="20%" height="20" align="right" class="form_table_right" >
       				<bean:message bundle="terminalsucc" key="comid" />:
       			</td>
       			<td width="30%" class="form_table_left">
       				<html:text styleClass="form_input_1x" property="_se_comid" />
       			</td>
       			<td width="20%" height="20" align="right" class="form_table_right" >
       				<bean:message bundle="terminalsucc" key="cityid" />:
       			</td>
       			<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true" >
       			<td width="30%" class="form_table_left">
       				<html:select property="_se_cityid" onchange="cityFlag=this.value;">
						<html:option value=""></html:option>
						<html:option value="200">广州</html:option>
						<html:option value="755">深圳</html:option>
						<html:option value="756">珠海</html:option>
						<html:option value="757">佛山</html:option>
						<html:option value="754">汕头</html:option>
						<html:option value="752">惠州</html:option>
						<html:option value="759">湛江</html:option>
						<html:option value="750">江门</html:option>
						<html:option value="758">肇庆</html:option>
						<html:option value="751">韶关</html:option>
						<html:option value="753">梅州</html:option>
						<html:option value="769">东莞</html:option>
						<html:option value="760">中山</html:option>
						<html:option value="668">茂名</html:option>
						<html:option value="660">汕尾</html:option>
						<html:option value="768">潮州</html:option>
						<html:option value="663">揭阳</html:option>
						<html:option value="662">阳江</html:option>
						<html:option value="763">清远</html:option>
						<html:option value="762">河源</html:option>
						<html:option value="766">云浮</html:option>
					</html:select>
       			</td>
       			</s:RewardPurChk>
       		</tr>
            <tr>
            	<td width="20%" height="20" align="right" class="form_table_right" >
       				<bean:message bundle="terminalsucc" key="wayid" />:
       			</td>
       			<td width="30%" class="form_table_left">
       				<html:text styleClass="form_input_1x" property="_se_wayid" /><input type="button" value="..." class="clickbutton"
									onclick="showWayByCityid(this,'_se_wayid',cityFlag,'AG');this.value='...';"/>
       			</td>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="terminalsucc" key="calcmonth" />:
            	</td>
            	<td width="30%" class="form_table_left">
               	<html:text styleClass="form_input_1x" property="_se_calcmonth"
									onclick="this.value=selectDateYYYYMM(this.value);" readonly="true" />
            	</td>
            </tr>
            <tr>
            	<td width="20%" height="20" align="right" class="form_table_right" >
       				<bean:message bundle="terminalsucc" key="chainhead" />:
       			</td>
       			<td width="30%" class="form_table_left">
            		<s:zoom definition="#WAY" property="_se_chainhead"
											styleClass="form_input_1x" condition="waytype:${'AG'};waysubtype:${'DIS'};upperwayid:${'DIS-----'}"/>
				</td>
				<td width="20%" height="20" align="right" class="form_table_right" >
				</td>
				<td width="30%" class="form_table_left">
				</td>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                	<input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                    onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                    value="导出" onClick="doExport();">
                    <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
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
                    <bean:message bundle="terminalsucc" key="cityid"/>
                </td>
                <td>
                    <bean:message bundle="terminalsucc" key="comid"/>
                </td>
                <td>
                    <bean:message bundle="terminalsucc" key="opnid"/>
                </td>
                <td>
                    <bean:message bundle="terminalsucc" key="wayid"/>
                </td>
                <td>
                   <bean:message bundle="terminalsucc" key="calcmonth"/>
                   
                </td>
                <td>
                    <bean:message bundle="terminalsucc" key="busivalue"/>
                    
                </td>
              
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center">
                     <td><s:Code2Name code="${item.cityid}"
											definition="$region" /></td>
                     <td><c:out value="${item.comid}"/></td>
                     <td><c:out value="${item.opnid}"/>-<s:Code2Name code="${item.opnid}"
											definition="#OPERATION" /></td>
                     <td><s:Code2Name code="${item.wayid}"
											definition="#WAY" /></td>
                     <td><c:out value="${item.calcmonth}"/></td>
                     <td><c:out value="${item.busivalue}"/></td>
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
