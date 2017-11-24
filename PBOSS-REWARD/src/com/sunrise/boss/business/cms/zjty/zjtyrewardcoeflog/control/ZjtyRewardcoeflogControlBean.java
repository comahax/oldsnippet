/**
* auto-generated code
* Sat Dec 27 10:22:09 CST 2008
*/
package com.sunrise.boss.business.cms.zjty.zjtyrewardcoeflog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyrewardcoeflog.persistent.ZjtyRewardcoeflogVO;
import com.sunrise.boss.business.cms.zjty.zjtyrewardcoeflog.persistent.ZjtyRewardcoeflogDAO;
import com.sunrise.boss.business.cms.zjty.zjtyrewardcoeflog.persistent.ZjtyRewardcoeflogListVO;

/**
 * <p>Title: ZjtyRewardcoeflogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtyrewardcoeflog/control/ZjtyRewardcoeflogControlBean"
 name="ZjtyRewardcoeflogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZjtyRewardcoeflogControlBean extends AbstractControlBean
    implements ZjtyRewardcoeflogControl {

    public ZjtyRewardcoeflogVO doCreate(ZjtyRewardcoeflogVO vo, User user)
        throws Exception {
        try{
			ZjtyRewardcoeflogDAO dao = (ZjtyRewardcoeflogDAO) DAOFactory.build(ZjtyRewardcoeflogDAO.class, user);
            // TODO  set the pk */
            return (ZjtyRewardcoeflogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(ZjtyRewardcoeflogVO vo, User user)
        throws Exception {
        try{
			ZjtyRewardcoeflogDAO dao = (ZjtyRewardcoeflogDAO) DAOFactory.build(ZjtyRewardcoeflogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ZjtyRewardcoeflogVO doUpdate(ZjtyRewardcoeflogVO vo, User user)
        throws Exception {
        try{
			ZjtyRewardcoeflogDAO dao = (ZjtyRewardcoeflogDAO) DAOFactory.build(ZjtyRewardcoeflogDAO.class, user);
            return (ZjtyRewardcoeflogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ZjtyRewardcoeflogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZjtyRewardcoeflogDAO dao = (ZjtyRewardcoeflogDAO) DAOFactory.build(ZjtyRewardcoeflogDAO.class, user);
        return (ZjtyRewardcoeflogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(ZjtyRewardcoeflogListVO params, User user)
        throws Exception {
			ZjtyRewardcoeflogDAO dao = (ZjtyRewardcoeflogDAO) DAOFactory.build(ZjtyRewardcoeflogDAO.class, user);
        return dao.query(params);
    }
}
