<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%
    String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_CIVIC||CH_PW_REWARD_PROVINCIAL";
%>
<html>
<head>
    <title><bean:message bundle="rewardrecord" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        addfield('calcmonth', '业务发生月', 'c', false, '6');
        addfield('cityid', '区域', 'c', false, '6');
            return checkval(window);
        }
        function exports(){
        	if(!isValidYYYYMM(formList.calcmonth.value)){
		 		alert("请填写正确格式的业务发生月，例如201108");
		 		return;
		 	}
		 	if(formList.cityid.value==''){
		 		alert("区域不能为空");
		 		return;
		 	}
        	var form=document.forms[0];
			form.action="<%=contextPath%>/cms/reward/backgroundfileexport.do?CMD=DOWNLOAD";
			form.submit();
		}
		
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/backgroundfileexport.do?CMD=SHOW" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/backgroundfileexport/BackgroundfileexportForm']}"/>
    
    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			G3转化率文件导出
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
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	业务发生月:
            	</td>
            	<td class="form_table_left">
            		<input type="text" name="calcmonth" class="form_input_1x"
            		value="<c:out value='${form.calcmonth}'/>"  onclick="this.value=selectDateYYYYMM(this.value);" readonly="true" />
            		
            		
    			<font color="red">*</font>
            	</td>
            </tr>
            <tr>
            	<td  width="20%" height="20" align="right" class="form_table_right"  >
            	区域:
            	</td>
            	<td>
            	<c:choose>
						<c:when test="${empty form.cityid}">
							<html:select property="cityid" >
								<html:option value=""></html:option>
								<s:Options definition="#REGIONNAME" />
							</html:select>
						</c:when>
						<c:otherwise>
							<html:select property="cityid" disabled="true">
								<html:option value=""></html:option>
								<s:Options definition="#REGIONNAME" />
							</html:select>
						</c:otherwise>
				</c:choose>
				<font color="red">*</font>
				</td>
	        </tr>
            
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                	<s:PurChk controlid="<%=ID_1%>">
                        <input type="button" class="button_6" onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="导出" onclick="exports()"/>
                    </s:PurChk>
                </td>
			</tr>
		</table>
	</div>

    
   </div>

   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
</html:form>

</body>
</html>
