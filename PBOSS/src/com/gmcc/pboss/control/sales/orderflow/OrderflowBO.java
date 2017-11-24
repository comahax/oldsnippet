/**
 * auto-generated code
 * Wed Oct 14 10:59:52 CST 2009
 */
package com.gmcc.pboss.control.sales.orderflow;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.business.sales.orderflow.OrderflowDBParam;
import com.gmcc.pboss.business.sales.orderflow.OrderflowDAO;
import com.gmcc.pboss.business.sales.orderflow.OrderflowVO;
import com.gmcc.pboss.business.sales.orderproce.OrderproceDBParam;
import com.gmcc.pboss.business.sales.orderproce.OrderproceVO;
import com.gmcc.pboss.control.sales.orderproce.Orderproce;
import com.gmcc.pboss.control.sales.orderproce.OrderproceBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OrderflowBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrderflowBO extends AbstractControlBean implements
		Orderflow {

	public OrderflowVO doCreate(OrderflowVO vo) throws Exception {
		try {
			OrderflowDAO dao = (OrderflowDAO) DAOFactory.build(OrderflowDAO.class, user);
			// TODO set the pk */
			//����Ψһ��Լ����飺���ݵ��б�ʶ������;�����ɷѷ�ʽ���ͻ���ʽ����Ч�ԣ�Ĭ����Ч��ֻ�����Ч���ݣ�
			//�Զ������̱�(FX_RU_ORDERFLOW)���в�ѯ������Ѿ��������ݣ�����ʾ����ͬ��¼�Ѿ����ڣ����顣��������
			if(new Short("1").equals(vo.getEffective())){
				OrderflowDBParam param = new OrderflowDBParam();
				param.set_se_cityid(vo.getCityid());
				param.set_se_orderave(vo.getOrderave());
				param.set_se_paytype(vo.getPaytype());
				param.set_se_delitype(vo.getDelitype());
				param.set_ne_effective("1");
				DataPackage dp = this.doQuery(param);
				if( null != dp && null != dp.getDatas() && 0<dp.getDatas().size())
					throw new JOPException("��ͬ��¼�Ѿ����ڣ�����");
			}
			
			return (OrderflowVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OrderflowVO vo) throws Exception {
		try {
			OrderflowDAO dao = (OrderflowDAO) DAOFactory.build(OrderflowDAO.class,user);
			//����ѡ�������̱�ŶԶ������̱�(FX_RU_ORDERFLOW) �Ͷ������̲���� (FX_RU_ORDERPROCE)�����ݽ���ɾ��(�汾��.��������)
			Orderproce orderproceBO = (OrderproceBO) BOFactory.build(OrderproceBO.class, user);
			OrderproceDBParam orderproceParam = new OrderproceDBParam();
			orderproceParam.set_ne_flowid(vo.getFlowid().toString());
			DataPackage dp = orderproceBO.doQuery(orderproceParam);
			if( null != dp && null != dp.getDatas() && 0<dp.getDatas().size()){
				List<OrderproceVO> list = dp.getDatas();
				for(OrderproceVO orderproceVO:list){
					orderproceBO.doRemoveByVO(orderproceVO);
				}
			}
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			//����ѡ�������̱�ŶԶ������̱�(FX_RU_ORDERFLOW) �Ͷ������̲���� (FX_RU_ORDERPROCE)�����ݽ���ɾ��(�汾��.��������)
			OrderflowDAO dao = (OrderflowDAO) DAOFactory.build(OrderflowDAO.class,user);
			Orderproce orderproceBO = (OrderproceBO) BOFactory.build(OrderproceBO.class, user);
			OrderproceDBParam orderproceParam = new OrderproceDBParam();
			orderproceParam.set_ne_flowid(String.valueOf(pk));
			DataPackage dp = orderproceBO.doQuery(orderproceParam);
			if( null != dp && null != dp.getDatas() && 0<dp.getDatas().size()){
				List<OrderproceVO> list = dp.getDatas();
				for(OrderproceVO orderproceVO:list){
					orderproceBO.doRemoveByVO(orderproceVO);
				}
			}
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderflowVO doUpdate(OrderflowVO vo) throws Exception {
		try {
			OrderflowDAO dao = (OrderflowDAO) DAOFactory.build(OrderflowDAO.class,user);
			
			//����Ψһ��Լ����飺���ݵ��б�ʶ������;�����ɷѷ�ʽ���ͻ���ʽ����Ч�ԣ�Ĭ����Ч��ֻ�����Ч���ݣ�
			//�Զ������̱�(FX_RU_ORDERFLOW)���в�ѯ������Ѿ��������ݣ�����ʾ����ͬ��¼�Ѿ����ڣ����顣��������
			OrderflowDBParam param = new OrderflowDBParam();
			if(new Short("1").equals(vo.getEffective())){
				param.set_nne_flowid(vo.getFlowid());
				param.set_se_cityid(vo.getCityid());
				param.set_se_orderave(vo.getOrderave());
				param.set_se_paytype(vo.getPaytype());
				param.set_se_delitype(vo.getDelitype());
				param.set_ne_effective("1");
				DataPackage dp = this.doQuery(param);
				if( null != dp && null != dp.getDatas() && 0<dp.getDatas().size())
					throw new JOPException("��ͬ��¼�Ѿ����ڣ�����");
			}
			
			return (OrderflowVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderflowVO doFindByPk(Serializable pk) throws Exception {
		OrderflowDAO dao = (OrderflowDAO) DAOFactory.build(OrderflowDAO.class,user);
		return (OrderflowVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OrderflowDBParam params)
			throws Exception {
		OrderflowDAO dao = (OrderflowDAO) DAOFactory.build(OrderflowDAO.class,user);
		return dao.query(params);
	}
}
