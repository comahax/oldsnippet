package com.gmcc.pboss.control.sales.comorder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.resource.compack.CompackDBParam;
import com.gmcc.pboss.business.resource.resalarminfo.ResalarminfoDBParam;
import com.gmcc.pboss.business.resource.resalarminfo.ResalarminfoVO;
import com.gmcc.pboss.business.sales.activerate.ActiverateVO;
import com.gmcc.pboss.business.sales.baseorderamt.BaseorderamtDBParam;
import com.gmcc.pboss.business.sales.baseorderamt.BaseorderamtVO;
import com.gmcc.pboss.business.sales.comorder.ComorderConstant;
import com.gmcc.pboss.business.sales.comorder.OrderCardVO;
import com.gmcc.pboss.business.sales.comorder.OrderEmptyCardVO;
import com.gmcc.pboss.business.sales.comorder.OrderMonthdayVO;
import com.gmcc.pboss.business.sales.comorder.OrderStdstockVO;
import com.gmcc.pboss.business.sales.comorder.OrderStockalarmVO;
import com.gmcc.pboss.business.sales.comorderstate.ComorderstateDBParam;
import com.gmcc.pboss.business.sales.comorderstate.ComorderstateVO;
import com.gmcc.pboss.business.sales.limitset.LimitsetDBParam;
import com.gmcc.pboss.business.sales.limitset.LimitsetVO;
import com.gmcc.pboss.business.sales.monorderinfo.MonorderinfoDBParam;
import com.gmcc.pboss.business.sales.monorderinfo.MonorderinfoVO;
import com.gmcc.pboss.business.sales.order.OrderDBParam;
import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitDBParam;
import com.gmcc.pboss.business.sales.realtimeamt.RealtimeamtDBParam;
import com.gmcc.pboss.business.sales.realtimeamt.RealtimeamtVO;
import com.gmcc.pboss.business.sales.timesect.TimesectDBParam;
import com.gmcc.pboss.business.sales.timesect.TimesectVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.resource.compack.CompackBO;
import com.gmcc.pboss.control.resource.resalarminfo.Resalarminfo;
import com.gmcc.pboss.control.resource.resalarminfo.ResalarminfoBO;
import com.gmcc.pboss.control.sales.baseorderamt.Baseorderamt;
import com.gmcc.pboss.control.sales.baseorderamt.BaseorderamtBO;
import com.gmcc.pboss.control.sales.comorderstate.Comorderstate;
import com.gmcc.pboss.control.sales.comorderstate.ComorderstateBO;
import com.gmcc.pboss.control.sales.limitset.Limitset;
import com.gmcc.pboss.control.sales.limitset.LimitsetBO;
import com.gmcc.pboss.control.sales.monorderinfo.Monorderinfo;
import com.gmcc.pboss.control.sales.monorderinfo.MonorderinfoBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderuplimit.Orderuplimit;
import com.gmcc.pboss.control.sales.orderuplimit.OrderuplimitBO;
import com.gmcc.pboss.control.sales.realtimeamt.Realtimeamt;
import com.gmcc.pboss.control.sales.realtimeamt.RealtimeamtBO;
import com.gmcc.pboss.control.sales.timesect.Timesect;
import com.gmcc.pboss.control.sales.timesect.TimesectBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.exception.business.SaleException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class ComorderCheckBO extends AbstractControlBean implements
		ComorderCheck {

	/**
	 * 商品订购辅助类
	 */
	private ComorderCheckHandle handle = new ComorderCheckHandle();

	/**
	 * 对订购时段进行检查
	 * 
	 * @throws Exception
	 */
	public void checkLimitTime(WayVO vo) throws Exception {
		try {
			Timesect timesect = (Timesect) BOFactory.build(TimesectBO.class,
					user);
			TimesectDBParam param = new TimesectDBParam();
			param.set_se_cityid(vo.getCityid());
			param.set_se_countyid(vo.getCountyid());
			List<String> marealist = new ArrayList();
			marealist.add(vo.getMareacode());
			marealist.add("ALL");
			if (StringUtils.isNotBlank(vo.getMareacode()))// 如果合作商所属微区域不为空,则匹配合作商所属微区域和所有微区域ALL
				param.set_sin_mareacode(marealist);
			else
				param.set_se_mareacode("ALL");
			param.set_se_datetype("STOPDATE");
			param.set_dnm_begindate(PublicUtils.formatUtilDate(new Date(),
					"yyyy-MM-dd"));
			param.set_dnl_enddate(PublicUtils.formatUtilDate(new Date(),
					"yyyy-MM-dd"));
			DataPackage dp = timesect.doQuery(param);
			if (null != dp && dp.getDatas().size() > 0) {
				throw new SaleException("SALE-104015");
			}

			TimesectDBParam param2 = new TimesectDBParam();
			param2.set_se_cityid(vo.getCityid());
			param2.set_se_countyid(vo.getCountyid());
			if (StringUtils.isNotBlank(vo.getMareacode()))
				param2.set_sin_mareacode(marealist);
			else
				param2.set_se_mareacode("ALL");
			param2.set_se_datetype("APPWEEK");
			DataPackage dp2 = timesect.doQuery(param2);
			TimesectVO timesectvo = new TimesectVO();
			Boolean hasNotAll = false;// 是否存在非“所有微区域”的数据
			if (null != dp2 && dp2.getDatas().size() > 0) {
				List<TimesectVO> list = dp2.getDatas();
				for (TimesectVO tvo : list) {
					if (!tvo.getMareacode().equals("ALL")) {
						timesectvo = tvo;
						hasNotAll = true;
						break;
					}
				}
				if (!hasNotAll) {// 不存在非“所有微区域”的数据，即只有微区域编码为“所有微区域”的数据
					timesectvo = list.get(0);
				}

				String weekset = timesectvo.getWeekset();
				String timesectstr = timesectvo.getTimesect();
				int dayindex = getWeekIndex(new Date()) - 1 == 0 ? 7
						: getWeekIndex(new Date()) - 1;// 今天星期几
				String dayindexstring = String.valueOf(dayindex);
				String[] weeksetArray = weekset.split(";");
				String[] timesectArray = timesectstr.split(";");
				if (!isIn(dayindexstring, weeksetArray)) {
					throw new SaleException("SALE-104015");
				} else {
					int orderindex = getIndex(dayindexstring, weeksetArray);// 今天的星期数在weeksetArray中第几个出现
					String timefortoday = timesectArray[orderindex - 1];// 今天的时间段限制
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
					sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
					String nowTime = sdf.format(new Date());
					String[] times = StringUtils.split(timefortoday, "-");
					if (!(nowTime.compareTo(times[0]) >= 0 && nowTime
							.compareTo(times[1]) < 0)) {
						SaleException se = new SaleException("SALE-104003",
								timefortoday);
						se.setTimesect(timefortoday);
						throw se;
					}
				}
			} else {
				throw new SaleException("SALE-104015");
			}
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	/**
	 * 商品种类订购基数检查
	 * 
	 * @param orderamount
	 *            订购数量
	 * @param comcategory
	 *            订购种类
	 * @throws Exception
	 */
	public void checkComcategoryUnitageMod(String comcategory, Long orderamount)
			throws Exception {
		try {
			Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,
					user);
			Long unitage = Long.parseLong(comorder.doGetUnitage(user
					.getCityid(), comcategory));
			if(orderamount == 0){
				String[] msgParam = { comcategory, "" + orderamount,
						"" + unitage };
				SaleException se = new SaleException("SALE-104004",
						msgParam);
				se.setComcode(comcategory);
				se.setOrderamt(orderamount);
				se.setUnitage(unitage);
				throw se;
			}
			if (unitage != 0) {
				if ((orderamount % (long) unitage) != 0) {
					// throw new WebSiteException("商品种类[" + comcategory +
					// "]的订购套数["
					// + orderamount + "]非订购基数[" + unitage + "]的整数倍",
					// RetResult.FAILURE);
					String[] msgParam = { comcategory, "" + orderamount,
							"" + unitage };
					SaleException se = new SaleException("SALE-104004",
							msgParam);
					se.setComcode(comcategory);
					se.setOrderamt(orderamount);
					se.setUnitage(unitage);
					throw se;
				}
			}
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	/**
	 * 商品种类订购状态检查
	 * 
	 * @param comordervo
	 * @throws Exception
	 */
	public void checkComcategoryState(String comcategory) throws Exception {
		try {
			Comorderstate comorderstate = (Comorderstate) BOFactory.build(
					ComorderstateBO.class, user);
			ComorderstateDBParam comorderstateDBParam = new ComorderstateDBParam();
			comorderstateDBParam.set_se_cityid(user.getCityid());
			comorderstateDBParam.set_se_comcategory(comcategory);
			DataPackage dp = comorderstate.doQuery(comorderstateDBParam);
			if (null != dp && dp.getDatas().size() != 0) {
				ComorderstateVO comorderstatevo = (ComorderstateVO) dp
						.getDatas().get(0);
				String orderstate = comorderstatevo.getOrderstate();
				if (!orderstate.equals("NORMAL")) {
					String msgcontent = comorderstatevo.getMsgcontent();
					// throw new WebSiteException(msgcontent,
					// RetResult.FAILURE);
					SaleException se = new SaleException("SALE-104006",
							msgcontent);
					throw se;
				}
			}
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	/**
	 * 商品种类是否套卡
	 * 
	 * @param comcategory
	 *            订购种类
	 * @return
	 * @throws Exception
	 */
	public ComcategoryrelaVO checkIsComressmp(String comcategory)
			throws Exception {
		try {
			Comcategoryrela comcategoryrela = (Comcategoryrela) BOFactory
					.build(ComcategoryrelaBO.class, user);
			ComcategoryrelaDBParam comcategoryrelaDBParam = new ComcategoryrelaDBParam();
			comcategoryrelaDBParam.set_se_comcategory(comcategory);
			DataPackage dp = comcategoryrela.doQuery(comcategoryrelaDBParam);
			ComcategoryrelaVO vo = null;
			if (dp != null && dp.getDatas().size() != 0) {
				vo = (ComcategoryrelaVO) dp.getDatas().get(0);
			} else {
				SaleException se = new SaleException("SALE-102002", comcategory);
				se.setComcode(comcategory);
				throw se;
			}
			return vo;
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	/**
	 * 获取品牌
	 * 
	 * @param comcategory
	 *            订购种类
	 * @return
	 * @throws Exception
	 */
	public String getBrand(String comcategory) throws Exception {
		try {
			String brand = "";
			Boolean brandflag = "1".equals(handle.getParamvalue_1());
			if (!brandflag) {// 如果不区分品牌
				brand = "AllBrand";
			} else {
				Comcategoryrela comcategoryrela = (Comcategoryrela) BOFactory
						.build(ComcategoryrelaBO.class, user);
				ComcategoryrelaDBParam comcategoryrelaDBParam = new ComcategoryrelaDBParam();
				comcategoryrelaDBParam.set_se_comcategory(comcategory);
				DataPackage dp = comcategoryrela
						.doQuery(comcategoryrelaDBParam);
				ComcategoryrelaVO vo = null;
				if (dp != null && dp.getDatas().size() != 0) {
					vo = (ComcategoryrelaVO) dp.getDatas().get(0);
				} else {
					SaleException se = new SaleException("SALE-102002",
							comcategory);
					se.setComcode(comcategory);
					throw se;
				}
				brand = vo.getBrand();
			}
			return brand;
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	/**
	 * 套卡激活率检查（区分品牌/不区分品牌） 1 区分品牌 0 不区分品牌
	 * 
	 * @param comcategoryrelavo
	 * @param wayvo
	 * @throws Exception
	 */
	public void checkActiverate(String brand, WayVO wayvo) throws Exception {
		try {
			String transbrand = Code2NameUtils.code2Name("$FX_SMPBRAND", brand,
					user.getCityid());

			String paramvalue_1 = handle.getParamvalue_1();
			Map<String, Short> activemap = handle.getActivemap();
			if (paramvalue_1.equals("1")) {
				if (!activemap.containsKey(brand)) {
					// throw new WebSiteException("该合作商[" + wayvo.getWayid() +
					// "]套卡品牌[" + transbrand + "]激活率数据不存在",RetResult.FAILURE);
					SaleException se = new SaleException("SALE-103004",
							transbrand);
					se.setBrandname(transbrand);
					throw se;
				} else {
					if (activemap.get(brand).equals(new Short("0"))) {
						// throw new WebSiteException("该合作商[" + wayvo.getWayid()
						// + "]套卡品牌[" + transbrand +
						// "]激活率未达标",RetResult.FAILURE);
						SaleException se = new SaleException("SALE-104008",
								transbrand);
						se.setBrandname(transbrand);
						throw se;
					}
				}
			} else { // 不区分品牌
				if (!activemap.containsKey("AllBrand")) {
					// throw new WebSiteException("该合作商[" + wayvo.getWayid() +
					// "]激活率数据不存在",RetResult.FAILURE);
					throw new SaleException("SALE-103003");
				}
				if (activemap.get("AllBrand").equals(new Short("0"))) {
					// throw new WebSiteException("该合作商[" + wayvo.getWayid() +
					// "]套卡激活率未达标",RetResult.FAILURE);
					throw new SaleException("SALE-104007");
				}
			}
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	/**
	 * 第5步要用到保底量,这里先获取保底量
	 * 
	 * @param brand
	 *            品牌
	 * @param orderamount
	 *            订购数量
	 * @param wayvo
	 *            渠道
	 */
	public boolean checkBaseAmount(String brand, Long orderamount,
			String storarea, WayVO wayvo) throws Exception {
		try {
			if (storarea.equals("BD") && !handle.getParamvalue_6().equals("1")) {
				Baseorderamt baseorderamt = (Baseorderamt) BOFactory.build(
						BaseorderamtBO.class, user);
				BaseorderamtDBParam bparam = new BaseorderamtDBParam();
				bparam.set_se_cityid(wayvo.getCityid());
				bparam.set_ne_starlevel(wayvo.getStarlevel().shortValue());
				DataPackage dp = baseorderamt.doQuery(bparam);
				BaseorderamtVO baseorderamtvo = (BaseorderamtVO) dp.getDatas()
						.get(0);
				Long baseamt = baseorderamtvo.getBaseamt();
				Long orderedmonth = (Long) handle.getMonorderedmap().get(brand);
				Long orderedday = (Long) handle.getDayorderedmap().get(brand);
				if (orderedmonth + orderamount > baseamt) {
					// throw new WebSiteException("超出保底量[" + baseamt +
					// "]",RetResult.FAILURE);
					SaleException se = new SaleException("SALE-104009", ""
							+ baseamt);
					se.setMaxamt(baseamt);
					throw se;
				} else {
					handle.getMonorderedmap().put(brand,
							orderedmonth + orderamount);
					handle.getDayorderedmap().put(brand,
							orderedday + orderamount);
				}
				return true;
			} else {
				return false;
			}
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	/**
	 * 6) 当月可订购量检查 7) 日/月订购量上限检查 9 累加订购量
	 * 
	 * @param brand
	 *            品牌
	 * @param orderamount
	 *            订购数量
	 * @param wayvo
	 *            渠道
	 */
	public void checkOrderedmonthAndLimitCheck(String brand, Long orderamount,
			WayVO wayvo, String mode) throws Exception {
		try {
			// 6) 当月可订购量检查
			Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,
					user);
			//Long ordermaxmonth = handle.getTopamtmap().get(brand);
			if (handle.getParamvalue_4().equals("1")) {
				Long ordermaxmonth = 0L;
				Long orderedmonth = 0L;
				boolean flag = false;
				//日月预警库存模式时需要处理共享品牌的情况
				if(mode.equals(ComorderConstant.MODE_MONDAYALARM)){
					Map<String,String> mapstr = this.checkOrderedStockalarmchild(brand, "COMRESSMP", orderamount, wayvo, mode,null);
					String brands = mapstr.get("curBrands");
					if(!"".equals(brands)){
						String[] tmp = brands.split(",");
						for(String brd:tmp){
							ordermaxmonth += handle.getTopamtmap().get(brd)==null?0:handle.getTopamtmap().get(brd);;
							orderedmonth +=handle.getMonorderedmap().get(brand)==null?0:handle.getMonorderedmap().get(brd);
							if(handle.getTopamtmap().get(brd)!=null) flag=true;
						}
					}
				}else{
					ordermaxmonth = handle.getTopamtmap().get(brand)==null?0:handle.getTopamtmap().get(brand);
					orderedmonth = handle.getMonorderedmap().get(brand);
					if(handle.getTopamtmap().get(brand)!=null) flag = true;	
				}
				if(flag){
					if ((orderedmonth == null ? 0 : orderedmonth)
							+ (orderamount == null ? 0 : orderamount) > ordermaxmonth) {
						String effectmonth = PublicUtils.formatUtilDate(new Date(),
								"yyyyMM");
						Long promotiondata = comorder.getQuantity(wayvo.getWayid(),
								brand, effectmonth).longValue();
						Long sum = ordermaxmonth
								+ (promotiondata == null ? 0 : promotiondata);
						if ((orderedmonth == null ? 0 : orderedmonth)
								+ (orderamount == null ? 0 : orderamount) > ordermaxmonth
								+ (promotiondata == null ? 0 : promotiondata)) {
							// throw new WebSiteException("超出当月可订购量[" + sum +
							// "]",RetResult.FAILURE);
							SaleException se = new SaleException("SALE-104010", ""
									+ sum);
							se.setMaxamt(sum);
							throw se;
						}
						handle.getBrandSet().add(brand);
					}
				}				
			}

			// 7) 日/月订购量上限检查
			if (null != mode && (mode.equals(ComorderConstant.MODE_MONDAYLIMIT)
					|| mode.equals(ComorderConstant.MODE_MONDAYSTOCK) || mode.equals(ComorderConstant.MODE_MONDAYALARM))) {
				/**
				 * limin update 2012 - 6 -19
				 * 如果日月预警库存组合模式和预警库存设置为多种品牌组合时，将对应组合品牌的日月订购量数据进行累加后再进行以下判断。
				 * 判断是否是共享品牌
				 */
				
				Long orderedday = 0L;
				Long ordermaxday = 0L;
				Long orderedmonth = 0L;
				Long ordermaxmonth2 = 0L;				
				if(mode.equals(ComorderConstant.MODE_MONDAYALARM)){//日月预警库存模式
					String babrand = "";
					Long maxstock = handle.getStockalarmmap().get(brand);
					Map<String,String> mapstr = this.checkOrderedStockalarmchild(brand, "COMRESSMP", orderamount, wayvo, mode,maxstock);
					if(mapstr.get("curBrands") != null){
						babrand = mapstr.get("curBrands");	
					}
					//判断是否组合品牌,先判断套卡库存预警设置（渠道）  若没有查询套卡库存预警设置
					Orderuplimit orderuplimit = (Orderuplimit) BOFactory.build(OrderuplimitBO.class,user);
					OrderuplimitDBParam orderuplimitDBParam = new OrderuplimitDBParam();
					//如果是组合品牌
					if(!babrand.equals("")){						
						String brandstr [] = babrand.split(",");
						for(int i=0;i<brandstr.length;i++){
							String brd = brandstr[i];
							orderedday += handle.getDayorderedmap().get(brd)==null?0:handle.getDayorderedmap().get(brd);
							ordermaxday += handle.getDaylimitmap().get(brd)==null?0:handle.getDaylimitmap().get(brd);							
							orderedmonth += handle.getMonorderedmap().get(brd)==null?0:handle.getMonorderedmap().get(brd);
							ordermaxmonth2 += handle.getMonlimitmap().get(brd)==null?0:handle.getMonlimitmap().get(brd);							
						}						
					}
				}else{//日月订购量模式
					orderedday = handle.getDayorderedmap().get(brand) == null ? 0: handle.getDayorderedmap().get(brand);
					ordermaxday = handle.getDaylimitmap().get(brand) == null ? 0: handle.getDaylimitmap().get(brand);
					orderedmonth = handle.getMonorderedmap().get(brand) == null ? 0: handle.getMonorderedmap().get(brand);
					ordermaxmonth2 = handle.getMonlimitmap().get(brand) == null ? 0: handle.getMonlimitmap().get(brand);
				}	

				if (orderedday + (orderamount == null ? 0 : orderamount) > ordermaxday) {
					// throw new WebSiteException("超出日订购量上限[" + ordermaxday +
					// "]",RetResult.FAILURE);
					SaleException se = new SaleException("SALE-104011", ""
							+ ordermaxday);
					se.setMaxamt(ordermaxday);
					throw se;
				} else if (orderedmonth
						+ (orderamount == null ? 0 : orderamount) > ordermaxmonth2) {
					String wayid = wayvo.getWayid();
					String effectmonth = PublicUtils.formatUtilDate(new Date(),
							"yyyyMM");
					Long promotiondata = comorder.getQuantity(wayid, brand,
							effectmonth).longValue();
					Long sum2 = ordermaxmonth2 + promotiondata;
					if (orderedmonth + (orderamount == null ? 0 : orderamount) > ordermaxmonth2
							+ promotiondata) {
						// throw new WebSiteException("超出月订购量上限[" + sum2 +
						// "]",RetResult.FAILURE);
						SaleException se = new SaleException("SALE-104012", ""
								+ sum2);
						se.setMaxamt(sum2);
						throw se;
					}
					handle.getBrandSet().add(brand);
				}
			}

			// 9 累加订购量
			Long orderedmonth = handle.getMonorderedmap().get(brand);
			orderedmonth = orderedmonth
					+ (orderamount == null ? 0 : orderamount);

			Long orderedday = handle.getDayorderedmap().get(brand);
			orderedday = orderedday + (orderamount == null ? 0 : orderamount);

			handle.getMonorderedmap().put(brand, orderedmonth);
			handle.getDayorderedmap().put(brand, orderedday);

		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	/**
	 * 基准库存上限检查
	 * 
	 * @param brand
	 *            品牌
	 * @param orderamount
	 *            订购数量
	 * @param wayvo
	 *            渠道
	 */
	public void checkOrderedNowstock(String brand, String restype,
			Long orderamount, WayVO wayvo, String mode) throws Exception {
		// 8) 基准库存上限检查
		try {
			if (null != mode && (mode.equals(ComorderConstant.MODE_STDSTOCK)
					|| mode.equals(ComorderConstant.MODE_MONDAYSTOCK))
					&& !restype.equals("COMRESCARD")) {
				Long nowstock = handle.getNowstockmap().get(brand);
				Long stocklimit = handle.getStocklimitmap().get(brand);
				if (nowstock == null) {
					throw new SaleException("SALE-103005");
				}
				if (stocklimit == null) {
					throw new SaleException("SALE-103012");
				}
				if (nowstock + orderamount > stocklimit) {
					// throw new WebSiteException("超出当前最大库存量[" + stocklimit +
					// "]",RetResult.FAILURE);
					SaleException se = new SaleException("SALE-104013", ""
							+ stocklimit);
					se.setMaxamt(stocklimit);
					throw se;
				}
				nowstock = nowstock + orderamount;
				handle.getNowstockmap().put(brand, nowstock);
			}
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	/**
	 * 最高库存检查（预警库存模式）
	 * 
	 * @param brand
	 *            品牌
	 * @param orderamount
	 *            订购数量
	 * @param wayvo
	 *            渠道
	 */
	public void checkOrderedStockalarm(String brand, String restype,
			Long orderamount, WayVO wayvo, String mode) throws Exception {
		// 8) 预警库存检查
		
		try {
			if (null != mode && (mode.equals(ComorderConstant.MODE_STOCKALARM)|| mode.equals(ComorderConstant.MODE_MONDAYALARM))
					&& !restype.equals("COMRESCARD")) {
				if(!restype.equals("EMPTYSIM")){//不等于空白SIM卡
					Long maxstock = handle.getStockalarmmap().get(brand);
					Long nowstock = null;
					
					if (maxstock == null) {
						Map<String,String>	mapstr = this.checkOrderedStockalarmchild(brand, restype, orderamount, wayvo, mode,maxstock);
						if(mapstr.get("nowstock") != null){
							nowstock = Long.parseLong(mapstr.get("nowstock"));
						}
						if(mapstr.get("maxstock") != null){
							maxstock = Long.parseLong(mapstr.get("maxstock"));
						}
					}else{
						nowstock = handle.getNowstockmap().get(brand);
					}
					if (maxstock == null) {
						
						throw new SaleException("SALE-103020",Code2NameUtils.code2Name("$FX_SMPBRAND", brand, user.getCityid()));
					}
					if (nowstock == null) {
						throw new SaleException("SALE-103005");
					}
	
					if (nowstock + orderamount > maxstock) {
						// throw new WebSiteException("超出当前最大库存量[" + stocklimit +
						// "]",RetResult.FAILURE);
						SaleException se = new SaleException("SALE-104013", ""
								+ maxstock);
						se.setMaxamt(maxstock);
						throw se;
					}
					nowstock = nowstock + orderamount;
					handle.getNowstockmap().put(brand, nowstock);
				}
			}
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}
	
	
	public Map<String,String> checkOrderedStockalarmchild(String brand, String restype,Long orderamount, WayVO wayvo, String mode,Long maxstock) throws Exception {
		
		Map<String,String> mapStr = new HashMap<String,String>();
		
		String retString ="";
		Long nowstock = 0l;
		//预警库存共享开关		0为关闭，1为开启
		Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
		String param73 = sysparamBO.doFindByID("73", "pboss_fx");
		if("1".equals(param73)){
			// 取单个品牌最高库存无数据时，取共享库存的最高库存、当前库存量
			String curBrands = "";//记录最高库存量时的混合品牌（如BrandSzx,BrandMwl）
			Map map = handle.getStockalarmmap();
			Iterator iter = map.entrySet().iterator();
			while (iter.hasNext()) {
			    Map.Entry entry = (Map.Entry) iter.next();
			    String brands = (String)entry.getKey();
			    Long val = (Long)entry.getValue();
			    if(brands != null && !"".equals(brands) && brands.indexOf(",")>=0){
			    	if(brands.indexOf(brand)>=0){
			    		if (maxstock == null) {
			    			curBrands = brands;
			    			maxstock = val;
			    		}else{
			    			if (maxstock < val) {
			    				curBrands = brands;
			    				maxstock = val;
			    			}
			    		}
			    	}
			    }
			   
			}
			//最高库存，对应的当前库存量
			Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,
					user);
			List<DictitemVO> brandInerList = comorder.doGetBrandList(wayvo.getWayid());
			List<OrderStockalarmVO> orderStockalarmList = comorder
					.doGetOrderInfoByStockalarm(wayvo, brandInerList);
			for (OrderStockalarmVO orderStockalarmVO : orderStockalarmList) {
				if(curBrands != null && curBrands.equals(orderStockalarmVO.getBrand())){
					nowstock = orderStockalarmVO.getNowstock();
				}
			}
			retString = curBrands;
		}
		
		mapStr.put("curBrands", retString);
		mapStr.put("nowstock", nowstock+"");
		mapStr.put("maxstock", maxstock+"");
		return mapStr;
	}
	

	/**
	 * 限量订购检查
	 */
	public void checkLimit(String comcategory, Long orderamount, WayVO wayvo)
			throws Exception {
		try {
			Resalarminfo resalarminfo = (Resalarminfo) BOFactory.build(
					ResalarminfoBO.class, user);
			ResalarminfoDBParam rparam = new ResalarminfoDBParam();
			String today = PublicUtils.formatUtilDate(new Date(), "yyyy-MM-dd");
			rparam.set_dnl_alarmdate(today + " 00:00:00");
			rparam.set_dnm_alarmdate(today + " 23:59:59");
			rparam.set_se_countyid(wayvo.getCountyid());
			rparam.set_se_comcategory(comcategory);
			rparam.set_se_alarmsignal("RED");
			DataPackage dp = resalarminfo.doQuery(rparam);
			if (dp.getDatas().size() > 0) {
				ResalarminfoVO raivo = (ResalarminfoVO) dp.getDatas().get(0);
				Long stockamt = raivo.getStockamt();
				Limitset limitset = (Limitset) BOFactory.build(
						LimitsetBO.class, user);
				LimitsetDBParam lparam = new LimitsetDBParam();
				lparam.set_se_cityid(wayvo.getCityid());
				lparam.set_se_countyid(wayvo.getCountyid());
				lparam.set_ne_starlevel(String.valueOf(wayvo.getStarlevel()));
				lparam.set_se_comcategory(comcategory);
				DataPackage dp2 = limitset.doQuery(lparam);
				if (dp2.getDatas().size() > 0) {
					Order order = (Order) BOFactory.build(OrderBO.class, user);
					OrderDBParam params = new OrderDBParam();
					LimitsetVO lsvo = (LimitsetVO) dp2.getDatas().get(0);
					Double stockscale = lsvo.getStockscale();
					Long orderedtoday = order.doQueryOrderedToday(params, wayvo
							.getWayid(), comcategory);// 当天已订购量
					if (orderedtoday + orderamount > stockamt * stockscale) {
						String[] msgParam = { comcategory,
								"" + stockamt * stockscale };
						SaleException se = new SaleException("SALE-104011",
								msgParam);
						se.setComcode(comcategory);
						se.setMaxamt(stockamt * stockscale.longValue());
						throw se;
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

	/**
	 * 资源库存检查
	 */
	public void checkResStock(String comcategory, Long orderamount, WayVO wayvo)
			throws Exception {
		try {
			Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,
					user);
			String pvalue = sysparam.doFindByID("48", "pboss_fx");
			if (StringUtils.isNotBlank(pvalue) && "1".equals(pvalue)) {
				Comcategoryrela comcategoryrelaBO = (Comcategoryrela) BOFactory
						.build(ComcategoryrelaBO.class, user);
				ComcategoryrelaDBParam comcategoryrelaParam = new ComcategoryrelaDBParam();
				comcategoryrelaParam.set_se_comcategory(comcategory);
				DataPackage comcategoryrelaDP = comcategoryrelaBO
						.doQuery(comcategoryrelaParam);
				if (null != comcategoryrelaDP
						&& comcategoryrelaDP.getDatas().size() > 0) {
					ComcategoryrelaVO comcategoryrelaVO = (ComcategoryrelaVO) comcategoryrelaDP
							.getDatas().get(0);
					String restype = comcategoryrelaVO.getRestype();
					// 按套卡和充值卡进行库存量统计
					long stocks = 0; // 库存资源数量
					long ordered = 0; // 已订购未抽取资源数量
					if ("COMRESSMP".equals(restype)) {
						CompackBO compackBO = (CompackBO) BOFactory.build(
								CompackBO.class, user);
						CompackDBParam compackParam = new CompackDBParam();
						compackParam.setDataOnly(true);
						compackParam.setQueryAll(true);
						compackParam.setSelectFieldsString("num");
						compackParam.getQueryConditions().put("COUNTYID",
								wayvo.getCountyid());
						compackParam.getQueryConditions().put("COMCATEGORY",
								comcategory);
						compackParam.getQueryConditions().put("RESUSE",
								"NORMAL");
						DataPackage dp = compackBO
								.doQueryBynameSql(
										"com.gmcc.pboss.business.resource.compack.doCommresmpStocksQuery",
										compackParam);
						if (null != dp && null != dp.getDatas()
								&& !dp.getDatas().isEmpty()) {
							stocks = Long.parseLong((String) dp.getDatas().get(
									0));
						}

						dp = compackBO
								.doQueryBynameSql(
										"com.gmcc.pboss.business.resource.compack.smporderednotchouquQuery",
										compackParam);
						if (null != dp && null != dp.getDatas()
								&& !dp.getDatas().isEmpty()) {
							ordered = (dp.getDatas().get(0) == null ? 0 : Long
									.parseLong((String) dp.getDatas().get(0)));
						}
					} else if ("COMRESCARD".equals(restype)) {
						CompackBO compackBO = (CompackBO) BOFactory.build(
								CompackBO.class, user);
						CompackDBParam compackParam = new CompackDBParam();
						compackParam.setDataOnly(true);
						compackParam.setQueryAll(true);
						compackParam.setSelectFieldsString("num");
						compackParam.getQueryConditions().put("COUNTYID",
								wayvo.getCountyid());
						compackParam.getQueryConditions().put("COMCATEGORY",
								comcategory);
						DataPackage dp = compackBO
								.doQueryBynameSql(
										"com.gmcc.pboss.business.resource.compack.doComrescardStocksQuery",
										compackParam);
						if (null != dp && null != dp.getDatas()
								&& !dp.getDatas().isEmpty()) {
							stocks = Long.parseLong((String) dp.getDatas().get(
									0));
						}

						dp = compackBO
								.doQueryBynameSql(
										"com.gmcc.pboss.business.resource.compack.cardordernotchouquQuery",
										compackParam);
						if (null != dp && null != dp.getDatas()
								&& !dp.getDatas().isEmpty()) {
							ordered = (dp.getDatas().get(0) == null ? 0 : Long
									.parseLong((String) dp.getDatas().get(0)));
						}
					}else if("EMPTYSIM".equals(restype)){
						CompackBO compackBO = (CompackBO) BOFactory.build(
								CompackBO.class, user);
						CompackDBParam compackParam = new CompackDBParam();
						compackParam.setDataOnly(true);
						compackParam.setQueryAll(true);
						compackParam.setSelectFieldsString("num");
						compackParam.getQueryConditions().put("COUNTYID",
								wayvo.getCountyid());
						compackParam.getQueryConditions().put("COMCATEGORY",
								comcategory);
						DataPackage dp = compackBO
								.doQueryBynameSql(
										"com.gmcc.pboss.business.resource.compack.doEmptysimStocksQuery",
										compackParam);
						if (null != dp && null != dp.getDatas()
								&& !dp.getDatas().isEmpty()) {
							stocks = Long.parseLong((String) dp.getDatas().get(
									0));
						}

						dp = compackBO
								.doQueryBynameSql(
										"com.gmcc.pboss.business.resource.compack.EmptysimorderednotchouquQuery",
										compackParam);
						if (null != dp && null != dp.getDatas()
								&& !dp.getDatas().isEmpty()) {
							ordered = (dp.getDatas().get(0) == null ? 0 : Long
									.parseLong((String) dp.getDatas().get(0)));
						}
						
						
					}
					if (!((stocks - ordered) >= orderamount)) {
						SaleException se = new SaleException("SALE-104016",
								comcategory);
						se.setComcode(comcategory);
						throw se;
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

	/**
	 * 充值卡订购上限检查
	 * 
	 * @param comcategory
	 *            商品种类
	 * @param orderamountou
	 *            订购数量
	 * @param wayvo
	 *            渠道
	 */
	public void checkOrderedCardLimit(String comcategory, String restype,
			Long orderamount, WayVO wayvo, String mode) throws Exception {
		// 8) 充值卡订购上限检查
		// 取得商品单次订购上限
		Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class, user);
		List<OrderCardVO> orderCardList = comorder.doGetOrderInfoByCard(wayvo);
		Long orderlimit = 0L;

		if (orderCardList != null) {
			for (int i = 0; i < orderCardList.size(); i++) {
				if (orderCardList.get(i).getComcategory() != null
						&& orderCardList.get(i).getComcategory().equals(
								comcategory)) {
					orderlimit = orderCardList.get(i).getOncelimit();
					break;
				}
			}
		}

		try {
			if (null != mode && !mode.equals(ComorderConstant.MODE_MONDAYLIMIT)) {
				this.doSetUplimitAndOrderdCardMap(wayvo);
			}
			// && restype.equals("COMRESCARD"))
			if (restype.equals("COMRESCARD")) {
				if (handle.getDayorderedcardmap() != null) {
					if (handle.getDayorderedcardmap().containsKey(comcategory)) {
						Long ordereddaycard = handle.getDayorderedcardmap()
								.get(comcategory) == null ? 0 : handle
								.getDayorderedcardmap().get(comcategory);
						Long ordermaxcardday = handle.getDaylimitcardmap().get(
								comcategory) == null ? 0 : handle
								.getDaylimitcardmap().get(comcategory);

						Long orderedmonthcard = handle.getMonorderedcardmap()
								.get(comcategory) == null ? 0 : handle
								.getMonorderedcardmap().get(comcategory);
						Long ordermaxmonthcard = handle.getMonlimitcardmap()
								.get(comcategory) == null ? 0 : handle
								.getMonlimitcardmap().get(comcategory);

						if (ordereddaycard
								+ (orderamount == null ? 0 : orderamount) > ordermaxcardday) {
							SaleException se = new SaleException("SALE-104011",
									"" + ordermaxcardday);
							se.setMaxamt(ordermaxcardday);
							throw se;
						} else if (orderedmonthcard
								+ (orderamount == null ? 0 : orderamount) > ordermaxmonthcard) {
							SaleException se = new SaleException("SALE-104012",
									"" + ordermaxmonthcard);
							se.setMaxamt(ordermaxmonthcard);
							throw se;
						}

					}
				}
				// 如果单次订购上限非空而且大于零，则判断 订购数量>单次订购上限，如果大于则提示
				// （错误码取“SALE-104017”，将单次订购上限传入）并返回；否则继续。
				if (orderlimit > 0 && orderamount > orderlimit) {
					SaleException se = new SaleException("SALE-104017", ""
							+ orderlimit);
					se.setMaxamt(orderlimit);
					throw se;
				}
			}
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}
	
	/**
	 * 空白SIM最高库存检查
	 */
	public void checkOrderedEmptySimLimit(ComorderCheckHandle handle,String comcategory, String restype,
			Long orderamount, WayVO wayvo, String mode) throws Exception {
		//如果资源类别不为空白SIM卡，则跳过本步骤；否则继续。
		if(restype.equals("EMPTYSIM")){
			boolean flage = true;
			//根据匹配最高库存数据（预警库存），如果不存在则提示（错误码取“SALE-103020”，将商品种类传入）并返回；否则继续。
			List<OrderEmptyCardVO> orderEmptyCardVOList = handle.getOrderEmptyCardVOList();
			if (orderEmptyCardVOList != null && orderEmptyCardVOList.size() > 0) {
				OrderEmptyCardVO orderEmptyCardVO = null;
				for (int i = 0; i < orderEmptyCardVOList.size(); i++) {
					orderEmptyCardVO = orderEmptyCardVOList.get(i);
					if (comcategory.equals(orderEmptyCardVO.getRestype())) {
						flage = false;
						/*
						 * 判断订购数量 是否大于 当前最大订购量（当前最大订购量 = 最高库存 – 已领用量 + 已使用量 + 坏卡数量），
						 * 如果大于则提示（错误码取“SALE-104013”）并返回；否则检查通过。
						 */
						if(orderamount > Long.parseLong(orderEmptyCardVO.getCurmaxstock())){
							SaleException se = new SaleException("SALE-104013", orderEmptyCardVO.getCurmaxstock());
							throw se;
						}
					}
				}
			}
			
			if (flage) {
				String msgParam = Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", comcategory, user.getCityid());
				SaleException se = new SaleException("SALE-103020", msgParam);
				throw se;
			}
		}
	}

	/**
	 * 载入辅助信息
	 */
	public ComorderCheckHandle getHelpHandle(WayVO wayvo,
			List<DictitemVO> brandlist, String mode) throws Exception {
		try {
			this.doSetParamvalue_1();
			this.doSetActiverateMap(wayvo, brandlist);
			this.doSetRealtimeamtMap(wayvo, brandlist);
			this.doSetMonorderinfoMap(wayvo, brandlist);
			if (null != mode) {
				if (mode.equals(ComorderConstant.MODE_MONDAYLIMIT)) {
					this.doSetOrderuplimitMap(wayvo, brandlist);
					this.doSetUplimitAndOrderdCardMap(wayvo);
				} else if (mode.equals(ComorderConstant.MODE_STDSTOCK)) {
					this.doSetStocklimitMap(wayvo, brandlist);
				} else if (mode.equals(ComorderConstant.MODE_STOCKALARM)) {
					this.doSetStockalarmMap(wayvo, brandlist);
				}else if (mode.equals(ComorderConstant.MODE_MONDAYSTOCK)) {
					this.doSetOrderuplimitMap(wayvo, brandlist);
					this.doSetUplimitAndOrderdCardMap(wayvo);
					this.doSetStocklimitMap(wayvo, brandlist);
				}else if (mode.equals(ComorderConstant.MODE_MONDAYALARM)) {
					this.doSetStockalarmMap(wayvo, brandlist);
					this.doSetOrderuplimitMap(wayvo, brandlist);
					this.doSetUplimitAndOrderdCardMap(wayvo);
				}
				this.doGetEmptySimInfo(wayvo);
			}

			return handle;
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception e) {
			e.printStackTrace();
			throw new JOPException(e);
		}
	}

	/**
	 * 设置辅助类参数-套卡是否区分品牌
	 * 
	 * @return
	 * @throws Exception
	 */
	private void doSetParamvalue_1() throws Exception {
		try {
			Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,
					user);
			String paramvalue_1 = sysparam.doFindByID("12", "pboss_fx");
			if (StringUtils.isEmpty(paramvalue_1)) {
				// throw new WebSiteException("是否区分品牌参数未设置，请联系管理员",
				// RetResult.FAILURE);
				throw new SaleException("SALE-101001");
			}
			handle.setParamvalue_1(paramvalue_1);
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}
	
	/**
	 * 获得空白sim卡信息
	 * @param way
	 * @throws Exception
	 */
	public void doGetEmptySimInfo(WayVO way) throws Exception{
		Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,user);
		handle.setOrderEmptyCardVOList(comorder.getEmptySimInfo(way));
	}

	/**
	 * 获取套卡激活率
	 */
	private void doSetActiverateMap(WayVO wayvo, List<DictitemVO> brandlist)
			throws Exception {
		// 2) 获取套卡激活率
		try {
			Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,
					user);
			List<ActiverateVO> activerateList = comorder.doGetActiveList(wayvo
					.getWayid(), brandlist);
			// if (activerateList.size() == 0) {
			// //throw new WebSiteException("该合作商[" + wayvo.getWayid() +
			// "]套卡激活率数据不存在",RetResult.FAILURE);
			// throw new SaleException("SALE-103003");
			// }
			Map<String, Short> activemap = new HashMap<String, Short>();
			Map<String, Double> activemap2 = new HashMap<String, Double>();
			for (ActiverateVO activeratevo : activerateList) {
				String brand_temp = activeratevo.getBrand();
				Short isachieve = activeratevo.getIsachieve();
				Double rate_2 = activeratevo.getRate();
				activemap.put(brand_temp, isachieve);
				activemap2.put(brand_temp, rate_2);
			}// 这里得到每种品牌和与之对应的激活率是否达标的信息
			handle.setActivemap(activemap);
			handle.setActivemap2(activemap2);
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	/**
	 * 获取实时订购量
	 */
	private void doSetRealtimeamtMap(WayVO wayvo, List<DictitemVO> brandlist)
			throws Exception {
		try {
			Realtimeamt realtimeamt = (Realtimeamt) BOFactory.build(
					RealtimeamtBO.class, user);
			RealtimeamtDBParam rparam = new RealtimeamtDBParam();
			rparam.set_se_wayid(wayvo.getWayid());
			List<RealtimeamtVO> realtimeamtlist = new LinkedList<RealtimeamtVO>();
			for (DictitemVO dictitemvo : brandlist) {
				String dictid = dictitemvo.getDictid();
				rparam.set_se_brand(dictid);
				DataPackage dp3 = realtimeamt.doQuery(rparam);
				if (null != dp3 && dp3.getRowCount() > 0) {
					RealtimeamtVO vo = (RealtimeamtVO) dp3.getDatas().get(0);
					realtimeamtlist.add(vo);
				} else {
					RealtimeamtVO vo = new RealtimeamtVO();
					vo.setBrand(dictid);
					vo.setMonordered(new Long("0"));
					vo.setDayordered(new Long("0"));
					realtimeamtlist.add(vo);
				}
			}
			Map<String, Long> monorderedmap = new HashMap<String, Long>();
			Map<String, Long> dayorderedmap = new HashMap<String, Long>();
			Map<String, Long> nowstockmap = new HashMap<String, Long>();
			for (RealtimeamtVO vo : realtimeamtlist) {
				String brand = vo.getBrand();
				Long monordered = vo.getMonordered() == null ? 0L : vo
						.getMonordered();
				Long dayordered = vo.getDayordered() == null ? 0L : vo
						.getDayordered();
				Long nowstock = vo.getNowstock() == null ? 0L : vo
						.getNowstock();
				monorderedmap.put(brand, monordered);
				dayorderedmap.put(brand, dayordered);
				nowstockmap.put(brand, nowstock);
			}

			handle.setMonorderedmap(monorderedmap);
			handle.setDayorderedmap(dayorderedmap);
			handle.setNowstockmap(nowstockmap);
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	/**
	 * 获取当月可订购量
	 */
	private void doSetMonorderinfoMap(WayVO wayvo, List<DictitemVO> brandlist)
			throws Exception {
		try {
			List<MonorderinfoVO> monorderinforlist = new LinkedList<MonorderinfoVO>();
			Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,
					user);
			String paramvalue_4 = sysparam.doFindByID("8", "pboss_fx");
			if (StringUtils.isEmpty(paramvalue_4)) {
				// throw new
				// WebSiteException("月订购量浮动开关状态参数未设置，请联系管理员",RetResult.FAILURE);
				throw new SaleException("SALE-101002");
			}
			Map<String, Long> topamtmap = new HashMap<String, Long>();
			if (paramvalue_4.equals("1")) {
				Monorderinfo monorderinfo = (Monorderinfo) BOFactory.build(
						MonorderinfoBO.class, user);
				MonorderinfoDBParam mparam = new MonorderinfoDBParam();
				String thismonth = PublicUtils.formatUtilDate(new Date(),
						"yyyyMM");
				mparam.set_se_wayid(wayvo.getWayid());
				mparam.set_se_month(thismonth);
				// DataPackage dp6 = monorderinfo.doQuery(mparam);
				// if (null == dp6 || dp6.getDatas().size() == 0) {
				// //throw new WebSiteException("该合作商[" + wayvo.getWayid() +
				// "]月订购量记录表无对应数据",RetResult.FAILURE);
				// throw new SaleException("SALE-103010");
				// }
				for (DictitemVO dictitemvo : brandlist) {
					String dictid = dictitemvo.getDictid();
					mparam.set_se_brand(dictid);
					DataPackage dp2 = monorderinfo.doQuery(mparam);
					if (null != dp2 && dp2.getRowCount() > 0) {
						MonorderinfoVO vo = (MonorderinfoVO) dp2.getDatas()
								.get(0);
						monorderinforlist.add(vo);
					} else {
						MonorderinfoVO vo = new MonorderinfoVO();
						vo.setBrand(dictid);
						vo.setTopamt(null);
						monorderinforlist.add(vo);
					}
				}

				// Long topamtforallbrand = -1L;
				Long topamt = -1L;
				// Boolean brandflag = "1".equals(handle.getParamvalue_1());
				// if (!brandflag) {// 如果不区分品牌
				// mparam.set_se_brand("AllBrand");
				// DataPackage dp7 = monorderinfo.doQuery(mparam);
				// if (null == dp7 || dp7.getDatas().size() == 0) {
				// //throw new WebSiteException("该合作商[" + wayvo.getWayid() +
				// "]月订购量记录表无[所有品牌]所对应的可订购量数据",RetResult.FAILURE);
				// throw new SaleException("SALE-103010");
				// }
				// MonorderinfoVO vo = (MonorderinfoVO) dp7.getDatas().get(0);
				// topamtforallbrand = vo.getTopamt();
				// }
				for (MonorderinfoVO monorderinfovo : monorderinforlist) {
					String brand = monorderinfovo.getBrand();
					topamt = monorderinfovo.getTopamt();
					topamtmap.put(brand, topamt);
				}
			}
			handle.setParamvalue_4(paramvalue_4);
			handle.setTopamtmap(topamtmap);
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	/**
	 * 获取日/月订购量上限
	 */
	private void doSetOrderuplimitMap(WayVO wayVO, List<DictitemVO> brandlist)
			throws Exception {
		try {

			Map<String, Long> monlimitmap = new HashMap<String, Long>();
			Map<String, Long> daylimitmap = new HashMap<String, Long>();

			Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,
					user);
			List<OrderMonthdayVO> orderMonthdayList = comorder
					.doGetOrderInfoByMonthDay(wayVO, brandlist);

			Long amtMonlimit = -1L;
			Long amtDaylimit = -1L;
			for (OrderMonthdayVO orderMonthdayVO : orderMonthdayList) {
				String brand = orderMonthdayVO.getBrand();
				amtMonlimit = orderMonthdayVO.getOrderMaxMonth();
				amtDaylimit = orderMonthdayVO.getOrderMaxDay();
				monlimitmap.put(brand, amtMonlimit);
				daylimitmap.put(brand, amtDaylimit);
			}

			handle.setMonlimitmap(monlimitmap);
			handle.setDaylimitmap(daylimitmap);
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	/**
	 * 获取基准库存上限
	 */
	private void doSetStockalarmMap(WayVO wayVO, List<DictitemVO> brandlist)
			throws Exception {
		try {

			Map<String, Long> stockalarmmap = new HashMap<String, Long>();
			Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,
					user);

			List<OrderStockalarmVO> orderStockalarmList = comorder
					.doGetOrderInfoByStockalarm(wayVO, brandlist);
			for (OrderStockalarmVO orderStockalarmVO : orderStockalarmList) {
				String brand = orderStockalarmVO.getBrand();
				stockalarmmap.put(brand, orderStockalarmVO.getMaxStock());
			}

			handle.setStockalarmmap(stockalarmmap);
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	/**
	 * 获取基准库存上限
	 */
	private void doSetStocklimitMap(WayVO wayVO, List<DictitemVO> brandlist)
			throws Exception {
		try {

			Map<String, Long> stocklimitmap = new HashMap<String, Long>();
			Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,
					user);

			List<ActiverateVO> activerateList = comorder.doGetActiveList(wayVO
					.getWayid(), brandlist);
			List<OrderStdstockVO> orderStdstockList = comorder
					.doGetOrderInfoByStdstock(wayVO, brandlist, activerateList);
			for (OrderStdstockVO orderStdstockVO : orderStdstockList) {
				String brand = orderStdstockVO.getBrand();
				stocklimitmap.put(brand, orderStdstockVO.getStdstock());
			}

			handle.setStocklimitmap(stocklimitmap);
		} catch (SaleException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	/**
	 * 设置充值卡日/月订购量上限和实时订购量
	 */
	private void doSetUplimitAndOrderdCardMap(WayVO wayVO) throws Exception {
		try {

			Map<String, Long> monlimitcardmap = new HashMap<String, Long>();
			Map<String, Long> daylimitcardmap = new HashMap<String, Long>();
			Map<String, Long> monorderedcardmap = new HashMap<String, Long>();
			Map<String, Long> dayorderedcardmap = new HashMap<String, Long>();

			Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,
					user);
			List<OrderCardVO> orderCardList = comorder
					.doGetOrderInfoByCard(wayVO);

			Long amtMonlimitCard = -1L;
			Long amtDaylimitCard = -1L;
			Long amtMonOrderedCard = -1L;
			Long amtDayOrderedCard = -1L;
			for (OrderCardVO ordercardvo : orderCardList) {
				String comcategory = ordercardvo.getComcategory();
				amtMonlimitCard = ordercardvo.getOrderMaxMonth();
				amtDaylimitCard = ordercardvo.getOrderMaxDay();
				amtMonOrderedCard = ordercardvo.getOrderedMonth();
				amtDayOrderedCard = ordercardvo.getOrderedDay();
				monlimitcardmap.put(comcategory, amtMonlimitCard);
				daylimitcardmap.put(comcategory, amtDaylimitCard);
				monorderedcardmap.put(comcategory, amtMonOrderedCard);
				dayorderedcardmap.put(comcategory, amtDayOrderedCard);
			}

			handle.setMonlimitcardmap(monlimitcardmap);
			handle.setDaylimitcardmap(daylimitcardmap);
			handle.setMonorderedcardmap(monorderedcardmap);
			handle.setDayorderedcardmap(dayorderedcardmap);
		} catch (SaleException ex) {
			throw ex;
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

	/**
	 * JAVA判断字符串数组中是否包含某字符串元素
	 * 
	 * @param substring
	 *            某字符串
	 * @param source
	 *            源字符串数组
	 * @return 包含则返回true，否则返回false
	 */
	private boolean isIn(String substring, String[] source) {
		if (source == null || source.length == 0) {
			return false;
		}
		for (int i = 0; i < source.length; i++) {
			String aSource = source[i];
			if (aSource.equals(substring)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断目标字符串在字符串数组中第几个出现 *
	 * 
	 * @param substring
	 *            某字符串
	 * @param source
	 *            源字符串数组
	 * @return 第一个出现则返回1
	 */
	private int getIndex(String substring, String[] source) {
		int index = 1;
		for (int i = 0; i < source.length; i++) {
			if (!source[i].equals(substring)) {
				index++;
			} else {
				break;
			}
		}
		return index;
	}
}
