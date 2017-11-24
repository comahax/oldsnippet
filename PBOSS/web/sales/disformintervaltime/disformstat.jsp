<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript" src="<%= contextPath %>/js/cookies.js"></script>
    <script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		addfield('param._se_countyid', '<s:text name="countyid"/>', 'c', true, '14');
		addfield('param._se_mareacode', '<s:text name="mareacode"/>', 'c', true, '14');
		addfield('param._ne_starlevel', '<s:text name="starlevel"/>', 'f', true, '2');
		addfield('param._dnl_createtime', '<s:text name="_dnl_createtime"/>', 'dt', false, '8');
        addfield('param._dnm_createtime', '<s:text name="_dnm_createtime"/>', 'dt', false, '8');
		return (checkval(window) && compareDate());
	}
	
	function compareDate(){
        var dnmCreatetime = document.getElementById('param._dnm_createtime').value;
        var dnlCreatetime = document.getElementById('param._dnl_createtime').value;
        	
        if(dnmCreatetime != '' && dnlCreatetime != '' && dnlCreatetime > dnmCreatetime){
	        var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnl_createtime"/> ]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnm_createtime"/>]</span>';
			errorMessageShow(alertstr);
			return false;
        }
        return true;
    }
	
	function putCountyID(countyid){
	     document.getElementById('countyid').value=countyid;
	     document.getElementById('mareacode').value="";
	}
	
	function opendMareacode(aObj,formWhere){
		 var countyid = document.getElementById('countyid').value;
		 if(countyid == ''){
		    openPicker(aObj,formWhere);
		 }else{
		    openPicker(aObj,formWhere,null,'boss.cms.microarea.queryBycountyid','COUNTYID:'+countyid);
		 }
	}
	
	function openPicker(control,definition,condition) {
        	if(control.name.indexOf('param._se_mareacode') > -1 ) {
                if(document.all('param._se_countyid').value == "") {
                	// 选择“微区域编码”前要先指定 “分公司”  这是一个跨级的查询
                    alert("请先输入分公司");
                    return;
                }else {
                    // 查询指定 “分公司”下的“微区域编码”
                    //condition = '_se_countyid:' + document.all('param._se_countyid').value;
                    condition = '';
                }
                
            }
            
            if(definition == null || definition =="") {	  	    			
    	   		alert("definition is required!");
    	   		return ;
    	    }
    	    
    	    definition = window.encodeURIComponent(definition);	    
    	    var url = contextPath +"/common/picker_list.do?definition=" + definition;
    	    
    	    // 对微区域查询时使用命名查询
    	    if (control.name.indexOf('param._se_mareacode') > -1) {
    	    
	    	    var sqlName = window.encodeURIComponent("boss.cms.microarea.queryBycountyid");
	    	    var url = url + "&sqlName=" + sqlName;
	    	    
	    	    // 查询参数使用分公司ID
	    	    var mapParam = window.encodeURIComponent("COUNTYID:" + document.all('param._se_countyid').value);
	    	    var url = url + "&mapParam=" + mapParam;
    	    }

    	    if(condition!=null) {
    	    	condition = window.encodeURIComponent(condition);
    	    	url = url +"&condition=" + condition;
    	    }
    	    
    	    url = url +"&" + new Date();
			//alert(url);
    		var rtn = window.showModalDialog(url, control, "dialogWidth:750px; dialogHeight:550px; status:no;resizable:no;");
    		
    		if( rtn == null) 
    			return false;
    			
    		var buttonID = control.name;		
    		if(buttonID == null || buttonID == "") {
    			alert("Must set the name property for this selector control!");
    			return false;
    		} 
    			
    		var selectorID = buttonID.substring(0, buttonID.indexOf("_button"));
    		var selectorTextID = selectorID + "_text";
    		
    		var codeCtrl = document.getElementById( selectorID );
    		var nameCtrl = document.getElementById( selectorTextID ); 
    		 
    		if(codeCtrl!=null) {
    			codeCtrl.value = rtn[0];
    			codeCtrl.focus();
    			}		
    		if(nameCtrl!=null) nameCtrl.value = rtn[1];
        }	
        
        function doExport(){         	
         	formList.action="<%=contextPath%>/sales/disformintervaltime_exceldisformstat.do";
	        formList.submit();
	        formList.action="<%=contextPath%>/sales/disformintervaltime_disformstat.do";
        }  
        
        function setlocationSpec (myid,myname,mylocation,mytarget) {
			var menuchildrenLen = top.mainmenu.menu.children.length;
			for (var m=0;m<menuchildrenLen;m++){
				if(top.mainmenu.menu.children[m].innerText.indexOf(myid)>0){
					top.mainmenu.menu.children[m].ondblclick();
					break;
				}
			}
			if (top.mainmenu.nowmenuNum <= top.mainmenu.menuNum) {
				addmylimenu(myid,myname,mylocation);
			}else{
				addmylimenu(myid,myname,mylocation);
			}
			if (mytarget!=null) {
				mytarget.location.href=mylocation;
				if(menuchildrenLen==10){
					for (var m=0;m<menuchildrenLen;m++){
						if(top.mainmenu.menu.children[m].className == "menu_f"){
							top.mainmenu.menu.children[m].innerText=myname;
							break;
						}
					}
				}
			}
			mystr = myid+"|"+myname + "|" + mylocation;
			getcookie();
			getar();
			setar (mystr);
			setcookie();				
		}
