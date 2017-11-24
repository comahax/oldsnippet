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
			log.info("ɾ��  " + destMonth + " �·ݵĶ��������ݣ�"+deletedRow +" ��");
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
		// �ۼƸ��¼�¼��
		int updateCount = 0;
		// ��¼�����µ�������ʶ
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
		log.info("��������("+lastMonth+")ʵ�ʶ������ͼ�������¼���� "+updateCount+"��;");
		log.info("���б���������������"+wayidSb.toString());
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
			log.warn("ϵͳ�������ñ���û�в�������Ϊ��pboss_fx����������ʶΪ��14�������ݣ���3 ����");
			avgActiveMonth = "3";
		}else if("".equals(spAvgActiveMonthValue.trim())) {
			log.warn("ϵͳ�������ñ��� \"����������ƽ���������·�\"��ֵΪ�գ���3����");
			avgActiveMonth = "3";
		}else {
			avgActiveMonth = spAvgActiveMonthValue.trim();
			if(!PublicUtils.isInteger(avgActiveMonth)) {
				throw new Exception("ϵͳ�������ñ��� \"����������ƽ���������·�\" ��ֵ��������");
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
		
		// activeMap�е� key = PartnerSMPBrandVO(��������id���׿�Ʒ��); 
		// value = ���·���|�ܼ�����|�����Ǽ�
		Map<PartnerSMPBrandVO, String> activeMap = this.doStatMonthOrder(months);
		Set<PartnerSMPBrandVO> keySet = activeMap.keySet();
		// ������¼��
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
					// ������X�µļ�¼
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
						throw new Exception("������"+wayid+"�� starlevel �ֶ�Ϊ��");
					}
					mrParam.set_se_cityid(user.getCityid());
					mrParam.set_se_brand(brand);
					mrParam.set_ne_starlevel(starlevel);
					
					mrParam.set_ne_effective("1");
					mrParam.set_pagesize("0");
					mrParam.setDataOnly(true);
					DataPackage mrDp = mrBo.doQuery(mrParam);
					List<MonamtchgruleVO> mrList = new ArrayList<MonamtchgruleVO>(mrDp.getDatas());
					// ��������Ĭ��Ϊ1������޲�ѯ�����Ĭ�϶�������Ϊ1�����ݷ������V1.32��
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
						exSb.append("���� : "+wayid+" ��ǰ").append(monthCount+" ���� ");
						for(int i=0;i<months.length;i++) {
							exSb.append(months[i]+" ");
						}
						exSb.append("��û�ж���"+brand);
						throw new Exception(exSb.toString());
					}
					// X���µ�ƽ��������
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
					// ����X��,����Ϊ�ú����̴ӿ�ʼ��������X��
					// ��Ŀ���·ݵ����¿ɶ�����Ϊ׼
					miParam.set_se_month(months[0]);
					miParam.set_se_wayid(wayid);
					miParam.set_se_brand(brand);
					miParam.set_pagesize("0");
					miParam.setDataOnly(true);
					DataPackage miDp = miBo.doQuery(miParam);
					List<MonorderinfoVO> miList = new ArrayList<MonorderinfoVO>(miDp.getDatas());
					if(miList.size() <= 0 ) {
						throw new Exception("���� : "+wayid+" �� �ϸ��£�"+months[0]+" û�ж��� " +brand);
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
				log.error("error in :"+" wayid: "+wayid+" brand: "+brand+" �����·�|ƽ��������: "+value);
			}
		}
		log.info("��������("+destMonth+")���������ݣ�"+newCount+"��;");
	}

	public void doProcess(String destMonth) throws Exception {
		log.info("**************************monthOrderCalculate begin*********************");
		this.doUpdateLMOrderAndActive(destMonth);
		// ��������ʵ�ʶ������ͼ������ĸ��²�����ͬ�������ݿ�
		SessionUtils.currentSession().flush();
		
		this.doDeleteMonthOrder(destMonth);
		this.doCreateMonthOrder(destMonth);
		log.info("**************************monthOrderCalculate end*********************");
	}

}
