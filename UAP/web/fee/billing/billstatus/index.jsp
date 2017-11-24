<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="j" uri="/jop-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>			
		<title><s:text name="title"></s:text></title>
		
		<script language="JavaScript">
        function ev_check() {
       /**    if( formList.year.value == "" && formList.month.value != "") {
	     		alert("<s:text name='billcyc'></s:text>");	     			
	     		return false;
			}else if( formList.year.value != "" && formList.month.value == "" ) {
	     		alert("<s:text name='billcyc'></s:text>");	     			
	     		return false;
			}else {
	     		formList._ne_validbillcyc.value = formList.year.value + formList.month.value;
			}   
		**/  
		
			if( document.getElementById("form._ne_validbillcyc").value == "") {
	     		alert("有效周期不能为空！");	     			
	     		return false;
			}else if(document.getElementById("form.regiongroup").value ==""){
				alert("市公司不能为空！");
				return false;
			}else{			       
				// document.getElementById("form._ne_validbillcyc").value = formList.validbillcyc.value;
			}		
            addfield('validbillcyc', '<s:text name="billcyc"></s:text>', 'l', false, 8);
		    addfield('form.regiongroup', '<s:text name="region"></s:text>', 'c', false, 200);	         
            return checkval(window);   
        }
        
         function showStartLog(cityid,startstep) {   
                        
          	var validbillcyc = document.formList._ne_validbillcyc.value	;
 			var batchnum = "01"	;
    		if (startstep != null && "" != startstep && validbillcyc != null && "" != validbillcyc
    				&& cityid != null && "" != cityid && batchnum != null && "" != batchnum){    				
    			var url =  '<%= contextPath%>/fee/billing/billstartlog.do?CMD=LIST2' + '&_VALIDBILLCYC=' + validbillcyc + '&_BATCHNUM=' + batchnum + '&_STARTSTEP=' + startstep + '&_CITYID=' + cityid;    	    			
    			var arg = new Array();
	    		var hWnd = window.showModalDialog(url, arg, "dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");  			    			
    		}  	
        }
        
        
        function showLog(cityid,billingphase,ruleid,batchnum,validbillcyc) {         
			var batchnum = "01";
			var validbillcyc = document.getElementById("form._ne_validbillcyc").value;
    		if (cityid != null && "" != cityid 
    				&& batchnum != null && "" != batchnum && validbillcyc != null && "" != validbillcyc){
    			var url = '<%= contextPath%>/fee/billing/accounting_showlog.do?_BATCHNUM=' + batchnum + '&_CITYID=' + cityid + '&_VALIDBILLCYC=' + validbillcyc + '&_BILLINGPHASE=' + billingphase + '&_RULEID=' + ruleid;    
				
				document.all.loadframe2.style.display="";    		
    			document.all.loadframe2.src = url;				
				// var arg = new Array();
    			// var hWnd = window.showModalDialog(url, arg, "dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
    		}  								
		}        

    </script>
	</head>

	<body onload="loadforiframe();">
			<s:form action="/fee/billing/billstatus_set.do" key="formList" cssStyle="formList" theme="simple"  method="post" onsubmit="return ev_check();">	
				<s:hidden name="param._orderby" />
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />				
				<input type="hidden" name="_rowcount" value="<s:property value='dp.rowCount'/>">
				
				<s:hidden name="CMD" />

				<div class="widgetL">
				<div class="wCenter">
					<div class="content">
						<div class="title_name">
							<s:text name="title" />
						</div>
						<aa:zone name="errorZone">
							<div class="error_text">
								<s:actionerror />
								<s:actionmessage />
							</div>
						</aa:zone>
						<div class="search2">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<th align="left">
								<s:text name="region" />
								:
								</th>
								<td align="left">								
									<j:selector id="form.regiongroup" name="form.regiongroup" definition="#CITYCOMPANY" cssClass="input" mode="morecheck" />
								</td>
								<th align="left">
									<s:text name="validbillcyc" />
									:
								</th>
								<td align="left">
									<s:textfield cssClass="Wdate"
										name="form._ne_validbillcyc" id="form._ne_validbillcyc" readonly="true"
										onfocus="WdatePicker({skin:'default',dateFmt:'yyyyMM00'})"></s:textfield>
								</td>
							
								<td align="right">
								<input type="button" class="bt48_gray"
									onmouseover="this.className='bt48'" onmouseout="this.className='bt48_gray'"
									value="<s:text name="button_search"/>" onclick="doQuery();" />
								</td>
					    	</tr>
					</table>
				</div>

			
			<iframe frameborder="0" class="loadframe" onload="document.all['loadframe1'].style.height=loadframe1.document.body.scrollHeight"
				id="loadframe1" name="loadframe1" scrolling="no"
				src="<%=contextPath%>/fee/billing/billstatus_show.do?form._ne_validbillcyc=<s:property value='#request._ne_validbillcyc'/>&form.regiongroup=<s:property value='#request.regiongroup'/>" />
            <iframe frameborder="0" class="loadframe" scrolling="no" id="loadframe2" name="loadframe2" 
            onload="document.all['loadframe2'].style.height=loadframe2.document.body.scrollHeight;window.document.body.scrollTop = 500;"/>
           <!--   <iframe frameborder="0" class="loadframe" style="height:100px;display:none" scrolling="auto" id="loadframe3" name="loadframe3" onload="document.all['loadframe3'].style.height=loadframe3.document.body.scrollHeight"/>	-->	
		</div>
	</div>
</div>
</s:form>
</body>
</html>









