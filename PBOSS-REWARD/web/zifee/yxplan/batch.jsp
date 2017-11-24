<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="3C3C1ACC" />
</jsp:include>

<%
    String ID_1 = "3C3C1ACCBT1";
%>

<html:html>
<head>
    <title><bean:message bundle="yxplan" key="upload"/></title>

    <script language="JavaScript">
        function ev_checkval() {
            //addfield('compactno', '<bean:message bundle="yxplan" key="compactno"/>', 'c', false, 17);
            return checkval(window);
        }
        
		function doUpload(urlStr) {
          if (ev_checkval()) {
          	var cmd="";
          	var select=document.all("batchaction").value;
          	if(select=='0'){
          		cmd="CMD=BATCHADD";
          	}else if(select=='1' || select=='2'){
				cmd="CMD=BATCHUPDATE";    		
          	}
              enable();
              formItem.action = contextPath + urlStr+cmd;
             
              formItem.submit();
          }
          return false;
        }        
    </script>
</head>
<body onload="loadforiframe();">
<div class="table_container">
<html:form action="/zifee/yxplan.do?CMD=UPLOAD" styleId="formItem" method="post" enctype="multipart/form-data">
	<hidden property="cmdState"/>

	 <div class="table_div">
		 <table class="top_table">
				<tr>
					<td>
						<bean:message bundle="yxplan" key="upload"/>
					</td>
				</tr>
			</table>
		</div>	
		
		<div class="table_div">
	     <table width="100%" class="error_text">
       	   <s:Msg />
       </table>	
		</div>	
	
	<div class="table_div">
        <table class="form_table">
        	<tr>
			    <td align=left colspan=4>&nbsp;&nbsp;<bean:message bundle="public" key="msgRequired"/></td>
		    </tr>
            
            <tr>
                <td  align="right" width="14%"><div class="field-require"><bean:message bundle="yxplan" key="inputfile"/>:</div></td>
                <td colspan="3" align="left" class="form_table_left">
                    <html:file property="inputFile" styleClass="form_input_files"></html:file>
                </td>
            </tr>
            <tr>
                <td  align="right" width="14%"><div class="field-require"><bean:message bundle="yxplan" key="inputresult"/>:</div></td>
                <td colspan="3" align="left" class="form_table_left">
                	  <html:textarea property="reInfo" readonly="true" styleClass="form_textarea_on"></html:textarea>
                </td>
            </tr>
            <tr>
                <td  align="right" width="14%"><div class="field-require"><bean:message bundle="yxplan" key="batchOperate"/>:</div></td>
                <td colspan="3" align="left" class="form_table_left">
                	<html:select  property="batchaction">
						<html:option value="0"><bean:message bundle="yxplan" key="batchAdd"/></html:option>
						<html:option value="1"><bean:message bundle="yxplan" key="batchUpdate"/></html:option>
						<html:option value="2">�Զ������</html:option>
					</html:select>
                </td>
            </tr>    
  
            <tr>
                <td  align="right" width="14%"><div class="field-require">�ļ���ʽ(��������/����):</div></td>
                <td colspan="3" align="left" class="form_table_left">
                       <p><font color=red>Ӫ��������ʶ</font>|<font color=red>Ӫ����������</font>|ȫʡ��ʶ|<font color=red>��������</font>|<font color=red>ͣ������</font>|<font color=red>�����ʶ</font>|</p>
                       <p>�Ƿ���Ҫ�����ײ�|������|�Ƿ�����ԤԼ|�����ô���|��С�Ż�������|�Ż�����ƫ����|����ʱ�䵥Ԫ|</p>
                       <p>��Чʱ�����|Ӫ�����������ʶ|�Ƿ񱸷�|�Ƿ��ӡ������|�Ƿ�����Ż�|�Ƿ�Ӫҵ���Ż�|</p>
                       <p>�Ƿ������Ա�Ż�|��Դ|Ӫ�����|Ӫ���������|<font color=red>�ϴ���ѷ������</font>|�Żݷ�Χ|<font color='red'>�ײ�����</font>|</p>
                       <p>�½�۷����ȼ�|<font color=red>�̶��������ʶ</font>|���ⷽ����־|<font color=red>�Ƿ��û�״̬���</font>|�ɰ����û�״̬|�ʷ�˵��|˵��|<font color=red>�Ż�����</font>|�Żݻ������|�ײ���Ч����</p>
                       <p>(ע����ɫ����Ϊ����¼���ֶ�)</p>
                       <p>������ⷽ����־��ɰ����û�״̬֮����","�Ŵ�����,��: 0,1,2</p>
                </td>
            </tr>    
             <tr>
                <td  align="right" width="14%"><div class="field-require">�ļ���ʽ(�Զ������):</div></td>
                <td colspan="3" align="left" class="form_table_left">
                       <p>ȫ���ļ�ͷ:<font color=red>Ӫ��������ʶ</font>|Ӫ����������|ȫʡ��ʶ|��������|ͣ������|�����ʶ|</p>
                       <p>�Ƿ���Ҫ�����ײ�|������|�Ƿ�����ԤԼ|�����ô���|��С�Ż�������|�Ż�����ƫ����|����ʱ�䵥Ԫ|</p>
                       <p>��Чʱ�����|Ӫ�����������ʶ|�Ƿ񱸷�|�Ƿ��ӡ������|�Ƿ�����Ż�|�Ƿ�Ӫҵ���Ż�|</p>
                       <p>�Ƿ������Ա�Ż�|��Դ|Ӫ�����|Ӫ���������|�ϴ���ѷ������|�Żݷ�Χ|�ײ�����|</p>
                       <p>�½�۷����ȼ�|�̶��������ʶ|���ⷽ����־|�Ƿ��û�״̬���|�ɰ����û�״̬|�ʷ�˵��|˵��|�Ż�����|�Żݻ������|�ײ���Ч����</p>
                       <p>(ע��1����һ�ж���Ҫ�޸ĵ��ֶ�(�ļ�ͷ),<font color=red>Ӫ��������ʶ</font>Ϊ�����ֶ�,�����ֶ�Ϊ��ѡ,</p>
                       <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���ֶ��������������涨���(ȫ���ļ�ͷ)����һ��,��"|"�ָ�,�磺<font color=red>Ӫ��������ʶ</font>|�Ƿ񱸷�|�ײ�����</p>
                       <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2���ڶ��п�ʼΪ�ļ�ͷ�ж�����ֶ�ֵ,��"|"�ָ�,�磺<font color=red>10091000000032</font>|0|1</p>
                       <p>������ⷽ����־��ɰ����û�״̬֮����","�Ŵ�����,��: 0,1,2</p>
                </td>
            </tr>   
            <tr>
                <td  align="right" width="14%"><div class="field-require">����˵��:</div></td>
                <td colspan="3" align="left" class="form_table_left">
                       <p>���ⷽ����־��0,���ڻ��Ż�,1,ָ�������ѡ,2,ָ����ɫ,4,ָ������,6,ָ���ͻ�Ⱥ,7,ָ�����벻��ѡ</p>
                       <p>8,ָ�������־�����ѡ,9,ָ�������־���벻��ѡ</p>
                       <p>�ɰ����û�״̬��US20,����,US22,Ԥ����,US23,ǿ������,US24,Ƿ������,US26,����,US28,δ����,US30,ͣ��</p>
                       <p>�Ƿ�����ԤԼ��0,��;1,ȫ��;2,˳��;3,ָ��ʱ����Ч;</p>
                       <p>�Ż����ԣ�1��VIP���ͣ�2���������ͣ�3��Ӫ�����ͣ�4������ʹ�ã�5��������                       </p>
                       <p><font color='red'>���ϲ��������ο�,�����µ�Ϊ׼</font></p>
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
		                 			name="btnHelp" onfocus="buttonover(this)" onblur="buttonout(this)"
		                 			value="<bean:message bundle="yxplan" key="batch"/>" class="button_4"
		                 			onclick="doUpload('/zifee/yxplan.do?')">
	         </s:PurChk>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/zifee/yxplan.do?CMD=LIST')">
					</td>
				</tr>
			</table>
		</div>

</html:form>
</div>
</body>
</html:html>
