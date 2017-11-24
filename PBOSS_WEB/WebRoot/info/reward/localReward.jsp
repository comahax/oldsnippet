<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="fun" uri="/fun-tags" %>
<%@ include file="/common/jspHead.jsp"%>
<%@page import="java.util.List,java.util.ArrayList" %>
<html>
<head>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
<jsp:useBean id="constants"  class="com.gmcc.pboss.common.dictionary.ConstantsType" />
<c:set var="fmtNumber" value ="#0.00"/>
<c:set var="TYPEDTL" value ="${constants.RPWDLocalRPT}"/>
<!-- ����CSS //-->
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
	<!-- ͷ�� -->
	<%@ include file="/common/include/inc_head.jsp"%>	
	<!--��׼���ݿ�ʼ-->
	<div class="divspan">
			<!-- ��������-->
		<%@ include file="/common/include/inc_menu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">�����ڵ�λ�ã�</span><span class="font_breadcrumb">${location}</span>
			</div>
			<s:form action="/reward/localReward.do" method="POST" id="frmQuery" onsubmit="return doSubmit();">
			<div class="listboxtitle">������������������</div>
				<table class = "tb02" width="100%">
                  <tr>
                    <td  class="tableTitle" width="15%">�����·ݣ�</td>
                    <td width="35%"><s:if test="%{!confirmAction}">
					<select name="parameter.month" class="select_3L" id="selMonth" orgval="${parameter.month}"></select></s:if><s:else>
						${parameter.month}
					</s:else>
					</td>
                    <td class="tableTitle" width="15%">�������ͣ�</td>
                    <td><s:select list="reportType" cssClass="select_4L" name="parameter.rewardtype" id="rewardtype"/></td>
                  </tr>
                  <tr>
                    <td class="tableTitle">�������ƣ�</td>
                    <td align="left">${logMember.channel.wayname}</td>
                    <td class="tableTitle">�������룺</td>
                    <td align="left">${logMember.channel.wayid}</td>
                  </tr>
                  <tr id="mobleLocal" style="display:${parameter.rewardtype eq TYPEDTL?'block':'none'}">
                    <td class="tableTitle">�ֻ�����</td>
                    <td align="left" colspan="3"><INPUT TYPE="text" class="text_01"  NAME="parameter.opermobile" id="opermobile" value="${parameter.opermobile}" maxlength="11"><INPUT TYPE="hidden"  NAME="parameter.no" id="pageNo" value="${parameter.no}" ></td>
                  </tr>
                  <tr>
                    <td valign="top" class="tableTitle">&nbsp;</td>
                    <td align="left" colspan="3">
                        <input name="btnQuery" type="submit" id="btnQuery" value="��ѯ" class="btn_blue_75" disabled="disabled" />&nbsp;&nbsp;
                        <input name="btnRest" type="button" id="btnRest" value="����" class="btn_blue_75" disabled="disabled"/>
					</td>
                  </tr>
                </table>
			</s:form>
