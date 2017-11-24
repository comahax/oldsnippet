<%@ page language="java" contentType="text/html;charset=GBK"%>

<%@ include file="/inc/listhead.inc" %>

<html>
  <head>
    
    <title><bean:message bundle="fee" key="selectPageList"/></title>
    <base target="_self">
 <script language=javascript>
	function ev_check() {
       	addfield('startindex', '<bean:message bundle="fee" key="startindex"/>', 'i', false, 20);
        addfield('endindex', '<bean:message bundle="fee" key="endindex"/>', 'i', false, 20);
        return checkval(window);
    }		
			
	function frmSubmit(){
		if(ev_check()){
			var startindex = document.all.startindex.value;
			var endindex = document.all.endindex.value;
			
			if(endindex < 1 || startindex < 1){
				alert('<bean:message bundle="fee" key="startindex"/><bean:message bundle="fee" key="and"/><bean:message bundle="fee" key="endindex"/><bean:message bundle="fee" key="plusNum"/>');
			}else if(endindex - startindex < 0){
				alert('<bean:message bundle="fee" key="startindex"/><bean:message bundle="fee" key="compare_gt"/><bean:message bundle="fee" key="endindex"/>');
			}else if(endindex - startindex >= 100){
				alert('<bean:message bundle="fee" key="pagenosize"/><bean:message bundle="fee" key="compare_gt"/>100');
			}else {
				
				var infopage = document.all.startindex.value + "|" + document.all.endindex.value; 
	
				window.returnValue = infopage;
				window.close();
			}
		}
	}
 </script>
</head>
 
<body>

<form method="post" id="formList">
	<div class="table_div">
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="fee" key="selectPageList"/></td>
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
        <table class="form_table">
        	<tr>
            	<td class="form_table_left" colspan="4"><bean:message bundle="fee" key="redStarExplain"/><br><bean:message bundle="fee" key="selectpageinfo"/></td>
            </tr>
            <tr>
            	<td class="form_table_right"><bean:message bundle="fee" key="startindex"/>:</td>
                <td class="form_table_left">
                	<input type="text" maxlength="20" value="1" name="startindex"><bean:message bundle="fee" key="redStar"/>
                </td>
                <td class="form_table_right"><bean:message bundle="fee" key="endindex"/>:</td>
                <td class="form_table_left">
                	<input type="text" maxlength="20" value="100" name="endindex"><bean:message bundle="fee" key="redStar"/>
                </td>
            </tr>
		</table>
    </div>
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
			        <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
			               onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			               value="<bean:message bundle="public" key="button_close"/>" onClick="window.close();">
			        <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_submit"/>" onClick="frmSubmit();">          
			    </td>	
			</tr>
		</table>
	</div>     	          
 </form>       

</body>
</html>
