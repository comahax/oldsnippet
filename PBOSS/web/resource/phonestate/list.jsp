<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
     <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
     
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="phonestate_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check()">
	<%//����Ŀؼ���Action�ṩ���ݣ�������ҳ%>
	<aa:zone name="hiddenZone">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <s:hidden name="isQuery" value="true"></s:hidden>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
	</aa:zone>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea">��Դ����</span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
			 
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
             <td align="center"><s:text name="comresid"/>:</td>
             <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_comresid" /><font color="red">*</font>
             </td> 
              <td align="center"><s:text name="reswayid"/>:</td>
                <td align="left">
                	  <s:textfield cssStyle="style_input" name="param._se_reswayid" /><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_reswayid',null,null,'AG');this.value='...';" />
                </td>
            </tr>
            <tr>
               <td align="center"><s:text name="saletime"/>&gt;=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_saletime" onclick="selectDatetime();" readonly="true"/>
                </td>
                <td align="center"><s:text name="saletime"/>&lt;=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_saletime" onclick="selectDatetime();" readonly="true"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/resource/phonestate_list.do');"> 
                        
                    <input type="button" id="btnBatchQuery" name="btnBatchQuery" class="button_6" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_batchimportquery"/>" onClick="doBatch();"> 
                     
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
                <td>
                    <j:orderByImg href="javascript:doOrderby('comresid')"><s:text name="comresid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comstate')"><s:text name="comstate"/></j:orderByImg>                 
                </td> 
                <td>
                    <j:orderByImg href="javascript:doOrderby('isactive')"><s:text name="isactive"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('acttime')"><s:text name="acttime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('orderid')"><s:text name="orderid"/></j:orderByImg>                 
                </td>
                 <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
                  <td>
                    <j:orderByImg href="javascript:doOrderby('reswayid')"><s:text name="reswayid"/></j:orderByImg>                 
                </td>
                  <td>
                    <j:orderByImg href="javascript:doOrderby('saletime')"><s:text name="saletime"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
                      <td><s:property value="comresid"/></td>
                     <td><j:code2Name definition="$FX_COMSTATE" code="comstate"/></td> 
                     <td><j:code2Name definition="ISACHIEVE" code="isactive"/></td>
                     <td><s:date name="acttime" format="yyyy-MM-dd HH:mm:ss" /></td>
                     <td><s:property value="orderid" /></td>
                     <td><s:property value="wayid" /></td>
                     <td><s:property value="reswayid" /></td>
                     <td><s:date name="saletime" format="yyyy-MM-dd HH:mm:ss" /></td>
                 </tr>
             </s:iterator>
        </table>
        </div>
    </div>
    <div class="table_div">
		<%@ include file="/common/pageNav.jsp"%>
   	</div>
    </aa:zone>
</s:form>
</div>
</body>
</html>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();  
	ajaxAnywhere.formURL = formList.action;
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
<script language="JavaScript" type="text/JavaScript">  
      function ev_check() {
             addfield('param._se_comresid', '<s:text name="comresid"/>', 'l', false, '32');  
           return checkval(window);
        }
          function doBatch(){
        	formList.action= "<%=contextPath%>/resource/phonestate/batchimport.jsp";
        	formList.submit();
        }
</script>
