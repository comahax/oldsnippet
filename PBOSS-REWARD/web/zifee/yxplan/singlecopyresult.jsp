<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO" %>
<%@ page import="com.sunrise.boss.common.base.db.DataPackage" %>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="3C3C1ABB" />
</jsp:include>

<%String ID_1 = "3C3C1ABBBT1";
			String ID_2 = "3C3C1ABBBT2";

			String AREACODE_A = "AREACODE_A";
			String AREACODE_B = "AREACODE_B";
			String AREACODE_C = "AREACODE_C";
			
			
			String url = (String)request.getAttribute("url");
			String[] copyitem = (String[])request.getAttribute("copyitem");
			int count = -1;
			for(int i=0;i<copyitem.length;i++){
				if(Integer.valueOf(copyitem[i]).intValue() > 4){
					count = i;
					break;
				}
			}
			String[] notcopied = null;
			if(count != -1){
				notcopied = new String[copyitem.length - count];
				for(int j=0; j<notcopied.length; j++){
					notcopied[j] = copyitem[j+count];
				}
			}
			boolean canpost = true;
			if(url == null || url.equals("") || notcopied == null){
				canpost = false;
			}
			Collection list = ((DataPackage)request.getAttribute("detail")).getDatas();
%>
<html:html>
<head>
	<title>
		<bean:message bundle="yxplan" key="titleCopy" />
	</title>
	<SCRIPT>
		function dosubmit(){
			formItem.action = '<%=url%>';
		}
	</SCRIPT>
</head>
<body onload="if(window.loadforiframe) loadforiframe();">
	<div class="table_container">
		<html:form action="/zifee/yxplan.do" styleId="formItem" method="post" onsubmit="dosubmit()">
			<div class="table_div">
				<!--####################################################################################-->
				<table class="top_table" border=0>
					<tr>
						<td>
							<bean:message bundle="yxplan" key="titleCopy" />
						</td>
					</tr>
				</table>
			</div>
			<div class="table_div">
				<table width="100%" class="error_text">
					<html:errors />
					<s:Msg />
				</table>
			</div>

			<!--####################################################################################-->
			<div class="table_div">
				<table class="form_table">
					<tr>
						<td align=left colspan="4">
							&nbsp;&nbsp;
							<bean:message bundle="yxplan" key="hascopied" />
						</td>
					</tr>
					<TR>
						<%
							for(int i=0; i<copyitem.length; i++){
								if(Integer.valueOf(copyitem[i]).intValue()<6 || (Integer.valueOf(copyitem[i]).intValue()>=27 && Integer.valueOf(copyitem[i]).intValue()<=29)){
									Iterator iterator = list.iterator();
									while(iterator.hasNext()){
										DictitemVO dictitemVO = (DictitemVO)iterator.next();
										if(dictitemVO.getDictid().equals(copyitem[i])){
						%>
						<TD>
							<%=dictitemVO.getDictname()%>
						</TD>
						<%
										break;
										}
									}
									if((i+1)%3 == 0){
						%>
					</TR><TR>
						<%
									}
								}
							}
						%>
					</TR>
				</table>
			</div>
			<div class="table_div" style="display: none;">
				<table class="form_table">
					<tr>
						<td align=left colspan="4">
							&nbsp;&nbsp;
							<bean:message bundle="yxplan" key="notcopied" />
						</td>
					</tr>
					<TR>
						<%
						if(notcopied != null){
							for(int k=0; k<notcopied.length; k++){
								Iterator iterator = list.iterator();
								while(iterator.hasNext()){
									DictitemVO dictitemVO = (DictitemVO)iterator.next();
									if(dictitemVO.getDictid().equals(notcopied[k])){
						%>
						<TD>
							<font color="red"><%=dictitemVO.getDictname()%></font>
						</TD>
						<%
										break;
									}
								}
								if((k+1)%3 == 0){
						%>
					</TR><TR>
						<%
								}
							}
						}
						%>
					</TR>
				</table>
			</div>
			<%if(!canpost){%>
			<div class="table_div" style="visibility: hidden;">
			<%}else{%>
			<div class="table_div">
			<%}%>			
				<table class="table_button_list">
					<tr>
						<td>
							<s:PurChk controlid="<%=ID_1%>">
								<input type="submit" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="yxplan" key="nextstep"/>" class="submit"/>
							</s:PurChk>
						</td>
					</tr>
				</table>
			</div>
		</html:form>
	</div>
</body>
</html:html>
