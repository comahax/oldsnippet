<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.gmcc.pboss.common.dictionary.Regex" %>
<%@ page import="com.gmcc.pboss.common.dictionary.ConstantsType" %>
<%@ page import="com.gmcc.pboss.common.bean.MenuBean" %>
<%@ page import="com.gmcc.pboss.common.constant.Constant" %>
<%@ page import="com.gmcc.pboss.common.cookie.CookieUtil"  %>
<%@ page import="com.gmcc.pboss.common.cookie.MenuCookie"  %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<!-- �˵�ҳ�� -->
	<div class="menu">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
	<td valign="top"  class="frameline">
		
		<div class="framesubnavbj">
            <div class="frametitle">�û���Ϣ</div>
        </div>
        
        <div class="framecontent">
        	<table border="0">
      			<tr>
        			<td><img src="${ctx}/images/img/name.gif" width="16" height="17"></td>
        			<td >
        				<span class="font_lightBlue">������</span><span class="font_orange">${_PBOSS_WEB_USER.employeename}</span>
        			</td>
      			</tr>
		      	<tr>
		        	<td><img src="${ctx}/images/img/number.gif" width="12" height="17"></td>
		        	<td ><span class="font_lightBlue">�ֻ���</span><span class="font_orange">${_PBOSS_WEB_USER.officetel}</span></td>
		      	</tr>
      			<tr>
        			<td><img src="${ctx}/images/img/role.gif" width="14" height="15"></td>
        			<td><span class="font_lightBlue">��ɫ��</span><span class="font_orange">${_PBOSS_WEB_USER.roleName}</span></td>
      			</tr>
		      	<tr>
		        	<td><img src="${ctx}/images/img/city.gif" width="14" height="15"></td>
		        	<td><span class="font_lightBlue">���У�</span><span class="font_orange">
		        	<%=Constant.getConstantName(ConstantsType.BRANCH_NAME,_member.getCityid()) %>
		        	</span></td>
		      	</tr>
		      	<tr>
		        	<td><img src="${ctx}/images/img/N0-1.gif" width="16" height="15"></td>
		        	<td><span class="font_lightBlue">�������룺</span><span class="font_orange">${_PBOSS_WEB_USER.wayid}</span></td>
		      	</tr>
		      	<tr>
		        	<td><img src="${ctx}/images/img/N0-2.gif" width="16" height="15"></td>
		        	<td><span class="font_lightBlue">�������ƣ�</span><span class="font_orange">${_PBOSS_WEB_USER.channel.wayname}</span></td>
		      	</tr>
			    <tr>
			        <td><img src="${ctx}/images/img/N0-3.gif" width="16" height="15"></td>
			        <td><span class="font_lightBlue">�������</span><span class="font_orange"><%=Constant.getConstantName(ConstantsType.WAY_SUB_TYPE,_member.getChannel().getWaysubtype()) %>
			        </span></td>
			    </tr>
			    
			    <!-- �����Ϣ20101207�������Ǽ����տ����������տ����˻����տ��˿����� -->
			    <tr>
		        	<td><img src="${ctx}/images/img/N0-1.gif" width="16" height="15"></td>
		        	<td><span class="font_lightBlue">�����Ǽ���</span><span class="font_orange">${_PBOSS_WEB_USER.channel.strStarLevel}</span></td>
		      	</tr>
		      	<c:if test="${logMem!=null && (logMem.isnet != role.MANAGER)}">
		      	<tr>
		        	<td><img src="${ctx}/images/img/N0-1.gif" width="16" height="15"></td>
		        	<td><span class="font_lightBlue">������������</span><span class="font_orange">${_PBOSS_WEB_USER.magName}</span></td>
		      	</tr>
		      	</c:if>
		      	<tr>
		        	<td><img src="${ctx}/images/img/N0-2.gif" width="16" height="15"></td>
		        	<td><span class="font_lightBlue">�տ������ƣ�</span><span class="font_orange">${_PBOSS_WEB_USER.recpers }
		        	</span></td>
		      	</tr>
			    <tr>
			        <td><img src="${ctx}/images/img/N0-1.gif" width="16" height="15"></td>
			        <td><span class="font_lightBlue">�տ����˻���</span><span class="font_orange">${_PBOSS_WEB_USER.acctno }
			        </span></td>
			    </tr>
			    <tr>
		        	<td><img src="${ctx}/images/img/N0-3.gif" width="16" height="15"></td>
		        	<td><span class="font_lightBlue">�տ��˿����У�</span><span class="font_orange">${_PBOSS_WEB_USER.bankname }
		        	</span></td>
		      	</tr>
    		</table>
        </div>
           
    </td>
</tr>
<tr>
	<td  valign="top"  height="8"></td>
</tr>
<!-- 
<tr>
  <td valign="top"  class="frameline">
	<div class="framesubnavbj"><div class="frametitle">���ò˵�</div></div>
	<div class="framecontent">
	<div class="sub_framelist2" id="_cmenu">
	</div>
	</div>
  </td>
</tr>
-->
</table>
</div>