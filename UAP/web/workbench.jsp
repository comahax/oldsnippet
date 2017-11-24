<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page  import="com.sunrise.jop.ui.struts2.WebConstant"%>
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base target="_self" /> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link rel="stylesheet" type="text/css" href="new/css/reset.css">
<link rel="stylesheet" type="text/css" href="new/css/workbench.css">
<title>工作台</title>
<script type="text/javascript">
	function tablink(name,url){
			
		window.parent.parent.openLink(name,url); 		
		
	}

</script>
</head>
<body>
<div class="top_content">
    <ul class="clearfix">
        <li class="bg_top_content bg_top_content_first">
            <ul><h3>出账进度</h3>
                <li><a href="javascript:tablink('全球通出账过程监控','fee/billing/billstatus_set.do')">全球通出账过程监控</a></li>
                <li><a href="javascript:tablink('预付费出账过程监控','fee/billing/billstatus_SetPrepaidFee.do')">预付费出账过程监控</a></li>
            </ul>
        </li>
        <li class="bg_top_content bg_top_content_second">
            <ul><h3>出账核查</h3>
                <li><a href="javascript:tablink('个人固定费核查','fee/billing/uapreq_list.do?target=GR')">固定费核查</a></li>
                <li><a href="javascript:tablink('平衡性检查','fee/billing/billlogdeta_view.do')">平衡性检查</a></li>
                <li><a href="javascript:tablink('文件下载','fee/billing/uapreqfile_list.do')">文件下载</a></li>
                <li><a href="javascript:tablink('文件上传','fee/billing/uapreqfile_listUpload.do')">文件上传</a></li>
            </ul>
        </li>
        <li class="bg_top_content bg_top_content_third">
            <ul><h3>出账调整</h3>
                <li><a href="javascript:tablink('个人固定费调整','integration.jsp?targetUrl=${menuitems["个人固定费调整"].guiobject}')">个人固定费调整</a></li>
                <li><a href="javascript:tablink('无主调整查询','integration.jsp?targetUrl=${menuitems["无主调整查询"].guiobject}')">无主调整查询</a></li>
            </ul>
        </li>
        <li class="bg_top_content bg_top_content_fouth">
            <ul><h3>统计分析</h3>
                <li><a href="javascript:tablink('统计分析','fee/billing/uapreqfile_list1.do')">统计分析</a></li>
            </ul>
        </li>
    </ul>
</div>
</body>
</html>
