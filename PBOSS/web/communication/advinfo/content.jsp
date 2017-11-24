<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    
    <script language="JavaScript">
        function ev_checkval() {
        	var content = getEditorTextContents('form.content');
        	if(Trim(content).length == 0){
        	var errMsg ='<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[发布消息内容]</span> 不允许为空 </span>';
        	errorMessageShow(errMsg);
        	return false;
        	}
			addfield('form.title', '<s:text name="title"/>', 'c', false, 256);
			//addfield('form.content', '<s:text name="content"/>', 'c', false);
			addfield('form.releasetime', '<s:text name="releasetime"/>', 't', false, 7);
			addfield('form.desttype', '<s:text name="desttype"/>', 'f', false, 3);$(":select[name='form.type'] option")
			
			if($(":hidden[name='param._ne_type']").val()=='1' || $(":hidden[name='param._ne_type']").val()=='6'){//为公告时
				addfield('form.enddate', '<s:text name="enddate"/>', 't', false, 7);
				return (checkval(window) && compareDate() && checkLogoType('logo','jpg'));
			}
			if($(":select[name='form.desttype']").val()=='4' || $(":select[name='form.desttype']").val()=='5'){
				addfield('form.objinfo', '对象选择', 'c', false, 512);
			}
            return checkval(window);
            
        }
        
        // 获取编辑器中文字内容
