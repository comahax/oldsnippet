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

    <!--##################################��ӱ�������##################################################-->
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
                         ��ֵ��Լ
                     </td>
                     <td>
                         տ��
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
   
   <div style="text-align:left">��ȫƷ�Ƴ�ֵ��Լҵ��տ�����س�����տ����ֵ��Լ���ҵ������ʮ�����з��ţ����±��<br>
����ȫ��ͨ��Ԥ����Ʒ�ư��������ܣ����ڵ��ڵ�һ��ҵ��������С�ڵڶ���ҵ�������ް���һ��<br>����������,���ڵ��ڵڶ���ҵ��������С�ڵ�����ҵ�������ް��ڶ�������������,�������ơ�
<style>.font{font-size:12px}</style>
<table width="550" border="1" style=" table-layout:fixed" class="font">
  <tr>
    <td>����</td>
    <td>��һ��</td>
    <td>�ڶ���</td>
    <td>������</td>
    <td>���ĵ�</td>
    <td>���嵵</td>
    <td>������</td>
    <td>���ߵ�</td>
    <td>�ڰ˵�</td>
    <td>�ھŵ�</td>
    <td>��ʮ��</td>
  </tr>
  <tr>
    <td>ȫ��ͨ������</td>
    <td>����1</td>
    <td>����2</td>
    <td>����3</td>
    <td>����4</td>
    <td>����5</td>
    <td>����6</td>
    <td>����7</td>
    <td>����8</td>
    <td>����9</td>
    <td>����10</td>
  </tr>
  <tr>
    <td>ȫ��ͨҵ����</td>
    <td>����11</td>
    <td>����12</td>
    <td>����13</td>
    <td>����14</td>
    <td>����15</td>
    <td>����16</td>
    <td>����17</td>
    <td>����18</td>
    <td>����19</td>
    <td>����20</td>
  </tr>
  <tr>
    <td>Ԥ���ѳ�����</td>
    <td>����21</td>
    <td>����22</td>
    <td>����23</td>
    <td>����24</td>
    <td>����25</td>
    <td>����26</td>
    <td>����27</td>
    <td>����28</td>
    <td>����29</td>
    <td>����30</td>
  </tr>
  <tr>
    <td>Ԥ����ҵ����</td>
    <td>����31</td>
    <td>����32</td>
    <td>����33</td>
    <td>����34</td>
    <td>����35</td>
    <td>����36</td>
    <td>����37</td>
    <td>����38</td>
    <td>����39</td>
    <td>����40</td>
  </tr>
</table>    
</div>
   
</html:form>
</div>
</body>
</html>
