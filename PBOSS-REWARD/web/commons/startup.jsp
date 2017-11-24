<%@ page language="java" contentType="text/html;charset=GBK"%>

<%@ include file="/inc/listhead.inc" %>

<html>
  <head>
    
    <title><bean:message bundle="fee" key="startup"/></title>
    <base target="_self">
 <script language=javascript>
	function ev_check() {
       	addfield('startrsn', '<bean:message bundle="fee" key="startrsn"/>', 'c', false, 255);      
        return checkval(window);
    }		
		 	
	function frmSubmit(){
		if(ev_check()){		
			window.returnValue = document.all.startrsn.value ;
			window.close();
		}
	}
	
 </script>
</head>
 
<body>

<form method="post" id="formList">
	<div class="table_div">
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="fee" key="startup"/></td>
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
            	<td class="form_table_left" colspan="4"><bean:message bundle="fee" key="redStarExplain"/></td>
            </tr>
            <tr>
            	<td class="form_table_right"><bean:message bundle="fee" key="startrsn"/>:</td>
                <td class="form_table_left">
                	<textarea  name="startrsn" class="form_textarea_on_4"></textarea><bean:message bundle="fee" key="redStar"/>
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
