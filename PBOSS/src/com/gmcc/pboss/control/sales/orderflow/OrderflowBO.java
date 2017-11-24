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
			//进行唯一性约束检查：根据地市标识、订购途径、缴费方式、送货方式、有效性（默认有效，只检查有效数据）
			//对订单流程表(FX_RU_ORDERFLOW)进行查询，如果已经存在数据，则提示“相同记录已经存在，请检查。”并返回
			if(new Short("1").equals(vo.getEffective())){
				OrderflowDBParam param = new OrderflowDBParam();
				param.set_se_cityid(vo.getCityid());
				param.set_se_orderave(vo.getOrderave());
				param.set_se_paytype(vo.getPaytype());
				param.set_se_delitype(vo.getDelitype());
				param.set_ne_effective("1");
				DataPackage dp = this.doQuery(param);
				if( null != dp && null != dp.getDatas() && 0<dp.getDatas().size())
					throw new JOPException("相同记录已经存在，请检查");
			}
			
			return (OrderflowVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OrderflowVO vo) throws Exception {
		try {
			OrderflowDAO dao = (OrderflowDAO) DAOFactory.build(OrderflowDAO.class,user);
			//根据选定的流程编号对订单流程表(FX_RU_ORDERFLOW) 和订单流程步骤表 (FX_RU_ORDERPROCE)的数据进行删除(版本１.２３需求)
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
			//根据选定的流程编号对订单流程表(FX_RU_ORDERFLOW) 和订单流程步骤表 (FX_RU_ORDERPROCE)的数据进行删除(版本１.２３需求)
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
			
			//进行唯一性约束检查：根据地市标识、订购途径、缴费方式、送货方式、有效性（默认有效，只检查有效数据）
			//对订单流程表(FX_RU_ORDERFLOW)进行查询，如果已经存在数据，则提示“相同记录已经存在，请检查。”并返回
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
					throw new JOPException("相同记录已经存在，请检查");
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
