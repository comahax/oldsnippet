<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>

 
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript"src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
    function doImport(){			
			formList.action = "<%=contextPath%>/channel/waystoreinfo/batchwaystoreinfo.jsp";
      		formList.submit();
		}

    function doImportPic(){			
		formList.action = "<%=contextPath%>/channel/waystoreinfo/batchwaystoreinfopic.jsp";
  		formList.submit();
	}
	
		function doExport(url){
			formList.action = contextPath + url + "?CMD=EXCEL";
  			formList.submit();
  			formList.action = contextPath + url + "?CMD=LIST";
		}
		
		</script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="waystoreinfo_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
	<aa:zone name="hiddenZone">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
     <s:hidden name="isQuery" value="true"></s:hidden>
     <s:hidden name="hasFlag"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
	</aa:zone>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
		               
		                <s:textfield cssStyle="style_input" name="param._sk_wayid" />
								  <input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._sk_wayid','','','AG','FDS|FD|VWAY|PSAL|SAGT|JMQD');this.value='...';" />
		            </td>
		            <td align="center"><s:text name="cityid"/>:</td>
		            	
					<s:if test="hasFlag =='true'">
		            <td align="left">
		            <j:selector definition="CITYNAME" name="param._se_cityid" />
		            </td>
		            </s:if>
		           	<s:else>
		            <td align="left">
		            <j:selector definition="#CITYCOMPANY" name="param._se_cityid"
									mode="selector" condition="citycompid:${dBAccessUser.cityid }"
									value="${dBAccessUser.cityid }" />
		            </td>
		            </s:else> 
		         </tr>
		         <tr>
		            <td align="center"><s:text name="zqtype"/>:</td>
		            <td align="left">
		            <j:selector definition="$CH_WAYSTORETYPE" name="param._ne_zqtype" />
		               
		            </td>
		            <td align="center"><s:text name="doortype"/>:</td>
		            <td align="left">
		            <j:selector definition="$CH_DOORTYPE" name="param._ne_doortype" />
		               
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/channel/waystoreinfo_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/channel/waystoreinfo_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/channel/waystoreinfo_delete.do')">
                        
                     <input type="button" id="btnBatch" name="btnBatch" class="button_4" onmouseover="buttonover(this);"
						onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
						 value="批量导入" onClick="doImport();">
						 
					 <input type="button" id="btnBatch" name="btnBatch" class="button_6" onmouseover="buttonover(this);"
						onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
						 value="批量导入照片" onClick="doImportPic();">
					
					<input type="button" id="btnExport" name="btnExport" class="button_4" onmouseover="buttonover(this);"
						onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" 
						value="<s:text name="button_exportexcel"/>" onClick="doExport('/channel/waystoreinfo_exportExcel.do')">
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
               	<s:i18n name="public">
                <td title="<s:text name="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();"/>
                </td>
                </s:i18n>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
                 <td>
                  门店编码名称                 
                </td>
                 <td>
                   地理经度               
                </td>
                 <td>
                  地理纬度                
                </td>
                 <td>
                    <j:orderByImg href="javascript:doOrderby('cityid')"><s:text name="cityid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('area')"><s:text name="area"/></j:orderByImg>                 
                </td>
               
                <td>
                    <j:orderByImg href="javascript:doOrderby('zqtype')"><s:text name="zqtype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('zqpic')"><s:text name="zqpic"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('zqarea')"><s:text name="zqarea"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('zqpanel')"><s:text name="zqpanel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('zqcupboard')"><s:text name="zqcupboard"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('zqcards')"><s:text name="zqcards"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('zqpricetag')"><s:text name="zqpricetag"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('zqrack')"><s:text name="zqrack"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('zqinad')"><s:text name="zqinad"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('zqoutad')"><s:text name="zqoutad"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('zqhead')"><s:text name="zqhead"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('zqpaste')"><s:text name="zqpaste"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('zqtablecard')"><s:text name="zqtablecard"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('zqdecca')"><s:text name="zqdecca"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('zqbill')"><s:text name="zqbill"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('doorpic')"><s:text name="doorpic"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('doortype')"><s:text name="doortype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('outwallad')"><s:text name="outwallad"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('outwallpic')"><s:text name="outwallpic"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('tdmonopoly')"><s:text name="tdmonopoly"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('busimonopoly')"><s:text name="busimonopoly"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('storeconduct')"><s:text name="storeconduct"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('modulus')"><s:text name="modulus"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('createtime')"><s:text name="createtime"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="wayid"/>" onclick="checkOne();">
                     </td>
                     <td> 	
                     <s:if test="hasFlag == 'true'">
							<s:property value="wayid"/>
                      </s:if>
                      <s:else> 
                         <a href='<s:url action="waystoreinfo_edit.do">
	                         <s:param name="param._pk" value="wayid"/>
	                     	</s:url>'>
							<s:property value="wayid"/>
                         </a>
                      </s:else>
					 </td>
					 <td><s:property value="wayname" /></td> 
					 <td><s:property value="longtitude" /></td>
					 <td><s:property value="latitude" /></td>
					 <td><j:code2Name code="cityid" definition="#CITYCOMPANY" /></td> 
                     <td><s:property value="area" /></td> 
                     <td> <j:code2Name code="zqtype" definition="$CH_WAYSTORETYPE" /></td>
                     <td>
                       <a href='<%=contextPath%>/channel/waystoreinfo/waystoreinfo_download.do?file=<s:property value="zqpicpath" />'> 
                       <s:property value="zqpic" />
                       </a></td>
                     <td><s:property value="zqarea" /></td>
                     <td> <j:code2Name code="zqpanel" definition="$CH_YESORNO1" /></td>
                     <td><s:property value="zqcupboard" /></td>
                     <td><s:property value="zqcards" /></td>
                     <td><s:property value="zqpricetag" /></td>
                     <td><s:property value="zqrack" /></td>
                     <td><j:code2Name code="zqinad" definition="$CH_YESORNO1" /></td>
                     <td><j:code2Name code="zqoutad" definition="$CH_YESORNO1" /></td>
                     <td><j:code2Name code="zqhead" definition="$CH_YESORNO1" /></td>
                     <td><j:code2Name code="zqpaste" definition="$CH_YESORNO1" /></td>
                     <td><s:property value="zqtablecard" /></td>
                     <td><s:property value="zqdecca" /></td>
                     <td><s:property value="zqbill" /></td>
                     <td>
                       <a href='<%=contextPath%>/channel/waystoreinfo/waystoreinfo_download.do?file=<s:property value="doorpicpath" />'> 
                       <s:property value="doorpic" />
                       </a></td>
                     <td><j:code2Name code="doortype" definition="$CH_DOORTYPE" /></td>
                     <td><s:property value="outwallad" /></td>
                     <td><s:property value="outwallpic" /></td>
                     <td>  <j:code2Name code="tdmonopoly" definition="$CH_YESORNO2" /></td>
                     <td>  <j:code2Name code="busimonopoly" definition="$CH_YESORNO2" /></td>
                     <td><s:property value="storeconduct" /></td>
                     <td><s:property value="modulus" /></td>
                     <td> <s:date name="createtime" format="yyyy-MM-dd" /></td>
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
		return checkval(window);
	}
</script>
