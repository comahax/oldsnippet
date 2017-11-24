<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib prefix="j" uri="/jop-tags" %>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<%
	String ID_AUDIT="CH_PW_WAYAPPLY_AUDIT";
%>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript">
        function ev_checkval(cmd) {
        	if(document.all("form.longtitude").value!=""){
        		if(document.all("form.longtitude").value*1<100 ||document.all("form.longtitude").value*1>130 || !document.all("form.longtitude").value.match("[0-9]{2}(.?)[0-9]{6}")){
        			var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[办公地点经度]</span>' + '经度值必须在100 － 130 之间并且精确到小数后6位!' + '</span>';
        			errorMessageShow(alertstr);
            		return false;
            	}
            }
            if(document.all("form.latitude").value!=""){
            	if(document.all("form.latitude").value*1<18 ||document.all("form.latitude").value*1>26 || !document.all("form.latitude").value.match("[0-9]{1}(.?)[0-9]{6}")){
            		var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[办公地点纬度]</span>' + '纬度值必须在18 － 26 之间并且精确到小数后6位!' + '</span>';
            		errorMessageShow(alertstr);
            		return false;
            	}
            }
        	addfield('form.wayid', '<s:text name="wayid"/>', 'c', false, 18);
			addfield('form.wayname', '<s:text name="wayname"/>', 'c', false, 256);
			addfield('form.starlevel', '<s:text name="starlevel"/>', 'f', false, 2);        
        	addfield('form.pt', '<s:text name="pt"/>', 'c', false, 2);
        	addfield('form.waymagcode', '<s:text name="waymagcode"/>', 'c', true, 18);
        	addfield('form.isstraitprd', '<s:text name="isstraitprd"/>', 'f', false, 2);
        	addfield('form.upperwayid', '<s:text name="upperwayid"/>', 'c', false, 18);
        	addfield('form.catetype', '<s:text name="catetype"/>', 'f', true, 2);
        	addfield('form.waysubtype', '<s:text name="waysubtype"/>', 'c', false, 4);
        	addfield('form.formtype', '<s:text name="formtype"/>', 'f', false, 2);
        	addfield('form.starttime', '<s:text name="starttime"/>', 't', false, 7);
        	addfield('form.cityid', '<s:text name="cityid"/>', 'c', false, 14);
        	addfield('form.countyid', '<s:text name="countyid"/>', 'c', false, 14);
			addfield('form.svccode', '<s:text name="svccode"/>', 'c', true, 14);
        	addfield('form.mareacode', '<s:text name="mareacode"/>', 'c', true, 14);
        	addfield('form.bchlevel', '<s:text name="bchlevel"/>', 'c', false, 4);
        	addfield('form.buzarea', '<s:text name="buzarea"/>', 'f', false, 5);
        	addfield('form.waystate', '<s:text name="waystate"/>', 'f', false, 3);
        	addfield('form.logiscode', '<s:text name="logiscode"/>', 'c', true, 18);
        	addfield('form.alarmbizamount', '<s:text name="alarmbizamount"/>', 'f', true, 10);
        	addfield('form.officetel', '<s:text name="officetel"/>', 'c', false, 12);
        	addfield('form.address', '<s:text name="address"/>', 'c', false, 128);
        	addfield('form.latitude', '<s:text name="latitude"/>', 'c', false, 15);
        	addfield('form.longtitude', '<s:text name="longtitude"/>', 'c', false, 15);
        	addfield('form.signstatus','<s:text name="signstatus"/>','i',false,2);
        	addfield('form.provcode','<s:text name="provcode"/>','c',true,18);
        	addfield('form.chainhead', '<s:text name="chainhead"/>', 'c', true, 18);
        	addfield('form.principal', '<s:text name="principal"/>', 'c', false, 64);
			addfield('form.principaltel', '<s:text name="principaltel"/>', 'c', false, 20);
			addfield('form.principalphone', '<s:text name="principalphone"/>', 'c', true, 20);
			addfield('form.principalemail', '<s:text name="principalemail"/>', 'm', true, 128);
        	addfield('form.smsmobileno', '<s:text name="smsmobileno"/>', 'i', true, 12);
        	addfield('form.recpers', '<s:text name="recpers"/>', 'c', true, 32);
        	addfield('form.recconntel', '<s:text name="recconntel"/>', 'c', true, 15);
			addfield('form.reccertno', '<s:text name="reccertno"/>', 'c', true, 20);
        	addfield('form.bailtype', '<s:text name="bailtype"/>', 'i', true, 2);
			addfield('form.servbound', '<s:text name="servbound"/>', 'i', false, 3);
        	addfield('form.sendaddr', '<s:text name="sendaddr"/>', 'c', true, 128);
        	addfield('form.compactno', '<s:text name="compactno"/>', 'c', false, 17);
        	addfield('form.compactname', '<s:text name="compactname"/>', 'c', false, 255);
        	addfield('form.begintime', '<s:text name="begintime"/>', 't', false, 10);
        	addfield('form.endtime', '<s:text name="endtime"/>', 't', false, 10);
        	addfield('form.signtime', '<s:text name="signtime"/>', 't', false, 10);
        	addfield('form.compacttype', '<s:text name="compacttype"/>', 'i', false, 2);
        	addfield('form.licenceno', '<s:text name="compactno"/>', 'c', true, 64);
        	addfield('form.bail', '<s:text name="bail"/>', 'f', true,18,2);
        	addfield('form.baillwrlmt', '<s:text name="baillwrlmt"/>', 'f', false,16,2);
        	addfield('form.licvalidate', '<s:text name="licvalidate"/>', 't', true, 10);
        	addfield('form.bailstatus', '<s:text name="bailstatus"/>', 'i', true, 2);
			addfield('form.isb2m', '<s:text name="isb2m"/>', 'i', false, 1);
			addfield('form.isunpb', '<s:text name="isunpb"/>', 'i', false, 1);
		  	addfield('form.acctno', '<s:text name="acctno"/>', 'c', false, 50);
        	addfield('form.acctname', '<s:text name="acctname"/>', 'c', false, 128);
        	addfield('form.bankname', '<s:text name="bankname"/>', 'c', false, 128);
			addfield('form.acctfid', '<s:text name="acctfid"/>', 'c', false, 32);
			addfield('form.deacctno', '<s:text name="deacctno"/>', 'c', true, 50);
			addfield('form.deacctname', '<s:text name="deacctname"/>', 'c', true, 128);
			addfield('form.debankname', '<s:text name="debankname"/>', 'c', true, 128);
			addfield('form.intime', '<s:text name="intime"/>', 't', true, 7);
            addfield('form.applyno', '<s:text name="applyno"/>', 'f', false, 14);
			addfield('form.optime', '<s:text name="optime"/>', 't', true, 7);
			//addfield('form.auditstatus', '<s:text name="auditstatus"/>', 'f', true, 2);
			addfield('form.description', '<s:text name="description"/>', 'c', true, 512);
			addfield('form.adacode', '<s:text name="adacode"/>', 'c', true, 18);
			addfield('form.adtypecode', '<s:text name="adtypecode"/>', 'f', true, 2);
			addfield('form.content', '<s:text name="content"/>', 'c', true, 512);
			addfield('form.accttype', '<s:text name="accttype"/>', 'i', false, 3);
            if (checkval(window)==true)
            {
            	doSave(cmd);
            }else
            {
            	return false;
            }
        }
         function doSave(cmd)
        {
        	if(cmd=='CANCEL')
        	{
        	 var content=document.all("form.content").value;
        	 if(content=="")
        	 {
        	 	alert('拒绝时[审核意见]为必填项');
        	 	return false;
        	 }
        	}
        	if(cmd=='PASS')
        	{
        	  var hasRight=document.all("form.hasRight").value;
        	  if("1"==hasRight && document.all("form.oprcode").value=='')
        	  {
        	   alert("地市启用了[网点审批角色控制],[下一审批人]不能为空!");
        	   return false;
        	  }
        	}
            var url="<%=contextPath%>/channel/wayapply_save.do";
            document.all("saveType").value=cmd;
            formItem.action=url;
            formItem.submit();
        }
         function doGetList(cmdvalue){
            document.all("form.cmdvalue").value=cmdvalue;
			ajaxAnywhere.submitByURL("/channel/wayapply_getcountid.do?cmdvalue="+cmdvalue); 
		}
		function doCheckUpper(obj)
     	{ 
     		var tmpAction=formItem.action;
     	    pshowSelectWay3(obj,'form.upperwayid','','','AG|ET','DIS|GMPT|G100')
	     	if(obj.value == null || obj.value == ""){
        		return;
        	}
        	var url = contextPath+"/channel/wayapply_Checkupperway.do";
        	formItem.action=url;
        	formItem.submit();
        	formItem.action = tmpAction;
     	}
     	 //审批人弹出框
	    function getAuditRoleList(){
			var	url='<%=contextPath %>/base/operator_auditRoleList.do?lastStepid='+document.all("form.lastStepid").value;	    	
	     	var returnValue=window.showModalDialog(url,window,"dialogWidth=500px;dialogHeight=430px;status:no;scroll=yes;");
		    if(returnValue!=undefined){
		    	return returnValue;
			}
	     }
	    function getValue()
	    {
		    var retValue=getAuditRoleList();
		    if(retValue!=null && typeof(retValue)!="undefined")
		    {
		    	document.all('form.oprcode').value=retValue;
		    }else
		    {
		     document.all('form.oprcode').value='';
		    }
	    }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="wayapply_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
	<s:hidden name="form.cmdvalue"/>		
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
	<s:hidden name="saveType" />
	<s:hidden name="form.seqid" />
	<s:hidden name="form.applyno" />
	<s:hidden name="form.auditstatus" />
	<s:hidden name="form.auditstatus_work" />
	<s:hidden name="form.waytype" value="AG" />
	<s:hidden name="formType"></s:hidden><!-- 表页面从哪里过来 -->
	<s:hidden name="rvcobjid"></s:hidden><!-- 接收对象表标识 -->
	<s:hidden name="form.worktype" />
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
			<span class="button_Help" onclick="openword('<s:text name="titleList"/>','<s:text name="helpContentWay"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
             <td align="right" width="15%"><s:text name="wayid"/>:&nbsp</td>
             <td align="left" width="35%">
				  <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.wayid" maxlength="18"/>
					<font color="red"> &nbsp; *</font>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.wayid" disabled="true"/>
					<font color="red"> &nbsp; *</font>
				</s:else>
             </td>
              <td align="right" width="15%"><s:text name="wayname"/>:&nbsp</td>
                <td align="left" width="35%">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.wayname" maxlength="256"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.wayname" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
        </tr>
        <tr>
        	 <td align="right"><s:text name="starlevel"/>:&nbsp</td>
              <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_STARLEVEL"  name="form.starlevel"  cssStyle="style_input"   mode="selector"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<j:selector definition="$CH_STARLEVEL"  name="form.starlevel" disabled="true" cssStyle="style_input"   mode="selector"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
             </td>
              <td align="right"><s:text name="pt"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_PT"  name="form.pt"  cssStyle="style_input"   mode="selector"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<j:selector definition="$CH_PT"  name="form.pt"  cssStyle="style_input"  disabled="true"  mode="selector"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
        </tr>
        <Tr>
       	   	<td align="right"><s:text name="waymagcode"/>:&nbsp</td>
               <td align="left">
				<s:if test="CMD != WEB_CMD_SAVE">
					<j:selector definition="#EMPLOYEE" name="form.waymagcode" condition='_ne_posittype:1;_se_waytype:ET;_ne_empstatus:0' readonly='true' mode="picker" />
				</s:if>
				<s:else>
					<j:selector definition="EMPLOYEE"  name="form.waymagcode"  cssStyle="style_input"  disabled="true"  mode="picker"/>
				</s:else>
            </td>
             <td align="right"><s:text name="isstraitprd"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_STRAITPRD"  name="form.isstraitprd"  cssStyle="style_input"  mode="selector"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<j:selector definition="$CH_STRAITPRD"  name="form.isstraitprd"  cssStyle="style_input"  disabled="true"  mode="selector"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
        </Tr>
        <tr>
        	 <td align="right"><s:text name="upperwayid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.upperwayid" readonly="true" onclick="doCheckUpper(this);"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.upperwayid" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
                <td align="right"><s:text name="adacode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.adacode" mode="picker"
											condition="_se_uppercode:${dBAccessUser.cityid }"
											definition="#CH_ADIMAREA" readonly="true"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.adacode" disabled="true"/>
					</s:else>
                </td>
        </tr>
        <tr>
        	 <td align="right"><s:text name="catetype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_CATETYPE"  name="form.catetype"  cssStyle="style_input"  mode="selector"/>
					</s:if>
					<s:else>
						<j:selector definition="$CH_CATETYPE"  name="form.catetype" disabled="true" cssStyle="style_input"  mode="selector"/>
					</s:else>
                </td>
                <td align="right"><s:text name="waysubtype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="WAYSUBTYPE"  name="form.waysubtype"  cssStyle="style_input"  mode="selector" />
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<j:selector definition="WAYSUBTYPE"  name="form.waysubtype"  cssStyle="style_input"  mode="selector" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
        </tr>
        <tr>
        	<td align="right"><s:text name="formtype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
					<j:selector definition="$CH_FORMTYPE"  name="form.formtype"  cssStyle="style_input"  mode="selector"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<j:selector definition="$CH_FORMTYPE"  name="form.formtype"  cssStyle="style_input"  mode="selector" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
            </td>
            <td align="right"><s:text name="starttime"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<input class="style_input" name="form.starttime" value="<s:property value="form.starttime!=null?getText('format.date',{form.starttime}):''"/>" onclick="selectDate();"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<input class="style_input" name="form.starttime" value="<s:property value="form.starttime!=null?getText('format.date',{form.starttime}):''"/>" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
            </td>
        </tr>
        <tr>
              <td align="right"><s:text name="cityid"/>:&nbsp</td>
                <td align="left">
                <aa:zone name="getcityid">
					<s:if test="CMD != WEB_CMD_SAVE  and  form.cityid==null ">
						<j:selector definition="#CITYCOMPANY"  name="form.cityid"  cssStyle="style_input"  mode="selector"
						onchange="doGetList('cityid')"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:elseif test="CMD != WEB_CMD_SAVE  and form.cityid!=null ">
						<s:textfield cssStyle="style_input" name="form.cityid" readonly="true"/>
						<font color="red"> &nbsp; *</font>
					</s:elseif>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.cityid" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
				</aa:zone>	
                </td>
                <td align="right"><s:text name="countyid"/>:&nbsp</td>
                <td align="left">
                <aa:zone name="getcountyid">
					<s:if test="CMD != WEB_CMD_SAVE and form.cityid!=null and ('' != form.cityid) and (form.countyid==null or '' == form.countyid)">
						<j:selector definition="#CNTYCOMPANY"  name="form.countyid"  cssStyle="style_input"  mode="selector"
						condition="citycompid:${form.cityid}" onchange="doGetList('citycompid')"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:elseif test="CMD != WEB_CMD_SAVE and form.cityid!=null and ('' != form.cityid) and (form.countyid!=null and '' != form.countyid)">
						<s:textfield cssStyle="style_input" name="form.countyid" readonly="true"/>
						<font color="red"> &nbsp; *</font>
					</s:elseif>
					<s:elseif test="CMD != WEB_CMD_SAVE  and (form.cityid==null or '' == form.cityid)">
						<s:textfield cssStyle="style_input" name="form.countyid" value="" readonly="true"/>
						<font color="red"> &nbsp; *</font>
					</s:elseif>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.countyid" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
				</aa:zone>
                </td>
            </tr>
             <tr>
                <td align="right"><s:text name="svccode"/>:&nbsp</td>
                <td align="left">
                <aa:zone name="getsvccode">
					<s:if test="CMD != WEB_CMD_SAVE and form.countyid!=null and ('' != form.countyid) and (form.svccode==null or '' == form.svccode)">
						<j:selector definition="#SERVCENT"  name="form.svccode"  cssStyle="style_input"  mode="selector"
						 condition="countyid:${form.countyid}" onchange="doGetList('countyid')"/>
					</s:if>
					<s:elseif test="CMD != WEB_CMD_SAVE and form.countyid!=null and ('' != form.countyid) and (form.svccode!=null and '' != form.svccode)">
						<s:textfield cssStyle="style_input" name="form.svccode" readonly="true"/>
					</s:elseif>
					<s:elseif test="CMD != WEB_CMD_SAVE and (form.countyid == null or '' == form.countyid)">
						<s:textfield cssStyle="style_input" name="form.svccode" value="" readonly="true"/>
					</s:elseif>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.svccode" disabled="true"/>
					</s:else>
				</aa:zone>
                </td>
                 <td align="right"><s:text name="mareacode"/>:&nbsp</td>
                <td align="left">
                <aa:zone name="getmareacode">
					<s:if test="CMD != WEB_CMD_SAVE and form.svccode!=null and ('' != form.svccode) and (form.mareacode == null or '' == form.mareacode)">
						<j:selector definition="#MICROAREA"  name="form.mareacode"  cssStyle="style_input"  mode="selector"
						condition="svccode:${form.svccode}"/>
					</s:if>
					<s:elseif test="CMD != WEB_CMD_SAVE and form.svccode!=null and ('' != form.svccode) and (form.mareacode != null and '' != form.mareacode)">
						<s:textfield cssStyle="style_input" name="form.mareacode" readonly="true"/>
					</s:elseif>
					<s:elseif test="CMD != WEB_CMD_SAVE  and (form.svccode == null or '' == form.svccode)">
						<s:textfield cssStyle="style_input" name="form.mareacode" value="" readonly="true"/>
					</s:elseif>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.mareacode" disabled="true"/>
					</s:else>
				</aa:zone>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="bchlevel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_BCHLEVEL"  name="form.bchlevel"  cssStyle="style_input"  mode="selector"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<j:selector definition="$CH_BCHLEVEL"  name="form.bchlevel" disabled="true"  cssStyle="style_input"  mode="selector"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
                 <td align="right"><s:text name="buzarea"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.buzarea" maxlength="5"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.buzarea" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="waystate"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="STATE"  name="form.waystate"  cssStyle="style_input"  mode="selector"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<j:selector definition="STATE"  name="form.waystate" disabled="true" cssStyle="style_input"  mode="selector"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
                 <td align="right"><s:text name="logiscode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#WAY" name="form.logiscode" condition="waytype:AG;waysubtype:LOGS;cityid:${dBAccessUser.cityid }" mode="picker" />
					</s:if>
					<s:else>
						<j:selector definition="#WAY" name="form.logiscode" condition="waytype:'AG';waysubtype:LOGS;cityid:${dBAccessUser.cityid }" mode="picker" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="alarmbizamount"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.alarmbizamount" maxlength="10"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.alarmbizamount" disabled="true"/>
					</s:else>
                </td>
                 <td align="right"><s:text name="officetel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.officetel" maxlength="12"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.officetel" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="address"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.address" maxlength="128"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.address" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
                <td align="right"><s:text name="latitude"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.latitude" maxlength="15"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.latitude" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="longtitude"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.longtitude" maxlength="15"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.longtitude" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
                <td align="right"><s:text name="adtypecode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_ADTYPE"  name="form.adtypecode"  cssStyle="style_input"  mode="selector"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<j:selector definition="$CH_ADTYPE"  name="form.adtypecode"  cssStyle="style_input"  mode="selector" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
            </tr>
            <tr>
            	 <td align="right"><s:text name="signstatus"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_SIGNSTATUS"  name="form.signstatus"  cssStyle="style_input"  mode="selector"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<j:selector definition="$CH_SIGNSTATUS"  name="form.signstatus"  cssStyle="style_input"  mode="selector" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
                <td align="right"><s:text name="provcode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.provcode" maxlength="15"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.provcode" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="chainhead"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.chainhead" definition="#WAY" condition="waytype:AG;waysubtype:DIS;waystate:1;cityid:${dBAccessUser.cityid}" readonly="true"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.chainhead" disabled="true"/>
					</s:else>
                </td>
                <td align="right"><s:text name="custtype"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#CUSTWAYTYPE"  name="form.custtype" condition="citycompid:${dBAccessUser.cityid};_sne_custwaytypecode:${'ALL'}" cssStyle="style_input"  mode="selector" />
					</s:if>
					<s:else>
						<j:selector definition="#CUSTWAYTYPE"  name="form.custtype" condition="citycompid:${dBAccessUser.cityid}" cssStyle="style_input"  mode="selector" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
              <td align="right"><s:text name="buztypecode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.buztypecode" definition="$CH_BUZTYPE" />
					</s:if>
					<s:else>
						 <j:selector name="form.buztypecode" definition="$CH_BUZTYPE"  disabled="true"/>
					</s:else>
                </td>
                <td align="right"><s:text name="istietong"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
                		<s:select name="form.istietong" theme="simple" listKey="key"
									listValue="value" cssStyle="select"
									list="#{'':'' ,'0':'普通网点', '1':'原铁通网点','2':'G3社会信息服务站'}"	/>
					</s:if>
					<s:else>
						<s:select name="form.istietong" theme="simple" listKey="key"
									listValue="value" cssStyle="select"
									list="#{'':'' ,'0':'普通网点', '1':'原铁通网点','2':'G3社会信息服务站'}"	disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
            	<td align="right"><s:text name="mainsur"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.connecttype" definition="$CH_CONNECTTYPE" />
					</s:if>
					<s:else>
						<j:selector name="form.connecttype" definition="$CH_CONNECTTYPE" disabled="true"/>
					</s:else>
                </td>
                <td align="right"><s:text name="secondsur"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.sublayer" definition="$CH_CONNECTTYPE" />
					</s:if>
					<s:else>
						<j:selector name="form.sublayer" definition="$CH_CONNECTTYPE"  disabled="true"/>
					</s:else>
                </td>
                <td align="right">&nbsp</td>
                <td align="left">
                	&nbsp;
                </td>
            </tr>
            <tr><td colspan=4 width=100%> <div><center><s:text name="style" /></center></div></td></tr>
            <tr> <td colspan=4 width=100%><div><center><s:text name="provcodestyle" /></center></div></td></tr>
     </table>
    </div>
	
	
	<div class="table_div">
    <table class="table_normal">
    	<tr> <td colspan=4 width=100%><div><font color=blue> <s:text name="gotoneTitle" /></font></div></td></tr>
    	<tr>
                <td align="right" width="15%"><s:text name="principal"/>:&nbsp</td>
                <td align="left" width="35%">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.principal" maxlength="64"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.principal" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
                <td align="right" width="15%"><s:text name="principaltel"/>:&nbsp</td>
                <td align="left" width="35%">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.principaltel" maxlength="20"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.principaltel" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="principalphone"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.principalphone" maxlength="20"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.principalphone" disabled="true"/>
					</s:else>
                </td>
                <td align="right"><s:text name="principalemail"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.principalemail" maxlength="128"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.principalemail" disabled="true"/>
					</s:else>
                </td>
            </tr>
             <tr>
             
             	<td align="right"><s:text name="smsmobileno"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.smsmobileno" maxlength="12"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.smsmobileno" disabled="true"/>
					</s:else>
                </td>
                 <td align="right"><s:text name="recpers"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.recpers" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.recpers" disabled="true"/>
					</s:else>
                </td>
            </tr>
             <tr>
                <td align="right"><s:text name="recconntel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.recconntel" maxlength="15"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.recconntel" disabled="true"/>
					</s:else>
                </td>
                <td align="right"><s:text name="reccertno"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.reccertno" maxlength="20"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.reccertno" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="bailtype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_BAILTYPE"  name="form.bailtype"  cssStyle="style_input"  mode="selector" />
					</s:if>
					<s:else>
						<j:selector definition="$CH_BAILTYPE"  name="form.bailtype"  cssStyle="style_input"  mode="selector" disabled="true"/>
					</s:else>
                </td>
                <td align="right"><s:text name="servbound"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_SERVBOUND"  name="form.servbound"  cssStyle="style_input"  mode="selector" />
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<j:selector definition="$CH_SERVBOUND"  name="form.servbound"  cssStyle="style_input"  mode="selector" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
            </tr>
             <tr>
                <td align="right"><s:text name="sendaddr"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.sendaddr" maxlength="128"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.sendaddr" disabled="true"/>
					</s:else>
                </td>
            </tr>
    </table>
    </div>
    
    
    <div class="table_div">
    <table class="table_normal">
    	<tr> <td colspan=4 width=100%><div><font color=blue> <s:text name="hetongTitle" /></font></div></td></tr>
    	<tr>
                <td align="right" width="15%"><s:text name="compactno"/>:&nbsp</td>
                <td align="left" width="35%">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.compactno" maxlength="18"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.compactno" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
                <td align="right" width="15%"><s:text name="compactname"/>:&nbsp</td>
                <td align="left" width="35%">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.compactname" maxlength="255"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.compactname" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right" width="15%"><s:text name="begintime"/>:&nbsp</td>
                <td align="left" width="35%">
					<s:if test="CMD != WEB_CMD_SAVE">
						<input class="style_input" name="form.begintime" value="<s:property value="form.begintime!=null?getText('format.date',{form.begintime}):''"/>" onclick="selectDate();"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<input class="style_input" name="form.begintime" value="<s:property value="form.begintime!=null?getText('format.date',{form.begintime}):''"/>" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
                <td align="right" width="15%"><s:text name="endtime"/>:&nbsp</td>
                <td align="left" width="35%">
					<s:if test="CMD != WEB_CMD_SAVE">
						<input class="style_input" name="form.endtime" value="<s:property value="form.endtime!=null?getText('format.date',{form.endtime}):''"/>" onclick="selectDate();"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<input class="style_input" name="form.endtime" value="<s:property value="form.endtime!=null?getText('format.date',{form.endtime}):''"/>" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
            </tr>
            <tr>
               <td align="right"><s:text name="signtime"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<input class="style_input" name="form.signtime" value="<s:property value="form.signtime!=null?getText('format.date',{form.signtime}):''"/>" onclick="selectDate();"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<input class="style_input" name="form.signtime" value="<s:property value="form.signtime!=null?getText('format.date',{form.signtime}):''"/>" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
                <td align="right"><s:text name="compacttype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_COMPACTTYPE"  name="form.compacttype"  cssStyle="style_input"  mode="selector" />
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<j:selector definition="$CH_COMPACTTYPE"  name="form.compacttype"  cssStyle="style_input"  mode="selector" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
            </tr>
            <tr>
               <td align="right"><s:text name="licenceno"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.licenceno" maxlength="64"/>
						<!-- <font color="red"> &nbsp; *</font> -->
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.licenceno" disabled="true"/>
							<!--<font color="red"> &nbsp; *</font> -->
					</s:else>
                </td>
                <td align="right"><s:text name="bail"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.bail" maxlength="22"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.bail" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
               <td align="right"><s:text name="baillwrlmt"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.baillwrlmt" maxlength="20"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.baillwrlmt" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
                <td align="right"><s:text name="licvalidate"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<input class="style_input" name="form.licvalidate" value="<s:property value="form.licvalidate!=null?getText('format.date',{form.licvalidate}):''"/>" onclick="selectDate();"/>
						<!-- <font color="red"> &nbsp; *</font> -->
					</s:if>
					<s:else>
						<input class="style_input" name="form.licvalidate" value="<s:property value="form.licvalidate!=null?getText('format.date',{form.licvalidate}):''"/>" disabled="true"/>
						<!-- <font color="red"> &nbsp; *</font> -->
					</s:else>
                </td>
            </tr>
            <tr>
               <td align="right"><s:text name="bailstatus"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_BAILSTATUS"  name="form.bailstatus"  cssStyle="style_input"  mode="selector" />
					</s:if>
					<s:else>
						<j:selector definition="$CH_BAILSTATUS"  name="form.bailstatus"  cssStyle="style_input"  mode="selector" disabled="true"/>
					</s:else>
                </td>
                <td align="right"><s:text name="isb2m"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="CH_YESORNO"  name="form.isb2m"  cssStyle="style_input"  mode="selector" />
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<j:selector definition="CH_YESORNO"  name="form.isb2m"  cssStyle="style_input"  mode="selector" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
            </tr>
            <tr>
            	<td align="right"><s:text name="isunpb"/>:&nbsp</td>
            	<td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.isunpb" definition="$IM_YESNO10" />
					</s:if>
					<s:else>
						<j:selector name="form.isunpb" definition="$IM_YESNO10" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
                <td></td>
                <td></td>
            </tr>
          
    </table>
    </div>
    
    
    <div class="table_div">
    <table class="table_normal">
    		<tr> <td colspan=4 width=100%><div><font color="blue"> <s:text name="zhanghuTitle" /></font></div></td></tr>
    		<tr>
                <td align="right" width="15%"><s:text name="acctno"/>:&nbsp</td>
                <td align="left" width="35%">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.acctno" maxlength="50"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.acctno" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
    		 <td align="right" width="15%"><s:text name="acctname"/>:&nbsp</td>
                <td align="left" width="35%">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.acctname" maxlength="128"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.acctname" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
            </tr>    
            <tr>
                <td align="right" width="15%"><s:text name="bankname"/>:&nbsp</td>
                <td align="left" width="35%">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.bankname" maxlength="128"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.bankname" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
                <td align="right"><s:text name="acctfid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.acctfid" maxlength="32"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.acctfid" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
            </tr>
                <tr>
                <td align="right" width="15%"><s:text name="debankid"/>:&nbsp</td>
                <td align="left" width="35%">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.debankid" definition="#BANK" mode="picker" readonly="true"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<j:selector name="form.debankid" definition="#BANK" mode="picker" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
                <td align="right"><s:text name="destate"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.destate" definition="$CH_VALIDFLAG" mode="selector"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<j:selector name="form.destate" definition="$CH_VALIDFLAG" mode="selector" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="deacctno"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.deacctno" maxlength="50"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.deacctno" disabled="true"/>
					</s:else>
                </td>
                <td align="right"><s:text name="deacctname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.deacctname" maxlength="128"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.deacctname" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="debankname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.debankname" maxlength="128"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.debankname" disabled="true"/>
					</s:else>
                </td>
                 <td align="right"><s:text name="intime"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<input class="style_input" name="form.intime" value="<s:property value="form.intime!=null?getText('format.date',{form.intime}):''"/>" onclick="selectDate();"/>
					</s:if>
					<s:else>
						<input class="style_input" name="form.intime" value="<s:property value="form.intime!=null?getText('format.date',{form.intime}):''"/>" disabled="true"/>
					</s:else>
                </td>
            </tr>
            
            <tr>
               <td align="right"><s:text name="content"/>:&nbsp
               <s:hidden name="form.lastStepid" />
               <s:hidden name="form.hasRight" />
               </td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.content"  maxlength="512"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.content"  disabled="true"/>
					</s:else>
                </td>
                <s:if test="form.oprcode!='-1'" >
                 <td align="right"><s:text name="nextstepid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE && worktype!='WAY_ADD_AUDIT'">
						<s:if test="form.worktype!='WAY_ADD_AUDIT'">
							<s:textfield name="form.oprcode" readonly="true"/>
						<input type="button" name="form.oprcode_button" class="picker_button" value="..." onclick="getValue()" />
						</s:if>
						<s:else>
							<j:selector definition="#OPERATOR" name="form.oprcode" condition='region:${dBAccessUser.hwcityid };_ne_status:1' />
						</s:else>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.oprcode" disabled="true"/>
					</s:else>
                </td>
                </s:if>
                <s:else>
                	<td colspan="2">&nbsp;</td>
                	<s:hidden name="form.oprcode"/>
                </s:else>
            </tr>
              <tr>
               <td align="right"><s:text name="accttype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.accttype" definition="$CH_ACCOUNTTYPE" mode="selector"/>
						<font color="red"> &nbsp; *</font>
					</s:if>
					<s:else>
						<j:selector name="form.accttype" definition="$CH_ACCOUNTTYPE" mode="selector" disabled="true"/>
						<font color="red"> &nbsp; *</font>
					</s:else>
                </td>
                <td>
                	&nbsp;
                </td>
                <td>
                	&nbsp;
                </td>
            </tr>   
    </table>
    </div>
    
    
    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                	<j:purChk permid="<%=ID_AUDIT%>" disableChild="true">
                	<input type="button" id="btn" name="btnPass" class="button_Save" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="pass"/>" onclick="return ev_checkval('PASS');" 
                           <s:if test="form.auditstatus_work!=0 or CMD == WEB_CMD_SAVE">disabled = "true"</s:if>  
                           />
                    <input type="button" id="btn" name="btnRefuse" class="button_Save" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="refuse"/>" onclick="doSave('CANCEL')"
                           <s:if test="form.auditstatus_work!=0 or CMD == WEB_CMD_SAVE">disabled = "true"</s:if> 
                           />
                     </j:purChk>
                   	<s:i18n name="public">
                   	<j:purChk permid="<%=ID_AUDIT%>" disableChild="true">
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="return ev_checkval('SAVE');"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    </j:purChk>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/auditwork_list2.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
