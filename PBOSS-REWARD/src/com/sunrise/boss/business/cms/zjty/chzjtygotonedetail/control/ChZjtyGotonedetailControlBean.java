/**
* auto-generated code
* Tue Jul 09 08:59:10 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtygotonedetail.control;

import java.io.Serializable;
import org.apache.commons.beanutils.BeanUtils;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtygotonedetail.persistent.ChZjtyGotonedetailVO;
import com.sunrise.boss.business.cms.zjty.chzjtygotonedetail.persistent.ChZjtyGotonedetailDAO;
import com.sunrise.boss.business.cms.zjty.chzjtygotonedetail.persistent.ChZjtyGotonedetailListVO;
import com.sunrise.boss.business.cms.zjty.chzjtygotonedetail.persistent.VChZjtyGotonedetailDAO;
import com.sunrise.boss.business.cms.zjty.chzjtygotonedetail.persistent.VChZjtyGotonedetailListVO;

/**
 * <p>Title: ChZjtyGotonedetailControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/chzjtygotonedetail/control/ChZjtyGotonedetailControlBean"
 name="ChZjtyGotonedetailControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChZjtyGotonedetailControlBean extends AbstractControlBean
    implements ChZjtyGotonedetailControl {

    public ChZjtyGotonedetailVO doCreate(ChZjtyGotonedetailVO vo, User user)
        throws Exception {
        try{
			ChZjtyGotonedetailDAO dao = (ChZjtyGotonedetailDAO) DAOFactory.build(ChZjtyGotonedetailDAO.class, user);
            // TODO  set the pk */
            return (ChZjtyGotonedetailVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChZjtyGotonedetailVO vo, User user)
        throws Exception {
        try{
			ChZjtyGotonedetailDAO dao = (ChZjtyGotonedetailDAO) DAOFactory.build(ChZjtyGotonedetailDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZjtyGotonedetailVO doUpdate(ChZjtyGotonedetailVO vo, User user)
        throws Exception {
        try{
			ChZjtyGotonedetailDAO dao = (ChZjtyGotonedetailDAO) DAOFactory.build(ChZjtyGotonedetailDAO.class, user);
            return (ChZjtyGotonedetailVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZjtyGotonedetailVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChZjtyGotonedetailDAO dao = (ChZjtyGotonedetailDAO) DAOFactory.build(ChZjtyGotonedetailDAO.class, user);
        return (ChZjtyGotonedetailVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChZjtyGotonedetailListVO params, User user)
        throws Exception {
    		ChZjtyGotonedetailDAO dao = (ChZjtyGotonedetailDAO) DAOFactory.build(ChZjtyGotonedetailDAO.class, user);
        return dao.query(params);
    }

	public DataPackage doQueryByView(ChZjtyGotonedetailListVO params, User user)
			throws Exception {
		VChZjtyGotonedetailListVO listVO = new VChZjtyGotonedetailListVO();
		BeanUtils.copyProperties(listVO, params);
		VChZjtyGotonedetailDAO dao = (VChZjtyGotonedetailDAO) DAOFactory.build(VChZjtyGotonedetailDAO.class, user);
        return dao.queryByNamedSqlQuery("querychzjtygotonedetail", listVO);
	}

	public void doDelete(ChZjtyGotonedetailListVO params, User user) throws Exception {
		VChZjtyGotonedetailListVO listVO = new VChZjtyGotonedetailListVO();
		BeanUtils.copyProperties(listVO, params);
		VChZjtyGotonedetailDAO dao = (VChZjtyGotonedetailDAO) DAOFactory.build(VChZjtyGotonedetailDAO.class, user);
        dao.delete(params);
	}

	public long doFindMaxMark(User user) throws Exception {
		VChZjtyGotonedetailDAO dao = (VChZjtyGotonedetailDAO) DAOFactory.build(VChZjtyGotonedetailDAO.class, user);
		return dao.doFindMaxMark();
	}

}
