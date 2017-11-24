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
 * 分数系数转
 * @author wefrogll
 * @version 1.0 2009-12-1
 */
public class GradeConvert  extends BgBase {
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		try{
			System.out.println("=================process start===========================");
			String stateTime = null;//处理年月 默认当前时间的上个月
			GradeConvert gradeConvert = new GradeConvert();
			boolean isPass = gradeConvert.checkArgs(args);
			if (!isPass) {
				return;
			}
//			1.	程序入口传参为：地市标识、处理年月（如果没有“处理年月”传参，则取程序运行年月的上一个月）；
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
					System.out.println("===============参数：处理年月["+args[1]+"]  格式 不正确（yyyyMM)");
					return;
				}
				stateTime = args[1];
			}
			// 获取User
			User user = gradeConvert.getUser(args[0]);
			// 设置hibernate配置文件路径（相对于class path的路径）
			gradeConvert.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/examine/hibernate.cfg.xml");
			// 设置个性化配置文件路径（相对于class path的路径）
//			gradeConvert.setMyProfilePath("/examine_gradeconvert.properties");
			// 初始化
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
