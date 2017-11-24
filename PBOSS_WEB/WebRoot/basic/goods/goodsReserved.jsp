<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ����CSS�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
<c:set var="allCarGoods" value ="${carGoods}"/>
<c:set var="allCarStats" value ="${carStats}"/>
<c:set var="fmtNumber" value ="#0.##"/>
</head>
<body>
	<!-- ͷ�������� -->
	<%@ include file="/common/include/inc_head.jsp"%>
	<div class="divspan">
			<!--��׼���ݿ�ʼ-->
			<!-- �����û����� -->
			<%@ include file="/common/include/inc_menu.jsp"%>
		<div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">�����ڵ�λ�ã�</span><span class="font_breadcrumb">${location}</span>
			</div>
		<c:if test="${!canOrder}"><br><font color="red">�𾴵Ŀͻ��������ܷ��𶩹���ԭ���ǣ�${message}</font></c:if>
            <div class="listboxlist">
                    <!-- �û�������Ϣ Begin-->
                    <c:if test="${bookBasicInfo.activeInfos !=null && isActivationInfoShow}">
                    <div class="listboxtitle">��������Ϣ��</div>
                    <table class="tb_comn" width="100%">
                        <thead>
                            <tr>
                                 <td>Ʒ��</td>
                                 <td>������</td>
                                 <td>�Ƿ���</td>
                                 <td>�����</td>
                            </tr>
                        </thead>
                        <tbody>					
                        <c:forEach items="${bookBasicInfo.activeInfos }" var="activeInfo" varStatus="i">
                            <tr>
                                <td class="red_01">${activeInfo.brandName}</td>
                                <td class="red_01"><fmt:formatNumber value='${activeInfo.actRate*100}' pattern='${fmtNumber}'/>% </td>
                                <td class="red_01"> <c:out value="${activeInfo.fulfilStandard?'��':'��'}"/> </td>
                                <td class="red_01" >${activeInfo.filStandardGap}��</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    </c:if>
                    <c:if test="${bookBasicInfo.bookInfos !=null}">
                    <div class="listboxtitle">��Ʒ������Ϣ ������λ����</div>
                    <table class = "tb_comn" width="100%">
                        <thead>
                            <tr>
                                 <td>Ʒ��</td>
                                 <td>���¿ɶ�����</td>
                                 <td>�����Ѷ�����</td>
                                 <td>����ʣ�ඩ����</td>
                                 <td>����ɶ�����</td>
                                 <td>�����Ѷ�����</td>
                                 <td>����ʣ�ඩ����</td>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${bookBasicInfo.bookInfos }" var="dtlBookInfo" varStatus="i">
                            <tr>
                                <td class="red_01">${dtlBookInfo.brandName}</td>
                                <td class="red_01"> ${dtlBookInfo.canBookNonceMonth}�� </td>
                                <td class="red_01"> ${dtlBookInfo.bookedNonceMonth}��</td>
                                <td class="red_01" >${dtlBookInfo.surBookNonceMonth}�� </td>
                                <td class="red_01"> ${dtlBookInfo.canBookToday}�� </td>
                                <td class="red_01"> ${dtlBookInfo.bookedToday}��</td>
                                <td class="red_01" >${dtlBookInfo.surBookToday}�� </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    </c:if>
                    <c:if test="${bookBasicInfo.stockInfos !=null}">
                    <div class="listboxtitle">��Ʒ�����Ϣ ������λ����</div>
                    <table class = "tb_comn" width="100%">
                        <thead>
                            <tr>
                                 <td>Ʒ��</td>
                                 <td>�ڶ������</td>
                                 <td>��׼�����</td>
                                 <td>��ǰ�����</td>
                                 <td>��ǰ�������</td>
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
                    <div class="listboxtitle">��Ʒ�����Ϣ ������λ����</div>
                    <table class = "tb_comn" width="100%">
                        <thead>
                            <tr>
                                 <td>Ʒ��</td>
                                 <td>Ԥ����ֵ</td>
                                 <td>�ڶ����</td>
                                 <td>��߿��</td>
                                 <td>��ǰ���</td>
                                 <td>��󶩹���</td>
								 
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
                    <div class="listboxtitle">��Ʒ������Ϣ ������λ����</div>
                    <table class = "tb_comn" width="100%">
                        <thead>
                            <tr>
                                 <td>Ʒ��</td>
                                 <td>���� �ɶ���/�Ѷ���/ʣ����</td>
                                 <td>���� �ɶ���/�Ѷ���/ʣ����</td>
                                 <td>��׼���/ʵ�ʿ��</td>
                                 <td>��󶩹����ο�</td>
								 
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
                    <div class="listboxtitle">��ֵ��������Ϣ ������λ����</div>
                    <table class = "tb_comn" width="100%">
                        <thead>
                            <tr>
                                 <td>��Ʒ����</td>
                                 <td>���¿ɶ�����</td>
                                 <td>�����Ѷ�����</td>
                                 <td>����ʣ�ඩ����</td>
                                 <td>���տɶ�����</td>
                                 <td>�����Ѷ�����</td>
                                 <td>����ʣ�ඩ����</td>
								 
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
                    <!-- �û�������Ϣ End-->
                    <!-- ��Ʒ��ѯ   
					--><%--
    		 < c:if test="${canOrder}">  --%>        
               <form action="ajaxQuery.do" method="POST" id="frmQuery" onkeypress="if(event.keyCode=='13') return false;">
                    <div class="listboxtitle">��Ʒ����</div>
                    <table class = "tb02" width="100%">
                            <tr>
                                <td class="textRight" width="20%">��Ʒ���ͣ�</td>
                                <td width="80%">
								<c:if test="${canOrder}">
								<s:select list="dictItem" cssClass="select_4L" name="param.comType" id="comType"/><span id="comTypeDscrp">����ѡ����Ʒ����!��</span>
								</c:if><c:if test="${!canOrder}">�Բ��������ܷ��𶩹���</c:if>
                              </td>
                            </tr>
                            <tr>
                                <td class="textRight">����������</td>
                                <td >
                                    <input name="param.orderCount" id="orderCount" type="text" class="text_01" disabled>
                              </td>
                            </tr>
                            <tr>
                                <td class="textRight">
                                </td>
                                <td >
                                    <div id="queryDiv" style="display:${canQuery?'block':'none'}"><input type="button" class="btn_blue_75" id="btnQuery" value="�� ѯ" disabled></div>
                                    <div id="addDiv" style="display:${!canQuery?'block':'none'}"><input type="button" class="btn_blue_75" id="btnAddToCar" value="�� ��" disabled></div>
                              </td>
                            </tr>
                  </table>
                </form>
                <c:if test="${canQuery}">
                <div id="showTips" style="display:none">�𾴵��û�������<SPAN class="font_orange">${bookBasicInfo.overTime}</SPAN>��������ɶ�����</div>
                <div class="listboxtitle">��Դ��ϸ</div>
                    <span id="showTbl"></span>
                    <table class="page_table">
                        <tr valign="middle">
                            <td align="left" height="30">&nbsp;&nbsp;</td>
                            <td align="right" style="font-size:12px;" id="navigation">&quot;</td>
                        </tr>
                    </table>
                </c:if><%--if test="${canQuery}">--%>
                    <!-- �ҵĹ����� -->
                <div class="listboxtitle" id="shopping">�ҵĹ��ﳵ</div>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="54%" valign="top"><table class="tb_comn" width="100%">
                                    <thead>
                                        <tr>
                                          <td>������</td>
                                          <td>����</td>
                                          <td>��������</td>
                                          <td>����</td>
                                        </tr>
                                    </thead>
                                    <tbody id="showGoodsDtls">
                                <c:if test="${allCarGoods!=null}"><c:forEach items="${allCarGoods}" var="dtlGoods" varStatus="i">
                                    <tr>
                                      <td id="showGdsType">${dtlGoods.type}</td>
                                      <td id="showGdsId"><a href="javascript:openDtl('${ctx}/goods/goodsDetail.do?carKey=${dtlGoods.key}');" >${dtlGoods.name}</a></td>
                                      <td id="showOrderCount">${dtlGoods.orderCount}</td>
                                      <td id="showGdsImg"><img src="/images/delete.jpg" alt="ɾ��" onClick="doDel('${dtlGoods.key}','${dtlGoods.id}','${dtlGoods.name}')"></td>
                                    </tr>
                                    </c:forEach></c:if>
                                    </tbody>
                    </table></td>
                    <td valign="top" style="padding-left:5px;"><table class="tb_comn" width="100%" >
                                    <thead>
                                        <tr>
                                          <td >����ͳ��</td>
                                          <td ><input type="button" class="btn_blue" value="�ύԤ��" onClick="doSumnit()" ${canOrder?"":"disabled"}></td>
                                        </tr>
                                    </thead>
                                    <tbody id="setGoodsStats">
                                <c:if test="${allCarStats!=null && fn:length(allCarStats)>0}">
                                <c:set var="allPackage" value ="0"/>
                                <c:set var="allDtlCnt" value ="0"/>
                                <c:forEach items="${allCarStats}" var="dtlStats" varStatus="i">
                                        <tr>
                                            <td class="textRight">${dtlStats.type}��</td><td><font class="red_01">${dtlStats.pckgCnt}</font>����<font class="red_01">${dtlStats.dtlCnt}</font>�ף�</td>
                                        </tr>
                                <c:set var="allPackage" value ="${allPackage+dtlStats.pckgCnt}"/>
                                <c:set var="allDtlCnt" value ="${allDtlCnt+dtlStats.dtlCnt}"/>
                                  </c:forEach>
                                        <tr>
                                            <td class="textRight">����ѡ���ˣ�</td><td><font class="red_01">${allPackage}</font>����<font class="red_01">${allDtlCnt}</font>�ף�</td>
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
	<!--��׼���ݽ���-->
	<%@ include file="/common/include/inc_foot.jsp"%>
	<table style="display:none">
		<tbody id="setDtls" style="display:none">
			<tr>
			  <td id="showGdsType"></td>
			  <td id="showGdsId"></td>
			  <td id="showOrderCount"></td>
			  <td id="showGdsImg"><img src="/images/delete.jpg" alt="ɾ��" onClick="doDel('$[key]','$[id]','$[packageNo]')"></td>
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
<!-- ����JS�ļ� -->
<%@ include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/jQuery/validation/jquery.validation.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/basic/goods/begin.js"></script>
<SCRIPT LANGUAGE="JavaScript">
<!--
// ��ѯ��ʾ����Ϣ ��ҳ��Ҫ��Action������Action��ʵ�֣�JSONArray.fromObject(getsetCols()).toString();
var showCols = ${ShowCols};//ȡ��̨�����������飬��Ӧ����  //dataKey,key,name,width
//�趨��ѯ����
var optin = {
	showCols:showCols,//��ʾ��
	fmtLink:fmtLink,//�û��Զ��嵥Ԫ������
	pageSize:${goodsResourseSize},//ҳ�ڴ�С
	navigation:$("#navigation"),//��ҳλ�� jq����
	unableBtu:$('#btnQuery'),
	width:"100%",
	keepShowData:true,//����������Ϣ֮ǰ������
	queryFrom: $("#frmQuery")//��ѯ��
};
var isQuery = ${canQuery};
var canOrder = ${canOrder};

//ҳ���������
var errMSG = "${errMSG}";
//-->
//-->
</SCRIPT>
</html>