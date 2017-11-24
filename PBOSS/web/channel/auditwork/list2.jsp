<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%@ taglib prefix="j" uri="/jop-tags" %>
<html>
<head>
    <title><s:text name="titleList2"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
         	addfield('param._ne_auditstatus', '<s:text name="auditstatus"/>', 'c', true, '2');
         	addfield('param._ne_applyno', '<s:text name="applyno"/>', 'f', true, '18');
            addfield('param._dnm_createtime', '<s:text name="createtime"/>', 't', true, '7');
            addfield('param._dnl_createtime', '<s:text name="createtime"/>', 't', true, '7');
            return checkval(window);
        }
    </script>
</head>
<%--网点审批管理 --%>
<%
	String ID_AUDIT="CH_PW_WAYAPPLY_AUDIT";
%>
<body class="list_body">
<div class="table_container">
<s:form action="auditwork_list2.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%--//下面的控件给Action提供数据，用来分页--%>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList2"/></span>
			<span class="button_Help" onclick="openword('<s:text name="titleList2"/>','<s:text name="helpContentWay"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
                <td align="center"><s:text name="applyno"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_applyno" />
                    
                </td>
                <td align="center"><s:text name="auditstatus"/>:</td>
                <td align="left">
                    <j:selector definition="$CH_AUDITSTATUS"  name="param._ne_auditstatus" cssStyle="style_input"  value="0" mode="selector"/>
                </td>
            </tr>
             <tr>
                <td align="center"><s:text name="createtime"/>>=</td>
                <td align="left">
                	<s:textfield cssStyle="style_input" name="param._dnl_createtime" onclick="selectDate();"/>
                </td>
                <td align="center"><s:text name="createtime"/><=</td>
                <td align="left">
                	<s:textfield cssStyle="style_input" name="param._dnm_createtime" onclick="selectDate();"/>
                </td>
              </tr>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
                	<s:i18n name="public">
                	<j:purChk permid="<%=ID_AUDIT%>" disableChild="true">
                	<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_search"/>" onClick="doQuery('/channel/auditwork_list2.do');">
                    </j:purChk>
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
                    <j:orderByImg href="javascript:doOrderby('seqid')"><s:text name="seqid"/></j:orderByImg>            
                </td>
                <td>
                	<j:orderByImg href="javascript:doOrderby('worktype')"><s:text name="worktype"/></j:orderByImg>
                </td>
                <td>
                	<j:orderByImg href="javascript:doOrderby('applyno')"><s:text name="applyno"/></j:orderByImg>
                </td>
                <td>
                	<j:orderByImg href="javascript:doOrderby('createtime')"><s:text name="createtime"/></j:orderByImg>
                </td>
                <td>
                	<j:orderByImg href="javascript:doOrderby('optime')"><s:text name="optime"/></j:orderByImg>
                </td>
                <td>
                	<j:orderByImg href="javascript:doOrderby('content')"><s:text name="content"/></j:orderByImg>
                </td>
                <td>
                	<j:orderByImg href="javascript:doOrderby('auditstatus')"><s:text name="auditstatus"/></j:orderByImg>
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="seqid"/>" onclick="checkOne();">
                     </td>
                     <td>
							<s:property value="seqid"/>
					 </td>
                     <td>
                     <s:if test="worktype=='WAY_ADD_AUDIT'">
                     	网点新增审核
                     </s:if>
                     <s:elseif test="worktype=='WAY_UPDATE_AUDIT'">
                     	网点修改审核
                     </s:elseif>
                     <s:elseif test="worktype=='WAY_REMOVE_AUDIT'">
                     	网点退出审核
                     </s:elseif>
                     </td>
                     <td>
                    	 <a href='<s:url action="wayapply_edit.do">
                         <s:param name="param._pk" value="applyno"/>
                         <s:param name="form.seqid" value="seqid" />
                         <%--
                         <s:param name="form.auditstatus_work" value="auditstatus" />
                         
                         <s:param name="form.stepid" value="stepid" />
                         <s:param name="form.content" value="content" />
                         <s:param name="form.worktype" value="worktype" />
                          --%>
                     	 </s:url>'><s:property value="applyno" />
	                  </a>
	                  </td>
                     <td>
                     <s:date format="yyyy-MM-dd HH:mm:ss" name="createtime"/>
                     </td>
                     <td>
                     <s:date format="yyyy-MM-dd HH:mm:ss" name="optime"/>
                     </td>
                     <td><s:property value="content" /></td>
                     <td>
                     <j:code2Name code="auditstatus" definition="$CH_AUDITSTATUS"/>
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
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
</body>
</html>
