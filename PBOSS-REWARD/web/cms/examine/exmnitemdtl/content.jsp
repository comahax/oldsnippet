<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="exmnitemdtl" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('seqid', '<bean:message bundle="exmnitemdtl" key="seqid"/>', 'f', true, '10');
            addfield('exmnid', '<bean:message bundle="exmnitemdtl" key="exmnid"/>', 'f', false, '6');
            addfield('exmnstdid', '<bean:message bundle="exmnitemdtl" key="exmnstdid"/>', 'f', false, '6');
            addfield('cityid', '<bean:message bundle="exmnitemdtl" key="cityid"/>', 'c', true, '3');
            addfield('marktype', '<bean:message bundle="exmnitemdtl" key="marktype"/>', 'c', false, '10');
            addfield('basemk', '<bean:message bundle="exmnitemdtl" key="basemk"/>', 'd', false, '5','2');
            if(document.getElementsByName("marktype")[0].value==''){
          		 var alertstr="<span class=\'errorkey\'>[<bean:message bundle="exmnitemdtl" key="marktype"/>]不能为空</span>";
				errorMessageShow(alertstr);
				return false;
			}
            if(document.getElementsByName("marktype")[0].value=='1'){//线性
            	addfield('dynamicmk', '<bean:message bundle="exmnitemdtl" key="dynamicmk"/>', 'f', false, '5','2');
            }
            addfield('leastcrtcl', '<bean:message bundle="exmnitemdtl" key="leastcrtcl"/>', 'f', false, '5','2');
            addfield('largestcrtcl', '<bean:message bundle="exmnitemdtl" key="largestcrtcl"/>', 'f', false, '5','2');
            addfield('pseqid', '<bean:message bundle="exmnitemdtl" key="pseqid"/>', 'f', true, '10');

            return (checkval(window) && checkCrtcl());
        }
        function checkCrtcl(){
        	var largestcrtcl=document.getElementsByName("largestcrtcl")[0].value;
        	var leastcrtcl=document.getElementsByName("leastcrtcl")[0].value;
        	if(Number(leastcrtcl)>Number(largestcrtcl)){
        		var alertstr="<span class=\'errorkey\'><bean:message bundle="exmnitemdtl" key="leastcrtcl"/>不能大于<bean:message bundle="exmnitemdtl" key="largestcrtcl"/></span>";
				errorMessageShow(alertstr);
				return false;
        	}
        	return true;
        }
        function selectMarktype(){
        	var marktype=document.getElementsByName("marktype")[0].value
        	if(marktype=='1'){//线性
        		document.getElementsByName("basemk")[0].className="form_input_year";
        		document.getElementById("basemkSpan").style.display="";
        		document.getElementById("dynamicmkSpan").style.display="";
        	}else{
        		document.getElementsByName("basemk")[0].className="form_input_1x";
        		document.getElementById("basemkSpan").style.display="none";
        		document.getElementById("dynamicmkSpan").style.display="none";
        	}
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/examine/exmnitemdtl.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_seqid"/>
    <html:hidden property="_ne_exmnid"/>
    <html:hidden property="_ne_exmnstdid"/>
    <html:hidden property="_se_cityid"/>
    <html:hidden property="cityid"/>
    <html:hidden property="seqid"/>
     <html:hidden property="pseqid"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/examine/exmnitemdtl/ExmnitemdtlForm']}"/>
	<input type="hidden" name="exmnid" value="<c:out value='${form._ne_exmnid}' />">
	<input type="hidden" name="exmnstdid" value="<c:out value='${form._ne_exmnstdid}' />" >
	<input type="hidden" id="provincialright" name="provincialright" value="<c:out value="${provincialright}"/>">
	<input type="hidden" id="exmncityid" name="exmncityid" value="<c:out value="${exmncityid}"/>">
    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="exmnitemdtl" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="exmnitemdtl" key="marktype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState or cmdState=='EDIT'}">
                        <c:if test="${updateState}">
                            <html:select property="marktype" onchange="selectMarktype();" disabled="true">
	                   		    <option/>
	                   		    <s:Options definition="$CH_MARKTYPE"/>
                     		</html:select>
                     		<font color="red">*</font>
                     	</c:if>
                     	<c:if test="${!updateState}">
                            <html:select property="marktype" onchange="selectMarktype();">
	                   		    <option/>
	                   		    <s:Options definition="$CH_MARKTYPE"/>
                     		</html:select>
                     		<font color="red">*</font>
                     	</c:if>
                        </c:when>
                        <c:otherwise>
                            <html:select property="marktype" disabled="true">
	                   		    <option/>
	                   		    <s:Options definition="$CH_MARKTYPE"/>
                     		</html:select>
                     		<font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="exmnitemdtl" key="mark"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState or cmdState=='EDIT'}">
                        	<span id="basemkSpan" style="display: none">
                            	<bean:message bundle="exmnitemdtl" key="basemk"/>:
                            </span>
                            <html:text styleClass="form_input_1x" property="basemk" />
                            <span id="dynamicmkSpan" style="display: none">
                            <bean:message bundle="exmnitemdtl" key="dynamicmk"/>:<html:text styleClass="form_input_year" property="dynamicmk" />
                            </span>
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <span id="basemkSpan" style="display: none">
                            	<bean:message bundle="exmnitemdtl" key="basemk"/>:
                            </span>
                            <html:text styleClass="form_input_1x" property="basemk" disabled="true"/>
                            <span id="dynamicmkSpan" style="display: none">
                            <bean:message bundle="exmnitemdtl" key="dynamicmk"/>:<html:text styleClass="form_input_year" property="dynamicmk" disabled="true" />
                            </span>
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="exmnitemdtl" key="leastcrtcl"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState or cmdState=='EDIT'}">
                            <html:text styleClass="form_input_1x" property="leastcrtcl" />
                            <font color="red">*</font>
                            <font id="leastcrtclGD" style="display: none" color="blue">省公司最小指标值：<c:out value='${form.leastcrtcl}' /></font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="leastcrtcl" disabled="true"/>
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="exmnitemdtl" key="largestcrtcl"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState or cmdState=='EDIT'}">
                            <html:text styleClass="form_input_1x" property="largestcrtcl" />
                            <font color="red">*</font>
                            <font id="largestcrtclGD" style="display: none" color="blue">省公司最大指标值：<c:out value='${form.largestcrtcl}' /></font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="largestcrtcl" disabled="true"/>
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
                           onclick="doSave('/cms/examine/exmnitemdtl.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/examine/exmnitemdtl.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
 <script language="JavaScript">
 		var marktype=document.getElementsByName("marktype")[0].value
     	if(marktype=='1'){//线性
     		document.getElementsByName("basemk")[0].className="form_input_year";
     		document.getElementById("basemkSpan").style.display="";
     		document.getElementById("dynamicmkSpan").style.display="";
     	}else{
     		document.getElementsByName("marktype")[0].value='0';
     		document.getElementsByName("basemk")[0].className="form_input_1x";
     		document.getElementById("basemkSpan").style.display="none";
     		document.getElementById("dynamicmkSpan").style.display="none";
     	}
     	if(document.getElementsByName("cmdState")[0].value=='EDIT'){//编辑的时候
     		var provincialright=document.getElementById("provincialright").value;
     		var exmncityid=document.getElementById("exmncityid").value;
     		if(provincialright=='YES' && exmncityid!='GD'){//省公司，但不是省公司考核
     			document.getElementsByName("basemk")[0].disabled=true;
     			document.getElementsByName("dynamicmk")[0].disabled=true;
     			document.getElementsByName("largestcrtcl")[0].disabled=true;
     			document.getElementsByName("leastcrtcl")[0].disabled=true;
     		}else if(provincialright!='YES'&& exmncityid=='GD'){//不是省公司，是省公司的考核
     			document.getElementById("leastcrtclGD").style.display="";
     			document.getElementById("largestcrtclGD").style.display="";
     			document.getElementsByName("basemk")[0].disabled=true;
     			document.getElementsByName("dynamicmk")[0].disabled=true;
     			var leastcrtcl="<c:out value="${cityexmnitemdtl.leastcrtcl}"/>";
     			var largestcrtcl="<c:out value="${cityexmnitemdtl.largestcrtcl}"/>";
     			if(leastcrtcl!="")
     				document.getElementsByName("leastcrtcl")[0].value=leastcrtcl;
     			if(largestcrtcl!="")
     				document.getElementsByName("largestcrtcl")[0].value=largestcrtcl;
     		}
     	}
     	
 </script>
</html>
