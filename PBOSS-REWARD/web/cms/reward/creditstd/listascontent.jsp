<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
    String slv = (String)request.getAttribute("slv");
    String opnidss = (String)request.getAttribute("opnidss");
    String adtypecode = (String)request.getAttribute("adtypecode");
    String cityorcountrystd = (String)request.getAttribute("cityorcountrystd");
    String slvlev=(String)request.getAttribute("slvlev");
    String id = (String)request.getAttribute("id");
    String cityorcountrycore = (String)request.getAttribute("cityorcountrycore");
    String cityorcountryaccount = (String)request.getAttribute("cityorcountryaccount");
%>
<html>
<head>
    <title><bean:message bundle="creditstd" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
    	function ifcheck(checkvalue){
        	
       	//if (ev_checkval()) {
      	 	//	enable();
      	 	var selectedseqs = formList.all("selectedseqs");
      	 	var cardstd= formList.all("cardstds");
      	 	var creditstd= formList.all("creditstds");
      	 	var rewardstd= formList.all("rewardstds");
      	 	var ruleid= formList.all("ruleids");
      	 	var intvmonth= formList.all("intvmonths");
       	var checkedNum = 0;
       	var id = '';
       	if (selectedseqs.length == undefined) {
       		if (selectedseqs.value != '') {
       			if (selectedseqs.type == 'checkbox'&& selectedseqs.checked ) {
       				checkedNum++;
       				id = selectedseqs.value;
       				cardstd.disabled=false;
       				creditstd.disabled=false;
       				rewardstd.disabled=false;
       				ruleid.disabled=false;
       				intvmonth.disabled=false;
       			}
       			if (selectedseqs.type == 'checkbox'&& !(selectedseqs.checked) ) {
       				cardstd.disabled=true;
       				creditstd.disabled=true;
       				rewardstd.disabled=true;
       				ruleid.disabled=true;
       				intvmonth.disabled=true;
       				
       			}
       		}
       	} else {
       		for (var i=0; i<selectedseqs.length; i++) {
       			
       			if (selectedseqs.type == 'checkbox'&& selectedseqs.checked ) {
       			alert("进入selectedseqs.length,checked");
       				checkedNum++;
       				id = selectedseqs.value;
       				cardstd.disabled=false;
       				creditstd.disabled=false;
       				rewardstd.disabled=false;
       				ruleid.disabled=false;
       				intvmonth.disabled=false;
       			}
       			if (selectedseqs.type == 'checkbox'&& !(selectedseqs.checked) ) {
       			alert("进入selectedseqs.length,没有checked");
       				cardstd.disabled=true;
       				creditstd.disabled=true;
       				rewardstd.disabled=true;
       				ruleid.disabled=true;
       				intvmonth.disabled=true;
       				
       			}
       		}
       	}
    
    }
        function ev_check() {
            addfield('_ne_slv', '<bean:message bundle="creditstd" key="slv"/>', 'f', 'false', '22');
            return checkval(window);
        }
        
        function doSave() {
    		//if (ev_checkval()) {
       	 	//	enable();
       	 	
        	/*
        	if (checkedNum == 0) {
        		alert('<bean:message bundle="rule" key="remindOnBusi"/>');
        		return;
        	}
        	*/
			var a=new Array();
			var selectedseqs = document.getElementsByName("selectedseqs");
        	var id = '';
        	
        	if (selectedseqs.length == 1) {
        		if (selectedseqs[0].value != '') {
        			
        			/*if (selectedseqs[0].type == 'checkbox'&& selectedseqs.checked ) {
        				a[0]= selectedseqs[0].value
        			}*/
        			if (selectedseqs[0].checked) {
        				a[0]= selectedseqs[0].value
        			}
        			
        		}
        	} else {
        		for (var i=0; i<selectedseqs.length; i++) {
        			
        			if (selectedseqs[i].type == 'checkbox'&& selectedseqs[i].checked ) {
        			
        				a[i]= selectedseqs[i].value;
        			}
        			
        		}
        	}
        	
        	//改变规则编码选择器文本框name属性值
        	var rownum = document.getElementById("contentrowcount").value;
        	var rownumint = parseInt(rownum);
        	for(var i=1;i<=rownumint;i++){
        		document.getElementById("ruleids"+i).name='ruleids';
        	}
        	
        	
			
       		 formList.action ="<%=contextPath%>/cms/reward/creditstd.do?CMD=SAVE2&rewardtype=55&a="+a+"&slv="+<%=slv%>+"&adtypecode="+<%=adtypecode%>+"&slvlev="+<%=slvlev%>+"&id="+<%=id%>;
       		 formList.submit();
   			// }
   		 //	return false;
		}
        function doShowRule(id) {
			var urlForPrint = contextPath + '/cms/reward/rule2.do?CMD=SELECTRULE&PK='+document.getElementById("aaabbb").value ;
			var returnValue = window.showModalDialog(urlForPrint, "", "dialogWidth=550px;dialogHeight=450px;status=no;resizable:yes;");
			returnValue = returnValue==null?"":returnValue;
			if (returnValue != "") {
				document.all(id).value = returnValue;
			}
		}
		
		function doBack(){
	    	formList.action="<%=contextPath%>/cms/reward/creditstd/list.jsp";
	    	formList.submit();
	    }
	    function doShowRuleDetail(slv,slvlev,adtypecode,id){
			//alert(slv);
			//alert(slvlev);
			//alert(adtypecode);
			// alert(id.value);
			// alert(document.getElementById(id).value);
			// alert("<%=contextPath%>/cms/reward/creditstd.do?CMD=SHOWRULEDETAIL&PK="+slv+"|"+slvlev+"|"+adtypecode+"|"+54+"|"+document.getElementById(id).value);
			 formList.action ="<%=contextPath%>/cms/reward/creditstd.do?CMD=SHOWRULEDETAIL&PK="+slv+"|"+slvlev+"|"+adtypecode+"|"+55+"|"+document.getElementById(id).value;
			 formList.submit();
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/creditstd.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <input type="hidden" id="contentrowcount" value="<c:out value='${requestScope.dp.rowCount}' />">
   <input type="hidden" id="aaabbb" name="opnidss" value="<%=opnidss%>">
    <input type="hidden" name="sslv" value="<%=slv%>">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/creditstd/CreditstdForm']}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="creditstd" key="titleList"/>
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
	</div>
	<div >
	积分奖励酬金
	</div>
	<br>
    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <!-- <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td> -->
                <td>
            	操作
            	</td>
                 <td>
                   星级
                </td>
                <td>
                  星级层次
                </td>
                <td>
                  城乡标识
                </td>
                <td>
                   核心业务量标准
                </td>
                <td>
                  星级积分标准
                </td>
                <td>
                  积分奖励金额标准
                </td>
                <td>
                   规则编码
                </td>
                <td>
                   间隔月份
                </td>
                <td>
                   规则细项
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.dp.datas}" varStatus="s">
                 <c:url value="/cms/reward/creditstd.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value=""/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="selectedseqs" value="<c:out value='${item.seq}' />"
                          checked="checked"  disabled="true"       class="table_checkbox">
                         <%-- <input type="hidden" name="subsidys" value="<c:out value="${item.subsidy}"/>" >   --%>
                     </td>
                     <!-- <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.cityid}"/></a>
                     </td>
                      -->
                     <!-- <td><c:out value="${item.cityid}"/></td> -->
                     <td>
                     <s:Code2Name code="${item.slv}" definition="$CH_STARLEVELONLY"/>
                     </td>
                     <td>
                      <s:Code2Name code="${item.slvlev}" definition="$CH_STARLAV"/>
                     </td>
                     <td>
                     <s:Code2Name code="${item.adtypecode}" definition="$CH_ACCOUNTREGION"/>
                     </td>
                     <td>
                     <input type="text" name="cardstds" value="<c:out value="${item.cardstd}"/>" 
			        			 size="10" />
			        			 <font color='red'><%=cityorcountrycore%></font>
                     <!-- <c:out value="${item.cardstd}"/> 
                     <c:out value="${item.creditstd}"/> 
                     <c:out value="${item.rewardstd}"/>
                     <c:out value="${item.ruleid}"/>
                     <c:out value="${item.intvmonth}"/>-->
                     </td>
                     <td>
                     <input type="text" name="creditstds" value="<c:out value="${item.creditstd}"/>" 
			        		 size="10" />
			        		<font color='red'><%=cityorcountryaccount%></font>
                     </td>
                     <td>
                     <input type="text" name="rewardstds" value="<c:out value="${item.rewardstd}"/>" 
			        		  size="10" />
			        		  <font color='red'><%=cityorcountrystd%></font>
                     </td>
                     <td>
                     <input type="text" id="ruleids<c:out value="${s.count}"/>" name="ruleids<c:out value="${s.count}"/>" value="<c:out value="${item.ruleid}"/>" 
			        			 size="10" />
			        <input type="button" value="..." class="clickButton" onclick="doShowRule('ruleids<c:out value="${s.count}"/>')" >
                     </td>
                     
                     <td>
                     <input type="text" name="intvmonths" value="<c:out value="${item.intvmonth}"/>" 
			        			 size="10" />
                     </td>
                     <td>
			        	<input type="button" value="设置" class="query" onclick="doShowRuleDetail(<c:out value="${item.slv}"/>,<c:out value="${item.slvlev}"/>,<c:out value="${item.adtypecode}"/>,'ruleids<c:out value="${s.count}"/>')" >
                     </td>
                 </tr>
             </c:forEach>
        </table>
     </div>
   </div>

	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                
                  <!--  
                  <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                         name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                         value="<bean:message bundle="public" key="button_save"/>" class="submit"
                       onclick="doSave()"/>
                   -->
                  <c:choose>
                    <c:when test="${updateState}">
						<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                         name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
	                         value="<bean:message bundle="public" key="button_save"/>" class="submit"
	                         onclick="doSave()"/>
                    </c:when>
                    <c:otherwise>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                         name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
	                         value="<bean:message bundle="public" key="button_save"/>" class="submit"
	                     disabled="true"    onclick="doSave()"/>
	                </c:otherwise>
                 </c:choose>
                  <input type="button" id="btnExportexcel" name="btnExportexcel" class="button_4" onmouseover="buttonover(this);"
                       onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                       value="返回" onClick="doBack()"> 
                </td>
			</tr>
		</table>
	</div>

   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
</html:form>
</div>
</body>
</html>
