<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%
    String ID_1 = "CH_PW_REWARD_MON";
%>

<html>
<head>
    <title><bean:message bundle="taskstate" key="titleList"/></title>
    <script language="JavaScript">
        
        
        function ev_check() {
            if( formList.year.value == "" && formList.month.value != "") {
	     		alert("<bean:message bundle="fee" key="selectCyc"/>");	     			
	     		return false;
			}else if( formList.year.value != "" && formList.month.value == "" ) {
	     		alert("<bean:message bundle="fee" key="selectCyc"/>");	     			
	     		return false;
			}else {
	     		formList._se_rewardmonth.value = formList.year.value + formList.month.value;
			}                       
            addfield('_se_rewardmonth', '<bean:message bundle="taskstate" key="billcyc" />', 'l', false, 8);
		    addfield('_se_cityid', '<bean:message bundle="bltouchrule" key="region"/>', 'c', false, 200);	         
            return checkval(window);   
        }
        
        function doShow(){
			if(ev_check()){ 
			resetPage();
			//alert(formList._se_rewardmonth.value);
        	formList.action=contextPath+'/cms/reward/taskstate.do?CMD=SET';
        	formList.submit();	
       	 	}
        }

    </script>
</head>

<body onload="loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/taskstate.do?CMD=SET" styleId="formList" method="post" onsubmit="return ev_check();">

	<html:hidden property="_se_rewardmonth" />
    <html:hidden property="_orderby" />
	<html:hidden property="_desc" />
	<html:hidden property="_pageno" />
	<html:hidden property="_pagesize" />
	<input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
	
	<div class="table_div">	
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="taskstate" key="titleList"/></td>			 
            	
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
                <td width="150" class="form_table_right"><bean:message bundle="taskstate" key="region"/>: </td>
                <td class="form_table_left" >
               			 <s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
                         		<html:select property="_se_cityid" styleClass="form_input_2x">
										<s:Options definition="#CITYCOMPANY" />
								</html:select>
                         </s:RewardPurChk>	
                </td>
            </tr>
            <tr>    
                <td class="form_table_right"><bean:message bundle="taskstate" key="rewardmonth2" />:</td>
				<td class="form_table_left">
					<html:select property="year" styleClass="form_selects_y">
		                <s:DateOptions type="#YY" desc="true" stepNowYear="1"/> 
		                </html:select><bean:message bundle="taskstate" key="year"/>
		            <html:select property="month" styleClass="form_selects_m">
		                <s:DateOptions type="#MM" fillZero="taskstate"/> 
		            </html:select><bean:message bundle="taskstate" key="month"/> 
				</td> 
				
            </tr>
        </table>
    </div>
	
	<div class="table_div">
		<table class="table_button_list">
			<tr>
			   <td> 
                 	<input type="button" class="query" onmouseover="buttonover(this);" 
                 			onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_search"/>" 
                            onclick="doQuery();"/>
               </td> 	
			</tr>
		</table>
	</div>

</html:form>
<iframe  frameborder="0" class="loadframe" style="height:800px;" id="loadframe1" scrolling="no"
	src="<%= contextPath%>/cms/reward/taskstate.do?CMD=SHOW&_se_rewardmonth=<c:out value="${requestScope._se_rewardmonth}"/>&_se_cityid=<c:out value="${requestScope._se_cityid}"/>"/>
</div>
</body>
</html>









