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
    <title><bean:message bundle="chetadtrecord" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_opnid', '<bean:message bundle="chetadtrecord" key="opnid"/>', 'c', 'false', '18');
            addfield('_se_calcmonth', '<bean:message bundle="chetadtrecord" key="calcmonth"/>', 'c', 'false', '6');
            addfield('_se_wayid', '<bean:message bundle="chetadtrecord" key="wayid"/>', 'c', 'false', '32');
            addfield('_se_mobile', '<bean:message bundle="chetadtrecord" key="mobile"/>', 'c', 'false', '20');
            addfield('_ne_batchno', '<bean:message bundle="chetadtrecord" key="batchno"/>', 'f', 'false', '14');
            return checkval(window);
        }
        
         function doExport(){
			formList.action = "<%=contextPath%>/cms/et/chetadtrecord.do?CMD=SUCTXT";
  			formList.submit();
  			formList.action="<%=contextPath%>/cms/et/chetadtrecord.do?CMD=SUCLIST";
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/et/chetadtrecord.do?CMD=SUCLIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/et/chetadtrecord/ChetadtrecordForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chetadtrecord" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chetadtrecord" key="opnid"/>:</td>
                <td width="30%" class="form_table_left">
                    <s:myzoom definition="#OPERATION" property="_se_opnid" condition="opnid:6501010300001*,6501010300003*;isbusi:1;" styleClass="form_input_1x" readonly="false"/>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chetadtrecord" key="calcmonth"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_calcmonth" onclick="this.value=selectDateYYYYMM(this.value)"></html:text>
               </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chetadtrecord" key="wayid"/>:</td>
                <td width="30%" class="form_table_left"> 
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text><input type="button" value="..." class="clickbutton" 
                    onclick="showSelectWay3(this,'_se_wayid','','','AG','ZJTY');this.value='...';" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chetadtrecord" key="mobile"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_mobile"></html:text>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chetadtrecord" key="_ne_batchno"/>:</td>
                <td width="30%" class="form_table_left"> 
                     <html:text styleClass="form_input_1x" property="_ne_batchno"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chetadtrecord" key="ruleid"/>:</td>
                <td width="30%" class="form_table_left">
                	<html:text styleClass="form_input_1x" property="_se_ruleid"></html:text>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right> 
                            
                            <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery('/cms/et/chetadtrecord.do?CMD=SUCLIST');"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                                
                            <input type="button" class="button_2" onmouseover="buttonover(this);" onclick="doExport()" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_export"/>" /> 
                        
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
                    <a href="javascript:doOrderby('seq')"><bean:message bundle="chetadtrecord" key="seq"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="seq"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('srcseq')"><bean:message bundle="chetadtrecord" key="srcseq"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="srcseq"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oid')"><bean:message bundle="chetadtrecord" key="oid"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="oid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="chetadtrecord" key="opnid"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="opnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('calcmonth')"><bean:message bundle="chetadtrecord" key="calcmonth"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="calcmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="chetadtrecord" key="wayid"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="chetadtrecord" key="oprcode"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtime')"><bean:message bundle="chetadtrecord" key="oprtime"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="oprtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mobile')"><bean:message bundle="chetadtrecord" key="mobile"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="mobile"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('subsid')"><bean:message bundle="chetadtrecord" key="subsid"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="subsid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('brand')"><bean:message bundle="chetadtrecord" key="brand"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="brand"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('yxplanid')"><bean:message bundle="chetadtrecord" key="yxplanid"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="yxplanid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('startdate')"><bean:message bundle="chetadtrecord" key="startdate"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="startdate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ruleid')"><bean:message bundle="chetadtrecord" key="ruleid"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="ruleid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ruleitemid')"><bean:message bundle="chetadtrecord" key="ruleitemid"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="ruleitemid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('noncyc')"><bean:message bundle="chetadtrecord" key="noncyc"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="noncyc"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('batchno')"><bean:message bundle="chetadtrecord" key="batchno"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="batchno"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adtcode')"><bean:message bundle="chetadtrecord" key="adtcode"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="adtcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adtremark')"><bean:message bundle="chetadtrecord" key="adtremark"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="adtremark"/>
                </td> 
                <td>
                    <a href="javascript:doOrderby('src')"><bean:message bundle="chetadtrecord" key="src"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="src"/>
                </td> 
                <td>
                    <a href="javascript:doOrderby('adtflag')"><bean:message bundle="chetadtrecord" key="adtflag"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="adtflag"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('createtime')"><bean:message bundle="chetadtrecord" key="createtime"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="createtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('bakinfo')"><bean:message bundle="chetadtrecord" key="bakinfo"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="bakinfo"/>
                </td>
                
                
                <td>
                    <a href="javascript:doOrderby('texe1')"><bean:message bundle="chetadtrecord" key="texe1"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="texe1"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('texe2')"><bean:message bundle="chetadtrecord" key="texe2"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="texe2"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('texe3')"><bean:message bundle="chetadtrecord" key="texe3"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="texe3"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('texe4')"><bean:message bundle="chetadtrecord" key="texe4"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="texe4"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('texe5')"><bean:message bundle="chetadtrecord" key="texe5"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="texe5"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('texe6')"><bean:message bundle="chetadtrecord" key="texe6"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="texe6"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('texe7')"><bean:message bundle="chetadtrecord" key="texe7"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="texe7"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('texe8')"><bean:message bundle="chetadtrecord" key="texe8"/></a>
                    <s:OrderImg form="/cms/et/chetadtrecord/ChetadtrecordForm" field="texe8"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}"> 

                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.seq}|${item.srcseq}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <c:out value="${item.seq}"/>
                     </td>
                     <td>
                         <c:out value="${item.srcseq}"/>
                     </td>
                     <td><c:out value="${item.oid}"/></td>
                     <td><c:out value="${item.opnid}"/></td>
                     <td><c:out value="${item.calcmonth}"/></td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><c:out value="${item.oprcode}"/></td>
                     <td><c:out value="${item.oprtime}"/></td>
                     <td><c:out value="${item.mobile}"/></td>
                     <td><c:out value="${item.subsid}"/></td>
                     <td><c:out value="${item.brand}"/></td>
                     <td><c:out value="${item.yxplanid}"/></td>
                     <td><c:out value="${item.startdate}"/></td>
                     <td><c:out value="${item.ruleid}"/></td>
                     <td><c:out value="${item.ruleitemid}"/></td>
                     <td><c:out value="${item.noncyc}"/></td>
                     <td><c:out value="${item.batchno}"/></td>
                     <td><c:out value="${item.adtcode}"/></td>
                     <td><c:out value="${item.adtremark}"/></td>
                     <td><c:out value="${item.src}"/></td> 
                     <td><c:out value="${item.adtflag}"/></td>
                     <td><c:out value="${item.createtime}"/></td>
                     <td><c:out value="${item.bakinfo}"/></td>
                     <td><c:out value="${item.texe1}"/></td>
                     <td><c:out value="${item.texe2}"/></td>
                     <td><c:out value="${item.texe3}"/></td>
                     <td><c:out value="${item.texe4}"/></td>
                     <td><c:out value="${item.texe5}"/></td>
                     <td><c:out value="${item.texe6}"/></td>
                     <td><c:out value="${item.texe7}"/></td>
                     <td><c:out value="${item.texe8}"/></td>
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
