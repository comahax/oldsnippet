<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ page  import="com.sunrise.jop.ui.component.ThemeSelector"%>
<%
	String contextPath = request.getContextPath();
	String currentTheme = "default";
	currentTheme = ThemeSelector.getCurrentTheme(request);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link  href="<%= contextPath %>/css/<%=currentTheme%>/peijian.css" rel="stylesheet" type="text/css">
<style type="text/css">
#map_box_bg {
	width:100%;
	background:#fbf9fb
}
#map_box {
	width:970px;
	margin:0 auto;
	padding:22px 0 50px 0;
}
#map_box a {
	color:#786670;
	text-decoration:none;
	display:inline-block;
	font-family:Arial, "宋体", "Times New Roman"
}
#map_box h1, h2 {
	margin:0;
	padding:0;
}
#map_box h1 {
	background:#f6f0f6;
	color:#66575f;
	font-size:14px;
	height:20px;
	line-height:20px;
	font-weight:bold;
	padding-left:20px; background:url('<%=currentTheme%>'/images/dtree/2.gif) 7px center no-repeat ;
	width:941px;
}
#map_box h2 {
	font-size:12px;
	font-weight:lighter;
	width:941px;
	line-height:19px;
	color:#000;
	padding-left:20px;
	margin:10px 0 20px 0;
}
.pad5 {
	width:31px;
	text-align:center;
	color:#786670;
	display:inline-block;
	font-family:Arial;
}
	
	
</style>



<title></title>
<script type="text/javascript">

	function showDialog(){
			
	$("#searchbtn").dialog({			
			   title:"事件详情",   
               width:600,   
               height:300,                  
               content:'url:../iframe/t.jsp',               
               max:false,   
               min:false,   
               lock:true 	
	});
	
	}

</script>


</head>

