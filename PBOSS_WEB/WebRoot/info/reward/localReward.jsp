<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="fun" uri="/fun-tags" %>
<%@ include file="/common/jspHead.jsp"%>
<%@page import="java.util.List,java.util.ArrayList" %>
<html>
<head>
<!-- 公共静态文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
<jsp:useBean id="constants"  class="com.gmcc.pboss.common.dictionary.ConstantsType" />
<c:set var="fmtNumber" value ="#0.00"/>
<c:set var="TYPEDTL" value ="${constants.RPWDLocalRPT}"/>
<!-- 本地CSS //-->
<style>
.tb02 th{
	background-color: #bcd2e9;
	border: 1px solid #bcd2e9;
	color: #0073C8;
	line-height:18px;
	padding:2px;
}
.tb02 td.dtl{
	text-align:center;
}
.tb02 td.baseContext{
	TEXT-INDENT: 15px;
}
</style>
 <script language="JavaScript" type="text/JavaScript">
 	var tol=0;           
 </script>
</head>
<body>
	<!-- 头部 -->
	<%@ include file="/common/include/inc_head.jsp"%>	
	<!--标准内容开始-->
	<div class="divspan">
			<!-- 左则功能区-->
		<%@ include file="/common/include/inc_menu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">您现在的位置：</span><span class="font_breadcrumb">${location}</span>
			</div>
			<s:form action="/reward/localReward.do" method="POST" id="frmQuery" onsubmit="return doSubmit();">
			<div class="listboxtitle">社会渠道网点基础资料</div>
				<table class = "tb02" width="100%">
                  <tr>
                    <td  class="tableTitle" width="15%">结算月份：</td>
                    <td width="35%"><s:if test="%{!confirmAction}">
					<select name="parameter.month" class="select_3L" id="selMonth" orgval="${parameter.month}"></select></s:if><s:else>
						${parameter.month}
					</s:else>
					</td>
                    <td class="tableTitle" width="15%">报表类型：</td>
                    <td><s:select list="reportType" cssClass="select_4L" name="parameter.rewardtype" id="rewardtype"/></td>
                  </tr>
                  <tr>
                    <td class="tableTitle">渠道名称：</td>
                    <td align="left">${logMember.channel.wayname}</td>
                    <td class="tableTitle">渠道编码：</td>
                    <td align="left">${logMember.channel.wayid}</td>
                  </tr>
                  <tr id="mobleLocal" style="display:${parameter.rewardtype eq TYPEDTL?'block':'none'}">
                    <td class="tableTitle">手机号码</td>
                    <td align="left" colspan="3"><INPUT TYPE="text" class="text_01"  NAME="parameter.opermobile" id="opermobile" value="${parameter.opermobile}" maxlength="11"><INPUT TYPE="hidden"  NAME="parameter.no" id="pageNo" value="${parameter.no}" ></td>
                  </tr>
                  <tr>
                    <td valign="top" class="tableTitle">&nbsp;</td>
                    <td align="left" colspan="3">
                        <input name="btnQuery" type="submit" id="btnQuery" value="查询" class="btn_blue_75" disabled="disabled" />&nbsp;&nbsp;
                        <input name="btnRest" type="button" id="btnRest" value="重置" class="btn_blue_75" disabled="disabled"/>
					</td>
                  </tr>
                </table>
			</s:form>
