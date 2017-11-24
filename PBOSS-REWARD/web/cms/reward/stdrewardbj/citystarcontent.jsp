<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%
     String ID_1 = "CH_PW_REWARD_EDIT || CH_PW_REWARD";

%>
<html>
<base target="_self"/>
<head>
    <title>酬金标准设置</title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/jquery/jquery-1.3.2.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/jquery/jquery.form.js"></script>
    <script language="JavaScript">    	
        function ev_checkval() {
        	if(formItem.s_starflag.value == "1"){
        		addfield('s_cityrewardstd', '<bean:message bundle="stdrewardbj" key="cityrewardstd"/>', 'd', false, '14','4','','0',formItem.s_rewardstd.value);
			}else if(formItem.s_starflag.value == "2"){
				addfield('rewardstd_onestar', '<bean:message bundle="stdrewardbj" key="1starstd"/>', 'd', false, '14','4','','0',formItem.s_rewardstd.value);
				addfield('rewardstd_threestar', '<bean:message bundle="stdrewardbj" key="3starstd"/>', 'd', false, '14','4','','0',formItem.s_rewardstd.value);
				addfield('rewardstd_fourstar', '<bean:message bundle="stdrewardbj" key="4starstd"/>', 'd', false, '14','4','','0',formItem.s_rewardstd.value);
				addfield('rewardstd_fivestar', '<bean:message bundle="stdrewardbj" key="5starstd"/>', 'd', false, '14','4','','0',formItem.s_rewardstd.value);
				addfield('rewardstd_sixstar', '<bean:message bundle="stdrewardbj" key="6starstd"/>', 'd', false, '14','4','','0',formItem.s_rewardstd.value);
				if(formItem.ispt.value == "1"){
					addfield('rewardstd_twostar', '<bean:message bundle="stdrewardbj" key="2starstd"/>', 'd', true, '14','4','','0',formItem.s_rewardstd.value);
					addfield('singlept', '<bean:message bundle="stdrewardbj" key="singlept"/>', 'd', false, '16','4','','0',formItem.s_rewardstd.value);
					addfield('diploidpt', '<bean:message bundle="stdrewardbj" key="diploidpt"/>', 'd', false, '16','4','','0',formItem.s_rewardstd.value);
				} else {
					addfield('rewardstd_twostar', '<bean:message bundle="stdrewardbj" key="2starstd"/>', 'd', false, '14','4','','0',formItem.s_rewardstd.value);
				}
			}else if(formItem.s_starflag.value == "3"){
				addfield('uplimit_level_non', '<bean:message bundle="stdrewardbj" key="level_non"/>', 'd', true, '8','2','','0','');
				addfield('uplimit_level_1', '<bean:message bundle="stdrewardbj" key="level_1"/>', 'd', true, '8','2','','0','');
				addfield('uplimit_level_2', '<bean:message bundle="stdrewardbj" key="level_2"/>', 'd', true, '8','2','','0','');
				addfield('uplimit_level_3', '<bean:message bundle="stdrewardbj" key="level_3"/>', 'd', true, '8','2','','0','');
				addfield('uplimit_level_4', '<bean:message bundle="stdrewardbj" key="level_4"/>', 'd', true, '8','2','','0','');
				addfield('uplimit_level_5', '<bean:message bundle="stdrewardbj" key="level_5"/>', 'd', true, '8','2','','0','');
				addfield('uplimit_level_6', '<bean:message bundle="stdrewardbj" key="level_6"/>', 'd', true, '8','2','','0','');
			}
            return checkval(window);
        }
        
        function doClose(){
        	var cmd = formItem.cmdState.value;
        	if(cmd == 'SAVECITYSTAR'){
        		if(formItem.s_starflag.value == "1"){
        			self.returnValue = formItem.s_cityrewardstd.value;
        		}else if(formItem.s_starflag.value == "2"){
					self.returnValue = '0.0';
				}
        	}
        	self.close();
        }
        function changeRewardStdMode(value) {
        	loadMethod(value)
			errorobj.innerHTML = "";
		}
		function loadMethod(value) {
			if (value == "1") {
				document.getElementById("basicreward_set").style.display=""; //显示
				document.getElementById("starreward_set").style.display="none"; //隐藏
				document.getElementById("uplimitreward_set").style.display="none"; //隐藏
				document.getElementById("installmentpay_set").style.display="none"; //隐藏
				document.getElementById("installmentpay_setnum").style.display="none";
				jQuery('.installmentpay_item').remove();
				document.getElementById("installmentpay_num").value='';
			}else if(value == "2"){
				if(formItem.ispt.value == 1){
					document.getElementById("isptid").checked=true;
					showPt(document.getElementById("isptid"));
				}
				document.getElementById("starreward_set").style.display=""; //显示
				document.getElementById("basicreward_set").style.display="none"; //隐藏
				document.getElementById("uplimitreward_set").style.display="none"; //隐藏
				document.getElementById("installmentpay_set").style.display="none"; //隐藏
				document.getElementById("installmentpay_setnum").style.display="none";
				jQuery('.installmentpay_item').remove();
				document.getElementById("installmentpay_num").value='';
			}else if(value == "3"){
				document.getElementById("basicreward_set").style.display="none"; //隐藏
				document.getElementById("starreward_set").style.display="none"; //隐藏
				document.getElementById("uplimitreward_set").style.display=""; //显示
				document.getElementById("installmentpay_set").style.display="none"; //隐藏
				document.getElementById("installmentpay_setnum").style.display="none";
				jQuery('.installmentpay_item').remove();
				document.getElementById("installmentpay_num").value='';
			}else if(value == "4"){
				document.getElementById("basicreward_set").style.display="none"; //隐藏
				document.getElementById("starreward_set").style.display="none"; //隐藏
				document.getElementById("uplimitreward_set").style.display="none";//隐藏 
				document.getElementById("installmentpay_set").style.display="";//显示
				document.getElementById("installmentpay_setnum").style.display="";
			}
		}
		
		function showPt(obj) {
			//reloadforiframe();
			if (obj.checked == true) {
				formItem.ispt.value = "1";
				document.getElementById("showpt").style.display=""; //显示
			} else {
				formItem.ispt.value = "0";
				document.getElementById("showpt").style.display="none"; //隐藏
			}
		}		
		function doBuildInstall(num){
			errorobj.innerHTML = "";
			//var num = parseInt(setnum);
			if(num=='' || num<=0 || num>30){
			    var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[酬金期数]</span> 必须为正整数且不超过30）</span>';
				errorMessageShow(alertstr);//errorMessageShow
				jQuery('.installmentpay_item').remove();
				return;
			}
			var htmlstr = '';
			for(var i=1; i<=num; i++){
				htmlstr+='<tr class="installmentpay_item"><td width="30%" align="right" class="form_table_right"><div class="field-require">';
				htmlstr+=i;
				htmlstr+='期酬金标准(元):</div></td><td width="60%" align="left" class="form_table_left">';
				htmlstr+='<input type="text" class="form_input_1x" maxlength="14" name="installmentpay_items"/><font color="red">&nbsp;最多允许2位小数</font></td></tr>';
			}
			jQuery('.installmentpay_item').remove();
			jQuery('#installmentpay_head').after(htmlstr);
		}
		function doSave(cmdSave) {
			//var url = '/cms/reward/stdrewardbj.do?CMD=SAVECITYSTAR';
			var s_starflag = document.getElementById('s_starflag').value;
			if(s_starflag!="4"){
				if (ev_checkval()) {
			        enable();
			        formItem.action = contextPath + cmdSave;
			        formItem.submit();
			    }
			    return false;
			}else{//installmentpay 标准关联期数设置
				jQuery('#saveButton').attr('disabled',true);
				var saveSuccess=function(retinfo){
					var info = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>'+retinfo+'</span></span>';
					errorMessageShow(info);
					jQuery('#saveButton').attr('disabled',false);
				}
				var ajaxOption={
					dataType:'text',
					success:saveSuccess
				}
				jQuery('#formItem').ajaxSubmit(ajaxOption);			
			}		    
		}
    </script>
