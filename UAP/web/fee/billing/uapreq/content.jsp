<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/contenthead.inc" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<base target="_self">
	<title><s:text name="title"/></title>
	<script language="JavaScript">
        function ev_checkval() {
           			
			addfield('form.req_type', '<s:text name="req_type" />', 'c', false, 8);
			addfield('form.param', '<s:text name="param"/>', 'c', false, 200);
	        addfield('form.remark', '<s:text name="remark"/>', 'c', false, 1000);
	       
	        if(document.getElementById("fileparam").checked) {
                  addfield('filename', '<s:text name="filename"/>', 'c', false, 1000);      
            }    
	        return checkval(window);
                     
        }
        
        function showbtnupload(){
            
			var url = "";
			if(document.getElementById("form.req_type").value=="1001"
			   || document.getElementById("form.req_type").value=="1002"
			   || document.getElementById("form.req_type").value=="1004"){
			    url = "<%=contextPath%>/fee/billing/uapreq_uploadNumber.do?target=${requestScope.target}";
			}
			if(document.getElementById("form.req_type").value=="1003"){
				url = "<%=contextPath%>/fee/billing/uapreq_uploadProd.do?target=${requestScope.target}";
			}
			if(document.getElementById("form.req_type").value==""){
				alert("请选择请求类型！");
			}

			var val = window.showModalDialog(url,'','dialogWidth:600px; dialogHeight:300px; status:no;resizable:no;');
		
			if(val != null && val != ""){
			    var file = val.split("|");
				document.getElementById("filename").value=file[0];
				var obj = document.getElementById("filearea");
				obj.innerHTML="已上传文件：<a href='<%=contextPath%>/common/batch/download.jsp?filename="+file[0]+"'><font color='red'>"+file[1]+"</font></a>";
			
			}
		}
		function change(){
		    
			if(document.getElementById("form.req_type").value=="1003"){
				document.getElementById("allparam").disabled=true;
				document.getElementById("fileparam").checked=true;
				document.getElementById("btnupload").disabled=false;
			}else {
			    document.getElementById("allparam").checked=true;
			    document.getElementById("allparam").disabled=false;
			    document.getElementById("btnupload").disabled=true;
			}
		    
		}
		
		
    </script>
</head>
<body onload="loadforiframe();">
	    <s:form action="/fee/billing/uapreq_save.do" key="formItem" method="post" theme="simple" >

			<s:hidden name="CMD"/>
			<s:hidden name="filename" id="filename"/>
            
			<div class="widgetL">
			<div class="wCenter"> 
			<div class="content">
			<div class="title_name">发起核查请求</div>
			<aa:zone name="errorZone"><div class="error_text"><s:actionerror/><s:actionmessage/></div></aa:zone>
			<div class="search2">
			<table width="100%"  border="0" cellspacing="0" cellpadding="0">
			        <tr>
				    <th><font color="red">*</font><s:text name="req_type"/>:</th>
				    <td width="60%">
						<j:selector definition="$IB_REQ_UAP" cssClass="input" readonly="true" onchange="change();" name="form.req_type" id="req_type" condition="_ssw_dictid:10__"/>
				    </td>
			        </tr>
			        
			        <tr style="padding-top:5px">
			        
			        	<th><font color="red">*</font><s:text name="checkparam"/>:</th>
			        	
				        <td width="60%">
				            <span class="title"><input type="radio" id="allparam" name="form.param" value="ALL" <s:if test="form.param == 'ALL'">checked</s:if> onClick="javascript:document.getElementById('btnupload').disabled=true; ">全量</span>
				            <span class="title" style="margin-left:27px"><input type="radio" id="fileparam" name="form.param" value="FILE" <s:if test="form.param == 'FILE'">checked</s:if> onClick="javascript:document.getElementById('btnupload').disabled=false;">
				            <input disabled id="btnupload" name="btnupload" type="button" onmouseover=this.className="l_bt48" 
	 					           onMouseOut=this.className="l_bt48_gray" value="导入文件" class="l_bt48_gray" onClick="showbtnupload();"/></span>
				            <span id="filearea" class="title"></span>
				        </td>
				   
			        </tr>
					
			        <tr style="padding-top:5px">
			        	<th><font color="red">*</font><s:text name="remark"/>:</th>
				        <td width="60%">
				        	<s:textarea name="form.remark" id="form.remark" cssClass="input"  />
				        </td>
			        </tr>
			
			<tr>
			    <th></th>
				<td width="60%" align="left">
				    <s:if test="CMD == 'NEW'">
					<input type="button" id="btnSave" onmouseover=this.className="bt48" onMouseOut="this.className='bt48_gray'"
			                           name="btnSave"  value="<s:text name="button_submit"/>" class="bt48_gray"
			                           onclick="doSave('/fee/billing/uapreq_save.do?target=${requestScope.target}')"/>
			        </s:if>
			        <s:else>
			        <input type="button" id="btnSave" onmouseover=this.className="bt48" onMouseOut="this.className='bt48_gray'"
			                           name="btnSave" value="<s:text name="button_submit"/>" class="bt48_gray" disabled="disabled"
			                           onclick="doSave('/fee/billing/uapreq_save.do?target=${requestScope.target}')"/>
			        </s:else>
			     	<input type="button" onmouseover=this.className="bt48" onMouseOut="this.className='bt48_gray'"
			                           name="btnReturn" value="<s:text name="button_return"/>" class="bt48_gray"
			                           onclick="doReturn('/fee/billing/uapreq_list.do?target=${requestScope.target}')"/>
				</td>
			</tr>
			
			</table>
			</div>
			</div>
		</div>
	</div>
</s:form>
</body>
</html>
