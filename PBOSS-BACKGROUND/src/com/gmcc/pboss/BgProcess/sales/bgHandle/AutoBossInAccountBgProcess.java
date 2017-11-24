package com.gmcc.pboss.BgProcess.sales.bgHandle;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.business.sales.order.OrderDBParam;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.sales.bgcontrol.autobossinaccount.AutoBossInAccount;
import com.gmcc.pboss.control.sales.bgcontrol.autobossinaccount.AutoBossInAccountBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.web.common.webservice.CRMServiceforback;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * @author limin
 * 史晓龙：2012-05-28 BOSS自动入账，不能用于CRM入账
 * 
 */
public class AutoBossInAccountBgProcess extends BgBase {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		AutoBossInAccountBgProcess pro = new AutoBossInAccountBgProcess();
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		// 获取User
		User user = pro.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		pro
				.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// 设置个性化配置文件路径（相对于class path的路径）
		pro.setMyProfilePath("/sales/bgHandle/autobossinaccount.properties");
		// 初始化
		pro.init(args);
		pro.runTask(user);

	}

	@Override
	protected void init(String[] args) throws Exception {
		super.init(args);
	}

	public void runTask(final User user) throws Exception {
		while (true) {
			Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,user);
			String paramValue = sysparam.doFindByID("9", "pboss_fx");
			// 取得所有的订单信息
			DataPackage dp = this.getOrderInBossInfo(user);
			if (null == paramValue)
				paramValue = "120";

			//2012-05-28注释掉一下代码
//			if (new CRMServiceforback().isCRMCityPort(user.getCityid())) {
//				// CRM不需要延时
//			} else {
//				// BOSS需要延时，默认120秒
//				int dss = Integer.parseInt(paramValue) * 1000;
//				Thread.sleep(dss);
//			}			
			int dss = Integer.parseInt(paramValue) * 1000;
			Thread.sleep(dss);

			log.info("*************开始处理*****************");
			AutoBossInAccount autoBossInAccountBO = (AutoBossInAccountBO) BOFactory.build(AutoBossInAccountBO.class, user);
			autoBossInAccountBO.process(dp, user, log);// 进行入账操作
		}

	}

	// 获取BOSS入账订单信息：根据BOSS工单编号（即默认BOSS工单编码等于“0”）、订单状态（默认不等于作废状态）对订单表(FX_SW_ORDER)进行查询
	public DataPackage getOrderInBossInfo(User user) throws Exception {
		Order bo = (OrderBO) BOFactory.build(OrderBO.class, user);
		OrderDBParam orderDBParam = new OrderDBParam();
		orderDBParam.set_se_bossworkfid("0");
		orderDBParam.set_sne_orderstate("CANCEL");
		orderDBParam.set_pagesize("0");
		return bo.doQuery(orderDBParam);
	}

}
