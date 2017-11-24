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
 * 考核分数汇总
 * @author wefrogll
 * @version 1.0 2009-11-30
 */
public class GradeGather extends BgBase {
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		try{
			System.out.println("=================process start===========================");
			String stateTime = null;//处理年月 默认当前时间的上个月
			GradeGather gradeGather = new GradeGather();
			boolean isPass = gradeGather.checkArgs(args);
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
			User user = gradeGather.getUser(args[0]);
			// 设置hibernate配置文件路径（相对于class path的路径）
			gradeGather.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/examine/hibernate.cfg.xml");
			// 设置个性化配置文件路径（相对于class path的路径）
//			gradeGather.setMyProfilePath("/examine_gradegather.properties");
			// 初始化
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
