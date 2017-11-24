package com.gmcc.pboss.control.sales.order;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderproce.OrderproceDBParam;
import com.gmcc.pboss.business.sales.orderproce.OrderproceVO;
import com.gmcc.pboss.business.sales.ordertask.OrdertaskDBParam;
import com.gmcc.pboss.business.sales.ordertask.OrdertaskVO;
import com.gmcc.pboss.business.sales.process.ProcessVO;
import com.gmcc.pboss.control.sales.autodeal.OrderDeal;
import com.gmcc.pboss.control.sales.orderproce.Orderproce;
import com.gmcc.pboss.control.sales.orderproce.OrderproceBO;
import com.gmcc.pboss.control.sales.ordertask.Ordertask;
import com.gmcc.pboss.control.sales.ordertask.OrdertaskBO;
import com.gmcc.pboss.control.sales.process.ProcessBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class OrderProcessBO extends AbstractControlBean implements OrderProcess {
	private Log log = LogFactory.getLog(OrderProcessBO.class);

	public void process(int intervalMin) throws Exception {
		while(true) {
			// TODO Auto-generated method stub
			// ��ѯ���������FX_SW_ORDERTASK����ƥ����б�ʶΪ��ڲ������б�ʶ
			// ,ƥ����Ч��Ϊ��Ч�������������������ߣ�����Խ��������������
			Ordertask ordertaskBO = (OrdertaskBO) BOFactory.build(OrdertaskBO.class, user);
			OrdertaskDBParam ordertaskParam = new OrdertaskDBParam();
			ordertaskParam.setQueryAll(true);
			ordertaskParam.setDataOnly(true);
			ordertaskParam.set_se_cityid(user.getCityid());
			ordertaskParam.set_ne_effective("1");
			ordertaskParam.set_orderby("recid");
			ordertaskParam.set_desc("0");
			DataPackage ordertaskDP = ordertaskBO.doQuery(ordertaskParam);
			if (null != ordertaskDP && null != ordertaskDP.getDatas()
					&& 0 < ordertaskDP.getDatas().size()) {
				for (int i = 0; i < ordertaskDP.getDatas().size(); i++) {
					try {
						OrdertaskVO ordertaskVO = (OrdertaskVO) ((List) ordertaskDP.getDatas()).get(i);
						this.doAutoProcess(ordertaskVO);
					} catch (Exception e) {
						LoggerUtils.error(e, log);
					}
				}
			} else {
				log.info("==============���� "+intervalMin+" ����=====================");
				Thread.sleep(intervalMin*60000);
			}
		}
	}


	public void doAutoProcess(OrdertaskVO ordertaskVO) throws Exception {
		Ordertask ordertaskBO = (OrdertaskBO) BOFactory.build(OrdertaskBO.class, user);
		Orderproce orderProceBO = (OrderproceBO) BOFactory.build(OrderproceBO.class, user);
		ProcessBO processBO = (ProcessBO) BOFactory.build(ProcessBO.class, user);
		Order orderBO = (OrderBO) BOFactory.build(OrderBO.class, user);
		// 1) ���ݶ�����Ų�ѯ������FX_SW_ORDER������������ݣ����޸Ķ������������Ч��Ϊ��Ч��
		// ��עΪ��������Ϣ�����ڡ������ش�����һ�����ݣ����������
		OrderVO orderVO = orderBO.doFindByPk(ordertaskVO.getOrderid());
		if (null != orderVO) {
			// 2) ���ݶ������̱�źͶ���״̬��ѯ�������̲����FX_RU_ORDERPROCE����ƥ�����״̬Ϊ��ǰ����״̬����������ݣ�
			// ���޸Ķ������������Ч��Ϊ��Ч����עΪ����ǰ��������һ�������������ش�����һ�����ݣ����������
			OrderproceDBParam orderproceParam = new OrderproceDBParam();
			orderproceParam.setQueryAll(true);
			orderproceParam.setDataOnly(true);
			orderproceParam.set_ne_flowid("" + orderVO.getFlowid());
			orderproceParam.set_se_instate(orderVO.getOrderstate());
			DataPackage orderproceDP = orderProceBO.doQuery(orderproceParam);
			if (null != orderproceDP && null != orderproceDP.getDatas()
					&& 0 < orderproceDP.getDatas().size()) {
				try {
					for (int j = 0; j < orderproceDP.getDatas().size(); j++) {
						try {
							OrderproceVO orderproceVO = (OrderproceVO) ((List) orderproceDP.getDatas()).get(j);
							// 3)
							// ����������账��ģʽΪ�˹������޸Ķ������������Ч��Ϊ��Ч����עΪ����һ���˹������衱�����ش�����һ�����ݣ����������
							if ("MANUAL".equals(orderproceVO.getDismode())) {
								String date1 = new Date().toLocaleString();
								ordertaskVO.setEffective(new Short("0"));
								ordertaskVO.setMemo("��һ���˹�������");
								ordertaskBO.doUpdate(ordertaskVO);
								String date2 = new Date().toLocaleString();
								log.info("ORDERID��"+ordertaskVO.getOrderid()+"; DISMODE:MANUAL" + "; DEALBEGIN:"+date1+"; DEALEND:"+date2);
							} else if ("AUTO".equals(orderproceVO.getDismode())) {
								// 4)
								// ����������账��ģʽΪ�Զ������ô�����Ըö������д����������ʧ�ܣ����޸Ķ������������Ч��Ϊ��Ч��
								// ��עΪ��[������������]����ʧ�ܡ����������ɹ������޸Ķ������������Ч��Ϊ��Ч,�������һ����¼����
								ProcessVO processVO = processBO.doFindByPk(orderproceVO.getProcessid());
								try {
									OrderDeal orderDeal = (OrderDeal) Class.forName(processVO.getClasspath()).newInstance();
									String date1 = new Date().toLocaleString();
									boolean result = orderDeal.doDeal(orderVO,user); 
									if (!result) {
										ordertaskVO.setEffective(new Short("0"));
										ordertaskVO.setMemo("["+ processVO.getProcessname()+ "] ����ʧ��--"+orderVO.getMemo());
										ordertaskBO.doUpdate(ordertaskVO);
									}else{
										ordertaskVO.setEffective(new Short("0"));
										ordertaskVO.setMemo("�ɹ�");
										ordertaskBO.doUpdate(ordertaskVO);
										
										orderBO.doNextProcess(orderVO.getOrderid());
										
									}
									String date2 = new Date().toLocaleString();
									log.info("ORDERID��"+ordertaskVO.getOrderid()+"; DISMODE:AUTO" +" DEALCLASS:"+processVO.getClasspath() + "; DEALBEGIN:"+date1+"; DEALEND:"+date2);
								} catch (Exception e) {
									e.printStackTrace();
									ordertaskVO.setEffective(new Short("0"));
									ordertaskVO.setMemo("["+ processVO.getProcessname()+ "] ����ʧ��");
									ordertaskBO.doUpdate(ordertaskVO);
									log.error(e);
								}
							}
						} catch (Exception e) {
							LoggerUtils.error(e, log);
						}
					}
				} catch (Exception e) {
					LoggerUtils.error(e, log);
				}
			} else {
				ordertaskVO.setEffective(new Short("0"));
				ordertaskVO.setMemo("��ǰ��������һ������");
				ordertaskBO.doUpdate(ordertaskVO);
			}
		} else {
			ordertaskVO.setEffective(new Short("0"));
			ordertaskVO.setMemo("������Ϣ������");
			ordertaskBO.doUpdate(ordertaskVO);
		}
	}

}
