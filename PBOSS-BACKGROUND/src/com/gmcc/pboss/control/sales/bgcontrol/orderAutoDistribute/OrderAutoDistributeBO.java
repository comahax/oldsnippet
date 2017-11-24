package com.gmcc.pboss.control.sales.bgcontrol.orderAutoDistribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.base.operator.OperatorDBParam;
import com.gmcc.pboss.business.base.operator.OperatorVO;
import com.gmcc.pboss.business.base.operrole.OperroleDBParam;
import com.gmcc.pboss.business.base.operrole.OperroleVO;
import com.gmcc.pboss.business.base.smstmpl.SmstmplVO;
import com.gmcc.pboss.business.base.sysparam.SysparamDBParam;
import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.comcatebrand.ComcatebrandDBParam;
import com.gmcc.pboss.business.resource.comcatebrand.ComcatebrandVO;
import com.gmcc.pboss.business.resource.stkalarmstat.StkalarmstatVO;
import com.gmcc.pboss.business.sales.bgbusiness.orderAutoDistribute.OrderAutoDistributeDAO;
import com.gmcc.pboss.business.sales.comdisscale.ComdisscaleDBParam;
import com.gmcc.pboss.business.sales.comdisscale.ComdisscaleVO;
import com.gmcc.pboss.business.sales.comorder.ComorderConstant;
import com.gmcc.pboss.business.sales.comorder.ComorderVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitDBParam;
import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitVO;
import com.gmcc.pboss.business.sales.realtimeamt.RealtimeamtDBParam;
import com.gmcc.pboss.business.sales.realtimeamt.RealtimeamtVO;
import com.gmcc.pboss.business.sales.stockalarm.StockalarmDBParam;
import com.gmcc.pboss.business.sales.stockalarm.StockalarmVO;
import com.gmcc.pboss.business.sales.stockalmfloat.StockalmfloatVO;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantDBParam;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantVO;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.base.operator.Operator;
import com.gmcc.pboss.control.base.operator.OperatorBO;
import com.gmcc.pboss.control.base.operrole.Operrole;
import com.gmcc.pboss.control.base.operrole.OperroleBO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.communication.pendingtask.Pendingtask;
import com.gmcc.pboss.control.communication.pendingtask.PendingtaskBO;
import com.gmcc.pboss.control.resource.comcatebrand.ComcatebrandBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.resource.stkalarmstat.Stkalarmstat;
import com.gmcc.pboss.control.resource.stkalarmstat.StkalarmstatBO;
import com.gmcc.pboss.control.sales.comdisscale.Comdisscale;
import com.gmcc.pboss.control.sales.comdisscale.ComdisscaleBO;
import com.gmcc.pboss.control.sales.comorder.Comorder;
import com.gmcc.pboss.control.sales.comorder.ComorderBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderuplimit.Orderuplimit;
import com.gmcc.pboss.control.sales.orderuplimit.OrderuplimitBO;
import com.gmcc.pboss.control.sales.realtimeamt.Realtimeamt;
import com.gmcc.pboss.control.sales.realtimeamt.RealtimeamtBO;
import com.gmcc.pboss.control.sales.stockalarm.Stockalarm;
import com.gmcc.pboss.control.sales.stockalarm.StockalarmBO;
import com.gmcc.pboss.control.sales.wayassistant.Wayassistant;
import com.gmcc.pboss.control.sales.wayassistant.WayassistantBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.TimeUtils;
import com.sunrise.jop.exception.business.SaleException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class OrderAutoDistributeBO extends AbstractControlBean implements
		OrderAutoDistribute {

	private Logger log = Logger.getLogger(OrderAutoDistributeBO.class);

	// �ռ����ж�������Ʒ����������_add by yedaoe
	List<ComorderVO> comorderListForAllOrders = new LinkedList<ComorderVO>();
	// ������ʶ,�������֮���ԡ�/���ָ�
	String orderidstr = "";

	public void doProcess() throws Exception {

		// boolean isDifBrand = this.checkBrand();
		Set<String> brandSet = this.getSmpBrandSet();
		this.orderDistribution(brandSet);
		// ɾ�����ۼƷ��������͡��������ܡ��߼�
		// this.orderCollection(orderCollection);
	}

	/**
	 * ����Ƿ�����Ʒ��
	 * 
	 * @return
	 * @throws Exception
	 */
	private boolean checkBrand() throws Exception {
		Sysparam spBo = (SysparamBO) BOFactory.build(SysparamBO.class, user);
		String paramValue = spBo.doFindByID(12L, "pboss_fx");
		if (StringUtils.isEmpty(paramValue))
			throw new Exception("����[�Ƿ�����Ʒ��]δ����");
		if ("1".equals(paramValue))
			return true;
		else
			return false;
	}

	/**
	 * 1) ���롾�׿�Ʒ�Ƽ��ϡ�
	 * 
	 * @param isDifBrand
	 * @return
	 * @throws Exception
	 */
	private Set<String> getSmpBrandSet() throws Exception {
		Dictitem diBO = (Dictitem) BOFactory.build(DictitemBO.class, user);
		DictitemDBParam param = new DictitemDBParam();
		param.set_se_groupid("FX_SMPBRAND");
		param.set_pagesize("0");
		param.setDataOnly(true);
		// if (isDifBrand) {
		param.set_sne_dictid("AllBrand");
		// } else {
		// param.set_se_dictid("AllBrand");
		// }
		DataPackage dp = diBO.doQuery(param);
		Set<String> brandSet = new HashSet();
		List list = dp.getDatas();
		for (int i = 0; i < list.size(); i++) {
			DictitemVO vo = (DictitemVO) list.get(i);
			brandSet.add(vo.getDictid());
		}
		return brandSet;
	}

	/**
	 * 2) ���롾�׿�Ʒ�ư���С��
	 * 
	 * @return
	 * @throws Exception
	 */
	private Map<String, Integer> getBrandPackSize(Set<String> brandSet)
			throws Exception {
		Sysparam spBo = (SysparamBO) BOFactory.build(SysparamBO.class, user);
		String paramValue = spBo.doFindByID(5L, "pboss_fx");
		if (StringUtils.isEmpty(paramValue))
			throw new Exception("����[�׿�Ʒ�ư���С]δ����");
		String[] packSizeArr1 = StringUtils.split(paramValue, "|");
		Map<String, Integer> brandPackSizeMap = new HashMap<String, Integer>();
		for (String packSize : packSizeArr1) {
			String[] packSizeArr2 = StringUtils.splitByWholeSeparator(packSize,
					":");
			try {
				Integer packsize = Integer.parseInt(packSizeArr2[1]);
				if (packsize <= 0)
					throw new Exception();
				brandPackSizeMap.put(packSizeArr2[0], packsize);
			} catch (Exception ex) {
				throw new Exception("����[�׿�Ʒ�ư���С]���ô���Ҫ��Ϊ����0������");
			}
		}
		// ��Ʒ�Ƽ���Ϊ��������Ʒ�ư���СMAP�������ƥ�䣬���ƥ��ʧ�������������[�׿�Ʒ�ư���С]���ô���
		// ��Ʒ��[XX]δ���ð���С�����˳������������

		for (Iterator<String> it = brandSet.iterator(); it.hasNext();) {
			String brand = it.next();
			if (!brandPackSizeMap.containsKey(brand)) {
				throw new Exception("����[�׿�Ʒ�ư���С]���ô��󣬸�Ʒ��[" + brand + "]δ���ð���С");
			}
		}

		return brandPackSizeMap;
	}

	/**
	 * 3) ���롾Ʒ�ƺ���Ʒ���༯�ϡ�
	 * 
	 * @param brandSet
	 *            Ʒ�Ƽ���
	 * @return
	 * @throws Exception
	 */
	private Map<String, List<String>> getBrandComcategory(Set<String> brandSet)
			throws Exception {

		// ��ѯ��Ʒ����Ʒ�ƶ�Ӧ��ϵ��(IM_PR_COMCATEBRAND)������Ʒ�ƺ���Ʒ�����Ӧ��ϵ��
		ComcatebrandBO comcatebrandBO = (ComcatebrandBO) BOFactory.build(
				ComcatebrandBO.class, user);
		ComcatebrandDBParam comcatdb = new ComcatebrandDBParam();
		comcatdb.setQueryAll(true);
		comcatdb.setDataOnly(true);
		// ��ѯ���е���Ʒ����Ʒ�ƶ�Ӧ��ϵ���ݣ�Ȼ����Ʒ����Ϣ���бȽ�
		DataPackage dp = comcatebrandBO.doQuery(comcatdb);
		Map<String, List<String>> brandComcateMap = new HashMap<String, List<String>>();
		// ��Ʒ����Ϣ���бȽ�

		if (dp != null && dp.getDatas() != null) {
			List datalist = dp.getDatas();
			for (Iterator<String> it = brandSet.iterator(); it.hasNext();) {
				String brand = it.next();
				List<String> comCateList = new ArrayList<String>();
				for (int i = 0; i < datalist.size(); i++) {
					ComcatebrandVO comc = (ComcatebrandVO) datalist.get(i);
					if (comc.getBrand() != null && brand != null) {
						if (comc.getBrand().equals(brand)) {
							comCateList.add(comc.getComcategory());
						}
					}
				}

				brandComcateMap.put(brand, comCateList);
			}
		}

		return brandComcateMap;
	}

	/**
	 * 4) ���롾��Ʒ����������á�
	 * 
	 * @param brandSet
	 *            Ʒ�Ƽ���
	 * @return
	 * @throws Exception
	 */
	private List getBrandComDisScale(Set<String> brandSet) throws Exception {

		// ��ѯ��Ʒ����������ñ� (FX_RU_COMDISSCALE)��������������������Ʒ�������δ���á����˳���
		// ���򱣴�ñ����ݵ������У�������ʹ�á�

		Comdisscale cdsBO = (Comdisscale) BOFactory.build(ComdisscaleBO.class,
				user);
		ComdisscaleDBParam params = new ComdisscaleDBParam();
		params.set_pagesize("0");
		params.setDataOnly(true);
		// Map<String, Map<String, Double>> brandComDisScaleMap = new
		// HashMap<String, Map<String, Double>>();
		params.setQueryAll(true);
		params.setDataOnly(true);
		DataPackage dp = cdsBO.doQuery(params);
		if (dp == null || dp.getDatas() == null) {
			throw new Exception("��Ʒ�������δ����");
		}
		List listdiscale = dp.getDatas();

		// for (Iterator<String> it = brandSet.iterator(); it.hasNext();) {
		// String brand = it.next();
		// Map<String, Double> comDisScaleMap = new TreeMap<String, Double>();
		// for (int i = 0; i < listdiscale.size(); i++) {
		// ComdisscaleVO vo = (ComdisscaleVO) listdiscale.get(i);
		// if(vo.getBrand()!=null && vo.getBrand().equals(brand)){
		// comDisScaleMap.put(vo.getComcategory(), vo.getDisscale());
		// }
		// }
		// brandComDisScaleMap.put(brand, comDisScaleMap);
		// }
		return listdiscale;
	}

	/**
	 * 5) ��������
	 * 
	 * @param brandSet
	 * @throws Exception
	 */
	private void orderDistribution(Set<String> brandSet) throws Exception {
		Wayassistant waBO = (Wayassistant) BOFactory.build(
				WayassistantBO.class, user);
		WayassistantDBParam waParams = new WayassistantDBParam();
		waParams.set_ne_canorder("1");
		waParams.set_pagesize("0");
		// waParams.set_se_wayid("TDZS04C102130");
		waParams.setDataOnly(true);
		DataPackage waDp = waBO.doQuery(waParams);
		List waList = waDp.getDatas();
		// ��Ʒ�����������
		// Map<String, Map<String, Double>> brandComDisScaleMap = this
		// .getBrandComDisScale(brandSet);
		List brandComDisScaleMap = this.getBrandComDisScale(brandSet);
		// Ʒ�ư���С
		Map<String, Integer> brandPackSizeMap = this.getBrandPackSize(brandSet);
		// ɾ�����ۼƷ��������͡��������ܡ��߼�
		// <�ֹ�˾,Ԥ������������Ϣ>
		// Map<String, AlaordercolVO> orderCollection = new HashMap<String,
		// AlaordercolVO>();

		for (int i = 0; i < waList.size(); i++) {
			try {
				WayassistantVO waVO = (WayassistantVO) waList.get(i);
				String wayid = waVO.getWayid();

				// ��ȡ��������

				WayVO wayvo = this.getWayinfo(wayid);

				// ��ȡ�����
				Map<String, Long> brandStocks = this.getBrandStocks(wayid,
						brandSet);
				// ��ȡ��߿���Ԥ����ֵ
				Map<String, Object[]> maxStockAndAlarmMap = this
						.getMaxStockAndAlarm(wayid, brandSet);

				// ��ȡ��Ʒ������
				Map<String, Object[]> brandComDisAmountMap = this
						.getBrandComDisAmount(brandStocks, maxStockAndAlarmMap,
								brandComDisScaleMap, brandPackSizeMap, wayvo);
				// ����������
				brandComDisAmountMap = this.orderDisCheck(brandComDisAmountMap,
						wayid);
				// ɾ�����ۼƷ��������͡��������ܡ��߼�
				// �������� �� �ۼƷ�����
				this.createOrderAndAccuAmount(brandComDisAmountMap, wayid,
						waVO, brandStocks);
			} catch (Exception ex) {
				LoggerUtils.error(ex, log);
				continue;
			}
		}
		if (comorderListForAllOrders.size() > 0) {
			// ����comorderListForAllOrders��װ������Ʒ����1:����1����Ʒ����2:����2��������
			String comcategoryAndAmountStr = this
					.joinComcategoryAndAmountStr(comorderListForAllOrders);
			Boolean isBatch = (orderidstr.indexOf("/") != (orderidstr.length() - 1));// �Ƿ�����
			// ȥ��orderidstr�����һ��"/"
			if (orderidstr.length() > 1)
				orderidstr = orderidstr.substring(0, orderidstr.length() - 1);
			// ������ɶ����Ƚ϶�,ֻ��ʾǰ3��
			String[] content = StringUtils.split(orderidstr, "/");
			if (content.length > 3) {
				orderidstr = content[0] + "/" + content[1] + "/" + content[2];
			}
			// �����������ż�����֪ͨ
			this.doCheckForSmsAndTodo(isBatch, comcategoryAndAmountStr,
					orderidstr);
		}
		// ɾ�����ۼƷ��������͡��������ܡ��߼�
		// return orderCollection;
	}

	/**
	 * 5)�������� -> (a) ��ȡ������Ϣ
	 * 
	 * @param wayid
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	public WayVO getWayinfo(String wayid) throws Exception {

		// ���ݺ����̱����ѯ������(CH_PW_WAY)������������������������[XX]���������ϡ������ش�����һ�����ݣ�
		// �������״̬��Ч����WAYSTATE<>1���������־��������[XX]����״̬��Ч�������ش�����һ����¼�����������
		// ��¼�ֹ�˾��΢�����Ǽ���Ϣ������ʹ�á�
		Way bo = (Way) BOFactory.build(WayBO.class, user);
		WayVO vo = bo.doFindByPk(wayid);
		if (vo == null) {
			throw new Exception("������[" + wayid + "]����������");
		}
		if (vo.getWaystate() != 1) {
			throw new Exception("������[" + wayid + "]����״̬��Ч");
		}

		return vo;
	}

	/**
	 * 5)�������� -> (b) ��ȡ�����
	 * 
	 * @param wayid
	 * @param brandSet
	 * @return
	 * @throws Exception
	 */
	private Map<String, Long> getBrandStocks(String wayid, Set<String> brandSet)
			throws Exception {
		Realtimeamt rtBO = (Realtimeamt) BOFactory.build(RealtimeamtBO.class,
				user);
		RealtimeamtDBParam params = new RealtimeamtDBParam();
		params.set_pagesize("0");
		params.setDataOnly(true);
		params.set_se_wayid(wayid);
		DataPackage dp = rtBO.doQuery(params);
		List list = dp.getDatas();
		Map<String, Long> brandStockMap = new HashMap<String, Long>();
		for (Iterator<String> it = brandSet.iterator(); it.hasNext();) {
			brandStockMap.put(it.next(), 0L); // Ĭ�Ͽ����Ϊ��
		}
		for (int j = 0; j < list.size(); j++) {
			RealtimeamtVO rtVO = (RealtimeamtVO) list.get(j);
			String brand = rtVO.getBrand();
			Long stock = rtVO.getNowstock();
			if (brandStockMap.containsKey(brand) && stock != null)
				brandStockMap.put(brand, stock);
		}
		return brandStockMap;
	}

	/**
	 * 5) �������� (c) ��ȡ��߿���Ԥ����ֵ
	 * 
	 * @param wayid
	 * @return
	 * @throws Exception
	 */
	private Map<String, Object[]> getMaxStockAndAlarm(String wayid,
			Set<String> brandSet) throws Exception {

		try {
			Stockalarm saBO = (Stockalarm) BOFactory.build(StockalarmBO.class,
					user);
			StockalarmDBParam params = new StockalarmDBParam();
			params.set_pagesize("0");
			params.setDataOnly(true);
			params.set_se_wayid(wayid);
			DataPackage dp = saBO.doQuery(params);
			List list = dp.getDatas();
			Map<String, Object[]> maxStockAndAlarmMapTemp1 = new HashMap<String, Object[]>();// ������Ԥ�����ñ��еĶ�Ӧ��ϵmap
			Map<String, Object[]> maxStockAndAlarmMapTemp2 = new HashMap<String, Object[]>();// �������������ñ��еĶ�Ӧ��ϵmap
			Map<String, Object[]> maxStockAndAlarmMap = new HashMap<String, Object[]>();// ����Ҫ���صĶ�Ӧ��ϵmap
			if (list.size() > 0) {
				for (int j = 0; j < list.size(); j++) {
					StockalarmVO saVO = (StockalarmVO) list.get(j);
					Object[] objArr = { saVO.getMaxstock(),
							saVO.getAlarmvalue() };
					maxStockAndAlarmMapTemp1.put(saVO.getBrand(), objArr);
				}
			}
			// Ȼ����ݵ��б�ʶ���ֹ�˾�����ع�˾��ʶCOUNTYID�����Ǽ���Լ��ģʽ��Ĭ��ȡԤ�����ģʽ��
			// ��ѯ�������������ñ�FX_RU_ORDERUPLIMIT������ȡƷ�ơ���߿�桢Ԥ����ֵ��
			Way wayBO = (Way) BOFactory.build(WayBO.class, user);
			WayVO wayVO = wayBO.doFindByPk(wayid);
			if (wayVO == null)
				throw new Exception("������[" + wayid + "]������,���ʵ");
			String cityid = wayVO.getCityid();
			Long starlevel = wayVO.getStarlevel();
			String countyid = wayVO.getCountyid();
			if (StringUtils.isEmpty(cityid))
				throw new Exception("������[" + wayid + "]�ĵ��б�ʶ (cityid) Ϊ��");
			if (StringUtils.isEmpty(countyid))
				throw new Exception("������[" + wayid + "]�ķֹ�˾ (countyid) Ϊ��");
			if (starlevel == null)
				throw new Exception("������[" + wayid + "]���Ǽ� (starlevel) Ϊ��");

			Orderuplimit olBO = (Orderuplimit) BOFactory.build(
					OrderuplimitBO.class, user);
			OrderuplimitDBParam olParams = new OrderuplimitDBParam();
			olParams.set_se_cityid(cityid);
			olParams.set_se_countyid(countyid);
			olParams.set_ne_starlevel(starlevel + "");
			olParams.set_se_limitmode("STOCKALARM");
			olParams.setDataOnly(true);
			olParams.set_pagesize("0");
			DataPackage olDp = olBO.doQuery(olParams);
			List olList = olDp.getDatas();
			if (olList.size() > 0) {
				for (int i = 0; i < olList.size(); i++) {
					OrderuplimitVO olVO = (OrderuplimitVO) olList.get(i);
					Object[] objArr = { olVO.getMaxstock(),
							olVO.getAlarmvalue() };
					maxStockAndAlarmMapTemp2.put(olVO.getBrand(), objArr);
				}
			}

			Sysparam sysparamBO = (SysparamBO) BOFactory.build(
					SysparamBO.class, user);
			SysparamVO sysparamVO = new SysparamVO();
			sysparamVO.setParamtype("pboss_fx");
			sysparamVO.setSystemid(new Long(73));
			sysparamVO = sysparamBO.doFindByPk(sysparamVO);

			// ��Ʒ�Ƽ���Ϊ����������߿���Ԥ����ֵ������䣬������ͬƷ��ʱ��������Ԥ������Ϊ׼
			for (Iterator<String> it = brandSet.iterator(); it.hasNext();) {
				String brandtemp = it.next();

				// ����׿�Ʒ��Ϊ���������Ĵ���
				if (sysparamVO.getParamvalue().toString().equals("1")) {
					// if (maxStockAndAlarmMapTemp1.containsKey(brandtemp)) {
					Object[] obj = checkExit(maxStockAndAlarmMapTemp1,
							brandtemp);
					Object[] obj2 = checkExit(maxStockAndAlarmMapTemp2,
							brandtemp);
					if (null != obj) {
						maxStockAndAlarmMap.put(brandtemp, obj);
					} else {
						if (null != obj2) {
							maxStockAndAlarmMap.put(brandtemp, obj2);
						}
					}

				} else {
					if (maxStockAndAlarmMapTemp1.containsKey(brandtemp)) {
						maxStockAndAlarmMap.put(brandtemp,
								maxStockAndAlarmMapTemp1.get(brandtemp));
					} else {
						if (maxStockAndAlarmMapTemp2.containsKey(brandtemp)) {
							maxStockAndAlarmMap.put(brandtemp,
									maxStockAndAlarmMapTemp2.get(brandtemp));
						}
					}
				}
			}

			if (maxStockAndAlarmMap.size() == 0)
				throw new Exception("�����̱���[" + wayid + "]��Ԥ���������");

			return maxStockAndAlarmMap;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 5) �������� (d) ��ȡ��Ʒ������
	 * 
	 * @param brandStocks
	 *            Ʒ�ƿ��������
	 * @param maxStockAndAlarm
	 *            ��߿���Ԥ����ֵ
	 * @param brandComDisScale
	 *            ��Ʒ�����������
	 * @param brandPackSize
	 *            Ʒ�ư���С
	 * @param wayid
	 * @return
	 * @throws Exception
	 */
	private Map<String, Object[]> getBrandComDisAmount(
			Map<String, Long> brandStocks,
			Map<String, Object[]> maxStockAndAlarm, List brandComDisScale1,
			Map<String, Integer> brandPackSize, WayVO way) throws Exception {
		String wayid = way.getWayid();
		Map<String, Object[]> brandComDisAmountMap = new HashMap<String, Object[]>();
		Map<String, Map<String, Double>> brandComDisScale = null;
		for (Iterator<String> it = brandStocks.keySet().iterator(); it
				.hasNext();) {
			String brand = it.next();
			// ���������Ԥ����ֵ
			Object[] stockAndAlarm = maxStockAndAlarm.get(brand);
			if (stockAndAlarm == null)
				continue;
			// �����
			Long stock = brandStocks.get(brand);
			String alarmValue = (String) stockAndAlarm[1];
			String[] arr1 = StringUtils.split(alarmValue, ";");
			// Ԥ������ͷ�ֵMap
			Map<String, Long> classAndAlarmValue = new TreeMap<String, Long>();
			// ��ֵlist
			for (String temp : arr1) {
				String[] arr2 = StringUtils.splitByWholeSeparator(temp, ":");
				classAndAlarmValue.put(arr2[0], Long.parseLong(arr2[1]));
			}
			Collection<Long> values = classAndAlarmValue.values();
			Long closelyAlarmValue = this.getCloselyAlarmValue(stock, values);
			if (closelyAlarmValue == null)
				// ��������������е�Ԥ����ֵʱ�������Ʒ��
				continue;
			// ��ӦԤ����ֵ��Ԥ������
			String alarmClass = "";
			for (Iterator<String> caIt = classAndAlarmValue.keySet().iterator(); caIt
					.hasNext();) {
				String aClass = caIt.next();
				Long aValue = classAndAlarmValue.get(aClass);
				if (closelyAlarmValue == aValue) {
					alarmClass = aClass;
					break;
				}
			}

			log.info("������: " + wayid + "��Ʒ��  [" + brand + "] ��߿�� = "
					+ stockAndAlarm[0] + "; ��ǰ��� = " + stock);
			// Ʒ�Ʒ�����=��߿��-��ǰ���
			Long brandDisAmount = (Long) stockAndAlarm[0] - stock;
			if (brandDisAmount <= 0) {
				log.info("������: " + wayid + "��Ʒ��  [" + brand + "] ��߿�� "
						+ stockAndAlarm[0] + "С�ڻ���ڵ�ǰ��� " + stock
						+ ",���Ʒ�Ʒ�����С�ڻ����0,����ҪΪ�ú�����Ʒ�ƽ��з���; ");
				continue;
			}

			// �õ����õ���Ʒ���������

			brandComDisScale = this.getSalecale(brandComDisScale1, brand, way);
			if (brandComDisScale == null || brandComDisScale.get(brand) == null) {
				continue;
			}

			if (!brandComDisScale.containsKey(brand)) {
				continue;
			} else {

				if (!brandPackSize.containsKey(brand)) {
					log.info("������: " + wayid + " ��Ʒ��[" + brand
							+ "]��\"Ʒ�ư���С\"û������");
					continue;
				}
				// �ܰ���=Ʒ�Ʒ�����/Ʒ�ư���С������ȡ������(CR_ZQ20100702_1075333)
				double totalPackDouble = Math.ceil((double) brandDisAmount
						/ (double) brandPackSize.get(brand));
				Long totalPack = new Double(totalPackDouble).longValue();
				// ��Ʒ���༰��������

				TreeMap<String, Double> comDisScale = (TreeMap<String, Double>) brandComDisScale
						.get(brand);

				// ��Ʒ���༰�������
				Map<String, Long> comCateDisAmount = new HashMap<String, Long>();
				// ����Ʒ�������֮��
				Long comCatePackSum = 0L;

				Collection scaleCol = comDisScale.values();
				Object[] scaleArray = scaleCol.toArray();
				Arrays.sort(scaleArray);

				// ��ߵķ������
				Double maxScale = (Double) scaleArray[scaleArray.length - 1];
				if (maxScale == 0.0) {
					// ���������Ʒ����ķ������������0���򽫸�Ʒ����ȥ
					continue;
				}
				// ��߷��������Ӧ����Ʒ����
				String comCateforMaxScale = "";

				for (Iterator<String> iterator = comDisScale.keySet()
						.iterator(); iterator.hasNext();) {
					String comCategory = iterator.next();
					Double scale = (Double) comDisScale.get(comCategory);
					if (scale == maxScale)
						comCateforMaxScale = comCategory;
					// ��Ʒ������� = �ܰ���*������� ��ȡ����λ
					Long packAmount = new Double(totalPack * scale).longValue();
					// ������=��Ʒ�������*Ʒ�ư���С
					Long disAmount = packAmount * brandPackSize.get(brand);
					comCatePackSum += packAmount;

					comCateDisAmount.put(comCategory, disAmount);
				}
				// ʣ�����=�ܰ���-����Ʒ���������ȡ����λ
				Long remainPackAmount = totalPack - comCatePackSum;

				Long oldDisAmount = comCateDisAmount.get(comCateforMaxScale);
				// ��ʣ�������ӵ�������ߵ���Ʒ���� (�Ӷ���ʣ�������Ӧ�ķ�������ӵ�������ߵ���Ʒ����)
				comCateDisAmount.put(comCateforMaxScale, oldDisAmount
						+ remainPackAmount * brandPackSize.get(brand));

				// ����������Ϊ�����Ʒ����
				for (Iterator<String> iter = comCateDisAmount.keySet()
						.iterator(); iter.hasNext();) {
					String comCategory = iter.next();
					Long disAmount = comCateDisAmount.get(comCategory);
					if (disAmount == 0)
						iter.remove();
				}
				Object[] classAndDisAmount = { alarmClass, comCateDisAmount };

				brandComDisAmountMap.put(brand, classAndDisAmount);
			}
		}
		return brandComDisAmountMap;
	}

	/**
	 * 5) �������� (e) ����������
	 * 
	 * @param brandComDisAmount
	 *            ��Ʒ�������������
	 * @return ����ͨ��������Ʒ�������������
	 * @throws Exception
	 */
	private Map<String, Object[]> orderDisCheck(
			Map<String, Object[]> brandComDisAmount, String wayid)
			throws Exception {
		for (Iterator<String> it = brandComDisAmount.keySet().iterator(); it
				.hasNext();) {
			String brand = it.next();
			Object[] classAndDisAmount = brandComDisAmount.get(brand);
			// Ԥ������
			String alarmClass = (String) classAndDisAmount[0];
			// ��Ʒ���༰�������
			Map<String, Long> comCateDisAmount = (Map<String, Long>) classAndDisAmount[1];
			if (comCateDisAmount.size() <= 0) {
				// �����Ʒ�Ƹ���Ʒ����ķ�����֮��Ϊ����֮�Ӽ�����ɾ�������ش�����һƷ������
				it.remove();
				continue;
			}

			Set<String> comCategory = comCateDisAmount.keySet();
			OrderVO orderVO = this.getLatelyOrdersInComCate(comCategory, wayid);
			if (orderVO == null)
				continue;
			if (!checkIsPass(alarmClass, orderVO)) { // �����鲻ͨ��������Ʒ�ƴӷ��伯����ȥ��
				it.remove();
			}
		}
		return brandComDisAmount;
	}

	/**
	 * 5) �������� ->(f) �������� (f) �ۼƷ�����
	 * 
	 * @param brandComDisAmount
	 * @param wayid
	 * @param orderCollection
	 * @param comorderListForAllOrders
	 * @return �ۼƺ��Ԥ���������� Map<�ֹ�˾,Ԥ������������Ϣ>
	 * @throws Exception
	 */

	private void createOrderAndAccuAmount(
			Map<String, Object[]> brandComDisAmount, String wayid,
			WayassistantVO waVO, Map<String, Long> brandStocks)
			throws Exception {

		if (brandComDisAmount.size() <= 0)
			return;
		Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class, user,
				BOFactory.PROPAGATION_REQUIRES_NEW);
		Way wayBO = (Way) BOFactory.build(WayBO.class, user);
		Order orderBO = (Order) BOFactory.build(OrderBO.class, user);
		Stkalarmstat sasBO = (Stkalarmstat) BOFactory.build(
				StkalarmstatBO.class, user, BOFactory.PROPAGATION_REQUIRES_NEW);
		WayVO wayVO = wayBO.doFindByPk(wayid);
		// 5.2.24.3 �޸ġ�����������
		// �߼�ɾ��������鲽�衣(CR_ZQ20100702_1075333)

		/*
		 * // �����ʸ��� Wayassistant wayassistant = (Wayassistant) BOFactory.build(
		 * WayassistantBO.class, user); WayassistantVO wayassistantVO =
		 * wayassistant.doFindByPk(wayid); if (null == wayassistantVO) { throw
		 * new SaleException("SALE-103002"); // throw new //
		 * WebSiteException("�ú����̶���������Ϣ������!",RetResult.FAILURE); }
		 */

		wayVO.setPaytype(waVO.getPaytype());
		wayVO.setDelitype(waVO.getDelitype());

		/*
		 * ɾ�����ۼƷ��������͡��������ܡ��߼� BOSS��CR_ZQ_20100908_1167835 PBOSSϵͳ���칫˾����̷��䷽�������ڣ�
		 * 5.2.21 �޸ġ������Զ����䡿��̨�߼� // �ֹ�˾ String countyid = wayVO.getCountyid(); //
		 * Ԥ������������Ϣ AlaordercolVO ocVO = null; if (orderCollection.get(countyid) !=
		 * null) ocVO = orderCollection.get(countyid); else { ocVO = new
		 * AlaordercolVO(); ocVO.setCountyid(countyid);
		 * orderCollection.put(countyid, ocVO); }
		 */

		// ������Դ����
		String storarea = comorder.doGetStorArea(wayVO);

		for (Iterator<String> it = brandComDisAmount.keySet().iterator(); it
				.hasNext();) {// ��Ʒ��ѭ��
			// ���鵽�Ķ��������б���Ϣ���붩���б�
			String brand = it.next();
			List<ComorderVO> comorderList = new LinkedList<ComorderVO>();
			String orderid = "";
			try {
				orderid = comorder.doGetOrderId();
				Object[] classAndDisAmount = brandComDisAmount.get(brand);
				// Ԥ������
				String alarmClass = (String) classAndDisAmount[0];
				// ��Ʒ���༰�������
				Map<String, Long> comCateDisAmount = (Map<String, Long>) classAndDisAmount[1];
				// Ʒ�Ʒ�����������Ʒ���������֮�ͣ�
				Long sumOrderAmount = 0L;
				for (Iterator<String> cdaIt = comCateDisAmount.keySet()
						.iterator(); cdaIt.hasNext();) {// ����Ʒ����ѭ��
					String comCategory = cdaIt.next();
					Long disAmount = comCateDisAmount.get(comCategory);
					sumOrderAmount = sumOrderAmount + disAmount; // �ۼƸ���Ʒ���������֮��
					ComorderVO comorderVO = new ComorderVO();
					comorderVO.setComcategory(comCategory);
					comorderVO.setOrderamount(disAmount);
					Double unitprice = comorder.doGetUnitprice(wayid,
							comCategory);
					comorderVO.setUnitprice(unitprice);
					comorderVO.setTotalprice(unitprice * disAmount);
					comorderList.add(comorderVO);
				}

				Set<String> brandSet = null;
				// ɾ��������鲽�衣(CR_ZQ20100702_1075333)
				/*
				 * try { //������� brandSet = comorder.comOrderCheck(wayid,
				 * comorderList, storarea); }catch(SaleException e) {
				 * log.info("[������鲻ͨ��]\t������ʶ: "+wayid+"; Ʒ�Ʊ�ʶ: "+brand+":");
				 * log.info(e.getMessage()); continue; }catch(Exception e) {
				 * e.printStackTrace(); continue; }
				 */

				try {
					// ��������
					comorder.doBuildOrder(orderid, wayVO, storarea,
							comorderList, brandSet,
							ComorderConstant.ORDERAVE_AUTO, alarmClass);

					StringBuffer comcateInfo = new StringBuffer("");
					for (ComorderVO comoderVO : comorderList) {
						comcateInfo.append(comoderVO.getComcategory()).append(
								":").append(comoderVO.getOrderamount()).append(
								"|");
					}
					log.info("�Զ����䶩����Ϣ: [������: " + orderid + "] [�����̱���: "
							+ wayid + "] [�ֹ�˾: " + wayVO.getCountyid()
							+ "] [�Ǽ�: " + wayVO.getStarlevel() + "] [Ԥ������: "
							+ alarmClass + "] [��Ʒ������Ϣ(��Ʒ����:��������): ("
							+ comcateInfo + ")");
					// 5.2.24.1 ����������Ԥ�����ա��߼� (CR_ZQ20100702_1075333)
					OrderVO orderVO = orderBO.doFindByPk(orderid);
					Date createtime = orderVO.getCreatetime();
					StkalarmstatVO sasVO = new StkalarmstatVO();
					sasVO.setAlarmdate(createtime);
					sasVO.setWayid(wayid);
					sasVO.setBrand(brand);
					sasVO.setAlarmlevel(alarmClass);
					sasVO.setOrderid(orderid);
					sasVO.setCrtstock(brandStocks.get(brand));
					sasBO.doCreate(sasVO);
				} catch (SaleException e) {
					log.info("[���������쳣]\t������ʶ: " + wayid + "; Ʒ�Ʊ�ʶ: " + brand
							+ ":");
					log.info(e.getMessage());
					continue;
				} catch (Exception e) {
					LoggerUtils.error(e, log);
					continue;
				}

				/*
				 * ɾ�����ۼƷ��������͡��������ܡ��߼� BOSS��CR_ZQ_20100908_1167835
				 * PBOSSϵͳ���칫˾����̷��䷽�������ڣ� 5.2.21 �޸ġ������Զ����䡿��̨�߼� // (f) �ۼƷ����� if
				 * ("YELALARM".equalsIgnoreCase(alarmClass)) { // �ۼƻ�ɫԤ�������� Long
				 * oldYelnum = ocVO.getYelnum(); ocVO.setYelnum(oldYelnum ==
				 * null ? 1L : ++oldYelnum); } else if
				 * ("REDALARM".equalsIgnoreCase(alarmClass)) { // �ۼƺ�ɫԤ�������� Long
				 * oldRednum = ocVO.getRednum(); ocVO.setRednum(oldRednum ==
				 * null ? 1L : ++oldRednum); } if
				 * ("BrandMzone".equalsIgnoreCase(brand)) { // �ۼƶ��еش������� Long
				 * oldDgamount = ocVO.getDgamount();
				 * ocVO.setDgamount(oldDgamount == null ? sumOrderAmount :
				 * sumOrderAmount + oldDgamount); } if
				 * ("BrandSzx".equalsIgnoreCase(brand)) { // �ۼ������з����� Long
				 * oldSzxamount = ocVO.getSzxamount();
				 * ocVO.setSzxamount(oldSzxamount == null ? sumOrderAmount :
				 * sumOrderAmount + oldSzxamount); } if
				 * ("BrandDzk".equalsIgnoreCase(brand)) { // �ۼƴ��ڿ������� Long
				 * oldDzkamount = ocVO.getDzkamount();
				 * ocVO.setDzkamount(oldDzkamount == null ? sumOrderAmount :
				 * sumOrderAmount + oldDzkamount); }
				 */
			} catch (Exception ex) {
				LoggerUtils.error(ex, log);
				continue;
			}
			// �ռ����ж�������Ʒ������������Ӧ��ϵ��[�����������ż�����֪ͨ]ʹ�� add by yedaoe
			comorderListForAllOrders.addAll(comorderList);
			// �ռ�������ʶ�Թ��������ż�����֪ͨ
			if (StringUtils.isNotBlank(orderid))
				orderidstr += orderid + "/";
		}
		// ɾ�����ۼƷ��������͡��������ܡ��߼�
		// return orderCollection;
	}

	/*
	 * ɾ�����ۼƷ��������͡��������ܡ��߼� BOSS��CR_ZQ_20100908_1167835 PBOSSϵͳ���칫˾����̷��䷽�������ڣ�
	 * 5.2.21 �޸ġ������Զ����䡿��̨�߼�
	 */
	/**
	 * 6) ��������
	 * 
	 * @param orderCollection
	 * @throws Exception
	 */
	// private void orderCollection(Map<String, AlaordercolVO> orderCollection)
	// throws Exception {
	// Alaordercol ocBO = (Alaordercol) BOFactory.build(AlaordercolBO.class,
	// user);
	// for (Iterator<String> it = orderCollection.keySet().iterator(); it
	// .hasNext();) {
	// String countyid = it.next();
	// AlaordercolVO ocVO = orderCollection.get(countyid);
	// ocVO.setColdate(PublicUtils.formatUtilDate(new Date(), "yyyyMMdd"));
	// ocBO.doCreate(ocVO);
	// }
	// }
	private Long getCloselyAlarmValue(Long stock, Collection<Long> alarms) {
		Object[] alarmArray = alarms.toArray();
		Arrays.sort(alarmArray); // �Է�ֵ����С��������
		for (int k = 0; k < alarmArray.length; k++) {
			if (stock <= (Long) alarmArray[k])
				return (Long) alarmArray[k];
		}
		return null;
	}

	/**
	 * ��ѯָ����Ʒ��������Ķ�����Ϣ
	 * 
	 * @param comCategory
	 * @return
	 * @throws Exception
	 */
	private OrderVO getLatelyOrdersInComCate(Set<String> comCategory,
			String wayid) throws Exception {
		OrderAutoDistributeDAO dao = (OrderAutoDistributeDAO) DAOFactory.build(
				OrderAutoDistributeDAO.class, user);
		return dao.getLatelyOrdersInComCate(comCategory, wayid);
	}

	private boolean checkIsPass(String alarmClass, OrderVO orderVO)
			throws Exception {

		// ����;��
		String orderRave = orderVO.getOrderave();
		// Ԥ������
		String alarmLevel = orderVO.getAlarmlevel();
		// �Ƿ�ȷ��
		Integer confirmflag = orderVO.getConfirmflag();
		// ����״̬
		String orderstate = orderVO.getOrderstate();
		// ��������ʱ��
		Date createtime = orderVO.getCreatetime();

		if ("AUTO".equalsIgnoreCase(orderRave)) {
			// �Զ�����
			if (alarmClass.equals(alarmLevel)) { // Ԥ��������ͬ
				if (confirmflag != null && confirmflag == 1) { // �Ƿ�ȷ��Ϊ"��"
					if ("FINISHED".equalsIgnoreCase(orderstate)
							|| "CANCEL".equalsIgnoreCase(orderstate)) {
						// ����ɻ����� -> ͨ��
						return true;
					} else {
						// ����״̬ -> ��ͨ��
						return false;
					}
				} else {
					// �Ƿ�ȷ��Ϊ"��" ���

					// ��������ʱ�䲻�ڵ�����,ͨ��
					if (!TimeUtils.inSameMonth(createtime)) {
						return true;
					} else {
						// ��������ʱ�䲻�ڵ�����,��ͨ��
						return false;
					}
				}
			} else { // Ԥ��������ͬ
				if (confirmflag != null && confirmflag == 1) { // �Ƿ�ȷ��Ϊ"��"
					if ("FINISHED".equalsIgnoreCase(orderstate)
							|| "CANCEL".equalsIgnoreCase(orderstate)) {
						// ����ɻ����� -> ͨ��
						return true;
					} else {
						// ����״̬ -> ��ͨ��
						return false;
					}
				} else {
					// �Ƿ�ȷ��Ϊ"��" �� �� -> ͨ��
					return true;
				}
			}
		} else {
			// �ǡ��Զ����䡱
			if ("FINISHED".equalsIgnoreCase(orderstate)
					|| "CANCEL".equalsIgnoreCase(orderstate)) {
				// ����ɻ����� -> ͨ��
				return true;
			} else {
				// ����״̬ -> ��ͨ��
				return false;
			}
		}
	}

	// ���Ƿ��Ͷ��ż�����֪ͨ���м�鲢���Ͷ���,��������
	private void doCheckForSmsAndTodo(Boolean isBatch,
			String comcategoryAndAmountStr, String orderidstr) throws Exception {
		// ��һ��:���[�Ƿ����ö�������֪ͨ]
		Sysparam spBo = (SysparamBO) BOFactory.build(SysparamBO.class, user);
		String paramValue1 = spBo.doFindByID(50L, "pboss_fx");
		if (StringUtils.isBlank(paramValue1)
				|| ((!"0".equals(paramValue1)) && (!"1".equals(paramValue1))
						&& (!"2".equals(paramValue1)) && (!"3"
						.equals(paramValue1)))) {
			log.info("[�Ƿ����ö�������֪ͨ]����ֵ���ò���ȷ,�޷���ȡ�ò���ֵ,���߲���ֵ��Ϊ0,1,2,3");
			return;
		}
		if ("0".equals(paramValue1)) {
			return;
		}
		// �ڶ���:���[��������֪ͨ��ɫ]
		String paramValue2 = spBo.doFindByID(51L, "pboss_fx");
		if (StringUtils.isBlank(paramValue2)) {
			log.info("[��������֪ͨ��ɫ]����ֵ���ò���ȷ,�޷���ȡ�ò���ֵ,���߲���ֵΪ��");
			return;
		}
		if ("-1".equals(paramValue2)) {
			return;
		}
		// ������:��ȡ��ɫ����Ӧ�Ĺ��ż���ϵ�绰
		Operrole operrole = (Operrole) BOFactory.build(OperroleBO.class, user);
		Operator operator = (Operator) BOFactory.build(OperatorBO.class, user);
		OperroleDBParam opparam = new OperroleDBParam();
		opparam.set_se_roleid(paramValue2);
		opparam.set_ne_status("1");
		DataPackage operroledp = operrole.doQuery(opparam);
		if (null == operroledp || operroledp.getDatas().size() == 0) {
			log.info("[��������֪ͨ��ɫ]����ֵ(����ɫ����)�ڽ�ɫ���ű���û��������Ĺ���");
			return;
		}
		List<OperroleVO> orlist = operroledp.getDatas();

		List<OperatorVO> oplist = new ArrayList<OperatorVO>();
		for (OperroleVO operrolevo : orlist) {
			OperatorDBParam oparam = new OperatorDBParam();
			oparam.set_se_operid(operrolevo.getOperid());
			oparam.set_ne_status("1");
			DataPackage operatordp = operator.doQuery(oparam);
			if (operatordp.getDatas().size() > 0) {
				oplist.add((OperatorVO) operatordp.getDatas().get(0));
			}
		}
		// ���Ĳ�:���[������̨����֪ͨʱ��]
		String paramValue4 = spBo.doFindByID(58L, "pboss_fx");// ���ŷ���֪ͨʱ��
		if (StringUtils.isBlank(paramValue4)) {
			log.info("[������̨����֪ͨʱ��]����ֵ���ò���ȷ,�޷���ȡ�ò���ֵ,���߲���ֵΪ��");
			return;
		}
		// ���岽:���ݡ��Ƿ����ö�������֪ͨ����������֪ͨ���
		// Ĭ��Ϊ0���Ƿ���й�˾��Դ����Ա֪ͨ��0��ʾ��֪ͨ��1��ʾ�Զ���֪ͨ��2��ʾ�Դ���֪ͨ��3��ʾ�Զ��źʹ���֪ͨ
		Smstmpl smstmplBO = (Smstmpl) BOFactory.build(SmstmplBO.class, user);
		SmstmplVO smstmplBatchVO = smstmplBO
				.doFindByPk("FX_ORDER_CADVICE_BATCH");
		SmstmplVO smstmplSingleVO = smstmplBO
				.doFindByPk("FX_ORDER_CADVICE_SINGLE");
		Waitreq waitreqbo = (Waitreq) BOFactory.build(WaitreqBO.class, user);
		if ("1".equals(paramValue1)) {
			// ��ȡ���ŷ��ͺ���
			String sendno = "";
			Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,
					user);
			SysparamDBParam param = new SysparamDBParam();
			param.set_se_paramtype("pboss");
			param.set_ne_systemid("7");
			DataPackage dp = sysparam.doQuery(param);
			if (dp.getRowCount() > 0)
				sendno = ((SysparamVO) dp.getDatas().get(0)).getParamvalue();
			// ��ȡ���ŷ���ʱ��
			String senttimestr = null;
			param.set_se_paramtype("pboss_fx");
			param.set_ne_systemid("58");
			DataPackage dp2 = sysparam.doQuery(param);
			if (dp2.getRowCount() > 0)
				senttimestr = ((SysparamVO) dp2.getDatas().get(0))
						.getParamvalue();
			String date1 = PublicUtils.formatUtilDate(new Date(), "yyyy-MM-dd");
			String date2 = date1 + " " + senttimestr;
			Date senttime = PublicUtils
					.UtilStrToDate(date2, "yyyy-MM-dd HH:mm");

			if (isBatch && smstmplBatchVO != null) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("COMCATEGORY:AMOUNT", comcategoryAndAmountStr);
				String content = smstmplBO.doGenSMS("FX_ORDER_CADVICE_BATCH",
						map);
				for (OperatorVO vo : oplist) {
					if (StringUtils.isNotBlank(vo.getContactphone())) {
						// waitreqbo.doInsert(new Short("3"), content,
						// vo.getContactphone());//���Ϊ�ü��Ϸ���ʱ������ķ���
						waitreqbo.doInsert3(new Short("3"), content, sendno, vo
								.getContactphone(), senttime);
					}
				}
			} else if (isBatch == false && smstmplSingleVO != null) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("COMCATEGORY:AMOUNT", comcategoryAndAmountStr);
				map.put("ORDERID", orderidstr);
				String content = smstmplBO.doGenSMS("FX_ORDER_CADVICE_SINGLE",
						map);

				for (OperatorVO vo : oplist) {
					if (StringUtils.isNotBlank(vo.getContactphone())) {
						// waitreqbo.doInsert(new Short("3"), content,
						// vo.getContactphone());//���Ϊ�ü��Ϸ���ʱ������ķ���
						waitreqbo.doInsert3(new Short("3"), content, sendno, vo
								.getContactphone(), senttime);
					}
				}
			}
		} else if ("2".equals(paramValue1)) {
			String opercodestr = "";// �ѽ�ɫ��Ӧ�Ĺ����ö���ƴ��
			for (OperatorVO vo : oplist) {
				String opercode = vo.getOperid();
				opercodestr = opercodestr + opercode + ",";
			}
			opercodestr = opercodestr.substring(0, opercodestr.length() - 1);// ȥ�����һ������
			Pendingtask pendingtaskBO = (Pendingtask) BOFactory.build(
					PendingtaskBO.class, user);
			pendingtaskBO.doCreate("�Ѵ�������" + orderidstr, "", "7", opercodestr,
					new Short("0"), null, new Date(), null);
		} else if ("3".equals(paramValue1)) {
			// ��ȡ���ŷ��ͺ���
			String sendno = "";
			Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,
					user);
			SysparamDBParam param = new SysparamDBParam();
			param.set_se_paramtype("pboss");
			param.set_ne_systemid("7");
			DataPackage dp = sysparam.doQuery(param);
			if (dp.getRowCount() > 0)
				sendno = ((SysparamVO) dp.getDatas().get(0)).getParamvalue();
			// ��ȡ���ŷ���ʱ��
			String senttimestr = null;
			param.set_se_paramtype("pboss_fx");
			param.set_ne_systemid("58");
			DataPackage dp2 = sysparam.doQuery(param);
			if (dp2.getRowCount() > 0)
				senttimestr = ((SysparamVO) dp2.getDatas().get(0))
						.getParamvalue();
			String date1 = PublicUtils.formatUtilDate(new Date(), "yyyy-MM-dd");
			String date2 = date1 + " " + senttimestr;
			Date senttime = PublicUtils
					.UtilStrToDate(date2, "yyyy-MM-dd HH:mm");

			// ������
			if (isBatch && smstmplBatchVO != null) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("COMCATEGORY:AMOUNT", comcategoryAndAmountStr);
				String content = smstmplBO.doGenSMS("FX_ORDER_CADVICE_BATCH",
						map);
				for (OperatorVO vo : oplist) {
					if (StringUtils.isNotBlank(vo.getContactphone())) {
						// waitreqbo.doInsert(new Short("3"), content,
						// vo.getContactphone());//���Ϊ�ü��Ϸ���ʱ������ķ���
						waitreqbo.doInsert3(new Short("3"), content, sendno, vo
								.getContactphone(), senttime);
					}
				}
			} else if (isBatch == false && smstmplSingleVO != null) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("COMCATEGORY:AMOUNT", comcategoryAndAmountStr);
				map.put("ORDERID", orderidstr);
				String content = smstmplBO.doGenSMS("FX_ORDER_CADVICE_SINGLE",
						map);
				for (OperatorVO vo : oplist) {
					if (StringUtils.isNotBlank(vo.getContactphone())) {
						// waitreqbo.doInsert(new Short("3"), content,
						// vo.getContactphone());//���Ϊ�ü��Ϸ���ʱ������ķ���
						waitreqbo.doInsert3(new Short("3"), content, sendno, vo
								.getContactphone(), senttime);
					}
				}
			}
			// д����
			String opercodestr = "";// �ѽ�ɫ��Ӧ�Ĺ����ö���ƴ��
			for (OperatorVO vo : oplist) {
				String opercode = vo.getOperid();
				opercodestr = opercodestr + opercode + ",";
			}
			opercodestr = opercodestr.substring(0, opercodestr.length() - 1);// ȥ�����һ������
			Pendingtask pendingtaskBO = (Pendingtask) BOFactory.build(
					PendingtaskBO.class, user);
			pendingtaskBO.doCreate("�Ѵ�������" + orderidstr, "", "7", opercodestr,
					new Short("0"), null, new Date(), null);
		}
	}

	// ����comorderListForAllOrders��װ������Ʒ����1:����1����Ʒ����2:����2��������
	private String joinComcategoryAndAmountStr(
			List<ComorderVO> comorderListForAllOrders) {
		String cmcategoryAndAmountStr = "";
		Map<String, Long> comcategoryMap = new HashMap<String, Long>();
		// ����ͬ����Ʒ����Ķ����ϲ�
		for (ComorderVO vo : comorderListForAllOrders) {
			String comcategorytemp = vo.getComcategory();
			if (!comcategoryMap.containsKey(comcategorytemp)) {
				comcategoryMap.put(comcategorytemp,
						vo.getOrderamount() == null ? 0 : vo.getOrderamount());
			} else {
				Long orderamounttemp = comcategoryMap.get(comcategorytemp);
				comcategoryMap.put(comcategorytemp,
						(vo.getOrderamount() == null ? 0 : vo.getOrderamount())
								+ orderamounttemp);
			}
		}
		// ��װ�������ʽ
		for (Iterator it = comcategoryMap.keySet().iterator(); it.hasNext();) {
			String comcategory = (String) it.next();
			cmcategoryAndAmountStr += Code2NameUtils.code2Name(
					"$IM_FXCOMCATEGORY", comcategory, user.getCityid())
					+ ":" + comcategoryMap.get(comcategory) + ";";
			// cmcategoryAndAmountStr += comcategory+ ":" +
			// comcategoryMap.get(comcategory) + ";";
		}
		// ȥ�����һ���ֺ�
		if (cmcategoryAndAmountStr.length() > 1)
			cmcategoryAndAmountStr = cmcategoryAndAmountStr.substring(0,
					cmcategoryAndAmountStr.length() - 1);
		return cmcategoryAndAmountStr;
	}

	// ���ݷֹ�˾��΢�����Ǽ����ں������Ǽ���STARLEVEL���������Ǽ���-1����Ʒ�Ʋ�ѯ��Ʒ����������ϣ�
	// ����������������������[XX] Ʒ��[YY] ��Ʒ����������������ݡ������ش�����һƷ�����ݣ�
	// ���ͬʱ���ں������Ǽ��������Ǽ���-1�������ݣ����Ժ������Ǽ�����Ϊ׼���������Ʒ���༰�����������ݡ�

	public Map<String, Map<String, Double>> getSalecale(List brandComDisScale1,
			String brand, WayVO way) throws Exception {

		Map<String, Map<String, Double>> brandComDisScale = new HashMap<String, Map<String, Double>>();
		Map<String, Double> comDisScaleMap = new TreeMap<String, Double>();

		List<ComdisscaleVO> AfList = new ArrayList<ComdisscaleVO>();
		List<ComdisscaleVO> AfList0 = new ArrayList<ComdisscaleVO>();
		List<ComdisscaleVO> AfList2 = new ArrayList<ComdisscaleVO>();
		// ���ݷֹ�˾��΢�����Ǽ����ں������Ǽ���STARLEVEL���������Ǽ���-1����Ʒ�Ʋ�ѯ��Ʒ����������ϣ�
		for (int j = 0; j < brandComDisScale1.size(); j++) {
			ComdisscaleVO comdisscalevo = (ComdisscaleVO) brandComDisScale1
					.get(j);
			if (comdisscalevo.getCountyid() != null
					&& comdisscalevo.getCountyid().equals(way.getCountyid())
					&& comdisscalevo.getMareacode() != null
					&& comdisscalevo.getMareacode().equals(way.getMareacode())
					&& comdisscalevo.getStarlevel() != null
					&& comdisscalevo.getBrand().equals(brand)) {

				if (comdisscalevo.getStarlevel() == Short.parseShort(way
						.getStarlevel().toString())
						|| comdisscalevo.getStarlevel() == Short
								.parseShort("-1")) {
					AfList.add(comdisscalevo);
				}
			}
		}
		if (AfList == null || AfList.size() == 0) {
			throw new Exception("������[" + way.getWayid() + "] Ʒ��[" + brand
					+ "] ��Ʒ�����������������");
		}

		for (int i = 0; i < AfList.size(); i++) {
			ComdisscaleVO cv = AfList.get(i);
			if (cv.getStarlevel() < 0) {
				AfList0.add(cv);
			} else {
				AfList2.add(cv);
			}
		}

		if (AfList2.size() == 0 && AfList0 != null) {
			// ȡ�����Ǽ�
			for (int i = 0; i < AfList0.size(); i++) {
				ComdisscaleVO vo = AfList0.get(i);
				if (vo.getBrand() != null && vo.getBrand().equals(brand)) {
					comDisScaleMap.put(vo.getComcategory(), vo.getDisscale());
				}
			}
			brandComDisScale.put(brand, comDisScaleMap);
		} else {
			// ȡ�������Ǽ�
			for (int i = 0; i < AfList2.size(); i++) {
				ComdisscaleVO vo = AfList2.get(i);
				if (vo.getBrand() != null && vo.getBrand().equals(brand)) {
					comDisScaleMap.put(vo.getComcategory(), vo.getDisscale());
				}
			}
			brandComDisScale.put(brand, comDisScaleMap);
		}
		return brandComDisScale;

	}

	public static void main(String[] args) {
		// List<ComorderVO> comorderListForAllOrders = new
		// LinkedList<ComorderVO>();
		// ComorderVO vo1 = new ComorderVO();
		// ComorderVO vo2 = new ComorderVO();
		// ComorderVO vo3 = new ComorderVO();
		// vo1.setComcategory("100DZ");
		// vo1.setOrderamount(20L);
		// vo2.setComcategory("55SZ");
		// vo2.setOrderamount(30L);
		// vo3.setComcategory("100DZ");
		// vo3.setOrderamount(40L);
		// comorderListForAllOrders.add(vo1);
		// comorderListForAllOrders.add(vo2);
		// comorderListForAllOrders.add(vo3);
		OrderAutoDistributeBO bo = new OrderAutoDistributeBO();
		// String result = bo
		// .joinComcategoryAndAmountStr(comorderListForAllOrders);
		// System.out.print(result);
		Map<String, Object[]> maxStockAndAlarmMapTemp1 = new HashMap<String, Object[]>();// ������Ԥ�����ñ��еĶ�Ӧ��ϵmap
		Object aa [] = {1000,123};
		Object bb [] = {1200,123};
		Object cc [] = {478,123};
		maxStockAndAlarmMapTemp1.put("aaa,bbb,ccc",aa);
		maxStockAndAlarmMapTemp1.put("ccc,eee,fff", bb);
		maxStockAndAlarmMapTemp1.put("gggg", cc);

		System.out.println(bo.checkExit(maxStockAndAlarmMapTemp1, "ccc")[0]);

	}

	// ���Ʒ�Ƽ������Ƿ���� ĳ�ض�Ʒ��
	public Object[] checkExit(Map<String, Object[]> maxStockAndAlarmMapTemp,
			String brand) {
		Set<String> keyset = maxStockAndAlarmMapTemp.keySet();
		
		if(keyset.contains(brand)){
			return maxStockAndAlarmMapTemp.get(brand);			
		}			
		
		Object[] bo = null;
		for (Iterator<String> it = keyset.iterator(); it.hasNext();) {
			String str = it.next();
			if (str.contains(",")) {
				String[] strarr = str.split(",");
				for (int i = 0; i < strarr.length; i++) {
					if (strarr[i].equals(brand)) {
						if(bo == null){
							bo = maxStockAndAlarmMapTemp.get(str);							
						}else{
							if(Long.parseLong(maxStockAndAlarmMapTemp.get(str)[0].toString())>Long.parseLong(bo[0].toString())){
								bo = maxStockAndAlarmMapTemp.get(str);
							}
						}
					}
				}
			}
		}
		return bo;
	}

}
