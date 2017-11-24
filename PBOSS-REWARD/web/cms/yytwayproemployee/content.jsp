<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="Wayproemployee" key="titleUpdate2"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
        	/*
        	var checkId = checkIdcard(formItem.cardid.value);
        	if(checkId != "yes"){
        		errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>'+checkId+'</span>');
        		return false;
        	}
        	*/
        	if(formItem.telephone.value.length != 11){
        		errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>手机号码必须满足11位!</span>');
        		return false;
        	}
        	var empattr=document.all("empattr").value;
        	if('7'==empattr || '8'==empattr)
        	{
        		if(document.all('empattrmemo').value=='')
        		{
        			errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>营业厅/分公司人员必须在[专员身份属性注释]填写注明所属营业厅/地市</span>');
        			return false;
        		}
        	}
        	addfield('wayid', '<bean:message bundle="Wayproemployee" key="wayid"/>', 'c', false, '18');
        	addfield('employeename', '<bean:message bundle="Wayproemployee" key="employeename"/>', 'c', false, '30');
        	addfield('subname', '<bean:message bundle="Wayproemployee" key="subname"/>', 'c', false, '30');
        	addfield('telephone', '<bean:message bundle="Wayproemployee" key="telephone"/>', 'i', false, '15');
        	addfield('cardid', '<bean:message bundle="Wayproemployee" key="cardid"/>', 'c', false, '18');
        	addfield('pvtemail', '<bean:message bundle="Wayproemployee" key="pvtemail"/>', 'm', true, '128');
        	addfield('regdate', '<bean:message bundle="Wayproemployee" key="regdate"/>', 't', false, '25');
        	addfield('intime', '<bean:message bundle="Wayproemployee" key="intime"/>', 't', false, '25');
        	addfield('outtime', '<bean:message bundle="Wayproemployee" key="outtime"/>', 't', false, '25');
        	addfield('empstatus', '<bean:message bundle="Wayproemployee" key="empstatus"/>', 'i', false, '3');
        	addfield('isnet', '<bean:message bundle="Wayproemployee" key="isnet"/>', 'i', false, '3');
        	addfield('istenseed', '<bean:message bundle="Wayproemployee" key="istenseed"/>', 'i', false, '3');
        	addfield('isinternal', '<bean:message bundle="Wayproemployee" key="isinternal"/>', 'i', false, '3');
        	addfield('empattr', '<bean:message bundle="Wayproemployee" key="empattr"/>', 'i', false, '3');
        	addfield('empattrmemo', '<bean:message bundle="Wayproemployee" key="empattrmemo"/>', 'c', true, '512');
        	addfield('empattr2', '<bean:message bundle="Wayproemployee" key="empattr2"/>', 'i', true, '3');
        	addfield('oprcode2', '<bean:message bundle="Wayproemployee" key="oprcode2"/>', 'c', false, '15');
        	if(date_compare("intime","outtime",'启用日期不得晚于停用日期')) return;
            return checkval(window);
        }
        //校验身份证 
		function checkIdcard(idcard){
			var Errors=new Array( 
			"yes", 
			"身份证号码位数不对!", 
			"身份证号码出生日期超出范围或含有非法字符!", 
			"身份证号码校验错误!", 
			"身份证地区非法!" 
			); 
			var area={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"}  
			var idcard,Y,JYM; 
			var S,M; 
			var idcard_array = new Array(); 
			idcard_array = idcard.split(""); 
			if(area[parseInt(idcard.substr(0,2))]==null) return Errors[4]; 
			switch(idcard.length){ 
			case 15: 
			if ( (parseInt(idcard.substr(6,2))+1900) % 4 == 0 || ((parseInt(idcard.substr(6,2))+1900) % 100 == 0 && (parseInt(idcard.substr(6,2))+1900) % 4 == 0 )){ 
			ereg=/^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$/;//测试出生日期的合法性 
			} else { 
			ereg=/^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/;//测试出生日期的合法性 
			} 
			if(ereg.test(idcard)) return Errors[0]; 
			else return Errors[2]; 
			break; 
			case 18: 
			if ( parseInt(idcard.substr(6,4)) % 4 == 0 || (parseInt(idcard.substr(6,4)) % 100 == 0 && parseInt(idcard.substr(6,4))%4 == 0 )){ 
			ereg=/^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/;//闰年出生日期的合法性正则表达式 
			} else { 
			ereg=/^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/;//平年出生日期的合法性正则表达式 
			} 
			if(ereg.test(idcard)){ 
			S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7 
			+ (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9 
			+ (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10 
			+ (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5 
			
			
			+ (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8 
			+ (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4 
			+ (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2 
			+ parseInt(idcard_array[7]) * 1  
			+ parseInt(idcard_array[8]) * 6 
			+ parseInt(idcard_array[9]) * 3 ; 
			Y = S % 11; 
			M = "F"; 
			JYM = "10X98765432"; 
			M = JYM.substr(Y,1); 
			if(M == idcard_array[17]) return Errors[0]; 
			else return Errors[3]; 
			} 
			else return Errors[2]; 
			break; 
			default: 
			return Errors[1]; 
			break; 
			}
		}
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/yytwayproemployee.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="waytype" value="AG"/>
    
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/yytwayproemployee/YYTWayproemployeeForm']}"/>
    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="Wayproemployee" key="titleList2"/>
   			</td>
    	</tr>
    </table>
    </div>
    <div class="table_div">	
   		 <table width="100%" class="error_text">
    		<html:errors/><s:Msg />
    	</table>
    </div>

    <div class="table_div">
        <table class="form_table">
        	<tr>
				<td width="100%" colspan="4" class="form_table_left">
					<div class="field-require">
						<font color=blue><bean:message bundle="Wayproemployee" key="basicinfo" /></font>
					</div>
				</td>
			</tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Wayproemployee" key="employeeid"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState||errorState}">
	                        <c:if test="${updateState}">
	                        	<html:text styleClass="form_input_1x" property="employeeid" disabled="true"/>
	                            <font color="red">*</font>
	                        </c:if>
	                        <c:if test="${!updateState}">
	                        	<html:text styleClass="form_input_1x" property="employeeid" value="系统自动生成" disabled="true"/>
	                            <font color="red">*</font>
	                        </c:if>
                        </c:when>
                        <c:otherwise>
                        	<html:text styleClass="form_input_1x" property="employeeid" disabled="true"/>
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Wayproemployee" key="wayid"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState||errorState}">
	                        <c:if test="${updateState}">
	                        	<s:zoom definition="#WAY" property="wayid" condition="waytype:AG;waystate:1;" styleClass="form_input_1x" nameOnly="false" disabled="true"/>
	                            <font color="red">*</font>
	                        </c:if>
	                        <c:if test="${!updateState}">
	                        	<s:zoom definition="#WAY" property="wayid" condition="waytype:AG;waystate:1;" styleClass="form_input_1x" nameOnly="false" readonly="true"/>
	                            <font color="red">*</font>
	                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <s:zoom definition="#WAY" property="wayid" condition="waytype:AG;waystate:1;" styleClass="form_input_1x" nameOnly="false" disabled="true"/>
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Wayproemployee" key="employeename"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState||errorState}">
                        	<html:text styleClass="form_input_1x" property="employeename" />
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                        	<html:text styleClass="form_input_1x" property="employeename" disabled="true"/>
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Wayproemployee" key="subname"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState||errorState}">
                        	<html:text styleClass="form_input_1x" property="subname" />
                        	<font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                        	<html:text styleClass="form_input_1x" property="subname" disabled="true"/>
                        	<font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Wayproemployee" key="cardid"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState||errorState}">
                        	<html:text styleClass="form_input_1x" property="cardid" />
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                        	<html:text styleClass="form_input_1x" property="cardid" disabled="true"/>
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Wayproemployee" key="telephone"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState||errorState}">
                        	<html:text styleClass="form_input_1x" property="telephone" />
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                        	<html:text styleClass="form_input_1x" property="telephone" disabled="true"/>
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Wayproemployee" key="pvtemail"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState||errorState}">
                        	<html:text styleClass="form_input_1x" property="pvtemail" />
                        </c:when>
                        <c:otherwise>
                        	<html:text styleClass="form_input_1x" property="pvtemail" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Wayproemployee" key="regdate"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState||errorState}">
                        	<c:if test="${updateState}">
	                        	<input type='text' class="form_input_1x" name="regdate"
									value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.regdate}"/>"
									disabled="disabled" />
	                            <font color="red">*</font>
	                        </c:if>
	                        <c:if test="${!updateState}">
	                        	<input type='text' class="form_input_1x" name="regdate"
									value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.regdate}"/>"
									onclick="this.value = selectDate()" />
	                            <font color="red">*</font>
	                        </c:if>
                        </c:when>
                        <c:otherwise>
                        	<input type='text' class="form_input_1x" name="regdate"
									value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.regdate}"/>"
									disabled="disabled" />
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Wayproemployee" key="intime"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState||errorState}">
                        	<input type='text' class="form_input_1x" name="intime"
									value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.intime}"/>"
									onclick="this.value = selectDate()" />
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                        	<input type='text' class="form_input_1x" name="intime"
									value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.intime}"/>"
									disabled="disabled" />
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Wayproemployee" key="outtime"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState||errorState}">
                        	<input type='text' class="form_input_1x" name="outtime"
									value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.outtime}"/>"
									onclick="this.value = selectDate()" />
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                       		<input type='text' class="form_input_1x" name="outtime"
									value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.outtime}"/>"
									disabled="true" />
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Wayproemployee" key="empstatus"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState||errorState}">
                        	<html:select property="empstatus">
								<option />
									<s:Options definition="$CH_EMPSTATUS" />
							</html:select>
							<font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                        	<html:select property="empstatus" disabled="true">
								<option />
									<s:Options definition="$CH_EMPSTATUS" />
							</html:select>
							<font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Wayproemployee" key="isnet"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState||errorState}">
                        	<html:select property="isnet" disabled="true" value="2">
								<option />
									<s:Options definition="$CH_ISNET" />
							</html:select>
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                        	<html:select property="isnet" disabled="true" value="2">
								<option />
									<s:Options definition="$CH_ISNET" />
							</html:select>
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
             <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Wayproemployee" key="istenseed"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState||errorState}">
                        	<html:select property="istenseed">
								<option />
									<s:Options definition="#IS_UNV_YN" />
							</html:select>
							<font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                        	<html:select property="istenseed" disabled="true">
								<option />
									<s:Options definition="#IS_UNV_YN" />
							</html:select>
							<font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Wayproemployee" key="isinternal"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState||errorState}">
                        	<html:select property="isinternal">
								<option />
									<s:Options definition="#IS_UNV_YN" />
							</html:select>
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                        	<html:select property="isinternal" disabled="true">
								<option />
									<s:Options definition="#IS_UNV_YN" />
							</html:select>
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
             <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Wayproemployee" key="emplevel"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                <c:choose>
                        <c:when test="${edtState||errorState}">
	                		<html:select property="emplevel" styleId="emplevel">
							<option />
								<s:Options definition="$CH_BBCUNPBLEVEL" />
							</html:select>
					 </c:when>
                        <c:otherwise>
	                        <html:select property="emplevel" styleId="emplevel" disabled="true">
							<option />
								<s:Options definition="$CH_BBCUNPBLEVEL" />
							</html:select>
                          </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Wayproemployee" key="empattr"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                	<c:choose>
                		 <c:when test="${edtState||errorState}">
                			<html:select property="empattr">
								<option />
									<s:Options definition="#EMPROLE" />
							</html:select>
							<font color="red">*</font>
                		</c:when>
                		<c:otherwise>
                			<html:select property="empattr" disabled="true">
								<option />
									<s:Options definition="#EMPROLE" />
							</html:select>
							<font color="red">*</font>
                		</c:otherwise>
                	</c:choose>
                </td>
              </tr>
              <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Wayproemployee" key="empattrmemo"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                	 <html:textarea property="empattrmemo"></html:textarea>
                </td>
                <td width="20%" align="right" class="form_table_right">
                	<div class="field-require"><bean:message bundle="Wayproemployee" key="empattr2"/>:</div>
                </td>
                <td width="30%" align="left" class="form_table_left">
                	<c:choose>
                		 <c:when test="${edtState||errorState}">
                			<html:select property="empattr2">
								<option />
								<s:Options definition="$CH_EMPATTR2" />
							</html:select>
                		</c:when>
                		<c:otherwise>
                			<html:select property="empattr2" disabled="true">
								<option />
								<s:Options definition="$CH_EMPATTR2" />
							</html:select>
                		</c:otherwise>
                	</c:choose>
                </td>
              </tr>
              <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Wayproemployee" key="oprcode2"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState||errorState}">
                        	<html:text styleClass="form_input_1x" property="oprcode2" />
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                        	<html:text styleClass="form_input_1x" property="oprcode2"  disabled="true"/>
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td colspan="2">&nbsp;</td>
            </tr>
        </table>
    </div>
    
    <div class="table_div">
    	<table class="form_table">            
        	<tr>
				<td width="100%" colspan="4" class="form_table_left">
					<div class="field-require">
						<font color='blue'><bean:message bundle="Wayproemployee" key="workmode" /></font>
					</div>
				</td>
			</tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Wayproemployee" key="isunpb"/>:</div></td>
                <td width="80%" align="left" colspan="3" class="form_table_left">
                	 <c:choose>
                        <c:when test="${edtState||errorState}">
                            <html:checkbox property="isunpb" />   
                        </c:when>
                        <c:otherwise>
                            <html:checkbox property="isunpb" disabled="true"/>   
                        </c:otherwise>
                    </c:choose>
                	
                </td>
            </tr>
		</table>
	</div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td>
                	<c:choose>
                        <c:when test="${edtState||errorState}">
                            <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
	                           onclick="doSave('/cms/yytwayproemployee.do?CMD=SAVE')"/>
                        </c:when>
                        <c:otherwise>
                            <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
		                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
		                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
		                           onclick="doSave('/cms/yytwayproemployee.do?CMD=SAVE')" disabled="disabled"/>
                        </c:otherwise>
                    </c:choose>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/yytwayproemployee.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
