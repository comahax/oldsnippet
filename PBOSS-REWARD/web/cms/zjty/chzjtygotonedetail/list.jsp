<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title>ȫ��ͨ���������ϸ</title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_rewardreporttime', '�·�', 'c', false, '14');
            return checkval(window);
        }
        
        function doExport(url){
			formList.action = contextPath + url + "?CMD=EXCEL";
  			formList.submit();
  			formList.action="<%=contextPath%>/cms/zjty/chzjtygotonedetail.do?CMD=LIST";
		}
		
		function doDele(url) {
			ev_check();
			var month = document.getElementById("_se_rewardreporttime").value;
			var msg = "ȷ��Ҫɾ��" + month + "�µļ�¼��"
			if (!confirm(msg)) {
				return false;
			}
			formList.action = contextPath + url + "?CMD=DELETE";
  			formList.submit();
  			formList.action="<%=contextPath%>/cms/zjty/chzjtygotonedetail.do?CMD=LIST";
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/zjty/chzjtygotonedetail.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize" value="20"/>
    <input type="hidden" name="query" value="true">
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/chzjtygotonedetail/ChzjtygotonedetailForm']}"/>

    <!--##################################��ӱ�������##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>ȫ��ͨ���������ϸ</td>
    	</tr>
    </table>
    </div>
    <div class="table_div">	
   		 <table width="100%" class="error_text">
    		<html:errors/><s:Msg />
    	</table>
    </div>
	<div class="table_div">
        <table class="form_table">
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" >�·�:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_rewardreporttime" styleId="_se_rewardreporttime" onclick="WdatePicker({dateFmt:'yyyyMM', maxDate:'%y {%M}'})"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><c:if test="${protoken}">����:</c:if></td>
                <td width="30%" class="form_table_left">
                    <c:if test="${protoken}">
                    	<html:select property="_sk_city">
							<s:Options definition="#CITYNAME_ZH_CN"/>
						</html:select>
                    </c:if>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                    <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_search"/>" />
                    <input type="button" class="button_4" onmouseover="buttonover(this);" 
            			onclick="doExport('/cms/zjty/chzjtygotonedetail.do')" 
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_export_excel"/>" />
                    <c:if test="${!protoken}">
                    <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_delete"/>"
                        onClick="doDele('/cms/zjty/chzjtygotonedetail.do')">
                    </c:if>
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
	    		<td colspan="4">һ��������Ϣ</td>
				<td colspan="79">����ҵ������Ϣ���¶ȣ�</td>
				<td colspan="8">������λ���</td>
				<td colspan="79">�ġ�����ܶ�</td>
				<td colspan="4">�塢����ϵ��</td>
				<td rowspan="3">ȫʡͳһ��������ܶ�</td>
	    	</tr>
	    	<tr class="table_style_head">
	    		<td rowspan="2">������</td>
				<td rowspan="2">����</td>
				<td rowspan="2">Ӫҵ������</td>
				<td rowspan="2">�·�</td>
				<td colspan="13">��1����ѡ��ѡ58�����ײ͡�58�����ײ�</td>
				<td colspan="13">��2��ѡ88�����ײͻ�88�����ײ�</td>
				<td colspan="13">��3��ѡ128�����ײͻ�128�����ײ�</td>
				<td colspan="13">��4��158�����ײ�</td>
				<td colspan="13">��5��ѡ188�����ײ�</td>
				<td colspan="13">��6��ѡ288��388��588��888�����ײ�</td>
				<td rowspan="2">(7)Ԥ����תȫ��ͨ</td>
				<td>��ѡ��ѡ58��88��128��158��188��288��388��588��888�����ײͣ�ѡ58��88��128�����ײ�</td>
				<td colspan="6">���������׼Ϊ�ͻ���Ƿ����������� 12 �����ײͷ��õ� 10% �����ް��� 268 Ԫ�ײͷⶥ��</td>
				<td rowspan="2">��7��Ԥ����תȫ��ͨ</td>
				<td colspan="13">��1����ѡ��ѡ58�����ײ͡�58�����ײ�</td>
				<td colspan="13">��2��ѡ88�����ײͻ�88�����ײ�</td>
				<td colspan="13">��3��ѡ128�����ײͻ�128�����ײ�</td>
				<td colspan="13">��4��158�����ײ�</td>
				<td colspan="13">��5��ѡ188�����ײ�</td>
				<td colspan="13">��6��ѡ288��388��588��888�����ײ�</td>
				<td rowspan="2">��7��Ԥ����תȫ��ͨ</td>
				<td colspan="4">����ϵ��</td>
	    	</tr>
	        <tr class="table_style_head">
				<td>�������</td>
				<td>�������1</td>
				<td>�������2</td>
				<td>�������3</td>
				<td>�������4</td>
				<td>�������5</td>
				<td>�������6</td>
				<td>�������7</td>
				<td>�������8</td>
				<td>�������9</td>
				<td>�������10</td>
				<td>�������11</td>
				<td>�������12</td>
				<td>�������</td>
				<td>�������1</td>
				<td>�������2</td>
				<td>�������3</td>
				<td>�������4</td>
				<td>�������5</td>
				<td>�������6</td>
				<td>�������7</td>
				<td>�������8</td>
				<td>�������9</td>
				<td>�������10</td>
				<td>�������11</td>
				<td>�������12</td>
				<td>�������</td>
				<td>�������1</td>
				<td>�������2</td>
				<td>�������3</td>
				<td>�������4</td>
				<td>�������5</td>
				<td>�������6</td>
				<td>�������7</td>
				<td>�������8</td>
				<td>�������9</td>
				<td>�������10</td>
				<td>�������11</td>
				<td>�������12</td>
				<td>�������</td>
				<td>�������1</td>
				<td>�������2</td>
				<td>�������3</td>
				<td>�������4</td>
				<td>�������5</td>
				<td>�������6</td>
				<td>�������7</td>
				<td>�������8</td>
				<td>�������9</td>
				<td>�������10</td>
				<td>�������11</td>
				<td>�������12</td>
				<td>�������</td>
				<td>�������1</td>
				<td>�������2</td>
				<td>�������3</td>
				<td>�������4</td>
				<td>�������5</td>
				<td>�������6</td>
				<td>�������7</td>
				<td>�������8</td>
				<td>�������9</td>
				<td>�������10</td>
				<td>�������11</td>
				<td>�������12</td>
				<td>�������</td>
				<td>�������1</td>
				<td>�������2</td>
				<td>�������3</td>
				<td>�������4</td>
				<td>�������5</td>
				<td>�������6</td>
				<td>�������7</td>
				<td>�������8</td>
				<td>�������9</td>
				<td>�������10</td>
				<td>�������11</td>
				<td>�������12</td>
				<td>�������</td>
				<td>��ѡ��ѡ58�����ײ͡�58�����ײ�</td>
				<td>ѡ88�����ײͻ�88�����ײ�</td>
				<td>ѡ128�����ײͻ�128�����ײ�</td>
				<td>158�����ײ�</td>
				<td>ѡ188�����ײ�</td>
				<td>ѡ288��388��588��888�����ײ�</td>
				<td>�������</td>
				<td>�������1</td>
				<td>�������2</td>
				<td>�������3</td>
				<td>�������4</td>
				<td>�������5</td>
				<td>�������6</td>
				<td>�������7</td>
				<td>�������8</td>
				<td>�������9</td>
				<td>�������10</td>
				<td>�������11</td>
				<td>�������12</td>
				<td>�������</td>
				<td>�������1</td>
				<td>�������2</td>
				<td>�������3</td>
				<td>�������4</td>
				<td>�������5</td>
				<td>�������6</td>
				<td>�������7</td>
				<td>�������8</td>
				<td>�������9</td>
				<td>�������10</td>
				<td>�������11</td>
				<td>�������12</td>
				<td>�������</td>
				<td>�������1</td>
				<td>�������2</td>
				<td>�������3</td>
				<td>�������4</td>
				<td>�������5</td>
				<td>�������6</td>
				<td>�������7</td>
				<td>�������8</td>
				<td>�������9</td>
				<td>�������10</td>
				<td>�������11</td>
				<td>�������12</td>
				<td>�������</td>
				<td>�������1</td>
				<td>�������2</td>
				<td>�������3</td>
				<td>�������4</td>
				<td>�������5</td>
				<td>�������6</td>
				<td>�������7</td>
				<td>�������8</td>
				<td>�������9</td>
				<td>�������10</td>
				<td>�������11</td>
				<td>�������12</td>
				<td>�������</td>
				<td>�������1</td>
				<td>�������2</td>
				<td>�������3</td>
				<td>�������4</td>
				<td>�������5</td>
				<td>�������6</td>
				<td>�������7</td>
				<td>�������8</td>
				<td>�������9</td>
				<td>�������10</td>
				<td>�������11</td>
				<td>�������12</td>
				<td>�������</td>
				<td>�������1</td>
				<td>�������2</td>
				<td>�������3</td>
				<td>�������4</td>
				<td>�������5</td>
				<td>�������6</td>
				<td>�������7</td>
				<td>�������8</td>
				<td>�������9</td>
				<td>�������10</td>
				<td>�������11</td>
				<td>�������12</td>
				<td>������ϵ��</td>
				<td>���ϵ��</td>
				<td>�ۺ�����ϵ��</td>
				<td>����ϵ��</td>
			</tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center">
                    <td><c:out value="${item.cooperauid}"/></td>
					<td><c:out value="${item.city}"/></td>
					<td><c:out value="${item.wayname}"/></td>
					<td><c:out value="${item.rewardreporttime}"/></td>
					<td><c:out value="${item.ywl58khcj}"/></td>
					<td><c:out value="${item.ywl58jlcj1}"/></td>
					<td><c:out value="${item.ywl58jlcj2}"/></td>
					<td><c:out value="${item.ywl58jlcj3}"/></td>
					<td><c:out value="${item.ywl58jlcj4}"/></td>
					<td><c:out value="${item.ywl58jlcj5}"/></td>
					<td><c:out value="${item.ywl58jlcj6}"/></td>
					<td><c:out value="${item.ywl58jlcj7}"/></td>
					<td><c:out value="${item.ywl58jlcj8}"/></td>
					<td><c:out value="${item.ywl58jlcj9}"/></td>
					<td><c:out value="${item.ywl58jlcj10}"/></td>
					<td><c:out value="${item.ywl58jlcj11}"/></td>
					<td><c:out value="${item.ywl58jlcj12}"/></td>
					<td><c:out value="${item.ywl88khcj}"/></td>
					<td><c:out value="${item.ywl88jlcj1}"/></td>
					<td><c:out value="${item.ywl88jlcj2}"/></td>
					<td><c:out value="${item.ywl88jlcj3}"/></td>
					<td><c:out value="${item.ywl88jlcj4}"/></td>
					<td><c:out value="${item.ywl88jlcj5}"/></td>
					<td><c:out value="${item.ywl88jlcj6}"/></td>
					<td><c:out value="${item.ywl88jlcj7}"/></td>
					<td><c:out value="${item.ywl88jlcj8}"/></td>
					<td><c:out value="${item.ywl88jlcj9}"/></td>
					<td><c:out value="${item.ywl88jlcj10}"/></td>
					<td><c:out value="${item.ywl88jlcj11}"/></td>
					<td><c:out value="${item.ywl88jlcj12}"/></td>
					<td><c:out value="${item.ywl128khcj}"/></td>
					<td><c:out value="${item.ywl128jlcj1}"/></td>
					<td><c:out value="${item.ywl128jlcj2}"/></td>
					<td><c:out value="${item.ywl128jlcj3}"/></td>
					<td><c:out value="${item.ywl128jlcj4}"/></td>
					<td><c:out value="${item.ywl128jlcj5}"/></td>
					<td><c:out value="${item.ywl128jlcj6}"/></td>
					<td><c:out value="${item.ywl128jlcj7}"/></td>
					<td><c:out value="${item.ywl128jlcj8}"/></td>
					<td><c:out value="${item.ywl128jlcj9}"/></td>
					<td><c:out value="${item.ywl128jlcj10}"/></td>
					<td><c:out value="${item.ywl128jlcj11}"/></td>
					<td><c:out value="${item.ywl128jlcj12}"/></td>
					<td><c:out value="${item.ywl158khcj}"/></td>
					<td><c:out value="${item.ywl158jlcj1}"/></td>
					<td><c:out value="${item.ywl158jlcj2}"/></td>
					<td><c:out value="${item.ywl158jlcj3}"/></td>
					<td><c:out value="${item.ywl158jlcj4}"/></td>
					<td><c:out value="${item.ywl158jlcj5}"/></td>
					<td><c:out value="${item.ywl158jlcj6}"/></td>
					<td><c:out value="${item.ywl158jlcj7}"/></td>
					<td><c:out value="${item.ywl158jlcj8}"/></td>
					<td><c:out value="${item.ywl158jlcj9}"/></td>
					<td><c:out value="${item.ywl158jlcj10}"/></td>
					<td><c:out value="${item.ywl158jlcj11}"/></td>
					<td><c:out value="${item.ywl158jlcj12}"/></td>
					<td><c:out value="${item.ywl188khcj}"/></td>
					<td><c:out value="${item.ywl188jlcj1}"/></td>
					<td><c:out value="${item.ywl188jlcj2}"/></td>
					<td><c:out value="${item.ywl188jlcj3}"/></td>
					<td><c:out value="${item.ywl188jlcj4}"/></td>
					<td><c:out value="${item.ywl188jlcj5}"/></td>
					<td><c:out value="${item.ywl188jlcj6}"/></td>
					<td><c:out value="${item.ywl188jlcj7}"/></td>
					<td><c:out value="${item.ywl188jlcj8}"/></td>
					<td><c:out value="${item.ywl188jlcj9}"/></td>
					<td><c:out value="${item.ywl188jlcj10}"/></td>
					<td><c:out value="${item.ywl188jlcj11}"/></td>
					<td><c:out value="${item.ywl188jlcj12}"/></td>
					<td><c:out value="${item.ywl288khcj}"/></td>
					<td><c:out value="${item.ywl288jlcj1}"/></td>
					<td><c:out value="${item.ywl288jlcj2}"/></td>
					<td><c:out value="${item.ywl288jlcj3}"/></td>
					<td><c:out value="${item.ywl288jlcj4}"/></td>
					<td><c:out value="${item.ywl288jlcj5}"/></td>
					<td><c:out value="${item.ywl288jlcj6}"/></td>
					<td><c:out value="${item.ywl288jlcj7}"/></td>
					<td><c:out value="${item.ywl288jlcj8}"/></td>
					<td><c:out value="${item.ywl288jlcj9}"/></td>
					<td><c:out value="${item.ywl288jlcj10}"/></td>
					<td><c:out value="${item.ywl288jlcj11}"/></td>
					<td><c:out value="${item.ywl288jlcj12}"/></td>
					<td><c:out value="${item.ywlmzonetogotone}"/></td>
					<td><c:out value="${item.dwkhcj}"/></td>
					<td><c:out value="${item.dw58cj}"/></td>
					<td><c:out value="${item.dw88cj}"/></td>
					<td><c:out value="${item.dw128cj}"/></td>
					<td><c:out value="${item.dw158cj}"/></td>
					<td><c:out value="${item.dw188cj}"/></td>
					<td><c:out value="${item.dw288cj}"/></td>
					<td><c:out value="${item.dwmzonetogotone}"/></td>
					<td><c:out value="${item.cjtotal58khcj}"/></td>
					<td><c:out value="${item.cjtotal58jlcj1}"/></td>
					<td><c:out value="${item.cjtotal58jlcj2}"/></td>
					<td><c:out value="${item.cjtotal58jlcj3}"/></td>
					<td><c:out value="${item.cjtotal58jlcj4}"/></td>
					<td><c:out value="${item.cjtotal58jlcj5}"/></td>
					<td><c:out value="${item.cjtotal58jlcj6}"/></td>
					<td><c:out value="${item.cjtotal58jlcj7}"/></td>
					<td><c:out value="${item.cjtotal58jlcj8}"/></td>
					<td><c:out value="${item.cjtotal58jlcj9}"/></td>
					<td><c:out value="${item.cjtotal58jlcj10}"/></td>
					<td><c:out value="${item.cjtotal58jlcj11}"/></td>
					<td><c:out value="${item.cjtotal58jlcj12}"/></td>
					<td><c:out value="${item.cjtotal88khcj}"/></td>
					<td><c:out value="${item.cjtotal88jlcj1}"/></td>
					<td><c:out value="${item.cjtotal88jlcj2}"/></td>
					<td><c:out value="${item.cjtotal88jlcj3}"/></td>
					<td><c:out value="${item.cjtotal88jlcj4}"/></td>
					<td><c:out value="${item.cjtotal88jlcj5}"/></td>
					<td><c:out value="${item.cjtotal88jlcj6}"/></td>
					<td><c:out value="${item.cjtotal88jlcj7}"/></td>
					<td><c:out value="${item.cjtotal88jlcj8}"/></td>
					<td><c:out value="${item.cjtotal88jlcj9}"/></td>
					<td><c:out value="${item.cjtotal88jlcj10}"/></td>
					<td><c:out value="${item.cjtotal88jlcj11}"/></td>
					<td><c:out value="${item.cjtotal88jlcj12}"/></td>
					<td><c:out value="${item.cjtotal128khcj}"/></td>
					<td><c:out value="${item.cjtotal128jlcj1}"/></td>
					<td><c:out value="${item.cjtotal128jlcj2}"/></td>
					<td><c:out value="${item.cjtotal128jlcj3}"/></td>
					<td><c:out value="${item.cjtotal128jlcj4}"/></td>
					<td><c:out value="${item.cjtotal128jlcj5}"/></td>
					<td><c:out value="${item.cjtotal128jlcj6}"/></td>
					<td><c:out value="${item.cjtotal128jlcj7}"/></td>
					<td><c:out value="${item.cjtotal128jlcj8}"/></td>
					<td><c:out value="${item.cjtotal128jlcj9}"/></td>
					<td><c:out value="${item.cjtotal128jlcj10}"/></td>
					<td><c:out value="${item.cjtotal128jlcj11}"/></td>
					<td><c:out value="${item.cjtotal128jlcj12}"/></td>
					<td><c:out value="${item.cjtotal158khcj}"/></td>
					<td><c:out value="${item.cjtotal158jlcj1}"/></td>
					<td><c:out value="${item.cjtotal158jlcj2}"/></td>
					<td><c:out value="${item.cjtotal158jlcj3}"/></td>
					<td><c:out value="${item.cjtotal158jlcj4}"/></td>
					<td><c:out value="${item.cjtotal158jlcj5}"/></td>
					<td><c:out value="${item.cjtotal158jlcj6}"/></td>
					<td><c:out value="${item.cjtotal158jlcj7}"/></td>
					<td><c:out value="${item.cjtotal158jlcj8}"/></td>
					<td><c:out value="${item.cjtotal158jlcj9}"/></td>
					<td><c:out value="${item.cjtotal158jlcj10}"/></td>
					<td><c:out value="${item.cjtotal158jlcj11}"/></td>
					<td><c:out value="${item.cjtotal158jlcj12}"/></td>
					<td><c:out value="${item.cjtotal188khcj}"/></td>
					<td><c:out value="${item.cjtotal188jlcj1}"/></td>
					<td><c:out value="${item.cjtotal188jlcj2}"/></td>
					<td><c:out value="${item.cjtotal188jlcj3}"/></td>
					<td><c:out value="${item.cjtotal188jlcj4}"/></td>
					<td><c:out value="${item.cjtotal188jlcj5}"/></td>
					<td><c:out value="${item.cjtotal188jlcj6}"/></td>
					<td><c:out value="${item.cjtotal188jlcj7}"/></td>
					<td><c:out value="${item.cjtotal188jlcj8}"/></td>
					<td><c:out value="${item.cjtotal188jlcj9}"/></td>
					<td><c:out value="${item.cjtotal188jlcj10}"/></td>
					<td><c:out value="${item.cjtotal188jlcj11}"/></td>
					<td><c:out value="${item.cjtotal188jlcj12}"/></td>
					<td><c:out value="${item.cjtotal288khcj}"/></td>
					<td><c:out value="${item.cjtotal288jlcj1}"/></td>
					<td><c:out value="${item.cjtotal288jlcj2}"/></td>
					<td><c:out value="${item.cjtotal288jlcj3}"/></td>
					<td><c:out value="${item.cjtotal288jlcj4}"/></td>
					<td><c:out value="${item.cjtotal288jlcj5}"/></td>
					<td><c:out value="${item.cjtotal288jlcj6}"/></td>
					<td><c:out value="${item.cjtotal288jlcj7}"/></td>
					<td><c:out value="${item.cjtotal288jlcj8}"/></td>
					<td><c:out value="${item.cjtotal288jlcj9}"/></td>
					<td><c:out value="${item.cjtotal288jlcj10}"/></td>
					<td><c:out value="${item.cjtotal288jlcj11}"/></td>
					<td><c:out value="${item.cjtotal288jlcj12}"/></td>
					<td><c:out value="${item.cjtotalmzonetogotone}"/></td>
					<td><c:out value="${item.manageexamine}"/></td>
					<td><c:out value="${item.vetocoefficient}"/></td>
					<td><c:out value="${item.ordercoefficient}"/></td>
					<td><c:out value="${item.campaigncoefficient}"/></td>
					<td><c:out value="${item.totalreward}"/></td>
                 </tr>
             </c:forEach>
        </table>
     </div>
   </div>

   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
</html:form>
</div>
</body>
</html>
