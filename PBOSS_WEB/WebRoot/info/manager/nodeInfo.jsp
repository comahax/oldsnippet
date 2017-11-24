<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="fun" uri="/fun-tags" %>
<%@ taglib prefix="st" uri="/select-tag"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>

<body>
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
			<div class="listboxlist">
			<s:if test="%{nodeDetail!=null}"> 
			<div class="listboxtitle">��������Ϣ</div>
			<table class="tb02" width="100%">
				<tbody>		
					<tr>
						<td class="blue_01 textRight" width="20%">������</td>
						<td class="red_01" width="30%">
						${nodeDetail.contact.principal }
						</td>
						<td class="blue_01 textRight" width="20%">�ƶ��绰��</td>
						<td class="red_01" width="30%">
						${nodeDetail.contact.principaltel }
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">�̶��绰��</td>
						<td class="red_01" width="30%">
						${nodeDetail.contact.principalphone }
						</td>
						<td class="blue_01 textRight" width="20%">�������䣺</td>
						<td class="red_01" width="30%">
						${nodeDetail.contact.principalemail }
						</td>
					</tr>
				</tbody>
			</table>
			
			<div class="listboxtitle">������Ϣ</div>
			<table class="tb02" width="100%">
				<tbody>
					<tr>
						<td class="blue_01 textRight" width="20%">�������룺</td>
						<td class="red_01" width="30%">${nodeDetail.way.wayid}</td>
						<td class="blue_01 textRight" width="20%">�������ƣ�</td>
						<td class="red_01" width="30%">
							${nodeDetail.way.wayname}
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">�Ǽ���</td>
						<td class="red_01" width="30%">${fun:getStarlevelName(nodeDetail.way.starlevel)}
						</td>
						<!-- 
						<td class="blue_01 textRight" width="20%">���ڷ�������</td>
						<td class="red_01" width="30%"></td>
						 -->
						 <td class="blue_01 textRight" width="20%">�����ܵ���룺</td>
						 <td class="red_01" width="30%">${nodeDetail.way.chainhead}</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">�������У�</td>
						<td class="red_01" width="30%">${fun:getBranchName(nodeDetail.way.cityid)}</td>
						<td class="blue_01 textRight" width="20%">�������ʣ�</td>
						<td class="red_01" width="30%">${fun:cateToStr(nodeDetail.way.catetype)}</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">�����������ı��룺</td>
						<td class="red_01" width="30%">${nodeDetail.way.svccode}</td>
						<td class="blue_01 textRight" width="20%">ҵ̬���ͣ�</td>
						<td class="red_01" width="30%">${fun:formateToStr(nodeDetail.way.formtype)}</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">��ϸ��ַ��</td>
						<td class="red_01" width="30%" colspan="3">
						<textarea readonly="true" class="textarea_01">${nodeDetail.way.address}</textarea>
						</td>
					</tr>
				</tbody>
			</table>
			
			<div class="listboxtitle">�ͻ���Ϣ</div>
			<table class="tb02" width="100%">
				<tbody>	
					<tr>
						<td class="blue_01 textRight" width="20%">�ջ���ϵ�ˣ�</td>
						<td class="red_01" width="80%">${nodeDetail.cooperator.recpers}</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">�ջ���ϵ���룺</td>
						<td class="red_01" width="80%">${nodeDetail.cooperator.recconntel}</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">�ջ���֤���ţ�</td>
						<td class="red_01" width="80%">${nodeDetail.cooperator.reccertno}</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">�ͻ���ַ��</td>
						<td class="red_01" width="80%">
						<textarea readonly="true" class="textarea_01" >${nodeDetail.cooperator.sendaddr}</textarea>
						</td>
					</tr>
				</tbody>
			</table>

			<div class="listboxtitle">�˻���Ϣ</div>
			<table class="tb02" width="100%">
				<tbody>
					<tr>
						<td class="blue_01 textRight" width="22%">���������֤���룺</td>
						<td class="red_01" width="80%">${nodeDetail.account.acctfid}</td>
					</tr>	
					<tr>
						<td class="blue_01 textRight" width="22%">���֧���ʺ����ƣ�</td>
						<td class="red_01" width="80%">${nodeDetail.account.acctname}</td>
					</tr>	
					<tr>
						<td class="blue_01 textRight" width="22%">���֧���������У�</td>
						<td class="red_01" width="80%">${nodeDetail.account.bankname}</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="22%">���֧�������˺ţ�</td>
						<td class="red_01" width="80%">${nodeDetail.account.acctno}</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="22%">���๺�������ʺ����ƣ�</td>
						<td class="red_01" width="80%">${nodeDetail.account.deacctname}
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="22%">���๺�����ۿ������У�</td>
						<td class="red_01" width="80%">${nodeDetail.account.debankname}</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="22%">���๺�����������˺ţ�</td>
						<td class="red_01" width="80%">${nodeDetail.account.deacctno}</td>
					</tr>
				</tbody>
			</table>
            </s:if>
            <s:else>
            </s:else>
            </div>
           
            <div class="registryable">
                <div class="registrytitle">
                	<input type="button" class="btn_blue"  onclick="location='/managerView/nodeList.do'" value="���������б�" />
                </div>
            </div>
    <!--������Ϣ��ʼ-->
	<div class="column">
         <div class="listboxtitle">����˵����</div>
         <div class="reminder">
           	<p>��ѯ����������ϡ�</p>
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
	</div>
			<!--��׼���ݽ���-->
	<%@ include file="/common/include/inc_foot.jsp"%>
	<div id="_rndImageDIV" style="border:solid 1px #545454;position:absolute;background:#E8FBFF;padding:3px;display:none;zIndex:3000"></div>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/common/rnd_code.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery/validation/jquery.validation.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery/validation/common.js"></script>
<script type="text/javascript" src="${ctx}/js/biz/basic/node/list.js"></script> 

<script type="text/javascript" src="${ctx}/js/jQuery/ac/jquery.autocomplete.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery/ac/auto.js"></script> 
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

var jaacDBBank = "${jqac.DBBank}";
//-->
//ҳ���ʼ�����ʱ����,ʹ����select���ɱ༭
$(document).ready(function() {
	$("table select").attr("disabled",true);
	showMenu("BaseInfo","nodeInfoList");
});
</SCRIPT>
</html>