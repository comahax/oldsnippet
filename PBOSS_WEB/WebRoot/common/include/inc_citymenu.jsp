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
      			<c:if test="${logMem!=null && (logMem.isnet == role.CITY_MANAGER)}">
        			<td><img src="${ctx}/images/img/role.gif" width="14" height="15"></td>
        			<td><span class="font_lightBlue">��ɫ��</span><span class="font_orange">�й�˾����Ա</span></td>
      			</c:if>
      			<c:if test="${logMem!=null && (logMem.isnet == role.GD_MANAGER)}">
        			<td><img src="${ctx}/images/img/role.gif" width="14" height="15"></td>
        			<td><span class="font_lightBlue">��ɫ��</span><span class="font_orange">ʡ��˾����Ա</span></td>
      			</c:if>
      			</tr>
      			<c:if test="${logMem!=null && (logMem.isnet == role.CITY_MANAGER)}">
		      	<tr>
		        	<td><img src="${ctx}/images/img/city.gif" width="14" height="15"></td>
		        	<td><span class="font_lightBlue">���У�</span><span class="font_orange">
		        	<%=Constant.getConstantName(ConstantsType.BRANCH_NAME,_member.getCityid()) %>
		        	</span></td>
		      	</tr>
		      	</c:if>
		      
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