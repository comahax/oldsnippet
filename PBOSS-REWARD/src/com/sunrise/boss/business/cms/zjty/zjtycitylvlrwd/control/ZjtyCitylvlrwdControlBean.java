/**
* auto-generated code
* Mon Oct 27 11:56:04 CST 2008
*/
package com.sunrise.boss.business.cms.zjty.zjtycitylvlrwd.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtycitylvlrwd.persistent.ZjtyCitylvlrwdVO;
import com.sunrise.boss.business.cms.zjty.zjtycitylvlrwd.persistent.ZjtyCitylvlrwdDAO;
import com.sunrise.boss.business.cms.zjty.zjtycitylvlrwd.persistent.ZjtyCitylvlrwdListVO;

/**
 * <p>Title: ZjtyCitylvlrwdControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtycitylvlrwd/control/ZjtyCitylvlrwdControlBean"
 name="ZjtyCitylvlrwdControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZjtyCitylvlrwdControlBean extends AbstractControlBean
    implements ZjtyCitylvlrwdControl {

    public ZjtyCitylvlrwdVO doCreate(ZjtyCitylvlrwdVO vo, User user)
        throws Exception {
        try{
			ZjtyCitylvlrwdDAO dao = (ZjtyCitylvlrwdDAO) DAOFactory.build(ZjtyCitylvlrwdDAO.class, user);
            // TODO  set the pk */
            return (ZjtyCitylvlrwdVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(ZjtyCitylvlrwdVO vo, User user)
        throws Exception {
        try{
			ZjtyCitylvlrwdDAO dao = (ZjtyCitylvlrwdDAO) DAOFactory.build(ZjtyCitylvlrwdDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ZjtyCitylvlrwdVO doUpdate(ZjtyCitylvlrwdVO vo, User user)
        throws Exception {
        try{
			ZjtyCitylvlrwdDAO dao = (ZjtyCitylvlrwdDAO) DAOFactory.build(ZjtyCitylvlrwdDAO.class, user);
            return (ZjtyCitylvlrwdVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ZjtyCitylvlrwdVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZjtyCitylvlrwdDAO dao = (ZjtyCitylvlrwdDAO) DAOFactory.build(ZjtyCitylvlrwdDAO.class, user);
        return (ZjtyCitylvlrwdVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(ZjtyCitylvlrwdListVO params, User user)
        throws Exception {
			ZjtyCitylvlrwdDAO dao = (ZjtyCitylvlrwdDAO) DAOFactory.build(ZjtyCitylvlrwdDAO.class, user);
        return dao.query(params);
    }
}
