<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
	function ev_checkval() {
		addfield('form.recid', '<s:text name="recid"/>', 'f', true, 14);
		addfield('form.cityid', '<s:text name="cityid"/>', 'c', false, 10);
		addfield('form.countyid', '<s:text name="countyid"/>', 'c', false, 14);
		addfield('form.mareacode', '<s:text name="mareacode"/>', 'c', true, 14);
		addfield('form.datetype', '<s:text name="datetype"/>', 'c', false, 16);
		addfield('form.weekset', '<s:text name="weekset"/>', 'c', true, 256);
		addfield('form.timesect', '<s:text name="timesect"/>', 'c', true, 256);
		var datetype = $("#datetype").val();
    	if(datetype=="STOPDATE")
    	{
    		addfield('form.begindate', '<s:text name="begindate"/>', 't', false, 7);
    		addfield('form.enddate', '<s:text name="enddate"/>', 't', false, 7);
    		if(date_compare('form.begindate','form.enddate','开始日期不能晚于结束日期')) return;
    	}else if(datetype=="APPWEEK"){
    		checkWeekset();
    	}
		return checkval(window);
	}
	function checkWeekset(){
		var timesect1 = $("#timesect1").val();
		var timesect2 = $("#timesect2").val();
		var timesect3 = $("#timesect3").val();
		var timesect4 = $("#timesect4").val();
		var timesect5 = $("#timesect5").val();
		var timesect6 = $("#timesect6").val();
		var timesect7 = $("#timesect7").val();
		if(timesect1==""&&timesect2==""&&timesect3==""&&timesect4==""&&timesect5==""&&timesect6==""&&timesect7==""){
			errorMessageShow("订购时段不可以全部为空");
			return falese;
		}
		var success1 = validateTimesect(timesect1);
		var success2 = validateTimesect(timesect2);
		var success3 = validateTimesect(timesect3);
		var success4 = validateTimesect(timesect4);
		var success5 = validateTimesect(timesect5);
		var success6 = validateTimesect(timesect6);
		var success7 = validateTimesect(timesect7);
		if(success1==20||success2==20||success3==20||success4==20||success5==20||success6==20||success7==20){
			errorMessageShow("请按照要求输入时段");
			return falese;
		}
	}
	function validateTimesect(sectstr){
		if (sectstr==null||sectstr=="")
			return 1;
		var arrayTime = sectstr.split("-");
		if (arrayTime.length==2){
			var a = validatetime(arrayTime[0]);
			var b = validatetime(arrayTime[1]);
			if(a==20 || b==20){
				return 20;
				}
			if(comparetimeHHMM(arrayTime[0],arrayTime[1]))
				return 1;
			}
		return 20;
	}

	function comparetimeHHMM(time1,time2){
		var str1 = time1.split(":");
		var str2 = time2.split(":");
		if((str1[0]==str2[0])&&(str1[1]<str2[1]))
			return true;
		else if(str1[0]<str2[0])
			return true;
		return false;
	}

	function validatetime( strValue )
	{
	  //----------------------------------------------------------------------------------------------------------------------
	  //strValue must be as:  hh:mm
	  //----------------------------------------------------------------------------------------------------------------------
	  var arrayTime = strValue.split(":")
	  if (arrayTime.length==2)
	  {
	    strHour=arrayTime[0];
	    strMinute=arrayTime[1];
	    if ((parseInt(strHour, 10)>=0 && parseInt(strHour, 10)<=23) &&
	        (parseInt(strMinute, 10)>=0 && parseInt(strMinute, 10)<=59) )
	     {
	     	Reg = /^\d{1,2}:\d{1,2}$/
	     	if(Reg.exec(strValue)){
	     		return 1;
	     		}
	     	}
	   return 20;
	  }
	  return 20;
	}
	
	function opendMareacode(aObj,formWhere){
	     var countyid = document.getElementById('countyid').value;
	     if(countyid == ''){
		     openPicker(aObj,formWhere);
	     }else{
		     openPicker(aObj,formWhere,null,'boss.cms.microarea.queryBycountyid','COUNTYID:'+countyid);
	    }
   }
	function putCountyIDandClearMareacode(countyid){
	     document.getElementById('countyid').value=countyid;
	     document.all("form.mareacode").value="";
	}

	//根据不同的日期类型，显示不同的页面内容
    function showTr()
    {
    	var datetype = $("#datetype").val();
    	if(datetype=="APPWEEK")
    	{
    		$("#timesect1Tr").show();
    		$("#timesect2Tr").show();
    		$("#timesect3Tr").show();
    		$("#timesect4Tr").show();
    		$("#timesect5Tr").show();
    		$("#timesect6Tr").show();
    		$("#timesect7Tr").show();
    		$("#begindateTr").hide();
    		$("#enddateTr").hide();
    	}
    	else if(datetype=="STOPDATE")
    	{
    		$("#timesect1Tr").hide();
    		$("#timesect2Tr").hide();
    		$("#timesect3Tr").hide();
    		$("#timesect4Tr").hide();
    		$("#timesect5Tr").hide();
    		$("#timesect6Tr").hide();
    		$("#timesect7Tr").hide();
    		$("#begindateTr").show();
    		$("#enddateTr").show();
    	}
    }
    
    $(document).ready(function(){
		showTr();
	});
