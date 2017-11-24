package com.gmcc.pboss.web.sales.order;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderproce.OrderproceDBParam;
import com.gmcc.pboss.business.sales.orderproce.OrderproceVO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDBParam;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderproce.Orderproce;
import com.gmcc.pboss.control.sales.orderproce.OrderproceBO;
import com.gmcc.pboss.control.sales.orderresdet.Orderresdet;
import com.gmcc.pboss.control.sales.orderresdet.OrderresdetBO;
import com.gmcc.pboss.web.common.webservice.CRMService;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class RecordedTaskBean extends BaseBatchTaskBean {

	public RecordedTaskBean() throws Exception {
		super.setBatchName("������������");
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String step = (String) super.parameterMap.get("step");
		String wayid = (String) super.parameterMap.get("wayid");
		// ϵͳ����
		Order bo = null;
		OrderVO orderVO = null;
		if (StringUtils.isEmpty(step)) {
			try {
				// ������Ϣ��飺���ݶ�����Ų�ѯ������FX_SW_ORDER�����������������д����ԭ�򡰶��������ڡ������ش�����һ����¼�����������һ����

				bo = (Order) BOFactory.build(OrderBO.class, user);
				orderVO = bo.doFindByPk(line);
				if (null == orderVO)
					throw new Exception("ϵͳ����ʧ�ܣ����Ϊ [" + line + "] ���������ڣ�");

				// ����״̬��飺���ݶ������̱�Ų�ѯ�������̲����FX_RU_ORDERPROCE����ƥ�����״̬Ϊ������ɡ��������ǰ����״̬�����״̬һ�£���ͨ����飬������һ����������д����ԭ�򡰶���״̬����ȷ�������ش���һ������¼��
				// ͨ��������ж������˴������ա��������ˡ��߼���
				Orderproce orderProceBO = (OrderproceBO) BOFactory.build(
						OrderproceBO.class, user);
				OrderproceDBParam orderproceParam = new OrderproceDBParam();
				orderproceParam.setDataOnly(true);
				orderproceParam.set_ne_flowid("" + orderVO.getFlowid());
				orderproceParam.set_se_instate(orderVO.getOrderstate());
				DataPackage orderproceDP = orderProceBO.doQuery(orderproceParam);
				if (null == orderproceDP || null == orderproceDP.getDatas()
						|| 0 == orderproceDP.getDatas().size()) {
					log.info("����["+orderVO.getOrderid()+"]����״̬����ȷ");
					throw new JOPException(" ����״̬����ȷ ");
				}
				OrderproceVO orderproceVO = (OrderproceVO) orderproceDP.getDatas()
						.get(0);
				if (!"FINISHED".equals(orderproceVO.getOutstate())){
					log.info("����["+orderVO.getOrderid()+"]����״̬����ȷ");
					throw new JOPException(" ����״̬����ȷ ");
				}				
				
				
				
//				Orderproce orderproceBO = (OrderproceBO) BOFactory.build(
//						OrderproceBO.class, user);
//				OrderproceDBParam orderproceParam = new OrderproceDBParam();
//				orderproceParam.set_ne_flowid(orderVO.getFlowid().toString());
//				orderproceParam.set_se_outstate("FINISHED");
//				DataPackage dp = orderproceBO.doQuery(orderproceParam);
//
//				if (null == dp
//						|| null == dp.getDatas()
//						|| dp.getDatas().size() == 0
//						|| orderVO.getOrderstate() == null
//						|| !orderVO.getOrderstate().equalsIgnoreCase(
//								((OrderproceVO) dp.getDatas().get(0))
//										.getInstate()))
//					throw new Exception("ϵͳ����ʧ�ܣ�����״̬����ȷ��");

				bo.recorded(line, wayid,"-1");
				line = line + "|1|ϵͳ���˳ɹ�";
				resultVO.setInfo(line);
				resultVO.setOk(true);
			} catch (Exception e) {
				e.printStackTrace();
				line = line + "|0|" + e.getMessage();
				resultVO.setInfo(line);
				resultVO.setOk(false);
			}
		}
		// boss����
		else if (null != step && step.equals("2")) {
			// line ����Ϣ��ʽΪ
			// orderid|�ɹ�ʧ��״̬λ|��ʾ��Ϣ��״̬λ1�ɹ�0ʧ��
			String[] info = line.split("\\|");
			if (info.length == 3) {
				// ϵͳ���˳ɹ�
				if (null != info[1] && info[1].equals("1")) {
					try {
						Orderresdet orderdet = (OrderresdetBO) BOFactory.build(	OrderresdetBO.class, user);
						// ���ݶ�����ź���Դ��𲻵��ڿհ�SIM��Ϊ������ѯ������Դ��ϸ��FX_SW_ORDERRESDET�����û���ݣ���������BOSS/CRM���˲�����
						OrderresdetDBParam orderresdet = new OrderresdetDBParam();
						orderresdet.setQueryAll(true);
						orderresdet.setDataOnly(true);
						orderresdet.set_se_orderid(info[0]);
						orderresdet.set_sne_restype("EMPTYSIM");
						DataPackage orderresdetdp = orderdet.doQuery(orderresdet);
						if (orderresdetdp != null && orderresdetdp.getDatas() != null && orderresdetdp.getDatas().size() > 0) {//��ϸ�����ǿհ׿�
							String orderid = info[0];
							bo = (Order) BOFactory.build(OrderBO.class, user);
							OrderVO orderVOt = bo.recordByBoss(orderid, wayid);
							line = info[0] + "|" + info[2] + "��" + "boss�ӿ����˳ɹ�";							
							if (!new CRMService().isCRMCityPort(user.getCityid())) {//BOSS�������Ͷ��ţ�CRM���˲�����
								// �����ۿ�����.
								Order boSms = (Order) BOFactory.build(OrderBO.class, user);
								boSms.doSmsForSale(orderVOt);
							}							
						}else{//��ϸ��Ϊ�հ׿�
							line = info[0] + "|" + info[2] + "��" + "�����հ׿�����boss����";
						}
						resultVO.setInfo(line);
						resultVO.setOk(true);
					} catch (Exception e) {
						e.printStackTrace();
						line = info[0] + "|" + info[2] + "��" + "boss�ӿ�����ʧ�ܣ�"	+ e.getMessage() + "��";
						resultVO.setInfo(line);
						resultVO.setOk(false);
					}
				}
				// ȥ��״̬λ
				else {
					line = info[0] + "|" + info[2];
					resultVO.setInfo(line);
					resultVO.setOk(false);
				}
			}
		}

		return resultVO;
	}
}
