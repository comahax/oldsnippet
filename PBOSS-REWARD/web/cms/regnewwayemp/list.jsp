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
    <title><bean:message bundle="regnewwayemp" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_wayid', '<bean:message bundle="regnewwayemp" key="wayid"/>', 'c', 'false', '18');
            addfield('_se_waymagcode', '<bean:message bundle="regnewwayemp" key="waymagcode"/>', 'c', 'false', '18');
            addfield('_se_countyid', '<bean:message bundle="regnewwayemp" key="countyid"/>', 'c', 'false', '14');
            addfield('_ne_brand', '<bean:message bundle="regnewwayemp" key="brand"/>', 'f', 'false', '3');
            addfield('_se_opnid', '<bean:message bundle="regnewwayemp" key="opnid"/>', 'c', 'false', '18');
            addfield('_dnm_oprtime', '<bean:message bundle="regnewwayemp" key="oprtime"/>', 'dt', 'false', '7');
            addfield('_dnl_oprtime', '<bean:message bundle="regnewwayemp" key="oprtime"/>', 'dt', 'false', '7');
            addfield('_se_oprcode', '<bean:message bundle="regnewwayemp" key="oprcode"/>', 'c', 'false', '15');
            addfield('_se_svccode', '<bean:message bundle="regnewwayemp" key="svccode"/>', 'c', 'false', '14');
            return (checkval(window) && compareDate());
        }
    function compareDate(){
        var startTime2 = document.getElementById('_dnl_oprtime').value;
        var endTime2 = document.getElementById('_dnm_oprtime').value;

        if (startTime2 == '') {
        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<bean:message bundle="regnewwayemp" key="_dnl_oprtime"/>]</span> 不能为空';
        	errorMessageShow(alertstr);
	        return false;
        }
        if (endTime2 == '') {
        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<bean:message bundle="regnewwayemp" key="_dnm_oprtime"/>]</span> 不能为空';
        	errorMessageShow(alertstr);
	        return false;
        }
       
        if(startTime2 != '' && endTime2 != '' &&  startTime2>endTime2){
	        var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<bean:message bundle="regnewwayemp" key="_dnl_oprtime"/> ]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[<bean:message bundle="regnewwayemp" key="_dnm_oprtime"/>]</span>';
			errorMessageShow(alertstr);
	        return false;
       	}
        
   		return true;	
    }
	function doExcel(){
    	formList.action="<%=contextPath%>/cms/regnewwayemp.do?CMD=EXCEL";
    	formList.submit();
    	formList.action="<%=contextPath%>/cms/regnewwayemp.do?CMD=LIST";
    }
    function doExportTxt(cmd){
 			var actionUrl = formList.action;
			formList.action = contextPath + cmd;
      		formList.submit();
      		formList.action = actionUrl;
		} 
    function openPicker(control,codeid) {
            if(codeid == '_se_svccode') {
                if(document.all('_se_countyid').value == "") {
    	            // 选择“服务销售中心编码”前要先指定“分公司” 
    	            alert("请先输入"+'<bean:message bundle="regnewwayemp" key="countyid"/>');
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
            if(codeid == '_se_oprcode') {
                if(document.all('_se_wayid').value == "") {
    	            // 选择“店员姓名”前要先指定“网点编码” 
    	            alert("请先输入"+'<bean:message bundle="regnewwayemp" key="wayid"/>');
    	            return;
                } else {
                    // 查询指定“网点编码”下的 “店员姓名”也就是id和name
                	var wayid = document.all('_se_wayid').value;
                	var url = contextPath + "/cms/employee.do?CMD=SHOWEMP";
                	if (wayid != "" && wayid != null) {url = url + "&wayid=" + wayid;}
					var rtn = window.showModalDialog(url, control, "dialogWidth=500px;dialogHeight=430px;status:no;scroll=yes;");
					if (rtn != null) {
						document.all('_se_oprcode').value = rtn;
						return rtn;
					}
                }
            }
    	    /*if(definition == null || definition =="") {	  	    			
    	   		alert("definition is required!");
    	   		return ;
    	    }	*/
    	}
    	function showSelectEmp(control) {
    		var url = contextPath + "/cms/employee.do?CMD=SHOWEMP&isnet=4&empstatus=0";
			var rtn = window.showModalDialog(url, control, "dialogWidth=500px;dialogHeight=430px;status:no;scroll=yes;");
			if (rtn != null) {
				document.all('_se_waymagcode').value = rtn;
				return rtn;
			}
    	}
      
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/regnewwayemp.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize" value="20" />
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/regnewwayemp/RegnewwayempForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="regnewwayemp" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="regnewwayemp" key="waymagcode"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_waymagcode"></html:text>
                    <input type="button" value="..." class="clickbutton" onclick="showSelectEmp(this);" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="regnewwayemp" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text>
                    <input type="button" value="..." class="clickbutton" onclick="showSelectWay3(this,'_se_wayid','','','AG');this.value='...';" />
                </td>
            </tr>
            <tr>
            	<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="regnewwayemp" key="oprcode"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_oprcode"></html:text>
                    <input type="button" value="..." class="clickbutton" onclick="javascript:openPicker(this,'_se_oprcode');" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="regnewwayemp" key="countyid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_se_countyid">
                    	<option />
                    	<s:Options definition="#CNTYCOMPANY" condition="citycompid:${requestScope.cityid}"/>
                    </html:select>
                </td>
                
            </tr>
            <tr>
                 <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="regnewwayemp" key="svccode"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_svccode"></html:text>
                    <input type="button" value="..." class="clickbutton" onclick="javascript:openPicker(this,'_se_svccode');" />
                </td>
            	<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="regnewwayemp" key="opnid"/>:</td>
                <td width="30%" class="form_table_left">
                    <s:zoom definition="#OPERATIONSMS" property="_se_opnid" styleClass="form_input_1x" readonly="true" condition="cityid:${requestScope.cityid};opntype:2;smsno:10086111"/>
                </td>
            </tr>
            <tr>
            	<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="regnewwayemp" key="oprtime"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_oprtime"  onclick="selectDatetime();"></html:text>
                    <font color="red">*</font>
                </td>
                
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="regnewwayemp" key="oprtime"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_oprtime"  onclick="selectDatetime();"></html:text>
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="regnewwayemp" key="brand"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_ne_brand">
                    	<option />
                    	<s:Options definition="$CH_SIMBRAND" />
                    </html:select>
                </td>
                <td>
                </td>
                <td>
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
                        <s:PurChk controlid="<%=ID_1%>">
                        <input type="button" id="btnExportexcel" name="btnExportexcel" class="button_4" onmouseover="buttonover(this);"
	                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                        value="导出EXCEL" onClick="doExcel()">
	                    </s:PurChk>
	                    <s:PurChk controlid="<%=ID_2%>">
	                    <input type="button" id="btnExporttxt" name="btnExporttxt"
							class="button_4" onmouseover="buttonover(this);"
							onmouseout="buttonout(this);" onfocus="buttonover(this)"
							onblur="buttonout(this)"
							value="导出TXT" onClick="doExportTxt('/cms/regnewwayemp.do?CMD=EXPORTTXT');">
						</s:PurChk>
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="regnewwayemp" key="wayid"/></a>
                    <s:OrderImg form="/cms/regnewwayemp/RegnewwayempForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayname')"><bean:message bundle="regnewwayemp" key="wayname"/></a>
                    <s:OrderImg form="/cms/regnewwayemp/RegnewwayempForm" field="wayname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('name')"><bean:message bundle="registersimvw" key="employeeid"/></a>
                    <s:OrderImg form="/cms/reward/registersimvw/RegistersimvwForm" field="name"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('countyid')"><bean:message bundle="regnewwayemp" key="countyid"/></a>
                    <s:OrderImg form="/cms/regnewwayemp/RegnewwayempForm" field="countyid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('starlevel')"><bean:message bundle="regnewwayemp" key="starlevel"/></a>
                    <s:OrderImg form="/cms/regnewwayemp/RegnewwayempForm" field="starlevel"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('employeename')"><bean:message bundle="regnewwayemp" key="employeename"/></a>
                    <s:OrderImg form="/cms/regnewwayemp/RegnewwayempForm" field="employeename"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('officetel')"><bean:message bundle="regnewwayemp" key="officetel"/></a>
                    <s:OrderImg form="/cms/regnewwayemp/RegnewwayempForm" field="officetel"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mobile')"><bean:message bundle="regnewwayemp" key="mobile"/></a>
                    <s:OrderImg form="/cms/regnewwayemp/RegnewwayempForm" field="mobile"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('brand')"><bean:message bundle="regnewwayemp" key="brand"/></a>
                    <s:OrderImg form="/cms/regnewwayemp/RegnewwayempForm" field="brand"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="regnewwayemp" key="opnid"/></a>
                    <s:OrderImg form="/cms/regnewwayemp/RegnewwayempForm" field="opnid"/>
                </td>
                <td>
                     业务名称
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtime')"><bean:message bundle="regnewwayemp" key="oprtime"/></a>
                    <s:OrderImg form="/cms/regnewwayemp/RegnewwayempForm" field="oprtime"/>
                </td>
                
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/regnewwayemp.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seqid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     
                     <td><c:out value="${item.wayid}"/></td>
                     <td><c:out value="${item.wayname}"/></td>
                     <td><c:out value="${item.name}"/></td>
                     <td><s:Code2Name code="${item.countyid}" definition="#CNTYCOMPANY"/></td>
                     <td><s:Code2Name code="${item.starlevel}" definition="$CH_STARLEVEL"/></td>
                     <td><c:out value="${item.employeename}"/></td>
                     <td><c:out value="${item.officetel}"/></td>
                     <td><c:out value="${item.mobile}"/></td>
                     <td><s:Code2Name code="${item.brand}" definition="$CH_SIMBRAND"/></td>
                     <td><c:out value="${item.opnid}"/></td>
                     <td><c:out value="${item.opnname}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.oprtime}" /></td>
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
