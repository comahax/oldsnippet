<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/listhead.inc" %>

<html>
<head>
    <title><bean:message bundle="rhtouchrule" key="title"/></title>
    <script language="JavaScript">
        
        
        function ev_check() {
            if( formList.year.value == "" && formList.month.value != "") {
	     		alert("<bean:message bundle="fee" key="selectCyc"/>");	     			
	     		return false;
			}else if( formList.year.value != "" && formList.month.value == "" ) {
	     		alert("<bean:message bundle="fee" key="selectCyc"/>");	     			
	     		return false;
			}else {
	     		formList._ne_validbillcyc.value = formList.year.value + formList.month.value;
			}                       
            addfield('_ne_validbillcyc', '<bean:message bundle="bltouchrule" key="billcyc" />', 'l', false, 8);
		    addfield('regiongroup', '<bean:message bundle="bltouchrule" key="region"/>', 'c', false, 200);	         
            return checkval(window);   
        }

        function historyback() {    
        	if(null != document.formList.startupbt){                
          		document.formList.startupbt.disabled = true;
          	}
    		doQuery();	
        }
        
        function doBatchstartup() {
        	var ischeck = false;
        	if(loadframe1.document.all._selectitem != null){
				if(loadframe1.document.all._selectitem.length != null ){				
					for( j = 0; j < loadframe1.document.all._selectitem.length; j++ ) {
						if( loadframe1.document.all._selectitem[j].checked == true ) {		
							ischeck = true;
							break;
						}														
					}											
				}else{		
					ischeck = loadframe1.document.all._selectitem.checked;					
				}
			}
			if(!ischeck){
				alert('请选择确认的记录！');
				return;
			}
			var step = loadframe1.formList.step.value;
			var stepname = loadframe1.formList.stepname.value;
			
			if(confirm('是否批量启动' + stepname )){
				var arg = new Array();
		    	var startupUrl = contextPath + "/commons/startup.jsp";
				var hWnd = window.showModalDialog(startupUrl, arg, "dialogWidth:600px; dialogHeight:230px; status:no;resizable:yes;");
				if (hWnd != null && hWnd != "") {
					key = 'ERRORSTEP';
					if(step == 50)  key = 'FIXC';if(step == 51)  key = 'PRMC';
					if(step == 75)  key = 'NUL';if(step == 80)  key = 'RED';
					if(step == 102)  key = 'USR';if(step == 103)  key = 'ACC';
					if(step == 104)  key = 'CFM';if(step == 105)  key = 'WOF';
						
					loadframe1.formList.action =  contextPath + '/fee/billing/rhtouchrule.do?CMD=BATCHSTARTUP' + '&_KEY=' + key + '&_STARTRSN=' + hWnd;   	    
					loadframe1.formList.submit();
					loadframe1.formList.action = contextPath + '/fee/billing/rhtouchrule.do?CMD=ACCBILLINGDET';	    			
						    			
		    	}  
			} 			
		}
        
        function showStartLog(cityid,startstep) {                    
          	var validbillcyc = document.formList._ne_validbillcyc.value	;
 			var batchnum = "01"	;
    		if (startstep != null && "" != startstep && validbillcyc != null && "" != validbillcyc
    				&& cityid != null && "" != cityid && batchnum != null && "" != batchnum){    				
    			var url =  contextPath + '/fee/billing/billstartlog.do?CMD=LIST2' + '&_VALIDBILLCYC=' + validbillcyc + '&_BATCHNUM=' + batchnum + '&_STARTSTEP=' + startstep + '&_CITYID=' + cityid;    	    			
    			var arg = new Array();
	    		var hWnd = window.showModalDialog(url, arg, "dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");  			    			
    		}  	
        }
        
        
        function showLog(cityid,billingphase,ruleid,batchnum,validbillcyc) {
			var batchnum = "01";
			var validbillcyc = document.formList._ne_validbillcyc.value			
 			
    		if (cityid != null && "" != cityid 
    				&& batchnum != null && "" != batchnum && validbillcyc != null && "" != validbillcyc){
    			var url =  contextPath + '/fee/accounting.do?CMD=SHOWLOG' + '&_BATCHNUM=' + batchnum + '&_CITYID=' + cityid + '&_VALIDBILLCYC=' + validbillcyc + '&_BILLINGPHASE=' + billingphase + '&_RULEID=' + ruleid;    
				var arg = new Array();
    			var hWnd = window.showModalDialog(url, arg, "dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
    		}  								
		}
		
		function doForward(){
			formList.action = contextPath + '/fee/billing/billstatus.do?CMD=SET'; 
    		formList.submit();
		}
    </script>
</head>

<body onload="loadforiframe();">
<div class="table_container">
<html:form action="/fee/billing/rhtouchrule.do?CMD=SET" styleId="formList" method="post" onsubmit="return ev_check();">

	<html:hidden property="_ne_validbillcyc" />
    <html:hidden property="_orderby" />
	<html:hidden property="_desc" />
	<html:hidden property="_pageno" />
	<html:hidden property="_pagesize" />
	<input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
	
	<div class="table_div">	
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="rhtouchrule" key="title"/></td>			 
            	
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
                <td width="150" class="form_table_right"><bean:message bundle="bltouchrule" key="region"/>: </td>
                <td class="form_table_left" >
                	<s:MoreCheck definition="#CITYCOMPANY" property="regiongroup" styleClass="form_input_2x"/>
		             
                </td>
            </tr>
            <tr>    
                <td class="form_table_right"><bean:message bundle="woffcust" key="validbillcyc" />:</td>
				<td class="form_table_left">
					<html:select property="year" styleClass="form_selects_y">
		                <html:option value=""> </html:option> 
		                <s:DateOptions type="#YY" desc="true" stepNowYear="1"/> 
		                </html:select><bean:message bundle="fee" key="year"/>
		            <html:select property="month" styleClass="form_selects_m">
		                <html:option value=""> </html:option> 
		                <s:DateOptions type="#MM" fillZero="true"/> 
		            </html:select><bean:message bundle="fee" key="month"/> 
				</td> 
				
            </tr>
        </table>
    </div>
	
	<div class="table_div">
		<table class="table_button_list">
			<tr>
			   <td> 
			   	<s:PurChk2 controlid="ACCOUNTING_STARTUP">		    
                	<input type="button" class="query" onmouseover="buttonover(this);" id="startupbt" disabled="disabled"
                 			onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="启动" onclick="doBatchstartup();"/>
             	</s:PurChk2>  
             	<input type="button" class="button_6" onmouseover="buttonover(this);" 
                 			onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="转到过程监控" onclick="doForward();"/>      
                 	<input type="button" class="query" onmouseover="buttonover(this);" 
                 			onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_search"/>" onclick="doQuery();"/>
               </td> 	
			</tr>
		</table>
	</div>

</html:form>
<iframe  frameborder="0" class="loadframe" style="height:800px;" id="loadframe1" scrolling="no"
	src="<%= contextPath%>/fee/billing/rhtouchrule.do?CMD=SHOW&_ne_validbillcyc=<c:out value="${requestScope._ne_validbillcyc}"/>&regiongroup=<c:out value="${requestScope.regiongroup}"/>"/>



</div>
</body>
</html>









