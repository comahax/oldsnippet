package com.gmcc.pboss.BgProcess.sales.bgHandle;



import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.BookResRelease.BookResRelease;
import com.gmcc.pboss.control.sales.bgcontrol.BookResRelease.BookResReleaseBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * [预定资源释放]后台处理
 * 功能描述： 对于预定超过指定时间的套卡资源进行释放
 * @author zhangsiwei
 *
 */
public class BookResReleaseBgProcess extends BgBase {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{

		BookResReleaseBgProcess pro = new BookResReleaseBgProcess();
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		// 获取User
		User user = pro.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// 设置个性化配置文件路径（相对于class path的路径）
		pro.setMyProfilePath("/sales/bgHandle/bookResRelease.properties");
		// 初始化
		pro.init(args);
		pro.runTask(user);
	}
	
	public void runTask(final User user) throws Exception {
		TimerTask task = new TimerTask() {
			@Override
			public void run(){
				try {
					smpResRelease(user);
				} catch (Exception e) {
					LoggerUtils.error(e, log);
				}
			}
			
		};
		try {
			String cityid = user.getCityid();
			// 休眠间隔数(分钟)
			String intervalMin = properties.getProperty(cityid+"_intervalMin");
			if(intervalMin == null) {
				throw new RuntimeException("配置文件中不存在属性："+cityid+"_intervalMin, 请核实。");
			}
			if("".equals(intervalMin)) {
				throw new RuntimeException("配置文件中名称为"+cityid+"_intervalMin的属性的值为空, 请核实。");
			}
			float intervalMinLong = Float.parseFloat(intervalMin);
			Timer timer = new Timer();
			timer.schedule(task, new Date(), (long)(intervalMinLong*60*1000));
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}
	
	public void smpResRelease(User user) throws Exception {
		BookResRelease brrBo = (BookResReleaseBO)BOFactory.build(BookResReleaseBO.class, user);
		try {
			brrBo.doProcess();
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}
	
}
