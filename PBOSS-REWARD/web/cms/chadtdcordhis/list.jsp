<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa" %>
<%@ include file="/inc/listhead.inc"%>
<% String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="chadtdcordhis" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/bus/rescommon.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/jquery/jquery-1.3.2.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_recordid', '<bean:message bundle="chadtdcordhis" key="recordid"/>', 'f', 'false', '14');
            addfield('_se_opnid', '<bean:message bundle="chadtdcordhis" key="opnid"/>', 'c', 'false', '18');
            addfield('_sin_opnid', '<bean:message bundle="chadtdcordhis" key="opnid"/>', 'c', 'false', '2000');
            addfield('_se_wayid', '<bean:message bundle="chadtdcordhis" key="wayid"/>', 'c', 'false', '18');
            addfield('_ne_rewardtype', '<bean:message bundle="chadtdcordhis" key="rewardtype"/>', 'f', 'false', '3');
            addfield('_se_rewardmonth', '<bean:message bundle="chadtdcordhis" key="rewardmonth"/>', 'c', 'false', '6');
            addfield('_se_approveid', '<bean:message bundle="chadtdcordhis" key="approveid"/>', 'c', 'false', '32');
            addfield('_ne_isflag', '<bean:message bundle="chadtdcordhis" key="isflag"/>', 'f', 'false', '3');
            addfield('_ne_systemflag', '<bean:message bundle="chadtdcordhis" key="systemflag"/>', 'f', 'false', '3');
            addfield('_nne_systemflag', '<bean:message bundle="chadtdcordhis" key="systemflag"/>', 'f', 'false', '3');
            addfield('_ne_rewardlistid', '<bean:message bundle="chadtdcordhis" key="rewardlistid"/>', 'f', 'false', '14');
            addfield('_se_mobile', '业务发生号码', 'c', 'false', '15');
            return (checkval(window));
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
    
    
    
	
		function doTxt(){ 
		      if(ev_check()){ 
			    formList.action = "<%=contextPath%>/cms/chadtdcordhis.do?CMD=TXT";
        	    formList.submit();
        	    formList.action = "<%=contextPath%>/cms/chadtdcordhis.do?CMD=LIST";
        	}
		} 

    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/chadtdcordhis.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/chadtdcordhis/ChadtdcordhisForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			 酬金明细历史数据查询
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
        	   <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtdcordhis" key="rewardmonth"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_rewardmonth" onclick="this.value=selectDateYYYYMM(this.value)"/>
                    
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtdcordhis" key="oprmonth"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_oprmonth" onclick="this.value=selectDateYYYYMM(this.value)"/>
                    
                </td>
        	
        	</tr>
        	<tr>
        	    <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtdcordhis" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text><input type="button" value="..." 
                    	class="clickbutton" onclick="showSelectWay3(this,'_se_wayid','','','AG');this.value='...';" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtdcordhis" key="rewardtype"/>:</td>
                <td width="30%" class="form_table_left"> 
                    <html:select property="_ne_rewardtype">
                    	<option />
                    	<s:Options definition="#REWARDTYPE" />
                    </html:select> 
                </td>
        	
        	</tr>
        	<tr>
        	 <td width="20%" height="20" align="right" class="form_table_right" >结算状态:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_ne_isflag">
                    	<option />
                    	<s:Options definition="#ISFLAG" />
                    </html:select> 
                </td>
        	    <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtdcordhis" key="systemflag"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_ne_systemflag">
                    	<option />
                    	<s:Options definition="#SYSTEMFLAG" />
                    </html:select>
                   
                </td>
        	</tr>  
            
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" >业务发生号码:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_mobile"></html:text>
                </td>
    			<td width="10%" height="20" align="right" class="form_table_right" >
                	业务编码（多选）:
            	</td>
            	<td  width="40%" class="form_table_left">
               		<html:textarea   property="_sin_opnid" rows="4" cols="30"></html:textarea>
                    <input type="button" value="..." class="clickbutton"
									onclick="showSelect();this.value='...';" />
            	</td> 
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery('/cms/chadtdcordhis.do?CMD=LIST');"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        <input type="button" class="button_4"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="导出"
										onclick="doTxt()"/> 
                </td>
			</tr>
		</table>
	</div>
	
    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
            	 
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="chadtdcordhis" key="recordid"/></a>
                    <s:OrderImg form="/cms/chadtdcordhis/ChadtdcordhisForm" field="wayid"/>
                </td>
                <td>
                	发布标志
                </td> 
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="chadtdcordhis" key="opnid"/></a>
                    <s:OrderImg form="/cms/chadtdcordhis/ChadtdcordhisForm" field="opnid"/>
                </td>
                 <td>业务代码名称</td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="chadtdcordhis" key="wayid"/></a>
                    <s:OrderImg form="/cms/chadtdcordhis/ChadtdcordhisForm" field="wayid"/>
                </td>
                 <td>渠道名称</td>
                 <td>
                    <a href="javascript:doOrderby('rewardtype')"><bean:message bundle="chadtdcordhis" key="rewardtype"/></a>
                    <s:OrderImg form="/cms/chadtdcordhis/ChadtdcordhisForm" field="rewardtype"/>
                </td>
                  <td>
                    <a href="javascript:doOrderby('rewardmonth')"><bean:message bundle="chadtdcordhis" key="rewardmonth"/></a>
                    <s:OrderImg form="/cms/chadtdcordhis/ChadtdcordhisForm" field="rewardmonth"/>
                </td>
                 <td>
                	<bean:message bundle="chadtdcordhis" key="oprtime"/>
                </td> 
                <td>
                	<bean:message bundle="chadtdcordhis" key="mobile"/>
                </td>
                <td>
                	<bean:message bundle="chadtdcordhis" key="brand"/>
                </td>
                
                <td>
                	<bean:message bundle="chadtdcordhis" key="busivalue"/>
                </td>
                <td>
                	<bean:message bundle="chadtdcordhis" key="paysum"/>
                </td>
                <td>
                	<bean:message bundle="chadtdcordhis" key="paymoney"/>
                </td>
                <td>
                	<bean:message bundle="chadtdcordhis" key="oprcode"/>
                </td>
                <td>
                	已发布时间
                </td>
                <td>
                	<bean:message bundle="chadtdcordhis" key="accountoprcode"/>
                </td>
                <td>
                	<bean:message bundle="chadtdcordhis" key="accountoptime"/>
                </td>
                 <td>
                	<bean:message bundle="chadtdcordhis" key="adjustoprcode"/>
                </td>
                 <td>
                	<bean:message bundle="chadtdcordhis" key="adjustoptime"/>
                </td>
                 <td>
                	<bean:message bundle="chadtdcordhis" key="rewardlistid"/>
                </td>
                 <td>
                	<bean:message bundle="chadtdcordhis" key="taskid"/>
                </td>
                 <td>
                	<bean:message bundle="chadtdcordhis" key="batchno"/>
                </td> 
               
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center"> 
                     <td><c:out value="${item.recordid}"/></td>
                     <td><s:Code2Name code="${item.isflag}" definition="#ISFLAG"/></td>
                      <td><c:out value="${item.opnid}"/></td>
                      <td><s:Code2Name code="${item.opnid}" definition="#OPERATION"/></td>  
                     <td><c:out value="${item.wayid}"/></td>
                     <td><s:Code2Name code="${item.wayid}" definition="#WAY"/></td>
                     <td><s:Code2Name code="${item.rewardtype}" definition="#REWARDTYPE"/></td>  
                     <td><c:out value="${item.rewardmonth}"/></td>
                     <td><c:out value="${item.oprtime}"/></td>
                      <td><c:out value="${item.mobile}"/></td>
                      <td><c:out value="${item.brand}"/></td>
                      <td><c:out value="${item.busivalue}"/></td>
                      <td><fmt:formatNumber pattern="0.00" value="${item.paysum}" /></td>
                      <td><fmt:formatNumber pattern="0.00" value="${item.paymoney}" /></td> 
                       <td><c:out value="${item.oprcode}"/></td>
                       <td><c:out value="${item.optime}"/></td>
                       <td><s:Code2Name code="${item.systemflag }" definition="#SYSTEMFLAG"/></td>
                       <td><c:out value="${item.accountoprcode}"/></td>
                       <td><c:out value="${item.accountoptime}"/></td>
                       <td><c:out value="${item.adjustoprcode}"/></td>
                       <td><c:out value="${item.adjustoptime}"/></td>
                       <td><c:out value="${item.rewardlistid}"/></td>
                       <td><c:out value="${item.taskid}"/></td>
                       <td><c:out value="${item.batchno}"/></td> 
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
