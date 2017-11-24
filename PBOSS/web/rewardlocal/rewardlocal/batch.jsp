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
            addfield('rewardmonth', '��������', 'c', false, '14');
            addfield('rpttype', '��������', 'c', false, '40');
            addfield('doc', '�ϴ��ļ�', 'c', false, '120');
            if( checkval(window)){
            return isExistReward();
            }
            return false;
        }
        
        //�жϱ��س���Ƿ����
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
            url: '/rewardlocal/rewardlocal_isExistReward.do',   //����ҳ��
            type: 'post',      //POST��ʽ��������
            async: false,      //ajaxͬ��
            data: {"param._se_rewardmonth":rewardmonth,"param._se_rpttype":rpttype},
            success: function(data) {
                if('true'== data){
		    	result=  window.confirm('['+rpttypeName+']��['+rewardmonth+']���Ѿ����ڣ��ظ��ϴ��Ḳ�����еı�����ȷ����');
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
			<span class="table_toparea_h">���س���ϴ�</span>
			
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
                <td align="right">�����·�:&nbsp</td>
                <td align="left">

					<s:textfield id="rewardmonth" name="rewardmonth" onclick="WdatePicker({dateFmt:'yyyyMM',minDate:'%y {%M-6}',maxDate:'%y {%M-1}'})" readonly="true"/>
					<font color=red>*</font>
                </td>
            </tr><tr >
                <td align="right">��������:&nbsp</td>
                <td align="left">
					<j:selector definition="$CH_REWARDLOCALTYPE" id="rpttype" name="rpttype" mode="selector"/>
					<font color=red>*</font>
                </td>
            </tr>
            <tr >
                <td align="right">��ѡ���ϴ��ļ�:&nbsp</td>
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
						�ֹ�˾|������|������ţ�˫���֣�|�������루BOSS��|��������|�����Ǽ�|
					</font>����
					<br/>ע�����ж�������ʱ����Ҫ�ѱ��ⶨ��Ϊ(XXX)-YYY��ʽ������XXXΪһ���������ƣ�YYYΪ�����������ƣ�()��Ϊ��Ƿ���
                </td>
            </tr>
            <tr >
                <td align="right"><s:text name="file_example"/>:&nbsp</td>
                <td align="left">
					<font color=red>
						����|���޷�����|1008|NESW1DZBF|��β�г��������ƶ�ͨ���в�|5|
					</font> ����
					
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
