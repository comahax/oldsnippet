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
        		var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[������ʽ ] ����Ϊ��</span> ';
        				errorMessageShow(alertstr);
        		return false;
        		}
        		if(flag){
        		var reg = /^\*[0-9]{1,8}$/;
        		if(!reg.test(ruleValue))
        			{
						var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[�Զ��������ʽ ]��ʽ����*�ſ�ͷ0--9�����֣����8λ</span> ';
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
			<span class="table_toparea_h">������ʽ</span>
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
                <td align="right">������ʽ:&nbsp</td>
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
                <td align="right">����:&nbsp</td>
			    <td align="left">
			    <input type="radio" name="ruleRadio" value="*AAAAAA" onclick="canWrite(this.value);">������</radio>
			    <input type="radio" name="ruleRadio" value="*AAAAA" onclick="canWrite(this.value);">������</radio>
			    <input type="radio" name="ruleRadio" value="*AAAA" onclick="canWrite(this.value);">������</radio>
			    <input type="radio" name="ruleRadio" value="*AAA" onclick="canWrite(this.value);">������</radio>
			    <input type="radio" name="ruleRadio" value="*AA" onclick="canWrite(this.value);">������</radio>
			    <br>
			    ĩβ������ͬ����13800166666������*AAAAA����13800138666������*AAA��
			    </td>
            </tr>
            <tr>
                <td align="right">��������:&nbsp</td>
			    <td align="left">
			    <input type="radio" name="ruleRadio" value="*AAAABBBB" onclick="canWrite(this.value);">������</radio>
			    <input type="radio" name="ruleRadio" value="*AAABBB" onclick="canWrite(this.value);">������</radio>
			    <input type="radio" name="ruleRadio" value="*AABB" onclick="canWrite(this.value);">������</radio>
			    <br>
			    ĩβ��������������ͬ����1388886666������*AAAABBBB����13800136688������*AABB��
			    </td>
            </tr>
            <tr>
                <td align="right">��������:&nbsp</td>
			    <td align="left">
			    <input type="radio" name="ruleRadio" value="*AAABBBCCC" onclick="canWrite(this.value);">������</radio>
			    <input type="radio" name="ruleRadio" value="*AABBCC" onclick="canWrite(this.value);">������</radio>
			    <br>
			    ĩβ��������������ͬ����13222888666������*AAABBBCCC����13820556688������*AABBCC��
			    </td>
            </tr>
            <tr>
                <td align="right">�Ķ�����:&nbsp</td>
			    <td align="left">
			    <input type="radio" name="ruleRadio" value="*AABBCCDD" onclick="canWrite(this.value);">������</radio>
			    <br>
			    ĩβ���������Ķ���ͬ����13800556688������*AABBCCDD��
			    </td>
            </tr>
            
            <tr>
                <td align="right">˳��:&nbsp</td>
			    <td align="left">
			    <input type="radio" name="ruleRadio" value="*ABCDE" onclick="canWrite(this.value);">��λ</radio>
			    <input type="radio" name="ruleRadio" value="*ABCD" onclick="canWrite(this.value);">��λ</radio>
			    <input type="radio" name="ruleRadio" value="*ABC" onclick="canWrite(this.value);">��λ</radio>
			    <br>
			    ĩβ�������ж�λ��������13800112345����λ*ABCDE����13800138123����λ*ABC��
			    </td>
            </tr>
            <tr>
                <td align="right">����:&nbsp</td>
			    <td align="left">
			    <input type="radio" name="ruleRadio" value="*EDCBA" onclick="canWrite(this.value);">��λ</radio>
			    <input type="radio" name="ruleRadio" value="*DCBA" onclick="canWrite(this.value);">��λ</radio>
			    <input type="radio" name="ruleRadio" value="*CBA" onclick="canWrite(this.value);">��λ</radio>
			    <br>
			    ĩβ�������ж�λ�ݼ�����13800154321����λ*EDCBA����13800138321����λ*CBA��
			    </td>
            </tr>
            <tr>
                <td align="right">˫˳:&nbsp</td>
			    <td align="left"> 
			    <input type="radio" name="ruleRadio" value="*abcdabcd" onclick="canWrite(this.value);">����</radio>
			    <input type="radio" name="ruleRadio" value="*abcabc" onclick="canWrite(this.value);">����</radio>
			    <input type="radio" name="ruleRadio" value="*abab" onclick="canWrite(this.value);">����</radio>
			    <br>
			    ĩβ�������������ظ�����13812681268������*abcdabcd����13800136868������*abab��
			    </td>
            </tr>
            <tr>
                <td align="right">��˳:&nbsp</td>
			    <td align="left">
			    <input type="radio" name="ruleRadio" value="*abcabcabc" onclick="canWrite(this.value);">����</radio>
			    <input type="radio" name="ruleRadio" value="*ababab" onclick="canWrite(this.value);">����</radio>
			    <br>
			    ĩβ�������������ظ�����13268268268������*abcabcabc����13800686868������*ababab��
			    </td>
            </tr>
            <tr>
                <td align="right">��˳:&nbsp</td>
			    <td align="left">
			    <input type="radio" name="ruleRadio" value="*abababab" onclick="canWrite(this.value);">����</radio>
			    <br>
			    ĩβ���������Ķ��ظ�����13868686868������*abababab��
			    </td>
            </tr>
            <tr>
                <td align="right">�Զ���:&nbsp</td>
			    <td align="left"> 
			    <input type="radio" name="ruleRadio" value="**" onclick="canWrite(this.value);" >�Զ���β��</radio>
			    <br>
			    ���ڹ�����ʽ���������д*�ſ�ͷ0--9�����֣����9λ
			    </td>
            </tr>
        </table>
    </div>

</div>
</body>
</html>
