<%@ page language="java" contentType="text/html;charset=GBK" %>
<%@ include file="/inc/contenthead.inc"%>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript" type="text/JavaScript">
	    function checkProcess(){
			var filename = formItem.path.value;
			if(filename != null || filename != ""){
	    		formItem.btnDeal.disabled=true;
	    		document.getElementById("importUrl").href="<%=contextPath%>/sales/disformintervaltime_import.do?filename="+filename+"&beanname=com.gmcc.pboss.web.sales.disformintervaltime.DisformintervaltimeImportTaskBean";
	    		document.getElementById("importUrl").click();
				
			}
		}
		  $(document).ready(function(){ 
		        var filename ="<s:property value="fileName" />";// formItem.path.value;
		
		     if(filename == null || filename == '' ){
		    	 $("#btnDeal").attr('disabled',true);
		     }
		     else{
			      $("#btnDeal").attr('disabled',false);
			      
		      }
  			 });
    </script>
    <base target="_self">
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="/sales/disformintervaltime_upload.do" cssStyle="formItem" key="formItem" 
			method="post" theme="simple" enctype ="multipart/form-data" >
    <a id="importUrl" href="#"></a>
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea">���͵�����</span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea">���͵�����ʱ������</span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h">�����ϴ�</span>
			</s:i18n>
		</div>
	</div>

<input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.sales.disformintervaltime.DisformintervaltimeImportCheck">
    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>
	
	<aa:zone name="listZone">
    <div class="table_div">
    <s:i18n name="public">
         <table class="table_normal">
            <tr >
                <td align="right">ѡ���ϴ��ļ�:&nbsp</td>
                <td align="left">
					<s:file name="doc" label="File"/>
                </td>
            </tr>
            <tr >
                <td align="right"><s:text name="file_file"/>:&nbsp</td>
                <td align="left">
					<a href='<%=contextPath%>/common/download.jsp?filename=<s:property value="filepath" />'> 
					<s:property value="fileName" /> 
            	</a>
                </td>
            </tr>
            <tr >
                <td align="right"><s:text name="file_type"/>:&nbsp</td>
                <td align="left">
					<s:text name="file_type_txt_describe"/>
                </td>
            </tr>
            <tr >
                <td align="right"><s:text name="file_format"/>:&nbsp</td>
                <td align="left">
                	 <font color=red>
						�ֹ�˾|΢����|�Ǽ�|����ʱ��|
					</font>
                </td>
            </tr>
            <tr >
                <td align="right"><s:text name="file_example"/>:&nbsp</td>
                <td align="left">
					<font color=red>
						A01|A01001|3|100|
					</font>
                </td>
            </tr>
             <tr >
                <td align="right">����˵��:&nbsp</td>
                <td align="left">
					�ļ���ʽ���ú�ɫ��ǵ��ֶ�Ϊ������ļ������ޱ����С�<br/>
					�ֹ�˾�������������ķֹ�˾����<br/>
					΢���򣺷ֹ�˾��Ͻ��΢�������<br/>
				          �Ǽ���0-δ���Ǽ� 1-һ�Ǽ� 2-���Ǽ� 3-���Ǽ� 4-���Ǽ� 5-���Ǽ� 6-���Ǽ�<br/>
				          ����ʱ�ޣ���λ����<br/>				    
					<font color=red>
						��ʾ����¼������ʱ���������� ����ʱ���и��С�
					</font>
                </td>
            </tr>
        </table>
        </s:i18n>
    </div>
</aa:zone>
    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                    <input type="submit" id="btnUpload" name="btnUpload" class="button_2" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_upload"/>" />                    
                   
                    <input type="button"  id="btnDeal" name="btnDeal" class="button_2" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_deal"/>" onclick="checkProcess();"/>
                           
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/sales/disformintervaltime_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.sales.disformintervaltime.DisformintervaltimeImportTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>

</body>
</html>