function getEditorTextContents(EditorName) { 
    var oEditor = FCKeditorAPI.GetInstance(EditorName); 
    return(oEditor.EditorDocument.body.innerText); 
}
        
        function compareDate(){
        	var releasetime = document.getElementById('releasetime').value;
        	var enddate = document.getElementById('enddate').value;
        	
        	if(releasetime != '' && enddate != '' && releasetime > enddate){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="enddate"/>]</span>不能小于<span style=\'color:#F00; font-size:12px;\'>[<s:text name="releasetime"/>]</span></span>';
				errorMessageShow(alertstr);
				return false;
        	}
        	
        	var currentdate = document.getElementById('currentdate').value;
        	if(currentdate != '' && enddate != '' && currentdate > enddate){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="enddate"/>]</span>不能小于<span style=\'color:#F00; font-size:12px;\'>[<s:text name="currentdate"/>]</span></span>';
				errorMessageShow(alertstr);
				return false;
        	}
        	
        	return true;
        }
        function checkLogoType(name,types) {
            var isPass = false;
            if(document.all[name] == null) {
                return true;
            }
            var val = document.all[name].value;
            if(val == "") {
                // 没有logo图片上传
                return true;
            }
            var pos = val.indexOf(".");
            var imgType = val.substring(pos+1);
            
            var typeArr = types.split(",");
            for(var i=0;i<typeArr.length;i++) {
                if(imgType == typeArr[i]) {
                	isPass = true;
                	break;
                }
            }
            if(!isPass) {
            	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="advlogo"/>]</span>的类型必须是['+types+']格式</span>';
            	errorMessageShow(alertstr);
            }
            return isPass;
        }
        
        <s:if test="CMD == WEB_CMD_EDIT">
    		var rowCount = 1;
    	</s:if>
    	<s:elseif test="CMD == WEB_CMD_NEW">
			var rowCount = 2;
		</s:elseif>
        function insertRow() {
            var table = document.getElementById('attachment_table');
            var trlength = table.rows.length;
            var lastRow = table.rows[trlength-1];
            var tdlength = lastRow.cells.length;
            var tds = new Array();
            tds[0] = '<s:text name="attachment"/>:&nbsp';
            tds[1] = '<input type="file" name="doc" />';
            tds[2] = '<input type="button" class="button_Save" value="删除" onclick="removeRow(this)"/>';
            var newRow = table.insertRow(trlength);
            for(var c=0;c<tdlength;c++) {
                var newtd = newRow.insertCell(c);
                newtd.align = lastRow.cells[c].align;
                newtd.width = lastRow.cells[c].width;
                newtd.innerHTML = tds[c]; 
            }
            rowCount++;
        }
        function removeRow(delBtn) {
            /*
            if(rowCount <= 2) {
                alert("<s:text name='attach_alert'/>");
                return;
            }
            */
        	var i=delBtn.parentNode.parentNode.rowIndex;
        	document.getElementById('attachment_table').deleteRow(i);
        	rowCount -- ;
        	<s:if test="CMD == WEB_CMD_EDIT">
	        	// 获取要删除附件的Id和附件路径
	        	document.all['delaffixs'].value=document.all['delaffixs'].value +delBtn.id+";";
    		</s:if>
        	
        }
        //选择对象类型
        function selectDesttype(val){
        	$("#objinfo").val("");
        	if(val=='4' || val=='5'){
        		$("#destselct").show();
        		$("#destselctText").show();
        	}else{
        		$("#destselct").hide();
        		$("#destselctText").hide();
        	}
        } 
        //选择是否需要审批
        function selectNdapproval(val){
        	if(val=='1'){
        		$(":hidden[name='form.state']").val("2");
        	}else{
        		$(":hidden[name='form.state']").val("1");
        	}
        }
         function showMultiOpr() {
        	var opercode = $("#objinfo").get(0);
			var originalValue = opercode.value;
			//获取标识符字符串
			var str = "";
			if(originalValue!="")
			{
				var valArray = originalValue.split(",");
				for(var i=0; i<valArray.length; i++)
				{
					str = str + valArray[i].split(" ")[0] + ",";
				}
			}
			
			$("#selectedStr").val(str);
			var strUrl = contextPath + "/common/multiselect_showopr.do";
			var ret = window.showModalDialog(strUrl, self, "dialogWidth:800px; dialogHeight:500px; status:no; resizable:no;");
			if ('NULL' != ret) {
				opercode.value = ret;
			}
			return ret;
		}
		
		
		function openPic(obj)
        {
        	var desttype = $("#desttype").val();
        	if(desttype=='4')
			{
				showMultiOpr();
			}
			else if(desttype=='5')
			{
				openPicker(obj,'#ADVGROUP','');
			}
        }
        
        
         $(document).ready(function(){ 
        	if($("#cmd").val()!="NEW")
        	{
        		var smsnotify = $("#smsnotify").val();
        		$("#smsnotify").children().each(function(i){
        			if($(this).val() == smsnotify)
        			{
        				var str = $(this).html() + '<input type="hidden" name="form.smsnotify" value="' + smsnotify + '"/>';
        				$("#smsnotify").parent().html(str);
        			}
        		});
        		
        		var ndapproval = $("#ndapproval").val();
        		$("#ndapproval").children().each(function(i){
        			if($(this).val() == ndapproval)
        			{
        				var str = $(this).html() + '<input type="hidden" name="form.ndapproval" value="' + ndapproval + '"/>';
        				$("#ndapproval").parent().html(str);
        			}
        		});
        	}
        	else
        	{
        		$("#smsnotify").show();
        		$("#ndapproval").show();
        	}
	        	
         		if($(":hidden[name='param._ne_type']").val()=='1' || $(":hidden[name='param._ne_type']").val()=='6'){//为公告时
         			if($(":hidden[name='CMD']").val()=='NEW'){
		         		var now= new Date(); 
						var year=now.getYear();
						var month=now.getMonth()+1;
						var day=now.getDate();
						if(month<10)
							month="0"+month;
						if(day<10)
							day="0"+day;
						var yyyyMMdd=year+"-"+month+"-"+day;//发送时间默认为当天
						$(":text[name='form.releasetime']").val(yyyyMMdd);
						//$(":hidden[name='form.type']").val("1");
         				$(":hidden[name='form.state']").val("1");
					}
         			$(":select[name='form.type'] option").each(function(){
						if($(this).val() !='1' && $(this).val() !='6' ){
							$(this).remove();
						}
					});
         			//为公告时，不能选择类型“6渠道经理”
         			$(":select[name='form.desttype'] option").each(function(){
						if($(this).val() =='6'|| $(this).val() =='7'){
							$(this).remove();
						}
					});
				
					//对象选择框在选择对象类型为4,5时才显示
	        		if($(":select[name='form.desttype']").val()=='4' || $(":select[name='form.desttype']").val()=='5'){
	        			$("#destselct").show();
		        		$("#destselctText").show();
	        		}
	        	}
	        	if($(":hidden[name='param._ne_type']").val()=='4'){//为在线学习时
	        		$("select[@name='form.desttype'] option").each(function(){
						if($(this).val() =='4' ||$(this).val() =='5'|| $(this).val() =='6'|| $(this).val() =='7')
							$(this).remove();
						
					});
	        	}
	        	
	        	selectNdapproval($("#ndapproval").val());
	        	
    	}); 

      	function doDownload(cmdDownload) {
      		formItem.action = contextPath + cmdDownload;
      	    formItem.submit();
      	}
    </script>
