<%@ page language="java" contentType="text/html;charset=GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%String contextPath = request.getContextPath();
%>
<html>
	<head>
		<title>index</title>
		<script>
		contextPath = "<%=contextPath%>/";
		</script>
		<link rel="stylesheet" href="<%=contextPath%>/css/dtree.css" type="text/css" />
		<script type="text/javascript" src="<%=contextPath%>/js/dtree.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK" />

		<style type="text/css">
<!--
.style1 {
	font-size: large;
	font-weight: bold;
}
-->
</style>
	</head>
	<body style="margin:0px; padding:0px;">
		<table cellpadding=0 cellspacing=0 border=0 width=100% height=100%>
			<tr style="height:76px; width:100%;">
				<td colspan=2 style="border-bottom:#e3e3e3 solid 2px; background:url(images/top.jpg); padding-left:100px; padding-top:10px; font-size:14px;">
					Ӧ������Ҫ�󣬸ĳ�3���˵���ʽ������4���˵��Ա�ǩҳչʾ������˵�Ŀ¼��DJ����
				</td>
			</tr>
			<tr>
				<td width=195 style="border-right:#e3e3e3 solid 2px; font-size:12px; background:#FFFFFF; color:#000000;">
					�ۺ������ǩҳʾ������
					<br />
					<br />
					<div style="width:195px; height:484px; overflow:auto; background:#fff; border-top:#e3e3e3 solid 2px;">
						<script type="text/javascript">
          target = "mywin"
          //d.add('100', 10, 'ϵͳ����', '','',target); 
          d = new dTree('d');      
                                              
          d.add('40', -1, '�ۺ�����', '');
          	  d.add('401', 40, '���ֹ���', '','',target);            
                  d.add('40101', 401, '�ͻ����ֹ���', '<%=contextPath%>/fee/custintegral.jsp','',target); 
                  d.add('40103', 401, '��������ֹ���', '<%=contextPath%>/fee/officialintegral.jsp','',target); 
                  d.add('40102', 401, '��Ʒ������ֹ���', '<%=contextPath%>/fee/prodintegral.jsp','',target); 
              d.add('402', 40, '���ʴ���', '','',target);   
              	  d.add('40202', 402, '��������', '<%=contextPath%>/fee/billingset.jsp','',target);                   
                  d.add('40203', 402, '���˺˲�', '<%=contextPath%>/fee/billingcheck.jsp','',target); 
                  d.add('40204', 402, '���˼��', '<%=contextPath%>/fee/billingmonitor.jsp','',target);    
                  d.add('40201', 402, '���ʵ���', '<%=contextPath%>/fee/billingfix.jsp','',target); 
 	          d.add('403', 40, 'Ʊ�ݹ���', '','',target);      
		      	  d.add('40301', 403, '�ʵ�����', '<%=contextPath%>/fee/billcustomize.jsp','',target);         
                  d.add('40302', 403, '�ʵ���ӡ', '<%=contextPath%>/fee/billprint.jsp','',target);      
                  d.add('40303', 403, '��Ʊ����', '<%=contextPath%>/fee/invoicecustomize.jsp','',target);     
                  d.add('40304', 403, '��Ʊ��ӡ', '<%=contextPath%>/fee/invoiceprint.jsp','',target);   
              d.add('404', 40, '�������', '','',target);   
                  d.add('40401', 404, '�������', '<%=contextPath%>/fee/billreduce.jsp','',target);     
                  d.add('40402', 404, '���ʹ���', '<%=contextPath%>/fee/handbill.jsp','',target); 
                  d.add('40403', 404, '�������', '<%=contextPath%>/fee/billingadjust.jsp','',target);   
                  d.add('40404', 404, '�����ʴ���', '<%=contextPath%>/fee/badbill.jsp','',target);                     
                  d.add('40405', 404, '�����˷ѹ���', '<%=contextPath%>/fee/mwbilling.jsp','',target);
              d.add('405', 40, '�ɷ����ʹ���', '','',target);      
				  d.add('40501', 405, '���ʹ���', '<%=contextPath%>/fee/woffmanage.jsp','',target);
				  d.add('40504', 405, '���ʴ���', '<%=contextPath%>/fee/woffdeal.jsp','',target);
				  d.add('40502', 405, '�ʱ�����', '<%=contextPath%>/fee/eboxunitadj.jsp','',target);     
                  d.add('40503', 405, '���ɽ����', '<%=contextPath%>/fee/latefee.jsp','',target);     
                  d.add('40505', 405, '�����ۺϲ�ѯ', '<%=contextPath%>/fee/querybyno/list.jsp','',target);     
	          d.add('406', 40, '�ɷѴ߷ѹ���', '','',target);
              	  d.add('40601', 406, '���л��ʹ���', '<%=contextPath%>/fee/realtran.jsp','',target);
				  d.add('40602', 406, '����', '<%=contextPath%>/fee/tsdeal.jsp','',target);	
              d.add('400',  40, '���ÿ��ƹ���', '','',target);   
		          d.add('40001', 400, '�ſز�������', '<%=contextPath%>/fee/creditmanage.jsp','',target);
		          d.add('40002', 400, '���������ݹ���', '<%=contextPath%>/fee/safeperiod.jsp','',target); 
		          d.add('40003', 400, '�ſز�������', '<%=contextPath%>/fee/credit.jsp','',target); 
                  d.add('40004', 400, '���Ź���', '<%=contextPath%>/fee/sms.jsp','',target); 
                  d.add('40005', 400, 'Ƿ�Ѵ߽�', '<%=contextPath%>/fee/ownback.jsp','',target); 
                                     	 
 	          
			 document.write(d);
        </script>
					</div>
				</td>
				<td width=900>
					<iframe framespacing="0" frameborder="NO" Scrolling="auto" width=806 height=510 name="mywin" id="IFRM_LEFT_BOTTOM" src="<%=contextPath%>/new.html"></iframe>
				</td>
			</tr>
		</table>
	</body>
</html>
