<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript"><!--
        function ev_checkval() {
			addfield('form.employeename', '<s:text name="employeename"/>', 'c', false, 30);
			addfield('form.birthday', '<s:text name="birthday"/>', 't', true, 7);
			addfield('form.sex', '<s:text name="sex"/>', 'f', false, 3);
			addfield('form.isnet', '<s:text name="isnet"/>', 'f', false, 2);
			addfield('form.edulevel', '<s:text name="edulevel"/>', 'f', true, 3);
			//addfield('form.telephone', '<s:text name="telephone"/>', 'c', true, 15);
			if(trim(document.getElementById("form.cardid").value).length!=15 && trim(document.getElementById("form.cardid").value).length!=18)
			{
				alert("身份证号码为必填，且长度必须为15或18位");
				return ;
			}
			addfield('form.cardid', '<s:text name="cardid"/>', 'c', false, 18);
			addfield('form.pvtemail', '<s:text name="pvtemail"/>', 'm', true, 128);
			addfield('form.officetel', '<s:text name="officetel2"/>', 'c', false, 12);
			addfield('form.selectmobile', '<s:text name="selectmobile"/>', 'c', true, 12);
			if('ZJTY'!=document.getElementById("form.waysubtype").value)
			{
				addfield('form.right','<s:text name="employee_type"/>','i',true,2);
			}
			else
			{
			addfield('form.right','<s:text name="employee_type"/>','i',false,2);
			}
			addfield('form.oprcode2', '<s:text name="oprcode"/>', 'c', true, 15);
			addfield('form.cityid', '<s:text name="cityid"/>', 'c', false, 14);
			addfield('form.countyid', '<s:text name="countyid"/>', 'c', false, 14);
			addfield('form.wayid', '<s:text name="wayid"/>', 'c', false, 18);
			addfield('form.intime', '<s:text name="intime"/>', 't', false, 7);
			addfield('form.contacttype', '<s:text name="contacttype"/>', 'i', false, 2);
			addfield('form.employtype', '<s:text name="employtype"/>', 'i', false, 3);
			addfield('form.empstatus', '<s:text name="empstatus"/>', 'i', false, 2);
			addfield('form.bail', '<s:text name="bail"/>', 'f', true, 10,2);
            return checkval(window);
        }
        
        //根据渠道设置对应地市，分公司值
         function getCityAndCounty(wayId){
        var url = contextPath+"/channel/employee_getWayInfo1.do";
        	$.post(url,
		       { 'form.wayid': wayId },
		       function(data){
		       //返回的数据格式为:countyid:countyname,cityid:cityname
		          if(data != null && "" != data){
			          var resultArray = data.split(',');
			          var countyArray = resultArray[0].split(':');
			          var cityArray = resultArray[1].split(':');
			          var waysubtype=resultArray[2];
			          document.getElementById('form.cityid').value=cityArray[0];
			          document.getElementById('cityName').value=cityArray[1];
			          document.getElementById('form.countyid').value=countyArray[0];
			          document.getElementById('countyName').value=countyArray[1];
			          document.getElementById('form.waysubtype').value=waysubtype;
			          showRed(waysubtype);
		          }
		       } 
			); 
        }
        function showRed(waysubtype)
        {
         if('ZJTY'==waysubtype)
          {
          	document.getElementById('typediv').style.display="";
          }
          else
          {
            document.getElementById('typediv').style.display="none";
          }
        }
        function doSave2()
        {
          showRed(document.getElementById('form.waysubtype').value);
          doSave('/channel/employee_save.do')
        }
        //根据采集平台捆绑手机设置号空中选号
        function setSelectmobile(officetel){
        var reg = /1[0-9]{10}/;
        	if(!reg.test(officetel) && '' != officetel){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="officetel2"/> ]</span> 只能为11位的数字的手机号码 <span style=\'color:#F00; font-size:12px;\'></span>';
				errorMessageShow(alertstr);
				return false;
        	}else{
        		errorMessageShow("");
        	}
        document.getElementById('form.selectmobile').value=officetel;
        }
        
    --></script>
