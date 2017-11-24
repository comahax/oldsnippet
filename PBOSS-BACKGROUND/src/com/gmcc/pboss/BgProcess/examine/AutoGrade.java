package com.gmcc.pboss.BgProcess.examine;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.examine.autograde.AutogradeBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;


/**
 * �Զ�����
 * @author wefrogll
 * @version 1.0 2009-11-30
 */
public class AutoGrade  extends BgBase {

	public static void main(String[] args){
	long start = System.currentTimeMillis();
		try{
			System.out.println("=================process start===========================");
			
			String stateTime = null;//�������� Ĭ�ϵ�ǰʱ����ϸ���
			AutoGrade autoGrade = new AutoGrade();
			boolean isPass = autoGrade.checkArgs(args);
			if (!isPass) {
				return;
			}
			
//			1.	������ڴ���Ϊ�����б�ʶ���������£����û�С��������¡����Σ���ȡ�����������µ���һ���£���
			SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
			if(args.length<2)
			{
				Calendar nowDate = Calendar.getInstance();
				nowDate.add(Calendar.MONTH, -1);
				stateTime = format.format(nowDate.getTime());
			}else{
				try{
					format.parse(args[1]);
				}catch(Exception e){
					System.out.println("===============��������������["+args[1]+"]  ��ʽ ����ȷ��yyyyMM)");
					return;
				}
				stateTime = args[1];
			}
			// ��ȡUser
			User user = autoGrade.getUser(args[0]);
			// ����hibernate�����ļ�·���������class path��·����
			autoGrade.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/examine/hibernate.cfg.xml");
			// ���ø��Ի������ļ�·���������class path��·����
			autoGrade.setMyProfilePath("/examine/examine_autograde.properties");
			// ��ʼ��
			autoGrade.init(args);
			AutogradeBO autogradeBO = (AutogradeBO)BOFactory.build(AutogradeBO.class,user);
			autogradeBO.process(stateTime);
			System.out.println("=================process end==========================="+(System.currentTimeMillis()-start)/1000);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("=================process end==========================="+(System.currentTimeMillis()-start)/1000);
		}
	} 
	

}
