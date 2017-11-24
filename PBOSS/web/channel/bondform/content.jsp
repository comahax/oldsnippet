<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
	<head>
		<title><s:text name="titleUpdate" />
		</title>
		<script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
		<script language="JavaScript">
	function ev_checkval() {
		addfield('form.wayid', '<s:text name="wayid"/>', 'c', false, 18);
		addfield('form.bondtype', '<s:text name="bondtype"/>', 'c', false, 16);
		addfield('form.countyid', '<s:text name="countyid"/>', 'c', false, 14);
		addfield('form.principal', '<s:text name="principal"/>', 'c', true, 64);
		addfield('form.principaltel', '<s:text name="principaltel"/>', 'c', true, 20);
		addfield('form.state', '<s:text name="state"/>', 'f', true, 4);
		addfield('form.confirmtime', '<s:text name="confirmtime"/>', 't', true, 7);
		addfield('form.createtime', '<s:text name="createtime"/>', 't', true, 7);
		addfield('form.memo', '<s:text name="memo"/>', 'c', true, 1000);
		addfield('form.boneobjtype', '<s:text name="boneobjtype"/>', 'f', false, 2);
		//addfield('form.bailtype', '<s:text name="bailtype"/>', 'f', true, 2);
		//addfield('form.payno', '<s:text name="payno"/>', 'c', true, 32);
		addfield('form.payfilepath', '<s:text name="payfilepath"/>', 'f', true, 4000);
		checkTX();
		return checkval(window);
	}
	
	
	function checkTX(){
		var datetype = $("#bondtype").val();    	
    	
    	if(datetype=="PAYFORM")
    	{
   		addfield('form.paymentmode', '<s:text name="paymentmode"/>', 'c', false, 16);
		addfield('form.payamt', '<s:text name="payamt"/>', 'f', false, 16);
    	addfield('form.receiptno', '<s:text name="receiptno"/>', 'c', true, 32);
		addfield('form.receiptamt', '<s:text name="receiptamt"/>', 'f', true, 16);
		addfield('form.filepath', '<s:text name="filepath"/>', 'f', false, 4000);
		addfield('form.receiptmeomo', '<s:text name="receiptmeomo"/>', 'c', true, 512);
    	}
    	else if(datetype=="BACKFORM"){
   		addfield('form.paymentmode', '<s:text name="paymentmode"/>', 'c',true, 16);
		addfield('form.payamt', '<s:text name="payamt"/>', 'f', true, 16);
    	addfield('form.receiptno', '<s:text name="receiptno"/>', 'c', false, 32);
		addfield('form.receiptamt', '<s:text name="receiptamt"/>', 'f', false, 16);
		addfield('form.filepath', '<s:text name="filepath"/>', 'f', false, 4000);
		addfield('form.receiptmeomo', '<s:text name="receiptmeomo"/>', 'c', true, 512);
    	}else{
	  	
	  	addfield('form.paymentmode', '<s:text name="paymentmode"/>', 'c', true, 16);
		addfield('form.payamt', '<s:text name="payamt"/>', 'f', true, 16);
    	addfield('form.receiptno', '<s:text name="receiptno"/>', 'c', true, 32);
		addfield('form.receiptamt', '<s:text name="receiptamt"/>', 'f', true, 16);
		addfield('form.filepath', '<s:text name="filepath"/>', 'f', false, 4000);
		addfield('form.receiptmeomo', '<s:text name="receiptmeomo"/>', 'c', true, 512);
    	}
    	
    	
    	//(渠道网点&&支票支付) 支票编码为必填

		//(渠道网点)保证金类型必填
		
    	var datetype = $("#boneobjtype").val();
    	if(datetype=="1")
    	{
    		addfield('form.bailtype', '<s:text name="bailtype"/>', 'f', false, 2);
    		var datetype1 = $("#paymentmode").val();
	   	 	if(datetype1=="CHECK"){
	   	 		 addfield('form.payno', '<s:text name="payno"/>', 'c', false, 32);
	    	}else{
	    	 	addfield('form.payno', '<s:text name="payno"/>', 'c', true, 32);
	    	 }
    	}else{
    		addfield('form.bailtype', '<s:text name="bailtype"/>', 'f', true, 2);
    		addfield('form.payno', '<s:text name="payno"/>', 'c', true, 32);
    	}
    	
	}
	
	
	
	
	
	//根据选择的值不同，显示不同的页面内容
	//实体类型
    function showTr1()
    {
    	var datetype = $("#boneobjtype").val();
    	if(datetype=="1")
    	{
    		$("#div21").show();
    		$("#div22").show();
    		$("#div23").show();
    		
    		$("#div211").show();
    		var datetype1 = $("#paymentmode").val();
	   	 	if(datetype1=="CHECK"){
	   	 		 $("#div221").show();
	    	}else{
	    	 $("#div221").hide();
	    	 }
    	}
    	else {
    	 	$("#div221").hide();
    	 	$("#div211").hide();
    		$("#div21").hide();
    		$("#div22").hide();
    		$("#div23").hide();
    	}
    }
    
    
    //申请单类型
    function showTr2()
    {
    	var datetype = $("#bondtype").val();
    	if(datetype=="PAYFORM")
    	{
    		$("#div11").show();
    		$("#div12").show();
    		$("#div3").hide();
    	}
    	else if(datetype=="BACKFORM"){
    		$("#div3").show();
    		$("#div11").hide();
    		$("#div12").hide();
    	}else{
    		$("#div3").hide();
    		$("#div11").hide();
    		$("#div12").hide();
    	}
    }
    
    
    
    //paymentmode 支付方式
    
    function showTr3()
    {
    	var datetype = $("#boneobjtype").val();
    	if(datetype=="1")
    	{
    		var datetype1 = $("#paymentmode").val();
	   	 	if(datetype1=="CHECK"){
	   	 		 $("#div221").show();
	    	}else{
	    	 $("#div221").hide();
	    	 }
    	}
    	else {
    	 	$("#div221").hide();    		
    	}
    }
    
    
    
    $(document).ready(function(){
		showTr1();
		showTr2();
		showTr3();
	});
    
    
    
        //根据渠道设置对应地市，分公司值
       function getCityAndCounty(wayId){
        var url = contextPath+"/channel/employee_getWayInfo1.do";
        	$.post(url,
		       { 'form.wayid': wayId },
		       function(data){
		       //返回的数据格式为:countyid:countyname,cityid:cityname
		          if(data != null && "" != data){
			          var resultArray = data.split(',');
			          var countyArray = resultArray[0].split(':');
			         
			          document.getElementById('form.countyid').value=countyArray[0];
			          document.getElementById('countyName').value=countyArray[1];
		          }
		       } 
			); 
        }
    
	
