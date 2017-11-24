<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="mappinglog" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/examine/mappinglog.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/examine/mappinglog/MappinglogForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="mappinglog" key="titleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waytypelog" key="optime"/>&gt;=:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_optime" onclick="this.value=selectDatetime();" readonly="true"/>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waytypelog" key="optime"/>&lt;=:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_optime" onclick="this.value=selectDatetime();" readonly="true"/>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waytypelog" key="oprcode"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_oprcode"></html:text>
                </td>
            </tr>
            <tr>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waytypelog" key="oprtype"/>:</td>
                <td class="form_table_left">
                     <html:select property="_se_oprtype"> <option></option>	<s:Options  definition="$OPRTYPE"/>  </html:select> 
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waytypelog" key="success"/>:</td>
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
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
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
                    <a href="javascript:doOrderby('logid')"><bean:message bundle="mappinglog" key="logid"/></a>
                    <s:OrderImg form="/cms/examine/mappinglog/MappinglogForm" field="logid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('optime')"><bean:message bundle="mappinglog" key="optime"/></a>
                    <s:OrderImg form="/cms/examine/mappinglog/MappinglogForm" field="optime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="mappinglog" key="oprcode"/></a>
                    <s:OrderImg form="/cms/examine/mappinglog/MappinglogForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtype')"><bean:message bundle="mappinglog" key="oprtype"/></a>
                    <s:OrderImg form="/cms/examine/mappinglog/MappinglogForm" field="oprtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('success')"><bean:message bundle="mappinglog" key="success"/></a>
                    <s:OrderImg form="/cms/examine/mappinglog/MappinglogForm" field="success"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('seqid')"><bean:message bundle="mappinglog" key="seqid"/></a>
                    <s:OrderImg form="/cms/examine/mappinglog/MappinglogForm" field="seqid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('exmnid')"><bean:message bundle="mappinglog" key="exmnid"/></a>
                    <s:OrderImg form="/cms/examine/mappinglog/MappinglogForm" field="exmnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="mappinglog" key="cityid"/></a>
                    <s:OrderImg form="/cms/examine/mappinglog/MappinglogForm" field="cityid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mmode')"><bean:message bundle="mappinglog" key="mmode"/></a>
                    <s:OrderImg form="/cms/examine/mappinglog/MappinglogForm" field="mmode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('markul')"><bean:message bundle="mappinglog" key="markul"/></a>
                    <s:OrderImg form="/cms/examine/mappinglog/MappinglogForm" field="markul"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('markll')"><bean:message bundle="mappinglog" key="markll"/></a>
                    <s:OrderImg form="/cms/examine/mappinglog/MappinglogForm" field="markll"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('coeforbase')"><bean:message bundle="mappinglog" key="coeforbase"/></a>
                    <s:OrderImg form="/cms/examine/mappinglog/MappinglogForm" field="coeforbase"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 
                 <tr class="table_style_content" align="center">
                    
                     <td>
                         <c:out value="${item.logid}"/>
                     </td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.optime}"/></td>
                     <td><c:out value="${item.oprcode}"/></td>
                     <td><s:Code2Name code="${item.oprtype}" definition="$OPRTYPE" /></td>
                     <td><s:Code2Name code="${item.success}" definition="$OPRRESULT" /></td>
                     <td><c:out value="${item.seqid}"/></td>
                     <td><s:Code2Name definition="#EXAMINE" code="${item.exmnid}"/></td>
                     <td><s:Code2Name definition="#CITYNAME" code="${item.cityid}"/></td>
                     <td><s:Code2Name definition="$CH_MMODE" code="${item.mmode}"/></td>
                     <td><c:out value="${item.markul}"/></td>
                     <td><c:out value="${item.markll}"/></td>
                     <td><c:out value="${item.coeforbase}"/></td>
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
