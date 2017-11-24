<%@ page language="java" contentType="text/html;charset=GBK" %>
<%@ include file="/inc/listhead.inc" %>
<%
String rewardMonth = request.getParameter("rewardmonth");
 %>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript" type="text/JavaScript">
	    function checkProcess(){
			var filename = formItem.path.value;
			if(filename != null || filename != ""){
	    		formItem.btnDeal.disabled=true;
	    		document.getElementById("importUrl").href="<%=contextPath%>/rewardlocal/rewardlocal_import.do?filename="+filename+"&beanname=com.gmcc.pboss.web.reward.rewardlocal.RewardlocalTask";
	    		document.getElementById("importUrl").click();
				
			}
		}
		$(document).ready(function(){ 
      		 var filename ="<s:property value="fileName" />";

		     if(filename == null || filename == '' ){
		    	 $("#btnDeal").attr('disabled',true);
		     }
		     else{
			      $("#btnDeal").attr('disabled',false);
			      
		      }
  		 });
  		 
  		  function ev_check() {
            addfield('rewardmonth', '结算日期', 'c', false, '14');
            addfield('rpttype', '报表类型', 'c', false, '40');
            addfield('doc', '上传文件', 'c', false, '120');
            if( checkval(window)){
            return isExistReward();
            }
            return false;
        }
        
        //判断本地酬金是否存在
        function isExistReward(){
        var result = true;
        var rpttype = '';
        var rewardmonth = $('#rewardmonth').val();
        var rpttypeName = '';
        $("#rpttype").children().each(function(i){
        	if(this.selected){
        		rpttypeName = this.text;
        		rpttype = this.value;
        	}
        });
        //alert(rpttypeName);
          
          $.ajax({
            url: '/rewardlocal/rewardlocal_isExistReward.do',   //接收页面
            type: 'post',      //POST方式发送数据
            async: false,      //ajax同步
            data: {"param._se_rewardmonth":rewardmonth,"param._se_rpttype":rpttype},
            success: function(data) {
                if('true'== data){
		    	result=  window.confirm('['+rpttypeName+']在['+rewardmonth+']中已经存在，重复上传会覆盖已有的报表，你确认吗？');
		    }
            }
        });      
		return result;
        }

        
    </script>
    <base target="_self">
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="/rewardlocal/rewardlocal_upload.do" cssStyle="formItem" key="formItem" 
			method="post" theme="simple" enctype ="multipart/form-data"  onsubmit="return ev_check();">
    <a id="importUrl" href="#"></a>
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<span class="table_toparea_h">本地酬金上传</span>
			
		</div>
	</div>

<input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.reward.rewardlocal.RewardlocalCheck">
    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>
	
	<aa:zone name="listZone">
    <div class="table_div">
    <s:i18n name="public">
         <table class="table_normal">
         	<tr >
                <td align="right">结算月份:&nbsp</td>
                <td align="left">

					<s:textfield id="rewardmonth" name="rewardmonth" onclick="WdatePicker({dateFmt:'yyyyMM',minDate:'%y {%M-6}',maxDate:'%y {%M-1}'})" readonly="true"/>
					<font color=red>*</font>
                </td>
            </tr><tr >
                <td align="right">报表类型:&nbsp</td>
                <td align="left">
					<j:selector definition="$CH_REWARDLOCALTYPE" id="rpttype" name="rpttype" mode="selector"/>
					<font color=red>*</font>
                </td>
            </tr>
            <tr >
                <td align="right">请选择上传文件:&nbsp</td>
                <td align="left">
					<s:file name="doc" label="File"/>
					<font color=red>*</font>
                </td>
            </tr>
            <tr >
                <td align="right"><s:text name="file_file"/>:&nbsp</td>
                <td align="left">
					<a href='<%=contextPath%>/common/download.jsp?filename=<s:property value="filepath" />'> 
					<s:property value="fileName" /> 
            	</a>
                </td>
            </tr>
            <tr >
                <td align="right"><s:text name="file_type"/>:&nbsp</td>
                <td align="left">
					<s:text name="file_type_txt_describe"/>
                </td>
            </tr>
            <tr >
                <td align="right"><s:text name="file_format"/>:&nbsp</td>
                <td align="left">
                	 <font color=red>
						分公司|服务厅|渠道编号（双积分）|渠道编码（BOSS）|渠道名称|渠道星级|
					</font>……
					<br/>注：若有二级标题时，城要把标题定义为(XXX)-YYY形式，基本XXX为一级标题名称，YYY为二级标题名称，()均为半角符号
                </td>
            </tr>
            <tr >
                <td align="right"><s:text name="file_example"/>:&nbsp</td>
                <td align="left">
					<font color=red>
						城区|香洲服务厅|1008|NESW1DZBF|汕尾市城区中联移动通门市部|5|
					</font> ……
					
                </td>
            </tr>
            
        </table>
        </s:i18n>
    </div>
</aa:zone>
    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                    <input type="submit" id="btnUpload" name="btnUpload" class="button_2" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_upload"/>" />
                    
                   
                    <input type="button"  id="btnDeal" name="btnDeal" class="button_2" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_deal"/>" onclick="checkProcess();"/>
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.reward.rewardlocal.RewardlocalTask" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>

</body>
</html>
<script>
var nowDate = new Date();
nowDate.setMonth(nowDate.getMonth()-1);
var month = nowDate.getMonth()+1;
if(month<10)
month="0"+month;
$("#rewardmonth").val(nowDate.getYear()+""+month);
<%
if( null != rewardMonth){
%>
$("#rewardmonth").val('<%=rewardMonth%>');
<%
}
%>
</script>
