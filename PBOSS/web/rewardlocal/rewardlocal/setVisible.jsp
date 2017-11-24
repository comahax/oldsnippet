<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            return checkval(window);
        }
        window.onload = function(){
        	f_rewardCheckVisible();
        }
        function f_rewardCheckVisible(){
        	var obj = document.forms[0].isVisibleReward;
        	if(!obj.checked){
        		$("#showLocalRewardTr").hide();
        	}else{
        		$("#showLocalRewardTr").show();
        	}
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="rewardlocal_setVisibleSave.do" cssStyle="formList" key="formItem" method="post" theme="simple" >
	
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea">������</span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea">���س�����</span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h">�������ƽ̨�������</span>
			<!-- 
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
			 -->
		</div>
	</div>

	<div class="error_text" >
		<table class="error_text">
			<s:actionerror /><s:actionmessage/>
		</table>
	</div>
	
    <div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="right" style="width: 150px;" ><s:text name="showReward"/>:&nbsp;</td>
                <td align="left">
                	<input type="checkbox" name="isVisibleReward" onclick="f_rewardCheckVisible()" value="1" <s:if test="isVisibleReward==1" >checked="checked"</s:if> >
                </td>
			</tr>
			<tr id="showLocalRewardTr" >
                <td align="right">ѡ����˵�:&nbsp;</td>
                <td align="left">
			    	<input type="radio" name="isVisibleLocalReward" value="1" <s:if test="isVisibleLocalReward==1" >checked="checked"</s:if> />ʹ�ñ��س��&nbsp;
			    	<input type="radio" name="isVisibleLocalReward" value="0" <s:if test="isVisibleLocalReward==0" >checked="checked"</s:if> />ʹ��ϵͳĬ�ϳ��&nbsp;
                </td>
            </tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                    <input type="submit" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>"  />
                    </s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
