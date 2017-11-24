package com.gmcc.pboss.BgProcess.cjpt;

import java.util.Iterator;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.BgCommonBase;
import com.gmcc.pboss.business.channel.ctilog.CtilogDBParam;
import com.gmcc.pboss.business.channel.ctilog.CtilogVO;
import com.gmcc.pboss.control.channel.ctilog.Ctilog;
import com.gmcc.pboss.control.channel.ctilog.CtilogBO;
import com.gmcc.pboss.control.service.sms.querybusicountformanager.SMSQueryBusiCountForManagerPr;
import com.gmcc.pboss.control.service.sms.querybusicountformanager.SMSQueryBusiCountForManagerPrBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
/**
 * ��������������ҵ������ѯ�������ӿ��߼�
 * @author Jerimy
 *
 */
public class QueryBusiCountForManagerBgProcess extends BgCommonBase {
	private static Logger logger = Logger.getLogger(QueryBusiCountForManagerBgProcess.class);
	
	public static void main(String[] args) throws Exception{

		QueryBusiCountForManagerBgProcess action = new QueryBusiCountForManagerBgProcess();
		boolean isPass = action.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser
		User user = action.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		action.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/cjpt/hibernate.cfg.xml");
		action.setHibernateCommonConfigPath("/com/gmcc/pboss/BgProcess/cjpt/hibernate_bg.hbm.xml");
		action.setMyProfilePath("/cjpt/queryBusiCountForManager.properties");
		// ��ʼ��
		action.init(args);
		action.queryBusiCountForManager(user);
		
	}
	
	private void queryBusiCountForManager(User user) throws Exception {
		try {
			String sleeptimesecond = properties.getProperty("sleeptimesecond");
			if(sleeptimesecond == null || "".equals(sleeptimesecond)){
				sleeptimesecond = "60";
			}
			Long sleeptimesecond_Long = Long.parseLong(sleeptimesecond);
			
			String pagesize = properties.getProperty("pagesize");
			
			SMSQueryBusiCountForManagerPr bo = (SMSQueryBusiCountForManagerPr) BOFactory.build(
					SMSQueryBusiCountForManagerPrBO.class, user);
			Ctilog ctilog = (Ctilog)BOFactory.build(CtilogBO.class, user);
			CtilogDBParam ctiparam = new CtilogDBParam();
			ctiparam.set_ne_smstype("5");//�����ѯ
			ctiparam.set_snn_cityid("");//cityid��Ϊ��
			ctiparam.set_pagesize(pagesize);
			ctiparam.set_orderby("cityid");
			while(1==1){
				DataPackage dp = ctilog.doQuery(ctiparam);
				if (null==dp || dp.getDatas().size()==0){
					logger.info("=============���ߣ�"+sleeptimesecond_Long+"��  ==========");
					Thread.sleep(1000*sleeptimesecond_Long);
					continue;
				}else{
					for (Iterator it = dp.getDatas().iterator(); it.hasNext();) {
						try{
							CtilogVO vo = (CtilogVO)it.next();
							String mobile = vo.getMobile();
							String cityid = vo.getCityid();
							String scontent = vo.getScontent();
							
							user.setCityid(cityid);
							bo = (SMSQueryBusiCountForManagerPr) BOFactory.build(
									SMSQueryBusiCountForManagerPrBO.class, user);
							
							logger.info("=============�����ֻ���Ϊ��"+mobile+"����ʼ  ==========");
							bo.doQueryBusiCountForManager(mobile, cityid,scontent);
							
							ctilog.doRemoveByVO(vo);
							logger.info("=============�����ֻ���Ϊ��"+mobile+"������  ==========");
						} catch (Exception e) {
							e.printStackTrace();
							logger.error(e.getMessage());
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

}
