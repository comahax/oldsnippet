<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/head.inc"%>

<script type="text/javascript">  
function selectOrg(nodeId, nodeName, nodeType,Turetype) {   
     var url = "/cms/way.do?CMD=LIST"; 
     var openURL= null;
		if(Turetype == "GMCC" ) {  //节点为省公司， 跟节点，下级显示所有市公司
          url = "/cms/citycompany.do?CMD=LIST";  //指向分公司管理的链接。
         openURL = "<%=contextPath%>" + url ;

     }else if(Turetype == "Citycom" ) {  //节点为市公司， 按市公司编码查询右侧列表
         url = "/cms/cntycompany.do?CMD=LIST";  //指向分公司管理的链接。
         openURL = "<%=contextPath%>" + url + "&_se_citycompid=" + nodeId ;   
     }else if(Turetype == "Cntycom" ) {  //节点为分公司， 按分公司编码查询右侧列表
          url = "/cms/servcent.do?CMD=LIST";  //指向服务销售中心管理的链接。
          openURL = "<%=contextPath%>" + url + "&_se_countyid=" + nodeId ; 
      }else if(Turetype == "Svc" ) {  //节点为服务销售中心， 按服务销售中心编码查询右侧列表
          url = "/cms/microarea.do?CMD=LIST";  //指向微区域管理的链接。
          openURL = "<%=contextPath%>" + url + "&_se_svccode=" + nodeId ;  
      }else if(Turetype == "Ma " ) {   //节点为微区域， 按微区域编码查询右侧列表
             url = "";  //微区域没有下级，指向空白链接
          openURL = "<%=contextPath%>" + url + "&_se_macode=" + nodeId ; 
      }
            var workLink = document.getElementById("wayLink");
      if( openURL!=null) {
      //alert(openURL);
          workLink.href = openURL;
          workLink.click();
      }
 } 
</script>

<jsp:include page="/cms/way/selectOrgTreePage.jsp"/>

