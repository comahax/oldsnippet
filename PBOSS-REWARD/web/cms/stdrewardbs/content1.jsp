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
    <title><bean:message bundle="stdrewardbs" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
        	var check = formItem.checkacctype.value;
        	addfield('checkacctype', '<bean:message bundle="stdrewardbs" key="acctype"/>', 'i', false, '3');
        	addfield('ttcitystd', '<bean:message bundle="stdrewardbs" key="ttcitystd"/>', 'f', false, '14','4','','0',formItem.ttcitystd.value);
            addfield('ttcountrystd', '<bean:message bundle="stdrewardbs" key="ttcountrystd"/>', 'f', false, '14','4','','0',formItem.ttcountrystd.value);
            addfield('intvmonth', '<bean:message bundle="stdrewardbs" key="intvmonth"/>', 'i', false, '5');
        	if(check == '11'){
       			addfield('citystd', '<bean:message bundle="stdrewardbs" key="citystd"/>', 'f', false, '14','4','','0',formItem.procitystd.value);
            	addfield('countrystd', '<bean:message bundle="stdrewardbs" key="countrystd"/>', 'f', false, '14','4','','0',formItem.procountrystd.value);
            	if(parseFloat(formItem.procitystd.value) < parseFloat(formItem.ttcitystd.value)){
            		alert('ԭ��ͨ�������׼��������ӦС�ڵ���ʡ��˾���õ������ĳ���׼');
            		return false;
            	}
            	if(parseFloat(formItem.procountrystd.value) < parseFloat(formItem.ttcountrystd.value)){
            		alert('ԭ��ͨ�������׼��������ӦС�ڵ���ʡ��˾���õĽ����ĳ���׼');
            		return false;
            	}
            }else{
            	addfield('basicsalenum', '<bean:message bundle="stdrewardbs" key="basicsalenum"/>', 'i', false, '8','','','0');
            	addfield('topsalenum', '<bean:message bundle="stdrewardbs" key="topsalenum"/>', 'i', false, '8','','','0');
            	addfield('citystdlow', '<bean:message bundle="stdrewardbs" key="citystdlow"/>', 'f', false, '14','4','','0',formItem.citystdmid.value);
            	addfield('countrystdlow', '<bean:message bundle="stdrewardbs" key="countrystdlow"/>', 'f', false, '14','4','','0',formItem.countrystdmid.value);
            	addfield('citystdmid', '<bean:message bundle="stdrewardbs" key="citystdmid"/>', 'f', false, '14','4','','0',formItem.citystdtop.value);
            	addfield('countrystdmid', '<bean:message bundle="stdrewardbs" key="countrystdmid"/>', 'f', false, '14','4','','0',formItem.countrystdtop.value);
            	addfield('citystdtop', '<bean:message bundle="stdrewardbs" key="citystdtop"/>', 'f', false, '14','4','','0',formItem.procitystd.value);
            	addfield('countrystdtop', '<bean:message bundle="stdrewardbs" key="countrystdtop"/>', 'f', false, '14','4','','0',formItem.procountrystd.value);
            	if(parseFloat(formItem.topsalenum.value) < parseFloat(formItem.basicsalenum.value)){
            		alert('��׼����Ӧ��С�ڵ����������');
            		return false;
            	}
            	if(check == '12'){
            		if(parseFloat(formItem.topsalenum.value)*parseFloat(formItem.citystdtop.value)>parseFloat(formItem.procitystd.value)){
            			alert('��������������������������׼�ĳ˻�Ӧ��С�ڵ���������������ֵ');
            			return false;
            		}
            		if(parseFloat(formItem.topsalenum.value)*parseFloat(formItem.countrystdtop.value)>parseFloat(formItem.procountrystd.value)){
            			alert('��������뽼���������������׼�ĳ˻�Ӧ��С�ڵ��ڽ�����������ֵ');
            			return false;
            		}
            	}
            }
            return checkval(window);
        }
        
        function doReturn(url){
    	window.parent.document.location=contextPath + url;
		}
		 function doSave(cmdSave) {
		 var form=document.forms[0];
	   		  if (ev_checkval()) {
	   		  enable();
	      	  form.action = contextPath + cmdSave;
	       	  form.submit();
	  		  }else{
	 		   return false; 
	 		 }
		}
		function initAcctype(){
			var obs = formItem.acctype;
			var check = formItem.checkacctype;
			for(var i=0;i<obs.length;i++){
				var ob = obs[i];
				if(ob.value == check.value){
					ob.checked = true;
				}
				if(ob.checked){
					if(ob.value == '11'){
						document.getElementById("normalAcc").style.display = "";	
						document.getElementById("saleAcc").style.display = "none";
					}else{
						document.getElementById("normalAcc").style.display = "none";	
						document.getElementById("saleAcc").style.display = "";
					}
				}
			}
		}
		function changeAcctype(){
			var obs = formItem.acctype;
			for(var i=0;i<obs.length;i++){
				var ob = obs[i];
				if(ob.checked){
					formItem.checkacctype.value = ob.value;
					if(ob.value == '11'){
						document.getElementById("normalAcc").style.display = "";	
						document.getElementById("saleAcc").style.display = "none";
					}else{
						document.getElementById("normalAcc").style.display = "none";	
						document.getElementById("saleAcc").style.display = "";
					}
				}
			}
		}
		
		
		function doDetails(){
	    	formItem.action="<%=contextPath%>/cms/stdrewardbs.do?CMD=DETAILS";
	    	
	    	formItem.submit();
	    }
		
    </script>
