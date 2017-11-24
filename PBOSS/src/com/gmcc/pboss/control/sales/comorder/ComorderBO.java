/**
 * auto-generated code
 * Mon Oct 19 19:01:28 CST 2009
 */
package com.gmcc.pboss.control.sales.comorder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.base.sysparam.SysparamDBParam;
import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeDBParam;
import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountDBParam;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountVO;
import com.gmcc.pboss.business.resource.comcatebrand.ComcatebrandDBParam;
import com.gmcc.pboss.business.resource.comcatebrand.ComcatebrandVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.resource.compack.CompackDBParam;
import com.gmcc.pboss.business.sales.activerate.ActiverateDBParam;
import com.gmcc.pboss.business.sales.activerate.ActiverateVO;
import com.gmcc.pboss.business.sales.baseorderamt.BaseorderamtDBParam;
import com.gmcc.pboss.business.sales.baseorderamt.BaseorderamtVO;
import com.gmcc.pboss.business.sales.comorder.ComorderConstant;
import com.gmcc.pboss.business.sales.comorder.ComorderVO;
import com.gmcc.pboss.business.sales.comorder.OrderCardVO;
import com.gmcc.pboss.business.sales.comorder.OrderEmptyCardVO;
import com.gmcc.pboss.business.sales.comorder.OrderMonthdayStockVO;
import com.gmcc.pboss.business.sales.comorder.OrderMonthdayStockalarm;
import com.gmcc.pboss.business.sales.comorder.OrderMonthdayVO;
import com.gmcc.pboss.business.sales.comorder.OrderStdstockVO;
import com.gmcc.pboss.business.sales.comorder.OrderStockalarmVO;
import com.gmcc.pboss.business.sales.comprice.CompriceDBParam;
import com.gmcc.pboss.business.sales.comprice.CompriceVO;
import com.gmcc.pboss.business.sales.incqttdtl.IncqttdtlDBParam;
import com.gmcc.pboss.business.sales.incqttdtl.IncqttdtlVO;
import com.gmcc.pboss.business.sales.monorderinfo.MonorderinfoDBParam;
import com.gmcc.pboss.business.sales.monorderinfo.MonorderinfoVO;
import com.gmcc.pboss.business.sales.order.OrderDAO;
import com.gmcc.pboss.business.sales.order.OrderDBParam;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateVO;
import com.gmcc.pboss.business.sales.orderflow.OrderflowDBParam;
import com.gmcc.pboss.business.sales.orderflow.OrderflowVO;
import com.gmcc.pboss.business.sales.orderplan.OrderplanVO;
import com.gmcc.pboss.business.sales.orderproce.OrderproceDBParam;
import com.gmcc.pboss.business.sales.orderproce.OrderproceVO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDBParam;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetVO;
import com.gmcc.pboss.business.sales.ordertimes.OrdertimesDBParam;
import com.gmcc.pboss.business.sales.ordertimes.OrdertimesVO;
import com.gmcc.pboss.business.sales.orderunit.OrderunitDBParam;
import com.gmcc.pboss.business.sales.orderunit.OrderunitVO;
import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitDBParam;
import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitVO;
import com.gmcc.pboss.business.sales.realtimeamt.RealtimeamtDBParam;
import com.gmcc.pboss.business.sales.realtimeamt.RealtimeamtVO;
import com.gmcc.pboss.business.sales.saleplan.SaleplanDBParam;
import com.gmcc.pboss.business.sales.saleplan.SaleplanVO;
import com.gmcc.pboss.business.sales.simrealtimeamt.SimrealtimeamtDBParam;
import com.gmcc.pboss.business.sales.simrealtimeamt.SimrealtimeamtVO;
import com.gmcc.pboss.business.sales.simstockalarm.SimstockalarmDBParam;
import com.gmcc.pboss.business.sales.simstockalarm.SimstockalarmVO;
import com.gmcc.pboss.business.sales.stockalarm.StockalarmDBParam;
import com.gmcc.pboss.business.sales.stockalarm.StockalarmVO;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantVO;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.custwaytype.Custwaytype;
import com.gmcc.pboss.control.channel.custwaytype.CustwaytypeBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.wayaccount.Wayaccount;
import com.gmcc.pboss.control.channel.wayaccount.WayaccountBO;
import com.gmcc.pboss.control.resource.comcatebrand.Comcatebrand;
import com.gmcc.pboss.control.resource.comcatebrand.ComcatebrandBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.resource.compack.Compack;
import com.gmcc.pboss.control.resource.compack.CompackBO;
import com.gmcc.pboss.control.resource.emptysimbad.Emptysimbad;
import com.gmcc.pboss.control.resource.emptysimbad.EmptysimbadBO;
import com.gmcc.pboss.control.sales.activerate.Activerate;
import com.gmcc.pboss.control.sales.activerate.ActiverateBO;
import com.gmcc.pboss.control.sales.baseorderamt.Baseorderamt;
import com.gmcc.pboss.control.sales.baseorderamt.BaseorderamtBO;
import com.gmcc.pboss.control.sales.comprice.Comprice;
import com.gmcc.pboss.control.sales.comprice.CompriceBO;
import com.gmcc.pboss.control.sales.incqttdtl.Incqttdtl;
import com.gmcc.pboss.control.sales.incqttdtl.IncqttdtlBO;
import com.gmcc.pboss.control.sales.monorderinfo.Monorderinfo;
import com.gmcc.pboss.control.sales.monorderinfo.MonorderinfoBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.ordercomcate.Ordercomcate;
import com.gmcc.pboss.control.sales.ordercomcate.OrdercomcateBO;
import com.gmcc.pboss.control.sales.orderflow.Orderflow;
import com.gmcc.pboss.control.sales.orderflow.OrderflowBO;
import com.gmcc.pboss.control.sales.orderplan.Orderplan;
import com.gmcc.pboss.control.sales.orderplan.OrderplanBO;
import com.gmcc.pboss.control.sales.orderproce.Orderproce;
import com.gmcc.pboss.control.sales.orderproce.OrderproceBO;
import com.gmcc.pboss.control.sales.ordertimes.Ordertimes;
import com.gmcc.pboss.control.sales.ordertimes.OrdertimesBO;
import com.gmcc.pboss.control.sales.orderunit.Orderunit;
import com.gmcc.pboss.control.sales.orderunit.OrderunitBO;
import com.gmcc.pboss.control.sales.orderuplimit.Orderuplimit;
import com.gmcc.pboss.control.sales.orderuplimit.OrderuplimitBO;
import com.gmcc.pboss.control.sales.partnerres.Partnerres;
import com.gmcc.pboss.control.sales.partnerres.PartnerresBO;
import com.gmcc.pboss.control.sales.realtimeamt.Realtimeamt;
import com.gmcc.pboss.control.sales.realtimeamt.RealtimeamtBO;
import com.gmcc.pboss.control.sales.saleplan.Saleplan;
import com.gmcc.pboss.control.sales.saleplan.SaleplanBO;
import com.gmcc.pboss.control.sales.simrealtimeamt.Simrealtimeamt;
import com.gmcc.pboss.control.sales.simrealtimeamt.SimrealtimeamtBO;
import com.gmcc.pboss.control.sales.simstockalarm.Simstockalarm;
import com.gmcc.pboss.control.sales.simstockalarm.SimstockalarmBO;
import com.gmcc.pboss.control.sales.stockalarm.Stockalarm;
import com.gmcc.pboss.control.sales.stockalarm.StockalarmBO;
import com.gmcc.pboss.control.sales.wayassistant.Wayassistant;
import com.gmcc.pboss.control.sales.wayassistant.WayassistantBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.exception.business.SaleException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ActiverateBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name=
 *           "com/sunrise/jop/business/sales/activerate/control/ActiverateBO"
 *           name="Activerate" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class ComorderBO extends AbstractControlBean implements Comorder {
	public static final int EXIT = -1; // �˳�
	public static final int START = 1; // ��ʼ
	public static final int NEXT = 1; // ��һ��

	public static boolean isurgent=false;
	// ��鹩Ӧ����Ϣ������ֵΪ���飬��������VO�ͺ����̸�����ϢVO
	public WayVO doCheckWay(String wayid) throws Exception {
		try {
			// �������ϼ��
			Way way = (Way) BOFactory.build(WayBO.class, user);
			WayDBParam param = new WayDBParam();
			param.set_se_wayid(wayid);
			param.set_se_cityid(user.getCityid());
			param.set_se_waytype("AG");
			param.set_ne_waystate("1");
			DataPackage dp = way.doQuery(param);
			if (dp == null || dp.getDatas().size() == 0) {
				throw new SaleException("SALE-103001");
				// throw new WebSiteException("�����̲�����!",RetResult.FAILURE);
			}

			// �����ʸ���
			Wayassistant wayassistant = (Wayassistant) BOFactory.build(
					WayassistantBO.class, user);
			WayassistantVO wayassistantVO = wayassistant.doFindByPk(wayid);
			if (null == wayassistantVO) {
				throw new SaleException("SALE-103002");
				// throw new
				// WebSiteException("�ú����̶���������Ϣ������!",RetResult.FAILURE);
			}

			Short canorder = wayassistantVO.getCanorder();
			if (null != canorder
					&& String.valueOf(canorder).equals(
							ComorderConstant.ORDER_CANNT)) {
				throw new SaleException("SALE-104002");
				// throw new
				// WebSiteException("�ú����̲��ܷ�����Ʒ������������Ʒ����������Ϣ!",RetResult.FAILURE);
			}

			// �˺���Ϣ���
			String paytype = wayassistantVO.getPaytype();
			if (paytype.equals(ComorderConstant.PAYTYPE_BANK)) {
				Wayaccount wayaccount = (Wayaccount) BOFactory.build(
						WayaccountBO.class, user);
				WayaccountDBParam param3 = new WayaccountDBParam();
				param3.set_se_wayid(wayid);
				DataPackage dp3 = wayaccount.doQuery(param3);
				// �ж��˺������Ƿ����
				if (null == dp3 || dp3.getDatas().size() == 0) {
					throw new SaleException("SALE-104001");
					// throw new
					// WebSiteException("�ú����������˺���Ϣ������!",RetResult.FAILURE);
				}

				WayaccountVO wayaccountVO = (WayaccountVO) dp3.getDatas()
						.get(0);
				String acctno = wayaccountVO.getDeacctno();
				String acctname = wayaccountVO.getDeacctname();
				String bankname = wayaccountVO.getDebankname();
				// �ж��˺������Ƿ�����
				if (null == acctno || acctno.equals("") || null == acctname
						|| acctname.equals("") || null == bankname
						|| bankname.equals("")) {
					throw new SaleException("SALE-104001");
					// throw new
					// WebSiteException("�ú����������˺���Ϣ������!",RetResult.FAILURE);
				}
			}

			WayVO wayVO = (WayVO) dp.getDatas().get(0);
			wayVO.setPaytype(paytype);
			wayVO.setDelitype(wayassistantVO.getDelitype());
			return wayVO;
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	// ��ȡ�׿�Ʒ�Ƽ���
	public List<DictitemVO> doGetBrandList(String wayid) throws Exception {
		try {
			Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,
					user);
			String paramvalue_1 = sysparam.doFindByID("12", "pboss_fx");
			if (StringUtils.isEmpty(paramvalue_1)) {
				throw new SaleException("SALE-101001");
			}
			Boolean brandflag = "1".equals(paramvalue_1);
			Dictitem di = (Dictitem) BOFactory.build(DictitemBO.class, user);
			DictitemDBParam params = new DictitemDBParam();
			params.set_se_groupid("FX_SMPBRAND");
			if (brandflag) {
				params.set_sne_dictid("AllBrand");
			} else {
				params.set_se_dictid("AllBrand");
			}
			DataPackage dp = di.doQuery(params);
			return dp.getDatas();
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}
	// ��ȡ�����׿�Ʒ�Ƽ��ϣ�����AllBrand��
	public List<DictitemVO> doGetBrandCollection(String wayid) throws Exception {
		try {
			Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,
					user);
			Dictitem di = (Dictitem) BOFactory.build(DictitemBO.class, user);
			DictitemDBParam params = new DictitemDBParam();
			params.set_se_groupid("FX_SMPBRAND");
			DataPackage dp = di.doQuery(params);
			return dp.getDatas();
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	// ��ȡ�׿���������Ϣ
	public List<ActiverateVO> doGetActiveList(String wayid,
			List<DictitemVO> brandlist) throws Exception {
		try {
			Activerate activerate = (Activerate) BOFactory.build(
					ActiverateBO.class, user);
			ActiverateDBParam param4 = new ActiverateDBParam();
			param4.set_se_wayid(wayid);
			List<ActiverateVO> newactiveratelist = new LinkedList<ActiverateVO>();
			for (DictitemVO dictitemvo : brandlist) {
				String dictid = dictitemvo.getDictid();
				param4.set_se_brand(dictid);
				DataPackage dp4 = activerate.doQuery(param4);
				if (null != dp4 && dp4.getRowCount() > 0) {
					ActiverateVO vo = (ActiverateVO) dp4.getDatas().get(0);
					setActiverateVO(vo);
					newactiveratelist.add(vo);
				} else {
					ActiverateVO vo = new ActiverateVO();
					Sysparam sysparam = (Sysparam) BOFactory.build(
							SysparamBO.class, user);
					String paramvalue = sysparam.doFindByID("36", "pboss_fx");
					if (StringUtils.isEmpty(paramvalue)) {
						throw new SaleException("SALE-101006");
					}
					vo.setRate(new Double(paramvalue));
					vo.setWayid(wayid);
					vo.setBrand(dictid);
					vo.setIsachieve(new Short("1"));
					newactiveratelist.add(vo);
				}
			}
			return newactiveratelist;
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}	

	private ActiverateVO setActiverateVO(ActiverateVO vo) throws Exception {
		try {
			if (null == vo.getRate() || "".equals(vo.getRate())) {
				Sysparam sysparam = (Sysparam) BOFactory.build(
						SysparamBO.class, user);
				String paramvalue = sysparam.doFindByID("36", "pboss_fx");
				if (StringUtils.isEmpty(paramvalue)) {
					throw new SaleException("SALE-101006");
				}
				vo.setRate(new Double(paramvalue));
			}
			if (null == vo.getIsachieve() || "".equals(vo.getIsachieve())) {
				vo.setIsachieve(new Short("1"));
			}
			return vo;
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	//�ж��׿�������Ϣ������/�����ơ���׼������ƻ���Ԥ������ģʽ��"MONDAYLIMIT"�������/�����ƣ�"STDSTOCK"����û�׼������ƣ�"STOCKALARM"�����Ԥ�����
	public String doGetOrderMode() throws Exception {
		try {
			// ��ȡ��/�¶��������޿�����Ϣ
			Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,
					user);
			String mode = sysparam.doFindByID(
					ComorderConstant.SYSTEMID_ORDER_STOCKALARM,
					ComorderConstant.PARAMTYPE_FX);
			if (StringUtils.isEmpty(mode)) {
				mode = ComorderConstant.MODE_MONDAYLIMIT;
			}
			return mode;
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}

	}

	// ��ȡ��/�¶�������Ϣ
	public List<OrderMonthdayVO> doGetOrderInfoByMonthDay(WayVO wayVO,
			List<DictitemVO> brandlist) throws Exception {
		try {
			List<OrderMonthdayVO> orderMonthdayList = new ArrayList<OrderMonthdayVO>();
			List<OrderuplimitVO> orderuplimitDealList = new ArrayList<OrderuplimitVO>();
			List<MonorderinfoVO> monorderinforDealList = new ArrayList<MonorderinfoVO>();
			List<RealtimeamtVO> realtimeamtDealList = new ArrayList<RealtimeamtVO>();
			

			//1����ȡ��/�¶�������������
			Orderuplimit orderuplimit = (Orderuplimit) BOFactory.build(
					OrderuplimitBO.class, user);
			OrderuplimitDBParam param = new OrderuplimitDBParam();

			String cityid = wayVO.getCityid();
			String starlevel = String.valueOf(wayVO.getStarlevel());
			String countyid = wayVO.getCountyid();
			String custtype = wayVO.getCusttype();
			param.set_se_cityid(cityid);
			param.set_ne_starlevel(starlevel);
			param.set_se_countyid(countyid);
			param.set_se_limitmode(ComorderConstant.MODE_MONDAYLIMIT);
			param.set_se_restype("COMRESSMP");//Ĭ���׿�
			
			//��Ӻ�����������
			List<String> _sin_cooptype = new ArrayList<String>();
			_sin_cooptype.add(ComorderConstant.COOPTYPE_ALL);
			if(!StringUtils.isEmpty(custtype)){
				_sin_cooptype.add(custtype);
			}
			param.set_sin_cooptype(_sin_cooptype);
			
			//��ȡ��ѯ�б�
			DataPackage dp = orderuplimit.doQuery(param);
			if(dp.getRowCount() == 0){
				throw new SaleException("SALE-103008");
			}
			List<OrderuplimitVO> orderuplimitList = dp.getDatas();
			
			//��ȡ��/�¶����������б�
			String brand = "";
			String brand2 = "";
			Boolean hasBrand = false;
			Boolean hasCooptype = false;
			
			//�����ض��������ͣ�����˵���������ΪALL������
			String cooptype = "";
			for(int i=0; i<orderuplimitList.size(); i++)
			{
				cooptype = orderuplimitList.get(i).getCooptype();
				if(null!=cooptype && !cooptype.equals(ComorderConstant.COOPTYPE_ALL))
				{
					hasCooptype = true;
					break;
				}
			}
			
			Set<String> brandSet = new HashSet<String>();
			List<OrderuplimitVO> orderuplimitTempList = new ArrayList<OrderuplimitVO>();
			//��������ˣ����˺�������orderuplimitTempList
			if(hasCooptype)
			{
				for(int i=0; i<orderuplimitList.size(); i++)
				{
					//���˺�������ΪALL�ļ�¼
					cooptype = orderuplimitList.get(i).getCooptype();
					if(null!=cooptype && !cooptype.equals(ComorderConstant.COOPTYPE_ALL))
					{
						String brandTemp = orderuplimitList.get(i).getBrand();
						//���˾�����ͬƷ�Ƶ��ظ�����
						if(!brandSet.contains(brandTemp))
						{
							brandSet.add(brandTemp);
							orderuplimitTempList.add(orderuplimitList.get(i));
						}
					}
				}
			}
			//��������ȡȫ��
			else
			{
				for(int i=0; i<orderuplimitList.size(); i++)
				{
					String brandTemp = orderuplimitList.get(i).getBrand();
					//���˾�����ͬƷ�Ƶ��ظ�����
					if(!brandSet.contains(brandTemp))
					{
						brandSet.add(brandTemp);
						orderuplimitTempList.add(orderuplimitList.get(i));
					}
				}
			}
			
			//δ�ҵ���Ӧ��Ʒ�ƣ���Ʒ����/�¶���������Ϊ0������Ʒ�Ƽ��ϴ�orderuplimitTempList�ٴι��ˣ�����orderuplimitDealList
			for(int i=0; i<brandlist.size(); i++)
			{
				brand = brandlist.get(i).getDictid();
				for(int j=0; j<orderuplimitTempList.size(); j++)
				{
					brand2 = orderuplimitTempList.get(j).getBrand();
					if(null!=brand && null!=brand2 && brand.equals(brand2))
					{
						orderuplimitDealList.add(orderuplimitTempList.get(j));
						hasBrand = true;
						break;
					}
				}
				if(!hasBrand)
				{
					OrderuplimitVO vo = new OrderuplimitVO();
					vo.setBrand(brand);
					vo.setDaylimit(new Long("0"));
					vo.setMonlimit(new Long("0"));
					orderuplimitDealList.add(vo);
				}
				hasBrand = false;
			}

			// ��ȡ���¿ɶ�����
			Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,
					user);
			DataPackage dp2 = new DataPackage();
			String paramvalue = sysparam.doFindByID(
					ComorderConstant.SYSTEMID_ORDER_MONTH,
					ComorderConstant.PARAMTYPE_FX);
			// ���ϵͳ����������¶������������ز���������������ʾ������Ϣ
			
			List<MonorderinfoVO> monorderinforList = new ArrayList<MonorderinfoVO>();
			if (StringUtils.isEmpty(paramvalue)) {
				throw new SaleException("SALE-101002");
				// throw new
				// WebSiteException("ϵͳ�������¶�������������״̬���ݣ�����",RetResult.FAILURE);
			} else {
				// �¶������������ش򿪣����ȡ�¶�������Ϣ�������򲻽��д���
				if (paramvalue.equals(ComorderConstant.ORDER_MONTH_OPEN)) {
					Monorderinfo monorderinfo = (Monorderinfo) BOFactory.build(
							MonorderinfoBO.class, user);
					MonorderinfoDBParam param2 = new MonorderinfoDBParam();
					String todayStr = PublicUtils.formatUtilDate(new Date(),
							"yyyyMM");
					param2.set_se_wayid(wayVO.getWayid());
					param2.set_se_month(todayStr);
					dp2 = monorderinfo.doQuery(param2);
					monorderinforList = dp2.getDatas();
					for(int i=0; i<brandlist.size(); i++)
					{
						brand = brandlist.get(i).getDictid();
						for(int j=0; j<monorderinforList.size(); j++)
						{
							brand2 = monorderinforList.get(j).getBrand();
							if(null!=brand && null!=brand2 && brand.equals(brand2))
							{
								monorderinforDealList.add(monorderinforList.get(j));
								hasBrand = true;
								break;
							}
						}
						//δ�ҵ���Ӧ��Ʒ�ƣ���Ʒ���¿ɶ�������ϢΪ0����ӽ��¿ɶ�������Ϣ�б�
						if(!hasBrand)
						{
							MonorderinfoVO vo = new MonorderinfoVO();
							vo.setBrand(brand);
							vo.setTopamt(null);
							monorderinforDealList.add(vo);
						}
						hasBrand = false;
					}
				}
			}

			// ��ȡʵʱ������
			Realtimeamt realtimeamt = (Realtimeamt) BOFactory.build(
					RealtimeamtBO.class, user);
			RealtimeamtDBParam param3 = new RealtimeamtDBParam();
			param3.set_se_wayid(wayVO.getWayid());
			DataPackage dp3 = realtimeamt.doQuery(param3);
			List<RealtimeamtVO> realtimeamtList = dp3.getDatas();
			
			for(int i=0; i<brandlist.size(); i++)
			{
				brand = brandlist.get(i).getDictid();
				for(int j=0; j<realtimeamtList.size(); j++)
				{
					//����FX_SW_REALTIMEAMT������˫������ͬһ������������ظ�Ʒ�����ݣ����ù���
					brand2 = realtimeamtList.get(j).getBrand();
					if(null!=brand && null!=brand2 && brand.equals(brand2))
					{
						realtimeamtDealList.add(realtimeamtList.get(j));
						hasBrand = true;
						break;
					}
				}
				//δ�ҵ���Ӧ��Ʒ�ƣ���Ʒ���¿ɶ�������ϢΪ0����ӽ��¿ɶ�������Ϣ�б�
				if(!hasBrand)
				{
					RealtimeamtVO vo = new RealtimeamtVO();
					vo.setBrand(brand);
					vo.setMonordered(new Long("0"));
					vo.setDayordered(new Long("0"));
					realtimeamtDealList.add(vo);
				}
				hasBrand = false;
			}

			// �¶�������
			Long amtMonlimit = null;
			// �¿ɶ�����
			Long amtMonCan = null;
			// ����󶩹���
			Long amtMonMax = null;
			// ���Ѷ�����
			Long amtMonOrdered = null;
			// ����󶩹���
			Long amtDayMax = null;
			// ���Ѷ�����
			Long amtDayOrdered = null;

			for (int i = 0; i < orderuplimitDealList.size(); i++) {
				// ����
				amtMonlimit = null;
				amtMonCan = null;
				amtMonMax = null;
				amtMonOrdered = null;
				amtDayMax = null;
				amtDayOrdered = null;
				amtMonCan = null;
				
				OrderMonthdayVO orderMonthdayVO = new OrderMonthdayVO();
				brand = orderuplimitDealList.get(i).getBrand();

				// ��������󶩹���
				amtMonlimit = orderuplimitDealList.get(i).getMonlimit();
				if (null != monorderinforDealList && monorderinforDealList.size() > 0) {
					for (int j = 0; j < monorderinforDealList.size(); j++) {
						brand2 = monorderinforDealList.get(j).getBrand();
						if (null!=brand && null!=brand2 && brand.equals(brand2)) {
							amtMonCan = monorderinforDealList.get(j).getTopamt();
							break;
						}
					}
				}

				// ���õ�����󶩹�����ȡ�¶��������޺͵��¿ɶ����������н�Сֵ��������¿ɶ����������ڣ���ȡ�¶���������
				if (null == amtMonCan) {
					amtMonMax = amtMonlimit;
				} else {
					amtMonMax = (amtMonlimit > amtMonCan) ? amtMonCan
							: amtMonlimit;
				}
				orderMonthdayVO.setOrderMaxMonth(amtMonMax);

				// ��������󶩹���
				amtDayMax = ((OrderuplimitVO) orderuplimitDealList.get(i))
						.getDaylimit();
				orderMonthdayVO.setOrderMaxDay(amtDayMax);

				// ������/���Ѷ�����
				for (int k = 0; k < realtimeamtDealList.size(); k++) {
					brand2 = realtimeamtDealList.get(k).getBrand();
					if (null!=brand && null!=brand2 && brand.equals(brand2)) {
						amtMonOrdered = realtimeamtDealList.get(k).getMonordered();
						amtDayOrdered = realtimeamtDealList.get(k).getDayordered();
					}
				}
				if(null==amtMonOrdered)amtMonOrdered=0L;
				if(null==amtDayOrdered)amtDayOrdered=0L;

				orderMonthdayVO.setOrderedMonth(amtMonOrdered);
				orderMonthdayVO.setOrderedDay(amtDayOrdered);

				// ������/��ʣ�ඩ����
				orderMonthdayVO.setOrderRemainMonth(amtMonMax - amtMonOrdered);
				orderMonthdayVO.setOrderRemainDay(amtDayMax - amtDayOrdered);

				if(orderMonthdayVO.getOrderRemainMonth()<0){
					orderMonthdayVO.setOrderRemainMonth(0L);
				}
				if(orderMonthdayVO.getOrderRemainDay()<0){
					orderMonthdayVO.setOrderRemainDay(0L);
				}
				
				// ����Ʒ��
				orderMonthdayVO.setBrand(brand);

				orderMonthdayList.add(orderMonthdayVO);
			}

			return orderMonthdayList;
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}

	}

	// ��ȡ��׼�����Ϣ
	public List<OrderStdstockVO> doGetOrderInfoByStdstock(WayVO wayVO,List<DictitemVO> brandlist, List<ActiverateVO> activerateList)
			throws Exception {
		try {
			List<OrderStdstockVO> orderStdstockList = new ArrayList<OrderStdstockVO>();
			List<OrderuplimitVO> stdstockDealList = new ArrayList<OrderuplimitVO>();
			List<RealtimeamtVO> realtimeamtDealList = new ArrayList<RealtimeamtVO>();

			// ��ȡ��׼�������
			Orderuplimit orderuplimit = (Orderuplimit) BOFactory.build(OrderuplimitBO.class, user);
			OrderuplimitDBParam param = new OrderuplimitDBParam();

			String cityid = wayVO.getCityid();
			String starlevel = String.valueOf(wayVO.getStarlevel());
			String countyid = wayVO.getCountyid();
			String custtype = wayVO.getCusttype();
			param.set_se_cityid(cityid);
			param.set_ne_starlevel(starlevel);
			param.set_se_countyid(countyid);
			param.set_se_limitmode(ComorderConstant.MODE_STDSTOCK);
			param.set_se_restype("COMRESSMP");//Ĭ���׿�
			
			//��Ӻ�����������
			List<String> _sin_cooptype = new ArrayList<String>();
			_sin_cooptype.add(ComorderConstant.COOPTYPE_ALL);
			if(!StringUtils.isEmpty(custtype)){
				_sin_cooptype.add(custtype);
			}
			param.set_sin_cooptype(_sin_cooptype);
			
			DataPackage dp = orderuplimit.doQuery(param);
			if(dp.getRowCount()==0){
				throw new SaleException("SALE-103012");
			}
			List<OrderuplimitVO> stdstockList = dp.getDatas();

			Boolean hasBrand = false;
			String brand = "";
			String brand2 = "";
			if(stdstockList.size()>0)
			{
				for(int i=0; i<brandlist.size(); i++)
				{
					brand = brandlist.get(i).getDictid();
					for(int j=0; j<stdstockList.size(); j++)
					{
						brand2 = stdstockList.get(j).getBrand();
						if(null!=brand && null!=brand2 && brand.equals(brand2))
						{
							stdstockDealList.add(stdstockList.get(j));
							hasBrand = true;
							break;
						}
					}
					//δ�ҵ���Ӧ��Ʒ��
					if(!hasBrand)
					{
						OrderuplimitVO vo = new OrderuplimitVO();
						vo.setBrand(brand);
						vo.setStdstock(0L);
						vo.setMaxamtmode(ComorderConstant.MAXAMTMODE_STDSTOCK);
						stdstockDealList.add(vo);
					}
					hasBrand = false;
				}
			}
			
			// ��ȡ��ǰ������б�realtimeamtDeallist
			Realtimeamt realtimeamt = (Realtimeamt) BOFactory.build(RealtimeamtBO.class, user);
			RealtimeamtDBParam param2 = new RealtimeamtDBParam();
			param2.set_se_wayid(wayVO.getWayid());
			DataPackage dp2 = realtimeamt.doQuery(param2);
			List<RealtimeamtVO> realtimeamtlist = dp2.getDatas();
			
			if(realtimeamtlist.size()>0)
			{
				for(int i=0; i<brandlist.size(); i++)
				{
					brand = brandlist.get(i).getDictid();
					for(int j=0; j<realtimeamtlist.size(); j++)
					{
						brand2 = realtimeamtlist.get(j).getBrand();
						if(null!=brand && null!=brand2 && brand.equals(brand2))
						{
							realtimeamtDealList.add(realtimeamtlist.get(j));
							hasBrand = true;
							break;
						}
					}
					//δ�ҵ���Ӧ��Ʒ��
					if(!hasBrand)
					{
						RealtimeamtVO vo = new RealtimeamtVO();
						vo.setBrand(brand);
						vo.setNowstock(new Long("0"));
						realtimeamtDealList.add(vo);
					}
					hasBrand = false;
				}
			}
			
			Long stdstock = null;
			Long nowstock = null;
			Double rate = null;
			Double stock = null;
			if (null != stdstockDealList && stdstockDealList.size() == realtimeamtDealList.size()) {
				for (int i = 0; i < stdstockDealList.size(); i++) {
					OrderStdstockVO OrderStdstockVO = new OrderStdstockVO();
					brand = ((OrderuplimitVO) stdstockDealList.get(i)).getBrand();
					OrderStdstockVO.setBrand(brand);

					// ���û�׼�����
					stdstock = stdstockDealList.get(i).getStdstock();
					if (null == stdstock) {
						throw new SaleException("SALE-103018");
					}
					OrderStdstockVO.setStdstock(stdstock);

					// ���õ�ǰ�����
					for (int j = 0; j < realtimeamtDealList.size(); j++) {
						brand2 = realtimeamtDealList.get(j).getBrand();
						if (null!=brand && null!=brand2 && brand2.equals(brand)) {
							nowstock = realtimeamtDealList.get(j).getNowstock();
						}
					}
					// δ�ҵ���Ӧʵʱ���
					if (null == nowstock) {
						// String wayname = Code2NameUtils.code2Name("#WAY",
						// wayVO.getWayid(), user.getCityid());
						String brandname = Code2NameUtils.code2Name("$FX_SMPBRAND", brand, user.getCityid());

						SaleException se = new SaleException("SALE-103006",brandname);
						se.setBrandname(brandname);
						throw se;
						// throw new WebSiteException("wayname:" + wayname +
						// ",brandname��" + brandname + ",δ�ҵ���Ӧʵʱ��棬����",
						// RetResult.FAILURE);
					}

					OrderStdstockVO.setNowstock(nowstock);

					// ���õ�ǰ��󶩹���
					String maxamtmode = ((OrderuplimitVO) stdstockDealList.get(i)).getMaxamtmode();
					if (null == maxamtmode) {
						throw new SaleException("SALE-103014");
					}

					// ��󶩹���ģʽΪ������ģʽʱ����󶩹������⴦��
					if (maxamtmode.equals(ComorderConstant.MAXAMTMODE_ACTRATE)) {
						brand = brandlist.get(i).getDictid();
						for(int j=0; j<activerateList.size(); j++)
						{
							brand2 = activerateList.get(j).getBrand();
							if(null!=brand && null!=brand2 && brand.equals(brand2))
							{
								rate = activerateList.get(j).getRate();
								hasBrand = true;
								break;
							}
						}
						if(hasBrand)
						{
							stock = stdstock * rate;
							//�������û�׼�������
							OrderStdstockVO.setStdstock(stock.longValue());
							OrderStdstockVO.setOrderMax((stock.longValue() - nowstock)>0?(stock.longValue() - nowstock):0L);
						} else {
							if (brand.equals(ComorderConstant.BRAND_TYPE_ALLBRAND)) 
							{
								throw new SaleException("SALE-103003");
								// throw new
								// WebSiteException("�޶�Ӧ��������Ϣ������",RetResult.FAILURE);
							} else {
								String brandname = Code2NameUtils.code2Name("$FX_SMPBRAND", brand, user.getCityid());
								SaleException se = new SaleException("SALE-103004", brandname);
								se.setBrandname(brandname);
								throw se;
							}
						}
					} else {
						OrderStdstockVO.setOrderMax((stdstock - nowstock)>0?(stdstock - nowstock):0);
					}

					orderStdstockList.add(OrderStdstockVO);
				}
			} else {
				throw new SaleException("SALE-103007");
				// throw new
				// WebSiteException("��ǰ������ͻ�׼����������ݲ�һ��",RetResult.FAILURE);
			}
			return orderStdstockList;
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}

	}

	// ��ȡԤ�������Ϣ
	public List<OrderStockalarmVO> doGetOrderInfoByStockalarm(WayVO wayVO,List<DictitemVO> brandlist)
			throws Exception {
		try {
			List<OrderStockalarmVO> orderStockalarmList = new LinkedList<OrderStockalarmVO>();
			
			Stockalarm stockalarm = (Stockalarm) BOFactory.build(
					StockalarmBO.class, user);
			StockalarmDBParam param = new StockalarmDBParam();
			param.set_se_wayid(wayVO.getWayid());
			DataPackage dp = stockalarm.doQuery(param);
			
			// ��ȡ��߿���Ԥ����ֵ
			List<String> alarmbrandlist = new ArrayList<String>();// Ԥ��Ʒ�Ƽ���
			if (dp.getRowCount() > 0) {
				List<StockalarmVO> stockalarmList = dp.getDatas();
				for (int i = 0; i < stockalarmList.size(); i++) {
					OrderStockalarmVO orderStockalarmVO = new OrderStockalarmVO();
					orderStockalarmVO.setBrand(stockalarmList.get(i).getBrand());
					orderStockalarmVO.setAlarmValue(stockalarmList.get(i).getAlarmvalue());
					orderStockalarmVO.setMaxStock(stockalarmList.get(i).getMaxstock());
					orderStockalarmVO.setNowstock(0L);
					orderStockalarmVO.setOrderMax(0L);
					orderStockalarmList.add(orderStockalarmVO);
					alarmbrandlist.add(stockalarmList.get(i).getBrand());// ��¼�´��ڵĶ�ӦԤ��Ʒ�Ƽ���
				}
			}
			Orderuplimit orderuplimit = (Orderuplimit) BOFactory.build(
					OrderuplimitBO.class, user);
			OrderuplimitDBParam opparam = new OrderuplimitDBParam();
			opparam.set_se_cityid(wayVO.getCityid());
			opparam.set_se_countyid(wayVO.getCountyid());
			opparam.set_ne_starlevel(String.valueOf(wayVO.getStarlevel()));
			opparam.set_se_limitmode(ComorderConstant.MODE_STOCKALARM);
			opparam.set_se_restype("COMRESSMP");// Ĭ���׿�
			opparam.getQueryConditions().put("_snin_brand", alarmbrandlist);//�ų������¼��Ԥ��Ʒ��
			DataPackage dp2 = orderuplimit.doQuery(opparam);

			if (dp2.getRowCount() > 0) {
				List<OrderuplimitVO> orderuplimitList = dp2.getDatas();
				for (int i = 0; i < orderuplimitList.size(); i++) {
					OrderStockalarmVO orderStockalarmVO = new OrderStockalarmVO();
					orderStockalarmVO.setBrand(orderuplimitList.get(i).getBrand());
					orderStockalarmVO.setAlarmValue(orderuplimitList.get(i).getAlarmvalue());
					orderStockalarmVO.setMaxStock(orderuplimitList.get(i).getMaxstock());
					orderStockalarmVO.setNowstock(0L);
					orderStockalarmVO.setOrderMax(0L);
					orderStockalarmList.add(orderStockalarmVO);
				}
			}
			if (dp.getRowCount() == 0 && dp2.getRowCount() == 0) {
				throw new SaleException("SALE-103019");
			}
			
			//��ȡ��ǰ�����
			Realtimeamt realtimeamt = (Realtimeamt) BOFactory.build(RealtimeamtBO.class, user);
			RealtimeamtDBParam param3 = new RealtimeamtDBParam();
			param3.set_se_wayid(wayVO.getWayid());
			DataPackage dp3 = realtimeamt.doQuery(param3);
			if(dp3.getRowCount()>0){
				List<RealtimeamtVO> realtimeamtList = dp3.getDatas();
				String brand = "";
				String brand2 = "";
				//Long maxStock = -1L;
				Long nowStock = -1L;
				//Long orderMax = -1L;
				for(int i=0; i<realtimeamtList.size(); i++)
				{
					brand = realtimeamtList.get(i).getBrand();
					for(int j=0; j<orderStockalarmList.size(); j++)
					{
						brand2 = orderStockalarmList.get(j).getBrand();
						if(null!=brand && null!=brand2 && brand.equals(brand2))
						{
							//maxStock = orderStockalarmList.get(j).getMaxStock();
							nowStock = realtimeamtList.get(i).getNowstock();
							//if(null==maxStock)maxStock=0L;
							if(null==nowStock)nowStock=0L;
							//orderMax = (maxStock.longValue()- nowStock)>0?(maxStock.longValue()- nowStock):0L;
							
							//orderStockalarmList.get(j).setMaxStock(maxStock);
							orderStockalarmList.get(j).setNowstock(nowStock);
							//orderStockalarmList.get(j).setOrderMax(orderMax);
						}
					}
				}
				//Ԥ����湲����		0Ϊ�رգ�1Ϊ����
				Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
				String param73 = sysparamBO.doFindByID("73", "pboss_fx");
				if("1".equals(param73)){
					for(int j=0; j<orderStockalarmList.size(); j++){
						//Ʒ�ƹ����ر���ǰ�����
						brand2 = orderStockalarmList.get(j).getBrand();
						if(null!=brand2 && brand2.indexOf(",")>=0){
							String brand2Arr[] = brand2.split(",");
							nowStock = 0L;
							for(int k=0 ; k<brand2Arr.length ; k++){
								String brand3 = brand2Arr[k];	
								for(int l=0; l<realtimeamtList.size(); l++){
									String brand4 = realtimeamtList.get(l).getBrand();
									if(null!=brand3 && null!=brand4 && brand3.equals(brand4)){
										Long nowStock1 = realtimeamtList.get(l).getNowstock();
										
										if(null==nowStock1)nowStock1=0L;
										nowStock = nowStock + nowStock1;
									}
								}
							}
							orderStockalarmList.get(j).setNowstock(nowStock);
						}
					}
				}
			}
			else{
				for(int j=0; j<orderStockalarmList.size(); j++)
				{
					orderStockalarmList.get(j).setNowstock(0L);
				}
			}
			//��ǰ��󶩹���
			for(int j=0; j<orderStockalarmList.size(); j++)
			{
				Long maxStock = -1L;
				Long nowStock = -1L;
				Long orderMax = -1L;
				maxStock = orderStockalarmList.get(j).getMaxStock();
				nowStock = orderStockalarmList.get(j).getNowstock();
				if(null==maxStock)maxStock=0L;
				if(null==nowStock)nowStock=0L;
				orderMax = (maxStock.longValue()- nowStock)>0?(maxStock.longValue()- nowStock):0L;
				orderStockalarmList.get(j).setOrderMax(orderMax);
			}
			
			//ת��Ԥ����ֵ
			String alarmValue = "";
			String dictid = "";
			String dictname = "";
			Dictitem dictitem = (Dictitem)BOFactory.build(DictitemBO.class, user);
			DictitemDBParam param2 = new DictitemDBParam();
			param2.set_se_groupid("FX_STOCKALARMLEVEL");
			DataPackage dp4 = dictitem.doQuery(param2);
			if(dp4.getRowCount()>0)
			{
				List<DictitemVO> alarmList = dp4.getDatas();
				for(int i=0; i<orderStockalarmList.size(); i++)
				{
					alarmValue = orderStockalarmList.get(i).getAlarmValue();
					for(int j=0; j<alarmList.size(); j++)
					{
						dictid = alarmList.get(j).getDictid();
						if(!StringUtils.isEmpty(dictid))
						{
							dictname = alarmList.get(j).getDictname();
							alarmValue = alarmValue.replaceAll(dictid, dictname);
						}
					}
					orderStockalarmList.get(i).setAlarmValue(alarmValue);
				}
			}
			Map brandMap = Code2NameUtils.valueList("$FX_SMPBRAND", user.getCityid());			
			for(int i=0; i<orderStockalarmList.size(); i++)
			{
				//Ʒ�ƹ�����
				String brandString = orderStockalarmList.get(i).getBrand();
				String brandsName = "";
				if(brandString.indexOf(",")>=0){
					String brand2Arr[] = brandString.split(",");
					for(int k=0 ; k<brand2Arr.length ; k++){
						String brand3 = brand2Arr[k];
						brandsName = brandsName + (String)brandMap.get(brand3) + ",";
					}
					if(brandsName.lastIndexOf(",") == (brandsName.length()-1)){
						brandsName = brandsName.substring(0, (brandsName.length()-1));
					}
				}else{
					brandsName = (String)brandMap.get(brandString);					
				}
				orderStockalarmList.get(i).setBrandsName(brandsName);
			}
			
			return orderStockalarmList;
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}

	}
	
	// ��ȡ��ֵ��������Ϣ
	public List<OrderCardVO> doGetOrderInfoByCard(WayVO wayVO)
			throws Exception {
		try {
			List<OrderCardVO> orderCardList = new ArrayList<OrderCardVO>();			

			//1����ȡ��/�¶�������������
			Orderuplimit orderuplimit = (Orderuplimit) BOFactory.build(
					OrderuplimitBO.class, user);
			OrderuplimitDBParam param = new OrderuplimitDBParam();

			String cityid = wayVO.getCityid();
			String starlevel = String.valueOf(wayVO.getStarlevel());
			String countyid = wayVO.getCountyid();
			String custtype = wayVO.getCusttype();
			param.set_se_cityid(cityid);
			param.set_ne_starlevel(starlevel);
			param.set_se_countyid(countyid);
			//param.set_se_limitmode(ComorderConstant.MODE_MONDAYLIMIT);
			param.set_se_restype("COMRESCARD");//Ĭ�ϳ�ֵ��
			
			//��Ӻ�����������
			List<String> _sin_cooptype = new ArrayList<String>();
			_sin_cooptype.add(ComorderConstant.COOPTYPE_ALL);
			if(!StringUtils.isEmpty(custtype)){
				_sin_cooptype.add(custtype);
			}
			param.set_sin_cooptype(_sin_cooptype);
			
			//��ȡ��ѯ�б�
			DataPackage dp = orderuplimit.doQuery(param);
			if(dp.getRowCount() == 0){
				return orderCardList;
			}
			List<OrderuplimitVO> orderuplimitList = dp.getDatas();
						
			Boolean hasCooptype = false;
			
			//�����ض��������ͣ�����˵���������ΪALL������
			//����õ�'�Ƿ�����ض���������'
			String cooptype = "";
			for(int i=0; i<orderuplimitList.size(); i++)
			{
				cooptype = orderuplimitList.get(i).getCooptype();
				if(null!=cooptype && !cooptype.equals(ComorderConstant.COOPTYPE_ALL))
				{
					hasCooptype = true;
					break;
				}
			}
			
			Set<String> comcategorySet = new HashSet<String>();
			List<OrderuplimitVO> orderuplimitTempList = new ArrayList<OrderuplimitVO>();
			//��������ˣ����˺�������orderuplimitTempList
			if(hasCooptype)
			{
				for(int i=0; i<orderuplimitList.size(); i++)
				{
					//���˺�������ΪALL�ļ�¼
					cooptype = orderuplimitList.get(i).getCooptype();
					if(null!=cooptype && !cooptype.equals(ComorderConstant.COOPTYPE_ALL))
					{
						String comcategoryTemp = orderuplimitList.get(i).getComcategory();
						//���˾�����ͬ��Ʒ������ظ�����
						if(!comcategorySet.contains(comcategoryTemp))
						{
							comcategorySet.add(comcategoryTemp);
							orderuplimitTempList.add(orderuplimitList.get(i));
						}
					}
				}
			}
			//��������ȡȫ��
			else
			{
				for(int i=0; i<orderuplimitList.size(); i++)
				{
					String comcategoryTemp = orderuplimitList.get(i).getComcategory();
					//���˾�����ͬ��Ʒ������ظ�����
					if(!comcategorySet.contains(comcategoryTemp))
					{
						comcategorySet.add(comcategoryTemp);
						orderuplimitTempList.add(orderuplimitList.get(i));
					}
				}
			}

			// ��ȡʵʱ������
			//����Ʒ������б���
			//��������Ϣ����
			Order order = (Order)BOFactory.build(OrderBO.class, user);
			OrderDBParam params = new OrderDBParam();
			for(int i=0;i<orderuplimitTempList.size();i++)
			{
				String comcategory = orderuplimitTempList.get(i).getComcategory();
				Long amtDayOrdered = order.doQueryOrderedToday(params, wayVO.getWayid(), comcategory);//�����Ѷ�����
				Long amtMonOrdered = order.doQueryOrderedMonth(params, wayVO.getWayid(), comcategory);//�����Ѷ�����
				OrderCardVO ordercardvo = new OrderCardVO();
				ordercardvo.setComcategory(comcategory);
				ordercardvo.setOrderMaxMonth(orderuplimitTempList.get(i).getMonlimit());
				ordercardvo.setOrderedMonth(amtMonOrdered);
				ordercardvo.setOrderRemainMonth(orderuplimitTempList.get(i).getMonlimit()-amtMonOrdered);
				ordercardvo.setOrderMaxDay(orderuplimitTempList.get(i).getDaylimit());
				ordercardvo.setOrderedDay(amtDayOrdered);
				ordercardvo.setOrderRemainDay(orderuplimitTempList.get(i).getDaylimit()-amtDayOrdered);
				
				if(orderuplimitTempList.get(i).getOncelimit()==null || orderuplimitTempList.get(i).getOncelimit().equals("")){
					ordercardvo.setOncelimit(0L);
				}else{
				ordercardvo.setOncelimit(orderuplimitTempList.get(i).getOncelimit());
				}
				
				orderCardList.add(ordercardvo);
			}
			
			return orderCardList;
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}
	
	//��ȡ�հ�SIM��������Ϣ
	public List<OrderCardVO> doGetOrderInfoByEmptyCard(WayVO wayVO)
			throws Exception {
		try {
			List<OrderCardVO> orderCardList = new ArrayList<OrderCardVO>();			

			//1����ȡ��/�¶�������������
			Orderuplimit orderuplimit = (Orderuplimit) BOFactory.build(
					OrderuplimitBO.class, user);
			OrderuplimitDBParam param = new OrderuplimitDBParam();

			String cityid = wayVO.getCityid();
			String starlevel = String.valueOf(wayVO.getStarlevel());
			String countyid = wayVO.getCountyid();
			String custtype = wayVO.getCusttype();
			param.set_se_cityid(cityid);
			param.set_ne_starlevel(starlevel);
			param.set_se_countyid(countyid);
			//param.set_se_limitmode(ComorderConstant.MODE_MONDAYLIMIT);
			param.set_se_restype("EMPTYSIM");//Ĭ�Ͽհ׿�
			
			//��Ӻ�����������
			List<String> _sin_cooptype = new ArrayList<String>();
			_sin_cooptype.add(ComorderConstant.COOPTYPE_ALL);
			if(!StringUtils.isEmpty(custtype)){
				_sin_cooptype.add(custtype);
			}
			param.set_sin_cooptype(_sin_cooptype);
			
			//��ȡ��ѯ�б�
			DataPackage dp = orderuplimit.doQuery(param);
			if(dp.getRowCount() == 0){
				return orderCardList;
			}
			List<OrderuplimitVO> orderuplimitList = dp.getDatas();
						
			Boolean hasCooptype = false;
			
			//�����ض��������ͣ�����˵���������ΪALL������
			//����õ�'�Ƿ�����ض���������'
			String cooptype = "";
			for(int i=0; i<orderuplimitList.size(); i++)
			{
				cooptype = orderuplimitList.get(i).getCooptype();
				if(null!=cooptype && !cooptype.equals(ComorderConstant.COOPTYPE_ALL))
				{
					hasCooptype = true;
					break;
				}
			}
			
			Set<String> comcategorySet = new HashSet<String>();
			List<OrderuplimitVO> orderuplimitTempList = new ArrayList<OrderuplimitVO>();
			//��������ˣ����˺�������orderuplimitTempList
			if(hasCooptype)
			{
				for(int i=0; i<orderuplimitList.size(); i++)
				{
					//���˺�������ΪALL�ļ�¼
					cooptype = orderuplimitList.get(i).getCooptype();
					if(null!=cooptype && !cooptype.equals(ComorderConstant.COOPTYPE_ALL))
					{
						String comcategoryTemp = orderuplimitList.get(i).getComcategory();
						//���˾�����ͬ��Ʒ������ظ�����
						if(!comcategorySet.contains(comcategoryTemp))
						{
							comcategorySet.add(comcategoryTemp);
							orderuplimitTempList.add(orderuplimitList.get(i));
						}
					}
				}
			}
			//��������ȡȫ��
			else
			{
				for(int i=0; i<orderuplimitList.size(); i++)
				{
					String comcategoryTemp = orderuplimitList.get(i).getComcategory();
					//���˾�����ͬ��Ʒ������ظ�����
					if(!comcategorySet.contains(comcategoryTemp))
					{
						comcategorySet.add(comcategoryTemp);
						orderuplimitTempList.add(orderuplimitList.get(i));
					}
				}
			}

			// ��ȡʵʱ������
			//����Ʒ������б���
			//��������Ϣ����
			Order order = (Order)BOFactory.build(OrderBO.class, user);
			OrderDBParam params = new OrderDBParam();
			for(int i=0;i<orderuplimitTempList.size();i++)
			{
				String comcategory = orderuplimitTempList.get(i).getComcategory();
				Long amtDayOrdered = order.doQueryOrderedToday(params, wayVO.getWayid(), comcategory);//�����Ѷ�����
				Long amtMonOrdered = order.doQueryOrderedMonth(params, wayVO.getWayid(), comcategory);//�����Ѷ�����
				OrderCardVO ordercardvo = new OrderCardVO();
				ordercardvo.setComcategory(comcategory);
				ordercardvo.setOrderMaxMonth(orderuplimitTempList.get(i).getMonlimit());
				ordercardvo.setOrderedMonth(amtMonOrdered);
				ordercardvo.setOrderRemainMonth(orderuplimitTempList.get(i).getMonlimit()-amtMonOrdered);
				ordercardvo.setOrderMaxDay(orderuplimitTempList.get(i).getDaylimit());
				ordercardvo.setOrderedDay(amtDayOrdered);
				ordercardvo.setOrderRemainDay(orderuplimitTempList.get(i).getDaylimit()-amtDayOrdered);
				
				if(orderuplimitTempList.get(i).getOncelimit()==null || orderuplimitTempList.get(i).getOncelimit().equals("")){
					ordercardvo.setOncelimit(0L);
				}else{
				ordercardvo.setOncelimit(orderuplimitTempList.get(i).getOncelimit());
				}
				
				orderCardList.add(ordercardvo);
			}
			
			return orderCardList;
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}
	
	// ȷ��������Դ����
	public String doGetStorArea(WayVO wayVO) throws Exception {
		try {
			String storarea;
			// �Ƿ����ñ�����Դ
			Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,
					user);
			SysparamDBParam param = new SysparamDBParam();
			param.set_se_paramtype("pboss_fx");
			param.set_ne_systemid("6");
			DataPackage dp1 = sysparam.doQuery(param);
			if (null == dp1 || dp1.getDatas().size() == 0) {
				// �ж�����������Ƿ����dis
				String waysubtype = wayVO.getWaysubtype();
				if (null != waysubtype && waysubtype.equals("DIS")) {
					storarea = "LS";
				} else
					storarea = "ZG";

				return storarea;
			}
			SysparamVO sysparamvo = (SysparamVO) dp1.getDatas().get(0);
			String paramvalue = sysparamvo.getParamvalue();
			if (paramvalue.equals("1")) {
				storarea = "BD";
			} else {
				// �ж�����������Ƿ����dis
				String waysubtype = wayVO.getWaysubtype();
				if (null != waysubtype && waysubtype.equals("DIS")) {
					storarea = "LS";
				} else
					storarea = "ZG";

				return storarea;
			}
			// ������Դ���Ƿ�������
			Compack compack = (Compack) BOFactory.build(CompackBO.class, user);
			CompackDBParam cparam = new CompackDBParam();
			cparam.set_se_storarea("BD");
			DataPackage dp3 = compack.doQuery(cparam);
			if (null != dp3 && dp3.getDatas().size() > 0) {
				storarea = "BD";
			} else {
				String waysubtype = wayVO.getWaysubtype();
				if (waysubtype.equals("DIS")) {
					storarea = "LS";
				} else
					storarea = "ZG";

				return storarea;
			}
			// ��ȡ������
			Baseorderamt baseorderamt = (Baseorderamt) BOFactory.build(
					BaseorderamtBO.class, user);
			BaseorderamtDBParam bparam = new BaseorderamtDBParam();

			bparam.set_se_cityid(wayVO.getCityid());
			bparam.set_ne_starlevel(wayVO.getStarlevel().shortValue());
			DataPackage dp4 = baseorderamt.doQuery(bparam);
			Long baseamt = null;
			if (null != dp4 && dp4.getDatas().size() > 0) {
				BaseorderamtVO baseorderamtvo = (BaseorderamtVO) dp4.getDatas()
						.get(0);
				baseamt = baseorderamtvo.getBaseamt();
			}

			// ��ȡ�����Ѷ�����
			Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,
					user);
			java.util.Calendar c1 = java.util.Calendar.getInstance();
			c1.setTime(new Date());
			String _dnl_createtime = PublicUtils.getMonthBegin(c1
					.get(java.util.Calendar.YEAR), c1
					.get(java.util.Calendar.MONTH) + 1);
			String _dnm_createtime = PublicUtils.formatUtilDate(new Date(),
					"yyyy-MM-dd hh:mm:ss");
			Long monordered = comorder.getMonordered(wayVO.getWayid(),
					_dnl_createtime, _dnm_createtime);

			// �жϵ����Ѷ������Ƿ���ڵ��ڱ�����
			if (baseamt == null || monordered >= baseamt) {
				// �ж�����������Ƿ����dis
				String waysubtype = wayVO.getWaysubtype();
				if (waysubtype.equals("DIS")) {
					storarea = "LS";
				} else
					storarea = "ZG";

				return storarea;
			} else
				storarea = "BD";

			return storarea;
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}

	}

	// ��ȡ��Ʒ������ʾ��Ϣ
	public String doGetOrderHint() throws Exception {
		try {
			String hint = "";
			Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,
					user);
			SysparamDBParam param = new SysparamDBParam();
			param.set_se_paramtype(ComorderConstant.PARAMTYPE_FX);
			param.set_ne_systemid(ComorderConstant.SYSTEMID_ORDER_HINT);
			DataPackage dp = sysparam.doQuery(param);

			if (null != dp.getDatas() && dp.getDatas().size() > 0)
				hint = ((SysparamVO) dp.getDatas().get(0)).getParamvalue();
			return hint;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	// ��ȡ��Ʒ������Ϣ
	public Double doGetUnitprice(String wayid, String comcategory) throws Exception {
		try {
			Double unitprice = null;//��Ʒ����
			//��Ʒ�ۼ�ģʽ SPEPRICE-ָ���ۼ� SALEPLAN-�Żݷ���
			Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
			String spePrice = sysparamBO.doFindByID("71", "pboss_fx");
			if(spePrice != null && "SALEPLAN".equals(spePrice)){
				//ȡĬ�ϵ�һ���Żݷ���
				Map<String,String> salePlanType = getSalePlanMap(comcategory);
				String planCode = "";
				if(salePlanType != null && !"".equals(salePlanType) 
						&& salePlanType.size()>0){
					Iterator iter = salePlanType.entrySet().iterator();
					while (iter.hasNext()) {
					    Map.Entry entry = (Map.Entry) iter.next();
					    planCode = (String)entry.getKey();
					    break;
					}
				}
				
				unitprice = doGetUnitprice(wayid,comcategory,planCode);
			}else{
				unitprice = getUnitprice(wayid, comcategory);
			}
			
			return unitprice;
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}
	
	public Map doGetUnitpriceAndPlancode(String wayid, String comcategory) throws Exception {
		Map rtMap = new HashMap();
		try {
			Double unitprice = null;//��Ʒ����
			//��Ʒ�ۼ�ģʽ SPEPRICE-ָ���ۼ� SALEPLAN-�Żݷ���
			Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
			String spePrice = sysparamBO.doFindByID("71", "pboss_fx");
			if(spePrice != null && "SALEPLAN".equals(spePrice)){
				//ȡĬ�ϵ�һ���Żݷ���
				Map<String,String> salePlanType = getSalePlanMap(comcategory);
				String planCode = "";
				if(salePlanType != null && !"".equals(salePlanType) 
						&& salePlanType.size()>0){
					Iterator iter = salePlanType.entrySet().iterator();
					while (iter.hasNext()) {
					    Map.Entry entry = (Map.Entry) iter.next();
					    planCode = (String)entry.getKey();
					    rtMap.put("planCode", planCode);
					    break;
					}
				}
				
				unitprice = doGetUnitprice(wayid,comcategory,planCode);
			}else{
				unitprice = getUnitprice(wayid, comcategory);
			}
			rtMap.put("unitprice", ""+unitprice);
		}catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
		return rtMap;
	}
	
	private Double getUnitprice(String wayid, String comcategory ) throws Exception {
		Way way = (Way) BOFactory.build(WayBO.class, user);
		WayVO wayVO = way.doFindByPk(wayid);
		String cityid = wayVO.getCityid();
		String countyid = wayVO.getCountyid();
		String custtype = wayVO.getCusttype();
		Long starlevel = wayVO.getStarlevel();
		
		Double unitprice = null;//��Ʒ����
		
		// ��ȡ��Ʒ�۸���Ϣ
		Comprice comprice = (Comprice) BOFactory.build(CompriceBO.class,user);
		CompriceDBParam param = new CompriceDBParam();
		
		param.set_se_cityid(cityid);
		param.set_se_countyid(countyid);
		param.set_se_comcategory(comcategory);
		
		//��Ӻ�����������
		List<String> _sin_cooptype = new ArrayList<String>();
		_sin_cooptype.add(ComorderConstant.COOPTYPE_ALL);
		if(!StringUtils.isEmpty(custtype)){
			_sin_cooptype.add(custtype);
		}
		param.set_sin_cooptype(_sin_cooptype);
		
		//����Ǽ���ѯ����
		List<Short> _nin_starlevel = new ArrayList<Short>();
		_nin_starlevel.add(Short.parseShort(ComorderConstant.STARLEVEL_ALL));
		if(null!=starlevel){
			_nin_starlevel.add(starlevel.shortValue());
		}
		param.set_nin_starlevel(_nin_starlevel);
		
		DataPackage dp = comprice.doQuery(param);
		List<CompriceVO> compriceList = dp.getDatas();
		
		// ��������
		if(compriceList.size()>0)
		{
			List<CompriceVO> compriceDealList1 = new ArrayList<CompriceVO>();
			List<CompriceVO> compriceDealList2 = new ArrayList<CompriceVO>();
			
			//ͨ���Ǽ�����
			String starlevelTemp = "";
			Boolean hasStarlevel = false;
			for(int i=0; i<compriceList.size(); i++)
			{
				starlevelTemp = String.valueOf(compriceList.get(i).getStarlevel());
				if(null!=starlevelTemp && !starlevelTemp.equals(ComorderConstant.STARLEVEL_ALL))
				{
					hasStarlevel = true;
					break;
				}
			}

			//��������ˣ����˺�������orderuplimitTempList
			if(hasStarlevel)
			{
				for(int i=0; i<compriceList.size(); i++)
				{
					//���˺�������ΪALL�ļ�¼
					starlevelTemp = String.valueOf(compriceList.get(i).getStarlevel());
					if(null!=starlevelTemp && !starlevelTemp.equals(ComorderConstant.STARLEVEL_ALL))
					{
						compriceDealList1.add(compriceList.get(i));
					}
				}
			}
			//��������ȡȫ��
			else
			{
				compriceDealList1.addAll(compriceList);
			}
			
			//ͨ���������͹���
			String cooptype = "";
			Boolean hasCooptype = false;
			for(int i=0; i<compriceDealList1.size(); i++)
			{
				cooptype = compriceDealList1.get(i).getCooptype();
				if(null!=cooptype && !cooptype.equals(ComorderConstant.COOPTYPE_ALL))
				{
					hasCooptype = true;
					break;
				}
			}

			//��������ˣ����˺�������orderuplimitTempList
			if(hasCooptype)
			{
				for(int i=0; i<compriceDealList1.size(); i++)
				{
					//���˺�������ΪALL�ļ�¼
					cooptype = compriceDealList1.get(i).getCooptype();
					if(null!=cooptype && !cooptype.equals(ComorderConstant.COOPTYPE_ALL))
					{
						compriceDealList2.add(compriceDealList1.get(i));
					}
				}
			}
			//��������ȡȫ��
			else
			{
				compriceDealList2.addAll(compriceDealList1);
			}
			
			// ������ʱ,�������ַ�ʽ�����Ʒ�۸�
			CompriceVO compriceVO = compriceDealList2.get(0);
			String pricediftype = compriceVO.getPricediftype();
			// �ۼ����ַ�ʽ�������֣�����Ʒ�۸�Ϊͳһ��
			if (null != pricediftype
					&& pricediftype
							.equals(ComorderConstant.PRICEDIFTYPE_NODIF)) {
				unitprice = compriceVO.getPrice1();
			}
			// �ۼ����ַ�ʽ�ǰ���˽�ʻ����֣�����ݸ��˻��ǹ�������˽��ȡ����Ӧ�ļ۸�
			else if (null != pricediftype
					&& pricediftype
							.equals(ComorderConstant.PRICEDIFTYPE_ACCOUNT)) {
				Wayaccount wayaccount = (Wayaccount) BOFactory.build(
						WayaccountBO.class, user);
				WayaccountDBParam param2 = new WayaccountDBParam();
				param2.set_se_wayid(wayid);
				DataPackage dp2 = wayaccount.doQuery(param2);
				if (null != dp2.getDatas() && dp2.getDatas().size() > 0) {
					Short accttype = ((WayaccountVO) dp2.getDatas()
							.get(0)).getAccttype();
					// �Թ�
					if (null != accttype
							&& accttype
									.equals(ComorderConstant.ACCOUNT_TO_CO)) {
						unitprice = compriceVO.getPrice1();
					}
					// ��˽
					else {
						unitprice = compriceVO.getPrice2();
					}
				} else {
					throw new SaleException("SALE-104001");
					// throw new WebSiteException("�˻���Ϣ�����ڣ�����",
					// RetResult.FAILURE);
				}
			}
			// �ۼ����ַ�ʽ�ǰ��Ƿ��ӡ��Ʊ���֣��������Ʒ����������Ϣ���Ƿ��ӡ��Ʊȷ���ۼ�
			else if (null != pricediftype
					&& pricediftype
							.equals(ComorderConstant.PRICEDIFTYPE_INVOICE)) {
				Wayassistant wayassistant = (Wayassistant) BOFactory
						.build(WayassistantBO.class, user);
				WayassistantVO wayassistantVO = wayassistant
						.doFindByPk(wayid);
				if (null != wayassistantVO) {
					Short printinvoice = wayassistantVO
							.getPrintinvoice();
					// ��ӡ��Ʊ
					if (null != printinvoice
							&& printinvoice
									.equals(ComorderConstant.INVOICE_PRI)) {
						unitprice = compriceVO.getPrice1();
					}
					// ����ӡ��Ʊ
					else {
						unitprice = compriceVO.getPrice2();
					}
				} else {
					throw new SaleException("SALE-103002");
					// throw new WebSiteException("��Ʒ����������Ϣ�����ڣ�����",
					// RetResult.FAILURE);
				}
			}
		}
		//�����ݱ���
		else{
			String compname = Code2NameUtils.code2Name("#CNTYCOMPANY",countyid, user.getCityid());
			
			//��ȡ������
			String cooptypename = "";
			if(!StringUtils.isEmpty(custtype))
			{
				Custwaytype custwaytype = (Custwaytype) BOFactory.build(CustwaytypeBO.class, user);
				CustwaytypeDBParam param3 = new CustwaytypeDBParam();
				param3.set_ne_citycompid(user.getCityid());
				param3.set_se_custwaytypecode(custtype);
				DataPackage dp3 = custwaytype.doQuery(param3);
				if (dp3.getRowCount() > 0) {
					CustwaytypeVO custwaytypeVO = ((List<CustwaytypeVO>) dp3.getDatas()).get(0);
					cooptypename = custwaytypeVO.getCustwaytypename();
				}
			}
			
			String starlevelname = Code2NameUtils.code2Name("$CH_STARLEVEL",String.valueOf(starlevel), user.getCityid());
			String[] msgParam = { comcategory, compname, cooptypename, starlevelname};
			SaleException se = new SaleException("SALE-102001", msgParam);
			se.setComcode(comcategory);
			se.setCompname(compname);
			if( null==custtype ||"".equals(custtype)){
				se.setCooptypename("");
			}else{
				se.setCooptypename(cooptypename);
			}
			se.setStarlevelname(starlevelname);
			throw se;
			// throw new WebSiteException("��Ʒ�ۼ����ݲ�����",
			// RetResult.FAILURE);
		}
		
		return unitprice;
	}

	// ��ȡ����������Ϣ
	public String doGetUnitage(String cityid, String comcategory)
			throws Exception {
		try {
			String unitage = "1";

			// ����Ʒ������Ϲ�ϵ���ȡ������Ʒ�Ƿ�Ϊ�׿�
			Comcategoryrela comcategoryrela = (Comcategoryrela) BOFactory
					.build(ComcategoryrelaBO.class, user);
			ComcategoryrelaDBParam param = new ComcategoryrelaDBParam();
			param.set_se_comcategory(comcategory);
			DataPackage dp = comcategoryrela.doQuery(param);

			if (null != dp.getDatas() && dp.getDatas().size() > 0) {
				ComcategoryrelaVO comcategoryrelaVO = (ComcategoryrelaVO) dp
						.getDatas().get(0);
				String restype = comcategoryrelaVO.getRestype();

				Orderunit orderunit = (Orderunit) BOFactory.build(
						OrderunitBO.class, user);
				OrderunitDBParam param2 = new OrderunitDBParam();
				param2.set_se_cityid(cityid);
				param2.set_se_comcategory(comcategory);
				DataPackage dp2 = orderunit.doQuery(param2);

				if (null != dp2.getDatas() && dp2.getDatas().size() > 0) {
					OrderunitVO orderunitVO = (OrderunitVO) dp2.getDatas().get(
							0);
					String unitagemode = orderunitVO.getUnitagemode();
					// ����׿��Ķ��������ǰ����ڻ��ֵģ�����ݶ�������Ϊ���õĵ���Ļ��������򶩹�����Ϊ���õĻ���
					if (unitagemode.equals(ComorderConstant.UNITAGEMODE_WEEK)) {
						String[] unitageArray = orderunitVO.getUnitage().split(
								"\\|");
						// ��ȡ���������������
						int arrayIndex = getUnitageIndex();
						unitage = unitageArray[arrayIndex];
					} else {
						unitage = orderunitVO.getUnitage();
					}
				} else {// ���������Ĭ���׿���������Ϊ20����ֵ����������Ϊ1
					if (null != restype
							&& restype.equals(ComorderConstant.RESTYPE_SMP))
						unitage = ComorderConstant.BASE_ORDER_DEFAULT;
					else
						unitage = "1";
				}
			} else {
				SaleException se = new SaleException("SALE-102002", comcategory);
				se.setComcode(comcategory);
				throw se;
			}
			return unitage;
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	/**
	 * ��������,���ض�����
	 */
	public void doBuildOrder(String orderid, WayVO wayVO, String storarea,
			List<ComorderVO> comorderList, Set<String> brandSet, String orderave, String alarmlevel)
			throws Exception {
		try {
			// a)��������ȷ��
			Orderflow orderflow = (Orderflow) BOFactory.build(
					OrderflowBO.class, user);
			OrderflowDBParam param = new OrderflowDBParam();
			param.set_se_cityid(wayVO.getCityid());
			if(orderave == null){
				orderave = "HALL";
			}
			if(isurgent){
				orderave = "URGENT";
			}
			param.set_se_orderave(orderave);
			param.set_se_paytype(wayVO.getPaytype());
			param.set_se_delitype(wayVO.getDelitype());
			param.set_ne_effective(ComorderConstant.EFFECTIVE_YES);
			DataPackage dp = orderflow.doQuery(param);

			String outstate = "";
			Long flowid = null;
			// ��ѯ�������̱������������������������ʾ������Ϣ
			if (null != dp.getDatas() && dp.getDatas().size() > 0) {
				OrderflowVO orderflowVO = (OrderflowVO) dp.getDatas().get(0);
				flowid = orderflowVO.getFlowid();

				Orderproce orderproce = (Orderproce) BOFactory.build(
						OrderproceBO.class, user);
				OrderproceDBParam param2 = new OrderproceDBParam();
				param2.set_ne_flowid(String.valueOf(flowid));
				DataPackage dp2 = orderproce.doQuery(param2);

				OrderproceVO orderproceVO = new OrderproceVO();
				// ��ѯ�����������̱������������������������ʾ������Ϣ�����������Ϊ�յĲ���Ҳ��ʾ������Ϣ
				if (null != dp2.getDatas() && dp2.getDatas().size() > 0) {
					for (int i = 0; i < dp2.getDatas().size(); i++) {
						orderproceVO = (OrderproceVO) dp2.getDatas().get(i);
						if (null == orderproceVO.getInstate()) {
							outstate = orderproceVO.getOutstate();
							break;
						}
					}
				}
				// �������̲����޶�Ӧ����
				else {
					throw new SaleException("SALE-102004");
					// throw new WebSiteException("���������쳣", RetResult.FAILURE);
				}
				// δ�ҵ����Ϊ�յĲ���
				if (outstate.equals("")) {
					throw new SaleException("SALE-102004");
					// throw new WebSiteException("���������쳣", RetResult.FAILURE);
				}

			}
			// ���������޶�Ӧ����
			else {
				throw new SaleException("SALE-102003");
				// throw new WebSiteException("���������쳣", RetResult.FAILURE);
			}

			// ��ȡ������ţ��������ȡ��ǰ����+��ǰʱ��+sequence
			// c)������Ʒ����
			Ordercomcate ordercomcate = (Ordercomcate) BOFactory.build(
					OrdercomcateBO.class, user);
			Order order = (Order) BOFactory.build(OrderBO.class, user);

			Date now = new Date();

			Double totalpriceAll = 0d;
			for (int i = 0; i < comorderList.size(); i++) {
				totalpriceAll = totalpriceAll
						+ comorderList.get(i).getTotalprice();

				OrdercomcateVO ordercomcateVO = new OrdercomcateVO();
				ordercomcateVO.setOrderid(orderid);
				ordercomcateVO.setOrdercomtype(ComorderConstant.COMORDER_TYPE);
				ordercomcateVO.setComcategory(comorderList.get(i)
						.getComcategory());
				ordercomcateVO
						.setOrderamt(comorderList.get(i).getOrderamount());
				ordercomcateVO.setUnitprice(comorderList.get(i).getUnitprice());
				ordercomcateVO.setTotalprice(comorderList.get(i)
						.getTotalprice());
				ordercomcateVO.setPlanCode(comorderList.get(i).getPlanCode());
				// ����������Ʒ����
				ordercomcate.doCreate(ordercomcateVO);
			}

			// b)����������Ϣ
			OrderVO orderVO = new OrderVO();
			orderVO.setFlowid(flowid);
			orderVO.setStorarea(storarea);
			orderVO.setOrderid(orderid);
			orderVO.setWayid(wayVO.getWayid());
			orderVO.setCountyid(wayVO.getCountyid());
			orderVO.setMareacode(wayVO.getMareacode());
			orderVO.setCooptype(wayVO.getCusttype());
			orderVO.setStarlevel(Short.valueOf(String.valueOf(wayVO
					.getStarlevel())));
			orderVO.setPaytype(wayVO.getPaytype());
			orderVO.setDelitype(wayVO.getDelitype());
			if(isurgent){
				orderave = "URGENT";
			}
			orderVO.setOrderave(orderave);
			orderVO.setOrderstate(outstate);
			orderVO.setCreatetime(now);
			orderVO.setStatechgtime(now);
			orderVO.setRecamt(totalpriceAll);
			orderVO.setActamt(ComorderConstant.ACTAMT_ZERO);
			orderVO.setDiscomcode(wayVO.getLogiscode());
			if(alarmlevel != null){
				orderVO.setAlarmlevel(alarmlevel);
			}
			// ��������
			order.doCreate(orderVO);

			// d)������������
			if (null != brandSet && brandSet.size() > 0) {
				Orderplan orderplan = (Orderplan) BOFactory.build(
						OrderplanBO.class, user);
				String monthStr = PublicUtils.formatUtilDate(new Date(),
						"yyyyMM");
				String brand = new String();
				for (Iterator it = brandSet.iterator(); it.hasNext();) {
					brand = (String) it.next();
					List<IncqttdtlVO> incqttdtlList = getIncqttdtlList(wayVO
							.getWayid(), brand, monthStr);
					for (int i = 0; i < incqttdtlList.size(); i++) {
						OrderplanVO orderplanVO = new OrderplanVO();
						orderplanVO.setOrderid(orderid);
						orderplanVO.setSaleplan(Long.valueOf(String
								.valueOf(incqttdtlList.get(i).getPid())));
						orderplanVO.setRuleid(Long.valueOf(String
								.valueOf(incqttdtlList.get(i).getRuleid())));
						orderplan.doCreate(orderplanVO);
					}
				}
			}

			Session session = SessionUtils.currentSession(user.getCityid());
			session.flush();

			
//			DataPackage dp3 = realtimeamt.doQuery(param3);
//			if (dp3.getRowCount() > 0) {
//				List<RealtimeamtVO> realtimeamtList = dp3.getDatas();
//				for (RealtimeamtVO realtimeamtVO : realtimeamtList) {
//					if (realtimeamtVO.getBrand().equals("AllBrand")) {
//						orderamt = ordercomcate
//								.doQueryOrderamtByAllBrand(orderid);
//					} else {
//						orderamt = ordercomcate.doQueryOrderamtByBrand(orderid,
//								realtimeamtVO.getBrand());
//					}
//					if (orderamt != null) {
//						if (null != realtimeamtVO.getMonordered()) {
//							realtimeamtVO.setMonordered(realtimeamtVO
//									.getMonordered()
//									+ orderamt);
//						}
//						if (null != realtimeamtVO.getDayordered()) {
//							realtimeamtVO.setDayordered(realtimeamtVO
//									.getDayordered()
//									+ orderamt);
//						}
//						if (null != realtimeamtVO.getNowstock()) {
//							realtimeamtVO.setNowstock(realtimeamtVO
//									.getNowstock()
//									+ orderamt);
//						}
//
//						realtimeamt.doUpdate(realtimeamtVO);
//					}
//				}
//			}
			Realtimeamt realtimeamt = (Realtimeamt) BOFactory.build(
					RealtimeamtBO.class, user);
			RealtimeamtDBParam param3 = new RealtimeamtDBParam();
			param3.set_se_wayid(wayVO.getWayid());
			Long orderamt = 0L;
			//��ȡ�׿�Ʒ�Ƽ���
			List<DictitemVO> brandlist = this.doGetBrandCollection(wayVO.getWayid());//��ѯ���е�
			for(DictitemVO vo : brandlist){
				String brand = vo.getDictid();
				if("AllBrand".equals(brand)){
					orderamt = ordercomcate.doQueryOrderamtByAllBrand(orderid);
				}else{
					orderamt = ordercomcate.doQueryOrderamtByBrand(orderid,brand);
				}
				param3.set_se_brand(brand);
				DataPackage dp3 = realtimeamt.doQuery(param3);
				RealtimeamtVO realtimeamtVO = new RealtimeamtVO();
				if(null!=dp3 && dp3.getRowCount()>0){
					realtimeamtVO = (RealtimeamtVO)dp3.getDatas().get(0);
					if (orderamt != null) {
						if (null != realtimeamtVO.getMonordered()) {
							realtimeamtVO.setMonordered(realtimeamtVO
									.getMonordered()
									+ orderamt);
						}else{
							realtimeamtVO.setMonordered(orderamt);//�״ζ���
						}
						if (null != realtimeamtVO.getDayordered()) {
							realtimeamtVO.setDayordered(realtimeamtVO
									.getDayordered()
									+ orderamt);
						}else{
							realtimeamtVO.setDayordered(orderamt);
						}
						if (null != realtimeamtVO.getNowstock()) {
							realtimeamtVO.setNowstock(realtimeamtVO
									.getNowstock()
									+ orderamt);
						}else{
							realtimeamtVO.setNowstock(orderamt);
						}
						realtimeamtVO.setUptime(new Date());
						realtimeamt.doUpdate(realtimeamtVO);
					}
				}else{
					realtimeamtVO.setWayid(wayVO.getWayid());
					realtimeamtVO.setBrand(brand);
					realtimeamtVO.setUptime(new Date());
					if(null!=orderamt){
						realtimeamtVO.setMonordered(orderamt);
						realtimeamtVO.setDayordered(orderamt);
						realtimeamtVO.setNowstock(orderamt);
					}else{
						realtimeamtVO.setMonordered(0L);
						realtimeamtVO.setDayordered(0L);
						realtimeamtVO.setNowstock(0L);
					}
					realtimeamt.doCreate(realtimeamtVO);
				}
			}
			
			//�հ�SIM��������ʵʱ��¼����
			DataPackage emptydp = ordercomcate.doquerySimamtByOrderID(orderid);
			List emptyList = emptydp.getDatas();
			if (emptyList != null && emptyList.size() > 0) {
				for (int i = 0; i < emptyList.size(); i++) {
					Map map = (Map) emptyList.get(i);
					String comcategory = map.get("comcategory").toString();
					long simamt = Long.parseLong(map.get("simamt").toString());
					
					Simrealtimeamt simrealtimeamt = (SimrealtimeamtBO)BOFactory.build(SimrealtimeamtBO.class,user);
					SimrealtimeamtDBParam simrealtimeamtDBParam = new SimrealtimeamtDBParam();
					simrealtimeamtDBParam.set_se_wayid(wayVO.getWayid());
					simrealtimeamtDBParam.set_se_comcategory(comcategory);
					DataPackage simrealtimedp = simrealtimeamt.doQuery(simrealtimeamtDBParam);
					if (simrealtimedp != null && simrealtimedp.getDatas() != null && simrealtimedp.getDatas().size() > 0) {
						SimrealtimeamtVO simrealtimeamtVO = (SimrealtimeamtVO) simrealtimedp.getDatas().get(0);
						simrealtimeamtVO.setDayordered(simrealtimeamtVO.getDayordered() + simamt);
						simrealtimeamtVO.setMonordered(simrealtimeamtVO.getMonordered() + simamt);
						simrealtimeamtVO.setNowstock(simrealtimeamtVO.getNowstock() + simamt);
						simrealtimeamtVO.setUptime(new Date(System.currentTimeMillis()));
						simrealtimeamt.doUpdate(simrealtimeamtVO);
					} else {
						SimrealtimeamtVO simrealtimeamtVO = new SimrealtimeamtVO();
						simrealtimeamtVO.setWayid(wayVO.getWayid());
						simrealtimeamtVO.setComcategory(comcategory);
						simrealtimeamtVO.setDayordered(simamt);
						simrealtimeamtVO.setMonordered(simamt);
						simrealtimeamtVO.setNowstock(simamt);
						simrealtimeamtVO.setUptime(new Date(System.currentTimeMillis()));
						simrealtimeamt.doCreate(simrealtimeamtVO);
					}
				}
			}
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	// ��ȡ�������
	public String doGetOrderId() throws Exception {
		try {
			Order order = (Order) BOFactory.build(OrderBO.class, user);
			Date now = new Date();
			return order.doGetOrderId(now);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	public void doNextProcess(String orderid) throws Exception {
		try {
			Order order = (Order) BOFactory.build(OrderBO.class, user);
			order.doNextProcess(orderid);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	// ��ȡ����������������
	public int getUnitageIndex() throws Exception {
		try {
			// ��ȡ���ڵ��������
			int dayIndex = this.getWeekIndex(new Date());
			int arrayIndex = -1;

			// �����ڵ��������תΪ����������������
			// ����
			if (dayIndex == 1) {
				arrayIndex = 6;
			}
			// ��һ������
			else {
				arrayIndex = dayIndex - 2;
			}
			return arrayIndex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	// ��ȡ���ڶ�Ӧ���������ڼ�����ţ���Ŷ�Ӧ��ϵΪ�����գ�1�� ��һ��2�� �ܶ���3�� ������4�� ���ģ�5�� ���壺6�� ������7
	private int getWeekIndex(Date date) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			int dayIndex = c.get(Calendar.DAY_OF_WEEK);
			return dayIndex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	// ��ȡ�����Ѷ�����
	public Long getMonordered(String wayid, String begintime, String endtime)
			throws Exception {
		try {
			Long monordered = new Long(-1);
			OrderDBParam param = new OrderDBParam();
			OrderresdetDBParam param2 = new OrderresdetDBParam();
			param.set_se_wayid(wayid);
			param.set_dnl_createtime(begintime);
			param.set_dnm_createtime(endtime);
			param.set_sne_orderstate("CANCEL");
			param2.set_se_restype("COMRESSMP");
			Object[] params = new Object[] { param, param2 };
			Class[] classvo = new Class[] { OrderVO.class, OrderresdetVO.class };
			String[][] joins = new String[][] { { "orderid", "orderid" } };
			OrderDAO dao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
			DataPackage dp = dao.unionQuery(params, classvo, joins);
			if (null != dp && dp.getDatas().size() != 0) {
				int monordered1 = dp.getRowCount();
				monordered = new Long(monordered1);
			} else {
				monordered = 0L;
			}
			return monordered;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}

	}

	// ��ȡ���������б�
	public List<CustwaytypeVO> doGetCustwaytypeList() throws Exception {
		try {
			Custwaytype custwaytype = (Custwaytype) BOFactory.build(
					CustwaytypeBO.class, user);
			CustwaytypeDBParam param = new CustwaytypeDBParam();
			param.set_ne_citycompid(user.getCityid());
			DataPackage dp = custwaytype.doQuery(param);
			return dp.getDatas();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	// ƥ�����������ȡ������
	public Integer getQuantity(String wayid, String prodid, String effectmonth)
			throws Exception {
		try {
			Incqttdtl incqttdtl = (Incqttdtl) BOFactory.build(
					IncqttdtlBO.class, user);
			IncqttdtlDBParam param = new IncqttdtlDBParam();
			param.set_se_wayid(wayid);
			param.set_se_prodid(prodid);
			param.set_se_effectmonth(effectmonth);
			DataPackage dp = incqttdtl.doQuery(param);
			Integer quantity = 0;
			if (null != dp && dp.getDatas().size() > 0) {
				for (Iterator it = dp.getDatas().iterator(); it.hasNext();) {
					IncqttdtlVO vo = (IncqttdtlVO) it.next();
					Integer quantitytemp = vo.getQuantity();
					quantity = quantity + quantitytemp;
				}
			}
			return quantity;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	// ƥ�����������ȡ������������ϸ
	public List<IncqttdtlVO> getIncqttdtlList(String wayid, String prodid,
			String effectmonth) throws Exception {
		try {
			Incqttdtl incqttdtl = (Incqttdtl) BOFactory.build(
					IncqttdtlBO.class, user);
			IncqttdtlDBParam param = new IncqttdtlDBParam();
			param.set_se_wayid(wayid);
			param.set_se_prodid(prodid);
			param.set_se_effectmonth(effectmonth);
			DataPackage dp = incqttdtl.doQuery(param);
			return dp.getDatas();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	// �������
	public Set<String> comOrderCheck(String wayid,
			List<ComorderVO> comorderList, String storarea) throws Exception {
		try {
			Way way = (Way) BOFactory.build(WayBO.class, user);
			WayVO wayvo = way.doFindByPk(wayid);
			
			//��ȡ�׿�Ʒ�Ƽ���
			Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class, user);
			List<DictitemVO> brandlist = comorder.doGetBrandList(wayvo.getWayid());
			
			//�¶����������
			comorder.checkMonthBookTimes(wayid);

			// �׿�������Ϣ����ģʽ
			String mode = comorder.doGetOrderMode();
			
			ComorderCheck comorderCheck = (ComorderCheck)BOFactory.build(ComorderCheckBO.class, user);
			
			// ���붩����鸨����Ϣ
			ComorderCheckHandle handle = comorderCheck.getHelpHandle(wayvo, brandlist, mode);

			// ��󣬶Զ�����Ʒ�����б������������
			for (ComorderVO comordervo : comorderList) {
				int i = START;
				ComcategoryrelaVO comcategoryrelavo = null;
				while(i != EXIT){
					switch(i){
						case 1: // 1) ��Ʒ���ඩ���������
							comorderCheck.checkComcategoryUnitageMod(comordervo.getComcategory(),comordervo.getOrderamount());
							i += NEXT;
							break;
						case 2: // 2) ��Ʒ���ඩ��״̬���
							comorderCheck.checkComcategoryState(comordervo.getComcategory());
							i += NEXT;
							break;
						case 3: // 3) ��Ʒ�����Ƿ��׿�
							comcategoryrelavo = comorderCheck.checkIsComressmp(comordervo.getComcategory());
							if (comcategoryrelavo != null && comcategoryrelavo.getRestype().equals("COMRESSMP")) {
								i += NEXT;
							}else if(comcategoryrelavo != null && comcategoryrelavo.getRestype().equals("EMPTYSIM")){
								i = 8;//������8�����հ�SIM���������޼��
							}else{
								i = 7;//������7������ֵ���������޼��
							}
							break;
						case 4: //�׿������ʼ�飨����Ʒ��/������Ʒ�ƣ�
							comorderCheck.checkActiverate(comorderCheck.getBrand(comordervo.getComcategory()), wayvo);
							i += NEXT;
							break;
						case 5: //��5��Ҫ�õ�������,�����Ȼ�ȡ������
							if(comorderCheck.checkBaseAmount(comorderCheck.getBrand(comordervo.getComcategory()), comordervo.getOrderamount(), storarea, wayvo)){
								i = EXIT;
							}else{
								i += NEXT;
							}
							break;
						case 6: // 6) ���¿ɶ�������� 7)  ��/�¶��������޼��  9) �ۼӶ�����  ���кϲ�
							comorderCheck.checkOrderedmonthAndLimitCheck(comorderCheck.getBrand(comordervo.getComcategory()), comordervo.getOrderamount(), wayvo, mode);
							i += NEXT;
							break;
						case 7: //  ��ֵ���������޼��
							comorderCheck.checkOrderedCardLimit(comordervo.getComcategory(), comcategoryrelavo.getRestype(), comordervo.getOrderamount(), wayvo, mode);
							i += NEXT;
							break;
						case 8: //  �հ�SIM���������޼��
							comorderCheck.checkOrderedEmptySimLimit(handle,comordervo.getComcategory(), comcategoryrelavo.getRestype(), comordervo.getOrderamount(), wayvo, mode);
							i += NEXT;
							break;
						case 9: //  ��׼������޼��
							comorderCheck.checkOrderedNowstock(comorderCheck.getBrand(comordervo.getComcategory()),comcategoryrelavo.getRestype(), comordervo.getOrderamount(), wayvo, mode);
							i += NEXT;
							break;
						case 10: //  Ԥ�������
							comorderCheck.checkOrderedStockalarm(comorderCheck.getBrand(comordervo.getComcategory()),comcategoryrelavo.getRestype(), comordervo.getOrderamount(), wayvo, mode);
							i += NEXT;
							break;
						case 11: //  �����������
							comorderCheck.checkLimit(comordervo.getComcategory(), comordervo.getOrderamount(), wayvo);
							i += NEXT;
							break;
						case 12: //  ��Դ�����
							comorderCheck.checkResStock(comordervo.getComcategory(), comordervo.getOrderamount(), wayvo);
							i = EXIT;
							break;
					}
				}
			}
			return handle.getBrandSet();
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}

	}
	
	/**
	 * �¶����������
	 */
	public void checkMonthBookTimes(String wayid) throws Exception {
		try {
			Ordertimes otBO = (Ordertimes) BOFactory.build(OrdertimesBO.class,
					user);
			OrdertimesDBParam param = new OrdertimesDBParam();
			param.set_se_objtype("APPWAY");
			param.set_se_objectcode(wayid);
			
			if(isurgent){
				param.set_ne_isurgent("1");
			}
			else{
				param.set_ne_isurgent("0");
			}
			
			DataPackage dp = otBO.doQuery(param);
			List list = dp.getDatas();
			short maxtimes = 0;
			if (list != null && list.size() > 0) {
				OrdertimesVO vo = (OrdertimesVO) list.get(0);
				maxtimes = vo.getMaxtimes();
			} else {
				//��������������Լ�����ͣ�ָ���Ǽ�����Լ�������Ǽ������Ƿ������Ĭ��Ϊ��0������������ʱΪ1����ѯ��������Լ����
				Way wayBO = (Way) BOFactory.build(WayBO.class, user);
				WayVO wayvo = wayBO.doFindByPk(wayid);
				Long starlevel = wayvo.getStarlevel();
				if(starlevel == null || "".equals(starlevel.toString().trim())) {
					throw new SaleException("������"+wayid+" �� starlevel �ֶ�Ϊ��");
				}
				param.set_se_objtype("APPSTAR");
				param.set_se_objectcode(starlevel.toString());//���������Ǽ��ֶζ���Ϊ��,����Ϊ�յ�����,�����й�˾ͳ�Ʋ���֮
				if(isurgent){
					param.set_ne_isurgent("1");
				}
				else{
					param.set_ne_isurgent("0");
				}
				DataPackage dp2 = otBO.doQuery(param);
				List list2 = dp2.getDatas();
				if (list2 != null && list2.size() > 0) {
					OrdertimesVO vo = (OrdertimesVO) list2.get(0);
					maxtimes = vo.getMaxtimes();
				} else {
					// �����������ͨ�����
					return;
				}
			}
			Order orderBO = (Order) BOFactory.build(OrderBO.class, user);
			Calendar now = Calendar.getInstance();
			int year = now.get(Calendar.YEAR);
			int month = now.get(Calendar.MONTH) + 1;
			String firstDay = PublicUtils.getMonthBegin(year, month);
			OrderDBParam orderParam = new OrderDBParam();
			orderParam.set_se_wayid(wayid);
			orderParam.set_sne_orderstate("CANCEL");
			orderParam.set_dnl_createtime(firstDay);
			orderParam.setCountOnly(true);
			DataPackage orderDp = orderBO.doQuery(orderParam);
			
			if (orderDp.getRowCount() >= maxtimes) {
				SaleException se = new SaleException("SALE-104014", ""+maxtimes);
				se.setMonmaxtimes(new Long(maxtimes));
				se.setMontimes(new Long(orderDp.getRowCount()));
				throw se;
			}
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}
	
	//����ϵͳ������[pboss_fx,63]������Ƿ���������϶���
	//1-��������϶�����0-������
	public boolean isMixOrderEnabled() throws Exception {
		try{
			Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,user);
			String paramvalue = sysparam.doFindByID("63", "pboss_fx");
			boolean enable = true;
			if(paramvalue!=null && !"".equals(paramvalue)){
				if("0".equals(paramvalue)){
					enable=false;
				}
			}
			return enable;
		}catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	public List<OrderMonthdayStockVO> doGetOrderInfoByMonthdayStock(
			WayVO wayvo, List<DictitemVO> brandlist, List<ActiverateVO> activerateList) throws Exception {
		List<OrderMonthdayStockVO> orderMonthdayStockList = new ArrayList<OrderMonthdayStockVO>();
		
		//���¶�����ģʽ����
		List<OrderMonthdayVO> orderMonthdayList = this.doGetOrderInfoByMonthDay(wayvo, brandlist);
		if(orderMonthdayList != null && !"".equals(orderMonthdayList) && orderMonthdayList.size() > 0){
			for(int i=0; i<orderMonthdayList.size(); i++){
				OrderMonthdayVO omdVO = orderMonthdayList.get(i);
				OrderMonthdayStockVO omdsVO = new OrderMonthdayStockVO();
				
				com.sunrise.jop.common.utils.bean.BeanUtils.copyProperties(omdsVO, omdVO);
				
				orderMonthdayStockList.add(omdsVO);
			}
		}
		
		//��׼���ģʽ����
		List<OrderStdstockVO> orderStdstockList = this.doGetOrderInfoByStdstock(wayvo, brandlist,activerateList);
		
		//�������ϣ������¶���������Ϊ��������������ݰ�Ʒ�ƽ�����䣬
		//��󶩹����ο�ֵȡ����ǰ��󶩹�������������ʣ��������������ʣ��������������Сֵ��
		if(orderMonthdayStockList != null && !"".equals(orderMonthdayStockList) && orderMonthdayStockList.size() > 0){
			for(int i=0; i<orderMonthdayStockList.size(); i++){
				OrderMonthdayStockVO omdsVO = (OrderMonthdayStockVO)orderMonthdayStockList.get(i);
				
				if(orderStdstockList != null && !"".equals(orderStdstockList) && orderStdstockList.size() > 0){
					for(int j=0; j<orderStdstockList.size(); j++){
						OrderStdstockVO osVO = orderStdstockList.get(j);
						if(omdsVO.getBrand() != null && omdsVO.getBrand().equals(osVO.getBrand())){
							omdsVO.setStdstock(osVO.getStdstock());
							omdsVO.setNowstock(osVO.getNowstock());
							omdsVO.setOrderMax(osVO.getOrderMax());
							
							//��󶩹����ο�
							if(omdsVO.getOrderRemainMonth() < omdsVO.getOrderRemainDay()){
								if(omdsVO.getOrderMax() < omdsVO.getOrderRemainMonth()){
									omdsVO.setReferData(omdsVO.getOrderMax());
								}else{
									omdsVO.setReferData(omdsVO.getOrderRemainMonth());
								}
							}else{
								if(omdsVO.getOrderMax() < omdsVO.getOrderRemainDay()){
									omdsVO.setReferData(omdsVO.getOrderMax());
								}else{
									omdsVO.setReferData(omdsVO.getOrderRemainDay());
								}
							}
						}
					}				
				}
			}
		}
		
		return orderMonthdayStockList;
	}

	public Double doGetUnitprice(String wayid, String comcategory,
			String planCode) throws Exception {
		//��ȡ��Ʒ��ֵ
		double parValue = 0;//��Ʒ��ֵ
		Comcatebrand comcatebrand = (Comcatebrand) BOFactory.build(ComcatebrandBO.class,
				user);
		ComcatebrandDBParam comcatebrandDBParam = new ComcatebrandDBParam();
		comcatebrandDBParam.set_se_comcategory(comcategory);
		DataPackage comcatebrandDP = comcatebrand.doQuery(comcatebrandDBParam);
		if (null != comcatebrandDP && null != comcatebrandDP.getDatas() 
				&& comcatebrandDP.getDatas().size() > 0) {
			ComcatebrandVO comcatebrandVO = (ComcatebrandVO)comcatebrandDP.getDatas().get(0);
			if(null == comcatebrandVO.getParValue()){
				throw new SaleException("��Ʒ����["+Code2NameUtils.code2Name(
						"$IM_FXCOMCATEGORY", comcategory, user.getCityid())+"]��ֵδ����");
				
			}else{
				parValue = comcatebrandVO.getParValue();
			}
		}else{
			throw new SaleException("��Ʒ����["+Code2NameUtils.code2Name(
					"$IM_FXCOMCATEGORY", comcategory, user.getCityid())+"]��ֵδ����");
			
		}
		
		//��ȡ�Żݼ���
		double preValue = 0;//�Żݽ��
		if(planCode != null && !"".equals(planCode)){
			SaleplanVO saleplanVO = new SaleplanVO();
			Saleplan saleplanBO = (SaleplanBO)BOFactory.build(SaleplanBO.class,user);
			SaleplanDBParam saleplanDBParam = new SaleplanDBParam();
			saleplanDBParam.set_se_cityid(user.getCityid());//���б�ʶ������Ա�������У�
			saleplanDBParam.set_se_plancode(planCode);//�Żݷ�������
			DataPackage saleplanDP = saleplanBO.doQuery(saleplanDBParam);
			if (null != saleplanDP && null != saleplanDP.getDatas()) {
				List<SaleplanVO> list = saleplanDP.getDatas();
				if(list.size() > 0){
					saleplanVO = list.get(0);
					if("SINGLEDERATE".equals(saleplanVO.getPremode())){
						if(null != saleplanVO.getPrevalue()){
							preValue = saleplanVO.getPrevalue();
						}
					}
				}
			}
		}
		double unitprice = parValue - preValue;//��Ʒ��ֵ-�Żݼ���
		if(unitprice<=0){
			throw new SaleException("��Ʒ����["+Code2NameUtils.code2Name(
					"$IM_FXCOMCATEGORY", comcategory, user.getCityid())+"]�ۼ۴���������ֵ���Żݷ���");
			
		}
				
		return unitprice;
	}

	public Map<String,String> getSalePlanMap(String comcategory) throws Exception {
		Map<String,String> tmpMap = new LinkedHashMap<String,String>();
		//��ȡ�Żݷ���
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = sdf.format(date);
		Saleplan saleplanBO = (SaleplanBO)BOFactory.build(SaleplanBO.class,user);
		SaleplanDBParam saleplanDBParam = new SaleplanDBParam();
		String comcategoryPara = "%" + comcategory + "%";
		saleplanDBParam.getQueryConditions().put("cityid", user.getCityid());
		saleplanDBParam.getQueryConditions().put("beginDate", dateString);
		saleplanDBParam.getQueryConditions().put("endDate", dateString);
		saleplanDBParam.getQueryConditions().put("comcategory", comcategoryPara);
		
		DataPackage saleplanDP = saleplanBO.doQueryByName("com.gmcc.pboss.business.sales.saleplan.doQuerySalePlan",saleplanDBParam);
		if (null != saleplanDP && null != saleplanDP.getDatas()) {
			List<SaleplanVO> list = saleplanDP.getDatas();
			
			for (SaleplanVO vo : list) {
				tmpMap.put(vo.getPlancode(), vo.getPlanname());				
			}
		}
		
		return tmpMap;
	}
	/**
	 * ��ÿհ�sim��Ϣ
	 */
	public List<OrderEmptyCardVO> getEmptySimInfo(WayVO way) throws Exception {
		List<OrderEmptyCardVO> list = new ArrayList<OrderEmptyCardVO>();
		/*
		 * 1����ȡ��߿���Ԥ����ֵ��
		 * ����1�����ݺ����̱����ѯ�հ�SIM��������Ԥ�����ñ�(FX_RU_SIMSTOCKALARM)��
		 * �������������ȡ��Ӧ����߿���Ԥ����ֵ���ݣ�����¼�´��ڵĶ�ӦԤ�����ϣ�
		 * �������ݽ����е�2����ѯ������������2����ѯ��
		 */
		Simstockalarm simstockalarm = (SimstockalarmBO)BOFactory.build(SimstockalarmBO.class,user);
		SimstockalarmDBParam simstockalarmDBParam = new SimstockalarmDBParam();
		simstockalarmDBParam.set_se_wayid(way.getWayid());
		DataPackage dp = simstockalarm.doQuery(simstockalarmDBParam);
		
		// 2����ȡ���������������Ѷ��������ݺ����̱����ѯ�հ�SIM��������ʵʱ��¼��FX_SW_SIMREALTIMEAMT������ȡ��Ʒ���ࡢ���������������Ѷ������ݡ�
		Simrealtimeamt simrealtimeamt = (SimrealtimeamtBO)BOFactory.build(SimrealtimeamtBO.class, user);
		SimrealtimeamtDBParam simrealtimeamtDBParam = new SimrealtimeamtDBParam();
		simrealtimeamtDBParam.set_se_wayid(way.getWayid());
		DataPackage simrealtimedp = simrealtimeamt.doQuery(simrealtimeamtDBParam);
		
		/* 
		 * 3����ȡ��ʹ���������ݺ����̱����ѯ��������Դ��(FX_SW_PARTNERRES)��
		 * ������Դ���(RESTYPE)Ϊ�հ�SIM��(EMPTYSIM)���Ƿ񼤻�(ISACTIVE)Ϊ��(1)ͳ�ƺ����̵ĸ��ֿհ�SIM��ʹ����
		 */
		Partnerres partnerres = (PartnerresBO)BOFactory.build(PartnerresBO.class, user);
		DataPackage useCountdp = partnerres.doEmptySimUseCount(way.getWayid());
		
		// 4����ȡ�������������ݺ����̱����ѯ�հ�SIM������¼��� (IM_FX_EMPTYSIMBAD)��ͳ�ƺ����̵ĸ��ֿհ�SIM����������
		Emptysimbad emptysimbad = (Emptysimbad) BOFactory.build(EmptysimbadBO.class, user);
		DataPackage badCountdp = emptysimbad.doEmptySimBadCount(way.getWayid());
		
		OrderEmptyCardVO orderEmptyCardVO = null;
		if (dp.getDatas() == null || dp.getDatas().size() == 0) {
			/*
			 * Ȼ��2�����ݵ��б�ʶ���ֹ�˾�����ع�˾��ʶCOUNTYID�����Ǽ���Լ��ģʽ��Ĭ��ȡԤ�����ģʽ������Դ���Ĭ�Ͽհ�SIM����
			 * ��ѯ�������������ñ�FX_RU_ORDERUPLIMIT������ȡ��߿�桢Ԥ����ֵ��
			 */
			Orderuplimit orderuplimit = (OrderuplimitBO)BOFactory.build(OrderuplimitBO.class,user);
			OrderuplimitDBParam orderuplimitDBParam = new OrderuplimitDBParam();
			orderuplimitDBParam.set_se_cityid(way.getCityid());
			orderuplimitDBParam.set_se_countyid(way.getCountyid());
			orderuplimitDBParam.set_ne_starlevel(way.getStarlevel() + "");
			orderuplimitDBParam.set_se_limitmode("STOCKALARM");
			orderuplimitDBParam.set_se_restype("EMPTYSIM");
			DataPackage orderuplimitdp = orderuplimit.doQuery(orderuplimitDBParam);
			
			if (orderuplimitdp != null && orderuplimitdp.getDatas() != null && orderuplimitdp.getDatas().size() > 0) {
				for (int i = 0; i < orderuplimitdp.getDatas().size(); i++) {
					String comcategory = ""; // ��Ʒ����
					long curmaxstock = 0; // ��ǰ��󶩹���
					long maxstock = 0; // ��߿��
					long curstock = 0; // ��������
					long usecount = 0; // ��ʹ����
					long badcount = 0; // ��������
					long orderedMonth = 0; // �����Ѷ���
					
					OrderuplimitVO orderuplimitVO = (OrderuplimitVO) orderuplimitdp.getDatas().get(i);
					orderEmptyCardVO = new OrderEmptyCardVO();
					
					comcategory = orderuplimitVO.getComcategory(); // ��Ʒ����
					maxstock = orderuplimitVO.getMaxstock(); // ��߿��
					String alarmvalue = null; // Ԥ����ֵ
					if(orderuplimitVO.getAlarmvalue() != null){
						alarmvalue = this.doInterpretAlarmValue(orderuplimitVO.getAlarmvalue());
					}
					
					for (int j = 0; j < simrealtimedp.getDatas().size(); j++) {
						SimrealtimeamtVO simrealtimeamtVO = (SimrealtimeamtVO) simrealtimedp.getDatas().get(i);
						if (comcategory.equals(simrealtimeamtVO.getComcategory())) {
							curstock = simrealtimeamtVO.getNowstock(); // ��������
							orderedMonth = simrealtimeamtVO.getMonordered(); // �����Ѷ���
							break;
						}
					}
					
					for (int j = 0; j < useCountdp.getDatas().size(); j++) {
						Map map = (Map) useCountdp.getDatas().get(i);
						if (comcategory.equals(map.get("comcategory"))) {
							usecount = Long.parseLong(map.get("count").toString()); // ��ʹ����
							break;
						}
					}
					
					for (int j = 0; j < badCountdp.getDatas().size(); j++) {
						Map map = (Map) badCountdp.getDatas().get(i);
						if (comcategory.equals(map.get("comcategory"))) {
							badcount = Long.parseLong(map.get("count").toString()); // ��������
							break;
						}
					}
					
					curmaxstock = maxstock - curstock + usecount + badcount;
					curmaxstock = curmaxstock < 0 ? 0 : curmaxstock;
					orderEmptyCardVO.setRestype(comcategory); // ��Ʒ����
					orderEmptyCardVO.setCurmaxstock(curmaxstock + ""); // ��ǰ��󶩹���
					orderEmptyCardVO.setMaxstock(maxstock + ""); // ��߿��
					orderEmptyCardVO.setCurstock(curstock + ""); // ��������
					orderEmptyCardVO.setUsecount(usecount + ""); // ��ʹ����
					orderEmptyCardVO.setBadcount(badcount + ""); // ��������
					orderEmptyCardVO.setOrderedMonth(orderedMonth + ""); // �����Ѷ���
					orderEmptyCardVO.setAlarmvalue(alarmvalue); // Ԥ����ֵ
					
					list.add(orderEmptyCardVO);
				}
			}
		} else {
			SimstockalarmVO simstockalarmvo = null;
			for (int i = 0; i < dp.getDatas().size(); i++) {
				String comcategory = ""; // ��Ʒ����
				long curmaxstock = 0; // ��ǰ��󶩹���
				long maxstock = 0; // ��߿��
				long curstock = 0; // ��������
				long usecount = 0; // ��ʹ����
				long badcount = 0; // ��������
				long orderedMonth = 0; // �����Ѷ���
				
				simstockalarmvo = (SimstockalarmVO)dp.getDatas().get(i);
				orderEmptyCardVO = new OrderEmptyCardVO();
				
				comcategory = simstockalarmvo.getComcategory(); // ��Ʒ����
				maxstock = simstockalarmvo.getMaxstock(); // ��߿��
				
				for (int j = 0; j < simrealtimedp.getDatas().size(); j++) {
					SimrealtimeamtVO simrealtimeamtVO = (SimrealtimeamtVO) simrealtimedp.getDatas().get(i);
					if (comcategory.equals(simrealtimeamtVO.getComcategory())) {
						curstock = simrealtimeamtVO.getNowstock(); // ��������
						orderedMonth = simrealtimeamtVO.getMonordered(); // �����Ѷ���
						break;
					}
				}
				
				for (int j = 0; j < useCountdp.getDatas().size(); j++) {
					Map map = (Map) useCountdp.getDatas().get(i);
					if (comcategory.equals(map.get("comcategory"))) {
						usecount = Long.parseLong(map.get("count").toString()); // ��ʹ����
						break;
					}
				}
				
				for (int j = 0; j < badCountdp.getDatas().size(); j++) {
					Map map = (Map) badCountdp.getDatas().get(i);
					if (comcategory.equals(map.get("comcategory"))) {
						badcount = Long.parseLong(map.get("count").toString()); // ��������
						break;
					}
				}
				
				curmaxstock = maxstock - curstock + usecount + badcount;
				curmaxstock = curmaxstock < 0 ? 0 : curmaxstock;
				orderEmptyCardVO.setRestype(comcategory); // ��Ʒ����
				orderEmptyCardVO.setCurmaxstock(curmaxstock + ""); // ��ǰ��󶩹���
				orderEmptyCardVO.setMaxstock(maxstock + ""); // ��߿��
				orderEmptyCardVO.setCurstock(curstock + ""); // ��������
				orderEmptyCardVO.setUsecount(usecount + ""); // ��ʹ����
				orderEmptyCardVO.setBadcount(badcount + ""); // ��������
				orderEmptyCardVO.setOrderedMonth(orderedMonth + ""); // �����Ѷ���
				orderEmptyCardVO.setAlarmvalue(this.doInterpretAlarmValue(simstockalarmvo.getAlarmvalue())); // Ԥ����ֵ
				
				list.add(orderEmptyCardVO);
			}
		}
		return list;
	}
	
	//����Ԥ����Ϣ
	public String doInterpretAlarmValue(String alarmvalue) throws Exception{
		
		DictitemDBParam dictitemwebparam = new DictitemDBParam();
		dictitemwebparam.set_se_groupid("FX_STOCKALARMLEVEL");
		DictitemBO dictitembo = (DictitemBO) BOFactory.build(DictitemBO.class, user);
		List<DictitemVO> dictitemformlist = (ArrayList) (dictitembo.doQuery(dictitemwebparam).getDatas());
		if(dictitemformlist != null){
			for(Iterator<DictitemVO> it = dictitemformlist.iterator();it.hasNext();){
				 DictitemVO dictitemvo = it.next();
				 alarmvalue = alarmvalue.replaceAll(dictitemvo.getDictid(), dictitemvo.getDictname());
			}
		}
		return alarmvalue;
	}

	
	/**
	 * �׿�������Ϣ������Ԥ��������ģʽ��
	 */
	public List<OrderMonthdayStockalarm> doGetOrderMonthdayStockalarm(
			List<OrderMonthdayVO> orderMonthdayList,
			List<OrderStockalarmVO> orderStockalarmList) throws Exception {
		List<OrderMonthdayStockalarm> orderMonthdayStockalarmList = new ArrayList<OrderMonthdayStockalarm>();
		
		for(Iterator<OrderStockalarmVO> it = orderStockalarmList.iterator();it.hasNext();){
			OrderMonthdayStockalarm orderMonthdayStockalarm = new OrderMonthdayStockalarm();			
			OrderStockalarmVO orderStockalarmVO = it.next();
			orderMonthdayStockalarm.setOrderMax(orderStockalarmVO.getOrderMax());
			orderMonthdayStockalarm.setAlarmValue(orderStockalarmVO.getAlarmValue());
			orderMonthdayStockalarm.setMaxStock(orderStockalarmVO.getMaxStock());
			orderMonthdayStockalarm.setNowstock(orderStockalarmVO.getNowstock());
			orderMonthdayStockalarm.setBrandsName(orderStockalarmVO.getBrandsName());
			
			String brand = orderStockalarmVO.getBrand();
			//��Ʒ�ƽ����Ƿ���Ʒ���ж�
			int index = brand.indexOf(",");
			if(index <= 0){//���ǹ���Ʒ��
				for(Iterator<OrderMonthdayVO> itmonthday = orderMonthdayList.iterator();itmonthday.hasNext();){
					OrderMonthdayVO orderMonthdayVO = itmonthday.next();
					if(orderMonthdayVO.getBrand().equals(brand)){
						orderMonthdayStockalarm.setOrderedDay(orderMonthdayVO.getOrderedDay());
						orderMonthdayStockalarm.setOrderedMonth(orderMonthdayVO.getOrderedMonth());
						orderMonthdayStockalarm.setOrderMaxDay(orderMonthdayVO.getOrderMaxDay());
						orderMonthdayStockalarm.setOrderMaxMonth(orderMonthdayVO.getOrderMaxMonth());
						orderMonthdayStockalarm.setOrderRemainDay(orderMonthdayVO.getOrderRemainDay());
						orderMonthdayStockalarm.setOrderRemainMonth(orderMonthdayVO.getOrderRemainMonth());
					}
				}				
			}else{//�ǹ���Ʒ��
				 	String brandstr [] = brand.split(",");
				 	Long dayOrdered=0L;
					Long dayMax=0L;
					Long monthOrdered=0L;
					Long monthMax=0L;
					for(int i = 0 ; i < brandstr.length; i++){
						String obrand = brandstr[i];
						for(Iterator<OrderMonthdayVO> itmonthday = orderMonthdayList.iterator();itmonthday.hasNext();){
							OrderMonthdayVO orderMonthdayVO = itmonthday.next();
							if(obrand.equals(orderMonthdayVO.getBrand())){
								dayOrdered += orderMonthdayVO.getOrderedDay();
								dayMax += orderMonthdayVO.getOrderMaxDay();
								monthOrdered += orderMonthdayVO.getOrderedMonth();
								monthMax += orderMonthdayVO.getOrderMaxMonth();	
							}
						}		
					}
					orderMonthdayStockalarm.setOrderedDay(dayOrdered);
					orderMonthdayStockalarm.setOrderMaxDay(dayMax);
					
					orderMonthdayStockalarm.setOrderedMonth(monthOrdered);
					orderMonthdayStockalarm.setOrderMaxMonth(monthMax);
					Long dayRemain = orderMonthdayStockalarm.getOrderMaxDay()-orderMonthdayStockalarm.getOrderedDay();
					Long monthRemain = orderMonthdayStockalarm.getOrderMaxMonth()-orderMonthdayStockalarm.getOrderedMonth();
					
					orderMonthdayStockalarm.setOrderRemainDay(dayRemain);
					orderMonthdayStockalarm.setOrderRemainMonth(monthRemain);
			}
//			���Ԥ����ǰ��󶩹��������ն�����ʱ����ǰ��󶩹���ȡ�ն�����������ȡ��Ԥ����ǰ��󶩹���
//			����Ԥ�����ģʽ����󶩹��� Ҫȡ Ԥ����ǰ��󶩹������յ�ǰ��󶩹������µ�ǰ��󶩹������������ߵ���Сֵ 
			if(orderMonthdayStockalarm.getOrderMax()!= null && orderMonthdayStockalarm.getOrderRemainDay() != null && orderMonthdayStockalarm.getOrderMax()>orderMonthdayStockalarm.getOrderRemainDay()){
				orderMonthdayStockalarm.setOrderMax(orderMonthdayStockalarm.getOrderRemainDay());
			}
			if(orderMonthdayStockalarm.getOrderMax()!= null && orderMonthdayStockalarm.getOrderRemainMonth() != null && orderMonthdayStockalarm.getOrderMax()>orderMonthdayStockalarm.getOrderRemainMonth()){
				orderMonthdayStockalarm.setOrderMax(orderMonthdayStockalarm.getOrderRemainMonth());
			}
			orderMonthdayStockalarmList.add(orderMonthdayStockalarm);
		}
		return orderMonthdayStockalarmList;
	}
	
}
