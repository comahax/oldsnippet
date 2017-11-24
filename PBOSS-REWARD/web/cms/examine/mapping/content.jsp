<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ page import="com.sunrise.boss.common.base.db.SessionFactoryRouter,com.sunrise.boss.ui.commons.User;"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
    request.setAttribute("exmncity", SessionFactoryRouter.conversionCityid(((User)request.getSession().getAttribute("_USER")).getCityid()));
%>
<html>
<head>
    <title><bean:message bundle="mapping" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('seqid', '<bean:message bundle="mapping" key="seqid"/>', 'f', true, '14');
            addfield('exmnid', '<bean:message bundle="mapping" key="exmnid"/>', 'f', false, '6');
            addfield('cityid', '<bean:message bundle="mapping" key="cityid"/>', 'c', true, '2');
            addfield('mmode', '<bean:message bundle="mapping" key="mmode"/>', 'c', false, '512');
	            addfield('markul', '<bean:message bundle="mapping" key="markul"/>', 'f', false, '10','2');
	            addfield('markll', '<bean:message bundle="mapping" key="markll"/>', 'f', false, '10','2');
	      
            addfield('coeforbase', '<bean:message bundle="mapping" key="coeforbase"/>', 'f', false, '10','4');

            return (checkval(window) && checkData());
        }
         function selectMode(val){
        	if(val=='0'){
        		document.getElementById("red_markul").style.display="";
        		document.getElementById("red_markll").style.display="";
        	}else{
        		document.getElementById("red_markul").style.display="none";
        		document.getElementById("red_markll").style.display="none";
        	}
        }
          function checkData(){
        	var markll=document.getElementsByName("markll")[0].value;
        	var markul=document.getElementsByName("markul")[0].value;
        	var coeforbase=document.getElementsByName("coeforbase")[0].value;
        	if(Number(markll)>=Number(markul)){
        		var alertstr="<span class=\'errorkey\'><bean:message bundle="mapping" key="markll"/>不能大于等于<bean:message bundle="mapping" key="markul"/></span>";
				errorMessageShow(alertstr);
				return false;
        	}
        	if(Number(coeforbase)<0){
        		var alertstr="<span class=\'errorkey\'>[<bean:message bundle="mapping" key="coeforbase"/>]必须为大于等0的实数</span>";
				errorMessageShow(alertstr);
				return false;
        	}
        	return true;
        }
        function showExamineInfo(){
        	var returnValue=window.showModalDialog('<%=contextPath %>/cms/examine/examine.do?CMD=examinelist',window,"dialogWidth=500px;dialogHeight=430px;status:no;scroll=yes;");
        	if(returnValue!=undefined){
        		var strs=returnValue.split(",");
        		document.getElementsByName("exmnid")[0].value=strs[0];
  			}
  		}
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/examine/mapping.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_seqid"/>
    <html:hidden property="_ne_exmnid"/>
    <html:hidden property="_se_cityid"/>
    <html:hidden property="cityid"/>
    <html:hidden property="seqid"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/examine/mapping/MappingForm']}"/>
	<input type="hidden" id="provincialright" name="provincialright" value="<c:out value="${provincialright}"/>">
	<input type="hidden" id="exmncityid" name="exmncityid" value="<c:out value="${exmncityid}"/>">
    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="mapping" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="mapping" key="exmnid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                           <%--  <s:zoom definition="#EXAMINE" property="exmnid"
											styleClass="form_input_1x" condition="cityid:${exmncity}"/>--%>
							 <html:text styleClass="form_input_1x" property="exmnid" /><input type="button" value="..." class="clickbutton"
								onclick="showExamineInfo();this.value='...';" />
							<font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <%--  <s:zoom definition="#EXAMINE" property="exmnid" disabled="true"
											styleClass="form_input_1x" condition="cityid:${exmncity}" />--%>
							<html:text styleClass="form_input_1x" property="exmnid" disabled="true"/>
							<font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="mapping" key="mmode"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:select property="mmode" >
	                   		    <option/>
	                   		    <s:Options definition="$CH_MMODE"/>
                     		</html:select>
                     		<font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <html:select property="mmode" disabled="true">
	                   		    <option/>
	                   		    <s:Options definition="$CH_MMODE"/>
                     		</html:select>
                     		<font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="mapping" key="markul"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="markul" />
                            <font id="red_markul"  color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="markul" disabled="true"/>
                            <font id="red_markul" color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="mapping" key="markll"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="markll" />
                            <font id="red_markll" color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="markll" disabled="true"/>
                            <font id="red_markll" color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="mapping" key="coeforbase"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="coeforbase" />
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="coeforbase" disabled="true"/>
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" class="form_table_center">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/examine/mapping.do?CMD=SAVE')"/>
                   
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/examine/mapping.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
 <script language="JavaScript">
 		var mmode=document.getElementsByName("mmode")[0].value
     	if(mmode==''){//
     		document.getElementById("mmode").value='0';
     		//document.getElementById("red_markll").style.display="";
     		//document.getElementById("red_markul").style.display="";
     	}
     	if(document.getElementsByName("cmdState")[0].value=='EDIT'){//编辑的时候
     		var provincialright=document.getElementById("provincialright").value;
     		var exmncityid=document.getElementById("exmncityid").value;
     		var cityid=document.getElementById("cityid").value;
     		if((provincialright!='YES' && exmncityid=='GD') || (provincialright!='YES' && cityid=='GD') || (provincialright=='YES' && cityid!='GD')){//对省公司应用于该地市考核的映射信息只允许查看
     			//document.getElementsByName("exmnid_zoom")[0].disabled=true;
     			document.getElementsByName("mmode")[0].disabled=true;
     			document.getElementsByName("markul")[0].disabled=true;
     			document.getElementsByName("markll")[0].disabled=true;
     			document.getElementsByName("coeforbase")[0].disabled=true;
     		}
     	}
     	
 </script>
</html>
