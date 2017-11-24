<%@ page language="java" contentType="text/html;charset=GBK" %>
<%@ include file="/inc/listhead.inc" %>
<%
	String ID_ADD = "FX_ORDERMGR_RESDRAW";
%>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript" type="text/JavaScript">
	    function checkProcess(){
			var filename = formItem.path.value;
			if(filename != null || filename != ""){
	    		formItem.btnDeal.disabled=true;
	    		document.getElementById("importUrl").href="<%=contextPath%>/sales/orderresdet_import.do?filename="+filename+"&beanname=com.gmcc.pboss.web.sales.orderresdet.OrderresdetTaskBean";
	    		document.getElementById("importUrl").click();
				
			}
		}
		function changeType(){
				
		 var resextratype=document.getElementById("orderresdet_upload_resextratype").value;
			if(resextratype=="CYCSECT"){//循环号段时
	        		$("#cycsectNumTR").show();
	        		$("#fixsectNumTR").hide();	        		
	        	}else if(resextratype=="FIXSECT"){//指定号段时
	        	 	$("#fixsectNumTR").show();
	        		$("#cycsectNumTR").hide();
	        		
	        	}else{
	        		//$(":select[name='resextratype']").val("RANDOM");
	        		$("#fixsectNumTR").hide();
	        		$("#cycsectNumTR").hide();
	        		
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
        	//var resextratype='<s:property value="formMap.resextratype" />';
        	 var resextratype=document.getElementById("orderresdet_upload_resextratype").value;
	        	if(resextratype=="CYCSECT"){//循环号段时
	        		$("#cycsectNumTR").show();
	        		$("#fixsectNumTR").hide();
	        	}else if(resextratype=="FIXSECT"){//指定号段时
	        		$("#fixsectNumTR").show();
	        		$("#cycsectNumTR").hide();
	        	}else if(resextratype=="RANDOM"){
	        		//$(":select[name='resextratype']").val("RANDOM");
	        		$("#fixsectNumTR").hide();
	        		$("#cycsectNumTR").hide();
	        	}
	        $(":select[name='resextratype'] option").each(function(){
				if($(this).val() =='' ){
					$(this).remove();
				}
			});
  	 });
  	 
  	 function ev_check(){
  	     var selector=document.getElementById("orderresdet_upload_resextratype");
  	     
  	     var hiddentype=document.getElementById("resextratypehidden");
  	     hiddentype.value=selector.value;
  	     
  	      var selector2=document.getElementById("orderresdet_upload_resextratype").disabled;
  	     var hiddenflagvalue;
  	     if(selector2==false){
  	        hiddenflagvalue="1";
  	     }else{
  	        hiddenflagvalue="2";
  	     }
  	     
  	       $.ajax({
            url: '/sales/orderresdet_setTokenflagValue.do',   //接收页面
            type: 'post',      //POST方式发送数据
            async: false,      //ajax同步
            data: {"tokenflag":hiddenflagvalue,"orderresdetparamvalue":selector.value},
	            success: function(data) {
			    }
            }); 
  	     
  	     
  	     
  	    
  	     //var hiddenflag=document.getElementById("tokenflag");
  	    // hiddenflag.value=hiddenflagvalue;
  	     return true;
  	  
  	 }
  	 
  	 
    </script>
    <base target="_self">
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="/sales/orderresdet_upload.do" cssStyle="formItem" key="formItem" 
			method="post" theme="simple" enctype ="multipart/form-data" onsubmit="return ev_check();">
    <a id="importUrl" href="#"></a>
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea">订单管理 </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h">订单资源批量抽取</span>
			</s:i18n>
		</div>
	</div>

<input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.sales.orderresdet.OrderresdetCheck">
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
         	 <tr>
                <td align="right">资源抽取方式:&nbsp</td>
                <td align="left">
                <input type="hidden" id="resextratypehidden" name="resextratype"/>
                 <input type="hidden" id="tokenflag" name="tokenflag" value="${sessionScope.tokenflag}"/>
               <j:purChk permid="<%=ID_ADD%>"> 
						<j:selector definition="$FX_RESEXTRATYPE" name="resextratype" value="${orderresdetparamvalue}" onchange="changeType()"/>
					 	<font color=red>*</font>
				</j:purChk>
                </td>
            </tr>
            <tr id="fixsectNumTR" style="display: none">
                <td align="right" >指点号段:&nbsp;</td>
                <td align="left">
					  <input type="text" name="fixsectNum" value='<s:property value="formMap.fixsectNum"/>' >
					  <font color=red>*</font>请填写三位号段，如：138
                </td>
            </tr>
             <tr id="cycsectNumTR" style="display: none">
                <td align="right" >循环号段:&nbsp;</td>
                <td align="left">
					  <input type="text" name="cycsectNum" value='<s:property value="formMap.cycsectNum"/>' >
					  <font color=red>*</font>多个号段用逗号分隔，如：135，136，137
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
						订单编号
					</font>
                </td>
            </tr>
            <tr >
                <td align="right"><s:text name="file_example"/>:&nbsp</td>
                <td align="left">
					<font color=red>
						GZ2009102000001001
					</font>
                </td>
            </tr>
             <tr >
                <td align="right">补充说明:&nbsp</td>
                <td align="left">
					文件格式中用红色标记的字段为必填项，文件内容无标题行<br>
					订单编号：最大长度为18位的字符串
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
</div>
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.sales.orderresdet.OrderresdetTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>

</body>
</html>
<script type="text/javascript">
<!--

  	     var selector=document.getElementById("orderresdet_upload_resextratype");
  	     var bo = selector.disabled;
  	     if(bo == false){
  	     var tokenflagvalue=document.getElementById("tokenflag").value;
	  	     if(tokenflagvalue == ""){
	  	      var selectoptions = selector.options;
		  	     for(var i=0;i<selectoptions.length;i++){
			  	     if(selectoptions[i].value == "RANDOM"){
			  	       selectoptions[i].selected=true;
			  	     }
		  	     }
	  	     }
	  	     
  	     }


 function showDelButton(){
 var filename = formItem.path.value;

     if(filename == null || filename == '' ){
    	 $("#btnDeal").attr('disabled',true);
     }
     else{
	      $("#btnDeal").attr('disabled',false);
	      
      }
  }
  
//-->
</script>
