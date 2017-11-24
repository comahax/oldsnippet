<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title>�׿���װ��ӡ</title>
    <object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0></object>
    <script language="javascript" src="<%=contextPath%>/js/LodopFuncs.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
    	getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM'));
    	
        function ev_check() {
            addfield('param._se_batchno', '��Ʒ����', 'c', false, '32');
            return checkval(window);
        }
        function doPreparedPrint(cmdQuery) {
        	
	        	if(cmdQuery != null && cmdQuery !="") {
	        		formList.action = contextPath + cmdQuery;
	        	}
	       		if(document.formList.onsubmit == null || document.formList.onsubmit())
	       			document.formList.submit();
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="compack_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">

	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="resource"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h">�׿���װ��ӡ</span>
			<%--<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>--%>
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
        		<td align="right">��Ʒ����:&nbsp</td>
                <td align="left" colspan="2">
					<s:textfield cssStyle="style_input" name="param._se_batchno" maxlength="32"/>
					<font color=red>*</font>
                </td>
        	</tr>
        	<tr>
        		<td align="right">��Ʒ��ʶ:&nbsp;</td>
                <td align="left" colspan="2">
                    <j:Comidtree name="param._ne_comid" condition="comclassid:3;" definition="#COMSYSTEM" nameOnly="true" readonly="true"/>
                </td>
        	</tr>
        	<tr>
        		<td align="right">��Դ��������:&nbsp;</td>
                <td align="left" colspan="2">
                    <s:textfield cssStyle="style_input" name="param._se_wayid" readonly="true"/><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_wayid');this.value='...';" />
                </td>
        	</tr>
            <tr>
                <td align="right">���:&nbsp;</td>
                <td align="left">
                	<s:textfield cssStyle="style_input" name="param._ssw_boxnum"/>
                </td>
                <td align="left">
                    <input type="button" id="btnTrunkPrint" name="btnTrunkPrint" class="button_4" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="��Ŵ�ӡ" onclick="doPreparedPrint('/resource/comressmp_printTrunkOrBox.do?mode=trunk')">
                    <input type="button" id="btnBoxPrint" name="btnBoxPrint" class="button_4" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="�кŴ�ӡ" onclick="doPreparedPrint('/resource/comressmp_printTrunkOrBox.do?mode=box')">
                    <input type="button" id="btnPackPrint" name="btnPackPrint" class="button_4" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="���Ŵ�ӡ" onclick="doPreparedPrint('/resource/comressmp_printPackage.do')">
                </td>
            </tr>
        </table>
    </div>
    
</s:form>
</div>
</body>
</html>
