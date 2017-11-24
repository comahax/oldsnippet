<%@ page contentType="text/html;charset=GBK" import="com.gmcc.pboss.biz.info.rewardtd.monthremuneration.support.WayrewardOther" pageEncoding="GBK"%>
<%
WayrewardOther info=request.getAttribute("info")==null?new WayrewardOther():(WayrewardOther)request.getAttribute("info");
    %>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- 公共静态文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
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
	<!-- 头部导航条 -->
<%@ include file="/common/include/inc_managerhead.jsp"%>	
<!--标准内容开始-->
<div class="divspan">
<!-- 左则功能区-->
<%@ include file="/common/include/inc_menu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">您现在的位置：</span><span class="font_breadcrumb">${location}</span>
			</div>
			
			<s:form action="/managerView/monthRemunerationAjax.do" method="POST" name="frmQuery" id="frmQuery"> 
			<div class="listboxtitle">查询条件</div>
            <table class="tb02" width="100%">
			  <tr>
				<td class="input_label" align="right">网点编码：</td>
				<td>
					<s:textfield cssClass="style_input" name="parameter.wayid" id="wayid"/>
					<font color='red'>*</font>
					<input type="button" class="" value="..." id="btnWaySelect" onclick="f_waySelect()"/>
				</td>
				<td class="input_label" align="right">结算月份：</td>
				<td>
					 <select name="parameter.rwmon" class="select_3L" id="selMonth" orgval="${parameter.rwmon}"></select>  <font color='red'>*</font>  </td>
					 
				</td>
			 </tr>
			 <tr> 
				 <td colspan="4"  align="center">
							<input name="btnQuery" type="button" id="btnQuery" value="查询" class="btn_blue_75" />&nbsp;&nbsp; 
						<input name="btnExportExcel" type="button" id="btnExportExcel" value="导出" class="btn_blue_75" />&nbsp;&nbsp;
					 </td>
				 
		 </tr> 
	  
			</table>
			</s:form>
			<div class="listboxlist">
			<div class="listboxtitle">酬金结果</div>
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
  <td class=xl68 style='border-top:none;border-left:none'>总考核业务量</td>
   <td class=xl68 style='border-top:none;border-left:none'>总考核通过量</td>
  <td class=xl68 style='border-top:none;border-left:none'>总结酬金额</td>
 </tr>
 </thead>
 <s:iterator value="retlist">
     <tr align="center" style='mso-height-source:userset;height:20.25pt'>
     <s:if test="rwmonCount > 0">	
     <td rowspan="<s:property value="rwmonCount"/>" height=27 class=xl83  style='height:20.25pt;border-left:none'><s:property value="rwmon"/></td>
 	 </s:if>
 	 
 	  <s:if test="custtypeCount > 0">	
 	 <td rowspan="<s:property value="custtypeCount"/>" height=27 class=xl70  style='height:20.25pt; border-left:none'><s:property value="custtype"/></td>
      </s:if>
      
       <s:if test="rwtypenameCount > 0">	
      <td rowspan="<s:property value="rwtypenameCount"/>" height=27 class=xl70  style='height:20.25pt;border-left:none'><s:property value="rwtypename"/></td>
      </s:if>
      
       <s:if test="chkitemnameCount > 0">	
     <td rowspan="<s:property value="chkitemnameCount"/>" height=27 class=xl70  style='height:20.25pt; border-left:none'><s:property value="chkitemname"/></td>
     </s:if>
     <td height=27 class=xl70  style='height:20.25pt; border-left:none'><s:property value="period"/></td>
     <td height=27 class=xl70  style='height:20.25pt; border-left:none'><s:property value="rwstd"/></td>

  <td class=xl69 style='border-top:none;border-left:none'><s:property value="tbusicnt5"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="tpasscnt5"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="trwmoney5"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="tbusicnt4"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="tpasscnt4"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="trwmoney4"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="tbusicnt3"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="tpasscnt3"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="trwmoney3"/></td>
   <td class=xl69 style='border-top:none;border-left:none'><s:property value="tbusicnt2"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="tpasscnt2"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="trwmoney2"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="tbusicnt1"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="tpasscnt1"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="trwmoney1"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="sumbusicnt"/></td>
    <td class=xl69 style='border-top:none;border-left:none'><s:property value="sumpasscnt"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="sumrwmoney"/></td>
 </tr>
    </s:iterator>
    <tr align="center" style='mso-height-source:userset;height:20.25pt'>
  
   <td colspan="5" height=27 class=xl70  style='height:20.25pt; border-left:none'>酬金合计</td>
 
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
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getSumpaymoney1() %></td>
 </tr>
</table>
	</s:if>		
            <br>
            <!--帮助信息开始-->
            <div class="column">
                 <div class="listboxtitle">功能说明：</div>
                   <div class="reminder">
      				  <p>1.统计各业务<font color='red'>月度应发酬金报表</font>。</p>
    				</div>
               </div>
               <div class="column">
                 <div class="listboxtitle">温馨提醒：</div>
                    <div class="reminder">
                      <p>1.查询条件中<font color='red'>“结算月份”不能为空</font>。
   				 </div>
               </div>
          </div>
		</div>
		<!--标准内容结束-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</div>
<iframe name="content" style="display: none;"></iframe>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/reward/common.js"></script>
<script type="text/javascript" src="${ctx}/js/biz/info/reward/rewardtd/monthremuneration/monthRemunerationMag.js"></script> 
<SCRIPT type="text/javascript">
function f_waySelect(){
	var url="/magSaleDetail/waySelect.do";
	var rtn=window.showModalDialog(url,null,"dialogWidth:900px; dialogHeight:450px; status:no; resizable:no;");
    if (rtn != null && rtn.length) {
	   document.getElementById("wayid").value = rtn;//[0]
	   return rtn;
	}
}

</SCRIPT>
</html>