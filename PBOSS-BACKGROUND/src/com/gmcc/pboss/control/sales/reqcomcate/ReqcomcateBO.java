/**
 * auto-generated code
 * Mon Nov 30 15:49:57 CST 2009
 */
package com.gmcc.pboss.control.sales.reqcomcate;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import com.gmcc.pboss.business.sales.orderreq.OrderreqVO;
import com.gmcc.pboss.business.sales.reqcomcate.ReqcomcateDAO;
import com.gmcc.pboss.business.sales.reqcomcate.ReqcomcateDBParam;
import com.gmcc.pboss.business.sales.reqcomcate.ReqcomcateVO;
import com.gmcc.pboss.control.sales.orderreq.Orderreq;
import com.gmcc.pboss.control.sales.orderreq.OrderreqBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ReqcomcateBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ReqcomcateBO extends AbstractControlBean implements
		Reqcomcate {

	public ReqcomcateVO doCreate(ReqcomcateVO vo) throws Exception {
		try {
			ReqcomcateDAO dao = (ReqcomcateDAO) DAOFactory.build(ReqcomcateDAO.class, user);
			// TODO set the pk */
			return (ReqcomcateVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ReqcomcateVO vo) throws Exception {
		try {
			ReqcomcateDAO dao = (ReqcomcateDAO) DAOFactory.build(ReqcomcateDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ReqcomcateDAO dao = (ReqcomcateDAO) DAOFactory.build(ReqcomcateDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ReqcomcateVO doUpdate(ReqcomcateVO vo) throws Exception {
		try {
			ReqcomcateDAO dao = (ReqcomcateDAO) DAOFactory.build(ReqcomcateDAO.class, user);
			return (ReqcomcateVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ReqcomcateVO doFindByPk(Serializable pk) throws Exception {
		ReqcomcateDAO dao = (ReqcomcateDAO) DAOFactory.build(ReqcomcateDAO.class, user);
		return (ReqcomcateVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ReqcomcateDBParam params)
			throws Exception {
		ReqcomcateDAO dao = (ReqcomcateDAO) DAOFactory.build(ReqcomcateDAO.class, user);
		return dao.query(params);
	}
	
	public void doBuildOrderList(String wayid, String mobile, String orderid, Map<String, Integer> dataMap, Date date) throws Exception {
		try {
			Orderreq orderreq = (Orderreq)BOFactory.build(OrderreqBO.class,user);
			OrderreqVO orderreqVO = new OrderreqVO();
			orderreqVO.setCityid(user.getCityid());
			orderreqVO.setMemo(null);
			orderreqVO.setMobileno(mobile);
			orderreqVO.setOrderave("SMS");
			orderreqVO.setReqid(orderid);
			orderreqVO.setReqtime(date);
			orderreqVO.setState((short)1);
			orderreqVO.setWayid(wayid);
			orderreq.doCreate(orderreqVO);
			
			Reqcomcate reqcomcate = (Reqcomcate)BOFactory.build(ReqcomcateBO.class,user);
			for(String brand : dataMap.keySet()){
				ReqcomcateVO reqcomcateVO = new ReqcomcateVO();
				reqcomcateVO.setRecid(null); //自动生成
				reqcomcateVO.setReqid(orderid);
				reqcomcateVO.setComcategory(brand);
				reqcomcateVO.setOrderamt(dataMap.get(brand).longValue());
				reqcomcate.doCreate(reqcomcateVO);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}
}
