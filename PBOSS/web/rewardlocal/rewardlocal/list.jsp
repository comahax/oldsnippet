<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_rewardmonth', '<s:text name="rewardmonth"/>', 'c', false, '6');
            addfield('param._se_rpttype', '<s:text name="rpttype"/>', 'c', false, '32');
            addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, '18');
            addfield('param._se_mobleno', '<s:text name="mobleno"/>', 'c', true, '20');
            return checkval(window);
        }
        window.onload = function(){
        	f_changeType();
        }
        function f_changeType(){
        	if(document.forms[0]["param._se_rpttype"].value=="RPWDLocalRPT"){
				document.getElementById("moblenoTd").style.display = "block";
				document.getElementById("moblenoValueTd").style.display = "block";
        	}else{
        		document.getElementById("moblenoTd").style.display = "none";
        		document.getElementById("moblenoValueTd").style.display = "none";
        	}
        }
    </script>
</head>

<body class="list_body">
<div class="table_container">
<s:form action="rewardlocal_doListReward.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//����Ŀؼ���Action�ṩ���ݣ�������ҳ%>
	<aa:zone name="hiddenZone">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
    </aa:zone>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea">������</span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea">���س�����</span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
			<!-- 
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
			 -->
		</div>
	</div>
    
    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>

	<div class="table_div">
        <table class="table_normal">
            <tr>
            	<td align="center"><s:text name="wayid2"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_wayid" /><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_wayid','','','AG');this.value='...';" />
                </td>
                <td align="center"><s:text name="rewardmonth"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_rewardmonth"
                    onclick="WdatePicker({dateFmt:'yyyyMM',minDate:'%y {%M-6}',maxDate:'%y {%M-1}'})" readonly="true"/>
                </td>
           </tr>
           <tr>
                <td align="center"><s:text name="rpttype"/>:</td>
                <td align="left">
                	<j:selector definition="$CH_REWARDLOCALTYPE" name="param._se_rpttype" cssStyle="style_input" onchange="f_changeType()" />
                </td>
                <td id="moblenoTd" align="center"><s:text name="mobleno"/>:</td>
                <td id="moblenoValueTd" align="left">
                    <s:textfield cssStyle="style_input" name="param._se_mobleno" />
                </td>
            </tr>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
                	<s:i18n name="public">
                	<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_search"/>" onClick="doQuery('/rewardlocal/rewardlocal_doListReward.do');">
                   </s:i18n>
				</td>
			</tr>
		</table>
	</div>

	<aa:zone name="listZone">
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style">
            <tr class="table_style_head">
            	<s:if test="param._se_rpttype=='RPWDLocalRPT'">
            		<td><s:text name="wayid2"/></td>
            		<td><s:text name="mobleno"/></td>
            		<td><s:text name="type"/></td>
            		<td><s:text name="failureexplain"/></td>
            	</s:if>
            	<s:else>
	                <td>
	                    <a href="javascript:doOrderby('cityname')"><s:text name="cityname"/></a>                 
	                </td>
	                <td>
	                    <a href="javascript:doOrderby('localname')"><s:text name="localname"/></a>                 
	                </td>
	                <td>
	                    <a href="javascript:doOrderby('wayidCus')"><s:text name="wayidCus"/></a>                 
	                </td>
	                <td>
	                    <a href="javascript:doOrderby('wayid')"><s:text name="wayid"/></a>                 
	                </td>
	                <td>
	                    <a href="javascript:doOrderby('wayname')"><s:text name="wayname"/></a>                 
	                </td>
	                <td>
	                    <a href="javascript:doOrderby('starlevel')"><s:text name="starlevel"/></a>                 
	                </td>
	                <s:iterator value="listRewardlocaltitle">
	                	<td>
	                		<s:if test="subtitlename!=null && subtitlename!=''">
	                			(${titlename })-${subtitlename }
	                		</s:if>
	                		<s:else>
	                			${titlename }
	                		</s:else>
		                </td>
	                </s:iterator>
                </s:else>
            </tr>
            <s:if test="param._se_rpttype!='RPWDLocalRPT' && listRewardlocaltitle!=null && listRewardlocaltitle.size()>0">
	            <s:iterator value="dp.datas" >
	                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
						 <%-- ���������á�|������� --%>
						 <!-- 
	                     <td>
	                         <input type="checkbox" name="param._selectitem" value="<s:property value="rewardid"/>" onclick="checkOne();">
	                     </td>
	                     <td><a href='<s:url action="rewardlocal_edit.do">
		                         <s:param name="param._pk" value="rewardid"/>
		                     	</s:url>'>
								<s:property value="rewardid"/>
	                         </a>
						 </td>
						  -->
	                     <td><s:property value="cityname" /></td>
	                     <td><s:property value="localname" /></td>
	                     <td><s:property value="wayidCus" /></td>
	                     <td><s:property value="wayid" /></td>
	                     <td><s:property value="wayname" /></td>
	                     <td><s:property value="starlevel" /></td>
	                     <s:iterator value="listRewardlocalvalue" status="st">
	                     	<s:if test="listRewardlocalvalue.get(#st.index)!=null">
	                     		<td>${content }</td>
	                     	</s:if>
	                     </s:iterator>
	                 </tr>
	             </s:iterator>
             </s:if>
             <s:elseif test="param._se_rpttype=='RPWDLocalRPT'" >
             	<s:iterator value="dp.datas" >
	                <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
	                 	<td><s:property value="wayid" /></td>
					 	<td><s:property value="mobleno" /></td>
					 	<td><s:property value="type" /></td>
					 	<td><s:property value="failureexplain" /></td>
	                </tr>
	            </s:iterator>
             </s:elseif>
        </table>
        </div>
    </div>
    <div class="table_div">
		<%@ include file="/common/pageNav.jsp"%>
   	</div>
    </aa:zone>
</s:form>
</div>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,hiddenZone,listZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();  
	ajaxAnywhere.formURL = formList.action;
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
</body>
</html>
