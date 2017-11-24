<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="creditstd" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
	       var rewardtype=document.getElementsByName("rewardtype")[0].value;
	       if(rewardtype==''){
	       alert("酬金类型不能为空!");
	       		return ;
	       }
        	var rewardtype=document.getElementsByName("rewardtype")[0].value;
            addfield('slv', '<bean:message bundle="creditstd" key="slv"/>', 'f', false, '22');
            addfield('adtypecode', '<bean:message bundle="creditstd" key="adtypecode"/>', 'f', false, '22');
            addfield('slvlev', '<bean:message bundle="creditstd" key="slvlev"/>', 'i', false, '1');
            addfield('ruleid', '规则编码', 'c', false, '30');
            addfield('intvmonth', '间隔月份', 'i', false, '10');
			if(document.getElementsByName("rewardtype")[0].value=="54"){
				   addfield('rewardstd11', '门店补贴金额标准', 'f', false, '8', '2', '', '0');
	        	}else{
				   addfield('creditstd', '销售积分标准', 'f', false, '8', '2', '', '0');
		           addfield('cardstd', '套卡销售标准', 'f', false, '8', '2', '', '0');
		           addfield('rewardstd', '积分奖励金额标准', 'f', false, '8', '2', '', '0');
	        		
	       }
            return checkval(window);
        }
        
        function changeType(aa){
				
		 var rewardtype=aa.value;
			if(rewardtype=="54"){
	        		document.getElementById("rewardstd5").style.display="none";
	        		document.getElementById("creditstd5").style.display="none";
	        		document.getElementById("cardstd5").style.display="none";
	        		document.getElementById("rewardstd1").style.display="block";	
	        	}else{
	        	 	document.getElementById("rewardstd5").style.display="block";
	        		document.getElementById("creditstd5").style.display="block";
	        		document.getElementById("cardstd5").style.display="block";
	        		document.getElementById("rewardstd1").style.display="none";
	        		
	        	}
		}
        
        function doShowRule(id) {
        	var pk= '';
	        if(document.getElementsByName("rewardtype")[0].value=="54"){
	        	pk='0701010100003';
	        }else{
	        	pk='0701010100002';
	        }
			var urlForPrint = contextPath + '/cms/reward/rule2.do?CMD=SELECTRULE&PK='+pk ;
			var returnValue = window.showModalDialog(urlForPrint, "", "dialogWidth=550px;dialogHeight=450px;status=no;resizable:yes;");
			returnValue = returnValue==null?"":returnValue;
			if (returnValue != "") {
				document.all(id).value = returnValue;
			}
		}
        
    </script>
</head>
<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/creditstd.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_cityid"/>
    <html:hidden property="_ne_slv"/>
    <html:hidden property="cityid"/>
    <html:hidden property="seq"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/creditstd/CreditstdForm']}"/>

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
<!-- 用于列出省公司的标准  开始 -->
	<div class="table_div">
      <div class="table_LongTable">
      省公司星级酬金标准
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <!-- <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td> -->
                <td>
                    星级
                </td>
                <td>
                城区上限
                </td>
                <td>
                城郊上限
                </td>
                <td>
                    城区核心业务量达标下限
                </td>
                 <td>
                    城区积分业务量达标下限
                </td>
                 <td>
                  城郊核心业务量达标下限
                </td>
                <td>
                  城郊积分业务量达标下限
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.dp.datas}">
                 <c:url value="/cms/reward/creditstd.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value=""/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                     <s:Code2Name code="${item.slv}" definition="#mutistarts"/>
                     </td>
                     <td>
                     	<c:out value="${item.citystd}"/>
                     </td>
                     <td>
                     	<c:out value="${item.countrystd}"/>
                     </td>
                     <td>
                     	<c:out value="${item.citycorelimit}"/>
                     </td>
                     <td>
                     	<c:out value="${item.cityaccountlimit}"/>
                     </td>
                     <td>
                     	<c:out value="${item.countycorelimit}"/>
                     </td>
                     <td>
                     	<c:out value="${item.countyaccountlimit}"/>
                     </td>
                 </tr>
             </c:forEach>
        </table>
     </div>
   </div>
   <br>
   <br>
