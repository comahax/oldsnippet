<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="s"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	
	<title>广东移动员工通讯号码账单查询系统</title>
	
</head>
<body class="easyui-layout">
	<div  class="easyui-tabs" data-options="fit:true,border:false" >
	
	<div id="toptabs" title="员工账单查询" data-options="" style="padding: 20px;" >
	<form id="billform" >
    <table class="table_normal">
      <tr>
		<td align="right">员工号码:</td>
		<td align="left">
			<input id="svrnums" class="easyui-validatebox" missingMessage="请填写员工号码" invalidMessage="员工号码格式不正确"  data-options="required:true,novalidate:true" type="text" name="svrnums" onf="validate(this)"></input>
		</td>
      	<td align="right">账期:</td>
      	<td align="left">
      		<div>
				<input id="billcycs" class="date_input easyui-validatebox"  missingMessage="请选择账期"  data-options="required:true,novalidate:true"  type="text" name="billcycs" ></input>
			</div>
		</td>
		<td><a href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-add'" onclick="showquerys()">查询</a></td>
      </tr>
      </table>
      </form>
			<table id="billsId" class="easyui-datagrid" title="员工账单查询" 
				data-options="singleSelect:true,pagination:true,method:'post',showfooter:true,fitColumns:true,rownumbers:true">
			</table>
			<div >
			</br>
			备注</br>
			1、本月核销话费：本月可核销业务经过打折后的费用，计入该项。若超过当月核销话费额度(如普通员工350元)，则超出部分计入本月超额话费。</br>
	        2、本月非核销类话费：即核销类业务列表之外的业务费用。</br>
	        3、本月应缴话费：即当月超额话费和非核销类话费的总和，实际按月结算方式，个人通过充值、缴费等方式缴清。</br>
	        </div>
			<div id="detailedIdss" class="easyui-window" data-options="closed:true,fit:true" title="号码账单业务详细" style="width:300px;height:auto;" >
			 <table id="detailedId"  class="easyui-dialog" data-options="iconCls:'icon-add',
			 border:false,fitColumns:true,pagination:true,showfooter:true,rownumbers:true,
			 singleSelect:false,showfooter:true,url:'<%=request.getContextPath() %>/bills/querysBusiness.do',method:'get'">
			 </table>
			</div>
	  </div>
      </div>

     <script type="text/javascript">
      	initBillForm();
      	
	</script>
  </body>
</html>
