<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/listhead.inc" %>
<% 
    String ID_1 = "4D1A2BBT1";
    String ID_2 = "4D1A2BBT2";
    String ID_3 = "4D1A2BBT3";

%>
<html>
<head>
    <title><s:text name="titleList1"/></title>
    <base target="_self">
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {                    
            return checkval(window); 
	
		}
		function showAccBilling(step,batchnum,validbillcyc,regiongroup) {

    		if (regiongroup != null && "" != regiongroup && validbillcyc != null && "" != validbillcyc
    				&& batchnum != null && "" != batchnum ){
    			    window.parent.document.all.loadframe2.style.display="";
    				window.parent.document.all.loadframe2.src = '<%= contextPath%>/fee/billing/rhtouchrule_simpleinfo.do?_BATCHNUM=' + batchnum + '&_REGIONGROUP=' + regiongroup + '&_VALIDBILLCYC=' + validbillcyc + '&_STEP=' + step ;  
    		}  else{
    			alert("请先查询!");
    		}								
		}
    </script>
    <style type="text/css">
	    .point {
			background:url(images/accounting/point7.gif) no-repeat 0px 0px;text-align:center;
		}
	</style>
</head>

<body onload="loadforiframe1();">

<s:form action="/fee/billing/rhtouchrule_accbillingdet.do" key="formList" cssStyle="formList"  theme="simple" method="post" onsubmit="return ev_check();">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>	
	<s:hidden name="form._ne_validbillcyc"/>	
	<s:hidden name="form.regiongroup"/>
	<s:hidden name="form.step"/> 
	<input type="hidden" name="stepname" value="<j:code2Name definition="BILLSTEP" code="#request.BILLINGPHASE" />"> 
	
	
    <div class="table_div">
		<table class="error_text">
			<s:actionerror />
			<s:actionmessage />
		</table>
	</div>     

	<div class="table_div" style="text-align:left;">
		<span class="point" style="width:700px;height:20px;padding:9px 0 0 550px;margin-top:0px;">			
		     点击此处[ <s:a href="javascript:parent.history.back();">返回</s:a>]总控流程</span>	
	</div> 
	
    <div class="table_div" style="text-align: left;">
        <table class="table2">	
        
        <s:iterator var="item" value="#request.LIST">                     	
        
            		       	
            <tr>
            	<td width="10px"></td>
            	<td>
            														
			        <s:if test="#request.BILLINGPHASE == '102' || #request.BILLINGPHASE == '103' || #request.BILLINGPHASE == '104' || #request.BILLINGPHASE == 105 || #request.BILLINGPHASE == 75 || #request.BILLINGPHASE  == 80 || #request.BILLINGPHASE == 51 || #request.BILLINGPHASE == 50 ">
			            <input type="checkbox" name="_selectitem" value="<s:property value='#item.cityid' />" onclick="" class="table_checkbox">
				    </s:if>
					
			    </td>
            	<td class="location" width="25px"><s:property value='#item.cityname'/></td>
            	
            								
					<s:if test="#request.BILLINGPHASE == '75' ">
		            	<td  onclick="parent.showStartLog('<s:property value='#item.cityid'/>','75');" style="cursor:hand;" class="jiantou<s:property value="#item.isrestart[8] + 0"/>"></td>						
						<td style="cursor:hand;" onclick="parent.showLog('<s:property value='#item.cityid'/>','75','<s:property value='#item.btrvo.ruleid'/>','<s:property value='#item.btrvo.batchnum'/>','<s:property value='#item.btrvo.validbillcyc'/>');" class="mybox_<s:property value="#item.btrvo.nullrecstate + 0"/>">无主回捞</td>
					</s:if>	 
				
					
            	
            		<s:elseif test="#request.BILLINGPHASE == '80' ">								
		            	<td  onclick="parent.showStartLog('<s:property value='#item.cityid'/>','80');" style="cursor:hand;" class="jiantou<s:property value="#item.isrestart[7] + 0"/>"></td>						
						<td style="cursor:hand;" onclick="parent.showLog('<s:property value='#item.cityid'/>','80','<s:property value='#item.btrvo.ruleid'/>','<s:property value='#item.btrvo.batchnum'/>','<s:property value='#item.btrvo.validbillcyc'/>');" class="mybox_<s:property value="#item.btrvo.reducestate + 0"/>">账单优惠</td>
					</s:elseif>	 
				
					<s:elseif test="#request.BILLINGPHASE == '1010' ">									
		            	<td  onclick="parent.showStartLog('<s:property value='#item.cityid'/>','1010');" style="cursor:hand;" class="jiantou<s:property value="#item.isrestart[9] + 0"/>"></td>						
						<td style="cursor:hand;" onclick="parent.showLog('<s:property value='#item.cityid'/>','1010','<s:property value='#item.btrvo.ruleid'/>','<s:property value='#item.btrvo.batchnum'/>','<s:property value='#item.btrvo.validbillcyc'/>');" class="mybox_<s:property value="#item.btrvo.dgfixfeestate + 0"/>">预付费固定费</td>
						<!--
						<s:iterator var="item1" value="#item.fixlist">  				
							<td class="jiantou0"></td>														
							<td class="mybox_<s:property value='#item1.status'/>"><j:code2Name definition="#FIXSUBPHASE" code="#item1.subphase" /></td>																											
						</s:iterator> 
						-->
					</s:elseif>
					<s:elseif test="#request.BILLINGPHASE == '50'">									
		            	<td  onclick="parent.showStartLog('<s:property value='#item.cityid'/>','50');" style="cursor:hand;" class="jiantou<s:property value="#item.isrestart[1] + 0"/>"></td>						
						<td  style="cursor:hand;" onclick="showAccBilling('50','<s:property value='#item.btrvo.batchnum'/>','<s:property value='#item.btrvo.validbillcyc'/>','<s:property value='#item.city'/>');" class="mybox_<s:property value="#item.btrvo.fixcfmstate + 0"/>">固定费核查确认</td>
				 
					</s:elseif>
					<s:elseif test="#request.BILLINGPHASE == '51'">									
		            	<td  onclick="parent.showStartLog('<s:property value='#item.cityid'/>','51');" style="cursor:hand;" class="jiantou<s:property value="#item.isrestart[0] + 0"/>"></td>						
						<td  style="cursor:hand;" onclick="parent.showLog('<s:property value='#item.cityid'/>','100','<s:property value='#item.btrvo.ruleid'/>','999','<s:property value='#item.btrvo.validbillcyc'/>');" class="mybox_<s:property value="#item.btrvo.prmcfmstate + 0"/>">预处理确认</td>
				 
					</s:elseif>
            	
					<s:elseif test="#request.BILLINGPHASE == '101'">																																	
		            	<td  onclick="parent.showStartLog('<s:property value='#item.cityid'/>','101');" style="cursor:hand;" class="jiantou<s:property value="#item.isrestart[2] + 0"/>"></td>						
						<td style="cursor:hand;" onclick="parent.showLog('<s:property value='#item.cityid'/>','101','<s:property value='#item.btrvo.ruleid'/>','<s:property value='#item.btrvo.batchnum'/>','<s:property value='#item.btrvo.validbillcyc'/>');" class="mybox_<s:property value="#item.btrvo.fixstate + 0"/>">全球通固定费</td>
						<!--<s:iterator var="item1" value="#item.fixlist">  				
							<td class="jiantou0"></td>														
							<td class="mybox_<s:property value='#item1.status'/>"><j:code2Name definition="#FIXSUBPHASE" code="#item1.subphase" /></td>																											
						</s:iterator> 									
					--></s:elseif>
					<s:elseif test="#request.BILLINGPHASE == '102'">									
		            	<td  onclick="parent.showStartLog('<s:property value='#item.cityid'/>','102');" style="cursor:hand;" class="jiantou<s:property value="#item.isrestart[3] + 0"/>"></td>						
						<td style="cursor:hand;" onclick="showAccBilling('102','<s:property value='#item.btrvo.batchnum'/>','<s:property value='#item.btrvo.validbillcyc'/>','<s:property value='#item.city'/>');" class="mybox_<s:property value="#item.btrvo.usrbillstate + 0"/>">用户出账</td>
						<!--
						<s:iterator var="item1" value="#item.usrlist">  				
							<td class="jiantou0"></td>															
							<td class="mybox_<s:property value="#item1.status + 0"/>"><j:code2Name definition="USRSUBPHASE" code="#item1.subphase" /></td>																		
												
						</s:iterator>    
						-->  
					</s:elseif>											
					<s:elseif test="#request.BILLINGPHASE == '103'">														
            			<td  onclick="parent.showStartLog('<s:property value='#item.cityid'/>','103');" style="cursor:hand;" class="jiantou<s:property value="#item.isrestart[4] + 0"/>"></td>						
						<td style="cursor:hand;" onclick="showAccBilling('103','<s:property value='#item.btrvo.batchnum'/>','<s:property value='#item.btrvo.validbillcyc'/>','<s:property value='#item.city'/>');" class="mybox_<s:property value="#item.btrvo.accbillstate + 0"/>">账户出账</td>
						<!-- 
						<s:iterator var="item1" value="#item.acclist">  				
							<td class="jiantou0"></td>														
							<td class="mybox_<s:property value="#item1.status + 0"/>"><j:code2Name definition="ACCSUBPHASE" code="#item1.subphase" /></td>																											
						</s:iterator> 
						-->
					</s:elseif>								
					<s:elseif test="#request.BILLINGPHASE == '104'">									
		            	<td  onclick="parent.showStartLog('<s:property value='#item.cityid'/>','104');" style="cursor:hand;" class="jiantou<s:property value="#item.isrestart[5] + 0"/>"></td>						
						<td style="cursor:hand;" onclick="showAccBilling('104','<s:property value='#item.btrvo.batchnum'/>','<s:property value='#item.btrvo.validbillcyc'/>','<s:property value='#item.city'/>');" class="mybox_<s:property value="#item.btrvo.cfmbillstate + 0"/>">出账核查确认</td>
				        <!--  
				        <s:iterator var="item1" value="#item.cfmlist">  				
							<td class="jiantou0"></td>														
							<td class="mybox_<s:property value="#item1.status + 0"/>"><j:code2Name definition="CFMSUBPHASE" code="#item1.subphase" /></td>																											
						</s:iterator> 
						-->
					</s:elseif>
					<s:elseif test="#request.BILLINGPHASE == '105'">									
		            	<td  onclick="parent.showStartLog('<s:property value='#item.cityid'/>','105');" style="cursor:hand;" class="jiantou<s:property value="#item.isrestart[6] + 0"/>"></td>						
						<td style="cursor:hand;" onclick="showAccBilling('105','<s:property value='#item.btrvo.batchnum'/>','<s:property value='#item.btrvo.validbillcyc'/>','<s:property value='#item.city'/>');" class="mybox_<s:property value="#item.btrvo.woffstate + 0"/>">销账信控</td>
						 
					</s:elseif>	
					<s:elseif test="#request.BILLINGPHASE == '106'">									
		            	<td  onclick="parent.showStartLog('<s:property value='#item.cityid'/>','106');" style="cursor:hand;" class="jiantou<s:property value="#item.isrestart[6] + 0"/>"></td>						
						<td style="cursor:hand;" onclick="showAccBilling('106','<s:property value='#item.btrvo.batchnum'/>','<s:property value='#item.btrvo.validbillcyc'/>','<s:property value='#item.city'/>');" class="mybox_<s:property value="#item.btrvo.precfmstate + 0"/>">通信费核查确认</td>
						 
					</s:elseif>	
					<s:else>									
						<td style="cursor:hand;" onclick="parent.showLog('<s:property value='#item.cityid'/>','101','<s:property value='#item.btrvo.ruleid'/>','<s:property value='#item.btrvo.batchnum'/>','<s:property value='#item.btrvo.validbillcyc'/>');" class="mybox_<s:property value="#item.btrvo.fixstate + 0"/>">固定费</td>
						<td onclick="parent.showStartLog('<s:property value='#item.cityid'/>','102');" style="cursor:hand;" class="jiantou<s:property value="#item.isrestart[3] + 0"/>"></td>
						<td style="cursor:hand;" onclick="parent.showLog('<s:property value='#item.cityid'/>','102','<s:property value='#item.btrvo.ruleid'/>','<s:property value='#item.btrvo.batchnum'/>','<s:property value='#item.btrvo.validbillcyc'/>');" class="mybox_<s:property value="#item.btrvo.usrbillstate + 0"/>">用户出账</td>
						<td onclick="parent.showStartLog('<s:property value='#item.cityid'/>','103');" style="cursor:hand;" class="jiantou<s:property value="#item.isrestart[4] + 0"/>"></td>
						<td style="cursor:hand;" onclick="parent.showLog('<s:property value='#item.cityid'/>','103','<s:property value='#item.btrvo.ruleid'/>','<s:property value='#item.btrvo.batchnum'/>','<s:property value='#item.btrvo.validbillcyc'/>');" class="mybox_<s:property value="#item.btrvo.accbillstate + 0"/>">账户出账</td>
						<td onclick="parent.showStartLog('<s:property value='#item.cityid'/>','104');" style="cursor:hand;" class="jiantou<s:property value="#item.isrestart[5] + 0"/>"></td>
						<td style="cursor:hand;" onclick="parent.showLog('<s:property value='#item.cityid'/>','104','<s:property value='#item.btrvo.ruleid'/>','<s:property value='#item.btrvo.batchnum'/>','<s:property value='#item.btrvo.validbillcyc'/>');" class="mybox_<s:property value="#item.btrvo.cfmbillstate + 0"/>">出账核查确认</td>
						<td onclick="parent.showStartLog('<s:property value='#item.cityid'/>','105');" style="cursor:hand;" class="jiantou<s:property value="#item.isrestart[6] + 0"/>"></td>
						<td style="cursor:hand;" onclick="parent.showLog('<s:property value='#item.cityid'/>','105','<s:property value='#item.btrvo.ruleid'/>','<s:property value='#item.btrvo.batchnum'/>','<s:property value='#item.btrvo.validbillcyc'/>');" class="mybox_<s:property value="#item.btrvo.woffstate + 0"/>">销账信控</td>	   
          			</s:else>																	
				
            	
            </tr> 
            <tr>
              	<td height="10px"></td>		
				<td></td>	
				<td></td>	
				<td></td>	
				<td></td>  
				<td></td>	
				<td></td>
				<td></td>	
				<td></td>
				<td></td>	
				<td></td>
				<td></td>	
				<td></td>
				<td></td>	
				<td></td> 
				<td></td>	
				<td></td>   
            </tr>
             
        </s:iterator>        
        </table>
    </div>

</s:form>

</body>
</html>





