<s:if test="%{query}">
   <c:choose>
   <c:when test="${!(parameter.rewardtype eq TYPEDTL)}"><%-- 非明细查询 --%>
		<s:if test="%{servResult.success}">
		<div class="listboxtitle">${fun:getRewardtypehName(parameter.rewardtype)}</div>
		<s:if test="parameter.rewardtype != 'RRWDSumRPT'"> 
            
            <table ID="table1" class="tb_comn" width="100%" border="0" >
            <thead>
              <tr id="tr01">
                <td rowspan="2" class="tableTitle" >分公司</td>
                <td rowspan="2" class="tableTitle" >服务厅</td>
                 <td rowspan="2"   class="tableTitle">渠道星级</td>
                 <s:iterator value="ttlList" status="st">
	                		<s:if test="subtitlename!=null && subtitlename!=''"> 
	                			
	                			<s:if test="#st.index==0 || ttlList.get(#st.index-1).titlename!=titlename ">
	                			 <script language="JavaScript" type="text/JavaScript">
	                			 		var n=1;
            							<c:forEach items="${ttlList}" var="tt" begin="${st.index+1}" >
            								if('${tt.titlename}'=='${titlename}'){
            									n++;
            								}
	                					</c:forEach>
            
										document.write("<td colspan='"+n+"'  class='tableTitle'>${titlename } </td>")

	       							</script>
	                				
	                				
	                			</s:if>
	                		</s:if>
	                		<s:else>
	                			<td rowspan="2" class="tableTitle">${titlename }</td>
	                		</s:else>
	             </s:iterator>
                 
              </tr>
              <tr>
              	  <s:iterator value="ttlList">
                		<s:if test="subtitlename!=null && subtitlename!=''">
                			<td class="tableTitle">${subtitlename }</td>
                		</s:if>
		           </td>
	             </s:iterator>
              </tr>
              </thead>
              <s:iterator value="rewardLocalList" >
	                 <tr align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
						
	                     <td><s:property value="cityname" /></td>
	                     <td><s:property value="localname" /></td>
	                     <td><s:property value="starlevel" /></td>
	                     <s:iterator value="valuesList" status="st">
	                     	<s:if test="valuesList.get(#st.index)!=null">
	                     		<td>${content }</td>
	                     	</s:if>
	                     </s:iterator>
	                 </tr>
	             </s:iterator>
            </table>
           
	    </s:if>
	    <s:else><%-- 渠道酬金汇总表--%>
	    	  <div class="subTitle">基本信息</div>
            <table width="100%" border="0" class="tb02">
              <tr>
                <td class="tableTitle" width="20%">分公司</td>
                <td width="30%"><span class="font_orange">${rewardLocal.cityname}</span></td>
                <td class="tableTitle" width="20%">服务厅</td>
                <td width="30%"><span class="font_orange">${rewardLocal.localname}</span></td>
              </tr>
              <tr>
                <td class="tableTitle">渠道编码</td>
                <td><span class="font_orange">${logMember.channel.wayid}</span></td>
                <td class="tableTitle">渠道星级</td>
                <td><span class="font_orange">${fun:getStarlevelName(rewardLocal.starlevel)}</span></td>
              </tr>
              <tr>
                <td class="tableTitle">渠道名称</td>
                <td colspan="3"><span class="font_orange">${logMember.channel.wayname}</span></td>
              </tr>
            </table>
            <div class="subTitle">${parameter.zhmonth}酬金信息</div>
            <table width="100%" border="0" class="tb02">
            	<s:iterator value="ttlList" status="st">
            	<c:set var="thisSeq" value="${fun:convSting(id.seq)}"/>
            	<s:if test="subtitlename==null || subtitlename==''"> 
	              <tr>
	                <td class="tableTitle" width="30%">${titlename }</td>
	                <td width="70%"><span class="font_orange">${rewardLocal.datas[thisSeq].content}</span></td>
	              </tr>
	              </s:if>
              </s:iterator>
             
            </table>
            
            <div class="subTitle">${parameter.zhmonth}应收酬金明细</div>
            <table width="100%" border="0" class="tb02">
            	<thead>
            	<tr id="tr01">
                	<td colspan="2" width="40%" align="center" class="tableTitle" >酬金项目</td>
                	<td width="30%" align="center" class="tableTitle" >结算金额</td>
                	<td width="30%" align="center" class="tableTitle" >计酬明细</td>
                </tr>
                </thead>
                 
            	<s:iterator value="ttlList" status="st">
            	<c:set var="thisSeq" value="${fun:convSting(id.seq)}"/>
                
            	<s:if test="subtitlename!=null && subtitlename!=''"> 
	              <tr>
	              	<s:if test="#st.index==0 ||ttlList.get(#st.index-1).titlename!=titlename">
	                			 <script language="JavaScript" type="text/JavaScript">
	                			 		var n=1;
            							<c:forEach items="${ttlList}" var="tt" begin="${st.index+1}" >
            								if('${tt.titlename}'=='${titlename}'){
            									n++;
            								}
	                					</c:forEach>
            
										document.write("<td rowspan='"+n+"' align='center'  class='tableTitle'>${titlename } </td>")

	       							</script>
	                				
	                				
	                </s:if>
	                <td class="tableTitle" align="center">${subtitlename }</td>
	                <td ><span class="font_orange">${rewardLocal.datas[thisSeq].content}
	                	 <script  type="text/JavaScript">
                 				tol+=Number('${rewardLocal.datas[thisSeq].content}');
                 		</script>
	                </span></td>
	                
	                <td>
	                	<c:if test="${rewardLocal.datas[thisSeq].type!=null && srewardLocal.datas[thisSeq].type!=''}">
	                		 <a href="javascript:window.location='/reward/localRewardDtl.do?parameter.rewardtype=RPWDLocalRPT&parameter.type=${rewardLocal.datas[thisSeq].type}&parameter.month=${parameter.month}'" ><span class="font_orange">点击明细</span></a>
	                	</c:if> 
	                </td>
	              </tr>
	              </s:if>
              </s:iterator>
              <tr>
                	<td colspan="2" align="center" class="tableTitle" >合计</td>
                	<td   class="tableTitle" ><span class="font_orange">
                		<script  type="text/JavaScript">
                 				document.write(tol);
                 		</script></span>
                	</td>
                	<td   class="tableTitle" >&nbsp;</td>
                </tr>
            </table>
            <div class="subTitle" style="text-align: right;">查询日期：<fmt:formatDate pattern="yyyy年MM月dd日" value="${parameter.nowDate}"/>
            </div>
         <div class="subTitle">备注：</div>
         <table width="100%" border="0" class="tb02">
         <tr><td>
	         1、上月酬金池余额 + 本月应收酬金 - 本月代扣税金 = 本月实收酬金 + 本月酬金池余额<br>
	         2、“上月酬金池余额”指累计至上月酬金池的结余金额<br>
	         3、“本月应收酬金”指本月产生的酬金<br>
	         4、“本月实收酬金”指本月实际收到的酬金<br>
	         5、“本月酬金池余额”指累计至本月酬金池的结余金额<br>
	         6、 网站可查询近6个月酬金数据
         </td></tr>
        </table>
	    </s:else>
		</s:if>
		<s:else>
			${message}
		</s:else>
	<%-- 非明细查询 --%>
   </c:when><c:otherwise><%-- 明细查询 --%><c:set var="qryRslt" value="${servResult.retResult}"/>
		<div class="listboxtitle">${fun:getRewardtypehName(parameter.rewardtype )}：</div>
			<table class = "tb_comn" width="100%">
				<thead>
					<tr>
						 <td>结算月份</td>
						 <td>计酬号码</td>
						 <td>酬金类型</td>
						 <td>失败原因</td>
						 <%--<td>酬金金额</td>--%>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${qryRslt.data }" var="dtlObj" varStatus="i">
					<tr>
						<td class="red_01">${dtlObj.rewardmonth}</td>
						<td class="red_01">${dtlObj.mobleno} </td>
						<td class="red_01">${dtlObj.type}</td>
						<td class="red_01">${dtlObj.failureexplain}</td>
						<%--<td class="red_01"><fmt:formatNumber value='${dtlObj.paymoney}' pattern='${fmtNumber}'/></td>--%>
					</tr>
				</c:forEach>
				</tbody>
			</table>
