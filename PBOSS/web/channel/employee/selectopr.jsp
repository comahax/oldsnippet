<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>

<html>
	<head>
		<title><s:text name="title"/></title>
		<script language="JavaScript" type="text/JavaScript">       
        
		//增加部分选项
        function addItem() {
			var str = "";
			if($("#s1").val()!=null)
			{
				//获得选取的值，以","拼接成字符串，并过滤重复的选项
				var valStr = "";
				var nameStr = "";
				
				var dataLength = $("#s2").children().length;
				var dataArray = new Array(dataLength);
				$("#s2").children().each(function(i){
					dataArray[i] = this.value;
				});
				
				//重复标识
				var hasMul;
				
				//获取选取值字符串
				$("#s1").children().each(function(i){
					if(this.selected && this.value!="-1")
				    {
				    	hasMul = false;
				    	for(var j=0; j<dataLength; j++)
				    	{
				    		if(this.value==dataArray[j])
				    		{
				    			hasMul = true;
				    		}
				    	}
				    	
				    	//将不重复的添加至选择字符串
				    	if(!hasMul)
				    	{
				    		valStr = valStr + this.value + ",";
				   			nameStr = nameStr + this.ename + ",";
				    	}
				    }
				});
				
				//根据选取值生成选项
				if(valStr.length>0)
				{
					//去掉末尾的","
					valStr = valStr.substring(0,valStr.length-1);
					nameStr = nameStr.substring(0,nameStr.length-1);
					
					//动态生成选项
					var valArray = valStr.split(",");
					var nameArray = nameStr.split(",");
					for(var i=0; i<valArray.length; i++)
					{
						str = str + "<option value=\"" + valArray[i] + "\" ename=\"" + nameArray[i] + "\">" +nameArray[i] + "</option>";
					}
					$("#s2").append(str);
				}
			}
			
        }
        
        //增加全部选项
        function addAllItem() {
			$("#s1").children().each(function(i){
				$(this).attr("selected",true);
			});
			addItem();
			$("#s1").children().each(function(i){
				$(this).attr("selected",false);
			});
        }
        
        //移除部分选项
        function outItem() {
			$("#s2").children().each(function(i){
				if(this.selected)
			    {
			    	$(this).remove();
			    }
			});
        }
        
        //移除全部选项
        function outAllItem() {
			$("#s2").children().each(function(i){
				$(this).remove();
			});
        }
        
        //返回
		function doConfirm() {
			var str = "";
			$("#s2").children().each(function(i){
				str = str + this.value + ",";
			});
			window.returnValue = str;
			window.close();
		}
		
    	</script>
	</head>

	<body>
			<div class="error_text">
				<table class="error_text">
					<s:actionerror /><s:actionmessage/>
				</table>
			</div>
			
			<div class="table_container">
				<div class="table_div">
					<table class="table_style">
						<tr class="table_style_content">
							<td align=left>
								可选项
							</td>
							<td align=left></td>
							<td align=left>
								已选项
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=left>
								<select style="width:200px;height:350px" name="s1" id="s1" size="56" multiple="true" ondblclick="addItem(this);">
									<option value=0 ename="人员ID">人员ID</option>
									<option value=1 ename="BOSS工号">BOSS工号</option>
									<option value=2 ename="姓名">姓名</option>
									<option value=3 ename="性别">性别</option>
									<option value=4 ename="手机号">手机号</option>
									<option value=5 ename="地市公司">地市公司</option>
									<option value=6 ename="分公司">分公司</option>
									<option value=7 ename="服务销售中心">服务销售中心</option>
									<option value=8 ename="微区域">微区域</option>
									<option value=9 ename="服务厅(所属渠道)">服务厅(所属渠道)</option>
									<option value=10 ename="岗位">岗位</option>
									<option value=11 ename="入职时间">入职时间</option>
									<option value=12 ename="用工性质">用工性质</option>									
									<option value=13 ename="用工状态">用工状态</option>				
									<option value=14 ename="出生日期">出生日期</option>
									<option value=15 ename="文化程度">文化程度</option>
									<option value=16 ename="籍贯">籍贯</option>
									<option value=17 ename="政治面貌">政治面貌</option>
									<option value=18 ename="家庭地址">家庭地址</option>
									<option value=19 ename="身份证号码">身份证号码</option>
									<option value=20 ename="个人电子邮箱">个人电子邮箱</option>
									<option value=21 ename="公司专用联系方式">公司专用联系方式</option>
									<option value=22 ename="专业">专业</option>
									<option value=23 ename="公务手机号码">公务手机号码</option>
									<option value=24 ename="毕业院校">毕业院校</option>
									<option value=25 ename="毕业时间">毕业时间</option>
									<option value=26 ename="劳动关系">劳动关系</option>
									<option value=27 ename="岗位级别">岗位级别</option>
									<option value=28 ename="职级">职级</option>
									<option value=29 ename="所在部门">所在部门</option>
									<option value=30 ename="参加工作年限">参加工作年限</option>
									<option value=31 ename="所属劳务公司">所属劳务公司</option>
									<option value=32 ename="本公司工作年限">本公司工作年限</option>
									<option value=33 ename="婚姻状况">婚姻状况</option>
								</select>
							</td>
							<td align=left>
								<br />
								<input type="button" value=">" style="width:50px; height:20px; background-color:#ffffff" onclick="addItem()" />
								<br />
								<input type="button" value=">>" style="width:50px; height:20px; background-color:#ffffff" onclick="addAllItem()" />
								<br />
								<br />
								<input type="button" value="<" style="width:50px; height:20px; background-color:#ffffff" onclick="outItem()" />
								<br />
								<input type="button" value="<<" style="width:50px; height:20px; background-color:#ffffff" onclick="outAllItem()" />
								<br />
							</td>
							<td align="left">
								<select style="width:200px;height:350px" name="s2" id="s2" size="56" multiple="true" ondblclick="outItem(this);">
									<option value=0 ename="人员ID">人员ID</option>
									<option value=1 ename="BOSS工号">BOSS工号</option>
									<option value=2 ename="姓名">姓名</option>
									<option value=3 ename="性别">性别</option>
									<option value=4 ename="手机号">手机号</option>
									<option value=5 ename="地市公司">地市公司</option>
									<option value=6 ename="分公司">分公司</option>
									<option value=7 ename="服务销售中心">服务销售中心</option>
									<option value=9 ename="服务厅(所属渠道)">服务厅(所属渠道)</option>
									<option value=10 ename="岗位">岗位</option>
									<option value=11 ename="入职时间">入职时间</option>
									<option value=12 ename="用工性质">用工性质</option>
								</select>
							</td>
						</tr>
						<tr class="table_style_content">
							<td colspan="3" align="center">
								<input type="button" id="btnSave" name="btnSave" class="button_4" onmouseover="buttonover(this);" 
			                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                           value="选择导出" onclick="doConfirm()"/>
							</td>
					</table>
				</div>
			</div>
	</body>
</html>
