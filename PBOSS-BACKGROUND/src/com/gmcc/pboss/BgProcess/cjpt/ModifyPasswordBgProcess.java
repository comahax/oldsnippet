package com.gmcc.pboss.BgProcess.cjpt;

import java.util.Iterator;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.BgCommonBase;
import com.gmcc.pboss.business.channel.ctilog.CtilogDBParam;
import com.gmcc.pboss.business.channel.ctilog.CtilogVO;
import com.gmcc.pboss.control.channel.ctilog.Ctilog;
import com.gmcc.pboss.control.channel.ctilog.CtilogBO;
import com.gmcc.pboss.control.service.sms.modifypassword.SMSModifyPasswordPr;
import com.gmcc.pboss.control.service.sms.modifypassword.SMSModifyPasswordPrBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
/**
 * ������ƽ̨���������޸ġ������ӿ��߼�
 * @author Yedaoe
 *
 */
public class ModifyPasswordBgProcess extends BgCommonBase {
	
	private static Logger logger = Logger.getLogger(ModifyPasswordBgProcess.class);
	
	/**
	 * @param args 
	 */
	public static void main(String[] args) throws Exception{

		ModifyPasswordBgProcess action = new ModifyPasswordBgProcess();
		boolean isPass = action.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser
		User user = action.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		action.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/cjpt/hibernate.cfg.xml");
		action.setHibernateCommonConfigPath("/com/gmcc/pboss/BgProcess/cjpt/hibernate_bg.hbm.xml");
		action.setMyProfilePath("/cjpt/modifyPassword.properties");
		// ��ʼ��
		action.init(args);
		
		action.modifyPassword(user);
		
	}
	
	private void modifyPassword(User user) throws Exception {
		try {
			String sleeptimesecond = properties.getProperty("sleeptimesecond");
			if(sleeptimesecond == null || "".equals(sleeptimesecond)){
				sleeptimesecond = "60";
			}
			Long sleeptimesecond_Long = Long.parseLong(sleeptimesecond);
			
			String pagesize = properties.getProperty("pagesize");
			
			Ctilog ctilog = (Ctilog)BOFactory.build(CtilogBO.class, user);
			CtilogDBParam ctiparam = new CtilogDBParam();
			ctiparam.set_ne_smstype("2");//�����޸�
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
						try {
							CtilogVO vo = (CtilogVO)it.next();
							String mobile = vo.getMobile();
							String cityid = vo.getCityid();
							String scontent = vo.getScontent();
							
							user.setCityid(cityid);
							SMSModifyPasswordPr bo = (SMSModifyPasswordPr) BOFactory.build(
									SMSModifyPasswordPrBO.class, user);
							
							logger.info("=============�����ֻ���Ϊ��"+mobile+"����ʼ  ==========");
							bo.doModifyPassword(mobile, cityid, scontent);
							
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
