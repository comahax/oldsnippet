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
    <title><bean:message bundle="examinestd" key="titleUpdate"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/pub/xmlhttp.js"></script>
    <script language="JavaScript">
  
        function ev_checkval() {
            addfield('exmnstdname', '<bean:message bundle="examinestd" key="exmnstdname"/>', 'c', false, '50');
            if(document.getElementsByName("markmode")[0].value==''){
				var alertstr='<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[评分方式]</span>不能为空</span>';
				return errorMessageShow(alertstr);
			}
       		if(document.getElementsByName("markmode")[0].value=='1'){
				addfield('syslogic', '<bean:message bundle="examinestd" key="syslogic"/>', 'c', false, 1024);
				if(!checkSyslogic())
					return false;
			}else{
				addfield('syslogic', '<bean:message bundle="examinestd" key="syslogic"/>', 'c', true, 1024);
				
			}

            return checkval(window);
        }
        function checkSyslogic(){
        	var syslogic=document.getElementsByName("syslogic")[0].value;
        	if(syslogic!=null && syslogic.substring(0,3)=='SQL'){
        		var alertstr="SQL语句中没有包含";
        		if(syslogic.indexOf("@STARTTIME@")<0){
        			alertstr+='[@STARTTIME@]';
				
        		}
        		if(syslogic.indexOf("@ENDTIME@")<0){
        			alertstr+=' [@ENDTIME@]';
				
        		}
        		/*if(syslogic.indexOf("@QTFKNPARAM@")<0){
        			alertstr+=' [@QTFKNPARAM@]';
				
        		}*/
        		if(alertstr!="SQL语句中没有包含"){
        			alertstr="<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>"+alertstr+"</span></span>";
        			errorMessageShow(alertstr);
        			return false;
        		}else{
        			startAjax("<%=contextPath %>/cms/examine/examinestd.do?CMD=Validatesyslogic&syslogic="+syslogic,"callback()","text","GET",false);
	        		if(mypoint=='NO'){
						var alertstr="<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>SQL语句无法执行!</span></span>";
			   			errorMessageShow(alertstr);
			   			return false;
					}
					if(mypoint=='NOone'){
						var alertstr="<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>SQL只允许返回一列!</span></span>";
			   			errorMessageShow(alertstr);
			   			return false;			
					}
				}
        	}else if(syslogic!=null && syslogic.substring(0,3)=='PGM'){
        		/*startAjax("<%=contextPath %>/cms/examine/examinestd.do?CMD=Validatesyslogic&syslogic="+syslogic,"callback()","text","GET",false);
        		if(mypoint=='NO'){
					alertstr="<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>PGM程序不合法!</span></span>";
					errorMessageShow(alertstr);
					return false;
				}*/
        	}else{
        		alertstr="<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>你所填的系统考核逻辑不合法,系统考核逻辑内容必须以SQL:或PGM:开头</span></span>";
        	    errorMessageShow(alertstr);
        	    return false;
        	}
        	return true;
        	
        }
  		function callback(){
  		}
  		
          function selectMarkmode(val){
        	if(val=='1'){
        		document.getElementById("red_syslogic").style.display="";
        	}else{
        		document.getElementById("red_syslogic").style.display="none";
        	}
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/examine/examinestd.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_sk_exmnstdname"/>
    <html:hidden property="_se_markmode"/>
    <html:hidden property="exmnstdid"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/examine/examinestd/ExaminestdForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="examinestd" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="examinestd" key="exmnstdname"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="exmnstdname" />
                            <font color=red>*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="exmnstdname" disabled="true"/>
                            <font color=red>*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="examinestd" key="markmode"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	<html:select property="markmode" onchange="selectMarkmode(this.value)" >
                        		    <option/>
                        		    <s:Options definition="$CH_MARKMODE"/>
                        	  </html:select>
                            
                            <font color=red>*</font>
                        </c:when>
                        <c:otherwise>
                            <html:select property="markmode" onchange="selectMarkmode(this.value)" disabled="true">
                        		    <option/>
                        		    <s:Options definition="$CH_MARKMODE"/>
                        	  </html:select>
                            <font color=red>*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="examinestd" key="syslogic"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:textarea styleClass="form_textarea" property="syslogic" cols="70" rows="10"/>
                            <font id="red_syslogic" style="display: none"  color=red>*</font>
                        </c:when>
                        <c:otherwise>
                            <html:textarea styleClass="form_textarea" property="syslogic" cols="70" rows="10" disabled="true"/>
                            <font id="red_syslogic" style="display: none"  color=red>*</font>
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
                           onclick="doSave('/cms/examine/examinestd.do?CMD=SAVE')"/>
                   
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/examine/examinestd.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
 <script language="JavaScript">
    if(document.getElementsByName("markmode")[0].value=='1'){
       document.getElementById("red_syslogic").style.display=""; 
    }else if(document.getElementsByName("markmode")[0].value==''){
    	document.getElementsByName("markmode")[0].value='0';
    }
 </script>
</html>
