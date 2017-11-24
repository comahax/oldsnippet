<%@ page language="java"
	contentType="application/x-msdownload;charset=GBK"%>
<%@ page
	import="java.text.SimpleDateFormat,java.util.*,com.gmcc.pboss.business.base.dictitem.DictitemVO,com.sunrise.jop.common.utils.lang.Code2NameUtils"%>
<%@ include file="/inc/listhead.inc"%>
<%
	response.setCharacterEncoding("GBK");
	response.setHeader("pragma", "no-cache");
	response.setHeader("Cache-control", "public");
	response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
	String fn = "attachment; filename=导出统计信息.xls";
	response.setHeader("Content-Disposition", new String(fn
			.getBytes("GBK"), "ISO-8859-1"));
	response.setContentType("application/x-msdownload");
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	String nowDate = format.format(new Date());
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base>


	</head>

	<body>
		<table>
			<tr>
				<td colspan="5">
					导出工号：${USER.oprcode}
				</td>
			</tr>
			<tr>
				<td colspan="5">
					导出时间：<%=nowDate%></td>
			</tr>
		</table>
		<!-- 订单编号 订单状态 分公司 渠道编码 渠道名称 星级 -->
		<table border="1" bordercolor="#A8A8A8">
			<tr class="table_style_head">
				<td>
					<s:text name="orderid" />
				</td>
				<td>
					<s:text name="orderstate" />
				</td>
				<td>
					<s:text name="countyid" />
				</td>
				<td>
					<s:text name="wayid" />
				</td>
				<td>
					渠道名称
				</td>
				<td>
					<s:text name="starlevel" />
				</td>
				<%
					List<DictitemVO> listcomcate = (List<DictitemVO>) request.getAttribute("FXCOMCATEGORY");
					for (Iterator<DictitemVO> itdict = listcomcate.iterator(); itdict.hasNext();) {
						DictitemVO dictitemVOdict = itdict.next();
				%>
				<td>
					<%
						out.print(dictitemVOdict.getDictname());
					%>
				</td>
				<%
					}
				%>
			</tr>




			<%
				List<Map> list = (List<Map>) request.getAttribute("orderResCount");
				for (Iterator<Map> it = list.iterator(); it.hasNext();) {
					Map itmap = it.next();
			%>
			<tr class="table_style_content" align="center">
				<td>
					<%
						out.print(itmap.get("orderid"));
					%>
				</td>
				<td>
					<%
						out.print(Code2NameUtils.code2Name("$FX_ORDERFSTATE", itmap.get("orderstate")+"", request.getAttribute("usercity")+""));
					%>
				</td>
				<td>
					<%
					out.print(Code2NameUtils.code2Name("#CNTYCOMPANY", itmap.get("countyid")+"", request.getAttribute("usercity")+""));
					%>
				</td>
				<td>
					<%
						out.print(itmap.get("wayid"));
					%>
				</td>
				<td>
					<%
						out.print(Code2NameUtils.code2Name("#WAYIDINFO", itmap.get("wayid")+"", request.getAttribute("usercity")+""));
					%>
				</td>
				<td>
					<%
						out.print(Code2NameUtils.code2Name("$CH_STARLEVEL", itmap.get("starlevel")+"", request.getAttribute("usercity")+""));
					%>
				</td>

				<%
					List<DictitemVO> list2 = (List<DictitemVO>) request
								.getAttribute("FXCOMCATEGORY");
						for (Iterator<DictitemVO> itt = list2.iterator(); itt.hasNext();) {
							DictitemVO dictitemVO = itt.next();
				%>
				<td>
					<%
					if(itmap.get(dictitemVO.getDictid())!= null){
						out.print(itmap.get(dictitemVO.getDictid()));
					//}
					//if(dictitemVO.getDictid().equals(itmap.get("comcategory")+"")){
						//	out.print(itmap.get("orderamt"));
					}else{
						out.print(0);
					}
					%>
				</td>
				<%
					}
				%>
			</tr>
			<%
				}
			%>
		</table>

	</body>
</html>