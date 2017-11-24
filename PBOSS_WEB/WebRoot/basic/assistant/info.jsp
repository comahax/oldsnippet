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
	<%@ include file="/common/include/inc_head.jsp"%>	
	<!--��׼���ݿ�ʼ-->
	<div class="divspan">
			<!-- ��������-->
		<%@ include file="/common/include/inc_menu.jsp"%>
        <div class="context">
			<form id="frmSubmit" method="POST" action="Submit.do" onsubmit="return doSubmit();">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">�����ڵ�λ�ã�</span><span class="font_breadcrumb">${location}</span>
			</div>
			<c:if test='${fn:length(message)>0}'>
		<DIV><font color="red">������ʾ��${message}</font></DIV></c:if>
	<s:if test="%{result.data.size > 0}">
		<s:set name="emp" value="result.data[0]" />
			<div class="listboxlist">
			<div class="listboxtitle">������Ϣ</div>
			<input type="hidden" name="apply.employeeid" value="${emp.employeeid}"/>
			<table class="tb02" width="96%">
				<tbody>		
					<tr>
						<td class="blue_01 textRight" width="20%">������</td>
						<td class="red_01" width="30%">
						<input name="apply.employeename" type="text" class="text_01" id="apply.employeename" value="${emp.employeename}" maxlength="20"/>&nbsp;<font color="#FF0000">*</font>
						</td>
						<td class="blue_01 textRight" width="20%">�Ա�</td>
						<td class="red_01" width="30%">
                			<st:st name="apply.sex" className="formSelect_2L" type="<%=ConstantsType.SEX %>" selected="${emp.sex}"/>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">���֤�ţ�</td>
						<td class="red_01" width="30%">
						<input name="apply.cardid" type="text" class="text_01" id="apply.cardid" value="${emp.cardid}" maxlength="18"/>&nbsp;<font color="#FF0000">*</font></td>
						<td class="blue_01 textRight" width="20%">���᣺</td>
						<td class="red_01" width="30%">
						<input name="apply.nativehome" type="text" class="text_01" id="apply.nativehome" value="${emp.nativehome }" maxlength="20"/>
						</td>
