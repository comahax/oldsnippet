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
					应久美的要求，改成3级菜单形式，所有4级菜单以标签页展示，这个菜单目录由DJ整理
				</td>
			</tr>
			<tr>
				<td width=195 style="border-right:#e3e3e3 solid 2px; font-size:12px; background:#FFFFFF; color:#000000;">
					综合帐务标签页示例程序
					<br />
					<br />
					<div style="width:195px; height:484px; overflow:auto; background:#fff; border-top:#e3e3e3 solid 2px;">
						<script type="text/javascript">
          target = "mywin"
          //d.add('100', 10, '系统管理', '','',target); 
          d = new dTree('d');      
                                              
          d.add('40', -1, '综合帐务', '');
          	  d.add('401', 40, '积分管理', '','',target);            
                  d.add('40101', 401, '客户积分管理', '<%=contextPath%>/fee/custintegral.jsp','',target); 
                  d.add('40103', 401, '公务机积分管理', '<%=contextPath%>/fee/officialintegral.jsp','',target); 
                  d.add('40102', 401, '产品号码积分管理', '<%=contextPath%>/fee/prodintegral.jsp','',target); 
              d.add('402', 40, '出帐处理', '','',target);   
              	  d.add('40202', 402, '出账设置', '<%=contextPath%>/fee/billingset.jsp','',target);                   
                  d.add('40203', 402, '出账核查', '<%=contextPath%>/fee/billingcheck.jsp','',target); 
                  d.add('40204', 402, '出账监控', '<%=contextPath%>/fee/billingmonitor.jsp','',target);    
                  d.add('40201', 402, '出帐调整', '<%=contextPath%>/fee/billingfix.jsp','',target); 
 	          d.add('403', 40, '票据管理', '','',target);      
		      	  d.add('40301', 403, '帐单定制', '<%=contextPath%>/fee/billcustomize.jsp','',target);         
                  d.add('40302', 403, '帐单打印', '<%=contextPath%>/fee/billprint.jsp','',target);      
                  d.add('40303', 403, '发票定制', '<%=contextPath%>/fee/invoicecustomize.jsp','',target);     
                  d.add('40304', 403, '发票打印', '<%=contextPath%>/fee/invoiceprint.jsp','',target);   
              d.add('404', 40, '帐务核算', '','',target);   
                  d.add('40401', 404, '帐务减免', '<%=contextPath%>/fee/billreduce.jsp','',target);     
                  d.add('40402', 404, '挂帐管理', '<%=contextPath%>/fee/handbill.jsp','',target); 
                  d.add('40403', 404, '帐务调整', '<%=contextPath%>/fee/billingadjust.jsp','',target);   
                  d.add('40404', 404, '呆坏帐处理', '<%=contextPath%>/fee/badbill.jsp','',target);                     
                  d.add('40405', 404, '梦网退费管理', '<%=contextPath%>/fee/mwbilling.jsp','',target);
              d.add('405', 40, '缴费销帐管理', '','',target);      
				  d.add('40501', 405, '销帐管理', '<%=contextPath%>/fee/woffmanage.jsp','',target);
				  d.add('40504', 405, '销帐处理', '<%=contextPath%>/fee/woffdeal.jsp','',target);
				  d.add('40502', 405, '帐本调整', '<%=contextPath%>/fee/eboxunitadj.jsp','',target);     
                  d.add('40503', 405, '滞纳金管理', '<%=contextPath%>/fee/latefee.jsp','',target);     
                  d.add('40505', 405, '帐务综合查询', '<%=contextPath%>/fee/querybyno/list.jsp','',target);     
	          d.add('406', 40, '缴费催费管理', '','',target);
              	  d.add('40601', 406, '银行划帐管理', '<%=contextPath%>/fee/realtran.jsp','',target);
				  d.add('40602', 406, '托收', '<%=contextPath%>/fee/tsdeal.jsp','',target);	
              d.add('400',  40, '信用控制管理', '','',target);   
		          d.add('40001', 400, '信控参数管理', '<%=contextPath%>/fee/creditmanage.jsp','',target);
		          d.add('40002', 400, '红名单数据管理', '<%=contextPath%>/fee/safeperiod.jsp','',target); 
		          d.add('40003', 400, '信控操作管理', '<%=contextPath%>/fee/credit.jsp','',target); 
                  d.add('40004', 400, '短信管理', '<%=contextPath%>/fee/sms.jsp','',target); 
                  d.add('40005', 400, '欠费催缴', '<%=contextPath%>/fee/ownback.jsp','',target); 
                                     	 
 	          
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
