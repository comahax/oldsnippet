<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
     
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="waychecked_save.do" key="formList" cssStyle="formList" theme="simple">
	<%//下面的控件给Action提供数据，用来分页%>
	<aa:zone name="hiddenZone">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>    
    <s:hidden name="form.applyno"/>
    <s:hidden name="form.applytype"/>
    <s:hidden name="form.APPSTATUS_MULTI"/>
    <s:hidden name="form.status"/>
    
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
	</aa:zone>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea" ><s:text name="currentPos"/> </span>
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
<aa:zone name="listZone">
	  <div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="right"><s:text name="cityid"/>:&nbsp</td>
                <td align="left" cssStyle="style_input"> 
					    <j:code2Name code="form.cityid" definition="#CITYCOMPANY"/>   
                </td>
                 <td align="right"><s:text name="aptime"/>:&nbsp</td>
                <td align="left" > 
					   <s:date name="form.aptime" format="yyyy-MM-dd"/>  
                </td>
            </tr> 
            <tr>
                <td align="right">申请工号:&nbsp</td>
                <td align="left"> 
						<s:property value="form.oprcode" /> 
                </td>
                 <td align="right"><s:text name="mobileno"/>:&nbsp</td>
                <td align="left"> 
                <s:property value="form.mobileno" /> 
                </td>
            </tr> 
            <tr>
                <td align="right"><s:text name="oprcode"/>:&nbsp</td>
                <td align="left"> 
						<s:property value="form.oprname" /> 
                </td>
                 <td align="right"><s:text name="applytype"/>:&nbsp</td>
                <td align="left"> 
                <j:code2Name definition="$CH_CHECKTYPE" code="form.applytype" />
                </td>
            </tr> 
            <tr>
                <td align="right"><s:text name="appath"/>:&nbsp</td>
                <td align="left" colspan="3"> 
                	<a	href='<%=contextPath%>/channel/checkedapply/checkedapply_download.do?file=<s:property value="form.appath"/>'
									target="_blank"><s:property value="form.appath"/></a>
                </td>
            </tr> 
            <tr>
                <td align="right"><s:text name="pptpath"/>:&nbsp</td>
                <td align="left" colspan="3"> 
                <a	href='<%=contextPath%>/channel/checkedapply/checkedapply_download.do?file=<s:property value="form.pptpath"/>'
									target="_blank"><s:property value="form.pptpath"/></a>
                </td>
            </tr>
           
             <tr>
             <td align="right"><s:text name="memo"/>:&nbsp</td>
                <td align="left" cssStyle="style_input" colspan="3">
                <s:property value="form.memo" /> 
                </td>
            
            </tr>
             <tr> 
                <td align="right"><s:text name="chkmemo"/>:&nbsp</td>
                <td align="left" colspan="3">
                <s:if test="CMD != WEB_CMD_SAVE">
                	<s:if test="form.status == 0">
                	 <textarea cssStyle="style_input" name="form.chkmemo" cols="64" rows="5"><s:property value="form.chkmemo" /></textarea> 
			        </s:if>
			        <s:else>
			        	<textarea cssStyle="style_input" name="form.chkmemo" cols="64" rows="5" ><s:property value="form.chkmemo" /></textarea>
			        </s:else>
		        </s:if>
		        <s:else>
			        	<textarea cssStyle="style_input" name="form.chkmemo" cols="64" rows="5" disabled="disabled"><s:property value="form.chkmemo" /></textarea>
				 </s:else>
                </td>
            </tr> 
            <tr>
             <td align="right">说明:&nbsp</td>
                <td align="left" cssStyle="style_input" colspan="4">
                      <font color=red>下面复选框中网点，选中则表示通过，未选中的记录表示不通过。</font>
                </td>
            
            </tr>
        </table>
    </div>
    
    

	
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style">
            <tr class="table_style_head">
            	<td title="<s:text name="list_title_select"/>">
					<input type="checkbox" name="allbox" onclick="checkAll();" checked="true"
						class="table_checkbox"
						<s:if test="form.cbFlag != true "> disabled="true" </s:if>
						>
				</td>
                <td>
                    <s:text name="applyno"/>              
                </td>
                <td>
                    <s:text name="city2"/>              
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
                  	申请类型
                </td>
                <td>
                	审核状态
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
					 <td>
					 	<input type="checkbox" name="param._selectitem" checked="true"
							value="<s:property value="seq"/>" onclick="checkOne();"
							<s:if test="form.cbFlag != true "> disabled="true" </s:if>
							>
					 </td>
                	 <td><s:property value="applyno" /></td>
                     <td><j:code2Name code="cityid" definition="#CITYCOMPANY" /></td>
                     <td><j:code2Name code="wtype" definition="$CH_WTYPE"/></td>
                     <td><j:code2Name code="chainhead" definition="#WAYIDINFO"/></td>
                     <td><s:property value="wayname" /></td>
                     <td><s:property value="wayid" /></td>
                     <td><s:property value="address" /></td>
                     <td><j:code2Name code="buztypecode" definition="$CH_BUZTYPE" /></td>
                     <td><j:code2Name code="chktype" definition="$CH_ASSESSMTHD" /></td>
                     <td><j:code2Name code="starlevel" definition="$CH_STARLEVEL" /></td>
                     <td><j:code2Name definition="$CH_CHECKTYPE" code="applytype" /></td>
                     <td>
                        <s:if test="form.APPSTATUS_MULTI">
		                  <j:code2Name definition="$CH_WAYSTATUS_GZ" code="waystatus" /> 
	                    </s:if>
	                    <s:else>
	                      <j:code2Name code="waystatus" definition="$CH_WAYSTATUS" />
	                    </s:else>
                     </td>
                 </tr>
             </s:iterator>
        </table>
        </div>
    </div>
    <div class="table_div">
		<%@ include file="/common/pageNav.jsp"%>
   	</div>
    
    <div class="table_div">
		<table class="table_button_list2">
			<tr>
				<td>
                	<s:i18n name="public">               	
                	<s:if test="CMD != WEB_CMD_SAVE">
                	<s:if test="form.cbFlag == true ">
                	 <input type="submit" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        
                        value="提交">
			        </s:if>
			        <s:else>
			        	<input type="submit" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="提交" disabled="true">
			        </s:else>
		        </s:if>
		        <s:else>
		        	<input type="submit" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="提交" disabled="true">
				 </s:else>
                      <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/waychecked_list.do')">
                   </s:i18n>
				</td>
			</tr>
		</table>
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
		addfield('param._ne_applyno', '<s:text name="applyno"/>', 'f', true, '14');
		addfield('param._se_cityid', '<s:text name="cityid"/>', 'c', true, '3'); 
		addfield('param._se_applytype', '<s:text name="applytype"/>', 'c', true, '2');
		
		var item = $(":radio:checked");  
		var len=item.length;  
		if(len <= 0){  
			alert("请选择处理类型！");
		  return false;
		}  
		return checkval(window);
	}
</script>
