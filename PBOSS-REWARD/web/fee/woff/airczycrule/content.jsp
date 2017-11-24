<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="4D1A1AAA" />
</jsp:include>
<%@ include file="/inc/contenthead.inc" %>
<% 
    String ID_1 = "4D1A1AAABT1";
    String ID_2 = "4D1A1AAABT2";
	String ID_3 = "4D1A1AAABT3";
%>
<html:html>
<head>
    <title><bean:message bundle="airczycrule" key="title"/></title>
    <script language="JavaScript">
        function ev_checkval() {  
            addfield('chargeamt', '<bean:message bundle="airczycrule" key="chargeamt"/>', 'l', false, 8);
            addfield('presentamt', '<bean:message bundle="airczycrule" key="presentamt"/>', 'l', false, 8);
            addfield('presentacctid', '<bean:message bundle="airczycrule" key="presentacctid"/>', 'l', false, 14);
            addfield('startdate', '<bean:message bundle="airczycrule" key="starttime"/>', 'dt', false, 20);
            addfield('presentmonths', '<bean:message bundle="airczycrule" key="presentmonths"/>', 'l', true, 4);
            addfield('zstime', '<bean:message bundle="airczycrule" key="zsflag"/>', 't', true, 10);
            addfield('zsmonths', '<bean:message bundle="airczycrule" key="zsmonths"/>', 'l', true, 3);
            addfield('prodid', '<bean:message bundle="airczycrule" key="prodid"/>', 'c', false, 32);
            addfield('pri', '<bean:message bundle="airczycrule" key="pri"/>', 'l', true, 4);
            addfield('memo', '<bean:message bundle="airczycrule" key="memo"/>', 'c', true, 256);
			
			if(formItem.presentmonths.value < 1) 
			{
			alert("<bean:message bundle="airczycrule" key="presentmonths"/>应>=1");
			return;
			}
			var day = formItem.startdate.value.substring(8,10);
			if(day >= 29)
			{
			alert("<bean:message bundle="airczycrule" key="starttime"/>应<=28号");	
			 return;
			 }
			 
			 var acctid = formItem.presentacctid.value;
			 var prodid = formItem.prodid.value;
			 var prodids = prodid.split(",");
			 // 神大('201','202','203','204','205','206','207','208')的21,动感('101','102','1005')的20
			 if(acctid == 20)
			 {
			 	for(i = 0; i< prodids.length-1; i++)
			 	{
			 		
					if(prodids[i] != "101"&&prodids[i] != "102"&&prodids[i] != "1005")
			 		{
			 			alert("赠送的账本科目与产品ID不符合，请检查！！！！");
			 			return;
			 		}		 		
			 	}
			 }else if(acctid == 21)
			 {
			 	for(i = 0; i< prodids.length-1; i++)
			 	{
			 		
					if(prodids[i] != "201"&&prodids[i] != "202"&&prodids[i] != "203"&&prodids[i] != "204"&&prodids[i] != "205"&&prodids[i] != "206"&&prodids[i] != "207"&&prodids[i] != "208") 
			 		{
			 			alert("赠送的账本科目与产品ID不符合，请检查！！！！");
			 			return;
			 		}		 		
			 	}		
			 }else if(acctid != "20"&&acctid != "21")
			 {
			 	alert("赠送的账本科目不存在，请检查！！！！");
			 	return;
			 }
            return checkval(window);
        }
    </script>
