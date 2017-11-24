package com.gmcc.pboss.web.sales.order;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderproce.OrderproceDBParam;
import com.gmcc.pboss.business.sales.orderproce.OrderproceVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderproce.Orderproce;
import com.gmcc.pboss.control.sales.orderproce.OrderproceBO;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class OrderChargeTaskBean extends BaseBatchTaskBean{

	public OrderChargeTaskBean() throws Exception {
		super.setBatchName("������������");
		// TODO Auto-generated constructor stub
	}

	
	@Override
	protected ResultVO processLine(String line, int rowCount) {
		// TODO Auto-generated method stub
		ResultVO resultVO = new ResultVO();
		String items[] = StringUtils.splitPreserveAllTokens(line, "|");
		try{
//			������Ϣ��飺���ݶ�����Ų�ѯ������FX_SW_ORDER�����������������д����ԭ�򡰶��������ڡ������ش�����һ����¼�����������һ����
			Order bo = (Order)BOFactory.build(OrderBO.class,user);
			OrderVO orderVO = bo.doFindByPk(items[0]);
			if(null == orderVO)
				throw new Exception(line+"|����������|");
			
			//����ͻ���ʽ���ǡ������������ǩ��״̬���ͨ����
			//����ͻ���ʽΪ�������������ǩ��״̬Ϊ����ǩ�ա���ǩ��״̬���ͨ�������򷵻���ʾ���ͻ���ʽΪ�������ǩ��״̬����Ϊ��ǩ��ʱ��������ִ���շѲ���������
			if("ARRIVEPAY".equals(orderVO.getDelitype()) && !"SIGNED".equals(orderVO.getSignstate())){
				throw new JOPException(line+"|�ͻ���ʽΪ�������ǩ��״̬����Ϊ��ǩ��ʱ��������ִ���շѲ�����| ");
			}
//			����״̬��飺���ݶ������̱�Ų�ѯ�������̲����FX_RU_ORDERPROCE����ƥ�����״̬Ϊ�����շѡ��������ǰ����״̬�����״̬һ�£���ͨ����飬������һ����������д����ԭ�򡰶���״̬����ȷ�������ش���һ������¼��
			Orderproce orderproceBO = (OrderproceBO)BOFactory.build(OrderproceBO.class,user);
			OrderproceDBParam orderproceParam = new OrderproceDBParam();
			orderproceParam.set_ne_flowid(orderVO.getFlowid().toString());
			orderproceParam.set_se_outstate("CHARGED");
			DataPackage dp = orderproceBO.doQuery(orderproceParam);
			
			//����ͻ���ʽΪ�������������ǩ��״̬Ϊ����ǩ�ա���ǩ��״̬���ͨ�������򷵻���ʾ���ͻ���ʽΪ�������ǩ��״̬����Ϊ��ǩ��ʱ��������ִ���շѲ���������
			if("ARRIVEPAY".equals(orderVO.getDelitype()) && !"SIGNED".equals(orderVO.getSignstate())){
				throw new JOPException(" �ͻ���ʽΪ�������ǩ��״̬����Ϊ��ǩ��ʱ��������ִ���շѲ����� ");
			}
			

			if("POS".equals(orderVO.getPaytype())){
				if(StringUtils.isEmpty(items[1])){
					throw new Exception("�ɷѷ�ʽΪPOSʱ��ˮ��Ϊ��!");
				} else {
					orderVO.setPosstream(items[1].trim());
				}
			}
			
			if( null == dp || null == dp.getDatas() || dp.getDatas().size()== 0 || orderVO.getOrderstate() == null ||  !orderVO.getOrderstate().equalsIgnoreCase(((OrderproceVO)dp.getDatas().get(0)).getInstate())){
				throw new Exception(line+"|����״̬����ȷ|");
			}
			
			//����ʵ�ս�����Ӧ�ս����¶���״̬Ϊ���շѣ�����״̬���ʱ��Ϊ��ǰʱ�䣬���µ���ʱ��Ϊ��ǰʱ�䡣
			orderVO.setActamt(orderVO.getRecamt());
			orderVO.setOrderstate("CHARGED");
			Date nowdate=new Date();
			orderVO.setStatechgtime(nowdate);
			orderVO.setPaytime(nowdate);
			bo.doUpdate(orderVO);
			
			
			//���á�������һ�������÷����������жϴ����������ش�����һ�����ݡ�
			bo.doNextProcess(orderVO.getOrderid());
			
			
			line = "�� "+rowCount+" �� +"+line +" ����ɹ�";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		}catch(Exception e){
			e.printStackTrace();
			if( !(e instanceof BusinessException)){
			if(e.getCause() != null && e.getCause().getMessage() != null)
				line = items[0]+"|"+(StringUtils.isNotBlank(items[1])?items[1]:"")+"|"+e.getCause().getMessage()+"|";
			else
				line = items[0]+"|"+(StringUtils.isNotBlank(items[1])?items[1]:"")+"|"+e.getMessage()+"|";
			resultVO.setInfo(line);
			resultVO.setOk(false);
			}else{
				line = "�� "+rowCount+" ��  ����ɹ�:"+e.getMessage();
				resultVO.setInfo(line);
				resultVO.setOk(true);
			}
		}
		return resultVO;
	}
}
