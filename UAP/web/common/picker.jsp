<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="j" uri="/jop-tags" %>
<%@ include file="/inc/listhead.inc" %>
<html>
<base target="_self">
<head>
    <title>编码</title>
    <script language="JavaScript" type="text/JavaScript">  
    	function selectCode(code,name) {
    	    var a = new Array(2);
    	    a[0] =code; 
    	    a[1] =name;
    	    
    		window.returnValue = a; 
			window.close();
    	}
    </script>
<style>
.picker_LongTable {
	overflow-x: scroll;
	overflow-y: scroll;
	width:100%;	
	text-align:left;
	height: 400px;
	width:103%;	
	background:#FFFFFF url(../../images/index_main_topleftbj.GIF) repeat-x;
}
</style>
</head>

<body>
<s:form key="formList" cssStyle="formList" theme="simple">
	<%//下面的控件给Action提供数据，用来分页%>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._queryexpress"/>
    
    <s:hidden name="definition" key="definition"/>
    <!-- textfield name="condition" key="condition"/ -->
    <s:hidden name="dbFlag" key="dbFlag"/>
    
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
    
    <aa:zone name="errorZone">
	   <div class="error_text">
		   	<s:actionerror/><s:actionmessage/>
	   </div >
	 </aa:zone>
	
	  <div class="table_div">
	  	<s:i18n name="public">
	    <table class="top_table">
	    	<tr>
	    		<td>
	    			选择器
	   			</td>
	    	</tr>
	    </table>
	    </s:i18n>
    </div>
    	
	
		<div class="table_div">
		<table class="table_button_list">
			<tr> 
				
                    <td align=right>
                    	 <s:i18n name="public">
                            <input type="submit" id="btnQuery" class="query" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<s:text name="button_search"/>" onClick="doQuery();">
                       </s:i18n>
                        
                    </td>                 
			</tr>
		</table>
	</div>

<aa:zone name="listZone">	
	<div class="table_div">
        <table class="form_table">
            <tr>
                <td height="20" align="right" class="form_table_right">
                	编码:
                </td>
                <td class="form_table_left">
                  <s:textfield name="code" /> 
                </td>               
                <td   height="20" align="right" class="form_table_right">
                	名称:
                </td>
                <td class="form_table_left">
                  <s:textfield name="name"  />                                   
                </td>
            </tr>
        </table>
   
     <div class="picker_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">             
                <td>
                   编码                  
                </td>
                <td>
                   名称
                </td>               
            </tr>
             <tr class="table_style_content"  align="center">             
                <td>
                   <a href="javascript:selectCode( '' ,'');">
	                   空值
                   </a>                  
                </td>
                <td>
                &nbsp;
                </td>               
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center">					
                      <td>
                         <a href="javascript:selectCode('<s:property value="code"/>','<s:property value="name"/>');">
                         	<s:property value="code"/>
                         </a>                       
                     </td>
                     <td>                       
                        <s:property value="name"/>
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



<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		//判断逻辑,根据按钮，和url来判断要刷新哪个zone
		return "errorZone,listZone";  //返回zon id。
	}
</script>   
<script language="javascript">
	/*设置表单提交通过ajax进行*/
	ajaxAnywhere.substituteFormSubmitFunction();  

	/*控制那些按钮需要使用ajax效果,传按钮ID */
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery");
</script>

</body>
</html>