</script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="disformintervaltime_disformstat.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
	<aa:zone name="hiddenZone">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" id ="countyid" value='<s:property value="param._se_countyid"/>'/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
	</aa:zone>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea">配送单管理</span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h">配送单超时预警统计查询</span>
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
				<td align="right"><s:text name="_dnl_createtime" />:</td>
				<td align="left">
					<s:textfield cssStyle="style_input" name="param._dnl_createtime" onclick="selectDatetime();" readonly="true" />
					<font color="red">*</font>
				</td>
				<td align="right"><s:text name="_dnm_createtime" />:</td>
				<td align="left">
					<s:textfield cssStyle="style_input" name="param._dnm_createtime" onclick="selectDatetime();" readonly="true" />
					<font color="red">*</font>
				</td>
			</tr>
            <tr>
                <td align="right"><s:text name="countyid"/>:</td>
                <td align="left">
                    <j:selector definition="#CNTYCOMPANY"  condition="citycompid:${USER.cityid}" name="param._se_countyid" mode="selector" onchange="putCountyID(this.value);"/>
                </td>
                <td align="right"><s:text name="mareacode"/>:</td>
                <td align="left">
                    <s:textfield styleId="order_list_do_param__se_mareacode_text" name="param._se_mareacode" id="mareacode" readonly="true"/>
						<INPUT class="picker_button" onclick="javascript:opendMareacode(this,'#MICROAREA'); " type="button" value="..." name="param._se_mareacode_button"/> 
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="starlevel"/>:</td>
                <td align="left">
                    <j:selector definition="$CH_STARLEVEL" name="param._ne_starlevel"/>
                </td>
                <td>&nbsp;</td><td>&nbsp;</td>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/disformintervaltime_disformstat.do');">
                        
                    <input type="button" id="btnExport" name="btnExport" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_exportexcel"/>" onClick="doExport()">                    
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
               	<s:i18n name="public"></s:i18n>
                <td>
                    <s:text name="countyid"/>               
                </td>
                <td>
                    <s:text name="mareacode"/>                 
                </td>
                <td>
                    <s:text name="starlevel"/>                 
                </td>
                <td>订单总数</td>
                <td>超时订单数</td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
                     <td>
                     	<a href="javascript:setlocationSpec('SM3008','配送单超时明细','/sales/vorderdisdetail_list.do?param._dnl_createtime=<s:property value="param._dnl_createtime"/>&param._dnm_createtime=<s:property value="param._dnm_createtime"/>&param._se_countyid=<s:property value="countyid"/>&param._se_mareacode=<s:property value="mareacode"/>&param._ne_starlevel=<s:property value="starlevel"/>',window.top.maintop)">
							<j:code2Name definition="#CNTYCOMPANY" code="countyid"/>
						</a>               
                     </td>
                     <td><j:code2Name definition="#MICROAREA" code="mareacode"/></td>
                     <td><j:code2Name definition="$CH_STARLEVEL" code="starlevel"/></td>
                     <td><s:property value="totalorder" /></td>
                     <td><s:property value="totalovertime" /></td>
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
