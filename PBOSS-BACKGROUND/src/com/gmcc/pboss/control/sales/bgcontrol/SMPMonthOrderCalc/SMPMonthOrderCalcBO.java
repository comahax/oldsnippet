package com.gmcc.pboss.control.sales.bgcontrol.SMPMonthOrderCalc;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.sales.activerate.ActiverateVO;
import com.gmcc.pboss.business.sales.bgbusiness.PartnerSMPBrandVO;
import com.gmcc.pboss.business.sales.bgbusiness.SMPMonthOrderCalc.SMPMonthOrderCalcDAO;
import com.gmcc.pboss.business.sales.monamtchgrule.MonamtchgruleDBParam;
import com.gmcc.pboss.business.sales.monamtchgrule.MonamtchgruleVO;
import com.gmcc.pboss.business.sales.monorderinfo.MonorderinfoDBParam;
import com.gmcc.pboss.business.sales.monorderinfo.MonorderinfoVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.sales.activerate.Activerate;
import com.gmcc.pboss.control.sales.activerate.ActiverateBO;
import com.gmcc.pboss.control.sales.bgcontrol.SMPActiveRateCalc.SMPActiveRateCalc;
import com.gmcc.pboss.control.sales.bgcontrol.SMPActiveRateCalc.SMPActiveRateCalcBO;
import com.gmcc.pboss.control.sales.monamtchgrule.Monamtchgrule;
import com.gmcc.pboss.control.sales.monamtchgrule.MonamtchgruleBO;
import com.gmcc.pboss.control.sales.monorderinfo.Monorderinfo;
import com.gmcc.pboss.control.sales.monorderinfo.MonorderinfoBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class SMPMonthOrderCalcBO extends AbstractControlBean implements
		SMPMonthOrderCalc {

	private Logger log = Logger.getLogger(SMPMonthOrderCalcBO.class);
	
	public int doDeleteMonthOrder(String destMonth) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		if(destMonth == null) {
			destMonth = format.format(new java.util.Date());
		}
		int deletedRow = 0;
		try {
			SMPMonthOrderCalcDAO dao = (SMPMonthOrderCalcDAO)DAOFactory.build(SMPMonthOrderCalcDAO.class, user);
			deletedRow = dao.deleteMonthOrder(destMonth);
			log.info("删除  " + destMonth + " 月份的订购量数据："+deletedRow +" 条");
			return deletedRow;
		}catch(Exception ex) {
			throw new JOPException(ex);
		}
	}

	public Map<PartnerSMPBrandVO, String> doStatMonthOrder(String[] months) throws Exception {
		SMPMonthOrderCalcDAO dao = (SMPMonthOrderCalcDAO)DAOFactory.build(SMPMonthOrderCalcDAO.class, user);
		return dao.statMonthOrder(months,user.getCityid());
	}
	
	public void doUpdateLMOrderAndActive(String destMonth) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		java.util.Date destDate = null;
		if(destMonth == null) {
			destDate = new java.util.Date();
		}else {
			destDate = format.parse(destMonth);
		}
		Calendar lmcal = Calendar.getInstance();
		lmcal.setTime(destDate);
		lmcal.add(Calendar.MONTH, -1);
		String lastMonth = format.format(lmcal.getTime());
		Monorderinfo miBo = (MonorderinfoBO)BOFactory.build(MonorderinfoBO.class,user,BOFactory.PROPAGATION_REQUIRES_NEW);
		
		SMPActiveRateCalc arcBo = (SMPActiveRateCalcBO)BOFactory.build(SMPActiveRateCalcBO.class,user);
		
		MonorderinfoDBParam miParam = new MonorderinfoDBParam();
		miParam.set_se_month(lastMonth);
		miParam.set_pagesize("0");
		miParam.setDataOnly(true);
		DataPackage miDp = miBo.doQuery(miParam);
		Collection datas = miDp.getDatas();
		// 累计更新记录数
		int updateCount = 0;
		// 记录被更新的渠道标识
		StringBuffer wayidSb = new StringBuffer();
		if(datas != null && datas.size() > 0) {
			List<MonorderinfoVO> dataList = new ArrayList<MonorderinfoVO>(datas);
			for(MonorderinfoVO miVo : dataList) {
				try {
					String brand = miVo.getBrand();
					String wayid = miVo.getWayid();
					java.util.Date firstDayOfMonth = PublicUtils.getFirstDateOfMonth(lmcal);
					java.util.Date endDayOfMonth = PublicUtils.getEndDateOfMonth(lmcal);
					BigDecimal[] quantity = new BigDecimal[2];
					if("AllBrand".equalsIgnoreCase(brand)) {
						quantity = arcBo.doStatOrderAndActiveSMPNotWithBrand(wayid, firstDayOfMonth, endDayOfMonth);
					}else {
						quantity = arcBo.doStatOrderAndActiveSMPWithBrand(wayid, brand, firstDayOfMonth, endDayOfMonth);
					}
					if(quantity[0] != null && quantity[1] != null) {
						miVo.setActualamt(quantity[0].longValue());
						miVo.setActamt(quantity[1].longValue());
						miVo.setUpdatetime(new java.util.Date());
						miBo.doUpdate(miVo);
						++updateCount;
						wayidSb.append(wayid+";");
					}
				}catch(Exception ex) {
					LoggerUtils.error(ex, log);
				}
			}
		}
		log.info("更新上月("+lastMonth+")实际订购量和激活量记录数： "+updateCount+"条;");
		log.info("其中被更新渠道包括："+wayidSb.toString());
	}
	
	public void doCreateMonthOrder(String destMonth) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		java.util.Date destDate = null;
		if(destMonth == null) {
			destDate = new java.util.Date();
			destMonth = format.format(destDate);
		}else {
			destDate = format.parse(destMonth);
		}
		Calendar destCal = Calendar.getInstance();
		destCal.setTime(destDate);
		
		Sysparam spBo = (SysparamBO)BOFactory.build(SysparamBO.class,user);
		String spAvgActiveMonthValue = spBo.doFindByID(14L, "pboss_fx");
		String avgActiveMonth = "";
		if(spAvgActiveMonthValue == null) {
			log.warn("系统参数配置表中没有参数类型为“pboss_fx”，参数标识为“14”的数据，按3 处理");
			avgActiveMonth = "3";
		}else if("".equals(spAvgActiveMonthValue.trim())) {
			log.warn("系统参数配置表中 \"订购量浮动平均激活量月份\"的值为空，按3处理");
			avgActiveMonth = "3";
		}else {
			avgActiveMonth = spAvgActiveMonthValue.trim();
			if(!PublicUtils.isInteger(avgActiveMonth)) {
				throw new Exception("系统参数配置表中 \"订购量浮动平均激活量月份\" 的值不是整数");
			}
		}
		int monthCount = Integer.parseInt(avgActiveMonth);
		String[] months = new String[monthCount];
		for(int i=0; i < monthCount;i++) {
			destCal.add(Calendar.MONTH, -(i+1));
			months[i] = format.format(destCal.getTime());
			destCal.add(Calendar.MONTH, i+1);
		}
		Monorderinfo miBo = (MonorderinfoBO)BOFactory.build(MonorderinfoBO.class,user,BOFactory.PROPAGATION_REQUIRES_NEW);
		Activerate arBo = (ActiverateBO)BOFactory.build(ActiverateBO.class,user);
		Monamtchgrule mrBo = (MonamtchgruleBO)BOFactory.build(MonamtchgruleBO.class,user);
		
		MonorderinfoDBParam miParam = new MonorderinfoDBParam();
		MonamtchgruleDBParam mrParam = new MonamtchgruleDBParam();
		
		// activeMap中的 key = PartnerSMPBrandVO(包含渠道id和套卡品牌); 
		// value = 总月份数|总激活量|渠道星级
		Map<PartnerSMPBrandVO, String> activeMap = this.doStatMonthOrder(months);
		Set<PartnerSMPBrandVO> keySet = activeMap.keySet();
		// 新增记录数
		int newCount = 0;
		for(Iterator<PartnerSMPBrandVO> it = keySet.iterator();it.hasNext();) {
			PartnerSMPBrandVO smpBrandVo = it.next();
			String wayid = smpBrandVo.getWayid();
			String brand = smpBrandVo.getBrand();
			String value = activeMap.get(smpBrandVo);
			try {
				String[] valueArr = value.split("\\|");
				int avgActMonths = Integer.parseInt(valueArr[0]);
				
				if(avgActMonths == monthCount) {
					// 有连续X月的记录
					Serializable arPk = new ActiverateVO();
					BeanUtils.setProperty(arPk, "wayid", wayid);
					BeanUtils.setProperty(arPk, "brand", brand);
					ActiverateVO arVo = arBo.doFindByPk(arPk);
					if(arVo == null) {
						continue;
					}
					double activeRate = arVo.getRate();
					String starlevel = valueArr[2];
					if("null".equalsIgnoreCase(starlevel)) {
						throw new Exception("渠道："+wayid+"的 starlevel 字段为空");
					}
					mrParam.set_se_cityid(user.getCityid());
					mrParam.set_se_brand(brand);
					mrParam.set_ne_starlevel(starlevel);
					
					mrParam.set_ne_effective("1");
					mrParam.set_pagesize("0");
					mrParam.setDataOnly(true);
					DataPackage mrDp = mrBo.doQuery(mrParam);
					List<MonamtchgruleVO> mrList = new ArrayList<MonamtchgruleVO>(mrDp.getDatas());
					// 订购倍数默认为1；如果无查询结果则默认订购倍数为1；根据分销设计V1.32版
					double times = 1d;
					for(MonamtchgruleVO mrVo : mrList) {
						if(activeRate > mrVo.getActratelow() 
								&& activeRate <= mrVo.getActrateup()) {
							times = mrVo.getTimes();
							break;
						}
					}
					if("0".equals(valueArr[1])) {
						StringBuffer exSb = new StringBuffer();
						exSb.append("渠道 : "+wayid+" 在前").append(monthCount+" 个月 ");
						for(int i=0;i<months.length;i++) {
							exSb.append(months[i]+" ");
						}
						exSb.append("都没有订购"+brand);
						throw new Exception(exSb.toString());
					}
					// X个月的平均激活量
					double avgActiveQty = Double.parseDouble(valueArr[1])/avgActMonths;
					long topAmt = (long)(Math.ceil(avgActiveQty*times));
					MonorderinfoVO miVo = new MonorderinfoVO();
					miVo.setTopamt(topAmt);
					miVo.setWayid(wayid);
					miVo.setMonth(destMonth);
					miVo.setBrand(brand);
					miVo.setUpdatetime(new java.util.Date());
					miBo.doCreate(miVo);
					++newCount;
				}else if(avgActMonths < monthCount){
					// 不足X月,可认为该合作商从开始订购不足X月
					// 以目标月份的上月可订购量为准
					miParam.set_se_month(months[0]);
					miParam.set_se_wayid(wayid);
					miParam.set_se_brand(brand);
					miParam.set_pagesize("0");
					miParam.setDataOnly(true);
					DataPackage miDp = miBo.doQuery(miParam);
					List<MonorderinfoVO> miList = new ArrayList<MonorderinfoVO>(miDp.getDatas());
					if(miList.size() <= 0 ) {
						throw new Exception("渠道 : "+wayid+" 在 上个月："+months[0]+" 没有订购 " +brand);
					}
					MonorderinfoVO lastMonthMiVo = miList.get(0);
					MonorderinfoVO thisMonthMiVo = new MonorderinfoVO();
					thisMonthMiVo.setWayid(wayid);
					thisMonthMiVo.setBrand(brand);
					thisMonthMiVo.setTopamt(lastMonthMiVo.getTopamt());
					thisMonthMiVo.setMonth(destMonth);
					thisMonthMiVo.setUpdatetime(new java.util.Date());
					miBo.doCreate(thisMonthMiVo);
					++newCount;
				}
			}catch(Exception ex) {
				LoggerUtils.error(ex, log);
				log.error("error in :"+" wayid: "+wayid+" brand: "+brand+" 连续月份|平均激活量: "+value);
			}
		}
		log.info("新增本月("+destMonth+")订购量数据："+newCount+"条;");
	}

	public void doProcess(String destMonth) throws Exception {
		log.info("**************************monthOrderCalculate begin*********************");
		this.doUpdateLMOrderAndActive(destMonth);
		// 将“上月实际订购量和激活量的更新操作”同步到数据库
		SessionUtils.currentSession().flush();
		
		this.doDeleteMonthOrder(destMonth);
		this.doCreateMonthOrder(destMonth);
		log.info("**************************monthOrderCalculate end*********************");
	}

}
