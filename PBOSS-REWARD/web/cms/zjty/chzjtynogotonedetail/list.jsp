<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title>��ȫ��ͨ���������ϸ</title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_rewardreporttime', '�·�', 'c', false, '14');
            return checkval(window);
        }
        
        function doExport(url){
			formList.action = contextPath + url + "?CMD=EXCEL";
  			formList.submit();
  			formList.action="<%=contextPath%>/cms/zjty/chzjtynogotonedetail.do?CMD=LIST";
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
  			formList.action="<%=contextPath%>/cms/zjty/chzjtynogotonedetail.do?CMD=LIST";
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/zjty/chzjtynogotonedetail.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize" value="20"/>
    <input type="hidden" name="query" value="true">
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/chzjtynogotonedetail/ChzjtynogotonedetailForm']}"/>

    <!--##################################��ӱ�������##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>��ȫ��ͨ���������ϸ</td>
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
                    <html:text styleClass="form_input_1x" property="_se_rewardreporttime" onclick="WdatePicker({dateFmt:'yyyyMM', maxDate:'%y {%M}'})"></html:text>
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
            			onclick="doExport('/cms/zjty/chzjtynogotonedetail.do')" 
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_export_excel"/>" />
                    <c:if test="${!protoken}">
                    <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_delete"/>" 
                        onClick="doDele('/cms/zjty/chzjtynogotonedetail.do')">
                    </c:if>
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
	    		<td rowspan="4">������</td>
				<td rowspan="4">����</td>
				<td rowspan="4">Ӫҵ������</td>
				<td rowspan="4">�·�</td>
				<td colspan="5">�׿�����</td>
				<td>��ֵҵ��</td>
				<td rowspan="4">��13�����еش����Ŀ�</td>
				<td colspan="19">��14�������ն�������</td>
				<td colspan="7">�ۺ�ҵ��</td>
				<td colspan="3">����ҵ��</td>
				<td>���ҵ��</td>
				<td colspan="5">&nbsp;</td>
				<td colspan="5">�׿�����</td>
				<td>��ֵҵ��</td>
				<td rowspan="4">��13�����еش����Ŀ�</td>
				<td colspan="19">��14�������ն�������</td>
				<td colspan="7">�ۺ�ҵ��</td>
				<td colspan="3">����ҵ��</td>
				<td colspan="5">&nbsp;</td>
				<td>���ҵ��</td>
				<td colspan="5">�׿�����</td>
				<td>��ֵҵ��</td>
				<td rowspan="4">��13�����еش����Ŀ�</td>
				<td colspan="19">��14�������ն�������</td>
				<td colspan="7">�ۺ�ҵ��</td>
				<td colspan="3">����ҵ��</td>
				<td>���ҵ��</td>
				<td colspan="5">&nbsp;</td>
				<td colspan="4">�ġ�����ϵ��</td>
				<td rowspan="4">ȫʡͳһ��������ܶ�</td>
	    	</tr>
	    	<tr class="table_style_head">
	    		<td rowspan="3">��7�����еش�100Ԫ</td>
				<td rowspan="3">��8�����еش�55Ԫ</td>
				<td rowspan="3">��9�����еش�25Ԫ</td>
				<td rowspan="3">��10��������100Ԫ</td>
				<td rowspan="3">��11��������55Ԫ</td>
				<td rowspan="3">��12����ֵ�ܽ��(��30��50��100��300Ԫ��ֵ��)</td>
				<td colspan="2">����500</td>
				<td colspan="2">501-1000</td>
				<td colspan="2">1001-1500</td>
				<td colspan="2">1501-2000</td>
				<td colspan="2">2001-2500</td>
				<td colspan="2">2501-3000</td>
				<td colspan="2">3001-3500</td>
				<td colspan="2">3501-4000</td>
				<td colspan="2">4000����</td>
				<td rowspan="3">MIFI</td>
				<td rowspan="3">��15��������</td>
				<td rowspan="3">��16��ͣ/����</td>
				<td rowspan="3">��17�������ܱ���������ܱ�������������顢������ʾ�� �������䡢����ͨ�����������ơ���ͨ100ͨѶ¼������ͨ�������ͨ��8�ֵ�������ȡ����ͬһ����ÿ��ֻ����һ�Σ�</td>
				<td rowspan="3">��18A���ײͱ�����߸ĵͣ�</td>
				<td rowspan="3">��18B���ײͱ�����͸ĸߣ�</td>
				<td rowspan="3">��19���ֽ�ɷѽ��</td>
				<td rowspan="3">��20��Ԥ�滰�ѽ�ע�������ն�Ӫ������������Ԥ�滰�Ѳ�������У�</td>
				<td rowspan="3">��21���ײͱ��</td>
				<td rowspan="3">��22�������ܱ���������������顢������ʾ�� �������䡢����ͨ�����������ơ���ͨ100ͨѶ¼������ͨ�������ͨ��8�ֵ�������ȡ����ͣ/����ҵ��</td>
				<td rowspan="3">��23���ֽ�ɷѽ��</td>
				<td rowspan="3">��ͥ�������</td>
				<td colspan="4">(24)��������(�������)</td>
				<td rowspan="3">(25)��Ϣ���׿�</td>
				<td rowspan="3">��7�����еش�100Ԫ</td>
				<td rowspan="3">��8�����еش�55Ԫ</td>
				<td rowspan="3">��9�����еش�25Ԫ</td>
				<td rowspan="3">��10��������100Ԫ</td>
				<td rowspan="3">��11��������55Ԫ</td>
				<td rowspan="3">��12����ֵ�ܽ��(��30��50��100��300Ԫ��ֵ��)</td>
				<td colspan="2">����500</td>
				<td colspan="2">501-1000</td>
				<td colspan="2">1001-1500</td>
				<td colspan="2">1501-2000</td>
				<td colspan="2">2001-2500</td>
				<td colspan="2">2501-3000</td>
				<td colspan="2">3001-3500</td>
				<td colspan="2">3501-4000</td>
				<td colspan="2">4000����</td>
				<td rowspan="3">MIFI</td>
				<td rowspan="3">��15��������</td>
				<td rowspan="3">��16��ͣ/����</td>
				<td rowspan="3">��17�������ܱ���������ܱ�������������顢������ʾ�� �������䡢����ͨ�����������ơ���ͨ100ͨѶ¼������ͨ�������ͨ��8�ֵ�������ȡ����ͬһ����ÿ��ֻ����һ�Σ�</td>
				<td rowspan="3">��18A���ײͱ�����߸ĵͣ�</td>
				<td rowspan="3">��18B���ײͱ�����͸ĸߣ�</td>
				<td rowspan="3">��19���ֽ�ɷѽ��</td>
				<td rowspan="3">��20��Ԥ�滰�ѽ�ע�������ն�Ӫ������������Ԥ�滰�Ѳ�������У�</td>
				<td rowspan="3">��21���ײͱ��</td>
				<td rowspan="3">��22�������ܱ���������������顢������ʾ�� �������䡢����ͨ�����������ơ���ͨ100ͨѶ¼������ͨ�������ͨ��8�ֵ�������ȡ����ͣ/����ҵ��</td>
				<td rowspan="3">��23���ֽ�ɷѽ��</td>
				<td colspan="4">(24)��������(�������)</td>
				<td rowspan="3">(25)��Ϣ���׿�</td>
				<td rowspan="3">��ͥ�������</td>
				<td rowspan="3">��7�����еش�100Ԫ</td>
				<td rowspan="3">��8�����еش�55Ԫ</td>
				<td rowspan="3">��9�����еش�25Ԫ</td>
				<td rowspan="3">��10��������100Ԫ</td>
				<td rowspan="3">��11��������55Ԫ</td>
				<td rowspan="3">��12����ֵ�ܽ��(��30��50��100��300Ԫ��ֵ��)</td>
				<td colspan="2">����500</td>
				<td colspan="2">501-1000</td>
				<td colspan="2">1001-1500</td>
				<td colspan="2">1501-2000</td>
				<td colspan="2">2001-2500</td>
				<td colspan="2">2501-3000</td>
				<td colspan="2">3001-3500</td>
				<td colspan="2">3501-4000</td>
				<td colspan="2">4000����</td>
				<td rowspan="3">MIFI</td>
				<td rowspan="3">��15��������</td>
				<td rowspan="3">��16��ͣ/����</td>
				<td rowspan="3">��17�������ܱ���������ܱ�������������顢������ʾ�� �������䡢����ͨ�����������ơ���ͨ100ͨѶ¼������ͨ�������ͨ��8�ֵ�������ȡ����ͬһ����ÿ��ֻ����һ�Σ�</td>
				<td rowspan="3">��18A���ײͱ�����߸ĵͣ�</td>
				<td rowspan="3">��18B���ײͱ�����͸ĸߣ�</td>
				<td rowspan="3">��19���ֽ�ɷѽ��</td>
				<td rowspan="3">��20��Ԥ�滰�ѽ�ע�������ն�Ӫ������������Ԥ�滰�Ѳ�������У�</td>
				<td rowspan="3">��21���ײͱ��</td>
				<td rowspan="3">��22�������ܱ���������������顢������ʾ�� �������䡢����ͨ�����������ơ���ͨ100ͨѶ¼������ͨ�������ͨ��8�ֵ�������ȡ����ͣ/����ҵ��</td>
				<td rowspan="3">��23���ֽ�ɷѽ��</td>
				<td rowspan="3">��ͥ�������</td>
				<td colspan="4">(24)��������(�������)</td>
				<td rowspan="3">(25)��Ϣ���׿�</td>
				<td rowspan="3">������ϵ��</td>
				<td rowspan="3">���ϵ��</td>
				<td rowspan="3">�ۺ�����ϵ��</td>
				<td rowspan="3">����ϵ��</td>
	    	</tr>
	    	<tr class="table_style_head">
	    		<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td colspan="2">5Ԫ�ײ�</td>
				<td colspan="2">10Ԫ�ײ�</td>
				<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td colspan="2">5Ԫ�ײ�</td>
				<td colspan="2">10Ԫ�ײ�</td>
				<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td rowspan="2">2G�ն�</td>
				<td rowspan="2">3G�ն�</td>
				<td colspan="2">5Ԫ�ײ�</td>
				<td colspan="2">10Ԫ�ײ�</td>
	    	</tr>
	        <tr class="table_style_head">
				<td>1���º�</td>
				<td>3���º�</td>
				<td>1���º�</td>
				<td>3���º�</td>
				<td>1���º�</td>
				<td>3���º�</td>
				<td>1���º�</td>
				<td>3���º�</td>
				<td>1���º�</td>
				<td>3���º�</td>
				<td>1���º�</td>
				<td>3���º�</td>
			</tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center">
                    <td><c:out value="${item.cooperauid}"/></td>
					<td><c:out value="${item.city}"/></td>
					<td><c:out value="${item.wayname}"/></td>
					<td><c:out value="${item.rewardreporttime}"/></td>
					<td><c:out value="${item.ywlmzone100}"/></td>
					<td><c:out value="${item.ywlmzone55}"/></td>
					<td><c:out value="${item.ywlmzone25}"/></td>
					<td><c:out value="${item.ywlsz100}"/></td>
					<td><c:out value="${item.ywlsz55}"/></td>
					<td><c:out value="${item.ywlcardtotal}"/></td>
					<td><c:out value="${item.ywlmzonewl}"/></td>
					<td><c:out value="${item.ywlt52g}"/></td>
					<td><c:out value="${item.ywlt53g}"/></td>
					<td><c:out value="${item.ywlt102g}"/></td>
					<td><c:out value="${item.ywlt103g}"/></td>
					<td><c:out value="${item.ywlt152g}"/></td>
					<td><c:out value="${item.ywlt153g}"/></td>
					<td><c:out value="${item.ywlt202g}"/></td>
					<td><c:out value="${item.ywlt203g}"/></td>
					<td><c:out value="${item.ywlt252g}"/></td>
					<td><c:out value="${item.ywlt253g}"/></td>
					<td><c:out value="${item.ywlt302g}"/></td>
					<td><c:out value="${item.ywlt303g}"/></td>
					<td><c:out value="${item.ywlt352g}"/></td>
					<td><c:out value="${item.ywlt353g}"/></td>
					<td><c:out value="${item.ywlt402g}"/></td>
					<td><c:out value="${item.ywlt403g}"/></td>
					<td><c:out value="${item.ywlt502g}"/></td>
					<td><c:out value="${item.ywlt503g}"/></td>
					<td><c:out value="${item.ywlmifi}"/></td>
					<td><c:out value="${item.ywlchangecard}"/></td>
					<td><c:out value="${item.ywlopenmobile}"/></td>
					<td><c:out value="${item.ywlservicechange}"/></td>
					<td><c:out value="${item.ywlpkchanlow}"/></td>
					<td><c:out value="${item.ywlpkchanhigh}"/></td>
					<td><c:out value="${item.ywlcash}"/></td>
					<td><c:out value="${item.ywlmoneyamount}"/></td>
					<td><c:out value="${item.ywlpkchan}"/></td>
					<td><c:out value="${item.ywlzuservicechange}"/></td>
					<td><c:out value="${item.ywlcashamount}"/></td>
					<td><c:out value="${item.ywlfamilybroadband}"/></td>
					<td><c:out value="${item.ywlhlzx51}"/></td>
					<td><c:out value="${item.ywlhlzx53}"/></td>
					<td><c:out value="${item.ywlhlzx101}"/></td>
					<td><c:out value="${item.ywlhlzx103}"/></td>
					<td><c:out value="${item.ywlinfocomress}"/></td>
					<td><c:out value="${item.dwmzone100}"/></td>
					<td><c:out value="${item.dwmzone55}"/></td>
					<td><c:out value="${item.dwmzone25}"/></td>
					<td><c:out value="${item.dwsz100}"/></td>
					<td><c:out value="${item.dwsz55}"/></td>
					<td><c:out value="${item.dwcardtotal}"/></td>
					<td><c:out value="${item.dwmzonewl}"/></td>
					<td><c:out value="${item.dwt52g}"/></td>
					<td><c:out value="${item.dwt53g}"/></td>
					<td><c:out value="${item.dwt102g}"/></td>
					<td><c:out value="${item.dwt103g}"/></td>
					<td><c:out value="${item.dwt152g}"/></td>
					<td><c:out value="${item.dwt153g}"/></td>
					<td><c:out value="${item.dwt202g}"/></td>
					<td><c:out value="${item.dwt203g}"/></td>
					<td><c:out value="${item.dwt252g}"/></td>
					<td><c:out value="${item.dwt253g}"/></td>
					<td><c:out value="${item.dwt302g}"/></td>
					<td><c:out value="${item.dwt303g}"/></td>
					<td><c:out value="${item.dwt352g}"/></td>
					<td><c:out value="${item.dwt353g}"/></td>
					<td><c:out value="${item.dwt402g}"/></td>
					<td><c:out value="${item.dwt403g}"/></td>
					<td><c:out value="${item.dwt502g}"/></td>
					<td><c:out value="${item.dwt503g}"/></td>
					<td><c:out value="${item.dwmifi}"/></td>
					<td><c:out value="${item.dwchangecard}"/></td>
					<td><c:out value="${item.dwopenmobile}"/></td>
					<td><c:out value="${item.dwservicechange}"/></td>
					<td><c:out value="${item.dwpkchanlow}"/></td>
					<td><c:out value="${item.dwpkchanhigh}"/></td>
					<td><c:out value="${item.dwcash}"/></td>
					<td><c:out value="${item.dwmoneyamount}"/></td>
					<td><c:out value="${item.dwpkchan}"/></td>
					<td><c:out value="${item.dwzuservicechange}"/></td>
					<td><c:out value="${item.dwcashamount}"/></td>
					<td><c:out value="${item.dwfamilybroadband}"/></td>
					<td><c:out value="${item.dwhlzx51}"/></td>
					<td><c:out value="${item.dwhlzx53}"/></td>
					<td><c:out value="${item.dwhlzx101}"/></td>
					<td><c:out value="${item.dwhlzx103}"/></td>
					<td><c:out value="${item.dwinfocomress}"/></td>
					<td><c:out value="${item.cjtotalmzone100}"/></td>
					<td><c:out value="${item.cjtotalmzone55}"/></td>
					<td><c:out value="${item.cjtotalmzone25}"/></td>
					<td><c:out value="${item.cjtotalsz100}"/></td>
					<td><c:out value="${item.cjtotalsz55}"/></td>
					<td><c:out value="${item.cjtotalcardtotal}"/></td>
					<td><c:out value="${item.cjtotalmzonewl}"/></td>
					<td><c:out value="${item.cjtotalt52g}"/></td>
					<td><c:out value="${item.cjtotalt53g}"/></td>
					<td><c:out value="${item.cjtotalt102g}"/></td>
					<td><c:out value="${item.cjtotalt103g}"/></td>
					<td><c:out value="${item.cjtotalt152g}"/></td>
					<td><c:out value="${item.cjtotalt153g}"/></td>
					<td><c:out value="${item.cjtotalt202g}"/></td>
					<td><c:out value="${item.cjtotalt203g}"/></td>
					<td><c:out value="${item.cjtotalt252g}"/></td>
					<td><c:out value="${item.cjtotalt253g}"/></td>
					<td><c:out value="${item.cjtotalt302g}"/></td>
					<td><c:out value="${item.cjtotalt303g}"/></td>
					<td><c:out value="${item.cjtotalt352g}"/></td>
					<td><c:out value="${item.cjtotalt353g}"/></td>
					<td><c:out value="${item.cjtotalt402g}"/></td>
					<td><c:out value="${item.cjtotalt403g}"/></td>
					<td><c:out value="${item.cjtotalt502g}"/></td>
					<td><c:out value="${item.cjtotalt503g}"/></td>
					<td><c:out value="${item.cjtotalmifi}"/></td>
					<td><c:out value="${item.cjtotalchangecard}"/></td>
					<td><c:out value="${item.cjtotalopenmobile}"/></td>
					<td><c:out value="${item.cjtotalservicechange}"/></td>
					<td><c:out value="${item.cjtotalpkchanlow}"/></td>
					<td><c:out value="${item.cjtotalpkchanhigh}"/></td>
					<td><c:out value="${item.cjtotalcash}"/></td>
					<td><c:out value="${item.cjtotalmoneyamount}"/></td>
					<td><c:out value="${item.cjtotalpkchan}"/></td>
					<td><c:out value="${item.cjtotalzuservicechange}"/></td>
					<td><c:out value="${item.cjtotalcashamount}"/></td>
					<td><c:out value="${item.cjtotalfamilybroadband}"/></td>
					<td><c:out value="${item.cjtotalhlzx51}"/></td>
					<td><c:out value="${item.cjtotalhlzx53}"/></td>
					<td><c:out value="${item.cjtotalhlzx101}"/></td>
					<td><c:out value="${item.cjtotalhlzx103}"/></td>
					<td><c:out value="${item.cjtotalinfocomress}"/></td>
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
