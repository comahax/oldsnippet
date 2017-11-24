/**
 * auto-generated code
 * Sun Nov 01 15:18:07 CST 2009
 */
package com.gmcc.pboss.control.channel.flowname;

import java.io.Serializable;

import com.gmcc.pboss.business.base.operator.OperatorDAO;
import com.gmcc.pboss.business.channel.flowname.FlownameDAO;
import com.gmcc.pboss.business.channel.flowname.FlownameDBParam;
import com.gmcc.pboss.business.channel.flowname.FlownameVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: FlownameBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class FlownameBO extends AbstractControlBean implements
		Flowname {

	public FlownameVO doCreate(FlownameVO vo) throws Exception {
		try {
			if(vo.getOprcode()!=null)
				{
				OperatorDAO   operatorDAO = (OperatorDAO) DAOFactory.build(OperatorDAO.class, user);
				if(operatorDAO.findByPk(vo.getOprcode())==null)
				{
					throw new JOPException("所输入的工号不存在:"+vo.getOprcode());
				}
				}
			FlownameDAO dao = (FlownameDAO) DAOFactory.build(FlownameDAO.class, user);
			// TODO set the pk */
			return (FlownameVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(FlownameVO vo) throws Exception {
		try {
			FlownameDAO dao = (FlownameDAO) DAOFactory.build(FlownameDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			FlownameDAO dao = (FlownameDAO) DAOFactory.build(FlownameDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public FlownameVO doUpdate(FlownameVO vo) throws Exception {
		try {
			FlownameDAO dao = (FlownameDAO) DAOFactory.build(FlownameDAO.class,user);
			return (FlownameVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public FlownameVO doFindByPk(Serializable pk) throws Exception {
		FlownameDAO dao = (FlownameDAO) DAOFactory.build(FlownameDAO.class,user);
		return (FlownameVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(FlownameDBParam params)
			throws Exception {
		FlownameDAO dao = (FlownameDAO) DAOFactory.build(FlownameDAO.class,user);
		return dao.query(params);
	}
}