</script>
	</head>
	<body>
		<div class="table_container">
			<s:form action="bondform_save.do" cssStyle="formList" key="formItem"  enctype="multipart/form-data"
				method="post" theme="simple" onsubmit="return ev_checkval();">

				<s:hidden name="CMD" />
				<s:hidden name="param._orderby" />
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				<s:hidden name="param._se_wayid" />
				<s:hidden name="param._se_bondtype" />
				<s:hidden name="param._se_countyid" />
				<s:hidden name="param._ne_state" />
				<s:hidden name="param._ne_boneobjtype" />
				<s:hidden name="form.formid" />

				<div class="table_top">
					<div class="table_topleft"></div>
					<div class="table_toparea_w">
						<s:i18n name="public">
							<span class="table_toparea"><s:text name="currentPos" /> </span>
							<span class="table_toparea_xi">></span>
							<span class="table_toparea"><s:text name="channel" /> </span>
							<span class="table_toparea_xi">></span>
						</s:i18n>
						<span class="table_toparea_h"><s:text name="titleList" />
						</span>
						<span class="button_Help"
							onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n
								name="public">
								<s:text name="help" />
							</s:i18n>
						</span>
					</div>
				</div>

				<div class="error_text">
					<table class="error_text">
						<s:actionerror />
						<s:actionmessage />
					</table>
				</div>

				<div class="table_div">
					<table class="table_normal">
					<!-- 
						<tr style="display: none">
							<td align="right">
								<s:text name="formid" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD == WEB_CMD_NEW">
									<s:textfield cssStyle="style_input" name="form.formid"
										maxlength="14" />
									<font color=red>*</font>
								</s:if>
								<s:elseif test="CMD == WEB_CMD_EDIT">
									<s:textfield cssStyle="style_input" name="form.formid"
										disabled="true" />
									<font color=red>*</font>
								</s:elseif>
								<s:else>
									<s:textfield cssStyle="style_input" name="form.formid"
										disabled="true" />
									<font color=red>*</font>
								</s:else>
							</td>
						</tr> -->



	<tr>
							<td align="left" colspan="2">
								申请信息								
							</td>
							</tr>

						<tr>
							<td align="right">
								<s:text name="boneobjtype" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
									<j:selector definition="$CH_BONEOBJTYPE" id="boneobjtype"
										name="form.boneobjtype" mode="selector" onchange="showTr1()" />
									<!-- <s:textfield cssStyle="style_input" name="form.boneobjtype" maxlength="2" onchange="showTr()"/> -->
								</s:if>
								<s:else>
									<j:selector definition="$CH_BONEOBJTYPE" name="form.boneobjtype" mode="selector" disabled="true"/>
									<!-- <s:textfield cssStyle="style_input" name="form.boneobjtype" disabled="true"/> -->
								</s:else>
								<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td align="right">
								<s:text name="bondtype" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
									<j:selector definition="$CH_BONDTYPE" id="bondtype"
										name="form.bondtype" mode="selector" onchange="showTr2()" />
									<!-- <s:textfield cssStyle="style_input" name="form.bondtype" maxlength="16" onchange="showTr()"/> -->
								</s:if>
								<s:else>
									<j:selector definition="$CH_BONDTYPE" name="form.bondtype"
										mode="selector" disabled="true" />
									<!-- <s:textfield cssStyle="style_input" name="form.bondtype" disabled="true"/> -->
								</s:else>
								<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td align="right">
								<s:text name="wayid" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
									<s:textfield cssStyle="style_input" name="form.wayid"
										maxlength="18" onclick="pshowSelectWay3(this,'form.wayid','','','AG');getCityAndCounty(this.value);" />
										                 <!--    <input type="button" value="..." class="picker_button"
									onclick="pshowSelectWay3(this,'form.wayid','','','AG');getCityAndCounty(this.value);" /> -->
								</s:if>
								<s:else>
									<s:textfield cssStyle="style_input" name="form.wayid"
										disabled="true" />
								</s:else>
								<font color=red>*</font>
							</td>
						</tr>

						<tr>
							<td align="right">
								<s:text name="countyid" />
								:&nbsp
							</td>
							<td align="left">
								
									<s:hidden name="form.countyid" id="form.countyid"/>
                <input type="text" cssStyle="style_input" id="countyName" name="countyName" value="<j:code2Name definition="#CNTYCOMPANY" code="form.countyid"/>" disabled="true"/>
								
								
								<!--
								<s:if test="CMD != WEB_CMD_SAVE">
								<input type="text" id="countyid" name="form.countyid" value="${form.countyid }" style="form.countyid" readonly="true"/>
								<
									 <s:textfield cssStyle="style_input" name="form.countyid"
										maxlength="14" />
								</s:if>
								<s:else>
								<input type="text" id="countyid" name="form.countyid" value="${form.countyid }" style="form.countyid" disabled="true" />
									<!-- <s:textfield cssStyle="style_input" name="form.countyid"
										disabled="true" />
								</s:else> -->
								<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td align="right">
								<s:text name="principal" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
									<s:textfield cssStyle="style_input" name="form.principal"
										maxlength="64" />
								</s:if>
								<s:else>
									<s:textfield cssStyle="style_input" name="form.principal"
										disabled="true" />
								</s:else>
							</td>
						</tr>
						<tr>
							<td align="right">
								<s:text name="principaltel" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
									<s:textfield cssStyle="style_input" name="form.principaltel"
										maxlength="20" />
								</s:if>
								<s:else>
									<s:textfield cssStyle="style_input" name="form.principaltel"
										disabled="true" />
								</s:else>
							</td>
						</tr>




				
					
						<tr id="div11">
							<td align="right">
								<s:text name="payamt" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
									<s:textfield cssStyle="style_input" name="form.payamt"
										maxlength="16" />
								</s:if>
								<s:else>
									<s:textfield cssStyle="style_input" name="form.payamt"
										disabled="true" />
								</s:else>
								<font color=red>*</font>
							</td>
						</tr>
						<tr id="div12">
							<td align="right">
								<s:text name="paymentmode" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
								<j:selector definition="$CH_PAYMENTMODE"
										name="form.paymentmode" mode="selector" id="paymentmode" onchange="showTr3()" />
									<!-- <s:textfield cssStyle="style_input" name="form.paymentmode"
										maxlength="16" /> -->
										
								</s:if>
								<s:else>
								<j:selector definition="$CH_PAYMENTMODE"
										name="form.paymentmode" mode="selector" disabled="true" />
									<!--<s:textfield cssStyle="style_input" name="form.paymentmode"
										disabled="true" />-->
								</s:else>
								<font color=red>*</font>
							</td>
						</tr>
					




						<tr id="div21">
							<td align="right">
								<s:text name="bailtype" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
								
								<j:selector definition="$CH_NEWBAILTYPE"
										name="form.bailtype" mode="selector"/>
									<!-- <s:textfield cssStyle="style_input" name="form.bailtype"
										maxlength="2" />-->
								</s:if>
								<s:else>
								<j:selector definition="$CH_NEWBAILTYPE"
										name="form.bailtype" mode="selector" disabled="true" />
									<!-- <s:textfield cssStyle="style_input" name="form.bailtype"
										disabled="true" /> -->
								</s:else>
								<font id="div211" color=red>*</font>
							</td>
						</tr>
						<tr id="div22">
							<td align="right">
								<s:text name="payno" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
									<s:textfield cssStyle="style_input" name="form.payno"
										maxlength="32" />
								</s:if>
								<s:else>
									<s:textfield cssStyle="style_input" name="form.payno"
										disabled="true" />
								</s:else>
								<font id="div221" color=red>*</font>
							</td>
						</tr>
						<tr id="div23">
							<td align="right">
								<s:text name="payfilepath" />
								:&nbsp
							</td>
							<td align="left">
							
							<s:if test="CMD != WEB_CMD_SAVE">
						<s:file name="payfilepath" label="File" />
						<a href='<%=contextPath%>/channel/saleway_download.do?file=<s:property value="form.payfilepath"/>'
							target="_blank"> <s:property value="form.payfilepath" /> </a>
					</s:if>
					<s:else>
						<a href='<%=contextPath%>/channel/saleway_download.do?file=<s:property value="form.payfilepath"/>'
							target="_blank"> <s:property value="form.payfilepath" /> </a>
					</s:else>
							
							<!-- 
								<s:if test="CMD != WEB_CMD_SAVE">
									<s:textfield cssStyle="style_input" name="form.payfilepath"
										maxlength="4000" />
								</s:if>
								<s:else>
									<s:textfield cssStyle="style_input" name="form.payfilepath"
										disabled="true" />
								</s:else>
								 -->
							</td>
						</tr>
						
						<tr>
							<td align="right">
								<s:text name="memo" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
									<s:textfield cssStyle="style_input" name="form.memo"
										maxlength="1000" />
								</s:if>
								<s:else>
									<s:textfield cssStyle="style_input" name="form.memo"
										disabled="true" />
								</s:else>
							</td>
						</tr>
					</table>
					</div>
