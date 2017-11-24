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
        
     function showAccBilling(cityid,rhphase){
        	var url;
			url ="<%=contextPath%>/fee/billing/rhruledeta_show.do?_ne_validbillcyc="+formList._ne_validbillcyc.value;	
			url =url+"&region="+cityid+"&_ne_rhphase="+rhphase;	
			window.open(url,'<s:text name ="title" />',"width=600px, height=250px, status=no, resizable=yes,top="+(window.screen.availHeight-390)/2+",left="+(window.screen.availWidth-600)/2);
        }
	
		
    </script>
    <style type="text/css">
	    .point {
			background:url(images/accounting/point5.jpg) no-repeat 0px 0px;text-align:center;
		}
	</style>
</head>

<body onload="loadforiframe1();">

<s:form action="/fee/billing/rhtouchrule_city.do" key="formList" cssStyle="formList" theme="simple" method="post" onsubmit="return ev_check();">
    <s:hidden property="_orderby"/>
    <s:hidden property="_desc"/>
    <s:hidden property="_pageno"/>
    <s:hidden property="_pagesize"/>	
	<s:hidden property="form._ne_validbillcyc"/>	
	<s:hidden property="form.regiongroup"/>
	
	 
    <div class="table_div">
		<table class="error_text">
			<s:actionerror/>
			<s:actionmessage />
		</table>
	</div>     

	<div class="table_div" style="text-align:left;">
		<span class="point" style="width:750px;height:20px;padding:9px 0 0 500px;margin-top:0px;">
		点击此处[ <a href="javascript:history.back(-1);" class="">返回</a> ]总控流程</span>	
	</div>
    <div class="table_div" style="text-align: left;">
        <table class="table2">	
        
        <s:iterator var="item" value="#request.LIST">        		       	
            <tr>
            	<td width="10px"></td>	
            	<td class="location" width="80px">
            	<j:code2Name code="#item.cityid" definition="CITYIDNUM2NMAME" />:
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
<br><br><br>
</s:form>

</body>
</html>





























