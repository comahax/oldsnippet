<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('orderamt', '数量', 'f', false, '10');
            return checkval(window);
        }
        
        var count = 0;//数量
        var total = 0;//总价
        
        //迭加数量和总价
        function stat(num,price){
        	count += num;
        	total += price;
        }
        $(document).ready(function(){ 
	        	
    	}); 
    	
    	  //订单下一步处理
	     function doNext(actionUrl){
	     	var orderid="<s:property value="form.orderid"/>";//选中的订单步骤编号
			$.post("<%=contextPath%>"+actionUrl,
	        {'form.orderid':orderid},
			     function(data){
			     var result = data.split(',');
			     if('0' == result[0]){
			     window.location.href ="<%=contextPath%>"+result[1]+"?param._pk="+orderid+"&param._se_orderid="+orderid;
			     	//window.open(result[1]+"?param._pk="+orderid+"&param._se_orderid="+orderid);
			     }else{
				     var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>'+result[1]+'</span> ';
					errorMessageShow(alertstr);
			     }
			       
			     }   
	        ); 
	     }
	      /*
	     *提交审核
	     */
	     function doAudit(){
	     	var orderid=$(":hidden[name='param._se_orderid']").val();
	     	var status=false;
			jQuery.ajax({
				type:"POST",
				url:"<%=contextPath %>/sales/audit_checkAudit.do",
				async:false, //同步
				data:"selectitems="+orderid,			
				success:function(msg){
					if(msg=='no'){
						var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[存在异常状态记录，不允许提交审核]</span>';
						errorMessageShow(alertstr);
						status= false;
					}else{
						status=true;
					}
				}
			});
			if(status){
		     	var returnValue=getAuditingRoleList();
		     	if(returnValue!=undefined){
		     		var strs=returnValue.split(",");
		     		$("#buttonAudit").attr("disabled","true");
		     		formList.action="<%=contextPath%>/sales/order_submitAudit.do?operid="+strs[0];
	       			formList.submit();
		     	}
		     }
	     }
	     //审批人弹出框
	     function getAuditingRoleList(){
	     	var returnValue=window.showModalDialog('<%=contextPath %>/base/operator_auditingRoleList.do',window,"dialogWidth=500px;dialogHeight=430px;status:no;scroll=yes;");
		    if(returnValue!=undefined){
		    	return returnValue;
			}
	     }
	      $(document).ready(function(){ 
	      	if($(":hidden[name='form.hasAudit']").val()=='Y'){
	      		$("#buttonAudit").attr("disabled","true");
	      		$("#buttonAdj").attr("disabled","true");
	      	}
	      	if($(":hidden[name='form.hasWaitAudit']").val()=='Y'){
	      		$("#buttonApp").attr("disabled","true");
	      	}
	      });

		function openAdj(ordcomid)
		{
			var url=contextPath + '/sales/ordcomlog_list.do?flag=1&form.ordcomid='+ ordcomid;
			window.showModalDialog(url ,self, "dialogWidth:800px; dialogHeight:500px; status:no; resizable:no;");
		}
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="order_appList.do" key="formList" cssStyle="formList" theme="simple" >
	<%//下面的控件给Action提供数据，用来分页%>
	
	 <aa:zone name="hiddenZone">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
    <s:hidden name="param._se_orderid"/>
    <s:hidden name="outstate"/>
    <s:hidden name="form.hasAudit"/>
    <s:hidden name="form.hasWaitAudit"/>
    <s:hidden name="form.param44"/>
    </aa:zone>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleAppList"/></span>
		</div>
	</div>
    
   
    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>