</head>
<body>
<div class="table_container">
<s:form action="advinfo_krsave.do" cssStyle="formList" key="formItem" enctype="multipart/form-data"
			method="post" theme="simple" onsubmit="return ev_checkval();">
	<s:hidden name="form.selectedStr" id="selectedStr"/>
			
    <s:hidden name="CMD" id="cmd"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._ne_advinfoid"/>
    <s:hidden name="param._se_title"/>
    <s:hidden name="param._se_content"/>
    <s:hidden name="param._ne_type"/>
    <s:hidden name="param._de_releasetime"/>
    <s:hidden name="param._de_plantime"/>
    <s:hidden name="param._dnm_enddate"/>
    <s:hidden name="param._ne_desttype"/>
    <s:hidden name="param._ne_smsnotify"/>
    <s:hidden name="param._ne_ndapproval"/>
    <s:hidden name="param._se_oprcode"/>
    <s:hidden name="param._ne_state"/>
    <s:hidden name="form.state"/>
    <s:hidden name="form.oprcode"/>
    <s:hidden name="form.url"/>
    
    <s:hidden name="form.advinfoid"/>
    
    <s:if test="param._ne_type != 1 && param._ne_type != 6">
    	<s:hidden name="form.type"/>
    </s:if>
    <s:hidden name="delaffixs"/>
    <s:hidden name="param._pk"/>
    <s:hidden name="downloadReturnActionName" value="advinfo_krOrAdvedit"/>
    <s:hidden name="downloadReturnMethod" value="doKrOrAdvedit"/>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="communication"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h">
				<s:if test="param._ne_type == 2">
					<s:text name="qa_online"/>
				</s:if>
				<s:if test="param._ne_type == 4">
					<s:text name="study_online"/>
				</s:if>
				<s:if test="param._ne_type == 1">
					<s:text name="advinfo" />
				</s:if>
			</span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent2"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
                <td align="right" width="20%"><s:text name="title"/>:&nbsp</td>
                <td align="left" colspan="3" >
                	 <s:if test="%{CMD == WEB_CMD_NEW || CMD == WEB_CMD_EDIT}">
						<s:textfield cssStyle="width:400px" name="form.title" maxlength="256"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="width:400px" name="form.title" maxlength="256" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                
                <s:if test="%{param._ne_type == 1 || param._ne_type == 6}">
    
	                 <td align="right" width="20%"><s:text name="type"/>:&nbsp</td>
	                  <td align="left" colspan="3">
	                  	<j:selector definition="$CH_ADVINFOTYPE" name="form.type" cssStyle="style_input"  />
	                  </td>
				</s:if>
            </tr>
            <tr>
                <td align="right" width="20%"><s:text name="content"/>:&nbsp</td>
                <td align="left" colspan="3">
                <s:if test="%{CMD == WEB_CMD_NEW || CMD == WEB_CMD_EDIT}">
                	 <FCK:editor instanceName="form.content">
                	 <jsp:attribute name="value"><s:property value="form.content" escape="false"/></jsp:attribute>
					</FCK:editor>
					<font color=red>*</font>
				</s:if>
				<s:else>	
				<s:property value="form.content" escape="false"/>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right" width="20%"><s:text name="releasetime"/>:&nbsp</td>
                <td align="left">
                	<s:if test="%{CMD == WEB_CMD_NEW || CMD == WEB_CMD_EDIT}">
						<input type="text" class="style_input" name="form.releasetime" id="releasetime" maxlength="10" onclick="selectDate();" value="<s:date name="form.releasetime" format="yyyy-MM-dd"/>">
						<font color=red>*</font>
					</s:if>
					<s:else>
						<input type="text" class="style_input" name="form.releasetime" id="releasetime" maxlength="10" onclick="selectDate();" value="<s:date name="form.releasetime" format="yyyy-MM-dd"/>" disabled="true">
					</s:else>
                </td>
                <s:if test="param._ne_type == 1 ||param._ne_type == 6">
                	<td align="right" width="20%"><s:text name="enddate"/>:&nbsp</td>
                	<td align="left">
                	<input type="hidden" id="currentdate" value="<s:date name="form.currentdate" format="yyyy-MM-dd"/>" />
                	<s:if test="%{CMD == WEB_CMD_NEW || CMD == WEB_CMD_EDIT}">
						<input type="text" class="style_input" name="form.enddate" id="enddate" maxlength="10" onclick="selectDate();" value="<s:date name="form.enddate" format="yyyy-MM-dd"/>">
						<font color=red>*</font>
					</s:if>
					<s:else>
						<input type="text" class="style_input" name="form.enddate" id="enddate" maxlength="10" onclick="selectDate();" value="<s:date name="form.enddate" format="yyyy-MM-dd"/>" disabled="true">
					</s:else>
                	</td>
                </s:if>
            </tr>
            <s:if test="param._ne_type == 1">
            	<tr>
            		<td align="right" width="20%"><s:text name="smsnotify"/>:&nbsp</td>
            		<td>
            			<s:select name="form.smsnotify" id="smsnotify" theme="simple" listKey="key"
						listValue="value" list="#{'0':'否', '1':'是'}" cssStyle="display:none"/>
					</td>
					<td align="right" width="20%"><s:text name="ndapproval"/>:&nbsp</td>
					<td>
						<s:select name="form.ndapproval" id="ndapproval" theme="simple" listKey="key"
						listValue="value" list="#{'0':'否', '1':'是'}"  onchange="selectNdapproval(this.value);" cssStyle="display:none"/>
					</td>				
					
            	</tr>
            	<tr>
            		<td align="right" width="20%"><s:text name="advlogo"/>:&nbsp</td>
            		<td>
						<s:file name="logo" label="File" />
	                </td>
            	</tr>
            </s:if>
        </table>
    </div>
     <div class="table_div">
	     <table class="table_normal" id="attachment_table">
	     	<s:if test="CMD != WEB_CMD_SAVE">
	     	<tr>
	     		<td align="right" width="20%"></td>
	     		<td align="center" width="60%"></td>
	     		<td align="center" width="20%"><input type="button" class="button_Save" value="新增" onclick="javascript:insertRow()"></td>
	     	</tr>
	     	</s:if>
	     	<s:if test="CMD == WEB_CMD_EDIT">
	     		<s:if test="dp.datas.size==0">
		     		<tr>
	                <td align="right" width="20%"><s:text name="attachment"/>:&nbsp</td>
	                <td align="center">
						<s:file name="doc" label="File" />
	                </td>
	                <td align="center"><input type="button" class="button_Save" value="删除" onclick="javascript:removeRow(this)"></td>
	            	</tr>
	     		</s:if>
	     		
	     		<s:iterator value="dp.datas">
	     		<script language="JavaScript">
	     			++rowCount;
	     		</script>
	     		<tr>
                <td align="right" width="20%"><s:text name="attachment"/>:&nbsp</td>
                <td align="center">
	                <a href='javascript:doDownload("/communication/advinfo_affixDownload.do?affixid=<s:property value="affixid"/>")'> 
						<s:property value="affixname"/>
					</a>
                </td>
                <td align="center"><input id="<s:property value="affixid"/>,<s:property value="affixpath"/>" type="button" class="button_Save" value="删除" onclick="javascript:removeRow(this)"></td>
                </tr>
                </s:iterator>
	     	</s:if>
	     	<s:elseif test="CMD == WEB_CMD_SAVE">
	     		<s:iterator value="dp.datas">
	     		<tr>
                <td align="right" width="20%"><s:text name="attachment"/>:&nbsp</td>
                <td align="center">
	                <a href='javascript:doDownload("/communication/advinfo_affixDownload.do?affixid=<s:property value="affixid"/>")'> 
						<s:property value="affixname"/>
					</a>
                </td>
                <td align="center"></td>
                </tr>
                </s:iterator>
	     	</s:elseif>
	     	<s:elseif test="CMD == WEB_CMD_NEW">
	     	<tr>
                <td align="right" width="20%"><s:text name="attachment"/>:&nbsp</td>
                <td align="center">
					<%--<s:file name="doc" label="File" />
					--%><input type="file" name="doc" />
                </td>
                <td align="center"><input type="button" class="button_Save" value="删除" onclick="javascript:removeRow(this)"></td>
            </tr>
	     	</s:elseif>
            
        </table>
	</div>
    <div class="table_div">
	     <table class="table_normal">
	            <tr>
	                <td align="right" width="20%"><s:text name="desttype"/>:&nbsp</td>
	                <td align="left">
	                	
						<s:if test="%{CMD == WEB_CMD_NEW || CMD == WEB_CMD_EDIT}">
							<j:selector definition="$CH_ADVINFODESTTYPE" name="form.desttype" id="desttype" cssStyle="style_input" onchange="selectDesttype(this.value);" />
							<font color=red>*</font>
						</s:if>
						<s:else>
							<j:selector definition="$CH_ADVINFODESTTYPE" name="form.desttype" id="desttype" cssStyle="style_input" onchange="selectDesttype(this.value);" disabled="true" />
						</s:else>
						
	                </td>
	                <s:if test="param._ne_type == 1 || param._ne_type == 6">
						<td align="right" width="20%" id="destselct" style="display: none" <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>>对象选择:&nbsp</td>
	                	<td  id="destselctText" style="display: none" >
		                	<s:textfield cssStyle="style_input" name="form.objinfo" id="objinfo"/><input type="button" name="form.objinfo_button" class="picker_button" value="..." onClick="openPic(this)"/>
							<font color=red>*</font>
	                	</td>
	                </s:if>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/communication/advinfo_save.do')" <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>

<script type="text/javascript">
	// 根据类型控制保存按钮和返回按钮的路径
	var saveBtn = document.getElementById("btnSave");
	var returnBtn = document.getElementById("btnReturn");
	var type = document.getElementsByName("param._ne_type")[0].value;
	var returnPath = "";
	var savePath = "";
	if(type == "4") {
		returnPath = "/communication/advinfo_krlist.do";
		savePath = "/communication/advinfo_krsave.do";
	}else if(type == "2") {
		returnPath = "/communication/advinfo_qalist.do";
	}else if(type == "1" || type == "6") {
		returnPath = "/communication/advinfo_advlist.do";
		savePath = "/communication/advinfo_advsave.do";
	}
	saveBtn.onclick = new Function("doSave('"+savePath+"')");
	returnBtn.onclick = new Function("doReturn('"+returnPath+"')");
</script>
</body>
</html>
