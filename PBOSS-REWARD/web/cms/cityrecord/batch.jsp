<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="7F1A1A" />
</jsp:include>

<html:html>
<head>
	<title>�й�˾�����ϸ�ϴ���������</title>
	<script language="JavaScript">
		function checkProcess(){
			var filename=formItem.filename.value;
			if(filename != null || filename != ""){
          		formItem.buttonProcess.disabled=true;
	      		window.location.href="<%= contextPath%>/cms/cityrecord/batch.do?filename="+filename+"&beanname=com.sunrise.boss.ui.cms.cityrecord.CityrecordTaskBean";                                                                                        
			}
		}
		function doReturnList(){
    		window.location.href="<%=contextPath%>/cms/cityrecord/list.jsp";
    	}	
    </script>
</head>
<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
	<html:form action="/cms/cityrecord/batch.do?CMD=UPLOAD" styleId="formItem" method="post" enctype="multipart/form-data">
		<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">		
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							�й�˾�����ϸ�ϴ���������
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
				<tr class="table_style_content_lyl">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							ѡ���ϴ��ļ�:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						<html:file styleClass="form_input_files" property="theFile"/>
					</td>
				</tr>
				<c:choose>
					<c:when test="${!empty requestScope.ITEM.inFile}">
						<tr class="table_style_content_lyl">
							<td align=right height=25>
								<bean:message bundle="upload" key="existfile" />
							</td>
							<td align=left>
								<a href='<%=contextPath%>/commons/batch/download.jsp?filename=
								<c:out value="${requestScope.ITEM.inFile}" />'>
								<c:out value="${requestScope.ITEM.fileName}" /> </a>
							</td>
						</tr>
					</c:when>
				</c:choose>
				<tr class="table_style_content_lyl">
					<td align=right height=25>
						<bean:message bundle="upload" key="filetype" />
					</td>
					<td align=left>
						<bean:message bundle="upload" key="typevalue" />
					</td>
				</tr>
				<tr class="table_style_content_lyl">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							�ļ���ʽ :
						</div>
					</td>
					<td align="left"><font color=red>��������|ҵ�����|�������|</font>�ֻ������IMEI��|<font color=red>�����·�|ҵ����ʱ��|ҵ������ҵ�������|Ӧ�����ϼ�|����Ӧ�����|��������|</font></td>
				</tr>
				<tr class="table_style_content_lyl">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							����˵��:
						</div>
					</td>
					<td align="left"><font color=red>TDZS1211002|0101020100002|1|</font>13687569920|<font color=red>201201|2011-11-01 08:04:35|100|10|10|7602011120601|</font></td>
				</tr>
				<tr class="table_style_content_lyl">
				
					<!--  <td width="20%" align="right" class="form_table_right">-->
					<td align="right">
						<div class="field-require">
							����˵��:
						</div>
					</td>
					<!--  <td width="75%" align="left" class="form_table_left">-->
					<td align="left">
�ļ���ʽ���ú�ɫ��ǵ��ֶ�Ϊ������,�ļ������ޱ�����.<br>
1��������ţ������COMSϵͳ���������Ϊ׼����ͨ����ı����ѯ·��:��������->���������Ϣ����ͳһ����ģʽ�̱���Ĳ�ѯ·������������->������Ӫ�����̹���<br>
2��ҵ����룺�����Чҵ����������������Ӧ��ϵ��ѯ·��: ������->�������ҵ�����->������Ч�Թ���->ҵ�������������ϵ��ѯ��<br>
3������������������ĳ���ǵڼ��ڳ�������Ǽ��������ĵ�һ�ڳ�������ֱ�ʾ������˵������:<br>
&nbsp;(<br>
&nbsp;&nbsp;   0:�׿��ź���.һ��<br>
&nbsp;&nbsp;  1:�׿��ź���.����<br>
&nbsp;&nbsp;   2:�׿��ź���.����<br>
&nbsp;&nbsp;   5:����ҵ����.һ��<br>
&nbsp;&nbsp;   6:����ҵ����.����<br>
&nbsp;&nbsp;   9:����ҵ����.һ��<br>
&nbsp;&nbsp;   10:����ҵ����.����<br>
&nbsp;&nbsp;   30:��Ȩ����.�������޽�(��)<br>
&nbsp;&nbsp;   60:��Ȩ����.���ڼ���<br>
&nbsp;&nbsp;   54:�Ǽ����.�ŵ겹�� <br>
&nbsp;&nbsp;   55:�Ǽ����.���ֽ���<br>
&nbsp;&nbsp;   7:�Ǽ����.�Ǽ����(��)<br>
 )<br>
