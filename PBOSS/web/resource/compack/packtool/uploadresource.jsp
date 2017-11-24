<%@ page language="java" contentType="text/html;charset=GBK" %>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript" type="text/JavaScript">
     function ev_checkval() {
            addfield('paramMap.comcategory', '��Ʒ����', 'c', false, 18);
			
            return checkval(window);
        }
	    function checkProcess(){
			var filename = formItem.filepath.value;
			if(filename != null || filename != ""){
	    		formItem.btnDeal.disabled=true;
	    		formItem.action="/resource/compack_packToolConfirm.do";
	    		formItem.submit();

				
			}
		}
		$(document).ready(function(){ 
      		 var filename ="<s:property value="fileName" />";

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
<s:form action="/resource/compack_packToolUpload.do" cssStyle="formItem" key="formItem" 
			method="post" theme="simple" enctype ="multipart/form-data"  onsubmit="return ev_checkval();">
			
	<s:hidden name="filepath"/>
    <a id="importUrl" href="#"></a>
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<span class="table_toparea_h">�����ϴ�</span>
			
		</div>
	</div>

    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.resource.compack.CompackToolCheck">
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
                <td align="right">��ѡ���ϴ��ļ�:&nbsp</td>
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
                <td align="right">��Ʒ����:&nbsp</td>
                <td align="left">
					
					<j:selector definition="$IM_FXCOMCATEGORY" name="paramMap.comcategory" condition="_snki_dictid:CZ" mode="picker"/>
					<font color=red>*</font>
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
						����|</font>����|
                </td>
            </tr>
            <tr >
                <td align="right"><s:text name="file_example"/>:&nbsp</td>
                <td align="left">
					<font color=red>
						13800138000|</font>123-2-1|
                </td>
            </tr>
             <tr >
                <td align="right">����˵��:&nbsp</td>
                <td align="left">
					�ļ���ʽ���ú�ɫ��ǵ��ֶ�Ϊ������ļ������ޱ�����<br>
					���룺���׿����룬�������ͣ�����11λ
					����:�����-�к�-���ţ���š��кš������ú�ܼ��
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
                           value="��һ��" onclick="checkProcess();"/>
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>


</body>
</html>
