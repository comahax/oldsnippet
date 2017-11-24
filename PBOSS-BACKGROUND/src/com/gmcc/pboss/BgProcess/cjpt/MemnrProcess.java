package com.gmcc.pboss.BgProcess.cjpt;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.BgCommonBase;
import com.gmcc.pboss.business.channel.ctilog.CtilogDBParam;
import com.gmcc.pboss.business.channel.ctilog.CtilogVO;
import com.gmcc.pboss.control.channel.ctilog.Ctilog;
import com.gmcc.pboss.control.channel.ctilog.CtilogBO;
import com.gmcc.pboss.control.service.sms.modifypassword.SMSModifyPasswordPr;
import com.gmcc.pboss.control.service.sms.modifypassword.SMSModifyPasswordPrBO;
import com.gmcc.pboss.control.service.sms.querybusicountforemployee.SMSQueryBusiCountForEmployeePr;
import com.gmcc.pboss.control.service.sms.querybusicountforemployee.SMSQueryBusiCountForEmployeePrBO;
import com.gmcc.pboss.control.service.sms.querybusicountformanager.SMSQueryBusiCountForManagerPr;
import com.gmcc.pboss.control.service.sms.querybusicountformanager.SMSQueryBusiCountForManagerPrBO;
import com.gmcc.pboss.control.service.sms.querybusicountfornet.SMSQueryBusiCountForNetPr;
import com.gmcc.pboss.control.service.sms.querybusicountfornet.SMSQueryBusiCountForNetPrBO;
import com.gmcc.pboss.control.service.sms.resetpassword.SMSResetPasswordPr;
import com.gmcc.pboss.control.service.sms.resetpassword.SMSResetPasswordPrBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class MemnrProcess extends BgCommonBase {
	private static Logger logger = Logger.getLogger(ResetPasswordBgProcess.class);
	
	public static void main(String[] args) throws Exception{

		MemnrProcess action = new MemnrProcess();
		boolean isPass = action.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser
		User user = action.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		action.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/cjpt/hibernate.cfg.xml");
		action.setHibernateCommonConfigPath("/com/gmcc/pboss/BgProcess/cjpt/hibernate_bg.hbm.xml");
		action.setMyProfilePath("/cjpt/MemnrProcess.properties");
		// ��ʼ��
		action.init(args);
		action.doProcess(user);
		
	}
	
	private void doProcess(User user) throws Exception {
		try {
			String sleeptimesecond = properties.getProperty("sleeptimesecond");
			if(sleeptimesecond == null || "".equals(sleeptimesecond)){
				sleeptimesecond = "60";
			}
			Long sleeptimesecond_Long = Long.parseLong(sleeptimesecond);			
			String pagesize = properties.getProperty("pagesize");
			
			Ctilog ctilog = (Ctilog)BOFactory.build(CtilogBO.class, user);
			CtilogDBParam ctiparam = new CtilogDBParam();
			ArrayList<Short> _nin_smstype = new ArrayList<Short>();
			_nin_smstype.add(Short.parseShort("1"));//��������
			_nin_smstype.add(Short.parseShort("2"));//�����޸�
			_nin_smstype.add(Short.parseShort("3"));//��Ա��ѯ
			_nin_smstype.add(Short.parseShort("4"));//�����ѯ
			_nin_smstype.add(Short.parseShort("5"));//�����ѯ
			ctiparam.set_nin_smstype(_nin_smstype);
			
			ctiparam.set_snn_cityid("");//cityid��Ϊ��
			String cityList = properties.getProperty("cityList");
			String cl[] = cityList.split("\\|");
			ArrayList tmp = new ArrayList();
			for(int i=0; i<cl.length ; i++){
				if(cl[i] != null && !"".equals(cl[i])){
					tmp.add(cl[i]);
				}
			}
			ctiparam.set_sin_cityid(tmp);
			
			ctiparam.set_pagesize(pagesize);
			ctiparam.set_orderby("oprtime");
			while(1==1){
				DataPackage dp = ctilog.doQuery(ctiparam);
				if (null==dp || dp.getDatas().size()==0){
					logger.info("=============���ߣ�"+sleeptimesecond_Long+"��  ==========");
					Thread.sleep(1000*sleeptimesecond_Long);
					continue;
				}else{
					for (Iterator it = dp.getDatas().iterator(); it.hasNext();) {
						CtilogVO vo = null;
						Short dealTypeShort = -1;
						vo = (CtilogVO)it.next();
						String mobile = vo.getMobile();
						String cityid = vo.getCityid();
						String scontent = vo.getScontent();
						try {
							Short smstype = vo.getSmstype();
							
							user.setCityid(cityid);
							if(smstype == 1){//��������
								dealTypeShort = 1;
								logger.info("=====��������========smstype��"+smstype+"����ʼ  ==========");
								resetPassword(user,mobile,cityid,scontent);
								logger.info("=======��������======smstype��"+smstype+"������  ==========");
							}else if(smstype == 2){//�����޸�
								dealTypeShort = 2;
								logger.info("=======�����޸�======smstype��"+smstype+"����ʼ  ==========");
								modifyPassword(user,mobile,cityid,scontent);
								logger.info("=======�����޸�======smstype��"+smstype+"������  ==========");
							}else if(smstype == 3){//��Ա��ѯ
								dealTypeShort = 3;
								logger.info("=======��Ա��ѯ======smstype��"+smstype+"����ʼ  ==========");
								queryBusiCountForEmployee(user,mobile,cityid,scontent);
								logger.info("=======��Ա��ѯ======smstype��"+smstype+"������  ==========");
							}else if(smstype == 4){//�����ѯ
								dealTypeShort = 4;
								logger.info("========�����ѯ=====smstype��"+smstype+"����ʼ  ==========");
								queryBusiCountForNet(user,mobile,cityid,scontent);
								logger.info("========�����ѯ=====smstype��"+smstype+"������  ==========");
							}else if(smstype == 5){//�����ѯ
								dealTypeShort = 5;
								logger.info("========�����ѯ=====smstype��"+smstype+"����ʼ  ==========");
								queryBusiCountForManager(user,mobile,cityid,scontent);
								logger.info("========�����ѯ=====smstype��"+smstype+"������  ==========");
							}
						}catch (Exception e) {
							String templateid = "�����ڲ��쳣��δ���ж��ţ�";
							if(dealTypeShort == 1){
								SMSResetPasswordPr bo = (SMSResetPasswordPr) BOFactory.build(
										SMSResetPasswordPrBO.class, user);
								bo.doRecordSmshisAndReturnSuccVal(mobile, cityid, templateid);
							}else if(dealTypeShort == 2){
								SMSModifyPasswordPr bo = (SMSModifyPasswordPr) BOFactory.build(
										SMSModifyPasswordPrBO.class, user);
								bo.doRecordSmshisAndReturnSuccVal(mobile, cityid, scontent, templateid);
							}else if(dealTypeShort == 3){
								SMSQueryBusiCountForEmployeePr bo = (SMSQueryBusiCountForEmployeePr) BOFactory.build(
										SMSQueryBusiCountForEmployeePrBO.class, user);
								bo.doRecordSmshisAndReturnSuccVal(mobile, cityid, scontent, templateid, new Short("1"));
							}else if(dealTypeShort == 4){
								SMSQueryBusiCountForNetPr bo = (SMSQueryBusiCountForNetPr) BOFactory.build(
										SMSQueryBusiCountForNetPrBO.class, user);
								bo.doRecordSmshisAndReturnSuccVal(mobile, cityid, scontent, templateid, new Short("1"));
							}else if(dealTypeShort == 5){
								SMSQueryBusiCountForManagerPr bo = (SMSQueryBusiCountForManagerPr) BOFactory.build(
										SMSQueryBusiCountForManagerPrBO.class, user);
								bo.doRecordSmshisAndReturnSuccVal(mobile, cityid, scontent, templateid, new Short("1"));
							}
							e.printStackTrace();
							logger.error(e.getMessage());
						}finally{
							ctilog.doRemoveByVO(vo);
						}
					}
				}
			}
			
		}catch(BusinessException ex) {
			ex.printStackTrace();
			logger.info(ex.getMessage());
		}catch(Exception ex) {
			ex.printStackTrace();
			LoggerUtils.error(ex, logger);
		}
	}
	
	private void resetPassword(User user,String mobile,String cityid,
			String scontent) throws Exception {
		SMSResetPasswordPr bo = (SMSResetPasswordPr) BOFactory.build(
				SMSResetPasswordPrBO.class, user);
		
		logger.info("=============�����ֻ���Ϊ��"+mobile+"����ʼ  ==========");
		bo.doResetPassword(mobile, cityid);
		
		logger.info("=============�����ֻ���Ϊ��"+mobile+"������  ==========");
	}
	
	private void modifyPassword(User user,String mobile,String cityid,
			String scontent) throws Exception {
		SMSModifyPasswordPr bo = (SMSModifyPasswordPr) BOFactory.build(
				SMSModifyPasswordPrBO.class, user);
		
		logger.info("=============�����ֻ���Ϊ��"+mobile+"����ʼ  ==========");
		bo.doModifyPassword(mobile, cityid, scontent);
		
		logger.info("=============�����ֻ���Ϊ��"+mobile+"������  ==========");
	}
	
	private void queryBusiCountForEmployee(User user,String mobile,String cityid,
			String scontent) throws Exception {
		SMSQueryBusiCountForEmployeePr bo = (SMSQueryBusiCountForEmployeePr) BOFactory.build(
				SMSQueryBusiCountForEmployeePrBO.class, user);
		
		logger.info("=============�����ֻ���Ϊ��"+mobile+"����ʼ  ==========");
		bo.doQueryBusiCountForEmployee(mobile, cityid,scontent);
		
		logger.info("=============�����ֻ���Ϊ��"+mobile+"������  ==========");
	}
	
	private void queryBusiCountForNet(User user,String mobile,String cityid,
			String scontent) throws Exception {
		SMSQueryBusiCountForNetPr bo = (SMSQueryBusiCountForNetPr) BOFactory.build(
				SMSQueryBusiCountForNetPrBO.class, user);
		
		logger.info("=============�����ֻ���Ϊ��"+mobile+"����ʼ  ==========");
		bo.doQueryBusiCountForNet(mobile, cityid,scontent);
		
		logger.info("=============�����ֻ���Ϊ��"+mobile+"������  ==========");
	}
	
	private void queryBusiCountForManager(User user,String mobile,String cityid,
			String scontent) throws Exception {
		SMSQueryBusiCountForManagerPr bo = (SMSQueryBusiCountForManagerPr) BOFactory.build(
				SMSQueryBusiCountForManagerPrBO.class, user);
		
		logger.info("=============�����ֻ���Ϊ��"+mobile+"����ʼ  ==========");
		bo.doQueryBusiCountForManager(mobile, cityid,scontent);
		
		logger.info("=============�����ֻ���Ϊ��"+mobile+"������  ==========");
	}
}
