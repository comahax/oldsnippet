<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/head.inc"%>

<script type="text/javascript">     
/* 注： 根据具体功能的不同， 目标链接不一定是 /cms/way.do ，实现此方法时需要指定为具体的链接。 */
function selectOrg(nodeId, nodeName, nodeType) {   
     var url = "/cms/way.do?CMD=LIST"; 
          url = "/cms/cntycompany.do?CMD=LIST";  //指向服务销售中心管理的链接。
         var openURL = null;
         openURL="<%=contextPath%>" + url + "&_sk_citycompid=" + nodeId ; 
      
      var workLink = document.getElementById("wayLink");
      if( openURL!=null) {
      //alert(openURL);
          workLink.href = openURL;
          workLink.click();
      }
 } 
</script>

<jsp:include page="/cms/way/selectOrgTreePage.jsp">
	<jsp:param name="orgtype" value="Citycom" />
</jsp:include>
