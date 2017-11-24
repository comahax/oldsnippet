<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>


<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
   
    
        function ev_check() {
        	return true;
            //return checkval(window);
        }
        
        function doPack(){
	        document.getElementById('btnQuery').disabled = true;
	        doQuery('/resource/compack_packtoolPack.do');
	        document.getElementById('btnSave').disabled=true; 
	  		document.getElementById('btnQuery').disabled=true; 
	  		document.getElementById('btnBack').disabled=true; 
        }
        
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="compack_confirmResource.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//����Ŀؼ���Action�ṩ���ݣ�������ҳ%>
    
<s:hidden name="param._pageno"/>
<s:hidden name="filepath"></s:hidden>
<s:hidden name="paramMap.comcategory"/>


	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<span class="table_toparea_h"><s:text name="title_pack"/></span>
			
		</div>
	</div>
    
    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>

<aa:zone name="listZone">
    <div class="table_div">
    	
                   
            <s:iterator id="tt" value="dp.datas">
	            <table class="table_style">
	            	<tr class="table_style_head">
				    <td align="left"  colspan='<s:property value="#tt.numberTypeInfo.size+1"/>'>
	                   <j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory"/> ÿ���׿��������ף�<s:property value="packSize"/>     
	                </td>
				    </tr>
				    <tr class="table_style_head">
				    <td></td>
				    <s:iterator value="numberTypeInfo">
				    <td><j:code2Name definition="#Numtypedef" code="type"/></td>
				    </s:iterator>
				    </tr>
				    <tr class="table_style_content" align="center">
				    <td>���ͷֲ�</td>
				     <s:iterator value="numberTypeInfo">
				    <td><s:property value="quantity"/></td>
				    </s:iterator>
				    </tr>
					<tr class="table_style_content" align="center">
					<td>Ĭ�ϱ���</td>
					<s:iterator value="numberTypeInfo">
				    <td><s:property value="scale"/></td>
				    </s:iterator>
					</tr>
					<tr class="table_style_content" align="center">
					<td>���������</td>
					<s:iterator value="numberTypeInfo">
				    <td ><s:property value="adjustScale"/> </td>
				    </s:iterator>
					</tr>
				</table>

             </s:iterator>
        
    </div>
</aa:zone>

<div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                   	<input type="button" id="btnSave" name="btnNext" class="button4" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="��һ��" onclick="doQuery('/resource/compack_packToolConfirm.do')" />
                    <input type="button" id="btnQuery" name="btnQuery" class="button4" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="��ʼ���" onclick="doPack()" />
                    <input type="button" id="btnBack" name="btnQuery" class="button4" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="����" onclick="doQuery('/resource/compack_goUploadresource.do')"  />
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
<%
if(request.getSession().getAttribute("PACKINFO") != null){
 %>
 <script type="text/javascript">
	document.getElementById('btnQuery').disabled = true;
   	document.getElementById('btnSave').disabled=true; 
	document.getElementById('btnBack').disabled=true; 
</script>
<iframe src="<%=contextPath%>/resource/compack/packstate.jsp" frameborder="0" class="loadframe" id="loadframe" scrolling="no" >
<%
}
 %>

</div>


<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"");
</script> 
</body>
</html>
