<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
	function ev_checkval() {
	var arr = document.getElementsByName("form.state");
		
			if(arr[0].checked!=true){
				if(arr[1].checked!=true){
					alert("批示不可以为空！");
					return ;
					
				}
			}
		addfield('form.seqid', '<s:text name="seqid"/>', 'f', false, 14);
		addfield('form.formid', '<s:text name="formid"/>', 'f', true, 14);
		addfield('form.bondtype', '<s:text name="bondtype"/>', 'c', true, 16);
		addfield('form.presenter', '<s:text name="presenter"/>', 'c', true, 16);
		addfield('form.smsntime', '<s:text name="smsntime"/>', 't', true, 7);
		addfield('form.auditor', '<s:text name="auditor"/>', 'c', true, 16);
		addfield('form.audittime', '<s:text name="audittime"/>', 't', true, 7);
		addfield('form.opinion', '<s:text name="opinion"/>', 'c', false, 512);
		//addfield('form.state', '<s:text name="state"/>', 'c', true, 32);
		addfield('form.memo', '<s:text name="memo"/>', 'c', true, 512);
		
		
		return checkval(window);
	}
</script>
</head>
<body>
<div class="table_container">
<s:form action="bondaudit_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._dnm_smsntime"/>
    <s:hidden name="param._dnl_smsntime"/>
    <s:hidden name="param._se_state"/>
    <s:hidden name="form.seqid"/>
	
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
		</div>
	</div>

	<div class="error_text" >
		<table class="error_text">
			<s:actionerror /><s:actionmessage/>
		</table>
	</div>
	
    <div class="table_div">
        <table class="table_normal">
      
              <tr>
                <td align="left" colspan="4"><j:code2Name definition="$CH_BONDTYPE" code="bondformForm.BONDTYPE" />(配送商/渠道网点)</td>
                
            </tr>
             <tr>
                <td align="right"><s:text name="wayid"/>:&nbsp</td>
                <td align="left">
					<j:code2Name definition="#WAYIDINFO" code="bondformForm.wayid" />
                </td>
                <td align="right"><s:text name="countyid"/>:&nbsp</td>
                <td align="left">
					<j:code2Name definition="#CNTYCOMPANY" code="bondformForm.countyid" />
                </td>
            </tr>
            
             <tr>
                <td align="right"><s:text name="principal"/>:&nbsp</td>
                <td align="left">
					<s:property value="bondformForm.principal" />
                </td>
                <td align="right"><s:text name="principaltel"/>:&nbsp</td>
                <td align="left">
					<s:property value="bondformForm.principaltel" />
                </td>
            </tr>
            
            
       <s:if test="bondformForm.boneobjtype==1">
             <tr>
                <td align="right"><s:text name="bailtype"/>:&nbsp</td>
                <td align="left">
					<j:code2Name definition="$CH_NEWBAILTYPE" code="bondformForm.bailtype" />
                </td>
                <td align="right"><s:text name="paymentmode"/>:&nbsp</td>
                <td align="left">
					<j:code2Name definition="$CH_PAYMENTMODE" code="bondformForm.paymentmode" />
                </td>
            </tr>
            
            
             <tr>
                <td align="right"><s:text name="filepath"/>:&nbsp</td>
                <td align="left">
					<a href='<%=contextPath%>/channel/saleway_download.do?file=<s:property value="bondformForm.payfilepath"/>'
							target="_blank"> <s:property value="bondformForm.payfilepath" /> </a>
                </td>
                <td align="right"></td>
                <td align="left">
					
                </td>
            </tr>
            </s:if>
						
            
            <tr>
                <td align="right"><s:text name="payamt"/>:&nbsp</td>
                <td align="left">
					<s:property value="bondformForm.payamt" />
                </td>
                <td align="right"><s:text name="paymentmode"/>:&nbsp</td>
                <td align="left">
					<j:code2Name definition="$CH_PAYMENTMODE" code="bondformForm.paymentmode" />
                </td>
            </tr>
            
            
            
                <tr>
                <td align="right"><s:text name="memo"/>:&nbsp</td>
                <td align="left">
					<s:property value="bondformForm.memo" /> 
                </td>
                <td align="right"></td>
                <td align="left">
					
                </td>
            </tr>
              </table>
    </div>
    
    <br>
    :&nbsp
    <br>
    
    
    
    
    
    
            
            <div class="table_div">
        <table class="table_normal">
         
              <tr>
                <td align="right"><s:text name="presenter"/>:&nbsp</td>
                <td align="left">
                <s:property value="form.presenter" /> 
                </td>
           
                <td align="right"><s:text name="smsntime"/>:&nbsp</td>
                <td align="left">
              		 <s:date name="form.smsntime" format="yyyy-MM-dd HH:mm:ss"/>
					
                </td>
            </tr>
             <tr>
                <td align="right"><s:text name="state"/>:&nbsp</td>
                <td align="left">
                	<j:code2Name definition="$CH_AUDITSTATE" code="form.state" />
				
                </td>
           
                <td align="right"><s:text name="memo"/>:&nbsp</td>
                <td align="left">
                 		<s:property value="form.memo" /> 
                </td>
            </tr>
            <s:if test="form.state==0">
		            <tr>
		                <td align="right">批示:&nbsp</td>
		                <td align="left">
		                	<s:if test="CMD != WEB_CMD_SAVE">
			                	<s:if test="form.state == 1">
									<INPUT type="radio" name="form.state" value="1" checked="true"> 通过 <INPUT type="radio" name="form.state" value="2"> 不通过
								</s:if>
								 <s:elseif test="form.state == 2">
								 	<INPUT type="radio" name="form.state" value="1"> 通过 <INPUT type="radio" name="form.state" value="2"  checked="true"> 不通过
								 </s:elseif>
								 <s:else>
								 	<INPUT type="radio" name="form.state" value="1"> 通过 <INPUT type="radio" name="form.state" value="2"> 不通过
								</s:else>
							</s:if>
							<s:else>
									<s:if test="form.state == 1">
										<INPUT type="radio" name="form.state" value="1" checked="true"  disabled="true"> 通过 <INPUT type="radio" name="form.state" value="2"  disabled="true"> 不通过
									</s:if>
									 <s:elseif test="form.state == 2">
									 	<INPUT type="radio" name="form.state" value="1"  disabled="true"> 通过 <INPUT type="radio" name="form.state" value="2"  checked="true"  disabled="true"> 不通过
									 </s:elseif>
									 <s:else>
									 	<INPUT type="radio" name="form.state" value="1"  disabled="true"> 通过 <INPUT type="radio" name="form.state" value="2"  disabled="true"> 不通过
									</s:else>
							</s:else>
		                <font color=red>*</font>	
		                </td>
		                <td align="right"><s:text name="opinion"/>:&nbsp</td>
		                <td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<s:textfield cssStyle="style_input" name="form.opinion" maxlength="512"/>
								
							</s:if>
							<s:else>
								<s:textfield cssStyle="style_input" name="form.opinion" disabled="true"/>
							</s:else>
							<font color=red>*</font>
		                </td>
		            </tr>
           </s:if>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                   	<s:if test="form.state==0">
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="确认" onclick="doSave('/channel/bondaudit_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                           </s:if>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="关闭" onclick="doReturn('/channel/bondaudit_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>