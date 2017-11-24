<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <style>
	    pre 
	    {
		    white-space: pre-wrap;       /* css-3 */
		    white-space: -moz-pre-wrap;  /* Mozilla, since 1999 */
		    white-space: -pre-wrap;      /* Opera 4-6 */
		    white-space: -o-pre-wrap;    /* Opera 7 */
		    word-wrap: break-word;       /* Internet Explorer 5.5+ */
		    text-align: left;
	    } 
    </style>
    <script language="JavaScript">
        function ev_checkval() {
			addfield('form.instname','<s:text name="instname"/>', 'c', false, 50);
			addfield('form.tmplid','<s:text name="tmplid"/>','f', false, 6);
			addfield('form.memo','<s:text name="memo"/>','c', true, 512);
			
			$("#paramTable .param").each(function(i){
				if($(this).attr("hasStar")=="Y")
				{
					addfield('param'+i,$(this).attr("paramName"), 'c', false, 50);
				}
			});
            return checkval(window);
        }
        
        //动态获取参数列表
        function getParamNameStr()
        {
       		var url="<%=contextPath%>/promotion/elmtinst_getParamInfo.do";
       		var tmplid = $("#tmplid").val();
       		if(tmplid!='')
       		{
       		   ajaxAnywhere.submitByURL(url);
       		}
        }
        
        //保存元素实例
        function doSaveElmtinst()
        {
        	//获取日期选框的参数值
        	var paramVal = "";
        	var paramDesc = "";
        	var year = "";
        	var mouth = ""
        	var day = "";
        	var dateVal = "";
        	var dateText;
        	$("#paramTable .dateHid").each(function(i){
        		dateText = $(this).next(":first");
        		if(dateText.val()!="")
        		{
        			dateVal = "";
        	
	        		paramVal = dateText.val();
	        		paramDesc = dateText.attr("paramDesc");
	        		year = paramVal.substring(0,4);
	        		mouth = paramVal.substring(5,7);
	        		day = paramVal.substring(8,10);
	        		dateVal = year + mouth + day;
	        		if(paramDesc=="START")
	        		{
	        			dateVal = dateVal + "000000";
	        		}
	        		else if(paramDesc=="END")
	        		{
	        			dateVal = dateVal + "235959";
	        		}
	        		$(this).val(dateVal);
        		}
        	});
        	
        	//获取复选框的参数值
        	var checkVal = "";
        	$("#paramTable .checkHid").each(function(i){
        		checkVal = "";
        		//取得对应的复选框
        		$(this).parent().children(":checkbox").each(function(j){
        			if(this.checked)
        			{
        				checkVal = checkVal + "'" + $(this).val() + "',";
        			}
        		});
        		//去掉末尾分隔符
        		checkVal = checkVal.substring(0,checkVal.length-1);
        		$(this).val(checkVal);
        	});
        	
        	//拼接参数字符串
        	var str = "";
        	var paramName = $("#paramTable .paramName");
        	var paramValue = $("#paramTable .paramValue");
        	
        	//参数赋值
        	paramName.each(function(i){
        		if(paramValue.eq(i).val()!="")
        		str = str + paramName.eq(i).val() + "=" + paramValue.eq(i).val() + ";";
        	});
        	$("#params").val(str);
        	
        	//保存
        	doSave("/promotion/elmtinst_save.do");
        }
        
        //回调处理,获取参数列表
        ajaxAnywhere.onAfterResponseProcessing = nativeCallBack;
        function nativeCallBack()
        {	
        	//动态获取参数列表
        	var str = "";
        	var paramNameStr = $("#paramNameStr").val();
        	
        	if(paramNameStr!="")
        	{
        		var paramArray = paramNameStr.split("|");
        		//有效元素个数为paramArray.length-1，最后一个元素为空
        		str = str + '<tr><td align="right" width="200px">参数名称&nbsp;</td><td align="left">&nbsp;参数值</td></tr>\n';
        		//根据不同的参数前缀，产生不同参数项
        		
        		var paramName = "";
        		var paramDesc = "";
        		var paramValue = "";
        		var hasStar;
        		for(var i=0; i<paramArray.length-1; i++)
	        	{
	        		//重置
	        		hasStar = "";
	        		
	        		//判断是否为必填
	        		if(paramArray[i].indexOf("*")!=-1)
	        		{
	        			hasStar = "Y";
	        		}

	        		//参数为TEXT
	        		if(paramArray[i].substring(0,4)=="TEXT")
	        		{
	        			paramName = paramArray[i].substring(5,paramArray[i].indexOf("{"));
	        			paramDesc = paramArray[i].substring(paramArray[i].indexOf("{")+1,paramArray[i].indexOf("}"));
	        			str = str + '<tr><td align="right"><input type="hidden" elmFlag="TEXT" class="paramName" value="' + paramName + '">' + paramName + '&nbsp;</td>'
		        		+ '<td align="left">&nbsp;<input type="text" name="param' + i + '" hasStar="' + hasStar + '" class="paramValue param" paramName="' + paramName + '">';
	        		}
	        		//参数为DATE
	        		else if(paramArray[i].substring(0,4)=="DATE")
	        		{
	        			paramName = paramArray[i].substring(5,paramArray[i].indexOf("{"));
	        			paramDesc = paramArray[i].substring(paramArray[i].indexOf("{")+1,paramArray[i].indexOf("}"));
	        			str = str + '<tr><td align="right"><input type="hidden" elmFlag="DATE" class="paramName" value="' + paramName + '">' + paramName + '&nbsp;</td>'
		        		+ '<td align="left">&nbsp;<input type="hidden" class="paramValue dateHid"><input type="text" readonly="true" onclick="selectDate();" paramName="' + paramName + '" paramDesc="' + paramDesc + '" name="param' + i + '" hasStar="' + hasStar + '" class="param"/>';
	        		}
	        		//参数为CHECKBOX
	        		else if(paramArray[i].substring(0,8)=="CHECKBOX")
	        		{
	        			paramName = paramArray[i].substring(9,paramArray[i].indexOf("{"));
	        			paramValue = paramArray[i].substring(paramArray[i].indexOf("{")+1,paramArray[i].indexOf("}"));
	        			//去掉末尾";"
	        			paramValue = paramValue.substring(0,paramValue.length-1);
	        			
	        			str = str + '<tr><td align="right"><input type="hidden" elmFlag="CHECKBOX" class="paramName" value="' + paramName + '">' + paramName + '&nbsp;</td>'
	        			+ '<td align="left"><input type="hidden" class="paramValue checkHid">&nbsp;';
	        			var paramValArray = paramValue.split(";");
	        			for(var j=0; j<paramValArray.length; j++)
	        			{
	        				str = str + '<input type="checkbox" class="box" value="' + paramValArray[j].split(":")[0] + '"/>' + paramValArray[j].split(":")[1];
	        			}
	        		}
	        		
	        		if(hasStar=="Y")
	        		{
	        			str = str + '<font color="red">&nbsp;*</font>';
	        		}
	        		str = str + '</td></tr>\n';
	        	}
        	}
        	$("#paramTable").append(str);
	        
	        //编辑或保存时，参数项赋值	
	        var cmd = $("#cmd").val();
	        if(cmd=="SAVE" || cmd=="EDIT")
	        {
	        	var params = $("#params").val();
	        	var paramArray = params.split(";");
	        	var checkArray;
	        	var paramValue = "";
	        	var dateValue = "";
	        	var box;
        		$("#paramTable .paramName").each(function(i){
	        		for(var j=0; j<paramArray.length; j++)
		        	{
	        			if($(this).val()==paramArray[j].split("=")[0])
	        			{
	        				paramValue = paramArray[j].split("=")[1];
	        				
	        				if($(this).attr("elmFlag")=="TEXT")
	        				{
	        					//取得对应文本框赋值
	        					$(this).parent().next(":first").children(":text").eq(0).val(paramValue);
	        				}
	        				else if($(this).attr("elmFlag")=="DATE")
	        				{
	        					//取得对应日期赋值
	        					dateValue = paramValue.substring(0,4) + "-"
	        							  + paramValue.substring(4,6) + "-"
	        							  + paramValue.substring(6,8);
	        					$(this).parent().next(":first").children(":text").eq(0).val(dateValue);
	        				}
	        				else if($(this).attr("elmFlag")=="CHECKBOX")
	        				{
	        					//取得对应复选框赋值
	        					checkArray = paramValue.split(",");
	        					
	        					$(this).parent().next().children(".box").each(function(k){
		        					for(var m=0; m<checkArray.length; m++)
		        					{
		        						//比较时去掉单引号
		        						if($(this).val()==checkArray[m].substring(1,checkArray[m].length-1))
		        						{
		        							$(this).attr("checked",true);
		        						}
		        					}
	        					});
	        				}
	        			}
	        		}
        		});
	        }
	        //保存后参数不可编辑
        	if(cmd=="SAVE")
        	{
        		$("#paramTable :checkbox").each(function(i){
        			$(this).attr("disabled",true);
        		});
        		$("#paramTable :text").each(function(i){
        			$(this).attr("disabled",true);
        		});
        	}
        	
        	//显示参数
        	$("#paramDiv").show();
        }
        
        //初始化
        $(document).ready(function(){
        	var cmd = $("#cmd").val();
        	//动态生成参数
        	if(cmd!="NEW")
        	{
        		getParamNameStr();
	        }
        });
    </script>
