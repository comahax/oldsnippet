<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page  import="java.text.SimpleDateFormat,java.util.Date"%>
<%@ include file="/inc/listhead.inc"%>
<%
	response.setCharacterEncoding("GBK");
	response.setHeader("pragma", "no-cache");
	response.setHeader("Cache-control", "public");
	response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
	String fn = "attachment; filename=��ȫ��ͨ���������ϸ.xls";
	response.setHeader("Content-Disposition", new String(fn.getBytes("GBK"), "ISO-8859-1"));
	response.setContentType("application/x-msdownload");
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	String nowDate = format.format(new Date());
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
	<table>
	 	<tr><td colspan="3">�������ţ�<c:out value="${_USER.opercode}"/></td></tr>
	 	<tr><td colspan="3">����ʱ�䣺<%=nowDate%></td></tr>
 	</table>
    <table border="1" bordercolor="#A8A8A8">
    	<tr align="center">
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
    	<tr align="center">
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
    	<tr align="center">
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
        <tr align="center">
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
			<tr align="center">
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
  </body>
</html>
