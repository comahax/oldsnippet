<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="j" uri="/jop-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="/inc/listhead.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>
		<s:text name="title" />
		</title>
	</head>
	<body onload="loadforiframe1()">
		<s:form name="formList" id="formList" action="checkprocess_list.do"
			theme="simple">
			<aa:zone name="hiddenZone">
				<s:hidden name="param._orderby" />
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				<s:hidden name="param.queryAll" />

				<input type="hidden" name="_rowcount"
					value="<s:property value="dp.rowCount" />" />
				<input type="hidden" id="maxRowCount" value="10" />
				<!--change it if you need-->
				<input type="hidden" name="ajaxFlag" id="ajaxFlag" />
			</aa:zone>
			<div class="widgetL">
				<div class="wCenter">
					<div class="content">
					    <div class="title_name">
							<s:text name="title" />
						</div>
						<aa:zone name="errorZone">
							<div class="error_text">
								<s:actionerror />
								<s:actionmessage />
							</div>
						</aa:zone>
						<div class="list_table overflow_scroll"  style="OVERFLOW-Y:HIDDEN; width=100%;">
						<!-- width根据实际的宽度设置如： width=100%、width=2000px -->
							<table width="100%" border="0" cellspacing="0" cellpadding="0" >
								<thead>
									<tr>
										<td nowrap><s:text name="checkfunc"/></td>
										<td nowrap><s:text name="reqtime"/></td>
										<td nowrap><s:text name="dealtime"/></td>
										<td nowrap><s:text name="operator"/></td>
										<td nowrap><s:text name="result"/></td>
										<td nowrap><s:text name="remark"/></td>
									</tr>
								</thead>
								<tbody>
								<s:iterator value="#request.LIST" var="item" status="status">
						        <s:if test="#status.odd">
									<tr class="" align="center" onMouseOver="this.className='trbg_1';" onMouseOut="this.className='';">
								</s:if>
								<s:else>
									<tr class="trbg_2" align="center" onMouseOver="this.className='trbg_1';" onMouseOut="this.className='trbg_2';">
								</s:else>
										<td nowrap><s:property value="#item.dictname"/></td>	
										<td nowrap><s:date name="#item.req_time" format="yyyy-MM-dd HH:mm:ss"/></td>	
										<td nowrap><s:date name="#item.deal_time" format="yyyy-MM-dd HH:mm:ss"/></td>	
										<td nowrap><s:property value="#item.operator"/></td>	
										<td nowrap>
											<j:code2Name definition="UAP_REQ_STATE" code="#item.state"/>
										</td>	
										<td nowrap><s:property value="#item.remark"/></td>	
								</s:iterator>
		                        </tr>
								</tbody>
							</table>
						</div>
						<%@ include file="/common/pageNav.jsp"%>
					</div>

				</div>
			</div>
		</s:form>
	</body>
</html>