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
    <title><bean:message bundle="bbcyzrewarddet" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('_ne_rptmon','<bean:message bundle="bbcyzrewarddet" key="rptmon"/>','i',false,'12');
            return checkval(window);
        }
        
        function exports(cmd){
             var hasRight=0;
        	 <s:RewardPurChk controlid="<%=ID_1%>">hasRight=1;</s:RewardPurChk>
        	 if(　ev_check() == false ) {
        	 	return ;
        	 }
			var form=document.forms[0];
			form.action="<%=contextPath%>/cms/bbc/bbcyzrewarddet.do?CMD=EXCEL";
			form.submit();
			form.action="<%=contextPath%>/cms/bbc/bbcyzrewarddet.do?CMD=LIST";
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/bbc/bbcyzrewarddet.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/bbc/bbcyzrewarddet/BbcyzrewarddetForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="bbcyzrewarddet" key="titleList"/>
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
                	<bean:message bundle="bbcyzrewarddet" key="rptmon"/>:
            	</td>
            	<td width="30%" class="form_table_left">
               	 	<html:text styleClass="form_input_1x" property="_ne_rptmon" onclick="this.value=selectDateYYYYMM(this.value);" readonly="true"></html:text>
            	</td>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="bbcyzrewarddet" key="wayid"/>:
            	</td>
            	<td width="30%" class="form_table_left">
               		<html:text styleClass="form_input_1x" property="_se_wayid"  />
            	</td>
            </tr>
            <tr>
            	<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="bbcyzrewarddet" key="tztype"/>:
            	</td>
            	<td width="30%" class="form_table_left">
            			<html:select property="_ne_tztype">
									<html:option value=""></html:option>
									<html:option value="1">web网盟</html:option>
									<html:option value="2">wap网盟</html:option>
								</html:select> 
            	</td>
            	<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="bbcyzrewarddet" key="batchno"/>:
            	</td>
            	<td width="30%" class="form_table_left">
               		<html:text styleClass="form_input_1x" property="_se_batchno"  />
            	</td>
            </tr>
            <tr>
            	<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="bbcyzrewarddet" key="cityid"/>:
            	</td>
            	<td width="30%" class="form_table_left">
            		<html:select  property="_se_cityid">
		                    	<option/>
		                    	<s:Options definition="#CITYCOMPANY" />
                    		</html:select> 
            	</td>
            	<td colspan="2">
            	</td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <input type="button" class="button_2" onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="bbcyzrewarddet" key="export"/>" onclick="exports();"/>
                        <input type="submit" class="query"onmouseover="buttonover(this);"
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
                    <a href="javascript:doOrderby('rptmon')"><bean:message bundle="bbcyzrewarddet" key="rptmon"/></a>
                    <s:OrderImg form="/cms/bbc/bbcyzrewarddet/BbcyzrewarddetForm" field="rptmon"/>
                </td>
                 <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="bbcyzrewarddet" key="wayid"/></a>
                    <s:OrderImg form="/cms/bbc/bbcyzrewarddet/BbcyzrewarddetForm" field="wayid"/>
                </td>
                 <td>
                    <bean:message bundle="bbcyzrewarddet" key="wayid1"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('tztype')"><bean:message bundle="bbcyzrewarddet" key="tztype"/></a>
                    <s:OrderImg form="/cms/bbc/bbcyzrewarddet/BbcyzrewarddetForm" field="tztype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="bbcyzrewarddet" key="cityid"/></a>
                    <s:OrderImg form="/cms/bbc/bbcyzrewarddet/BbcyzrewarddetForm" field="cityid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('num')"><bean:message bundle="bbcyzrewarddet" key="num"/></a>
                    <s:OrderImg form="/cms/bbc/bbcyzrewarddet/BbcyzrewarddetForm" field="num"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('yzreward')"><bean:message bundle="bbcyzrewarddet" key="yzreward"/></a>
                    <s:OrderImg form="/cms/bbc/bbcyzrewarddet/BbcyzrewarddetForm" field="yzreward"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adjreward')"><bean:message bundle="bbcyzrewarddet" key="adjreward"/></a>
                    <s:OrderImg form="/cms/bbc/bbcyzrewarddet/BbcyzrewarddetForm" field="adjreward"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('batchno')"><bean:message bundle="bbcyzrewarddet" key="batchno"/></a>
                    <s:OrderImg form="/cms/bbc/bbcyzrewarddet/BbcyzrewarddetForm" field="batchno"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/bbc/bbcyzrewarddet.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.batchno}|${item.cityid}|${item.rptmon}|${item.tztype}|${item.wayid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                   
                     <td>
                         <c:out value="${item.rptmon}"/>
                     </td>
                     <td>
                         <c:out value="${item.wayid}"/>
                     </td>
                        <td>
                         <s:Code2Name code="${item.wayid}" definition="#BBCWAY" />
                     </td>
                     <td>
                         <s:Code2Name code="${item.tztype}" definition="#CH_BBC_OSSRC" />
                     </td>
                     <td>
                        <s:Code2Name code="${item.cityid}" definition="#CITYCOMPANY" />
                     </td>
                     
                     <td><c:out value="${item.num}"/></td>
                     <td><fmt:formatNumber pattern="0.0000" value="${item.yzreward}" /></td>
                     <td><fmt:formatNumber pattern="0.0000" value="${item.adjreward}" /></td>
                     <td>
                         <c:out value="${item.batchno}"/>
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
