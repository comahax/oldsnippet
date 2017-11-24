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
    <title><bean:message bundle="chpwfiletransfer" key="titleList"/></title>
     <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
     <script type="text/javascript" src="<%=contextPath%>/js/jquery/jquery-1.3.2.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            	addfield('_dnl_datadate', '起始时间', 'dt', false, '19');
            	addfield('_dnm_datadate', '终止时间', 'dt', false, '19');
                return checkval(window);
            }
        
         function exports(mothed){
        	if (ev_check()) {
        		errorobj.innerHTML = "";
        		var form = document.forms[0]; 
				form.action = "<%=contextPath%>/cms/chpwfiletransfer.do?CMD=DOWNLOAD&seq=" +mothed ;
				form.submit();
				form.action = "<%=contextPath%>/cms/chpwfiletransfer.do?CMD=LIST";
        	}
		}
		
		function exportsall(mothed){
		     var length = $("input:checkbox[name=_selectitem]:checked").length;
        	if (ev_check() ) { 
        	    if (length>0){
        		errorobj.innerHTML = "";
        		var form = document.forms[0]; 
				form.action = "<%=contextPath%>/cms/chpwfiletransfer.do?CMD=" +mothed ;
				form.submit();
				form.action = "<%=contextPath%>/cms/chpwfiletransfer.do?CMD=LIST";
				} else{
				alert("请选择需要下载的报表");
				}
        	}
		}
		
		
    </script>
    
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/chpwfiletransfer.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/chpwfiletransfer/ChPwFiletransferForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chpwfiletransfer" key="titleList"/>
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
            	
            	<td width="20%" height="20" align="right" class="form_table_right" >起始时间:</td>
                <td width="30%" class="form_table_left">
                  <html:text styleClass="form_input_1x" property="_dnl_datadate" onclick="this.value=selectDatetime()"/> 
                    <font color=red>*</font>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" >终止时间:</td>
                <td width="30%" class="form_table_left">
                  <html:text styleClass="form_input_1x" property="_dnm_datadate" onclick="this.value=selectDatetime()"/> 
                    <font color=red>*</font>
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
                            
                             <input type="button" class="button_6" value="批量下载" class="comfir"  
                   		    onmouseover="buttonover(this)" onclick="exportsall('DOWNLOADALL');"
                   		    onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)" >
                         
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
                    <a href="javascript:doOrderby('seq')"> 序号</a>
                    <s:OrderImg form="/cms/chpwfiletransfer/ChPwFiletransferForm" field="seq"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="chpwfiletransfer" key="cityid"/></a>
                    <s:OrderImg form="/cms/chpwfiletransfer/ChPwFiletransferForm" field="cityid"/>
                </td> 
                <td>
                    <a href="javascript:doOrderby('filename')"><bean:message bundle="chpwfiletransfer" key="filename"/></a>
                    <s:OrderImg form="/cms/chpwfiletransfer/ChPwFiletransferForm" field="filename"/>
                </td>
                 <td>
                    <a href="javascript:doOrderby('datadate')"><bean:message bundle="chpwfiletransfer" key="datadate"/></a>
                    <s:OrderImg form="/cms/chpwfiletransfer/ChPwFiletransferForm" field="datadate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('receivetime')"><bean:message bundle="chpwfiletransfer" key="receivetime"/></a>
                    <s:OrderImg form="/cms/chpwfiletransfer/ChPwFiletransferForm" field="receivetime"/>
                </td>
                 <td>
                     操作
                </td>
               
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}" varStatus="sta">
                 
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value="${item.seq}"/>"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td><c:out value="${sta.count}"/></td>
                     <td> <s:Code2Name code="${item.cityid}" definition="#CITYNAME" />  </td> 
                     <td><c:out value="${item.filename}"/></td>
                      <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.datadate}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.receivetime}"/></td>
                     <td><input type="button" class="button_4" value="点击下载" class="comfir" onmouseover="buttonover(this)" onclick="exports('<c:out value="${item.seq}"/>');"
                   		    onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)" ></td>
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
