<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/head.inc"%>

<script type="text/javascript">     
/* ע�� ���ݾ��幦�ܵĲ�ͬ�� Ŀ�����Ӳ�һ���� /cms/way.do ��ʵ�ִ˷���ʱ��Ҫָ��Ϊ��������ӡ� */
function selectOrg(nodeId, nodeName, nodeType) {   
     var url = "/cms/way.do?CMD=LIST"; 
          url = "/cms/cntycompany.do?CMD=LIST";  //ָ������������Ĺ�������ӡ�
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
