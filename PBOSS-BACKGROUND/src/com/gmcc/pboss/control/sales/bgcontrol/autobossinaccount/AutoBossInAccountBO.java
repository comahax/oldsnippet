package com.gmcc.pboss.control.sales.bgcontrol.autobossinaccount;

import java.util.Iterator;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.resource.resoperator.ResoperatorDBParam;
import com.gmcc.pboss.business.resource.resoperator.ResoperatorVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDBParam;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetVO;
import com.gmcc.pboss.control.resource.resoperator.Resoperator;
import com.gmcc.pboss.control.resource.resoperator.ResoperatorBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderresdet.Orderresdet;
import com.gmcc.pboss.control.sales.orderresdet.OrderresdetBO;
import com.gmcc.pboss.web.common.webservice.CRMServiceforback;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class AutoBossInAccountBO extends AbstractControlBean implements
		AutoBossInAccount {

	private static Logger logger = Logger.getLogger(AutoBossInAccountBO.class);
	
	public void process(DataPackage dp, User user,Logger log) throws Exception {
		// �Զ�����Ϣ���������˴���
		if (dp != null && dp.getDatas() != null && dp.getDatas().size() > 0) {
			for (Iterator<OrderVO> it = dp.getDatas().iterator(); it.hasNext();) {
				OrderVO vo = it.next();
				Order bo = (Order) BOFactory.build(OrderBO.class, user);
				try {
					logger.info("��ʼ����*************"+vo.getOrderid()+"****************");
					Orderresdet orderdet = (OrderresdetBO) BOFactory.build(OrderresdetBO.class, user);

					// ���ݶ�����ź���Դ��𲻵��ڿհ�SIM��Ϊ������ѯ������Դ��ϸ��FX_SW_ORDERRESDET�����û���ݣ���������BOSS���˲�����
					OrderresdetDBParam orderresdet = new OrderresdetDBParam();
					orderresdet.setQueryAll(true);
					orderresdet.setDataOnly(true);
					orderresdet.set_se_orderid(vo.getOrderid());
					orderresdet.set_sne_restype("EMPTYSIM");
					DataPackage orderresdetdp = orderdet.doQuery(orderresdet);
					if (orderresdetdp != null && orderresdetdp.getDatas() != null && orderresdetdp.getDatas().size() > 0) {
						//2012-05-28
						//�ڵ��ýӿڷ�װ�������Ų���ʱ��������Դ���������͵��б�ʶȥ��ѯ��Դ�����������ñ�(IM_FX_RESOPERATOR)��
						//��ȡ��Ӧ�Ĳ������š���û�ж�Ӧ�Ĺ�����Ϣ��BOSS�����޸�Ϊ��-1������������ı�ע�ֶ��޸�Ϊ����Դ�Զ���
						//�˶�Ӧ�Ĳ�������δ���á�
						String operatorid = null;
						//���ݵ�һ����Դ��ϸ��ȡ��Դ��������
						OrderresdetVO orderresdetVO = (OrderresdetVO)orderresdetdp.getDatas().get(0);
						String reswayid = orderresdetVO.getWayid();
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
							String wayid = resoperVO.getWayid();
							OrderVO reorderVO = bo.recordByBoss(vo.getOrderid(), wayid, operatorid);
							log.info("BOSS���˳ɹ�");
							// �����ۿ�����
							bo.doSmsForSale(reorderVO);
						}else{
							vo.setBossworkfid("-1");
							vo.setMemo("��Դ�Զ����˶�Ӧ�Ĳ�������δ����");
							logger.info("��Դ�Զ����˶�Ӧ�Ĳ�������δ����");
							bo.doUpdate(vo);
						}						
						
						//���´���2012-05-28ע�͵�
						//OrderVO reorderVO = bo.recordByBoss(vo.getOrderid(),wayid);
						//if (new CRMServiceforback().isCRMCityPort(user.getCityid())) {
						//	log.info("�Ѿ��ύNGCRM����");
						//} else {
						//	log.info("BOSS���˳ɹ�");
						//	// �����ۿ�����
						//	Order boSms = (Order) BOFactory.build(OrderBO.class, user);
						//	boSms.doSmsForSale(reorderVO);
						//}
					}
					logger.info("�������*************"+vo.getOrderid()+"****************");
				} catch (Exception e) {
					log.info(e.getMessage());
					logger.info("����ʧ��*************"+vo.getOrderid()+"****************"+e.getMessage());
				}

			}
		}

	}

}
