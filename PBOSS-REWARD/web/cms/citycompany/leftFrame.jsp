<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/head.inc"%>

<script type="text/javascript">  
function selectOrg(nodeId, nodeName, nodeType,Turetype) {   
     var url = "/cms/way.do?CMD=LIST"; 
     var openURL= null;
		if(Turetype == "GMCC" ) {  //�ڵ�Ϊʡ��˾�� ���ڵ㣬�¼���ʾ�����й�˾
          url = "/cms/citycompany.do?CMD=LIST";  //ָ��ֹ�˾��������ӡ�
         openURL = "<%=contextPath%>" + url ;

     }else if(Turetype == "Citycom" ) {  //�ڵ�Ϊ�й�˾�� ���й�˾�����ѯ�Ҳ��б�
         url = "/cms/cntycompany.do?CMD=LIST";  //ָ��ֹ�˾��������ӡ�
         openURL = "<%=contextPath%>" + url + "&_se_citycompid=" + nodeId ;   
     }else if(Turetype == "Cntycom" ) {  //�ڵ�Ϊ�ֹ�˾�� ���ֹ�˾�����ѯ�Ҳ��б�
          url = "/cms/servcent.do?CMD=LIST";  //ָ������������Ĺ�������ӡ�
          openURL = "<%=contextPath%>" + url + "&_se_countyid=" + nodeId ; 
      }else if(Turetype == "Svc" ) {  //�ڵ�Ϊ�����������ģ� �������������ı����ѯ�Ҳ��б�
          url = "/cms/microarea.do?CMD=LIST";  //ָ��΢�����������ӡ�
          openURL = "<%=contextPath%>" + url + "&_se_svccode=" + nodeId ;  
      }else if(Turetype == "Ma " ) {   //�ڵ�Ϊ΢���� ��΢��������ѯ�Ҳ��б�
             url = "";  //΢����û���¼���ָ��հ�����
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

