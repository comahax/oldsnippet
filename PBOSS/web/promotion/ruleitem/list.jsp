<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%@ taglib prefix="j" uri="/jop-tags" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        
        //��дɾ������
        function doDelete(str, str1) {
        	//�Ƿ�ѡ��Դ���ݱ�ʶ
	    	var sourceFlag = false;
	    	var hasSource = "0";
	    	$(".selectitem").each(function(i){
				if(this.checked)
				{
					if(this.datatype=="0")
					{
						sourceFlag = true;
						return;
					}
				}
			});
			
			//�������Դ����
			if(sourceFlag)
			{
				hasSource = "1";
				msgConfirmDelete = "ɾ��Դ���ݻ�ɾ�������Ļ�׼���ݣ�ȷ��Ҫɾ����";
			}
        
		    var TO = true;
		    var sis = formList.all("param._selectitem");
		    if (forincheck(TO,sis,msgConfirmDelete)){
		    	formList.action = contextPath + "/promotion/ruleitem_delete.do?form.hasSource=" + hasSource + "&pk=" + str + "&pk1=" + str1;
		    	formList.submit();    	
		    }  
		}
		
		function doNew(str) {
   		 	formList.action ="<%=contextPath%>/promotion/ruleitem_new.do?pk=" + str;
   			formList.submit();
		}
		
		function doQuery(str, str1){
			formList.action ="<%=contextPath%>/promotion/ruleitem_list.do?pk=" + str + "&pk1=" + str1;
			formList.submit();
		}
		
		function doReturn(str, str1){
			formList.action ="<%=contextPath%>/promotion/ppzlnrule_list.do?param._pk=" + str + "&isActive=" +str1;
			formList.submit();
		}
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="/promotion/ruleitem_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//����Ŀؼ���Action�ṩ���ݣ�������ҳ%>
    <aa:zone name="hiddenZone"><s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
   	<s:hidden name="form.ruleid"/>
   	<s:hidden name="form.pid"/>
   	<s:hidden name="form.isEnabled" />
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/></aa:zone>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="promotion"/> </span>
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
            	<td align="center"><s:text name="itemid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_itemid" />
                </td>
                <td align="center"><s:text name="datatype"/>:</td>
                <td align="left">
                	<j:selector definition="$CH_DATATYPE" name="param._se_datatype"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery(document.all['form.ruleid'].value, document.all['form.pid'].value)">
                	<s:if test="form.isEnabled=='isActive'">
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew(document.all['form.pid'].value)" disabled="true">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete(document.all['form.ruleid'].value, document.all['form.pid'].value)" disabled="true">
                    </s:if>
                    <s:else>
                    	 <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew(document.all['form.pid'].value)">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete(document.all['form.ruleid'].value, document.all['form.pid'].value)">
                    </s:else>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_6" onmouseover="buttonover(this);" 
                    	onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="���ط�������" onclick="doReturn(document.all['form.pid'].value,document.all['form.isEnabled'].value)">
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
                <td width="15px" title="<s:text name="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();"/>
                </td>
                </s:i18n>
                <td>
                    <j:orderByImg href="javascript:doOrderby('itemid')"><s:text name="itemid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('ruleid')"><s:text name="ruleid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('optexpression')"><s:text name="optexpression"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('datatype')"><s:text name="datatype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('filtermode')"><s:text name="filtermode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('matching')"><s:text name="matching"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- ���������á�|������� --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="itemid"/>" datatype="<s:property value="datatype"/>" class="selectitem" onclick="checkOne();">
                     </td>
                     <td>
                     	<s:property value="itemid"/>
					 </td>
                     <td><s:property value="ruleid" /></td>
                     <td><s:property value="optexpression" /></td>
                     <td><j:code2Name definition="$CH_DATATYPE" code="${datatype}"/></td>
                     <td><j:code2Name definition="FILTERMODE" code="${filtermode}"/></td>
                     <td><s:property value="matching" /></td>
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
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
</body>
</html>
