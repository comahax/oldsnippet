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
		addfield('form.wayid', '<s:text name="wayid"/>', 'c', true, 18);
		addfield('form.calcmonth', '<s:text name="calcmonth"/>', 'l', true, 6);
		addfield('form.paymonth', '<s:text name="paymonth"/>', 'l', false, 6);
		addfield('form.optype', '<s:text name="optype"/>', 'c', false, 16);
		addfield('form.ltype', '<s:text name="ltype"/>', 'c', false, 128);
		addfield('form.stype', '<s:text name="stype"/>', 'c', false, 128);
		addfield('form.mobile', '<s:text name="mobile"/>', 'c', true, 20);
		addfield('form.imei', '<s:text name="imei"/>', 'c', true, 15);
		addfield('form.paysum', '<s:text name="paysum"/>', 'd', false, 18);
		addfield('form.settleperiods', '<s:text name="settleperiods"/>', 'c', false, 400);
		addfield('form.note', '<s:text name="note"/>', 'c', true, 4000);
		
		addfield('form.upoprcode', '<s:text name="upoprcode"/>', 'c', true, 15);
		addfield('form.checkedflag', '<s:text name="checkedflag"/>', 'c', true, 32);

		var cmd = document.getElementById("CMD").value;
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
<s:form action="paymentsc_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
	<s:hidden name="form.seq"/>
	<input type="hidden" name="_switchflag" value="<s:property value="switchflag" />"/>
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
               <td align="right"><s:text name="wayid"/>:&nbsp;</td>
               <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
					    <j:selector name="form.wayid" definition="#WAYIDINFO" />
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.wayid" maxlength="18" disabled="true"/>
					</s:else>
					<font color=red>*</font>
				</td>
				<td align="right"><s:text name="calcmonth"/>:&nbsp;</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_SAVE">
			            <s:textfield cssStyle="style_input" name="form.calcmonth" disabled="true"/>
			        </s:if>
			        <s:else>
						<s:textfield name="form.calcmonth" onclick="selectDateYYYYMM();" />
					</s:else>
					<font color=red>*</font>
			    </td>
            </tr>
            <tr>
                <td align="right"><s:text name="paymonth"/>:&nbsp;</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_SAVE">
			            <s:textfield cssStyle="style_input" name="form.paymonth" disabled="true"/>
                    </s:if>
			        <s:else>
						<s:textfield name="form.paymonth" onclick="selectDateYYYYMM();"  />
					</s:else>
			        <font color=red>*</font>
                </td>
                <td align="right"><s:text name="optype"/>:&nbsp;</td>
                <td align="left">
                    <s:if test="CMD == WEB_CMD_SAVE">
                        <s:textfield cssStyle="style_input" name="form.optype" disabled="true"/>
                    </s:if>
			        <s:else>
						<j:selector definition="LTYPEOPTYPE" name="form.optype" />
					</s:else>
			        <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="ltype"/>:&nbsp;</td>
                <td align="left">
			       <s:if test="CMD == WEB_CMD_SAVE">
			           <s:textfield cssStyle="style_input" name="form.ltype" disabled="true"/>
                    </s:if>
			        <s:else>
					   <j:selector name="form.ltype" definition="#LTYPE" />
					</s:else>
					<font color=red>*</font>
                </td>
                <td align="right"><s:text name="stype"/>:&nbsp;</td>
                <td align="left">
			       <s:if test="CMD == WEB_CMD_SAVE">
			           <s:textfield cssStyle="style_input" name="form.stype" disabled="true"/>
                    </s:if>
			        <s:else>
					   <j:selector name="form.stype" definition="#STYPE" />
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            
            <tr>
                <td align="right"><s:text name="mobile"/>:&nbsp;</td>
                <td align="left">
                    <s:if test="CMD == WEB_CMD_SAVE">
                        <s:textfield cssStyle="style_input" name="form.mobile" disabled="true"/>
                    </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.mobile" maxlength="20"/>
					</s:else>
                </td>
                <td align="right"><s:text name="imei"/>:&nbsp;</td>
                <td align="left">
					<s:if test="CMD == WEB_CMD_SAVE">
                        <s:textfield cssStyle="style_input" name="form.imei" disabled="true"/>
                    </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.imei" maxlength="15"/>
					</s:else>
                </td>
            </tr>
            
            <tr>
                <td align="right"><s:text name="paysum"/>:&nbsp;</td>
                <td align="left">
                    <s:if test="CMD == WEB_CMD_SAVE">
                        <s:textfield cssStyle="style_input" name="form.paysum" disabled="true"/>
                    </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.paysum" maxlength="18"/>
					</s:else>
					<font color=red>*</font>
                </td>
                <td align="right"><s:text name="settleperiods"/>:&nbsp;</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.settleperiods" maxlength="400" disabled="false"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.settleperiods" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            
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
                <td align="right" colspan="2">&nbsp;</td>
            </tr>
            
            <s:if test="CMD != WEB_CMD_NEW">
               <tr>
                   <td align="right"><s:text name="checkedflag"/>:&nbsp;</td>
                   <td align="left">
                       <s:if test="form.checkedflag==null">
                           <input type="text" value="未审核" id="form.checkedflag" name="form.checkedflag" length="20" maxlength="256" disabled="disabled"/>
                       </s:if>
                       <s:else>
                           <input type="text" value="<j:code2Name definition="CHECKEDFLAG" code="form.checkedflag"/>" id="form.checkedflag" name="form.checkedflag" length="20" maxlength="256" disabled="disabled"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/paymentsc/paymentsc_save.do')"
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/paymentsc/paymentsc_list.do')">
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