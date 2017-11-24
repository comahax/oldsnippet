<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>

<html>
<head>
    <title><s:text name="titleList"/></title>

    <script language="JavaScript" type="text/JavaScript">
	    var checkFlag = true;//是否检查编辑值的标识,点修改时不需要检查
	    var process;  //处理
        function ev_check() {
			if(!checkFlag){
	            addfield('form.processid', '<s:text name="processid"/>', 'f', false, '14');
	            addfield('form.dismode', '<s:text name="dismode"/>', 'c', false, '16');
	            addfield('form.instate', '<s:text name="instate"/>', 'c', true, '16');
	            addfield('form.outstate', '<s:text name="outstate"/>', 'c', false, '16');       
	            return checkval(window);     
           }else if("doUpdate" == process){
           	checkFlag = false;
           	return checkUpdate();
           }
        }
       
       
       function doSave(cmd){
       checkFlag = false;       

      	var flowid = document.getElementById('form.flowid').value;
      	if( null == flowid || '' == flowid){
      		 	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>流程不存在(请先添加流程)</span> ';
				errorMessageShow(alertstr);
      		return false;
      	}
       	return doQuery(cmd);
       } 
       
       
       function goNew(cmd){
       	document.getElementById('contentForm').style.display="";//显示编辑框
       	document.getElementById('CMD').value="NEW";
       	formList.action = contextPath + cmd;
       }
       
       
       function doUpdate(cmd){
	       process = "doUpdate";
	       checkFlag = true;    
	       if(!checkUpdate())   
	       return false;	      	
	  		formList.action = contextPath + cmd;

	       	document.getElementById('contentForm').style.display="";//显示编辑框
       }
       
       function checkUpdate(){
       var recid;//选中的订单步骤编号
       var count = 0;//选中项计数
       	var sis = document.getElementsByName("param._selectitem");
           for (var i = 0; i < sis.length; i++) {
               var e = sis[i];
               if (e.type == 'checkbox') {
                   if (e.checked){
                       	recid = e.value;
                       	document.getElementById('param._pk').value=recid;
                       	count++;
                       	if(count>1)
                       	{
                       		var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>修改只能选择一项</span> ';
							errorMessageShow(alertstr);
                       		return false;
                       	}
                    }
               }
           }
           if(count<1){
           var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>请选择修改项(只能一项)</span> ';
			errorMessageShow(alertstr);
			document.getElementById('contentForm').style.display="none";//
			return false;
		}
		return true;
       }
       
       
       
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container" >

<s:form action="orderproce_listByFlow.do" cssStyle="formList" key="formList"
			method="post" theme="simple" onsubmit="return ev_check();">
	<s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._ne_flowid"/>
    <s:hidden name="param._ne_processid"/>
    <s:hidden name="param._se_dismode"/>
    <s:hidden name="param._se_instate"/>
    <s:hidden name="param._se_outstate"/>
    <s:hidden name="form.flowid"/>
    <s:hidden name="param._pk"/>
   
	
	<div class="table_top">
		<div class="table_topleft"></div> 
		<div class="table_toparea_w">
			<span class="table_toparea_h"><s:text name="titleList"/></span>
			
			<s:if test="param._ne_flowid == null || param._ne_flowid == ''">
			</s:if>
			<s:else>
			<s:i18n name="public">
                	<input type="button" id="btnUpdate" name="btnUpdate" class="button_Query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="修改" onClick="doUpdate('/sales/orderproce_editInFlow.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="goNew('/sales/orderproce_newInFlow.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/sales/orderproce_deleteInFlow.do')">
              </s:i18n>
            </s:else>
		</div>
	</div>

	<aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>
	
	
    	
    <div class="table_div" id="contentForm" style="display:none" >  
    
    <aa:zone name="contentZone">
     <s:hidden name="form.recid"/>     
        <table class="table_normal">
            <tr>
                <td align="right"><s:text name="processid"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<j:selector definition="#FX_RU_PROCESS" condition="cityid:${USER.cityid}" name="form.processid"/>
				</s:if>
				<s:else>
					<j:selector definition="#FX_RU_PROCESS" condition="cityid:${USER.cityid}" name="form.processid" disabled="true"/>
				</s:else>
				<font color="red">*</font>
                </td>
                <td align="right"><s:text name="dismode"/>:&nbsp</td>
                <td align="left">
                 <s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$FX_PRODISMODE" name="form.dismode"/>
				</s:if>
				<s:else>	
					<j:selector definition="$FX_PRODISMODE" name="form.dismode" disabled="true"/>
				</s:else>	<font color="red">*</font>
						<s:i18n name="public">
	                  		<input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
	                         onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                         value="<s:text name="button_save"/>" onclick="doSave('/sales/orderproce_saveInFlow.do')"
	                         <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>/>
	                     </s:i18n>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="instate"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$FX_ORDERFSTATE" name="form.instate" />
				</s:if>
				<s:else>
					<j:selector definition="$FX_ORDERFSTATE" name="form.instate" disabled="true"/>
				</s:else>
				
                </td>
                <td align="right"><s:text name="outstate"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$FX_ORDERFSTATE" name="form.outstate"/>
				</s:if>
				<s:else>
					<j:selector definition="$FX_ORDERFSTATE" name="form.outstate" disabled="true"/>
				</s:else>	
				<font color="red">*</font>	
                </td>
            </tr>
        </table>  
        </aa:zone>      
    </div>

   

	<aa:zone name="listZone">
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style">
            <tr class="table_style_head">
               	<s:i18n name="public">
                <td title="<s:text name="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();"/>
                </td>
                </s:i18n>
               
                <td>
                    <a href="javascript:doOrderby('processid')"><s:text name="processid"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('processid')">步骤名称</a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('dismode')"><s:text name="dismode"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('instate')"><s:text name="instate"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('outstate')"><s:text name="outstate"/></a>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="recid"/>" onclick="checkOne();">
                     </td>
                    
                     <td><s:property value="processid" /></td>
                     <td><j:code2Name definition="#FX_RU_PROCESS" code="processid"/></td>
                     <td><j:code2Name definition="$FX_PRODISMODE" code="dismode"/></td>
                     <td><j:code2Name definition="$FX_ORDERFSTATE" code="instate"/></td>
                     <td><j:code2Name definition="$FX_ORDERFSTATE" code="outstate"/></td>
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
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		if("btnDelete" == submitButton.name){
			return "errorZone,listZone";  
		}else if("btnUpdate" == submitButton.name){
			return "errorZone,contentZone";
		}else if("btnNew" == submitButton.name){
			return "errorZone,contentZone";
		}else{
			return "errorZone";
		}	
		
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnNew,btnUpdate,btnDelete");
</script> 
</body>
</html>
