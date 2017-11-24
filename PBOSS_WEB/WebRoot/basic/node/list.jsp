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
	<%@ include file="/common/include/inc_head.jsp"%>	
	<!--��׼���ݿ�ʼ-->
	<div class="divspan">
			<!-- ��������-->
		<%@ include file="/common/include/inc_menu.jsp"%>
        <div class="context">
			<form id="frmSubmit" method="POST" action="submit.do" onSubmit="return doSubmit();">
			<input type="hidden" name="parameter.employeeId" value="${_PBOSS_WEB_USER.employeeid}"/>
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">�����ڵ�λ�ã�</span><span class="font_breadcrumb">${location}</span>
			</div>
			<c:if test='${fn:length(message)>0}'>
		<DIV><font color="red">������ʾ��${message}</font></DIV></c:if>
			<div class="listboxlist">
			<s:if test="%{apply!=null}">
			<div class="listboxtitle">��������Ϣ</div>
			<table class="tb02" width="100%">
				<tbody>		
					<tr>
						<td class="blue_01 textRight" width="20%">������</td>
						<td class="red_01" width="30%">
						<input name="apply.principal" type="text" class="text_01" id="apply.principal" value="${apply.principal}" maxlength="10"/>
						&nbsp;<font color="#FF0000">*</font>
						</td>
						<td class="blue_01 textRight" width="20%">�ƶ��绰��</td>
						<td class="red_01" width="30%">
						<input name="apply.principaltel" type="text" class="text_01" id="apply.principaltel" value="${apply.principaltel}" maxlength="11"/>
						&nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">�̶��绰��</td>
						<td class="red_01" width="30%">
						<input name="apply.principalphone" type="text" class="text_01" id="apply.principalphone" value="${apply.principalphone}" maxlength="20"/>
						</td>
						<td class="blue_01 textRight" width="20%">�������䣺</td>
						<td class="red_01" width="30%">
						<input name="apply.principalemail" type="text" class="text_01" id="apply.principalemail" value="${apply.principalemail}" maxlength="100"/>
						</td>
					</tr>
				</tbody>
			</table>
			
			<div class="listboxtitle">������Ϣ</div>
			<table class="tb02" width="100%">
				<tbody>
					<tr>
						<td class="blue_01 textRight" width="20%">�������룺</td>
						<td class="red_01" width="30%">${apply.wayid}</td>
						<td class="blue_01 textRight" width="20%">�������ƣ�</td>
						<td class="red_01" width="30%">
							<input name="apply.wayname" type="text" class="text_01" id="apply.wayname" value="${apply.wayname}" maxlength="100"/>
						  &nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">�Ǽ���</td>
						<td class="red_01" width="30%">${temWay.strStarlevel}<INPUT TYPE="hidden" NAME="temWay.starlevel" value="${temWay.starlevel}"/></td>
						<!-- 
						<td class="blue_01 textRight" width="20%">���ڷ�������</td>
						<td class="red_01" width="30%"></td>
						 -->
						 <td class="blue_01 textRight" width="20%">�����ܵ���룺</td>
						 <td class="red_01" width="30%">${temWay.chainhead}<INPUT TYPE="hidden" NAME="temWay.chainhead" value="${temWay.chainhead}"/></td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">�������У�</td>
						<td class="red_01" width="30%">${fun:getBranchName(apply.cityid)}</td>
						<td class="blue_01 textRight" width="20%">�������ʣ�</td>
						<td class="red_01" width="30%">${fun:cateToStr(temWay.catetype)}<INPUT TYPE="hidden" NAME="temWay.catetype" value="${temWay.catetype}"/></td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">�����������ı��룺</td>
						<td class="red_01" width="30%">${temWay.svccode}<INPUT TYPE="hidden" NAME="temWay.svccode" value="${temWay.svccode}"/></td>
						<td class="blue_01 textRight" width="20%">ҵ̬���ͣ�</td>
						<td class="red_01" width="30%">${fun:formateToStr(temWay.formtype)}<INPUT TYPE="hidden" NAME="temWay.formtype" value="${temWay.formtype}"/></td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">��ϸ��ַ��</td>
						<td class="red_01" width="30%" colspan="3">
						<textarea name="apply.address" class="textarea_01" id="apply.address">${apply.address}</textarea>
&nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>
				</tbody>
			</table>
			
			<div class="listboxtitle">�ͻ���Ϣ</div>
			<table class="tb02" width="100%">
				<tbody>	
					<tr>
						<td class="blue_01 textRight" width="20%">�ջ���ϵ�ˣ�</td>
						<td class="red_01" width="80%">
							<input name="apply.recpers" type="text" class="text_01" id="apply.recpers" value="${apply.recpers}" maxlength="50"/>
						  &nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">�ջ���ϵ���룺</td>
						<td class="red_01" width="80%">
							<input name="apply.recconntel" type="text" class="text_01" id="apply.recconntel" value="${apply.recconntel}" maxlength="20"/>
						  &nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">�ջ���֤���ţ�</td>
						<td class="red_01" width="80%">
							<input name="apply.reccertno" type="text" class="text_01" id="apply.reccertno" value="${apply.reccertno}" maxlength="50"/>
						  &nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">�ͻ���ַ��</td>
						<td class="red_01" width="80%">
						<textarea name="apply.sendaddr" class="textarea_01" id="apply.sendaddr">${apply.sendaddr}</textarea>
&nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>
				</tbody>
			</table>

			<div class="listboxtitle">�˻���Ϣ</div>
			<table class="tb02" width="100%">
				<tbody>
					<tr>
						<td class="blue_01 textRight" width="22%">���������֤���룺</td>
						<td class="red_01" width="80%">
							<input name="apply.acctfid" type="text" class="text_01" id="apply.acctfid" value="${apply.acctfid}" maxlength="18"/>
						  &nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>	
					<tr>
						<td class="blue_01 textRight" width="22%">���֧���ʺ����ƣ�</td>
						<td class="red_01" width="80%">
							<input name="apply.acctname" type="text" class="text_01" id="apply.acctname" value="${apply.acctname}" maxlength="80"/>
						  &nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>	
					<tr>
						<td class="blue_01 textRight" width="22%">���֧���������У�</td>
						<td class="red_01" width="80%">
							<input name="apply.bankname" type="text" class="text_01" id="apply.bankname" value="${apply.bankname}" maxlength="80"/>
						  &nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="22%">���֧�������˺ţ�</td>
						<td class="red_01" width="80%">
							<input name="apply.acctno" type="text" class="text_01" id="apply.acctno" value="${apply.acctno}" maxlength="80"/>
						  &nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="22%">���๺�������ʺ����ƣ�</td>
						<td class="red_01" width="80%">
							<input name="apply.deacctname" type="text" class="text_01" id="apply.deacctname" value="${apply.deacctname}" maxlength="80"/>
						  &nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="22%">���๺�����ۿ������У�</td>
						<td class="red_01" width="80%">
							<input name="apply.debankname" type="text" class="text_01" id="apply.debankname" value="${apply.debankname}" maxlength="80"/>
						  &nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="22%">���๺�����������˺ţ�</td>
						<td class="red_01" width="80%">
							<input name="apply.deacctno" type="text" class="text_01" id="apply.deacctno" value="${apply.deacctno}" maxlength="80"/>
						  &nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="22%">���๺���������б�ʶ��</td>
						<td class="red_01" width="80%">
							<input id="bankname" class="text_01" value="${apply.debankidName}"/>
							<input type="hidden" name="apply.debankid" id="debankid" value="${apply.debankid}"/>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="22%">���๺����������״̬��</td>
						<td class="red_01" width="80%">
							<st:st name="destate" className="formSelect_3L" type="<%=ConstantsType.VALIDFLAG %>" selected="${destate}"/>
						</td>
					</tr>
				</tbody>
			</table>
            <div class="registryable">
                <div class="registrytitle">
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                ��֤�룺
                    <input tabindex="8" name="vaildateCode" type="text" id="vaildate_code" class="input3"  maxlength="4" onBlur="hiddenVerify()" 
                    onFocus="focusGetVerify(this)"  size="4" style="ime-mode:disabled;width:50px" value=""/>
                    <input type="button" class="btn_blue"  onclick="clickSubmit();" value="�ύ�޸�����" />
                </div>
            </div>
            </div>
            </s:if>
			</form>
    <!--������Ϣ��ʼ-->
	<div class="column">
         <div class="listboxtitle">����˵����</div>
         <div class="reminder">
           ��ѯ����������ϣ������������������޸����롣 </div>
       </div>
       <div class="column">
         <div class="listboxtitle">��ܰ���ѣ�</div>
         <div class="reminder">
         <p>1�� �޸�ʱ����<font color="#FF0000">*</font>��Ϊ�����</p>
         <p>2�� ���֤����Ϊ15λ��18λ��Ч���롣</p>
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
</SCRIPT>
</html>