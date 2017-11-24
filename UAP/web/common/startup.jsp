<%@ page language="java" contentType="text/html;charset=utf-8"%>

<%@ include file="/inc/listhead.inc" %>

<html>
  <head>
    
    <title>启动</title>
    <base target="_self">
 <script language=javascript>
	function ev_check() {
       	addfield('startrsn', '启动原因', 'c', false, 255);      
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

<form method="post" key="formList" cssStyle="formList"  theme="simple" method="post">
	<div class="table_div">
		<table class="top_table">
			<tr> 
				<td>启动</td>
			</tr>
		</table>
    </div>
    <div class="table_div">
		<table class="error_text">
			<s:actionerror />
			<s:actionmessage />
		</table>
	</div>
	<div class="table_div">
        <table class="form_table">
        	<tr>
            	<td class="form_table_left" colspan="4">带<font color="red">*</font>为必填项</td>
            </tr>
            <tr>
            	<td class="form_table_right">启动原因:</td>
                <td class="form_table_left">
                	<textarea  name="startrsn" class="form_textarea_on_4"></textarea><font color="red">*</font>
                </td>
                
            </tr>
		</table>
    </div>
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
			        <input type="button" name="btnDelete" class="delete" 
			               value="<s:text name="button_close"/>" onClick="window.close();">
			        <input type="button" name="btnDelete" class="delete" 
                           value="<s:text name="button_submit"/>" onClick="frmSubmit();">          
			    </td>	
			</tr>
		</table>
	</div>     	          
 </form>       

</body>
</html>
