<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="j" uri="/jop-tags"%>

<%@ page  import="com.sunrise.jop.infrastructure.db.DataPackage"%>
<!-- 告警指标需要选择多项指标,原picker.jsp无法实现,故加此告警指标专用picker -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <%@ include file="/inc/listhead.inc" %>
		<title>数据查询</title>
		<script language="JavaScript" type="text/JavaScript">  
    	function selectCode(obj,acode,name) {
    		var a1 = document.getElementById("choosedCode");
    		var a2 = document.getElementById("choosedName");
    		var listTB = document.getElementById("querylist");
    		var codechdv = a1.value;
    		if(obj == 'null' && acode == ""){
    			a1.value = "";
    			a2.value = "";
    			var allChbs = listTB.getElementsByTagName("INPUT");
    			for(var i = 0; i < allChbs.length; i++){
        			if(allChbs[i].type == "checkbox"){
    					allChbs[i].checked = false;
        			}
        		} 
        	}else if(obj.checked){
				if(!contains(codechdv, acode)){
					var cs = a1.value;
					var ns = a2.value;
					var split1 = (cs.lastIndexOf(",")  == cs.length - 1) ? "": ",";
					var split2 = (ns.lastIndexOf(",")  == ns.length - 1) ? "": ",";
					a1.value += split1 + acode; 
					a2.value += split2 + name;
				}        		

        	}else{
				if(contains(codechdv, acode)){
					if(contains(codechdv , acode +",")){
						acode = acode + ",";
						name = name + ",";
					}
					a1.value = a1.value.replace(acode,"");
					a2.value = a2.value.replace(name,"");
				}
            }    		

    	}
    	
    	function contains(codechdv, acode){
	         var searchPar = new RegExp(acode,"gmi");
			 return  searchPar.test(codechdv);
        }
        
    	//最终返回指标,多项,以","分隔
    	function selectedCode(acode,name){
    	    var a = new Array(2);
    	    a[0] =document.getElementById("choosedCode").value; 
    	    a[1] =document.getElementById("choosedName").value;
           // alert("a="+a[0]);
    	    if(a[0].lastIndexOf(",") == (a[0].length - 1)) {
    	    	a[0] =  a[0].substring(0,a[0].length - 1);
    	    	// alert("b="+a[0]);
    	    }
    	    if(a[1].lastIndexOf(",") == (a[1].length - 1)) {
    	    	a[0] =  a[1].substring(0,a[1].length - 1);
    	    }
    		window.returnValue = a;
			window.close();
        }
        function selectAll(){
            var a = new Array(2);
	    	a[0] ="*,";	
			a[1] ="全部";
	        window.returnValue = a;
			window.close();
	    }

        function queryIdx(){
         var fm = document.forms.formList;
		var qCode = fm.code.value;
		var qName = fm.name.value;
		var tbd = document.getElementById("querylist");		
		var oRows = tbd.rows;	
		var date1 = new Date();	
		for(var i = 0; i < oRows.length ; i ++){
			
			var oTr = oRows[i];
			var id = oTr.id.split("|");
			
			if((trim(qCode) == "" || contains(id[0], qCode)) && (trim(qName) == "" || contains(id[1], qName))){
				oTr.style.display = "";
			}else{
				oTr.style.display = "none";
			}
		}
		var date2 = new Date();
		alert(date2 - date1);
		
        }
        
        function cleardata(){
        	document.all("code").value = "";
        }
    </script>
    <base target="_self" /> 
	</head>
	<body onload="cleardata();" style="overflow: hidden;">
	 	<div class="widgetL">
        <div class="wCenter"> 
        <div class="content">
        <aa:zone name="listZone"> 
		<s:form key="formList" cssStyle="formList" action="morecheck_list.do" theme="simple">
			<s:hidden name="param._orderby" />
			<s:hidden name="param._desc" />
			<s:hidden name="param._pageno"/>
			<s:hidden name="param._pagesize"/>
			<s:hidden name="param._queryexpress" />
			<s:hidden name="definition" key="definition" />
			<s:hidden name="condition" key="condition" />
			<s:hidden name="first" value="true" />
			<input type="hidden" id="checkvalue" />
			<input type="hidden" name="_rowcount"
				value="<s:property value="dp.rowCount" />" />

			<table class="error_text" width="100%">
				<s:property value="resultmsg" escape="false" />
			</table>
			
					<div class="search2">
						 <div class="title_name">
						 	<s:text name="数据查询" />
						 </div>
						
						<table width="100%" border="0" cellspacing="0" cellpadding="0" id="Table3">
							
							<tr>
								<th align="left">编码:</th>
								<td>
									<s:hidden name="code" />
									<s:textfield name="queryCode"/>
								</td>
								<th align="left">名称:</th>
								<td>
									<s:hidden name="name" />
									<s:textfield name="queryName"/>
								</td>
								
								<td align=right>
									&nbsp;
									<s:i18n name="public">
										<input type="button" class="query" id="btn_query"
											value="<s:text name="button_search"/>" onclick="doQuery()" />
									</s:i18n>
								</td>
							</tr>
						</table>
					</div>
			
					<div class="list_table"  style="width:100%;OVERFLOW-Y:HIDDEN">
					<table width="100%" border="0" cellspacing="0" cellpadding="0" ID="Table2">
						<thead>
						<tr>
							<s:if test="condition!='idxitemid:CM'">
								<td align="center"></td>
							</s:if>
								<td align="center">
									编码
								</td>
								<td align="center">
									名称
								</td>
							<s:if test="condition=='idxitemid:CM'">
								<td align="center"></td>
							</s:if>
						</tr>
						</thead>
						<tbody id="querylist">
							<tr class="trbg_2" align="center" onmouseover="this.className='trbg_1';" onmouseout="this.className='trbg_2';" align="center">
									<s:if test="condition!='idxitemid:CM'">
										<td align="center">
											<a href="javascript:selectCode('null' ,'' ,'');"> 空值 </a>
										</td>
									</s:if>
									<td align="center">
										<a href="javascript:selectCode( 'null', '' ,'');"> 空值 </a>
									</td>
									<td align="center">
										<a href="javascript:selectCode( 'null', '' ,'');"> 空值 </a>
									</td>
								<s:if test="condition=='idxitemid:CM'"><td align="center"></td></s:if>
							</tr>
							<s:iterator value="dp.datas">
								<s:if test="#count.odd">
									<tr class="" align="center" onmouseover="this.className='trbg_1';" onmouseout="this.className=''" align="center" id="<s:property value="code" />|<s:property value="name" />">
										<s:if test="condition!='idxitemid:CM'">
											<td align="center">
												<input type="checkbox" name="chbcodes" style="border:0;" onclick="javascript:selectCode(this,'<s:property value="code"/>','<s:property value="name"/>');"/>
											</td>
										</s:if>
											<td align="center">
												<s:property value="code" />
											</td>
											<td align="center">
												<s:property value="name" />
											</td>
										<s:if test="condition=='idxitemid:CM'">
											<td align="center">
												<input type="checkbox" name="chbcodes" style="border:0;" onclick="javascript:selectCode(this,'<s:property value="code"/>','<s:property value="name"/>');"/>
											</td>
										</s:if>
									</tr>
								</s:if>
								<s:else>
									<tr class="trbg_2" align="center" onmouseover="this.className='trbg_1';" onmouseout="this.className='trbg_2';" align="center" id="<s:property value="code" />|<s:property value="name" />">
										<s:if test="condition!='idxitemid:CM'">
											<td align="center">
												<input type="checkbox" id="<s:property value="code" />" name="chbcodes" style="border:0;" onclick="javascript:selectCode(this,'<s:property value="code"/>','<s:property value="name"/>');"/>
											</td>
										</s:if>
											<td align="center">
												<s:property value="code" />
											</td>
											<td align="center">
												<s:property value="name" />
											</td>
										<s:if test="condition=='idxitemid:CM'">
											<td align="center">
												<input type="checkbox" name="chbcodes" style="border:0;" onclick="javascript:selectCode(this,'<s:property value="code"/>','<s:property value="name"/>');"/>
											</td>
										</s:if>
									</tr>
								</s:else>
							</s:iterator>
						</tbody>
					</table>
				</div>
				<table width="100%"  border="0" cellspacing="5" cellpadding="0">
					<tr>
						<td align="right" colspan="4">
					    	<%@ include file="/common/pageNav.jsp"%>
					    </td>
					</tr>
			    </table>
			    <div class="search2">
				<table width="100%"  border="0" cellspacing="5" cellpadding="0">
						<tr>	
							<th valign="top" style="width:10%" align="left"><s:hidden name="choosedCode" />
								已选:
							</th>
							<td colspan="2" align="left" style="width:70%;">
								<s:textarea name="choosedName" cssClass="textbox" cssStyle="width:260px;height:50px;"  readonly="true"></s:textarea>
							</td>
							<td style="text-align:right;width: 15%;" align="right">
								<input type="button" class="query"
								value="全选" onclick="selectAll();" />
							</td>
							<td style="text-align:right;width: 15%;" align="right">
								<input type="button" class="query"
								value="<s:text name="button_confirm"/>" onclick="selectedCode();" />
							</td>
						</tr>
				</table>
				</div>
		</s:form>
		</aa:zone>
		
		
		</div>
		</div>
		</div>
		
		<script language="javascript">
			var codestr="<s:property value='choosedCode' />";
			var codeary=codestr.split(',');
			for(var i=0;i<codeary.length;i++){
				if(document.getElementById(codeary[i])!=null){
					document.getElementById(codeary[i]).checked=true;
				}
			}
			//ajaxAnywhere.getZonesToReload = function(url,submitButton) {
				//url=url+"?d="+new Date();
				//判断逻辑,根据按钮，和url来判断要刷新哪个zone
				//return "listZone";  //返回zon id。
			//};
		</script>   
		<script language="javascript">
			/*设置表单提交通过ajax进行*/
			//ajaxAnywhere.substituteFormSubmitFunction();  
		
			/*控制那些按钮需要使用ajax效果,传按钮ID */
			//ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btn_query");
		</script>

	
	</body>
</html>
