<%@ page language="java" import="java.util.*,java.text.*,com.gmcc.pboss.biz.info.rewardtd.monthremuneration.support.*"  contentType="application/vnd.ms-excel;charset=GB2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
List<MonthRemuneration> retlist=(List<MonthRemuneration>)request.getAttribute("retlist")==null?new ArrayList<MonthRemuneration>():(List<MonthRemuneration>)request.getAttribute("retlist");
WayrewardOther info=request.getAttribute("info")==null?new WayrewardOther():(WayrewardOther)request.getAttribute("info");
String fileName = (String)request.getAttribute("fileName");
response.setHeader("Content-Disposition","inline;filename=\"" + 
        new String(fileName.getBytes("GB2312"), "ISO-8859-1") + "\"");
 %>

<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:x="urn:schemas-microsoft-com:office:excel"
xmlns="http://www.w3.org/TR/REC-html40">
<link rel="File-List" href="Page.files/filelist.xml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<meta name="ProgId" content="Excel.Sheet">
<meta name="Generator" content="Microsoft Excel 11">
<style>
.xl68
	{mso-style-parent:style0;
	font-weight:700;
	text-align:center;
	border:.5pt solid windowtext;
	background:#E4DFEC;
	mso-pattern:black none;
	white-space:normal;}
.xl69
	{mso-style-parent:style0;
	text-align:center;
	border:.5pt solid windowtext;
	white-space:normal;}
.xl70
	{mso-style-parent:style0;
	text-align:center;
	border:.5pt solid windowtext;
	background:#FCD5B4;
	mso-pattern:black none;
	white-space:normal;}
.xl83
	{mso-style-parent:style0;
	color:red;
	font-size:12.0pt;
	font-weight:700;
	text-align:center;
	border:.5pt solid windowtext;
	background:#B7DEE8;
	mso-pattern:black none;
	white-space:normal;}
.xl87
	{mso-style-parent:style0;
	color:red;
	font-weight:700;
	text-align:center;
	border:.5pt solid windowtext;
	background:#8DB4E2;
	mso-pattern:black none;
	white-space:normal;}
</style>
</head>

<body>
<!--[if !excel]>　　<![endif]-->
<!--下列信息由 Microsoft Office Excel 的“发布为网页”向导生成。-->
<!--如果同一条目从 Excel 中重新发布，则所有位于 DIV 标记之间的信息均将被替换。-->
<!----------------------------->
<!--“从 EXCEL 发布网页”向导开始-->
<!----------------------------->

<div id="内容" align="center" x:publishsource="Excel">