<div class="table_div">
	<table class="table_normal">
	<tr>
		<td>
			<FIELDSET>
				<legend>订单信息</legend>
		        <table class="table_normal">
		            <tr>
		                <td align="right"><s:text name="orderid"/>:&nbsp</td>
		                <td align="left">
							<s:property value="form.orderid"/>
		                </td>
		                <td align="right"><s:text name="createtime"/>:&nbsp</td>
		                <td align="left">
							<s:date name="form.createtime" format="yyyy-MM-dd"/>
		                </td>
		                <td align="right"><s:text name="orderstate"/>:&nbsp</td>
		                <td align="left">
							<j:code2Name definition="$FX_ORDERFSTATE" code="form.orderstate"/>
		                </td>
		            </tr>
		            <tr>
		             	<td align="right"><s:text name="wayid"/>:&nbsp</td>
		                <td align="left">
		                <!-- 
		                	<j:code2Name definition="#WAY" code="form.wayid"/>
		                -->
		                <s:property value="form.wayid" />
		                </td>
		                 <td align="right">合作商名称:&nbsp</td>
		                <td align="left">
							<j:code2Name definition="#WAYIDINFO" code="form.wayid"/>
		                </td>
		                <td align="right"><s:text name="orderave"/>:&nbsp</td>
		                <td align="left">
							<j:code2Name definition="$FX_ORDERAVE" code="form.orderave"/>
		                </td>
		
		            </tr>
		            <tr>
		            	<td align="right"><s:text name="countyid"/>:&nbsp</td>
		                <td align="left">
							<j:code2Name definition="#CNTYCOMPANY" code="form.countyid"/>
		                </td>
		                 <td align="right"><s:text name="cooptype"/>:&nbsp</td>
		                <td align="left">
							<s:property value="form.custwaytypename" />
		                </td>
		                <td align="right"><s:text name="starlevel"/>:&nbsp</td>
		                <td align="left">
							 <j:code2Name definition="$CH_STARLEVEL" code="form.starlevel"/>
		                </td>
		            </tr>
		
		            <tr>
		            	<td align="right"><s:text name="paytype"/>:&nbsp</td>
		                <td align="left">
							<j:code2Name definition="$FX_PAYTYPE" code="form.paytype"/>
		                </td>
		                <td align="right"><s:text name="delitype"/>:&nbsp</td>
		                <td align="left">
							<j:code2Name definition="$FX_DELITYPE" code="form.delitype"/>
		                </td>
		                <td align="right"><s:text name="posstream"/>:&nbsp</td>
		                <td align="left">
							<s:property value="form.posstream"/>
		                </td>
		            </tr>
		
		            <tr>
		                <td align="right"><s:text name="bossworkfid"/>:&nbsp</td>
		                <td align="left">
							<s:property value="form.bossworkfid"/>
		                </td>
		                <td align="right"><s:text name="recamt"/>:&nbsp</td>
		                <td align="left">
							<s:property value="form.recamt"/>
		                </td>
		                <td align="right"><s:text name="actamt"/>:&nbsp</td>
		                <td align="left">
							<s:property value="form.actamt"/>
		                </td>
		            </tr>
		              <tr>
		                <td align="right"><s:text name="paytime"/>:&nbsp</td>
		                <td align="left">
							<s:date name="form.paytime" format="yyyy-MM-dd HH:mm:ss"/>
		                </td>
		                <td align="right"><s:text name="deductstate"/>:&nbsp</td>
		                <td align="left">
							<j:code2Name definition="$FX_DEDUCTSTATE" code="form.deductstate"/>
		                </td>
		                <td align="right"><s:text name="discomcode"/>:&nbsp</td>
		                <td align="left">
							<j:code2Name definition="#WAYIDINFO" code="form.discomcode"/>
		                </td>
		              </tr>
		              
		               <tr>
		               <td align="right"><s:text name="signstate"/>:&nbsp</td>
		                <td align="left" >
		               	 <j:code2Name definition="$FX_SIGNSTATE" code="form.signstate"/>
		                </td>
		               <td align="right"><s:text name="orderinfo"/>:&nbsp</td>
		                <td align="left" colspan="3">
								<s:property value="form.orderInfo"/>
		                </td>
		                
		            </tr>
		              <tr>
		              	<s:if test="form.showAus">
		              	<td align="right"><font color="red">主动放弃次数:</font>&nbsp</td>
		                <td align="left" >
								<font color="red"><s:property value="form.giveCount"/>（最近<s:property value="form.monthParam"/>个月）</font>
		                </td>
		                <td align="right"><s:text name="memo"/>:&nbsp</td>
		                <td align="left" colspan="3">
		                </s:if>
		                <s:else>
		                <td align="right"><s:text name="memo"/>:&nbsp</td>
		                <td align="left" colspan="5">
		                </s:else>
								<s:property value="form.memo"/>
		                </td>
		            </tr>
		        </table>
	        </FIELDSET>
		</td>
		<s:if test="form.showAus">
		<td STYLE="vertical-align:top">
			<FIELDSET>
				<legend>辅助信息</legend>
				  <table class="table_normal" >
					<tr> 
					  <td  rowspan="2"></td>
					  <td align="center" rowspan="2">分公司库存</td>
					  <td align="center" rowspan="2">网点库存</td>
					  <td align="center" colspan="<s:property value="form.stattypes.length"/>">网点激活率</td>
					</tr>
					<tr> 
					  <s:iterator value="form.stattypes" var="var">
					  <td  align="center">
					  
					  最近<s:text name="#var"/>个月</td>
					  </s:iterator>
					</tr>
					
					<s:iterator value="form.auxInfoList"  >
					<tr> 
					  <td align="center"><j:code2Name definition="$FX_SMPBRAND" code="brand"/></td>
					  <td align="center"><s:property value="countyStock"/></td>
					  <td  align="center"><s:property value="wayStock"/></td>
					  <s:iterator value="form.stattypes" var="var">
					  <td align="center">
					  <s:iterator value="auxilaryActalarmList">
					  		<s:if test="stattype == #var">
					  	  	<s:property value="rate*100"/>%
					  	  	</s:if>
					  </s:iterator>
					  </td>
					  </s:iterator>
					 
					</tr>
					</s:iterator>
					
				  </table>
			</FIELDSET>
		</td>
		</s:if>
	</tr>
