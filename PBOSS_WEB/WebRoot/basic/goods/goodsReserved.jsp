<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- 公共CSS文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
<c:set var="allCarGoods" value ="${carGoods}"/>
<c:set var="allCarStats" value ="${carStats}"/>
<c:set var="fmtNumber" value ="#0.##"/>
</head>
<body>
	<!-- 头部导航条 -->
	<%@ include file="/common/include/inc_head.jsp"%>
	<div class="divspan">
			<!--标准内容开始-->
			<!-- 公共用户资料 -->
			<%@ include file="/common/include/inc_menu.jsp"%>
		<div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">您现在的位置：</span><span class="font_breadcrumb">${location}</span>
			</div>
		<c:if test="${!canOrder}"><br><font color="red">尊敬的客户，您不能发起订购，原因是：${message}</font></c:if>
            <div class="listboxlist">
                    <!-- 用户基本信息 Begin-->
                    <c:if test="${bookBasicInfo.activeInfos !=null && isActivationInfoShow}">
                    <div class="listboxtitle">激活率信息：</div>
                    <table class="tb_comn" width="100%">
                        <thead>
                            <tr>
                                 <td>品牌</td>
                                 <td>激活率</td>
                                 <td>是否达标</td>
                                 <td>达标差距</td>
                            </tr>
                        </thead>
                        <tbody>					
                        <c:forEach items="${bookBasicInfo.activeInfos }" var="activeInfo" varStatus="i">
                            <tr>
                                <td class="red_01">${activeInfo.brandName}</td>
                                <td class="red_01"><fmt:formatNumber value='${activeInfo.actRate*100}' pattern='${fmtNumber}'/>% </td>
                                <td class="red_01"> <c:out value="${activeInfo.fulfilStandard?'是':'否'}"/> </td>
                                <td class="red_01" >${activeInfo.filStandardGap}套</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    </c:if>
                    <c:if test="${bookBasicInfo.bookInfos !=null}">
                    <div class="listboxtitle">商品订购信息 订购单位：套</div>
                    <table class = "tb_comn" width="100%">
                        <thead>
                            <tr>
                                 <td>品牌</td>
                                 <td>本月可订购量</td>
                                 <td>本月已订购量</td>
                                 <td>本月剩余订购量</td>
                                 <td>当天可订购量</td>
                                 <td>当天已订购量</td>
                                 <td>当天剩余订购量</td>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${bookBasicInfo.bookInfos }" var="dtlBookInfo" varStatus="i">
                            <tr>
                                <td class="red_01">${dtlBookInfo.brandName}</td>
                                <td class="red_01"> ${dtlBookInfo.canBookNonceMonth}套 </td>
                                <td class="red_01"> ${dtlBookInfo.bookedNonceMonth}套</td>
                                <td class="red_01" >${dtlBookInfo.surBookNonceMonth}套 </td>
                                <td class="red_01"> ${dtlBookInfo.canBookToday}套 </td>
                                <td class="red_01"> ${dtlBookInfo.bookedToday}套</td>
                                <td class="red_01" >${dtlBookInfo.surBookToday}套 </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    </c:if>
                    <c:if test="${bookBasicInfo.stockInfos !=null}">
                    <div class="listboxtitle">商品库存信息 订购单位：套</div>
                    <table class = "tb_comn" width="100%">
                        <thead>
                            <tr>
                                 <td>品牌</td>
                                 <td>在订库存量</td>
                                 <td>基准库存量</td>
                                 <td>当前库存量</td>
                                 <td>当前最大库存量</td>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${bookBasicInfo.stockInfos }" var="dtlstockInfo" varStatus="i">
                            <tr>
                                <td class="red_01">${dtlstockInfo.brandName}</td>
                                <td class="red_01">${dtlstockInfo.orderStock}</td>
                                <td class="red_01">${dtlstockInfo.basicStock}</td>
                                <td class="red_01">${dtlstockInfo.nonceStock}</td>
                                <td class="red_01">${dtlstockInfo.nonceMaxStock}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    </c:if>

                    <c:if test="${bookBasicInfo.stockAlarmInfos !=null}">
                    <div class="listboxtitle">商品库存信息 订购单位：套</div>
                    <table class = "tb_comn" width="100%">
                        <thead>
                            <tr>
                                 <td>品牌</td>
                                 <td>预警阀值</td>
                                 <td>在订库存</td>
                                 <td>最高库存</td>
                                 <td>当前库存</td>
                                 <td>最大订购量</td>
								 
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${bookBasicInfo.stockAlarmInfos }" var="dtlstockAlarmInfo" varStatus="i">
                            <tr>
                                <td class="red_01">${dtlstockAlarmInfo.brandName}</td>
                                <td class="red_01">${dtlstockAlarmInfo.alarmValue}</td>
                                <td class="red_01">${dtlstockAlarmInfo.orderStock}</td>
                                <td class="red_01">${dtlstockAlarmInfo.maxStock}</td>
                                <td class="red_01">${dtlstockAlarmInfo.nowstock}</td>
                                <td class="red_01">${dtlstockAlarmInfo.orderMax}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    </c:if>
                    
                    <c:if test="${bookBasicInfo.mondaystockInfos !=null}">
                    <div class="listboxtitle">商品订购信息 订购单位：套</div>
                    <table class = "tb_comn" width="100%">
                        <thead>
                            <tr>
                                 <td>品牌</td>
                                 <td>当月 可订购/已定购/剩余量</td>
                                 <td>当天 可订购/已定购/剩余量</td>
                                 <td>基准库存/实际库存</td>
                                 <td>最大订购量参考</td>
								 
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${bookBasicInfo.mondaystockInfos }" var="dtlmondaystockInfos" varStatus="i">
                            <tr>
                                <td class="red_01">${dtlmondaystockInfos.brandName}</td>
                                <td class="red_01">
                                	${dtlmondaystockInfos.canBookNonceMonth}/
                                	${dtlmondaystockInfos.bookedNonceMonth}/
                                	${dtlmondaystockInfos.surBookNonceMonth}
                                </td>
                                <td class="red_01">
                                	${dtlmondaystockInfos.canBookToday}/
                                	${dtlmondaystockInfos.bookedToday}/
                                	${dtlmondaystockInfos.surBookToday}
                                </td>
                                <td class="red_01">
                                	${dtlmondaystockInfos.basicStock}/
                                	${dtlmondaystockInfos.nonceStock}
                                </td>
                                <td class="red_01">${dtlmondaystockInfos.refMaxStock}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    </c:if>
                    
                    <c:if test="${fn:length(bookBasicInfo.comresscardOrderInfos)>0}">
                    <div class="listboxtitle">充值卡订购信息 订购单位：张</div>
                    <table class = "tb_comn" width="100%">
                        <thead>
                            <tr>
                                 <td>商品种类</td>
                                 <td>当月可订购量</td>
                                 <td>当月已订购量</td>
                                 <td>当月剩余订购量</td>
                                 <td>当日可订购量</td>
                                 <td>当日已订购量</td>
                                 <td>当日剩余订购量</td>
								 
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${bookBasicInfo.comresscardOrderInfos }" var="dtlComresscardOrderInfo" varStatus="i">
                            <tr>
                                <td class="red_01">${dtlComresscardOrderInfo.comcategory}</td>
                                <td class="red_01">${dtlComresscardOrderInfo.orderMaxMonth}</td>
                                <td class="red_01">${dtlComresscardOrderInfo.orderedMonth}</td>
                                <td class="red_01">${dtlComresscardOrderInfo.orderRemainMonth}</td>
                                <td class="red_01">${dtlComresscardOrderInfo.orderMaxDay}</td>
                                <td class="red_01">${dtlComresscardOrderInfo.orderedDay}</td>
                                <td class="red_01">${dtlComresscardOrderInfo.orderRemainDay}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    </c:if>
                    <!-- 用户基本信息 End-->
                    <!-- 商品查询   
					--><%--
    		 < c:if test="${canOrder}">  --%>        
               <form action="ajaxQuery.do" method="POST" id="frmQuery" onkeypress="if(event.keyCode=='13') return false;">
                    <div class="listboxtitle">商品搜索</div>
                    <table class = "tb02" width="100%">
                            <tr>
                                <td class="textRight" width="20%">商品类型：</td>
                                <td width="80%">
								<c:if test="${canOrder}">
								<s:select list="dictItem" cssClass="select_4L" name="param.comType" id="comType"/><span id="comTypeDscrp">（请选择商品类型!）</span>
								</c:if><c:if test="${!canOrder}">对不起，您不能发起订购！</c:if>
                              </td>
                            </tr>
                            <tr>
                                <td class="textRight">订购套数：</td>
                                <td >
                                    <input name="param.orderCount" id="orderCount" type="text" class="text_01" disabled>
                              </td>
                            </tr>
                            <tr>
                                <td class="textRight">
                                </td>
                                <td >
                                    <div id="queryDiv" style="display:${canQuery?'block':'none'}"><input type="button" class="btn_blue_75" id="btnQuery" value="查 询" disabled></div>
                                    <div id="addDiv" style="display:${!canQuery?'block':'none'}"><input type="button" class="btn_blue_75" id="btnAddToCar" value="添 加" disabled></div>
                              </td>
                            </tr>
                  </table>
                </form>
                <c:if test="${canQuery}">
                <div id="showTips" style="display:none">尊敬的用户，请在<SPAN class="font_orange">${bookBasicInfo.overTime}</SPAN>分钟内完成订购。</div>
                <div class="listboxtitle">资源明细</div>
                    <span id="showTbl"></span>
                    <table class="page_table">
                        <tr valign="middle">
                            <td align="left" height="30">&nbsp;&nbsp;</td>
                            <td align="right" style="font-size:12px;" id="navigation">&quot;</td>
                        </tr>
                    </table>
                </c:if><%--if test="${canQuery}">--%>
                    <!-- 我的购物篮 -->
                <div class="listboxtitle" id="shopping">我的购物车</div>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="54%" valign="top"><table class="tb_comn" width="100%">
                                    <thead>
                                        <tr>
                                          <td>卡类型</td>
                                          <td>包号</td>
                                          <td>订购套数</td>
                                          <td>操作</td>
                                        </tr>
                                    </thead>
                                    <tbody id="showGoodsDtls">
                                <c:if test="${allCarGoods!=null}"><c:forEach items="${allCarGoods}" var="dtlGoods" varStatus="i">
                                    <tr>
                                      <td id="showGdsType">${dtlGoods.type}</td>
                                      <td id="showGdsId"><a href="javascript:openDtl('${ctx}/goods/goodsDetail.do?carKey=${dtlGoods.key}');" >${dtlGoods.name}</a></td>
                                      <td id="showOrderCount">${dtlGoods.orderCount}</td>
                                      <td id="showGdsImg"><img src="/images/delete.jpg" alt="删除" onClick="doDel('${dtlGoods.key}','${dtlGoods.id}','${dtlGoods.name}')"></td>
                                    </tr>
                                    </c:forEach></c:if>
                                    </tbody>
                    </table></td>
                    <td valign="top" style="padding-left:5px;"><table class="tb_comn" width="100%" >
                                    <thead>
                                        <tr>
                                          <td >数据统计</td>
                                          <td ><input type="button" class="btn_blue" value="提交预定" onClick="doSumnit()" ${canOrder?"":"disabled"}></td>
                                        </tr>
                                    </thead>
                                    <tbody id="setGoodsStats">
                                <c:if test="${allCarStats!=null && fn:length(allCarStats)>0}">
                                <c:set var="allPackage" value ="0"/>
                                <c:set var="allDtlCnt" value ="0"/>
                                <c:forEach items="${allCarStats}" var="dtlStats" varStatus="i">
                                        <tr>
                                            <td class="textRight">${dtlStats.type}：</td><td><font class="red_01">${dtlStats.pckgCnt}</font>包（<font class="red_01">${dtlStats.dtlCnt}</font>套）</td>
                                        </tr>
                                <c:set var="allPackage" value ="${allPackage+dtlStats.pckgCnt}"/>
                                <c:set var="allDtlCnt" value ="${allDtlCnt+dtlStats.dtlCnt}"/>
                                  </c:forEach>
                                        <tr>
                                            <td class="textRight">您共选购了：</td><td><font class="red_01">${allPackage}</font>包（<font class="red_01">${allDtlCnt}</font>套）</td>
                                        </tr>
                                    </c:if>
                                    </tbody>
                    </table></td>
                  </tr>
              </table>
			  <%--
			  </c:if> if  test="${canOrder}
			  --%>
              
            </div>
		</div>
    </div>
	<!--标准内容结束-->
	<%@ include file="/common/include/inc_foot.jsp"%>
	<table style="display:none">
		<tbody id="setDtls" style="display:none">
			<tr>
			  <td id="showGdsType"></td>
			  <td id="showGdsId"></td>
			  <td id="showOrderCount"></td>
			  <td id="showGdsImg"><img src="/images/delete.jpg" alt="删除" onClick="doDel('$[key]','$[id]','$[packageNo]')"></td>
			</tr>
		</tbody>
	</table>
	<table style="display:none">
		<tbody id="setStatsData" style="display:none">
			<tr>
				<td id="showType"></td>
				<td id="showDesc"></td>
			</tr>
		</tbody>
	</table>
</body>
<!-- 公共JS文件 -->
<%@ include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/jQuery/validation/jquery.validation.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/basic/goods/begin.js"></script>
<SCRIPT LANGUAGE="JavaScript">
<!--
// 查询显示列信息 该页面要用Action请求，在Action中实现：JSONArray.fromObject(getsetCols()).toString();
var showCols = ${ShowCols};//取后台列设置类数组，对应如下  //dataKey,key,name,width
//设定查询参数
var optin = {
	showCols:showCols,//显示列
	fmtLink:fmtLink,//用户自定义单元格内容
	pageSize:${goodsResourseSize},//页内大小
	navigation:$("#navigation"),//翻页位置 jq对象
	unableBtu:$('#btnQuery'),
	width:"100%",
	keepShowData:true,//保留出错信息之前的数据
	queryFrom: $("#frmQuery")//查询表单
};
var isQuery = ${canQuery};
var canOrder = ${canOrder};

//页面变量设置
var errMSG = "${errMSG}";
//-->
//-->
</SCRIPT>
</html>