<s:if test="%{query}">
   <c:choose>
   <c:when test="${!(parameter.rewardtype eq TYPEDTL)}"><%-- ����ϸ��ѯ --%>
		<s:if test="%{servResult.success}">
		<div class="listboxtitle">${fun:getRewardtypehName(parameter.rewardtype)}</div>
		<s:if test="parameter.rewardtype != 'RRWDSumRPT'"> 
            
            <table ID="table1" class="tb_comn" width="100%" border="0" >
            <thead>
              <tr id="tr01">
                <td rowspan="2" class="tableTitle" >�ֹ�˾</td>
                <td rowspan="2" class="tableTitle" >������</td>
                 <td rowspan="2"   class="tableTitle">�����Ǽ�</td>
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
	    <s:else><%-- ���������ܱ�--%>
	    	  <div class="subTitle">������Ϣ</div>
            <table width="100%" border="0" class="tb02">
              <tr>
                <td class="tableTitle" width="20%">�ֹ�˾</td>
                <td width="30%"><span class="font_orange">${rewardLocal.cityname}</span></td>
                <td class="tableTitle" width="20%">������</td>
                <td width="30%"><span class="font_orange">${rewardLocal.localname}</span></td>
              </tr>
              <tr>
                <td class="tableTitle">��������</td>
                <td><span class="font_orange">${logMember.channel.wayid}</span></td>
                <td class="tableTitle">�����Ǽ�</td>
                <td><span class="font_orange">${fun:getStarlevelName(rewardLocal.starlevel)}</span></td>
              </tr>
              <tr>
                <td class="tableTitle">��������</td>
                <td colspan="3"><span class="font_orange">${logMember.channel.wayname}</span></td>
              </tr>
            </table>
            <div class="subTitle">${parameter.zhmonth}�����Ϣ</div>
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
            
            <div class="subTitle">${parameter.zhmonth}Ӧ�ճ����ϸ</div>
            <table width="100%" border="0" class="tb02">
            	<thead>
            	<tr id="tr01">
                	<td colspan="2" width="40%" align="center" class="tableTitle" >�����Ŀ</td>
                	<td width="30%" align="center" class="tableTitle" >������</td>
                	<td width="30%" align="center" class="tableTitle" >�Ƴ���ϸ</td>
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
	                		 <a href="javascript:window.location='/reward/localRewardDtl.do?parameter.rewardtype=RPWDLocalRPT&parameter.type=${rewardLocal.datas[thisSeq].type}&parameter.month=${parameter.month}'" ><span class="font_orange">�����ϸ</span></a>
	                	</c:if> 
	                </td>
	              </tr>
	              </s:if>
              </s:iterator>
              <tr>
                	<td colspan="2" align="center" class="tableTitle" >�ϼ�</td>
                	<td   class="tableTitle" ><span class="font_orange">
                		<script  type="text/JavaScript">
                 				document.write(tol);
                 		</script></span>
                	</td>
                	<td   class="tableTitle" >&nbsp;</td>
                </tr>
            </table>
            <div class="subTitle" style="text-align: right;">��ѯ���ڣ�<fmt:formatDate pattern="yyyy��MM��dd��" value="${parameter.nowDate}"/>
            </div>
         <div class="subTitle">��ע��</div>
         <table width="100%" border="0" class="tb02">
         <tr><td>
	         1�����³������ + ����Ӧ�ճ�� - ���´���˰�� = ����ʵ�ճ�� + ���³������<br>
	         2�������³�����ָ�ۼ������³��صĽ�����<br>
	         3��������Ӧ�ճ��ָ���²����ĳ��<br>
	         4��������ʵ�ճ��ָ����ʵ���յ��ĳ��<br>
	         5�������³�����ָ�ۼ������³��صĽ�����<br>
	         6�� ��վ�ɲ�ѯ��6���³������
         </td></tr>
        </table>
	    </s:else>
		</s:if>
		<s:else>
			${message}
		</s:else>
	<%-- ����ϸ��ѯ --%>
   </c:when><c:otherwise><%-- ��ϸ��ѯ --%><c:set var="qryRslt" value="${servResult.retResult}"/>
		<div class="listboxtitle">${fun:getRewardtypehName(parameter.rewardtype )}��</div>
			<table class = "tb_comn" width="100%">
				<thead>
					<tr>
						 <td>�����·�</td>
						 <td>�Ƴ����</td>
						 <td>�������</td>
						 <td>ʧ��ԭ��</td>
						 <%--<td>�����</td>--%>
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
	�ܼ�<FONT color=red>${qryRslt.page.numbers}</FONT>ҳ,��${qryRslt.page.rows}��¼&nbsp;
	��ǰ��<FONT color=red>${qryRslt.page.current}</FONT>ҳ<c:if test="${qryRslt.page.current >1}">
	<A style="TEXT-DECORATION: none" href="#" onclick="doDtlPage(1)"><IMG alt="��һҳ" src="/images/frist.gif" border=0></A> 
	<A style="TEXT-DECORATION: none" href="#" onclick="doDtlPage(${qryRslt.page.current-1})"><IMG alt="ǰһҳ" src="/images/pre.gif" border=0></A></c:if><c:if test="${qryRslt.page.current < qryRslt.page.numbers}">
	<A style="TEXT-DECORATION: none" href="#" onclick="doDtlPage(${qryRslt.page.current+1})"><IMG alt="��һҳ" src="/images/next.gif" border=0></A>
	<A style="TEXT-DECORATION: none" href="#" onclick="doDtlPage(${qryRslt.page.numbers})"><IMG alt="���һҳ" src="/images/last.gif" border=0></A> </c:if>&nbsp; 
	</TD></TR><!--/TBODY--></TABLE>
   <%-- ��ϸ��ѯ --%>
</c:otherwise></c:choose>
</s:if>
	<!--������Ϣ��ʼ-->
	<div class="column">
         <div class="listboxtitle">����˵����</div>
         <div class="reminder">
          ����ѯ�� </div>
       </div>
       <div class="column">
         <div class="listboxtitle">��ܰ���ѣ�</div>
         <div class="reminder">
           <p>1��ÿ����ֻ�����ϸ��µĳ��</p>
           <p>2�������·ݺͱ������ͱ���ѡ��</p>
          </div>
       </div>
     <!--������Ϣ����-->
	  </div>
		<!--��׼���ݽ���-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</div>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/validation/jquery.validation.js"></script> 
<script type="text/javascript" src="${ctx}/js/jQuery/validation/common.js"></script> 
<script type="text/javascript" src="${ctx}/js/biz/info/reward/rewardlocal.js"></script> 
<SCRIPT LANGUAGE="JavaScript">
<!--
	var taskId='${taskID}'//������ϢID
	var TYPEDTL = '${TYPEDTL}';//��ϸ�������ͱ�ʶ�������̶����޸�ע�⣩
//-->
</SCRIPT>
</html>