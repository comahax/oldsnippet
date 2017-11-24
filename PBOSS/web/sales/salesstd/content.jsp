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
		//addfield('form.recid', '<s:text name="recid"/>', 'f', false, 14);
		addfield('form.cityid', '<s:text name="cityid"/>', 'c', false, 10);
		addfield('form.countyid', '<s:text name="countyid"/>', 'c', false, 14);
		addfield('form.mareacode', '<s:text name="mareacode"/>', 'c', false, 14);
		addfield('form.starlevel', '<s:text name="starlevel"/>', 'f', false, 2); 
		addfield('form.salesstd', '<s:text name="salesstd"/>', 'f', false, 10);
		return checkval(window);
	}
		function opendMareacode(aObj,formWhere){
	     var countyid = document.getElementById('countyid').value;
	     if(countyid == ''){		     
		        alert("请先输入分公司");
               return;
		     //openPicker(aObj,formWhere);
	     }else{
		     openPicker(aObj,formWhere,null,'boss.cms.microarea.queryBycountyid','COUNTYID:'+countyid);
	    }
    }
    
   function putCountyID(countyid){
	     document.getElementById('countyid').value=countyid;
	}
	
</script>
</head>
<body>
<div class="table_container">
<s:form action="salesstd_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_countyid"/>
    <s:hidden name="param._se_mareacode"/>
    <s:hidden name="param._ne_starlevel"/>
    <s:hidden name="param._se_brand"/>
	<input type="hidden" id="countyid" value="${form.countyid}"/>
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea">合作商销量提醒 </span>
			<span class="table_toparea_xi">&gt;</span>
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
                <td align="right"><s:text name="recid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.recid" maxlength="14" disabled="true"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.recid" readonly="true"/>
						<font color=red>*</font>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.recid" readonly="true"/>
						<font color=red>*</font>
			        </s:else>
			        自动生成
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="countyid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
					<j:selector definition="#CNTYCOMPANY" name="form.countyid" mode="selector" condition="citycompid:${dBAccessUser.cityid }" onchange="putCountyID(this.value);" />
					</s:if>
					<s:else>
					<j:selector definition="#CNTYCOMPANY" name="form.countyid" mode="selector" condition="citycompid:${dBAccessUser.cityid }" disabled="true" />
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="mareacode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield name="form.mareacode"/><input class="picker_button" onclick="javascript:opendMareacode(this,'#MICROAREA');"  type="button" value="..." name="form.mareacode_button"/>
					</s:if>
					<s:else>
						<j:selector definition="#MICROAREA" name="form.mareacode" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="starlevel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_STARLEVEL" name="form.starlevel" />
					</s:if>
					<s:else>
						<j:selector definition="$CH_STARLEVEL" name="form.starlevel"  disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr> 
            <tr>
                <td align="right"><s:text name="salesstd"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.salesstd" maxlength="10"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.salesstd" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					单位：套，要求大于零的整数，不超过10位
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
                           value="<s:text name="button_save"/>" onclick="doSave('/sales/salesstd_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/sales/salesstd_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>