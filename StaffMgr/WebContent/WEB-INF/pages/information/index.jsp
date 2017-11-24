<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	
	<title>广东移动集群网员工信息查询系统</title>
	 <style type="text/css">
        .subtotal { font-weight: bold; }/*合计单元格样式*/
     </style>
</head>
<body class="easyui-layout" onload="init()">

	<div  class="easyuied-tabs" data-options="fit:true,border:false" >
	<div title="员工管理" data-options="" style="padding: 20px;">
	<form id="empform">
    <table class="table_normal" id="showTable">
    	<c:if test="${loginperm=='staff'}">
    		<tr>
		<td align="right">员工号码:</td>
		<td align="left">
			<input id="svrnum" class="textbox" type="text" name="svrnum" value=""></input>
		</td>
        <td align="right">号码归属:</td>
			<td align="left">
				<select id="numberattr" name="numberattr">
					<option value="">不限</option>
					<option value="200">广州</option>
					<option value="751">韶关</option>
					<option value="755">深圳</option>
					<option value="756">珠海</option>
					<option value="754">汕头</option>
					<option value="757">佛山</option>
					<option value="750">江门</option>
					<option value="759">湛江</option>
					<option value="668">茂名</option>
					<option value="758">肇庆</option>
					<option value="752">惠州</option>
					<option value="753">梅州</option>
					<option value="660">汕尾</option>
					<option value="762">河源</option>
					<option value="662">阳江</option>
					<option value="763">清远</option>
					<option value="769">东莞</option>
					<option value="760">中山</option>
					<option value="768">潮州</option>
					<option value="663">揭阳</option>
					<option value="766">云浮</option>
				</select>
			</td>
	   
		<td><a href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-search'" onclick="showquery()">查询</a></td>
      </tr>
      </c:if>
      
     <c:if test="${loginperm=='cityadmin'}">
      <tr>
        <td align="right">员工编号:</td>
		<td align="left">
			<input id="staffid" class="textbox" type="text" name="staffid" value="" ></input>
		</td>
		<td align="right">员工姓名:</td>
		<td align="left">
			<input id="staffname" class="textbox" type="text" name="staffname" value=""></input>
		</td>
		<td align="right">员工号码:</td>
		<td align="left">
			<input id="svrnum" class="textbox" type="text" name="svrnum" value=""></input>
		</td>
		
      </tr>
      <tr>
        <td align="right">号码归属:</td>
			<td align="left">
				<select id="numberattr" name="numberattr">
					<option value="">不限</option>
					<option value="200">广州</option>
					<option value="751">韶关</option>
					<option value="755">深圳</option>
					<option value="756">珠海</option>
					<option value="754">汕头</option>
					<option value="757">佛山</option>
					<option value="750">江门</option>
					<option value="759">湛江</option>
					<option value="668">茂名</option>
					<option value="758">肇庆</option>
					<option value="752">惠州</option>
					<option value="753">梅州</option>
					<option value="660">汕尾</option>
					<option value="762">河源</option>
					<option value="662">阳江</option>
					<option value="763">清远</option>
					<option value="769">东莞</option>
					<option value="760">中山</option>
					<option value="768">潮州</option>
					<option value="663">揭阳</option>
					<option value="766">云浮</option>
				</select>
			</td>
			<td align="right">在职状态:</td>
		<td align="left">
			<select id="status" name="status">
					<option value="">不限</option>
					<option value="0">在职</option>
					<option value="1">离职</option>
					<option value="2">内退</option>
					<option value="3">离退</option>
					<option value="4">退休</option>
				</select>
		</td>
	   <td></td>
		<td><a href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-search'" onclick="showquery()">查询</a></td>
      </tr>
    	</c:if>
    <c:if test="${loginperm=='gdadmin'}">
    	<tr>
        <td align="right">员工编号:</td>
		<td align="left">
			<input id="staffid" class="textbox" type="text" name="staffid" value="" ></input>
		</td>
		<td align="right">员工姓名:</td>
		<td align="left">
			<input id="staffname" class="textbox" type="text" name="staffname" value=""></input>
		</td>
		<td align="right">员工号码:</td>
		<td align="left">
			<input id="svrnum" class="textbox" type="text" name="svrnum" value=""></input>
		</td>
      </tr>
      <tr>
      <td align="right">员工归属:</td>
		<td align="left">
			<select id="staffattr" name="staffattr">
					<option value="">不限</option>
					<option value="999">省公司本部</option>
					<option value="200">广州分公司</option>
					<option value="751">韶关分公司</option>
					<option value="755">深圳分公司</option>
					<option value="756">珠海分公司</option>
					<option value="754">汕头分公司</option>
					<option value="757">佛山分公司</option>
					<option value="750">江门分公司</option>
					<option value="759">湛江分公司</option>
					<option value="668">茂名分公司</option>
					<option value="758">肇庆分公司</option>
					<option value="752">惠州分公司</option>
					<option value="753">梅州分公司</option>
					<option value="660">汕尾分公司</option>
					<option value="762">河源分公司</option>
					<option value="662">阳江分公司</option>
					<option value="763">清远分公司</option>
					<option value="769">东莞分公司</option>
					<option value="760">中山分公司</option>
					<option value="768">潮州分公司</option>
					<option value="663">揭阳分公司</option>
					<option value="766">云浮分公司</option>
					<option value="dgzx">客服东莞中心</option>
					<option value="fszx">客服佛山中心</option>
					<option value="jmzx">客服江门中心</option>
					<option value="stzx">客服汕头中心</option>
					<option value="szzx">客服深圳中心</option>
					<option value="gzzx">客服广州中心</option>
					<option value="www">互联网公司</option>
					<option value="nfjd">南方基地</option>
					<option value="zdgs">终端公司</option>
				</select>
		</td>
        <td align="right">号码归属:</td>
			<td align="left">
				<select id="numberattr" name="numberattr">
					<option value="">不限</option>
					<option value="200">广州</option>
					<option value="751">韶关</option>
					<option value="755">深圳</option>
					<option value="756">珠海</option>
					<option value="754">汕头</option>
					<option value="757">佛山</option>
					<option value="750">江门</option>
					<option value="759">湛江</option>
					<option value="668">茂名</option>
					<option value="758">肇庆</option>
					<option value="752">惠州</option>
					<option value="753">梅州</option>
					<option value="660">汕尾</option>
					<option value="762">河源</option>
					<option value="662">阳江</option>
					<option value="763">清远</option>
					<option value="769">东莞</option>
					<option value="760">中山</option>
					<option value="768">潮州</option>
					<option value="663">揭阳</option>
					<option value="766">云浮</option>
				</select>
			</td>
			<td align="right">在职状态:</td>
		<td align="left">
			<select id="status" name="status">
					<option value="">不限</option>
					<option value="0">在职</option>
					<option value="1">离职</option>
					<option value="2">内退</option>
					<option value="3">离退</option>
					<option value="4">退休</option>
				</select>
		</td>
	   
		<td><a href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-search'" onclick="showquery()">查询</a></td>
      </tr>
    </c:if>
    </table>
      </form>
			<table id="employeesId" class="easyui-datagrid"  title="员工信息查询"
				data-options="singleSelect:true,fitColumns:true,pagination:true,url:'<%=request.getContextPath() %>/information/querys.do',method:'post',toolbar:'#tb',onLoadSuccess:loadSuccess">
				<thead>
					<tr>
