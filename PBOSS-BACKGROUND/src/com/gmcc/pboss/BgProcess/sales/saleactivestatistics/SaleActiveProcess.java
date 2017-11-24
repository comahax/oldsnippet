package com.gmcc.pboss.BgProcess.sales.saleactivestatistics;

import java.util.Date;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.common.utils.tools.DateUtil;
import com.gmcc.pboss.common.utils.tools.DateUtil.DateFormatType;
import com.gmcc.pboss.common.utils.tools.DateUtil.DateOperationType;
import com.gmcc.pboss.common.utils.tools.DateUtil.TimeFormatType;
import com.gmcc.pboss.control.sales.bgcontrol.saleactivestatistics.SaleActiveStatistics;
import com.gmcc.pboss.control.sales.bgcontrol.saleactivestatistics.SaleActiveStatisticsBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.ui.User;

public class SaleActiveProcess extends BgBase {

private static Logger log = Logger.getLogger(SaleActiveProcess.class);
	
	public static void main(String[] args){
		SaleActiveProcess saleActiveStatisticsProcess = new SaleActiveProcess();
		
		/* --����4������ͨ�õķ���������ī�سɹ棬�������������Ļ�����д���漸������--------- */
		// ������
		boolean isPass = saleActiveStatisticsProcess.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser
		User user = saleActiveStatisticsProcess.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		saleActiveStatisticsProcess.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/saleactivestatistics/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		saleActiveStatisticsProcess.setMyProfilePath("/sales/bgHandle/saleactive.properties");
		// ��ʼ��
		try {
			saleActiveStatisticsProcess.init(args);
			
			/* ------------------------------------------------------------------------------- */
			log.info("=========�����������ռ�����=====��ʼ����ɣ���ʼ����==========");
			
			String starttime = null;
			String endtime = null;
			
			// ��ʼ����
			if(args.length == 3){
				starttime = args[1];
//				log.info("starttime = "+starttime);
				endtime = args[2]; 
//				log.info("endtime = "+endtime);
			}else{
				Date Afdate = DateUtil.operationDateOfDay(DateUtil.getCurrentDate(),1,DateOperationType.DIFF);
				int year = DateUtil.getTime(Afdate,TimeFormatType.YEAR);
				int month = DateUtil.getTime(Afdate,TimeFormatType.MONTH);
				int day = DateUtil.getTime(Afdate,TimeFormatType.DAY);
				
				starttime = year+"-"+month+"-"+day+" 00:00:00";
				endtime = year+"-"+month+"-"+day+" 23:59:59";
			}
			saleActiveStatisticsProcess.process(user,starttime,endtime);
			
			log.info("======�����������ռ�����========������ɣ������˳�===========");
			
		} catch (Exception e) {e.printStackTrace();
			log.error(e);
			log.error("=====�����������ռ�����=========�쳣�˳�===============\n"+e.getMessage());
		}
	}
	
	
	protected boolean checkArgs(String[] args) {
		
		if(args.length != 1 && args.length != 3){
			System.out.println("���������������");
			return false;
		}
		if(args.length == 3){
			try {
				PublicUtils.UtilStrToDate(args[1]);
				PublicUtils.UtilStrToDate(args[2]);
			} catch (Exception e) {
				System.out.println("�������ڸ�ʽ����");
				return false;
			}
		}
		
		if (args.length < 1) {
			System.out.println(getHelp());
			return false;
		}
		if (!CityMappingUtil.contain(args[0])) {
			System.out.println("cityid is not exist");
			return false;
		}
		return true;
	}
	
	private void process(DBAccessUser user,String starttime,String endtime) throws Exception{
		SaleActiveStatistics saleActiveStatistics = (SaleActiveStatisticsBO) BOFactory.build(SaleActiveStatisticsBO.class, user);
		//�׿��ռ�
//		try{
//			//ͬ��֮ǰ��ɾ��ͬһ������ݣ���ֹ�����ظ�
//			saleActiveStatistics.doDelComressProcess(starttime,endtime);
//			
//			saleActiveStatistics.doComressProcess(starttime,endtime);
//			//ZS "2014-06-07 00:00:00" "2014-06-10 23:59:59"
//		} catch(Exception e){
//			log.error(e.getMessage());
//		}
//		
//		
//		//��ֵ���ռ�
//		try{
//			//ͬ��֮ǰ��ɾ��ͬһ������ݣ���ֹ�����ظ�
//			saleActiveStatistics.doDelComrescardProcess(starttime, endtime);
//			
//			saleActiveStatistics.doComrescardProcess(starttime, endtime);
//			//ZS "2014-06-27 00:00:00" "2014-06-27 23:59:59"
//		} catch(Exception e){
//			log.error(e.getMessage());
//		}
		
		
		//���������ռ�
		try{
			//ͬ��֮ǰ��ɾ��ͬһ������ݣ���ֹ�����ظ�
			saleActiveStatistics.doDelActiveProcess(starttime, endtime);
			
			saleActiveStatistics.doActiveProcess(starttime, endtime);
			//ZS "2014-04-25 00:00:00" "2014-04-25 23:59:59"
		} catch(Exception e){
			log.error(e.getMessage());
		}
	}

}