</head>
<body onload="if(window.loadforiframe) loadforiframe();initAcctype();">
<div class="table_container">
<html:form action="/cms/stdrewardbs.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_rewardid"/>
    <html:hidden property="_se_region"/>
    <html:hidden property="_se_slv"/>
	
    <html:hidden property="_sk_rewardname"/>
    <html:hidden property="_dnl_startdate"/>
    <html:hidden property="_dnm_stopdate"/>
    <html:hidden property="rewardid"/>
    <html:hidden property="rewardname"/> 
    <html:hidden property="rewardproj"/>  
    <html:hidden property="startdate"/> 
    <html:hidden property="stopdate"/> 
    <html:hidden property="memo"/> 
   	<html:hidden property="islimt"/> 
   	<html:hidden property="rewardtype"/> 
   	<html:hidden property="region"/> 
   	<html:hidden property="checkacctype"/> 
   	
   	<html:hidden property="procitystd"/> 
   	<html:hidden property="procountrystd"/> 
   	<html:hidden property="procitystdtop"/> 
   	<html:hidden property="procountrystdtop"/> 
   	
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
	
	
	  <!--##################################��ӱ�������##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="stdrewardbs" key="titleList1"/>
   			</td>
    	</tr>
    </table>
    </div>
    <div class="table_div">	
   		 <table width="100%" class="error_text">
    		<html:errors/><s:Msg />
    	</table>
    </div>
<FIELDSET>
		<legend name="organizeinfo"><bean:message bundle="stdreward" key="titleList1"/></legend>
    <div class="table_div">
        <table class="form_table">
            <tr><td colspan="4">
			</td></tr>
			 <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdreward" key="rewardid"/>:</div></td>
                <td width="30%" colspan="4">
                    <c:choose>
                        <c:when test="${edtState}">
                            <c:out value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].rewardid}" /> 
                        </c:when>
                        <c:otherwise>
                           <c:out value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].rewardid}" /> 
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdreward" key="rewardname"/>:</div></td>
                <td width="30%" colspan="4">
                    <c:choose>
                        <c:when test="${edtState}">
                           <c:out value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].rewardname}" /> 
                        </c:when>
                        <c:otherwise>
                            <c:out value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].rewardname}" /> 
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdreward" key="startdate"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                           <fmt:formatDate pattern="yyyy-MM-dd" value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].startdate}"/>
                        </c:when> 
                        <c:otherwise>
                            <fmt:formatDate pattern="yyyy-MM-dd" value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].startdate}"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdreward" key="stopdate"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                           <fmt:formatDate pattern="yyyy-MM-dd" value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].stopdate}"/>
                        </c:when>
                        <c:otherwise>
                          <fmt:formatDate pattern="yyyy-MM-dd" value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].stopdate}"/>
                        </c:otherwise>
                    </c:choose>
                
           </tr>
           <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdreward" key="memo"/>:</div></td>
                <td width="30%" align="left" class="form_table_left" colspan="4">
                     <c:choose>
                        <c:when test="${edtState}"> 
                           <c:out value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].memo}" /> 
                        </c:when>
                        <c:otherwise>
                          <c:out value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].memo}" /> 
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </div>
</FIELDSET>
    <!--##################################��ӱ�������##################################################-->
