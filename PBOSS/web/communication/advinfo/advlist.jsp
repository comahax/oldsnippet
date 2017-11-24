<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('param._dnl_releasetime', '<s:text name="releasetime"/>', 't', true, 7);
        	addfield('param._dnm_releasetime', '<s:text name="releasetime"/>', 't', true, 7);
            return checkval(window);
        }
        function doMyNew(url){
        	$(":hidden[name='param._ne_type']").val("1");
        	doNew(url);
        }
         function doMyDel(url){
        	var checkedBoxs=$(":checkbox[name='param._selectitem']:checked");
			if(checkedBoxs.length==0){
				alert("请选择记录！");
				return;
			}
			var submitState=true;
			checkedBoxs.each(function(i) {
				if(jQuery(this).attr("state")!='1' && jQuery(this).attr("state")!='2' && jQuery(this).attr("state")!='5'){
					jQuery(this).attr("checked",false);
					if(submitState){
						submitState=false;
					}
				}
			});
			if(!submitState){
				alert("未发布，待审批，退回的记录才可以删除。请查实后再操作！");
				return;
			}
        	doDelete(url);
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="advinfo_advlist.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
    <s:hidden name="param._ne_type"/>
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="communication"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent1"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
		</div>
	</div>
    
    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>

	<div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="center"><s:text name="title"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._sk_title" />
                </td>
                
                <td align="center"><s:text name="state"/>:</td>
                <td align="left">
                    <j:selector definition="$CH_ADVINFOSTATE" condition="_pagesize:0" name="param._ne_state" cssStyle="select" />
                </td>
            </tr>
            <tr>
            	<td align="center"><s:text name="releasetime"/>>=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_releasetime" onclick="selectDate();"/>
                </td>
                <td align="center"><s:text name="releasetime"/><=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_releasetime" onclick="selectDate();"/>
                </td>
            </tr>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
                	<s:i18n name="public">
                	<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_search"/>" onClick="doQuery('/communication/advinfo_advlist.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doMyNew('/communication/advinfo_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doMyDel('/communication/advinfo_advdelete.do')">
                   </s:i18n>
				</td>
			</tr>
		</table>
	</div>

	<aa:zone name="listZone">
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style">
            <tr class="table_style_head">
               	<s:i18n name="public">
                <td title="<s:text name="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();"/>
                </td>
                </s:i18n>
                <td>
                    <j:orderByImg href="javascript:doOrderby('title')"><s:text name="title"/></j:orderByImg>                 
                </td>
                 <td>
                    <j:orderByImg href="javascript:doOrderby('type')"><s:text name="type"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('releasetime')"><s:text name="releasetime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('desttype')"><s:text name="desttype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('smsnotify')"><s:text name="smsnotify"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('ndapproval')"><s:text name="ndapproval"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('state')"><s:text name="state"/></j:orderByImg>                 
                </td>
                <td>审批
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="advinfoid"/>" state="<s:property value="state"/>" onclick="checkOne();">
                     </td>
                     <td>
                      <s:if test="(ndapproval==0 && state==1) || state==2 || state==5 ">
                     		<a href='<s:url action="advinfo_krOrAdvedit.do">
	                         		<s:param name="param._pk" value="advinfoid"/>
	                         		<s:param name="param._ne_type" value="type"/>
	                     			</s:url>'>
									<s:property value="title"/>
                        	 </a>
                       </s:if>
                       <s:else>
							<a href='<s:url action="advinfo_advreply.do">
	                         		<s:param name="param._ne_advinfoid" value="advinfoid"/>
	                         		
	                     			</s:url>'>
									<s:property value="title"/>
                        	 </a>
			          </s:else>
                     </td>
                     <td><j:code2Name definition="$CH_ADVINFOTYPE" code="type" /></td>
                     <td><s:date name="releasetime" format="yyyy-MM-dd"/></td>
                     <td><j:code2Name definition="$CH_ADVINFODESTTYPE" code="desttype" /></td>
                     <td><j:code2Name definition="SMSNOTIFY" code="smsnotify" /></td>
                     <td><j:code2Name definition="NDAPPROVAL" code="ndapproval" /></td>
                     <td><j:code2Name definition="$CH_ADVINFOSTATE" code="state" /></td>
                     
                     <td>
                     <s:if test="state==2">
                     	<input type="button" id="btnAudit" name="btnAudit" class="button_2" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="审批" onClick="doQuery('/communication/advinfo_advApproval.do?param._ne_advinfoid=<s:property value="advinfoid"/>')">
                     </s:if>
                     </td>
                 </tr>
             </s:iterator>
        </table>
        </div>
    </div>
    <div class="table_div">
		<%@ include file="/common/pageNav.jsp"%>
   	</div>
    </aa:zone>
</s:form>
</div>
</body>
</html>
