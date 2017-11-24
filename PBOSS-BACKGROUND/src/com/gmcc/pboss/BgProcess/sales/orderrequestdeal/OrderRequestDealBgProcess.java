package com.gmcc.pboss.BgProcess.sales.orderrequestdeal;

import java.util.List;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.business.sales.orderreq.OrderreqDBParam;
import com.gmcc.pboss.business.sales.orderreq.OrderreqVO;
import com.gmcc.pboss.control.sales.orderreq.Orderreq;
import com.gmcc.pboss.control.sales.orderreq.OrderreqBO;
import com.gmcc.pboss.control.sales.orderrequestdeal.OrderRequestDeal;
import com.gmcc.pboss.control.sales.orderrequestdeal.OrderRequestDealBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * ����������
 * @author wefrogll
 * @version 1.0 2009-11-14
 */
public class OrderRequestDealBgProcess extends BgBase {
	private static String STATE_EFFECTIVE = "1";
//	private static String STATE_INVALID = "0";
//	private static String PARAMTYPE_PBOSS_FX = "pboss_fx";
//	private static String SYSTEMID_RESDET = "15";
//	//���ͣ����������
//	private static String WAYTYPE_AG = "AG";
	
	public static void main(String[] args){
		OrderRequestDealBgProcess bgProcess = new OrderRequestDealBgProcess();

		/* --����4������ͨ�õķ���������ī�سɹ棬�������������Ļ�����д���漸������--------- */
		// ������
		boolean isPass = bgProcess.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser
		User user = bgProcess.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		bgProcess.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/orderrequestdeal/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		bgProcess.setMyProfilePath("/OrderRequestDealBgProcess.properties");
		// ��ʼ��
		try {
			bgProcess.init(args);
			/* ------------------------------------------------------------------------------- */
			log.info("==============��ʼ����ɣ���ʼ����=====================");
			// ��ʼ����
			while(true){
			String propName = args[0]+ "_intervalMin";
			int intervalMin = bgProcess.properties.getProperty(propName) == null ? 10:Integer.parseInt(bgProcess.properties.getProperty(propName));
			
			bgProcess.process(user);
			log.info("==============���� "+intervalMin+" ����=====================");
			Thread.sleep(intervalMin*60000);
			}
		} catch (Exception e) {
			log.error(e);
			log.error("==============�쳣�˳�=====================");
		}
	}
	
	private void process(DBAccessUser user) throws Exception{
		Orderreq orderreq = (Orderreq)BOFactory.build(OrderreqBO.class, user);
		OrderreqDBParam param = new OrderreqDBParam();
		param.set_pagesize("0");
		param.set_se_cityid(user.getCityid());
		param.set_ne_state(STATE_EFFECTIVE);
		DataPackage dp = orderreq.doQuery(param);
		List<OrderreqVO> orderreqList = dp.getDatas();
		
		OrderRequestDeal orderRequestDeal = (OrderRequestDeal)BOFactory.build(OrderRequestDealBO.class, user);
		//��ѯ��Ʒ��������,������������������
		if(null!=orderreqList&&orderreqList.size()>0)
		{
			for(int i=0; i<orderreqList.size(); i++)
			{
				OrderreqVO orderreqVO = orderreqList.get(i);
				try{
					orderRequestDeal.doProcess(orderreqVO);
				}catch(Exception ex){
					log.error(ex);
				}
			}
		}
	}
}
