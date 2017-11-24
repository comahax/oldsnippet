<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<%
	String filename= (String)request.getAttribute("filename");
	String zqpicfilename=(String)request.getAttribute("zqpicfilename");

%>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script type="text/javascript"src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    
<script language="JavaScript">
	function ev_checkval() {  
		addfield('form.wayid', '<s:text name="wayid"/>', 'c', false, 18);
		addfield('form.area', '<s:text name="area"/>', 'f', false, 14); 
		addfield('form.zqtype', '<s:text name="zqtype"/>', 'f', false, 2);
		addfield('form.zqpic', '<s:text name="zqpic"/>', 'c', true, 225);
		addfield('form.zqarea', '<s:text name="zqarea"/>', 'f', false, 14);
		addfield('form.zqpanel', '<s:text name="zqpanel"/>', 'f', false, 2);
		addfield('form.zqcupboard', '<s:text name="zqcupboard"/>', 'i', false, 4);
		addfield('form.zqcards', '<s:text name="zqcards"/>', 'i', false, 4);
		addfield('form.zqpricetag', '<s:text name="zqpricetag"/>', 'i', false, 4);
		addfield('form.zqrack', '<s:text name="zqrack"/>', 'i', false, 4);
		addfield('form.zqinad', '<s:text name="zqinad"/>', 'f', false, 2);
		addfield('form.zqoutad', '<s:text name="zqoutad"/>', 'f', false, 2);
		addfield('form.zqhead', '<s:text name="zqhead"/>', 'f', false, 2);
		addfield('form.zqpaste', '<s:text name="zqpaste"/>', 'f', false, 2);
		addfield('form.zqtablecard', '<s:text name="zqtablecard"/>', 'i', false, 4);
		addfield('form.zqdecca', '<s:text name="zqdecca"/>', 'i', false, 4);
		addfield('form.zqbill', '<s:text name="zqbill"/>', 'i', false, 4);
		addfield('form.doorpic', '<s:text name="doorpic"/>', 'c', true, 225);
		addfield('form.doortype', '<s:text name="doortype"/>', 'f', false, 2);
		addfield('form.outwallad', '<s:text name="outwallad"/>', 'f', false, 14);
		addfield('form.outwallpic', '<s:text name="outwallpic"/>', 'i', false, 2);
		addfield('form.tdmonopoly', '<s:text name="tdmonopoly"/>', 'f', false, 2);
		addfield('form.busimonopoly', '<s:text name="busimonopoly"/>', 'f', false, 2);
		addfield('form.storeconduct', '<s:text name="storeconduct"/>', 'i', false, 4);
		addfield('form.modulus', '<s:text name="modulus"/>', 'f', true,1,2,0,0,1);  
	 
		 if(document.all("form.zqtype").value!=""){
	      var doortype = document.all("form.doortype").value;
	      var zqtype = document.all("form.zqtype").value;
	      if ((doortype == '3' && zqtype== '4' ) || (doortype == '4' && zqtype== '3' ) ){ 
        	 var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>【专区类型】与【门店类型】互斥，如果是[专区类型]3G专区则[门店类型]必须为3G门店类型，[专区类型]4G专区则[门店类型]必须为4G门店类型</span>';
        			errorMessageShow(alertstr);
            		return false;
            }
        }    
 
        
		return checkval(window);
	} 
	
	
