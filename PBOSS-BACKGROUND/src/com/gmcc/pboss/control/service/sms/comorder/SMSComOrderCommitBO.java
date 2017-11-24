package com.gmcc.pboss.control.service.sms.comorder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.MdbgBase;
import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountDBParam;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.nosect.NosectDBParam;
import com.gmcc.pboss.business.resource.nosect.NosectVO;
import com.gmcc.pboss.business.sales.comorderstate.ComorderstateDBParam;
import com.gmcc.pboss.business.sales.comorderstate.ComorderstateVO;
import com.gmcc.pboss.business.sales.orderunit.OrderunitDBParam;
import com.gmcc.pboss.business.sales.orderunit.OrderunitVO;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantDBParam;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantVO;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.wayaccount.Wayaccount;
import com.gmcc.pboss.control.channel.wayaccount.WayaccountBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.resource.nosect.Nosect;
import com.gmcc.pboss.control.resource.nosect.NosectBO;
import com.gmcc.pboss.control.sales.comorder.Comorder;
import com.gmcc.pboss.control.sales.comorder.ComorderBO;
import com.gmcc.pboss.control.sales.comorder.ComorderCheck;
import com.gmcc.pboss.control.sales.comorder.ComorderCheckBO;
import com.gmcc.pboss.control.sales.comorderstate.Comorderstate;
import com.gmcc.pboss.control.sales.comorderstate.ComorderstateBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderunit.Orderunit;
import com.gmcc.pboss.control.sales.orderunit.OrderunitBO;
import com.gmcc.pboss.control.sales.reqcomcate.Reqcomcate;
import com.gmcc.pboss.control.sales.reqcomcate.ReqcomcateBO;
import com.gmcc.pboss.control.sales.wayassistant.Wayassistant;
import com.gmcc.pboss.control.sales.wayassistant.WayassistantBO;
import com.gmcc.pboss.control.service.sms.ServiceSmsBOHelper;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.ActivityRatioResult;
import com.gmcc.pboss.service.sms.result.ComOrderResult;
import com.gmcc.pboss.service.sms.utils.SMSUtils;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.common.utils.logging.LoggingConstant;
import com.sunrise.jop.exception.business.SaleException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.infrastructure.db.hibernate3.SessionFactoryContextHolder;

public class SMSComOrderCommitBO extends AbstractControlBean implements SMSComOrderCommit{