</head>
<body onload="loadMethod(formItem.s_starflag.value);">
<div class="table_container">
<html:form action="/cms/reward/stdrewardbj.do?CMD=SAVECITYSTAR" styleId="formItem" method="post">

    <html:hidden property="cmdState"/>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    
    <html:hidden property="s_opnid" />
    <html:hidden property="s_rewardid" />
    <html:hidden property="s_acctype" />
    <html:hidden property="s_ruleid" />
    <html:hidden property="s_rewardstd" />
    <html:hidden property="ispt" />
    
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
	    <table class="form_table">
	    	<tr>
	    		<td>
					酬金设置模式选择:
					<html:select property="s_starflag" onchange="changeRewardStdMode(this.value);" style="width:160" styleId="s_starflag">
						<s:Options definition="#REWARDSTDMODE" />
					</html:select>
				</td>
				<td>
					<div class="installmentpay" id="installmentpay_setnum" style="display:none">
					酬金期数 :<html:text property="installmentpay_num" styleId="installmentpay_num" onkeyup="doBuildInstall(this.value);"></html:text>
					<font color='red'>必须为正整数且不超过30</font>
					</div>
				</td>
	    	</tr>
	    </table>
    </div>
    
    <div class="table_div">	
   		 <table width="100%" class="error_text">
    		<html:errors/><s:Msg />
    	</table>
    </div>
    
    <div class="table_div" id="basicreward_set">
        <table class="form_table">
	    	<tr>
	    		<td colspan="2">
	    		    统一标准酬金设置:
	   			</td>
	    	</tr>
	    	<tr>
                <td width="30%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbj" key="cityrewardstd"/>:</div></td>
                <td width="60%" align="left" class="form_table_left">
                	<html:text styleClass="form_input_1x" property="s_cityrewardstd" maxlength="14" />
                	<font color=red>*</font>(省公司酬金上限:<font color="red"><c:out value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].s_rewardstd}" /></font>元/百分比)
                </td>
            </tr>
	    </table>
    </div>

    <div class="table_div" id="starreward_set">
        <table class="form_table">
        	<tr>
	    		<td colspan="2">
	    			标准关联渠道星级设置:
	   			</td>
    		</tr>
            <tr>
                 <td width="30%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbj" key="1starstd"/>:</div></td>
                <td width="60%" align="left" class="form_table_left">
                	<html:text styleClass="form_input_1x" property="rewardstd_onestar" maxlength="14" />
                	<font color=red>*</font>(省公司酬金上限:<font color="red"><c:out value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].s_rewardstd}" /></font>元/百分比)
                </td>
            </tr>
            <tr>
                 <td width="30%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbj" key="2starstd"/>:</div></td>
                <td width="60%" align="left" class="form_table_left">
                	<html:text styleClass="form_input_1x" property="rewardstd_twostar" maxlength="14" />
                	<font color=red>*</font>(省公司酬金上限:<font color="red"><c:out value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].s_rewardstd}" /></font>元/百分比)
                	<input type="checkbox" id="isptid" value="" onclick="showPt(this);" class="table_checkbox">是否排他<font color=red><br>(勾选后2星级酬金标准变为非必填项)</font>
                </td>
            </tr>
            <tr id="showpt" style="display:none">
            	<td width="30%" align="right" class="form_table_right">2星级网点单、双排它酬金标准:</td>
            	<td width="60%" align="right" class="form_table_left">单排他:<html:text styleClass="form_input_1x" property="singlept" maxlength="16" />&nbsp<font color=red>*</font>&nbsp&nbsp&nbsp&nbsp&nbsp双排他:<html:text styleClass="form_input_1x" property="diploidpt" maxlength="16" />&nbsp<font color=red>*</font></td>
            </tr>
            <tr>
                 <td width="30%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbj" key="3starstd"/>:</div></td>
                <td width="60%" align="left" class="form_table_left">
                	<html:text styleClass="form_input_1x" property="rewardstd_threestar" maxlength="14" />
                	<font color=red>*</font>(省公司酬金上限:<font color="red"><c:out value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].s_rewardstd}" /></font>元/百分比)
                </td>
            </tr>
            <tr>
                 <td width="30%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbj" key="4starstd"/>:</div></td>
                <td width="60%" align="left" class="form_table_left">
                	<html:text styleClass="form_input_1x" property="rewardstd_fourstar" maxlength="14" />
                	<font color=red>*</font>(省公司酬金上限:<font color="red"><c:out value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].s_rewardstd}" /></font>元/百分比)
                </td>
            </tr>
            <tr>
                 <td width="30%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbj" key="5starstd"/>:</div></td>
                <td width="60%" align="left" class="form_table_left">
                	<html:text styleClass="form_input_1x" property="rewardstd_fivestar" maxlength="14" />
                	<font color=red>*</font>(省公司酬金上限:<font color="red"><c:out value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].s_rewardstd}" /></font>元/百分比)
                </td>
            </tr>
            <tr>
                 <td width="30%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbj" key="6starstd"/>:</div></td>
                <td width="60%" align="left" class="form_table_left">
                	<html:text styleClass="form_input_1x" property="rewardstd_sixstar" maxlength="14" />
                	<font color=red>*</font>(省公司酬金上限:<font color="red"><c:out value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].s_rewardstd}" /></font>元/百分比)
                </td>
            </tr>
        </table>
    </div>
    
    <div class="table_div" id="uplimitreward_set">
    	<table class="form_table">
    		<tr>
	    		<td colspan="2">
	    		   网点酬金总额封顶设置:&nbsp;&nbsp;<font color=red>以下设置允许为空，小数部分最多2位</font>
	   			</td>
	    	</tr>
	    	<tr>
                <td width="30%" align="right" class="form_table_right">
                	<div class="field-require"><bean:message bundle="stdrewardbj" key="level_non"/>:</div>
                </td>
                <td width="60%" align="left" class="form_table_left">
                	<html:text styleClass="form_input_1x" property="uplimit_level_non" maxlength="14" />
                </td>
            </tr>
            <tr>
                <td width="30%" align="right" class="form_table_right">
                	<div class="field-require"><bean:message bundle="stdrewardbj" key="level_1"/>:</div>
                </td>
                <td width="60%" align="left" class="form_table_left">
                	<html:text styleClass="form_input_1x" property="uplimit_level_1" maxlength="14" />
                </td>
            </tr>
            <tr>
                <td width="30%" align="right" class="form_table_right">
                	<div class="field-require"><bean:message bundle="stdrewardbj" key="level_2"/>:</div>
                </td>
                <td width="60%" align="left" class="form_table_left">
                	<html:text styleClass="form_input_1x" property="uplimit_level_2" maxlength="14" />
                </td>
            </tr>
            <tr>
                <td width="30%" align="right" class="form_table_right">
                	<div class="field-require"><bean:message bundle="stdrewardbj" key="level_3"/>:</div>
                </td>
                <td width="60%" align="left" class="form_table_left">
                	<html:text styleClass="form_input_1x" property="uplimit_level_3" maxlength="14" />
                </td>
            </tr>
             <tr>
                <td width="30%" align="right" class="form_table_right">
                	<div class="field-require"><bean:message bundle="stdrewardbj" key="level_4"/>:</div>
                </td>
                <td width="60%" align="left" class="form_table_left">
                	<html:text styleClass="form_input_1x" property="uplimit_level_4" maxlength="14" />
                </td>
            </tr>
            <tr>
                <td width="30%" align="right" class="form_table_right">
                	<div class="field-require"><bean:message bundle="stdrewardbj" key="level_5"/>:</div>
                </td>
                <td width="60%" align="left" class="form_table_left">
                	<html:text styleClass="form_input_1x" property="uplimit_level_5" maxlength="14" />
                </td>
            </tr>
            <tr>
                <td width="30%" align="right" class="form_table_right">
                	<div class="field-require"><bean:message bundle="stdrewardbj" key="level_6"/>:</div>
                </td>
                <td width="60%" align="left" class="form_table_left">
                	<html:text styleClass="form_input_1x" property="uplimit_level_6" maxlength="14" />
                </td>
            </tr>
    	</table>
    </div>
    
     <div class="table_div" id="installmentpay_set" class="installmentpay">
    	<table class="form_table">
    		<tr id="installmentpay_head">
    			<td colspan="2">标准关联期数设置:
    			<font color='red'>(省公司酬金上限:<font color="red"><c:out value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].s_rewardstd}" /></font>元/百分比)</font>
    			</td>
    		</tr>
    	</table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/reward/stdrewardbj.do?CMD=SAVECITYSTAR');" id="saveButton"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doClose();">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>