<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page  import="java.text.SimpleDateFormat,java.util.Date"%>
<%@ include file="/inc/listhead.inc"%>
<%
	response.setCharacterEncoding("GBK");
	response.setHeader("pragma", "no-cache");
	response.setHeader("Cache-control", "public");
	response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
	String fn = "attachment; filename=ȫ��ͨ���������ϸ.xls";
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
    	<tr>
    		<th colspan="4">һ��������Ϣ</th>
			<th colspan="79">����ҵ������Ϣ���¶ȣ�</th>
			<th colspan="8">������λ���</th>
			<th colspan="79">�ġ�����ܶ�</th>
			<th colspan="4">�塢����ϵ��</th>
			<td rowspan="3">ȫʡͳһ��������ܶ�</td>
    	</tr>
    	<tr align="center">
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
        <tr align="center">
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
			<tr align="center">
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
  </body>
</html>
