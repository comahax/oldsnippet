package com.gmcc.pboss.control.sales.bgcontrol.SMPActiveRateCalc;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gmcc.pboss.business.sales.bgbusiness.PartnerSMPBrandVO;
import com.gmcc.pboss.business.sales.bgbusiness.SMPActiveRateCalc.SMPActiveRateCalcDAO;
import com.gmcc.pboss.business.sales.noactinfo.NoactinfoDBParam;
import com.gmcc.pboss.business.sales.noactinfo.NoactinfoVO;
import com.gmcc.pboss.business.sales.partnerres.PartnerresDAO;
import com.gmcc.pboss.business.sales.partnerres.PartnerresDBParam;
import com.gmcc.pboss.business.sales.partnerres.PartnerresVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.sales.bgcontrol.SMPActiveRateCalc.calcmode.intf.CalcMode;
import com.gmcc.pboss.control.sales.bgcontrol.SMPActiveRateCalc.calcmode.utils.ModeMappingUtil;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class SMPActiveRateCalcBO extends AbstractControlBean implements
		SMPActiveRateCalc {
	
	private Logger log = Logger.getLogger(SMPActiveRateCalcBO.class);

	private CalcMode calcMode;
	
	public void setCalcMode(CalcMode calcMode) {
		this.calcMode = calcMode;
	}

	public Map<String, String> doStatSMPNotWithBrand(int activeOrderDay,
			int activeDay,int inActiveOrderDay) throws Exception {
		SMPActiveRateCalcDAO dao = (SMPActiveRateCalcDAO) DAOFactory.build(SMPActiveRateCalcDAO.class,user);
		return dao.statSMPNotWithBrand(activeOrderDay, activeDay, inActiveOrderDay);
	}

	public Map<PartnerSMPBrandVO, Long[]> doStatSMPWithBrand(
			int activeOrderDay,
				int activeDay,int inActiveOrderDay) throws Exception {
		SMPActiveRateCalcDAO dao = (SMPActiveRateCalcDAO) DAOFactory.build(SMPActiveRateCalcDAO.class,user);
		return dao.statSMPWithBrand(activeOrderDay, activeDay, inActiveOrderDay);
	}
	
	public Map<PartnerSMPBrandVO, BigDecimal> doStatInActiveSMPWithBrand() throws Exception {
		SMPActiveRateCalcDAO dao = (SMPActiveRateCalcDAO) DAOFactory.build(SMPActiveRateCalcDAO.class,user);
		return dao.statInActiveSMPWithBrand();
	}

	public Map<String, String> doStatActiveAndOrderSMPNotWithBrand(
			int activeOrderDay, int activeDay, int orderDay) throws Exception {
		SMPActiveRateCalcDAO dao = (SMPActiveRateCalcDAO) DAOFactory.build(SMPActiveRateCalcDAO.class,user);
		return dao.statActiveAndOrderSMPNotWithBrand(activeOrderDay, activeDay, orderDay);
	}

	public Map<PartnerSMPBrandVO, String> doStatActiveAndOrderSMPWithBrand(
			int activeOrderDay, int activeDay, int orderDay) throws Exception {
		SMPActiveRateCalcDAO dao = (SMPActiveRateCalcDAO) DAOFactory.build(SMPActiveRateCalcDAO.class,user);
		return dao.statActiveAndOrderSMPWithBrand(activeOrderDay, activeDay, orderDay);
	}

	public BigDecimal[] doStatOrderAndActiveSMPNotWithBrand(String wayid,
			Date firstDayOfMonth, Date endDayOfMonth)
			throws Exception {
		SMPActiveRateCalcDAO dao = (SMPActiveRateCalcDAO) DAOFactory.build(SMPActiveRateCalcDAO.class,user);
		return dao.statOrderAndActiveSMPNotWithBrand(wayid, firstDayOfMonth, endDayOfMonth);
	}
	public BigDecimal[] doStatOrderAndActiveSMPWithBrand(String wayid,
			String brand, Date firstDayOfMonth, Date endDayOfMonth) throws Exception {
		SMPActiveRateCalcDAO dao = (SMPActiveRateCalcDAO) DAOFactory.build(SMPActiveRateCalcDAO.class,user);
		return dao.statOrderAndActiveSMPWithBrand(wayid, brand, firstDayOfMonth, endDayOfMonth);
	}

	public Map<String, BigDecimal> doStatActiveSMPLastMonth()
			throws Exception {
		SMPActiveRateCalcDAO dao = (SMPActiveRateCalcDAO) DAOFactory.build(SMPActiveRateCalcDAO.class,user);
		return dao.statActiveSMPLastMonth();
	}

	/**
	 * 合作商套卡激活数据更新
	 * @param intervalDay 合作商资源表中的创建时间和号码激活记录表中的激活时间的间隔天数
	 * @throws Exception
	 */
	public int doSMPActiveUpdate(int intervalDay) throws Exception {
		int updateRow = 0;
		try {
			log.info("开始更新合作商套卡激活数据......");
			SMPActiveRateCalcDAO dao = (SMPActiveRateCalcDAO) DAOFactory.build(SMPActiveRateCalcDAO.class,user);
			updateRow = dao.updateSMPActive(intervalDay);
			
			Session currentSession = SessionUtils.currentSession(user.getCityid());
			Transaction tx = currentSession.beginTransaction();
			tx.commit();// 更新后提交数据
			tx.begin(); // 更新操作全部提交后重新开启事务，避免后续修改操作无法提交事务
			log.info("完成更新合作商套卡激活数据......");
			log.info("更新行数: "+updateRow);
			return updateRow;
		}catch(Exception ex) {
			throw new JOPException(ex);
		}
		
		
		//查询合作商资源表（FX_SW_PARTNERRES），匹配资源类别为套卡，是否激活为否
		/*Partnerres prBo = (PartnerresBO)BOFactory.build(PartnerresBO.class,user);
		NoactinfoDBParam niParam = new NoactinfoDBParam();
		PartnerresDBParam prParam = new PartnerresDBParam();
		prParam.set_se_restype("COMRESSMP");
		prParam.set_ne_isactive("0");
		prParam.set_pagesize("500"); // 为避免数据量过大时，JVM内存溢出问题，需要进行分页处理,每次从数据库读取100条数据
		prParam.setCountOnly(true);  // 先只计算总记录数
		DataPackage rowDp = this.doUnionQuerySmpInfo(prParam,niParam);
		int rowCount = rowDp.getRowCount();
		double pageCount = Math.ceil((double)rowCount/Double.parseDouble(prParam.get_pagesize()));
		
		prParam.setCountOnly(false); 
		prParam.setDataOnly(true);   // 前面已经获得总记录数，因此这里只需要获得数据
		
		String cityid = user.getCityid();
		Session currentSession = SessionUtils.currentSession(cityid);
		Transaction tx =null;
		while(rowCount != 0) {
			DataPackage prDp = this.doUnionQuerySmpInfo(prParam,niParam);
			
			Collection prDatas = prDp.getDatas();
			if(prDatas != null && prDatas.size() > 0) {
				// 以处理一“页”数据的时间作为一个原子事务周期
				tx = currentSession.beginTransaction();
				
				List<Object[]> prList = new ArrayList<Object[]>(prDatas);
				int count = 0;
				for(Object[] vos : prList) {
					PartnerresVO prVo = (PartnerresVO)vos[0];
					NoactinfoVO niVo = (NoactinfoVO)vos[1];
					
					try {
						// 合作商资源创建时间
						java.util.Date resCreateDate = prVo.getCreatetime();
						// 号码激活时间
						java.util.Date noActiveDate = niVo.getActivedate();
						
						if(resCreateDate.after(noActiveDate)) {
							// 号码激活记录表中的激活时间小于合作商资源表中的创建时间
							Calendar resCreateCal = Calendar.getInstance();
							Calendar noActiveCal = Calendar.getInstance();
							resCreateCal.setTime(resCreateDate);
							noActiveCal.setTime(noActiveDate);
							// 
							noActiveCal.add(Calendar.DAY_OF_YEAR, 30);
							// 如果号码激活时间在合作商资源创建时间前30天内
							if(noActiveCal.after(resCreateCal)) {
								prVo.setActtime(noActiveDate);
								prVo.setIsactive(Short.valueOf("1"));
								prBo.doUpdate(prVo);
							}
						}else {
							// 号码激活记录表中的激活时间大于等于合作商资源表中的创建时间
							prVo.setActtime(noActiveDate);
							prVo.setIsactive(Short.valueOf("1"));
							prBo.doUpdate(prVo);
						}
						if(++count % 50 == 0) { // 与hibernate.jdbc.batch_size设定的值相同，以控制一级缓存的大小
							currentSession.flush();
							currentSession.clear();
						}
						
					}catch(Exception ex) {
						LoggerUtils.error(ex, log);
					}
				}
				tx.commit();// 提交该“页”所处理的数据
			}
			int pageno = Integer.parseInt(prParam.get_pageno());
			if(pageCount > 1 && pageCount > pageno) {
				prParam.set_pageno(String.valueOf(pageno+1));
			}else {
				tx.begin(); // 更新操作全部提交后重新开启事务，避免进行套卡激活率计算后事务无法提交
				break;
			}
		}*/
		
	}
	
	public void doSMPActiveRateCalc() throws Exception {
		calcMode.doSMPActiveRateCalc(user);
	}
	
	public DataPackage doUnionQuerySmpInfo(PartnerresDBParam param1, NoactinfoDBParam param2)
			throws Exception {
		Object[] params = {param1,param2};
		Class[] vo = {PartnerresVO.class, NoactinfoVO.class};
		String[][] joins = {{"comresid","mobileno"}};
		
		PartnerresDAO dao = (PartnerresDAO)DAOFactory.build(PartnerresDAO.class, user);
		if(param1.isCountOnly()) {
			return dao.unionQuery(params, vo, joins, PartnerresDAO.QUERY_TYPE_COUNT);
		}else if(param1.isDataOnly()) {
			return dao.unionQuery(params, vo, joins, PartnerresDAO.QUERY_TYPE_DATA);
		}else {
			return dao.unionQuery(params, vo, joins, PartnerresDAO.QUERY_TYPE_ALL);
		}
	}

	public void doProcess() throws Exception {
		
		log.info("**************************activeRateCalculate begin*********************");
		Sysparam spBo = (SysparamBO)BOFactory.build(SysparamBO.class, user);
		String calcModeStr = spBo.doFindByID(11L, "pboss_fx");
		if(calcModeStr == null) {
			log.error("系统参数配置表中没有参数类型为“pboss_fx”，参数标识为“11”的数据，请核实");
			return;
		}
		calcModeStr = calcModeStr.trim();
		if("".equals(calcModeStr)) {
			log.error("系统参数配置表中\"套卡激活率计算模式\"的数据为空，请核实。");
			return;
		}else if(!"GENERAL".equalsIgnoreCase(calcModeStr) && !"BUILDUP".equalsIgnoreCase(calcModeStr)
					&& !"STDSTOCK".equalsIgnoreCase(calcModeStr)) {
			log.error("系统参数配置表中\"套卡激活率计算模式\"的值有误，请核实。GENERAL-普通模式，BUILDUP-组合模式，STDSTOCK-基准库存模式");
			return;
		}
//		else {
//			this.doSMPActiveUpdate(30);
//		}
		
		String modeClass = ModeMappingUtil.getModeClass(calcModeStr.toUpperCase());
		CalcMode calcModeInstance = (CalcMode)Class.forName(modeClass).getConstructor(this.getClass().getInterfaces()[0]).newInstance(this);
		this.setCalcMode(calcModeInstance);
		this.doSMPActiveRateCalc();
		log.info("**************************activeRateCalculate end*********************");
		
	}
	
	
}
