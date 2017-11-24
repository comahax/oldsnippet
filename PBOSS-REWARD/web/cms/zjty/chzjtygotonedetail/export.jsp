<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page  import="java.text.SimpleDateFormat,java.util.Date"%>
<%@ include file="/inc/listhead.inc"%>
<%
	response.setCharacterEncoding("GBK");
	response.setHeader("pragma", "no-cache");
	response.setHeader("Cache-control", "public");
	response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
	String fn = "attachment; filename=全球通基础酬金明细.xls";
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
	 	<tr><td colspan="3">导出工号：<c:out value="${_USER.opercode}"/></td></tr>
	 	<tr><td colspan="3">导出时间：<%=nowDate%></td></tr>
 	</table>
    <table border="1" bordercolor="#A8A8A8">
    	<tr>
    		<th colspan="4">一、基础信息</th>
			<th colspan="79">二、业务量信息（月度）</th>
			<th colspan="8">三、单位酬金</th>
			<th colspan="79">四、酬金总额</th>
			<th colspan="4">五、考核系数</th>
			<td rowspan="3">全省统一基础酬金总额</td>
    	</tr>
    	<tr align="center">
    		<td rowspan="2">合作商</td>
			<td rowspan="2">地市</td>
			<td rowspan="2">营业厅名称</td>
			<td rowspan="2">月份</td>
			<td colspan="13">（1）不选或选58商旅套餐、58上网套餐</td>
			<td colspan="13">（2）选88商旅套餐或88上网套餐</td>
			<td colspan="13">（3）选128商旅套餐或128上网套餐</td>
			<td colspan="13">（4）158商旅套餐</td>
			<td colspan="13">（5）选188商旅套餐</td>
			<td colspan="13">（6）选288、388、588、888商旅套餐</td>
			<td rowspan="2">(7)预付费转全球通</td>
			<td>不选或选58、88、128、158、188、288、388、588、888商旅套餐；选58、88、128上网套餐</td>
			<td colspan="6">激励奖金标准为客户无欠费情况下连续 12 个月套餐费用的 10% （上限按照 268 元套餐封顶）</td>
			<td rowspan="2">（7）预付费转全球通</td>
			<td colspan="13">（1）不选或选58商旅套餐、58上网套餐</td>
			<td colspan="13">（2）选88商旅套餐或88上网套餐</td>
			<td colspan="13">（3）选128商旅套餐或128上网套餐</td>
			<td colspan="13">（4）158商旅套餐</td>
			<td colspan="13">（5）选188商旅套餐</td>
			<td colspan="13">（6）选288、388、588、888商旅套餐</td>
			<td rowspan="2">（7）预付费转全球通</td>
			<td colspan="4">考核系数</td>
    	</tr>
        <tr align="center">
			<td>开户酬金</td>
			<td>激励酬金1</td>
			<td>激励酬金2</td>
			<td>激励酬金3</td>
			<td>激励酬金4</td>
			<td>激励酬金5</td>
			<td>激励酬金6</td>
			<td>激励酬金7</td>
			<td>激励酬金8</td>
			<td>激励酬金9</td>
			<td>激励酬金10</td>
			<td>激励酬金11</td>
			<td>激励酬金12</td>
			<td>开户酬金</td>
			<td>激励酬金1</td>
			<td>激励酬金2</td>
			<td>激励酬金3</td>
			<td>激励酬金4</td>
			<td>激励酬金5</td>
			<td>激励酬金6</td>
			<td>激励酬金7</td>
			<td>激励酬金8</td>
			<td>激励酬金9</td>
			<td>激励酬金10</td>
			<td>激励酬金11</td>
			<td>激励酬金12</td>
			<td>开户酬金</td>
			<td>激励酬金1</td>
			<td>激励酬金2</td>
			<td>激励酬金3</td>
			<td>激励酬金4</td>
			<td>激励酬金5</td>
			<td>激励酬金6</td>
			<td>激励酬金7</td>
			<td>激励酬金8</td>
			<td>激励酬金9</td>
			<td>激励酬金10</td>
			<td>激励酬金11</td>
			<td>激励酬金12</td>
			<td>开户酬金</td>
			<td>激励酬金1</td>
			<td>激励酬金2</td>
			<td>激励酬金3</td>
			<td>激励酬金4</td>
			<td>激励酬金5</td>
			<td>激励酬金6</td>
			<td>激励酬金7</td>
			<td>激励酬金8</td>
			<td>激励酬金9</td>
			<td>激励酬金10</td>
			<td>激励酬金11</td>
			<td>激励酬金12</td>
			<td>开户酬金</td>
			<td>激励酬金1</td>
			<td>激励酬金2</td>
			<td>激励酬金3</td>
			<td>激励酬金4</td>
			<td>激励酬金5</td>
			<td>激励酬金6</td>
			<td>激励酬金7</td>
			<td>激励酬金8</td>
			<td>激励酬金9</td>
			<td>激励酬金10</td>
			<td>激励酬金11</td>
			<td>激励酬金12</td>
			<td>开户酬金</td>
			<td>激励酬金1</td>
			<td>激励酬金2</td>
			<td>激励酬金3</td>
			<td>激励酬金4</td>
			<td>激励酬金5</td>
			<td>激励酬金6</td>
			<td>激励酬金7</td>
			<td>激励酬金8</td>
			<td>激励酬金9</td>
			<td>激励酬金10</td>
			<td>激励酬金11</td>
			<td>激励酬金12</td>
			<td>开户酬金</td>
			<td>不选或选58商旅套餐、58上网套餐</td>
			<td>选88商旅套餐或88上网套餐</td>
			<td>选128商旅套餐或128上网套餐</td>
			<td>158商旅套餐</td>
			<td>选188商旅套餐</td>
			<td>选288、388、588、888商旅套餐</td>
			<td>开户酬金</td>
			<td>激励酬金1</td>
			<td>激励酬金2</td>
			<td>激励酬金3</td>
			<td>激励酬金4</td>
			<td>激励酬金5</td>
			<td>激励酬金6</td>
			<td>激励酬金7</td>
			<td>激励酬金8</td>
			<td>激励酬金9</td>
			<td>激励酬金10</td>
			<td>激励酬金11</td>
			<td>激励酬金12</td>
			<td>开户酬金</td>
			<td>激励酬金1</td>
			<td>激励酬金2</td>
			<td>激励酬金3</td>
			<td>激励酬金4</td>
			<td>激励酬金5</td>
			<td>激励酬金6</td>
			<td>激励酬金7</td>
			<td>激励酬金8</td>
			<td>激励酬金9</td>
			<td>激励酬金10</td>
			<td>激励酬金11</td>
			<td>激励酬金12</td>
			<td>开户酬金</td>
			<td>激励酬金1</td>
			<td>激励酬金2</td>
			<td>激励酬金3</td>
			<td>激励酬金4</td>
			<td>激励酬金5</td>
			<td>激励酬金6</td>
			<td>激励酬金7</td>
			<td>激励酬金8</td>
			<td>激励酬金9</td>
			<td>激励酬金10</td>
			<td>激励酬金11</td>
			<td>激励酬金12</td>
			<td>开户酬金</td>
			<td>激励酬金1</td>
			<td>激励酬金2</td>
			<td>激励酬金3</td>
			<td>激励酬金4</td>
			<td>激励酬金5</td>
			<td>激励酬金6</td>
			<td>激励酬金7</td>
			<td>激励酬金8</td>
			<td>激励酬金9</td>
			<td>激励酬金10</td>
			<td>激励酬金11</td>
			<td>激励酬金12</td>
			<td>开户酬金</td>
			<td>激励酬金1</td>
			<td>激励酬金2</td>
			<td>激励酬金3</td>
			<td>激励酬金4</td>
			<td>激励酬金5</td>
			<td>激励酬金6</td>
			<td>激励酬金7</td>
			<td>激励酬金8</td>
			<td>激励酬金9</td>
			<td>激励酬金10</td>
			<td>激励酬金11</td>
			<td>激励酬金12</td>
			<td>开户酬金</td>
			<td>激励酬金1</td>
			<td>激励酬金2</td>
			<td>激励酬金3</td>
			<td>激励酬金4</td>
			<td>激励酬金5</td>
			<td>激励酬金6</td>
			<td>激励酬金7</td>
			<td>激励酬金8</td>
			<td>激励酬金9</td>
			<td>激励酬金10</td>
			<td>激励酬金11</td>
			<td>激励酬金12</td>
			<td>管理考核系数</td>
			<td>否决系数</td>
			<td>综合排名系数</td>
			<td>竞标系数</td>
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