<FIELDSET>
	<legend name="organizeinfo"><bean:message bundle="stdrewardbs" key="titleList2"/></legend>
    <div class="table_div">
        <table class="form_table">
             <tr><td colspan="4">
				<bean:message bundle="stdrewardbs" key="tishi" />
			</td></tr>
            <tr>
                 <td width="18%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbs" key="slv"/>:</div></td>
                <td width="42%" align="left" class="form_table_left">
                      <c:choose>
								<c:when test="${edtState}">
									<table class="form_table">
										<tr><td>
											<c:forEach var="item" items="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].star}"
												varStatus="vars">
												
													<html:multibox property="seleteSlv" disabled="true">
														<c:out value="${item}" />
													</html:multibox>

													<c:out value="${item}" />
												
												
											</c:forEach></td>
										</tr>
									</table>
								</c:when>
								<c:otherwise>
									<table class="form_table" > 
										<tr><td>
											<c:forEach var="item" items="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].star}" 
												varStatus="vars">
												
													<html:multibox property="seleteSlv" disabled="true">
														<c:out value="${item}" />
													</html:multibox>

													<c:out value="${item}" />
												
												
											</c:forEach>
											
											</td>
										</tr>
									</table>
								</c:otherwise>
							</c:choose>
                </td>
                 <td width="13%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbs" key="region"/>:</div></td>
                <td width="27%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <s:Code2Name code="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].region}" definition="#CITYIDNUM2NMAME"/>
                        </c:when>
                        <c:otherwise>
                        <s:Code2Name code="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].region}" definition="#CITYIDNUM2NMAME"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
            	 <td width="18%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbs" key="acctype"/>:</div></td>
                <td width="42%" colspan="3" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <c:forEach var="item" items="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].acctypes}" varStatus="vars">
                            	<input type="radio" name="acctype" value="<c:out value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].acctypevalues[vars.index]}"/>" onclick="changeAcctype()"/>
								<c:out value="${item}" />
							</c:forEach>
							<font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                        	<c:forEach var="item" items="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].acctypes}" varStatus="vars">
                            	<input type="radio" name="acctype" value="<c:out value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].acctypevalues[vars.index]}"/>" disabled="true"/>
								<c:out value="${item}" />
							</c:forEach>
							<font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
            	<td width="18%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbs" key="intvmonth"/>:</div></td>
                <td width="42%" colspan="3" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="intvmonth" maxlength="5"/>
                            <font color=red>&nbsp;*</font>
                            (0:T+1�¼���, 1:T+2�¼���, ��������)
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="intvmonth" disabled="true"/>
                            (0:T+1�¼���, 1:T+2�¼���, ��������)
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            </table>
    </div>
    
        <div class="table_div" id="normalAcc">
			<table class="form_table">
             <tr>
             <td width="12%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbs" key="citystd2"/>:</div></td>
                <td width="38%" colspan="3" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="citystd" maxlength="16"/>
                            <font color=red>&nbsp;*</font>
                            (ʡ��˾����Ϊ:<font color="red"><c:out value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].procitystd}" /></font>)
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="citystd" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                
            </tr>
            <tr>
             <td width="12%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbs" key="countrystd2"/>:</div></td>
                <td width="38%" colspan="3" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="countrystd" maxlength="16"/>
                            <font color=red>&nbsp;*</font>
                            (ʡ��˾����Ϊ:<font color="red"><c:out value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].procountrystd}" /></font>)
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="countrystd" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
           	</tr>
           	</table>
    </div>
    <div class="table_div" id="saleAcc">
		<table class="form_table">
			<tr>
             	<td width="12%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbs" key="basicsalenum"/>:</div></td>
                <td width="38%" colspan="3" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="basicsalenum" maxlength="8"/>
                            <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="basicsalenum" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
           	</tr>
           	<tr>
             	<td width="12%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbs" key="topsalenum"/>:</div></td>
                <td width="38%" colspan="3" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="topsalenum" maxlength="8"/>
                            <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="topsalenum" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
           	</tr>
           	<tr>
             	<td width="12%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbs" key="citystdlow"/>:</div></td>
                <td width="38%" colspan="3" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="citystdlow" maxlength="18"/>
                            <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="citystdlow" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
           	</tr>
           	<tr>
             	<td width="12%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbs" key="countrystdlow"/>:</div></td>
                <td width="38%" colspan="3" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="countrystdlow" maxlength="18"/>
                            <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="countrystdlow" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
           	</tr>
           	<tr>
             	<td width="12%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbs" key="citystdmid"/>:</div></td>
                <td width="38%" colspan="3" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="citystdmid" maxlength="18"/>
                            <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="citystdmid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
           	</tr>
           	<tr>
             	<td width="12%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbs" key="countrystdmid"/>:</div></td>
                <td width="38%" colspan="3" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="countrystdmid" maxlength="18"/>
                            <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="countrystdmid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
           	</tr>
           	<tr>
             	<td width="12%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbs" key="citystdtop"/>:</div></td>
                <td width="38%" colspan="3" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="citystdtop" maxlength="18"/>
                            <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="citystdtop" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
           	</tr>
           	<tr>
             	<td width="12%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbs" key="countrystdtop"/>:</div></td>
                <td width="38%" colspan="3" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="countrystdtop" maxlength="18"/>
                            <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="countrystdtop" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
           	</tr>
           	<tr>
             	<td width="100%" align="left" colspan="4" class="form_table_left">
             		<div class="field-require">
             			ʡ��˾<font color="red">����</font>����Ϊ:<font color="red"><c:out value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].procitystdtop}" /></font>,ʡ��˾<font color="red">����</font>����Ϊ:<font color="red"><c:out value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].procountrystdtop}" /></font>;
             		</div>
             	</td>
           	</tr>
           	<tr>
             	<td width="100%" align="left" colspan="4" class="form_table_left">
             		<div class="field-require">
             			��ѡ����㷽ʽΪ"<font color="red">��ʵ�������������ۼ���</font>",��Ӧ�ı�׼Ӧ��<font color="blue">����</font>,ֻҪ����<font color="red">�������*����<=ʡ��˾����</font>����;<br>
             			ϵͳ����ʵ������(����ɹ��Ǽǵ��ɼ�ƽ̨),�������������Ǽ��Ļ�׼�����Ƚ�,��Ӧ���Ǽ������㹫ʽ����,��С��:<font color="blue">ʵ������*����׼1(��������С�ڻ�׼������׼)</font>;�����ڵ���,�������������Ǽ�����������Ƚ�,��С�ڵ���:<font color="blue">ʵ������*����׼2(��������������������׼)</font>;������:<font color="red">�������</font><font color="blue">*����׼3(���������������������׼)</font>
             		</div>
             	</td>
            </tr>
            <tr>
             	<td width="100%" align="left" colspan="4" class="form_table_left">
             		<div class="field-require">
             			��ѡ����㷽ʽΪ"<font color="red">�����������̶���׼����</font>",��Ӧ�ı�׼Ӧ��<font color="blue">���й�˾ʵ��ִ�еı�׼</font>,ֻҪ����<font color="red">����ʵ��ִ�б�׼<=ʡ��˾����</font>����;
             		</div>
             	</td>
           	</tr>
		</table>
	</div>
	
	<div class="table_div">
        <table class="form_table">
			 <tr>
                <td width="30%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbs" key="ttcitystd"/>:</div></td>
                <td align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="ttcitystd" maxlength="18"/>
                            <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="ttcitystd" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
            	<td width="30%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbs" key="ttcountrystd"/>:</div></td>
                <td align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="ttcountrystd" maxlength="18"/>
                            <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="ttcountrystd" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
            	<td align="left" colspan="2" class="form_table_left"><bean:message bundle="stdrewardbs" key="remark"/></td>
            </tr>
        </table>
    </div>
</FIELDSET>
    <div class="table_div">
        <table class="table_button_list">
             <tr>
                <td>
            	  <c:choose>
                    <c:when test="${edtState}"> 
                           <s:PurChk controlid="<%=ID_1%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/stdrewardbs.do?CMD=SAVEST&STR=content1')"/>
                  </s:PurChk>
                    </c:when>
              </c:choose>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                          onclick="doReturn('/cms/stdrewardbs.do?CMD=LIST')">
                          
                    <input type="button" id="btnExportexcel" name="btnExportexcel" class="button_6" onmouseover="buttonover(this);"
					        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
					        value="����ϸ������" onClick="doDetails()">
        
                </td>
                <c:choose>
                    <c:when test="${edtState}"> 
                           <td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
                    </c:when>
               	 <c:otherwise>
                       	   <td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
           		 </c:otherwise>
              </c:choose>
               
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>

