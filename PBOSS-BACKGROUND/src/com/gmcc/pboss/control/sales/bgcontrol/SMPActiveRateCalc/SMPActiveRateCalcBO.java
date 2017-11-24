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
	 * �������׿��������ݸ���
	 * @param intervalDay ��������Դ���еĴ���ʱ��ͺ��뼤���¼���еļ���ʱ��ļ������
	 * @throws Exception
	 */
	public int doSMPActiveUpdate(int intervalDay) throws Exception {
		int updateRow = 0;
		try {
			log.info("��ʼ���º������׿���������......");
			SMPActiveRateCalcDAO dao = (SMPActiveRateCalcDAO) DAOFactory.build(SMPActiveRateCalcDAO.class,user);
			updateRow = dao.updateSMPActive(intervalDay);
			
			Session currentSession = SessionUtils.currentSession(user.getCityid());
			Transaction tx = currentSession.beginTransaction();
			tx.commit();// ���º��ύ����
			tx.begin(); // ���²���ȫ���ύ�����¿������񣬱�������޸Ĳ����޷��ύ����
			log.info("��ɸ��º������׿���������......");
			log.info("��������: "+updateRow);
			return updateRow;
		}catch(Exception ex) {
			throw new JOPException(ex);
		}
		
		
		//��ѯ��������Դ��FX_SW_PARTNERRES����ƥ����Դ���Ϊ�׿����Ƿ񼤻�Ϊ��
		/*Partnerres prBo = (PartnerresBO)BOFactory.build(PartnerresBO.class,user);
		NoactinfoDBParam niParam = new NoactinfoDBParam();
		PartnerresDBParam prParam = new PartnerresDBParam();
		prParam.set_se_restype("COMRESSMP");
		prParam.set_ne_isactive("0");
		prParam.set_pagesize("500"); // Ϊ��������������ʱ��JVM�ڴ�������⣬��Ҫ���з�ҳ����,ÿ�δ����ݿ��ȡ100������
		prParam.setCountOnly(true);  // ��ֻ�����ܼ�¼��
		DataPackage rowDp = this.doUnionQuerySmpInfo(prParam,niParam);
		int rowCount = rowDp.getRowCount();
		double pageCount = Math.ceil((double)rowCount/Double.parseDouble(prParam.get_pagesize()));
		
		prParam.setCountOnly(false); 
		prParam.setDataOnly(true);   // ǰ���Ѿ�����ܼ�¼�����������ֻ��Ҫ�������
		
		String cityid = user.getCityid();
		Session currentSession = SessionUtils.currentSession(cityid);
		Transaction tx =null;
		while(rowCount != 0) {
			DataPackage prDp = this.doUnionQuerySmpInfo(prParam,niParam);
			
			Collection prDatas = prDp.getDatas();
			if(prDatas != null && prDatas.size() > 0) {
				// �Դ���һ��ҳ�����ݵ�ʱ����Ϊһ��ԭ����������
				tx = currentSession.beginTransaction();
				
				List<Object[]> prList = new ArrayList<Object[]>(prDatas);
				int count = 0;
				for(Object[] vos : prList) {
					PartnerresVO prVo = (PartnerresVO)vos[0];
					NoactinfoVO niVo = (NoactinfoVO)vos[1];
					
					try {
						// ��������Դ����ʱ��
						java.util.Date resCreateDate = prVo.getCreatetime();
						// ���뼤��ʱ��
						java.util.Date noActiveDate = niVo.getActivedate();
						
						if(resCreateDate.after(noActiveDate)) {
							// ���뼤���¼���еļ���ʱ��С�ں�������Դ���еĴ���ʱ��
							Calendar resCreateCal = Calendar.getInstance();
							Calendar noActiveCal = Calendar.getInstance();
							resCreateCal.setTime(resCreateDate);
							noActiveCal.setTime(noActiveDate);
							// 
							noActiveCal.add(Calendar.DAY_OF_YEAR, 30);
							// ������뼤��ʱ���ں�������Դ����ʱ��ǰ30����
							if(noActiveCal.after(resCreateCal)) {
								prVo.setActtime(noActiveDate);
								prVo.setIsactive(Short.valueOf("1"));
								prBo.doUpdate(prVo);
							}
						}else {
							// ���뼤���¼���еļ���ʱ����ڵ��ں�������Դ���еĴ���ʱ��
							prVo.setActtime(noActiveDate);
							prVo.setIsactive(Short.valueOf("1"));
							prBo.doUpdate(prVo);
						}
						if(++count % 50 == 0) { // ��hibernate.jdbc.batch_size�趨��ֵ��ͬ���Կ���һ������Ĵ�С
							currentSession.flush();
							currentSession.clear();
						}
						
					}catch(Exception ex) {
						LoggerUtils.error(ex, log);
					}
				}
				tx.commit();// �ύ�á�ҳ�������������
			}
			int pageno = Integer.parseInt(prParam.get_pageno());
			if(pageCount > 1 && pageCount > pageno) {
				prParam.set_pageno(String.valueOf(pageno+1));
			}else {
				tx.begin(); // ���²���ȫ���ύ�����¿������񣬱�������׿������ʼ���������޷��ύ
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
			log.error("ϵͳ�������ñ���û�в�������Ϊ��pboss_fx����������ʶΪ��11�������ݣ����ʵ");
			return;
		}
		calcModeStr = calcModeStr.trim();
		if("".equals(calcModeStr)) {
			log.error("ϵͳ�������ñ���\"�׿������ʼ���ģʽ\"������Ϊ�գ����ʵ��");
			return;
		}else if(!"GENERAL".equalsIgnoreCase(calcModeStr) && !"BUILDUP".equalsIgnoreCase(calcModeStr)
					&& !"STDSTOCK".equalsIgnoreCase(calcModeStr)) {
			log.error("ϵͳ�������ñ���\"�׿������ʼ���ģʽ\"��ֵ�������ʵ��GENERAL-��ͨģʽ��BUILDUP-���ģʽ��STDSTOCK-��׼���ģʽ");
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
