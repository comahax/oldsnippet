<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<%@ page import="com.gmcc.pboss.common.dictionary.ConstantsType" %>
<%@ taglib prefix="st" uri="/select-tag"%>
<html>
<head>
<!-- 公共CSS文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
<jsp:useBean id="pageInfo2" class="com.gmcc.pboss.common.action.PageInfo"/>
<c:set var="PageInfo" value ="${pageInfo2}"/>
</head>
<body>
    <div class="divspan">
    <table width="910"  border="0" cellspacing="0" cellpadding="0" align="center">
        <tr>
          <td width="910px" height="121px" valign="top" background="/images/img/header.jpg"><div class="heade" >
            <div class="font_red"> 欢迎使用广东移动渠道合作伙伴服务平台</div>
          </div></td>
        </tr>
      </table>
    </div>
	<div class="divspan">
		<s:form id="frmRegister" method="POST" action="/node/wayApply.do" validate="true" onsubmit="return doSubmit(this);">
		<!-- 注册内容开始 -->
		<div class="registryable">
                 <div class="listboxtitle">帮助信息</div>
		<div align="left">
		1.带有红色<font color="#FF0000">*</font>标注的输入框为必填框，请正确填写；<br>
		2.身份证号码为15位或18位有效号码；
		<c:if test='${fn:length(message)>0}'>
		<br><font color="red">错误提示：${message}</font></c:if>
		
		</div>
	    <div class="listboxtitle">申请人资料</div>
			<div class="listboxform">
            <table border="0" width="100%">
				<tr class="registryable_view_head">
				<td width="12%">姓名：</td>
				<td >
		        	<s:textfield name="apply.principal" cssClass="text_01" maxlength="10" />
		        	&nbsp;<font color="#FF0000">*</font>
		        </td>
		</tr>
				<tr class="registryable_view_head">
			  <td width="12%">身份证号：</td>
			  <td>
			  <s:textfield name="apply.acctfid" cssClass="text_01" maxlength="18"/>
		      &nbsp;<font color="#FF0000">*</font>
		      </td>
		</tr>	 
				<tr class="registryable_view_head">
			  	<td>移动电话：</td>
          <td>
                    <s:textfield name="apply.principaltel" cssClass="text_01" maxlength="11"/>
                    &nbsp;<font color="#FF0000">*</font></td>
                  </tr>
		   	<tr class="registryable_view_head">
                 <td>办公电话：</td>
             <td >
                 <s:textfield name="apply.principalphone" cssClass="text_01" maxlength="20"/>
                 </td>
            </tr>
            <tr class="registryable_view_head">
                 <td>电子邮箱：</td>
             <td >
                 <s:textfield name="apply.principalemail" cssClass="text_01" maxlength="100"/>
                 </td>
            </tr>
            <!-- 
			<tr class="registryable_view_head">    
			    <td>性别：</td>
		      <td>
                <st:st className="formSelect_2L" type="<%=ConstantsType.SEX %>"/>
                </td>
           </tr>
            -->	
		</table>
        	</div>
  		
        <div class="listboxtitle">网点基本资料</div>
		<div class="listboxform">
            <table border="0" width="100%">
<tr class="registryable_view_head">
						<td width="12%">网点名称：</td>
<td>
<s:textfield name="apply.wayname" cssClass="text_01" maxlength="100"/>
				        &nbsp;<font color="#FF0000">*</font>				        </td>
		   	  </tr>
				   	<tr class="registryable_view_head">
					    <td >网点面积：</td>
				      <td >
					    <s:textfield name="apply.buzarea" cssClass="text_01" maxlength="5"/>平米
					    </td>
			  </tr>
					<tr class="registryable_view_head">
					    <td >网点地址：</td>
				      <td >
					    <s:textarea id="address" name="apply.address" cssClass="textarea_01" rows="3" cols="45" onkeydown="textdown(event,'address',100)" onkeyup="textup('address',100)"></s:textarea>&nbsp;<font color="#FF0000">*</font>
					    </td>
			  </tr>
					<tr class="registryable_view_head">
					  <td>归属地：</td>
					  <td>
                      <st:st name="apply.cityid" className="formSelect_2L" type="<%=ConstantsType.BRANCH_NAME %>" selected="${apply.cityid}" />
				      &nbsp;<font color="#FF0000">*</font></td>
				    </tr>
					<tr class="registryable_view_head">
					  <td>经营业态：</td>
                      <td>
                       <st:st name="apply.formtype" className="formSelect_4L" type="<%=ConstantsType.FORMTYPE %>"/>
                      </td>
				</tr>	
			</table>
            </div>
		</div>
	<!--	
	<div class="registryable">
		<div class="scanpointbj"> 
  			<li class="scanpoint"></li>
  			<li class="scantitlename">网点酬金资料</li>
  		</div>
  		<table width="100%" class="registryable_view">
			<tr class="registryable_view_head">
				<td width="10%">开户人姓名：</td>
		        <td width="14%">  <input type="text" class="text_01" />
		          &nbsp;<font color="#FF0000">*</font></td>
		     </tr>
      <tr class="registryable_view_head">
			    <td width="10%" >开户银行：</td>
    <td >
			   <s:textfield name="apply.bankname" cssClass="text_01" maxlength="100"/>&nbsp;<font color="#FF0000">*</font></td>
		  </tr>
			  <tr class="registryable_view_head">
			    <td >银行帐号：</td>
			    <td >
			    <s:textfield name="apply.acctno" cssClass="text_01" maxlength="50"/>
		        &nbsp;<font color="#FF0000">*</font>
		        </td>
		  </tr>
			
		</table>
		
		
	</div>
	-->
		<div class="registrytitle">
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		验证码：
  			<input tabindex="8" name="vaildateCode" type="text" id="vaildate_code" class="input3"  maxlength="4" onBlur="hiddenVerify()" onFocus="focusGetVerify(this)"  size="4" style="ime-mode:disabled;width:50px" value=""/>&nbsp;&nbsp;
			<input type="submit" class="btn_blue_75" value="提 交" />&nbsp;&nbsp;
			<input type="button" class="btn_blue_75" value="关 闭" onClick="window.close();">
    	</div>
	</s:form>
	</div>
		<!-- 注册内容结束 -->
	<%@ include file="/common/include/inc_foot.jsp"%>
	<div id="_rndImageDIV" style="border:solid 1px #545454;position:absolute;background:#E8FBFF;padding:3px;display:none;zIndex:3000"></div>
</body>
<%@ include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="/js/common/rnd_code.js"></script>
<script type="text/javascript" src="/js/jQuery/validation/jquery.validation.js"></script>
<script type="text/javascript" src="/js/jQuery/validation/common.js"></script>
<script type="text/javascript" src="/js/biz/register.js"></script>
<SCRIPT LANGUAGE="JavaScript">
<!--
//页面变量设置
var errMap = new Array();
<%--设置错误信息--%>
<c:set var="ferrMap" value ="${fieldErrors}"/>
<c:if test="${fn:length(ferrMap)>0}"><c:forEach items="${ferrMap}" var="fieldError" varStatus="i">
errMap[${i.index}]={feild:'${fieldError.key}',msg:'${fieldError.value}'};
</c:forEach>
</c:if>
//-->
</SCRIPT>
</html>