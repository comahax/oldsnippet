<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
  <head>
    
    <title><s:text name="selectPageList" /></title>
    <base target="_self">
    
    <script type="text/javascript">
		function ev_check() {
	       	addfield('startindex', '<s:text name="startindex"></s:text>', 'i', false, 20);
	        addfield('endindex', '<s:text name="endindex"></s:text>', 'i', false, 20);
	        return checkval(window);
	    }		
				
		function frmSubmit(){
			if(ev_check()){
				var startindex = document.all.startindex.value;
				var endindex = document.all.endindex.value;
				
				if(endindex < 1 || startindex < 1){
					alert('<s:text name="startindex"/><s:text name="and"/><s:text name="endindex"/><s:text name="plusNum"/>');
				}else if(endindex - startindex < 0){
					alert('<s:text name="startindex"/><s:text name="compare_gt"/><s:text name="endindex"/>');
				}else if(endindex - startindex >= 5){
					alert('<s:text name="pagenosize"/><s:text name="compare_gt"/>5');
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
<div class="table_container">
<s:form method="post" id="formList" name="formList">
	<table class="table_style">
            <tr class="table_style_head"><td><s:text name="selectPageList"/></td></tr>
    </table>
    <aa:zone name="errorZone">
		<div class="error_text"><font color="red"><s:actionerror/><s:actionmessage/></font></div>
	</aa:zone>

	<div class="table_div">
        <table class="table_normal">
        	<tr style="padding-top:10px;padding-left:20px">
            	<td colspan="4"><s:text name="redStarExplain"/><br><s:text name="selectpageinfo"/></td>
            </tr>
            <tr style="padding-top:15px">
            	<td align="right"><s:text name="startindex"></s:text>:</td>
                <td align="left">
                	<input type="text" maxlength="20" value="1" name="startindex"><s:text name="redStar"/>
                </td>
                <td align="right"><s:text name="endindex"></s:text>:</td>
                <td align="left">
                	<input type="text" maxlength="20" value="5" name="endindex"><s:text name="redStar"/>
                </td>
            </tr>
			<tr style="padding-top:15px">
			
				<td colspan="4" align="right">
					<s:i18n name="public">
						<input type="button" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
							value="<s:text name="button_return"/>"
							onclick="window.close();" />
						<input type="button" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
							value="<s:text name="button_export"/>"
						onclick="frmSubmit();" />
					</s:i18n>    
			    </td>	
			</tr>
		</table>
	</div>    	          
</s:form>       
</div>
</body>
</html>
