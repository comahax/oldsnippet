<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="3C3C1ACC" />
</jsp:include>

<%
    String ID_1 = "3C3C1ACCBT1";
%>

<html:html>
<head>
    <title><bean:message bundle="yxplan" key="upload"/></title>

    <script language="JavaScript">
        function ev_checkval() {
            //addfield('compactno', '<bean:message bundle="yxplan" key="compactno"/>', 'c', false, 17);
            return checkval(window);
        }
        
		function doUpload(urlStr) {
          if (ev_checkval()) {
          	var cmd="";
          	var select=document.all("batchaction").value;
          	if(select=='0'){
          		cmd="CMD=BATCHADD";
          	}else if(select=='1' || select=='2'){
				cmd="CMD=BATCHUPDATE";    		
          	}
              enable();
              formItem.action = contextPath + urlStr+cmd;
             
              formItem.submit();
          }
          return false;
        }        
    </script>
</head>
<body onload="loadforiframe();">
<div class="table_container">
<html:form action="/zifee/yxplan.do?CMD=UPLOAD" styleId="formItem" method="post" enctype="multipart/form-data">
	<hidden property="cmdState"/>

	 <div class="table_div">
		 <table class="top_table">
				<tr>
					<td>
						<bean:message bundle="yxplan" key="upload"/>
					</td>
				</tr>
			</table>
		</div>	
		
		<div class="table_div">
	     <table width="100%" class="error_text">
       	   <s:Msg />
       </table>	
		</div>	
	
	<div class="table_div">
        <table class="form_table">
        	<tr>
			    <td align=left colspan=4>&nbsp;&nbsp;<bean:message bundle="public" key="msgRequired"/></td>
		    </tr>
            
            <tr>
                <td  align="right" width="14%"><div class="field-require"><bean:message bundle="yxplan" key="inputfile"/>:</div></td>
                <td colspan="3" align="left" class="form_table_left">
                    <html:file property="inputFile" styleClass="form_input_files"></html:file>
                </td>
            </tr>
            <tr>
                <td  align="right" width="14%"><div class="field-require"><bean:message bundle="yxplan" key="inputresult"/>:</div></td>
                <td colspan="3" align="left" class="form_table_left">
                	  <html:textarea property="reInfo" readonly="true" styleClass="form_textarea_on"></html:textarea>
                </td>
            </tr>
            <tr>
                <td  align="right" width="14%"><div class="field-require"><bean:message bundle="yxplan" key="batchOperate"/>:</div></td>
                <td colspan="3" align="left" class="form_table_left">
                	<html:select  property="batchaction">
						<html:option value="0"><bean:message bundle="yxplan" key="batchAdd"/></html:option>
						<html:option value="1"><bean:message bundle="yxplan" key="batchUpdate"/></html:option>
						<html:option value="2">自定义更新</html:option>
					</html:select>
                </td>
            </tr>    
  
            <tr>
                <td  align="right" width="14%"><div class="field-require">文件格式(批量新增/更新):</div></td>
                <td colspan="3" align="left" class="form_table_left">
                       <p><font color=red>营销方案标识</font>|<font color=red>营销方案名称</font>|全省标识|<font color=red>启动日期</font>|<font color=red>停用日期</font>|<font color=red>区域标识</font>|</p>
                       <p>是否需要捆绑套餐|捆绑期|是否允许预约|可享用次数|最小优惠周期数|优惠起算偏移量|起算时间单元|</p>
                       <p>生效时间规则|营销方案分组标识|是否备份|是否打印到受理单|是否算费优惠|是否营业费优惠|</p>
                       <p>是否网外成员优惠|来源|营销类别|营销方案类别|<font color=red>上传算费方案类别</font>|优惠范围|<font color='red'>套餐类型</font>|</p>
                       <p>月结扣费优先级|<font color=red>固定费特殊标识</font>|特殊方案标志|<font color=red>是否用户状态检查</font>|可办理用户状态|资费说明|说明|<font color=red>优惠属性</font>|优惠活动短名称|套餐有效周期</p>
                       <p>(注：红色字体为必须录入字段)</p>
                       <p>多个特殊方案标志与可办理用户状态之间用","号串起来,如: 0,1,2</p>
                </td>
            </tr>    
             <tr>
                <td  align="right" width="14%"><div class="field-require">文件格式(自定义更新):</div></td>
                <td colspan="3" align="left" class="form_table_left">
                       <p>全量文件头:<font color=red>营销方案标识</font>|营销方案名称|全省标识|启动日期|停用日期|区域标识|</p>
                       <p>是否需要捆绑套餐|捆绑期|是否允许预约|可享用次数|最小优惠周期数|优惠起算偏移量|起算时间单元|</p>
                       <p>生效时间规则|营销方案分组标识|是否备份|是否打印到受理单|是否算费优惠|是否营业费优惠|</p>
                       <p>是否网外成员优惠|来源|营销类别|营销方案类别|上传算费方案类别|优惠范围|套餐类型|</p>
                       <p>月结扣费优先级|固定费特殊标识|特殊方案标志|是否用户状态检查|可办理用户状态|资费说明|说明|优惠属性|优惠活动短名称|套餐有效周期</p>
                       <p>(注：1、第一行定义要修改的字段(文件头),<font color=red>营销方案标识</font>为必填字段,其它字段为可选,</p>
                       <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;各字段描述必须与上面定义的(全量文件头)描述一致,用"|"分隔,如：<font color=red>营销方案标识</font>|是否备份|套餐类型</p>
                       <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2、第二行开始为文件头中定义的字段值,用"|"分隔,如：<font color=red>10091000000032</font>|0|1</p>
                       <p>多个特殊方案标志与可办理用户状态之间用","号串起来,如: 0,1,2</p>
                </td>
            </tr>   
            <tr>
                <td  align="right" width="14%"><div class="field-require">参数说明:</div></td>
                <td colspan="3" align="left" class="form_table_left">
                       <p>特殊方案标志：0,大众化优惠,1,指定号码可选,2,指定角色,4,指定工号,6,指定客户群,7,指定号码不可选</p>
                       <p>8,指定特殊标志号码可选,9,指定特殊标志号码不可选</p>
                       <p>可办理用户状态：US20,销户,US22,预销户,US23,强制销户,US24,欠费销户,US26,回退,US28,未激活,US30,停机</p>
                       <p>是否允许预约：0,否;1,全部;2,顺延;3,指定时间生效;</p>
                       <p>优惠属性：1，VIP赠送；2，积分赠送；3，营销赠送；4，测试使用；5，其它。                       </p>
                       <p><font color='red'>以上参数仅做参考,以最新的为准</font></p>
                </td>
            </tr>    
        </table>
    </div>
    
		<div class="table_div">
			<table class="table_button_list">
				<tr>
					<td>
						<s:PurChk controlid="<%=ID_1%>">
		          			<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
		                 			name="btnHelp" onfocus="buttonover(this)" onblur="buttonout(this)"
		                 			value="<bean:message bundle="yxplan" key="batch"/>" class="button_4"
		                 			onclick="doUpload('/zifee/yxplan.do?')">
	         </s:PurChk>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/zifee/yxplan.do?CMD=LIST')">
					</td>
				</tr>
			</table>
		</div>

</html:form>
</div>
</body>
</html:html>