</head>
<body>
<div class="table_container">
<s:form action="elmtinst_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD" id="cmd"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="form.instid" id="instid"/>
	
	<s:hidden name="form.type"/>
	<s:hidden name="form.params" id="params"/>
	
	<div class="table_top" id="top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="promotion"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent1"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
		</div>
	</div>

	<div class="error_text" >
		<table class="error_text">
			<s:actionerror /><s:actionmessage/>
		</table>
	</div>
	
    <div class="table_div">
	    <fieldset class="table_container">
			<legend>实例信息</legend>
	        <table class="table_normal">
	            <tr>
	                <td align="right" width="200px"><s:text name="instname"/>:&nbsp</td>
	                <td align="left">
	                	<s:if test="CMD=='NEW' or CMD=='EDIT'">
						<s:textfield cssStyle="style_input" name="form.instname" maxlength="50"/>
						<font color="red">&nbsp;*</font>
						</s:if>
						<s:else>
						<s:textfield cssStyle="style_input" name="form.instname" maxlength="50" disabled="true"/>
						<font color="red">&nbsp;*</font>
						</s:else>
	                </td>
	            </tr>
	       
	            <tr>
	                <td align="right"><s:text name="tmplid"/>:&nbsp</td>
	                <td align="left">
	               	 <s:if test="CMD=='NEW' or CMD=='EDIT'">
	               	 	<s:textfield name="form.tmplid" readonly="true" id="tmplid" /><input type="button" name="form.tmplid_button" class="picker_button" value="..." 
						 onclick="javascript:openPicker(this,'#ELMTTMPL','state:1');getParamNameStr();" />
						 <font color="red">&nbsp;*</font>
	               	 </s:if>
	               	 <s:else>
	               	 	<s:textfield name="form.tmplid" disabled="true" id="tmplid" />
						 <font color="red">&nbsp;*</font>
	               	 </s:else>
	                </td>
	            </tr>
	            <tr>
	                <td align="right"><s:text name="memo"/>:&nbsp</td>
	                <td align="left">
	                	<s:if test="CMD=='NEW' or CMD=='EDIT'">
							<s:textarea name="form.memo" cols="60" rows="9" maxlength="512" />
						</s:if>
						<s:else>
							<s:textarea name="form.memo" cols="60" rows="9" disabled="true" maxlength="512" />
						</s:else>
	                </td>
	            </tr>
	        </table>
	    </fieldset>
    </div>
    <aa:zone name="refreshTable">
    	<input type="hidden" id="paramNameStr" value="<%=request.getAttribute("paramNameStr")==null?"":(String)request.getAttribute("paramNameStr")%>"/>
   		<div class="table_div" id="paramDiv" style="display: none;">
   			<fieldset class="table_container">
				<legend>参数列表</legend>
				<div align="left">模板说明:</div>
				<div align="left"><s:label name="form.elmttmplMemo"/></div>
				<table class="table_normal" id="paramTable">
	        	</table>
			</fieldset>
   		</div>
    </aa:zone>
    <div class="table_div">
        <table class="table_button_list" border=1>
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="doSaveElmtinst()"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/promotion/elmtinst_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>