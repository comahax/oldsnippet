/**
* auto-generated code
* Mon Oct 27 10:18:24 CST 2008
*/
package com.sunrise.boss.business.cms.zjty.zjtylvlrwd.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtylvlrwd.persistent.ZjtyLvlrwdVO;
import com.sunrise.boss.business.cms.zjty.zjtylvlrwd.persistent.ZjtyLvlrwdDAO;
import com.sunrise.boss.business.cms.zjty.zjtylvlrwd.persistent.ZjtyLvlrwdListVO;

/**
 * <p>Title: ZjtyLvlrwdControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtylvlrwd/control/ZjtyLvlrwdControlBean"
 name="ZjtyLvlrwdControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZjtyLvlrwdControlBean extends AbstractControlBean
    implements ZjtyLvlrwdControl {

    public ZjtyLvlrwdVO doCreate(ZjtyLvlrwdVO vo, User user)
        throws Exception {
        try{
			ZjtyLvlrwdDAO dao = (ZjtyLvlrwdDAO) DAOFactory.build(ZjtyLvlrwdDAO.class, user);
            // TODO  set the pk */
            return (ZjtyLvlrwdVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(ZjtyLvlrwdVO vo, User user)
        throws Exception {
        try{
			ZjtyLvlrwdDAO dao = (ZjtyLvlrwdDAO) DAOFactory.build(ZjtyLvlrwdDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ZjtyLvlrwdVO doUpdate(ZjtyLvlrwdVO vo, User user)
        throws Exception {
        try{
			ZjtyLvlrwdDAO dao = (ZjtyLvlrwdDAO) DAOFactory.build(ZjtyLvlrwdDAO.class, user);
            return (ZjtyLvlrwdVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ZjtyLvlrwdVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZjtyLvlrwdDAO dao = (ZjtyLvlrwdDAO) DAOFactory.build(ZjtyLvlrwdDAO.class, user);
        return (ZjtyLvlrwdVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(ZjtyLvlrwdListVO params, User user)
        throws Exception {
			ZjtyLvlrwdDAO dao = (ZjtyLvlrwdDAO) DAOFactory.build(ZjtyLvlrwdDAO.class, user);
        return dao.query(params);
    }
}
