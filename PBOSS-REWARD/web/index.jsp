<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="com.sunrise.boss.ui.commons.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
String contextPath = request.getContextPath(); 
User user = (User)session.getAttribute("_USER");
%>
<html>
	<head>
		<title>index</title>
		<script>
		contextPath = "<%=contextPath%>/";
		</script>
		<link rel="stylesheet" href="css/dtree.css" type="text/css" />
		<script type="text/javascript" src="js/dtree.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK" />

		<style type="text/css">
<!--
.style1 {
	font-size: large;
	font-weight: bold;g
}
--> 
</style>
	</head> 
	<body style="margin:0px; padding:0px;">
		<table cellpadding=0 cellspacing=0 border=0 width=100% height=100%>
			<tr style="height:76px; width:100%;">
				<td colspan=2 style="border-bottom:#e3e3e3 solid 2px; background:url(images/Index_Middle.gif); padding-left:200px; padding-top:10px; font-size:14px;">
					BOSS2.0的系统管理与主页面柜架由华为做，所以暂以直接业务模块的连接做开发<br/><br/>
					<p style="color:#ffffff">工号：<%=user.getOpercode() %> 渠道：<%=user.getWayid() %> 市标识：<%=user.getCityid() %>
					<a href="admin/logincase.do?CMD=LIST">快速登录</a>
					</p>
				</td>
			</tr>
			<tr>
				<td width=195 style="border-right:#e3e3e3 solid 2px; font-size:12px; background:#FFFFFF; color:#000000;">
					BOSS2.0示例程序
					<br />
					<a style="color:#000;" href="<%= contextPath %>/example/example1.do">示例程序</a>&nbsp;
					<a style="color:#000;" href="<%= contextPath %>/example/example1.do?CMD=LISTNOCOUNT">不显示总页数</a>&nbsp; 
					<a style="color:#000;" href="http://10.200.26.36:9080/jmbboss/login.jsp?opercode=admin">报表模块 </a>
					<br />
					<div style="width:195px; height:484px; overflow:auto; background:#fff; border-top:#e3e3e3 solid 2px;">
						<script type="text/javascript">
          target = "mywin"
          //d.add('100', 10, '系统管理', '','',target); 
          d = new dTree('d');
          d.add('1', -1, '系统菜单', '');                      
          d.add('20', 1, '渠道管理', '');
          		d.add('200', 20, '渠道资料管理', '','',target);
          			d.add('20027', 200, '数据业务运营渠道', '','',target); 
	          			d.add('2002701', 20027, '省级渠道信息管理', 'cms/waypro.do?CMD=LIST','',target);
	                 	d.add('2002702', 20027, '推广专员信息管理', 'cms/wayproemployee.do?CMD=LIST','',target);
                 	d.add('20028', 200, '专员日志查询', 'cms/employeelogquery.do?CMD=LIST','',target);
                 	d.add('20029', 200, '专员操作二次确认参数管理', 'cms/chadtdictparam.do?CMD=LIST','',target);
				d.add('209', 20, '服务厅效益监控', '','',target);
             		d.add('20909', 209, '社会渠道套卡销售管理','cms/resale.do?CMD=SHOW','',target);
				    d.add('20910', 209, '社会渠道充值卡销售管理','cms/costcard.do?CMD=SHOW','',target);
					d.add('20911', 209, '社会渠道资源审核管理','cms/waitaudit.do?CMD=LIST','',target);
					d.add('20912', 209, 'IOD平台短信稽核明细查询','cms/iodaudit.do?CMD=SHOW','',target);
                    d.add('20913', 209, '采集平台短信稽核查询','cms/mpsaudit.do?CMD=LIST','',target);
                    d.add('20914', 209, '销售信息查询','cms/reward/registersimvw/frame.jsp','',target);
                    
                    d.add('20916', 209, '后台文件导出','cms/reward/backgroundfileexport/frame.jsp','',target);
               	d.add('215', 20, '社会渠道业务管理', '','',target);
               		d.add('21501', 215, '社会渠道全业务基本信息管理','','',target);
               			d.add('2150101', 21501, '全省统一业务管理','cms/operation.do?CMD=LIST','',target);
               			d.add('2150102', 21501, '全省统一业务分类树管理','cms/operation/tree/frame.jsp','',target);
               			d.add('2150103', 21501, '全省业务适用地市上架','cms/busicityload.do?CMD=SHOW','',target);
               		d.add('21502',215,'数据有效性管理','','',target);
               			d.add('2150201', 21502, '有效性规则管理','cms/reward/rule.do?CMD=LIST','',target);
               			d.add('2150202', 21502, '业务关联有效性规则查询','cms/reward/rule2.do?CMD=LIST','',target);
               			//d.add('2150203', 21502,'地市有效业务数据导入','cms/citydata/batchintask.do?CMD=Querydict','',target); 
               			d.add('2150204', 21502, '营销方案与全省统一业务关联设置','cms/reward/busyxplan.do?CMD=SHOW','',target);
               			d.add('2150205', 21502, '校验失败数据查询','cms/reward/faildataquery.do?CMD=SHOW','',target);
               			d.add('2150206', 21502, '业务与费项关联设置','cms/reward/cbopnacctmap.do?CMD=SHOW','',target);
               			d.add('2150207', 21502, '业务需计酬渠道设置','cms/reward/busiwayrel.do?CMD=LIST','',target);
               			d.add('2150208', 21502, '业务与商品资源关联设置','cms/reward/busitocom.do?CMD=LIST','',target);
               			d.add('2150209', 21502, '业务与套卡资源关联设置','cms/reward/busitosmp.do?CMD=LIST','',target);
               			d.add('2150210', 21502, '业务与审批编码关系查询','cms/chadtbusitoapprove.do?CMD=LIST','',target);
               		d.add('21503', 215, '酬金参数管理','','',target);
               			d.add('2150301', 21503, '酬金池规则管理','cms/rewardpoolr.do?CMD=SHOW','',target);
               			d.add('2150302', 21503, '星级酬金标准参数管理','cms/stdrewardbs.do?CMD=LIST','',target);
               			d.add('2150303', 21503, '星级评定效益监控','cms/reward/salecredit/frame.jsp','',target);
               			//d.add('2150303', 21503, '项目启动金标准参数管理','cms/stdrewardbp.do?CMD=SHOW','',target);
               			d.add('2150304', 21503, '合作年限奖标准设置','cms/stdrewardhz.do?CMD=LIST','',target);
               			d.add('2150305', 21503, '统一管理模式酬金标准设置','cms/reward/stdrewardut/frame.jsp','',target);
               			d.add('2150306', 21503, '放号质量价值激励酬金参数管理','cms/salereward.do?CMD=LIST','',target);
               			d.add('2150307', 21503, '渠道星级酬金标准导入','cms/waystrarewardstd.do?CMD=LIST','',target);
               			d.add('2150308', 21503, '市公司个性化参数名称管理','cms/chadtdictidname.do?CMD=VIEW','',target);
               			d.add('2150309', 21503, '商圈门店补贴参数管理','','',target);
               				d.add('215030901', 2150309, '商圈门店补贴调节系数设置','cms/chadtwaymod/list.jsp','',target);
               			
               		d.add('21504', 215, '酬金管理','','',target);
               			d.add('2150401', 21504, '酬金计算结果查询','','',target);
               				d.add('215040101', 2150401, '应付酬金明细查询','cms/rewardrecord.do?CMD=SHOW','',target);
               				d.add('215040102', 2150401, '结算酬金总表查询','cms/reward/rewardtotal.do?CMD=SHOW','',target);
               				d.add('215040105', 2150401, '酬金调整管理','cms/rewardadjust.do','',target);
               			d.add('2150402', 21504, '酬金考核系数管理', 'cms/rewardasse.do?CMD=LIST','',target);
               			d.add('2150403', 21504, '地市二批酬金数据导入', 'cms/cityrewardad.do?CMD=LIST','',target);
             			d.add('2150404', 21504, '合作年限奖管理', 'cms/wayhznx.do?CMD=LIST','',target);
             			d.add('2150405', 21504, '酬金出帐确认', 'cms/reward/rewardconf.do?CMD=Aglist','',target);
             			d.add('2150406', 21504, '社会渠道月初备份信息导出 ', 'cms/reward/waysnpt.do?CMD=SHOW','',target);
             			d.add('2150407', 21504, '社会渠道出酬过程监控 ', 'cms/reward/taskstate.do?CMD=SET','',target);
             			d.add('2150408', 21504, '星级奖励酬金管理','cms/waystarmonth.do?CMD=STARLIST','',target);
             			d.add('2150409', 21504, '酬金结果支付管理','cms/rewardsms/frame.jsp','',target);
             			d.add('2150410', 21504, '税率管理规则配置','cms/reward/tax.do?CMD=LIST','',target);
             			d.add('2150411', 21504, '市公司考核违规网点导入','cms/wayhzwg.do?CMD=LIST','',target);
               	 d.add('216', 20, '网站渠道业务管理', '','',target);
               		d.add('21601', 216, '业务基本信息管理','','',target);	
               			d.add('2160101', 21601, '全省统一业务管理','cms/bbc/operation.do?CMD=LIST','',target);
               			d.add('2160102', 21601, 'MM业务管理','cms/bbc/mmopn.do?CMD=LIST','',target);		
               			d.add('2160103', 21601, '无线音乐管理','cms/bbc/music/list.jsp','',target);		
           			d.add('21602', 216, '服务功能费项对应关系管理','cms/bbc/opnacctmap.do?CMD=LIST','',target);	
           			d.add('21603', 216, 'B2M业务编码与企业代码对应关系管理','cms/bbc/jfopnmap.do?CMD=LIST','',target);
           			d.add('21604', 216, 'B2M网站酬金计算结果明细查询','cms/bbc/bbcrewardrecord.do?CMD=SHOW','',target);
               		d.add('21605', 216, 'B2M网站酬金计算结果总表查询','cms/bbc/bbcrewardtotal.do?CMD=SHOW','',target);
               		d.add('21606', 216, 'B2M网站酬金出帐确认','cms/reward/rewardconf.do?CMD=B2mlist','',target);
               		d.add('21607', 216, '有效性校验失败数据查询','cms/bbc/bbcfaildataquery.do?CMD=SHOW','',target);
               		d.add('21608', 216, '营销方案与业务关联设置','cms/bbc/yxplan.do?CMD=LIST','',target);
               		d.add('21609', 216, 'B2M网盟酬金计算结果查询','cms/nasrwdtotal.do?CMD=SHOW','',target);
               		d.add('21610', 216, 'B2M网站酬金调整管理','cms/bbc/bbcadjust.do?CMD=LIST','',target);
               		d.add('21611', 216, '酬金管理','','',target);
               			d.add('2161101', 21611, '酬金计算结果查询','','',target);
	               			d.add('216110101', 2161101, '全员代理酬金计算结果明细查询','cms/bbc/unvrewardrecord.do?CMD=SHOW','',target);
	               			d.add('216110102', 2161101, '全员代理酬金计算结果总表查询','cms/bbc/unvrewardtotal.do?CMD=SHOW','',target);
	               			d.add('216110103', 2161101, '全员代理计酬和推荐失败记录查询','cms/bbc/unvfaildataquery.do?CMD=LIST','',target);
	               			d.add('216110104', 2161101, '优质网站酬金明细查询','cms/bbc/bbcyzrewarddet.do?CMD=SHOW','',target);
               		d.add('21612', 216, '合动网业务办理查询','cms/bbc/hdnetsales.do?CMD=LIST','',target);
               		d.add('21613', 216, '代理商层级信息查询','cms/bbc/bbcwaylevel.do?CMD=LIST','',target);
               		d.add('21614', 216, '全员代理酬金调整管理','cms/bbc/bbcadjust.do?CMD=UNPBLIST','',target);
               		d.add('21615', 216, '数据业务核减功能设置','cms/bbc/subtract/frame.jsp','',target);
	             d.add('217', 20, '渠道考核管理', '','',target); 
	                 d.add('21705', 217, '指标管理','cms/examine/examinestd.do?CMD=LIST','',target);
	               	 d.add('21706', 217, '考核管理','cms/examine/examine.do?CMD=LIST','',target);	
	               	 d.add('21707', 217, '分数映射','cms/examine/mapping.do?CMD=LIST','',target);
	               	 d.add('21708', 217, '考核评分','cms/examine/itemgraded.do?CMD=Showexmnpage','',target);
	               	 d.add('21709', 217, '考核结果','cms/examine/exmnrslt.do?CMD=LIST','',target);
	               	 d.add('21710', 217, '考核系数','cms/examine/coefficient.do?CMD=LIST','',target);
	               	 d.add('21711', 217, '系数调整','cms/examine/coefrevision.do?CMD=LIST','',target);
	           		 d.add('21712', 217, '渠道评分授权', 'cms/examine/oprnwayid.do?CMD=LIST','', target);
	               	 d.add('21713', 217, '考核日志查询', 'cms/examine/logquery/logQueryFrame.jsp','', target);	
		document.write(d);

        </script> 
					</div>
				</td>
				<td width=900>
					<iframe framespacing="0" frameborder="NO" Scrolling="auto" width=806 height=510 name="mywin" id="IFRM_LEFT_BOTTOM" src="new.html"></iframe>
				</td>
			</tr>
		</table>
	</body>
</html>