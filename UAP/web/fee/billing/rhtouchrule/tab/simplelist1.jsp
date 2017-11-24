<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="title"/></title>
    <base target="_self">
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {                    
            return checkval(window);   
        } 
        
     function showAccBilling(region,rhphase){
        	var url;
			url ="<%=contextPath%>/fee/billing/rhruledeta_show.do?_ne_validbillcyc="+formList._ne_validbillcyc.value;	
			url =url+"&_ne_region="+region+"&_ne_rhphase="+rhphase;	
			window.open(url,'<bean:message bundle="rhruledeta" key="title" />',"width=600px, height=250px, status=no, resizable=yes,top="+(window.screen.availHeight-390)/2+",left="+(window.screen.availWidth-600)/2);
        }
		
    </script>
    <style type="text/css">
	    .point {
			background:url(images/accounting/point5.jpg) no-repeat 0px 0px;text-align:center;
		}
	</style>
</head>

<body onload="parent.reloadiframe(document.body.scrollHeight);">

<s:form action="/fee/billing/rhtouchrule_simpleinfo1.do" key="formList" cssStyle="formList" theme="simple" method="post" onsubmit="return ev_check();">
    <s:hidden name="_orderby"/>
    <s:hidden name="_desc"/>
    <s:hidden name="_pageno"/>
    <s:hidden name="_pagesize"/>	
	<s:hidden name="form._ne_validbillcyc"/>	
	<s:hidden name="form.regiongroup"/>
	
	 
    <div class="table_div">
		<table class="error_text">
			<s:actionerror />
			<s:actinmessage />
		</table>
	</div>     

	<div class="table_div" style="text-align:left;padding:0px 0px 0 70px;">
		<span class="point" style="width:600px;height:20px;padding:0px 0px 0 0px;margin-top:0px;"></span>	
	</div>
    <div class="table_div" style="text-align: left;">
        <table class="table2">	
        <s:iterator var="item" value="#request.List">       		       	
            <tr>
            	<td height="10px" width="80px"></td>	
            	<td class="location" width="80px">
            	<s:Code2Name code="#item.cityid" definition="CITYCOMPANY" />:
            	</td>			
				<td class="mybox_0">计费</td>
				
				
				<td  style="cursor:hand;" onclick="showAccBilling('<s:property value='#item.cityid'/>',0)" class="jiantou<s:property value='#FLFLAG.flischeck + 0'/>"></td>  	
				<td class="mybox_<s:property value='#FLFLAG.flstate + 1'/>">分流</td>

				<td  style="cursor:hand;" onclick="showAccBilling('<s:property value='#item.cityid'/>',1)" class="jiantou<s:property value='#item.lzischeck + 0'/>"></td>
                <td class="mybox_<s:property value='#item.lzstate + 1'/>">累帐解析</td>

				<td  style="cursor:hand;" onclick="showAccBilling('<s:property value='#item.cityid'/>',2)" class="jiantou<s:property value='#item.lzischeck2 + 0'/>"></td>
                <td class="mybox_<s:property value='#item.lzstate2 + 1'/>">实时累帐</td>
                
            </tr> 
            <tr>
              	<td height="10px"></td>			
				<td></td>	
				<td></td>	
				<td></td>	
				<td></td>	
				<td></td>	
				<td></td>	
				<td></td>	
				<td></td>	  
				<td></td>	          
            </tr>
         </s:iterator>    
          
        </table>
    </div>
</s:form>

</body>
</html>





























