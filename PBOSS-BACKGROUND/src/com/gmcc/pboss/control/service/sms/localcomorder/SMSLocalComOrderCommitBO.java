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
	 * ������������
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	private String doGetWayid(String mobile) throws Exception{
		//�Ŷα�
		logger = ServiceSmsBOHelper.createChildLogger(user.getCityid()
				+ LoggingConstant.SMS_CITY_LOG_ROOT_NAME, this.getClass()
				.getSimpleName());
		//��Ա��
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
			parammap.put("defaultsms", "�𾴵Ŀͻ��������ֻ�������δ�Ǽǣ��޷�Ϊ���ṩ�����������������ϵ��������򲦴�������ߡ�");
			parammap.put("receiveno", mobile);
			throw new SMSException("����δ�Ǽ�",LocalComOrderResult.RET_TYPE_FAIL_2,parammap);
		}
		EmployeeVO vo = (EmployeeVO)dp.getDatas().get(0);
		if(!"1".equals(vo.getIsnet().toString())){
			Map<String,String> map = new HashMap<String,String>();
			Map<String,Object> parammap = new HashMap<String,Object>();
			parammap.put("sid", "FX_ORDER_NOTTHEBOSS");
			parammap.put("keyvaluemap", map);
			parammap.put("defaultsms", "�𾴵Ŀͻ�����Ʒ������ʱֻ���Ÿ�����ʹ�ã��޷�Ϊ���ṩ�����������������ϵ��������򲦴�������ߡ�");
			parammap.put("receiveno", mobile);
			throw new SMSException("�ǵ���������Ȩ��",LocalComOrderResult.RET_TYPE_FAIL_3,parammap);
		}
		String wayid = vo.getWayid();
		Way wayBO  = (Way) BOFactory.build(WayBO.class,user);
		WayVO wayVO = wayBO.doFindByPk(wayid);
		if (wayVO == null || wayVO.getWaystate() != 1) {
			Map<String,Object> parammap = new HashMap<String,Object>();
			parammap.put("defaultsms", "�𾴵Ŀͻ�������������״̬��Ϊ���꣬���ܽ�����Ʒ������");
			parammap.put("receiveno", mobile);
			parammap.put("orderstatecheckflag", "1");
			throw new SMSException("��������״̬��Ϊ����",LocalComOrderResult.RET_TYPE_FAIL_4,parammap);
		}
		date = new Date();
		return wayid;
	}
	
	/**
	 * ��鶩���ʸ�
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
			parammap.put("defaultsms", "�𾴵Ŀͻ�������ʱ���ܷ�����Ʒ����������ϵ��������˲���Ʒ����������Ϣ��");
			parammap.put("receiveno", mobile);
			throw new SMSException("����Ʒ����Ȩ��",LocalComOrderResult.RET_TYPE_FAIL_4,parammap);
		}
		WayassistantVO vo = (WayassistantVO)dp.getDatas().get(0);
		if(vo.getCanorder() == null || !"1".equals(vo.getCanorder().toString())){
			Map<String,String> map = new HashMap<String,String>();
			Map<String,Object> parammap = new HashMap<String,Object>();
			parammap.put("sid", "FX_ORDER_NOAUTH");
			parammap.put("keyvaluemap", map);
			parammap.put("defaultsms", "�𾴵Ŀͻ�������ʱ���ܷ�����Ʒ����������ϵ��������˲���Ʒ����������Ϣ��");
			parammap.put("receiveno", mobile);
			throw new SMSException("����Ʒ����Ȩ��",LocalComOrderResult.RET_TYPE_FAIL_4,parammap);
		}
		return vo.getPaytype();
	}
	
	/**
	 * ��������˺�
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
			parammap.put("defaultsms", "�𾴵Ŀͻ������ǼǵĿ��๺�����������˺���Ϣ���������޷�������Ʒ�������������������ϵ��������򲦴�������ߡ�");
			parammap.put("receiveno", mobile);
			throw new SMSException("�����˺���Ϣ�����ڻ�����",LocalComOrderResult.RET_TYPE_FAIL_7,parammap);
		}
		WayaccountVO vo = (WayaccountVO)dp.getDatas().get(0);
		if(StringUtils.isEmpty(vo.getDeacctno()) || StringUtils.isEmpty(vo.getDeacctname()) || StringUtils.isEmpty(vo.getDebankname())){
			Map<String,String> map = new HashMap<String,String>();
			Map<String,Object> parammap = new HashMap<String,Object>();
			parammap.put("sid", "FX_ORDER_ACCOUNT");
			parammap.put("keyvaluemap", map);
			parammap.put("defaultsms", "�𾴵Ŀͻ������ǼǵĿ��๺�����������˺���Ϣ���������޷�������Ʒ�������������������ϵ��������򲦴�������ߡ�");
			parammap.put("receiveno", mobile);
			throw new SMSException("�����˺���Ϣ�����ڻ�����",LocalComOrderResult.RET_TYPE_FAIL_7,parammap);
		}
	}
    
	/**
	 * �¶����������
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
			parammap.put("defaultsms", "�𾴵Ŀͻ����������ѳɹ�����"+se.getMonmaxtimes().toString()+"�Σ��ﵽ��󶩹����������ܼ����������������������ϵ��������򲦴�������ߡ�");
			parammap.put("receiveno", mobile);
			throw new SMSException(se.getMessage(),
					LocalComOrderResult.RET_TYPE_FAIL_8,parammap);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * ��鶩��ʱ��
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
				parammap.put("defaultsms", "�𾴵Ŀͻ������첻�ṩ��Ʒ���������������������ϵ��������򲦴�������ߡ�");
				parammap.put("receiveno", mobile);
				throw new SMSException(ex.getMessage(),LocalComOrderResult.RET_TYPE_FAIL_9,parammap);
			}else if("SALE-104003".equals(ex.getErrorCode())){
				Map<String,String> map = new HashMap<String,String>();
				map.put("TIMESECT", ex.getTimesect());
				Map<String,Object> parammap = new HashMap<String,Object>();
				parammap.put("sid", "FX_ORDER_TIMESECT");
				parammap.put("keyvaluemap", map);
				parammap.put("defaultsms", "�𾴵Ŀͻ�����������ʱ��Ϊ"+ex.getTimesect()+"����ǰʱ�䲻�ܽ�����Ʒ�������������������ϵ��������򲦴�������ߡ�");
				parammap.put("receiveno", mobile);
				throw new SMSException(ex.getMessage(),LocalComOrderResult.RET_TYPE_FAIL_10,parammap);
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * �����Ʒ�������Ʒ����
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
//				throw new SMSException("�����ʽ����(wrong request format)",LocalComOrderResult.RET_TYPE_FAIL_111);
//			}
			
			//�����Ʒ����
			String brand = comcate.toUpperCase().trim();
			
			String cityrescode = brand;//������ǽ��ţ�cityrescode��ֵ����brand��ֵ
			if("JM".equals(user.getCityid()) && codeAndComcate.containsValue(brand)){
				cityrescode = getCodeFromComcate(brand);//�õ�������Դ����
			}
			if(dataMap.get(brand) != null){
				Map<String,String> map = new HashMap<String,String>();
				map.put("COMCODE", cityrescode);
				Map<String,Object> parammap = new HashMap<String,Object>();
				parammap.put("sid", "FX_ORDER_COMDUP");
				parammap.put("keyvaluemap", map);
				parammap.put("defaultsms", "�𾴵Ŀͻ�������������Ʒ"+cityrescode+"�ظ������޸ĺ����ԡ��������������ϵ��������򲦴�������ߡ�");
				parammap.put("receiveno", mobile);
				throw new SMSException("��Ʒ�ظ�",LocalComOrderResult.RET_TYPE_FAIL_11,parammap);
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
				parammap.put("defaultsms", "�𾴵Ŀͻ�������������Ʒ"+cityrescode+"�����ڣ����޸ĺ����ԡ��������������ϵ��������򲦴�������ߡ�");
				parammap.put("receiveno", mobile);
				throw new SMSException("��Ʒ������",LocalComOrderResult.RET_TYPE_FAIL_12,parammap);
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
					parammap.put("defaultsms", (StringUtils.isBlank(vo.getMsgcontent())?"�𾴵Ŀͻ�������������Ʒ"+cityrescode+
							"��ʱ�����ṩ�������������������ϵ��������򲦴�������ߡ�":vo.getMsgcontent()));
					parammap.put("receiveno", mobile);
					parammap.put("orderstatecheckflag", "1");
					throw new SMSException("��Ʒ����״̬������",LocalComOrderResult.RET_TYPE_FAIL_13,parammap);
				}
			}
			
			//�����Ʒ����
			String amount = count.trim();
			if(!PublicUtils.isInteger(amount) || Integer.parseInt(amount) <= 0){
				Map<String,String> map = new HashMap<String,String>();
				Map<String,Object> parammap = new HashMap<String,Object>();
				parammap.put("sid", "FX_ORDER_DIGITALERR");
				parammap.put("keyvaluemap", map);
				parammap.put("defaultsms", "�𾴵Ŀͻ���������������Ϊ����������������޸ĺ����ԡ��������������ϵ��������򲦴�������ߡ�");
				parammap.put("receiveno", mobile);
				throw new SMSException("���������Ǵ����������",LocalComOrderResult.RET_TYPE_FAIL_14,parammap);
			}
			// ��ȡ�������� 
			// ���ա���Ʒ�������½��еĶ���������ȡ�߼�����ȡָ�����С�ָ����Ʒ����Ķ���������[2010-07-29]
			String unitage = comorderBO.doGetUnitage(user.getCityid(), brand);
			if(Integer.parseInt(amount) % Integer.parseInt(unitage) != 0){
				Map<String,String> map = new HashMap<String,String>();
				map.put("COMCODE", cityrescode);
				map.put("UNITAGE", unitage);
				map.put("ORDERAMT", amount);
				Map<String,Object> parammap = new HashMap<String,Object>();
				parammap.put("sid", "FX_ORDER_UNITAGE");
				parammap.put("keyvaluemap", map);
				parammap.put("defaultsms", "�𾴵Ŀͻ�����Ʒ"+cityrescode+"����������Ϊ"+unitage+"��������������ǰ������Ϊ"+amount+"�����޸ĺ����ԡ��������������ϵ��������򲦴�������ߡ�");
				parammap.put("receiveno", mobile);
				throw new SMSException("������Ʒ�����Ƕ�������������",LocalComOrderResult.RET_TYPE_FAIL_15,parammap);
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
					throw new SMSException(brand+"�Ķ�������["+amount+"]����Ϊ["+unitage+"]��������",LocalComOrderResult.RET_TYPE_FAIL_9);
				}
			}*/
			
			dataMap.put(brand, Integer.parseInt(amount));
		}
		return dataMap;
	}
	
	/**
	 * ��ȡ�������
	 * @return
	 * @throws Exception
	 */
	private String doGetOrderid() throws Exception{
		Order order = (Order)BOFactory.build(OrderBO.class,user);
		return order.doGetOrderId(date);
	}
	
	/**
	 * �齨����
	 * @param orderid
	 * @param dataMap
	 * @throws Exception
	 */
	private void doBuildOrderList(String wayid, String mobile, String orderid, Map<String, Integer> dataMap) throws Exception {
		Reqcomcate reqcomcate = (Reqcomcate)BOFactory.build(ReqcomcateBO.class,user);
		reqcomcate.doBuildOrderList(wayid, mobile, orderid, dataMap, date);
	}
	
	private LocalComOrderResult doReturnSuccVal(String orderid,String mobile) throws Exception{
		//д���Ŵ����ͱ�
		Map<String,String> map = new HashMap<String,String>();
		map.put("ORDERID", orderid);
		String defaultsms = "�𾴵Ŀͻ������Ķ����������ύ��������["+orderid+"]��ϵͳ�����У��������Ժ����֪ͨ��";
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
		//���ض���
		LocalComOrderResult result = new LocalComOrderResult();
		List<String> list = new ArrayList<String>();
		list.add(orderid);
		result.setRet(LocalComOrderResult.RET_TYPE_SUCC_0);
		result.setMessage("�ɹ�");
		result.setDatas(list);
		return result;
	}
	
	/**
	 * ����ϵͳ��������Ƿ������϶���,�������������أ����������鶩����Ʒ�Ƿ�ΪͬһƷ��
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
		if(!enable){//����������϶���
			//��ѯIM_PR_COMCATEGORYRELA����ȡ��Ʒ����-��Դ�����ϣ��ŵ�һ��Map��
			Comcategoryrela comcategoryrela = (Comcategoryrela)BOFactory.build(ComcategoryrelaBO.class, user);
			ComcategoryrelaDBParam params = new ComcategoryrelaDBParam();
			params.setSelectFieldsString("comcategory,restype");
			params.set_pagesize("0");
			params.setDataOnly(true);
			DataPackage dp = comcategoryrela.doLoadComCateAndResType(params);
			List comcateAndRestype = dp.getDatas();
			//key-comcategory��Ʒ����,value-restype��Դ����
			Map<String,String> cateAndRes = new HashMap<String,String>();
			if(comcateAndRestype.size()>0){
				for(Iterator it=comcateAndRestype.iterator();it.hasNext();){
					Map<String,String> temp = (Map<String,String>)it.next();					
					cateAndRes.put(temp.get("comcategory"), temp.get("restype"));
				}
			}
			
			//��Ʒ��Դ���ͱ�Ǳ���
			String tokenRestype = null;
			for(Map<String,String> comcateAndCountMap: ordreDataList){
				if(tokenRestype==null){//�����һ����Ʒ��������Դ��𱣴�
					tokenRestype = cateAndRes.get(comcateAndCountMap.keySet().iterator().next());
					continue;
				}
				//����������Ʒ�������Դ����뱣�����Դ���ͬ������
				String restype = cateAndRes.get(comcateAndCountMap.keySet().iterator().next());
				if(!tokenRestype.equals(restype)){
					Map<String,String> map = new HashMap<String,String>();
					Map<String,Object> parammap = new HashMap<String,Object>();
					parammap.put("sid", "FX_ORDER_SINGLERES");
					parammap.put("keyvaluemap", map);
					parammap.put("defaultsms", "�𾴵Ŀͻ������ζ���ֻ����һ����Դ������޸ĺ����ԡ��������������ϵ��������򲦴�������ߡ�");
					parammap.put("receiveno", mobile);
					throw new SMSException("���ܶ��������Դ���Ķ���",LocalComOrderResult.RET_TYPE_FAIL_6,parammap);
				}
			}
		}
	}
	
	private Map<String,String> getCodeAndComcateMap() throws Exception {
		//������������Ӧ��ϵ���ϣ���ѯ������Դ�����Ӧ��(IM_PR_CITYRESCODE)��
		//ƥ���й�˾��ʶΪ�������У�����Ӧ��ϵһ�����롣
		Cityrescode cityrescode = (Cityrescode)BOFactory.build(CityrescodeBO.class, user);
		CityrescodeDBParam cparams = new CityrescodeDBParam();
		cparams.set_se_cityid(user.getCityid());
		DataPackage dp = cityrescode.doQuery(cparams);
		List<CityrescodeVO> codeAndComcateList = dp.getDatas();
		//key-cityrescode������Դ����,value-comcategory��Ʒ�������
		Map<String,String> codeAndComcate = new HashMap<String,String>();
		if(codeAndComcateList.size()>0){
			for(CityrescodeVO cityrescodevo:codeAndComcateList){
				codeAndComcate.put(cityrescodevo.getCityrescode(),cityrescodevo.getComcategory());
			}
		}
		return codeAndComcate;
	}
	
	//������Ʒ����ó�������Դ����
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
	 * 4��	�����Դ���������,����list��list��ÿ��mapΪһ����Ʒ�����Ӧһ������
	 */
	private List<Map<String,String>> doSplitResCount(String ordreData,String mobile,Map<String,String> codeAndComcate) throws Exception {
		List<Map<String,String>> returnList = new ArrayList<Map<String,String>>();
		//Ȼ����ݺ���������в����Դ���������
		if("JM".equals(user.getCityid())){//����,ordreData��Ϸ�ʽ�硰a10b20c60��
			//�㷨�� 1.���ַ�����λ��ʼ����ѭ����飬����������� ��������
			//	    2.����������,�ж���ǰһ���ǲ�����ĸ,�����,���ڸ�����ǰ�����"#"��
			//      3.�����ж�����һ���ǲ�����ĸ,�����,���ڸ����ֺ������","��
			String buf = ordreData;
			int stringlength = buf.length();
			for(int i=0;i<ordreData.length();i++){
				if(Character.isDigit(ordreData.charAt(i))){//���������
					if(i-1<0){
						continue;
					}else{
						if(Character.isLetter(ordreData.charAt(i-1))){//���ǰһ������ĸ
							buf=buf.substring(0,i+(buf.length()-ordreData.length()))+"#"+buf.substring(i+(buf.length()-ordreData.length()));
							stringlength++;
						}
					}
					if(i+1>=ordreData.length()){
						continue;
					}else{
						if(Character.isLetter(ordreData.charAt(i+1))){//�����һ������ĸ
							buf=buf.substring(0,i+1+(buf.length()-ordreData.length()))+","+buf.substring(i+1+(buf.length()-ordreData.length()));
							stringlength++;
						}
					}
				}
			}
			//�����Ѿ��õ�������������ͬ��ͨ�ø�ʽ�ַ������硰a#30��b#50��c#20����������и�����������ͬ�Ĵ���
			List<String> dataList = Arrays.asList(StringUtils.split(buf, ","));//���
//			if(dataList.size()==1)
//				dataList = Arrays.asList(StringUtils.split(buf, "��"));//ȫ��
//			if(dataList.size()==1){
//				Map<String,String> map = new HashMap<String,String>();
//				map.put("CUSTSMS","FXDH"+ordreData);
//				Map<String,Object> parammap = new HashMap<String,Object>();
//				parammap.put("sid", "FX_ORDER_SMSFORMATERR");
//				parammap.put("keyvaluemap", map);
//				parammap.put("defaultsms", "�𾴵Ŀͻ��������͵Ķ��� "+"FXDH"+ordreData+" ��ʽ����ȷ�����޸ĺ����ԡ�");
//				parammap.put("receiveno", mobile);
//				throw new SMSException("���Ÿ�ʽ����",LocalComOrderResult.RET_TYPE_FAIL_5,parammap);
//			}
				
			for(String data : dataList){
				String[] datas = StringUtils.split(data, "\\"+SMSProtocol.DATA_SLIT_SYMBOL);//��Ʒ����,����
				if(datas.length != 2){
					Map<String,String> map = new HashMap<String,String>();
					map.put("CUSTSMS","FXDH"+ordreData);
					Map<String,Object> parammap = new HashMap<String,Object>();
					parammap.put("sid", "FX_ORDER_SMSFORMATERR");
					parammap.put("keyvaluemap", map);
					parammap.put("defaultsms", "�𾴵Ŀͻ��������͵Ķ��� "+"FXDH"+ordreData+" ��ʽ����ȷ�����޸ĺ����ԡ�");
					parammap.put("receiveno", mobile);
					throw new SMSException("���Ÿ�ʽ����",LocalComOrderResult.RET_TYPE_FAIL_5,parammap);
				}
				Map<String,String> comcateAndCountMap = new HashMap<String,String>();
				if(codeAndComcate.containsKey(datas[0]))
					comcateAndCountMap.put(codeAndComcate.get(datas[0]), datas[1]);
				else
					comcateAndCountMap.put(datas[0], datas[1]);
				returnList.add(comcateAndCountMap);
			}
		}else{//������ͨ�ø�ʽ�����硰a#30��b#50��c#20��
			ordreData = StringUtils.replaceAll(ordreData, "��", ",");//��ȫ�Ƕ���ͳһ���ɰ�Ƕ���
			List<String> dataList = Arrays.asList(StringUtils.split(ordreData, ","));//���
//			if(dataList.size()==1){
//				Map<String,String> map = new HashMap<String,String>();
//				map.put("CUSTSMS","FXDH"+ordreData);
//				Map<String,Object> parammap = new HashMap<String,Object>();
//				parammap.put("sid", "FX_ORDER_SMSFORMATERR");
//				parammap.put("keyvaluemap", map);
//				parammap.put("defaultsms", "�𾴵Ŀͻ��������͵Ķ��� "+"FXDH"+ordreData+" ��ʽ����ȷ�����޸ĺ����ԡ�");
//				parammap.put("receiveno", mobile);
//				throw new SMSException("���Ÿ�ʽ����",LocalComOrderResult.RET_TYPE_FAIL_5,parammap);
//			}
				
			for(String data : dataList){
				String[] datas = StringUtils.split(data, "\\"+SMSProtocol.DATA_SLIT_SYMBOL);//��Ʒ����,����
				if(datas.length != 2){
					Map<String,String> map = new HashMap<String,String>();
					map.put("CUSTSMS","FXDH"+ordreData);
					Map<String,Object> parammap = new HashMap<String,Object>();
					parammap.put("sid", "FX_ORDER_SMSFORMATERR");
					parammap.put("keyvaluemap", map);
					parammap.put("defaultsms", "�𾴵Ŀͻ��������͵Ķ��� "+"FXDH"+ordreData+" ��ʽ����ȷ�����޸ĺ����ԡ�");
					parammap.put("receiveno", mobile);
					throw new SMSException("���Ÿ�ʽ����",LocalComOrderResult.RET_TYPE_FAIL_5,parammap);
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
//		ordreData = StringUtils.replaceIgnoreCase(ordreData, "��", "#");
//		return ordreData;
	}
	
	public String doResult(String mobile,String ordreData) throws Exception{
		try{
			String wayid = doGetWayid(mobile);
			String paytype = doCheckOrderQualification(wayid,mobile);
			Map<String,String> codeAndComcateMap = getCodeAndComcateMap();
			List<Map<String,String>> ordreDataList = doSplitResCount(ordreData, mobile,codeAndComcateMap);
			doCheckMixOrderEnable(ordreDataList,mobile);
			if("BANK".equals(paytype)){//�жϽɷѷ�ʽ�Ƿ�Ϊ���л��ۣ��������������������
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
