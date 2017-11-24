<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
	<head>
	    <title><s:text name="titleList"/></title>
	    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
	    <script language="JavaScript" type="text/JavaScript">
	        function ev_checkval() {
            	addfield('form.wayid', '<s:text name="wayid"/>', 'c', false, 20);
            	return checkval(window);
        	}
	    </script>
	</head>
	
	<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<s:form action="comorder_step2.do" key="formList" cssStyle="formList" key="formItem" theme="simple" onsubmit="return ev_checkval();">
			    <s:hidden name="isurgent"/>
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
			                <td align="center"><s:text name="wayid"/>:</td>
			                <td align="left">
			                    <s:textfield cssStyle="style_input" name="form.wayid" /><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'form.wayid','','','AG');this.value='...';" />
			                	<input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="È·¶¨" onclick="doSave('/sales/comorder_step2.do')"/>
			                </td>
			            </tr>
			        </table>
			    </div>
			</s:form>
		</div>
	</body>
</html>
