<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- 公共静态文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
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
			
			<div class="listboxlist">
			<div class="listboxtitle">查询结果</div>
			<span id="showTbl"></span>
			<table class="tb02" width="100%">
				
				<tr>
					<td>本月可订购次数</td>
					<td>本月已订购次数</td>
					<td>本月剩余订购次数</td>
				</tr>
				<tr>
					<td>
						<s:if test="max > 0">
							<s:property value="max"/>
						</s:if>
						<s:else>
							无订购次数限制
						</s:else>
					</td>
					<td><s:property value="count"/></td>
					<td>
						<s:if test="max > 0">
							<s:property value="remain"/>
						</s:if>
						<s:else>
							&nbsp
						</s:else>
					</td>
				</tr>
			</table>
            <br>
            <!--帮助信息开始-->
            <div class="column">
                 <div class="listboxtitle">功能说明：</div>
                 <div class="reminder"> <p>订购次数信息查询。</p> </div>
            </div>
            <div class="column">
                 <div class="listboxtitle">温馨提醒：</div>
                 <div class="reminder">
					 <p>进入该功能页面时系统默认查询时间为当前月。</p>
                  </div>
            </div>
          </div>
		</div>
		<!--标准内容结束-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</div>
</body>
<%@include file="/common/meta_js.jsp"%>
</html>