<br>


				<div id="div3">
					<div class="table_div">
						<table class="table_normal">
	<tr>
							<td align="left" colspan="2">
								收据信息								
							</td>
							</tr>
							<tr>
								<td align="right">
									<s:text name="receiptno" />
									:&nbsp
								</td>
								<td align="left">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.receiptno"
											maxlength="32" />
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.receiptno"
											disabled="true" />
									</s:else>
									<font color=red>*</font>
								</td>
							</tr>
							<tr>
								<td align="right">
									<s:text name="receiptamt" />
									:&nbsp
								</td>
								<td align="left">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.receiptamt"
											maxlength="16" />
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.receiptamt"
											disabled="true" />
									</s:else>
									<font color=red>*</font>
								</td>
							</tr>
							<tr>
								<td align="right">
									<s:text name="receiptmeomo" />
									:&nbsp
								</td>
								<td align="left">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.receiptmeomo"
											maxlength="512" />
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.receiptmeomo"
											disabled="true" />
									</s:else>
								</td>
							</tr>
							<tr>
								<td align="right">
									<s:text name="filepath" />
									:&nbsp
								</td>
								<td align="left">
								
								<s:if test="CMD != WEB_CMD_SAVE">
						<s:file name="filepath" label="File" />
						<a href='<%=contextPath%>/channel/saleway_download.do?file=<s:property value="form.filepath"/>'
							target="_blank"> <s:property value="form.filepath" /> </a>
					</s:if>
					<s:else>
						<a href='<%=contextPath%>/channel/saleway_download.do?file=<s:property value="form.filepath"/>'
							target="_blank"> <s:property value="form.filepath" /> </a>
					</s:else>
								
								<!-- 	<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.filepath"
											maxlength="4000" />
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.filepath"
											disabled="true" />
									</s:else> -->
									<font color=red>*</font>
								</td>
							</tr>
						</table>
					</div>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td width="100%" align="center">
								<s:i18n name="public">
									<input type="button" id="btnSave" name="btnSave"
										class="button_Save" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="<s:text name="button_save"/>"
										onclick="doSave('/channel/bondform_save.do')"
										<s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if> />
									<input type="button" id="btnReturn" name="btnReturn"
										class="button_Back" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_return"/>"
										onclick="doReturn('/channel/bondform_list.do')">
								</s:i18n>
							</td>
						</tr>
					</table>
				</div>
			</s:form>
		</div>
	</body>
</html>