package com.gmcc.pboss.BgProcess.sales.bgHandle;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.Adpaysum.AdpaysumBg;
import com.gmcc.pboss.control.sales.bgcontrol.Adpaysum.AdpaysumBgBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.ui.User;

/**
 * [���ʶ�������] ��̨�߼�
 * @author zsw
 *
 */
public class AdpaysumBgProcess extends BgBase {

	public static void main(String[] args) throws Exception{
		AdpaysumBgProcess pro = new AdpaysumBgProcess();
		boolean isPass = pro.checkArgs(args);
		if(!isPass) {
			return;
		}
		// ��ȡUser
		User user = pro.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		pro.setMyProfilePath("/sales/bgHandle/adpaysum.properties");
		// ��ʼ��
		pro.init(args);
		pro.adpaysum(args, user);
	}	
	/**
	 * �������
	 */
	protected boolean checkArgs(String[] args) {
		if (args.length != 1 && args.length != 3) { // ��������ֻ����1 ���� 3
			System.out.println(getHelp());
			return false;
		}
		if (!CityMappingUtil.contain(args[0])) {
			System.out.println("cityid is not exist");
			return false;
		}
		if(args.length > 1 && !PublicUtils.checkDateTime(2, args[1])) {
			System.out.println("format of second parameter (date) : yyyy-MM-dd");
			return false;
		}
		if(args.length > 1 && !args[2].matches("([0-9]|[1][0-9]|[2][0-3])-([0-9]|[1][0-9]|[2][0-3])")) {
			System.out.println("the third parameter must be [x-y] :");
			System.out.println("x,y represent hour,they both are between 0 and 23,including 0 and 23");
			return false;
		}
		return true;
	}
	
	protected static String getHelp() {
		StringBuffer sb = new StringBuffer();
		sb.append("Explain of args:").append("\n");
		sb.append("the args number is 1 or 3").append("\n");
		sb.append("[cityid] or [cityid][date][x-y] : ").append("\n");
		sb.append("(the format of \"date\" is yyyy-MM-dd)").append("\n");
		sb.append("(x,y represent hour,so they both are between 0 and 23,including 0 and 23)").append("\n");
		sb.append("e.g. [ZS] or [ZS][2010-04-28][9-14]");
		return sb.toString();
	}
	
	public void adpaysum(String[] args,User user) throws Exception {
		AdpaysumBg bgBO = (AdpaysumBg)BOFactory.build(AdpaysumBgBO.class, user);
		try {
			bgBO.doProcess2(args);
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}
}
