<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
    String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL||CH_PW_REWARD_CIVIC";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="rewardpoolr" key="titleUpdate"/></title>
    <script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript">
    	
 	function forcheck(ob){
		var TO=true;
	 	 if (ob != null) {
	      if (ob.length != null) {
	         for (var i = 0; i < ob.length; i++) {
	             var e = ob[i];
	             if (e.type == 'checkbox') {
	                 if (e.checked)
	                     TO = false;
	             }
	         }
	      } else {
	          var e = ob;
	          if (e.type == 'checkbox') {
	              if (e.checked)
	                  TO = false;
	          }
	      }
		}
		if (TO) { 
	        return false;
	   	}
		return true;
	}  
	function rewardtypeCheck(){
		var value=formItem.rewardtype.value;
		if("0123456".indexOf(value)==-1){
			return false;	
		}else{
			return true;
		}
	}
    function ev_checkval() {
        //if(rewardtypeCheck()){
       	//	var value=formItem.inputrewardbuss.value;
       	//	if(value==""){
     //   		errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[入酬金池业务]</span>酬金类型为0(标准卡固定酬金)、1(标准卡积分酬金)、2(标准卡专门津贴)、3(数据业务基本酬金)、</br></br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4(数据业务奖励酬金)、5(服务业务基本酬金)、6(服务业务奖励酬金)时入酬金池业务为必填项</span>');     
     //   		return false;
     //   	}
        //}
    	//var ob = formItem.all("seleteSlv"); 
    	//if(!forcheck(ob)){
  	    //	 errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="stdrewardbs" key="slv"/>]</span><bean:message bundle="stdrewardbs" key="slv"/>不能为空</span>');     
        // 	return false; 
        //}
        addfield('rewardtype', '<bean:message bundle="rewardpoolr" key="rewardtype"/>', 'i', false, '5');
        addfield('region', '<bean:message bundle="rewardpoolr" key="region"/>', 'c', false, '10');
        addfield('slv', '<bean:message bundle="rewardpoolr" key="slv"/>', 'c', true, '40');
        addfield('startdate', '<bean:message bundle="rewardpoolr" key="startdate"/>', 't', false, '25');
        addfield('stopdate', '<bean:message bundle="rewardpoolr" key="stopdate"/>', 't', false, '25');
        addfield('memo', '<bean:message bundle="rewardpoolr" key="memo"/>', 'c', true, '512');
        addfield('proportion', '<bean:message bundle="rewardpoolr" key="proportion"/>', 'c', false, '15');
        addfield('cycle', '<bean:message bundle="rewardpoolr" key="cycle"/>', 'c', false, '10');

		if(proportionCheck())
        //alert(rewardtypeCheck());
        return checkval(window);
    }
    function proportionCheck(){    
    	var value1=formItem.proportion.value;    	
    	var value2=formItem.cycle.value;
    	var arg1 = value1.split("|");
    	var arg2 = value2.split("|");
    	//alert(arg1.length);
    	if(arg1.length != arg2.length){
    		errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="rewardpoolr" key="proportion"/>]与[<bean:message bundle="rewardpoolr" key="cycle"/>]期数要相一致</span>');     
     		return false;
    	}    	
    	var sum=0;
    	for(var i=0;i<arg1.length-1;i++){
    		var re = /^-?[1-9]*(\.\d*)?$|^-?0(\.\d*)?$/;
    		//alert(!re.test(arg1[i]));
    		if(!re.test(arg1[i])){
    			errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="rewardpoolr" key="proportion"/>]含非法数字</span>');
    			return false;
    		}else if(arg1[i] <= 0 ){
    			//alert(arg1[i]+"未精确");
    			errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="rewardpoolr" key="proportion"/>]每期设置值必须大于0</span>');
    			return false;
    		}else if(arg1[i].indexOf(".")>0 && arg1[i].substring(arg1[i].indexOf(".")+1).length>2){
    			//alert(arg1[i]+"未精确");
    			errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="rewardpoolr" key="proportion"/>]最多精确到2位小数录入</span>');
    			return false;
    		}else{
	    		//alert(arg1[i]);
				sum += parseFloat(arg1[i]);
			}
		}
		//alert(sum);
		if(sum!=10){
			errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="rewardpoolr" key="proportion"/>]多期发放比例之和必须等于10(100%)</span>');     
     		return false;
		}
		var temp=0;
		for(var j=0;j<arg2.length-1;j++){
			//var r = /^[0-9]*[1-9][0-9]*$/;//正整数
			var r = /^\d+$/;//非负整数（正整数 + 0） 
    		//alert(!r.test(arg1[i]));
    		if(!r.test(arg2[j])){
    			errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="rewardpoolr" key="cycle"/>]必须是正整数或0</span>');
    			return false;
    		}else if(temp > arg2[j]){
    			errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="rewardpoolr" key="cycle"/>]后面的期数应大于前面的期数</span>');
    			return false;
    		}else{
    			temp = arg2[j];
    		}
		}
    	return true;
    }    
    function getRewarBussValues(definition,obj) {
		var originalValue = event.srcElement.value;
		var rewardtype=formItem.rewardtype.value;
		if(rewardtype=="" || rewardtype=="7" || rewardtype=="8" || rewardtype=="-1"||rewardtype=="30"||rewardtype=="78"){
			return;
		}
		
		var arg = new Array();
		var strUrl = contextPath + "/commons/rewardopr.do?CMD=select&definition=" + definition + "&originalStr=" + originalValue+"&EXTEND1="+rewardtype;
		var ret = window.showModalDialog(strUrl, arg, "dialogWidth:720px; dialogHeight:360px; status:no; resizable:no;");
		if (ret == null || ret == '') {
			ret = originalValue;
			ret = '';
		}
		obj.value=ret;
	}
    </script> 
