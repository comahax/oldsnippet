<%@ include file="/common/jspHead.jsp"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@page import="com.gmcc.pboss.common.dictionary.HttpDictionary"%>
<%@page import="com.gmcc.pboss.common.dictionary.LoginType" %>
<html>
<head>
<title>��ӭ�����㶫�ƶ���������������ƽ̨</title>
<link href="${ctx}/css/enter.css" rel="stylesheet" type="text/css">
<%@ include file="/common/meta_allcss.jsp"%>

<style type="text/css">
<!--
body {
background-image:none;
padding-left:20px;
}
-->
</style>
</head>

<body bottommargin="0" leftmargin="0" topmargin="0" rightmargin="0">
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center" valign="middle">
    <table border="0" align="center" cellpadding="0" cellspacing="0" class="bj">
      <tr>
        <td align="right">
        <table width="88%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td valign="top">
            <table border="0" cellpadding="0" cellspacing="0" class="new">
              <tr>
                <td align="right"><table width="95%" border="0" cellpadding="0" cellspacing="0" class="newtitle">
                  <tr>
                    <td align="left">������Ϣ</td>
                    </tr>
                </table></td>
              </tr>
              <tr>
                <td><div class="newk">
                	<!-- ����������Ϣ Begin -->
	                <s:if test="%{publicList.size > 0}">
	                	<s:iterator value="publicList" id="info">
	                		<s:set name="title" value="@com.gmcc.pboss.common.util.CommonUtil@fOmit(#info.title,15)" />
		                  	<li>&nbsp;
			                  	<a href="javaScript:f_openDetl('/communi/showPublic.do?cityid=${_cityid}&publicParameter.advinfoid=<s:property value="#info.advinfoid"/>','������Ϣ')" class="a4">
			                  	<s:property value="#title"/></a>
		                  	</li>
	                  	</s:iterator>
	                </s:if>
	                <s:else>
	                  <li>���޹�����Ϣ��</li>
	                </s:else>
	                <!-- ����������Ϣ End -->  
                </div></td>
              </tr>
            </table></td>
            <td align="right">
            
            <form name="LoginForm" id="LoginForm" method="post" action="/service/Login.do">
			<input type="hidden" name="loginParameter.backURL" value=""/>
            <input type="hidden" name="loginParameter.step2" value="true"/>
            <table border="0" cellspacing="0" cellpadding="0" class="login">
              <tr>
              	<td><div class="enter_m_bid">
              		<span class="index_main_top_area_xi">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�û����ͣ�</span>           
              		<s:select name="loginParameter.isnet" list="%{#session.isnetmap}" cssClass="biaodan_biaodan_denter" cssStyle="width:130px"/>
              	</div>              	
              	</td>
              </tr>
              <tr>
                <td class="enter_m_bo">
                	<label><button class="btn_blue_75" onclick="login2()" type="button">ȷ ��</button></label>
			      	<label><button class="btn_blue_75" id="back" onclick="f_jumpToURL('/tologin.do')" type="button">�� ��</button></label>
                  </td>
              </tr>
            </table>
            </form>
            <input type="hidden" name="" value="${_cityid}"/>
            </td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/validation/jquery.validation.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery/validation/common.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery/ac/jquery.autocomplete.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery/ac/auto.js"></script>
<script type="text/javascript" src="${ctx}/js/biz/login2.js"></script>
</html>