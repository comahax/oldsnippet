<%@ page language="java" contentType="text/html;charset=GBK" %>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="文件上传"/></title>
    <script language="JavaScript" type="text/JavaScript">
	    function checkProcess(actionUrl){
			var filename = formItem.path.value;
			if(filename != null || filename != ""){
				formItem.btnDeal.disabled=true;
				document.getElementById("tt").href="<%=contextPath%>/channel/employeeimport.do?filename="+filename+"&beanname=com.gmcc.pboss.web.channel.employee.EmployeeTaskBean";
	    		document.getElementById("tt").click();
			}
		}
		
		function upload(actionUrl){
			formItem.action=actionUrl;
			var fileName = document.getElementById('doc').value;
			if(fileName == ''){
				 var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>请选择上传的文件</span> ';
				errorMessageShow(alertstr);
				return false;
			}
			formItem.submit();
		}
		
		function dataCheck(){
			
			return ture;
		}
		
		
    </script>
    <base target="_self">
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<s:form action="/channel/employeeupload.do" cssStyle="formItem" key="formItem" 
			method="post" theme="simple" enctype ="multipart/form-data" onSubmit="return dataCheck()">
    <a id="tt" href="#"></a>
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h"><s:text name="file_upload"/></span>
			</s:i18n>
		</div>
	</div>

<input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.channel.employee.EmployeeCheck">

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
                <td align="right" width=110px>请选择上传的文件:&nbsp</td>
                <td align="left">
					<s:file name="doc" label="File"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="file_file"/>:&nbsp</td>
                <td align="left">
					<a href='<%=contextPath%>/common/download.jsp?filename=<s:property value="filepath" />'> 
					<s:property value="fileName" /> 
            	</a>
                </td>
            </tr>

            <tr>
                <td align="right">文件类型:&nbsp</td>
                <td align="left">
					.txt文本文件(文件里不要留空行和多余的空格)
                </td>
            </tr>
            <tr>
                <td align="right">文件格式:&nbsp</td>
                <td align="left">

					BOSS工号|<FONT color=red>姓名</FONT>|出生日期|性别|籍贯|政治面貌|家庭住址|<FONT color=red>身份证号码</FONT>|手机号|<FONT color=red>个人电子邮箱</FONT>|<BR>公司专用联系方式|文化程度|专业|<FONT 
color=red>地市公司</FONT>|<FONT color=red>分公司</FONT>|服务销售中心|微区域|<FONT color=red>服务厅（所属渠道）</FONT>|所属劳务公司|<FONT 
color=red>岗位</FONT>|<BR>岗位级别|职级|所在部门|毕业时间|毕业院校|入职时间|劳动关系|用工性质|<FONT color=red>用工状态</FONT>|参加工作年限|<BR>本公司工作年限|婚姻状况|<FONT color=red>公务手机号码</FONT>|
                </td>
            </tr>
            <tr>
                <td align="right">举例说明:&nbsp</td>
                <td align="left">
					testcode|test|1980-01-01|1|1|0|0|440524198002202437|13666666666|test@163.com|020-88888888|
					8| |JM|JMA| | |JFJMAAA00| |60|1|3| |2004-06-30|广州大学|2006-01-01|0|1|1|2|1|1|13635548143|
                </td>
            </tr>
            <tr>
                <td align="right">补充说明:&nbsp</td>
                <td align="left">
					岗位:60-渠道经理,64-战略层渠道经理,65-紧密层渠道经理
					政治面貌:0-中共党员,1-中共预备党员,2-共青团员,3-民革会员,4-民盟盟员,5-民建会员,6-民进会员,
					7-农工党党员,8-致公党党员,9-九三学社社员,10-台盟盟员,11-无党派人士,99-群众
					文化程度:0-初中以下,1-初中,2-高中,3-中专,4-大专,5-本科,6-双学位,7-硕士,8-博士,9-博士后
					用工性质:0-合同工,1-招聘工,2-劳务工,3-临时工,99-其他
					职级:0-初级,1-中级,2-副高级,3-正高级,4-其他
					籍贯：1-广东，2-广西，99-其它
					劳动关系:0-未签合同,1-已签合同
					用工状态:0-在岗,1-离职
					性别:0-男,1-女
					岗位级别:1-经理
					婚姻状况:0-未婚,1-已婚 
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
                    <input type="button" id="btnUpload" name="btnUpload" class="button_New" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="上传" onclick="upload('/channel/employeeupload.do')"/>
                    
                   
                    <input type="button"  id="btnDeal" name="btnDeal" class="button_New" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_deal"/>" onclick="checkProcess('/channel/employeeimport.do');"/>
                           
                           <input type="button"  id="btnBack" name="btnBack" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="window.location.href='/channel/employee_list.do?processType=MANAGER';"/>
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
    
</s:form>
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.channel.employee.EmployeeTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>

</body>
</html>
<script type="text/javascript">
<!--

 function showDelButton(){
 var filename = formItem.filename.value;
        if(filename == null || filename == '' ){
        $("#btnDeal").attr('disabled',true);
        }
        else{
         $("#btnDeal").attr('disabled',false);
         }
        }
        showDelButton();
        
//-->
</script>
