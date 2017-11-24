<%@ page language="java" contentType="text/html;charset=utf-8"%>

<%@ include file="/inc/contenthead.inc" %>
<%

    String ID_1 = "4D3C2B1AAABT1";
    String ID_2 = "4D3C2B1AAABT2";
    String ID_3 = "4D3C2B1AAABT3";
%>
<html>
<head>
	<base target="_self">
	<title><s:text name="title"/></title>
	<script language="JavaScript">
        function ev_checkval() {
           			
			addfield('_ne_region', '<s:text name="region" />', 'c', false, 14);
			addfield('validbillcyc', '<s:text name="validbillcyc"/>', 'l', false, 8);
	        addfield('state', '<s:text name="state"/>', 'l', false, 3);
	        addfield('begindate', '<s:text name="begindate"/>', 'dt', false, 20);
	        addfield('enddate', '<s:text name="enddate"/>', 'dt', false, 20);
	        addfield('descinfo', '<s:text name="descinfo"/>', 'c', true, 255);
	        addfield('billcyccode', '<s:text name="billcyccode"/>', 'c', true, 10);
	        //if(date_compare("begindate","enddate","<s:text name='date_compare'/>")) return false;
	            
	        return checkval(window);
                     
        }
        
    </script>
</head>
<body onload="loadforiframe();">
	<div class="table_container">
	    <s:form action="validbillcyc_save.do" key="formItem" method="post" theme="simple">
		
			<s:hidden styleClass="form_input_1x" property="billmodeid"
				value="1" />
			<s:hidden property="cmdState" />

			<s:hidden property="_orderby" />
			<s:hidden property="_desc" />
			<s:hidden property="_pageno" />
			<s:hidden property="_pagesize" />
			<s:hidden property="validbillcyc" />
			
			<s:hidden property="_ne_validbillcyc" />
			<s:hidden property="regiongroup" />
            
			<div class="widgetL">
			<div class="wCenter"> 
			<div class="content">
			<div class="title_name"><s:text name="title"/></div>
			<aa:zone name="errorZone"><div class="error_text"><s:actionerror/><s:actionmessage/></div></aa:zone>
			<div class="search2" style="float: center;" align="center">
			<table width="100%"  border="0" cellspacing="0" cellpadding="0">
			        <tr>
				    <th><font color="red">*</font><s:text name="validbillcyc"/>：</th>
				    <td>
						<s:textfield cssClass="input" name="form.validbillcyc" id="validbillcyc" readonly="true" onfocus="WdatePicker({skin:'default',dateFmt:'yyyyMM00'})"></s:textfield>
				    </td>
			        </tr>
			         <tr style="padding-top:5px">
			        	<th><font color="red">*</font><s:text name="state"/>：</th>
				        <td>
				        	<j:selector definition="$IB_BILLCYCSTATE" name="form.state"  cssClass="input"/>
				        </td>
			        </tr>
			        <tr style="padding-top:5px">
			        	<th><font color="red">*</font><s:text name="begindate"/>：</th>
				        <td>
				        	<s:textfield name="form.begindate"  id="form.begindate" onfocus="WdatePicker({skin:'default',dateFmt:'yyyy-MM-dd HH:mm:ss'})" cssClass="Wdate" readonly="true"></s:textfield>
				        </td>
			        </tr>
			        <tr style="padding-top:5px">
			        	<th><font color="red">*</font><s:text name="enddate"/>：</th>
				        <td>
				        	<s:textfield name="form.enddate"  id="form.enddate" onfocus="WdatePicker({skin:'default',dateFmt:'yyyy-MM-dd HH:mm:ss'})" cssClass="Wdate" readonly="true"></s:textfield>
				        </td>
			        </tr>
			        <tr style="padding-top:5px">
			        	<th><s:text name="billcyccode"/>：</th>
				        <td>
				        	<s:textfield name="form.billcyccode" id="form.billcyccode" cssClass="input" maxlength="20" />
				        </td>
			        </tr>
			        <tr style="padding-top:5px">
			        	<th><font color="red">*</font><s:text name="region"/>：</th>
				        <td>
				        	<j:selector definition="CITYIDCODE" name="form._ne_region" cssClass="input"/>
				        </td>
			        </tr>
			        <tr style="padding-top:5px">
			        	<th><s:text name="descinfo"/>：</th>
				        <td>
				        	<s:textarea name="form.descinfo" id="form.descinfo" cssClass="input"  />
				        </td>
			        </tr>
			
			<tr>
				<td colspan="4" align="right">
					<input type="button" id="btnSave" onmouseover=this.className="bt48" onMouseOut="this.className='bt48_gray'"
			                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
			                           value="<s:text name="button_save"/>" class="bt48_gray"
			                           onclick="doSave('/fee/billing/validbillcyc_save.do')"/>
			     	<input type="button" onmouseover=this.className="bt48" onMouseOut="this.className='bt48_gray'"
			                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
			                           value="<s:text name="button_close"/>" class="bt48_gray"
			                           onclick="doReturn('/fee/billing/validbillcyc_list.do')"/>
				</td>
			</tr>
			
			</table>
			</div>
			</div>
		</div>
	</div>
</s:form>
</body>
</html>
