<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ taglib prefix="j" uri="/jop-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html:html>
<head>
<title>多选框</title>
<base target="_self">
<script language="JavaScript" type="text/JavaScript">
	
	var allcodeTure = false;
	
	var sis = document.all("param._selectitem");
	
    function ev_check() {
		return checkval(window);
    }
	
	function replace(strtext, text,replacetext ){
		var str = "";
		if(strtext != ""){
			if(strtext.indexOf(text) != -1 )
				str = strtext.replace(text,replacetext);
		}
		return str;
	}

	function subString(strtext){
		var str = "";
		if(strtext != ""){
			str = strtext.substring(1,strtext.length);	
		}
		return str;
	}
	function frmSubmit(){
		var fullcode = document.formList.fullcode.value;	
		var fullname = document.formList.fullname.value;
		
		var code = document.formList.code.value;	
		var name = document.formList.name.value;
		
		var allcode = document.formList.allcode.value;	
		var allname = document.formList.allname.value;
		
		var uncheckcode = document.formList.uncheckcode.value;	
		var uncheckname = document.formList.uncheckname.value;
			
		if(allcodeTure) {
			if(uncheckcode != ""){	
				var uncheckcodekey = uncheckcode.split(",");
				var unchecknamekey = uncheckname.split(",");
				var fullcodekey = fullcode.split(",");
				var fullnamekey = fullname.split(",");			
				var subfullcode = "," + fullcode;
				var subfullname = "," + fullname;
				for( i=0; i < uncheckcodekey.length; i++ ) {
					if(uncheckcodekey[i] != ""){
						subfullcode = replace(subfullcode,","+uncheckcodekey[i]+",",",");		
						subfullname = replace(subfullname,","+unchecknamekey[i]+",",",");
					}							 					
				}
				code = subString(subfullcode);	
				name = subString(subfullname);
			}else{
				code = allcode;
				name = allname;
			}
		}else{				
			if(code != ""){	
				if(isALL()){
					code = allcode;
					name = allname;
				}
			}else{
				code = "";
				name = "";
			}
		}
		
		
		window.returnValue = code + "|" + name + "|";
		window.close();
	}	
	
	
	
    function selectAll(){
    	var allcode = document.formList.allcode.value;	
		var allname = document.formList.allname.value;
        window.returnValue = allcode + "|" + allname + "|";
		window.close();
    }
    
    function deSelectAll(){
        window.returnValue = "";
		window.close();
    }
    
    
    function checkAllThis(){
		var sis = document.all("param._selectitem");
    	
    	var isAllBox = document.formList.allbox.checked; 
        if(allcodeTure) {
	        if(isAllBox){
	        	if(sis.length != null ){ 
					for( j = 0; j < sis.length; j++ ) {
						if(sis[j].checked == false) {
							var idAndName = sis[j].id.split(",");	
							if(idAndName[0] != ""){
								var uncheckcode = "," + document.formList.uncheckcode.value;
								var uncheckname = "," + document.formList.uncheckname.value;	
								document.formList.uncheckcode.value = subString(replace(uncheckcode,","+idAndName[0]+",",","));
								if(idAndName[1] == ""){
									document.formList.uncheckname.value = subString(replace(uncheckname,","+idAndName[0]+",",","));					
								}else{
									document.formList.uncheckname.value = subString(replace(uncheckname,","+idAndName[1]+",",","));					
								}	
							}		
						}				
					} 
				}else{
					if(sis.checked == false){
						var idAndName = sis.id.split(",");
						if(idAndName[0] != ""){
							var uncheckcode = "," + document.formList.uncheckcode.value;
							var uncheckname = "," + document.formList.uncheckname.value;
							document.formList.uncheckcode.value = subString(replace(uncheckcode,","+idAndName[0]+",",","));
							if(idAndName[1] == ""){
								document.formList.uncheckname.value = subString(replace(uncheckname,","+idAndName[0]+",",","));					
							}else{
								document.formList.uncheckname.value = subString(replace(uncheckname,","+idAndName[1]+",",","));					
							}
						}	
					}
				} 	
	        	
        	}else{
        		if(sis.length != null ){
					for( j = 0; j < sis.length; j++ ) {
						if(sis[j].checked == true) {
							var idAndName = sis[j].id.split(",");																
							if(idAndName[0] != ""){
								document.formList.uncheckcode.value = document.formList.uncheckcode.value + idAndName[0] + ",";
								if(idAndName[1] == ""){
									document.formList.uncheckname.value = document.formList.uncheckname.value + idAndName[0] + ",";						
								}else{
									document.formList.uncheckname.value = document.formList.uncheckname.value + idAndName[1] + ",";						
								}
							}													
						}				
					}
				}else{
					if(sis.checked == true){
						var idAndName = sis.id.split(",");						
						if(idAndName[0] != ""){
							document.formList.uncheckcode.value = document.formList.uncheckcode.value + idAndName[0] + ",";
							if(idAndName[1] == ""){
								document.formList.uncheckname.value = document.formList.uncheckname.value + idAndName[0] + ",";						
							}else{
								document.formList.uncheckname.value = document.formList.uncheckname.value + idAndName[1] + ",";						
							}
						}	
					}
				}
        		   	 		        	
        	}

        }else{
        	if(isAllBox){
	        	if(sis.length != null ){
					for( j = 0; j < sis.length; j++ ) {
						if(sis[j].checked == false) { 
							var idAndName = sis[j].id.split(",");										
							if(idAndName[0] != ""){
								document.formList.code.value = document.formList.code.value + idAndName[0] + ",";
								if(idAndName[1] == ""){
									document.formList.name.value = document.formList.name.value + idAndName[0] + ",";
								}else{
									document.formList.name.value = document.formList.name.value + idAndName[1] + ",";
								}
							}							
						}				
					}
				}else{
					if(sis.checked == false){ 
						var idAndName = sis.id.split(",");
						if(idAndName[0] != ""){
							document.formList.code.value = document.formList.code.value + idAndName[0] + ",";
							if(idAndName[1] == ""){
								document.formList.name.value = document.formList.name.value + idAndName[0] + ",";
							}else{
								document.formList.name.value = document.formList.name.value + idAndName[1] + ",";
							}
						}	
					}
				}	
	        	
        	}else{
        		if(sis.length != null ){
					for( j = 0; j < sis.length; j++ ) {
						if(sis[j].checked = true) {
							var idAndName = sis[j].id.split(",");
							if(idAndName[0] != ""){
								var code = "," + document.formList.code.value;
								var name = "," + document.formList.name.value;	
								document.formList.code.value = subString(replace(code,","+idAndName[0]+",",","));
								if(idAndName[1] == ""){
									document.formList.name.value = subString(replace(name,","+idAndName[0]+",",","));
								}else{
									document.formList.name.value = subString(replace(name,","+idAndName[1]+",",","));
								}	
							}										
						}				
					}
				}else{
					if(sis.checked == true){
						var idAndName = sis.id.split(",");
						if(idAndName[0] != ""){
							var code = "," + document.formList.code.value;
							var name = "," + document.formList.name.value;	
							document.formList.code.value = subString(replace(code,","+idAndName[0]+",",","));
							if(idAndName[1] == ""){
								document.formList.name.value = subString(replace(name,","+idAndName[0]+",",","));
							}else{
								document.formList.name.value = subString(replace(name,","+idAndName[1]+",",","));
							}
						}	
					}
				}	        	
        	}
        }
		checkAll();
    }
     function checkOneThis(id){
     	checkOne();
		var idAndName = id.split(",");  
		if(idAndName[0] != ""){
			if(allcodeTure) {
				if(document.all(id).checked == false){
					document.formList.uncheckcode.value = document.formList.uncheckcode.value + idAndName[0] + ",";
					if(idAndName[1] == ""){
						document.formList.uncheckname.value = document.formList.uncheckname.value + idAndName[0] + ",";						
					}else{
						document.formList.uncheckname.value = document.formList.uncheckname.value + idAndName[1] + ",";						
					}
				}else{ 
				
					var uncheckcode = "," + document.formList.uncheckcode.value;
					var uncheckname = "," + document.formList.uncheckname.value;	
					document.formList.uncheckcode.value = subString(replace(uncheckcode,","+idAndName[0]+",",","));
					if(idAndName[1] == ""){
						document.formList.uncheckname.value = subString(replace(uncheckname,","+idAndName[0]+",",","));					
					}else{
						document.formList.uncheckname.value = subString(replace(uncheckname,","+idAndName[1]+",",","));					
					} 
				}			
			}else{  
				if(document.all(id).checked == false){	
					var code = "," + document.formList.code.value;
					var name = "," + document.formList.name.value;	
					document.formList.code.value = subString(replace(code,","+idAndName[0]+",",","));
					if(idAndName[1] == ""){
						document.formList.name.value = subString(replace(name,","+idAndName[0]+",",","));
					}else{
						document.formList.name.value = subString(replace(name,","+idAndName[1]+",",","));
					}
					
					
				}else{						
					document.formList.code.value = document.formList.code.value + idAndName[0] + ",";	
					if(idAndName[1] == ""){
						document.formList.name.value = document.formList.name.value + idAndName[0] + ",";
					}else{
						document.formList.name.value = document.formList.name.value + idAndName[1] + ",";
					}
				}		
			} 
		}	   	
    }
    
	function init_Checked(){
		
		var code = document.formList.code.value; 
		var name = document.formList.name.value;
		
		var initcode = document.formList.initcode.value;		
		
		var allcode = document.formList.allcode.value;	
		
		if(initcode != null && initcode == allcode){
			allcodeTure = true;
		}
		
		var sis = document.all("param._selectitem");
		
		if(sis != null ){
			if(allcodeTure) {
				document.formList.allbox.checked = true;
				checkAll();				
				var uncheckcode = document.formList.uncheckcode.value;	
				if(uncheckcode != ""){			
					var uncheckcodekey = uncheckcode.split(",");			
					for( i=0; i < uncheckcodekey.length - 1; i++ ) {		
						if(sis.length != null ){
							for( j = 0; j < sis.length; j++ ) {						
								if( uncheckcodekey[i] == sis[j].value ) {				
									sis[j].checked = false;															
								}
							}
						}else{ 
							if(uncheckcodekey[i] == sis.value){
								sis.checked = false;
								break;
							}
						}				
					}
				}
			}
			else{
				if(code != null && code != ""){					
					var codekey = code.split(",");							
					for( i=0; i < codekey.length - 1; i++ ) {		
						if(sis.length != null ){					
							for( j = 0; j < sis.length; j++ ) {
								if( codekey[i] == sis[j].value ) {				
									sis[j].checked = true;													
								}				
							}						
						}else{
							if(codekey[i] == sis.value){
								sis.checked = true;
								break;
							}
						}				
					}					
				}								
			}
			checkOne();
		}			
	}
	
	function isALL(){
		
		var fullcode = document.formList.fullcode.value;				
		var code = document.formList.code.value;		
		var len = code.split(",").length;
		var len1 = fullcode.split(",").length;
		if(len == len1){
			return true;				
		}
		return false;
	}	
