<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT1" />
</jsp:include>
<html>
<head>
    <title><bean:message bundle="waylog" key="salewaylist"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/waylog.do?CMD=SALEWAYLIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="waylog" key="salewaylist"/>
   			</td>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waylog" key="optime"/>&gt;=:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_optime" onclick="this.value=selectDatetime();" readonly="true"/>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waylog" key="optime"/>&lt;=:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_optime" onclick="this.value=selectDatetime();" readonly="true"/>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waylog" key="oprcode"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_oprcode"></html:text>
                </td>
            </tr>
            <tr>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waylog" key="oprtype"/>:</td>
                <td class="form_table_left">
                     <html:select property="_se_oprtype"> <option></option>	<s:Options  definition="$OPRTYPE"/>  </html:select> 
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waylog" key="success"/>:</td>
                <td class="form_table_left">
                     <html:select property="_se_success">  <option></option>	 <s:Options  definition="$OPRRESULT"/>  </html:select> 
                </td>
    			<td width="80" height="20" align="right" class="form_table_right" >
                	&nbsp;
            	</td>
            	<td class="form_table_left">
               	 &nbsp;
            	</td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right> 
                        <input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                     
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>
                    <a href="javascript:doOrderby('logid')"><bean:message bundle="waylog" key="logid"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="logid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('optime')"><bean:message bundle="waylog" key="optime"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="optime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="waylog" key="oprcode"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtype')"><bean:message bundle="waylog" key="oprtype"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="oprtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('success')"><bean:message bundle="waylog" key="success"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="success"/>
                </td>
                <td nowrap>
					<a href="javascript:doOrderby('wayid')"> <bean:message
							bundle="waylog" key="wayid" /> </a>
					<s:OrderImg form="/cms/way/SalewayForm" field="wayid" />
				</td>
				<td nowrap>
					<a href="javascript:doOrderby('wayname')"> <bean:message
							bundle="waylog" key="wayname" /> </a>
					<s:OrderImg form="/cms/way/SalewayForm" field="wayname" />
				</td>
				<td nowrap>
					<a href="javascript:doOrderby('waysubtype')"><bean:message bundle="saleway" key="waysubtype"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="waysubtype"/>
				</td>
				<td nowrap>
					<a href="javascript:doOrderby('upperwayid')"><bean:message bundle="saleway" key="upperwayid"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="upperwayid"/>
				</td>
				<td nowrap>
					<a href="javascript:doOrderby('starlevel')"><bean:message bundle="saleway" key="starlevel"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="starlevel"/>
				</td>
				<td nowrap>
					<a href="javascript:doOrderby('pt')"><bean:message bundle="saleway" key="pt"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="pt"/>
				</td>
				<td nowrap>
					<a href="javascript:doOrderby('isstraitprd')"><bean:message bundle="saleway" key="isstraitprd"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="isstraitprd"/>
				</td>
				<td nowrap>
					<a href="javascript:doOrderby('catetype')"><bean:message bundle="saleway" key="catetype"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="catetype"/>
				</td>
				<td nowrap>
					<a href="javascript:doOrderby('cityid')"><bean:message bundle="saleway" key="cityid"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="cityid"/>
				</td>
				<td nowrap>
					<a href="javascript:doOrderby('countyid')"><bean:message bundle="saleway" key="countyid"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="countyid"/>
				</td>
				<td nowrap>
					<a href="javascript:doOrderby('svccode')"><bean:message bundle="saleway" key="svccode"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="svccode"/>
				</td>
				<td nowrap>
					<a href="javascript:doOrderby('mareacode')"><bean:message bundle="saleway" key="mareacode"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="mareacode"/>
				</td>
				<td nowrap>
					<a href="javascript:doOrderby('adtypecode')"><bean:message bundle="saleway" key="adtypecode"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="adtypecode"/>
				</td>
				<td nowrap>
					<a href="javascript:doOrderby('adacode')"><bean:message bundle="saleway" key="adacode"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="adacode"/>
				</td>
				<td nowrap>
					<a href="javascript:doOrderby('formtype')"><bean:message bundle="saleway" key="formtype"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="formtype"/>
				</td>
				<td nowrap>
					<a href="javascript:doOrderby('starttime')"><bean:message bundle="saleway" key="starttime"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="starttime"/>
				</td>
				<td nowrap>
					<a href="javascript:doOrderby('logiscode')"><bean:message bundle="saleway" key="logiscode"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="logiscode"/>
				</td>
				<td nowrap>
					<a href="javascript:doOrderby('waymagcode')"><bean:message bundle="saleway" key="waymagcode"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="waymagcode"/>
				</td>
				<td nowrap>
					<a href="javascript:doOrderby('bchlevel')"><bean:message bundle="saleway" key="bchlevel"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="bchlevel"/>
				</td>
				<td nowrap>
					<a href="javascript:doOrderby('waystate')"><bean:message bundle="saleway" key="waystate"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="waystate"/>
				</td>
				<td nowrap>
					<a href="javascript:doOrderby('buzphoneno')"><bean:message bundle="saleway" key="buzphoneno"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="buzphoneno"/>
				</td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/waylog.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.logid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <c:out value="${item.logid}"/>
                     </td>                     
                     <td> <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.optime}"/> </td>
                     <td><c:out value="${item.oprcode}"/></td>
                     <td> <s:Code2Name code="${item.oprtype}" definition="$OPRTYPE"/> </td>
                     <td> <s:Code2Name code="${item.success}" definition="$OPRRESULT"/> </td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td nowrap="nowrap">
						<c:out value="${item.wayname}" />
					</td>
					<td>
						<s:Code2Name code="${item.waysubtype}" definition="#WAYTYPE" />
					</td>
					<td>
						<s:Code2Name code="${item.upperwayid}" definition="#WAY" />
					</td>
					<td>
						<s:Code2Name code="${item.starlevel}"
							definition="$CH_STARLEVEL" />
					</td>
					<td>
						<s:Code2Name code="${item.pt}" definition="$CH_PT" />
					</td>
					<td>
						<s:Code2Name code="${item.isstraitprd}" definition="$CH_STRAITPRD" />
					</td>
					<td>
						<s:Code2Name code="${item.catetype}" definition="$CH_CATETYPE" />
					</td>
					<td>
						<s:Code2Name code="${item.cityid}" definition="#CITYCOMPANY" />
					</td>
					<td>
						<s:Code2Name code="${item.countyid}" definition="#CNTYCOMPANY" />
					</td>
					<td>
						<s:Code2Name code="${item.svccode}" definition="#CH_SERVCENT" />
					</td>
					<td>
						<s:Code2Name code="${item.mareacode}"
							definition="#CH_MICROAREA" />
					</td>
					<td>
						<s:Code2Name code="${item.adtypecode}" definition="$CH_ADTYPE" />
					</td>
					<td>
						<s:Code2Name code="${item.adacode}" definition="#CH_ADIMAREA" />
					</td>
					<td>
						<s:Code2Name code="${item.formtype}" definition="$CH_FORMTYPE" />
					</td>
					<td>
						<fmt:formatDate value="${item.starttime}" pattern="yyyy-MM-dd" />
					</td>
					<td>
						<c:out value="${item.logiscode}" />
					</td>
					<td>
						<c:out value="${item.waymagcode}" />
					</td>
					<td>
						<s:Code2Name code="${item.bchlevel}" definition="$CH_BCHLEVEL" />
					</td>
					<td>
						<s:Code2Name code="${item.waystate}"
							definition="$CH_VALIDFLAG" />
					</td>
					<td>
						<c:out value="${item.buzphoneno}" />
					</td>
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