</head>
<body onload="loadforiframe();">
<div class="table_container">
<html:form action="/fee/woff/airczycrule.do?CMD=SAVE" styleId="formItem" method="post">

    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="ruleid"/>


    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="new" scope="request" value="${!empty param.CMD and param.CMD eq 'NEW'}"/>

	<div class="table_div">
		<table class="top_table">		
			<tr> 
				<td><bean:message bundle="airczycrule" key="title"/></td>

			</tr>
		</table>
	</div>
	<div class="table_div">
		<table class="error_text">
			<html:errors />
			<s:Msg />
		</table>
	</div>
	<div class="table_div">
        <table class="form_table">
        	<tr>
				<td colspan="4"><bean:message bundle="fee" key="redStarExplain"/></td>
			</tr>
			<tr>
                <td class="form_table_right"><bean:message bundle="airczycrule" key="chargeamt"/>:<div class="field-require"></div></td>
                <td class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="chargeamt"/><bean:message bundle="fee" key="redStar"/>
                        </c:when>
                        <c:otherwise>
							<html:text styleClass="form_input_1x" property="chargeamt" disabled="true"/><bean:message bundle="fee" key="redStar"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="airczycrule" key="starttime"/>:</div></td>
                <td class="form_table_left">
                     <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="startdate" onclick="this.value=selectDatetime()"/><bean:message bundle="fee" key="redStar"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="startdate" disabled="true" /><bean:message bundle="fee" key="redStar"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                
            </tr>
            <tr>
            	<td class="form_table_right"><bean:message bundle="airczycrule" key="presentmonths"/>:<div class="field-require"></div></td>
                <td class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="presentmonths"/>
                        </c:when>
                        <c:otherwise>
							<html:text styleClass="form_input_1x" property="presentmonths" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td class="form_table_right"><bean:message bundle="airczycrule" key="pri"/>:<div class="field-require"></div></td>
                <td class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="pri"/>
                        </c:when>
                        <c:otherwise>
							<html:text styleClass="form_input_1x" property="pri" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            
            </tr>
            
            <tr>
            	<td class="form_table_right"><div class="field-require"><bean:message bundle="airczycrule" key="presentamt"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="presentamt"/><bean:message bundle="fee" key="redStar"/>
                        </c:when>
                        <c:otherwise>
							<html:text styleClass="form_input_1x" property="presentamt" disabled="true"/><bean:message bundle="fee" key="redStar"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            	<td class="form_table_right"><bean:message bundle="airczycrule" key="presentacctid"/>:<div class="field-require"></div></td>
                <td class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState}">
                        	<html:select property="presentacctid">
								<html:option value=" "></html:option>
								<s:Options definition="#PRESENTACCTID" nameOnly="false"/>
							</html:select><bean:message bundle="fee" key="redStar"/>
                        </c:when>
                        <c:otherwise>
                        	<html:select property="presentacctid">
								<html:option value=" "></html:option>
								<s:Options definition="#PRESENTACCTID" nameOnly="false"/>
							</html:select><bean:message bundle="fee" key="redStar"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            
            </tr>
            
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="airczycrule" key="zsdate"/>:</div></td>
                <td class="form_table_left">
                     <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="zstime" onclick="this.value=selectDate()"/><bean:message bundle="fee" key="redStar"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="zstime" disabled="true" /><bean:message bundle="fee" key="redStar"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td class="form_table_right"><bean:message bundle="airczycrule" key="zsmonths"/>:<div class="field-require"></div></td>
                <td class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="zsmonths"/>
                        </c:when>
                        <c:otherwise>
							<html:text styleClass="form_input_1x" property="zsmonths" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                
            </tr>
            
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="airczycrule" key="prodid"/>:</div></td>
                <td class="form_table_left" colspan="3">
                    <c:choose>
                        <c:when test="${edtState}">
                            <s:MoreCheck definition="#PRODID" property="prodid" styleClass="form_input_3x"/><bean:message bundle="fee" key="redStar"/>
                        </c:when>
                        <c:otherwise>
							<s:MoreCheck definition="#PRODID" property="prodid" styleClass="form_input_3x" showonly="true"/><bean:message bundle="fee" key="redStar"/>
                        </c:otherwise>
                    </c:choose>
                </td>
               
            </tr>
            
            <tr>  
            	<td class="form_table_right"><div class="field-require"><bean:message bundle="airczycrule" key="memo"/>:</div></td>
                <td class="form_table_left" colspan="3">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:textarea  property="memo" styleClass="form_textarea_on"/>
                        </c:when>
                        <c:otherwise>
                            <html:textarea  property="memo" styleClass="form_textarea_on" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>           
		</table>
	</div>            

    
	<div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
					<s:PurChk controlid="<%=ID_1%>">
					<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_submit"/>" class="submit"
                           onclick="doSave('/fee/woff/airczycrule.do?CMD=SAVE')"/>
                    </s:PurChk>
                    <s:PurChk controlid="<%=ID_3%>">   
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/fee/woff/airczycrule.do?CMD=LIST')">
                    </s:PurChk>       
				</td>		
			</tr>
		</table>
	</div>
</html:form>
</div>
</body>
</html:html>
