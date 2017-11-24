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
    <title><bean:message bundle="chzjtyrewfilenote" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            
            return checkval(window);
        }
        
        function reUploadReport(){
    		formItem.action="<%=contextPath%>/cms/zjty/zjtyReportFileUpload.do?CMD=REUPLOADREPORT";
       		formItem.submit();
       		formItem.rul.disabled=true;
    		
    	}
    	
    	function uploadReport(){
    		formItem.action="<%=contextPath%>/cms/zjty/zjtyReportFileUpload.do?CMD=UPLOADREPORT";
       		formItem.submit();
       		formItem.ul.disabled=true;
    	}
    	
    	function setHiVal(obj){
    		document.getElementsByName("fileAndPath")[0].value = obj.value;
    	}
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/zjty/zjtyReportFileUpload.do?CMD=SAVE" styleId="formItem" method="post" enctype="multipart/form-data">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/chzjtyrewfilenote/ChZjtyRewfilenoteForm']}"/>
	<c:set var="newOrUpdate" scope="request" value="${!empty form.newOrUpdate and (form.newOrUpdate eq 'NEW')}"/>
	
    <!--##################################��ӱ�������##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chzjtyrewfilenote" key="titleList"/>
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
				<td width="20%" align="right" class="form_table_right">
					ѡ���ϴ��ļ�:
				</td>
				<td width="80%" align="left" class="form_table_left">
					<html:file styleClass="form_input_files" property="theFile" onchange="setHiVal(this)"/>
					<html:hidden property="fileAndPath"/>
					<html:hidden property="seqid"/>
				</td>
			</tr>
			
			<tr>
	            <td width="20%" align="right" class="form_table_right"><bean:message bundle="chzjtyrewfilenote" key="filename"/>:</td>
	            <td width="80%" align="left" class="form_table_left">
	                <c:choose>
	                     <c:when test="${!newOrUpdate}">
	                        <html:text styleClass="form_input_1x" property="filename" disabled="true"/>
	                     </c:when>
	                     <c:otherwise>
	                         
	                    </c:otherwise>
	                </c:choose>
	            </td>
	        </tr>
			
			<tr>
	                <td width="20%" align="right" class="form_table_right"><bean:message bundle="chzjtyrewfilenote" key="rewardmonth"/>:</td>
	                <td width="80%" align="left" class="form_table_left">
	                    <c:choose>
	                        <c:when test="${!newOrUpdate}">
	                        	<html:hidden property="rewardmonth"/>
	                            <html:text styleClass="form_input_1x" property="rewardmonth" disabled="true"/>
	                        </c:when>
	                        <c:otherwise>
	                        	<html:text styleClass="form_input_1x" property="rewardmonth" onclick="this.value=selectDateYYYYMM(this.value);" ></html:text>
	                        </c:otherwise>
	                    </c:choose>
	                    <font color=red>*</font>
	                </td>
	            </tr>
	            <tr>
	                <td width="20%" align="right" class="form_table_right"><bean:message bundle="chzjtyrewfilenote" key="memo"/>:</td>
	                <td width="80%" align="left" class="form_table_left">
	                    <html:textarea cols="50" rows="4" property="memo">
		                </html:textarea>
	                </td>
	            </tr>
	            <tr>
	                <td width="20%" align="right" class="form_table_right">�ļ�����:</td>
	                <td width="80%" align="left" class="form_table_left">
	                    .rar��.zipѹ���ļ�
	                </td>
	            </tr>
	            <tr>
	                <td width="20%" align="right" class="form_table_right">˵��:</td>
	                <td width="80%" align="left" class="form_table_left">
	                  1 �Ƴ��·�Ϊ�����ͬ�Ƽ������·���ͬ������ϴ��ĵ������Ƽ��͹̶�����������·ݲ�ͬ����ȡ�Ƽ������·ݡ�<br>
   					  2 ÿ���Ƴ��·�ֻ���ϴ�һ��ѹ���ĵ��������Ҫ���£�����ɾ�����ϴ����ĵ���Ȼ���ϴ��µ��ĵ���<br>	                  
	                  3 ѹ���ĵ���С���ܳ���<%=request.getSession().getAttribute("sysparam82") %>M��
	                </td>
	            </tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" class="form_table_center">
		                	<c:choose>
		                        <c:when test="${!newOrUpdate}">
		                        	<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
					                      name="rul" onfocus="buttonover(this)" onblur="buttonout(this)"
					                      value="�����ϴ�" class="button_4"
					                      onClick="reUploadReport()"/>
			                        
			                    </c:when>
			                    <c:otherwise>
			                    	<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
					                     name="ul" onfocus="buttonover(this)" onblur="buttonout(this)"
					                     value="�ϴ�" class="button_4"
					                     onClick="uploadReport()"/>
			                    </c:otherwise>
		                	</c:choose>
		                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
		                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
		                           value="<bean:message bundle="public" key="button_return"/>" class="close"
		                           onclick="doReturn('/cms/zjty/zjtyReportFileUpload.do?CMD=LIST')">
		                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
