/**
* auto-generated code
* Mon Mar 05 15:38:34 CST 2012
*/
package com.sunrise.boss.business.cms.zjty.zjtyimportrec.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyimportrec.persistent.ZjtyImportrecVO;
import com.sunrise.boss.business.cms.zjty.zjtyimportrec.persistent.ZjtyImportrecDAO;
import com.sunrise.boss.business.cms.zjty.zjtyimportrec.persistent.ZjtyImportrecListVO;

/**
 * <p>Title: ZjtyImportrecControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtyimportrec/control/ZjtyImportrecControlBean"
 name="ZjtyImportrecControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZjtyImportrecControlBean extends AbstractControlBean
    implements ZjtyImportrecControl {

    public ZjtyImportrecVO doCreate(ZjtyImportrecVO vo, User user)
        throws Exception {
        try{
			ZjtyImportrecDAO dao = (ZjtyImportrecDAO) DAOFactory.build(ZjtyImportrecDAO.class, user);
            // TODO  set the pk */
            return (ZjtyImportrecVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ZjtyImportrecVO vo, User user)
        throws Exception {
        try{
			ZjtyImportrecDAO dao = (ZjtyImportrecDAO) DAOFactory.build(ZjtyImportrecDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyImportrecVO doUpdate(ZjtyImportrecVO vo, User user)
        throws Exception {
        try{
			ZjtyImportrecDAO dao = (ZjtyImportrecDAO) DAOFactory.build(ZjtyImportrecDAO.class, user);
            return (ZjtyImportrecVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyImportrecVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZjtyImportrecDAO dao = (ZjtyImportrecDAO) DAOFactory.build(ZjtyImportrecDAO.class, user);
        return (ZjtyImportrecVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ZjtyImportrecListVO params, User user)
        throws Exception {
			ZjtyImportrecDAO dao = (ZjtyImportrecDAO) DAOFactory.build(ZjtyImportrecDAO.class, user);
        return dao.query(params);
    }
}
