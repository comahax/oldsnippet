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
		addfield('form.recid', '<s:text name="recid"/>', 'f', true, 14);
		addfield('form.countyid', '<s:text name="countyid"/>', 'c', false, 14);
		addfield('form.mareacode', '<s:text name="mareacode"/>', 'c', false, 14);
		addfield('form.starlevel', '<s:text name="starlevel"/>', 'f', false, 2);
		addfield('form.intervaltime', '<s:text name="intervaltime"/>', 'f', false, 10);
		return checkval(window);
	}	
	
	function putCountyID(countyid){
	     document.getElementById('countyid').value=countyid;
	     //alert(countyid);
	     document.getElementById('mareacode').value="";
	}
	
	function opendMareacode(aObj,formWhere){
		 var countyid = document.getElementById('countyid').value;
		 //alert("*"+countyid);
		 if(countyid == ''){
		 	alert("请先输入分公司");
		 }else{
		    openPicker(aObj,formWhere,null,'boss.cms.microarea.queryBycountyid','COUNTYID:'+countyid);
		 }
	}
	
	function openPicker(control,definition,condition) {            
            if(definition == null || definition =="") {	  	    			
    	   		alert("definition is required!");
    	   		return ;
    	    }
    	    
    	    definition = window.encodeURIComponent(definition);	    
    	    var url = contextPath +"/common/picker_list.do?definition=" + definition;
    	    
    	    // 对微区域查询时使用命名查询
    	    //alert("control.name.indexOf('form.mareacode')"+control.name.indexOf('form.mareacode'))
    	    if (control.name.indexOf('form.mareacode') > -1) {
    	    
	    	    var sqlName = window.encodeURIComponent("boss.cms.microarea.queryBycountyid");
	    	    var url = url + "&sqlName=" + sqlName;
	    	    
	    	    // 查询参数使用分公司ID
	    	    var mapParam = window.encodeURIComponent("COUNTYID:" + document.all('form.countyid').value);
	    	    var url = url + "&mapParam=" + mapParam;
    	    }

    	    if(condition!=null) {
    	    	condition = window.encodeURIComponent(condition);
    	    	url = url +"&condition=" + condition;
    	    }
    	    
    	    url = url +"&" + new Date();

    		var rtn = window.showModalDialog(url, control, "dialogWidth:750px; dialogHeight:550px; status:no;resizable:no;");
    		
    		if( rtn == null) 
    			return false;
    			
    		var buttonID = control.name;		
    		if(buttonID == null || buttonID == "") {
    			alert("Must set the name property for this selector control!");
    			return false;
    		} 
    			
    		var selectorID = buttonID.substring(0, buttonID.indexOf("_button"));
    		var selectorTextID = selectorID + "_text";
    		
    		var codeCtrl = document.getElementById( selectorID );
    		var nameCtrl = document.getElementById( selectorTextID ); 
    		 
    		if(codeCtrl!=null) {
    			codeCtrl.value = rtn[0];
    			codeCtrl.focus();
    			}		
    		if(nameCtrl!=null) nameCtrl.value = rtn[1];
        }
</script>
</head>
<body>
<div class="table_container">
<s:form action="disformintervaltime_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_countyid"/>
    <s:hidden name="param._se_mareacode"/>
    <s:hidden name="param._ne_starlevel"/>
    <input type="hidden" id ="countyid" value='<s:property value="form.countyid"/>'/>
	
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea">配送单管理</span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
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
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.recid" disabled="true" disabled="true"/>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.recid" disabled="true" disabled="true"/>
			        </s:else>自动生成
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="countyid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#CNTYCOMPANY"  condition="citycompid:${USER.cityid}" name="form.countyid" mode="selector" onchange="putCountyID(this.value);"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<j:selector definition="#CNTYCOMPANY"  condition="citycompid:${USER.cityid}" name="form.countyid" mode="selector" onchange="putCountyID(this.value);"/>
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="mareacode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield styleId="order_list_do_param__se_mareacode_text" name="form.mareacode" id="mareacode" readonly="true"/>
						<INPUT class="picker_button" onclick="javascript:opendMareacode(this,'#MICROAREA'); " type="button" value="..." name="form.mareacode_button"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<s:textfield styleId="order_list_do_param__se_mareacode_text" name="form.mareacode" id="mareacode" readonly="true"/>
						<INPUT class="picker_button" onclick="javascript:opendMareacode(this,'#MICROAREA'); " type="button" value="..." name="form.mareacode_button"/>
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="starlevel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_STARLEVEL" name="form.starlevel"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<j:selector definition="$CH_STARLEVEL" name="form.starlevel"/>
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="intervaltime"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.intervaltime" />
						<font color=red>*</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.intervaltime"/>
						<font color=red>*</font>
					</s:else>单位：天
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
                           value="<s:text name="button_save"/>" onclick="doSave('/sales/disformintervaltime_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/sales/disformintervaltime_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>