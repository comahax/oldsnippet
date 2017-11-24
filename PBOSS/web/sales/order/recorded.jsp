<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title>入帐</title>
    <script type="text/javascript" src="/js/pub/json2.js"></script>
    <script language="javascript" src="<%=contextPath%>/js/pub/LodopFuncs.js"></script>
		<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
		</object>
    <script language="JavaScript">
    	function ev_checkval() {
       		return true;
        }
        
        function waitSyn()
        {
        	formItem.action = contextPath + '/sales/order_recordByBoss.do';
        	formItem.submit();
        }
        $(document).ready(function(){
        	var step = $("#step").val();
        	//调用华为接口
        	if(step=='2')
        	{
        		$("#btnSave").attr("disabled",true);
        		$("#btnReturn").attr("disabled",true);
        		var delaySeconds = $("#delaySeconds").val();
        		var delayMilliseconds = delaySeconds * 1000;
        		delayMilliseconds = 1;
        		window.setTimeout("waitSyn()", delayMilliseconds);
        	}
        	if(step=='3')
        	{
        		$("#btnReturn").attr("disabled",false);
        	}
        });
        
    </script>
</head>
<body>
<div class="table_container">
<s:form action="order_recorded.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
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
    <s:hidden name="param._pk"/>
	
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea"><s:text name="titleList"/></span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h">订单入帐</span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
		</div>
	</div>

	<div class="error_text" id="msg">
		<table class="error_text">
			<s:actionerror /><s:actionmessage/>
		</table>
	</div>
	
    <div class="table_div">
        <table class="table_normal">
        <s:hidden name="form.orderid"/>
        <s:hidden name="form.flowid"/>
        <s:hidden name="form.step" id="step"/>
        <s:hidden name="form.delaySeconds" id="delaySeconds"/>
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
						<s:property value="form.wayid"/>
                </td>
                 <td align="right">合作商名称:&nbsp</td>
                <td align="left">
						<j:code2Name definition="#WAYIDINFO" code="form.wayid"/>
                </td>
                
                <td align="right"><s:text name="orderave"/>:&nbsp</td>
                <td align="left">
						<j:code2Name definition="$FX_ORDERAVE" code="form.orderave"/>
                </td> 
            </tr>
            <tr>
            	<td align="right"><s:text name="countyid"/>:&nbsp</td>
                <td align="left">
						<j:code2Name definition="#CNTYCOMPANY" code="form.countyid"/>
                </td>
                <td align="right"><s:text name="cooptype"/>:&nbsp</td>
                <td align="left">
						<s:property value="form.custwaytypename" />
                </td>
                <td align="right"><s:text name="starlevel"/>:&nbsp</td>
                <td align="left">
						<j:code2Name definition="$CH_STARLEVEL" code="form.starlevel"/>
                </td>
            </tr>
            <tr>
            	 <td align="right"><s:text name="paytype"/>:&nbsp</td>
                <td align="left">
						<j:code2Name definition="$FX_PAYTYPE" code="form.paytype"/>
                </td>
                <td align="right"><s:text name="delitype"/>:&nbsp</td>
                <td align="left">
						<j:code2Name definition="$FX_DELITYPE" code="form.delitype"/>
                </td>
                <td align="right"><s:text name="posstream"/>:&nbsp</td>
                <td align="left">
						<s:property value="form.posstream"/>
                </td> 
            </tr>
            <tr>
            	 <td align="right"><s:text name="bossworkfid"/>:&nbsp</td>
                <td align="left">
						<s:property value="form.bossworkfid"/>
                </td>
            	 <td align="right"><s:text name="recamt"/>:&nbsp</td>
                <td align="left">
						<s:property value="form.recamt"/>
                </td>
                <td align="right"><s:text name="actamt"/>:&nbsp</td>
                <td align="left">
						<s:property value="form.actamt"/>
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
                <td align="right"><s:text name="discomcode"/>:&nbsp</td>
                <td align="left">
					<j:code2Name definition="#WAYIDINFO" code="form.discomcode"/>
                </td>
              </tr>
              
               <tr>
               <td align="right"><s:text name="signstate"/>:&nbsp</td>
                <td align="left" >
               	 <j:code2Name definition="$FX_SIGNSTATE" code="form.signstate"/>
                </td>
               <td align="right"><s:text name="orderinfo"/>:&nbsp</td>
                <td align="left" colspan="3">
						<s:property value="form.orderInfo"/>
                </td>
                
            </tr>
              <tr>
                <td align="right"><s:text name="memo"/>:&nbsp</td>
                <td align="left" colspan="5">
						<s:property value="form.memo"/>
                </td>
            </tr>
        </table>
    </div>

	
    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                <j:purChk permid="FX_INVOICEPRINT">
                  <input type="button" id="btnSave" name="btnSave" class="button_4" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="发票打印" onclick="myDesign();"/>
                 </j:purChk>
                 <j:purChk permid="FX_ACCEPFORMPRINT">
                    <input type="button" id="btnSave" name="btnSave" class="button_4" onmouseover="buttonover(this);" 
		                   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                   value="业务单打印" onclick="myDesignBusiness();"/>
		         </j:purChk>
                   	<s:i18n name="public">
                    <input type="button" id="btnSave" name="btnSave" class="button_4" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="确认入帐" onclick="doSave('/sales/order_recorded.do');"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                          
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturnInFrame('/sales/order_list.do?backFlag=true');">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
<script language="javascript" type="text/javascript"> 
        var LODOP; //声明为全局变量
        
     function dealStatus(statuscode){
		var code = LODOP.GET_VALUE('PRINT_STATUS_OK',statuscode);
		var code2 = LODOP.GET_VALUE('PRINT_STATUS_ID',statuscode);
		
		//alert("得到的code值为＝："+code);
		//alert("打印状态代码为=:"+code2);
		
		if(code == 0){//成功
		//alert("开始发送成功请求");
		var orderid = document.getElementById("order_recorded_do_form_orderid").value;
		//增加js方法
		jQuery.ajax({
					type:"POST",
					url:"<%=contextPath %>/sales/order_updatePrintCount.do",
					async:false, //同u27493 
					data:"orderid="+orderid,			
					success:function(msg){
					}
				});
			alert("打印完成!");
		}else{
			//alert("发送失败请求");
		}
	}
        
        //若要显示:当前日期加时间(如:2009-06-12 12:00:09)
	function CurentTime()
    { 
        var now = new Date();
       
        var year = now.getFullYear();       //年
        var month = now.getMonth() + 1;     //月
        var day = now.getDate();            //日
       
        var hh = now.getHours();            //时
        var mm = now.getMinutes();          //分
        var seconds = now.getSeconds();		//秒
       
        var clock = year + "-";
       
        if(month < 10)
            clock += "0";
       
        clock += month + "-";
       
        if(day < 10)
            clock += "0";
           
        clock += day + " ";
       
        if(hh < 10)
            clock += "0";
           
        clock += hh + ":";
        if (mm < 10) clock += '0'; 
        clock += mm+":"; 
        
         if (seconds < 10) clock += '0'; 
        clock += seconds;         
        return(clock); 
    } ;
        
	function myPrint() {		
		var orderid = document.getElementById("order_recorded_do_form_orderid").value;
	//增加js方法
	jQuery.ajax({
				type:"POST",
				url:"<%=contextPath %>/sales/order_ajaxPrint.do",
				async:false, //同u27493 
				data:"orderid="+orderid,			
				success:function(msg){
				var myE = eval(msg); 
					CreatePrintPage(myE);
				}
			});
		LODOP.PRINT();		
	};  
	function myDesign() {	
	if(confirm("请确认纸张地否已经正确放入打印机!")){	
		var orderid = document.getElementById("order_recorded_do_form_orderid").value;
	//增加js方法
	jQuery.ajax({
				type:"POST",
				url:"<%=contextPath %>/sales/order_ajaxPrint.do",
				async:false, //同u27493 
				data:"orderid="+orderid,			
				success:function(msg){
				var myE = eval(msg); 
					CreatePrintPage(myE);
				}
			});
		LODOP.PRINT();
		alert("打印完成!");
		}
		//LODOP.PREVIEW();
		//LODOP.PRINT();
	};	
	function CreatePrintPage(msg) {
		LODOP=getLodop(document.getElementById('LODOP_OB'),null);  
		LODOP.SET_LICENSES("广东移动","849716019056235623847190847152","","");
		LODOP.PRINT_INIT("发票打印");		
		var myDate = new Date();
		LODOP.ADD_PRINT_TEXT(105,136,141,15,CurentTime());
		LODOP.ADD_PRINT_TEXT(104,596,142,18,msg[0].oprcode);
		LODOP.ADD_PRINT_HTM(211,65,618,199,msg[0].content);
		LODOP.ADD_PRINT_TEXT(436,220,265,17,msg[0].upperstr);
		LODOP.ADD_PRINT_TEXT(434,600,100,20,msg[0].actprice);
	};	
	
	
	function myDesignBusiness() {	
		if(confirm("请确认纸张地否已经正确放入打印机!")){
			var orderid = document.getElementById("order_recorded_do_form_orderid").value;
		//增加js方法
		jQuery.ajax({
					type:"POST",
					url:"<%=contextPath %>/sales/order_ajaxPrintBusiness.do",
					async:false, //同u27493 
					data:"orderid="+orderid,			
					success:function(msg){
					var myE = eval(msg); 
						CreatePrintPageBusiness(myE);
					}
				});
			LODOP.SET_PRINT_MODE("CATCH_PRINT_STATUS",true);
			var statuscode = LODOP.PRINT();
			//alert("statuscode = "+statuscode);
			dealStatus(statuscode);
		}else{
			//alert("打印取消!");
		
		}
	};	
	
	function CreatePrintPageBusiness(msg) {
		LODOP=getLodop(document.getElementById('LODOP_OB'),null);  
		LODOP.SET_LICENSES("广东移动","849716019056235623847190847152","","");
		LODOP.PRINT_INIT("协议书打印");
		LODOP.ADD_PRINT_TEXT(122,50,253,20,msg[0].wayname);
		LODOP.ADD_PRINT_TEXT(122,349,145,20,msg[0].wayid);
		LODOP.ADD_PRINT_HTM(223,65,625,146,msg[0].content);
		LODOP.ADD_PRINT_TEXT(404,219,100,14,msg[0].lowerprice);
		LODOP.ADD_PRINT_TEXT(380,222,18,15,msg[0].shiwan);
		LODOP.ADD_PRINT_TEXT(380,253,18,15,msg[0].wan);
		LODOP.ADD_PRINT_TEXT(380,284,18,15,msg[0].qian);
		LODOP.ADD_PRINT_TEXT(380,315,18,15,msg[0].bai);
		LODOP.ADD_PRINT_TEXT(380,373,18,15,msg[0].yuan);
		LODOP.ADD_PRINT_TEXT(380,403,18,15,msg[0].jiao);
		LODOP.ADD_PRINT_TEXT(380,434,18,15,msg[0].fen);
		LODOP.ADD_PRINT_TEXT(380,343,18,15,msg[0].shiyuan);
	};	
</script> 