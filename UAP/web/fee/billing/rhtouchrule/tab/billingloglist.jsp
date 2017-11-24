<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/inc/listhead.inc"%>
<%
	String ID_1 = "4D3C2B2BBT1";
	String ID_2 = "4D3C2B2BBT2";
	String ID_3 = "4D3C2B2BBT3";	
%>
<html>
	<head>
		<title><s:text name="titleList" /></title> 		
		<base target="_self">
		<script language="JavaScript" type="text/JavaScript">
			var bill_status = "<s:property value='#request.BILLSTATUS' />";
	        function ev_check() {
				return checkval(window);
	        }
	        
	        //文件下载/上传
	        function doFileDownload(state){
	        	var url;
	        	var name;
	        	if(state == '1'){
	        		url = 'fee/billing/uapreqfile_list.do';
	        		name = '文件下载';
	        	}else{
	        		url = 'fee/billing/uapreqfile_listUpload.do'
	        		name = '文件上传';
	        	}
	        	window.parent.parent.parent.openLink(name,url);
	        }
	        
	        
	        
	        function doLogConfirm(){
	        	if(bill_status == 3){
	        		if(confirm('是否确认?' )){
	        			formList.action =  contextPath + '/fee/billing/rhtouchrule_UpdateStatus.do';
	        			formList.submit();
	        			// 更新状态后刷新饼图		    	
		    			window.parent.document.all.loadframe2.autoRefresh();
	        		}
	        	}else{
	        		alert("低消计算未完成，不能确认");
	        		return false;
	        	}
	        }
    </script>
	</head>

	<body style="border:1px solid #ccc;" scroll="no">

			<s:form action="/fee/billing/rhtouchrule_BillinglogList.do" key="formList" cssStyle="formList" theme="simple" method="post" onsubmit="return ev_check();">
				<s:hidden name="param._orderby" />
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				
		
				<s:hidden name="form._ne_validbillcyc" />
				<s:hidden name="form.regiongroup" />
				<s:hidden name="form.step" /> 

			
				<div class="table_div">
					<table class="top_table">
						<tr>							
							<td>低消确认</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="error_text">
						<s:actionerror />
						<s:actionmessage />
					</table>
				</div> 
				<div class="table_div">        
			        <table class="form_table">   
			            <tr>
							<td class="form_table_right">
								<input type="button" class="query"  id="simplebt" value="文件上传" onclick="doFileDownload('0')"/>
								<input type="button" class="query"  id="simplebt" value="文件下载" onclick="doFileDownload('1')" />
								<input type="button" class="query"  id="simplebt" value="确认" onclick="doLogConfirm();"/>
							</td>      
			            </tr>
			        </table>
			    </div>
				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">
							<tr class="table_style_head">											
								<td>子步骤</td>
								<td>启动时间</td>
								<td>结束时间</td>
								<td>处理记录数</td>
								<td>处理金额</td>
								<td>状态</td>
							</tr>
							<s:iterator var="item" value="#request.LIST">						
								<tr class="table_style_content" align="center">												
									<td><j:code2Name definition="FILEDOWNLOAD" code="#item.subphase" /></td>
									<td><s:date name="#item.starttime" format="yyyy-MM-dd HH:mm:ss"/></td>
									<td><s:date name="#item.endtime" format="yyyy-MM-dd HH:mm:ss"/></td>
									<td><s:property value="#item.processcnt + 0"/></td>
									<td><fmt:formatNumber value="${item.processamt + 0}" type="currency" />	</td>									
									<td><j:code2Name definition="BACKACCTSTATE" dbFlag="BILL" code="#item.status + 0" /></td>													
								</tr>
							</s:iterator>
				
						</table>
					</div>
				</div>
			</s:form>
	</body>
</html>