</table>
    </div>
    
	 <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
                	<s:i18n name="public">
                		<j:purChk permid="FX_ORDERMGR_SMT">
                		<input type="button" id="buttonAudit" name="buttonAudit" class="button_4" onmouseover="buttonover(this);" 
	                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="提交审核" onclick="doAudit()" />
	                    </j:purChk>
	                    <j:purChk permid="FX_ORDERMGR_AUDIT">
						<input type="button" id="buttonApp" name="buttonApp" class="button_4" onmouseover="buttonover(this);" 
	                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="<s:text name="button_appPass"/>" onclick="doAppPass()" 
	                           <s:if test="outstate!='AUDITED'">disabled = "true"</s:if>/>
	                    </j:purChk>
	                    <input type="button" id="button_doNext" name="button_doNext" class="button_4" onmouseover="buttonover(this);" 
	                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="<s:text name="doNext"/>" onclick="doNext('/sales/order_nextProcess.do')" 
	                            <s:if test="form.orderstate!='AUDITED'">disabled = "true"</s:if> />
	                    <input type="button" id="buttonAdj" name="buttonAdj" class="button_4" onmouseover="buttonover(this);" 
	                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="<s:text name="button_amtadj"/>" onclick="doAmtadj()" 
	                           <s:if test="outstate!='AUDITED'">disabled = "true"</s:if>/>
	                    <input type="button"  name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
	                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="<s:text name="button_return"/>" onclick="doReturnInFrame('/sales/order_list.do?backFlag=true');">
                   </s:i18n>
				</td>
			</tr>
			
		</table>
		<table id="adjTab" class="table_normal" style="display: none">
             <tr >
				<td align="left"  id="adjTd1">
				</td>
				<td align="right" id="adjTd2">
				</td>
			</tr>
			 <tr >
				<td align="center" id="adjTd3">
				</td>
				<td align="center" id="adjTd4">
				</td>
			</tr>
          </table>
	</div>
	<aa:zone name="listZone">
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style">
            <tr class="table_style_head">
            	<td> &nbsp;</td>
                <td >
                    序号
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('recid')"><s:text name="recid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('ordercomtype')"><s:text name="ordercomtype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comcategory')"><s:text name="comcategory"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('orderamt')"><s:text name="orderamt"/>(套)</j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('unitprice')"><s:text name="unitprice"/>(元)</j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('totalprice')"><s:text name="totalprice"/>(元)</j:orderByImg>                 
                </td>
                <td>
                    <s:text name="adj"/>           
                </td>
            </tr>
            <s:iterator value="dp.datas" status="state">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" 
                         value="<s:property value="recid"/>,<j:code2Name definition="$FX_ORDERCOMTYPE" code="ordercomtype"/>,<j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory"/>,<s:property value="orderamt" />" />
                     </td>
                     <td>
                        <s:text name="#state.count"/>
                     </td>
                     <td>
							<s:property value="recid"/>
					 </td>
                     <td><j:code2Name definition="$FX_ORDERCOMTYPE" code="ordercomtype"/></td>
                     <td><j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory"/></td>
                     <td><s:property value="orderamt" /></td>
                     <td><s:property value="unitprice" /></td>
                     <td><s:property value="totalprice" /></td>
                     <td>&nbsp;
                     	<s:if test="changeFlag=='YES'">
	                     	<label onclick="openAdj(<s:property value="recid"/>)">
	                     		<font style="text-decoration: underline; color: red; cursor: hand">详细</font>
	                     	</label>
                     	</s:if>
                     </td>
                 </tr>
                 <script language="javascript">
                 	stat(<s:property value="orderamt"/>,<s:property value="totalprice"/>);
                 </script>
             </s:iterator>
             <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
             	<td>合计</td>
             	<td></td>
             	<td></td>
             	<td></td>
             	<td></td>
             	<td><script language="javascript"> document.write(count) </script></td>
             	<td></td>
             	<td><font color="red"><script language="javascript"> document.write(total) </script></font></td>
             	<td></td>
             </tr>
        </table>
        </div>
    </div>
    <div class="table_div">
		<%@ include file="/common/pageNav.jsp"%>
   	</div>
    </aa:zone>