4���ֻ������IMEI�ţ��Ƽ���ҵ����ն�����ҵ����������ҵ��ѡ������ó����ֻ�������ն�IMEI�ţ�������Ƽ����ļ����׿����룬����άϵ����ȫ��ͨ������<br>
 &nbsp;&nbsp; �룬������꽱�ļ����׿����룬�����ն˳���IMEI�ţ����Ǽ���������ֻ�����������ա�<br>
5�������·ݣ�������ǳ����˵����ڡ����磬2011��12��5�ճ��꣬������·�Ϊ201111��<br>
6��ҵ����ʱ�䣺�Ƽ���ҵ����������ҵ��ѡ��Ǽ������������д��2011-11-01 00:00:00�ȸ�ʽ��ʾ�·ݣ��缤�����Ӧ���׿�����ʱ�䣬���ѷ������<br>
 &nbsp;&nbsp; ���Ӧ�Ľɷ�ʱ�䣬��ʽΪYYYY-MM-DD HH:MM:SS��<br>
7��ҵ������ҵ�����������д������ҵ�����������ݣ����׻�ԪΪ��λ����ҵ���������صĳ�����ͱ�����д������ֵ100Ԫ���1.5Ԫ���ѷ������𣬻���<br>
 &nbsp;&nbsp; �ǻ�ó�ֵ����1.5%��Ϊ���ѷ�������<br>
8��Ӧ�����ϼƣ����ָ���˵��ܽ����������صĳ�𣬵�һ�ڡ�Ӧ�����ϼơ�ӦΪ�����ǰ�ĳ���ܶ����������Ӧ�����ϼơ�Ϊ0Ԫ����Բ�����صĳ�𣬡�Ӧ<br>
 &nbsp;&nbsp; �����ϼơ��롰����Ӧ�������ȣ��������˵����<br>
9������Ӧ����𣺱���������ϴ�����Ӧ֧��������ĳ��ʵ��֧��ʱ��������������㷢Ʊ�Ͻɡ��������̵�Ӱ�����ʱ����δ�۳�˰��<br>
10���������룺����������Ӧ��Ӫ���������嵽������ҵ�����������룬������Ӫ������ƽ̨�ϵ���������Ϊ׼������ע��Ӫ������ƽ̨������������ȫ��������������������<br>
 &nbsp;&nbsp; ǰĬ�ϵı�����00000����<br>
				<font color="red">��ʾ:ÿ�ν�����������</font>
				</td>
				</tr>
			</table>
		</div>
		<iframe
				src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.cityrecord.CityrecordTaskBean"
				frameborder="0" class="loadframe" id="loadframe" scrolling="no">
		</iframe>
        <div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
							
							<input type="submit" value="<bean:message bundle="upload" key="upload" />" class="button_4"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonUpload" NAME="buttonUpload"/>
							<input type="button" value="<bean:message bundle="upload" key="process"/>" class="button_4"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonProcess" NAME="buttonProcess" onClick="checkProcess()" />
								
							<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           		name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           		value="<bean:message bundle="public" key="button_return"/>" class="button_4"
                           		onclick="doReturnList()">
						</td>
					</tr>
				</table>
			</div>
	</html:form> 
	<br>
	</div>
</body>
</html:html>
