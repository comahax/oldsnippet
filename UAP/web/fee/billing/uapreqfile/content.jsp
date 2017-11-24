<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/contenthead.inc" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<base target="_self">
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.validbillcyc', '<s:text name="validbillcyc"/>', 'l', false, 8);
            return checkval(window);
        }
		// 获取出账状态        
        function doFetchStatus(){       
            var validbillcyc = document.getElementById("validbillcyc").value;
			formItem.action="fee/billing/uapreqfile_new.do?validbillcyc="+validbillcyc; 	
			formItem.submit();	
		}
		function checkStatus(){
		    if($("input[id='status_A102']").val()==3){
	    	  		$("input[value='1101']").attr("disabled",true);
	    	  		$("input[value='1102']").attr("disabled",true);
	    	}
	    	else if($("input[id='status_A101']").val()==3){
	    	  		$("input[value='1103']").attr("disabled",true);
	    	  		$("input[value='1104']").attr("disabled",true);
	    	}
	    	else if($("input[id='status_A102']").val()!=3 && $("input[id='status_A101']").val()!=3){
	    	  		$("input[value='1101']").attr("disabled",true);
	    	  		$("input[value='1102']").attr("disabled",true);
	    	  		$("input[value='1103']").attr("disabled",true);
	    	  		$("input[value='1104']").attr("disabled",true);
	    	}
	    	
	    	if($("input[id='status_A105']").val()==3){
	    	  		$("input[value='1105']").attr("disabled",true);
	    	  		$("input[value='1106']").attr("disabled",true);
	    	  		$("input[value='1107']").attr("disabled",true);
	    	  		$("input[value='1108']").attr("disabled",true);
	    	  		$("input[value='1109']").attr("disabled",true);
	    	  		$("input[value='1110']").attr("disabled",true);
	    	  		$("input[value='1111']").attr("disabled",true);
	    	  		$("input[value='1112']").attr("disabled",true);
	    	}
	    	else if($("input[id='status_A104']").val()==3){
	    	  		$("input[value='1105']").attr("disabled",true);
	    	  		$("input[value='1106']").attr("disabled",true);
	    	  		$("input[value='1107']").attr("disabled",true);
	    	  		$("input[value='1108']").attr("disabled",true);
	    	  		$("input[value='1113']").attr("disabled",true);
	    	  		$("input[value='1114']").attr("disabled",true);
	    	  		$("input[value='1115']").attr("disabled",true);
	    	  		$("input[value='1116']").attr("disabled",true);
	    	}
	    	else if($("input[id='status_A103']").val()==3){
	    	  		$("input[value='1109']").attr("disabled",true);
	    	  		$("input[value='1110']").attr("disabled",true);
	    	  		$("input[value='1111']").attr("disabled",true);
	    	  		$("input[value='1112']").attr("disabled",true);
	    	  		$("input[value='1113']").attr("disabled",true);
	    	  		$("input[value='1114']").attr("disabled",true);
	    	  		$("input[value='1115']").attr("disabled",true);
	    	  		$("input[value='1116']").attr("disabled",true);
	    	}
	    	else if($("input[id='status_A103']").val()!=3 
	    	   && $("input[id='status_A104']").val()!=3 
	    	   && $("input[id='status_A105']").val()!=3){
	    	  		$("input[value='1105']").attr("disabled",true);
	    	  		$("input[value='1106']").attr("disabled",true);
	    	  		$("input[value='1107']").attr("disabled",true);
	    	  		$("input[value='1108']").attr("disabled",true);
	    	  		$("input[value='1109']").attr("disabled",true);
	    	  		$("input[value='1110']").attr("disabled",true);
	    	  		$("input[value='1111']").attr("disabled",true);
	    	  		$("input[value='1112']").attr("disabled",true);
	    	  		$("input[value='1113']").attr("disabled",true);
	    	  		$("input[value='1114']").attr("disabled",true);
	    	  		$("input[value='1115']").attr("disabled",true);
	    	  		$("input[value='1116']").attr("disabled",true);
	    	}
		}
    	
    	$(document).ready(function()
    	  {
    	  	//$("input[name='form.validbillcyc']").val(getCurrBillCyc());
    	  	
    	  	$("input[name='allbox']:checkbox").click(function(){
    	  		$("input[name='param._selectitem']").each(function(){
            		if($(this).attr("disabled") == undefined && $(this).attr("checked") == undefined){//未选中返回undefined，选中则返回checked
            			$(this).attr("checked",true);
            		}
            		else{
            			$(this).attr("checked",false);
            		}
            	});
    	  	});
    	  	
    	  	$("form:first").submit(function(){
    	  		if(ev_checkval()){
    	  			var flg = false;
    	  			$("input[name='param._selectitem']").each(function(){
    	  				if($(this).attr("checked") == "checked"){
    	  					flg = true;
    	  				}
    	  			});
    	  			if(!flg){
    	  				alert('请选择文件类型!');
    	  				return false;
    	  			}
    	  			return true;
    	  		}
    	  		return false;
    	  	});
    	  	
    	  });  
    </script>
