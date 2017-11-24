<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.cancelReason', '作废原因', 'c', false,1024);
			addfield('form.cancelDes', '说明', 'c', false,1024);
			
            return checkval(window);
        }
        
        function doRemove(reqUrl){
	        if(ev_checkval()){
	        	var selectitem = $('#selectitem').val();
	        	var cancelReason = ''; 
	        	$('#cancelReason').children().each(function(i){
		        	if(this.selected){
		        		cancelReason = this.value;
		        	}
       	 		});
	        	var cancelDes = $('#cancelDes').val();
	        	
	        	$.ajax({
	        	url: reqUrl,   //接收页面
		         type: 'post',      //POST方式发送数据
		         async: false,      //ajax同步
		         data: {"form.cancelReason":cancelReason,"form.cancelDes":cancelDes,"param._selectitem":selectitem},
		         success: function(data) {
		             if(''== data){
		   				window.dialogArguments.formList.submit() ;
		   				window.close();
		   			}else{
		   				alert(data);
		         	}	 
		         }       	
	        	});
	        }
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="order_remove.do" cssStyle="formList" key="formItem"
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
     <s:hidden  name="param._selectitem" id="selectitem"/>
	
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

	<div class="error_text" >
		<table class="error_text">
			<s:actionerror /><s:actionmessage/>
		</table>
	</div>
	
    <div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="right">作废原因:&nbsp</td>
                <td align="left">
                    
                     <j:selector id="cancelReason" definition="$FX_DISUSE"  name="form.cancelReason" mode="selector"/>
                     <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right">说明:&nbsp</td>
                <td align="left">
					<s:textarea id="cancelDes" cssStyle="style_input"  name="form.cancelDes" rows="5" cols="40"/>
					<font color=red>*</font>
                </td>
            </tr>
          
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="提交" onclick="doRemove('/sales/order_remove.do');"
                           
                           />
                      <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="取消" onclick="window.close();"
                           
                           />
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