</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">�������ڣ�</td>
						<td class="red_01" width="30%">
						<input name="apply.birthday" type="text" class="text_01" style="width:80px;" id="birthday" value="<fmt:formatDate value="${emp.birthday }" type="both" pattern="yyyy-MM-dd"/>" maxlength="18"/>
						</td>
						<td class="blue_01 textRight" width="20%">רҵ��</td>
						<td class="red_01" width="30%">
						<input name="apply.speciality" type="text" class="text_01" id="apply.speciality" value="${emp.speciality }" maxlength="16"/>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">�Ļ��̶ȣ�</td>
						<td class="red_01" width="30%">
							<st:st name="apply.edulevel" className="formSelect_3L" type="<%=ConstantsType.EDULEVEL %>" selected="${emp.edulevel}"/>
						</td>
						<td class="blue_01 textRight" width="20%">��ҵԺУ��</td>
						<td class="red_01" width="30%">
						<input name="apply.gradschool" type="text" class="text_01" id="apply.gradschool" value="${emp.gradschool}" maxlength="40"/>
						</td>
					</tr>
				</tbody>
			</table>
			
			<div class="listboxtitle">��ϵ��ʽ</div>
			<table class="tb02" width="96%">
				<tbody><!--
					<tr>
						<td class="blue_01 textRight" width="20%">��ϵ�绰��</td>
						<td class="red_01" width="30%">
						<input name="apply.telephone" type="text" class="text_01" id="apply.telephone" value="${emp.telephone }" maxlength="15"/>
						&nbsp;<font color="#FF0000">*</font>
						</td>
						<td class="blue_01 textRight" width="20%">��˾ר����ϵ���룺</td>
						<td class="red_01" width="30%">
							<input name="apply.ofcphone" type="text" class="text_01" id="apply.ofcphone" value="${emp.ofcphone }" maxlength="64"/>
						  &nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>//-->
					<tr>
						<td class="blue_01 textRight" width="20%">ҵ������룺</td>
						<td class="red_01" width="30%">
						<input name="apply.officetel" type="text" class="text_01" id="apply.officetel" value="${emp.officetel }" maxlength="12"/>
						&nbsp;<font color="#FF0000">*</font>
						</td>
						<td class="blue_01 textRight" width="20%">���˵������䣺</td>
						<td class="red_01" width="30%">
						<input name="apply.pvtemail" type="text" class="text_01" id="apply.pvtemail" value="${emp.pvtemail }" maxlength="128"/>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">��˾ר�õ������䣺</td>
						<td class="red_01" width="30%" colspan="3">
						<input name="apply.ofcemail" type="text" class="text_01" id="apply.ofcemail" value="${emp.ofcemail }" maxlength="128"/>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">��ͥ��ַ��</td>
						<td class="red_01" width="30%" colspan="3">
						<textarea name="apply.homeaddr" class="textarea_01" id="apply.homeaddr">${emp.homeaddr }</textarea>
						</td>
					</tr>
				</tbody>
			</table>
			<div class="listboxtitle">��֯��Ϣ</div>
  			<table class="tb02" width="96%">
  				<tr>
					<td class="blue_01 textRight" width="20%">�������룺</td>
					<td class="red_01" width="30%">
					${_PBOSS_WEB_USER.wayid}
					</td>
					<td class="blue_01 textRight" width="20%">�������ƣ�</td>
					<td class="red_01" width="30%">
					${_PBOSS_WEB_USER.channel.wayname}
					</td>
				</tr>
				<tr>
					<td class="blue_01 textRight" width="20%">���й�˾��</td>
					<td class="red_01" width="30%">
					${fun:getBranchName(_PBOSS_WEB_USER.cityid)}
					</td>
					<td class="blue_01 textRight" width="20%">�ֹ�˾��</td>
					<td class="red_01" width="30%">
					${fun:getCountyidchName(_PBOSS_WEB_USER.channel.countyid)}
					</td>
				</tr>
				<tr>
					<td class="blue_01 textRight" width="20%">�����������ı��룺</td>
					<td class="red_01" width="30%" colspan="3">
					${_PBOSS_WEB_USER.channel.svccode}
					</td>
				</tr>
  			</table>
  			
			<div class="listboxtitle">��֯��Ϣ</div>
  			<table class="tb02" width="96%">
  				<tr>
					<td class="blue_01 textRight" width="20%">��ְʱ�䣺</td>
					<td class="red_01" width="30%">
					<input name="apply.intime" type="text" class="text_01" style="width:80px;" id="intime" value="<fmt:formatDate value="${emp.intime }" type="both" pattern="yyyy-MM-dd"/>"/>
					&nbsp;<font color="#FF0000">*</font>
					</td>
					<td class="blue_01 textRight" width="20%">�Ͷ���ϵ��</td>
					<td class="red_01" width="30%">
					<st:st name="apply.contacttype" className="formSelect_3L" type="<%=ConstantsType.CONTACTTYPE %>" selected="${emp.contacttype}"/>&nbsp;<font color="#FF0000">*</font>
					</td>
				</tr>
				<tr>
					<td class="blue_01 textRight" width="20%">�ù����ʣ�</td>
					<td class="red_01" width="30%">
					<st:st name="apply.employtype" className="formSelect_3L" type="<%=ConstantsType.EMPLOYTYPE %>" selected="${emp.employtype}"/>&nbsp;<font color="#FF0000">*</font>
					</td>
					<td class="blue_01 textRight" width="20%">�ù�״̬��</td>
					<td class="red_01" width="30%">
					<st:st name="apply.empstatus" className="formSelect_3L" type="<%=ConstantsType.EMPSTATUS %>" selected="${emp.empstatus}"/>&nbsp;<font color="#FF0000">*</font>
					</td>
				</tr>
			</table>
		<div class="registryable">
			<div class="registrytitle">
			 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			��֤�룺
	  			<input tabindex="8" name="vaildateCode" type="text" id="vaildate_code" class="code input3"  maxlength="4" onBlur="hiddenVerify()" onFocus="focusGetVerify(this)"  size="4" style="ime-mode:disabled;width:50px" value=""/>
				<input type="submit" class="btn_blue" id="btnSubmit"  value="�ύ����" />
				<INPUT TYPE="hidden" NAME="doAction" id="doAction" value="${doAction}">
				<input type="button" class="btn_blue"  onclick="location='/assistant/List.do'" value="�� ��" />
	    	</div>
		</div>
			</form>
     
    <!--������Ϣ��ʼ-->
	<div class="column">
		<div class="listboxtitle">����˵����</div>
         <div class="reminder">
           ��Ա����¼�룬��Ա����ͨ����̨����ͨ�������Ч�� </div>
       </div>
       <div class="column">
         <div class="listboxtitle">��ܰ���ѣ�</div>
         <div class="reminder">
         <p>1�� ��<font color="#FF0000">*</font>��Ϊ�����</p>
         <p>2�� ���֤����Ϊ15λ��18λ��Ч���롣</p>
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
<script type="text/javascript" src="${ctx}/js/biz/basic/assistant/info.js"></script> 
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
</SCRIPT>
</html>