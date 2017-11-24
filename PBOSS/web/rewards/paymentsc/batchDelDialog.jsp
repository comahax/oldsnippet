<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>

<html>
<head>
	<title>确认对话窗 </title>
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
        <table id="tbQuery" class="table_normal" width="500">
            <tr>
            	<td align="left" colspan="4">&nbsp;&nbsp;已选择条件
            	   <input type="hidden" id="cmdType" name="cmdType"/>&nbsp;
            	</td>
            </tr>
            
            <tr>
				<td align="right" width="32%"></span>查询总记录数：</td>
				<td align="left" width="18%">&nbsp;&nbsp;<span id="rowcount"></span></td>
				<td align="right" width="32%">可<span id="cmd"></span>的记录数：</td>
				<td align="left" width="18%">&nbsp;&nbsp;<font color="red"><span id="resCounts"></span></font></td>
			</tr>
			<tr>
			    <td align="right">注意：</td>
				<td align="left" colspan="3">&nbsp;&nbsp;<font color="red"><span id="explain"></span></font></td>
			</tr>
			<tr>
			    <td align="center" colspan="2">
            		<input type="button" id="confirm" name="confirm" class="button2" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="确认" onClick="doOperate('ok')">
	            </td>
            	<td align="center" colspan="2">
            	    <input type="button" id="cancel" name="cancel" class="button2" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="取消" onClick="doOperate('cancel')">
	            </td>
            </tr>
        </table>
    </div>
    
</body>

<script language="JavaScript" type="text/JavaScript">
	 function addTR(trIndex,chnName,qryText) 
	 {
		 var tb = getElementByTabId("tbQuery");
		 var tr = tb.insertRow(trIndex);
		 
		 var newTd0 = tr.insertCell(0);
		 newTd0.innerHtml = "&nbsp;";
		 newTd0.style.textAlign = "left";
		 newTd0.style.width = "32%";
		 
		 var newTd1 = tr.insertCell(1);
		 newTd1.innerText = chnName;
		 newTd1.style.textAlign = "right";
		 newTd1.style.width = "18%";
		 
		 var newTd2 = tr.insertCell(2);
		 newTd2.innerText = " " + qryText;
		 newTd2.style.textAlign = "left";
		 newTd2.style.width = "32%";
		 
		 var newTd3 = tr.insertCell(3);
		 newTd3.innerHtml = "&nbsp;";
		 newTd3.style.textAlign = "right";
		 newTd3.style.width = "18%";
	 }
	 
	 function doOperate(opt){
		window.returnValue= opt;
		window.close();
	 }
	 
	 function setAddTr(param,paramName,trIndex){
		if(param != ""){
			addTR(trIndex, paramName, param);
		    trIndex = trIndex + 1;
		}
		return trIndex;
	 }
	 	 
	 (function(){
		 var trIndex = 1;
		 var send = window.dialogArguments;
		 
		 var switchflag = send.switchflag;
		 var cmdType = send.cmdType;
		 getElementByTabId("cmdType").value = cmdType;
		 
		 trIndex = setAddTr(send.wayid, "渠道编码： ",trIndex);
		 trIndex = setAddTr(send.calcmonth, "结算月份（出账月份）： ",trIndex);
		 trIndex = setAddTr(send.optype, "业务类型： ",trIndex);
		 trIndex = setAddTr(send.ltype, "酬金大类： ",trIndex);
		 trIndex = setAddTr(send.stype, "酬金小类： ",trIndex);
		 trIndex = setAddTr(send.paymonth, "业务月份（办理月份）： ",trIndex);
		 trIndex = setAddTr(send.mobile, "手机号码： ",trIndex);
		 trIndex = setAddTr(send.imei, "IMEI号： ",trIndex);
		 
		 var checkedflag = send.checkedflag;
		 if(checkedflag=="CHECKED"){
			 checkedflag="已审核";
		 }else if(checkedflag=="UNCHECKED"){
			 checkedflag="未审核";
		 }else{
			 checkedflag="";
		 }
		 trIndex = setAddTr(checkedflag, "审核标识： ",trIndex);
		 
		 trIndex = setAddTr(send.upoprcode, "上传工号： ",trIndex);
		 
		 var cmd = getElementByTabId("cmd");
		 var explain = getElementByTabId("explain");
		 
		 var totalpre="";
		 var explaintxt="";
		 if(cmdType == "batchDelete"){
			 totalpre = "删除";
		     explaintxt = "当前只允许删除未发送过的数据";
		 }
		 
		 setInnerText(cmd, totalpre);
		 setInnerText(explain, explaintxt);
		 
		 var rowcount = getElementByTabId("rowcount");
		 setInnerText(rowcount, send.rowcount);
		 
		 var resCounts = getElementByTabId("resCounts");
		 setInnerText(resCounts, send.resCounts);
	 })();
	 
    </script>
</html>