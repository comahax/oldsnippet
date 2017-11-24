package com.gmcc.pboss.BgProcess.sales.bgHandle;



import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.SMPMonthOrderCalc.SMPMonthOrderCalc;
import com.gmcc.pboss.control.sales.bgcontrol.SMPMonthOrderCalc.SMPMonthOrderCalcBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.ui.User;
/**
 * <pre>
 * [�������׿��¶���������]��̨�����߼�
 * ���������� �����׿�������������Ժ������¶��������м��㡣
 * </pre>
 * @author zhangsiwei
 *
 */
public class SMPMonthOrderCalcBgProcess extends BgBase {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{

		SMPMonthOrderCalcBgProcess pro = new SMPMonthOrderCalcBgProcess();
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser
		User user = pro.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		pro.setMyProfilePath("/sales/bgHandle/monOrderCalc.properties");
		// ��ʼ��
		pro.init(args);
		// ��ָ��Ŀ���·�
		if(args.length < 2) {
			pro.monthOrderCalculate(null, user);
		}else {
			// ��ָ��Ŀ���·ݣ������õڶ�������ΪĿ���·ݵ�ֵ ����ʽΪ"yyyyMM"
			pro.monthOrderCalculate(args[1], user);
		}
	}
	
	public void monthOrderCalculate(String destMonth,User user) throws Exception {
		
		SMPMonthOrderCalc mocBo = (SMPMonthOrderCalcBO)BOFactory.build(SMPMonthOrderCalcBO.class,user);
		try {
			mocBo.doProcess(destMonth);
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}

	@Override
	protected boolean checkArgs(String[] args) {
		
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
	
	protected static String getHelp() {
		StringBuffer sb = new StringBuffer();
		sb.append("Explain of args:").append("\n");
		sb.append("the args number is 1 or 2").append("\n");
		sb.append("[cityid] or [cityid][destmonth] (the format of \"destMonth\" is yyyyMM)").append("\n");
		sb.append("e.g. [ZS] or [ZS][200910]");
		return sb.toString();
	}


}
