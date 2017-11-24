<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
 <base target="baseExportThis" />
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
		
		function doExport(){
			formList.action="<%=contextPath%>/sales/hisactivetol_exportExcelDetail.do";
    		formList.submit();
		}
		</script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="hisactivetol_showDetail.do" key="formList" cssStyle="formList" theme="simple">
<iframe id="baseExportThis" name="baseExportThis" height="0px" width="0px"></iframe>
	<%//下面的控件给Action提供数据，用来分页%>
	<aa:zone name="hiddenZone">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
	</aa:zone>
    
    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
                	<s:i18n name="public">
                	<input type="button" class="button_4" onmouseover="buttonover(this);"
			            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			            value="导出TXT" onClick="doExport();"/>
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
                    序号
                </td>
                <td>
                    合作商编码     
                </td>
                 <td>
                    合作商名称                 
                </td>
                <td>
                    品牌             
                </td>
                <td>
                     号码                
                </td>
                <td>
                    激活时间                 
                </td>
               
            </tr>
            <s:iterator value="dp.datas" status="status">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
						<s:property value="#status.count" />
					 </td>
					 <td>
                         <s:property value="wayid" />
					 </td>
                     <td>
                         <j:code2Name definition="#WAYIDINFO" code="wayid" />
					 </td>
                     <td>
                        <j:code2Name definition="$FX_SMPBRAND" code="brand"/>
					 </td>
					 <td>
                        <s:property value="comresid" />
					 </td>
					 <td>
                        <s:property value="activetime" />
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
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();  
	ajaxAnywhere.formURL = formList.action;
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
