<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "CH_ADT_ADJUST_UP||CH_ADT_ADJUST_COUNTY";
    String ID_2 = "CH_ADT_MONITOR_CON||CH_ADT_ADJUST_COUNTY";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="dcord" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/jquery/jquery-1.3.2.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_countyid', '<bean:message bundle="dcord" key="countyid"/>', 'c', 'false', '14');
            addfield('_se_wayid', '<bean:message bundle="dcord" key="wayid"/>', 'c', 'false', '18');
            addfield('_sk_wayname', '<bean:message bundle="dcord" key="wayname"/>', 'c', 'false', '30');
            addfield('_ne_starlevel', '<bean:message bundle="dcord" key="starlevel"/>', 'f', 'false', '3');
            addfield('_se_opnid', '<bean:message bundle="dcord" key="opnid"/>', 'c', 'false', '2000');
            addfield('_se_upperopnid', '<bean:message bundle="dcord" key="upperopnid"/>', 'c', 'false', '18');
            addfield('_se_subopnid', '<bean:message bundle="dcord" key="subopnid"/>', 'c', 'false', '18');
            addfield('_se_oprmonth', '<bean:message bundle="dcord" key="oprmonth"/>', 'c', 'false', '6');
            addfield('_ne_rewardtype', '<bean:message bundle="dcord" key="rewardtype"/>', 'f', 'false', '3');
            addfield('_se_rewardmonth', '<bean:message bundle="dcord" key="rewardmonth"/>', 'c', 'false', '6');
            return (checkval(window) && checkParam());
        }
        function checkParam(){
        	var rewardmonth = document.getElementById('_se_rewardmonth').value;
        	var supportPaymonth = jQuery('#supportPaymonth').val();
        	if(supportPaymonth == 'false'){
	        	if(rewardmonth == ''){
		        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[结算月份]</span> 不能为空 ';
					errorMessageShow(alertstr);
					return false;
	        	}
        	}else{
        		var paymonth = jQuery('#paymonth').val();
        		if(rewardmonth =='' && paymonth==''){
        			var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[结算月份][付款月份]</span> 不能同时为空 ';
					errorMessageShow(alertstr);
					return false;
        		}
        	}        	
        	return true;
        }
        function showSelect() { 
		    var categorycode =document.getElementById('_se_opnid') 
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
		function doAdjust(seq_id,wayid,rewardmonth){
			var url = contextPath + '/cms/dcord.do?CMD=ADJUST';
			var isflag = document.getElementById(seq_id).value;
			if(isflag!=null && isflag!=''){
				jQuery.post(url,
					{"id":seq_id,"isflag":isflag,"wayid":wayid,"rewardmonth":rewardmonth},
					function(data){
						alert(data);
						//if(data!=null && data!=''){				}
					},
					"text"		
				);
			}			
		}
		function doExcel(){ 
		    if( ev_check() ){
		    	formList.action = "<%=contextPath%>/cms/dcord.do?CMD=EXCEL";
	        	formList.submit();
	        	formList.action = "<%=contextPath%>/cms/dcord.do?CMD=LIST";
		    }			
		}
		function doTxt(){ 
		    if( ev_check() ){
		    	formList.action = "<%=contextPath%>/cms/dcord.do?CMD=TXT";
	        	formList.submit();
	        	formList.action = "<%=contextPath%>/cms/dcord.do?CMD=LIST";
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
					jQuery('#_se_subopnid').append(htmlstr);
				}	
			};
			jQuery('#_se_subopnid').empty().append('<option/>');
			var url = contextPath + '/cms/dcord.do?CMD=LOADSUB';
			if(value!=null && value!=''){
				jQuery.post(url, {'upperopnid':value}, success, "text");
			}
		}
		function doBatch(){
        	var url=contextPath + '/cms/dcord.do?CMD=BATCH';
        	formList.action=url;
        	formList.submit();
        }
		
		function doQuery(){
			var html = jQuery('#_se_subopnid').html();
			jQuery('#_subopnids').val(html);
			resetPage();
			if(document.formList.onsubmit == null || document.formList.onsubmit()){
				document.formList.submit();
			}
		}
		jQuery(document).ready(function(){
			var html = jQuery('#_subopnids').val();
			if(html!=null && html!=''){
				jQuery('#_se_subopnid').empty();
				jQuery('#_se_subopnid').append(html);
			}
		});		
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/dcord.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_subopnids" styleId="_subopnids"/>
    <html:hidden property="citypermited"/>
    <html:hidden property="countypermited"/>
    <html:hidden property="supportPaymonth" styleId="supportPaymonth"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/dcord/DcordForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="dcord" key="titleList"/>&nbsp;&nbsp;
    			<font color='red'>该界面查询的明细记录为当前时间前一天完成确认的记录!</font>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="dcord" key="countyid"/>:</td>
                <td width="30%" class="form_table_left">                    
                    <c:choose>
                	   <c:when test="${form.citypermited==1}">   
                	   <html:select property="_se_countyid">             	   
						<option />
                    	<s:Options definition="#CNTYCOMPANY" condition="citycompid:${requestScope.cityid}"/>
                       </html:select>
                	   </c:when>
                	   <c:when test="${form.citypermited!=1 && form.countypermited==1 && form._se_countyid!=null}">
                	   <html:select property="_se_countyid">
                    	<s:Options definition="#CNTYCOMPANY" condition="countycompid:${form._se_countyid}"/>
                       </html:select>
                	   </c:when>
                	</c:choose>   
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="dcord" key="rewardmonth"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_rewardmonth" onclick="this.value=selectDateYYYYMM(this.value)"></html:text>
                    <c:if test="${!form.supportPaymonth}"><font color=red>*</font></c:if>
                </td>
            </tr>
            <tr>
            	<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="dcord" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text><input type="button" value="..." 
                    	class="clickbutton" onclick="showSelectWay3(this,'_se_wayid','','','AG');this.value='...';" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="dcord" key="wayname"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_wayname"></html:text>
                </td>
            </tr>
            <tr>
            	<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="dcord" key="starlevel"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_ne_starlevel">
                    	<option />
						<s:Options definition="$CH_STARLEVEL"></s:Options>
					</html:select>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="dcord" key="rewardtype"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_ne_rewardtype">
                    	<option />
                    	<s:Options definition="#REWARDTYPE" />
                    </html:select>
                </td>
            </tr>
            <tr>
            	<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="dcord" key="upperopnid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_se_upperopnid" onchange="doLoadSub(this.value);">
                    	<option />
                    	<s:Options definition="#OPERATION" condition="opnlevel:1"/>
                    </html:select>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="dcord" key="subopnid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_se_subopnid" styleId="_se_subopnid">
                    	<option />
                    </html:select>
                </td>                
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="dcord" key="oprmonth"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_oprmonth" onclick="this.value=selectDateYYYYMM(this.value)"></html:text>
                </td>
                <td rowspan="3" width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="dcord" key="_se_opnid"/>:</td>
                <td rowspan="3" width="30%" class="form_table_left">
                    <html:textarea   property="_se_opnid" rows="4" cols="30"></html:textarea>
                    <input type="button" value="..." class="clickbutton" onclick="showSelect();this.value='...';" />
                </td>
            </tr>
            <tr>
            	<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="dcord" key="batchno"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_batchno"></html:text>
                </td>
            </tr>
            <tr>
            	<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="dcord" key="abatchno"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_abatchno"></html:text>
                </td>
            </tr>
            <tr>
            	<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="dcord" key="isflag"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_ne_isflag">
                    	<option />
                    	<s:Options definition="$CH_ISFLAG" />
                    </html:select>
                </td>
                <c:choose>
                    <c:when test="${form.supportPaymonth}">
                        <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="dcord" key="paymonth"/>:</td>
		                <td width="30%" class="form_table_left">
		                    <html:text styleClass="form_input_1x" styleId="paymonth" property="_se_paymonth" onclick="this.value=selectDateYYYYMM(this.value)"></html:text>
		                </td>
                    </c:when>
                    <c:otherwise>
                        <td width="20%" height="20" align="right" class="form_table_right" ></td>
                		<td width="30%" class="form_table_left"></td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                		<s:RewardPurChk controlid="<%=ID_2%>" disableChild="true">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_search"/>" />
                        <input type="button" class="button_2" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
							onfocus="buttonover(this)" onblur="buttonout(this)" 
							value="导出TXT" onclick="doTxt()"/>
                        <input type="button" class="button_4" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
							onfocus="buttonover(this)" onblur="buttonout(this)" 
							value="导出EXCEL" onclick="doExcel()"/>
						</s:RewardPurChk> 
						 <s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
						 <input type="button" name="btnNew"  class="button_4" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="批量调整" onClick="doBatch()">
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
                    <a href="javascript:doOrderby('id')"><bean:message bundle="dcord" key="id"/></a>
                    <s:OrderImg form="/cms/dcord/dcordorm" field="id"/>
                </td>
                <td>
                    <bean:message bundle="dcord" key="countyid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="dcord" key="wayid"/></a>
                    <s:OrderImg form="/cms/dcord/DcordForm" field="wayid"/>
                </td>
                <td>
                    <bean:message bundle="dcord" key="wayname"/>                   
                </td>
                <td>
                    <bean:message bundle="dcord" key="starlevel"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="dcord" key="opnid"/></a>
                    <s:OrderImg form="/cms/dcord/DcordForm" field="opnid"/>
                </td>
                <td>
                    <bean:message bundle="dcord" key="opnname"/>
                </td>
                <td>
                    <bean:message bundle="dcord" key="upperopnid"/>
                </td>
                <td>
                    <bean:message bundle="dcord" key="subopnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprmonth')"><bean:message bundle="dcord" key="oprmonth"/></a>
                    <s:OrderImg form="/cms/dcord/DcordForm" field="oprmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardtype')"><bean:message bundle="dcord" key="rewardtype"/></a>
                    <s:OrderImg form="/cms/dcord/DcordForm" field="rewardtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardmonth')"><bean:message bundle="dcord" key="rewardmonth"/></a>
                    <s:OrderImg form="/cms/dcord/DcordForm" field="rewardmonth"/>
                </td>
                <td>
                    <bean:message bundle="dcord" key="gotonebusivalue"/>
                </td>
                <td>
                    <bean:message bundle="dcord" key="gotonemoney"/>
                </td>
                <td>
                    <bean:message bundle="dcord" key="szxbusivalue"/>
                </td>
                <td>
                    <bean:message bundle="dcord" key="szxmoney"/>
                </td>
                <td>
                    <bean:message bundle="dcord" key="mzonebusivalue"/>
                </td>
                <td>
                    <bean:message bundle="dcord" key="mzonemoney"/>
                </td>
                <td>
                    <bean:message bundle="dcord" key="tdbusivalue"/>
                </td>
                <td>
                    <bean:message bundle="dcord" key="tdmoney"/>
                </td>
                <td>
                    <bean:message bundle="dcord" key="otherbusivalue"/>
                </td>
                <td>
                    <bean:message bundle="dcord" key="othermoney"/>
                </td>
                <td>
                    <bean:message bundle="dcord" key="busivaluesum"/>
                </td>
                <td>
                    <bean:message bundle="dcord" key="moneysum"/>
                </td>
                <td>
                    <bean:message bundle="dcord" key="isflag"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('batchno')"><bean:message bundle="dcord" key="batchno"/></a>
                    <s:OrderImg form="/cms/dcord/DcordForm" field="batchno"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('abatchno')"><bean:message bundle="dcord" key="abatchno"/></a>
                    <s:OrderImg form="/cms/dcord/DcordForm" field="abatchno"/>
                </td>
                <c:if test="${form.supportPaymonth}">
                <td><bean:message bundle="dcord" key="paymonth"/></td>
                </c:if>
                <td>
                    <bean:message bundle="dcord" key="operationtitle"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/dcord.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.id}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='#99FFCC'" onMouseOut="this.bgColor='#ffffff'">
                     <td><c:out value="${item.id}"/></td>
                     <td><s:Code2Name code="${item.countyid}" definition="#CNTYCOMPANY" /></td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><c:out value="${item.wayname}"/></td>
                     <td><s:Code2Name code="${item.starlevel}" definition="$CH_STARLEVEL" /></td>
                     <td><c:out value="${item.opnid}"/></td>
                     <td><s:Code2Name code="${item.opnid}" definition="#OPERATION" /></td>
                     <td><s:Code2Name code="${item.upperopnid}" definition="#OPERATION" /></td>
                     <td><s:Code2Name code="${item.subopnid}" definition="#OPERATION" /></td>
                     <td><c:out value="${item.oprmonth}"/></td>
                     <td><s:Code2Name code="${item.rewardtype}" definition="#REWARDTYPE"/></td>
                     <td><c:out value="${item.rewardmonth}"/></td>
                     <td><c:out value="${item.gotonebusivalue}"/></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.gotonemoney}" /></td>
                     <td><c:out value="${item.szxbusivalue}"/></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.szxmoney}"/></td>
                     <td><c:out value="${item.mzonebusivalue}"/></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.mzonemoney}"/></td>
                     <td><c:out value="${item.tdbusivalue}"/></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.tdmoney}"/></td>
                     <td><c:out value="${item.otherbusivalue}"/></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.othermoney}"/></td>
                     <td><c:out value="${item.busivaluesum}"/></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.moneysum}"/></td>
                     <td>
                     	<c:choose>
                          <c:when test="${item.isflag==0}">
                          	<select id='<c:out value="${item.id}"/>' style="width:75px;">
                          		<option value='0' selected>待结算</option>
                          		<option value='3'>暂挂</option>
                          		<option value='4'>冻结</option>
                          	</select>
                          </c:when>
                          <c:when test="${item.isflag==3}">
                          	<select id='<c:out value="${item.id}"/>' style="width:75px;">
                          		<option value='0'>待结算</option>
                          		<option value='3' selected>暂挂</option>
                          		<option value='4'>冻结</option>
                          	</select>
                          </c:when>
                          <c:when test="${item.isflag==4}">
                          	<select id='<c:out value="${item.id}"/>' style="width:75px;">
                          		<option value='0'>待结算</option>
                          		<option value='3'>暂挂</option>
                          		<option value='4' selected>冻结</option>
                          	</select>
                          </c:when>
                          <c:otherwise>
                          	<s:Code2Name code="${item.isflag}" definition="$CH_ISFLAG" />
                          </c:otherwise>
                     	</c:choose>
                     </td>
                     <td><c:out value="${item.batchno}"/></td>
                     <td><c:out value="${item.abatchno}"/></td>
                     <c:if test="${form.supportPaymonth}">
                     <td><c:out value="${item.paymonth}"/></td>
                     </c:if>
                     <td>
                     	<c:choose>
                          <c:when test="${item.isflag==0 || item.isflag==3 || item.isflag==4}">
                          <s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
                          	<input type="button" value="<bean:message bundle="dcord" key="operation"/>" 
                          		onclick="doAdjust('<c:out value="${item.id}"/>','<c:out value="${item.wayid}"/>','<c:out value="${item.rewardmonth}"/>');" class="button_2">
                          </s:RewardPurChk>
                          </c:when>                         
                          <c:otherwise>
                          	&nbsp;
                          </c:otherwise>
                     	</c:choose>                     	
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
