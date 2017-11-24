<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<script type="text/javascript" src="<%= contextPath %>/js/jquery/jquery-1.3.2.js"></script>
<html>
<head>
    <title><bean:message bundle="hdnetsales" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        
        function doExport(url){
			formList.action = contextPath + url + "?CMD=TOTXT";
  			formList.submit();
  			formList.action = contextPath + url + "?CMD=LIST";
		}
		
		$(document).ready(function(){
			$(".time").each(function(i){
				if($(this).val().length>0)
				{
					$(this).val($(this).val().substring(0,10));
				}
			});
		});
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/bbc/hdnetsales.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/hdnetsales/HdnetsalesForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="hdnetsales" key="titleList"/>
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
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="hdnetsales" key="seq" />
					:
            	</td>
            	<td width="30%" class="form_table_left">
               	  <html:text  property="_se_seq" styleClass="form_input_1x"/>
            	</td>
            	<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="hdnetsales" key="opnid" />
					:
            	</td>
            	<td width="30%" class="form_table_left">
               	  <html:text  property="_se_opnid" styleClass="form_input_1x"/>
            	</td>
            </tr>
            <tr>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="hdnetsales" key="opnname" />
					:
            	</td>
            	<td width="30%" class="form_table_left">
               	  <html:text  property="_sk_name" styleClass="form_input_1x"/>
            	</td>
            	<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="hdnetsales" key="mobile" />
					:
            	</td>
            	<td width="30%" class="form_table_left">
               	  <html:text  property="_se_mobile" styleClass="form_input_1x"/>
            	</td>
            </tr>
            <tr>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="hdnetsales" key="oprtimenl" />
					:
            	</td>
            	<td width="30%" class="form_table_left">
            		<html:text styleClass="form_input_1x time" property="_dnl_oprtime"
									onclick="this.value=selectDatetime();"></html:text>
            	</td>
            	<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="hdnetsales" key="oprtimenm" />
					:
            	</td>
            	<td width="30%" class="form_table_left">
            		<html:text styleClass="form_input_1x time" property="_dnm_oprtime"
									onclick="this.value=selectDatetime();"></html:text>
            	</td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                	<input type="button" class="button_2" onmouseover="buttonover(this);" onclick="doExport('/cms/bbc/hdnetsales.do')" 
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_export"/>" />  
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
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td>
                    <a href="javascript:doOrderby('seq')"><bean:message bundle="hdnetsales" key="seq"/></a>
                    <s:OrderImg form="/cms/hdnetsales/HdnetsalesForm" field="seq"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('srcseq')"><bean:message bundle="hdnetsales" key="srcseq"/></a>
                    <s:OrderImg form="/cms/hdnetsales/HdnetsalesForm" field="srcseq"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ruleid')"><bean:message bundle="hdnetsales" key="ruleid"/></a>
                    <s:OrderImg form="/cms/hdnetsales/HdnetsalesForm" field="ruleid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="hdnetsales" key="opnid"/></a>
                    <s:OrderImg form="/cms/hdnetsales/HdnetsalesForm" field="opnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('calcmonth')"><bean:message bundle="hdnetsales" key="calcmonth"/></a>
                    <s:OrderImg form="/cms/hdnetsales/HdnetsalesForm" field="calcmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="hdnetsales" key="wayid"/></a>
                    <s:OrderImg form="/cms/hdnetsales/HdnetsalesForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtime')"><bean:message bundle="hdnetsales" key="oprtime"/></a>
                    <s:OrderImg form="/cms/hdnetsales/HdnetsalesForm" field="oprtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="hdnetsales" key="oprcode"/></a>
                    <s:OrderImg form="/cms/hdnetsales/HdnetsalesForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mobile')"><bean:message bundle="hdnetsales" key="mobile"/></a>
                    <s:OrderImg form="/cms/hdnetsales/HdnetsalesForm" field="mobile"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/hdnetsales.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seq}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.seq}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td><c:out value="${item.seq}"/></td>
                     <td><c:out value="${item.srcseq}"/></td>
                     <td><c:out value="${item.ruleid}"/></td>
                     <td><c:out value="${item.opnid}"/></td>
                     <td><c:out value="${item.calcmonth}"/></td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.oprtime}"/></td>
                     <td><c:out value="${item.oprcode}"/></td>
                     <td><c:out value="${item.mobile}"/></td>
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
