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
		addfield('form.actvday', '<s:text name="actvday"/>', 'c', false, 10);

		addfield('form.wayid', '<s:text name="wayid"/>', 'c', false, 30);
		
		addfield('form.waytype', '<s:text name="waytype"/>', 'c', false, 1);
		
		addfield('form.mobile', '<s:text name="mobile"/>', 'c', false, 11);
		
		addfield('form.cityid', '<s:text name="cityid"/>', 'c', false, 2);
		
		var mo = document.getElementById("form.mobile").value;
		if(mo != null && mo != "" && mo.length !=11){
			alert("[号码]应为11位");
			return false;
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
    <s:hidden name="param._se_optype"/>
    <s:hidden name="param._se_stype"/>
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
                <td align="right"><s:text name="wayid"/>:&nbsp;</td>
                <td align="left">
                <s:if test="CMD == WEB_CMD_NEW || CMD == WEB_CMD_EDIT">
                   <j:selector definition="#WAYIDINFO" name="form.wayid" />
			      </s:if>
			       <s:else>
			       	<j:selector definition="#WAYIDINFO" name="form.wayid" disabled="true"/>
			       </s:else>
			       <font color=red>*</font>
                </td>
                <td align="right"><s:text name="waytype"/>:&nbsp;</td>
                <td align="left">
                <s:if test="CMD == WEB_CMD_NEW || CMD == WEB_CMD_EDIT">
			      <select  name="form.waytype">
			      <s:if test='form.waytype==null || form.waytype==""' >
                		<option value="" selected></option>
                        <option value="1">自有渠道</option>
                        <option value="2">社会渠道</option>
                   </s:if>
                   <s:if test="form.waytype==1" >
                		<option value="" ></option>
                        <option value="1" selected>自有渠道</option>
                        <option value="2">社会渠道</option>
                   </s:if>
                   <s:if test="form.waytype==2" >
                		<option value="" ></option>
                        <option value="1" >自有渠道</option>
                        <option value="2" selected>社会渠道</option>
                   </s:if>
                  </select>
                  </s:if>
                    <s:else>
                      <select  name="form.waytype"  disabled="true">
			      <s:if test='form.waytype==null || form.waytype==""' >
                		<option value="" selected></option>
                        <option value="1">自有渠道</option>
                        <option value="2">社会渠道</option>
                   </s:if>
                   <s:if test="form.waytype==1" >
                		<option value="" ></option>
                        <option value="1" selected>自有渠道</option>
                        <option value="2">社会渠道</option>
                   </s:if>
                   <s:if test="form.waytype==2" >
                		<option value="" ></option>
                        <option value="1" >自有渠道</option>
                        <option value="2" selected>社会渠道</option>
                   </s:if>
                  </select>
                   </s:else>
					<font color=red>*</font>
                </td>
            </tr>
            
            <tr>
                <td align="right"><s:text name="actvday"/>:&nbsp;</td>
                <td align="left">
                <s:if test="CMD == WEB_CMD_NEW || CMD == WEB_CMD_EDIT">
			            <s:textfield cssStyle="style_input" name="form.actvday" maxlength="128" onclick="selectDate();"/>
			         </s:if>
			       <s:else>
			        <s:textfield cssStyle="style_input" name="form.actvday" onclick="selectDate();" disabled="true"/>
			         </s:else>
			        <font color=red>*</font>
                </td>
                <td align="right"><s:text name="mobile"/>:&nbsp;</td>
                <td align="left">
                 <s:if test="CMD == WEB_CMD_NEW || CMD == WEB_CMD_EDIT">
			           <s:textfield cssStyle="style_input" name="form.mobile" maxlength="128"/>
			      </s:if>
			       <s:else>
			       	 <s:textfield cssStyle="style_input" name="form.mobile" disabled="true"/>
			       </s:else>
			        <font color=red>*</font>
                </td>
            </tr>
            
            <tr>
                <td align="right"><s:text name="cityid"/>:&nbsp;</td>
                <td align="left">
			        <j:selector name="form.cityid" definition="CITYNAME" value="${dBAccessUser.cityid }" mode="selector" disabled="true"/>
					<font color=red>*</font>
                </td>
                <td align="right"><s:text name="comname"/>:&nbsp;</td>
                <td align="left">
                 <s:if test="CMD == WEB_CMD_NEW || CMD == WEB_CMD_EDIT">
			          <s:textfield cssStyle="style_input" name="form.comname" maxlength="128"/>
			     </s:if>
			     <s:else>
			     	<s:textfield cssStyle="style_input" name="form.comname" disabled="true"/>
			     </s:else>
                </td>
            </tr>
            
            <tr>
                <td align="right"><s:text name="filename"/>:&nbsp;</td>
                <td align="left">
                 <s:if test="CMD == WEB_CMD_NEW || CMD == WEB_CMD_EDIT">
			        <s:textfield cssStyle="style_input" name="form.filename" maxlength="200"/>
			     </s:if>
			     <s:else>
			     	<s:textfield cssStyle="style_input" name="form.filename" disabled="true"/>
			     </s:else>
                </td>
            </tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="doSave('/setcard/setcard_save.do')"
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/setcard/setcard_list.do')">
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
    if(cmd == "SAVE"){
    	setBtnDisabled("btnSave",true);
    }
</script> 