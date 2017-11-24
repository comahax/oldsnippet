<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib prefix="j" uri="/jop-tags" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
	function ev_checkval() {
		addfield('form.countyid', '<s:text name="countyid"/>', 'c', false, 14);
		addfield('form.mareacode', '<s:text name="mareacode"/>', 'c', false, 14);
		addfield('form.starlevel', '<s:text name="starlevel"/>', 'l', false,2);
		addfield('form.comcategory', '<s:text name="comcategory"/>', 'c', false, 20);
		addfield('form.brand', '<s:text name="brand"/>', 'c', false, 16);
		addfield('form.disscale', '<s:text name="disscale"/>', 'f', false, 16);
        
        var validate1 = checkval(window);
		var validate2 = true;
		if(document.all("form.disscale").value!=""){
    		if(document.all("form.disscale").value*1<0 ||document.all("form.disscale").value*1>1){
    			var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[库存比例]</span>' + '必须是0到1之间的数字,包括0和1,最多两位小数!' + '</span>';
				var errorDiv = $("#msgDiv");
				if(document.getElementById("msgDiv"))
				{
					$("#msgDiv").append(alertstr);
				}
				else
				{
					errorMessageShow(alertstr);
				}
        		validate2 = false;
        	}
        }
		return validate1&&validate2;
	}
	
	//从选择框的值获取选择的显示内容
	/*function mapSelect(objid,val)
	{
		var str = "";
		$("#"+objid).children().each(function(i){
			if(this.value == val)
			{
				str = this.innerText;
			}
		});
		return str;
	}
	
	function getComcategory()
	{
		var brand = $("#brand").val();
		var relaInfo = "";
		var relaInfoArray;
		var comcategoryArray;
		var str = "";
		var comcategoryName="";
		$("#relaInfoSpan .relaInfo").each(function(i){
			relaInfo = $(this).val();
			relaInfoArray = relaInfo.split(":");
			if(relaInfoArray.length==2)
			{
				if(relaInfoArray[0] == brand)
				{
					comcategoryArray = relaInfoArray[1].split(",");
					for(var i=0; i<comcategoryArray.length; i++)
					{
						comcategoryName = mapSelect("comcategoryHid", comcategoryArray[i]);
						str = str + '<option value="' + comcategoryArray[i] + '">' + comcategoryName + '</option>';
					}
				}
			}
		});
		$("#comcategory").html(str);
	}
	*/
	/*$(document).ready(function(){
		//出错返回的情况
		var brand = $("#brand").val();
		if(brand.length!="")
		{
			getComcategory();
		}
	});*/
	
	function opendMareacode(aObj,formWhere){
	     var countyid = document.getElementById('countyid').value;
	     if(countyid == ''){
		      alert("请先输入分公司");
                    return;
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
<s:form action="comdisscale_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_comcategory"/>
    <s:hidden name="param._se_brand"/>
	<input type="hidden" id="countyid" value="${form.countyid}"/>
	<span id="relaInfoSpan">
	<s:iterator value="form.relaInfoList" status="status">
		<s:hidden name="form.relaInfoList[%{#status.index}]" cssClass="relaInfo"/>
	</s:iterator>
	</span>
	
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
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
						<s:textfield name="form.mareacode" disabled="true"/><input class="picker_button" onclick="javascript:opendMareacode(this,'#MICROAREA');"  type="button" value="..." name="form.mareacode_button" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="starlevel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_STARLEVEL2" name="form.starlevel" />
					</s:if>
					<s:else>
						<j:selector definition="$CH_STARLEVEL2" name="form.starlevel"  disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
        	<tr>
                <td align="right"><s:text name="brand"/>:</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<p:smpBrand name="form.brand" id="brand" mode="def" cssStyle="style_input"/>
					</s:if>
					<s:else>
						<p:smpBrand name="form.brand" id="brand" mode="def" cssStyle="style_input" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comcategory"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD != WEB_CMD_SAVE">
                        <j:selector name="form.comcategory" definition="$IM_FXCOMCATEGORY" mode="picker"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
			        	<j:selector definition="$IM_FXCOMCATEGORY" name="form.comcategory" mode="picker" disabled="true"/>
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="disscale"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.disscale" maxlength="4"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.disscale" disabled="true"/>
					</s:else>
					<font color=red>*</font>要求为0到1之间的数字,包括0和1,最多两位小数
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
                           value="<s:text name="button_save"/>" onclick="doSave('/sales/comdisscale_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/sales/comdisscale_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>