<TABLE class="page_table">
<TR vAlign="center">
	<TD align="left" height="30">&nbsp;&nbsp;</TD>
	<TD id="navigation" align="right">
	总计<FONT color=red>${qryRslt.page.numbers}</FONT>页,共${qryRslt.page.rows}记录&nbsp;
	当前第<FONT color=red>${qryRslt.page.current}</FONT>页<c:if test="${qryRslt.page.current >1}">
	<A style="TEXT-DECORATION: none" href="#" onclick="doDtlPage(1)"><IMG alt="第一页" src="/images/frist.gif" border=0></A> 
	<A style="TEXT-DECORATION: none" href="#" onclick="doDtlPage(${qryRslt.page.current-1})"><IMG alt="前一页" src="/images/pre.gif" border=0></A></c:if><c:if test="${qryRslt.page.current < qryRslt.page.numbers}">
	<A style="TEXT-DECORATION: none" href="#" onclick="doDtlPage(${qryRslt.page.current+1})"><IMG alt="下一页" src="/images/next.gif" border=0></A>
	<A style="TEXT-DECORATION: none" href="#" onclick="doDtlPage(${qryRslt.page.numbers})"><IMG alt="最后一页" src="/images/last.gif" border=0></A> </c:if>&nbsp; 
	</TD></TR><!--/TBODY--></TABLE>
   <%-- 明细查询 --%>
</c:otherwise></c:choose>
</s:if>
	<!--帮助信息开始-->
	<div class="column">
         <div class="listboxtitle">功能说明：</div>
         <div class="reminder">
          酬金查询。 </div>
       </div>
       <div class="column">
         <div class="listboxtitle">温馨提醒：</div>
         <div class="reminder">
           <p>1、每个月只结算上个月的酬金。</p>
           <p>2、结算月份和报表类型必须选择。</p>
          </div>
       </div>
     <!--帮助信息结束-->
	  </div>
		<!--标准内容结束-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</div>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/validation/jquery.validation.js"></script> 
<script type="text/javascript" src="${ctx}/js/jQuery/validation/common.js"></script> 
<script type="text/javascript" src="${ctx}/js/biz/info/reward/rewardlocal.js"></script> 
<SCRIPT LANGUAGE="JavaScript">
<!--
	var taskId='${taskID}'//待办信息ID
	var TYPEDTL = '${TYPEDTL}';//明细报表类型标识（参数固定，修改注意）
//-->
</SCRIPT>
</html>