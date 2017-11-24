/**
 * auto-generated code
 * Tue Jul 07 15:33:22 CST 2009
 */
package com.gmcc.pboss.control.channel.adimarea;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.adimarea.AdimareaDBParam;
import com.gmcc.pboss.business.channel.adimarea.AdimareaDAO;
import com.gmcc.pboss.business.channel.adimarea.AdimareaVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: AdimareaBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/channel/adimarea/control/AdimareaBO"
*    name="Adimarea"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class AdimareaBO extends AbstractControlBean implements
		Adimarea {

	public AdimareaVO doCreate(AdimareaVO vo) throws Exception {
		try {
			AdimareaDAO dao = (AdimareaDAO) DAOFactory.build(AdimareaDAO.class, user);
			// TODO set the pk */
			return (AdimareaVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(AdimareaVO vo) throws Exception {
		try {
			AdimareaDAO dao = (AdimareaDAO) DAOFactory.build(AdimareaDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			AdimareaDAO dao = (AdimareaDAO) DAOFactory.build(AdimareaDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AdimareaVO doUpdate(AdimareaVO vo) throws Exception {
		try {
			AdimareaDAO dao = (AdimareaDAO) DAOFactory.build(AdimareaDAO.class,user);
			return (AdimareaVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AdimareaVO doFindByPk(Serializable pk) throws Exception {
		AdimareaDAO dao = (AdimareaDAO) DAOFactory.build(AdimareaDAO.class,user);
		return (AdimareaVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(AdimareaDBParam params)
			throws Exception {
		AdimareaDAO dao = (AdimareaDAO) DAOFactory.build(AdimareaDAO.class,user);
		return dao.query(params);
	}
	
	public List doQueryUpperada(String adacode) throws Exception {
		AdimareaDAO dao = (AdimareaDAO) DAOFactory.build(AdimareaDAO.class,
				user);
		List list = dao.doQuerySuberada(adacode);
		List result = new ArrayList();
		for (Iterator it = list.iterator(); it.hasNext();) {
			AdimareaVO vo = (AdimareaVO) it.next();
			if (!StringUtils.equals(adacode, vo.getAdacode())) {
				result.add(vo);
			}
		}
		return result;
	}
}
