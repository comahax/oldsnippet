<%@ page language="java" contentType="text/html;charset=GBK"%>
<%//  contenthead.inc是content.jsp的文件头，声明了JS、CSS等的引用，所有content.jsp必须引用这个文件头%>
<%@ include file="/inc/contenthead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A3CBB30" />
</jsp:include>
<%
	//业务控制点标识，暂时没用上，先保留  
    String PID = "2B1A3CBB30";
    String ID_1 = PID + "BT1";
    String ID_2 = PID + "BT2";
    String ID_3 = PID + "BT3";    
%>
<html:html>
<head>
    <title><bean:message bundle="wayentitybch" key="titleUpdate"/></title>
    <script language="JavaScript">
        <%//录入数据的校检%>
        function ev_checkval() {
            addfield('wayid', '<bean:message bundle="wayentitybch" key="wayid"/>', 'c', false, 18);    
            addfield('bchtype', '<bean:message bundle="wayentitybch" key="bchtype"/>', 'c', true, 3);    
            addfield('ownedby', '<bean:message bundle="wayentitybch" key="ownedby"/>', 'c', true, 100);    
            addfield('wayarea', '<bean:message bundle="wayentitybch" key="wayarea"/>', 'c', true, 100);    
            addfield('areaattr', '<bean:message bundle="wayentitybch" key="areaattr"/>', 'c', true, 100);    
            addfield('constrtype', '<bean:message bundle="wayentitybch" key="constrtype"/>', 'i', true, 3);                
            
            addfield('opentime', '<bean:message bundle="wayentitybch" key="opentime"/>', 't', true, 10);    
            addfield('worktime', '<bean:message bundle="wayentitybch" key="worktime"/>', 't', true, 10);    
            addfield('bussupply', '<bean:message bundle="wayentitybch" key="bussupply"/>', 'c', true, 255);    
            addfield('busstate', '<bean:message bundle="wayentitybch" key="busstate"/>', 'i', true, 3);    
            addfield('employcnt', '<bean:message bundle="wayentitybch" key="employcnt"/>', 'i', true, 6);                
            addfield('buytype', '<bean:message bundle="wayentitybch" key="buytype"/>', 'i', true, 3);                
            addfield('byeprice', '<bean:message bundle="wayentitybch" key="byeprice"/>', 'd', true, 16,2);    
            
            addfield('rentunit', '<bean:message bundle="wayentitybch" key="rentunit"/>', 'c', true, 255);    
            addfield('rentperiod', '<bean:message bundle="wayentitybch" key="rentperiod"/>', 'c', true, 20);               
            addfield('rent', '<bean:message bundle="wayentitybch" key="rent"/>', 'd', true, 16,2);                
            addfield('decinvest', '<bean:message bundle="wayentitybch" key="decinvest"/>', 'd', true, 16,2);                
            addfield('compactarea', '<bean:message bundle="wayentitybch" key="compactarea"/>', 'd', true, 16,2);   
            
            addfield('envdescp', '<bean:message bundle="wayentitybch" key="envdescp"/>', 'c', true, 255);   
            addfield('bossarea', '<bean:message bundle="wayentitybch" key="bossarea"/>', 'c', true, 14);          
            return checkval(window);
        }
    </script>
</head>
<body onload="loadforiframe()">

<html:form action="/cms/wayentitybch.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>
    <%//查询页面的参数，有了这些就能在增加，编辑时返回编辑前的正确页面%>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_wayid"/> 
       
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW' or param.CMD eq 'EDITNEW')}"/>
    
<!--##################################添加标题内容，里面可以放置按钮##################################################-->		

	<div class="table_div">				
		<table class="top_table">
			<tr> 
				<td>
					<bean:message bundle="wayentitybch" key="titleList"/>
				</td>
			</tr>
		</table>
	</div>
	
	 <div class="table_div">	
		<table width="100%" class="error_text">
		    <html:errors/><s:Msg />
	    </table>	
    </div>
    
