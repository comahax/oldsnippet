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
 * ʷ������2012-05-28 BOSS�Զ����ˣ���������CRM����
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
		// ��ȡUser
		User user = pro.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		pro
				.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		pro.setMyProfilePath("/sales/bgHandle/autobossinaccount.properties");
		// ��ʼ��
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
			// ȡ�����еĶ�����Ϣ
			DataPackage dp = this.getOrderInBossInfo(user);
			if (null == paramValue)
				paramValue = "120";

			//2012-05-28ע�͵�һ�´���
//			if (new CRMServiceforback().isCRMCityPort(user.getCityid())) {
//				// CRM����Ҫ��ʱ
//			} else {
//				// BOSS��Ҫ��ʱ��Ĭ��120��
//				int dss = Integer.parseInt(paramValue) * 1000;
//				Thread.sleep(dss);
//			}			
			int dss = Integer.parseInt(paramValue) * 1000;
			Thread.sleep(dss);

			log.info("*************��ʼ����*****************");
			AutoBossInAccount autoBossInAccountBO = (AutoBossInAccountBO) BOFactory.build(AutoBossInAccountBO.class, user);
			autoBossInAccountBO.process(dp, user, log);// �������˲���
		}

	}

	// ��ȡBOSS���˶�����Ϣ������BOSS������ţ���Ĭ��BOSS����������ڡ�0����������״̬��Ĭ�ϲ���������״̬���Զ�����(FX_SW_ORDER)���в�ѯ
	public DataPackage getOrderInBossInfo(User user) throws Exception {
		Order bo = (OrderBO) BOFactory.build(OrderBO.class, user);
		OrderDBParam orderDBParam = new OrderDBParam();
		orderDBParam.set_se_bossworkfid("0");
		orderDBParam.set_sne_orderstate("CANCEL");
		orderDBParam.set_pagesize("0");
		return bo.doQuery(orderDBParam);
	}

}
