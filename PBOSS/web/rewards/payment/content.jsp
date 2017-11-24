<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
    function setBtnDisabled(tabId,state){
    	document.getElementById(tabId).disabled=state;
    }
    
	function ev_checkval() {
		addfield('form.optype', '<s:text name="optype"/>', 'c', false, 16);
		addfield('form.ltype', '<s:text name="ltype"/>', 'c', true, 128);
		addfield('form.stype', '<s:text name="stype"/>', 'c', true, 128);
		addfield('form.payee', '<s:text name="payee"/>', 'c', false, 128);
		
		addfield('form.bkactname', '<s:text name="bkactname"/>', 'c', false, 256);
		addfield('form.bank', '<s:text name="bank"/>', 'c', false, 256);
		addfield('form.depositbank', '<s:text name="depositbank"/>', 'c', false, 256);
		
		addfield('form.account', '<s:text name="account"/>', 'c', false, 64);
		addfield('form.billnumber', '<s:text name="billnumber"/>', 'c', true, 80);
		addfield('form.countyid', '<s:text name="countyid"/>', 'c', true, 32);
		
		addfield('form.paymonth', '<s:text name="paymonth"/>', 'l', false, 6);
		addfield('form.paysum', '<s:text name="paysum"/>', 'd', false, 18);
		addfield('form.batch', '<s:text name="batch"/>', 'c', true, 32);
		
		addfield('form.pubpri', '<s:text name="pubpri"/>', 'c', true, 4);
		addfield('form.note', '<s:text name="note"/>', 'c', true, 4000);
		addfield('form.calcmonth', '<s:text name="calcmonth"/>', 'l', true, 6);
		
		var cmd = document.getElementById("CMD").value;
		if(cmd != "NEW"){
		    addfield('form.upoprcode', '<s:text name="upoprcode"/>', 'c', true, 15);
		    addfield('form.checkedflag', '<s:text name="checkedflag"/>', 'c', true, 32);
		}
		
		if(cmd == "EDIT"){
			var checkedflag = document.getElementById("form.checkedflag").value;
			if(checkedflag=="已审核"||checkedflag=="CHECKED"){
				alert("此数据已被审核，审核通过的数据不能修改！");
				setBtnDisabled("btnSave",true);
				return false;
			}
		}
		
		return checkval(window);
	}
