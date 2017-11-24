<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="checkedapplydetail_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
	<aa:zone name="hiddenZone">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
	</aa:zone>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
            	<td align="center">
					<s:text name="chktype" />
					:
				</td>
				<td align="left">
					<j:selector definition="$CH_ASSESSMTHD"	name="param._se_chktype" />
				</td>
				<td align="center">
					<s:text name="buztypecode" />
					:
				</td>
				<td align="left">
					<j:selector definition="$CH_BUZTYPE" name="param._se_buztypecode" />
				</td>
            </tr>
            <tr>
            	<td align="center">
					<s:text name="status" />
					:
				</td>
				<td align="left">
					<s:if test="paramvalue">
                		<j:selector definition="$CH_APPSTATUS_GZ" name="param._se_status"/>
                	</s:if>
                	<s:else><j:selector definition="$CH_APPSTATUS" name="param._se_status"/></s:else>
				</td>
				<td align="center">
					<s:text name="applytype" />
					:
				</td>
				<td align="left">
					<j:selector definition="$CH_CHECKTYPE" name="param._se_applytype" />
				</td>
            </tr>
            <tr>
            	<td align="center">
					<s:text name="aptime" />>=:
				</td>
				<td align="left">
					<s:textfield cssStyle="style_input" name="param._dnl_aptime" onclick="selectDatetime();"/>
				</td>
				<td align="center">
					<s:text name="aptime" /><=:
				</td>
				<td align="left">
					<s:textfield cssStyle="style_input" name="param._dnm_aptime" onclick="selectDatetime();"/>
				</td>
            </tr>
            <tr>
            	<td align="center">
					<s:text name="applyno" />
					:
				</td>
				<td align="left">
					<s:textfield cssStyle="style_input" name="param._ne_applyno"/>
				</td>
				<td align="center">
					<s:text name="oprtime" />:
				</td>
				<td align="left">
					<s:textfield cssStyle="style_input" name="param._se_oprtime" readonly="true" onclick="selectDateYYYYMM();"/>
				</td>
            </tr>
             <tr>
            	<td align="center">
					网点审核状态
					:
				</td>
				<td align="left" colspan="3">
					<s:if test="paramvalue"><j:selector definition="$CH_WAYSTATUS_GZ" name="param._se_waystatus" /></s:if>
                    <s:if test="!paramvalue"><j:selector definition="$CH_WAYSTATUS" name="param._se_waystatus" /></s:if>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/channel/checkedapplydetail_list.do');">
                	
                	
                	<input type="button" id="btnExportexcel" name="btnExportexcel" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_exportexcel"/>" onClick="doExcel()">
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
                <td>
                    <s:text name="seq"/>              
                </td>
                <td>
                    <s:text name="applyno"/>              
                </td>
                <td>
                    <s:text name="cityid"/>              
                </td>
                <td>
                    <s:text name="nettype"/>                
                </td>
                <td>
                    <s:text name="chainhead"/>               
                </td>
                <td>
                    <s:text name="wayname"/>              
                </td>
                <td>
                    <s:text name="wayid"/>               
                </td>
                <td>
                    <s:text name="address"/>                
                </td>
                <td>
                    <s:text name="buztypecode"/>              
                </td>
                <td>
                    <s:text name="chktype"/>                
                </td>
                <td>
                    <s:text name="starlevel"/>               
                </td>
                <td>
                    <s:text name="status"/>                
                </td>
                <td>
                    <s:text name="applytype"/>               
                </td>
                <td>网点审核状态</td>
                <td>
                    <s:text name="aptime"/>              
                </td>
                <td>
                    <s:text name="oprtime"/>              
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
					 <td>
					 <s:if test="paramvalue">
					 	<s:if test="(CH_CHECKED_COUNTY&&status==2) || (CH_CHECKED_MIDCITY&&status==0)">
							<a href='<s:url action="checkedapplydetail_edit.do">
							<s:param name="param._pk" value="seq"/></s:url>'>
							<s:property value="seq"/></a>
					 	</s:if>
					 	<s:else>
					 		<s:property value="seq"/>
					 	</s:else>
					 </s:if>
					 <s:else>
					 	<s:if test="CH_CHECKED_COUNTY == true ">
					 		<s:if test="status != 1 ">
							 	<a href='<s:url action="checkedapplydetail_edit.do">
			                         <s:param name="param._pk" value="seq"/>
			                     	 </s:url>'>
									 <s:property value="seq"/>
		                         </a>
	                         </s:if>
                        	 <s:else>
                        	 	<s:property value="seq"/>
                         	</s:else>                        	 
                         </s:if>
                         <s:else>
                         	<s:property value="seq"/>
                         </s:else>
                     </s:else>
					 </td>
					 <td><s:property value="applyno" /></td>
                     <td><j:code2Name code="cityid" definition="#CITYCOMPANY" /></td>
                     <td><j:code2Name code="wtype" definition="$CH_WTYPE" /></td>
                     <td><j:code2Name code="chainhead" definition="#WAYIDINFO"/></td>
                     <td><s:property value="wayname" /></td>
                     <td><s:property value="wayid" /></td>
                     <td><s:property value="address" /></td>
                     <td><j:code2Name code="buztypecode" definition="$CH_BUZTYPE" /></td>
                     <td><j:code2Name code="chktype" definition="$CH_ASSESSMTHD" /></td>
                     <td><j:code2Name code="starlevel" definition="$CH_STARLEVEL" /></td>
                     <td>
                     	<s:if test="paramvalue"><j:code2Name definition="$CH_APPSTATUS_GZ" code="status" /></s:if>
                     	<s:if test="!paramvalue"><j:code2Name definition="$CH_APPSTATUS" code="status" /></s:if>
                     </td>
                     <td><j:code2Name code="applytype" definition="$CH_CHECKTYPE" /></td>
                     <td>
                     	<s:if test="paramvalue"><j:code2Name code="waystatus" definition="$CH_WAYSTATUS_GZ" /></s:if>
                     	<s:if test="!paramvalue"><j:code2Name code="waystatus" definition="$CH_WAYSTATUS" /></s:if>
                     </td>
                     <td><s:property value="aptime" /></td>
                     <td><s:property value="oprtime" /></td>
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
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();  
	ajaxAnywhere.formURL = formList.action;
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
<script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		return checkval(window);
	}
	
	function doExcel(){
    	formList.action="<%=contextPath%>/channel/checkedapplydetail_exportExcel.do";
        formList.submit();
        formList.action="<%=contextPath%>/channel/checkedapplydetail_list.do";
    }
</script>
