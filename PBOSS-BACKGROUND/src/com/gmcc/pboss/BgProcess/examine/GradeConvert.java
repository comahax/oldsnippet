package com.gmcc.pboss.BgProcess.examine;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Transaction;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.examine.gradeconvert.GradeConvertBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * ����ϵ��ת
 * @author wefrogll
 * @version 1.0 2009-12-1
 */
public class GradeConvert  extends BgBase {
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		try{
			System.out.println("=================process start===========================");
			String stateTime = null;//�������� Ĭ�ϵ�ǰʱ����ϸ���
			GradeConvert gradeConvert = new GradeConvert();
			boolean isPass = gradeConvert.checkArgs(args);
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
			User user = gradeConvert.getUser(args[0]);
			// ����hibernate�����ļ�·���������class path��·����
			gradeConvert.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/examine/hibernate.cfg.xml");
			// ���ø��Ի������ļ�·���������class path��·����
//			gradeConvert.setMyProfilePath("/examine_gradeconvert.properties");
			// ��ʼ��
			gradeConvert.init(args);
			
			GradeConvertBO gradeConvertBO = (GradeConvertBO)BOFactory.build(GradeConvertBO.class,user);
			gradeConvertBO.process(stateTime);
			System.out.println("=================process end==========================="+(System.currentTimeMillis()-start)/1000);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("=================process end==========================="+(System.currentTimeMillis()-start)/1000);
		}
	} 
	
}
