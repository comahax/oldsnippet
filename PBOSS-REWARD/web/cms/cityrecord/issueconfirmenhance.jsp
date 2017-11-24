<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "CH_ADT_CITYRECORD_AUDIT";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title>地市酬金明细确认管理</title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/jquery/jquery-1.3.2.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_recordid', '<bean:message bundle="cityrecord" key="recordid"/>', 'f', 'false', '14');
            addfield('_se_opnid', '<bean:message bundle="cityrecord" key="opnid"/>', 'c', 'false', '18');
            addfield('_sin_opnid', '<bean:message bundle="cityrecord" key="opnid"/>', 'c', 'false', '2000');
            addfield('_se_wayid', '<bean:message bundle="cityrecord" key="wayid"/>', 'c', 'false', '18');
            addfield('_ne_rewardtype', '<bean:message bundle="cityrecord" key="rewardtype"/>', 'f', 'false', '3');
            addfield('_se_rewardmonth', '<bean:message bundle="cityrecord" key="rewardmonth"/>', 'c', 'true', '6');
            addfield('_se_approveid', '<bean:message bundle="cityrecord" key="approveid"/>', 'c', 'false', '32');
            addfield('_ne_isflag', '<bean:message bundle="cityrecord" key="isflag"/>', 'f', 'false', '3');
            addfield('_ne_systemflag', '<bean:message bundle="cityrecord" key="systemflag"/>', 'f', 'false', '3');
            addfield('_nne_systemflag', '<bean:message bundle="cityrecord" key="systemflag"/>', 'f', 'false', '3');
            addfield('_ne_rewardlistid', '<bean:message bundle="cityrecord" key="rewardlistid"/>', 'f', 'false', '14');
            return (checkval(window) && checkMonth());
        }
        function checkMonth(){
        	var rewardmonth = document.getElementById('_se_rewardmonth').value;
        	var taskid = document.getElementById('_ne_taskid').value;
        	var ifpaymonth =jQuery("#supportPaymonth").val();
        	var paymonth = null;
        	if (ifpaymonth=='true') {
        	    paymonth = document.getElementById('_se_paymonth').value;
        	} 
        	taskid = trim(taskid);
        	if(taskid==null || taskid==''){ 
        		if (ifpaymonth!='true'){
	        		if(rewardmonth == ''){
			        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>【结算月份】</span> 不能为空 ';
						errorMessageShow(alertstr);
						return false;
	        		}
        		}else{//ifpaymonth=='true'
	        		if ( (''==paymonth || paymonth==null) && (''==rewardmonth ||rewardmonth==null)){
	        		    var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>【付款月份】【结算月份】</span>不能同时为空';
						errorMessageShow(alertstr);
						return false;
        		   }
        		}
        	}        	
        	return true;
        } 
        
        function doStat(cmd) {
        	var html = $('#_se_opnid2').html(); 
			$('#_subopnids').val(html);
            if(checkMonth()){
            	resetPage();
            	formList.action = contextPath + cmd + "?CMD=LISTSTAT";
                formList.submit();
            }
        }
        function doShowdetail(opnid2,rewardtype,oprmonth,isflag) {
            var _se_wayid = document.getElementById('_se_wayid').value;
            var _se_rewardmonth = document.getElementById('_se_rewardmonth').value;
            var _ne_systemflag = document.getElementById('_ne_systemflag').value;
            //var _se_opnid = document.getElementById('_se_opnid').value;
            var _sin_opnid= document.getElementById('_sin_opnid').value;
            //var _ne_isflag = document.getElementById('_ne_isflag').value;
            var _ne_taskid = document.getElementById('_ne_taskid').value;
            var _se_countyid = document.getElementById('_se_countyid').value; 
            
            var ifpaymonth =jQuery("#supportPaymonth").val();
        	var _se_paymonth = '';
        	if (ifpaymonth=='true') {
        	    _se_paymonth = document.getElementById('_se_paymonth').value;
        	}  
            
            var url= contextPath + '/cms/cityrecord.do?CMD=LISTDETAIL&opnid2='+opnid2+'&rewardtype='+rewardtype+'&oprmonth='+oprmonth+'&flg=false'+'&isflag='+isflag;
            if(_se_wayid!=''){
            	url = url + '&_se_wayid='+_se_wayid;
                }
            if(_se_rewardmonth!=''){
            	url = url + '&_se_rewardmonth='+_se_rewardmonth;
                }
            if(_ne_systemflag!=''){
            	url = url + '&_ne_systemflag='+_ne_systemflag;
                } 
            if(_sin_opnid!=''){
            	url = url + '&_sin_opnid='+_sin_opnid;
            } 
            if(_ne_taskid!=''){
            	url = url + '&_ne_taskid='+_ne_taskid;
            }
           if(_se_countyid!=''){
            	url = url + '&_se_countyid='+_se_countyid;
            }
           if(_se_paymonth!=''){
            	url = url + '&_se_paymonth='+_se_paymonth;
            }
            
    		window.showModalDialog(url , self , "dialogWidth:800px; dialogHeight:550px; status:no; resizable:yes;");
        }
        function doConfirmone(opnid2,rewardtype,oprmonth) {
        	if(confirm("是否确认将酬金结果发布给网点核查?")){
        		formList.action = contextPath + '/cms/cityrecord.do?CMD=CONFIRMONE&opnid2='+opnid2+'&rewardtype='+rewardtype+'&oprmonth='+oprmonth;
                formList.submit();
                formList.action = "<%=contextPath%>/cms/cityrecord.do?CMD=LISTSTAT";
            }
        }
        function doConfirmall() {
            if(confirm("提醒：全部确认前请务必先导出数据核对。是否确认将酬金结果发布给网点核查?")){
            	formList.action = contextPath + '/cms/cityrecord.do?CMD=ALLCONFIRM';
                formList.submit();
                formList.action = "<%=contextPath%>/cms/cityrecord.do?CMD=LISTSTAT";
            } 
        }
        function doExcelissue(){		
			formList.action = "<%=contextPath%>/cms/cityrecord.do?CMD=EXCELISSUE";
        	formList.submit();
        	formList.action = "<%=contextPath%>/cms/cityrecord.do?CMD=LISTSTAT";
		}		
		function showSelect() { 
		  var categorycode =document.getElementById('_sin_opnid') ;
		   var categorycodeValue = categorycode.value;
		  
		   //获取标识符字符串
		    var str = "";
		    if(categorycodeValue != ""){
		     var valArray = categorycodeValue.split(",");
		      
		     for(var i=0;i<valArray.length;i++){  
		       if (valArray[i].split(" ")[0].length==0) {  
		           str = str+ valArray[i].split(" ")[0]; 
		       }else if (valArray[i].split(" ")[0].length>0){  
		           str = str + valArray[i].split(" ")[0]+",";
		       }
		     } 
		    }  
		   	var strUrl = contextPath + "/cms/cityrecord.do?CMD=ALLFIFTHOPNIDS";
		   	var ret = window.showModalDialog(strUrl, self, "dialogWidth:700px; dialogHeight:450px; status:no; resizable:no;");  
		    
		  	if (ret.length>0 && 'NULL'!=ret) { 
					categorycode.value = ret;
			}else if(ret.length==0){ 
					categorycode.value = str;
			}  
		}
		
		function doLoadSub(value){//AJAX请求获取二级业务编码业务小类
			var success = function(data){//AJAX请求处理成功后回调函数
				if(data!=null && data!=''){
					var htmlstr = '';
					var opnArray = data.split(',');
					for(var i=0; i<opnArray.length; i++){
						var opn_name = opnArray[i].split(':');
						var opnid = opn_name[0];
						var name = opn_name[1];
						htmlstr += '<option value="'+opnid+'">'+name+'</option>'
					}
					jQuery('#_se_opnid2').append(htmlstr);
				}	
			};
			jQuery('#_se_opnid2').empty().append('<option/>');
			var url = contextPath + '/cms/dcord.do?CMD=LOADSUB';
			if(value!=null && value!=''){
				jQuery.post(url, {'upperopnid':value}, success, "text");
			}
		}
		$(document).ready(function(){
			var html = jQuery('#_subopnids').val();
			if(html != null && html != ''){
				jQuery('#_se_opnid2').empty();
				jQuery('#_se_opnid2').append(html);
			}
		});
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/cityrecord.do?CMD=LISTSTAT" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="iscountyoperid"/>
    <html:hidden property="_subopnids" styleId="_subopnids" />
    <html:hidden property="supportPaymonth" styleId="supportPaymonth"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/cityrecord/CityrecordForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>地市酬金明细确认管理</td>
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
                <td width="13%" height="20" align="right" class="form_table_right" ><bean:message bundle="cityrecord" key="wayid"/>:</td>
                <td width="37%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text><input type="button" value="..." 
                    	class="clickbutton" onclick="showSelectWay3(this,'_se_wayid','','','AG');this.value='...';" />
                </td>
            	<td width="15%" height="20" align="right" class="form_table_right" ><bean:message bundle="cityrecord" key="rewardmonth"/>:</td>
                <td width="35%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_rewardmonth" onclick="this.value=selectDateYYYYMM(this.value)"/><font color=red>*</font>
                </td>
            </tr>
            <tr>
            	<td width="13%" height="20" align="right" class="form_table_right" >业务大类:</td>
                <td width="37%" class="form_table_left">
                    <html:select property="_se_opnid" onchange="doLoadSub(this.value);">
                    	<option />
                    	<s:Options definition="#OPERATION" condition="opnlevel:1"/>
                    </html:select>
                </td>
                <td width="15%" height="20" align="right" class="form_table_right" ><bean:message bundle="cityrecord" key="systemflag"/>:</td>
                <td width="35%" class="form_table_left">
                    <html:select property="_ne_systemflag">
                    	<option />
                    	<s:Options definition="#SYSTEMFLAG" />
                    </html:select>
                </td>
            </tr>
            <tr>
            	<td width="13%" height="20" align="right" class="form_table_right" >业务小类:</td>
                <td width="37%" class="form_table_left">
                    <html:select property="_se_opnid2" styleId="_se_opnid2">
                    	<option />
                    </html:select>
                </td>
                <td rowspan="3" width="15%" align="right" class="form_table_right" >业务编码（多选）:</td>
            	<td rowspan="3" width="35%" class="form_table_left">
               		<html:textarea   property="_sin_opnid" rows="5" cols="30"></html:textarea>
                    <input type="button" value="..." class="clickbutton"
									onclick="showSelect();this.value='...';" />
            	</td>
            </tr>
            <tr>
            	<td width="13%" height="20" align="right" class="form_table_right" ><bean:message bundle="cityrecord" key="isflag"/>:</td>
                <td width="37%" class="form_table_left">
                    <html:select property="_ne_isflag">
                    	<option />
                    	<s:Options definition="#ISFLAG" />
                    </html:select>
                </td>
            </tr>
            <tr>
            	<td width="13%" height="20" align="right" class="form_table_right" >所属分公司:</td>
                <td width="37%" class="form_table_left">   
            	<c:choose>
	                <c:when test="${form.iscountyoperid==1}">   
	                <html:select property="_se_countyid">
	                <s:Options definition="#CNTYCOMPANY" condition="countycompid:${form._se_countyid}"/>
	                </html:select>
	                </c:when>
	                <c:otherwise>
	                <html:select property="_se_countyid">             	   
					<option />
	                <s:Options definition="#CNTYCOMPANY" condition="citycompid:${requestScope.cityid}"/>
	                </html:select>
                	</c:otherwise>
                </c:choose>
                </td>
            </tr>
            <tr>
            	<td width="13%" height="20" align="right" class="form_table_right" >任务号:</td>
                <td width="37%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_ne_taskid" ></html:text>
                    <font color='red'>填充[任务号]可不选[结算月份]</font>
                </td> 
         <c:if test="${form.supportPaymonth}">        
	 
				<td width="20%" height="20" align="right" class="form_table_right" >付款月份:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" styleId="paymonth" property="_se_paymonth" onclick="this.value=selectDateYYYYMM(this.value)"></html:text>
                </td> 
                 
			</tr>	
		</c:if>	 
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <input type="button" name="btnDelete" class="query" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_search"/>" onClick="doStat('/cms/cityrecord.do')">                
                		<input type="button" class="button_4"
							onmouseover="buttonover(this);" onmouseout="buttonout(this);"
							onfocus="buttonover(this)" onblur="buttonout(this)" value="导出" onclick="doExcelissue()"/>
						<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
                 		<input type="button" name="btnDelete" class="button_4" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="全部确认" onClick="doConfirmall()" />
             			</s:RewardPurChk>
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>
                    <bean:message bundle="cityrecord" key="opnidone"/>
                </td>
                <td><bean:message bundle="cityrecord" key="opnidtwo"/>
                </td>
                <td>
                    <bean:message bundle="cityrecord" key="rewardtype"/>
                </td>
                <td>
                	<bean:message bundle="cityrecord" key="oprmonth"/>
                </td>
                <td>
                    <bean:message bundle="cityrecord" key="sumbusivalue"/>
                </td>
                <td>
                    <bean:message bundle="cityrecord" key="sumpaymoney"/>
                </td>
                <td>
                    <bean:message bundle="cityrecord" key="sumconfirmmoney"/>
                </td>
                <td>
                    <bean:message bundle="cityrecord" key="sumnotconfirmmoney"/>
                </td>
                <td>
                    <bean:message bundle="cityrecord" key="issueconfirm"/>
                </td>
                <td>
                    <bean:message bundle="cityrecord" key="detail"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
            	<c:url value="" var="urlContent">
								
				</c:url>
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='#99FFCC'" onMouseOut="this.bgColor='#ffffff'">
                 	<c:url value="/cms/cityrecord.do?CMD=LISTDETAIL" var="urlContent">
								<c:param name="opnid2" value=""/>
								<c:param name="rewardtype" value=""/>
								<c:param name="oprmonth" value=""/>
					</c:url>
					<td> <s:Code2Name code="${item.opnid1}" definition="#OPERATION"/> </td>
					<td> <s:Code2Name code="${item.opnid2}" definition="#OPERATION"/> </td>
					<td> <s:Code2Name code="${item.rewardtype}" definition="#REWARDTYPE"/>  </td>
					<td> <c:out value="${item.oprmonth}"/> </td>
                 	<td><fmt:formatNumber pattern="0.00" value="${item.sumbusivalue}" /></td>
                 	<td><fmt:formatNumber pattern="0.00" value="${item.sumpaymoney}" /></td>
                 	<td <c:if test="${item.sumconfirmmoney != 0}">style="background-color:#FFFF00"</c:if>><fmt:formatNumber pattern="0.00" value="${item.sumconfirmmoney}" /></td>
                 	<td <c:if test="${item.sumnotconfirmmoney != 0}">style="background-color:#FF9966"</c:if>><fmt:formatNumber pattern="0.00" value="${item.sumnotconfirmmoney}" /></td>
                 	<td>
                 	
                 	<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
                      <input type="button" name="btnDelete" class="button_2" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="确认" onClick="doConfirmone('<c:out value="${item.opnid2}"/>','<c:out value="${item.rewardtype}"/>','<c:out value="${item.oprmonth}"/>')"
                            <c:if test="${item.sumnotconfirmmoney == 0}"> disabled </c:if>>
                 	</s:RewardPurChk>
                 	</td>
                 	<td>
                 		<input type="button" name="btnDelete" class="button_2" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="明细" onClick="doShowdetail('<c:out value="${item.opnid2}"/>','<c:out value="${item.rewardtype}"/>','<c:out value="${item.oprmonth}"/>','<c:out value="${item.isflag}"/>')">
                 	</td>
                 </tr>
             </c:forEach>
        </table>
     </div>
   </div>
   
   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
</html:form>
</div>
</body>
</html>