</head>
<body>
<div class="table_container">
<s:form action="employee_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="form.employeeid"/>
    <s:hidden name="form.nativehome"/>
    <s:hidden name="form.polivisage"/>
    <s:hidden name="form.department"/>
    <s:hidden name="form.servoffice"/>
    <s:hidden name="form.station"/>
    <s:hidden name="form.joblevel"/>
    <s:hidden name="form.worktime"/>
    <s:hidden name="form.hereworktime"/>
    <s:hidden name="form.company"/>
    <s:hidden name="form.outtime"/>
    <s:hidden name="form.outresult"/>
    <s:hidden name="form.homeaddr"/>
    <s:hidden name="form.waytype"/>
    <s:hidden name="form.ofcphone"/>
    <s:hidden name="form.ofcemail"/>
    <s:hidden name="form.speciality"/>
    <s:hidden name="form.posittype"/>
    <s:hidden name="form.actbank"/>
    <s:hidden name="form.actno"/>
    <s:hidden name="form.actname"/>
    <s:hidden name="form.actpid"/>
    <s:hidden name="form.gradschool"/>
    <s:hidden name="form.gradtime"/>
    <s:hidden name="form.ismarried"/>
    <s:hidden name="form.outreason"/>
    <s:hidden name="form.trainlevel"/>
    <s:hidden name="form.hobby"/>
    <s:hidden name="form.character"/>
    <s:hidden name="form.asses"/>
    <s:hidden name="form.workhistry"/>
    <s:hidden name="form.prizeorpunish"/>
    <s:hidden name="form.empass"/>
    <s:hidden name="form.netpass"/>
    <s:hidden name="form.isopen"/>
    <s:hidden name="form.telephone"/>
    <s:hidden name="form.modelState"/>
    <s:hidden name="form.empmodelid"/>
    
	
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
			<span class="button_Help" onclick="openword('<s:text name="titleList"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
		</div>
	</div>

	<div class="error_text" >
		<table class="error_text">
			<s:actionerror /><s:actionmessage/>
		</table>
	</div>
	
    <div class="table_div">
    <FIELDSET>
	    	<legend name="baseinfo">基本信息</legend>
        <table class="table_normal">
            <tr>
                <td align="right" width=150px><s:text name="employeename"/>:&nbsp</td>
                <td align="left" width=250px>
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.employeename" maxlength="30"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.employeename" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
                <td align="right" width=150px><s:text name="birthday"/>:&nbsp</td>
                <td align="left" width=250px>
					<s:if test="CMD != WEB_CMD_SAVE">
						<input class="style_input" name="form.birthday" value="<s:property value="form.birthday!=null?getText('format.date',{form.birthday}):''"/>" onclick="selectDate();"/>
					</s:if>
					<s:else>
						<input class="style_input" name="form.birthday" value="<s:property value="form.birthday!=null?getText('format.date',{form.birthday}):''"/>" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right" width=150px><s:text name="sex"/>:&nbsp</td>
                <td align="left" width=250px>
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.sex" definition="$CH_SEX" />
					</s:if>
					<s:else>
						<j:selector name="form.sex" definition="$CH_SEX" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
                <td align="right" width=150px><s:text name="isnet"/>:&nbsp</td>
               
                <td align="left" width=250px>
					 <s:if test="CMD == WEB_CMD_NEW">
                        <s:select name="form.isnet" theme="simple" listKey="key"
									listValue="value" cssStyle="select"
									list="#{'':'' ,'1':'店主', '0':'店员'}"	/>
                        <font color=red>*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT and form.isnet eq '3'">
			        	 <s:select name="form.isnet" theme="simple" listKey="key"
									listValue="value" cssStyle="select"
									list="#{'':'' ,'3':'配送商'}"	/>
                        <font color=red>*</font>
					</s:elseif>
					<s:elseif test="CMD == WEB_CMD_EDIT and form.isnet != 3">
			        	 <s:select name="form.isnet" theme="simple" listKey="key"
									listValue="value" cssStyle="select"
									list="#{'':'' ,'1':'店主', '0':'店员'}"	/>
                        <font color=red>*</font>
					</s:elseif>
			        <s:else>
						<j:selector name="form.isnet" definition="$CH_ISNET" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right" width=150px><s:text name="edulevel"/>:&nbsp</td>
                <td align="left" width=250px>
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.edulevel" definition="$CH_EDULEVEL" />
					</s:if>
					<s:else>
						<j:selector name="form.edulevel" definition="$CH_EDULEVEL" disabled="true"/>
					</s:else>
                </td>
                <td align="right" width=150px><s:text name="oprcode"/>:&nbsp</td>
                <td align="left" width=250px>
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#OPERATOR" name="form.oprcode2" condition='region:${dBAccessUser.hwcityid }' />
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.oprcode2" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right" width=150px><s:text name="cardid"/>:&nbsp</td>
                <td align="left" width=250px>
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.cardid"   maxlength="18"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.cardid" disabled="true"/>
						<font color=red>*</font>
					</s:else>
                </td>
                <td align="right" width=150px><s:text name="pvtemail"/>:&nbsp</td>
                <td align="left" width=250px>
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.pvtemail" maxlength="128"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.pvtemail" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right" width=150px>公务机号码:&nbsp</td>
                <!-- <s:text name="officetel2"/>  -->
                <td align="left" width=250px>
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.officetel" maxlength="11" onchange="setSelectmobile(this.value)"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.officetel" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
                <td align="right" width=150px><s:text name="selectmobile"/>:&nbsp</td>
                <td align="left" width=250px>
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.selectmobile" maxlength="12"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.selectmobile" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
            	<td align="right" width=150px><s:text name="employee_type"/>:&nbsp</td>
            	<td align="left" width=250px>
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.right" definition="$CH_EMPLOYEETYPE" />
						<div id="typediv" style="display:'none'">
							<font color="red">*</font>
						</div>
						<s:hidden  name="form.waysubtype" />
					</s:if>
					<s:else>
						<j:selector name="form.right" definition="$CH_EMPLOYEETYPE" disabled="true"/>
						<div id="typediv" style="display:'none'">
							<font color="red"> &nbsp;*</font>
						</div>
					</s:else>
                </td>
                <td></td>
                <td></td>
            </tr>
           
            </table>
            </FIELDSET>
            <FIELDSET>
        	<legend name="organizeinfo">组织信息</legend>
        	<table class="table_normal">
        	
        	
        	 <tr>
                <td align="right" width=150px><s:text name="wayid3"/>:&nbsp</td>
                <td align="left" width=250px>
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.wayid" maxlength="18" onclick="pshowSelectWay3(this,'form.wayid','','','AG');getCityAndCounty(this.value);"/>
					</s:if>
					<s:else>
						<s:textfield name="form.wayid" cssStyle="style_input" />
					</s:else>
				<font color=red>*</font>
                </td>
                <td>
                </td>
                <td>
                </td>
            </tr>
            <tr>
                <td align="right" width=150px><s:text name="cityid"/>:&nbsp</td>
                <td align="left" width=250px>
					<s:hidden name="form.cityid" id="form.cityid"/>
					<input type="text" id="cityName" cssStyle="style_input" name="cityName" value="<j:code2Name definition="#CITYCOMPANY" code="form.cityid"/>" disabled="true"/>
					<font color=red>*</font>
                </td>
                <td align="right" width=150px><s:text name="countyid"/>:&nbsp</td>
                <td align="left" width=250px>
					<s:hidden name="form.countyid" id="form.countyid"/>
                <input type="text" cssStyle="style_input" id="countyName" name="countyName" value="<j:code2Name definition="#CNTYCOMPANY" code="form.countyid"/>" disabled="true"/>
					<font color=red>*</font>
                </td>
            </tr>
            </table>
            </FIELDSET>
        	<FIELDSET>
        	<legend name="employinfo">劳务信息</legend>
        	<table class="table_normal">
        	<tr>
                <td align="right" width=150px><s:text name="intime"/>:&nbsp</td>
                <td align="left" width=250px>
					<s:if test="CMD != WEB_CMD_SAVE">
						<input class="style_input" name="form.intime" value="<s:property value="form.intime!=null?getText('format.date',{form.intime}):''"/>" onclick="selectDate();"/>
					</s:if>
					<s:else>
						<input class="style_input" name="form.intime" value="<s:property value="form.intime!=null?getText('format.date',{form.intime}):''"/>" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
                <td align="right" width=150px><s:text name="contacttype"/>:&nbsp</td>
                <td align="left" width=250px>
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.contacttype" definition="$CH_CONTACTTYPE" />
					</s:if>
					<s:else>
						<j:selector name="form.contacttype" definition="$CH_CONTACTTYPE" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right" width=150px><s:text name="employtype"/>:&nbsp</td>
                <td align="left" width=250px>
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.employtype" definition="$CH_EMPLOYTYPE" />
					</s:if>
					<s:else>
						<j:selector name="form.employtype" definition="$CH_EMPLOYTYPE" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
                <td align="right" width=150px><s:text name="empstatus"/>:&nbsp</td>
                <td align="left" width=250px>
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.empstatus" definition="$CH_EMPSTATUS" />
					</s:if>
					<s:else>
						<j:selector name="form.empstatus" definition="$CH_EMPSTATUS" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            <tr>
                <td align="right" width=150px><s:text name="bail"/>:&nbsp</td>
                <td align="left" width=250px>
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:i18n name="public">
							<input class="style_input" name="form.bail" value="<s:property value="form.bail!=null?
										getText('format.double',{form.bail}):''"/>"" />
						</s:i18n>
					</s:if>
					<s:else>
						<s:i18n name="public">
							<input class="style_input" name="form.bail" value="<s:property value="form.bail!=null?
										getText('format.double',{form.bail}):''"/>"" disabled="true"/>
						</s:i18n>
					</s:else>
                </td>
                <td></td>
                <td></td>
            </tr>
        </table>
        </FIELDSET><!--
        工作模式屏蔽   确认by李茂
        <FIELDSET>
        	<legend name="workmode">工作模式</legend>
        	<table class="table_normal">
        		<tr>
        			<td align="right" width=150px><s:text name="agentmode"/>:&nbsp;</td>
        			<td colspan="3">
        				<s:if test="CMD != WEB_CMD_SAVE">
						<input type="checkbox" name="agentmode_checkbox" <s:if test="form.modelState == 0">checked="checked"</s:if> value="3"/>
					</s:if>
					<s:else>
						<input type="checkbox" name="agentmode_checkbox" <s:if test="form.modelState == 0">checked="checked"</s:if> value="3" disabled="true"/>
					</s:else>
        			</td>
        		</tr>
        	</table>
        </FIELDSET>
    --></div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="doSave2();"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/employee_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