<!-- 用于列出省公司的标准  结束 -->
    <div class="table_div">
        <table class="form_table">
        	<tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require">酬金类型:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:select   property="rewardtype" onchange="changeType(this)" >
                            	<option value=""></option>
                            <c:forEach var="item" items="${requestScope.dpselected.datas}">
	                           <option value="<c:out value="${item.rewardtype}"/>"><c:out value="${item.rewardname}"/></option>
                            </c:forEach>
                            </html:select>
                            <font color='red'>*</font>
                        </c:when>
                        <c:otherwise>
                            <html:select  property="rewardtype" disabled="true" >
	                           <option value="<c:out value="${form.rewardtype}"/>"><c:out value="${form.rewardname}"/></option>
                            </html:select>
                            <font color='red'>*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="creditstd" key="slv"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:select property="slv" disabled="true">
								<html:option value=""></html:option>
								<s:Options definition="$CH_STARLEVELONLY" />
							</html:select>
							<font color='red'>*</font>
					    </c:if>
                        <c:if test="${!updateState}">
                        	<html:select property="slv">
								<html:option value=""></html:option>
								<s:Options definition="$CH_STARLEVELONLY" />
							</html:select>
							<font color='red'>*</font>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:select property="slv" disabled="true">
								<html:option value=""></html:option>
								<s:Options definition="$CH_STARLEVELONLY" />
							</html:select>
							<font color='red'>*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="creditstd" key="adtypecode"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:select property="adtypecode" disabled="true">
								<html:option value=""></html:option>
								<s:Options definition="$CH_ACCOUNTREGION" />
							</html:select>
                            <font color='red'>*</font>
                        </c:if>
                        <c:if test="${!updateState}">
                        	<html:select property="adtypecode" >
								<html:option value=""></html:option>
								<s:Options definition="$CH_ACCOUNTREGION" />
							</html:select>
                            <font color='red'>*</font>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:select property="adtypecode" disabled="true">
								<html:option value=""></html:option>
								<s:Options definition="$CH_ACCOUNTREGION" />
							</html:select>
							<font color='red'>*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="creditstd" key="slvlev"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:select property="slvlev" disabled="true">
								<html:option value=""></html:option>
								<s:Options definition="$CH_STARLAV" />
							</html:select>
							<font color='red'>*</font>
					    </c:if>
                        <c:if test="${!updateState}">
                        	<html:select property="slvlev">
								<html:option value=""></html:option>
								<s:Options definition="$CH_STARLAV" />
							</html:select>
							<font color='red'>*</font>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:select property="slvlev" disabled="true">
								<html:option value=""></html:option>
								<s:Options definition="$CH_STARLAV" />
							</html:select>
							<font color='red'>*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require">规则编码:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <!-- 
                            <html:text styleClass="form_input_1x" property="ruleid" />
                            <font color='red'>*</font>
                             --> 
                     <input type="text" id="ruleid" name="ruleid" value="<c:out value="${form.ruleid}"/>" 
			        			 size="23" />
			        <input type="button" value="..." class="clickButton" onclick="doShowRule('ruleid')" >
			        <font color='red'>*</font>
                        </c:when>
                        <c:otherwise>
                     <input type="text" id="ruleid" name="ruleid" value="<c:out value="${form.ruleid}"/>" 
			        			 size="23" />
			        <input type="button" value="..." class="clickButton" onclick="doShowRule('ruleid')" >
                           <!-- <html:text styleClass="form_input_1x" property="ruleid" disabled="true"/>  --> 
                           <font color='red'>*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require">间隔月份:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="intvmonth" />
                            <font color='red'>*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="intvmonth" disabled="true"/>
                            <font color='red'>*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr id="rewardstd5">
                <td width="20%" align="right" class="form_table_right"><div class="field-require">积分奖励金额标准:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="rewardstd" />
                            <font color='red'>*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rewardstd" disabled="true"/>
                            <font color='red'>*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr id="creditstd5">
                <td width="20%" align="right" class="form_table_right"><div class="field-require">星级积分标准:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="creditstd" />
                            <font color='red'>*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="creditstd" disabled="true"/>
                            <font color='red'>*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr id="cardstd5">
                <td width="20%" align="right" class="form_table_right"><div class="field-require">核心业务量标准:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="cardstd" />
                            <font color='red'>*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="cardstd" disabled="true"/>
                            <font color='red'>*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr id="rewardstd1">
                <td width="20%" align="right" class="form_table_right"><div class="field-require">门店补贴金额标准:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="rewardstd11" />
                            <font color='red'>*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rewardstd11" disabled="true"/>
         					<font color='red'>*</font>
                            
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </div>
                    <c:choose>
                        <c:when test="${edtState}">
                          
                        </c:when>
                        <c:otherwise>
                          
         <script language="JavaScript">
		 var rewardtype=document.getElementsByName("rewardtype")[0].value;
			if(rewardtype=="54"){
	        		document.getElementById("rewardstd5").style.display="none";
	        		document.getElementById("creditstd5").style.display="none";
	        		document.getElementById("cardstd5").style.display="none";
	        		document.getElementById("rewardstd1").style.display="block";	
	        	}else{
	        	 	document.getElementById("rewardstd5").style.display="block";
	        		document.getElementById("creditstd5").style.display="block";
	        		document.getElementById("cardstd5").style.display="block";
	        		document.getElementById("rewardstd1").style.display="none";
	        		
	        	}

        </script>
                            
                        </c:otherwise>
                    </c:choose>
    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" class="form_table_center">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/reward/creditstd.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/reward/creditstd.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
