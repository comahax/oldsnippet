package com.gmcc.pboss.control.sales.autodeal;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.resource.resoperator.ResoperatorDBParam;
import com.gmcc.pboss.business.resource.resoperator.ResoperatorVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDBParam;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetVO;
import com.gmcc.pboss.control.resource.resoperator.Resoperator;
import com.gmcc.pboss.control.resource.resoperator.ResoperatorBO;
import com.gmcc.pboss.control.sales.bgcontrol.autobossinaccount.AutoBossInAccountBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderresdet.Orderresdet;
import com.gmcc.pboss.control.sales.orderresdet.OrderresdetBO;
import com.gmcc.pboss.web.common.webservice.CRMServiceforback;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class OrderInAccountDealBO extends AbstractControlBean implements OrderDeal {

	private static Logger logger = Logger.getLogger(OrderInAccountDealBO.class);
	
	public boolean doDeal(OrderVO order, DBAccessUser user1) throws Exception {
		// �Զ�����Ϣ���������˴���
		OrderVO vo = order;
		User user = (User) user1;
		Order bo = (Order) BOFactory.build(OrderBO.class, user);
		try {
			logger.info("��ʼ����*************"+vo.getOrderid()+"****************");
			logger.info("��̨����COMS���˿�ʼ*************"+vo.getOrderid()+"****************");
			OrderVO orderVO = bo.recorded(vo.getOrderid(), vo.getWayid(),"0");// ���ñ������˳���
			logger.info("��̨����COMS���˽���*************"+vo.getOrderid()+"****************");
			//OrderVO orderVO = bo.doFindByPk(vo.getOrderid());//����ʹ�ã�����ʱ�ɰ�����һ��COMS���˴���ע�͵���ֱ�Ӳ���CRM����
			if(new CRMServiceforback().isCRMCityPort(user1.getCityid())){//�����CRM���ˣ�����е���CRM���˽ӿڡ�
				logger.info(user1.getCityid()+"����ΪCRM���˵��У�����CRM��������*************"+vo.getOrderid()+"****************");
				//2012-05-28
				// ���ݶ�����ź���Դ��𲻵��ڿհ�SIM��Ϊ������ѯ������Դ��ϸ��FX_SW_ORDERRESDET�����û���ݣ���������CRM���˲�����
				logger.info(vo.getOrderid()+"*************���ݶ�����ź���Դ��𲻵��ڿհ�SIM��Ϊ������ѯ������Դ��ϸ��,���û���ݣ���������CRM���˲���****************");
				Orderresdet orderdet = (OrderresdetBO) BOFactory.build(OrderresdetBO.class, user);				
				OrderresdetDBParam orderresdet = new OrderresdetDBParam();
				orderresdet.setQueryAll(true);
				orderresdet.setDataOnly(true);
				orderresdet.set_se_orderid(orderVO.getOrderid());
				orderresdet.set_sne_restype("EMPTYSIM");
				DataPackage orderresdetdp = orderdet.doQuery(orderresdet);
				//2012-05-28
				//�ڵ��ýӿڷ�װ�������Ų���ʱ��������Դ���������͵��б�ʶȥ��ѯ��Դ�����������ñ�(IM_FX_RESOPERATOR)��
				//��ȡ��Ӧ�Ĳ������š���û�ж�Ӧ�Ĺ�����Ϣ��BOSS�����޸�Ϊ��-1������������ı�ע�ֶ��޸�Ϊ����Դ�Զ���
				//�˶�Ӧ�Ĳ�������δ���á�
				if (orderresdetdp != null && orderresdetdp.getDatas() != null && orderresdetdp.getDatas().size() > 0) {
					logger.info(vo.getOrderid()+"*************��ϸ��¼���ڣ���������CRM��������****************");
					String operatorid = null;
					String wayid = null;
					//���ݵ�һ����Դ��ϸ��ȡ��Դ��������
					OrderresdetVO orderresdetVO = (OrderresdetVO)orderresdetdp.getDatas().get(0);
					String reswayid = orderresdetVO.getWayid();
					logger.info(vo.getOrderid()+"*************���ݵ�һ����Դ��ϸ��ȡ��Դ����������"+reswayid+"****************");
					Resoperator resoper = (ResoperatorBO)BOFactory.build(ResoperatorBO.class, user);
					ResoperatorDBParam rparam = new ResoperatorDBParam();
					rparam.set_se_cityid(user.getCityid());
					rparam.set_se_wayid(reswayid);
					rparam.setDataOnly(true);
					rparam.setQueryAll(true);
					DataPackage resoperdp = resoper.doQuery(rparam);
					if(resoperdp!=null && resoperdp.getDatas()!=null && resoperdp.getDatas().size()>0){
						ResoperatorVO resoperVO = (ResoperatorVO)resoperdp.getDatas().get(0);
						operatorid = resoperVO.getOperid();
						logger.info(vo.getOrderid()+"*************���˲������ţ�"+operatorid+"****************");
						wayid = resoperVO.getWayid();
						logger.info(vo.getOrderid()+"*************���˲���������"+wayid+"****************");
						//����NGCRM����
						logger.info("��̨����CRM���˿�ʼ*************"+vo.getOrderid()+"****************");
						orderVO = bo.recordByCRM(orderVO.getOrderid(), wayid, operatorid);
						logger.info("��̨����CRM���˽���*************"+vo.getOrderid()+"****************");
					}else{
						orderVO.setBossworkfid("-1");
						orderVO.setMemo(vo.getOrderid()+"��Դ�Զ����˶�Ӧ�Ĳ�������δ����");
						bo.doUpdate(orderVO);
						logger.info("�������*************"+vo.getOrderid()+"*******��Դ�Զ����˶�Ӧ�Ĳ�������δ����*********");
						return false;
					}
				}else{
					logger.info(vo.getOrderid()+"*************��ϸ��¼�����ڣ�����CRM���˲���****************");
				}
			}			
			logger.info("�������*************"+vo.getOrderid()+"****************");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
