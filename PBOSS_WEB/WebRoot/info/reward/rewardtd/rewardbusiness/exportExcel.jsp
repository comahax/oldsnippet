<%@ page language="java" import="java.util.*,java.text.*,com.gmcc.pboss.biz.info.rewardtd.rewardbusiness.support.*"  contentType="application/vnd.ms-excel;charset=GB2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
List<RewardBusiness> retlist=(List<RewardBusiness>)request.getAttribute("retlist")==null?new ArrayList<RewardBusiness>():(List<RewardBusiness>)request.getAttribute("retlist");
RewardBusinessOther info=request.getAttribute("info")==null?new RewardBusinessOther():(RewardBusinessOther)request.getAttribute("info");
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
<!--[if !excel]>����<![endif]-->
<!--������Ϣ�� Microsoft Office Excel �ġ�����Ϊ��ҳ�������ɡ�-->
<!--���ͬһ��Ŀ�� Excel �����·�����������λ�� DIV ���֮�����Ϣ�������滻��-->
<!----------------------------->
<!--���� EXCEL ������ҳ���򵼿�ʼ-->
<!----------------------------->

<div id="����" align="center" x:publishsource="Excel">
	<s:if test="retlist.size>0">
			 <table  class = "tb_comn" width="100%" >
			 <thead >
  <tr height=36 style='mso-height-source:userset;height:27.0pt'>
  <td rowspan=3 height=63 class=xl87 style='height:47.25pt;border-top:
  none'>��������</td>
  <td rowspan=2 colspan=6 class=xl83 style='border-left:none'>�����</td>
  <td colspan=14 class=xl83 style='border-left:none'>ҵ������</td>
 </tr>
 <tr> 
  <td colspan=2 class=xl68 style='border-left:none'><%=info.getOprmon1() %></td>
  <td colspan=2 class=xl68 style='border-left:none'><%=info.getOprmon2() %></td>
  <td colspan=2 class=xl68 style='border-left:none'><%=info.getOprmon3() %></td>
  <td colspan=2 class=xl68 style='border-left:none'><%=info.getOprmon4() %></td>
  <td colspan=2 class=xl68 style='border-left:none'><%=info.getOprmon5() %></td>
  <td colspan=2 class=xl68 style='border-left:none'><%=info.getOprmon6() %></td>
  <td colspan=2 class=xl68 style='border-left:none'><%=info.getOprmon7() %></td>
  </tr>
 <tr height=27 style='mso-height-source:userset;height:20.25pt'>
  <td height=27 class=xl83  style='height:20.25pt;
  border-left:none'>�ͻ�����</td>
   <td height=27 class=xl83  style='height:20.25pt;
  border-left:none'>������ҵ��</td>
   <td height=27 class=xl83  style='height:20.25pt;
  border-left:none'>����ϸ��</td>
   <td height=27 class=xl83  style='height:20.25pt;
  border-left:none'>���ʺϼƳ������</td>
   <td height=27 class=xl83  style='height:20.25pt;
  border-left:none'>ҵ����</td>
  <td height=27 class=xl83  style='height:20.25pt;
  border-left:none'>�ɼƳ���ܶ�</td>
  <td class=xl68 style='border-top:none;border-left:none'>������/��׼</td>
  <td class=xl68 style='border-top:none;border-left:none'>���³����</td>
  <td class=xl68 style='border-top:none;border-left:none'>������/��׼</td>
  <td class=xl68 style='border-top:none;border-left:none'>���³����</td> 
  <td class=xl68 style='border-top:none;border-left:none'>������/��׼</td>
  <td class=xl68 style='border-top:none;border-left:none'>���³����</td>
  <td class=xl68 style='border-top:none;border-left:none'>������/��׼</td>
  <td class=xl68 style='border-top:none;border-left:none'>���³����</td> 
  <td class=xl68 style='border-top:none;border-left:none'>������/��׼</td>
  <td class=xl68 style='border-top:none;border-left:none'>���³����</td> 
  <td class=xl68 style='border-top:none;border-left:none'>������/��׼</td>
  <td class=xl68 style='border-top:none;border-left:none'>���³����</td> 
  <td class=xl68 style='border-top:none;border-left:none'>������/��׼</td>
  <td class=xl68 style='border-top:none;border-left:none'>���³����</td>
 </tr>
 </thead>
  <%
      	//ѭ�������Ʒ
     	for(int i=0;i<retlist.size();i++){
     		RewardBusiness rewardBusiness =retlist.get(i);
     %>
     <tr align="center" style='mso-height-source:userset;height:20.25pt'>
    
      <%
      	if(rewardBusiness.getOprmonCount() > 0){
     %>	
     <td rowspan="<%=rewardBusiness.getOprmonCount() %>" height=27 class=xl83  style='height:20.25pt;border-left:none'><%=rewardBusiness.getOprmon() %></td>
 	
 	 <%
      	}
      	if(rewardBusiness.getCusttypeCount() > 0){
     %>
 	 <td rowspan="<%=rewardBusiness.getCusttypeCount() %>" height=27 class=xl70  style='height:20.25pt; border-left:none'><%=rewardBusiness.getCusttype() %></td>
       <%
      	}
      	if(rewardBusiness.getRwtypenameCount() > 0){
     %>
      <td rowspan="<%=rewardBusiness.getRwtypenameCount() %>" height=27 class=xl70  style='height:20.25pt;border-left:none'><%=rewardBusiness.getRwtypename() %></td>
       <%
      	}
      	if(rewardBusiness.getChkitemnameCount() > 0){
     %>
      
     <td rowspan="<%=rewardBusiness.getChkitemnameCount() %>" height=27 class=xl70  style='height:20.25pt; border-left:none'><%=rewardBusiness.getChkitemname() %></td>
      <%
      	}
     %>
     <td height=27 class=xl70  style='height:20.25pt; border-left:none'><%=rewardBusiness.getRwhlvl() %></td>
     <td height=27 class=xl70  style='height:20.25pt; border-left:none'><%=rewardBusiness.getBusicnt() %></td>
     <td height=27 class=xl70  style='height:20.25pt; border-left:none'><%=rewardBusiness.getMaxrwmoney() %></td>
  <td class=xl69 style='border-top:none;border-left:none'><%=rewardBusiness.getTrwstd1() %></td>
  <td class=xl69 style='border-top:none;border-left:none'><%=rewardBusiness.getTrwmoney1() %></td>
  <td class=xl69 style='border-top:none;border-left:none'><%=rewardBusiness.getTrwstd2() %></td>
  <td class=xl69 style='border-top:none;border-left:none'><%=rewardBusiness.getTrwmoney2() %></td>
 <td class=xl69 style='border-top:none;border-left:none'><%=rewardBusiness.getTrwstd3() %></td>
  <td class=xl69 style='border-top:none;border-left:none'><%=rewardBusiness.getTrwmoney3() %></td>
  <td class=xl69 style='border-top:none;border-left:none'><%=rewardBusiness.getTrwstd4() %></td>
  <td class=xl69 style='border-top:none;border-left:none'><%=rewardBusiness.getTrwmoney4() %></td>
 <td class=xl69 style='border-top:none;border-left:none'><%=rewardBusiness.getTrwstd5() %></td>
  <td class=xl69 style='border-top:none;border-left:none'><%=rewardBusiness.getTrwmoney5() %></td>
   <td class=xl69 style='border-top:none;border-left:none'><%=rewardBusiness.getTrwstd6() %></td>
  <td class=xl69 style='border-top:none;border-left:none'><%=rewardBusiness.getTrwmoney6() %></td>
 <td class=xl69 style='border-top:none;border-left:none'><%=rewardBusiness.getTrwstd7() %></td>
  <td class=xl69 style='border-top:none;border-left:none'><%=rewardBusiness.getTrwmoney7() %></td>
 </tr>
    <%
     	}
      %>
    <tr align="center" style='mso-height-source:userset;height:20.25pt'>
  
  <td colspan="6" height=27 class=xl70  style='height:20.25pt; border-left:none'>���ϼ�</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getTrwmoney1()%></td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getTrwmoney2() %></td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getTrwmoney3() %></td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getTrwmoney4() %></td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getTrwmoney5() %></td>
   <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getTrwmoney6() %></td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getTrwmoney7() %></td>
 </tr>
 
</table>
	</s:if>	
</div>


<!----------------------------->
<!--���� EXCEL ������ҳ���򵼽���-->
<!----------------------------->
</body>

</html>