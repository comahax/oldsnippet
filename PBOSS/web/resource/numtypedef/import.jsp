<%@ page language="java" contentType="text/html;charset=GBK" %>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title>������ʽ��������</title>
    <script language="JavaScript" type="text/JavaScript">
	    function checkProcess(){
			var filename = formItem.path.value;
			if(filename != null || filename != ""){
				 $("#btnDeal").attr('disabled',true);
	    		formItem.btnDeal.disabled=true;
	    		document.getElementById("importUrl").href="<%=contextPath%>/resource/numtypedef_import.do?filename="+filename+"&beanname=com.gmcc.pboss.web.resource.numtypedef.NumtypedefTaskBean";
	    		document.getElementById("importUrl").click();
				
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
        var typeid='${param.typeid}';
        if(typeid==""){
        	$(":hidden[name='typeid']").val('${parameterMap.typeid}');
        	$(":hidden[name='typecode']").val('${parameterMap.typecode}');
        	$(":hidden[name='typename']").val('${parameterMap.typename}');
        	$("#typeidTD").text('${parameterMap.typeid}');
        	$("#typecodeTD").text('${parameterMap.typecode}');
        	$("#typenameTD").text('${parameterMap.typename}');
        }
   });
    </script>
    <base target="_self">
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<s:form action="/resource/numtypedef_upload.do" cssStyle="formItem" key="formItem" 
			method="post" theme="simple" enctype ="multipart/form-data" >
    <a id="importUrl" href="#"></a>
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea">������ʽ��������</span>
			</s:i18n>
		</div>
	</div>

<input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="typeid" value='${param.typeid}'>
    <input type="hidden" name="typecode" value='${param.typecode}'>
    <input type="hidden" name="typename" value='${param.typename}'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.resource.numtypedef.NumtypedefCheck">
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
                <td align="right">����ID:&nbsp</td>
                <td id="typeidTD" align="left">
                    ${param.typeid}
					
                </td>
            </tr>
             <tr >
                <td align="right">���ͱ���:&nbsp</td>
                <td id="typecodeTD" align="left">
					${param.typecode}
                </td>
            </tr>
             <tr >
                <td align="right">��������:&nbsp</td>
                <td id="typenameTD" align="left">
					${param.typename}
                </td>
            </tr>
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
                <td align="right"><s:text name="file_type"/>:&nbsp</td>
                <td align="left">
					<s:text name="file_type_txt_describe"/>
                </td>
            </tr>
            <tr >
                <td align="right"><s:text name="file_format"/>:&nbsp</td>
                <td align="left">
                	 <font color=red>
						������ʽ
					</font>
                </td>
            </tr>
            <tr >
                <td align="right"><s:text name="file_example"/>:&nbsp</td>
                <td align="left">
					<font color=red>
						*AAAA
					</font>
                </td>
            </tr>
             <tr >
                <td align="right">����˵��:&nbsp</td>
                <td align="left">
                	֧�̶ֹ���ʽ���Զ���β�����ַ�ʽ<br>
                	1.����,δβ������ͬ,��13800166666(����*AAAAA)��13800136666��������*AAAA��,֧������������������������������<br>
                	2.��������,ĩβ��������������ͬ����1388886666������*AAAABBBB����13800136688������*AABB��,֧������������������<br>
                	3.��������,ĩβ��������������ͬ����13777888666������*AAABBBCCC����13820556688������*AABBCC��,֧������������<br>
                	4.�Ķ�����,ĩβ���������Ķ���ͬ����13800556688������*AABBCCDD��,֧������<br>
                	5.˳��,ĩβ�������ж�λ��������13800112345����λ*ABCDE����13800138123����λ*ABC��,֧����λ����λ����λ<br>
                	6.����,ĩβ�������ж�λ�ݼ�����13800154321����λ*EDCBA����13800138321����λ*CBA��,֧����λ����λ����λ<br>
                	7.˫˳,ĩβ�������������ظ�����13812681268������*abcdabcd����13800136868������*abab��,֧������������������<br>
                	8.��˳,ĩβ�������������ظ�����13768768768������*abcabcabc����13800686868������*ababab��,֧������������<br>
                	9.��˳,ĩβ���������Ķ��ظ�����13868686868������*abababab��,֧������<br>
                	10.�Զ���,�Ǻż�������ϣ��������9λ����*168168��*1314�ȡ�
                </td>
            </tr>
        </table>
        </s:i18n>
    </div>
</aa:zone>
    <div class="table_div">
        <table class="table_normal">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                    <input type="submit" id="btnUpload" name="btnUpload" class="button_New" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_upload"/>" />
                    
                   
                    <input type="button"  id="btnDeal" name="btnDeal" class="button_New" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_deal"/>" onclick="checkProcess();"/>
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
    
</s:form>
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.resource.numtypedef.NumtypedefTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>

</body>
</html>
