/**
 * auto-generated code
 * Thu Dec 29 17:51:44 CST 2011
 */
package com.gmcc.pboss.control.channel.bondaudit;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import org.hibernate.Session;

import com.gmcc.pboss.business.channel.bondaudit.BondauditDAO;
import com.gmcc.pboss.business.channel.bondaudit.BondauditDBParam;
import com.gmcc.pboss.business.channel.bondaudit.BondauditVO;
import com.gmcc.pboss.business.channel.bondform.BondformVO;
import com.gmcc.pboss.control.channel.bondform.BondformBO;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: BondauditBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class BondauditBO extends AbstractControlBean implements
		Bondaudit {

	public BondauditVO doCreate(BondauditVO vo) throws Exception {
		try {
			BondauditDAO dao = (BondauditDAO) DAOFactory.build(BondauditDAO.class, user);
			// TODO set the pk */
			return (BondauditVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(BondauditVO vo) throws Exception {
		try {
			BondauditDAO dao = (BondauditDAO) DAOFactory.build(BondauditDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			BondauditDAO dao = (BondauditDAO) DAOFactory.build(BondauditDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BondauditVO doUpdate(BondauditVO vo) throws Exception {
		try {
			//更新审核信息，
			//审核人为当前工号，
			//审核时间为当前时间，
			//审核状态、审核意见取页面值。
			Date date = new Date(System.currentTimeMillis());
			
			BondauditDAO dao = (BondauditDAO) DAOFactory.build(BondauditDAO.class,user);
			
			BondauditVO bondauditVO = this.doFindByPk(vo.getSeqid());
			bondauditVO.setAuditor(user.getOprcode());
			bondauditVO.setAudittime(date);
			bondauditVO.setState(vo.getState());
			bondauditVO.setOpinion(vo.getOpinion());
			dao.update(bondauditVO);
			
			
			BondformBO bondformBO = (BondformBO) BOFactory.build(BondformBO.class,user);
			BondformVO bondformVO = bondformBO.doFindByPk(bondauditVO.getFormid());
			
			//如果审核通过时，更新审核保证金申请单表中的状态为“已审核”。不通过时更新状态为“审核不通过”。
			if(bondauditVO.getState().equals("1")){
				bondformVO.setState(Short.parseShort("3"));
			}
			else if(bondauditVO.getState().equals("2")){
				bondformVO.setState(Short.parseShort("2"));
			}
			bondformBO.doUpdate(bondformVO);
			
			return bondauditVO;
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BondauditVO doFindByPk(Serializable pk) throws Exception {
		BondauditDAO dao = (BondauditDAO) DAOFactory.build(BondauditDAO.class,user);
		return (BondauditVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BondauditDBParam params)
			throws Exception {
		BondauditDAO dao = (BondauditDAO) DAOFactory.build(BondauditDAO.class,user);
		return dao.query(params);
	}
	
	
	public String doQuerySeq() throws Exception {
		String sql = "select FX_SW_BONDAUDIT_SEQ.Nextval from dual";

			Session session = SessionUtils.currentSession(this.getUser().getCityid());
			Connection conn = session.connection();
			PreparedStatement ps = conn.prepareStatement(sql);
		
			ResultSet rs = ps.executeQuery();
			rs.next();
			String s = rs.getInt(1)+"";
			ps.close();	
		return s;
	}
	
}
