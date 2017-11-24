<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<link href="<%=contextPath%>/css/css_1/xmlhttp.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="<%=contextPath%>/js/pub/content.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/pub/xmlhttp.js"></script>
<%
	String ID_1 = "1A2B4D80BT1";
	String ID_2 = "1A2B4D80BT2";
%>
<html>
<head>
<title><bean:message bundle="operrole" key="batchinTitle" /></title>
<script language="JavaScript" type="text/JavaScript">

		function ev_checkval() {
		   if (checkfilename() == false){
		   		return false;
			}
			addfield('createdate', '<bean:message bundle="operright" key="createdate"/>', 't', false);
            addfield('status', '<bean:message bundle="operright" key="status"/>', 'i', false, 1);
            addfield('statusdate', '<bean:message bundle="operright" key="statusdate"/>', 't', true);
		   return checkval(window);	   
		}
		
	  function checkfilename(){
	   	  var filename = document.all.theFile.value;
	   	  if(filename != "") {
	   	   	var arrys = filename.split(".");
		    var filetype = arrys[arrys.length-1];
		    if(filetype.toUpperCase() != "TXT" && filetype.toUpperCase() != "DOC"){
		      alert('<bean:message bundle="Comrescard" key="invalidFileCompose"/>');
		      return false;
		    }
		   }else{
		   	if(filename == ""){
		   		alert('<bean:message bundle="Comrescard" key="selectfile"/>');
		   		return false;
		   	}
		   }
		   return true; 
	   }
		
		function checkProcess(){
		  var filename=formItem.filename.value;
		if(filename != null || filename != ""){
          formItem.Button7.disabled=true;
	      window.location.href="<%= contextPath%>/operrolebatchtask.do?filename="+filename+"&beanname=com.sunrise.boss.ui.rightmanage.operrole.batchin.BatchinOperroleTaskBean";
			}
		}
		function doAjax2(myself,myurl,myobj){
			var value = myself.value.split(" ");
			myurl = contextPath+myurl+"&comid="+value[0];
			startAjax(myurl,"selectChange2('"+myobj+"')","text","get");
		}
		
		function selectChange2(obj){
			var mc=unescape(mypoint);
			document.all.price.value=mc;
			document.all.stockprice.value=mc;
		}
</script>
</head>
<body onload="loadforiframe()">
<div class="table_container">
<html:form action="/batchinoperrole" enctype="multipart/form-data" styleId="formItem">
	<input type="hidden" name="filename"
		value="<c:out value='${requestScope.ITEM.inFile}'/>">
	<div class="table_div">
		<table class="top_table">
			<tr>
				<td><bean:message bundle="operrole" key="batchinTitle" /></td>
			</tr>
		</table>
	</div>
	<div class="table_div">
	<table width="100%" class="error_text">
		<s:Msg />
	</table>
	</div>
	<div class="table_div">
	<table class="form_table" width="95%">
		<TBODY>
		<tr class="table_style_content">
			<td align=left colspan=6>&nbsp;&nbsp;<bean:message bundle="Comrescard" key="fill" /></td>
		</tr>
		<tr>
			<td width=15% align=right height=25 ><bean:message
				bundle="upload" key="choose" /></td>
			<td align=left colspan=4><input type="file" class="form_input_files"
				name="theFile" ID="File1" /><font color=red>&nbsp;*</font></td>
		</tr>
		<tr>
			<td align=right height=25 >
				<bean:message bundle="Comrescard"key="filetype" /></td>
			<td align=left colspan=4>
				<bean:message bundle="Comrescard" key="typevalue" />
			</td>
		</tr>
		<tr>
			<td align=right height=25>
				<bean:message bundle="Comrescard" key="filestyle" />
			</td>
			<td align=left colspan=4>
				<bean:message bundle="operrole" key="batchinfilehead" />
			</td>
		</tr>
		<tr>
			<td align=right height=25>
				<bean:message bundle="upload"key="example" />
			</td>
			<td align=left colspan=4><font color=red>abc|AA|</font></td>
		</tr>
		<tr>
			<td align=right >
				<div class="field-require">
				<bean:message bundle="operrole"key="status" />
				</div>
			</td>
			<td align="left" colspan=4>
				<html:text styleClass="form_input_1x" property="status" value="1" readonly="true"/><font color=red>&nbsp;*</font>
			</td>
		</tr>
		<tr>			
			<td align=right height=25>
				<bean:message bundle="operrole" key="createdate" />
			</td>
			<td align="left">
				<html:text styleClass="form_input_1x" property="createdate" onclick="this.value=selectDate()"/><font color=red>&nbsp;*</font>
			</td>
			<td align="right" height=25>
				<bean:message bundle="operrole" key="statusdate" />
			</td>
			<td align="left">
				<html:text styleClass="form_input_1x" property="statusdate" onclick="this.value=selectDate()"/><font color=red>&nbsp;*</font>
			</td>
		</tr>
		<c:choose>
			<c:when test="${!empty requestScope.ITEM.inFile}">
				<tr>
					<td align=right height=25><bean:message bundle="upload"
						key="existfile" /></td>
					<td align=left colspan=4>
							<a href='<%=contextPath%>/commons/batch/download.jsp?filename=<c:out value="${requestScope.ITEM.inFile}" />'><font color=red><c:out value="${requestScope.ITEM.fileName}" /></font> </a>
					</td>
				</tr>
			</c:when>
		</c:choose>
	</table>
	</div>
   <iframe
		src="<%= contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.rightmanage.operrole.batchin.BatchinOperroleTaskBean"
		frameborder="0" class="loadframe" id="loadframe" scrolling="no"></iframe>
	<div class="table_div">
		<table class="table_button_list">
			<tr>
				<td >
				<s:PurChk controlid="<%=ID_1%>">
					<input type="submit" value="<bean:message bundle="upload" key="upload" />"
						class="Button_2" onmouseover="buttonover(this)"
						onmouseout="buttonout(this)" onfocus="buttonover(this)"
						onblur="buttonout(this)" ID="1A2B4D80BT1" NAME="Button6"
						onClick="return ev_checkval()" /> 
				</s:PurChk>
				<s:PurChk controlid="<%=ID_2%>">
					<input type="button" value="<bean:message bundle="upload" key="process"/>"
						class="Button_2" onmouseover="buttonover(this)"
						onmouseout="buttonout(this)" onfocus="buttonover(this)"
						onblur="buttonout(this)" ID="1A2B4D80BT2" NAME="Button7"
						onClick="checkProcess()" />
				</s:PurChk>
				</td>
			</tr>
		</table>
	</div>
</html:form>
</div>
</body>
</html>
