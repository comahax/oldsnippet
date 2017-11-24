<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="p" uri="/page-tag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>List</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<style type="text/css">
			body {
				text-align: center;
			}
			table {
				margin: 0 auto;
			}
			ul {
				list-style: none;
			}
			ul li {
				display: inline;
				margin: 0 5px;
			}
		</style>
	</head>
	<body>
		<table border="1">
			<tbody>
				<tr>
					<td>SN</td>
					<td>Username</td>
					<td>Password</td>
					<td>Description</td>
					<td>Id</td>
					<td>Edit</td>
					<td>Remove</td>
				</tr>
				<s:iterator value="result.data.{?#this.id != null}" status="stus">
				<tr>
					<td><s:property value="${result.page.firstResult + stus.index + 1}" /></td>
					<td><s:property value="%{result.data[#stus.index].username}" /></td>
					<td><s:property value="%{result.data[#stus.index].password}" /></td>
					<td><s:property value="%{result.data[#stus.index].description}" /></td>
					<td><s:property value="%{result.data[#stus.index].id}" /></td>
					<td><a href='<s:url action="Load"><s:param name="user.id" value="id" /></s:url>'>Edit</a></td>
					<td><a href='<s:url action="Remove"><s:param name="user.id" value="id" /></s:url>'>Remove</a></td>
				</tr>
				</s:iterator>
				<tr>
					<td colspan="7"><p:p url="List.do" size="${result.page.size}" next="${result.page.next}" last="${result.page.last}" previous="${result.page.previous}" current="${result.page.current}" rows ="${result.page.rows}"/></td>
				</tr>
			</tbody>
		</table>
		<p><a href="JQList.do">jQuery例子</a></p>
	</body>
</html>
