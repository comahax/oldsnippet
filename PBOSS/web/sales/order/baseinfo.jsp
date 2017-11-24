<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
    //�������״̬Ϊ������ɡ������ϡ�����һ������ťʧЧ
        function showOrDisabledDoNext(orderstate){
        	if("CANCEL" == orderstate || "FINISHED" == orderstate){
        		document.getElementById('button_doNext').disabled="none";
        	}else{
        	document.getElementById('button_doNext').disabled="";
        	}
        }
        
        //	������״̬Ϊ������ɡ��͸���״̬��Ϊ���Ѹ��ˡ�ʱ���˰�ť�ɼ���
        //	ǰ�������ǵ�ǰ�����и�����
        function showOrDisabledDoReview(orderstate, reviewstate){
        	if(document.getElementById('buttonReview').disabled){//�����ã��û������ƣ�
	        	document.getElementById('buttonReview').style.display = "none";
        	}else{
        		if(1 != reviewstate && "FINISHED" == orderstate){//������״̬Ϊ������ɡ��͸���״̬��Ϊ���Ѹ��ˡ�ʱ���˰�ť�ɼ���
        			document.getElementById('buttonReview').style.display = "";
	        	}else{
	        		document.getElementById('buttonReview').style.display = "none";
	        	}
        	}
        }
        function doReview(){
        	var orderid = '<s:property value="form.orderid"/>';
        	if(window.confirm("��Ҫ���ˣ���ȷ�ϡ�")){
    			var actionUrl = "<%=contextPath%>/sales/order_review.do";
    			$.post(actionUrl,
		        {'form.orderid':orderid},
				     function(data){
				     	alert(data);
				     	window.location.reload(); 
				     }   
		        ); 
		       
	 		}
	 		
        }
        
        //������һ������
        function doNext(actionUrl){
        var orderid = '<s:property value="form.orderid"/>';
        	$.post("<%=contextPath%>"+actionUrl,
	        {'form.orderid':orderid},
			     function(data){
			     var result = data.split(',');
			     if('0' == result[0]){
			     window.location.href ="<%=contextPath%>"+result[1]+"?param._pk="+orderid+"&param._se_orderid="+orderid;
			     	//window.open(result[1]+"?param._pk="+orderid+"&param._se_orderid="+orderid);
			     }else{
				     var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>'+result[1]+'</span> ';
					errorMessageShow(alertstr);
			     }
			       
			     }   
	        ); 
        }

    </script>
