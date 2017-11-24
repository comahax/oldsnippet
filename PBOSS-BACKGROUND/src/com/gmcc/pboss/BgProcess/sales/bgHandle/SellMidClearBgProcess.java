package com.gmcc.pboss.BgProcess.sales.bgHandle;

import java.util.Calendar;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.SellMidClear.SellMidClear;
import com.gmcc.pboss.control.sales.bgcontrol.SellMidClear.SellMidClearBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * ���������� ��BOSS���ڹ����������Ʒ�����м���������ɾ������ʱ�䳬��ָ�����������ݡ�
 * @author zhangsiwei
 *
 */
public class SellMidClearBgProcess extends BgBase {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{

		SellMidClearBgProcess pro = new SellMidClearBgProcess();
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser
		User user = pro.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		pro.setMyProfilePath("/sales/bgHandle/sellMidClear.properties");
		// ��ʼ��
		pro.init(args);
		pro.clearSellMid(args[0], user);
		
	}
	
	public void clearSellMid(String arg1,User user) throws Exception {
		try {
			log.info("===========��ʼ���������Ʒ�����м��=========");
			String keepDays = properties.getProperty(arg1+"_keepdays");
			
			if(StringUtils.isEmpty(keepDays)) {
				// ������������������Ĭ��Ϊ30��
				keepDays = "30";
			}else {
				if(!PublicUtils.isInteger(keepDays) || Integer.parseInt(keepDays) < 0) {
					throw new BusinessException("������ʱ�������"+arg1+"_keepdays ����Ϊ������");
				}
			}
			Calendar now = Calendar.getInstance();
			now.set(Calendar.HOUR_OF_DAY, 0);
			now.set(Calendar.MINUTE, 0);
			now.set(Calendar.SECOND, 0);
			now.add(Calendar.DAY_OF_MONTH, -Integer.parseInt(keepDays));
			
			SellMidClear smcBo = (SellMidClear)BOFactory.build(SellMidClearBO.class,user);
			smcBo.doProcess(now.getTime());
			log.info("===========������������Ʒ�����м��=========");
		}catch(BusinessException ex) {
			log.info(ex.getMessage());
			log.info("===========�����쳣��δ������������Ʒ�����м��=========");
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
			log.info("===========�����쳣��δ������������Ʒ�����м��=========");
		}
	}

	@Override
	protected boolean checkArgs(String[] args) {
		if (args.length < 1 || !"BOSSCOMMON".equals(args[0])) {
			System.out.println(getHelp());
			return false;
		}
		return true;
	}
	
	protected static String getHelp() {
		StringBuffer sb = new StringBuffer();
		sb.append("Explain of args:").append("\n");
		sb.append("the args number is 1").append("\n");
		sb.append("[cityid] must be [BOSSCOMMON]" ).append("\n");
		return sb.toString();
	} 

}
