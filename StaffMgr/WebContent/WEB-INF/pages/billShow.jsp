<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:choose>
	<c:when test="${not empty errors }">
		<c:forEach items="${errors}" var="e">
			<span class="errormsg">${e}</span>
		</c:forEach>
	</c:when>
	<c:otherwise>
		<c:forEach items="${printData.tables}" var="table">
		<c:if test="${not empty table.title }">
		<h3>${table.title }</h3>
		</c:if>
			<table class="mygridtable">
				<thead>
					<tr>
						<c:forEach items="${table.theads}" var="thead">
							<th>${thead}</th>
						</c:forEach>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${table.items}" var="item" begin="0" end="49">
						<tr>
							<c:forEach var="col" items="${item}">
								<td>${col}</td>
							</c:forEach>
						</tr>
					</c:forEach>					
				</tbody>
			</table>
			<c:if test="${not empty table.nodata}">
				<div>${table.nodata}</div>
			</c:if>
			<br />
			<br />
		</c:forEach>
	</c:otherwise>
</c:choose>
