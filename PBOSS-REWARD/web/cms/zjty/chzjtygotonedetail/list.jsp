<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title>全球通基础酬金明细</title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_rewardreporttime', '月份', 'c', false, '14');
            return checkval(window);
        }
        
        function doExport(url){
			formList.action = contextPath + url + "?CMD=EXCEL";
  			formList.submit();
  			formList.action="<%=contextPath%>/cms/zjty/chzjtygotonedetail.do?CMD=LIST";
		}
		
		function doDele(url) {
			ev_check();
			var month = document.getElementById("_se_rewardreporttime").value;
			var msg = "确定要删除" + month + "月的记录吗？"
			if (!confirm(msg)) {
				return false;
			}
			formList.action = contextPath + url + "?CMD=DELETE";
  			formList.submit();
  			formList.action="<%=contextPath%>/cms/zjty/chzjtygotonedetail.do?CMD=LIST";
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/zjty/chzjtygotonedetail.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize" value="20"/>
    <input type="hidden" name="query" value="true">
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/chzjtygotonedetail/ChzjtygotonedetailForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>全球通基础酬金明细</td>
    	</tr>
    </table>
    </div>
    <div class="table_div">	
   		 <table width="100%" class="error_text">
    		<html:errors/><s:Msg />
    	</table>
    </div>
	<div class="table_div">
        <table class="form_table">
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" >月份:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_rewardreporttime" styleId="_se_rewardreporttime" onclick="WdatePicker({dateFmt:'yyyyMM', maxDate:'%y {%M}'})"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><c:if test="${protoken}">地市:</c:if></td>
                <td width="30%" class="form_table_left">
                    <c:if test="${protoken}">
                    	<html:select property="_sk_city">
							<s:Options definition="#CITYNAME_ZH_CN"/>
						</html:select>
                    </c:if>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                    <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_search"/>" />
                    <input type="button" class="button_4" onmouseover="buttonover(this);" 
            			onclick="doExport('/cms/zjty/chzjtygotonedetail.do')" 
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_export_excel"/>" />
                    <c:if test="${!protoken}">
                    <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_delete"/>"
                        onClick="doDele('/cms/zjty/chzjtygotonedetail.do')">
                    </c:if>
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
	    		<td colspan="4">一、基础信息</td>
				<td colspan="79">二、业务量信息（月度）</td>
				<td colspan="8">三、单位酬金</td>
				<td colspan="79">四、酬金总额</td>
				<td colspan="4">五、考核系数</td>
				<td rowspan="3">全省统一基础酬金总额</td>
	    	</tr>
	    	<tr class="table_style_head">
	    		<td rowspan="2">合作商</td>
				<td rowspan="2">地市</td>
				<td rowspan="2">营业厅名称</td>
				<td rowspan="2">月份</td>
				<td colspan="13">（1）不选或选58商旅套餐、58上网套餐</td>
				<td colspan="13">（2）选88商旅套餐或88上网套餐</td>
				<td colspan="13">（3）选128商旅套餐或128上网套餐</td>
				<td colspan="13">（4）158商旅套餐</td>
				<td colspan="13">（5）选188商旅套餐</td>
				<td colspan="13">（6）选288、388、588、888商旅套餐</td>
				<td rowspan="2">(7)预付费转全球通</td>
				<td>不选或选58、88、128、158、188、288、388、588、888商旅套餐；选58、88、128上网套餐</td>
				<td colspan="6">激励奖金标准为客户无欠费情况下连续 12 个月套餐费用的 10% （上限按照 268 元套餐封顶）</td>
				<td rowspan="2">（7）预付费转全球通</td>
				<td colspan="13">（1）不选或选58商旅套餐、58上网套餐</td>
				<td colspan="13">（2）选88商旅套餐或88上网套餐</td>
				<td colspan="13">（3）选128商旅套餐或128上网套餐</td>
				<td colspan="13">（4）158商旅套餐</td>
				<td colspan="13">（5）选188商旅套餐</td>
				<td colspan="13">（6）选288、388、588、888商旅套餐</td>
				<td rowspan="2">（7）预付费转全球通</td>
				<td colspan="4">考核系数</td>
	    	</tr>
	        <tr class="table_style_head">
				<td>开户酬金</td>
				<td>激励酬金1</td>
				<td>激励酬金2</td>
				<td>激励酬金3</td>
				<td>激励酬金4</td>
				<td>激励酬金5</td>
				<td>激励酬金6</td>
				<td>激励酬金7</td>
				<td>激励酬金8</td>
				<td>激励酬金9</td>
				<td>激励酬金10</td>
				<td>激励酬金11</td>
				<td>激励酬金12</td>
				<td>开户酬金</td>
				<td>激励酬金1</td>
				<td>激励酬金2</td>
				<td>激励酬金3</td>
				<td>激励酬金4</td>
				<td>激励酬金5</td>
				<td>激励酬金6</td>
				<td>激励酬金7</td>
				<td>激励酬金8</td>
				<td>激励酬金9</td>
				<td>激励酬金10</td>
				<td>激励酬金11</td>
				<td>激励酬金12</td>
				<td>开户酬金</td>
				<td>激励酬金1</td>
				<td>激励酬金2</td>
				<td>激励酬金3</td>
				<td>激励酬金4</td>
				<td>激励酬金5</td>
				<td>激励酬金6</td>
				<td>激励酬金7</td>
				<td>激励酬金8</td>
				<td>激励酬金9</td>
				<td>激励酬金10</td>
				<td>激励酬金11</td>
				<td>激励酬金12</td>
				<td>开户酬金</td>
				<td>激励酬金1</td>
				<td>激励酬金2</td>
				<td>激励酬金3</td>
				<td>激励酬金4</td>
				<td>激励酬金5</td>
				<td>激励酬金6</td>
				<td>激励酬金7</td>
				<td>激励酬金8</td>
				<td>激励酬金9</td>
				<td>激励酬金10</td>
				<td>激励酬金11</td>
				<td>激励酬金12</td>
				<td>开户酬金</td>
				<td>激励酬金1</td>
				<td>激励酬金2</td>
				<td>激励酬金3</td>
				<td>激励酬金4</td>
				<td>激励酬金5</td>
				<td>激励酬金6</td>
				<td>激励酬金7</td>
				<td>激励酬金8</td>
				<td>激励酬金9</td>
				<td>激励酬金10</td>
				<td>激励酬金11</td>
				<td>激励酬金12</td>
				<td>开户酬金</td>
				<td>激励酬金1</td>
				<td>激励酬金2</td>
				<td>激励酬金3</td>
				<td>激励酬金4</td>
				<td>激励酬金5</td>
				<td>激励酬金6</td>
				<td>激励酬金7</td>
				<td>激励酬金8</td>
				<td>激励酬金9</td>
				<td>激励酬金10</td>
				<td>激励酬金11</td>
				<td>激励酬金12</td>
				<td>开户酬金</td>
				<td>不选或选58商旅套餐、58上网套餐</td>
				<td>选88商旅套餐或88上网套餐</td>
				<td>选128商旅套餐或128上网套餐</td>
				<td>158商旅套餐</td>
				<td>选188商旅套餐</td>
				<td>选288、388、588、888商旅套餐</td>
				<td>开户酬金</td>
				<td>激励酬金1</td>
				<td>激励酬金2</td>
				<td>激励酬金3</td>
				<td>激励酬金4</td>
				<td>激励酬金5</td>
				<td>激励酬金6</td>
				<td>激励酬金7</td>
				<td>激励酬金8</td>
				<td>激励酬金9</td>
				<td>激励酬金10</td>
				<td>激励酬金11</td>
				<td>激励酬金12</td>
				<td>开户酬金</td>
				<td>激励酬金1</td>
				<td>激励酬金2</td>
				<td>激励酬金3</td>
				<td>激励酬金4</td>
				<td>激励酬金5</td>
				<td>激励酬金6</td>
				<td>激励酬金7</td>
				<td>激励酬金8</td>
				<td>激励酬金9</td>
				<td>激励酬金10</td>
				<td>激励酬金11</td>
				<td>激励酬金12</td>
				<td>开户酬金</td>
				<td>激励酬金1</td>
				<td>激励酬金2</td>
				<td>激励酬金3</td>
				<td>激励酬金4</td>
				<td>激励酬金5</td>
				<td>激励酬金6</td>
				<td>激励酬金7</td>
				<td>激励酬金8</td>
				<td>激励酬金9</td>
				<td>激励酬金10</td>
				<td>激励酬金11</td>
				<td>激励酬金12</td>
				<td>开户酬金</td>
				<td>激励酬金1</td>
				<td>激励酬金2</td>
				<td>激励酬金3</td>
				<td>激励酬金4</td>
				<td>激励酬金5</td>
				<td>激励酬金6</td>
				<td>激励酬金7</td>
				<td>激励酬金8</td>
				<td>激励酬金9</td>
				<td>激励酬金10</td>
				<td>激励酬金11</td>
				<td>激励酬金12</td>
				<td>开户酬金</td>
				<td>激励酬金1</td>
				<td>激励酬金2</td>
				<td>激励酬金3</td>
				<td>激励酬金4</td>
				<td>激励酬金5</td>
				<td>激励酬金6</td>
				<td>激励酬金7</td>
				<td>激励酬金8</td>
				<td>激励酬金9</td>
				<td>激励酬金10</td>
				<td>激励酬金11</td>
				<td>激励酬金12</td>
				<td>开户酬金</td>
				<td>激励酬金1</td>
				<td>激励酬金2</td>
				<td>激励酬金3</td>
				<td>激励酬金4</td>
				<td>激励酬金5</td>
				<td>激励酬金6</td>
				<td>激励酬金7</td>
				<td>激励酬金8</td>
				<td>激励酬金9</td>
				<td>激励酬金10</td>
				<td>激励酬金11</td>
				<td>激励酬金12</td>
				<td>管理考核系数</td>
				<td>否决系数</td>
				<td>综合排名系数</td>
				<td>竞标系数</td>
			</tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center">
                    <td><c:out value="${item.cooperauid}"/></td>
					<td><c:out value="${item.city}"/></td>
					<td><c:out value="${item.wayname}"/></td>
					<td><c:out value="${item.rewardreporttime}"/></td>
					<td><c:out value="${item.ywl58khcj}"/></td>
					<td><c:out value="${item.ywl58jlcj1}"/></td>
					<td><c:out value="${item.ywl58jlcj2}"/></td>
					<td><c:out value="${item.ywl58jlcj3}"/></td>
					<td><c:out value="${item.ywl58jlcj4}"/></td>
					<td><c:out value="${item.ywl58jlcj5}"/></td>
					<td><c:out value="${item.ywl58jlcj6}"/></td>
					<td><c:out value="${item.ywl58jlcj7}"/></td>
					<td><c:out value="${item.ywl58jlcj8}"/></td>
					<td><c:out value="${item.ywl58jlcj9}"/></td>
					<td><c:out value="${item.ywl58jlcj10}"/></td>
					<td><c:out value="${item.ywl58jlcj11}"/></td>
					<td><c:out value="${item.ywl58jlcj12}"/></td>
					<td><c:out value="${item.ywl88khcj}"/></td>
					<td><c:out value="${item.ywl88jlcj1}"/></td>
					<td><c:out value="${item.ywl88jlcj2}"/></td>
					<td><c:out value="${item.ywl88jlcj3}"/></td>
					<td><c:out value="${item.ywl88jlcj4}"/></td>
					<td><c:out value="${item.ywl88jlcj5}"/></td>
					<td><c:out value="${item.ywl88jlcj6}"/></td>
					<td><c:out value="${item.ywl88jlcj7}"/></td>
					<td><c:out value="${item.ywl88jlcj8}"/></td>
					<td><c:out value="${item.ywl88jlcj9}"/></td>
					<td><c:out value="${item.ywl88jlcj10}"/></td>
					<td><c:out value="${item.ywl88jlcj11}"/></td>
					<td><c:out value="${item.ywl88jlcj12}"/></td>
					<td><c:out value="${item.ywl128khcj}"/></td>
					<td><c:out value="${item.ywl128jlcj1}"/></td>
					<td><c:out value="${item.ywl128jlcj2}"/></td>
					<td><c:out value="${item.ywl128jlcj3}"/></td>
					<td><c:out value="${item.ywl128jlcj4}"/></td>
					<td><c:out value="${item.ywl128jlcj5}"/></td>
					<td><c:out value="${item.ywl128jlcj6}"/></td>
					<td><c:out value="${item.ywl128jlcj7}"/></td>
					<td><c:out value="${item.ywl128jlcj8}"/></td>
					<td><c:out value="${item.ywl128jlcj9}"/></td>
					<td><c:out value="${item.ywl128jlcj10}"/></td>
					<td><c:out value="${item.ywl128jlcj11}"/></td>
					<td><c:out value="${item.ywl128jlcj12}"/></td>
					<td><c:out value="${item.ywl158khcj}"/></td>
					<td><c:out value="${item.ywl158jlcj1}"/></td>
					<td><c:out value="${item.ywl158jlcj2}"/></td>
					<td><c:out value="${item.ywl158jlcj3}"/></td>
					<td><c:out value="${item.ywl158jlcj4}"/></td>
					<td><c:out value="${item.ywl158jlcj5}"/></td>
					<td><c:out value="${item.ywl158jlcj6}"/></td>
					<td><c:out value="${item.ywl158jlcj7}"/></td>
					<td><c:out value="${item.ywl158jlcj8}"/></td>
					<td><c:out value="${item.ywl158jlcj9}"/></td>
					<td><c:out value="${item.ywl158jlcj10}"/></td>
					<td><c:out value="${item.ywl158jlcj11}"/></td>
					<td><c:out value="${item.ywl158jlcj12}"/></td>
					<td><c:out value="${item.ywl188khcj}"/></td>
					<td><c:out value="${item.ywl188jlcj1}"/></td>
					<td><c:out value="${item.ywl188jlcj2}"/></td>
					<td><c:out value="${item.ywl188jlcj3}"/></td>
					<td><c:out value="${item.ywl188jlcj4}"/></td>
					<td><c:out value="${item.ywl188jlcj5}"/></td>
					<td><c:out value="${item.ywl188jlcj6}"/></td>
					<td><c:out value="${item.ywl188jlcj7}"/></td>
					<td><c:out value="${item.ywl188jlcj8}"/></td>
					<td><c:out value="${item.ywl188jlcj9}"/></td>
					<td><c:out value="${item.ywl188jlcj10}"/></td>
					<td><c:out value="${item.ywl188jlcj11}"/></td>
					<td><c:out value="${item.ywl188jlcj12}"/></td>
					<td><c:out value="${item.ywl288khcj}"/></td>
					<td><c:out value="${item.ywl288jlcj1}"/></td>
					<td><c:out value="${item.ywl288jlcj2}"/></td>
					<td><c:out value="${item.ywl288jlcj3}"/></td>
					<td><c:out value="${item.ywl288jlcj4}"/></td>
					<td><c:out value="${item.ywl288jlcj5}"/></td>
					<td><c:out value="${item.ywl288jlcj6}"/></td>
					<td><c:out value="${item.ywl288jlcj7}"/></td>
					<td><c:out value="${item.ywl288jlcj8}"/></td>
					<td><c:out value="${item.ywl288jlcj9}"/></td>
					<td><c:out value="${item.ywl288jlcj10}"/></td>
					<td><c:out value="${item.ywl288jlcj11}"/></td>
					<td><c:out value="${item.ywl288jlcj12}"/></td>
					<td><c:out value="${item.ywlmzonetogotone}"/></td>
					<td><c:out value="${item.dwkhcj}"/></td>
					<td><c:out value="${item.dw58cj}"/></td>
					<td><c:out value="${item.dw88cj}"/></td>
					<td><c:out value="${item.dw128cj}"/></td>
					<td><c:out value="${item.dw158cj}"/></td>
					<td><c:out value="${item.dw188cj}"/></td>
					<td><c:out value="${item.dw288cj}"/></td>
					<td><c:out value="${item.dwmzonetogotone}"/></td>
					<td><c:out value="${item.cjtotal58khcj}"/></td>
					<td><c:out value="${item.cjtotal58jlcj1}"/></td>
					<td><c:out value="${item.cjtotal58jlcj2}"/></td>
					<td><c:out value="${item.cjtotal58jlcj3}"/></td>
					<td><c:out value="${item.cjtotal58jlcj4}"/></td>
					<td><c:out value="${item.cjtotal58jlcj5}"/></td>
					<td><c:out value="${item.cjtotal58jlcj6}"/></td>
					<td><c:out value="${item.cjtotal58jlcj7}"/></td>
					<td><c:out value="${item.cjtotal58jlcj8}"/></td>
					<td><c:out value="${item.cjtotal58jlcj9}"/></td>
					<td><c:out value="${item.cjtotal58jlcj10}"/></td>
					<td><c:out value="${item.cjtotal58jlcj11}"/></td>
					<td><c:out value="${item.cjtotal58jlcj12}"/></td>
					<td><c:out value="${item.cjtotal88khcj}"/></td>
					<td><c:out value="${item.cjtotal88jlcj1}"/></td>
					<td><c:out value="${item.cjtotal88jlcj2}"/></td>
					<td><c:out value="${item.cjtotal88jlcj3}"/></td>
					<td><c:out value="${item.cjtotal88jlcj4}"/></td>
					<td><c:out value="${item.cjtotal88jlcj5}"/></td>
					<td><c:out value="${item.cjtotal88jlcj6}"/></td>
					<td><c:out value="${item.cjtotal88jlcj7}"/></td>
					<td><c:out value="${item.cjtotal88jlcj8}"/></td>
					<td><c:out value="${item.cjtotal88jlcj9}"/></td>
					<td><c:out value="${item.cjtotal88jlcj10}"/></td>
					<td><c:out value="${item.cjtotal88jlcj11}"/></td>
					<td><c:out value="${item.cjtotal88jlcj12}"/></td>
					<td><c:out value="${item.cjtotal128khcj}"/></td>
					<td><c:out value="${item.cjtotal128jlcj1}"/></td>
					<td><c:out value="${item.cjtotal128jlcj2}"/></td>
					<td><c:out value="${item.cjtotal128jlcj3}"/></td>
					<td><c:out value="${item.cjtotal128jlcj4}"/></td>
					<td><c:out value="${item.cjtotal128jlcj5}"/></td>
					<td><c:out value="${item.cjtotal128jlcj6}"/></td>
					<td><c:out value="${item.cjtotal128jlcj7}"/></td>
					<td><c:out value="${item.cjtotal128jlcj8}"/></td>
					<td><c:out value="${item.cjtotal128jlcj9}"/></td>
					<td><c:out value="${item.cjtotal128jlcj10}"/></td>
					<td><c:out value="${item.cjtotal128jlcj11}"/></td>
					<td><c:out value="${item.cjtotal128jlcj12}"/></td>
					<td><c:out value="${item.cjtotal158khcj}"/></td>
					<td><c:out value="${item.cjtotal158jlcj1}"/></td>
					<td><c:out value="${item.cjtotal158jlcj2}"/></td>
					<td><c:out value="${item.cjtotal158jlcj3}"/></td>
					<td><c:out value="${item.cjtotal158jlcj4}"/></td>
					<td><c:out value="${item.cjtotal158jlcj5}"/></td>
					<td><c:out value="${item.cjtotal158jlcj6}"/></td>
					<td><c:out value="${item.cjtotal158jlcj7}"/></td>
					<td><c:out value="${item.cjtotal158jlcj8}"/></td>
					<td><c:out value="${item.cjtotal158jlcj9}"/></td>
					<td><c:out value="${item.cjtotal158jlcj10}"/></td>
					<td><c:out value="${item.cjtotal158jlcj11}"/></td>
					<td><c:out value="${item.cjtotal158jlcj12}"/></td>
					<td><c:out value="${item.cjtotal188khcj}"/></td>
					<td><c:out value="${item.cjtotal188jlcj1}"/></td>
					<td><c:out value="${item.cjtotal188jlcj2}"/></td>
					<td><c:out value="${item.cjtotal188jlcj3}"/></td>
					<td><c:out value="${item.cjtotal188jlcj4}"/></td>
					<td><c:out value="${item.cjtotal188jlcj5}"/></td>
					<td><c:out value="${item.cjtotal188jlcj6}"/></td>
					<td><c:out value="${item.cjtotal188jlcj7}"/></td>
					<td><c:out value="${item.cjtotal188jlcj8}"/></td>
					<td><c:out value="${item.cjtotal188jlcj9}"/></td>
					<td><c:out value="${item.cjtotal188jlcj10}"/></td>
					<td><c:out value="${item.cjtotal188jlcj11}"/></td>
					<td><c:out value="${item.cjtotal188jlcj12}"/></td>
					<td><c:out value="${item.cjtotal288khcj}"/></td>
					<td><c:out value="${item.cjtotal288jlcj1}"/></td>
					<td><c:out value="${item.cjtotal288jlcj2}"/></td>
					<td><c:out value="${item.cjtotal288jlcj3}"/></td>
					<td><c:out value="${item.cjtotal288jlcj4}"/></td>
					<td><c:out value="${item.cjtotal288jlcj5}"/></td>
					<td><c:out value="${item.cjtotal288jlcj6}"/></td>
					<td><c:out value="${item.cjtotal288jlcj7}"/></td>
					<td><c:out value="${item.cjtotal288jlcj8}"/></td>
					<td><c:out value="${item.cjtotal288jlcj9}"/></td>
					<td><c:out value="${item.cjtotal288jlcj10}"/></td>
					<td><c:out value="${item.cjtotal288jlcj11}"/></td>
					<td><c:out value="${item.cjtotal288jlcj12}"/></td>
					<td><c:out value="${item.cjtotalmzonetogotone}"/></td>
					<td><c:out value="${item.manageexamine}"/></td>
					<td><c:out value="${item.vetocoefficient}"/></td>
					<td><c:out value="${item.ordercoefficient}"/></td>
					<td><c:out value="${item.campaigncoefficient}"/></td>
					<td><c:out value="${item.totalreward}"/></td>
                 </tr>
             </c:forEach>
        </table>
     </div>
   </div>

   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
</html:form>
</div>
</body>
</html>
