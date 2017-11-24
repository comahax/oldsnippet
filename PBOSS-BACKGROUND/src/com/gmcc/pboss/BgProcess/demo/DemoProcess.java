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

		/* --����4������ͨ�õķ���������ī�سɹ棬�������������Ļ�����д���漸������--------- */
		// ������
		boolean isPass = demo.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser
		User user = demo.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		demo.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/demo/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		demo.setMyProfilePath("/DemoProcess.properties");
		// ��ʼ��
		demo.init(args);
		/* ------------------------------------------------------------------------------- */

		// ��ʼ����
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
	 * ʹ��spring�������������(�Ƽ�һ�������ʹ��)
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
	 * �Լ��ֹ�������������ӣ�Ҫ��ȷ����Լ�Ҫ��ʲô�������ʹ�ã�
	 */
	protected void process2(User user) {
		Session session = SessionUtils.currentSession(user.getCityid());
		Transaction trans = session.getTransaction();
		try {

			trans.begin();
			
			DictitemBO bo = new DictitemBO();  //��new��ʽ���ɵ�bo����spring�й�
			bo.setUser(user);
			DictitemDBParam params = new DictitemDBParam();
			params.set_pagesize("100");
			params.set_se_groupid("ApnVisitType");
			params.set_se_dictid("1");
			DataPackage pack = bo.doQuery(params);  // ����ע�⣺����ֻ����ʾ����ʵ�������ｨ�鲻��do*����
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
