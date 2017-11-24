package com.gmcc.pboss.control.sales.bgcontrol.ActiveNumberImport;

import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.sales.actfilerec.ActfilerecDBParam;
import com.gmcc.pboss.business.sales.bgbusiness.ActiveNumberImport.ActiveNumberImportDAO;
import com.gmcc.pboss.business.sales.bgbusiness.SMPActiveRateCalc.SMPActiveRateCalcDAO;
import com.gmcc.pboss.control.sales.actfilerec.Actfilerec;
import com.gmcc.pboss.control.sales.actfilerec.ActfilerecBO;
import com.gmcc.pboss.web.common.webservice.CRMServiceforback;
import com.gmcc.pboss.web.common.webservice.ICRMServiceforback;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class ActiveNumberImportBO extends AbstractControlBean implements
		ActiveNumberImport {

	private Logger log = Logger.getLogger(ActiveNumberImportBO.class);
	/**日期(yyyyMMdd)正则表达式*/
	private static String DATEREGEX = 
		new StringBuffer().
		append("((").
		append("([1-9][0-9]{3})").
		append("(").
			append("((0[13578]|1[02])").append("(0[1-9]|[12][0-9]|3[01]))").  //1 3 5 7 8 10 12月为31天
			append("|").
			append("((0[469]|11)").append("(0[1-9]|[12][0-9]|30))").		//4 6 9 11月为30天
			append("|").
			append("(02").append("(0[1-9]|[1][0-9]|2[0-8]))").	//默认情况下设2月为28天
		append(")").
		append(")").
		append("|").
		append("((([1-9][0-9])(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))").append("02").append("29))") //闰年情况下为29天;
		.toString();   

	public void doProcess(String cityid,String srcpath) throws Exception {
		
		log.info("**************************activePhoneNoImport begin*********************");
		if(srcpath == null) {
			throw new RuntimeException("配置文件中不存在该属性：srcpath, 请核实");
		}
		File dir = new File(srcpath);
		if(!dir.exists()) {
			throw new RuntimeException("该目录不存在: "+srcpath);
		}
		if(!dir.isDirectory()) {
			throw new RuntimeException(srcpath+" 不是一个目录");
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		
//		Date yesterday = cal.getTime();
//		String yesterdayStr = df.format(yesterday);
		// 选择文件名格式为"NOINNET+地市+日期.txt"的文件,如 NOINNETGZ20100216.txt
		
		File[] matchFiles1 = null;
		Actfilerec afBo = (ActfilerecBO)BOFactory.build(ActfilerecBO.class, user,BOFactory.PROPAGATION_REQUIRES_NEW);
		ActfilerecDBParam params = new ActfilerecDBParam();
		ICRMServiceforback service = new CRMServiceforback();
		if(!service.isCRMCityPort(user.getCityid())){//不是crm，就读计费文件和boss表
			matchFiles1 = dir.listFiles(new DirFilter("NOINNET"+cityid+DATEREGEX+"\\.txt"));
			for (int i = 0; matchFiles1 != null && i < matchFiles1.length; i++) {
				try {
					File matchFile = matchFiles1[i];
					String filename = matchFile.getName();
					params.set_se_filename(filename);
					params.set_pagesize("0");
					params.setDataOnly(true);
					DataPackage dp = afBo.doQuery(params);
					Collection datas = dp.getDatas();
					if (datas != null && datas.size() > 0) {
						// 已处理文件检查
						continue;
					} else {
						log.info("开始从激活文件 ["+filename+"] 导入");
						afBo.doHandleFileLines2(matchFile);
						log.info("完成从激活文件 ["+filename+"] 导入");
					}
				}catch(Exception ex) {
					LoggerUtils.error(ex, log);
				}
			}
			//从BOSS库表(CS_REC_RECEPTION)中导入数据
			log.info("开始从BOSS库导入数据");
			Date beginTime = PublicUtils.getFirstTimeOrEndTimeOfDate(0, cal);
			Date endTime = PublicUtils.getFirstTimeOrEndTimeOfDate(0, null);
			String cityno = CityMappingUtil.getCityNo(cityid);
			try {
				int insertRow = this.batchImportDataFromBOSS(cityno, beginTime, endTime);
				log.info("一共从BOSS库导入"+insertRow+"条记录");
				log.info("完成从BOSS库导入数据");
			}catch(Exception ex) {
				LoggerUtils.error(ex, log);
				log.info("出现异常，无法从BOSS库导入数据");
			}
		}else{//如果是crm
			if("CX".equals(service.getCityCRMMark(user.getCityid()))){//从兴CRM,要读计费文件和crm表
				matchFiles1 = dir.listFiles(new DirFilter("NOINNET"+cityid+DATEREGEX+"\\.txt"));
				for (int i = 0; matchFiles1 != null && i < matchFiles1.length; i++) {
					try {
						File matchFile = matchFiles1[i];
						String filename = matchFile.getName();
						params.set_se_filename(filename);
						params.set_pagesize("0");
						params.setDataOnly(true);
						DataPackage dp = afBo.doQuery(params);
						Collection datas = dp.getDatas();
						if (datas != null && datas.size() > 0) {
							// 已处理文件检查
							continue;
						} else {
							log.info("开始从激活文件 ["+filename+"] 导入");
							afBo.doHandleFileLines2(matchFile);
							log.info("完成从激活文件 ["+filename+"] 导入");
						}
					}catch(Exception ex) {
						LoggerUtils.error(ex, log);
					}
				}
				//从crm库表(CS_REC_RECEPTION)中导入数据
				log.info("开始从CRM库导入数据");
				Date beginTime = PublicUtils.getFirstTimeOrEndTimeOfDate(0, cal);
				Date endTime = PublicUtils.getFirstTimeOrEndTimeOfDate(0, null);
				String cityno = CityMappingUtil.getCityNo(cityid);
				try {
					int insertRow = this.batchImportDataFromCRM(cityno, beginTime, endTime);
					log.info("一共从CRM库导入"+insertRow+"条记录");
					log.info("完成从CRM库导入数据");
				}catch(Exception ex) {
					LoggerUtils.error(ex, log);
					log.info("出现异常，无法从CRM库导入数据");
				}
			}else{//"HW" 华为CRM,只读文件，问价格式 NOINNET_JM20120221_CRM.txt
				matchFiles1 = dir.listFiles(new DirFilter("NOINNET_"+cityid+DATEREGEX+"_CRM"+"\\.txt"));
				for (int i = 0; matchFiles1 != null && i < matchFiles1.length; i++) {
					try {
						File matchFile = matchFiles1[i];
						String filename = matchFile.getName();
						params.set_se_filename(filename);
						params.set_pagesize("0");
						params.setDataOnly(true);
						DataPackage dp = afBo.doQuery(params);
						Collection datas = dp.getDatas();
						if (datas != null && datas.size() > 0) {
							// 已处理文件检查
							continue;
						} else {
							log.info("开始从激活文件 ["+filename+"] 导入");
							afBo.doHandleFileLines2(matchFile);
							log.info("完成从激活文件 ["+filename+"] 导入");
						}
					}catch(Exception ex) {
						LoggerUtils.error(ex, log);
					}
				}
			}
			
		}
			
		log.info("开始更新合作商套卡激活数据......");
		int updateRow = this.doCooperatorActiveUpdate();
		log.info("合作商套卡激活数据更新行数: "+updateRow);
		log.info("完成更新合作商套卡激活数据......");
		log.info("**************************activePhoneNoImport end*********************");
	}
	
	public int batchImportDataFromBOSS(String cityno, Date today,
			Date yesterday) throws Exception {
		try {
			ActiveNumberImportDAO dao = (ActiveNumberImportDAO)DAOFactory.build(ActiveNumberImportDAO.class, user);
			return dao.batchImportDataFromBOSS(cityno, today, yesterday,user);
		}catch(Exception ex) {
			throw new JOPException(ex);
		}
	}
	
	public int batchImportDataFromCRM(String cityno, Date today,
			Date yesterday) throws Exception {
		try {
			ActiveNumberImportDAO dao = (ActiveNumberImportDAO)DAOFactory.build(ActiveNumberImportDAO.class, user);
			return dao.batchImportDataFromCRM(cityno, today, yesterday,user);
		}catch(Exception ex) {
			throw new JOPException(ex);
		}
	}

	/*
	 * 合作商套卡激活数据更新
	 */
	public int doCooperatorActiveUpdate() throws Exception {
		try{
			SMPActiveRateCalcDAO dao = (SMPActiveRateCalcDAO) DAOFactory.build(SMPActiveRateCalcDAO.class,user);
			return dao.updateSMPActive(30);
		}catch(Exception e){
			throw new JOPException(e);
		}
	}

	/**
	 * 用于通过正则表达式过滤文件列表的内部类
	 * 
	 * @author zhangsiwei
	 * 
	 */
	private class DirFilter implements FilenameFilter {

		private Pattern pattern;

		public DirFilter(String regex) {
			pattern = Pattern.compile(regex);
		}

		public boolean accept(File dir, String name) {
			return pattern.matcher(name).matches();
		}
	}
	public static void main(String[] args) {
		String fileRegex = "NOINNETZS"+DATEREGEX+"_CRM"+"\\.txt";
		Pattern pattern = Pattern.compile(fileRegex);
		System.out.println(pattern.matcher("NOINNETZS20110228_CRM.txt").matches());
	}
}
