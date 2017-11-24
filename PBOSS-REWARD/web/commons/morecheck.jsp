<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>

<html:html>
	<head>
		<title><bean:message bundle="public" key="choosedata"/></title>
		<base target="_self">
<script language="JavaScript" type="text/JavaScript">
	
	var allcodeTure = false;
	
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
    	var isAllBox = document.formList.allbox.checked; 
        if(allcodeTure) {
	        if(isAllBox){
	        	if(document.formList._selectitem.length != null ){ 
					for( j = 0; j < document.formList._selectitem.length; j++ ) {
						if(document.formList._selectitem[j].checked == false) {
							var idAndName = document.formList._selectitem[j].id.split(",");	
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
					if(document.formList._selectitem.checked == false){
						var idAndName = document.formList._selectitem.id.split(",");
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
        		if(document.formList._selectitem.length != null ){
					for( j = 0; j < document.formList._selectitem.length; j++ ) {
						if(document.formList._selectitem[j].checked == true) {
							var idAndName = document.formList._selectitem[j].id.split(",");																
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
					if(document.formList._selectitem.checked == true){
						var idAndName = document.formList._selectitem.id.split(",");						
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
	        	if(document.formList._selectitem.length != null ){
					for( j = 0; j < document.formList._selectitem.length; j++ ) {
						if(document.formList._selectitem[j].checked == false) { 
							var idAndName = document.formList._selectitem[j].id.split(",");										
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
					if(document.formList._selectitem.checked == false){ 
						var idAndName = document.formList._selectitem.id.split(",");
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
        		if(document.formList._selectitem.length != null ){
					for( j = 0; j < document.formList._selectitem.length; j++ ) {
						if(document.formList._selectitem[j].checked = true) {
							var idAndName = document.formList._selectitem[j].id.split(",");
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
					if(document.formList._selectitem.checked == true){
						var idAndName = document.formList._selectitem.id.split(",");
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
		
		if(document.formList._selectitem != null ){
			if(allcodeTure) {
				document.formList.allbox.checked = true;
				checkAll();				
				var uncheckcode = document.formList.uncheckcode.value;	
				if(uncheckcode != ""){			
					var uncheckcodekey = uncheckcode.split(",");			
					for( i=0; i < uncheckcodekey.length - 1; i++ ) {		
						if(document.formList._selectitem.length != null ){
							for( j = 0; j < document.formList._selectitem.length; j++ ) {						
								if( uncheckcodekey[i] == document.formList._selectitem[j].value ) {				
									document.formList._selectitem[j].checked = false;															
								}
							}
						}else{ 
							if(uncheckcodekey[i] == document.formList._selectitem.value){
								document.formList._selectitem.checked = false;
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
						if(document.formList._selectitem.length != null ){					
							for( j = 0; j < document.formList._selectitem.length; j++ ) {
								if( codekey[i] == document.formList._selectitem[j].value ) {				
									document.formList._selectitem[j].checked = true;													
								}				
							}						
						}else{
							if(codekey[i] == document.formList._selectitem.value){
								document.formList._selectitem.checked = true;
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
<body onload="init_Checked();">
<div class="table_container">	
<html:form action="/commons/morecheck.do?CMD=MORECHECK" styleId="formList" method="post" onsubmit="return ev_check();">
		<html:hidden property="definition"/>
		<html:hidden property="condition"/>
		<html:hidden property="dbFlag"/>
		
		<html:hidden property="_orderby" />
		<html:hidden property="_desc" />
		<html:hidden property="_pageno" />
		<html:hidden property="_pagesize" />
		
		<html:hidden property="initcode" />
		<html:hidden property="initname" />
		
		<html:hidden property="code" />
		<html:hidden property="name" />
		
		<html:hidden property="fullcode" />
		<html:hidden property="fullname" />		
		
		<html:hidden property="allcode" />
		<html:hidden property="allname" />
		
		<html:hidden property="uncheckcode" />
		<html:hidden property="uncheckname" />
		
		<html:hidden property="first" />
		
		<input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
		
		<div class="table_div">
			<table class="top_table">
			     <tr>
			     	 <td><bean:message bundle="public" key="choosedata"/></td>
			     </tr>
		    </table>
		</div>
		<div class="table_div">
			<table class="error_text">
				<html:errors />
				<s:Msg />
			</table>
		</div>
		
		<div class="table_div">
		   <table class="table_button_list">
		      <tr>
		      	  <td>
		      	  		<input type="button" class="button_4" onmouseover="buttonover(this);" 
		                	onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" 		                		 
		                	value="<bean:message bundle="credstatechg" key="selectall" />" onclick="selectAll();"> 
					    <input type="button" class="button_4" onmouseover="buttonover(this);" 
							onmouseout="buttonout(this);" onfocus="buttonover(this)" 
							value="<bean:message bundle="credstatechg" key="selectnull"/>" onblur="buttonout(this)"
							onclick="deSelectAll();" />
		      	  </td>
		          <td>		               
		               
						<input type="button" value="<bean:message bundle="public" 
		                	key="button_submit"/>" onclick="frmSubmit();" class="comfir" 
		                	onmouseover="buttonover(this)" onmouseout="buttonout(this)" 
		                	onfocus="buttonover(this)" onblur="buttonout(this)" ID="Button1" NAME="Button6">
		                <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
			                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                value="<bean:message bundle="public" key="button_close"/>" onClick="window.close();">			
		            </td>
		        </tr>
		    </table>
		</div>
	   	<div class="table_div" >
			<s:PageNav dpName="LIST"/>
		</div>
		<div class="table_div">
			<div class="table_LongTable">    	
			<table class="table_style">				
				
				<tr class="table_style_head">
					<td  width="30" title="<bean:message bundle="public" key="list_title_select"/>">
						<input type="checkbox" name="allbox" onclick="checkAllThis();" class="table_checkbox">
					</td>
					<td><bean:message bundle="public" key="code"/></td>
					<td><bean:message bundle="public" key="name"/></td>			
				</tr>
				
				<c:forEach var="item" items="${requestScope.LIST.datas}">
					<tr class="table_style_content" align="center">
						<td>
							<input type="checkbox" name="_selectitem" 
								id="<c:out value='${item.code},${item.name},' />" onclick="checkOneThis('<c:out value='${item.code},${item.name},' />');" 
								value="<c:out value='${item.code}' />" class="table_checkbox">
						</td>
						<td><c:out value="${item.code}"/></td>
						<td><c:out value="${item.name}"/></td>
					</tr>
				</c:forEach>							
			</table>
			</div>
		</div>	
</html:form>
</div>	
</body>
</html:html>

