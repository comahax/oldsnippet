<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<%@ page import="com.gmcc.pboss.common.dictionary.ConstantsType" %>
<%@ taglib prefix="fun" uri="/fun-tags" %>
<%@ taglib prefix="st" uri="/select-tag"%>
<html>
<head>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>

<body>
	<!-- ͷ�������� -->
	<!-- ͷ�� -->
	<%@ include file="/common/include/inc_managerhead.jsp"%>	
	<!--��׼���ݿ�ʼ-->
	<div class="divspan">
			<!-- ��������-->
		<%@ include file="/common/include/inc_menu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">�����ڵ�λ�ã�</span><span class="font_breadcrumb">${location}</span>
			</div>
			<c:if test='${fn:length(message)>0}'>
		<DIV><font color="red">������ʾ��${message}</font></DIV></c:if>
	<s:if test="%{result.data.size > 0}">
		<s:set name="emp" value="result.data[0]" />
			<div class="listboxlist">
			<div class="listboxtitle">������Ϣ</div>
			<table class="tb02" width="96%">
				<tbody>		
					<tr>
						<td class="blue_01 textRight" width="20%">������</td>
						<td class="red_01" width="30%">
						${emp.employeename}
						</td>
						<td class="blue_01 textRight" width="20%">�Ա�</td>
						<td class="red_01" width="30%">
                			<st:st className="formSelect_2L" type="<%=ConstantsType.SEX %>" selected="${emp.sex}" />
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">���֤�ţ�</td>
						<td class="red_01" width="30%">
						${emp.cardid}
						<td class="blue_01 textRight" width="20%">���᣺</td>
						<td class="red_01" width="30%">
						${emp.nativehome }
						</td>
</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">�������ڣ�</td>
						<td class="red_01" width="30%">
						<fmt:formatDate value="${emp.birthday }" type="both" pattern="yyyy-MM-dd"/>
						</td>
						<td class="blue_01 textRight" width="20%">רҵ��</td>
						<td class="red_01" width="30%">
						${emp.speciality }
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">�Ļ��̶ȣ�</td>
						<td class="red_01" width="30%">
							<st:st className="formSelect_3L" type="<%=ConstantsType.EDULEVEL %>" selected="${emp.edulevel}"/>
						</td>
						<td class="blue_01 textRight" width="20%">��ҵԺУ��</td>
						<td class="red_01" width="30%">
						${emp.gradschool}
						</td>
					</tr>
				</tbody>
			</table>
			
			<div class="listboxtitle">��ϵ��ʽ</div>
			<table class="tb02" width="96%">
				<tbody>
					<tr>
						<td class="blue_01 textRight" width="20%">ҵ������룺</td>
						<td class="red_01" width="30%">
						${emp.officetel }
						</td>
						<td class="blue_01 textRight" width="20%">���˵������䣺</td>
						<td class="red_01" width="30%">
						${emp.pvtemail }
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">��˾ר�õ������䣺</td>
						<td class="red_01" width="30%" colspan="3">
						${emp.ofcemail }
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">��ͥ��ַ��</td>
						<td class="red_01" width="30%" colspan="3">
						<textarea  readonly="true" class="textarea_01" >${emp.homeaddr }</textarea>
						</td>
					</tr>
				</tbody>
			</table>
			<div class="listboxtitle">��֯��Ϣ</div>
  			<table class="tb02" width="96%">
  				<tr>
					<td class="blue_01 textRight" width="20%">�������룺</td>
					<td class="red_01" width="30%">
					${empChannel.wayid}
					</td>
					<td class="blue_01 textRight" width="20%">�������ƣ�</td>
					<td class="red_01" width="30%">
					${empChannel.wayname}
					</td>
				</tr>
				<tr>
					<td class="blue_01 textRight" width="20%">���й�˾��</td>
					<td class="red_01" width="30%">
					${fun:getBranchName(empChannel.cityid)}
					</td>
					<td class="blue_01 textRight" width="20%">�ֹ�˾��</td>
					<td class="red_01" width="30%">
					${fun:getCountyidchName(empChannel.countyid)}
					</td>
				</tr>
				<tr>
					<td class="blue_01 textRight" width="20%">�����������ı��룺</td>
					<td class="red_01" width="30%" colspan="3">
					${empChannel.svccode}
					</td>
				</tr>
  			</table>
  			
			<div class="listboxtitle">�ù���Ϣ</div>
  			<table class="tb02" width="96%">
  				<tr>
					<td class="blue_01 textRight" width="20%">��ְʱ�䣺</td>
					<td class="red_01" width="30%">
					<fmt:formatDate value="${emp.intime }" type="both" pattern="yyyy-MM-dd"/>
					</td>
					<td class="blue_01 textRight" width="20%">�Ͷ���ϵ��</td>
					<td class="red_01" width="30%">
					<st:st className="formSelect_3L" type="<%=ConstantsType.CONTACTTYPE %>" selected="${emp.contacttype}"/>
					</td>
				</tr>
				<tr>
					<td class="blue_01 textRight" width="20%">�ù����ʣ�</td>
					<td class="red_01" width="30%">
					<st:st className="formSelect_3L" type="<%=ConstantsType.EMPLOYTYPE %>" selected="${emp.employtype}"/>
					</td>
					<td class="blue_01 textRight" width="20%">�ù�״̬��</td>
					<td class="red_01" width="30%">
					<st:st className="formSelect_3L" type="<%=ConstantsType.EMPSTATUS %>" selected="${emp.empstatus}"/>
					</td>
				</tr>
			</table>
		<div class="registryable">
			<div class="registrytitle">
				<input type="button" align="middle"  class="btn_blue"  onclick="location='/managerView/assistantList.do'" value="���ص�Ա�б�" />
	    	</div>
		</div>
     
    <!--������Ϣ��ʼ-->
	<div class="column">
		<div class="listboxtitle">����˵����</div>
         <div class="reminder">
            <p>��Ա��ϸ��Ϣչʾ�����������ء���ť�����ص�Ա�б�</p>
         </div>
       </div>
       <div class="column">
         <div class="listboxtitle">��ܰ���ѣ�</div>
         <div class="reminder">
         <p>������Ϣ������ѯ����֧���޸ġ�</p>
         </div>
       </div>
     <!--������Ϣ����-->
            </div>
    </s:if>
    <s:else>
    	��������
    </s:else>
		</div>
		</div>
		<!--��׼���ݽ���-->
	<%@ include file="/common/include/inc_foot.jsp"%>
	<div id="_rndImageDIV" style="border:solid 1px #545454;position:absolute;background:#E8FBFF;padding:3px;display:none;zIndex:3000"></div>
	<div id="datepicker"></div>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/common/rnd_code.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery/validation/jquery.validation.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery/validation/common.js"></script>
<SCRIPT LANGUAGE="JavaScript">
<!--
//ҳ���������
var errMap = new Array();
<%--���ô�����Ϣ--%>
<c:set var="ferrMap" value ="${fieldErrors}"/>
<c:if test="${fn:length(ferrMap)>0}"><c:forEach items="${ferrMap}" var="fieldError" varStatus="i">
errMap[${i.index}]={feild:'${fieldError.key}',msg:'${fieldError.value}'};
</c:forEach>
</c:if>
//-->
//ҳ���ʼ�����ʱ����,ʹ����select���ɱ༭
$(document).ready(function() {
	$("table select").attr("disabled",true);
	showMenu("BaseInfo","assistantInfoList");
});
</SCRIPT>
</html>