package com.gmcc.pboss.control.service.sms.localcomorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountDBParam;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountVO;
import com.gmcc.pboss.business.resource.cityrescode.CityrescodeDBParam;
import com.gmcc.pboss.business.resource.cityrescode.CityrescodeVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.sales.comorderstate.ComorderstateDBParam;
import com.gmcc.pboss.business.sales.comorderstate.ComorderstateVO;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantDBParam;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantVO;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.wayaccount.Wayaccount;
import com.gmcc.pboss.control.channel.wayaccount.WayaccountBO;
import com.gmcc.pboss.control.resource.cityrescode.Cityrescode;
import com.gmcc.pboss.control.resource.cityrescode.CityrescodeBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.sales.comorder.Comorder;
import com.gmcc.pboss.control.sales.comorder.ComorderBO;
import com.gmcc.pboss.control.sales.comorder.ComorderCheck;
import com.gmcc.pboss.control.sales.comorder.ComorderCheckBO;
import com.gmcc.pboss.control.sales.comorderstate.Comorderstate;
import com.gmcc.pboss.control.sales.comorderstate.ComorderstateBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.reqcomcate.Reqcomcate;
import com.gmcc.pboss.control.sales.reqcomcate.ReqcomcateBO;
import com.gmcc.pboss.control.sales.wayassistant.Wayassistant;
import com.gmcc.pboss.control.sales.wayassistant.WayassistantBO;
import com.gmcc.pboss.control.service.sms.ServiceSmsBOHelper;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.LocalComOrderResult;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.common.utils.logging.LoggingConstant;
import com.sunrise.jop.exception.business.SaleException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class SMSLocalComOrderCommitBO extends AbstractControlBean implements SMSLocalComOrderCommit{

	private static Logger logger = Logger.getLogger(SMSLocalComOrderCommitBO.class);
	
	private Date date;
	
	/**
	 * 检查合作商资料
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	private String doGetWayid(String mobile) throws Exception{
		//号段表
		logger = ServiceSmsBOHelper.createChildLogger(user.getCityid()
				+ LoggingConstant.SMS_CITY_LOG_ROOT_NAME, this.getClass()
				.getSimpleName());
		//雇员表
		Employee employee = (Employee)BOFactory.build(EmployeeBO.class, user);
		EmployeeDBParam employeeDBParam = new EmployeeDBParam();
		employeeDBParam.set_se_officetel(mobile);
		employeeDBParam.set_ne_empstatus("0");
		DataPackage dp = employee.doQuery(employeeDBParam);
		if(dp.getDatas().size() == 0){
			Map<String,String> map = new HashMap<String,String>();
			Map<String,Object> parammap = new HashMap<String,Object>();
			parammap.put("sid", "FX_ORDER_NUMBERUNREG");
			parammap.put("keyvaluemap", map);
			parammap.put("defaultsms", "尊敬的客户，您的手机号码尚未登记，无法为您提供服务。如需帮助，请联系渠道经理或拨打服务热线。");
			parammap.put("receiveno", mobile);
			throw new SMSException("号码未登记",LocalComOrderResult.RET_TYPE_FAIL_2,parammap);
		}
		EmployeeVO vo = (EmployeeVO)dp.getDatas().get(0);
		if(!"1".equals(vo.getIsnet().toString())){
			Map<String,String> map = new HashMap<String,String>();
			Map<String,Object> parammap = new HashMap<String,Object>();
			parammap.put("sid", "FX_ORDER_NOTTHEBOSS");
			parammap.put("keyvaluemap", map);
			parammap.put("defaultsms", "尊敬的客户，商品订购暂时只开放给店主使用，无法为您提供服务。如需帮助，请联系渠道经理或拨打服务热线。");
			parammap.put("receiveno", mobile);
			throw new SMSException("非店主号码无权限",LocalComOrderResult.RET_TYPE_FAIL_3,parammap);
		}
		String wayid = vo.getWayid();
		Way wayBO  = (Way) BOFactory.build(WayBO.class,user);
		WayVO wayVO = wayBO.doFindByPk(wayid);
		if (wayVO == null || wayVO.getWaystate() != 1) {
			Map<String,Object> parammap = new HashMap<String,Object>();
			parammap.put("defaultsms", "尊敬的客户，您所在渠道状态不为开店，不能进行商品订购。");
			parammap.put("receiveno", mobile);
			parammap.put("orderstatecheckflag", "1");
			throw new SMSException("所属渠道状态不为开店",LocalComOrderResult.RET_TYPE_FAIL_4,parammap);
		}
		date = new Date();
		return wayid;
	}
	
	/**
	 * 检查订购资格
	 * @param wayid
	 * @return
	 * @throws Exception
	 */
	private String doCheckOrderQualification(String wayid,String mobile) throws Exception{
		Wayassistant wayassistant = (Wayassistant)BOFactory.build(WayassistantBO.class, user);
		WayassistantDBParam param = new WayassistantDBParam();
		param.set_se_wayid(wayid);
		DataPackage dp = wayassistant.doQuery(param);
		if(dp.getDatas().size() == 0){
			Map<String,String> map = new HashMap<String,String>();
			Map<String,Object> parammap = new HashMap<String,Object>();
			parammap.put("sid", "FX_ORDER_NOAUTH");
			parammap.put("keyvaluemap", map);
			parammap.put("defaultsms", "尊敬的客户，您暂时不能发起商品订购，请联系渠道经理核查商品订购辅助信息。");
			parammap.put("receiveno", mobile);
			throw new SMSException("无商品订购权限",LocalComOrderResult.RET_TYPE_FAIL_4,parammap);
		}
		WayassistantVO vo = (WayassistantVO)dp.getDatas().get(0);
		if(vo.getCanorder() == null || !"1".equals(vo.getCanorder().toString())){
			Map<String,String> map = new HashMap<String,String>();
			Map<String,Object> parammap = new HashMap<String,Object>();
			parammap.put("sid", "FX_ORDER_NOAUTH");
			parammap.put("keyvaluemap", map);
			parammap.put("defaultsms", "尊敬的客户，您暂时不能发起商品订购，请联系渠道经理核查商品订购辅助信息。");
			parammap.put("receiveno", mobile);
			throw new SMSException("无商品订购权限",LocalComOrderResult.RET_TYPE_FAIL_4,parammap);
		}
		return vo.getPaytype();
	}
	
	/**
	 * 检查银行账号
	 * @param wayid
	 * @throws Exception
	 */
	private void doCheckBankInformation(String wayid,String mobile) throws Exception{
		Wayaccount wayaccount = (Wayaccount)BOFactory.build(WayaccountBO.class, user);
		WayaccountDBParam param = new WayaccountDBParam();
		param.set_se_wayid(wayid);
		DataPackage dp = wayaccount.doQuery(param);
		if(dp.getDatas().size() == 0){
			Map<String,String> map = new HashMap<String,String>();
			Map<String,Object> parammap = new HashMap<String,Object>();
			parammap.put("sid", "FX_ORDER_ACCOUNT");
			parammap.put("keyvaluemap", map);
			parammap.put("defaultsms", "尊敬的客户，您登记的卡类购销划扣银行账号信息不完整，无法进行商品订购。如需帮助，请联系渠道经理或拨打服务热线。");
			parammap.put("receiveno", mobile);
			throw new SMSException("银行账号信息不存在或不完整",LocalComOrderResult.RET_TYPE_FAIL_7,parammap);
		}
		WayaccountVO vo = (WayaccountVO)dp.getDatas().get(0);
		if(StringUtils.isEmpty(vo.getDeacctno()) || StringUtils.isEmpty(vo.getDeacctname()) || StringUtils.isEmpty(vo.getDebankname())){
			Map<String,String> map = new HashMap<String,String>();
			Map<String,Object> parammap = new HashMap<String,Object>();
			parammap.put("sid", "FX_ORDER_ACCOUNT");
			parammap.put("keyvaluemap", map);
			parammap.put("defaultsms", "尊敬的客户，您登记的卡类购销划扣银行账号信息不完整，无法进行商品订购。如需帮助，请联系渠道经理或拨打服务热线。");
			parammap.put("receiveno", mobile);
			throw new SMSException("银行账号信息不存在或不完整",LocalComOrderResult.RET_TYPE_FAIL_7,parammap);
		}
	}
    
	/**
	 * 月订购次数检查
	 * 
	 * @param wayid
	 * @throws Exception
	 */
	private void checkBookTimes(String wayid,String mobile) throws Exception {
		try {
			Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,
					user);
			comorder.checkMonthBookTimes(wayid);
		} catch (SaleException se) {
			Map<String,String> map = new HashMap<String,String>();
			map.put("ORDERTIMES", se.getMonmaxtimes().toString());
			Map<String,Object> parammap = new HashMap<String,Object>();
			parammap.put("sid", "FX_ORDER_MONMAXTIMES");
			parammap.put("keyvaluemap", map);
			parammap.put("defaultsms", "尊敬的客户，您本月已成功订购"+se.getMonmaxtimes().toString()+"次，达到最大订购次数，不能继续订购。如需帮助，请联系渠道经理或拨打服务热线。");
			parammap.put("receiveno", mobile);
			throw new SMSException(se.getMessage(),
					LocalComOrderResult.RET_TYPE_FAIL_8,parammap);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * 检查订购时段
	 * @throws Exception
	 */
	private void doCheckOrderTime(String wayid,String mobile) throws Exception{
		try{
			Way wayBO  = (Way) BOFactory.build(WayBO.class,user);
			WayVO wayVO = wayBO.doFindByPk(wayid);
			ComorderCheck comorderCheckBO = (ComorderCheckBO)BOFactory.build(ComorderCheckBO.class,user);
			comorderCheckBO.checkLimitTime(wayVO);
		}catch(SaleException ex){
			if("SALE-104015".equals(ex.getErrorCode())){
				Map<String,String> map = new HashMap<String,String>();
				Map<String,Object> parammap = new HashMap<String,Object>();
				parammap.put("sid", "FX_STOPORDER");
				parammap.put("keyvaluemap", map);
				parammap.put("defaultsms", "尊敬的客户，今天不提供商品订购服务。如需帮助，请联系渠道经理或拨打服务热线。");
				parammap.put("receiveno", mobile);
				throw new SMSException(ex.getMessage(),LocalComOrderResult.RET_TYPE_FAIL_9,parammap);
			}else if("SALE-104003".equals(ex.getErrorCode())){
				Map<String,String> map = new HashMap<String,String>();
				map.put("TIMESECT", ex.getTimesect());
				Map<String,Object> parammap = new HashMap<String,Object>();
				parammap.put("sid", "FX_ORDER_TIMESECT");
				parammap.put("keyvaluemap", map);
				parammap.put("defaultsms", "尊敬的客户，正常订购时段为"+ex.getTimesect()+"，当前时间不能进行商品订购。如需帮助，请联系渠道经理或拨打服务热线。");
				parammap.put("receiveno", mobile);
				throw new SMSException(ex.getMessage(),LocalComOrderResult.RET_TYPE_FAIL_10,parammap);
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * 检查商品种类和商品数量
	 * @param orderData
	 * @return
	 * @throws Exception
	 */
	private Map<String, Integer> doCheckDataList(List<Map<String,String>> ordreDataList,String mobile,Map<String,String> codeAndComcate) throws Exception {
		Map<String, Integer> dataMap = new HashMap<String, Integer>();
		Comorder comorderBO = (Comorder)BOFactory.build(ComorderBO.class, user);
		for(Map<String,String> comcateAndCountMap: ordreDataList){
			String comcate = comcateAndCountMap.keySet().iterator().next();
			String count = comcateAndCountMap.get(comcate);
//			String[] datas = StringUtils.split(data, "\\"+SMSProtocol.STR_SLIT_SYMBOL);
//			if(datas.length != 2){
//				throw new SMSException("请求格式错误(wrong request format)",LocalComOrderResult.RET_TYPE_FAIL_111);
//			}
			
			//检查商品种类
			String brand = comcate.toUpperCase().trim();
			
			String cityrescode = brand;//如果不是江门，cityrescode的值仍是brand的值
			if("JM".equals(user.getCityid()) && codeAndComcate.containsValue(brand)){
				cityrescode = getCodeFromComcate(brand);//得到地市资源代码
			}
			if(dataMap.get(brand) != null){
				Map<String,String> map = new HashMap<String,String>();
				map.put("COMCODE", cityrescode);
				Map<String,Object> parammap = new HashMap<String,Object>();
				parammap.put("sid", "FX_ORDER_COMDUP");
				parammap.put("keyvaluemap", map);
				parammap.put("defaultsms", "尊敬的客户，您订购的商品"+cityrescode+"重复，请修改后重试。如需帮助，请联系渠道经理或拨打服务热线。");
				parammap.put("receiveno", mobile);
				throw new SMSException("商品重复",LocalComOrderResult.RET_TYPE_FAIL_11,parammap);
			}
			
			Dictitem dictitem = (Dictitem)BOFactory.build(DictitemBO.class, user);
			DictitemDBParam dictitemDBParam = new DictitemDBParam();
			dictitemDBParam.set_se_groupid("IM_FXCOMCATEGORY");
			dictitemDBParam.set_se_dictid(brand);
			DataPackage dictitemDp = dictitem.doQuery(dictitemDBParam);
			if(dictitemDp.getDatas().size() == 0){
				Map<String,String> map = new HashMap<String,String>();
				map.put("COMCODE", cityrescode);
				Map<String,Object> parammap = new HashMap<String,Object>();
				parammap.put("sid", "FX_ORDER_COMNOEXIST");
				parammap.put("keyvaluemap", map);
				parammap.put("defaultsms", "尊敬的客户，您订购的商品"+cityrescode+"不存在，请修改后重试。如需帮助，请联系渠道经理或拨打服务热线。");
				parammap.put("receiveno", mobile);
				throw new SMSException("商品不存在",LocalComOrderResult.RET_TYPE_FAIL_12,parammap);
			}
			
			Comorderstate comorderstate = (Comorderstate)BOFactory.build(ComorderstateBO.class, user);
			ComorderstateDBParam comorderstateDBParam = new ComorderstateDBParam();
			comorderstateDBParam.set_se_cityid(user.getCityid());
			comorderstateDBParam.set_se_comcategory(brand);
			DataPackage comorderstateDp = comorderstate.doQuery(comorderstateDBParam);
			if(comorderstateDp.getDatas().size() != 0){
				ComorderstateVO vo = (ComorderstateVO)comorderstateDp.getDatas().get(0);
				if(!"NORMAL".equals(vo.getOrderstate())){
					Map<String,String> map = new HashMap<String,String>();
					map.put("COMCODE", cityrescode);
					Map<String,Object> parammap = new HashMap<String,Object>();
//					parammap.put("sid", "FX_ORDER_COMNOEXIST");
//					parammap.put("keyvaluemap", map);
					parammap.put("defaultsms", (StringUtils.isBlank(vo.getMsgcontent())?"尊敬的客户，您订购的商品"+cityrescode+
							"暂时不能提供订购。如需帮助，请联系渠道经理或拨打服务热线。":vo.getMsgcontent()));
					parammap.put("receiveno", mobile);
					parammap.put("orderstatecheckflag", "1");
					throw new SMSException("商品订购状态不正常",LocalComOrderResult.RET_TYPE_FAIL_13,parammap);
				}
			}
			
			//检查商品数量
			String amount = count.trim();
			if(!PublicUtils.isInteger(amount) || Integer.parseInt(amount) <= 0){
				Map<String,String> map = new HashMap<String,String>();
				Map<String,Object> parammap = new HashMap<String,Object>();
				parammap.put("sid", "FX_ORDER_DIGITALERR");
				parammap.put("keyvaluemap", map);
				parammap.put("defaultsms", "尊敬的客户，订购数量必须为大于零的整数，请修改后重试。如需帮助，请联系渠道经理或拨打服务热线。");
				parammap.put("receiveno", mobile);
				throw new SMSException("订购数量非大于零的整数",LocalComOrderResult.RET_TYPE_FAIL_14,parammap);
			}
			// 获取订购基数 
			// 参照【商品订购】章节中的订购基数获取逻辑，获取指定地市、指定商品种类的订购基数。[2010-07-29]
			String unitage = comorderBO.doGetUnitage(user.getCityid(), brand);
			if(Integer.parseInt(amount) % Integer.parseInt(unitage) != 0){
				Map<String,String> map = new HashMap<String,String>();
				map.put("COMCODE", cityrescode);
				map.put("UNITAGE", unitage);
				map.put("ORDERAMT", amount);
				Map<String,Object> parammap = new HashMap<String,Object>();
				parammap.put("sid", "FX_ORDER_UNITAGE");
				parammap.put("keyvaluemap", map);
				parammap.put("defaultsms", "尊敬的客户，商品"+cityrescode+"订购量必须为"+unitage+"的整数倍，您当前订购量为"+amount+"，请修改后重试。如需帮助，请联系渠道经理或拨打服务热线。");
				parammap.put("receiveno", mobile);
				throw new SMSException("订购商品数量非订购基数整数倍",LocalComOrderResult.RET_TYPE_FAIL_15,parammap);
			}
			/*if(!brand.contains("CZ")){
				Orderunit orderunit = (Orderunit)BOFactory.build(OrderunitBO.class, user);
				OrderunitDBParam orderunitDBParam = new OrderunitDBParam();
				orderunitDBParam.set_se_cityid(user.getCityid());
				orderunitDBParam.set_se_comcategory(brand);
				DataPackage orderunitDp = orderunit.doQuery(orderunitDBParam);
				String unitage = null;
				if(orderunitDp.getDatas().size() == 0){
					unitage = "20";
				}else{
					OrderunitVO vo = (OrderunitVO)orderunitDp.getDatas().get(0);
					if("FIXED".equals(vo.getUnitagemode())){
						unitage = vo.getUnitage();
					}else if("WEEK".equals(vo.getUnitagemode())){
						String[] unitages = StringUtils.split(vo.getUnitage(), "|");
						if(unitages.length == 7){
							Calendar c = Calendar.getInstance();
							c.setTime(date);
							int day = c.get(Calendar.DAY_OF_WEEK);
							if(day == Calendar.SUNDAY){
								unitage = unitages[unitages.length-1];
							}else{
								unitage = unitages[day-2];
							}
						}else{
							unitage = "20";
						}
					}
				}
				if(Integer.parseInt(amount) % Integer.parseInt(unitage) != 0){
					throw new SMSException(brand+"的订购数量["+amount+"]必须为["+unitage+"]的整数倍",LocalComOrderResult.RET_TYPE_FAIL_9);
				}
			}*/
			
			dataMap.put(brand, Integer.parseInt(amount));
		}
		return dataMap;
	}
	
	/**
	 * 获取订单编号
	 * @return
	 * @throws Exception
	 */
	private String doGetOrderid() throws Exception{
		Order order = (Order)BOFactory.build(OrderBO.class,user);
		return order.doGetOrderId(date);
	}
	
	/**
	 * 组建订单
	 * @param orderid
	 * @param dataMap
	 * @throws Exception
	 */
	private void doBuildOrderList(String wayid, String mobile, String orderid, Map<String, Integer> dataMap) throws Exception {
		Reqcomcate reqcomcate = (Reqcomcate)BOFactory.build(ReqcomcateBO.class,user);
		reqcomcate.doBuildOrderList(wayid, mobile, orderid, dataMap, date);
	}
	
	private LocalComOrderResult doReturnSuccVal(String orderid,String mobile) throws Exception{
		//写短信待发送表
		Map<String,String> map = new HashMap<String,String>();
		map.put("ORDERID", orderid);
		String defaultsms = "尊敬的客户，您的订购申请已提交，订单号["+orderid+"]，系统处理中，请留意稍后短信通知。";
		Sysparam SysparamBO = (SysparamBO) BOFactory.build(SysparamBO.class,user);
		String sendno = SysparamBO.doFindByID("42", "pboss_fx");
		if(StringUtils.isBlank(sendno))
			sendno = "10086116";
		Smstmpl smstmplBO = (SmstmplBO)BOFactory.build(SmstmplBO.class,user);
		String smsContent = smstmplBO.doGenSMS("FX_ORDER_SUBMITNOTICE", map);
		if( null == smsContent || "".equals(smsContent.trim()))
			smsContent = defaultsms;
		Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
		waitreqBO.doInsert2(new Short("3"), smsContent, sendno,mobile);
		//返回短厅
		LocalComOrderResult result = new LocalComOrderResult();
		List<String> list = new ArrayList<String>();
		list.add(orderid);
		result.setRet(LocalComOrderResult.RET_TYPE_SUCC_0);
		result.setMessage("成功");
		result.setDatas(list);
		return result;
	}
	
	/**
	 * 根据系统参数检查是否允许混合订单,允许则立即返回，不允许则检查订购商品是否为同一品牌
	 */
	private void doCheckMixOrderEnable(List<Map<String,String>> ordreDataList,String mobile) throws Exception {
		Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,user);
		String paramvalue = sysparam.doFindByID("63", "pboss_fx");		
		boolean enable = true;
		if(paramvalue!=null && !"".equals(paramvalue)){
			if("0".equals(paramvalue)){
				enable=false;
			}
		}
		if(!enable){//不允许订购混合订单
			//查询IM_PR_COMCATEGORYRELA，获取商品种类-资源类别组合，放到一个Map中
			Comcategoryrela comcategoryrela = (Comcategoryrela)BOFactory.build(ComcategoryrelaBO.class, user);
			ComcategoryrelaDBParam params = new ComcategoryrelaDBParam();
			params.setSelectFieldsString("comcategory,restype");
			params.set_pagesize("0");
			params.setDataOnly(true);
			DataPackage dp = comcategoryrela.doLoadComCateAndResType(params);
			List comcateAndRestype = dp.getDatas();
			//key-comcategory商品种类,value-restype资源类型
			Map<String,String> cateAndRes = new HashMap<String,String>();
			if(comcateAndRestype.size()>0){
				for(Iterator it=comcateAndRestype.iterator();it.hasNext();){
					Map<String,String> temp = (Map<String,String>)it.next();					
					cateAndRes.put(temp.get("comcategory"), temp.get("restype"));
				}
			}
			
			//商品资源类型标记变量
			String tokenRestype = null;
			for(Map<String,String> comcateAndCountMap: ordreDataList){
				if(tokenRestype==null){//处理第一个商品，将其资源类别保存
					tokenRestype = cateAndRes.get(comcateAndCountMap.keySet().iterator().next());
					continue;
				}
				//处理其他商品，如果资源类别与保存的资源类别不同，报错
				String restype = cateAndRes.get(comcateAndCountMap.keySet().iterator().next());
				if(!tokenRestype.equals(restype)){
					Map<String,String> map = new HashMap<String,String>();
					Map<String,Object> parammap = new HashMap<String,Object>();
					parammap.put("sid", "FX_ORDER_SINGLERES");
					parammap.put("keyvaluemap", map);
					parammap.put("defaultsms", "尊敬的客户，单次订购只允许一种资源类别，请修改后重试。如需帮助，请联系渠道经理或拨打服务热线。");
					parammap.put("receiveno", mobile);
					throw new SMSException("不能订购混合资源类别的订单",LocalComOrderResult.RET_TYPE_FAIL_6,parammap);
				}
			}
		}
	}
	
	private Map<String,String> getCodeAndComcateMap() throws Exception {
		//首先载入代码对应关系集合，查询地市资源代码对应表(IM_PR_CITYRESCODE)，
		//匹配市公司标识为归属地市，将对应关系一次载入。
		Cityrescode cityrescode = (Cityrescode)BOFactory.build(CityrescodeBO.class, user);
		CityrescodeDBParam cparams = new CityrescodeDBParam();
		cparams.set_se_cityid(user.getCityid());
		DataPackage dp = cityrescode.doQuery(cparams);
		List<CityrescodeVO> codeAndComcateList = dp.getDatas();
		//key-cityrescode地市资源代码,value-comcategory商品种类编码
		Map<String,String> codeAndComcate = new HashMap<String,String>();
		if(codeAndComcateList.size()>0){
			for(CityrescodeVO cityrescodevo:codeAndComcateList){
				codeAndComcate.put(cityrescodevo.getCityrescode(),cityrescodevo.getComcategory());
			}
		}
		return codeAndComcate;
	}
	
	//根据商品种类得出地市资源代码
	private String getCodeFromComcate(String comcate) throws Exception {
		Cityrescode cityrescode = (Cityrescode)BOFactory.build(CityrescodeBO.class, user);
		CityrescodeDBParam cparams = new CityrescodeDBParam();
		cparams.set_se_cityid(user.getCityid());
		cparams.set_se_comcategory(comcate);
		DataPackage dp = cityrescode.doQuery(cparams);
		if(null!=dp && dp.getDatas().size()>0){
			CityrescodeVO vo = (CityrescodeVO)dp.getDatas().iterator().next();
			return vo.getCityrescode();
		}else{
			return comcate;
		}
	}
	
	/**
	 * 4、	拆分资源代码和数量,返回list，list内每个map为一个商品种类对应一个数量
	 */
	private List<Map<String,String>> doSplitResCount(String ordreData,String mobile,Map<String,String> codeAndComcate) throws Exception {
		List<Map<String,String>> returnList = new ArrayList<Map<String,String>>();
		//然后根据号码归属地市拆分资源代码和数量
		if("JM".equals(user.getCityid())){//江门,ordreData组合方式如“a10b20c60”
			//算法： 1.从字符串首位开始依次循环检查，如果不是数字 ，不处理
			//	    2.如是是数字,判断它前一个是不是字母,如果是,则在该数字前面加上"#"号
			//      3.继续判断它后一个是不是字母,如果是,则在该数字后面加上","号
			String buf = ordreData;
			int stringlength = buf.length();
			for(int i=0;i<ordreData.length();i++){
				if(Character.isDigit(ordreData.charAt(i))){//如果是数字
					if(i-1<0){
						continue;
					}else{
						if(Character.isLetter(ordreData.charAt(i-1))){//如果前一个是字母
							buf=buf.substring(0,i+(buf.length()-ordreData.length()))+"#"+buf.substring(i+(buf.length()-ordreData.length()));
							stringlength++;
						}
					}
					if(i+1>=ordreData.length()){
						continue;
					}else{
						if(Character.isLetter(ordreData.charAt(i+1))){//如果后一个是字母
							buf=buf.substring(0,i+1+(buf.length()-ordreData.length()))+","+buf.substring(i+1+(buf.length()-ordreData.length()));
							stringlength++;
						}
					}
				}
			}
			//至此已经得到跟其他地市相同的通用格式字符串，如“a#30，b#50，c#20”，下面进行跟其他地市相同的处理
			List<String> dataList = Arrays.asList(StringUtils.split(buf, ","));//半角
//			if(dataList.size()==1)
//				dataList = Arrays.asList(StringUtils.split(buf, "，"));//全角
//			if(dataList.size()==1){
//				Map<String,String> map = new HashMap<String,String>();
//				map.put("CUSTSMS","FXDH"+ordreData);
//				Map<String,Object> parammap = new HashMap<String,Object>();
//				parammap.put("sid", "FX_ORDER_SMSFORMATERR");
//				parammap.put("keyvaluemap", map);
//				parammap.put("defaultsms", "尊敬的客户，您发送的短信 "+"FXDH"+ordreData+" 格式不正确，请修改后重试。");
//				parammap.put("receiveno", mobile);
//				throw new SMSException("短信格式错误",LocalComOrderResult.RET_TYPE_FAIL_5,parammap);
//			}
				
			for(String data : dataList){
				String[] datas = StringUtils.split(data, "\\"+SMSProtocol.DATA_SLIT_SYMBOL);//商品种类,数量
				if(datas.length != 2){
					Map<String,String> map = new HashMap<String,String>();
					map.put("CUSTSMS","FXDH"+ordreData);
					Map<String,Object> parammap = new HashMap<String,Object>();
					parammap.put("sid", "FX_ORDER_SMSFORMATERR");
					parammap.put("keyvaluemap", map);
					parammap.put("defaultsms", "尊敬的客户，您发送的短信 "+"FXDH"+ordreData+" 格式不正确，请修改后重试。");
					parammap.put("receiveno", mobile);
					throw new SMSException("短信格式错误",LocalComOrderResult.RET_TYPE_FAIL_5,parammap);
				}
				Map<String,String> comcateAndCountMap = new HashMap<String,String>();
				if(codeAndComcate.containsKey(datas[0]))
					comcateAndCountMap.put(codeAndComcate.get(datas[0]), datas[1]);
				else
					comcateAndCountMap.put(datas[0], datas[1]);
				returnList.add(comcateAndCountMap);
			}
		}else{//其他（通用格式），如“a#30，b#50，c#20”
			ordreData = StringUtils.replaceAll(ordreData, "，", ",");//将全角逗号统一换成半角逗号
			List<String> dataList = Arrays.asList(StringUtils.split(ordreData, ","));//半角
//			if(dataList.size()==1){
//				Map<String,String> map = new HashMap<String,String>();
//				map.put("CUSTSMS","FXDH"+ordreData);
//				Map<String,Object> parammap = new HashMap<String,Object>();
//				parammap.put("sid", "FX_ORDER_SMSFORMATERR");
//				parammap.put("keyvaluemap", map);
//				parammap.put("defaultsms", "尊敬的客户，您发送的短信 "+"FXDH"+ordreData+" 格式不正确，请修改后重试。");
//				parammap.put("receiveno", mobile);
//				throw new SMSException("短信格式错误",LocalComOrderResult.RET_TYPE_FAIL_5,parammap);
//			}
				
			for(String data : dataList){
				String[] datas = StringUtils.split(data, "\\"+SMSProtocol.DATA_SLIT_SYMBOL);//商品种类,数量
				if(datas.length != 2){
					Map<String,String> map = new HashMap<String,String>();
					map.put("CUSTSMS","FXDH"+ordreData);
					Map<String,Object> parammap = new HashMap<String,Object>();
					parammap.put("sid", "FX_ORDER_SMSFORMATERR");
					parammap.put("keyvaluemap", map);
					parammap.put("defaultsms", "尊敬的客户，您发送的短信 "+"FXDH"+ordreData+" 格式不正确，请修改后重试。");
					parammap.put("receiveno", mobile);
					throw new SMSException("短信格式错误",LocalComOrderResult.RET_TYPE_FAIL_5,parammap);
				}
				Map<String,String> comcateAndCountMap = new HashMap<String,String>();
				if(codeAndComcate.containsKey(datas[0]))
					comcateAndCountMap.put(codeAndComcate.get(datas[0]), datas[1]);
				else
					comcateAndCountMap.put(datas[0], datas[1]);
				returnList.add(comcateAndCountMap);
			}
		}
		return returnList;
//		ordreData = StringUtils.replaceIgnoreCase(ordreData, "#", "^");
//		ordreData = StringUtils.replaceIgnoreCase(ordreData, ",", "#");
//		ordreData = StringUtils.replaceIgnoreCase(ordreData, "，", "#");
//		return ordreData;
	}
	
	public String doResult(String mobile,String ordreData) throws Exception{
		try{
			String wayid = doGetWayid(mobile);
			String paytype = doCheckOrderQualification(wayid,mobile);
			Map<String,String> codeAndComcateMap = getCodeAndComcateMap();
			List<Map<String,String>> ordreDataList = doSplitResCount(ordreData, mobile,codeAndComcateMap);
			doCheckMixOrderEnable(ordreDataList,mobile);
			if("BANK".equals(paytype)){//判断缴费方式是否为银行划扣，如果不是则跳过本步骤
				doCheckBankInformation(wayid,mobile);
			}
			checkBookTimes(wayid,mobile);
			doCheckOrderTime(wayid,mobile);
			Map<String, Integer> dataMap = doCheckDataList(ordreDataList,mobile,codeAndComcateMap);
			String orderid = doGetOrderid();
			doBuildOrderList(wayid,mobile,orderid,dataMap);
			return doReturnSuccVal(orderid,mobile).toString();
		}catch (Exception e) {
			e.printStackTrace();
			LoggerUtils.error(e, logger);
			throw e;
		}
	}

}
