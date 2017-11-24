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
    <title><bean:message bundle="regnewwayemptotal" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_wayid', '<bean:message bundle="regnewwayemptotal" key="wayid"/>', 'c', 'false', '18');
            addfield('_se_countyid', '<bean:message bundle="regnewwayemptotal" key="countyid"/>', 'c', 'false', '14');
            addfield('_se_waymagcode', '<bean:message bundle="regnewwayemptotal" key="waymagcode"/>', 'c', 'false', '18');
            addfield('_se_svccode', '<bean:message bundle="regnewwayemptotal" key="svccode"/>', 'c', 'false', '14');
            addfield('_dnm_oprtime', '<bean:message bundle="regnewwayemptotal" key="oprtime"/>', 'dt', 'false', '7');
            addfield('_dnl_oprtime', '<bean:message bundle="regnewwayemptotal" key="oprtime"/>', 'dt', 'false', '7');
            addfield('_ne_brand', '<bean:message bundle="regnewwayemptotal" key="brand"/>', 'f', 'false', '3');
            return (checkval(window) && compareDate());
        }
        function compareDate(){
	        var startTime2 = document.getElementById('_dnl_oprtime').value;
	        var endTime2 = document.getElementById('_dnm_oprtime').value;
	
	        if (startTime2 == '') {
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<bean:message bundle="regnewwayemptotal" key="_dnl_oprtime"/>]</span> 不能为空';
	        	errorMessageShow(alertstr);
		        return false;
	        }
	        if (endTime2 == '') {
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<bean:message bundle="regnewwayemptotal" key="_dnm_oprtime"/>]</span> 不能为空';
	        	errorMessageShow(alertstr);
		        return false;
	        }
	        
	        if(startTime2 != '' && endTime2 != '' &&  startTime2>endTime2){
		        var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<bean:message bundle="regnewwayemptotal" key="_dnl_oprtime"/> ]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[<<bean:message bundle="regnewwayemptotal" key="_dnm_oprtime"/>]</span>';
				errorMessageShow(alertstr);
		        return false;
	       	}
	   		return true;	
    	}
    	function doExcel(){
	    	formList.action="<%=contextPath%>/cms/regnewwayemptotal.do?CMD=EXCEL";
	    	formList.submit();
	    	formList.action="<%=contextPath%>/cms/regnewwayemptotal.do?CMD=LIST";
    	}
    	function openPicker(control,codeid) {
            if(codeid == '_se_svccode') {
                if(document.all('_se_countyid').value == "") {
    	            // 选择“服务销售中心编码”前要先指定“分公司” 
    	            alert("请先输入"+'<bean:message bundle="regnewwayemptotal" key="countyid"/>');
    	            return;
                }else {
                    // 查询指定“分公司”下的 “服务销售中心编码”
                	condition = '_se_countyid:'+ document.all('_se_countyid').value;
                	var countyid = document.all('_se_countyid').value;
		            var url = contextPath + "/cms/servcent.do?CMD=SHOWDATA";
		            if (countyid != '' && countyid != null) url = url + "&countyid=" + countyid;
					var rtn = window.showModalDialog(url, control, "dialogWidth=570px;dialogHeight=430px;status:no;scroll=yes;");
					if (rtn != null) {
						document.all('_se_svccode').value = rtn;
						return rtn;
					}
                }
            }
    	}
    	function showSelectEmp(control) {
    		var url = contextPath + "/cms/employee.do?CMD=SHOWEMP&isnet=4&empstatus=0";
			var rtn = window.showModalDialog(url, control, "dialogWidth=500px;dialogHeight=430px;status:no;scroll=yes;");
			if (rtn != null) {
				document.all('_se_waymagcode').value = rtn;
				return rtn;
			}
    	}
        function doshowDetail(str, str1, str2){
        	formList.action = "<%=contextPath%>/cms/regnewwayemptotal.do?CMD=SELECTLIST&wayid="+str+"&countyid=" + str1 + "&starlevel="+str2 + "&flg=false";
        	formList.submit();
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/regnewwayemptotal.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"  value="20" />
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/regnewwayemptotal/RegnewwayemptotalForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="regnewwayemptotal" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="regnewwayemptotal" key="waymagcode"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_waymagcode"></html:text>
                    <input type="button" value="..." class="clickbutton" onclick="showSelectEmp(this);" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="regnewwayemptotal" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text>
                    <input type="button" value="..." class="clickbutton" onclick="showSelectWay3(this,'_se_wayid','','','AG');this.value='...';" />
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="regnewwayemptotal" key="countyid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_se_countyid">
                    	<option />
                    	<s:Options definition="#CNTYCOMPANY" condition="citycompid:${requestScope.cityid}"/>
                    </html:select>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="regnewwayemptotal" key="svccode"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_svccode" ></html:text>
                    <input type="button" value="..." class="clickbutton" onclick="javascript:openPicker(this,'_se_svccode');" />
                </td>
            </tr>
            <tr><td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="regnewwayemptotal" key="_dnl_oprtime"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_oprtime" onclick="selectDatetime();"></html:text>
                    <font color="red">*</font>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="regnewwayemptotal" key="_dnm_oprtime"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_oprtime" onclick="selectDatetime();"></html:text>
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="regnewwayemptotal" key="brand"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_ne_brand">
                    	<option />
                    	<s:Options definition="$CH_SIMBRAND" />
                    </html:select>
                </td>
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
                        <input type="button" id="btnExportexcel" name="btnExportexcel" class="button_4" onmouseover="buttonover(this);"
	                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                        value="导出EXCEL" onClick="doExcel()">
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="regnewwayemptotal" key="wayid"/></a>
                    <s:OrderImg form="/cms/regnewwayemptotal/RegnewwayemptotalForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayname')"><bean:message bundle="regnewwayemptotal" key="wayname"/></a>
                    <s:OrderImg form="/cms/regnewwayemptotal/RegnewwayemptotalForm" field="wayname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('countyid')"><bean:message bundle="regnewwayemptotal" key="countyid"/></a>
                    <s:OrderImg form="/cms/regnewwayemptotal/RegnewwayemptotalForm" field="countyid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('starlevel')"><bean:message bundle="regnewwayemptotal" key="starlevel"/></a>
                    <s:OrderImg form="/cms/regnewwayemptotal/RegnewwayemptotalForm" field="starlevel"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('amt')"><bean:message bundle="regnewwayemptotal" key="amt"/></a>
                    <s:OrderImg form="/cms/regnewwayemptotal/RegnewwayemptotalForm" field="amt"/>
                </td>
                <td>
                    操作
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center">
                     <td><c:out value="${item.wayid}"/></td>
                     <td><c:out value="${item.wayname}"/></td>
                     <td><s:Code2Name code="${item.countyid}" definition="#CNTYCOMPANY"/></td>
                     <td><s:Code2Name code="${item.starlevel}" definition="$CH_STARLEVEL"/></td>
                     <td><c:out value="${item.amt}"/></td>
                     <td>
                     <input type="button" id="btnUpdate" name="btnUpdate"
						class="button_2" onmouseover="buttonover(this);"
						onmouseout="buttonout(this);" onfocus="buttonover(this)"
						onblur="buttonout(this)" value="查看明细"
						onClick="doshowDetail('<c:out value="${item.wayid}"/>','<c:out value="${item.countyid}"/>','<c:out value="${item.starlevel}"/>');">
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