<th data-options="field:'staffid',align:'center',halign:'center'">员工编号</th>
<th data-options="field:'staffname',align:'center',halign:'center'">员工姓名</th>
<th data-options="field:'staffattr',align:'center',halign:'center',formatter:operstaffattrFormatter">员工归属</th>
<th data-options="field:'dept',align:'center',halign:'center'">归属部门</th>
<th data-options="field:'svrnum',align:'center',halign:'center'">员工号码</th>
<th data-options="field:'states',align:'center',halign:'center',formatter:operstatesFormatter">号码状态</th>
<th data-options="field:'numberattr',align:'center',halign:'center',formatter:opernumberattrFormatter">号码归属</th>
<th data-options="field:'isprimary',align:'center',halign:'center',formatter:operisprimaryFormatter">主副号标示</th>
<th data-options="field:'status',align:'center',halign:'center',formatter:operstatusFormatter">在职状态</th>
<th data-options="field:'position',align:'center',halign:'center'">额度</th>
<th data-options="field:'createtime',align:'center',halign:'center'">创建时间</th>
<th data-options="field:'chgtime',align:'center',halign:'center'">修改时间</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	
	
	   <div id="tb"  style="padding:5px;height:auto;">    
 		        <a id="add" href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="addEmployees()">添加新员工</a>    
		        <a id="save" href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="addEmployeesNumber()">添加员工号码</a>    
		        <a id="delete" href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="deleteEmployees()">删除</a>    
		        <a id="update" href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"  onClick="updateEmployees()">修改</a>    
		        <a id="queryss" href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="queryEmployees();">号码归属地查询</a>
		        <a id="returns" href="#" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onClick="Refresh()">返回员工信息查询</a>    
	   </div>
	   
	   <div id="empinfo" class="easyui-window" title="员工信息" style="width: 700px; height: 400px" data-options="iconCls:'icon-save',collapsible:false,maximizable:false,minimizable:false,modal:true,closed:true">
		<form id="employeesform" method="post" action="./save.do">
			<input type="hidden" id="createtime" name="createtime" value="" />				
			<table cellpadding="6" class="table_normal" cellspacing="1">
				<tr><th>员工信息</th></tr>
	    		<tr colspan="10%" align="center">
	    			<td>员工编号:</td>
	    			<td><input class="easyui-validatebox textbox" type="text"  id="staffids"  name="staffid" readOnly=false  value=""data-options="required:true,validType:'length[6,10]'"></input></td>
	    			&nbsp;
	    			<td>员工姓名:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="staffnames" name="staffname"  value=""data-options="required:true,validType:'length[1,12]'"></input></td>
	    		</tr>
	    		<tr  colspan="10%" align="center" id="tr">
		    		<td >员工归属:</td>
						<td >
							<select id="staffattrs" name="staffattr">
									<option value="999">省公司本部</option>
									<option value="200">广州分公司</option>
									<option value="751">韶关分公司</option>
									<option value="755">深圳分公司</option>
									<option value="756">珠海分公司</option>
									<option value="754">汕头分公司</option>
									<option value="757">佛山分公司</option>
									<option value="750">江门分公司</option>
									<option value="759">湛江分公司</option>
									<option value="668">茂名分公司</option>
									<option value="758">肇庆分公司</option>
									<option value="752">惠州分公司</option>
									<option value="753">梅州分公司</option>
									<option value="660">汕尾分公司</option>
									<option value="762">河源分公司</option>
									<option value="662">阳江分公司</option>
									<option value="763">清远分公司</option>
									<option value="769">东莞分公司</option>
									<option value="760">中山分公司</option>
									<option value="768">潮州分公司</option>
									<option value="663">揭阳分公司</option>
									<option value="766">云浮分公司</option>
									<option value="dgzx">客服东莞中心</option>
									<option value="fszx">客服佛山中心</option>
									<option value="jmzx">客服江门中心</option>
									<option value="stzx">客服汕头中心</option>
									<option value="szzx">客服深圳中心</option>
									<option value="gzzx">客服广州中心</option>
									<option value="www">互联网公司</option>
									<option value="nfjd">南方基地</option>
									<option value="zdgs">终端公司</option>
								</select>
						</td>
				
			            <td>单位部门名称:</td>
		    			<td><input class="easyui-validatebox textbox" type="text"  id="depts"  name="dept" data-options="required:true,validType:'length[1,60]'" value=""></input></td>
		    	</tr>
		    	<tr colspan="10%" align="center">
		    			<td >在职状态:</td>
						<td >
							<select id="statuss" name="status">
									<option value="0">在职</option>
									<option value="1">离职</option>
									<option value="2">内退</option>
									<option value="3">离退</option>
									<option value="4">退休</option>
								</select>
						</td>
						<td id="td1">额度:</td>
	    				<td id="td2">
										<select id="positions" name="position">
										<option value="0">0</option>
											<option value="350">350</option>
											<option value="450">450</option>
											<option value="500">500</option>
									    </select>
	    				</td>
	    		</tr>
	    		</table>
	    		
	    		<table cellpadding="6" class="table_normal" cellspacing="1">
	    		<tr><th>员工号码信息</th></tr>
	    		<tr colspan="10%" align="center">
	    		
	    				<td>员工号码:</td>
		    			<td><input class="easyui-validatebox textbox" type="text"  id="svrnums"  name="svrnum" readOnly="false" ></input></td>
						<td>号码状态:</td>
				    			<td >
										<select id="statesids" name="states">
											<option value="0">在用</option>
											<option value="1">停用</option>
									    </select>
						</td>
				</tr>
				<tr colspan="10%" align="center">
				        <td >号码归属:</td>
							<td >
								<select id="numberattrs" name="numberattr">
									<option value="200">广州</option>
									<option value="751">韶关</option>
									<option value="755">深圳</option>
									<option value="756">珠海</option>
									<option value="754">汕头</option>
									<option value="757">佛山</option>
									<option value="750">江门</option>
									<option value="759">湛江</option>
									<option value="668">茂名</option>
									<option value="758">肇庆</option>
									<option value="752">惠州</option>
									<option value="753">梅州</option>
									<option value="660">汕尾</option>
									<option value="762">河源</option>
									<option value="662">阳江</option>
									<option value="763">清远</option>
									<option value="769">东莞</option>
									<option value="760">中山</option>
									<option value="768">潮州</option>
									<option value="663">揭阳</option>
									<option value="766">云浮</option>
								</select>
						</td>
						<td>主副号标示:</td>
						<td>
							<select id="isprimarys" name="isprimary">
							        <option value="1">主</option>
									<option value="0">副</option>	
							</select>
						</td>
				</tr>
				<tr >		
	    					<td colspan="2"  align="center" >
			    				<input type="button" value="提交" id="numsd"/>
			    				
			    			</td>
			    			
			    				&nbsp;
			    				&nbsp;
			    			<td >
			    				<input type="button" value="提交" id="nums"/>
				    		</td>
	    		</tr>
				</table>
				
   		</form>
	</div>
	   
	   
	    <input type="hidden" id="perm" name="perm" value="${loginperm }"/>
	    <input type="hidden" id="attrs" name="attrs" value="${attrs }"/>
	    <script type="text/javascript">
		initEmpForm();
		//$("#empinfo").hide();
		
		var loginperms = document.getElementById("perm").value;
     	var attrs = document.getElementById("attrs").value;
     //alert(attrs);
		if(loginperms == "gdadmin"){			
			document.getElementById("queryss").disabled = true;
			document.getElementById("returns").disabled = true;
		}else if(loginperms=="cityadmin"){
			if(attrs=="999" || attrs=="dgzx" || attrs=="fszx" || attrs=="jmzx"
			  || attrs=="stzx" || attrs=="szzx" || attrs=="gzzx" || attrs=="www" || attrs=="nfjd" || attrs=="zdgs"){
				document.getElementById("queryss").disabled = true;
				document.getElementById("returns").disabled = true;
			}else{			
				document.getElementById("queryss").disabled = false;
				document.getElementById("returns").disabled = false;
			}
		}else{
			document.getElementById("add").disabled = true;
			document.getElementById("save").disabled = true;
			document.getElementById("delete").disabled = true;
			document.getElementById("update").disabled = true;
			document.getElementById("queryss").disabled = true;
			document.getElementById("returns").disabled = true;
		}
		
	</script>
  </body>
</html>
