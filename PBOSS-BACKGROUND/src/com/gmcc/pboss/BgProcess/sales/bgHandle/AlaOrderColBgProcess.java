package com.gmcc.pboss.BgProcess.sales.bgHandle;

import java.util.Date;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.alaOrderCol.AlaOrderColBg;
import com.gmcc.pboss.control.sales.bgcontrol.alaOrderCol.AlaOrderColBgBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.ui.User;

/**
 * <pre>
 * 【预警分配单汇总】后台程序
 *  功能描述：针对指定日期创建且自动分配的订单，按多维度进行统计汇总。默认情况下对前一天产生的订单进行处理
 * </pre>
 * @author yedaoe
 *
 */
public class AlaOrderColBgProcess extends BgBase {
	
	private Logger log = Logger.getLogger(AlaOrderColBgProcess.class);

	public static void main(String[] args) throws Exception{
		AlaOrderColBgProcess pro = new AlaOrderColBgProcess();
		boolean isPass = pro.myCheckArgs(args);
		if (!isPass) {
			return;
		}
		// 获取User
		User user = pro.getUser(args[0]);
		//获取目标日期
		String coldate = "";
		if(args.length>1){
			coldate = args[1];
		}else{
			coldate = PublicUtils.formatUtilDate(new Date(), "yyyyMMdd");
		}
		// 设置hibernate配置文件路径（相对于class path的路径）
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// 设置个性化配置文件路径（相对于class path的路径）
		pro.setMyProfilePath("/sales/bgHandle/alaOrderCol.properties");
		// 初始化
		pro.init(args);
		pro.alaOrderCol(user,coldate);
	}
	
	/**
	 * 参数检查
	 */
	private boolean myCheckArgs(String[] args) {
		if (args.length < 1) {
			//System.out.println(getHelp());
			log.info("程序运行参数未设置，退出");
			return false;
		}
		if (!CityMappingUtil.contain(args[0])) {
			System.out.println("cityid is not exist");
			return false;
		}
		if(args.length>1){
			String coldatestr = "";
			coldatestr = args[1];
			try{
				Date date = PublicUtils.UtilStrToDate(coldatestr,"yyyyMMdd");
			}catch(Exception e){
				log.info("目标日期格式不符合yyyyMMdd");
				return false;
			}
			String now = PublicUtils.formatUtilDate(new Date(), "yyyyMMdd");
			if(new Long(coldatestr)>new Long(now)){
				log.info("目标日期不允许大于当前时间");
				return false;
			}
		}
		return true;
	}
	
	private void alaOrderCol(User user,String coldate) throws Exception {
		
		AlaOrderColBg alaOrderCol = (AlaOrderColBg)BOFactory.build(AlaOrderColBgBO.class, user);
		try {
			log.info("==================预警分配单汇总后台程序开始==================");
			log.info("目标日期为："+coldate);
			alaOrderCol.doProcess(coldate);
			log.info("==================预警分配单汇总后台程序结束==================");
		}catch(BusinessException ex) {
			log.info(ex.getMessage());
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}
}