<!--#################################添加标题内容，里面可以放置按钮###################################################-->		
	<div class="table_div">	
        <table class="form_table">
        	<tr >
				<td align=left colspan="4">&nbsp;&nbsp;<bean:message bundle="public" key="msgRequired"/></td>
			</tr>
            <tr >
                <td width="20%" align="right"><div class="field-require"><bean:message bundle="wayentitybch" key="wayid"/>:</div></td>
                <td  width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="wayid" readonly="true" /><font color=red>&nbsp;* <bean:message bundle="waylicence" key="readonly"/></font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                 <td width="20%" align="right"><div class="field-require"><bean:message bundle="wayentitybch" key="bchtype"/>:</div></td>
                <td   width="30%" align="left" class="form_table_left">
                    <c:choose>
	                        <c:when test="${edtState}">
	                           	<html:select property="bchtype">
	                        		<s:Options definition="#CUSTBCHTYPE" />
	                        	</html:select>                         	 
	                        </c:when>
	                        <c:otherwise>
	                            <html:select property="bchtype" disabled="true">
	                        		<s:Options definition="#CUSTBCHTYPE"/>
	                        	</html:select>  
	                        </c:otherwise>
	                </c:choose>
                </td>
                
            </tr>
            <tr >
                <td  align="right"><div class="field-require"><bean:message bundle="wayentitybch" key="ownedby"/>:</div></td>
                <td  align="left" class="form_table_left" colspan="3">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_3x" property="ownedby" maxlength="24"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_3x" property="ownedby" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>                
            </tr>
            
             <tr >
               <td  align="right"><div class="field-require"><bean:message bundle="wayentitybch" key="wayarea"/>:</div></td>
                <td  align="left" class="form_table_left"  colspan="3">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_3x" property="wayarea"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_3x" property="wayarea" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                
            </tr>
            
            <tr >
              <td  align="right"><div class="field-require"><bean:message bundle="wayentitybch" key="areaattr"/>:</div></td>
                <td  align="left"  colspan="3">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_3x" property="areaattr"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_3x" property="areaattr" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr >                
               <td  align="right"><div class="field-require"><bean:message bundle="wayentitybch" key="constrtype"/>:</div></td>
                <td  align="left"  colspan="3">
                    <c:choose>
	                        <c:when test="${edtState}">
	                           	<html:select property="constrtype">
	                        		<s:Options definition="$CH_CONSTRTYPE" />
	                        	</html:select>                         	 
	                        </c:when>
	                        <c:otherwise>
	                            <html:select property="constrtype" disabled="true">
	                        		<s:Options definition="$CH_CONSTRTYPE"/>
	                        	</html:select>  
	                        </c:otherwise>
	                </c:choose> 
                </td>
                
            </tr>             
            <tr >
                <td  align="right"><div class="field-require"><bean:message bundle="wayentitybch" key="opentime"/>:</div></td>
                <td  align="left" >
                     <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="opentime" onclick="this.value=selectDate()" readonly="true"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="opentime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                
               <td  align="right"><div class="field-require"><bean:message bundle="wayentitybch" key="worktime"/>:</div></td>
                <td  align="left" >
                      <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="worktime" onclick="this.value=selectDate()" readonly="true"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="worktime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            
            <tr >
              <td  align="right"><div class="field-require"><bean:message bundle="wayentitybch" key="bussupply"/>:</div></td>
                <td  align="left" colspan="3">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_3x" property="bussupply"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_3x" property="bussupply" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                
              
            </tr>
            
             <tr >
             <td  align="right"><div class="field-require"><bean:message bundle="wayentitybch" key="busstate"/>:</div></td>
                <td  align="left" >
                    <c:choose>
	                        <c:when test="${edtState}">
	                           	<html:select property="busstate">
	                        		<s:Options definition="$CH_BUSSTATE" />
	                        	</html:select>                         	 
	                        </c:when>
	                        <c:otherwise>
	                            <html:select property="busstate" disabled="true">
	                        		<s:Options definition="$CH_BUSSTATE"/>
	                        	</html:select>  
	                        </c:otherwise>
	                </c:choose> 
                </td>
                
                <td  align="right"><div class="field-require"><bean:message bundle="wayentitybch" key="employcnt"/>:</div></td>
                <td  align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="employcnt"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="employcnt" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                
             </tr>
             <tr >
               <td  align="right"><div class="field-require"><bean:message bundle="wayentitybch" key="buytype"/>:</div></td>
                <td  align="left" >
                    <c:choose>
	                        <c:when test="${edtState}">
	                           	<html:select property="buytype">
	                        		<s:Options definition="$CH_BUYTYPE" />
	                        	</html:select>                         	 
	                        </c:when>
	                        <c:otherwise>
	                            <html:select property="buytype" disabled="true">
	                        		<s:Options definition="$CH_BUYTYPE"/>
	                        	</html:select>  
	                        </c:otherwise>
	                </c:choose> 
                </td>
                
                <td  align="right"><div class="field-require"><bean:message bundle="wayentitybch" key="byeprice"/>:</div></td>
                <td  align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="byeprice"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="byeprice" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            
          <tr >
             	
                
               <td  align="right"><div class="field-require"><bean:message bundle="wayentitybch" key="rentunit"/>:</div></td>
                <td  align="left" colspan="3">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_3x" property="rentunit"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_3x" property="rentunit" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                
             
                
            </tr>
            
           <tr >      
               <td  align="right"><div class="field-require"><bean:message bundle="wayentitybch" key="rentperiod"/>:</div></td>
                <td  align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="rentperiod"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rentperiod" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                
                <td  align="right"><div class="field-require"><bean:message bundle="wayentitybch" key="rent"/>:</div></td>
                <td  align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="rent"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rent" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            
           <tr >
             	<td  align="right"><div class="field-require"><bean:message bundle="wayentitybch" key="decinvest"/>:</div></td>
                <td  align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="decinvest"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="decinvest" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                
               <td  align="right"><div class="field-require"><bean:message bundle="wayentitybch" key="compactarea"/>:</div></td>
                <td  align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="compactarea"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="compactarea" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            
          <tr >
             	<td  align="right"><div class="field-require"><bean:message bundle="wayentitybch" key="envdescp"/>:</div></td>
                <td  align="left"  colspan="3">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_3x" property="envdescp" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_3x" property="envdescp"  disabled="true"/>
                        </c:otherwise>                        
                    </c:choose>
                </td>
                
              
            </tr>
            
             <tr >
             	 <td  align="right"><div class="field-require"><bean:message bundle="wayentitybch" key="bossarea"/>:</div></td>
                <td  align="left" colspan="3">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="bossarea"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="bossarea" disabled="true"/>
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
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/wayentitybch.do?CMD=SAVE')"/>
                         </s:PurChk>  
                         
                         <s:PurChk controlid="<%=ID_2%>"> 
	                    	<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
	                     </s:PurChk>      	                  
						</td>
                    </tr>
		</table>
    </div>
</html:form>
</body>
</html:html>
