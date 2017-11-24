<%@ page language="java" contentType="text/html;charset=GBK" %>
<%@ include file="/inc/listhead.inc" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="文件上传"/></title>
    <script language="JavaScript" type="text/JavaScript">
	    function checkProcess(actionUrl){
			var filename = formItem.path.value;
			if(filename != null || filename != ""){
				formItem.btnDeal.disabled=true;
				document.getElementById("tt").href="<%=contextPath%>/channel/societypeopleimport.do?filename="+filename+"&beanname=com.gmcc.pboss.web.channel.employee.SocietyPeopleTaskBean";
	    		document.getElementById("tt").click();
			}
		}
		
		function upload(actionUrl){
			var param92 = document.getElementById("param92").value;
			if (param92 != null && param92 != "") {
				document.getElementById("paramMap_param92").value = param92;
			}
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
    <script type="text/javascript" src="<%=contextPath%>/js/pub/content.js"></script>
    <base target="_self">
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="/channel/societypeopleupload.do" cssStyle="formItem" key="formItem" 
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
    <s:hidden name="param92" id="param92"></s:hidden>
    <s:hidden name="paramMap.param92" id="paramMap_param92"></s:hidden>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.channel.employee.SocietyPeopleCheck">

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
					<FONT color=blue>人员ID|</FONT><FONT color=red>公务机号码</FONT>|<FONT 
					color=red>姓名</FONT>|出生日期|<FONT 
					color=red>性别</FONT>|<FONT color=red>身份证号码</FONT>|个人电子邮箱|文化程度|<FONT 
					color=red>地市公司</FONT>|<BR><FONT color=red>分公司</FONT>|服务销售中心|<FONT 
					color=red>所属网点</FONT>|<FONT color=red>入职时间</FONT>|<FONT 
					color=red>劳动关系</FONT>|<FONT color=red>用工性质</FONT>|保证金|<FONT 
					color=red>用工状态</FONT>|空中选号手机号|工号<s:if test="{param92 == 1 || paramMap.param92 == 1}">|是否为店主</s:if><s:elseif test="{#request.parameterMap.param92 == 1}">|是否为店主</s:elseif><BR>(注:红色字体为必须录入字段) 
                </td>
            </tr>
            <tr>
                <td align="right">举例说明:&nbsp</td>
                <td align="left">
					<FONT color=red>批量新增时，人员id由系统自动生成，不需要录入人员id，第一列为空以|开头</FONT><BR>
					举例说明：|13888888888|姓名||0|12346879|134645|1|JM|JMC|JMSVC1|JFJMCSE02|2007-04-02|1|1|100|1|15013335503|JM10054<s:if test="{param92 == 1 || paramMap.param92 == 1}">|0</s:if><s:elseif test="{#request.parameterMap.param92 == 1}">|0</s:elseif><BR>
					<FONT color=red>批量修改时，请指定人员id（可以先批量导出人员信息，然后补充未填写的信息）</FONT><BR>
					举例说明：JM10000185|13888888888|姓名||0|12346879|134645|1|JM|JMC|JMSVC1|JFJMCSE02|2007-04-02|1|1|100|1|15013335503|JM10054<s:if test="{param92 == 1 || paramMap.param92 == 1}">|0</s:if><s:elseif test="{#request.parameterMap.param92 == 1}">|0</s:elseif>
					<s:if test="{param92 == 1 || paramMap.param92 == 1}">
						<BR><FONT color=red>自定义导入：可以根据人员ID，修改此条数据的其他任何信息</FONT><BR>
						举例说明(自定义导入)格式：<BR>
						人员ID|姓名<BR>
						ZS1002420|黄小艺
					</s:if>
					<s:elseif test="#request.parameterMap.param92 == 1">
						<BR><FONT color=red>自定义导入：可以根据人员ID，修改此条数据的其他任何信息</FONT><BR>
						举例说明(自定义导入)格式：<BR>
						人员ID|姓名<BR>
						ZS1002420|黄小艺
					</s:elseif>
                </td>
            </tr>
            <tr>
                <td align="right">补充说明:&nbsp</td>
                <td align="left">
					性别:0(男),1(女)<BR>
					文化程度:0(初中以下),1(初中),2(高中),3(中专),4(大专),5(本科),6(双学位),7(硕士),8(博士),9(博士后),99(其他)<BR>
					劳动关系:0(未签合同),1(已签合同)<BR>
					用工性质:0(合同工),1(招聘工),2(劳务工),3(临时工),99(其他)<BR>
					用工状态：0(在岗),1(离职)<BR>
					是否为店主：0(店员),1(店主)<br>
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
                    <input type="button" id="btnUpload" name="btnUpload" class="button_2" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="上传" onclick="upload('/channel/societypeopleupload.do')"/>
                    
                   
                    <input type="button"  id="btnDeal" name="btnDeal" class="button_2" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_deal"/>" onclick="checkProcess('/channel/societypeopleimport.do');"/>
                    
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/employee_societylist.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
    
</s:form>
</div>
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.channel.employee.SocietyPeopleTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
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
