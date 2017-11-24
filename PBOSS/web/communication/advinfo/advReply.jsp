<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<script type="text/javascript" src="<%=contextPath%>/js/pub/content.js"></script>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            /*
			addfield('form.title', '<s:text name="title"/>', 'c', false, 256);
			addfield('form.content', '<s:text name="content"/>', 'c', false, 2048);
			addfield('form.releasetime', '<s:text name="releasetime"/>', 't', false, 7);
			addfield('form.desttype', '<s:text name="desttype"/>', 'f', false, 3);
			*/
			
			addfield('form.replycontent','<s:text name="input"/>','c',false,256);
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
<s:form action="advinfo_doAdvreply.do" cssStyle="formList" key="formList"
			method="post" theme="simple">
			
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
    <s:if test="#parameters.mode[0] == 'reply'">
    <s:hidden name="mode" value="reply"/>
    </s:if>
    
    <s:hidden name="downloadReturnActionName" value="advinfo_advReply"/>
    <s:hidden name="downloadReturnMethod" value="doAdvreply"/>
    
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
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent3"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
		</div>
	</div>

	<div class="error_text" >
		<table class="error_text">
			<s:actionerror /><s:actionmessage/>
		</table>
	</div>
	
    <div class="table_div">
        <table class="table_normal">
        <!-- 
            <tr>
                <td align="right" width="20%"><s:text name="advinfoid"/>:&nbsp;</td>
                <td align="left">
			        <s:property value="form.advinfoid"/>
                </td>
            </tr>
             -->
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
    <aa:zone name="listZone">
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
		     <table class="table_normal">
		     	<s:iterator value="dp.datas">
		     		 <tr>
		                <td align="right" width="20%"><s:property value="replytime"/></td>
		                <td align="right" width="20%">
		                	<s:if test="oid == -1">
		                		匿名
		                	</s:if>
		                	<s:elseif test="oid == 0">
		                		渠道经理
		                	</s:elseif>
		                	<s:else>
		                		<s:property value="wayid"/>_<s:property value="employeename"/>
		                	</s:else>
		                	回复:&nbsp;
		                </td>
		                <td align="left"><s:property value="replycontent"/></td>
		             </tr>
		     	</s:iterator>
		           
	        </table>
		</div>
		
		<div class="table_div">
			<%@ include file="/common/pageNav.jsp"%>
	   	</div>
    
    </aa:zone>
</s:form>

<s:form action="reply_resave.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">     
	   	 <div class="table_div">
			     <table class="table_normal" id="attachment_table">
			     	<tr>
		                <td align="right" width="20%"><s:text name="input"/>:&nbsp</td>
		                <td align="left">
							<s:textarea cssStyle="style_input" name="form.replycontent" maxlength="2048" cols="50" rows="5" />
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
		                        value="<s:text name="button_submit"/>" onClick="doSave('/communication/reply_advRresave.do?param._ne_advinfoid=<s:property value="form.advinfoid"/>')">
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