</script>
<body class="list_body" onload="init_Checked();">
<s:form key="formList" cssStyle="formList" theme="simple">

		<s:hidden name="definition"/>
		<s:hidden name="condition"/>
		<s:hidden name="initcondition"/>
		<s:hidden name="dbFlag"/>
		
		<s:hidden name="param._orderby" />
		<s:hidden name="param._desc" />
		<s:hidden name="param._pageno" />
		<s:hidden name="param._pagesize" />
		<s:hidden name="param._queryexpress" />
			
		<s:hidden name="initcode" />
		<s:hidden name="initname" />
		
		<s:hidden name="code" />
		<s:hidden name="name" />
		
		<s:hidden name="fullcode" />
		<s:hidden name="fullname" />		
		
		<s:hidden name="allcode" />
		<s:hidden name="allname" />
		
		<s:hidden name="uncheckcode" />
		<s:hidden name="uncheckname" />
		
		<s:hidden name="first" />
		
		<input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />" />
		
		<div class="error_text">
			<table class="error_text">
				<s:actionerror />
				<s:actionmessage />
			</table>
		</div>
		
		<div class="table_div">
			<table class="table_normal">
				<tr>
					<td height="20" align="right" class="form_table_right">
						编码:
					</td>
					<td class="form_table_left">
						<s:textfield name="queryCode" />
					</td>
					<td height="20" align="right" class="form_table_right">
						名称:
					</td>
					<td class="form_table_left">
						<s:textfield name="queryName" />
					</td>
				</tr>
			</table>
		</div>
		
		<div class="table_div">
		   <table class="table_button_list">
		      <tr>
		      	  <td>
		      	  		<input type="button" class="button_4" onmouseover="buttonover(this);" 
		                	onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" 		                		 
		                	value="选择全部" onclick="selectAll();"> 
					    <input type="button" class="button_4" onmouseover="buttonover(this);" 
							onmouseout="buttonout(this);" onfocus="buttonover(this)" 
							value="取消所有" onblur="buttonout(this)"
							onclick="deSelectAll();" />
		      	  </td>
		          <td>		               
		                <input type="submit" id="btnQuery" class="button_Query"
								onmouseover="buttonover(this);" onmouseout="buttonout(this);"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="查询" onClick="doQuery();">
						<input type="button" value="提交" onclick="frmSubmit();" class="button_2" 
		                	onmouseover="buttonover(this)" onmouseout="buttonout(this)" 
		                	onfocus="buttonover(this)" onblur="buttonout(this)">
		                <input type="button" name="btnDelete" class="button_2" onmouseover="buttonover(this);"
			                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                value="关闭" onClick="window.close();">			
		           </td>
		        </tr>
		    </table>
		</div>
		
		<aa:zone name="listZone">
		<div class="table_div">
			<div class="">    	
			<table class="table_style">				
				<tr class="table_style_head">
					<td>
						<input type="checkbox" name="allbox" onclick="checkAllThis();" class="table_checkbox">
					</td>
					<td>
						编码
					</td>
					<td>
						名称
					</td>
				</tr>
				<s:iterator value="dp.datas">
					<tr class="table_style_content" align="center"
						onMouseMove="this.bgColor='F0F5F9'"
						onMouseOut="this.bgColor='#ffffff'">
						<td>
							<input type="checkbox" name="param._selectitem" 
								id="<s:property value="code"/>,<s:property value="name"/>" onclick="javascript:checkOneThis('<s:property value="code"/>,<s:property value="name"/>');" 
								value="<s:property value="code"/>" class="table_checkbox">
						</td>
						<td>
							<s:property value="code" />
						</td>
						<td>
							<s:property value="name" />
						</td>
					</tr>
				</s:iterator>
			</table>
			</div>
		</div>	
		<div class="table_div">
			<%@ include file="/common/pageNav.jsp"%>
	   	</div>
	   	</aa:zone>
</s:form>
</body>
</html:html>
