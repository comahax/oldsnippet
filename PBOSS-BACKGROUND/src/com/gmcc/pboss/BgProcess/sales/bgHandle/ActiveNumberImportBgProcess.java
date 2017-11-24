package com.gmcc.pboss.BgProcess.sales.bgHandle;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.ActiveNumberImport.ActiveNumberImport;
import com.gmcc.pboss.control.sales.bgcontrol.ActiveNumberImport.ActiveNumberImportBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * <pre>
 * [激活号码导入]后台处理
 * 功能描述： 将指定格式的激活数据文件（计费下发后经BAM系统过滤处理）导入到号码激活记录表。
 * </pre>
 * @author zhangsiwei
 *
 */
public class ActiveNumberImportBgProcess extends BgBase {

	/**激活号码文件存放路径*/
	private String srcpath;
	/**休眠间隔数(分钟)*/
	private static String intervalMin;
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		
		ActiveNumberImportBgProcess pro = new ActiveNumberImportBgProcess();
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		// 获取User
		User user = pro.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// 设置个性化配置文件路径（相对于class path的路径）
		pro.setMyProfilePath("/sales/bgHandle/activeimport.properties");
		// 初始化
		pro.init(args);
//		pro.runTask(user,intervalMin);
		pro.activePhoneNoImport(user);
	}
	
	
	@Override
	protected void init(String[] args) throws Exception {
		super.init(args);
		srcpath = properties.getProperty("srcpath");
		intervalMin = properties.getProperty(args[0]+"_intervalMin");
	}
	
	public void runTask(final User user,final String intervalMin) throws Exception {
		TimerTask task = new TimerTask() {
			@Override
			public void run(){
				try {
					activePhoneNoImport(user);
					log.info("休眠  "+intervalMin+"分钟");
				} catch (Exception e) {
					LoggerUtils.error(e, log);
				}
			}
			
		};
		try {
			String cityid = user.getCityid();
			// 休眠间隔数(分钟)
			if(intervalMin == null) {
				throw new RuntimeException("配置文件中不存在属性："+cityid+"_intervalMin, 请核实。");
			}
			if("".equals(intervalMin)) {
				throw new RuntimeException("配置文件中名称为"+cityid+"_intervalMin的属性的值为空, 请核实。");
			}
			float intervalMinFloat = Float.parseFloat(intervalMin);
			Timer timer = new Timer();
			timer.schedule(task, new Date(), (long)(intervalMinFloat*60*1000));
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}

	public void activePhoneNoImport(User user) throws Exception {
		ActiveNumberImport aniBo = (ActiveNumberImportBO)BOFactory.build(ActiveNumberImportBO.class, user);
		try {
			aniBo.doProcess(user.getCityid(),srcpath);
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}

	
}
