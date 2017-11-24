<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>

<html>
<head>
    <title><bean:message bundle="acct" key="titleList"/></title>
    <base target="_self">

    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('_ne_acctid', '<bean:message bundle="acct" key="acctid"/>', 'l', true, 14);
            addfield('_sk_acctname', '<bean:message bundle="acct" key="acctname"/>', 'c', true, 128);
            addfield('_ne_accttype', '<bean:message bundle="acct" key="accttype"/>', 'i', true, 3);
            addfield('_ne_acctstate', '<bean:message bundle="acct" key="acctstate"/>', 'i', true, 3);
            addfield('_ne_acctlevel', '<bean:message bundle="acct" key="acctlevel"/>', 'i', true, 3);
            return checkval(window);
        }
        
       window.returnValue = "";
       function doOK(value) {
	   		window.returnValue = value;
	   		window.close();
	   }
	   function doConfirm(){
			var sel=document.all("_selectitem");
	   		var str="";
	   		if (sel.length != null) {
		   		for(var i=0;i<sel.length;i++){
		   			if(sel[i].checked==true){
		   				str=str+sel[i].value+",";
		   			}
		   		}
		   		str = str.substring(0,str.length-1);
		   		window.returnValue=str;
		    	window.close();
		   	}else{
		   		window.returnValue=sel.value;
		   		window.close();
		   	}
	   }
    </script>
</head>

<body onload="document.formList._sk_acctname.focus()" onclose="javascript:window.returnValue = ''">
<div class="table_container">
<html:form action="/cms/reward/cbopnacctmap.do?CMD=SELECT" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

	<div class="table_div">
		<table class="top_table">
			<tr>
				<td><bean:message bundle="acct" key="custMsg"/></td>

            </tr>
        </table>
    </div>
    <div class="table_div">
		<table class="error_text">
			<html:errors />
			<s:Msg />
		</table>
	</div>

	<div class="table_div">
        <table class="form_table">
            <tr>
            	<td class="form_table_right"><bean:message bundle="acct" key="acctid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_ne_acctid"  maxlength="14"></html:text>
                </td>
                <td class="form_table_right"><bean:message bundle="acct" key="acctname"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_acctname"  maxlength="128"></html:text>
                </td>
            </tr>
            <tr>
                <td class="form_table_right"><bean:message bundle="acct" key="accttype"/>:</td>
                <td class="form_table_left">
                    <html:select property="_ne_accttype">
                    	<html:option value=""></html:option>
                    	<s:Options definition="$IB_FEETYPE"/>
                    </html:select>
                </td>
                <td class="form_table_right"><bean:message bundle="acct" key="acctlevel"/>:</td>
                <td class="form_table_left">
                    <html:select property="_ne_acctlevel">
                    	<html:option value=""></html:option>
                    	<s:Options definition="$IB_FEELEVEL"/>
                    </html:select>
                </td>
            </tr>
             <tr>
             <td class="form_table_right"><bean:message bundle="acct" key="acctstate"/>:</td>
                <td  align="left" colspan="3">
                    <html:select property="_ne_acctstate">
                    	<html:option value=""></html:option>
                    	<s:Options definition="$IB_ACCTSTATE"/>
                    </html:select>
                </td>
                </tr>
        </table>
    </div>

	<div class="table_div">

		<table class="table_button_list">
			<tr>
			   <td>
                 	<input type="button" class="query" onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" onclick="doQuery()"/>
                    <input type="button" class="query"
							onmouseover="buttonover(this);" onmouseout="buttonout(this);"
							onfocus="buttonover(this)" onblur="buttonout(this)"
							value="<bean:message bundle="public" key="button_confirm"/>"
							onclick="doConfirm();" />
        </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
    <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head"  >
            	<td title="<bean:message bundle="public" key="list_title_select"/>">
					          	        <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td>
                    <a href="javascript:doOrderby('acctid')"><bean:message bundle="acct" key="acctid"/></a>
                    <s:OrderImg form="/fee/woff/acct/AcctForm" field="acctid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('acctname')"><bean:message bundle="acct" key="acctname"/></a>
                    <s:OrderImg form="/fee/woff/acct/AcctForm" field="acctname"/>
                </td>           
                <td>
                    <a href="javascript:doOrderby('acctstate')"><bean:message bundle="acct" key="acctstate"/></a>
                    <s:OrderImg form="/fee/woff/acct/AcctForm" field="acctstate"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr style="cursor:hand" class="table_style_content" align="center" >
                  	 <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.acctid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td onclick="doOK('<c:out value="${item.acctid}"/>');">
                         <c:out value="${item.acctid}"/>
                     </td>
                     <td onclick="doOK('<c:out value="${item.acctid}"/>');">
                         <c:out value="${item.acctname}"/>
                     </td>
                    <td onclick="doOK('<c:out value="${item.acctid}"/>');">
                    	<s:Code2Name code="${item.acctstate}" definition="$IB_ACCTSTATE"/>
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