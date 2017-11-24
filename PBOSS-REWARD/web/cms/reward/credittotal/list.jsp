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
    <title><bean:message bundle="credittotal" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_wayid', '<bean:message bundle="credittotal" key="wayid"/>', 'c', 'false', '20');
            return checkval(window);
        }
        
        
        function checkRuleitem(checkvalue){
        	
        	//if (ev_checkval()) {
       	 	//	enable();
       	 	var sis = formList.all("ruleitemids");
       	 	var pv= formList.all("paramervalues");
        	var checkedNum = 0;
        	var id = '';
        	if (sis.length == undefined) {
        		if (sis.value != '') {
        			checkedNum = 1;
        			id = sis.value;
        		}
        	} else {
        		for (var i=0; i<sis.length; i++) {
        			if (sis[i].type == 'checkbox'&& sis[i].checked ) {
        				checkedNum++;
        				id = sis[i].value;
        				pv[i].disabled=false;
        			}
        			if (sis[i].type == 'checkbox'&& !(sis[i].checked) ) {
        				pv[i].disabled=true;
        				
        			}
        		}
        	}
        	
  			<%-- 
  			ajaxAnywhere.submitByURL( '/cms/reward/salecreditstd.do?CMD=CANCELRULEITEM&ruleitemid='+checkvalue);  
  			formList.action=contextPath+"/cms/reward/salecreditstd.do?CMD=LIST";
  			--%>
  	
        }
        
        function doSave(cmdSave) {
    		//if (ev_checkval()) {
       	 	//	enable();
       	 	var sis = formList.all("ruleitemids");
       	 	var pv= formList.all("paramervalues");
        	var checkedNum = 0;
        	var id = '';
        	if (sis.length == undefined) {
        		if (sis.value != '') {
        			checkedNum = 1;
        			id = sis.value;
        		}
        	} else {
        		for (var i=0; i<sis.length; i++) {
        			if (sis[i].type == 'checkbox'&& sis[i].checked ) {
        				checkedNum++;
        				id = sis[i].value;
        				pv.disabled='false';
        				 
        			}
        		}
        	}
        	/*
        	if (checkedNum == 0) {
        		alert('<bean:message bundle="rule" key="remindOnBusi"/>');
        		return;
        	}
        	*/
			
       		 formList.action = contextPath + cmdSave;
       		 formList.submit();
   			// }
   		 //	return false;
		}
        
        function doExcel(){
	    	formList.action="<%=contextPath%>/cms/reward/credittotal.do?CMD=EXCEL";
	    	formList.submit();
	    	formList.action="<%=contextPath%>/cms/reward/credittotal.do?CMD=LIST";
	    }
    	
    	function doSyn(){
    		var form=document.forms[0];
    		var time1=form.all['rewardmonth'].value;
    		if(!time1.length>0){
    		alert("请输入对应月份,对应月份不能为空!");
    		return false;
    		}
    		if(time1.length>0&&!isDateYYYYMM(time1)){
        	alert("请输入正确的对应月份格式:YYYYMM");
        	return false;
        	}
    		
    		var rewardtype=form.all['rewardtype'].value;
    		if(!rewardtype.length>0){
    		alert("请输入考核分数类型,考核分数类型不能为空!");
    		return false;
    		}
    		
	    	formList.action="<%=contextPath%>/cms/reward/credittotal.do?CMD=SYN";
	    	formList.submit();
	    	formList.action="<%=contextPath%>/cms/reward/credittotal.do?CMD=LIST";
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
        
         function doDetails(){
	    	formList.action="<%=contextPath%>/cms/reward/credittotal.do?CMD=DETAILS";
	    	formList.submit();
	    }
	    
	    function doImp(){
	    	formList.action="<%=contextPath%>/cms/reward/assess/list.jsp";
	    	formList.submit();
	    }
	    
	    
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/credittotal.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/credittotal/CredittotalForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="credittotal" key="titleList"/>
   			</td>
    	</tr>
    </table>
    </div>
    <!-- 添加的部分 开始-->
    
    
    <!-- 添加的部分 结束 -->
    <div class="table_div">	
   		 <table width="100%" class="error_text">
    		<html:errors/><s:Msg />
    	</table>
    </div>
	<div class="table_div">
        <table class="form_table">
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="credittotal" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text>
                    <input type="button" value="..." class="clickbutton" onclick="showSelectWay3(this,'_se_wayid','','','AG');this.value='...';" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ></td>
                <td width="30%" class="form_table_left">
                    
                </td>
            </tr>
            
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                		<input type="button" id="btnExportexcel" name="btnExportexcel" class="button_6" onmouseover="buttonover(this);"
	                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                        value="规则细项设置" onClick="doDetails()">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        <input type="button" id="btnExportexcel" name="btnExportexcel" class="button_4" onmouseover="buttonover(this);"
	                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                        value="导出EXCEL" onClick="doExcel()">
	                    <input type="button" id="btnExportexcel1" name="btnExportexcel1" class="button_6" onmouseover="buttonover(this);"
	                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                        value="考核分数导入" onClick="doImp()">
                        
	                        
                </td>
			</tr>
		</table>
	</div>

	
	

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="credittotal" key="wayid"/></a>
                    <s:OrderImg form="/cms/reward/credittotal/CredittotalForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adtypecode')"><bean:message bundle="credittotal" key="adtypecode"/></a>
                    <s:OrderImg form="/cms/reward/credittotal/CredittotalForm" field="adtypecode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cardsale')"><bean:message bundle="credittotal" key="cardsale"/></a>
                    <s:OrderImg form="/cms/reward/credittotal/CredittotalForm" field="cardsale"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('salelev')"><bean:message bundle="credittotal" key="salelev"/></a>
                    <s:OrderImg form="/cms/reward/credittotal/CredittotalForm" field="salelev"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('creditlev')"><bean:message bundle="credittotal" key="creditlev"/></a>
                    <s:OrderImg form="/cms/reward/credittotal/CredittotalForm" field="creditlev"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('creditaccount')"><bean:message bundle="credittotal" key="creditaccount"/></a>
                    <s:OrderImg form="/cms/reward/credittotal/CredittotalForm" field="creditaccount"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('issalelev')"><bean:message bundle="credittotal" key="issalelev"/></a>
                    <s:OrderImg form="/cms/reward/credittotal/CredittotalForm" field="issalelev"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('iscreditlev')"><bean:message bundle="credittotal" key="iscreditlev"/></a>
                    <s:OrderImg form="/cms/reward/credittotal/CredittotalForm" field="iscreditlev"/>
                </td>
                <td>
                	经营考核积分
                </td>
                <td>
                	考核积分
                </td>
                <td>
                	期数
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/reward/credittotal.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seq}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td><c:out value="${item.wayid}"/></td>
                     <td><s:Code2Name code="${item.adtypecode}" definition="$CH_COUNTYCOMPTYPE"/></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.cardsale}" /></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.salelev}" /></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.creditlev}" /></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.creditaccount}" /></td>
                     <td><c:out value="${item.issalelev}"/></td>
                     <td><c:out value="${item.iscreditlev}"/></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.manageassess}" /></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.assess}" /></td>
                     <td><c:out value="${item.noncyc}"/></td>
                 </tr>
             </c:forEach>
        </table>
     </div>
   </div>

   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
   
   <div class="table_div">
        <table class="form_table">
            <tr>
            	<td width="20%" height="20" align="right" class="form_table_right" >
                	对应月份:
            	</td>
            	<td class="form_table_left">
               	    <html:text styleClass="form_input_1x" property="rewardmonth" onclick="this.value=selectDateYYYYMM(this.value);" maxlength="6"/>
            	</td>
            	<td width="20%" height="20" align="right" class="form_table_right" >
                	考核分数类型:
            	</td>
            	<td class="form_table_left">
               	    <html:select property="rewardtype">
						<option />
							<s:Options definition="$CH_REWARDTYPE"/>
					</html:select>
            	</td>
            	
            </tr>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <input type="button" id="btnExportexcel" name="btnExportexcel" class="button_6" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="同步考核分数" onClick="doSyn()">
	                        
                </td>
			</tr>
		</table>
	</div>
   
</html:form>
</div>
</body>
</html>
