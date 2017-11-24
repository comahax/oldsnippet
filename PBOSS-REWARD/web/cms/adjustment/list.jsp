<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "CH_ADT_ADJUST_UP||CH_ADT_ADJUST_COUNTY";
    String ID_2 = "CH_ADT_ADJUST_TAX||CH_ADT_ADJUST_COUNTY";
    String ID_3 = "CH_ADT_PAYMENT_NEW||CH_ADT_ADJUST_COUNTY";
    String ID_4 = "CH_ADT_ADJUST_COUNTY";
%>
<html>
<head>
    <title><bean:message bundle="adjustment" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/jquery/jquery-1.3.2.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/cookie/cookies.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_wayid', '<bean:message bundle="adjustment" key="wayid"/>', 'c', 'false', '18');
            addfield('_se_rewardmonth', '<bean:message bundle="adjustment" key="rewardmonth"/>', 'c', 'false', '6');
            addfield('_se_countyid', '<bean:message bundle="adjustment" key="countyid"/>', 'c', 'false', '14');
            addfield('_sk_wayname', '<bean:message bundle="adjustment" key="wayname"/>', 'c', 'false', '30');
            addfield('_ne_accttype', '<bean:message bundle="adjustment" key="accttype"/>', 'i', 'false', '3');
            return (checkval(window) && checkParam());
        }
        function checkParam(){
        	var check = document.getElementById('_checked').value;
        	if(check==null || check==''){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[是否核对]</span> 不能为空 ';
				errorMessageShow(alertstr);
				return false;
        	}
        	return true;
        }
        function doExcel(){ 
		    if( ev_check() ){
		    	formList.action = "<%=contextPath%>/cms/adjustment.do?CMD=EXCEL";
	        	formList.submit();
	        	formList.action = "<%=contextPath%>/cms/adjustment.do?CMD=LIST";
		    }			
		}
        function doSave(){
        	var TO = true;
		    var sis = formList.all("_selectitem");
		    if(forsavecheck(TO,sis,"确认税前金额准确？")){
		    	formList.action = "<%=contextPath%>/cms/adjustment.do?CMD=SAVEUNCHECKED";
        		formList.submit();
        		formList.action = "<%=contextPath%>/cms/adjustment.do?CMD=LIST";
		    }
        }
        function doSaveall(){
        	var msg = "确认所有数据税前金额准确？";
        	if(confirm(msg)){
        		formList.action = "<%=contextPath%>/cms/adjustment.do?CMD=SAVEALLUNCHECKED";
        		formList.submit();
        		formList.action = "<%=contextPath%>/cms/adjustment.do?CMD=LIST";
        	}
        }
        function doDeleteall(){
        	var msg = "确认删除符合当前条件的所有【已核对】数据？若已经导入税金和奖罚，删除后需要重新导入。";
        	if(confirm(msg)){
        		formList.action = "<%=contextPath%>/cms/adjustment.do?CMD=DELETEALLCHECKED";
        		formList.submit();
        		formList.action = "<%=contextPath%>/cms/adjustment.do?CMD=LIST";
        	}
        }
        function forsavecheck(TO,sis,msg){
        	if (sis != null) {
		        if (sis.length != null) {
		            for (var i = 0; i < sis.length; i++) {
		                var e = sis[i];
		                if (e.type == 'checkbox') {
		                    if (e.checked)
		                        TO = false;
		                }
		            }
		        } else {
		            var e = sis;
		            if (e.type == 'checkbox') {
		                if (e.checked)
		                    TO = false;
		            }
		        }
		    }
		
		    if (TO) {
		        alert("请选择税前金额准确的数据");
		        return false;
		    }
			
			if(msg.length>0){
			    if (!confirm(msg)) {
			        return false;
			    }
		    }
		    return true;
        }
        function doBatch(){
        	var url='cms/adjustment.do?CMD=BATCH';
        	formList.action=url;
        	formList.submit();
        }
        function doShowreport(){
        	var countypermited = document.getElementById('countypermited').value;
			formReport.action=contextPath + "/cms/adjustment.do?CMD=SHOWREPORT&countypermited="+countypermited;
			formReport.submit();       
        }
        function doCheckedChange(){
        	var checked = document.getElementById('_checked').value;
        	if(checked===null || checked==''){
        		document.getElementById('_se_batchno').disabled=false;
        	}else if(checked==1){
        		document.getElementById('_se_batchno').value='';
        		document.getElementById('_se_batchno').disabled=true;
        	}else{
        		document.getElementById('_se_batchno').disabled=false;
        	}
        }
        jQuery(document).ready(function() {
  			doCheckedChange();
		});
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/adjustment.do?CMD=LIST" styleId="formReport" method="post">	
    <html:hidden property="_hasfees" />
    <html:hidden property="_hasupperopnid" />
