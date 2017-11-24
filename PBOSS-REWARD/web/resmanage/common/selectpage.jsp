<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="com.sunrise.boss.common.utils.i18n.Message" %>
<%@ include file="/inc/listhead.inc" %>
<%
	String resFileName = "/com/sunrise/boss/resource/i18n/resmanage/Excelout_zh_CN.properties";
	String formName = request.getParameter("formName");
	String reName = request.getParameter("newResName");
	String resName = (String)session.getAttribute("resName");
	if (reName != null && reName.trim().length() > 0){
		resName = reName;
	}
	
	String property = Message.getString(resFileName,resName);
	String[] properties = property.split("\\,");
	String bundleName = properties[0];
%>
<html>
  <head>
    <title><bean:message bundle="fee" key="selectPageList"/></title>
    <base target="_self">
 <script type="text/javascript" src="<%=contextPath%>/js/pub/xmlhttp.js"></script>
 <script language=javascript>
 var arg = window.dialogArguments;
	function ev_check() {
		if(!document.all.excelbox.checked){
			addfield('startindex', '<bean:message bundle="fee" key="startindex"/>', 'i', false, 20);
        	addfield('endindex', '<bean:message bundle="fee" key="endindex"/>', 'i', false, 20);
		}
        return checkval(window);
    }		
			
	function frmSubmit(){
		if(ev_check()){
			var startindex = document.all.startindex.value;
			var endindex = document.all.endindex.value;
			var excelCheck = document.all.excelbox.checked;
			if(!excelCheck && (endindex < 1 || startindex < 1)){
				alert('<bean:message bundle="fee" key="startindex"/><bean:message bundle="fee" key="and"/><bean:message bundle="fee" key="endindex"/><bean:message bundle="fee" key="plusNum"/>');
			}else if(endindex - startindex < 0){
				alert('<bean:message bundle="fee" key="startindex"/><bean:message bundle="fee" key="compare_gt"/><bean:message bundle="fee" key="endindex"/>');
			}else if(arg[1] == "excelout" && endindex - startindex >= 100){
				alert('<bean:message bundle="fee" key="pagenosize"/><bean:message bundle="fee" key="compare_gt"/>100');
			}else {
				var array = new Array;
				var bxArray = new Array;
				var infopage;
				if (excelCheck){
					infopage = "1|100000000000";
				}else {
					infopage = document.all.startindex.value + "|" + document.all.endindex.value; 
				}			
				var box = document.all("_selectitem");
				for (var i = 0;i < box.length; i++){
					if (box[i].checked){
						bxArray.push(box[i].value);
					}
				}
				array.push(infopage);
				array.push(bxArray);
				if(array.length == null || array.length < 1){
					array = "";
				}
				array.toString();
				window.returnValue = array;
				window.close();
			}
		}
	}
	
	function getAllRecord(){
		var formName = '<%=formName%>';
		var resName = '<%=reName%>';
		var myobj;
		if (arg[1] == "excelout"){
			document.getElementById("exceloutid").style.display = "none";
			document.getElementById("exceloutid2").style.display = "none";
			document.getElementById("exceloutid3").colSpan =3;
			document.getElementById("text").innerHTML ='<bean:message bundle="fee" key="selectpageinfo"/>';
		}
		var url = contextPath+"/resmanage/excelout.do?CMD=GETTINGRECORDCOUNT&queryString="+arg[0].join(";");
		if (resName !='' && resName != 'null')
			url += "&newResName="+resName;
		if (formName !='' && formName != 'null')
			url += "&formName="+formName;
		startAjax(url,"selectChange2('"+myobj+"')","text","get");
	}
	function selectChange2(obj){
		var mc=unescape(mypoint);
		document.formList.allrecord.value=mc;
		document.formList.allrecord.style.color = "red";
		loading.className = "loading_off";
		loading.innerHTML = "";
	}
	
	function allCheck(checkBox){
		if (checkBox.checked){
			document.all("startindex").value = "";
			document.all("endindex").value = "";
			document.all("startindex").disabled = true;
			document.all("endindex").disabled = true;
		}else {
			document.all("startindex").disabled = false;
			document.all("endindex").disabled = false;
			document.all("startindex").value = 1;
			document.all("endindex").value = 100;
		}
	}
 </script>
