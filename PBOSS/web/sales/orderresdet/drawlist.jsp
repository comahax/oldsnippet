<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('orderamt', '����', 'f', false, '10');
            return checkval(window);
        }
        
        var count = 0;//����
        var total = 0;//�ܼ�
        
        //�����������ܼ�
        function stat(num,price){
        	count += num;
        	total += price;
        }
        $(document).ready(function(){ 
	        	
    	}); 
    	 //������һ������
	     function doNext(actionUrl){
	     	var orderid="<s:property value="form.orderid"/>";//ѡ�еĶ���������
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
	     var drawPara = "";//�Զ��ֳ�ֵ�����趨��Χ���ݲ�������|�ָ�
	     function goSetNumber(actionUrl){
	     	
	     	var rtn=window.showModalDialog(actionUrl , null, "dialogWidth:700px; dialogHeight:450px; status:no; resizable:yes;");
	        
	        if(rtn != null && rtn != "" && rtn != undefined){
	        	var result = rtn.split(',');
	        	var nums = result[1].split('<br>');
	        	
	        	if(drawPara == ""){
	        		drawPara = drawPara + result + "|";
	        	}else{
	        		if(drawPara.indexOf(result[0]) >= 0){
	        			//�ú����趨��Χ�滻֮ǰ�趨�ķ�Χ
	        			var drawParas = drawPara.split('|');
	        			var tmp = "";
	        			for(var i=0 ; i<drawParas.length ; i++){
	        				var tmp1 = drawParas[i];
	        				if(tmp1.indexOf(result[0]) >= 0){//�����滻
	        					tmp = tmp + result + "|";
	        				}else{
	        					if(tmp1 != ""){//�����ڣ�ԭ���ı��ֲ���
	        						tmp = tmp + tmp1 + "|";
	        					}
	        				}
	        			}
	        			drawPara = tmp;
	        		}else{
	        			//û�趨����ֱ���ۼ�
	        			drawPara = drawPara + result + "|";
	        		}	        		
	        	}
	        	
	        	var h = nums.length*16;
	        	document.getElementById(result[0]).style.height = h;//��̬�趨���и߶�
	        	document.getElementById(result[0]).innerHTML = result[1];//����ָ����Χ����Դ��ţ�
	        }
	        
	     	return false;
	     }
	     
	     function loadErrorMsg(){
	     	//��ȡʧ��ʱ���������֮ǰ�趨�ķ�Χ
	     	var errMemo = "<%=request.getSession().getAttribute("errMemo")%>";
	     	var errDrawPara = "<%=request.getSession().getAttribute("errDrawPara")%>";
	     	
	     	if(errMemo == "errMemo"){
	     		var errDrawParas = errDrawPara.split('|');
	     		if(errDrawParas != null && errDrawParas != "" && errDrawParas != undefined){
	     			for(var i=0 ; i<errDrawParas.length ; i++){
	     				var onecgy = errDrawParas[i];
	     				if(onecgy != ""){
	     					var onecgys = onecgy.split(',');
	     					
	     					var nums = onecgys[1].split('<br>');
	     					var h = nums.length*16;
	        				document.getElementById(onecgys[0]).style.height = h;//��̬�趨���и߶�
	     					document.getElementById(onecgys[0]).innerHTML = onecgys[1];//����ָ����Χ����Դ��ţ�
	     				}
	     			}
	     		}
	     		
	     		drawPara = errDrawPara;
	     	}
	     	
	     	
	     	
	     	<%request.getSession().setAttribute("errMemo","");%>;
	     	<%request.getSession().setAttribute("errDrawPara","");%>;
	     }

    </script>
    
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();loadErrorMsg()">
<div class="table_container">
<s:form action="orderresdet_drawList.do" key="formList" cssStyle="formList" theme="simple" >
	<%//����Ŀؼ���Action�ṩ���ݣ�������ҳ%>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
    <s:hidden name="param._se_orderid"/>
    <s:hidden name="outstate"/>
    <s:hidden name="instate"/>
    <input type="hidden" name="orderstate" value="<s:property value="form.orderstate" />"/>
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleListdraw"/></span>
		</div>
	</div>
    
   
    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>

    
	 <div class="table_div">
		<table id="adjTab" class="table_normal">
             <tr >
					<td>
						<s:text name="orderid"/>:<s:property value="form.orderid"/>&nbsp;&nbsp;
						<s:text name="createtime"/>:<s:date name="form.createtime" format="yyyy-MM-dd"/>&nbsp;&nbsp;
						<s:text name="orderstate"/>:<j:code2Name definition="$FX_ORDERFSTATE" code="form.orderstate"/>&nbsp;&nbsp;
					</td>
			</tr>
          </table>
	</div>
	<aa:zone name="listZone">
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style">
            <tr class="table_style_head">
                <td >
                    ���
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comdp.comcategory')"><s:text name="comcategory"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comdp.orderamt')"><s:text name="orderamt"/>(��)</j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comdp.unitprice')"><s:text name="unitprice"/>(Ԫ)</j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comdp.totalprice')"><s:text name="totalprice"/>(Ԫ)</j:orderByImg>                 
                </td>
                <td >
                    ָ����Χ����Դ��ţ�
                </td>
            </tr>
            <s:iterator value="comdp.datas" status="state">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
                     <td>
                        <s:text name="#state.count"/>
                     </td>
                     <td>
                     <s:if test="outstate=='EXTRAED'">
                     	<s:if test="comcategoryType=='CZ' && dismode=='MANUAL'">
                     		<a href="javascript:void()" onclick="goSetNumber('sales/orderresdet/orderresdet_setNumbers.do?orderamt=<s:property value="orderamt" />&comcategory=<s:property value="comcategory" />')">
                     			<j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory"/>
                     		</a>
                     	</s:if>
                     	<s:else>
                     		<j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory"/>
                     	</s:else>
                     </s:if>
                     <s:else>
                     	<j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory"/>
                     </s:else>
                     	
                     	<s:if test="ordercomtype=='SYSTIEIN'">
                       		(ϵͳ����)
			        	 </s:if>
			        	 <s:elseif test="ordercomtype=='SYSGIFT'">
					     	(ϵͳ����)
					     </s:elseif>
                     </td>
                     <td><s:property value="orderamt" /></td>
                     <td><s:property value="unitprice" /></td>
                     <td><s:property value="totalprice" /></td>
                     <td id="<s:property value="comcategory" />"></td>
                 </tr>
                 <script language="javascript">
                 	stat(<s:property value="orderamt"/>,<s:property value="totalprice"/>);
                 </script>
             </s:iterator>
             <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
             	<td>�ϼ�</td>
             	<td></td>
             	<td><script language="javascript"> document.write(count) </script></td>
             	<td></td>
             	<td><font color="red"><script language="javascript"> document.write(total) </script></font></td>
             </tr>
        </table>
        </div>
    </div>
    </aa:zone>
     <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
                	<s:i18n name="public">
						<input type="button" id="buttonResdraw" name="buttonResdraw" class="button_4" onmouseover="buttonover(this);" 
	                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="<s:text name="button_Resdraw"/>" onclick="doResdraw()" 
	                           <s:if test="outstate!='EXTRAED'">disabled = "true"</s:if> />
	                    <input type="button" id="button_doNext" name="button_doNext" class="button_4" onmouseover="buttonover(this);" 
	                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="<s:text name="doNext"/>" onclick="doNext('/sales/order_nextProcess.do')" 
	                            <s:if test="form.orderstate!='EXTRAED'">disabled = "true"</s:if> />
	                    <input type="button"  name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
	                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="<s:text name="button_return"/>" onclick="doReturnInFrame('/sales/order_list.do?backFlag=true');">
                   </s:i18n>
				</td>
			</tr>
		</table>
	</div>
	
	<aa:zone name="list2Zone">
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style">
            <tr class="table_style_head">
               	<s:i18n name="public">
                <td >
                    ���
                </td>
                </s:i18n>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comcategory')"><s:text name="comcategory"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('batchno')"><s:text name="batchno"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('boxnum')"><s:text name="boxnum"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comcategory')"><s:text name="comresids"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas" status="state">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- ���������á�|������� --%>
                     <td><s:text name="#state.count"/></td>
                     <td><j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory"/>
                     	<s:if test="ordercomtype=='SYSTIEIN'">
                       		(ϵͳ����)
			        	 </s:if>
			        	 <s:elseif test="ordercomtype=='SYSGIFT'">
					     	(ϵͳ����)
					     </s:elseif>
                     </td>
                     <td><s:property value="batchno" /></td>
                     <td><s:property value="boxnum" /></td>
                     <td><s:property value="comresids" /></td>
                 </tr>
             </s:iterator>
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
		return "errorZone,listZone,list2Zone";  
	}
	//��Դ��ȡ
	function doResdraw(){
		
		if($(":hidden[name='outstate']").val()!='EXTRAED'){
			var alertstr='<span class=\'errorkey\'>��������״̬������һ���費����</span>';
			errorMessageShow(alertstr);
			return ;
		}
		if($(":hidden[name='instate']").val()!=$(":hidden[name='orderstate']").val()){
			var state="<j:code2Name definition="$FX_ORDERFSTATE" code="form.orderstate"/>";
			var alertstr='<span class=\'errorkey\'>��������״̬�������״̬����Ϊ['+state+']</span>';
			errorMessageShow(alertstr);
			return ;
		}
		
		disabledButtons();
		formList.action = contextPath + "/sales/orderresdet_resdraw.do?drawPara="+drawPara;
        formList.submit();
	}
	function disabledButtons(){
		var buttons=$(":button");
		buttons.each(function(i) {
			jQuery(this).attr("disabled",true);
		});
	}

	//ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	//ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnDelete");
</script> 
</body>
</html>
