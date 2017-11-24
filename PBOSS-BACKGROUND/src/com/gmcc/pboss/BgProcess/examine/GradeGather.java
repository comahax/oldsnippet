package com.gmcc.pboss.BgProcess.examine;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.examine.gradegather.GradeGatherBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * ���˷�������
 * @author wefrogll
 * @version 1.0 2009-11-30
 */
public class GradeGather extends BgBase {
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		try{
			System.out.println("=================process start===========================");
			String stateTime = null;//�������� Ĭ�ϵ�ǰʱ����ϸ���
			GradeGather gradeGather = new GradeGather();
			boolean isPass = gradeGather.checkArgs(args);
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
			User user = gradeGather.getUser(args[0]);
			// ����hibernate�����ļ�·���������class path��·����
			gradeGather.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/examine/hibernate.cfg.xml");
			// ���ø��Ի������ļ�·���������class path��·����
//			gradeGather.setMyProfilePath("/examine_gradegather.properties");
			// ��ʼ��
			gradeGather.init(args);
			GradeGatherBO gradeGatherBO = (GradeGatherBO)BOFactory.build(GradeGatherBO.class,user);
			gradeGatherBO.process(stateTime);
			System.out.println("=================process end==========================="+(System.currentTimeMillis()-start)/1000);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("=================process end==========================="+(System.currentTimeMillis()-start)/1000);
		}
	} 
	
	public void process(String cityID) throws Exception{

	}
}
