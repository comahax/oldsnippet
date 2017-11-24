<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT1" />
</jsp:include>
<html>
<head>
    <title><bean:message bundle="waylog" key="logistitleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/waylog.do?CMD=LOGISLIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			<bean:message bundle="waylog" key="logistitleList"/>
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
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="waylog" key="wayid"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayname')"><bean:message bundle="waylog" key="wayname"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="wayname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('upperwayid')"><bean:message bundle="Way" key="upperwayid"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="upperwayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cooperator1')"><bean:message bundle="Way" key="cooperator1"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="cooperator1"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="Way" key="cityid"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="cityid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('subcomp')"><bean:message bundle="Way" key="subcomp"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="subcomp"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('svccode')"><bean:message bundle="Way" key="svccode"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="svccode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mareacode')"><bean:message bundle="Way" key="mareacode"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="mareacode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('taxtype')"><bean:message bundle="Way" key="taxtype"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="taxtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mainlayer')"><bean:message bundle="Way" key="mainlayer"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="mainlayer"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adacode')"><bean:message bundle="Way" key="adacode"/></a>
                    <s:OrderImg form="/cms/waylog/waylogForm" field="adacode"/>
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
                     <td>  <s:Code2Name code="${item.upperwayid}"  definition="#WAY"/> </td>
                     <td>  <s:Code2Name code="${item.cooperator}"  definition="$CH_COOPERATOR"/> </td>
                     <td>  <s:Code2Name code="${item.cityid}"  definition="#CITYCOMPANY"/> </td>
                     <td>  <s:Code2Name code="${item.countyid}"  definition="#CNTYCOMPANY"/> </td>
                     <td>  <s:Code2Name code="${item.svccode}"  definition="#CH_SERVCENT"/> </td>
                     <td>  <s:Code2Name code="${item.mareacode}"  definition="#CH_MICROAREA"/> </td>
                     <td>  <s:Code2Name code="${item.taxtype}"  definition="$CH_STTAXTYPE"/> </td>
                     <td>  <s:Code2Name code="${item.mainlayer}"  definition="$CH_COPLAYER"/> </td>
                     <td>  <s:Code2Name code="${item.adacode}"  definition="#CH_ADIMAREA"/> </td>
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
