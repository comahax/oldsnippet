<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
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
			
			<div class="listboxlist">
			<div class="listboxtitle">��ѯ���</div>
			<span id="showTbl"></span>
			<table class="tb02" width="100%">
				
				<tr>
					<td>���¿ɶ�������</td>
					<td>�����Ѷ�������</td>
					<td>����ʣ�ඩ������</td>
				</tr>
				<tr>
					<td>
						<s:if test="max > 0">
							<s:property value="max"/>
						</s:if>
						<s:else>
							�޶�����������
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
            <!--������Ϣ��ʼ-->
            <div class="column">
                 <div class="listboxtitle">����˵����</div>
                 <div class="reminder"> <p>����������Ϣ��ѯ��</p> </div>
            </div>
            <div class="column">
                 <div class="listboxtitle">��ܰ���ѣ�</div>
                 <div class="reminder">
					 <p>����ù���ҳ��ʱϵͳĬ�ϲ�ѯʱ��Ϊ��ǰ�¡�</p>
                  </div>
            </div>
          </div>
		</div>
		<!--��׼���ݽ���-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</div>
</body>
<%@include file="/common/meta_js.jsp"%>
</html>