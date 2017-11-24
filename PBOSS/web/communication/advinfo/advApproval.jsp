<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<script type="text/javascript" src="<%=contextPath%>/js/pub/content.js"></script>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
			
			addfield('form.appState','����״̬','c',false,2);
			addfield('form.appContent','�������','c',false,128);
            return checkval(window);
        }
        function doDownload(cmdDownload) {
      		formItem.action = contextPath + cmdDownload;
      	    formItem.submit();
      	}
        

    </script>
</head>
<body>
<div class="table_container">
<s:form action="advinfo_doApprovalSave.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();"> 
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._ne_advinfoid"/>
    <s:hidden name="param._se_title"/>
    <s:hidden name="param._se_content"/>
    <s:hidden name="param._ne_type"/>
    <s:hidden name="param._de_releasetime"/>
    <s:hidden name="param._de_plantime"/>
    <s:hidden name="param._dnm_enddate"/>
    <s:hidden name="param._ne_desttype"/>
    <s:hidden name="param._ne_smsnotify"/>
    <s:hidden name="param._ne_ndapproval"/>
    <s:hidden name="param._se_oprcode"/>
    <s:hidden name="param._ne_state"/>
    <s:hidden name="form.advinfoid"/>
    
    <s:hidden name="downloadReturnActionName" value="advinfo_advApproval"/>
    <s:hidden name="downloadReturnMethod" value="advApproval"/>
    
	<input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="communication"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h">
				<s:text name="titleAdvreply"/>
			</span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent4"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
		</div>
	</div>

	<div class="error_text" >
		<table class="error_text">
			<s:actionerror /><s:actionmessage/>
		</table>
	</div>
	
    <div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="right" width="20%"><s:text name="advinfoid"/>:&nbsp;</td>
                <td align="left">
			        <s:property value="form.advinfoid"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="20%"><s:text name="title"/>:&nbsp;</td>
                <td align="left">
					<s:property value="form.title"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="20%"><s:text name="content"/>:&nbsp</td>
                <td align="left">
                	<s:property value="form.content" escape="false"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="20%"><s:text name="state"/>:&nbsp;</td>
                <td align="left">
					<j:code2Name definition="$CH_ADVINFOSTATE" code="form.state" />
                </td>
            </tr>
            <tr>
                <td align="right" width="20%"><s:text name="releasetime"/>:&nbsp;</td>
                <td align="left">
					<s:date name="form.releasetime" format="yyyy-MM-dd"/>
                </td>
            </tr>
             <tr>
                <td align="right" width="20%"><s:text name="enddate"/>:&nbsp;</td>
                <td align="left">
					<s:date name="form.enddate" format="yyyy-MM-dd"/>
                </td>
            </tr>
             <tr>
                <td align="right" width="20%"><s:text name="oprcode"/>:&nbsp;</td>
                <td align="left">
					<s:property value="form.oprcode"/>
                </td>
            </tr>
        </table>
    </div>
    
    	<div class="table_div">
		     <table class="table_normal" id="attachment_table">
		     	<s:iterator value="afDp.datas">
			     	 <tr>
		                <td align="center" width="40%"><s:text name="attachment"/>:&nbsp;</td>
		                <td align="center">
							<a href='javascript:doDownload("/communication/advinfo_affixDownload.do?affixid=<s:property value="affixid"/>")'> 
								<s:property value="affixname"/>
							</a>
						</td>
		            </tr>
		     	</s:iterator>
	           
	        </table>
		</div>
	   
		
	

	   	 <div class="table_div">
			     <table class="table_normal" id="attachment_table">
			     	<tr>
		                <td align="right" width="20%">����״̬:&nbsp</td>
		                <td align="left">
							<j:selector definition="$CH_ADVAPPRTYPE" name="form.appState" cssStyle="style_input" />
							<font color=red>*</font>
		                </td>
		            </tr>
			     	<tr>
		                <td align="right" width="20%">�������:&nbsp</td>
		                <td align="left">
							<s:textarea cssStyle="style_input" name="form.appContent" maxlength="128" cols="50" rows="5" />
							<font color=red>*</font>
		                </td>
		            </tr>
		        </table>
		</div>
   	<div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
	                   	<s:i18n name="public">
		                   <input type="button" id="btnSubmit" name="btnSubmit" class="button_New" onmouseover="buttonover(this);"
		                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                        value="<s:text name="button_submit"/>" onclick="doSave('/communication/advinfo_doApprovalSave.do')">
		                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
		                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                           value="<s:text name="button_return"/>" onclick="window.location.href='/communication/advinfo_advlist.do'">
						</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>

</body>
</html>
