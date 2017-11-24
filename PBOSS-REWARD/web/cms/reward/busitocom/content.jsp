<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/commons" prefix="s" %>
<%
	String ID_1 = "CH_PW_REWARD_PROVINCIAL||CH_PW_REWARD_CIVIC||CH_PW_REWARD";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="busitocom" key="titleUpdate"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('opnid', '<bean:message bundle="busitocom" key="opnid"/>', 'c', false, '18');
            addfield('comid', '<bean:message bundle="busitocom" key="comid"/>', 'f', false, '18');
            addfield('pricelowd', '<bean:message bundle="busitocom" key="pricelow"/>', 'd', false, '14','2','','0');
            addfield('pricetopd', '<bean:message bundle="busitocom" key="pricetop"/>', 'd', false, '14','2','','0');
            addfield('busitype', '<bean:message bundle="busitocom" key="busitype"/>', 'c', false, '32');
            if(parseFloat(formItem.pricelowd.value) > parseFloat(formItem.pricetopd.value)){
           		alert('业务编码起始价格（闭区间）必须小于业务编码结束价格（闭区间）');
           		return false;
           	}
            if(checkval(window)){
            	formItem.pricelow.value = parseInt(formItem.pricelowd.value*100);
            	formItem.pricetop.value = parseInt(formItem.pricetopd.value*100);
            	return true;
            }else{
            	return false;
            }
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/reward/busitocom.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    
    <html:hidden property="cityid"/>
    <html:hidden property="comclassid"/>
    <html:hidden property="comtype"/>
    <html:hidden property="comresid"/>
    <html:hidden property="pricelow"/>
    <html:hidden property="pricetop"/>
    
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/busitocom/BusitocomForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="busitocom" key="titleList"/>
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
                <td width="30%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="busitocom" key="comid"/>:</div></td>
                <td width="70%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
	                        <c:if test="${updateState}">
	                        	<html:text styleClass="form_input_1x" property="comid" disabled="true"/>
	                        	<font color="red">*</font>
	                        </c:if>
	                        <c:if test="${!updateState}">
	                        	<s:Comidtree styleClass="form_input_1x" property="comid" condition="comclassid:2;comclassid:5;comclassid:6;comclassid:99;comclassid:1" definition="#COMSYSTEM" nameOnly="false"/>
	                        	<font color="red">*</font>
	                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="comid" disabled="true"/>
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="30%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="busitocom" key="opnid"/>:</div></td>
                <td width="70%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
	                        <c:if test="${updateState}">
	                            <html:text styleClass="form_input_1x" property="opnid" disabled="true"/>
	                            <font color="red">*</font>
	                        </c:if>
	                        <c:if test="${!updateState}">
	                            <html:text styleClass="form_input_1x" property="opnid"/><input type="button" value="..." class="clickbutton" onclick="showOpnTree2(this, 'opnid' , 'busi')">
	                            <font color="red">*</font>
	                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="opnid" disabled="true"/>
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="30%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="busitocom" key="pricelow"/>:</div></td>
                <td width="70%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	<input type="text" name="pricelowd" value="<fmt:formatNumber pattern="0.00" value='${form.pricelowd}'/>" class="form_input_1x" />
                            <font color="red">*</font>（只能填正数，支持2位小数，单位：元）
                        </c:when>
                        <c:otherwise>
                            <input type="text" name="pricelowd" value="<fmt:formatNumber pattern="0.00" value='${form.pricelowd}'/>" class="form_input_1x" disabled="disabled"/>
                            <font color="red">*</font>（只能填正数，支持2位小数，单位：元）
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="30%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="busitocom" key="pricetop"/>:</div></td>
                <td width="70%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <input type="text" name="pricetopd" value="<fmt:formatNumber pattern="0.00" value='${form.pricetopd}'/>" class="form_input_1x" />
                            <font color="red">*</font>（只能填正数，支持2位小数，单位：元）
                        </c:when>
                        <c:otherwise>
                            <input type="text" name="pricetopd" value="<fmt:formatNumber pattern="0.00" value='${form.pricetopd}'/>" class="form_input_1x" disabled="disabled"/>
                            <font color="red">*</font>（只能填正数，支持2位小数，单位：元）
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="30%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="busitocom" key="busitype"/>:</div></td>
                <td width="70%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	<html:select property="busitype">
								<option />
								<s:Options definition="$CH_TOCOMBUSITYPE" />
							</html:select>
							<font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <html:select property="busitype" disabled="true">
								<option />
								<s:Options definition="$CH_TOCOMBUSITYPE" />
							</html:select>
							<font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" class="form_table_center">
                	<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
                	<c:choose>
                        <c:when test="${edtState}">
	                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
	                           onclick="doSave('/cms/reward/busitocom.do?CMD=SAVE')"/>
	                    </c:when>
                        <c:otherwise>
                        <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
	                           onclick="doSave('/cms/reward/busitocom.do?CMD=SAVE')" disabled="disabled"/>
                        </c:otherwise>
                    </c:choose>
                    </s:RewardPurChk>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/reward/busitocom.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
    
    <div class="table_div">
        <table class="form_table">
        	<tr>
        		<td width="10%" align="right" class="form_table_right">
        			备注:
        		</td>
        		<td width="90%" align="left" class="form_table_left">
        			1、本菜单主要针对定制终端计酬业务进行设置<br/>
					2、设置时，请根据资源入库时的实际操作进行对应业务编码的设置<br/>
					3、一个商品标识，设置对应一个业务编码<br/>
        		</td>
        	</tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
