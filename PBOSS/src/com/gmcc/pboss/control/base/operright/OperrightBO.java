/**
 * auto-generated code
 * Mon Jul 13 10:33:51 CST 2009
 */
package com.gmcc.pboss.control.base.operright;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.gmcc.pboss.business.base.operright.OperrightDAO;
import com.gmcc.pboss.business.base.operright.OperrightDBParam;
import com.gmcc.pboss.business.base.operright.OperrightVO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OperrightBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Lee
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/base/operright/control/OperrightBO"
*    name="Operright"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class OperrightBO extends AbstractControlBean implements	Operright {

	public OperrightVO doCreate(OperrightVO vo) throws Exception {
		try {
			OperrightDAO dao = (OperrightDAO) DAOFactory.build(OperrightDAO.class, user);
			// TODO set the pk */
			return (OperrightVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OperrightVO vo) throws Exception {
		try {
			OperrightDAO dao = (OperrightDAO) DAOFactory.build(OperrightDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OperrightDAO dao = (OperrightDAO) DAOFactory.build(OperrightDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OperrightVO doUpdate(OperrightVO vo) throws Exception {
		try {
			OperrightDAO dao = (OperrightDAO) DAOFactory.build(OperrightDAO.class,user);
			return (OperrightVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OperrightVO doFindByPk(Serializable pk) throws Exception {
		OperrightDAO dao = (OperrightDAO) DAOFactory.build(OperrightDAO.class,user);
		return (OperrightVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OperrightDBParam params)
			throws Exception {
		OperrightDAO dao = (OperrightDAO) DAOFactory.build(OperrightDAO.class,user);
		return dao.query(params);
	}

	public boolean doCheckPermission(String oprcode, String permissionId)
			throws Exception {
		// TODO Auto-generated method stub
		OperrightDAO dao = (OperrightDAO) DAOFactory.build(OperrightDAO.class,user);
		OperrightDBParam param = new OperrightDBParam();
		param.getQueryConditions().put("oprcode", oprcode);
		param.getQueryConditions().put("permissionId", permissionId);
		Integer count = (Integer)dao.queryUniqueByNamedSqlQuery("base.operright.hasPermisson", param);
		return count.intValue() > 0;
	}

	public boolean doCheckURIPermission(String oprcode, String currentURI)
			throws Exception {
		// TODO Auto-generated method stub
		OperrightDAO dao = (OperrightDAO) DAOFactory.build(OperrightDAO.class,user);
		OperrightDBParam param = new OperrightDBParam();
		param.getQueryConditions().put("oprcode", oprcode);
		param.getQueryConditions().put("currentURI", currentURI);
		Integer count = (Integer)dao.queryUniqueByNamedSqlQuery("base.operright.hasURIPermisson", param);
		return count.intValue() > 0;
	}
	
	public void doBatchSave(List rightList, List operList) throws Exception{
		try {
			//OperrightDAO dao = (OperrightDAO) DAOFactory.build(OperrightDAO.class,user);
			Operright operright = (Operright)BOFactory.build(OperrightBO.class,user);
			for(Iterator ittRight = rightList.iterator();ittRight.hasNext();){
				String rightid = (String) ittRight.next();
				for(Iterator ittOper = operList.iterator();ittOper.hasNext();){
					String operid = (String)ittOper.next();
					OperrightVO vo = new OperrightVO();
					vo.setOperid(operid);
					vo.setRightid(rightid);
					if((OperrightVO) this.doFindByPk(vo)==null){
						vo.setFlag((byte)1);
						vo.setStatus((byte)1);
						vo.setCreatedate(new Date());
						vo.setStatusdate(PublicUtils.UtilStrToDate("2099-12-31", "yyyy-MM-dd"));
						operright.doCreate(vo);
					}
				}
			}
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}
}
