/**
* auto-generated code
* Fri Dec 08 11:45:12 CST 2006
*/
package com.sunrise.boss.business.cms.fee.yxfeaprv.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.fee.yxfeaprv.persistent.YxfeaprvVO;
import com.sunrise.boss.business.cms.fee.yxfeaprv.persistent.YxfeaprvDAO;
import com.sunrise.boss.business.cms.fee.yxfeaprv.persistent.YxfeaprvListVO;

/**
 * <p>Title: YxfeaprvControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/fee/yxfeaprv/control/YxfeaprvControlBean"
 name="YxfeaprvControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class YxfeaprvControlBean extends AbstractControlBean
    implements YxfeaprvControl {

    public YxfeaprvVO doCreate(YxfeaprvVO vo, User user)
        throws Exception {
        try{
			YxfeaprvDAO dao = (YxfeaprvDAO) DAOFactory.build(YxfeaprvDAO.class, user);
            // TODO  set the pk */
            return (YxfeaprvVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(YxfeaprvVO vo, User user)
        throws Exception {
        try{
			YxfeaprvDAO dao = (YxfeaprvDAO) DAOFactory.build(YxfeaprvDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxfeaprvVO doUpdate(YxfeaprvVO vo, User user)
        throws Exception {
        try{
			YxfeaprvDAO dao = (YxfeaprvDAO) DAOFactory.build(YxfeaprvDAO.class, user);
            return (YxfeaprvVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxfeaprvVO doFindByPk(Serializable pk, User user)
        throws Exception {
			YxfeaprvDAO dao = (YxfeaprvDAO) DAOFactory.build(YxfeaprvDAO.class, user);
        return (YxfeaprvVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(YxfeaprvListVO params, User user)
        throws Exception {
			YxfeaprvDAO dao = (YxfeaprvDAO) DAOFactory.build(YxfeaprvDAO.class, user);
        return dao.query(params);
    }
}
