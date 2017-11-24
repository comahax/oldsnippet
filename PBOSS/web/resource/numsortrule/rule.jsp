<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>

    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
       var flag = false;
       
        function doConfirm(){
        	
        		ruleValue = document.getElementById('ruleexp').value;
        		if( null == ruleValue || '' == ruleValue){
        		var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[规则表达式 ] 不能为空</span> ';
        				errorMessageShow(alertstr);
        		return false;
        		}
        		if(flag){
        		var reg = /^\*[0-9]{1,8}$/;
        		if(!reg.test(ruleValue))
        			{
						var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[自定义规则表达式 ]格式不对*号开头0--9的数字，最多8位</span> ';
        				errorMessageShow(alertstr);
        				return false;
        		}else{
        			errorMessageShow(''); 
        		}
        	}
        	window.dialogArguments.pubRuleexp(ruleValue);
        		window.close();
        }
        
        function canWrite(ruleValue){ 
        	if(ruleValue == '**'){
        		flag = true;
        		document.getElementById('ruleexp').value="*";
        		document.getElementById('ruleexp').readOnly=false;
        	}else{
        		flag = false;
        		document.getElementById('ruleexp').value= ruleValue;
        		document.getElementById('ruleexp').readOnly=true;
        	}
        }
        
 
    </script>
</head>
<body>
<div class="table_container">


	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="resource"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h">规则表达式</span>
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
                <td align="right">规则表达式:&nbsp</td>
			    <td align="left">
			    <input type="text" id="ruleexp" name="ruleexp" readonly="readonly"  />
			    	<s:i18n name="public">
                    <input type="button" id="btnConfirm" name="btnConfirm" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_confirm"/>" onclick="doConfirm()"/>
                    <input type="button" id="btnClose" name="btnClose" class="button_Delete" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_close"/>" onclick="window.close();">
					</s:i18n>
			    </td>
            </tr>
            <tr>
                <td align="right">连号:&nbsp</td>
			    <td align="left">
			    <input type="radio" name="ruleRadio" value="*AAAAAA" onclick="canWrite(this.value);">六连号</radio>
			    <input type="radio" name="ruleRadio" value="*AAAAA" onclick="canWrite(this.value);">五连号</radio>
			    <input type="radio" name="ruleRadio" value="*AAAA" onclick="canWrite(this.value);">四连号</radio>
			    <input type="radio" name="ruleRadio" value="*AAA" onclick="canWrite(this.value);">三连号</radio>
			    <input type="radio" name="ruleRadio" value="*AA" onclick="canWrite(this.value);">二连号</radio>
			    <br>
			    末尾数字相同，如13800166666（五连*AAAAA）、13800138666（三连*AAA）
			    </td>
            </tr>
            <tr>
                <td align="right">两段连号:&nbsp</td>
			    <td align="left">
			    <input type="radio" name="ruleRadio" value="*AAAABBBB" onclick="canWrite(this.value);">四连号</radio>
			    <input type="radio" name="ruleRadio" value="*AAABBB" onclick="canWrite(this.value);">三连号</radio>
			    <input type="radio" name="ruleRadio" value="*AABB" onclick="canWrite(this.value);">二连号</radio>
			    <br>
			    末尾数字中有两段相同，如1388886666（四连*AAAABBBB）、13800136688（二连*AABB）
			    </td>
            </tr>
            <tr>
                <td align="right">三段连号:&nbsp</td>
			    <td align="left">
			    <input type="radio" name="ruleRadio" value="*AAABBBCCC" onclick="canWrite(this.value);">三连号</radio>
			    <input type="radio" name="ruleRadio" value="*AABBCC" onclick="canWrite(this.value);">二连号</radio>
			    <br>
			    末尾数字中有三段相同，如13222888666（三连*AAABBBCCC）、13820556688（二连*AABBCC）
			    </td>
            </tr>
            <tr>
                <td align="right">四段连号:&nbsp</td>
			    <td align="left">
			    <input type="radio" name="ruleRadio" value="*AABBCCDD" onclick="canWrite(this.value);">二连号</radio>
			    <br>
			    末尾数字中有四段相同，如13800556688（二连*AABBCCDD）
			    </td>
            </tr>
            
            <tr>
                <td align="right">顺序:&nbsp</td>
			    <td align="left">
			    <input type="radio" name="ruleRadio" value="*ABCDE" onclick="canWrite(this.value);">五位</radio>
			    <input type="radio" name="ruleRadio" value="*ABCD" onclick="canWrite(this.value);">四位</radio>
			    <input type="radio" name="ruleRadio" value="*ABC" onclick="canWrite(this.value);">三位</radio>
			    <br>
			    末尾数字中有多位递增，如13800112345（五位*ABCDE）、13800138123（三位*ABC）
			    </td>
            </tr>
            <tr>
                <td align="right">倒序:&nbsp</td>
			    <td align="left">
			    <input type="radio" name="ruleRadio" value="*EDCBA" onclick="canWrite(this.value);">五位</radio>
			    <input type="radio" name="ruleRadio" value="*DCBA" onclick="canWrite(this.value);">四位</radio>
			    <input type="radio" name="ruleRadio" value="*CBA" onclick="canWrite(this.value);">三位</radio>
			    <br>
			    末尾数字中有多位递减，如13800154321（五位*EDCBA）、13800138321（三位*CBA）
			    </td>
            </tr>
            <tr>
                <td align="right">双顺:&nbsp</td>
			    <td align="left"> 
			    <input type="radio" name="ruleRadio" value="*abcdabcd" onclick="canWrite(this.value);">四条</radio>
			    <input type="radio" name="ruleRadio" value="*abcabc" onclick="canWrite(this.value);">三条</radio>
			    <input type="radio" name="ruleRadio" value="*abab" onclick="canWrite(this.value);">两条</radio>
			    <br>
			    末尾数字中有两段重复，如13812681268（四条*abcdabcd）、13800136868（两条*abab）
			    </td>
            </tr>
            <tr>
                <td align="right">三顺:&nbsp</td>
			    <td align="left">
			    <input type="radio" name="ruleRadio" value="*abcabcabc" onclick="canWrite(this.value);">三条</radio>
			    <input type="radio" name="ruleRadio" value="*ababab" onclick="canWrite(this.value);">两条</radio>
			    <br>
			    末尾数字中有三段重复，如13268268268（三条*abcabcabc）、13800686868（两条*ababab）
			    </td>
            </tr>
            <tr>
                <td align="right">四顺:&nbsp</td>
			    <td align="left">
			    <input type="radio" name="ruleRadio" value="*abababab" onclick="canWrite(this.value);">两条</radio>
			    <br>
			    末尾数字中有四段重复，如13868686868（两条*abababab）
			    </td>
            </tr>
            <tr>
                <td align="right">自定义:&nbsp</td>
			    <td align="left"> 
			    <input type="radio" name="ruleRadio" value="**" onclick="canWrite(this.value);" >自定义尾号</radio>
			    <br>
			    请在规则表达式输入框中填写*号开头0--9的数字，最多9位
			    </td>
            </tr>
        </table>
    </div>

</div>
</body>
</html>
