<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>

<html>
<head>
	<title>�ļ��ϴ�</title>
	<script language="JavaScript" type="text/JavaScript">
		function checkProcess(){
			var filename=formItem.path.value;
			if(filename != null || filename != ""){
          		formItem.buttonProcess.disabled=true;
	      		window.location.href="<%= contextPath%>/channel/checkedapply_import.do?filename="+filename+"&beanname=com.gmcc.pboss.web.channel.checkedapply.CheckedapplyTaskBean";                                                                                        
			}
		}
		function doReturn() {
	     	formItem.action = "<%=contextPath%>/channel/checkedapply_retrunfrombatch.do"; 
		    formItem.submit();
		}
		
		function upload(){
			formItem.action="<%=contextPath%>/channel/checkedapply_upload.do";
			var fileName = document.getElementById('doc').value;
			if(fileName == ''){ 
				 var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>��ѡ���ϴ����ļ�</span> ';
				errorMessageShow(alertstr); 
				return false;
			}
			return true;
		}
    </script>
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="/channel/checkedapply_upload.do" cssStyle="formItem" key="formItem" method="post" theme="simple" enctype ="multipart/form-data" onSubmit="return upload();" >
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			</s:i18n>
			<span class="table_toparea_h">�ļ��ϴ�</span>
		</div>
	</div>
	<aa:zone name="hiddenZone">
		<s:hidden name="param._orderby" />
		<s:hidden name="param._desc" />
		<s:hidden name="param._pageno" />
		<s:hidden name="param._pagesize" />
		<s:hidden name="param.queryAll" />
		<input type="hidden" name="_rowcount"
			value="<s:property value="dp.rowCount" />" /> 
		<input type="hidden" name="applywayid"/>	
		<input type="hidden" name="param.applyeno" value="<s:property value="param.applyeno" />"/>
		<input type="hidden" name="param.applytype" value="<s:property value="param.applytype" />"/>
		<input type="hidden" name="param.oprcode2" value="<s:property value="param.oprcode2" />"/>
		<input type="hidden" name="param.aptime" value="<s:date name="param.aptime" format="yyyy-MM-dd HH:mm:ss" />"/>
		<input type="hidden" name="param.mobileno" value="<s:property value="param.mobileno" />"/>
		<input type="hidden" name="param.memo" value="<s:property value="param.memo" />"/>
		<input type="hidden" name="param.appath" value="<s:property value="param.appath" />"/>
		<input type="hidden" name="param.pptpath" value="<s:property value="param.pptpath" />"/>
	</aa:zone>
	<input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.channel.checkedapply.CheckedapplyCheck">
    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>
    <aa:zone name="listZone">
    <div class="table_div">
        <table class="table_normal">
            <tr>
            	<td align="right">��ѡ���ϴ����ļ�: 	</td>
            	<td align="left"><s:file name="doc" label="File" /></td>
            </tr>
            <tr>
				<td align="right" height=25>�ļ�����:</td>
				<td align="left">.txt�ı��ļ� (�ı��ﲻҪ�����кͶ���Ŀո�)</td>
			</tr>
            <tr>
            	<td align="right">�ļ�:</td>
            	<td align="left">
            	<a href='<%=contextPath%>/common/download.jsp?filename=<s:property value="filepath" />'> 
            	<s:property value="fileName" /> 
            	</a>
            	</td>
            </tr>
			<tr>
				<td align="right" height=25>�ļ���ʽ:</td>
				<td align="left"><font color=red>��������</font>|<font color=red>���˷�ʽ</font>|<font color=red>��������</font>|��������(�˳��������ӻ��˳�)|</td>
			</tr>
			<tr>
				<td align="right" height=25>����˵��:</td>
				<td align="left"> 
				<font color="red">JMJF88888</font>|<font color="red">0</font>|<font color="red">1</font>|1|
				</td>
			</tr>
			<tr>
				<td align="right" height=25>
					����˵�� 
				</td>
				<td align="left">
					 ���˷�ʽ��0-���㿼�ˣ�1-ͳһ����ģʽ����<br/>
					 �������ͣ�0-׼�����룬1-�˳�����<br/>
					 �������ݣ�0-�˳�����1-�ӻ��˳�<br/>
					 ע����������Ϊ���˳����롿ʱ�����������ݡ�����
				</td>
			</tr>
			<tr>
					<td align=right height=25>
						��дָ��:
					</td>
					<td align=left>
						<a href="<%=contextPath%>/channel/common/importguide.htm">��дָ��</a></td>
            </tr>
            <tr>
                  <td align=right height=25>Excel��дģ�壺</td>
                  <td> <a href="<%=contextPath%>/channel/checkedapply/batchimportmodel.xls"/>��Ȩ������������ģ��.xls</a>(ע����д���뽫����ת��Ϊtxt��ʽ��ȥ�������У����ϴ�����)
                  </td>
            </tr>
			 
        </table>
    </div>
    </aa:zone>
    <div class="table_div">
		<table class="table_button_list">
			<tr> 
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
	                    <td align=right>
	                    <s:i18n name="public">
	                        <input type="submit" id="btnBatch" name="btnBatch" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="<s:text name="button_upload"/>">
	                            
	                        <input type="button" id="buttonProcess" name="buttonProcess" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" onclick="checkProcess()"
	                            value="����">
	                            
	                        <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   		onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           		value="<s:text name="button_return"/>" onclick="doReturn()">
                        </s:i18n>
	                    </td>
	                    </tr>
					</table>
				</td>
			</tr>
		</table>
	</div>

</s:form>
</div>
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.channel.checkedapply.CheckedapplyTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>
</body>
</html>