<body>
<div id="map_box_bg">
	<div id="map_box">
	 <!--  <div class="vipmap_title"><imgwidth="126" height="38" />站点地图</div>  --> 
	   
	   <script>
	    Array.prototype.indexOf = function (val) {
                            for (var i = 0; i < this.length; i++) {
                                if (this[i] == val) return i;
                            }
                            return -1;
                        };
         //数组删除指定索引元素
        Array.prototype.remove = function (val) {
                  var index = this.indexOf(val);
                            if (index > -1) {
                                this.splice(index, 1);
                            }
                        };
	   	var ary= [1,2,3,4,5];
 			ary.remove(2);
			
	   
	   
	   	var secordMenu = ['出账进度','出账核查','出账调整','统计分析','出账确认','数据管理','预出固定费','基础资料设置 '];
	   	
	   	var fourMenu =  ['清单堆积全流程监控','冲销处理监控','节点CBE和省中心计费对账监控 ','省中心计费侧内部对账监控','省中心计费账务包级对账监控  ',
							'省中心计费账务日报表对账监控','累账内部对账监控','实时累帐抛包监控','HSC一致性数据集合监控','出账前系统监控总体情况',
							'出账前健康性检查','出账过程监控','出账后总体情况监控','出账总结汇报','地市公司核查过程监控','预付费低消处理监控',
							'欠费入库的进度监控','触发销账进度监控','积分计算进度展示','清单生成进度展监控','账单入库进度展示监控','出账报表处理总体进度展示','|',
							'固定费核查说明','固定费抽查','批量固定费核查','产品方案资费核查','固定费费项配置核查','固定费结果重复核查',
							'八大套餐重复核查','产品方案抽检','固定费核查登记','出账数据核查说明','文件下载','文件抽查','通信费平衡性检查',
							'出帐整体平衡性检查','|','固定费调整','批量固定费调整','无主调整查询','批量无主调整','|','固定费波动分析 ','通信费波动分析 ','出账结果波动分析 ','积分结果波动分析 ','预付费低消补扣波动分析 ',
							'应收话费波动性分析 ','预付费低消波动分析 ','积分波动分析 ','|','固定费确认','通信费确认','出账启动确认','触发销账信控','|','批量用户固定费优惠导出','批量固定费结果维护','合作商结算资料查询','固定费结算设定管理',
							'固定费结算设定日志查询','八加一套餐网龄对应折扣管理 ','万宝数据管理','批量万宝数据管理',
							'万宝固定费查询','集团代付帐单临时数据查询','|',
							'预出固定费调整日志查询 ','预出固定费上挂 ','批量预出固定费调整 ','预出固定费结果查询 ','批量预出固定费核查 ','预出固定费出帐日志查询 ','|','有效账务周期设置 ','出账触发规则设置 ','出账业务模块联系人设置 ','出账短信通知设置 '];
      	 
      	 
      	 
      	 
      	 var thirdMenu  = ['帐务出账监控总览','提供整月账务生产的工作列表','出账统一平台，展示各个模块的负责人及联系方式','统一出帐监控管理','异常过程显示及干预','出帐日志明细查询 ',
						   '出账业务监控管理','累帐对账结果查询','分流对帐结果查询 ','出帐启动日志查询 ','NGBOSS“出账确认、触发销账信控”增加前台按钮，由地市自由控制 ','出账进度短信通知功能','|',
						   '固定费调整','批量固定费调整','无主调整查询','批量无主调整','融合无主查询','|',
						   '批量用户固定费优惠导出','批量固定费结果维护','固定费结算设定管理','合作商结算资料查询','合作商结算资料统计',
						   '固定费结算设定日志查询','最近3个月的结果数据汇总比较','八加一套餐网龄对应折扣管理','固定费计算结果确认','|',						   
						   '固定费核查说明','固定费抽查','批量固定费核查','导出产品方案资费','导出固定费费项配置','导出固定费结果文件','固定费记录重复性检查（集团、节点）',
						   '检查同一号码是否有多个八大套餐数据','产品使用天数统计','近往月固定费比较','与上月的明细数据进行比较','产品方案抽检','固定费核查登记','|',
						   '出账数据核查说明','预处理文件导入','预处理文件平衡性检查（平衡性公式展示）','预处理文件抽查','monfee账单波动分析','MONFEE文件的检查',
						   '无主账单波动分析','出账文件导入','出账文件抽查','用户出账波动性分析','账户出账波动性分析','出帐金额平衡性检查（平衡性公式展示）',
						   '出帐用户数平衡性检查','客户应收抽查','应收话费波动性分析','批量导出客户应收','出账数据核查登记','全球通出账预付费号码检测','|',
						   '万宝数据管理','批量万宝数据管理','万宝固定费查询','|','集团代付帐单临时数据查询','|','有效账务周期设置','出账触发规则设置','|',
						   '出账后总体情况监控（全球通）','出账后总体情况监控（预付费）','出账总结汇报','地市公司核查过程监控','|',
						   '预付费低消处理监控','预付费用户当月话费消费情况查询','预付费低消核查调整','预付费低消数据分析、波动检查','预付费数据核查登记','|',
						   '欠费入库的进度监控','触发销账进度监控','|','积分计算进度展示','积分结果抽查','积分数据分析、波动检查','积分检查','|',
						   '清单生成进度展监控','|','账单入库进度展示监控','|','出账报表处理总体进度展示','ICP赠费统计报表 ','补收冲减统计报表 ','固定费明细统计表 ','特殊用机应收统计报表 ','无主统计报表 ',
						   '应收统计报表 ','帐单减免统计表 ','全球通代预付费品牌充值报表 ','套餐列帐拆分报表','COA报表 ','重出报表','|',
						   '出账数据自动备份清理','|','出账前系统监控总体情况','出账前健康性检查','|','CRM&HSC数据核查结果展示，不平明细展示','ESOP&省HSC数据核查结果展示，不平明细展示','不平明细调整监控','|',
						   '预出固定费调整日志查询','预出固定费上挂','批量预出固定费调整','预出固定费结果查询','批量预出固定费核查',
						   '预出固定费出帐日志查询','固定费调试工具(珠海市公司)','|','固定费核查说明','固定费抽查','批量固定费核查','导出产品方案资费','导出固定费费项配置','导出固定费结果文件','固定费记录重复性检查（集团、节点）',
						   '检查同一号码是否有多个八大套餐数据','产品使用天数统计','近往月固定费比较','与上月的明细数据进行比较','产品方案抽检','固定费核查登记','|',
						   '清单堆积全流程监控','冲销处理监控','节点CBE和省中心计费对账监控','省中心计费侧内部对账监控','省中心计费账务包级对账监控',
						   '省中心计费账务日报表对账监控','累账内部对账监控','实时累帐抛包监控','实时累账数据分析','|',]; 
						   
			var menuArray = new Array();
			
			var tempArray = fourMenu;
			
			for(var i=0 ; i<secordMenu.length;i++){
						
			var html = '<h1>'+secordMenu[i]+'</h1>';
			
			var content="";	
			
			for(var j=0 ;j<tempArray.length ; j++){				
					
				if(tempArray[j] == '|'){
					tempArray=tempArray.slice(j+1); 				
					break;
				}				
				content += '<a href="contact_us.php" target="_blank">'+tempArray[j]+'</a><span class="pad5">|</span>'; 			
					 
			}				
			menuArray.push(html+"<h2>"+content+"</h2>");
			 
		}			   
		document.write(menuArray.join(''));	
	   
	   </script>	   
   
	</div>
</div>
</body>
</html>
