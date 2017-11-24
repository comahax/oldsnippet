<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
    
%>
<html>
<head>
    <title><bean:message bundle="chadtdictparam" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        
        function doKeep(){
        	var url='cms/chadtdictparam.do?CMD=SAVE';
        	formList.action=url;
        	formList.submit();
        }
        
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/chadtdictparam.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
   
    <c:set var="form" scope="request" value="${requestScope['/cms/chadtdictparam/ChAdtDictparamForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			专员操作二次确认参数管理
   			</td>
    	</tr>
    </table>
    </div>
    <div class="table_div">	
   		 <table width="100%" class="error_text">
    		<html:errors/><s:Msg />
    	</table>
    </div>
	<div class="table_div">
        <table class="form_table">
            <tr>
    			<td width="10%" height="20" align="right" class="form_table_right" >
                	 <html:checkbox property="checked" value="form.checked" />
                	<!--<input type="checkbox" name="checked">  -->
            	</td>
            	<td width="90%" class="form_table_left">
               	启用二次确认提醒功能
            	</td>
            </tr>
            <tr>
    			<td width="10%" height="20" align="right" class="form_table_right" >
                	&nbsp;
            	</td>
            	<td width="90%" class="form_table_left">
               	 备注:如果勾选启用二次确认功能,专员管理界面"新增","修改","删除","导入"操作中如果涉及修改了专员的状态或者专员的渠道信息,将触发二次确认提醒.
            	</td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="button_4" onmouseover="buttonover(this);" onclick="doKeep()" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="确认" />
                        </s:PurChk>
                </td>
			</tr>
		</table>
	</div>

    

  
</html:form>
</div>
</body>
</html>