<s:if test="retlist.size>0">
			 <table  class = "tb_comn" width="100%" >
			 <thead >
 <tr height=36 style='mso-height-source:userset;height:27.0pt'>
  <td rowspan=3 height=63 class=xl87 style='height:47.25pt;border-top:
  none'>酬金结算月</td>
  <td rowspan=2 colspan=5 class=xl83 style='border-left:none'>酬金项</td>
  <td colspan=24 class=xl83 style='border-left:none'>业务发生月</td>
 </tr>
 <tr> 
 <td colspan=3 class=xl68 style='border-left:none'><%=info.getRwmon7() %></td>
  <td colspan=3 class=xl68 style='border-left:none'><%=info.getRwmon6() %></td>
  <td colspan=3 class=xl68 style='border-left:none'><%=info.getRwmon5() %></td>
  <td colspan=3 class=xl68 style='border-left:none'><%=info.getRwmon4() %></td>
  <td colspan=3 class=xl68 style='border-left:none'><%=info.getRwmon3() %></td>
  <td colspan=3 class=xl68 style='border-left:none'><%=info.getRwmon2() %></td>
  <td colspan=3 class=xl68 style='border-left:none'><%=info.getRwmon1() %></td>
  <td colspan=3 class=xl83 style='border-top:none'>合计</td>
  </tr>
 <tr height=27 style='mso-height-source:userset;height:20.25pt'>
  <td height=27 class=xl83  style='height:20.25pt;
  border-left:none'>客户类型</td>
   <td height=27 class=xl83  style='height:20.25pt;
  border-left:none'>具体酬金业务</td>
   <td height=27 class=xl83  style='height:20.25pt;
  border-left:none'>考核细项</td>
   <td height=27 class=xl83  style='height:20.25pt;
  border-left:none'>酬金期数</td>
   <td height=27 class=xl83  style='height:20.25pt;
  border-left:none'>单笔酬金标准</td>
  <td class=xl68 style='border-top:none;border-left:none'>业务发生量</td>
  <td class=xl68 style='border-top:none;border-left:none'>考核通过量</td>
  <td class=xl68 style='border-top:none;border-left:none'>应发酬金额</td>
  <td class=xl68 style='border-top:none;border-left:none'>业务发生量</td>
  <td class=xl68 style='border-top:none;border-left:none'>考核通过量</td>
  <td class=xl68 style='border-top:none;border-left:none'>应发酬金额</td> 
   <td class=xl68 style='border-top:none;border-left:none'>业务发生量</td>
  <td class=xl68 style='border-top:none;border-left:none'>考核通过量</td>
  <td class=xl68 style='border-top:none;border-left:none'>应发酬金额</td> 
   <td class=xl68 style='border-top:none;border-left:none'>业务发生量</td>
  <td class=xl68 style='border-top:none;border-left:none'>考核通过量</td>
  <td class=xl68 style='border-top:none;border-left:none'>应发酬金额</td>  
  <td class=xl68 style='border-top:none;border-left:none'>业务发生量</td>
  <td class=xl68 style='border-top:none;border-left:none'>考核通过量</td>
  <td class=xl68 style='border-top:none;border-left:none'>应发酬金额</td>  
  <td class=xl68 style='border-top:none;border-left:none'>业务发生量</td>
  <td class=xl68 style='border-top:none;border-left:none'>考核通过量</td>
  <td class=xl68 style='border-top:none;border-left:none'>应发酬金额</td>  
  <td class=xl68 style='border-top:none;border-left:none'>业务发生量</td>
  <td class=xl68 style='border-top:none;border-left:none'>考核通过量</td>
  <td class=xl68 style='border-top:none;border-left:none'>应发酬金额</td>
  <td class=xl68 style='border-top:none;border-left:none'>总考核业务量</td>
    <td class=xl68 style='border-top:none;border-left:none'>总考核通过量</td>
  <td class=xl68 style='border-top:none;border-left:none'>总结酬金额</td>
 </tr>
 </thead>
  <%
      	//循环输出商品
     	for(int i=0;i<retlist.size();i++){
     		MonthRemuneration monthRemuneration=retlist.get(i);
     %>

     <tr align="center" style='mso-height-source:userset;height:20.25pt'>
     
     <%
      	if(monthRemuneration.getRwmonCount() > 0){
     %>	
     <td rowspan="<%=monthRemuneration.getRwmonCount() %>" height=27 class=xl83  style='height:20.25pt;border-left:none'><%=monthRemuneration.getRwmon() %></td>
 	 <%
      	}
      	if(monthRemuneration.getCusttypeCount() > 0){
     %>
 	 <td rowspan="<%=monthRemuneration.getCusttypeCount() %>" height=27 class=xl70  style='height:20.25pt; border-left:none'><%=monthRemuneration.getCusttype() %></td>
       <%
      	
      	}	
      	if(monthRemuneration.getRwtypenameCount() > 0){
     %>
      <td rowspan="<%=monthRemuneration.getRwtypenameCount() %>" height=27 class=xl70  style='height:20.25pt;border-left:none'><%=monthRemuneration.getRwtypename() %></td>
       <%
      	
      	}	
      	if(monthRemuneration.getChkitemnameCount() > 0){
     %>
      
     <td rowspan="<%=monthRemuneration.getChkitemnameCount() %>" height=27 class=xl70  style='height:20.25pt; border-left:none'><%=monthRemuneration.getChkitemname() %></td>
    <%
      	}	
     %>
     <td height=27 class=xl70  style='height:20.25pt; border-left:none'><%=monthRemuneration.getPeriod() %></td>
     <td height=27 class=xl70  style='height:20.25pt; border-left:none'><%=monthRemuneration.getRwstd() %></td>
  <td class=xl69 style='height:20.25pt;border-left:none'><%=monthRemuneration.getTbusicnt7() %></td>
  <td class=xl69 style='height:20.25pt;border-left:none'><%=monthRemuneration.getTpasscnt7() %></td>
  <td class=xl69 style='height:20.25pt;border-left:none'><%=monthRemuneration.getTrwmoney7() %></td>
  <td class=xl69 style='height:20.25pt;border-left:none'><%=monthRemuneration.getTbusicnt6() %></td>
  <td class=xl69 style='height:20.25pt;border-left:none'><%=monthRemuneration.getTpasscnt6() %></td>
  <td class=xl69 style='height:20.25pt;border-left:none'><%=monthRemuneration.getTrwmoney6() %></td>
  <td class=xl69 style='height:20.25pt;border-left:none'><%=monthRemuneration.getTbusicnt5() %></td>
  <td class=xl69 style='height:20.25pt;border-left:none'><%=monthRemuneration.getTpasscnt5() %></td>
  <td class=xl69 style='height:20.25pt;border-left:none'><%=monthRemuneration.getTrwmoney5() %></td>
  <td class=xl69 style='height:20.25pt;border-left:none'><%=monthRemuneration.getTbusicnt4() %></td>
  <td class=xl69 style='height:20.25pt;border-left:none'><%=monthRemuneration.getTpasscnt4() %></td>
  <td class=xl69 style='height:20.25pt;border-left:none'><%=monthRemuneration.getTrwmoney4() %></td>
  <td class=xl69 style='height:20.25pt;border-left:none'><%=monthRemuneration.getTbusicnt3() %></td>
  <td class=xl69 style='height:20.25pt;border-left:none'><%=monthRemuneration.getTpasscnt3() %></td>
  <td class=xl69 style='height:20.25pt;border-left:none'><%=monthRemuneration.getTrwmoney3() %></td>
   <td class=xl69 style='height:20.25pt;border-left:none'><%=monthRemuneration.getTbusicnt2() %></td>
  <td class=xl69 style='height:20.25pt;border-left:none'><%=monthRemuneration.getTpasscnt2() %></td>
  <td class=xl69 style='height:20.25pt;border-left:none'><%=monthRemuneration.getTrwmoney2() %></td>
  <td class=xl69 style='height:20.25pt;border-left:none'><%=monthRemuneration.getTbusicnt1() %></td>
  <td class=xl69 style='height:20.25pt;border-left:none'><%=monthRemuneration.getTpasscnt1() %></td>
  <td class=xl69 style='height:20.25pt;border-left:none'><%=monthRemuneration.getTrwmoney1() %></td>
  <td class=xl69 style='height:20.25pt;border-left:none'><%=monthRemuneration.getSumbusicnt() %></td>
  <td class=xl69 style='height:20.25pt;border-left:none'><%=monthRemuneration.getSumpasscnt() %></td>
  <td class=xl69 style='height:20.25pt;border-left:none'><%=monthRemuneration.getSumrwmoney() %></td>
 </tr>
   <%
     	}
      %>
    <tr align="center" style='mso-height-source:userset;height:20.25pt'>
  
   <td colspan="5" height=27 class=xl70  style='height:20.25pt; border-left:none'>酬金合计</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getTrwmoney7() %></td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getTrwmoney6() %></td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getTrwmoney5() %></td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getTrwmoney4() %></td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getTrwmoney3() %></td>
   <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getTrwmoney2() %></td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getTrwmoney1() %></td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
    <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getSumrwmoney() %></td>
 </tr>
 <tr align="center" style='mso-height-source:userset;height:20.25pt'>
  
   <td colspan="5" height=27 class=xl70  style='height:20.25pt; border-left:none'>其他酬金合计</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
   <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
    <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getOtherrwmoney() %></td>
 </tr>
 <tr align="center" style='mso-height-source:userset;height:20.25pt'>
  
   <td colspan="5" height=27 class=xl70  style='height:20.25pt; border-left:none'>合计</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
   <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
    <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getSumpaymoney1() %></td>
 </tr>
</table>
	</s:if>	
</div>


<!----------------------------->
<!--“从 EXCEL 发布网页”向导结束-->
<!----------------------------->
</body>

</html>