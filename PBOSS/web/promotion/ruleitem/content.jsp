<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="aa" uri="http://ajaxanywhere.sourceforge.net/" %>

<%
	String pk = request.getParameter("pk");
 %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
    	//�����֤
    	function ev_checkval() {
            addfield('form.itemid', '<s:text name="itemid"/>', 'f', true, 10);
			addfield('form.ruleid', '<s:text name="ruleid"/>', 'f', true, 6);
			addfield('form.optexpression', '<s:text name="optexpression"/>', 'c', true, 64);
			addfield('form.datatype', '<s:text name="datatype"/>', 'c', true, 32);
			addfield('form.filtermode', '<s:text name="filtermode"/>', 'c', true, 32);
			addfield('form.matching', '<s:text name="matching"/>', 'c', true, 64);
			
			if($("#expType").val()=="1")
			{
				addfield('form.elmtinst_1_1', 'Ԫ��ʵ��1', 'c', false, 10);
			}
			
			if($("#expType").val()=="2")
			{
				addfield('form.elmtinst_2_1', 'Ԫ��ʵ��1', 'c', false, 10);
				addfield('form.elmtinst_2_2', 'Ԫ��ʵ��2', 'c', false, 10);
			}
			
			if($("#expType").val()=="3")
			{
				addfield('form.elmtinst_3_1', 'Ԫ��ʵ��1', 'c', false, 10);
				addfield('form.elmtinst_3_2', 'Ԫ��ʵ��2', 'c', false, 10);
				addfield('form.param_3', 'n', 'f', false, 10);
			}
			
			if($("#expType").val()=="4")
			{
				addfield('form.elmtinst_4_1', 'Ԫ��ʵ��1', 'c', false, 10);
				addfield('form.elmtinst_4_2', 'Ԫ��ʵ��2', 'c', false, 10);
				addfield('form.param_4', 'n', 'f', false, 10);
			}
			
			if($("#expType").val()=="5")
			{
				addfield('form.param_5', '���ʽ', 'c', false, 256);
			}
			
			//δ��ӹ�������ʱ����ʾ������
			if($("#hasSource").val()=="1")
			{
				if($("#filTable .source").length==0)
				{
					alert("����ӹ�������");
					return;
				}
			}
            return checkval(window);
        }
        
        function doReturn(str, str1) {
        
   		 	formItem.action ="<%=contextPath%>/promotion/ruleitem_list.do?pk="+str + "&pk1=" + str1;
   			formItem.submit();
		}
        
        //�Զ���ص�����������ˢ�¹�����������
    	ajaxAnywhere.onAfterResponseProcessing = nativeCallback;
    	function nativeCallback()
    	{
			var columnsinfo = $("#columnsinfo").val();
			var columnArray = columnsinfo.split("|");
			
			//���鳤�ȴ���1ʱ��split���������һ��Ԫ��Ϊ��
			var length = columnArray.length;
			if(columnArray.length>1)length = length-1;
 				
			//��̬���ɻ�׼�����ֶ�
			var str = "<select id=\"normSel\">";
   			for(var i=0; i<length; i++)
   			{
   				str = str + "<option value=\"" + columnArray[i] + "\">" + columnArray[i] + "</option>";
   			}
   			str = str + "</select>";
   			$("#normTd").html(str);
    	}
    	
    	//��̬���ɻ�׼�����ֶ�
        function getNormCols()
        {
	        ajaxAnywhere.submitByURL(contextPath+"/promotion/ruleitem_refresh.do");
        }

        //���ݲ�ͬ���ʽ������ʾ��ͬ�Ŀ�
        function expDisplay()
		{
			var index = parseInt($("#expType").val());
			for(var i=1; i<6; i++)
			{
				if(i==index)
				{
	        		$("#expTable"+i).show();
				}
				else
				{
	        		$("#expTable"+i).hide();
				}
			}
		}
        
        //������Ԫ��ʵ�����ڣ������������
        function eleNew(obj)
        {
        	var url = contextPath +"/promotion/elmtinst_new.do?form.type=SELECT";
        	var instid = window.showModalDialog(url, obj, "dialogWidth:700px; dialogHeight:600px; status:no;resizable:yes;");
        	var instidText = $(obj).parents("td").eq(0).children().eq(0);
        	instidText.val(instid);
        	instidText.focus();
        	window.focus();
        }
        
        //������������
        function filNew()
        {
        	var sourceVal = $("#sourceSel").val();
        	var normVal = $("#normSel");
        	if(normVal.length==0 || normVal.val()=="")
        	{
        		alert("��׼���ݲ���Ϊ��");
        		return;
        	}
        	
        	var normVal = $("#normSel").val();
        	var str = "<tr class=\"table_style_content\" align=\"center\" onMouseMove=\"this.bgColor='F0F5F9'\" onMouseOut=\"this.bgColor='#ffffff'\"><td>" + sourceVal + "</td><td>" + normVal + "</td><td><input type=\"button\" value=\"ɾ��\" class=\"button_Delete\" onclick=\"filDelete(this)\">"
						+ "<input type=\"hidden\" name=\"form.source\" class=\"source\" value=\"" + sourceVal + "\" />"
						+ "<input type=\"hidden\" name=\"form.norm\" value=\"" + normVal + "\" /></td></tr>";
        	$("#filTable").append(str); 
        }
        
        //ɾ����������
        function filDelete(obj)
        {
        	$(obj).parents("tr").eq(0).remove();
        }

        //��ʾ��������
    	function filShow()
    	{
    		$("#filHead").show();
       		$("#filTable").show();
       		$("#filSpan").show();
    	}
    	
        //��ʼ��
        $(document).ready(function(){
        	//��ʾ��������
        	if($("#hasSource").val()=="0")
        	{
        		$("#sourceSpan").show();
        		$("#normSpan").hide();
        	}
        	else if($("#hasSource").val()=="1")
        	{
        		$("#sourceSpan").hide();
        		$("#normSpan").show();
        	}
        
        	//��ʾ���ʽ��
			expDisplay();
			
			//������׼����ʱ����ʾ���˷�ʽ
			if($("#hasSource").val()=="1")
			{
				//�趨Ĭ�Ϲ��˷�ʽ
	        	var hasChecked = false;
	        	$(".filtermode").each(function(i){
	   				if(this.checked)hasChecked = true;
	 			}); 
				if(!hasChecked)$(".filtermode").eq(0).attr("checked",true);
			
	        	//��׼���ݳ�ʼ��
	        	filInit();
	        	//��ʾ��������
    			filShow();
			}
			
			//��ʼ������
			$("#expDiv .params").each(function(i){
				$(this).val("1");
			});
			
			//��focusout����
			if($("#hasSource").val()=="1")
			{
				$("#expDiv .elmtinst").each(function(i){
					$(this).blur(function(){
						getNorm();
					});
				});
			}
		});
		
		//��ʼ����������
        function filInit()
        {
        	var matching = $("#matching").val();
        	var str = "";
        	var match = new Array(2);
        	if(matching)
        	{
        		var expArray = matching.split(";");
        		//expArray�������һ��Ԫ��Ϊ��
        		for(var i=0; i<expArray.length-1; i++)
        		{
        			match = expArray[i].split("=");
        			str = str + "<tr class=\"table_style_content\" align=\"center\" onMouseMove=\"this.bgColor='F0F5F9'\" onMouseOut=\"this.bgColor='#ffffff'\"><td>" + match[0] + "</td><td>" + match[1]
							+ "<input type=\"hidden\" name=\"form.resource\" value=\"" + match[0] + "\" />"
							+ "<input type=\"hidden\" name=\"form.norm\" value=\"" + match[1] + "\" /></td></tr>";
        		}
        	}
        	$("#filTable").append(str); 
        }
        
        function getNorm()
        {
        	var expType = $("#expType").val();
        	if(expType=="1")
        	{
        		if($("#elmtinst_1_1").val()!="")
        		{
        			getNormCols();
        		}
        	}
        	else if(expType=="2")
        	{
        		if($("#elmtinst_2_1").val()!="" && $("#elmtinst_2_2").val()!="")
        		{
        			getNormCols();
        		}
        	}
        	else if(expType=="3")
        	{
        		if($("#elmtinst_3_1").val()!="" && $("#elmtinst_3_2").val()!="")
        		{
        			getNormCols();
        		}
        	}
        	else if(expType=="4")
        	{
        		if($("#elmtinst_4_1").val()!="" && $("#elmtinst_4_2").val()!="")
        		{
        			getNormCols();
        		}
        	}
        	else if(expType=="5")
        	{
        		if($("#param_5").val()!="")
        		{
        			getNormCols();
        		}
        	}
        }
    </script>
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="ruleitem_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">	
    <s:hidden name="CMD" id="cmd"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
	
	<s:hidden name="form.hasSource" id="hasSource"/>
	<s:hidden name="form.itemid"/>
	<s:hidden name="form.ruleid"/>
	<s:hidden name="form.optexpression"/>
	<s:hidden name="form.matching" id="matching"/>
	<input type="hidden" name="pk" value="<%=pk%>"/>
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

	<div class="error_text" >
		<table class="error_text">
			<s:actionerror /><s:actionmessage/>
		</table>
	</div>
	
	<div class="table_div">
        <table class="table_normal">
        	<tr>
                <td align="right" width="20%">���ʽ����:&nbsp</td>
                <td align="left" width="30%">
                	<s:select list="#{'1':'����','2':'��','3':'������','4':'����','5':'�Զ���'}" name="form.expType" id="expType" onchange="expDisplay();loadforiframe();"/>
                </td>
                <td align="right" width="20%"><s:text name="datatype"/>:&nbsp</td>
                <td align="left" width="30%">
