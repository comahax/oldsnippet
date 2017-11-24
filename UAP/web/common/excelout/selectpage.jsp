<%@ page language="java" contentType="text/html;charset=UTF-8"%>
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
				}else if(endindex - startindex >= 100){
					alert('<s:text name="pagenosize"/><s:text name="compare_gt"/>100');
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

<s:form method="post" id="formList" name="formList">
	<div class="title_name">
		<table class="title_name">	
			<tr> 
				<td><s:text name="selectPageList"/></td>
			</tr>
			<tr>
				<td class="error_text">
					<s:actionerror />
					<s:actionmessage />
				</td>
			</tr>
		</table>
    </div>

	<div class="search2">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        	<tr style="padding-top:10px;padding-left:20px">
            	<td colspan="4"><s:text name="redStarExplain"/><br><s:text name="selectpageinfo"/></td>
            </tr>
            <tr style="padding-top:15px">
            	<th><s:text name="startindex"></s:text>:</th>
                <td align="left">
                	<input type="text" maxlength="20" value="1" name="startindex"><s:text name="redStar"/>
                </td>
                <th><s:text name="endindex"></s:text>:</th>
                <td align="left">
                	<input type="text" maxlength="20" value="100" name="endindex"><s:text name="redStar"/>
                </td>
            </tr>
			<tr style="padding-top:15px">
			
				<td colspan="4" align="right">
					<s:i18n name="public">
						<input type="button" class="bt48_gray"
							value="<s:text name="button_return"/>"
							onmouseover="this.className='bt48'"
							onmouseout="this.className='bt48_gray'"
							onclick="window.close();" />
						<input type="button" class="bt48_gray"
							value="<s:text name="button_export"/>"
							onmouseover="this.className='bt48'"
							nmouseout="this.className='bt48_gray'"
						onclick="frmSubmit();" />
					</s:i18n>    
			    </td>	
			</tr>
		</table>
	</div>    	          
</s:form>       

</body>
</html>
