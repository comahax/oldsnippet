<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="examine" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
        	if(!setSaveForm()){
        		return false;
        	}
            addfield('exmnid', '<bean:message bundle="examine" key="exmnid"/>', 'f', true, '6');
            addfield('exmnname', '<bean:message bundle="examine" key="exmnname"/>', 'c', false, '50');
            addfield('state', '<bean:message bundle="examine" key="state"/>', 'c', false, '32');
            //addfield('cityid', '<bean:message bundle="examine" key="cityid"/>', 'c', true, '2');
            addfield('adtype', '<bean:message bundle="examine" key="adtype"/>', 'c', false, '32');
            addfield('starlevel', '<bean:message bundle="examine" key="starlevel"/>', 'c', false, '32');
            addfield('memo', '<bean:message bundle="examine" key="memo"/>', 'c', true, '512');
            if(document.getElementById("provincialright").value=='YES'){
           		 addfield('rights', '<bean:message bundle="examine" key="rights"/>', 'c', true, '32');
           		  addfield('applycityid', '<bean:message bundle="examine" key="applycityid"/>', 'c', false, '128');
           	} 
            return checkval(window);
        }
        
        function setSaveForm(){
        	//区域类型
        	var adtypebox=document.getElementsByName("adtypebox");
        	var adtype="";
        	for(var i=0;i<adtypebox.length;i++){
        		if(adtypebox[i].checked==true){
        			if(adtype=='')
        				adtype+=adtypebox[i].value;
        			else
        				adtype+=","+adtypebox[i].value;
        		}
        	}
        	
        		document.getElementsByName("adtype")[0].value=adtype;
        	if(adtype==""){
        		var alertstr='<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<bean:message bundle="examine" key="adtype"/>]</span>不能为空</span>';
				errorMessageShow(alertstr);
        		return false;
        	}
        	//星级
        	var starlevelbox=document.getElementsByName("starlevelbox");
        	var starlevel="";
        	for(var i=0;i<starlevelbox.length;i++){
        		if(starlevelbox[i].checked==true){
        			if(starlevel=="")
        				starlevel+=starlevelbox[i].value;
        			else
        				starlevel+=","+starlevelbox[i].value;
        		}
        	}
        
        		document.getElementsByName("starlevel")[0].value=starlevel;
        	if(starlevel==""){
        		var alertstr='<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<bean:message bundle="examine" key="starlevel"/>]</span>不能为空</span>';
				errorMessageShow(alertstr);
        		return false;
        	}
        		
        	
        	if(document.getElementById("provincialright").value=='YES'){
        		//应用地市
	        	var applycityidbox=document.getElementsByName("applycityidbox");
	        	var applycityid="";
	        	for(var i=0;i<applycityidbox.length;i++){
	        		if(applycityidbox[i].checked==true){
	        			if(applycityid=="")
	        				applycityid+=applycityidbox[i].value;
	        			else
	        				applycityid+=","+applycityidbox[i].value;
	        		}
	        	}
	        	document.getElementsByName("applycityid")[0].value=applycityid;
	        	if(applycityid==""){
	        		var alertstr='<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<bean:message bundle="examine" key="applycityid"/>]</span>不能为空</span>';
					errorMessageShow(alertstr);
	        		return false;
	        	}
	        	//权限
	        	if(document.getElementById("rightsbox").checked==true)
	        		document.getElementsByName("rights")[0].value='1';
	        	else
	        		document.getElementsByName("rights")[0].value='0';
        	}else{
				 document.getElementsByName("rights")[0].value='0';       	
        	}
        	return true;
        }
        /*
        *全选通用方法
        */
        function checkAllbox(thisAllbox,boxname){
        	var checkboxs=document.getElementsByName(boxname);
        	for(var i=0;i<checkboxs.length;i++){
        		if(thisAllbox.checked==true){
        			checkboxs[i].checked=true;
        		}else{
        			checkboxs[i].checked=false;
        		}
        	}
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/examine/examine.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_exmnid"/>
    <html:hidden property="_sk_exmnname"/>
    <html:hidden property="_se_state"/>
    <html:hidden property="_se_adtype"/>
    <html:hidden property="_sk_adtype"/>
    <html:hidden property="_se_starlevel"/>
    <html:hidden property="_sk_starlevel"/>
    <html:hidden property="exmnid"/>
    <html:hidden  property="rights" />
    <html:hidden  property="applycityid" />
    <html:hidden  property="adtype" />
    <html:hidden  property="starlevel" />
    <html:hidden  property="cityid" />
     <input type="hidden" id="provincialright" name="provincialright" value="<c:out value="${provincialright}"/>">
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/examine/examine/ExamineForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="examine" key="titleList"/>
   			</td>
    	</tr>
    </table>
    </div>
    <div class="table_div">	
   		 <table width="100%" class="error_text">
    		<html:errors/><s:Msg />
    	</table>
    </div>

    <div class="table_div">
        <table class="form_table">
           
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="examine" key="exmnname"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="exmnname" />
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="exmnname" disabled="true"/>
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="examine" key="state"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:select property="state"  >
                        		    <option/>
                        		    <s:Options definition="$CH_KHSTATE"/>
                        	  </html:select>
                        	  <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                             <html:select property="state" disabled="true" >
                        		    <option/>
                        		    <s:Options definition="$CH_KHSTATE"/>
                        	  </html:select>
                        	  <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
           <c:if test="${(provincialright=='YES'and form.cmdState=='NEW') or (form.cmdState=='EDIT' and form.cityid=='GD') }">
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="examine" key="rights"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                           	是否允许地市公司修改占比：<input type="checkbox" id="rightsbox" name="rightsbox" value="1" class="table_checkbox">（注：勾上允许，否则不允许）
                        </c:when>
                        <c:otherwise>
                                是否允许地市公司修改占比：<input type="checkbox" id="rightsbox" name="rightsbox" value="1" disabled="disabled" class="table_checkbox">（注：勾上允许，否则不允许）
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="examine" key="applycityid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                          	 全省<input type="checkbox" id="allapplycityid" name="allapplycityid" onclick="checkAllbox(this,'applycityidbox');" class="table_checkbox">
                        	<c:forEach items="${applycityMap}" var="item">
									<c:out value="${item.value}"/><input type="checkbox"  name="applycityidbox" value="<c:out value="${item.key}"/>" class="table_checkbox">
							</c:forEach>
							<font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                                 全省<input type="checkbox" id="allapplycityid" name="allapplycityid" onclick="checkAllbox(this,'applycityidbox');" class="table_checkbox" disabled="disabled">
                        	<c:forEach items="${applycityMap}" var="item">
									<c:out value="${item.value}"/><input type="checkbox"  name="applycityidbox" value="<c:out value="${item.key}"/>" class="table_checkbox" disabled="disabled">
							</c:forEach>
							<font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            </c:if>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="examine" key="adtype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                    	
                        <c:when test="${edtState}">
                           	全市<input type="checkbox" id="alladtype" name="alladtype" onclick="checkAllbox(this,'adtypebox');" class="table_checkbox">
                        	<c:forEach items="${adtypeMap}" var="item">
									<c:out value="${item.value}"/><input type="checkbox"  name="adtypebox" value="<c:out value="${item.key}"/>" class="table_checkbox">
							</c:forEach>
							<font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                                全市<input type="checkbox" id="alladtype" name="alladtype" onclick="checkAllbox(this,'adtypebox');" class="table_checkbox" disabled="disabled">
                        	<c:forEach items="${adtypeMap}" var="item">
									<c:out value="${item.value}"/><input type="checkbox"  name="adtypebox" value="<c:out value="${item.key}"/>" class="table_checkbox" disabled="disabled">
							</c:forEach>
							<font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="examine" key="starlevel"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                          	全部星级<input type="checkbox" id="allstarlevel" name="allstarlevel" onclick="checkAllbox(this,'starlevelbox');" class="table_checkbox">
                          	<c:forEach items="${startLevelMap}" var="item">
									<c:out value="${item.value}"/><input type="checkbox"  name="starlevelbox" value="<c:out value="${item.key}"/>" class="table_checkbox">
							</c:forEach>
							<font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                                全部星级<input type="checkbox" id="allstarlevel" name="allstarlevel" onclick="checkAllbox(this,'starlevelbox');" class="table_checkbox" disabled="disabled">
                          	<c:forEach items="${startLevelMap}" var="item">
									<c:out value="${item.value}"/><input type="checkbox"  name="starlevelbox" value="<c:out value="${item.key}"/>" class="table_checkbox" disabled="disabled">
							</c:forEach>
							<font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="examine" key="memo"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:textarea styleClass="form_textarea_on_4" property="memo"/>
                        </c:when>
                        <c:otherwise>
                            <html:textarea styleClass="form_textarea_on_4" property="memo" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
           
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" class="form_table_center">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/examine/examine.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/examine/examine.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
<script language="JavaScript">
			var state=document.getElementsByName("state")[0].value;
			if(state==''){
				document.getElementsByName("state")[0].value='1';
			}
			//区域类型
        	var adtype=document.getElementsByName("adtype")[0].value;
        	if(adtype!=""){
        		var adtypes=adtype.split(",");
        		var adtypebox=document.getElementsByName("adtypebox");
        		if(adtypes.length==adtypebox.length)
        			document.getElementById("alladtype").checked=true;
        		for(var i=0;i<adtypes.length;i++){
		        	for(var j=0;j<adtypebox.length;j++){
		        		if(adtypes[i]==adtypebox[j].value)
		        			adtypebox[j].checked=true
		        	}
		        }
	        }
        	//星级
        	var starlevel=document.getElementsByName("starlevel")[0].value;
        	if(starlevel!=""){
        		var starlevels=starlevel.split(",");
        		var starlevelbox=document.getElementsByName("starlevelbox");
        		if(starlevels.length==starlevelbox.length)
        			document.getElementById("allstarlevel").checked=true;
        		for(var i=0;i<starlevels.length;i++){
		        	for(var j=0;j<starlevelbox.length;j++){
		        		if(starlevels[i]==starlevelbox[j].value)
		        			starlevelbox[j].checked=true
		        	}
		        }
	        }
        	
        	
        
        	if(document.getElementsByName("cmdState")[0].value=='EDIT'){//编辑的时候
	        	if(document.getElementsByName("cityid")[0].value=='GD'){
	        		//应用地市
	        		var applycityid=document.getElementsByName("applycityid")[0].value;
		        	if(applycityid!=""){
		        		var applycityids=applycityid.split(",");
		        		var applycityidbox=document.getElementsByName("applycityidbox");
		        		if(applycityids.length==applycityidbox.length)
	        			document.getElementById("allapplycityid").checked=true;
		        		for(var i=0;i<applycityids.length;i++){
				        	for(var j=0;j<applycityidbox.length;j++){
				        		if(applycityids[i]==applycityidbox[j].value)
				        			applycityidbox[j].checked=true
				        	}
				        }
			        }
		        	
		        	//权限
		        	if(document.getElementsByName("rights")[0].value=='1')
		        		document.getElementById("rightsbox").checked=true
		        	if(document.getElementById("provincialright").value!='YES'){
		        		document.getElementsByName("exmnname")[0].disabled=true;
		        		document.getElementsByName("state")[0].disabled=true;
		        		document.getElementsByName("memo")[0].disabled=true;
		        		document.getElementById("alladtype").disabled=true;
		        		document.getElementById("allstarlevel").disabled=true;
		        		document.getElementById("allapplycityid").disabled=true;
		        		document.getElementById("rightsbox").disabled=true;
		        		var adtypebox=document.getElementsByName("adtypebox");
		        		for(var j=0;j<adtypebox.length;j++){
			        		adtypebox[j].disabled=true;
			        	}
			        	var starlevelbox=document.getElementsByName("starlevelbox");
			        	for(var j=0;j<starlevelbox.length;j++){
				        	starlevelbox[j].disabled=true;
				        }
				        var applycityidbox=document.getElementsByName("applycityidbox");
				        for(var j=0;j<applycityidbox.length;j++){
				        	applycityidbox[j].disabled=true;
				        }
		        	}
		        		
		        }else if(document.getElementById("provincialright").value=='YES'){
		        		document.getElementsByName("exmnname")[0].disabled=true;
		        		document.getElementsByName("state")[0].disabled=true;
		        		document.getElementsByName("memo")[0].disabled=true;
		        		document.getElementById("alladtype").disabled=true;
		        		document.getElementById("allstarlevel").disabled=true;
		        		var adtypebox=document.getElementsByName("adtypebox");
		        		for(var j=0;j<adtypebox.length;j++){
			        		adtypebox[j].disabled=true;
			        	}
			        	var starlevelbox=document.getElementsByName("starlevelbox");
			        	for(var j=0;j<starlevelbox.length;j++){
				        	starlevelbox[j].disabled=true;
				        }
		        }
		  }
</script>
</html>
