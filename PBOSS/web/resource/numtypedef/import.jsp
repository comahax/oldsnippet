<%@ page language="java" contentType="text/html;charset=GBK" %>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title>规则表达式批量导入</title>
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
			<span class="table_toparea">规则表达式批量导入</span>
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
                <td align="right">类型ID:&nbsp</td>
                <td id="typeidTD" align="left">
                    ${param.typeid}
					
                </td>
            </tr>
             <tr >
                <td align="right">类型编码:&nbsp</td>
                <td id="typecodeTD" align="left">
					${param.typecode}
                </td>
            </tr>
             <tr >
                <td align="right">类型名称:&nbsp</td>
                <td id="typenameTD" align="left">
					${param.typename}
                </td>
            </tr>
            <tr >
                <td align="right">请选择上传文件:&nbsp</td>
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
						规则表达式
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
                <td align="right">补充说明:&nbsp</td>
                <td align="left">
                	支持固定公式和自定义尾号两种方式<br>
                	1.连号,未尾数字相同,如13800166666(五连*AAAAA)、13800136666（四连号*AAAA）,支持六连、五连、四连、三连、两连<br>
                	2.两段连号,末尾数字中有两段相同，如1388886666（四连*AAAABBBB）、13800136688（二连*AABB）,支持四连、三连、两连<br>
                	3.三段连号,末尾数字中有三段相同，如13777888666（三连*AAABBBCCC）、13820556688（二连*AABBCC）,支持三连、两连<br>
                	4.四段连号,末尾数字中有四段相同，如13800556688（二连*AABBCCDD）,支持两连<br>
                	5.顺序,末尾数字中有多位递增，如13800112345（五位*ABCDE）、13800138123（三位*ABC）,支持五位、四位、三位<br>
                	6.倒序,末尾数字中有多位递减，如13800154321（五位*EDCBA）、13800138321（三位*CBA）,支持五位、四位、三位<br>
                	7.双顺,末尾数字中有两段重复，如13812681268（四条*abcdabcd）、13800136868（两条*abab）,支持四条、三条、两条<br>
                	8.三顺,末尾数字中有三段重复，如13768768768（三条*abcabcabc）、13800686868（两条*ababab）,支持三条、两条<br>
                	9.四顺,末尾数字中有四段重复，如13868686868（两条*abababab）,支持两条<br>
                	10.自定义,星号加数字组合，数字最多9位，如*168168、*1314等。
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
