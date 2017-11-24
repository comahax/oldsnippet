<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ page import="org.ajaxanywhere.AAUtils" %>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa" %> 
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="rulerel" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            //addfield('_se_ruleitemid', '<bean:message bundle="rulerel" key="ruleitemid"/>', 'c', true, '18');
            //addfield('_se_ruleid', '<bean:message bundle="rulerel" key="ruleid"/>', 'c', true, '18');
           // addfield('_se_cityid', '<bean:message bundle="rulerel" key="cityid"/>', 'c', true, '4');
          //  addfield('_ne_state', '<bean:message bundle="rulerel" key="state"/>', 'f', false, '2');
            return checkval(window);
        }
        function doReturn(){
        	formList._orderby.value='';
        	formList.action = contextPath + '/cms/reward/rulemode.do?CMD=LIST';
        	formList.submit();
        }
        function checkRuleItemNum(){
        	var sis = formList.all("ruleitemids");
        	var checkedNum = 0;
        	var id = '';
        	if (sis.length == undefined) {
        		if (sis.value != '') {
        			checkedNum = 1;
        			id = sis.value;
        		}
        	} else {
        		for (var i=0; i<sis.length; i++) {
        			if (sis[i].type == 'checkbox' && sis[i].checked) {
        				checkedNum++;
        				id = sis[i].value;
        			}
        		}
        	}
        	return checkedNum;
        }
        function checkRuleitem(checkvalue){
        	if(checkvalue.checked == false){
        		//var item=checkvalue.value.split('|');
        		var ss = checkvalue.value.split('|');
        		if(ss[1]=='0'){
	        		checkvalue.disabled='true';
        		}else{
        			var _se_cityid=formList._se_cityid.value;
        			var _se_ruleid= formList._se_ruleid.value;
        			ajaxAnywhere.submitByURL( '/cms/reward/rulerel.do?CMD=CANCELRULEITEM&ruleitemid='+ss[0]);
        			formList.action=contextPath+"/cms/reward/rulerel.do?CMD=LIST";
        		}
        	}else{
        		var _se_cityid=formList._se_cityid.value;
        		var _se_ruleid= formList._se_ruleid.value;

        		ajaxAnywhere.submitByURL( '/cms/reward/rulerel.do?CMD=CHECKRULEITEM');
        		formList.action=contextPath+"/cms/reward/rulerel.do?CMD=LIST";
        	}
        }
        function doSave(cmdSave) {
    		//if (ev_checkval()) {
       	 	//	enable();
       	 	var sis = formList.all("ruleitemids");
        	var checkedNum = 0;
        	var id = '';
        	if (sis.length == undefined) {
        		if (sis.value != '') {
        			checkedNum = 1;
        			id = sis.value;
        		}
        	} else {
        		for (var i=0; i<sis.length; i++) {
        			if (sis[i].type == 'checkbox' && sis[i].checked) {
        				checkedNum++;
        				id = sis[i].value;
        			}
        		}
        	}
        	/*
        	if (checkedNum == 0) {
        		alert('<bean:message bundle="rule" key="remindOnBusi"/>');
        		return;
        	}
        	*/

       		 formList.action = contextPath + cmdSave;
       		 formList.submit();
   			// }
   		 //	return false;
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/rulerel.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_cityid"/>
    <html:hidden property="_se_ruleid"/>
    <html:hidden property="rulemodeid"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="formvalue" scope="request" value="${requestScope['/cms/reward/rulerel/RulerelForm']}"/>

    <!--##################################��ӱ�������##################################################-->
    <div class="table_div">
    
    	<table class="top_table">
    		<tr>
    			<td>
    				<bean:message bundle="rulerel" key="titleList"/>
   				</td>
    		</tr>
    	</table>
   
    </div>
    <aa:zone name="zoneCityRule1">
    <div class="table_div">	
   		 <table width="100%" class="error_text">
    		<html:errors/><s:Msg />
    	</table>
    </div>
    </aa:zone>

    <div class="table_div">
     
      <table class="form_table">
      <tr >
      	<td width="15%">
      		<bean:message bundle="rulerel" key="ruleid"/>
      	</td>
      	<td width="90%">
      		<c:out value="${formvalue._se_ruleid}"/>
      	</td>
      </tr>
      <tr >
      	<td width="15%">
      		<bean:message bundle="rulerel" key="rulename"/>
      	</td>
      	<td width="90%">
	      	<s:Code2Name code="${formvalue._se_ruleid}" definition="#CH_ADT_RULE"/>
      	</td>
      </tr>
      <tr >
      	<td width="15%">
      		<bean:message bundle="rulerel" key="ruleitem"/>
      	</td>
      	<td width="90%">
      	<aa:zone name="zoneCityRule">
      	 <div class="table_div">
      	
        <table class="table_style" ID="Table3">
            <tr class="table_style_head">          
            	<td></td>
                <td>
                    <a href="javascript:doOrderby('ruleitemid')"><bean:message bundle="rulerel" key="ruleitemid"/></a>
                    <s:OrderImg form="/cms/reward/rulerel/rulerelForm" field="ruleitemid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ruleitemname')"><bean:message bundle="rulerel" key="ruleitemname"/></a>
                    <s:OrderImg form="/cms/reward/rulerel/rulerelForm" field="ruleitemname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('state')"><bean:message bundle="rulerel" key="state"/></a>
                    <s:OrderImg form="/cms/reward/rulerel/rulerelForm" field="state"/>
                </td>
            </tr>
	
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/reward/rulerel.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${formvalue._se_cityid}|${formvalue._se_ruleid}|${item[1].ruleitemid}"/>
                     <%--<c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                 	  <td >
                 	  <c:choose>
                 	  	<c:when test="${formvalue._se_cityid eq '755' and (formvalue._se_ruleid eq 'A21' or formvalue._se_ruleid eq 'A22' or formvalue._se_ruleid eq 'A23') and item[0].ruleitemid eq 'CB1001'}">
	                 	  	<input type="checkbox" name="ruleitemids" <c:out value='${item[0].checked}' /> <c:out value='${item[0].disabled}' /> value="<c:out value='${item[0].ruleitemid}|${item[0].state}' />"
				                     onclick="checkRuleitem(this);" class="table_checkbox" disabled = 'true'>
				        </c:when>
				        <c:otherwise>
				        	<c:if test="${formvalue.hasRuleexp eq false}">
	                 			<input type="checkbox" name="ruleitemids" <c:out value='${item[0].checked}' /> <c:out value='${item[0].disabled}' /> value="<c:out value='${item[0].ruleitemid}|${item[0].state}' />"
				                     onclick="checkRuleitem(this);" class="table_checkbox">
				          </c:if>
				          <c:if test="${formvalue.hasRuleexp eq true}">
				          		<input type="checkbox" name="ruleitemids" <c:out value='${item[0].checked}' /> <c:out value='${item[0].disabled}' /> value="<c:out value='${item[0].ruleitemid}|${item[0].state}' />"
				                     onclick="checkRuleitem(this);" class="table_checkbox" disabled = 'true'>
				          </c:if>
				        </c:otherwise>
			          </c:choose>
			         </td>
                     <td >
                         <c:out value="${item[0].ruleitemid}"/>
                     </td>
                     <td width="400">
                         <c:out value="${item[1].ruleitemname}"/>
                     </td>
                     <td >
                     	<c:choose>
								<c:when test="${item[0].state=='0'}">
									<font color=red><bean:message bundle="rulerel" key="invalid"/></font>
								</c:when>
								<c:otherwise>
									<bean:message bundle="rulerel" key="valid"/>
								</c:otherwise>
							</c:choose>
                     
                     </td>
                 </tr>
             </c:forEach>

        </table>
         
        </div>
   		</aa:zone>
        </td>
         </tr>
        </table>
     
   </div>
   	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                	<c:choose>
						<c:when test="${requestScope.INVALID=='false' || requestScope.LIST.rowCount==0 || formvalue.hasRuleexp eq true}">
							<input type="button" disabled="true" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/reward/rulerel.do?CMD=SAVE2')"/>
						</c:when>
						<c:otherwise>
							<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/reward/rulerel.do?CMD=SAVE2')"/>
						</c:otherwise>
						</c:choose>
                        <input type="button" class="query" onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" 
                                onblur="buttonout(this)" onclick="doReturn();"
                                value="<bean:message bundle="public" key="button_return"/>" />
                     
                </td>
			</tr>
		</table>
	</div>
	
	<c:if test="${formvalue._se_ruleid eq 'A21'}">
		<div class="table_div">
	      <table class="form_table">
	       <tr>
	      		<td width="100%">
	      			������ϸ"CB1001 ״̬�Ѽ���"�Ĳ���˵��:
	      		</td>
	       </tr>
	       <tr>
	      		<td width="100%">
	      			����͵Ǽ���ͬһ��:���ڡ���ɽ����ݸ
	      		</td>
	       </tr>
	       <tr>
	      		<td width="100%">
	      			����͵Ǽ���ͬһ��:���ݡ�����
	      		</td>
	       </tr>
	       <tr>
	      		<td width="100%">
	      			����ǰ��24Сʱ�ڵǼ�:����
	      		</td>
	       </tr>
	       <tr>
	      		<td width="100%">
	      			��:���ڲ���Ҫѡ������ϸ"CB1001 ״̬�Ѽ���",ϵͳ���Զ����������⴦��,�������а�ʵ�����ѡ��(ѡ��ѡ),�������û���ر�ָ���ĵ���,Ĭ�ϰ�"����͵Ǽ���ͬһ��"����
	      		</td>
	       </tr>
	      </table>
	   </div>
   </c:if>
   
   
   <div class="table_div">
	      <table class="form_table">
	       <tr>
	       		<td width="15%">
	      		<td width="85%"><font color="red">&nbsp;&nbsp;&nbsp;&nbsp;Ŀǰ,ϵͳ�������汻��ѡ�Ĺ�����ϸ��������У��,ֻ����ѡ������ϸ������ʱ�żƳꡣ����й�˾�и��Ի���������ĳ��ҵ����ҪУ��3��������ϸA��B��C,У���߼�Ϊ��ֻҪ����A��B�е�һ��Ȼ��������C�����ɼƳꡣ�������ƱȽϸ��ӵĸ��Ի��������й�˾��ϵ�����̺�̨����������Ӧ������ϸ��</font></td>
	       </tr>
	       <c:if test="${formvalue.hasRuleexp eq true}">
	       <tr>
	      		<td width="15%" align="right">��̨���õĹ���������ϸ���ʽ:</td>
	      		<td width="85%" align="left"><c:out value='${formvalue.ruleitemexp}'/></td>
	       </tr>
	       <tr>
	      		<td width="15%" align="right">��ע:</td>
	      		<td width="85%" align="left"><c:out value='${formvalue.remark}'/></td>
	       </tr>
	       </c:if>
	      </table>
	</div>
</html:form>
</div>
</body>
</html>
