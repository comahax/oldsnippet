<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/contenthead.inc" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<base target="_self">
    <title><s:text name="title3"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.req_type', '<s:text name="s_a_type"/>', 'c', false, 20);
           	addfield('form.validbillcyc', '<s:text name="s_a_validbillcyc"/>', 'l', false, 8);
            addfield('form.compvalidbillcyc', '<s:text name="com_validbillcyc"/>', 'l', false, 8);
            return checkval(window);
        }

	     $(document).ready(function()
	     { 
	     	var myDate = new Date();
    	  	$("input[name='form.validbillcyc']").val(getCurrBillCyc());
    	  	$("input[name='form.compvalidbillcyc']").val(getLastBillCyc());
    	  		
	     	var flg = false;
	     	$("form:first").submit(function(){
	     		if(ev_checkval()){
	     			$("input[name='param._selectitem']").each(function(){
	     				if($(this).attr("checked") == "checked"){
    	  					flg = true;
    	  				}
	     			});
	     			$("input[name='param._selectitem2']").each(function(){
	     				if($(this).attr("checked") == "checked"){
    	  					flg = true;
    	  				}
	     			});
	     			
	     			if(!flg){
    	  				alert('请选择‘统计’或‘分析’!');
    	  				return false;
    	  			}
	     			return true;
	     		}
	     		return false;
	     	});

	     });
	</script>
</head>
<body>
<s:form action="uapreqfile_save1.do" key="formItem" method="post" theme="simple">
		<s:hidden name="CMD"/>
		<div class="widgetL">
		<div class="wCenter"> 
		<div class="content">
		<div class="title_name">发起统计请求</div>
		<aa:zone name="errorZone"><div class="error_text"><s:actionerror/><s:actionmessage/></div></aa:zone>
		<div class="search2">
		<table  width="100%"  border="0" cellspacing="0" cellpadding="0">
            <tr>
                <th><s:text name="s_a_type"/>:</th>
                <td width="65%" align="left">
                	<j:selector id="_req_type" name="form.req_type" definition="$IB_REQ_UAP" condition="_ssw_dictid:_2"  cssClass="input" mode="selector" />
                	<input type="checkbox"  name="param._selectitem"/> <s:text name="statistic"/>
                	<input type="checkbox" name="param._selectitem2"/> <s:text name="analyse"/>
                </td>

            </tr>
            <tr>
                <th><s:text name="s_a_validbillcyc"/>:</th>
                <td width="65%" align="left">
                	<s:textfield cssClass="Wdate" name="form.validbillcyc" id="validbillcyc" readonly="true" onfocus="WdatePicker({skin:'default',dateFmt:'yyyyMM00'})"></s:textfield>
                </td>
            </tr>
            <tr>
            	<th><s:text name="com_validbillcyc"/>:</th>
               	<td width="65%" align="left">
               		<s:textfield cssClass="Wdate" name="form.compvalidbillcyc"   onfocus="WdatePicker({skin:'default',dateFmt:'yyyyMM00'})"></s:textfield>
               	</td>
            </tr>
            <tr>
            	 <th><s:text name="remark"/>:</th>
            	 <td width="65%" align="left"><s:textarea cssClass="input" name="form.remark" ></s:textarea></td>
            </tr>
            <tr>
                <th></th>
                <td width="65%" align="left" class="form_table_left">   
                   	<s:i18n name="public">
                   		<s:if test="#request.SUCCEED=='SUCCEED'">
                   			<input type="submit" name="btnSave" onmouseover=this.className="bt48" onMouseOut="this.className='bt48_gray'"
                           value="<s:text name="button_yes"/>" class="bt48_gray" disabled="disabled" />
                   		</s:if>
                   		<s:else>
                   		   <input type="submit"  name="btnSave" onmouseover=this.className="bt48" onMouseOut="this.className='bt48_gray'"
                           value="<s:text name="button_yes"/>" class="bt48_gray" />
                   		</s:else>
                    <input type="button"  value="<s:text name="button_return"/>"  onmouseover=this.className="bt48" onMouseOut="this.className='bt48_gray'"
                           class="bt48_gray" onclick="doReturn('/fee/billing/uapreqfile_list1.do')"/>
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
