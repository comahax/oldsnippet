/**
* auto-generated code
* Tue Jul 09 12:03:37 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtynogotonedetail.control;

import java.io.Serializable;
import org.apache.commons.beanutils.BeanUtils;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtynogotonedetail.persistent.ChZjtyNogotonedetailVO;
import com.sunrise.boss.business.cms.zjty.chzjtynogotonedetail.persistent.ChZjtyNogotonedetailDAO;
import com.sunrise.boss.business.cms.zjty.chzjtynogotonedetail.persistent.ChZjtyNogotonedetailListVO;
import com.sunrise.boss.business.cms.zjty.chzjtynogotonedetail.persistent.VChZjtyNogotonedetailDAO;
import com.sunrise.boss.business.cms.zjty.chzjtynogotonedetail.persistent.VChZjtyNogotonedetailListVO;

/**
 * <p>Title: ChZjtyNogotonedetailControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/chzjtynogotonedetail/control/ChZjtyNogotonedetailControlBean"
 name="ChZjtyNogotonedetailControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChZjtyNogotonedetailControlBean extends AbstractControlBean
    implements ChZjtyNogotonedetailControl {

    public ChZjtyNogotonedetailVO doCreate(ChZjtyNogotonedetailVO vo, User user)
        throws Exception {
        try{
			ChZjtyNogotonedetailDAO dao = (ChZjtyNogotonedetailDAO) DAOFactory.build(ChZjtyNogotonedetailDAO.class, user);
            // TODO  set the pk */
            return (ChZjtyNogotonedetailVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChZjtyNogotonedetailVO vo, User user)
        throws Exception {
        try{
			ChZjtyNogotonedetailDAO dao = (ChZjtyNogotonedetailDAO) DAOFactory.build(ChZjtyNogotonedetailDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZjtyNogotonedetailVO doUpdate(ChZjtyNogotonedetailVO vo, User user)
        throws Exception {
        try{
			ChZjtyNogotonedetailDAO dao = (ChZjtyNogotonedetailDAO) DAOFactory.build(ChZjtyNogotonedetailDAO.class, user);
            return (ChZjtyNogotonedetailVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZjtyNogotonedetailVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChZjtyNogotonedetailDAO dao = (ChZjtyNogotonedetailDAO) DAOFactory.build(ChZjtyNogotonedetailDAO.class, user);
        return (ChZjtyNogotonedetailVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChZjtyNogotonedetailListVO params, User user)
        throws Exception {
    		ChZjtyNogotonedetailDAO dao = (ChZjtyNogotonedetailDAO) DAOFactory.build(ChZjtyNogotonedetailDAO.class, user);
        return dao.query(params);
    }

	public DataPackage doQueryByView(ChZjtyNogotonedetailListVO params,
			User user) throws Exception {
		VChZjtyNogotonedetailListVO listVO = new VChZjtyNogotonedetailListVO();
    	BeanUtils.copyProperties(listVO, params);
		VChZjtyNogotonedetailDAO dao = (VChZjtyNogotonedetailDAO) DAOFactory.build(VChZjtyNogotonedetailDAO.class, user);
        return dao.queryByNamedSqlQuery("querychzjtynogotonedetail", listVO);
	}

	public void doDelete(ChZjtyNogotonedetailListVO params,
			User user) throws Exception {
		VChZjtyNogotonedetailListVO listVO = new VChZjtyNogotonedetailListVO();
    	BeanUtils.copyProperties(listVO, params);
		VChZjtyNogotonedetailDAO dao = (VChZjtyNogotonedetailDAO) DAOFactory.build(VChZjtyNogotonedetailDAO.class, user);
		dao.delete(listVO);
	}

	public long doFindMaxMark(User user) throws Exception {
		VChZjtyNogotonedetailDAO dao = (VChZjtyNogotonedetailDAO) DAOFactory.build(VChZjtyNogotonedetailDAO.class, user);
		return dao.doFindMaxMark();
	}
}
