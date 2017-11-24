/**
 * auto-generated code
 * Wed Oct 14 13:53:36 CST 2009
 */
package com.gmcc.pboss.control.sales.orderproce;

import java.io.Serializable;
import java.util.Map;

import com.gmcc.pboss.business.sales.orderproce.OrderproceDBParam;
import com.gmcc.pboss.business.sales.orderproce.OrderproceDAO;
import com.gmcc.pboss.business.sales.orderproce.OrderproceVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OrderproceBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrderproceBO extends AbstractControlBean implements
		Orderproce {

	public OrderproceVO doCreate(OrderproceVO vo) throws Exception {
		try {
//			分销需求1.20版本中新增的验证 (7.5.34新增【订单流程管理】逻辑)
//			根据流程编号和步骤编号查询订单流程步骤表(FX_RU_ORDERPROCE)，
//			如果有结果数据，则提示“订购步骤已存在，不允许重复录入”
			Orderproce orderproceBO = (OrderproceBO) BOFactory.build(OrderproceBO.class, user);
			OrderproceDBParam orderproceParam = new OrderproceDBParam();
			orderproceParam.set_ne_flowid(""+vo.getFlowid());
			orderproceParam.set_ne_processid(""+vo.getProcessid());
			DataPackage orderproceDP = orderproceBO.doQuery(orderproceParam);
//			if( null != orderproceDP && null != orderproceDP.getDatas() && 0<orderproceDP.getDatas().size()){
//				throw new Exception("订购步骤已存在，不允许重复录入");
//			}
			OrderproceDAO dao = (OrderproceDAO) DAOFactory.build(OrderproceDAO.class, user);
			// TODO set the pk */
			return (OrderproceVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex.getMessage());
		}
	}

	public void doRemoveByVO(OrderproceVO vo) throws Exception {
		try {
			OrderproceDAO dao = (OrderproceDAO) DAOFactory.build(OrderproceDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OrderproceDAO dao = (OrderproceDAO) DAOFactory.build(OrderproceDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderproceVO doUpdate(OrderproceVO vo) throws Exception {
		try {
			OrderproceDAO dao = (OrderproceDAO) DAOFactory.build(OrderproceDAO.class,user);
			Orderproce orderproceBO = (OrderproceBO) BOFactory.build(OrderproceBO.class, user);
			OrderproceDBParam orderproceParam = new OrderproceDBParam();
			orderproceParam.set_ne_flowid(""+vo.getFlowid());
			orderproceParam.set_ne_processid(""+vo.getProcessid());
			orderproceParam.set_nne_recid(""+vo.getRecid());//非当前修改对象
			DataPackage orderproceDP = orderproceBO.doQuery(orderproceParam);
//			if( null != orderproceDP && null != orderproceDP.getDatas() && 0<orderproceDP.getDatas().size()){
//				throw new Exception("订购步骤已存在，不允许重复录入");
//			}
			return (OrderproceVO) dao.update(vo);
		} catch (Exception ex) {
//			throw new JOPException(ex);
			throw new Exception(ex.getMessage());
		}
	}

	public OrderproceVO doFindByPk(Serializable pk) throws Exception {
		OrderproceDAO dao = (OrderproceDAO) DAOFactory.build(OrderproceDAO.class,user);
		return (OrderproceVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OrderproceDBParam params)
			throws Exception {
		OrderproceDAO dao = (OrderproceDAO) DAOFactory.build(OrderproceDAO.class,user);
		return dao.query(params);
	}
}