</head>
<body onload="checkStatus();">
<s:form action="uapreqfile_save.do" key="formItem" method="post" theme="simple">
    <s:hidden name="CMD"/>
    
    <div class="widgetL">
	<div class="wCenter"> 
	<div class="content">
	<div class="title_name">发起下载请求</div>
	<aa:zone name="errorZone"><div class="error_text"><s:actionerror/><s:actionmessage/></div></aa:zone>
	<div class="search2">
	<table width="100%"  border="0" cellspacing="0" cellpadding="0">
    	<tr>
		    <th><s:text name="validbillcyc"/>:</th>
            <td width="75%" align="left">
                    <s:textfield  cssClass="Wdate" name="form.validbillcyc"  id="validbillcyc" readonly="true" onchange="doFetchStatus();"  onfocus="WdatePicker({skin:'default',dateFmt:'yyyyMM00'})"></s:textfield>
                    <aa:zone name="rhbillstatus">		
								<s:hidden name="#request.status_A101" id="status_A101"/>	
								<s:hidden name="#request.status_A102" id="status_A102"/>	
								<s:hidden name="#request.status_A103" id="status_A103"/>	
								<s:hidden name="#request.status_A104" id="status_A104"/>
								<s:hidden name="#request.status_A105" id="status_A105"/>					
					</aa:zone>
            </td>
        </tr>
        <tr>
		    <th><s:text name="reqtype"/>:</th>
            <td width="75%" align="left"><s:checkbox name="allbox" cssClass="table_checkbox"/> <s:text name="chooseall"/></td>
        </tr>
        <tr>
            <th>固定费:</th>
            <td width="75%" align="left" class="form_table_left">   
            <table><tr>
			<td style="border:1px dashed #ccc">
				<table>
					<tr>
						<s:iterator value="#request.FIXFEE.datas" var="item" status="status">
               			<s:if test="#status.count > 4">
               				<s:if test="#status.index%4==0">
               					</tr>
               				</s:if>
               			</s:if>
              			<td><input type="checkbox" class="table_checkbox" name="param._selectitem" value="${ item.dictid }"/> <s:text name="#item.dictname"/></td>
              			</s:iterator>
				</table>
			</td>
			</tr></table>				
            </td>
        </tr>
        <tr>
            <th>通信费:</th>
            <td width="75%" align="left" class="form_table_left">   
            <table><tr>
			<td style="border:1px dashed #ccc">
				<table>
					<tr>
						<s:iterator value="#request.ACCULATE.datas" var="item" status="status">
               			<s:if test="#status.count > 4">
               				<s:if test="#status.index%4==0">
               					</tr>
               				</s:if>
               			</s:if>
              			<td><input type="checkbox" class="table_checkbox" name="param._selectitem" value="${ item.dictid }"/> <s:text name="#item.dictname"/></td>
              			</s:iterator>
				</table>
			</td>
			</tr></table>				
            </td>
        </tr>
        <tr>
            <th>合账:</th>
            <td width="75%" align="left" class="form_table_left">   
            <table><tr>
			<td style="border:1px dashed #ccc">
				<table>
					<tr>
						<s:iterator value="#request.ACCOUNTING.datas" var="item" status="status">
               			<s:if test="#status.count > 4">
               				<s:if test="#status.index%4==0">
               					</tr>
               				</s:if>
               			</s:if>
              			<td><input type="checkbox" class="table_checkbox" name="param._selectitem" value="${ item.dictid }"/> <s:text name="#item.dictname"/></td>
              			</s:iterator>
				</table>
			</td>
			</tr></table>				
            </td>
        </tr>
		<tr>
			<th>预付费低销:</th>
			<td width="75%" align="left" class="form_table_left">
				<table>
					<tr>
						<td style="border:1px dashed #ccc">
							<table>
								<tr>
									<s:iterator value="#request.PREFEE.datas" var="item"
										status="status">
										<s:if test="#status.count > 4">
											<s:if test="#status.index%4==0">
								</tr>
								</s:if>
								</s:if>
								<td><input type="checkbox" class="table_checkbox"
									name="param._selectitem" value="${ item.dictid }" /> <s:text
										name="#item.dictname" /></td>
								</s:iterator>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
        <tr>
            <th></th>
            <td width="75%" align="left" class="form_table_left">
                 	<s:i18n name="public">
                 	<s:if test="#request.SUCCEED=='SUCCEED'">
                 	 	<input type="submit" name="btnSave" onmouseover=this.className="bt48" onMouseOut="this.className='bt48_gray'"
                         value="<s:text name="button_yes"/>" class="bt48_gray" disabled="disabled" />
                 	</s:if>
                 	<s:else>
                 		<input type="submit" name="btnSave" onmouseover=this.className="bt48" onMouseOut="this.className='bt48_gray'"
                         value="<s:text name="button_yes"/>" class="bt48_gray" />
                 	</s:else>
                  <input type="button"  value="<s:text name="button_return"/>" onmouseover=this.className="bt48" onMouseOut="this.className='bt48_gray'"
                         class="bt48_gray" onclick="doReturn('/fee/billing/uapreqfile_list.do')"/>
				</s:i18n>
             </td>
        </tr>    
        </table>
    </div>
    </div>
    </div>
</div>

</s:form>
</body>
</html>