</head>
 
<body onload="getAllRecord()">

<form method="post" name="formList">
	<div class="table_div">
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="fee" key="selectPageList"/></td>
			</tr>
		</table>
    </div>
    <div class="table_div">
		<table class="error_text">
			<html:errors />
			<s:Msg />
		</table>
	</div>
	<div class="table_div">
        <table class="form_table">
        	<tr>
        		<td class="form_table_left" colspan="4"><bean:message bundle="fee" key="redStarExplain"/></td>
        	</tr>
        	<tr>
            	<td class="form_table_left" colspan="4" id="text"><bean:message bundle="comressmp" key="selectpageinfo"/></td>
            </tr>
            <tr>
            	<td class="form_table_right">符合条件的总记录数:</td>
            	<td class="form_table_left" id="exceloutid3"><input type="text" name="allrecord" readonly="true"/></td>         	
            	<td class="form_table_right" id="exceloutid"><input type="checkbox" name="excelbox" class="table_checkbox" onclick="allCheck(this)"/></td>
				<td id="exceloutid2">导出全量数据</td>       	
            </tr>
            <tr>
            	<td class="form_table_right"><bean:message bundle="fee" key="startindex"/>:</td>
                <td class="form_table_left">
                	<input type="text" maxlength="20" value="1" name="startindex"><bean:message bundle="fee" key="redStar"/>
                </td>
                <td class="form_table_right"><bean:message bundle="fee" key="endindex"/>:</td>
                <td class="form_table_left">
                	<input type="text" maxlength="20" value="100" name="endindex"><bean:message bundle="fee" key="redStar"/>
                </td>
            </tr>
		</table>
    </div>
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
			        <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
			               onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			               value="<bean:message bundle="public" key="button_close"/>" onClick="window.close();">
			        <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_submit"/>" onClick="frmSubmit();">          
			    </td>	
			</tr>
		</table>
	</div>
	<div class="table_div">
		<table class="form_table">
			<tr>
				<td class="form_table_left" colspan=8>请选择导出的字段</td>
			</tr>
			<tr>
				<td class="form_table_right"><input type="checkbox" name="allbox" class="table_checkbox" onclick="checkAll()"/></td>
				<td colspan=5>选中或清除所有的字段(不选则默认导出所有字段)</td>
			</tr>
			<tr>
			<%if (properties != null){
				int j = 0;
				for (int i =1 ;i < properties.length;i++){ if(i == properties.length-1){
					j = i%3;
										
					%>

				<td class="form_table_right"><input type="checkbox" name="_selectitem" value="<%=properties[i]%>" class="table_checkbox" onclick="checkOne()"/></td>
				<td class="form_table_left" id="td_last"><bean:message bundle="<%=bundleName %>" key="<%=properties[i] %>"/></td>
			<%}else { %>
				<td class="form_table_right"><input type="checkbox" name="_selectitem" value="<%=properties[i]%>" class="table_checkbox" onclick="checkOne()"/></td>
				<td class="form_table_left"><bean:message bundle="<%=bundleName %>" key="<%=properties[i] %>"/></td>
			<%}
			  if (i%3==0){%>
				</tr>
				<tr>
			<%
			}}
			 if (j != 0){%>
			 	<script language="javascript">
			 		var colspan = <%=j%>;
			 		document.getElementById("td_last").colSpan = (3-colspan)*2+1;			 		
			 	</script>
			 <%		  
			 }
			}
			%>
			</tr>
		</table>
	</div>     	          
 </form>       

</body>
</html>