</head>
<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="order_list.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" >
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_orderid"/>
    <s:hidden name="param._se_wayid"/>
    <s:hidden name="param._se_orderave"/>
    <s:hidden name="param._dnm_createtime"/>
    <s:hidden name="param._dnl_createtime"/>
    <s:hidden name="param._se_orderstate"/>
	
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
					<j:purChk permid="FX_ORDERMG_REVIEW">
                    <input type="button" id="buttonReview" name="buttonReview" class="button_4" onmouseover="buttonover(this);" 
	                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="����" onclick="doReview();" />
	               </j:purChk>
                    <input type="button" id="button_doNext" name="btnSave" class="button_4" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="doNext"/>" onclick="doNext('/sales/order_nextProcess.do')" />
                    <input type="button"  name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturnInFrame('/sales/order_list.do?backFlag=true');">
				</s:i18n>
		    	</td>
		    </tr>
		 </table>
	</div>
	<div class="error_text" >
		<table class="error_text">
			<s:actionerror /><s:actionmessage/>
		</table>
	</div>
	
    <div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="right"><s:text name="orderid"/>:&nbsp</td>
                <td align="left">
					<s:property value="form.orderid"/>
                </td>
                <td align="right"><s:text name="createtime"/>:&nbsp</td>
                <td align="left">
					<s:date name="form.createtime" format="yyyy-MM-dd"/>
                </td>
                <td align="right"><s:text name="orderstate"/>:&nbsp</td>
                <td align="left">
					<j:code2Name definition="$FX_ORDERFSTATE" code="form.orderstate"/>
                </td>
            </tr>
            <tr>
             	<td align="right"><s:text name="wayid"/>:&nbsp</td>
                <td align="left">
					<s:property value="form.wayid" />
                </td>
                 <td align="right">����������:&nbsp</td>
                <td align="left">
					<j:code2Name definition="#WAYIDINFO" code="form.wayid"/>
                </td>
                 <td align="right"><s:text name="cooptype"/>:&nbsp</td>
                <td align="left">
					<s:property value="form.custwaytypename" />
                </td>
            </tr>
            <tr>
            	<td align="right"><s:text name="countyid"/>:&nbsp</td>
                <td align="left">
					<j:code2Name definition="#CNTYCOMPANY" code="form.countyid"/>
					
                </td>
                <td align="right"><s:text name="mareacode"/>:&nbsp</td>
                <td align="left">
					<j:code2Name definition="#MICROAREA" code="form.mareacode"/>
                </td>
                
                <td align="right"><s:text name="starlevel"/>:&nbsp</td>
                <td align="left">
					 <j:code2Name definition="$CH_STARLEVEL" code="form.starlevel"/>
                </td>
            </tr>

            <tr>
            	<td align="right"><s:text name="orderave"/>:&nbsp</td>
                <td align="left">
					<j:code2Name definition="$FX_ORDERAVE" code="form.orderave"/>
                </td>
            	<td align="right"><s:text name="paytype"/>:&nbsp</td>
                <td align="left">
					<j:code2Name definition="$FX_PAYTYPE" code="form.paytype"/>
                </td>
                <td align="right"><s:text name="delitype"/>:&nbsp</td>
                <td align="left">
					<j:code2Name definition="$FX_DELITYPE" code="form.delitype"/>
                </td>
            </tr>

            <tr>
                <td align="right"><s:text name="recamt"/>:&nbsp</td>
                <td align="left">
					<s:property value="form.recamt"/>
                </td>
                <td align="right"><s:text name="actamt"/>:&nbsp</td>
                <td align="left">
					<s:property value="form.actamt"/>
                </td>
                 <td align="right"><s:text name="posstream"/>:&nbsp</td>
                <td align="left">
					<s:property value="form.posstream"/>
                </td>
              </tr>
              <tr>
                <td align="right"><s:text name="paytime"/>:&nbsp</td>
                <td align="left">
					<s:date name="form.paytime" format="yyyy-MM-dd HH:mm:ss"/>
                </td>
                <td align="right"><s:text name="deductstate"/>:&nbsp</td>
                <td align="left">
					<j:code2Name definition="$FX_DEDUCTSTATE" code="form.deductstate"/>
                </td>
                <td align="right"><s:text name="bossworkfid"/>:&nbsp</td>
                <td align="left">
					<s:property value="form.bossworkfid"/>
                </td>
              
                
              </tr>
              <tr>
                <td align="right"><s:text name="alarmlevel"/>:&nbsp</td>
                <td align="left">
					<j:code2Name definition="$FX_STOCKALARMLEVEL" code="form.alarmlevel"/>
                </td>
                <td align="right"><s:text name="confirmflag"/>:&nbsp</td>
                <td align="left">
					<j:code2Name definition="$IM_YESNO10" code="form.confirmflag"/>
                </td>
               	 <td align="right"><s:text name="orderinfo"/>:&nbsp</td>
                <td align="left">
						<s:property value="form.orderInfo"/>
                </td>
              </tr>
             <tr>
             	<td align="right"><s:text name="discomcode"/>:&nbsp</td>
                <td align="left">
					<j:code2Name definition="#WAYIDINFO" code="form.discomcode"/>
                </td>
               	<td align="right"><s:text name="signstate"/>:&nbsp</td>
                <td align="left" >
               	 <j:code2Name definition="$FX_SIGNSTATE" code="form.signstate"/>
                </td>
                <td align="right">����ʱ��:&nbsp</td>
                <td align="left" >
					<s:date name="form.auditTime" format="yyyy-MM-dd HH:mm:ss"/>
                </td>
                
            </tr>
            <tr>
             	
                <td align="right"><s:text name="memo"/>:&nbsp</td>
                <td align="left" colspan='5'>
						<s:property value="form.memo"/>
                </td>
                
            </tr>
             
            
        </table>
    </div>

    
</s:form>
</div>
</body>
</html>
<script >
showOrDisabledDoNext('<s:property value="form.orderstate"/>');
showOrDisabledDoReview('<s:property value="form.orderstate"/>','<s:property value="form.reviewstate"/>');
</script>
