<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title>市公司长期激励酬金标准设置</title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript">
    
        function ev_checkval() {
        	addfield('intvmonth', '间隔月份', 'l', false, '10');
        	addfield('rewardstd', '间隔月份', 'd', false, '8','2');
        	var isstar=document.all("isstar");
        	if (isstar.checked) {
        		if(document.all("slv").value == ""){
        		alert("星级不能为空!");
        		}
        	}
            return checkval(window);
        }
        
        function doCqjl(url){
        
        if (ev_checkval()) {
        	formItem.action=contextPath + url ;
			formItem.submit();
    	}
    	return false;
        	
        }
        
        function checkIsstar(checkvalue){
        
        	var isstar=document.all("isstar");
        	if (isstar.checked) {
        		document.all("slv").disabled=false;
        	}
        	if (!isstar.checked) {
        		document.all("slv").disabled=true;
        	}
        }
        
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/reward/creditstd.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'content' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/creditstd/CreditstdForm']}"/>
    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			市公司长期激励酬金标准设置
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
	                <td width="20%" align="right" class="form_table_right"><div class="field-require">是否关联星级:</div></td>
	                <td width="80%" align="left" colspan="3" class="form_table_left">
	                	 <c:choose>
	                        <c:when test="${edtState||errorState}">
	                            <html:checkbox property="isstar"   onclick="checkIsstar(this);" />   
	                        </c:when>
	                        <c:otherwise>
	                            <html:checkbox property="isstar" disabled="true"/>   
	                        </c:otherwise>
	                    </c:choose>
	                	
	                </td>
	            </tr>
             <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require">星级:</div></td>
                <td width="30%" align="left" class="form_table_left">
                	<c:choose>
                		 <c:when test="${edtState||errorState}">
                			<html:select property="slv">
								<option />
									<s:Options definition="$CH_STARLEVELONLY" />
							</html:select>
							
                		</c:when>
                		<c:otherwise>
                			<html:select property="slv" disabled="true">
								<option />
									<s:Options definition="$CH_STARLEVELONLY" />
							</html:select>
                		</c:otherwise>
                	</c:choose>
                </td>
              </tr>
              <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require">间隔月份:</div></td>
                <td width="30%" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState||errorState}">
                        	<html:text styleClass="form_input_1x" property="intvmonth" />
                        </c:when>
                        <c:otherwise>
                        	<html:text styleClass="form_input_1x" property="intvmonth" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>*</font>
                    <font color=red>T月激活，T+7月发放，则间隔月份为6</font>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require">长期激励酬金标准:</div></td>
                <td width="30%" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState||errorState}">
                        	<html:text styleClass="form_input_1x" property="rewardstd" />
                        </c:when>
                        <c:otherwise>
                        	<html:text styleClass="form_input_1x" property="rewardstd" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>*</font>
                </td>
            </tr>
        </table>
    </div>
    

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td>
                	<c:choose>
                        <c:when test="${edtState||errorState}">
                            <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
	                           onclick="doCqjl('/cms/reward/creditstd.do?CMD=CQJL')"/>
                        </c:when>
                        <c:otherwise>
                            <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
		                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
		                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
		                           onclick="doCqjl('/cms/reward/creditstd.do?CMD=CQJL')" disabled="disabled"/>
                        </c:otherwise>
                    </c:choose>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/reward/cqjlcjbz/list.jsp')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