	private static Logger logger = Logger.getLogger(SMSComOrderCommitBO.class);
	
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
			throw new SMSException("����δ�Ǽ�",ComOrderResult.RET_TYPE_FAIL_1);
		}
		EmployeeVO vo = (EmployeeVO)dp.getDatas().get(0);
		if(!"1".equals(vo.getIsnet().toString())){
			throw new SMSException("�ǵ���������Ȩ��",ComOrderResult.RET_TYPE_FAIL_2);
		}
		String wayid = vo.getWayid();
		Way wayBO  = (Way) BOFactory.build(WayBO.class,user);
		WayVO wayVO = wayBO.doFindByPk(wayid);
		if (wayVO == null || wayVO.getWaystate() != 1) {
			throw new SMSException("��������״̬��Ϊ����",ComOrderResult.RET_TYPE_FAIL_3);
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
	private String doCheckOrderQualification(String wayid) throws Exception{
		Wayassistant wayassistant = (Wayassistant)BOFactory.build(WayassistantBO.class, user);
		WayassistantDBParam param = new WayassistantDBParam();
		param.set_se_wayid(wayid);
		DataPackage dp = wayassistant.doQuery(param);
		if(dp.getDatas().size() == 0){
			throw new SMSException("����Ʒ����Ȩ��",ComOrderResult.RET_TYPE_FAIL_3);
		}
		WayassistantVO vo = (WayassistantVO)dp.getDatas().get(0);
		if(vo.getCanorder() == null || !"1".equals(vo.getCanorder().toString())){
			throw new SMSException("����Ʒ����Ȩ��",ComOrderResult.RET_TYPE_FAIL_3);
		}
		return vo.getPaytype();
	}
	
	/**
	 * ��������˺�
	 * @param wayid
	 * @throws Exception
	 */
	private void doCheckBankInformation(String wayid) throws Exception{
		Wayaccount wayaccount = (Wayaccount)BOFactory.build(WayaccountBO.class, user);
		WayaccountDBParam param = new WayaccountDBParam();
		param.set_se_wayid(wayid);
		DataPackage dp = wayaccount.doQuery(param);
		if(dp.getDatas().size() == 0){
			throw new SMSException("�����˺���Ϣ�����ڻ�����",ComOrderResult.RET_TYPE_FAIL_4);
		}
		WayaccountVO vo = (WayaccountVO)dp.getDatas().get(0);
		if(StringUtils.isEmpty(vo.getDeacctno()) || StringUtils.isEmpty(vo.getDeacctname()) || StringUtils.isEmpty(vo.getDebankname())){
			throw new SMSException("�����˺���Ϣ�����ڻ�����",ComOrderResult.RET_TYPE_FAIL_4);
		}
	}
    
	/**
	 * �¶����������
	 * 
	 * @param wayid
	 * @throws Exception
	 */
	private void checkBookTimes(String wayid) throws Exception {
		try {
			Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,
					user);
			comorder.checkMonthBookTimes(wayid);
		} catch (SaleException se) {
			throw new SMSException(se.getMessage(),
					ComOrderResult.RET_TYPE_FAIL_12);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * ��鶩��ʱ��
	 * @throws Exception
	 */
	private void doCheckOrderTime(String wayid) throws Exception{
		try{
			Way wayBO  = (Way) BOFactory.build(WayBO.class,user);
			WayVO wayVO = wayBO.doFindByPk(wayid);
			ComorderCheck comorderCheckBO = (ComorderCheckBO)BOFactory.build(ComorderCheckBO.class,user);
			comorderCheckBO.checkLimitTime(wayVO);
		}catch(SaleException ex){
			throw new SMSException(ex.getMessage(),ComOrderResult.RET_TYPE_FAIL_13);
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
	private Map<String, Integer> doCheckDataList(List<String> orderData) throws Exception {
		Map<String, Integer> dataMap = new HashMap<String, Integer>();
		Comorder comorderBO = (Comorder)BOFactory.build(ComorderBO.class, user);
		for(String data : orderData){
			String[] datas = StringUtils.split(data, "\\"+SMSProtocol.STR_SLIT_SYMBOL);
			if(datas.length != 2){
				throw new SMSException("�����ʽ����(wrong request format)",ComOrderResult.RET_TYPE_FAIL_111);
			}
			
			//�����Ʒ����
			String brand = datas[0].toUpperCase().trim();
			if(dataMap.get(brand) != null){
				throw new SMSException(brand,ComOrderResult.RET_TYPE_FAIL_7);
			}
			
			Dictitem dictitem = (Dictitem)BOFactory.build(DictitemBO.class, user);
			DictitemDBParam dictitemDBParam = new DictitemDBParam();
			dictitemDBParam.set_se_groupid("IM_FXCOMCATEGORY");
			dictitemDBParam.set_se_dictid(brand);
			DataPackage dictitemDp = dictitem.doQuery(dictitemDBParam);
			if(dictitemDp.getDatas().size() == 0){
				throw new SMSException(brand,ComOrderResult.RET_TYPE_FAIL_6);
			}
			
			Comorderstate comorderstate = (Comorderstate)BOFactory.build(ComorderstateBO.class, user);
			ComorderstateDBParam comorderstateDBParam = new ComorderstateDBParam();
			comorderstateDBParam.set_se_cityid(user.getCityid());
			comorderstateDBParam.set_se_comcategory(brand);
			DataPackage comorderstateDp = comorderstate.doQuery(comorderstateDBParam);
			if(comorderstateDp.getDatas().size() != 0){
				ComorderstateVO vo = (ComorderstateVO)comorderstateDp.getDatas().get(0);
				if(!"NORMAL".equals(vo.getOrderstate())){
					throw new SMSException(vo.getMsgcontent(),ComOrderResult.RET_TYPE_FAIL_8);
				}
			}
			
			//�����Ʒ����
			String amount = datas[1].trim();
			if(!PublicUtils.isInteger(amount)){
				throw new SMSException("������������Ϊ����",ComOrderResult.RET_TYPE_FAIL_11);
			}
			if(Integer.parseInt(amount) <= 0){
				throw new SMSException("�����������������",ComOrderResult.RET_TYPE_FAIL_10);
			}
			// ��ȡ�������� 
			// ���ա���Ʒ�������½��еĶ���������ȡ�߼�����ȡָ�����С�ָ����Ʒ����Ķ���������[2010-07-29]
			String unitage = comorderBO.doGetUnitage(user.getCityid(), brand);
			if(Integer.parseInt(amount) % Integer.parseInt(unitage) != 0){
				throw new SMSException(brand+"�Ķ�������["+amount+"]����Ϊ["+unitage+"]��������",ComOrderResult.RET_TYPE_FAIL_9);
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
					throw new SMSException(brand+"�Ķ�������["+amount+"]����Ϊ["+unitage+"]��������",ComOrderResult.RET_TYPE_FAIL_9);
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
	
	private ComOrderResult doReturnSuccVal(String orderid) throws Exception{
		ComOrderResult result = new ComOrderResult();
		
		List<String> list = new ArrayList<String>();
		list.add(orderid);
		
		result.setRet(ComOrderResult.RET_TYPE_SUCC_0);
		result.setMessage("�ɹ�");
		result.setDatas(list);
		return result;
	}
	
	/**
	 * ����ϵͳ��������Ƿ������϶���,�������������أ����������鶩����Ʒ�Ƿ�ΪͬһƷ��
	 */
	private void doCheckMixOrderEnable(List<String> ordreData) throws Exception {
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
			for(String data : ordreData){
				String[] datas = StringUtils.split(data, "\\"+SMSProtocol.STR_SLIT_SYMBOL);//Ʒ��,����
				if(datas.length != 2){
					throw new SMSException("�����ʽ����(wrong request format)",ComOrderResult.RET_TYPE_FAIL_111);
				}
				//�����Ʒ����
				String brand = datas[0].toUpperCase().trim();
				if(tokenRestype==null){//�����һ����Ʒ��������Դ��𱣴�
					tokenRestype = cateAndRes.get(brand);
					continue;
				}
				//����������Ʒ�������Դ����뱣�����Դ���ͬ������
				String restype = cateAndRes.get(brand);
				if(!tokenRestype.equals(restype)){
					throw new SMSException("���ܶ��������Դ���Ķ���",ComOrderResult.RET_TYPE_FAIL_14);
				}
			}	
		}
	}
	
	public String doResult(String mobile,List<String> ordreData) throws Exception{
		try{
			String wayid = doGetWayid(mobile);
			String paytype = doCheckOrderQualification(wayid);
			doCheckMixOrderEnable(ordreData);
			if("BANK".equals(paytype)){//�жϽɷѷ�ʽ�Ƿ�Ϊ���л��ۣ��������������������
				doCheckBankInformation(wayid);
			}
			checkBookTimes(wayid);
			doCheckOrderTime(wayid);
			Map<String, Integer> dataMap = doCheckDataList(ordreData);
			String orderid = doGetOrderid();
			doBuildOrderList(wayid,mobile,orderid,dataMap);
			return doReturnSuccVal(orderid).toString();
		}catch (Exception e) {
			e.printStackTrace();
			LoggerUtils.error(e, logger);
			throw e;
		}
	}

}
