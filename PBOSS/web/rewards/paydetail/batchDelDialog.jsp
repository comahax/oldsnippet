<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>

<html>
<head>
	<title>����ɾ��ȷ�϶Ի��� </title>
	<script language="JavaScript" type="text/JavaScript">
	function setInnerText(element, text) {
        if (typeof element.textContent == "string") {
           element.textContent = text;
        } else {
           element.innerText = text;
        }
     }
	
	function getElementByTabId(tabName){
	    return document.getElementById(tabName);
	}

    </script>
</head>

<body>
     <div class="table_container">
        <table class="table_normal" width="500">
            <tr>
            	<td align="right" width="20%">��ѡ������</td>
            	<td align="left" width="80%" colspan="2">&nbsp;</td>
            </tr>
            <tr>
                <td align="left">&nbsp;</td>
            	<td align="right" width="20%">��������</td>
            	<td align="left"><span id="wayid">&nbsp;</span></td>
            </tr>
            <tr>
                <td align="left">&nbsp;</td>
            	<td align="right">������</td>
            	<td align="left"><span id="calcmonth">&nbsp;</span></td>
            </tr>
            <tr>
                <td align="left">&nbsp;</td>
            	<td align="right">ҵ����</td>
            	<td align="left"><span id="opmonth">&nbsp;</span></td>
            </tr>
            <tr>
                <td align="left">&nbsp;</td>
            	<td align="right">IMEI/����</td>
            	<td align="left"><span id="mobile">&nbsp;</span></td>
            </tr>
            <tr>
				<td align="right">ɾ����¼��</td>
				<td align="left" colspan="2">&nbsp;&nbsp;<span id="rowcount">&nbsp;</span></td>
			</tr>
			<tr>
				<td align="left" colspan="3">&nbsp;</td>
			</tr>
			<tr>
			    <td align="center" colspan="2">
            		<input type="button" id="confirm" name="confirm" class="button2" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="ȷ��" onClick="doOperate('ok')">
	            </td>
            	<td align="center">
            	    <input type="button" id="cancel" name="cancel" class="button2" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="ȡ��" onClick="doOperate('cancel')">
	            </td>
            </tr>
        </table>
    </div>
    
</body>

<script language="JavaScript" type="text/JavaScript">
	 var send = window.dialogArguments;

	 var wayid = getElementByTabId("wayid");
	 var mobile = getElementByTabId("mobile");
	 var calcmonth = getElementByTabId("calcmonth");
	 var opmonth = getElementByTabId("opmonth");
	 
	 var rowcount = getElementByTabId("rowcount");
	 
	 setInnerText(wayid, send.wayid);
	 setInnerText(mobile, send.mobile);
	 setInnerText(calcmonth, send.calcmonth);
	 setInnerText(opmonth, send.opmonth);
	 setInnerText(rowcount, send.rowcount);

	 function doOperate(opt){
		window.returnValue= opt;
		window.close();
	 }
    </script>
</html>