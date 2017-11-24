<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.relaid', '<s:text name="relaid"/>', 'f', true, 18);
			addfield('form.comcategory', '<s:text name="comcategory"/>', 'c', false, 20);
			addfield('form.comid', '<s:text name="comid"/>', 'f', false, 18);
			addfield('form.restype', '<s:text name="restype"/>', 'c', false, 32);
			if($(":select[name='form.restype']").val()=='COMRESSMP')
				addfield('form.brand', '<s:text name="brand"/>', 'c', false, 16);
			else
				addfield('form.brand', '<s:text name="brand"/>', 'c', true, 16);
			
            return (checkval(window) && checkUnique());
        }
         function checkUnique(){
        		var comid=$(":select[name='form.comid']").val();//类型编码
        		if(comid=="<s:property value="form.comid" />"){
        				return true;
        		}
        		var state=false;
        		jQuery.ajax({
					type:"POST",
					url:"<%=contextPath %>/resource/comcategoryrela_checkUnique.do",
					async:false, //同步
					data:"comid="+comid,			
					success:function(msg){
						if(msg=="NO"){
							var alertstr = "<span class=\'errorkey\'>商品标识["+comid+"]已经存在，不允许重复录入</span>";
							errorMessageShow(alertstr);
							state=false;
						}else if(msg==""){
							state=true;
						}
					}
				});
        	return state;
        }
        function selectRestype(val){
        	if(val=='COMRESSMP'){
        		$("#red_brand").show();
        	}else{
        		$("#red_brand").hide();
        	}
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="comcategoryrela_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_comcategory"/>
    <s:hidden name="param._ne_comid"/>
    <s:hidden name="param._se_restype"/>
	
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="resource"/> </span>
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
                <td align="right"><s:text name="relaid"/>:&nbsp</td>
                <td align="left">
                        <s:textfield cssStyle="style_input" name="form.relaid" maxlength="18" readOnly="true"/> 自动生成
                </td>
            </tr>
             <tr>
                <td align="right"><s:text name="restype"/>:&nbsp</td>
                <td align="left">
					<j:selector definition="$IM_FXRESTYPE" name="form.restype"  cssStyle="style_input" onchange="selectRestype(this.value);"/>
					<font color=red>*</font>
                </td>
            </tr>
             <tr>
                <td align="right"><s:text name="brand"/>:&nbsp</td>
                <td align="left">
					<p:smpBrand name="form.brand" mode="def" cssStyle="style_input" />
					<font id="red_brand" style="display: none"  color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comcategory"/>:&nbsp</td>
                <td align="left">
					<j:selector definition="$IM_FXCOMCATEGORY" name="form.comcategory"  cssStyle="style_input"/>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comid"/>:&nbsp</td>
                <td align="left">
					<j:Comidtree name="form.comid" condition="comclassid:0;comclassid:1;comclassid:2;comclassid:3;comclassid:4;comclassid:5;comclassid:6;comclassid:99" definition="#COMSYSTEM" nameOnly="true" readonly="false"/>
					<font color=red>*</font>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/resource/comcategoryrela_save.do')" <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/resource/comcategoryrela_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
