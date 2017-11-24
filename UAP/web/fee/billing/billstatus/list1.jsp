<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="title1"/></title>
    <link href="<%=contextPath%>/fee/billing/billstatus/list.css" rel="stylesheet" type="text/css" media="all" />
	<link href="<%=contextPath%>/fee/billing/rhtouchrule/css/list.css" rel="stylesheet" type="text/css" media="all" />
	
	
    <base target="_self">
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {                    
            return checkval(window);   
        } 
        
        function showLog(step,region){
        	var validbillcyc = document.getElementById('form._ne_validbillcyc').value;
        	var url = contextPath + '/fee/billing/billstatus_showlog.do?' + '_PHASE=' + step + '&_REGIONGROUP=' + region + '&_VALIDBILLCYC=' + validbillcyc;
       		
       		// var hWnd = window.showModalDialog(url,new Array(),"dialogWidth:620px; dialogHeight:250px; status:no;resizable:yes;");
       		document.getElementById("IFRM_MAIN").style.display = "";
            IFRM_MAIN.location.href = url;
            window.document.body.scrollTop = 1000;
        }
        
        function doBatchstartup() {
        	var ischeck = false;
        	if(document.all._selectitem != null){
				if(document.all._selectitem.length != null ){				
					for( j = 0; j < document.all._selectitem.length; j++ ) {
						if( document.all._selectitem[j].checked == true ) {		
							ischeck = true;
							break;
						}														
					}											
				}else{		
					ischeck = document.all._selectitem.checked;					
				}
			}
			if(!ischeck){
				alert('请选择确认的记录！');
				return;
			}
			
			if(confirm('是否批量启动?')){				
				formList.action =  contextPath + '/fee/billing/billstatus_batchstartup.do';   	    
				formList.submit();
			} 			
		}
		
		function goMain(){
			formList.action =  contextPath + '/fee/billing/billstatus_set.do';  
			formList.submit();
		}	
        
        function autoRefresh(){
        	var validbillcyc = document.getElementById('form._ne_validbillcyc').value;
	        var regiongroup = document.getElementById('form.regiongroup').value;
	        var phase = document.getElementById('form.phase').value;
	       
        	if(validbillcyc != "" && regiongroup != "" && phase != ""){
        		formList.submit();
        	}
    	}						
		setInterval("autoRefresh()",1000*60*1);
    </script>
    <style type="text/css">
	    .point {
			background:url(images/accounting/point7.gif) no-repeat 0px 0px;text-align:center;
		}
	</style>
</head>

<body>
<div class="table_container">
<s:form action="/fee/billing/billstatus_showproc.do" key="formList" cssStyle="formList" theme="simple" method="post" onsubmit="return ev_check();">
    <s:hidden name ="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>	
	<s:hidden name="form._ne_validbillcyc"/>	
	<s:hidden name="form.regiongroup"/>
	<s:hidden name="form.phase"/>

	<div class="widgetL">
		<div class="wCenter">
			<div class="content">
				<div class="title_name">
					<s:text name="subtitle"/>
				</div>
				<div class="search2">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						
						<tr>
						    <td align="left"><aa:zone name="errorZone">
								<div class="error_text">
									<s:actionerror />
									<s:actionmessage />
								</div>
							</aa:zone></td>
							<td  align="right">										
								<j:purChk permid="MONITORSTATUS_START" disableChild="true">
								<s:if test="#request['_BIGPHASE'] == 'A101' || #request['_BIGPHASE'] == 'G101'">	
								<input type="button" class="bt48_gray"  id="startupbt"
				                 	onmouseover="this.className='bt48'" onmouseout="this.className='bt48_gray'"
				                    value="启动" onclick="doBatchstartup();"/>
				                </s:if>    
				                </j:purChk>
				                <input type="button" class="bt48_gray" 
							        onmouseover="this.className='bt48'" onmouseout="this.className='bt48_gray'"
							        value="返回" onClick="goMain();"/>
							</td>
						</tr>
					</table>
				</div>		
   
				<div class="table_div" style="text-align:left;">
					<span class="point" style="width:750px;height:20px;padding:9px 0 0 500px;margin-top:0px;">
					</span>
				</div>
			    <div class="table_div" style="text-align: left;">
			        <table class="table2">
			        <s:if test="#request['_BIGPHASE'] == 'A101' || #request['_BIGPHASE'] == 'G101'">
			        	<tr>
			        		<td width="10px"></td>
			            	<td>
			            		<input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
			            	</td>
			            	<td style="no-repeat 0px 7px; padding-left:20px;padding-right:10px" width="30px">
			            		全选
			            	</td>
			        	</tr>
			        </s:if>	
			        <s:iterator var="item" value="#request.LIST">      		       	
			            <tr>
			            	<td width="10px"></td>            	
			            	<s:if test="#request._BIGPHASE == 'A101' || #request['_BIGPHASE'] == 'G101'">
			            	<td>            		
			            		<input type="checkbox" name="param._selectitem" value="#item.region" onclick="" class="table_checkbox">
			            	</td>
			            	</s:if>
			            	<td><span class="location" style="padding-top:7px">
			            	<j:code2Name code="#item.region" definition="CITYIDCODE"/>:            	
			            	</span>
			            	</td>
			            	<s:iterator var="stat" value="#item.statusdata" status="s">            	
				            	<s:if test="#stat.subphase == 1">            		
				            		<td style="font-size:17px">:&nbsp;</td>
				            		<td><table><tr>
				            	</s:if>
				            	 
				            	<s:if test="#stat.subphase > 1">
				            		<td class="jiantou0"></td>
				            	</s:if>
				            	<s:if test="#s.index % 6 == 1">
				            		</tr><tr>
				            	</s:if>
				            	<!-- ${#stat.status + 0} -->
				            	<td style="cursor:hand;" onclick="showLog('<s:property value='#stat.stepname'/>','<s:property value='#item.region'/>');" ><span class="mybox_<s:property value='#stat.status + 0'/>" style="padding-top:6px"><j:code2Name code="#stat.stepname" definition="SUBPHASENAME" /></span></td>
				            	<s:if test="#s.last">
				            	    <s:if test="#stat.subphase > 0">
				            		</tr></table></td>
									</s:if>
				            	</s:if>
			            	</s:iterator>	
			            	
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
			    </br>
			    <iframe frameborder="0" scrolling="no" class="loadframe" name="IFRM_MAIN" id="IFRM_MAIN" style="display:none"></iframe>
			    
			  </div>
		</div>
	</div>
</s:form>
</body>
</html>





























