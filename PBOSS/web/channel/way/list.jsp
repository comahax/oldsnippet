<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<style type="text/css">
   a:link,a:visited{text-decoration:none;}
</style>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, '18');
            addfield('param._se_wayname', '<s:text name="wayname"/>', 'c', true, '256');
            addfield('param._se_waytype', '<s:text name="waytype"/>', 'c', true, '4');
            addfield('param._ne_waystate', '<s:text name="waystate"/>', 'f', true, '3');
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="way_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//????????????Action?��????????????��???%>
    <aa:zone name="hiddenZone"><s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/></aa:zone>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="wayinfomanage"/></span>
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
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_wayid" />
                </td>
                <td align="center"><s:text name="wayname"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_wayname" />
                </td>
                <td align="center"><s:text name="waytype"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_waytype" />
                </td>
                <td align="center"><s:text name="waystate"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_waystate" />
                </td>
            </tr>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr> 
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
	                    <td align=right>
	                    	<s:i18n name="public">
	                    	<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="<s:text name="button_search"/>" onClick="doQuery('/channel/way_list.do');">
	                    	
	                        <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="<s:text name="button_new"/>" onClick="doNew('/channel/way_new.do')">
	                        
	                        <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="<s:text name="button_delete"/>" onClick="doDelete('/channel/way_delete.do')">
	                       </s:i18n>
	                    </td>
	                    </tr>
					</table>
				</td>
			</tr>
		</table>
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
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('shortname')"><s:text name="shortname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('svbrchcode')"><s:text name="svbrchcode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('svccode')"><s:text name="svccode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('mareacode')"><s:text name="mareacode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('buztypecode')"><s:text name="buztypecode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('adtypecode')"><s:text name="adtypecode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('address')"><s:text name="address"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('logiscode')"><s:text name="logiscode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('latitude')"><s:text name="latitude"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('longtitude')"><s:text name="longtitude"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('adacode')"><s:text name="adacode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('waymagcode')"><s:text name="waymagcode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('catetype')"><s:text name="catetype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('formtype')"><s:text name="formtype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('starttime')"><s:text name="starttime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('buzarea')"><s:text name="buzarea"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('mainlayer')"><s:text name="mainlayer"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('sublayer')"><s:text name="sublayer"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('buzphoneno')"><s:text name="buzphoneno"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayname')"><s:text name="wayname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('cooperator')"><s:text name="cooperator"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('waytype')"><s:text name="waytype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('waysubtype')"><s:text name="waysubtype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('custtype')"><s:text name="custtype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('upperwayid')"><s:text name="upperwayid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('busicode')"><s:text name="busicode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('countyid')"><s:text name="countyid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('cityid')"><s:text name="cityid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('centerid')"><s:text name="centerid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('citylevel')"><s:text name="citylevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('waylevel')"><s:text name="waylevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('bchlevel')"><s:text name="bchlevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('function')"><s:text name="function"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('miscode')"><s:text name="miscode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('createtime')"><s:text name="createtime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('disabletime')"><s:text name="disabletime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('waystate')"><s:text name="waystate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('runbyself')"><s:text name="runbyself"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('depotdet')"><s:text name="depotdet"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('isshare')"><s:text name="isshare"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('alarmbizamount')"><s:text name="alarmbizamount"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('prtsource')"><s:text name="prtsource"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('isconnected')"><s:text name="isconnected"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('connecttype')"><s:text name="connecttype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('runmode')"><s:text name="runmode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('iscoreway')"><s:text name="iscoreway"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('starlevel')"><s:text name="starlevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('pt')"><s:text name="pt"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('chainhead')"><s:text name="chainhead"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('signstatus')"><s:text name="signstatus"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('empnumber')"><s:text name="empnumber"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('magnumber')"><s:text name="magnumber"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('terminumber')"><s:text name="terminumber"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('updatedate')"><s:text name="updatedate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('isstraitprd')"><s:text name="isstraitprd"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('taxtype')"><s:text name="taxtype"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- ?????��?��???��|?��?????? --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="wayid"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="way_edit.do">
	                         <s:param name="param._pk" value="wayid"/>
	                     	</s:url>'>
							<s:property value="wayid"/>
                         </a>
					 </td>
                     <td><s:property value="shortname" /></td>
                     <td><s:property value="svbrchcode" /></td>
                     <td><s:property value="svccode" /></td>
                     <td><s:property value="mareacode" /></td>
                     <td><s:property value="buztypecode" /></td>
                     <td><s:property value="adtypecode" /></td>
                     <td><span STYLE="overflow:hidden; text-overflow:ellipsis; white-space:nowrap;width:300px" title="<s:property value="address" />"/>
                     		<s:property value="address" />
                     	</span></td>
                     <td><s:property value="logiscode" /></td>
                     <td><s:property value="latitude" /></td>
                     <td><s:property value="longtitude" /></td>
                     <td><s:property value="adacode" /></td>
                     <td><s:property value="waymagcode" /></td>
                     <td><s:property value="catetype" /></td>
                     <td><s:property value="formtype" /></td>
                     <td><s:property value="starttime" /></td>
                     <td><s:property value="buzarea" /></td>
                     <td><s:property value="mainlayer" /></td>
                     <td><s:property value="sublayer" /></td>
                     <td><s:property value="buzphoneno" /></td>
                     <td><s:property value="wayname" /></td>
                     <td><s:property value="cooperator" /></td>
                     <td><s:property value="waytype" /></td>
                     <td><s:property value="waysubtype" /></td>
                     <td><s:property value="custtype" /></td>
                     <td><s:property value="upperwayid" /></td>
                     <td><s:property value="busicode" /></td>
                     <td><s:property value="countyid" /></td>
                     <td><s:property value="cityid" /></td>
                     <td><s:property value="centerid" /></td>
                     <td><s:property value="citylevel" /></td>
                     <td><s:property value="waylevel" /></td>
                     <td><s:property value="bchlevel" /></td>
                     <td><s:property value="function" /></td>
                     <td><s:property value="miscode" /></td>
                     <td><s:property value="createtime" /></td>
                     <td><s:property value="disabletime" /></td>
                     <td><s:property value="waystate" /></td>
                     <td><s:property value="runbyself" /></td>
                     <td><s:property value="depotdet" /></td>
                     <td><s:property value="isshare" /></td>
                     <td><s:property value="alarmbizamount" /></td>
                     <td><s:property value="prtsource" /></td>
                     <td><s:property value="isconnected" /></td>
                     <td><s:property value="connecttype" /></td>
                     <td><s:property value="runmode" /></td>
                     <td><s:property value="iscoreway" /></td>
                     <td><s:property value="starlevel" /></td>
                     <td><s:property value="pt" /></td>
                     <td><s:property value="chainhead" /></td>
                     <td><s:property value="signstatus" /></td>
                     <td><s:property value="empnumber" /></td>
                     <td><s:property value="magnumber" /></td>
                     <td><s:property value="terminumber" /></td>
                     <td><s:property value="updatedate" /></td>
                     <td><s:property value="isstraitprd" /></td>
                     <td><s:property value="taxtype" /></td>
                     <td>
                     </td>
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
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
</div>
</body>
</html>
