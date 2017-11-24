package com.gmcc.pboss.web.sales.order;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.sales.audit.AuditDBParam;
import com.gmcc.pboss.business.sales.audit.AuditVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderproce.OrderproceDBParam;
import com.gmcc.pboss.business.sales.orderproce.OrderproceVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.sales.audit.Audit;
import com.gmcc.pboss.control.sales.audit.AuditBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderproce.Orderproce;
import com.gmcc.pboss.control.sales.orderproce.OrderproceBO;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class OrderAuditTaskBean extends BaseBatchTaskBean {

	public OrderAuditTaskBean() throws Exception {
		super.setBatchName("�����������");
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String itemStr = "";
		try {
			// ������Ϣ��飺���ݶ�����Ų�ѯ������FX_SW_ORDER�����������������д����ԭ�򡰶��������ڡ������ش�����һ����¼�����������һ����
			Order bo = (Order) BOFactory.build(OrderBO.class, user);
			OrderVO orderVO = bo.doFindByPk(line);
			if (null == orderVO)
				throw new Exception("����[" + line + "]������");

			// ���ݶ������̱�źͳ���״̬������ˣ���ѯ�������̲����FX_RU_ORDERPROCE����������״̬�����ڵ�ǰ����״̬����д������������[XXX]״̬����ȷ��
			// ������XXXΪ������ţ�
			Orderproce orderproceBO = (OrderproceBO) BOFactory.build(OrderproceBO.class, user);
			OrderproceDBParam orderproceParam = new OrderproceDBParam();
			orderproceParam.set_ne_flowid(orderVO.getFlowid().toString());
			orderproceParam.set_se_outstate("AUDITED");
			DataPackage dp = orderproceBO.doQuery(orderproceParam);

			if (null == dp || null == dp.getDatas() || dp.getDatas().size() == 0 || orderVO.getOrderstate() == null
					|| !orderVO.getOrderstate().equalsIgnoreCase(((OrderproceVO) dp.getDatas().get(0)).getInstate())) {
				throw new Exception("����[" + line + "]״̬����ȷ");
			}

			// ��������¼��飺���ݶ�����Ų�ѯ������ˣ�FX_SW_AUDIT����������ڼ�¼�����״̬������1����д������������[XXX]δ����ͨ����
			// ������XXXΪ������ţ������ش�����һ����¼�����������һ��
			Audit auditBO = (Audit) BOFactory.build(AuditBO.class, user);
			AuditDBParam auditDBParam = new AuditDBParam();
			auditDBParam.set_se_orderid(line);
			auditDBParam.set_orderby("smsntime");
			auditDBParam.set_desc("1");
			DataPackage auditDP = auditBO.doGetAuditInfo(auditDBParam);
			
			if (auditDP != null) {
				List<AuditVO> auditlist = auditDP.getDatas();
				if(!auditlist.isEmpty()){
					for(AuditVO auditVO:auditlist){
						if(!"1".equals(auditVO.getState())){
							throw new Exception("����[" + line + "]δ����ͨ��");
						}
						break;//����ֻ��Ҫ�жϵ�һ�����ݣ�����ʱ������
					}
				}
			}
			orderVO.setOrderstate("AUDITED");
			orderVO.setStatechgtime(new Date());
			bo.doUpdate(orderVO);//���¶���״̬Ϊ�����
			bo.doNextProcess(line);// ���á�������һ�������÷����������жϴ�����
			itemStr = rowCount + "|" + line + "|����ɹ�|";
			resultVO.setInfo(itemStr);
			resultVO.setOk(true);
		} catch (Exception e) {
			e.printStackTrace();
			if (!(e instanceof BusinessException)) {
				if (e.getCause() != null && e.getCause().getMessage() != null){
					itemStr = rowCount + "|" + (StringUtils.isNotBlank(line) ? line : "") + "|" + e.getCause().getMessage() + "|";
				}else{
					itemStr = rowCount + "|" + (StringUtils.isNotBlank(line) ? line : "") + "|" + e.getMessage() + "|";
				}		
				resultVO.setInfo(itemStr);
				resultVO.setOk(false);
			} else {
				itemStr = rowCount + "|" + line + "|����ɹ�|" + e.getMessage();
				resultVO.setInfo(itemStr);
				resultVO.setOk(true);
			}
		}
		return resultVO;
	}
}
