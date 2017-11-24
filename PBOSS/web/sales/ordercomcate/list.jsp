<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>

<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        
            addfield('param._se_orderid', '<s:text name="orderid"/>', 'c', true, '18');
            addfield('param._se_ordercomtype', '<s:text name="ordercomtype"/>', 'c', true, '16');
            addfield('param._se_comcategory', '<s:text name="comcategory"/>', 'c', true, '20');
            addfield('param._ne_orderamt', '<s:text name="orderamt"/>', 'f', true, '10');
            return checkval(window);
        }
        
        var count = 0;//数量
        var total = 0;//总价
        
        //迭加数量和总价
        function stat(num,price){
        	count += num;
        	total += price;
        }

    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="ordercomcate_list.do" key="formList" cssStyle="formList" theme="simple" >
	<%//下面的控件给Action提供数据，用来分页%>
    <aa:zone name="hiddenZone"><s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/></aa:zone>
    <s:hidden name="param._se_orderid"/>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
		</div>
	</div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
                	<s:i18n name="public">

                    <input type="button" id="btnBack" name="btnBack" class="button_back" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_return"/>" onClick="doReturnInFrame('/sales/order_list.do?backFlag=true');">
                   </s:i18n>
				</td>
			</tr>
		</table>
	</div>
    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>
<!-- 
	<div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="center"><s:text name="orderid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_orderid" />
                </td>
                <td align="center"><s:text name="ordercomtype"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_ordercomtype" />
                </td>
                <td align="center"><s:text name="comcategory"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_comcategory" />
                </td>
                <td align="center"><s:text name="orderamt"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_orderamt" />
                </td>
            </tr>
        </table>
    </div>
    --> 
    

	<aa:zone name="listZone">
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style">
            <tr class="table_style_head">
               	<s:i18n name="public">
                <td >
                    序号
                </td>
                </s:i18n>
                
                <td>
                    <j:orderByImg href="javascript:doOrderby('ordercomtype')"><s:text name="ordercomtype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comcategory')"><s:text name="comcategory"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('orderamt')"><s:text name="orderamt"/>(套)</j:orderByImg>                 
                </td>
                <td>
                    <s:text name="planName"/>            
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('unitprice')"><s:text name="unitprice"/>(元)</j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('totalprice')"><s:text name="totalprice"/>(元)</j:orderByImg>               
                </td>
            </tr>
            <s:iterator value="dp.datas" status="state">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                        <s:text name="#state.count"/>
                     </td>
                    
                     <td><j:code2Name definition="$FX_ORDERCOMTYPE" code="ordercomtype"/></td>
                     <td><j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory"/></td>
                     <td><s:property value="orderamt" /></td>
                     <td><s:property value="planName" /></td>
                     <td><s:property value="unitprice" /></td>
                     <td><s:property value="totalprice" /></td>
                 </tr>
                 <script language="javascript">
                 	stat(<s:property value="orderamt"/>,<s:property value="totalprice"/>);
                 </script>
             </s:iterator>
             <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
             	<td>合计</td>
             	<td></td>
             	<td></td>
             	<td><script language="javascript"> document.write(count) </script></td>
             	<td></td>
             	<td></td>
             	<td><font color="red"><script language="javascript"> document.write(total) </script></font></td>
             </tr>
        </table>
        </div>
    </div>
    <div class="table_div">
		<%@ include file="/common/pageNav.jsp"%>
   	</div>
    </aa:zone>
</s:form>
</div>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	//ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	//ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnDelete");
</script> 
</body>
</html>