</s:form>
</div>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	function doAppPass(){
		if($(":hidden[name='form.param44']").val()=='1'){
			var orderid="<s:property value="form.orderid"/>";
			var returnValue=window.showModalDialog('<%=contextPath %>/sales/order_appPassStockInfo.do?param._se_orderid='+orderid,window,"dialogWidth=800px;dialogHeight=600px;status:no;scroll=yes;");
		    if(returnValue!=undefined){
		    	formList.action = contextPath + "/sales/order_appPass.do";
	            formList.submit();
			}
		}else{
			formList.action = contextPath + "/sales/order_appPass.do";
            formList.submit();
		}
		
		
	}
	function doAmtadj(){
		var checkedBoxs=$(":checkbox[name='param._selectitem']:checked");
		if(checkedBoxs.length!=1){
			alert("请选择一条记录！");
			return;
		}
		checkedBoxs.each(function(i) {
				var str=jQuery(this).val();
				var vals=str.split(",");
				var adjText1="编号:"+vals[0]+"&nbsp;&nbsp;订购商品类型："+vals[1]+"&nbsp;&nbsp;商品种类："+vals[2];
				var	adjText3="数量（套）：<input type='hidden' name='recid' value='"+vals[0]+"'><input type='text' name='orderamt' value='"+vals[3]+"'>";
                var adjText2="<input type='button' id='btnSave' name='btnSave' class='button_Save' onmouseover='buttonover(this);'";
                    adjText2+=" onmouseout='buttonout(this);' onfocus='buttonover(this)' onblur='buttonout(this)'";
                    adjText2+="value='保存' onclick=\"doAdjSave('/sales/order_amtadjSave.do')\"/>";
               var	adjText4=" 备注：<textarea class='form_textarea_on_4' name='memo'></textarea> ";
				$("#adjTd1").html(adjText1);
				$("#adjTd2").html(adjText2);
				$("#adjTd3").html(adjText3);
				$("#adjTd4").html(adjText4);
				$("#adjTab").show();
		});
	}
	function doAdjSave(cmdSave){
		addfield('orderamt', '数量', 'f', false, '10');
        if(checkval(window)){
	        formList.action = contextPath + cmdSave;
	        formList.submit();
        }
	}

	//ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	//ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnDelete");
</script> 
</body>
</html>