</html:form>
<html:form action="/cms/adjustment.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="citypermited"/>
    <html:hidden property="countypermited" styleId="countypermited"/>
    <html:hidden property="exporttype" value="1"/>
    <html:hidden property="_hasfees"/>
    <html:hidden property="_hasupperopnid"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/adjustment/AdjustmentForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="adjustment" key="titleList"/>
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
                <td  height="20" align="right" class="form_table_right" ><bean:message bundle="adjustment" key="wayid"/>:</td>
                <td  class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text>
                    <input type="button" value="..." class="clickbutton" onclick="showSelectWay3(this,'_se_wayid','','','AG');this.value='...';" />
                </td>
                <td  height="20" align="right" class="form_table_right" ><bean:message bundle="adjustment" key="_checked"/>:</td>
                <td  class="form_table_left">
                    <html:select property="_checked" onchange="doCheckedChange()">
                    	<s:Options definition="#CH_ADT_ADJUSTCHECKED" />
                    </html:select><font color=red>*</font>
                </td>
                <c:if test="${form._hasupperopnid==1}">
            	<td rowspan="5"  height="20" align="right" class="form_table_right" ><bean:message bundle="adjustment" key="upperopnid"/>:</td>
                <td rowspan="5"  class="form_table_left">
                    <html:select property="_se_upperopnid" size="5" multiple="true" style="height:100px">   
                        <option />                 	
                    	<s:Options definition="#OPERATION" condition="opnlevel:1"/>
                    </html:select>
                </td>                
                </c:if>
            </tr>
            <tr>
                <td  height="20" align="right" class="form_table_right" ><bean:message bundle="adjustment" key="wayname"/>:</td>
                <td  class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_wayname"></html:text>
                </td>
                <td  height="20" align="right" class="form_table_right" ><bean:message bundle="adjustment" key="rewardmonth"/>:</td>
                <td  class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_rewardmonth" onclick="this.value=selectDateYYYYMM(this.value)"></html:text>
                </td>                
            </tr>
            <tr>
            	<td  height="20" align="right" class="form_table_right" ><bean:message bundle="adjustment" key="countyid"/>:</td>
                <td  class="form_table_left">
                    <c:choose>
                	   <c:when test="${form.citypermited==1}">   
                	   <html:select property="_se_countyid">             	   
						<option />
                    	<s:Options definition="#CNTYCOMPANY" condition="citycompid:${requestScope.cityid}"/>
                       </html:select>
                	   </c:when>
                	   <c:when test="${form.citypermited!=1 && form.countypermited==1 && form._se_countyid!=null}">
                	   <html:select property="_se_countyid">
                    	<s:Options definition="#CNTYCOMPANY" condition="countycompid:${form._se_countyid}"/>
                       </html:select>
                	   </c:when>
                	</c:choose>   
                </td>
            	<td  height="20" align="right" class="form_table_right" ><bean:message bundle="adjustment" key="accttype"/>:</td>
                <td  class="form_table_left">
                    <html:select property="_ne_accttype">
                    	<option />
                    	<s:Options definition="$CH_ACCOUNTTYPE" />
                    </html:select>
                </td>
            </tr>
            <tr>
            	<td  height="20" align="right" class="form_table_right" ><bean:message bundle="adjustment" key="chainhead"/>:</td>
                <td  class="form_table_left">
					<html:text styleClass="form_input_1x" property="_se_chainhead"></html:text>
                    <input type="button" value="..." class="clickbutton" onclick="showSelectWay3(this,'_se_chainhead');this.value='...';" />
                </td>
                <td  height="20" align="right" class="form_table_right" ><bean:message bundle="adjustment" key="starlevel"/>:</td>
                <td  class="form_table_left">
                    <html:select property="_ne_starlevel">
                    	<option />
                    	<s:Options definition="$CH_STARLEVEL" />
                    </html:select>
                </td>              
            </tr>
            <tr>
            	<td  height="20" align="right" class="form_table_right" ><bean:message bundle="adjustment" key="batchno"/>:</td>
                <td  class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_batchno"></html:text>
                </td>    
                <td colspan="2">&nbsp;</td>            
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                		<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />  
                        <input type="button" class="button_2" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
							onfocus="buttonover(this)" onblur="buttonout(this)" 
							value="<bean:message bundle="public" key="button_export"/>" onclick="doExcel()"/>                      
                        <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="保存" onClick="doSave()"  <c:if test="${form._checked!=1}"> disabled  </c:if> >  
                        <input type="button" name="btnNew"  class="button_4" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="全部保存" onClick="doSaveall()"  <c:if test="${form._checked!=1}"> disabled  </c:if> >               
                        <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/adjustment.do')"
                            <c:if test="${form._checked==1 || (form._se_batchno!=null && form._se_batchno!='')}"> disabled  </c:if>>
                        <input type="button" name="btnDelete" class="button_4" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="全部删除" onClick="doDeleteall()"
                            <c:if test="${form._checked==1 || (form._se_batchno!=null && form._se_batchno!='')}"> disabled  </c:if>>
                        </s:RewardPurChk>
                        <s:RewardPurChk controlid="<%=ID_2%>" disableChild="true">
                        <input type="button" name="btnNew"  class="button_4" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="税金导入" onClick="doBatch()">
                        </s:RewardPurChk>
                        <s:RewardPurChk controlid="<%=ID_3%>" disableChild="true">
                        <input type="button" name="btnDelete" class="button_6" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="生成付款报表" onClick="doShowreport()">
                        </s:RewardPurChk>
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
                    <a href="javascript:doOrderby('id')"><bean:message bundle="adjustment" key="id"/></a>
                    <s:OrderImg form="/cms/adjustment/AdjustmentForm" field="id"/>
                </td>    
                <td>
                    <a href="javascript:doOrderby('countyid')"><bean:message bundle="adjustment" key="countyid"/></a>
                    <s:OrderImg form="/cms/adjustment/AdjustmentForm" field="countyid"/>
                </td>            
                <td>
                    <bean:message bundle="adjustment" key="rewardmonth"/>
                </td>                
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="adjustment" key="wayid"/></a>
                    <s:OrderImg form="/cms/adjustment/AdjustmentForm" field="wayid"/>
                </td>
                <td>
                    <bean:message bundle="adjustment" key="wayname"/>
                </td>
                <td>
                    <bean:message bundle="adjustment" key="starlevel"/>
                </td>
                 <c:if test="${form._hasupperopnid==1}">
                      <td>
		                    <bean:message bundle="adjustment" key="upperopnid"/>
		              </td>
                 </c:if> 
                <td>
                    <bean:message bundle="adjustment" key="paysum"/>
                </td>
                <td>
                    <bean:message bundle="adjustment" key="rpmoney"/>
                </td>
                <td>
                    <bean:message bundle="adjustment" key="invoicesum"/>
                </td>
                <td>
                    <bean:message bundle="adjustment" key="taxmoney"/>
                </td>
                <c:if test="${form._hasfees==1}">
                      <td>
		                    <bean:message bundle="adjustment" key="fees"/>
		              </td>
                 </c:if> 
                 <td>
                    <bean:message bundle="adjustment" key="realpay"/>
                </td>
                <td>
                    <bean:message bundle="adjustment" key="remark"/>
                </td>
                <td>
                    <bean:message bundle="adjustment" key="operationtitle"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/adjustment.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.id}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='#99FFCC'" onMouseOut="this.bgColor='#ffffff'">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.id}' />|<c:out value='${item.wayid}' />|<c:out value='${item.rewardmonth}' />|<c:out value='${item.countyid}'/>|<c:out value='${item.upperopnid}'/>"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <c:out value="${item.id}"/>
                     </td>
                     <td><s:Code2Name code="${item.countyid}" definition="#CNTYCOMPANY" /></td>
                     <td><c:out value="${item.rewardmonth}"/></td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><c:out value="${item.wayname}"/></td>
                     <td><s:Code2Name code="${item.starlevel}" definition="$CH_STARLEVEL" /></td>
                     <c:if test="${form._hasupperopnid==1}">
                     	<td><s:Code2Name code="${item.upperopnid}" definition="#OPERATION" /></td>
                     </c:if>
                     <td><fmt:formatNumber pattern="0.0000" value="${item.paysum}" /></td>
                      <td><fmt:formatNumber pattern="0.0000" value="${item.rpmoney}" /></td>
                     <td><fmt:formatNumber pattern="0.0000" value="${item.invoicesum}" /></td>
                     <td><fmt:formatNumber pattern="0.0000" value="${item.taxmoney}" /></td>
                     <c:if test="${form._hasfees==1}">
                     	<td><fmt:formatNumber pattern="0.0000" value="${item.fees}" /></td>
                     </c:if>                   
                     <td><fmt:formatNumber pattern="0.0000" value="${item.realpay}" /></td>
                     <td><c:out value="${item.remark}"/></td>
                     <td>
                     <c:if test="${form._checked==1}">
                     <s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
                     <input type="button" value="<bean:message bundle="adjustment" key="operation"/>" class="button_2"
                          	onclick="setlocationSpec('RM060403','酬金出帐明细查询','<%=contextPath%>/cms/dcord.do?CMD=LIST&_se_wayid=<c:out value="${item.wayid}"/>&_se_rewardmonth=<c:out value="${item.rewardmonth}"/>&_se_countyid=<c:out value="${item.countyid}"/>',window.top.maintop)" >
                     </s:RewardPurChk>
                     </c:if>
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
