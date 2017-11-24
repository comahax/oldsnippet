<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa" %>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "CH_ADT_CITYRECORD_UPLOAD";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="cityrecord" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/jquery/jquery-1.3.2.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_recordid', '<bean:message bundle="cityrecord" key="recordid"/>', 'f', 'false', '14');
            //addfield('_se_opnid', '<bean:message bundle="cityrecord" key="opnid"/>', 'c', 'false', '18');
            addfield('_sin_opnid', '<bean:message bundle="cityrecord" key="opnid"/>', 'c', 'false', '2000');
            addfield('_se_wayid', '<bean:message bundle="cityrecord" key="wayid"/>', 'c', 'false', '18');
            addfield('_ne_rewardtype', '<bean:message bundle="cityrecord" key="rewardtype"/>', 'f', 'false', '3');
            addfield('_se_rewardmonth', '<bean:message bundle="cityrecord" key="rewardmonth"/>', 'c', 'true', '6');
            //addfield('_se_approveid', '<bean:message bundle="cityrecord" key="approveid"/>', 'c', 'false', '32');
            addfield('_ne_isflag', '<bean:message bundle="cityrecord" key="isflag"/>', 'f', 'false', '3');
            addfield('_ne_systemflag', '<bean:message bundle="cityrecord" key="systemflag"/>', 'f', 'false', '3');
            addfield('_nne_systemflag', '<bean:message bundle="cityrecord" key="systemflag"/>', 'f', 'false', '3');
            addfield('_ne_rewardlistid', '<bean:message bundle="cityrecord" key="rewardlistid"/>', 'f', 'false', '14');
            addfield('_se_mobile', '业务发生号码', 'c', 'false', '15');
            return (checkval(window) && checkParam());
        }
        function checkParam(){
        	var rewardmonth = document.getElementById('_se_rewardmonth').value;
        	var isflag = document.getElementById('_ne_isflag').value;
        	var systemflag = document.getElementById('_ne_systemflag').value;
        	var taskid = document.getElementById('_ne_taskid').value;
        	taskid = trim(taskid);
        	if(taskid==null || taskid===''){
        		if(rewardmonth == ''){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[结算月份]</span> 不能为空 ';
				errorMessageShow(alertstr);
				return false;
        		}
        		if(isflag == ''){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[结算状态]</span> 不能为空 ';
				errorMessageShow(alertstr);
				return false;
        		}
        	}else if(2==systemflag || 3==systemflag){
        		var alertstr = '<span class=\'errorkey\'>使用<span style=\'color:#F00; font-size:12px;\'>[任务号]</span>只能查询地市上传酬金 ';
				errorMessageShow(alertstr);
				return false;
        	}
        	return true;
        }
        function doImport(url){
        	formList.action=contextPath + url + "?CMD=IMPORT";
			formList.submit();
		}
        function doIssue(cmdDelete) {        
        	var isflag = document.getElementById('_ne_isflag').value;
        	var systemflag = document.getElementById('_ne_systemflag').value;
        	if(isflag != 1){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[结算状态]</span>只能是待确认';
				errorMessageShow(alertstr);
				return false;
        	}
        	if( systemflag!=2 && systemflag!=3){
        		var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[计酬系统]</span>必须为[社会渠道酬金]或者[创新联盟酬金]才需要同步 ';
				errorMessageShow(alertstr);
				return false;
        	}  
        	
            var TO = true;
            var sis = formList.all("_selectitem");
            if (forincheck(TO,sis,"确定要同步这些记录吗？")){
            	formList.action = addParam(contextPath + cmdDelete, 'CMD', 'ISSUE');
            	formList.submit();
            	}  
        }
        function doAllissue(url) { 
			var rewardmonth = document.getElementById('_se_rewardmonth').value;
        	var isflag = document.getElementById('_ne_isflag').value;
        	var systemflag = document.getElementById('_ne_systemflag').value;
        	if(rewardmonth == ''){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[结算月份]</span> 不能为空 ';
				errorMessageShow(alertstr);
				return false;
        	}
        	if(isflag != 1){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[结算状态]只能是待确认</span>  ';
				errorMessageShow(alertstr);
				return false;
        	}
        	if( systemflag!=2 && systemflag!=3){
        		var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[计酬系统]</span>必须为[社会渠道酬金]或者[创新联盟酬金]才需要同步 ';
				errorMessageShow(alertstr);
				return false;
        	}
			if(ev_check()){
				formList.action="<%=contextPath%>"+url;
				formList.submit();
			}
			
        }
        function doAffirmgather(url){ 
        	formList.action=contextPath + url + "?CMD=AFFIRMGATHER";
			formList.submit();
		}
		function upload(){
			formList.action="<%=contextPath%>/cms/reward/adtrewardupload/list.jsp";
			formList.submit();
		}
		function doshowDetail(wayid, opnid, rewardmonth, rewardtype){  
        	formList.action = "<%=contextPath%>/cms/cityrecord.do?CMD=SELECTLIST&wayid="+wayid+"&opnid=" + opnid + "&rewardmonth="+rewardmonth + "&rewardtype="+rewardtype + "&flg=false";
        	formList.submit();
		}
		function doExcel(){ 
			if(ev_check()){ 
				formList.action = "<%=contextPath%>/cms/cityrecord.do?CMD=EXCEL";
        		formList.submit();
			}
		}
		function doTxtdetail(){ 
			var isflag = document.getElementById('_ne_isflag').value;
        	var systemflag = document.getElementById('_ne_systemflag').value;
        	var rewardmonth = document.getElementById('_se_rewardmonth').value;
        	if(rewardmonth == ''){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[结算月份]</span> 不能为空 ';
				errorMessageShow(alertstr);
				return false;
        	}
        	if( isflag != 1 ){
        		var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[结算状态]</span>只能是待确认 ';
				errorMessageShow(alertstr);
				return false;
        	}
        	if( systemflag!=2 && systemflag!=3){
        		var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[计酬系统]</span>必须为[社会渠道酬金]或者[创新联盟酬金] ';
				errorMessageShow(alertstr);
				return false;
        	}        	
			formList.action = "<%=contextPath%>/cms/cityrecord.do?CMD=TXTDETAIL";
        	formList.submit();
		}		
		function showSelect() { 
	     var categorycode =document.getElementById('_sin_opnid') 
	     var categorycodeValue = categorycode.value; 
	   //获取标识符字符串
	    var str = "";
	    if(categorycodeValue != ""){
	     var valArray = categorycodeValue.split(",");
	      
	     for(var i=0;i<valArray.length;i++){  
	       if (valArray[i].split(" ")[0].length==0) {  
	           str = str+ valArray[i].split(" ")[0]; 
	       }else if (valArray[i].split(" ")[0].length>0){  
	           str = str + valArray[i].split(" ")[0]+",";
	       }
	     } 
	    }  
	      
	   	var strUrl = contextPath + "/cms/cityrecord.do?CMD=ALLFIFTHOPNIDS";
	   	var ret = window.showModalDialog(strUrl, self, "dialogWidth:700px; dialogHeight:450px; status:no; resizable:no;");  
	  
	 
	  	if (ret.length>0 && 'NULL'!=ret) { 
				categorycode.value = ret;
		}else if(ret.length==0){ 
				categorycode.value = str;
		} 
	}
	function doQuery(){
		if(ev_check()){ 
			resetPage();
			var form=document.forms[0];
			form.action="<%=contextPath%>/cms/cityrecord.do?CMD=LIST";
			form.submit();			
		}		
	}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/cityrecord.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="iscountyoperid"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/cityrecord/CityrecordForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="cityrecord" key="titleList"/>
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
        		<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="cityrecord" key="isflag"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_ne_isflag">
                    	<option />
                    	<s:Options definition="#ISFLAG" />
                    </html:select>
                    <font color=red>*</font>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="cityrecord" key="rewardmonth"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_rewardmonth" onclick="this.value=selectDateYYYYMM(this.value)"/>
                    <font color=red>*</font>
                </td>
        	</tr>
            <tr>
            	<td width="20%" height="20" align="right" class="form_table_right" >任务号:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_ne_taskid"></html:text>
                    <font color='red'>填充[任务号]可不选[结算状态]和[结算月份]</font>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="cityrecord" key="systemflag"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_ne_systemflag">
                    	<option />
                    	<s:Options definition="#SYSTEMFLAG" />
                    </html:select>
                </td>            	
            </tr>
            <tr>
            	<td width="13%" height="20" align="right" class="form_table_right" >合作商编码:</td>
                <td width="20%" class="form_table_left">
					<html:text styleClass="form_input_1x" property="_se_chainhead"></html:text>
                    <input type="button" value="..." class="clickbutton" onclick="showSelectWay3(this,'_se_chainhead');this.value='...';" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="cityrecord" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text><input type="button" value="..." 
                    	class="clickbutton" onclick="showSelectWay3(this,'_se_wayid','','','AG');this.value='...';" />
                </td>                
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" >业务发生号码:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_mobile"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" >所属分公司:</td>
                <td width="30%" class="form_table_left">                    
                    <c:choose>
                	   <c:when test="${form.iscountyoperid==1}">   
                	   <html:select property="_se_countyid">
                    	<s:Options definition="#CNTYCOMPANY" condition="countycompid:${form._se_countyid}"/>
                       </html:select>
                	   </c:when>
                	   <c:otherwise>
                	   <html:select property="_se_countyid">             	   
						<option />
                    	<s:Options definition="#CNTYCOMPANY" condition="citycompid:${requestScope.cityid}"/>
                       </html:select>
                	   </c:otherwise>
                	</c:choose>
                </td>
            </tr>
            <tr>
    			<td width="10%" height="20" align="right" class="form_table_right" >
                	业务编码（多选）:
            	</td>
            	<td  width="40%" class="form_table_left">
               		<html:textarea   property="_sin_opnid" rows="4" cols="30"></html:textarea>
                    <input type="button" value="..." class="clickbutton"
									onclick="showSelect();this.value='...';" />
            	</td>
            	<td width="50" colspan="2" class="form_table_left">&nbsp;</td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        <input type="button" class="button_4"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="导出"
										onclick="doExcel()"/>
						<input type="button" class="button_6"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="COMS明细导出"
										onclick="doTxtdetail()"/>
                        <s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">                    
                        <input type="button" class="button_4"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="批量上传"
										onclick="upload()"/>
						<input type="button" name="btnDelete" class="button_2" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="同步" onClick="doIssue('/cms/cityrecord.do')">
                        <input type="button" class="button_4"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="全部同步" <c:if test="${disable}"> disabled="disabled" </c:if>
										onclick="doAllissue('/cms/cityrecord.do?CMD=ASSIUEPAGE')"/>
						</s:RewardPurChk>
						<!-- <input type="button" class="button_4"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="汇总确认"
										onclick="doAffirmgather('/cms/cityrecord.do')"/> -->
						
                </td>
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
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="cityrecord" key="wayid"/></a>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="wayid"/>
                </td>
                <td>
                	<bean:message bundle="cityrecord" key="wayname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="cityrecord" key="opnid"/></a>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="opnid"/>
                </td>
                <td>
                	<bean:message bundle="cityrecord" key="opnname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardtype')"><bean:message bundle="cityrecord" key="rewardtype"/></a>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="rewardtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardmonth')"><bean:message bundle="cityrecord" key="rewardmonth"/></a>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="rewardmonth"/>
                </td>
                <td>
                    业务量或业务发生金额
                </td>
                <td>
                    <a href="javascript:doOrderby('paysum')"><bean:message bundle="cityrecord" key="paysum"/></a>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="paysum"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('paymoney')"><bean:message bundle="cityrecord" key="paymoney"/></a>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="paymoney"/>
                </td>
                <td>
                    明细查询
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='#99FFCC'" onMouseOut="this.bgColor='#ffffff'">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.wayid}|${item.opnid}|${item.rewardtype}|${item.rewardmonth}|${form._ne_isflag}|${form._ne_systemflag}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><s:Code2Name code="${item.wayid}" definition="#WAY"/></td>
                     <td><c:out value="${item.opnid}"/></td>
                     <td><s:Code2Name code="${item.opnid}" definition="#OPERATION"/></td>
<%--                     <td><s:Code2Name code="${item.rewardtype}" definition="$CH_REWARDTYPE"/></td>--%>
					 <td><c:out value="${item.rewardtypename}"/></td>
                     <td><c:out value="${item.rewardmonth}"/></td>
                     <td>
                     <fmt:formatNumber pattern="0.00" value="${item.sumbusivalue}" /></td>
                     <td>
                     <fmt:formatNumber pattern="0.00" value="${item.sumpaysum}" /></td>
                     <td>
                     <fmt:formatNumber pattern="0.00" value="${item.sumpaymoney}" /></td>
                     <td>
                     <input type="button" id="btnUpdate" name="btnUpdate"
						class="button_2" onmouseover="buttonover(this);"
						onmouseout="buttonout(this);" onfocus="buttonover(this)"
						onblur="buttonout(this)" value="查看明细"
						onClick="doshowDetail('<c:out value="${item.wayid}"/>','<c:out value="${item.opnid}"/>','<c:out value="${item.rewardmonth}"/>','<c:out value="${item.rewardtype}"/>');">
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
