<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="7F1A1A" />
</jsp:include>
<% String flag = (String) session.getAttribute("flag"); %>
<html:html>
<head>
	<title><bean:message bundle="custinte" key="batchTransferList" /></title>
	<script language="JavaScript">
		function checkProcess(){
			var filename=formItem.filename.value;
			if(filename != null || filename != ""){
          		formItem.buttonProcess.disabled=true;
	      		window.location.href="<%= contextPath%>/cms/zjty/zjtybusyxplan/batch.do?filename="+filename+"&beanname=com.sunrise.boss.ui.cms.zjty.zjtybusyxplan.ZjtyBusyxplanTaskBean";                                                                                        
			}
		}
		function doReturnList(){
    		window.location.href="<%=contextPath%>/cms/zjty/zjtybusyxplan/list.jsp";
    	}	
    </script>
</head>
<body  onload＝" loadforiframe()">
<div class="table_container">
	<html:form action="/cms/zjty/zjtybusyxplan/batch.do?CMD=UPLOAD" styleId="formItem" method="post" enctype="multipart/form-data">
		<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">		
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							产品编码与业务编码设置导入
						</td>
					</tr>
				</table>
		    </div>
			<div class="table_div">
			<table width="100%" class="error_text">
	        	<s:Msg />
	   		</table>
	   		</div>
	   		<div class="table_div">
			<table class="form_table">	
				<tr class="table_style_content">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							选择上传文件:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						<html:file styleClass="form_input_files" property="theFile"/>
					</td>
				</tr>
				<c:choose>
					<c:when test="${!empty requestScope.ITEM.inFile}">
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="upload" key="existfile" />
							</td>
							<td align=left>
								<a href='<%=contextPath%>/commons/batch/download.jsp?filename=
								<c:out value="${requestScope.ITEM.inFile}" />'>
								<c:out value="${requestScope.ITEM.fileName}" /> </a>
							</td>
						</tr>
					</c:when>
				</c:choose>
				<tr class="table_style_content">
					<td align=right height=25>
						<bean:message bundle="upload" key="filetype" />
					</td>
					<td align=left>
						<bean:message bundle="upload" key="typevalue" />
					</td>
				</tr>
				<tr class="table_style_content">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							文件格式 :
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left" nowrap="false">
						<font color=red>业务编码</font>|<font color=red>映射类型</font>|<font color=red>产品编码</font>|套餐值|
						（注：红色字体为必须录入字段）
					</td>
				</tr>				
				<tr class="table_style_content">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							举例说明:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left" nowrap="false">
						<font color=red>6202010300003</font>|<font color=red>CONG3CLIENT</font>|<font color=red>prod.20013090800092|</font>100|
					</td>
				</tr>
				<tr class="table_style_content">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							补充说明:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left" nowrap="false">
						映射类型类型包括：<br>
						1，HAPPYONLINE---欢乐在线 <br>
						2，XINXIJITAOKA---信息机套卡<br>
						3，CHANGEPLAN---套餐变更  <br>
						4，NEWUSER---全球通放号     <br>
						5，G3NETBOOK---G3上网本 <br>
						6，YCHFTC---预存话费剔除<br>
						7，CONG3CLIENT---合约购机低消产品
					</td>
				</tr>
				<tr class="table_style_content">
					<td align=right height=25>
						填写指南
					</td>
					<td align=left>
						<a href="<%=contextPath%>/cms/common/importguide.htm">填写指南</a></td>
				</tr>
				<tr class="table_style_content">
					<td align=right height=25>
						Excel填写模板
					</td>
					<td align=left>
						<a href="<%=contextPath%>/cms/zjty/zjtybusyxplan/zjtybusyxplan.xls">自建他营营销方案与业务编码映射导入</a>
						（注：填写后请将数据转换为txt格式，去掉标题行，再上传导入）</td>
				</tr>
			</table>
		</div>
		<iframe
				src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.zjty.zjtybusyxplan.ZjtyBusyxplanTaskBean"
				frameborder="0" class="loadframe" id="loadframe" scrolling="no">
		</iframe>
        <div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
							
							<input type="submit" value="<bean:message bundle="upload" key="upload" />" class="button_4"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonUpload" NAME="buttonUpload"/>
							<input type="button" value="<bean:message bundle="upload" key="process"/>" class="button_4"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonProcess" NAME="buttonProcess" onClick="checkProcess()" />
								
							<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           		name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           		value="<bean:message bundle="public" key="button_return"/>" class="button_4"
                           		onclick="doReturnList()">
						</td>
					</tr>
				</table>
			</div>
	</html:form> 
	<br>
	</div>
</body>
</html:html>
