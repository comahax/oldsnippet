<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>

<html>
	<head>
		<title><bean:message bundle="orderdetailquery" key="orderdetailquerytitle" /></title>
		<script language="JavaScript" type="text/JavaScript">
        function checkProcess(){
			var filename = formItem.filename.value;
			if(filename != null || filename != ""){
        		formItem.buttonProcess.disabled=true;
    			window.location.href="<%=contextPath%>/cms/way/process.do?CMD=BATCH&filename="+filename+"&beanname=com.sunrise.boss.ui.cms.way.BatchWayTaskBean";
    		}
		}
        function getpath(){
    		var url = formList.file.value;
    		document.getElementById("savePath").value = url.substr(0,url.lastIndexOf("\\")+1);
    	}
    	function doReturn(cmdReturn) {
    	formItem.action = contextPath + cmdReturn;
    	formItem.submit();
		}
    </script>
		<script type="text/javascript" src="<%= contextPath %>/js/bus/waycommon.js"></script>
	</head>

	<body  onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/way/upload.do?CMD=UPLOAD" enctype="multipart/form-data" styleId="formItem">

				<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td width="210" class="AreaName" align="left" valign=middle>
								渠道资料管理批量导入
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="error_text" width="100%">
						<html:errors />
						<s:Msg />
					</table>
				</div>
				<div class="table_div">
					<table class="form_table">
					    <tr>
							<td width="126" height="20" align="right" class="form_table_right">
								<bean:message bundle="batchimportorder" key="selectfile" />
								:
							</td>
							<td class="form_table_left">
								<input type="file" class="form_input_files" name="theFile" ID="File1" />
							</td>
						</tr>
						<c:choose>
							<c:when test="${!empty requestScope.ITEM.inFile}">
								<tr class="table_style_content">
									<td align=right height=25>
										<bean:message bundle="upload" key="existfile" />
									</td>
									<td align=left>
										<a href='<%=contextPath%>/commons/batch/download.jsp?filename=<c:out
						value="${requestScope.ITEM.inFile}" />'> <c:out value="${requestScope.ITEM.fileName}" /> </a>
									</td>
								</tr>
							</c:when>
						</c:choose>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="upload" key="filetype" />
							</td>
							<td align=left>
								<bean:message bundle="upload" key="typevalue" />
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="upload" key="filestyle" />
							</td>
							<td align=left>
								<p><font color=red>渠道编码|渠道名称|上级渠道|</font>营业点标识|<font color=red>是否共享|渠道类别|</font>渠道子类别|</p>
								<p>分公司自定义渠道类别管理|城市级别|渠道等级|</p>
								<p>渠道MIS编码|物业来源分类|是否联网|联网方式|经营模式|是否中心渠道|星级|排他性|</p>
								<p>连锁总店编码|签约状态|营业人员数量|管理人员数量|终端数量|<font color=red>纬度|经度|渠道状态|</font></p>
								<p>渠道中间代码|<font color=red>自营标志</font></p>
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="upload" key="example" />
							</td>
							<td align=left>
								<font color=red> JMTEST|江门移动|JFJMAA00|002|0|AV|AVAG|0|1|2|002|0|1|1|0|1|2|2|123|1|10|8|12|23.234534|121.334261|1|20|FZY </font>
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="svwayinfoms" key="exinfos" />
							</td>
							<td align=left>
								<p>是否共享:0,否1,是; 渠道类别:AV,增值合作渠道;RIVL,竞争对手渠道;SA,直销渠道; </p> 
								<p>AG,社会渠道;渠道子类别:TEMI 终端厂家; IT厂家 ITF; ECF 电子充值券经销商</p>
								<p>,AVAG 增值代理商;VTAG 虚拟运营商  </P>
								<p>RVOW 竞争对手自营渠道;RVST 竞争对手社会渠道 </p> 
								<p>SMAG 销售经理;CMAG 客户经理</p> 
								<p>分公司自定义渠道类别管理:0,其他;11,热线前台                                            </p> 
								<p>城市级别:1,直辖市;2,副省级;3,地级市;4,县级市;99,其他;-1,退回;                          </p> 
								<p>渠道等级:1,A级;2,B级;3,C级;99,其他                                                     </p> 
								<p>物业来源分类:0,租赁;1,存续企业购建;2,上市公司购建;3,社会物业（他建）                   </p> 
								<p>是否联网:0,联网;非联网,1  联网方式:0,光缆;1,2M电缆;2,GPRS;3,CSD;4,拨号上网;5,无线网桥  </p> 
								<p>经营模式:0,自建自营;1,自建他营;2,他建他营  是否中心渠道:0,否;1,是                     </p> 
								<p>星级:0,未定星级;1,一星级;2,二星级;3,三星级;4,四星级;5,五星级;6,六星级;                 </p> 
								<p>排他性:-1,双排他;1,非排他;0,单排他;  签约状态:0,正常;1,预解约;2,注销;                  </p> 
								<p>渠道状态:1,生效,0,无效; 自营标志:FZY,非自营;ZY,自营                           </p> 

							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="svwayinfoms" key="redirect" />
							</td>
							<td align=left>
								<a href="<%=contextPath %>/cms/common/importguide.htm">填写指南</a>
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="svwayinfoms" key="excelexample" />
							</td>
							<td align=left>
								<a href="<%= contextPath %>/cms/way/waybatch.xls">渠道资料管理批量导入模板.xls</a>&nbsp;&nbsp;
								<bean:message bundle="svwayinfoms" key="excelinfo" />
							</td>
						</tr>
						
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>

							<input type="submit" value="<bean:message bundle="upload" key="upload" />" class="comfir"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonUpload" NAME="buttonUpload">

							<input type="button" value="<bean:message bundle="upload" key="process"/>" class="button_4"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonProcess" NAME="buttonProcess" onClick="checkProcess()" />
								
							<input type="button" value="返回" class="button_4"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonProcess" NAME="buttonProcess" onClick="doReturn('/cms/way.do?CMD=LIST')" />
							</td>
						</tr>
					</table>
				</div>
			</html:form>
			<iframe src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.way.BatchWayTaskBean" 
			frameborder="0" class="loadframe" id="loadframe" scrolling="no">
			</iframe>
		</div>
	</body>
</html>
