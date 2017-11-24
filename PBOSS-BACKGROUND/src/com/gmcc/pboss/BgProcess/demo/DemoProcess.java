package com.gmcc.pboss.BgProcess.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.sales.activerate.ActiverateDBParam;
import com.gmcc.pboss.business.sales.activerate.ActiverateVO;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.sales.activerate.Activerate;
import com.gmcc.pboss.control.sales.activerate.ActiverateBO;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * @author hbm
 * 
 */
public class DemoProcess extends BgBase {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		DemoProcess demo = new DemoProcess();

		/* --下面4个基类通用的方法，不用墨守成规，如果不符合需求的话就重写下面几个方法--------- */
		// 检查参数
		boolean isPass = demo.checkArgs(args);
		if (!isPass) {
			return;
		}
		// 获取User
		User user = demo.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		demo.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/demo/hibernate.cfg.xml");
		// 设置个性化配置文件路径（相对于class path的路径）
		demo.setMyProfilePath("/DemoProcess.properties");
		// 初始化
		demo.init(args);
		/* ------------------------------------------------------------------------------- */

		// 开始处理
		demo.testCityProcess(user);
	}
	
	protected void testCityProcess(User user) {
		try {
			Activerate activerate = (Activerate) BOFactory.build(ActiverateBO.class, user);
			ActiverateDBParam param = new ActiverateDBParam();
			param.set_se_wayid("KFMM0CC87");
			DataPackage dp = activerate.doQuery(param);
			ActiverateVO vo = (ActiverateVO)dp.getDatas().get(0);
			activerate.doRemoveByVO(vo);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * 使用spring管理事务的例子(推荐一般情况下使用)
	 */
	protected void process(User user) {
		try {
			DictitemBO bo = (DictitemBO) BOFactory.build(DictitemBO.class, user);

			DictitemDBParam params = new DictitemDBParam();
			params.set_pagesize("100");
			params.set_se_groupid("ApnVisitType");
			params.set_se_dictid("1");
			DataPackage pack = bo.doQuery(params);
			DictitemVO vo = (DictitemVO) pack.getDatas().get(0);

			System.out.println(pack.getRowCount());
			System.out.println(vo);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 自己手工管理事务的例子（要明确清楚自己要干什么的情况下使用）
	 */
	protected void process2(User user) {
		Session session = SessionUtils.currentSession(user.getCityid());
		Transaction trans = session.getTransaction();
		try {

			trans.begin();
			
			DictitemBO bo = new DictitemBO();  //用new方式生成的bo不受spring托管
			bo.setUser(user);
			DictitemDBParam params = new DictitemDBParam();
			params.set_pagesize("100");
			params.set_se_groupid("ApnVisitType");
			params.set_se_dictid("1");
			DataPackage pack = bo.doQuery(params);  // ！！注意：这里只是做示例，实际上这里建议不用do*方法
			DictitemVO vo = (DictitemVO) pack.getDatas().get(0);
			System.out.println(pack.getRowCount());
			System.out.println(vo);

			trans.commit();

		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			session.close();
		}
	}

}
