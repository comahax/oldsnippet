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
    <title><bean:message bundle="chadtrulerel" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/fee/chadtrulerel.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/fee/chadtrulerel/ChadtrulerelForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chadtrulerel" key="titleList"/>
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
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <s:PurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/fee/chadtrulerel.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/fee/chadtrulerel.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:PurChk>
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
                    <a href="javascript:doOrderby('ruleitemid')"><bean:message bundle="chadtrulerel" key="ruleitemid"/></a>
                    <s:OrderImg form="/fee/chadtrulerel/ChadtrulerelForm" field="ruleitemid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ruleid')"><bean:message bundle="chadtrulerel" key="ruleid"/></a>
                    <s:OrderImg form="/fee/chadtrulerel/ChadtrulerelForm" field="ruleid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="chadtrulerel" key="cityid"/></a>
                    <s:OrderImg form="/fee/chadtrulerel/ChadtrulerelForm" field="cityid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('paramer')"><bean:message bundle="chadtrulerel" key="paramer"/></a>
                    <s:OrderImg form="/fee/chadtrulerel/ChadtrulerelForm" field="paramer"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/fee/chadtrulerel.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.cityid}|${item.ruleid}|${item.ruleitemid}|${item.rulemodeid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.cityid}|${item.ruleid}|${item.ruleitemid}|${item.rulemodeid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                     <s:Code2Name code="${item.ruleitemid}" definition="#ZJ_CZHY" />
                     </td>
                     <td>
                         充值合约
                     </td>
                     <td>
                         湛江
                     </td>
                     <td><c:out value="${item.paramer}"/></td>
                 </tr>
             </c:forEach>
        </table>
     </div>
   </div>

   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
   
   <div style="text-align:left">【全品牌充值合约业务湛江本地酬金规则】湛江充值合约酬金按业务量分十档进行发放，如下表格：<br>
区分全球通和预付费品牌按渠道汇总，大于等于第一档业务量下限小于第二档业务量下限按第一档<br>酬金比例计算,大于等于第二档业务量下限小于第三档业务量下限按第二档酬金比例计算,依次类推。
<style>.font{font-size:12px}</style>
<table width="550" border="1" style=" table-layout:fixed" class="font">
  <tr>
    <td>档次</td>
    <td>第一档</td>
    <td>第二档</td>
    <td>第三档</td>
    <td>第四档</td>
    <td>第五档</td>
    <td>第六档</td>
    <td>第七档</td>
    <td>第八档</td>
    <td>第九档</td>
    <td>第十档</td>
  </tr>
  <tr>
    <td>全球通酬金比例</td>
    <td>参数1</td>
    <td>参数2</td>
    <td>参数3</td>
    <td>参数4</td>
    <td>参数5</td>
    <td>参数6</td>
    <td>参数7</td>
    <td>参数8</td>
    <td>参数9</td>
    <td>参数10</td>
  </tr>
  <tr>
    <td>全球通业务量</td>
    <td>参数11</td>
    <td>参数12</td>
    <td>参数13</td>
    <td>参数14</td>
    <td>参数15</td>
    <td>参数16</td>
    <td>参数17</td>
    <td>参数18</td>
    <td>参数19</td>
    <td>参数20</td>
  </tr>
  <tr>
    <td>预付费酬金比例</td>
    <td>参数21</td>
    <td>参数22</td>
    <td>参数23</td>
    <td>参数24</td>
    <td>参数25</td>
    <td>参数26</td>
    <td>参数27</td>
    <td>参数28</td>
    <td>参数29</td>
    <td>参数30</td>
  </tr>
  <tr>
    <td>预付费业务量</td>
    <td>参数31</td>
    <td>参数32</td>
    <td>参数33</td>
    <td>参数34</td>
    <td>参数35</td>
    <td>参数36</td>
    <td>参数37</td>
    <td>参数38</td>
    <td>参数39</td>
    <td>参数40</td>
  </tr>
</table>    
</div>
   
</html:form>
</div>
</body>
</html>
