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
    <title><bean:message bundle="allsalesday" key="statisticTitle"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_dnm_oprtime', '<bean:message bundle="allsalesday" key="oprtime"/>', 't', 'false', '7');
            addfield('_dnl_oprtime', '<bean:message bundle="allsalesday" key="oprtime"/>', 't', 'false', '7');
            return (checkval(window) && compareDate());
        }
        
        function compareDate(){
	        var startTime2 = document.getElementById('_dnl_oprtime').value;
	        var endTime2 = document.getElementById('_dnm_oprtime').value;         		
       		if(startTime2==''){
       			var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[统计汇总时间>=]</span> 不能为空';
       			errorMessageShow(alertstr);
		        return false;
       		}
       		if(endTime2==''){
       			var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[统计汇总时间<=]</span> 不能为空';
       			errorMessageShow(alertstr);
		        return false;
       		}       
	        if(startTime2 != '' && endTime2 != '' && startTime2>endTime2){
		        var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[统计汇总时间>=]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[统计汇总时间<=]</span>';
				errorMessageShow(alertstr);
		        return false;
	       	}	        
	   		return true;	
    	}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/bbc/allsalesday.do?CMD=STATISTIC" styleId="formList" method="post" onsubmit="return ev_check();">
    <c:set var="form" scope="request" value="${requestScope['/cms/bbc/allsalesday/AllsalesdayForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="allsalesday" key="statisticTitle"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="allsalesday" key="statistic_time"/>&gt;=:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_oprtime" onclick="this.value=selectDate();"></html:text>
                	<font color="red">*</font>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="allsalesday" key="statistic_time"/>&lt;=:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_oprtime" onclick="this.value=selectDate();"></html:text>
                	<font color="red">*</font>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <input type="submit" class="query" onmouseover="buttonover(this);" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="allsalesday" key="button_statistic"/>" />
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">        
        	<tr class="table_style_head">
                <td>
                    	<bean:message bundle="allsalesday" key="statistic_item"/>
                </td>
                <td>
                		<bean:message bundle="allsalesday" key="statistic_quantity"/>
                </td>
            </tr>        
            <c:forEach var="item" items="${requestScope.STATISTIC}">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
                     <td><c:out value="${item.key}"/></td>
                     <td><c:out value="${item.value}"/></td>
                 </tr>
             </c:forEach>
        </table>
     </div>
   </div>

   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
</html:form>
</div>
</body>
</html>
