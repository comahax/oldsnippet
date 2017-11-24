<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT1" />
</jsp:include>
<html>
<head>
    <title><bean:message bundle="waylog" key="distitleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/waylog.do?CMD=DISLIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			<bean:message bundle="waylog" key="distitleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waylog" key="optime"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_optime" onclick="this.value=selectDatetime();" readonly="true"/>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waylog" key="optime"/>:</td>
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
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="waylog" key="wayid2"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayname')"><bean:message bundle="waylog" key="wayname2"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="wayname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('waytype')"><bean:message bundle="waylog" key="waytype"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="waytype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('waysubtype')"><bean:message bundle="waylog" key="waysubtype"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="waysubtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('custtype')"><bean:message bundle="waylog" key="custtype"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="custtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('upperwayid')"><bean:message bundle="waylog" key="upperwayid"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="upperwayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('countyid')"><bean:message bundle="waylog" key="countyid"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="countyid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="waylog" key="cityid"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="cityid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('centerid')"><bean:message bundle="waylog" key="centerid"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="centerid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('citylevel')"><bean:message bundle="waylog" key="citylevel"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="citylevel"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('waylevel')"><bean:message bundle="waylog" key="waylevel"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="waylevel"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('bchlevel')"><bean:message bundle="waylog" key="bchlevel"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="bchlevel"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('function')"><bean:message bundle="waylog" key="function"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="function"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('miscode')"><bean:message bundle="waylog" key="miscode"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="miscode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('waystate')"><bean:message bundle="waylog" key="waystate"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="waystate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('isshare')"><bean:message bundle="Way" key="isshare"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="isshare"/>
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
                     <td><c:out value="${item.wayname}"/></td>
                     <td> <s:Code2Name code="${item.waytype}"  definition="#WAYTYPE"/></td>
                     <td><c:out value="${item.waysubtype}"/></td>
                     <td><c:out value="${item.custtype}"/></td>
                     <td><c:out value="${item.upperwayid}"/></td>
                     <td><c:out value="${item.countyid}"/></td>
                     <td><c:out value="${item.cityid}"/></td>
                     <td><c:out value="${item.centerid}"/></td>
                     <td><s:Code2Name code="${item.citylevel}"  definition="$CH_CITYLEVEL"/></td>
                     <td><c:out value="${item.waylevel}"/></td>
                     <td><c:out value="${item.bchlevel}"/></td>
                     <td><c:out value="${item.function}"/></td>
                     <td><c:out value="${item.miscode}"/></td>
                     <td><s:Code2Name code="${item.waystate}"  definition="$CH_VALIDFLAG"/></td>
                     <td>  <s:Code2Name code="${item.isshare}"  definition="$CH_DSTISKEYSTEP"/> </td>
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
