<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc" %>
<html>
<head>
    <title>��������</title>
    <script language="JavaScript" type="text/JavaScript">
	    function checkProcess(){
			var filename = formItem.path.value;
			if(filename != null || filename != ""){
	    		formItem.buttonProcess.disabled=true;
				window.location.href="<%=contextPath%>/sales/actrepairbatch.do?filename="+filename+"&beanname=com.gmcc.pboss.web.sales.actrepair.ActrepairTaskBean";
			}
		}

    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<s:form action="/sales/actrepairupload.do" method="POST" key="formItem"	cssStyle="formItem"	enctype="multipart/form-data" theme="simple">
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			</s:i18n>
			<span class="table_toparea_h">��������</span>
		</div>
	</div>
    <input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.sales.actrepair.ActrepairCheck">
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
            <tr class="table_normal_head">
            	<td align=right>
            		ѡ���ļ�:
            	</td>
            	<td align=left>
            		<s:file name="doc" label="File" /> 
            	</td>
             </tr>
             <tr class="table_normal_head">
				<td align=right height=25>
					�ļ�����:
				</td>
				<td align="left">
						.txt�ı��ļ� (�ı��ﲻҪ�����кͶ���Ŀո�)
				</td>
				</tr>
            <tr class="table_normal_head">
            	<td align="right">�ļ�:</td>
            	<td align="left">
            	<a href='<%=contextPath%>/common/download.jsp?filename=<s:property value="filepath" />'> 
            	<s:property value="fileName" /> 
            	</a>
            	</td>
            </tr>
			<tr class="table_normal_head">
				<td align=right height=25>
					�ļ���ʽ:
				</td>
				<td align=left>
					<font color="red">����|��������|��¼ԭ��|</font>
				</td>
			</tr>
			<tr class="table_normal_head">
				<td align=right height=25>
					����˵��:
				</td>
				<td align=left>
					<font color=red>13760787707|2009-05-06|���벹¼|</font>
				</td>
			</tr>
			<tr class="table_normal_head">
				<td align=right height=25>
					����˵��: 
				</td>
				<td align=left>
					&nbsp;���ڸ�ʽΪ:  &nbsp;yyyy-MM-dd
				</td>
			</tr>
        </table>
    </div>
    </aa:zone>
    <div class="table_div">
		<table class="table_normal">
			<tr> 
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
	                    <td align=right>
	                        <input type="submit" id="btnBatch" name="btnBatch" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="�ϴ�">
	                        <input type="button" id="buttonProcess" name="buttonProcess" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" onclick="checkProcess()"
	                            value="����"> 
	                         <input type="button" id="buttonProcess" name="buttonProcess" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" onclick="doReturn('/sales/actrepair_list.do')"
	                            value="����">             
	                    </td>
	                    </tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	
</s:form>
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.sales.actrepair.ActrepairTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>
</body>
</html>