</script>
</head>
<body>
<div class="table_container">
<s:form action="waystoreinfo_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" enctype="multipart/form-data" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
	<s:hidden name="isQuery" value="true"></s:hidden>
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="base"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
                <td align="right"><s:text name="wayid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.wayid" maxlength="18"  disabled="true"/>
                        <input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'form.wayid','','','AG','FDS|FD|VWAY|PSAL|SAGT|JMQD');this.value='...';" />
                        <font color=red>*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.wayid" disabled="true"/>
						<font color=red>*</font>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.wayid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td> 
                <td align="right"><s:text name="area"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.area" maxlength="14"/><font color='red'>*</font>平方
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.area" disabled="true"/><font color='red'>*</font>
					</s:else>
                </td>
            </tr> 
            <tr>
                <td align="right"><s:text name="zqtype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE"> 
					<j:selector definition="$CH_WAYSTORETYPE" name="form.zqtype" />
                    <font color='red'>*</font>
					</s:if>
					<s:else>
						<j:selector definition="$CH_WAYSTORETYPE" name="form.zqtype" /> <font color='red'>*</font>
					</s:else>
                </td> 
                <td align="right"><s:text name="zqpic"/>:&nbsp</td>
                <td align="left">
                	<s:file name="zqPic" label="File" /><font color='red'>文件类型只能为JPG，大小不能超过3M。</font>
                	<a href='<%=contextPath%>/channel/waystoreinfo/waystoreinfo_download.do?file=<s:property value="form.zqpicpath" />'> 
                       <s:property value="form.zqpic" />
					<%--<input type="file" name="serv" id="gongwen" value="<%=filename %>" class="form_text :required edit">--%>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="zqarea"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.zqarea" maxlength="14"/><font color='red'>*</font>平方
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.zqarea" disabled="true"/><font color='red'>*</font>平方
					</s:else>
                </td> 
                <td align="right"><s:text name="zqpanel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
					 <j:selector definition="$CH_YESORNO1" name="form.zqpanel" /><font color='red'>*</font>
					</s:if>
					<s:else>
					 <j:selector definition="$CH_YESORNO1" name="form.zqpanel" /><font color='red'>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="zqcupboard"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.zqcupboard" maxlength="4"/><font color='red'>*</font>个
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.zqcupboard" disabled="true"/><font color='red'>*</font>个
					</s:else>
                </td> 
                <td align="right"><s:text name="zqcards"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.zqcards" maxlength="4"/><font color='red'>*</font>个
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.zqcards" disabled="true"/><font color='red'>*</font>个
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="zqpricetag"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.zqpricetag" maxlength="4"/><font color='red'>*</font>个
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.zqpricetag" disabled="true"/><font color='red'>*</font>个
					</s:else>
                </td> 
                <td align="right"><s:text name="zqrack"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.zqrack" maxlength="4"/><font color='red'>*</font>个
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.zqrack" disabled="true"/><font color='red'>*</font>个
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="zqinad"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
					 <j:selector definition="$CH_YESORNO1" name="form.zqinad" />
						<font color='red'>*</font>
					</s:if>
					<s:else>
						 <j:selector definition="$CH_YESORNO1" name="form.zqinad" /><font color='red'>*</font>
					</s:else>
                </td> 
                <td align="right"><s:text name="zqoutad"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
					 <j:selector definition="$CH_YESORNO1" name="form.zqoutad" />
					<font color='red'>*</font>
					</s:if>
					<s:else>
						 <j:selector definition="$CH_YESORNO1" name="form.zqoutad" /><font color='red'>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="zqhead"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE"> 
						 <j:selector definition="$CH_YESORNO1" name="form.zqhead" /><font color='red'>*</font>
					</s:if>
					<s:else>
						 <j:selector definition="$CH_YESORNO1" name="form.zqhead" /><font color='red'>*</font>
					</s:else>
                </td> 
                <td align="right"><s:text name="zqpaste"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE"> 
						 <j:selector definition="$CH_YESORNO1" name="form.zqpaste" /><font color='red'>*</font>
					</s:if>
					<s:else>
						  <j:selector definition="$CH_YESORNO1" name="form.zqpaste" /><font color='red'>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="zqtablecard"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.zqtablecard" maxlength="4"/><font color='red'>*</font>个
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.zqtablecard" disabled="true"/><font color='red'>*</font>个
					</s:else>
                </td> 
                <td align="right"><s:text name="zqdecca"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.zqdecca" maxlength="4"/><font color='red'>*</font>个
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.zqdecca" disabled="true"/><font color='red'>*</font>个
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="zqbill"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.zqbill" maxlength="4"/><font color='red'>*</font>张
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.zqbill" disabled="true"/><font color='red'>*</font>张
					</s:else>
                </td> 
                <td align="right"><s:text name="doorpic"/>:&nbsp</td>
                <td align="left">
                	<s:file name="doorPic" label="File" /><font color='red'>文件类型只能为JPG，大小不能超过3M。</font>
                	<a href='<%=contextPath%>/channel/waystoreinfo/waystoreinfo_download.do?file=<s:property value="form.doorpicpath" />'> 
                       <s:property value="form.doorpic" />
					<%--<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.doorpic" maxlength="225"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.doorpic" disabled="true"/>
					</s:else>
                --%></td>
            </tr>
            <tr>
                <td align="right"><s:text name="doortype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						  <j:selector definition="$CH_DOORTYPE" name="form.doortype" /><font color='red'>*</font>
					</s:if>
					<s:else>
						   <j:selector definition="$CH_DOORTYPE" name="form.doortype" /><font color='red'>*</font>
					</s:else>
                </td> 
                <td align="right"><s:text name="outwallad"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.outwallad" maxlength="14"/><font color='red'>*</font>平方
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.outwallad" disabled="true"/><font color='red'>*</font>平方
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="outwallpic"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.outwallpic" maxlength="2"/><font color='red'>*</font>个
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.outwallpic" disabled="true"/><font color='red'>*</font>个
					</s:else>
                </td> 
                <td align="right"><s:text name="tdmonopoly"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						  <j:selector definition="$CH_YESORNO2" name="form.tdmonopoly" /><font color='red'>*</font>
					</s:if>
					<s:else>
						 <j:selector definition="$CH_YESORNO2" name="form.tdmonopoly" /><font color='red'>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="busimonopoly"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						 <j:selector definition="$CH_YESORNO2" name="form.busimonopoly" /><font color='red'>*</font>
					</s:if>
					<s:else>
						 <j:selector definition="$CH_YESORNO2" name="form.busimonopoly" /><font color='red'>*</font>
					</s:else>
                </td> 
                <td align="right"><s:text name="storeconduct"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.storeconduct" maxlength="4"/><font color='red'>*</font>个
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.storeconduct" disabled="true"/><font color='red'>*</font>个
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="modulus"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.modulus" maxlength="4"/><font color='red'>*</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.modulus" disabled="true"/><font color='red'>*</font>
					</s:else>
                </td>
                  <td colspan="2"></td>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/channel/waystoreinfo_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/waystoreinfo_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>