</script>
</head>
<body>
<div class="table_container">
<s:form action="timesect_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_cityid"/>
    <s:hidden name="param._se_countyid"/>
    <s:hidden name="param._se_mareacode"/>
    <s:hidden name="param._se_datetype"/>
    <input type="hidden" id ="countyid" value='<s:property value="form.countyid"/>'/>
	
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
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
                <td align="right"><s:text name="recid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.recid" maxlength="14" readonly="true"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.recid" disabled="true"/>
						<font color=red>*</font>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.recid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>自动生成
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cityid"/>:&nbsp</td>
                <td align="left">
					<j:selector definition="#CITYCOMPANY" name="form.cityid" mode="selector" condition="citycompid:${dBAccessUser.cityid }" value="%{dBAccessUser.cityid}" disabled="true"/>
					<font color=red>*</font> 系统默认
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="countyid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#CNTYCOMPANY" name="form.countyid" mode="selector" condition="citycompid:${dBAccessUser.cityid }"  onchange="putCountyIDandClearMareacode(this.value);" />
					</s:if>
					<s:else>
						<j:selector definition="#CNTYCOMPANY" name="form.countyid" mode="selector" condition="citycompid:${dBAccessUser.cityid }"  onchange="putCountyIDandClearMareacode(this.value);" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="mareacode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield name="form.mareacode" maxlength="14" readonly="true"/><input class="picker_button" onclick="javascript:opendMareacode(this,'#MICROAREA');"  type="button" value="..." name="form.mareacode_button"/>
					</s:if>
					<s:else>
						<s:textfield name="form.mareacode" maxlength="14" disabled="true"/><input class="picker_button" onclick="javascript:opendMareacode(this,'#MICROAREA');"  type="button" value="..." name="form.mareacode_button" disabled="true"/>
					</s:else>为空时默认所有区域
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="datetype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.datetype" definition="$FX_DATETYPE" id="datetype" onchange="showTr()"/>
					</s:if>
					<s:else>
						<j:selector name="form.datetype" definition="$FX_DATETYPE" id="datetype" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            
            
            
            <tr id="timesect1Tr" style="display: none;">
                <td align="right"><s:text name="timesect1"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.timesect1" id="timesect1" maxlength="11"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.timesect1" disabled="true"/>
					</s:else>时段，格式为 HH:mm-HH:mm ，如08:00-16:00。开始时间需早于结束时间。以下同。
                </td>
            </tr>
            <tr id="timesect2Tr" style="display: none;">
                <td align="right"><s:text name="timesect2"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.timesect2" id="timesect2" maxlength="11"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.timesect2" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr id="timesect3Tr" style="display: none;">
                <td align="right"><s:text name="timesect3"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.timesect3" id="timesect3" maxlength="11"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.timesect3" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr id="timesect4Tr" style="display: none;">
                <td align="right"><s:text name="timesect4"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.timesect4" id="timesect4" maxlength="11"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.timesect4" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr id="timesect5Tr" style="display: none;">
                <td align="right"><s:text name="timesect5"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.timesect5" id="timesect5" maxlength="11"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.timesect5" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr id="timesect6Tr" style="display: none;">
                <td align="right"><s:text name="timesect6"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.timesect6" id="timesect6" maxlength="11"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.timesect6" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr id="timesect7Tr" style="display: none;">
                <td align="right"><s:text name="timesect7"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.timesect7" id="timesect7" maxlength="11"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.timesect7" disabled="true"/>
					</s:else>
                </td>
            </tr>
            
            
            <tr id="begindateTr" style="display: none;">
                <td align="right"><s:text name="begindate"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<input type="text" cssStyle="style_input" name="form.begindate" onclick="selectDate();" value="<s:date name="form.begindate" format="yyyy-MM-dd"/>"/>
					</s:if>
					<s:else>
						<input type="text" cssStyle="style_input" name="form.begindate" onclick="selectDate();" value="<s:date name="form.begindate" format="yyyy-MM-dd"/>" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr id="enddateTr" style="display: none;">
                <td align="right"><s:text name="enddate"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<input type="text" cssStyle="style_input" name="form.enddate" onclick="selectDate();" value="<s:date name="form.enddate" format="yyyy-MM-dd"/>"/>
					</s:if>
					<s:else>
						<input type="text" cssStyle="style_input" name="form.enddate" onclick="selectDate();" value="<s:date name="form.enddate" format="yyyy-MM-dd"/>" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/sales/timesect_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/sales/timesect_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
