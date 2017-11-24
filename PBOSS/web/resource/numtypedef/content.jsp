<%@ page language="java" contentType="text/html;charset=gbk"%>
<%@ include file="/inc/listhead.inc" %>
<script type="text/javascript" src="<%=contextPath%>/js/pub/content.js"></script>
<html>

<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.typeid', '<s:text name="typeid"/>', 'f', true, 14);
			addfield('form.typecode', '<s:text name="typecode"/>', 'c', false, 10);
			addfield('form.typename', '<s:text name="typename"/>', 'c', false, 100);
			addfield('form.typedesc', '<s:text name="typedesc"/>', 'c', true, 200);
			addfield('form.prilevel', '<s:text name="prilevel"/>', 'f', false, 3);
			addfield('form.effective', '<s:text name="effective"/>', 'f', false, 3);
			addfield('form.isdefault', '<s:text name="isdefault"/>', 'f', false, 3);
            return (checkval(window) && checkUnique());
        }
        function checkUnique(){
        	var state=true;
        	if($(":select[name='form.effective']").val()=="1"){//当有效性为生效时
        		var typecode=$(":select[name='form.typecode']").val();//类型编码
        		var prilevel=$(":select[name='form.prilevel']").val();//优先级别
        		var effective=$(":select[name='form.effective']").val();
        		if(effective=="<s:property value="form.effective" />"){
	        		if(typecode=="<s:property value="form.typecode" />"){
	        			if(prilevel=="<s:property value="form.prilevel" />"){
	        				return true;
	        			}
	        			typecode="";//prilevel不等于原来值时
	        		}else{
	        			if(prilevel=="<s:property value="form.prilevel" />")
	        				prilevel="";
	        		}
	        	}
        		
        		jQuery.ajax({
					type:"POST",
					url:"<%=contextPath %>/resource/numtypedef_checkUnique.do",
					async:false, //同步
					data:"typecode="+typecode+"&prilevel="+prilevel,			
					success:function(msg){
						if(msg=="NO1"){
							var alertstr = '<span class=\'errorkey\'>已存在相同类型编码且有效的记录，请检查</span>';
							errorMessageShow(alertstr);
							state=false;
						}else if(msg=="NO2"){
							var alertstr = '<span class=\'errorkey\'>已经存在相同优先级且有效的记录，请检查</span>';
							errorMessageShow(alertstr);
							state=false;
						}else if(msg==""){
							state=true;
						}
					}
				});
        	}
        	return state;
        }
          $(document).ready(function(){ 
        		//
        		if($(":hidden[name='CMD']").val()=='NEW'){
        			$("#btnImport").attr("disabled",'true');
        			$("#btnExportexcel").attr("disabled",'true');
        			$("#btnDelete").attr("disabled",'true');
        			$("#ruleexp_button").attr("disabled",'true');
        			$("#btnAdd").attr("disabled",'true');
        		}
    	}); 
    	function doExcel(){
    		var typeid=$(":text[name='form.typeid']").val();
        	formList.action="<%=contextPath%>/resource/numsortrule_excel.do?param._ne_typeid="+typeid;
        	formList.submit();
        	formList.action="<%=contextPath%>/resource/numtypedef_edit.do";
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="numtypedef_edit.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._ne_typeid"/>
    <s:hidden name="param._se_typecode"/>
    <s:hidden name="param._ne_prilevel"/>
    <s:hidden name="param._ne_effective"/>
    <s:hidden name="param._ne_isdefault"/>
	
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
	 <aa:zone name="errorZone">
	<div class="error_text" >
		<table class="error_text">
			<s:actionerror /><s:actionmessage/>
		</table>
	</div>
	</aa:zone>
	
    <div class="table_div">
        <table class="table_normal">
        	<tr>
                <td align="left" colspan="4">基本信息&nbsp;&nbsp;带<font color=red>*</font>号为必填项</td>
               
            </tr>
            <tr>
                <td align="right"><s:text name="typeid"/>:&nbsp</td>
                <td align="left">
						<s:textfield cssStyle="style_input" name="form.typeid" disabled="true"/> 自动生成
                </td>
                <td align="right"><s:text name="typecode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.typecode" maxlength="10"/>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="typename"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.typename" maxlength="100"/>
					<font color=red>*</font>
                </td>
                <td align="right"><s:text name="typedesc"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.typedesc" maxlength="200"/>
                </td>
            </tr>
            <tr>
                 <td align="right"><s:text name="effective"/>:&nbsp</td>
                <td align="left">
					 <j:selector definition="$CH_VALIDFLAG" condition="dictid:0,1" name="form.effective"  cssStyle="style_input"/>
					<font color=red>*</font>
                </td>
                <td align="right"><s:text name="prilevel"/>:&nbsp</td>
                <td align="left">
					<j:selector definition="$IM_NUMTYPEPRI" name="form.prilevel"  cssStyle="style_input"/>
					<font color=red>*</font>数字越小,优先级越高
                </td>
               
            </tr>
            <tr>
                
                 <td align="right"><s:text name="isdefault"/>:&nbsp</td>
                <td align="left">
					<j:selector definition="$IM_YESNO10" name="form.isdefault"  cssStyle="style_input"/>
					<font color=red>*</font>
                </td>
                <td align="right">&nbsp;</td>
                <td align="left">
					 &nbsp;
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
                           value="<s:text name="button_save"/>" onclick="doSave('/resource/numtypedef_save.do')"/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/resource/numtypedef_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
    
</s:form>
<s:form action="numtypedef_edit.do" key="formList" cssStyle="formList" theme="simple" >
	<%//下面的控件给Action提供数据，用来分页%>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="param._pk" value="<s:property value="form.typeid" />"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>

    <div class="table_div">
		<table class="table_normal">
			<tr>
				<td align="left">规则表达式信息</td>
			</tr>
			<tr>
		</table>
		<table class="table_button_list">
			<tr>
				<td align="right">
                	<s:i18n name="public">
                	<input type="button" id="btnImport" name="btnImport" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_batchimport"/>" onClick="doImport('/resource/numtypedef/import.jsp');">
                	
                    <input type="button" id="btnExportexcel" name="btnExportexcel" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_exportexcel"/>" onClick="doExcel();">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/resource/numtypedef_deleteRule.do')">
                   </s:i18n>
				</td>
			</tr>
		</table>
	</div>

	<aa:zone name="listZone">
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style">
             <tr class="table_style_head">
               	<s:i18n name="public">
                <td title="<s:text name="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();"/>
                </td>
                </s:i18n>
               <td>
                    <a href="javascript:doOrderby('typeid')"><s:text name="number"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('ruleexp')"><s:text name="ruleexp"/></a>                 
                </td>
            </tr>
            <s:iterator value="dp.datas" status="status">
                  <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="ruleid"/>" onclick="checkOne();">
                     </td>
                     <td><s:property value="#status.count" /></td>
                     <td><s:property value="ruleexp" /></td>
                 </tr>
             </s:iterator>
        </table>
        </div>
    </div>
    <div class="table_div">
		<%@ include file="/common/pageNav.jsp"%>
   	</div>
    </aa:zone>
     <div class="table_div">
		<table class="table_normal">
			<tr>
				<td align="left">
						新增规则表达式:
						<input type="text" style="style_input" name="ruleexp" id="ruleexp" maxlength="6" readonly="readonly">
						<input type="button" name="ruleexp_button" id="ruleexp_button" class="picker_button"
 						value="..." onclick="window.showModalDialog('<%=contextPath %>/resource/numsortrule/rule.jsp',window);"/>
 						<s:i18n name="public">
		                    <input type="button" id="btnAdd" name="btnAdd" class="button" onmouseover="buttonover(this);"
		                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                        value="<s:text name="button_add"/>" onClick="doAdd('/resource/numtypedef_saveRule.do')">
                        </s:i18n>
				</td>
			</tr>
		</table>
	</div>
</s:form>
</div>

<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnDelete,btnSave,btnAdd");

	function pubRuleexp(ruleValue){
		document.getElementById('ruleexp').value=ruleValue;
	}

	function doAdd(cmdNew) {
		var ruleexp=$(":text[name='ruleexp']").val();
		if(ruleexp==null || ruleexp==""){
			alert("请选择规则表达式!");
			return;
		}
   		var url = contextPath + cmdNew;
    	formList.action = url;  
    	formList.submit();
	}
	function doImport(url){
		var typeid=$(":text[name='form.typeid']").val();
		var typecode=$(":text[name='form.typecode']").val();
		var typename=$(":text[name='form.typename']").val();
		//window.location.href=contextPath+url+"?typeid="+typeid+"&typecode="+typecode+"&typename="+typename;
		//formList.action = url+"?typeid="+typeid+"&typecode="+typecode+"&typename="+typename; 
    	//formList.submit();
		window.open(contextPath+url+"?typeid="+typeid+"&typecode="+typecode+"&typename="+typename);
	}

</script> 
</body>
</html>