<!--				<j:selector definition="$CH_DATATYPE" id="datatype" name="form.datatype" onchange="filDisplay()"/>-->
					<span id="sourceSpan" style="display:none">&nbsp;&nbsp;<j:code2Name definition="$CH_DATATYPE" code="0"/></span>
					<span id="normSpan" style="display:none">&nbsp;&nbsp;<j:code2Name definition="$CH_DATATYPE" code="1"/></span>
					<span id="filSpan" style="display: none">
						<br>���˷�ʽ
						<s:radio list="#{'0':'����','1':'ȥ��'}" name="form.filtermode" cssClass="filtermode"></s:radio>
					</span>
                </td>
            </tr>

    	</table>
    </div>
    
    <div class="table_div" id="expDiv">
        <table class="table_normal" id="expTable1" style="display: none">
        	<tr colspan=2>������ϸ���ʽ</tr>
        	<tr>
                <td align="right" width="30%">���ʽ:&nbsp</td>
                <td align="left">
                	Ԫ��ʵ��1
                </td>
            </tr>
            <tr>
                <td align="right">Ԫ��ʵ��1:&nbsp</td>
                <td align="left">
                	<s:textfield name="form.elmtinst_1_1" id="elmtinst_1_1" cssClass="elmtinst"></s:textfield>
	 				<input type="button" name="form.elmtinst_1_1_button" class="picker_button"
 						value="..." onclick="javascript:openPicker(this,'#ELETINST','');window.focus()"/>
                	<input type="button" value="��" class="picker_button" onclick="eleNew(this)" />
                	<font color=red>*</font>
                </td>
            </tr>
    	</table>
    	
        <table class="table_normal" id="expTable2">
        	<tr colspan=2>������ϸ���ʽ</tr>
        	<tr>
                <td align="right" width="30%">���ʽ:&nbsp</td>
                <td align="left">
                	Ԫ��ʵ��1-Ԫ��ʵ��2
                </td>
            </tr>
            <tr>
                <td align="right">Ԫ��ʵ��1:&nbsp</td>
                <td align="left">
                	<s:textfield name="form.elmtinst_2_1" id="elmtinst_2_1" cssClass="elmtinst"></s:textfield>
	 				<input type="button" name="form.elmtinst_2_1_button" class="picker_button"
 						value="..." onclick="javascript:openPicker(this,'#ELETINST','');window.focus()"/>
                	<input type="button" value="��" class="picker_button" onclick="eleNew(this)" />
                	<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right">Ԫ��ʵ��2:&nbsp</td>
                <td align="left">
                	<s:textfield name="form.elmtinst_2_2" id="elmtinst_2_2" cssClass="elmtinst"></s:textfield>
	 				<input type="button" name="form.elmtinst_2_2_button" class="picker_button"
 						value="..." onclick="javascript:openPicker(this,'#ELETINST','');window.focus()"/>
                	<input type="button" value="��" class="picker_button" onclick="eleNew(this)" />
                	<font color=red>*</font>
                </td>
            </tr>
    	</table>
    	
        <table class="table_normal" id="expTable3">
        	<tr colspan=2>������ϸ���ʽ</tr>
        	<tr>
                <td align="right" width="30%">���ʽ:&nbsp</td>
                <td align="left">
                	(Ԫ��ʵ��1-Ԫ��ʵ��2)/Ԫ��ʵ��2>n
                </td>
            </tr>
            <tr>
                <td align="right">Ԫ��ʵ��1:&nbsp</td>
                <td align="left">
                	<s:textfield name="form.elmtinst_3_1" id="elmtinst_3_1" cssClass="elmtinst"></s:textfield>
	 				<input type="button" name="form.elmtinst_3_1_button" class="picker_button"
 						value="..." onclick="javascript:openPicker(this,'#ELETINST','');window.focus()"/>
                	<input type="button" value="��" class="picker_button" onclick="eleNew(this)" />
                	<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right">Ԫ��ʵ��2:&nbsp</td>
                <td align="left">
                	<s:textfield name="form.elmtinst_3_2" id="elmtinst_3_2" cssClass="elmtinst"></s:textfield>
	 				<input type="button" name="form.elmtinst_3_2_button" class="picker_button"
 						value="..." onclick="javascript:openPicker(this,'#ELETINST','');window.focus()"/>
                	<input type="button" value="��" class="picker_button" onclick="eleNew(this)" />
                	<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right">n:&nbsp</td>
                <td align="left">
                	<s:textfield name="form.param_3" cssClass="params" cssStyle="style_input"/>
                	<font color=red>*</font>
                </td>
            </tr>
    	</table>
    	
    	<table class="table_normal" id="expTable4">
    		<tr colspan=2>������ϸ���ʽ</tr>
        	<tr>
                <td align="right" width="30%">���ʽ:&nbsp</td>
                <td align="left">
                	Ԫ��ʵ��1/Ԫ��ʵ��2>n
                </td>
            </tr>
            <tr>
                <td align="right">Ԫ��ʵ��1:&nbsp</td>
                <td align="left">
                	<s:textfield name="form.elmtinst_4_1" id="elmtinst_4_1" cssClass="elmtinst"></s:textfield>
	 				<input type="button" name="form.elmtinst_4_1_button" class="picker_button"
 						value="..." onclick="javascript:openPicker(this,'#ELETINST','');window.focus()"/>
                	<input type="button" value="��" class="picker_button" onclick="eleNew(this)" />
                	<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right">Ԫ��ʵ��2:&nbsp</td>
                <td align="left">
                	<s:textfield name="form.elmtinst_4_2" id="elmtinst_4_2" cssClass="elmtinst"></s:textfield>
	 				<input type="button" name="form.elmtinst_4_2_button" class="picker_button"
 						value="..." onclick="javascript:openPicker(this,'#ELETINST','');window.focus()"/>
                	<input type="button" value="��" class="picker_button" onclick="eleNew(this)" />
                	<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right">n:&nbsp</td>
                <td align="left">
                	<s:textfield name="form.param_4" cssClass="params" cssStyle="style_input"/>
                	<font color=red>*</font>
                </td>
            </tr>
    	</table>
    	
    	<table class="table_normal" id="expTable5">
    		<tr colspan=2>������ϸ���ʽ</tr>
        	<tr>
                <td align="right" width="30%">���ʽ:&nbsp</td>
                <td align="left">
                	<s:textfield name="form.param_5" id="param_5" cssStyle="width:400px" cssClass="elmtinst"/>
                	<font color=red>*</font>
                </td>
            </tr>
    	</table>
    	
    	<aa:zone name="refreshTable">
	         <input type="hidden" id="columnsinfo" value="<%=request.getAttribute("columnsinfo")==null?"":(String)request.getAttribute("columnsinfo")%>"/>
    	</aa:zone>	
    	<table class="table_normal" id="filHead" style="display: none">
    		<tr colspan=2>��������</tr>
            <tr>
                <td align="right" width="20%">Դ�����ֶ�:&nbsp</td>
                <td align="left" width="20%" id="sourceTd">
                	<s:if test="form.sourceMap!=null">
                		<s:select id="sourceSel" list="form.sourceMap" theme="simple" listKey="key" listValue="value" />
                	</s:if>
                </td>
                <td align="right" width="20%">��׼�����ֶ�:&nbsp</td>
                <td align="left" width="20%" id="normTd">
                	&nbsp;
                </td>
                
                <s:if test="CMD == WEB_CMD_NEW">
	                <td align="right" width="20%">
	                 	<input type="button" value="���" class="button_New" onclick="filNew(this)">
	                </td>
                </s:if>
            </tr>
    	</table>
    	
    	
    	<table class="table_normal" id="filTable" style="display: none">
            <tr class="table_style_head">
                <td>Դ�����ֶ�</td>
                <td>��׼�����ֶ�</td>
                <s:if test="CMD == WEB_CMD_NEW">
                	<td width="10%">ɾ��</td>
                </s:if>
            </tr>
        </table>
    </div>
	
    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="doSave('/promotion/ruleitem_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn(document.all['form.ruleid'].value, document.all['pk'].value)">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