</head>
<body>
<div class="table_container">
<html:form action="/cms/rewardpoolr.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_rewardtype"/>
    <html:hidden property="_se_region"/>
    <html:hidden property="_dnl_startdate"/>
    <html:hidden property="_dnm_stopdate"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="rewardpoolr" key="titleList"/>
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
        <tr><td colspan="4">
					<bean:message bundle="rewardpoolr" key="tishi" />
					</td></tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rewardpoolr" key="rewardtype"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:select property="rewardtype" disabled="true">
									<option />
										<s:Options definition="$CH_REWARDTYPE" />
					</html:select>
                        </c:if>
                        <c:if test="${!updateState}">
                             <html:select property="rewardtype">
									<option />
										<s:Options definition="$CH_REWARDTYPE" />
					</html:select>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                         <html:select property="rewardtype" disabled="true">
									<option />
										<s:Options definition="$CH_REWARDTYPE" />
					</html:select>
                        </c:otherwise>
                    </c:choose><font color=red>&nbsp;*</font>
                </td>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rewardpoolr" key="region"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:select property="region" disabled="true">
										 <html:option value=""></html:option>  
                        		  			  <s:Options definition="$region"/>
                        					  </html:select>
                        </c:if>
                        <c:if test="${!updateState}">
                        	<c:if test="${showCityList eq '1'}">
								<html:select property="region">
												<html:option value=""></html:option>
	                        		  			  <s:Options definition="$region"/>
	                        					  </html:select>
	                        </c:if>
	                        <c:if test="${!(showCityList eq '1')}">
	                        	<html:select property="region" disabled="true">
												<html:option value=""></html:option>
	                        		  			  <s:Options definition="$region"/>
	                        					  </html:select>
	                        </c:if>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:select property="region" disabled="true">
										 <html:option value=""></html:option>  
                        		  			  <s:Options definition="$region"/>
                        					  </html:select>
                        </c:otherwise>
                    </c:choose><font color=red>&nbsp;*</font>
                </td>
            </tr>           
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rewardpoolr" key="inputrewardbuss"/>:</div></td>
                <td width="30%" align="left" class="form_table_left" colspan="4">
                   <html:textarea property="inputrewardbuss" rows="3" cols="70" readonly="true" onclick="getRewarBussValues('REWARDBUSSSELECTS',this)"/>
                   <html:hidden property="beforinputrewardbuss"/>
                   </br>可选(不选择业务则默认该酬金类型下的所有业务均入酬金池),点击输入框进行选择业务
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rewardpoolr" key="startdate"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                             <input class="form_input_1x" type="text" name="startdate"
											value="<fmt:formatDate value="${requestScope['/cms/rewardpoolr/RewardpoolrForm'].startdate}"
											pattern="yyyy-MM-dd" />"
											onclick="this.value=selectDate();" readonly="true" />
                        </c:when> 
                        <c:otherwise>
                            <input class="form_input_1x" type="text" name="startdate"
											value="<fmt:formatDate value="${requestScope['/cms/rewardpoolr/RewardpoolrForm'].startdate}"
											pattern="yyyy-MM-dd" />"
											onclick="this.value=selectDate();" disabled="true" />
                        </c:otherwise>
                    </c:choose><font color=red>&nbsp;*</font>
                </td>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rewardpoolr" key="stopdate"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <input class="form_input_1x" type="text" name="stopdate"
											value="<fmt:formatDate value="${requestScope['/cms/rewardpoolr/RewardpoolrForm'].stopdate}"
											pattern="yyyy-MM-dd" />"
											onclick="this.value=selectDate();" readonly="true" />
                        </c:when>
                        <c:otherwise>
                            <input class="form_input_1x" type="text" name="startdate"
											value="<fmt:formatDate value="${requestScope['/cms/rewardpoolr/RewardpoolrForm'].startdate}"
											pattern="yyyy-MM-dd" />"
											onclick="this.value=selectDate();" disabled="true" />
                        </c:otherwise>
                    </c:choose><font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rewardpoolr" key="proportion"/>:</div></td>
                <td width="30%" align="left" class="form_table_left" colspan="4">
                    <c:choose>
                        <c:when test="${edtState}">                        
                            <html:text styleClass="form_input_1x"  property="proportion" />
                        </c:when>
                        <c:otherwise>
                        	<html:text styleClass="form_input_1x"  property="proportion" disabled="true" />
                        </c:otherwise>
                    </c:choose><font color=red>&nbsp;*&nbsp;默认发放比例为4|3|3|,即40%|30%|30%|,酬金池最多分三期,多期发放比例之和必须等于10(100%),市公司可视情况调整</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rewardpoolr" key="cycle"/>:</div></td>
                <td width="30%" align="left" class="form_table_left" colspan="4">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x"  property="cycle"/>
                        </c:when>
                        <c:otherwise>
                        	<html:text styleClass="form_input_1x"  property="cycle" disabled="true" />
                        </c:otherwise>
                    </c:choose><font color=red>&nbsp;*&nbsp;默认发放周期为1|4|7|,市公司可视情况调整(0表示当前结算月,1表示结算月次月)</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rewardpoolr" key="memo"/>:</div></td>
                <td width="30%" align="left" class="form_table_left" colspan="4">
                    <c:choose>
                        <c:when test="${edtState}">
                        
                            <html:textarea property="memo" rows="3" cols="70"/>
                        </c:when>
                        <c:otherwise>
                        	<html:textarea property="memo" rows="3" cols="70" disabled="true" />
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
            	  <s:RewardPurChk controlid="<%=ID_1%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/rewardpoolr.do?CMD=SAVE')"/>
                  </s:RewardPurChk>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/rewardpoolr.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