</script>
</head>
<body>
<div class="table_container">
<s:form action="payment_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
	<s:hidden name="form.seq"/>
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="酬金管理"/> </span>
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
		<span id="chkeditexplain"></span>
	</div>
	
    <div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="right"><s:text name="optype"/>:&nbsp;</td>
                <td align="left">
                    <s:if test="CMD == WEB_CMD_NEW">
                        <j:selector definition="LTYPEOPTYPE" name="form.optype" />
                    </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.optype" disabled="true"/>
					</s:else>
			        <font color=red>*</font>
                </td>
                <td align="right"><s:text name="ltype"/>:&nbsp;</td>
                <td align="left">
			       <s:if test="CMD == WEB_CMD_NEW">
			           <j:selector name="form.ltype" definition="#LTYPE" />
                    </s:if>
			        <s:else>
					   <s:textfield cssStyle="style_input" name="form.ltype"/>
					</s:else>
				</td>
            </tr>
            
            <tr>
                <td align="right"><s:text name="stype"/>:&nbsp;</td>
                <td align="left">
			       <s:if test="CMD == WEB_CMD_NEW">
			           <j:selector name="form.stype" definition="#STYPE" />
                    </s:if>
			        <s:else>
					   <s:textfield cssStyle="style_input" name="form.stype" disabled="true"/>
					</s:else>
				</td>
                <td align="right"><s:text name="payee"/>:&nbsp;</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
			            <s:textfield cssStyle="style_input" name="form.payee" maxlength="128"/>
                    </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.payee" disabled="true"/>
					</s:else>
			        <font color=red>*</font>
                </td>
            </tr>
            
            <tr>
                <td align="right"><s:text name="bkactname"/>:&nbsp;</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
			            <s:textfield cssStyle="style_input" name="form.bkactname" maxlength="256"/>
                    </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.bkactname" maxlength="256" disabled="false"/>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.bkactname" disabled="true"/>
					</s:else>
			        <font color=red>*</font>
                </td>
                <td align="right"><s:text name="bank"/>:&nbsp;</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
			            <s:textfield cssStyle="style_input" name="form.bank" maxlength="256"/>
                    </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.bank" maxlength="256" disabled="false"/>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.bank" disabled="true"/>
					</s:else>
			        <font color=red>*</font>
                </td>
            </tr>
            
            <tr>
                <td align="right"><s:text name="depositbank"/>:&nbsp;</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
			            <s:textfield cssStyle="style_input" name="form.depositbank" maxlength="256"/>
                    </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.depositbank" maxlength="256" disabled="false"/>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.depositbank" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
                <td align="right"><s:text name="account"/>:&nbsp;</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
			            <s:textfield cssStyle="style_input" name="form.account" maxlength="64"/>
                    </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.account" maxlength="64" disabled="false"/>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.account" disabled="true"/>
					</s:else>
			        <font color=red>*</font>
                </td>
            </tr>
            
            <tr>
                <td align="right"><s:text name="billnumber"/>:&nbsp;</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
			            <s:textfield cssStyle="style_input" name="form.billnumber" maxlength="80"/>
                    </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.billnumber" maxlength="80" disabled="false"/>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.billnumber" disabled="true"/>
			        </s:else>
                </td>
                <td align="right"><s:text name="countyid"/>:&nbsp;</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
			            <s:textfield cssStyle="style_input" name="form.countyid" maxlength="32"/>
                    </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.countyid" maxlength="32" disabled="false"/>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.countyid" disabled="true"/>
					</s:else>
                </td>
            </tr>
            
            <tr>
                <td align="right"><s:text name="paymonth"/>:&nbsp;</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
			            <s:textfield name="form.paymonth" onclick="selectDateYYYYMM();"  />
                    </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.paymonth" disabled="true"/>
					</s:else>
			        <font color=red>*</font>
                </td>
                <td align="right"><s:text name="paysum"/>:&nbsp;</td>
                <td align="left">
                    <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.paysum" maxlength="18"/>
                    </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" maxlength="18" name="form.paysum" disabled="false"/>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.paysum" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            
            <tr>
                <td align="right"><s:text name="batch"/>:&nbsp;</td>
                <td align="left">
                    <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.batch" maxlength="32"/>
                    </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.batch" maxlength="32" disabled="true"/>
					</s:else>
			    </td>
                <td align="right"><s:text name="pubpri"/>:&nbsp;</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
					    <j:selector name="form.pubpri" definition="PUBPRI" />
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.pubpri" disabled="true"/>
					</s:else>
                </td>
             </tr>
            <tr>

            <tr>           
                <td align="right"><s:text name="note"/>:&nbsp;</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.note" maxlength="4000" disabled="false"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.note" disabled="true"/>
					</s:else>
                </td>
                <td align="right"><s:text name="calcmonth"/>:&nbsp;</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_SAVE">
			            <s:textfield cssStyle="style_input" name="form.calcmonth" disabled="true"/>
			        </s:if>
			        <s:else>
						<s:textfield name="form.calcmonth" onclick="selectDateYYYYMM();" />
					</s:else>
			    </td>
             </tr>
             
             <s:if test="CMD != WEB_CMD_NEW">
               <tr>
                   <td align="right"><s:text name="checkedflag"/>:&nbsp;</td>
                   <td align="left">
                       <s:if test="form.checkedflag==null">
                           <input type="text" value="未审核" id="form.checkedflag" name="form.checkedflag" length="20" maxlength="256" disabled="disabled"/>
                       </s:if>
                       <s:else>
                           <input type="text" value="<j:code2Name definition="CHECKEDFLAG" code="form.checkedflag"/>" id="form.checkedflag" name="form.checkedflag" length="20" maxlength="20" disabled="disabled"/>
                       </s:else>
                   </td>
                   <td align="right"><s:text name="upoprcode"/>:&nbsp;</td>
                   <td align="left">
                       <s:textfield cssStyle="style_input" name="form.upoprcode" maxlength="15" disabled="true"/>
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
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="doSave('/payment/payment_save.do')"
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/payment/payment_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
<script language="javascript">
    var cmd = document.getElementById("CMD").value;
    if(cmd == "EDIT"){
	    var checkedflag = document.getElementById("form.checkedflag").value;
	    if(checkedflag=="已审核"){
		    var chkeditexplain = document.getElementById("chkeditexplain");
		    chkeditexplain.innerHTML = "<font color='red'><li>审核通过的数据不能修改！</font></li>";
		    setBtnDisabled("btnSave",true);
		}
    }else if(cmd == "SAVE"){
    	setBtnDisabled("btnSave",true);
    }
</script> 