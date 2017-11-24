<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ page import="com.sunrise.boss.ui.commons.User"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="3C3C1AAA50AA" />
</jsp:include>
<%
    String ID_1 = "3C3C1AAA50AABT1";
    String ID_2 = "3C3C1AAA50AABT2";
    String areacode = request.getParameter("areacode") == null ? ""
			: request.getParameter("areacode").toString();
	User user = (User) request.getSession().getAttribute(
			WebConstant.SESSION_ATTRIBUTE_USER);
	String cityid = user.getCityid();

	boolean isBelong = user.isProvinceUser();
	if (!isBelong)
		isBelong = areacode.trim().equals(cityid.trim());
%>
<html:html>
<head>
	<title><bean:message bundle="yxplansplitscale" key="titleUpdate" /></title>
	<script type="text/javascript" src="<%=contextPath%>/js/pub/xmlhttp.js"></script>
	<script language="JavaScript">
        function ev_checkval() {
            addfield('yxplanid', '<bean:message bundle="yxplansplitscale" key="yxplanid"/>', 'l', false, 20);
            addfield('yxplankindid', '<bean:message bundle="yxplansplitscale" key="yxplankindid"/>', 'l', false, 20);
            addfield('yxplantypeid', '<bean:message bundle="yxplansplitscale" key="yxplantypeid"/>', 'l', false, 20);
            addfield('yxplanitemid', '<bean:message bundle="yxplansplitscale" key="yxplanitemid"/>', 'l', false, 50);
            addfield('scale', '<bean:message bundle="yxplansplitscale" key="scale"/>', 'f', false, 5,2,'0.00',0.00,99999.99);             
        	
          	flag = checkval(window);
            if(flag)
            {
	            scale = parseInt(document.all("formItem").scale.value);
	            if(scale==0)
	            {
	            	alert('<bean:message bundle="yxplansplitscale" key="checkscaleinfo"/>');
	            	return false;
	            }	            
	        }
            return flag;
        }
        
		function doajax(myself,myurl,myobj) {
			myurl = contextPath + myurl + "?CMD=LOWGRD&rsncode=" + myself.value;
			startAjax(myurl,"selectchange('"+myobj+"')","text","get");
		}
	    
		function selectchange(obj) {
			var mc=unescape(mypoint);
			for (i=0;i<mc.length;i++) {
				mc = mc.replace("+"," ")
			}
			document.all(obj).innerHTML = mc;
		}
		
		 function selectYxplan(){
			var arg = new Array();
			var strUrl ="<%=contextPath%>/zifee/yxplan.do?CMD=SELECT";
			var returnValue= window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
			return returnValue;
		 }
		 
		 var retUrl="";
		 function getRetUrl(){
		 	retUrl = "/zifee/yxplansplitscale.do?CMD=LIST&lockOject=true&_ne_yxplanid="+formItem.yxplanid.value;
		 }
    </script>
</head>
<body onload="loadforiframe();getRetUrl();" >
<div class="table_container">
	<html:form action="/zifee/yxplansplitscale.do?CMD=SAVE" styleId="formItem" method="post">
		
		<html:hidden property="cmdState" />
		<html:hidden property="_orderby" />
		<html:hidden property="_desc" />
		<html:hidden property="_pageno" />
		<html:hidden property="_pagesize" />
		<html:hidden property="_ne_yxplanid"/>
		<input type="hidden" name="areacode" value="<%=areacode%>"/>
		<input type="hidden" name="lockOject" value='<c:out value="${param.lockOject}"/>' >

   		<c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW' or param.CMD eq 'EDITNEW' or requestScope['cmdState'] eq 'EDIT' )}"/>
		<c:set var="lockOject" scope="request" value="${!empty param.lockOject}"/>
		<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="yxplansplitscale" key="titleList"/>
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
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							<bean:message bundle="yxplansplitscale" key="yxplanid" />
							:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						
                        	<html:text styleClass="form_input_1x" property="yxplanid" disabled="true"></html:text>
		                
					</td>
				</tr>
				<tr>
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							<bean:message bundle="yxplansplitscale" key="yxplankindid" />
							:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						<c:choose>
							<c:when test="${param.CMD eq 'NEW'}">
								<html:select property="yxplankindid" onchange="doajax(this,'/zifee/yxplansplitscale.do','yxplantypeidbykindid')">
				            		<s:Options  definition="#ZIFEE-YXPLANKIND"/>
						        </html:select>								
							</c:when>
							<c:otherwise>
								<html:select property="yxplankindid" disabled="true">              		
				            		<s:Options  definition="#ZIFEE-YXPLANKIND"/>
						        </html:select>							
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							<bean:message bundle="yxplansplitscale" key="yxplantypeid" />
							:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left" id="yxplantypeidbykindid">
						<c:choose>
							<c:when test="${param.CMD eq 'NEW'}">
								<html:select property="yxplantypeid">                		
				            		<s:Options  definition="#ZIFEE-YXPLANTYPE"/>
						        </html:select>
							</c:when>
							<c:otherwise>
								<html:select property="yxplantypeid" disabled="true">                		
				            		<s:Options  definition="#ZIFEE-YXPLANTYPE"/>
						        </html:select>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>			
				
				<%
				//TO DO
				%>
				<tr>
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							<bean:message bundle="yxplansplitscale" key="yxplanitemid" />
							:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						<c:choose>
							<c:when test="${param.CMD eq 'NEW'}">
								<html:select property="yxplanitemid">	                		
			            			<s:Options  definition="$PC_YXCHAIFENITEM"/>
					        	</html:select>								
							</c:when>
							<c:otherwise>
								<html:select property="yxplanitemid" disabled="true" >                		
			            			<s:Options  definition="$PC_YXCHAIFENITEM"/>
					        	</html:select>								
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							<bean:message bundle="yxplansplitscale" key="scale" />
							:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						<c:choose>
							<c:when test="${edtState}">
								<html:text styleClass="form_input_1x" property="scale" />
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="scale" disabled="true" />
							</c:otherwise>
						</c:choose>
						<bean:message bundle="yxplansplitscale" key="amtunit" />
					</td>
				</tr>
			</table>
		</div>



		<div class="table_div">
			<table class="table_button_list">
				<tr>				
					<td width="100%" class="form_table_right">
					<%
								if (isBelong) {
								%>
						<s:PurChk controlid="<%=ID_1%>">
						<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_save"/>" class="submit"
							onclick="doSave('/zifee/yxplansplitscale.do?CMD=SAVE')" />
						</s:PurChk>
						 <%} %>
                    	<s:PurChk controlid="<%=ID_2%>">
                    	<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
						</s:PurChk>
						<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_return"/>" class="close"
							onclick="doReturn(retUrl)">
					</td>
				</tr>
			</table>
		</div>
	</html:form>
	</div>
</body>
</html:html>
