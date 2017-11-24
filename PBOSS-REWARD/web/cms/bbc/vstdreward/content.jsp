<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="vstdreward" key="titleUpdate"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
           if(objExists("max_pro_std")){
            var max=document.all("max_pro_std").value;
            if(!isNaN(max))
              {
            	var rewardstd=document.all("rewardstd").value;
            	if(rewardstd*1-max*1>0)
            	{
            	  alert("地市酬金标准不能大于省酬金标准:"+max);
            	  return false;
            	}
            }
            }
            addfield('rewardname', '<bean:message bundle="vstdreward" key="rewardname"/>', 'c', false, '40');
            addfield('opnid', '<bean:message bundle="vstdreward" key="opnid"/>', 'c', false, '18');
            addfield('region', '<bean:message bundle="vstdreward" key="region"/>', 'c', false, '10');
            addfield('ossrc', '<bean:message bundle="vstdreward" key="ossrc"/>', 'f', false, '2');
            addfield('rewardtype', '<bean:message bundle="vstdreward" key="rewardtype"/>', 'i', true, '3');
            addfield('intvmonth', '<bean:message bundle="vstdreward" key="intvmonth"/>', 'i', false, '5');
            addfield('rewardstd', '<bean:message bundle="vstdreward" key="rewardstd"/>', 'f', false, '14','2','',0);
            addfield('startdate', '<bean:message bundle="vstdreward" key="startdate"/>', 't', false, '7');
            addfield('stopdate', '<bean:message bundle="vstdreward" key="stopdate"/>', 't', false, '7');
            addfield('ruleid', '<bean:message bundle="vstdreward" key="ruleid"/>', 'c', false, '18');
            addfield('memo', '<bean:message bundle="vstdreward" key="memo"/>', 'c', false, '512');
			if(date_compare("startdate","stopdate",'启用时间不能大于停用时间')) return;
            return checkval(window);
        }
         function getOpnId() {
			var arg = new Array();
			var strUrl ="<%=contextPath%>/cms/bbc/operation.do?CMD=SELECT";
			var obj= window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
			document.all("opnid").value=obj;
			doGetValue();
			return obj;
		}
		function doShowRule(id) {
			var urlForPrint = contextPath + '/cms/reward/rule2.do?CMD=SELECTBBCRULE&PK=' + formItem.opnid.value;
			var returnValue = window.showModalDialog(urlForPrint, "", "dialogWidth=550px;dialogHeight=450px;status=no;resizable:yes;");
			returnValue = returnValue==null?"":returnValue;
			if (returnValue != "") {
				document.all(id).value = returnValue;
			}
		}
		function doGetValue(){
			var ossrc=document.all("ossrc").value;
			var opnid=document.all("opnid").value;
			var region=document.all("region").value;
			if(opnid!="" && region!="" && ossrc!="")
			{
			// ajaxAnywhere.submitByURL("/cms/bbc/vstdreward.do?CMD=GETVALUE&cmdstates=<c:out value="${requestScope['/cms/bbc/VstdrewardForm'].cmdState}" />"); 
			 document.formItem.action="<%=contextPath%>/cms/bbc/vstdreward.do?CMD=GETVALUE&cmdstates=<c:out value="${requestScope['/cms/bbc/VstdrewardForm'].cmdState}" />";
			 formItem.submit();
			}
		}
		function objExists(objName){ 
		  try{  
		   if(typeof eval(objName)=="undefined"){return false;}
		   if(typeof eval(objName)=="object"){return true;}
		  }catch(e){
		   return false;
		  } 
		 }
		
		function doGetValue2(){
			var opnid=document.all("opnid").value;
			var region=document.all("region").value;
			var ossrc=document.all("ossrc").value;
			var intvmonth=document.all("intvmonth").value;
			var startdate=document.all("startdate").value;
			var stopdate=document.all("stopdate").value;
			if(opnid!="" && region!="" && ossrc!="" && intvmonth!="" && startdate!="" && stopdate!="" && region!="999" )
			{
			 //ajaxAnywhere.submitByURL("<%=contextPath%>/cms/bbc/vstdreward.do?CMD=GETPROVINCESTD&cmdstates=<c:out value="${requestScope['/cms/bbc/VstdrewardForm'].cmdState}" />"); 
			 document.formItem.action="<%=contextPath%>/cms/bbc/vstdreward.do?CMD=GETPROVINCESTD&cmdstates=<c:out value="${requestScope['/cms/bbc/VstdrewardForm'].cmdState}" />";
			 formItem.submit();
			}else if(region!="999")
			{
			alert("请把资料填写完整再填写酬金标准");
			return;
			}
			document.all("rewardstd").focus;
		}
		
		function doReturnIndex(){
           var str = self.parent.location.toString();
           self.parent.location='<%=contextPath%>/cms/bbc/vstdreward.do?CMD=LIST';
        }
		
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/bbc/vstdreward.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_sk_rewardname"/>
    <html:hidden property="_se_opnid"/>
    <html:hidden property="_se_region"/>
    <html:hidden property="_ne_ossrc"/>
    <html:hidden property="_dnl_startdate"/>
    <html:hidden property="_dnm_stopdate"/>
    <html:hidden property="rewardid" />
    <html:hidden property="rewardtype" />
    <html:hidden property="rewardproj" />
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW' or requestScope.cmdState eq 'EDIT' or requestScope.cmdState eq 'NEW' or requestScope.cmdState eq 'GETVALUE')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/bbc/VstdrewardForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="vstdreward" key="titleList"/>
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
        		<td colspan=4 align=left>
        			<font color=blue>
        				基本信息
        			</font>
        		</td>
        	</tr>
        	 <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="vstdreward" key="opnid"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	<c:if test="${!updateState}">
                        		<html:text styleClass="form_input_1x" property="opnid" disabled="true" readonly="true"/>
                            	<input type="button" value="..." class="clickbutton"
										onclick="opnid.value=getOpnId();">
                        	</c:if>
                        	<c:if test="${updateState}">
                        		<html:text styleClass="form_input_1x" property="opnid" disabled="true" readonly="true"/>
							<font color=red>&nbsp;*</font>
                        	</c:if>
                            
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="opnid" disabled="true"/>
                            <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="vstdreward" key="region"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:hidden  property="region" />
                            <s:Code2Name definition="$region" code="${form.region}"  />
                        </c:when>
                        <c:otherwise>
                            <html:hidden  property="region" />
                            <s:Code2Name definition="$region" code="${form.region}"  />
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
             <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="vstdreward" key="acctype"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:radio property="acctype" value="1" disabled="true"></html:radio>
							<bean:message bundle="bbcstdrewardbj" key="acctype_num" />
							<html:radio property="acctype" value="2" disabled="true"></html:radio>
							<bean:message bundle="bbcstdrewardbj" key="acctype_scale" />
							<font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:radio property="acctype" value="1" disabled="true"></html:radio>
							<bean:message bundle="bbcstdrewardbj" key="acctype_num" />
							<html:radio property="acctype" value="2" disabled="true"></html:radio>
							<bean:message bundle="bbcstdrewardbj" key="acctype_scale" />
                            <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="vstdreward" key="ossrc"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	<c:if test="${!updateState}">
                        		<html:select property="ossrc" onchange="doGetValue()">
		                    	<option/>
		                    	<html:option value="0">社会渠道代理商</html:option>
		                    	<html:option value="1">网盟</html:option>
		                    	<html:option value="3">全员代理</html:option>
		                    	</html:select>
		                    <font color=red>&nbsp;*</font>
                        	</c:if>
                        	<c:if test="${updateState}">
                        		<html:select property="ossrc" disabled="true">
		                    	<option/>
		                    	<html:option value="0">社会渠道代理商</html:option>
		                    	<html:option value="1">网盟</html:option>
		                    	<html:option value="3">全员代理</html:option>
		                    	</html:select>
		                    <font color=red>&nbsp;*</font>
                        	</c:if>
                            
                        </c:when>
                        <c:otherwise>
                           <html:select property="ossrc" disabled="true">
		                    	<option/>
		                    	<html:option value="0">社会渠道代理商</html:option>
		                    	<html:option value="1">网盟</html:option>
		                    	<html:option value="3">全员代理</html:option>
		                    	<html:option value="4">新数据业务</html:option>
		                    </html:select>
                            <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
             <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="vstdreward" key="startdate"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <input name="startdate" readonly="true" class="form_input_1x" onclick="this.value=selectDate()" value="<fmt:formatDate pattern='yyyy-MM-dd' value="${form.startdate}" />">
                            <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <input name="startdate" disabled="true" class="form_input_1x"   value="<fmt:formatDate pattern='yyyy-MM-dd' value="${form.startdate}" />">
                            <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="vstdreward" key="stopdate"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <input name="stopdate" readonly="true" class="form_input_1x" onclick="this.value=selectDate()" value="<fmt:formatDate pattern='yyyy-MM-dd' value="${form.stopdate}" />">
                            <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <input name="stopdate" disabled="true" class="form_input_1x" value="<fmt:formatDate pattern='yyyy-MM-dd' value="${form.stopdate}" />">
                            <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
            	<td colspan=4>
            	<center>备注 :如果选择计酬方式为<font color=blue>按笔数计算</font>,举例填酬金上限<font color=blue>22元</font>则应该填<font color=blue>22</font><br></center>
				<center>如果选择计酬方式为按比例计算,举例填酬金上限<font color=blue>22%</font>则应该填<font color=blue>0.22</font>     <br></center>
				<center>业务办理时间发生在"启用时间"和"停用时间"区间段内的酬金标准用于酬金计算.<br></center>
            	
            	</td>
            </tr>
            <tr>
               
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="vstdreward" key="rewardname"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="rewardname"  disabled="true" />
                            <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rewardname" disabled="true"/>
                            <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="vstdreward" key="intvmonth"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="intvmonth" />
                            <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="intvmonth" disabled="true"/>
                            <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <aa:zone name="getprovincestd">
            <tr>
               
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="vstdreward" key="rewardstd"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="rewardstd" />
                            <font color=red>&nbsp;*</font><br>
                            <c:if test="${form.acctype eq '1' and not empty form.max_pro_std}">
									<font color=red>(省公司酬金上限:<c:out value='${form.max_pro_std}'/>元)</font>
									<input type="hidden" value="<c:out value='${form.max_pro_std}'/>" name="max_pro_std" id="max_pro_std"/>
							</c:if>
							<c:if test="${form.acctype eq '2' and not empty form.max_pro_std}">
									<font color=red>(省公司酬金上限:<c:out value='${form.max_pro_std*100}'/>%)</font>
									<input type="hidden" value="<c:out value='${form.max_pro_std*100}'/>" name="max_pro_std" id="max_pro_std"/>
							</c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rewardstd" disabled="true"/>
                            <input type="hidden" value="" name="max_pro_std"/>
                            <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="vstdreward" key="ruleid"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text readonly="true" styleClass="form_input_1x" property="ruleid"  disabled="true"/>
                            <input type="button" value="..." class="clickButton" onclick="doShowRule('ruleid')" >
                            <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="ruleid" disabled="true"/>
                            <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            </aa:zone>
        </table>
    </div>
	
    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" class="form_table_center">
                	<s:RewardPurChk controlid="CH_B2M_REWARD_PROVINCIAL||CH_B2M_REWARD_CIVIC">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/bbc/vstdreward.do?CMD=SAVE')"/>
                    </s:RewardPurChk>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturnIndex()">
                        <%--  doReturn('/cms/bbc/vstdreward.do?CMD=LIST')--%>  
                </td>
            </tr>
        </table>
    </div>
    <aa:zone name="getvalue">
    	<c:if test="${requestScope.SHOW=='TRUE'}" >
    	<div class="table_container">
    		 <table class="top_table">
		    	<tr>
		    		<td>
		    			已设置的酬金标准
		   			</td>
		    	</tr>
		    </table>
		    <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>酬金名称</td>
                <td>启用时间</td>
                <td>停用时间</td>
                <td>酬金标准（元）</td>
                <td>间隔月份</td>
                <td>酬金类型</td>
                <td>有效性检验规则</td>
                <td>区域</td>
                <td>业务平台来源</td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center">
                     <td><c:out value="${item.rewardname}"/></td>
                     <td><c:out value="${item.startdate}"/></td>
                     <td><c:out value="${item.stopdate}"/></td>
                     <td><c:out value="${item.rewardstd}"/></td>
                     <td><c:out value="${item.intvmonth}"/></td>
                     <td>
                     <s:Code2Name definition="$CH_BBCREWARDTYPE" code="${item.rewardtype}"  />
                     </td>
                     <td>
                     <s:Code2Name definition="#CH_ADT_RULE" code="${item.ruleid}"  />
                     </td>
                     <td>
                     <s:Code2Name definition="$region" code="${item.region}"  />
                     </td>
                     <td>
                     <c:choose>
                        <c:when test="${item.ossrc==0}">
                        	社会渠道代理商
                        </c:when>
                        <c:when test="${item.ossrc==1}">
                        	网盟
                        </c:when>
                        <c:when test="${item.ossrc==3}">
                        	全员代理
                        </c:when>
                        <c:otherwise>
                        	<c:out value="${item.ossrc}" />
                        </c:otherwise>
                        </c:choose>
                     </td>
                 </tr>
             </c:forEach>
        </table>
        </div>
    	</div>
    </c:if>
 </aa:zone>
</html:form>
</div>
</body>
</html>
