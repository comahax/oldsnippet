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
	public static final int EXIT = -1; // 退出
	public static final int START = 1; // 开始
	public static final int NEXT = 1; // 下一步

	public static boolean isurgent=false;
	// 检查供应商信息，返回值为数组，包含渠道VO和合作商辅助信息VO
	public WayVO doCheckWay(String wayid) throws Exception {
		try {
			// 基本资料检查
			Way way = (Way) BOFactory.build(WayBO.class, user);
			WayDBParam param = new WayDBParam();
			param.set_se_wayid(wayid);
			param.set_se_cityid(user.getCityid());
			param.set_se_waytype("AG");
			param.set_ne_waystate("1");
			DataPackage dp = way.doQuery(param);
			if (dp == null || dp.getDatas().size() == 0) {
				throw new SaleException("SALE-103001");
				// throw new WebSiteException("合作商不存在!",RetResult.FAILURE);
			}

			// 订购资格检查
			Wayassistant wayassistant = (Wayassistant) BOFactory.build(
					WayassistantBO.class, user);
			WayassistantVO wayassistantVO = wayassistant.doFindByPk(wayid);
			if (null == wayassistantVO) {
				throw new SaleException("SALE-103002");
				// throw new
				// WebSiteException("该合作商订购辅助信息不存在!",RetResult.FAILURE);
			}

			Short canorder = wayassistantVO.getCanorder();
			if (null != canorder
					&& String.valueOf(canorder).equals(
							ComorderConstant.ORDER_CANNT)) {
				throw new SaleException("SALE-104002");
				// throw new
				// WebSiteException("该合作商不能发起商品订购，请检查商品订购辅助信息!",RetResult.FAILURE);
			}

			// 账号信息检查
			String paytype = wayassistantVO.getPaytype();
			if (paytype.equals(ComorderConstant.PAYTYPE_BANK)) {
				Wayaccount wayaccount = (Wayaccount) BOFactory.build(
						WayaccountBO.class, user);
				WayaccountDBParam param3 = new WayaccountDBParam();
				param3.set_se_wayid(wayid);
				DataPackage dp3 = wayaccount.doQuery(param3);
				// 判断账号数据是否存在
				if (null == dp3 || dp3.getDatas().size() == 0) {
					throw new SaleException("SALE-104001");
					// throw new
					// WebSiteException("该合作商银行账号信息不完整!",RetResult.FAILURE);
				}

				WayaccountVO wayaccountVO = (WayaccountVO) dp3.getDatas()
						.get(0);
				String acctno = wayaccountVO.getDeacctno();
				String acctname = wayaccountVO.getDeacctname();
				String bankname = wayaccountVO.getDebankname();
				// 判断账号数据是否完整
				if (null == acctno || acctno.equals("") || null == acctname
						|| acctname.equals("") || null == bankname
						|| bankname.equals("")) {
					throw new SaleException("SALE-104001");
					// throw new
					// WebSiteException("该合作商银行账号信息不完整!",RetResult.FAILURE);
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

	// 获取套卡品牌集合
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
	// 获取所有套卡品牌集合（包括AllBrand）
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

	// 获取套卡激活率信息
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

	//判断套卡订购信息采用日/月限制、基准库存限制或者预警库存的模式，"MONDAYLIMIT"则采用日/月限制，"STDSTOCK"则采用基准库存限制，"STOCKALARM"则采用预警库存
	public String doGetOrderMode() throws Exception {
		try {
			// 获取日/月订购量上限开关信息
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

	// 获取日/月订购量信息
	public List<OrderMonthdayVO> doGetOrderInfoByMonthDay(WayVO wayVO,
			List<DictitemVO> brandlist) throws Exception {
		try {
			List<OrderMonthdayVO> orderMonthdayList = new ArrayList<OrderMonthdayVO>();
			List<OrderuplimitVO> orderuplimitDealList = new ArrayList<OrderuplimitVO>();
			List<MonorderinfoVO> monorderinforDealList = new ArrayList<MonorderinfoVO>();
			List<RealtimeamtVO> realtimeamtDealList = new ArrayList<RealtimeamtVO>();
			

			//1、获取日/月订购量上限数据
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
			param.set_se_restype("COMRESSMP");//默认套卡
			
			//添加合作类型条件
			List<String> _sin_cooptype = new ArrayList<String>();
			_sin_cooptype.add(ComorderConstant.COOPTYPE_ALL);
			if(!StringUtils.isEmpty(custtype)){
				_sin_cooptype.add(custtype);
			}
			param.set_sin_cooptype(_sin_cooptype);
			
			//获取查询列表
			DataPackage dp = orderuplimit.doQuery(param);
			if(dp.getRowCount() == 0){
				throw new SaleException("SALE-103008");
			}
			List<OrderuplimitVO> orderuplimitList = dp.getDatas();
			
			//获取日/月订购量上限列表
			String brand = "";
			String brand2 = "";
			Boolean hasBrand = false;
			Boolean hasCooptype = false;
			
			//存在特定合作类型，则过滤掉合作类型为ALL的数据
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
			//存在则过滤，过滤后结果放入orderuplimitTempList
			if(hasCooptype)
			{
				for(int i=0; i<orderuplimitList.size(); i++)
				{
					//过滤合作类型为ALL的记录
					cooptype = orderuplimitList.get(i).getCooptype();
					if(null!=cooptype && !cooptype.equals(ComorderConstant.COOPTYPE_ALL))
					{
						String brandTemp = orderuplimitList.get(i).getBrand();
						//过滤具有相同品牌的重复数据
						if(!brandSet.contains(brandTemp))
						{
							brandSet.add(brandTemp);
							orderuplimitTempList.add(orderuplimitList.get(i));
						}
					}
				}
			}
			//不存在则取全部
			else
			{
				for(int i=0; i<orderuplimitList.size(); i++)
				{
					String brandTemp = orderuplimitList.get(i).getBrand();
					//过滤具有相同品牌的重复数据
					if(!brandSet.contains(brandTemp))
					{
						brandSet.add(brandTemp);
						orderuplimitTempList.add(orderuplimitList.get(i));
					}
				}
			}
			
			//未找到对应的品牌，则品牌日/月订购量上限为0，根据品牌集合从orderuplimitTempList再次过滤，放入orderuplimitDealList
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

			// 获取当月可订购量
			Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,
					user);
			DataPackage dp2 = new DataPackage();
			String paramvalue = sysparam.doFindByID(
					ComorderConstant.SYSTEMID_ORDER_MONTH,
					ComorderConstant.PARAMTYPE_FX);
			// 如果系统参数里存在月订购量浮动开关参数，则处理，否则提示出错信息
			
			List<MonorderinfoVO> monorderinforList = new ArrayList<MonorderinfoVO>();
			if (StringUtils.isEmpty(paramvalue)) {
				throw new SaleException("SALE-101002");
				// throw new
				// WebSiteException("系统参数无月订购量浮动开关状态数据，请检查",RetResult.FAILURE);
			} else {
				// 月订购量浮动开关打开，则获取月订购量信息，否则，则不进行处理
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
						//未找到对应的品牌，则品牌月可订购量信息为0，添加进月可订购量信息列表
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

			// 获取实时订购量
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
					//这里FX_SW_REALTIMEAMT设置了双主键，同一渠道不会出现重复品牌数据，不用过滤
					brand2 = realtimeamtList.get(j).getBrand();
					if(null!=brand && null!=brand2 && brand.equals(brand2))
					{
						realtimeamtDealList.add(realtimeamtList.get(j));
						hasBrand = true;
						break;
					}
				}
				//未找到对应的品牌，则品牌月可订购量信息为0，添加进月可订购量信息列表
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

			// 月订购上限
			Long amtMonlimit = null;
			// 月可订购量
			Long amtMonCan = null;
			// 月最大订购量
			Long amtMonMax = null;
			// 月已订购量
			Long amtMonOrdered = null;
			// 日最大订购量
			Long amtDayMax = null;
			// 日已订购量
			Long amtDayOrdered = null;

			for (int i = 0; i < orderuplimitDealList.size(); i++) {
				// 重置
				amtMonlimit = null;
				amtMonCan = null;
				amtMonMax = null;
				amtMonOrdered = null;
				amtDayMax = null;
				amtDayOrdered = null;
				amtMonCan = null;
				
				OrderMonthdayVO orderMonthdayVO = new OrderMonthdayVO();
				brand = orderuplimitDealList.get(i).getBrand();

				// 设置月最大订购量
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

				// 设置当月最大订购量，取月订购量上限和当月可订购量两者中较小值，如果当月可订购量不存在，则取月订购量上限
				if (null == amtMonCan) {
					amtMonMax = amtMonlimit;
				} else {
					amtMonMax = (amtMonlimit > amtMonCan) ? amtMonCan
							: amtMonlimit;
				}
				orderMonthdayVO.setOrderMaxMonth(amtMonMax);

				// 设置日最大订购量
				amtDayMax = ((OrderuplimitVO) orderuplimitDealList.get(i))
						.getDaylimit();
				orderMonthdayVO.setOrderMaxDay(amtDayMax);

				// 设置日/月已订购量
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

				// 设置日/月剩余订购量
				orderMonthdayVO.setOrderRemainMonth(amtMonMax - amtMonOrdered);
				orderMonthdayVO.setOrderRemainDay(amtDayMax - amtDayOrdered);

				if(orderMonthdayVO.getOrderRemainMonth()<0){
					orderMonthdayVO.setOrderRemainMonth(0L);
				}
				if(orderMonthdayVO.getOrderRemainDay()<0){
					orderMonthdayVO.setOrderRemainDay(0L);
				}
				
				// 设置品牌
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

	// 获取基准库存信息
	public List<OrderStdstockVO> doGetOrderInfoByStdstock(WayVO wayVO,List<DictitemVO> brandlist, List<ActiverateVO> activerateList)
			throws Exception {
		try {
			List<OrderStdstockVO> orderStdstockList = new ArrayList<OrderStdstockVO>();
			List<OrderuplimitVO> stdstockDealList = new ArrayList<OrderuplimitVO>();
			List<RealtimeamtVO> realtimeamtDealList = new ArrayList<RealtimeamtVO>();

			// 获取基准库存数据
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
			param.set_se_restype("COMRESSMP");//默认套卡
			
			//添加合作类型条件
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
					//未找到对应的品牌
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
			
			// 获取当前库存量列表realtimeamtDeallist
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
					//未找到对应的品牌
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

					// 设置基准库存量
					stdstock = stdstockDealList.get(i).getStdstock();
					if (null == stdstock) {
						throw new SaleException("SALE-103018");
					}
					OrderStdstockVO.setStdstock(stdstock);

					// 设置当前库存量
					for (int j = 0; j < realtimeamtDealList.size(); j++) {
						brand2 = realtimeamtDealList.get(j).getBrand();
						if (null!=brand && null!=brand2 && brand2.equals(brand)) {
							nowstock = realtimeamtDealList.get(j).getNowstock();
						}
					}
					// 未找到对应实时库存
					if (null == nowstock) {
						// String wayname = Code2NameUtils.code2Name("#WAY",
						// wayVO.getWayid(), user.getCityid());
						String brandname = Code2NameUtils.code2Name("$FX_SMPBRAND", brand, user.getCityid());

						SaleException se = new SaleException("SALE-103006",brandname);
						se.setBrandname(brandname);
						throw se;
						// throw new WebSiteException("wayname:" + wayname +
						// ",brandname：" + brandname + ",未找到对应实时库存，请检查",
						// RetResult.FAILURE);
					}

					OrderStdstockVO.setNowstock(nowstock);

					// 设置当前最大订购量
					String maxamtmode = ((OrderuplimitVO) stdstockDealList.get(i)).getMaxamtmode();
					if (null == maxamtmode) {
						throw new SaleException("SALE-103014");
					}

					// 最大订购量模式为激活率模式时，最大订购量特殊处理
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
							//重新设置基准库存上限
							OrderStdstockVO.setStdstock(stock.longValue());
							OrderStdstockVO.setOrderMax((stock.longValue() - nowstock)>0?(stock.longValue() - nowstock):0L);
						} else {
							if (brand.equals(ComorderConstant.BRAND_TYPE_ALLBRAND)) 
							{
								throw new SaleException("SALE-103003");
								// throw new
								// WebSiteException("无对应激活率信息，请检查",RetResult.FAILURE);
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
				// WebSiteException("当前库存量和基准库存设置数据不一致",RetResult.FAILURE);
			}
			return orderStdstockList;
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}

	}

	// 获取预警库存信息
	public List<OrderStockalarmVO> doGetOrderInfoByStockalarm(WayVO wayVO,List<DictitemVO> brandlist)
			throws Exception {
		try {
			List<OrderStockalarmVO> orderStockalarmList = new LinkedList<OrderStockalarmVO>();
			
			Stockalarm stockalarm = (Stockalarm) BOFactory.build(
					StockalarmBO.class, user);
			StockalarmDBParam param = new StockalarmDBParam();
			param.set_se_wayid(wayVO.getWayid());
			DataPackage dp = stockalarm.doQuery(param);
			
			// 获取最高库存和预警阀值
			List<String> alarmbrandlist = new ArrayList<String>();// 预警品牌集合
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
					alarmbrandlist.add(stockalarmList.get(i).getBrand());// 记录下存在的对应预警品牌集合
				}
			}
			Orderuplimit orderuplimit = (Orderuplimit) BOFactory.build(
					OrderuplimitBO.class, user);
			OrderuplimitDBParam opparam = new OrderuplimitDBParam();
			opparam.set_se_cityid(wayVO.getCityid());
			opparam.set_se_countyid(wayVO.getCountyid());
			opparam.set_ne_starlevel(String.valueOf(wayVO.getStarlevel()));
			opparam.set_se_limitmode(ComorderConstant.MODE_STOCKALARM);
			opparam.set_se_restype("COMRESSMP");// 默认套卡
			opparam.getQueryConditions().put("_snin_brand", alarmbrandlist);//排除上面记录的预警品牌
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
			
			//获取当前库存量
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
				//预警库存共享开关		0为关闭，1为开启
				Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
				String param73 = sysparamBO.doFindByID("73", "pboss_fx");
				if("1".equals(param73)){
					for(int j=0; j<orderStockalarmList.size(); j++){
						//品牌共享，特别处理当前库存量
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
			//当前最大订购量
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
			
			//转换预警阀值
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
				//品牌共享翻译
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
	
	// 获取充值卡订购信息
	public List<OrderCardVO> doGetOrderInfoByCard(WayVO wayVO)
			throws Exception {
		try {
			List<OrderCardVO> orderCardList = new ArrayList<OrderCardVO>();			

			//1、获取日/月订购量上限数据
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
			param.set_se_restype("COMRESCARD");//默认充值卡
			
			//添加合作类型条件
			List<String> _sin_cooptype = new ArrayList<String>();
			_sin_cooptype.add(ComorderConstant.COOPTYPE_ALL);
			if(!StringUtils.isEmpty(custtype)){
				_sin_cooptype.add(custtype);
			}
			param.set_sin_cooptype(_sin_cooptype);
			
			//获取查询列表
			DataPackage dp = orderuplimit.doQuery(param);
			if(dp.getRowCount() == 0){
				return orderCardList;
			}
			List<OrderuplimitVO> orderuplimitList = dp.getDatas();
						
			Boolean hasCooptype = false;
			
			//存在特定合作类型，则过滤掉合作类型为ALL的数据
			//下面得到'是否存在特定合作类型'
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
			//存在则过滤，过滤后结果放入orderuplimitTempList
			if(hasCooptype)
			{
				for(int i=0; i<orderuplimitList.size(); i++)
				{
					//过滤合作类型为ALL的记录
					cooptype = orderuplimitList.get(i).getCooptype();
					if(null!=cooptype && !cooptype.equals(ComorderConstant.COOPTYPE_ALL))
					{
						String comcategoryTemp = orderuplimitList.get(i).getComcategory();
						//过滤具有相同商品种类的重复数据
						if(!comcategorySet.contains(comcategoryTemp))
						{
							comcategorySet.add(comcategoryTemp);
							orderuplimitTempList.add(orderuplimitList.get(i));
						}
					}
				}
			}
			//不存在则取全部
			else
			{
				for(int i=0; i<orderuplimitList.size(); i++)
				{
					String comcategoryTemp = orderuplimitList.get(i).getComcategory();
					//过滤具有相同商品种类的重复数据
					if(!comcategorySet.contains(comcategoryTemp))
					{
						comcategorySet.add(comcategoryTemp);
						orderuplimitTempList.add(orderuplimitList.get(i));
					}
				}
			}

			// 获取实时订购量
			//对商品种类进行遍历
			//订购量信息整合
			Order order = (Order)BOFactory.build(OrderBO.class, user);
			OrderDBParam params = new OrderDBParam();
			for(int i=0;i<orderuplimitTempList.size();i++)
			{
				String comcategory = orderuplimitTempList.get(i).getComcategory();
				Long amtDayOrdered = order.doQueryOrderedToday(params, wayVO.getWayid(), comcategory);//当天已订购量
				Long amtMonOrdered = order.doQueryOrderedMonth(params, wayVO.getWayid(), comcategory);//当月已订购量
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
	
	//获取空白SIM卡订购信息
	public List<OrderCardVO> doGetOrderInfoByEmptyCard(WayVO wayVO)
			throws Exception {
		try {
			List<OrderCardVO> orderCardList = new ArrayList<OrderCardVO>();			

			//1、获取日/月订购量上限数据
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
			param.set_se_restype("EMPTYSIM");//默认空白卡
			
			//添加合作类型条件
			List<String> _sin_cooptype = new ArrayList<String>();
			_sin_cooptype.add(ComorderConstant.COOPTYPE_ALL);
			if(!StringUtils.isEmpty(custtype)){
				_sin_cooptype.add(custtype);
			}
			param.set_sin_cooptype(_sin_cooptype);
			
			//获取查询列表
			DataPackage dp = orderuplimit.doQuery(param);
			if(dp.getRowCount() == 0){
				return orderCardList;
			}
			List<OrderuplimitVO> orderuplimitList = dp.getDatas();
						
			Boolean hasCooptype = false;
			
			//存在特定合作类型，则过滤掉合作类型为ALL的数据
			//下面得到'是否存在特定合作类型'
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
			//存在则过滤，过滤后结果放入orderuplimitTempList
			if(hasCooptype)
			{
				for(int i=0; i<orderuplimitList.size(); i++)
				{
					//过滤合作类型为ALL的记录
					cooptype = orderuplimitList.get(i).getCooptype();
					if(null!=cooptype && !cooptype.equals(ComorderConstant.COOPTYPE_ALL))
					{
						String comcategoryTemp = orderuplimitList.get(i).getComcategory();
						//过滤具有相同商品种类的重复数据
						if(!comcategorySet.contains(comcategoryTemp))
						{
							comcategorySet.add(comcategoryTemp);
							orderuplimitTempList.add(orderuplimitList.get(i));
						}
					}
				}
			}
			//不存在则取全部
			else
			{
				for(int i=0; i<orderuplimitList.size(); i++)
				{
					String comcategoryTemp = orderuplimitList.get(i).getComcategory();
					//过滤具有相同商品种类的重复数据
					if(!comcategorySet.contains(comcategoryTemp))
					{
						comcategorySet.add(comcategoryTemp);
						orderuplimitTempList.add(orderuplimitList.get(i));
					}
				}
			}

			// 获取实时订购量
			//对商品种类进行遍历
			//订购量信息整合
			Order order = (Order)BOFactory.build(OrderBO.class, user);
			OrderDBParam params = new OrderDBParam();
			for(int i=0;i<orderuplimitTempList.size();i++)
			{
				String comcategory = orderuplimitTempList.get(i).getComcategory();
				Long amtDayOrdered = order.doQueryOrderedToday(params, wayVO.getWayid(), comcategory);//当天已订购量
				Long amtMonOrdered = order.doQueryOrderedMonth(params, wayVO.getWayid(), comcategory);//当月已订购量
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
	
	// 确定订购资源库区
	public String doGetStorArea(WayVO wayVO) throws Exception {
		try {
			String storarea;
			// 是否启用保底资源
			Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,
					user);
			SysparamDBParam param = new SysparamDBParam();
			param.set_se_paramtype("pboss_fx");
			param.set_ne_systemid("6");
			DataPackage dp1 = sysparam.doQuery(param);
			if (null == dp1 || dp1.getDatas().size() == 0) {
				// 判断渠道子类别是否等于dis
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
				// 判断渠道子类别是否等于dis
				String waysubtype = wayVO.getWaysubtype();
				if (null != waysubtype && waysubtype.equals("DIS")) {
					storarea = "LS";
				} else
					storarea = "ZG";

				return storarea;
			}
			// 保底资源区是否有数据
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
			// 获取保底量
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

			// 获取当月已订购量
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

			// 判断当月已订购量是否大于等于保底量
			if (baseamt == null || monordered >= baseamt) {
				// 判断渠道子类别是否等于dis
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

	// 获取商品订购提示信息
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

	// 获取商品单价信息
	public Double doGetUnitprice(String wayid, String comcategory) throws Exception {
		try {
			Double unitprice = null;//商品单价
			//商品售价模式 SPEPRICE-指定售价 SALEPLAN-优惠方案
			Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
			String spePrice = sysparamBO.doFindByID("71", "pboss_fx");
			if(spePrice != null && "SALEPLAN".equals(spePrice)){
				//取默认第一条优惠方案
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
			Double unitprice = null;//商品单价
			//商品售价模式 SPEPRICE-指定售价 SALEPLAN-优惠方案
			Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
			String spePrice = sysparamBO.doFindByID("71", "pboss_fx");
			if(spePrice != null && "SALEPLAN".equals(spePrice)){
				//取默认第一条优惠方案
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
		
		Double unitprice = null;//商品单价
		
		// 获取商品价格信息
		Comprice comprice = (Comprice) BOFactory.build(CompriceBO.class,user);
		CompriceDBParam param = new CompriceDBParam();
		
		param.set_se_cityid(cityid);
		param.set_se_countyid(countyid);
		param.set_se_comcategory(comcategory);
		
		//添加合作类型条件
		List<String> _sin_cooptype = new ArrayList<String>();
		_sin_cooptype.add(ComorderConstant.COOPTYPE_ALL);
		if(!StringUtils.isEmpty(custtype)){
			_sin_cooptype.add(custtype);
		}
		param.set_sin_cooptype(_sin_cooptype);
		
		//添加星级查询条件
		List<Short> _nin_starlevel = new ArrayList<Short>();
		_nin_starlevel.add(Short.parseShort(ComorderConstant.STARLEVEL_ALL));
		if(null!=starlevel){
			_nin_starlevel.add(starlevel.shortValue());
		}
		param.set_nin_starlevel(_nin_starlevel);
		
		DataPackage dp = comprice.doQuery(param);
		List<CompriceVO> compriceList = dp.getDatas();
		
		// 存在数据
		if(compriceList.size()>0)
		{
			List<CompriceVO> compriceDealList1 = new ArrayList<CompriceVO>();
			List<CompriceVO> compriceDealList2 = new ArrayList<CompriceVO>();
			
			//通过星级过滤
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

			//存在则过滤，过滤后结果放入orderuplimitTempList
			if(hasStarlevel)
			{
				for(int i=0; i<compriceList.size(); i++)
				{
					//过滤合作类型为ALL的记录
					starlevelTemp = String.valueOf(compriceList.get(i).getStarlevel());
					if(null!=starlevelTemp && !starlevelTemp.equals(ComorderConstant.STARLEVEL_ALL))
					{
						compriceDealList1.add(compriceList.get(i));
					}
				}
			}
			//不存在则取全部
			else
			{
				compriceDealList1.addAll(compriceList);
			}
			
			//通过合作类型过滤
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

			//存在则过滤，过滤后结果放入orderuplimitTempList
			if(hasCooptype)
			{
				for(int i=0; i<compriceDealList1.size(); i++)
				{
					//过滤合作类型为ALL的记录
					cooptype = compriceDealList1.get(i).getCooptype();
					if(null!=cooptype && !cooptype.equals(ComorderConstant.COOPTYPE_ALL))
					{
						compriceDealList2.add(compriceDealList1.get(i));
					}
				}
			}
			//不存在则取全部
			else
			{
				compriceDealList2.addAll(compriceDealList1);
			}
			
			// 有数据时,根据区分方式获得商品价格
			CompriceVO compriceVO = compriceDealList2.get(0);
			String pricediftype = compriceVO.getPricediftype();
			// 售价区分方式是无区分，则商品价格为统一价
			if (null != pricediftype
					&& pricediftype
							.equals(ComorderConstant.PRICEDIFTYPE_NODIF)) {
				unitprice = compriceVO.getPrice1();
			}
			// 售价区分方式是按公私帐户区分，则根据该账户是公或者是私，取得相应的价格
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
					// 对公
					if (null != accttype
							&& accttype
									.equals(ComorderConstant.ACCOUNT_TO_CO)) {
						unitprice = compriceVO.getPrice1();
					}
					// 对私
					else {
						unitprice = compriceVO.getPrice2();
					}
				} else {
					throw new SaleException("SALE-104001");
					// throw new WebSiteException("账户信息不存在，请检查",
					// RetResult.FAILURE);
				}
			}
			// 售价区分方式是按是否打印发票区分，则根据商品订购辅助信息中是否打印发票确定售价
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
					// 打印发票
					if (null != printinvoice
							&& printinvoice
									.equals(ComorderConstant.INVOICE_PRI)) {
						unitprice = compriceVO.getPrice1();
					}
					// 不打印发票
					else {
						unitprice = compriceVO.getPrice2();
					}
				} else {
					throw new SaleException("SALE-103002");
					// throw new WebSiteException("商品订购辅助信息不存在，请检查",
					// RetResult.FAILURE);
				}
			}
		}
		//无数据报错
		else{
			String compname = Code2NameUtils.code2Name("#CNTYCOMPANY",countyid, user.getCityid());
			
			//获取合作商
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
			// throw new WebSiteException("商品售价数据不存在",
			// RetResult.FAILURE);
		}
		
		return unitprice;
	}

	// 获取订购基数信息
	public String doGetUnitage(String cityid, String comcategory)
			throws Exception {
		try {
			String unitage = "1";

			// 从商品种类组合关系表获取此类商品是否为套卡
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
					// 如果套卡的订购基数是按星期划分的，则根据订购基数为设置的当天的基数，否则订购基数为设置的基数
					if (unitagemode.equals(ComorderConstant.UNITAGEMODE_WEEK)) {
						String[] unitageArray = orderunitVO.getUnitage().split(
								"\\|");
						// 获取订购基数数组序号
						int arrayIndex = getUnitageIndex();
						unitage = unitageArray[arrayIndex];
					} else {
						unitage = orderunitVO.getUnitage();
					}
				} else {// 如果无数据默认套卡订购基数为20、充值卡订购基数为1
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
	 * 订单建立,返回订单号
	 */
	public void doBuildOrder(String orderid, WayVO wayVO, String storarea,
			List<ComorderVO> comorderList, Set<String> brandSet, String orderave, String alarmlevel)
			throws Exception {
		try {
			// a)订单流程确定
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
			// 查询订单流程表，有数据则继续，无数据则提示出错信息
			if (null != dp.getDatas() && dp.getDatas().size() > 0) {
				OrderflowVO orderflowVO = (OrderflowVO) dp.getDatas().get(0);
				flowid = orderflowVO.getFlowid();

				Orderproce orderproce = (Orderproce) BOFactory.build(
						OrderproceBO.class, user);
				OrderproceDBParam param2 = new OrderproceDBParam();
				param2.set_ne_flowid(String.valueOf(flowid));
				DataPackage dp2 = orderproce.doQuery(param2);

				OrderproceVO orderproceVO = new OrderproceVO();
				// 查询订单步骤流程表，有数据则继续，无数据则提示出错信息，不存在入口为空的步骤也提示出错信息
				if (null != dp2.getDatas() && dp2.getDatas().size() > 0) {
					for (int i = 0; i < dp2.getDatas().size(); i++) {
						orderproceVO = (OrderproceVO) dp2.getDatas().get(i);
						if (null == orderproceVO.getInstate()) {
							outstate = orderproceVO.getOutstate();
							break;
						}
					}
				}
				// 订单流程步骤无对应数据
				else {
					throw new SaleException("SALE-102004");
					// throw new WebSiteException("订单流程异常", RetResult.FAILURE);
				}
				// 未找到入口为空的步骤
				if (outstate.equals("")) {
					throw new SaleException("SALE-102004");
					// throw new WebSiteException("订单流程异常", RetResult.FAILURE);
				}

			}
			// 订单流程无对应数据
			else {
				throw new SaleException("SALE-102003");
				// throw new WebSiteException("订单流程异常", RetResult.FAILURE);
			}

			// 获取订单编号，订单编号取当前地市+当前时间+sequence
			// c)订单商品种类
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
				// 建立订单商品种类
				ordercomcate.doCreate(ordercomcateVO);
			}

			// b)订单基本信息
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
			// 建立订单
			order.doCreate(orderVO);

			// d)订单促销方案
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
			//获取套卡品牌集合
			List<DictitemVO> brandlist = this.doGetBrandCollection(wayVO.getWayid());//查询所有的
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
							realtimeamtVO.setMonordered(orderamt);//首次订购
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
			
			//空白SIM卡订购量实时记录更新
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

	// 获取订单编号
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

	// 获取订购基数数组的序号
	public int getUnitageIndex() throws Exception {
		try {
			// 获取日期的星期序号
			int dayIndex = this.getWeekIndex(new Date());
			int arrayIndex = -1;

			// 将日期的星期序号转为订购基数数组的序号
			// 周日
			if (dayIndex == 1) {
				arrayIndex = 6;
			}
			// 周一至周六
			else {
				arrayIndex = dayIndex - 2;
			}
			return arrayIndex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	// 获取日期对应具体是星期几的序号，序号对应关系为，周日：1； 周一：2； 周二：3； 周三：4； 周四：5； 周五：6； 周六：7
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

	// 获取当月已订购量
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

	// 获取合作类型列表
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

	// 匹配促销方案获取提升量
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

	// 匹配促销方案获取订货量提升明细
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

	// 订购检查
	public Set<String> comOrderCheck(String wayid,
			List<ComorderVO> comorderList, String storarea) throws Exception {
		try {
			Way way = (Way) BOFactory.build(WayBO.class, user);
			WayVO wayvo = way.doFindByPk(wayid);
			
			//获取套卡品牌集合
			Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class, user);
			List<DictitemVO> brandlist = comorder.doGetBrandList(wayvo.getWayid());
			
			//月订购次数检查
			comorder.checkMonthBookTimes(wayid);

			// 套卡订购信息采用模式
			String mode = comorder.doGetOrderMode();
			
			ComorderCheck comorderCheck = (ComorderCheck)BOFactory.build(ComorderCheckBO.class, user);
			
			// 载入订购检查辅助信息
			ComorderCheckHandle handle = comorderCheck.getHelpHandle(wayvo, brandlist, mode);

			// 最后，对订单商品种类列表进行逐条处理
			for (ComorderVO comordervo : comorderList) {
				int i = START;
				ComcategoryrelaVO comcategoryrelavo = null;
				while(i != EXIT){
					switch(i){
						case 1: // 1) 商品种类订购基数检查
							comorderCheck.checkComcategoryUnitageMod(comordervo.getComcategory(),comordervo.getOrderamount());
							i += NEXT;
							break;
						case 2: // 2) 商品种类订购状态检查
							comorderCheck.checkComcategoryState(comordervo.getComcategory());
							i += NEXT;
							break;
						case 3: // 3) 商品种类是否套卡
							comcategoryrelavo = comorderCheck.checkIsComressmp(comordervo.getComcategory());
							if (comcategoryrelavo != null && comcategoryrelavo.getRestype().equals("COMRESSMP")) {
								i += NEXT;
							}else if(comcategoryrelavo != null && comcategoryrelavo.getRestype().equals("EMPTYSIM")){
								i = 8;//跳至第8步：空白SIM卡订购上限检查
							}else{
								i = 7;//跳至第7步：充值卡订购上限检查
							}
							break;
						case 4: //套卡激活率检查（区分品牌/不区分品牌）
							comorderCheck.checkActiverate(comorderCheck.getBrand(comordervo.getComcategory()), wayvo);
							i += NEXT;
							break;
						case 5: //第5步要用到保底量,这里先获取保底量
							if(comorderCheck.checkBaseAmount(comorderCheck.getBrand(comordervo.getComcategory()), comordervo.getOrderamount(), storarea, wayvo)){
								i = EXIT;
							}else{
								i += NEXT;
							}
							break;
						case 6: // 6) 当月可订购量检查 7)  日/月订购量上限检查  9) 累加订购量  进行合并
							comorderCheck.checkOrderedmonthAndLimitCheck(comorderCheck.getBrand(comordervo.getComcategory()), comordervo.getOrderamount(), wayvo, mode);
							i += NEXT;
							break;
						case 7: //  充值卡订购上限检查
							comorderCheck.checkOrderedCardLimit(comordervo.getComcategory(), comcategoryrelavo.getRestype(), comordervo.getOrderamount(), wayvo, mode);
							i += NEXT;
							break;
						case 8: //  空白SIM卡订购上限检查
							comorderCheck.checkOrderedEmptySimLimit(handle,comordervo.getComcategory(), comcategoryrelavo.getRestype(), comordervo.getOrderamount(), wayvo, mode);
							i += NEXT;
							break;
						case 9: //  基准库存上限检查
							comorderCheck.checkOrderedNowstock(comorderCheck.getBrand(comordervo.getComcategory()),comcategoryrelavo.getRestype(), comordervo.getOrderamount(), wayvo, mode);
							i += NEXT;
							break;
						case 10: //  预警库存检查
							comorderCheck.checkOrderedStockalarm(comorderCheck.getBrand(comordervo.getComcategory()),comcategoryrelavo.getRestype(), comordervo.getOrderamount(), wayvo, mode);
							i += NEXT;
							break;
						case 11: //  限量订购检查
							comorderCheck.checkLimit(comordervo.getComcategory(), comordervo.getOrderamount(), wayvo);
							i += NEXT;
							break;
						case 12: //  资源库存检查
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
	 * 月订购次数检查
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
				//如果无数据则根据约束类型（指定星级）、约束对象（星级）、是否紧急（默认为否0，当紧急订购时为1）查询订购次数约束表
				Way wayBO = (Way) BOFactory.build(WayBO.class, user);
				WayVO wayvo = wayBO.doFindByPk(wayid);
				Long starlevel = wayvo.getStarlevel();
				if(starlevel == null || "".equals(starlevel.toString().trim())) {
					throw new SaleException("渠道："+wayid+" 的 starlevel 字段为空");
				}
				param.set_se_objtype("APPSTAR");
				param.set_se_objectcode(starlevel.toString());//正常来讲星级字段都不为空,对于为空的数据,将让市公司统计补充之
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
					// 如果无数据则通过检查
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
	
	//根据系统参数：[pboss_fx,63]，检查是否允许订购混合订单
	//1-允许订购混合订单，0-不允许
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
		
		//日月订购量模式数据
		List<OrderMonthdayVO> orderMonthdayList = this.doGetOrderInfoByMonthDay(wayvo, brandlist);
		if(orderMonthdayList != null && !"".equals(orderMonthdayList) && orderMonthdayList.size() > 0){
			for(int i=0; i<orderMonthdayList.size(); i++){
				OrderMonthdayVO omdVO = orderMonthdayList.get(i);
				OrderMonthdayStockVO omdsVO = new OrderMonthdayStockVO();
				
				com.sunrise.jop.common.utils.bean.BeanUtils.copyProperties(omdsVO, omdVO);
				
				orderMonthdayStockList.add(omdsVO);
			}
		}
		
		//基准库存模式数据
		List<OrderStdstockVO> orderStdstockList = this.doGetOrderInfoByStdstock(wayvo, brandlist,activerateList);
		
		//数据整合：以日月订购量数据为基础，将库存数据按品牌进行填充，
		//最大订购量参考值取“当前最大订购量”、“当月剩余量”、“当天剩余量”三者中最小值。
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
							
							//最大订购量参考
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
		//获取商品面值
		double parValue = 0;//商品面值
		Comcatebrand comcatebrand = (Comcatebrand) BOFactory.build(ComcatebrandBO.class,
				user);
		ComcatebrandDBParam comcatebrandDBParam = new ComcatebrandDBParam();
		comcatebrandDBParam.set_se_comcategory(comcategory);
		DataPackage comcatebrandDP = comcatebrand.doQuery(comcatebrandDBParam);
		if (null != comcatebrandDP && null != comcatebrandDP.getDatas() 
				&& comcatebrandDP.getDatas().size() > 0) {
			ComcatebrandVO comcatebrandVO = (ComcatebrandVO)comcatebrandDP.getDatas().get(0);
			if(null == comcatebrandVO.getParValue()){
				throw new SaleException("商品种类["+Code2NameUtils.code2Name(
						"$IM_FXCOMCATEGORY", comcategory, user.getCityid())+"]面值未定义");
				
			}else{
				parValue = comcatebrandVO.getParValue();
			}
		}else{
			throw new SaleException("商品种类["+Code2NameUtils.code2Name(
					"$IM_FXCOMCATEGORY", comcategory, user.getCityid())+"]面值未定义");
			
		}
		
		//获取优惠减免
		double preValue = 0;//优惠金额
		if(planCode != null && !"".equals(planCode)){
			SaleplanVO saleplanVO = new SaleplanVO();
			Saleplan saleplanBO = (SaleplanBO)BOFactory.build(SaleplanBO.class,user);
			SaleplanDBParam saleplanDBParam = new SaleplanDBParam();
			saleplanDBParam.set_se_cityid(user.getCityid());//地市标识（操作员归属地市）
			saleplanDBParam.set_se_plancode(planCode);//优惠方案编码
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
		double unitprice = parValue - preValue;//商品面值-优惠减免
		if(unitprice<=0){
			throw new SaleException("商品种类["+Code2NameUtils.code2Name(
					"$IM_FXCOMCATEGORY", comcategory, user.getCityid())+"]售价错误，请检查面值和优惠方案");
			
		}
				
		return unitprice;
	}

	public Map<String,String> getSalePlanMap(String comcategory) throws Exception {
		Map<String,String> tmpMap = new LinkedHashMap<String,String>();
		//获取优惠方案
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
	 * 获得空白sim信息
	 */
	public List<OrderEmptyCardVO> getEmptySimInfo(WayVO way) throws Exception {
		List<OrderEmptyCardVO> list = new ArrayList<OrderEmptyCardVO>();
		/*
		 * 1、获取最高库存和预警阀值：
		 * 首先1、根据合作商编码查询空白SIM卡网点库存预警设置表(FX_RU_SIMSTOCKALARM)，
		 * 如果存在数据则取对应的最高库存和预警阀值数据，并记录下存在的对应预警集合；
		 * 如无数据将进行第2步查询，否则跳过第2步查询。
		 */
		Simstockalarm simstockalarm = (SimstockalarmBO)BOFactory.build(SimstockalarmBO.class,user);
		SimstockalarmDBParam simstockalarmDBParam = new SimstockalarmDBParam();
		simstockalarmDBParam.set_se_wayid(way.getWayid());
		DataPackage dp = simstockalarm.doQuery(simstockalarmDBParam);
		
		// 2、获取已领用量、当月已订购：根据合作商编码查询空白SIM卡订购量实时记录表（FX_SW_SIMREALTIMEAMT），获取商品种类、已领用量、当月已订购数据。
		Simrealtimeamt simrealtimeamt = (SimrealtimeamtBO)BOFactory.build(SimrealtimeamtBO.class, user);
		SimrealtimeamtDBParam simrealtimeamtDBParam = new SimrealtimeamtDBParam();
		simrealtimeamtDBParam.set_se_wayid(way.getWayid());
		DataPackage simrealtimedp = simrealtimeamt.doQuery(simrealtimeamtDBParam);
		
		/* 
		 * 3、获取已使用量：根据合作商编码查询合作商资源表(FX_SW_PARTNERRES)，
		 * 限制资源类别(RESTYPE)为空白SIM卡(EMPTYSIM)，是否激活(ISACTIVE)为是(1)统计合作商的各种空白SIM卡使用量
		 */
		Partnerres partnerres = (PartnerresBO)BOFactory.build(PartnerresBO.class, user);
		DataPackage useCountdp = partnerres.doEmptySimUseCount(way.getWayid());
		
		// 4、获取坏卡数量：根据合作商编码查询空白SIM卡坏卡录入表 (IM_FX_EMPTYSIMBAD)，统计合作商的各种空白SIM卡坏卡数量
		Emptysimbad emptysimbad = (Emptysimbad) BOFactory.build(EmptysimbadBO.class, user);
		DataPackage badCountdp = emptysimbad.doEmptySimBadCount(way.getWayid());
		
		OrderEmptyCardVO orderEmptyCardVO = null;
		if (dp.getDatas() == null || dp.getDatas().size() == 0) {
			/*
			 * 然后2、根据地市标识、分公司（即县公司标识COUNTYID）、星级、约束模式（默认取预警库存模式）、资源类别（默认空白SIM卡）
			 * 查询订购量上限设置表（FX_RU_ORDERUPLIMIT），获取最高库存、预警阀值。
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
					String comcategory = ""; // 商品种类
					long curmaxstock = 0; // 当前最大订购量
					long maxstock = 0; // 最高库存
					long curstock = 0; // 已领用量
					long usecount = 0; // 已使用量
					long badcount = 0; // 坏卡数量
					long orderedMonth = 0; // 当月已订购
					
					OrderuplimitVO orderuplimitVO = (OrderuplimitVO) orderuplimitdp.getDatas().get(i);
					orderEmptyCardVO = new OrderEmptyCardVO();
					
					comcategory = orderuplimitVO.getComcategory(); // 商品种类
					maxstock = orderuplimitVO.getMaxstock(); // 最高库存
					String alarmvalue = null; // 预警阀值
					if(orderuplimitVO.getAlarmvalue() != null){
						alarmvalue = this.doInterpretAlarmValue(orderuplimitVO.getAlarmvalue());
					}
					
					for (int j = 0; j < simrealtimedp.getDatas().size(); j++) {
						SimrealtimeamtVO simrealtimeamtVO = (SimrealtimeamtVO) simrealtimedp.getDatas().get(i);
						if (comcategory.equals(simrealtimeamtVO.getComcategory())) {
							curstock = simrealtimeamtVO.getNowstock(); // 已领用量
							orderedMonth = simrealtimeamtVO.getMonordered(); // 当月已订购
							break;
						}
					}
					
					for (int j = 0; j < useCountdp.getDatas().size(); j++) {
						Map map = (Map) useCountdp.getDatas().get(i);
						if (comcategory.equals(map.get("comcategory"))) {
							usecount = Long.parseLong(map.get("count").toString()); // 已使用量
							break;
						}
					}
					
					for (int j = 0; j < badCountdp.getDatas().size(); j++) {
						Map map = (Map) badCountdp.getDatas().get(i);
						if (comcategory.equals(map.get("comcategory"))) {
							badcount = Long.parseLong(map.get("count").toString()); // 坏卡数量
							break;
						}
					}
					
					curmaxstock = maxstock - curstock + usecount + badcount;
					curmaxstock = curmaxstock < 0 ? 0 : curmaxstock;
					orderEmptyCardVO.setRestype(comcategory); // 商品种类
					orderEmptyCardVO.setCurmaxstock(curmaxstock + ""); // 当前最大订购量
					orderEmptyCardVO.setMaxstock(maxstock + ""); // 最高库存
					orderEmptyCardVO.setCurstock(curstock + ""); // 已领用量
					orderEmptyCardVO.setUsecount(usecount + ""); // 已使用量
					orderEmptyCardVO.setBadcount(badcount + ""); // 坏卡数量
					orderEmptyCardVO.setOrderedMonth(orderedMonth + ""); // 当月已订购
					orderEmptyCardVO.setAlarmvalue(alarmvalue); // 预警阀值
					
					list.add(orderEmptyCardVO);
				}
			}
		} else {
			SimstockalarmVO simstockalarmvo = null;
			for (int i = 0; i < dp.getDatas().size(); i++) {
				String comcategory = ""; // 商品种类
				long curmaxstock = 0; // 当前最大订购量
				long maxstock = 0; // 最高库存
				long curstock = 0; // 已领用量
				long usecount = 0; // 已使用量
				long badcount = 0; // 坏卡数量
				long orderedMonth = 0; // 当月已订购
				
				simstockalarmvo = (SimstockalarmVO)dp.getDatas().get(i);
				orderEmptyCardVO = new OrderEmptyCardVO();
				
				comcategory = simstockalarmvo.getComcategory(); // 商品种类
				maxstock = simstockalarmvo.getMaxstock(); // 最高库存
				
				for (int j = 0; j < simrealtimedp.getDatas().size(); j++) {
					SimrealtimeamtVO simrealtimeamtVO = (SimrealtimeamtVO) simrealtimedp.getDatas().get(i);
					if (comcategory.equals(simrealtimeamtVO.getComcategory())) {
						curstock = simrealtimeamtVO.getNowstock(); // 已领用量
						orderedMonth = simrealtimeamtVO.getMonordered(); // 当月已订购
						break;
					}
				}
				
				for (int j = 0; j < useCountdp.getDatas().size(); j++) {
					Map map = (Map) useCountdp.getDatas().get(i);
					if (comcategory.equals(map.get("comcategory"))) {
						usecount = Long.parseLong(map.get("count").toString()); // 已使用量
						break;
					}
				}
				
				for (int j = 0; j < badCountdp.getDatas().size(); j++) {
					Map map = (Map) badCountdp.getDatas().get(i);
					if (comcategory.equals(map.get("comcategory"))) {
						badcount = Long.parseLong(map.get("count").toString()); // 坏卡数量
						break;
					}
				}
				
				curmaxstock = maxstock - curstock + usecount + badcount;
				curmaxstock = curmaxstock < 0 ? 0 : curmaxstock;
				orderEmptyCardVO.setRestype(comcategory); // 商品种类
				orderEmptyCardVO.setCurmaxstock(curmaxstock + ""); // 当前最大订购量
				orderEmptyCardVO.setMaxstock(maxstock + ""); // 最高库存
				orderEmptyCardVO.setCurstock(curstock + ""); // 已领用量
				orderEmptyCardVO.setUsecount(usecount + ""); // 已使用量
				orderEmptyCardVO.setBadcount(badcount + ""); // 坏卡数量
				orderEmptyCardVO.setOrderedMonth(orderedMonth + ""); // 当月已订购
				orderEmptyCardVO.setAlarmvalue(this.doInterpretAlarmValue(simstockalarmvo.getAlarmvalue())); // 预警阀值
				
				list.add(orderEmptyCardVO);
			}
		}
		return list;
	}
	
	//翻译预警信息
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
	 * 套卡订购信息（日月预警库存组合模式）
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
			//对品牌进行是否共享品牌判断
			int index = brand.indexOf(",");
			if(index <= 0){//不是共享品牌
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
			}else{//是共享品牌
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
//			如果预警当前最大订购量大于日订购量时，则当前最大订购量取日订购量，否则取回预警当前最大订购量
//			日月预警库存模式的最大订购量 要取 预警当前最大订购量、日当前最大订购量、月当前最大订购量订购量三者的最小值 
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
