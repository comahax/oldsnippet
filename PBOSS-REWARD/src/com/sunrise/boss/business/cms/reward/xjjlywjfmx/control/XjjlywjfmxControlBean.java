/**
* auto-generated code
* Thu Mar 15 09:32:40 CST 2012
*/
package com.sunrise.boss.business.cms.reward.xjjlywjfmx.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.xjjlywjfmx.persistent.XjjlywjfmxVO;
import com.sunrise.boss.business.cms.reward.xjjlywjfmx.persistent.XjjlywjfmxDAO;
import com.sunrise.boss.business.cms.reward.xjjlywjfmx.persistent.XjjlywjfmxListVO;

/**
 * <p>Title: XjjlywjfmxControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/xjjlywjfmx/control/XjjlywjfmxControlBean"
 name="XjjlywjfmxControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class XjjlywjfmxControlBean extends AbstractControlBean
    implements XjjlywjfmxControl {

    public XjjlywjfmxVO doCreate(XjjlywjfmxVO vo, User user)
        throws Exception {
        try{
			XjjlywjfmxDAO dao = (XjjlywjfmxDAO) DAOFactory.build(XjjlywjfmxDAO.class, user);
            // TODO  set the pk */
            return (XjjlywjfmxVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(XjjlywjfmxVO vo, User user)
        throws Exception {
        try{
			XjjlywjfmxDAO dao = (XjjlywjfmxDAO) DAOFactory.build(XjjlywjfmxDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public XjjlywjfmxVO doUpdate(XjjlywjfmxVO vo, User user)
        throws Exception {
        try{
			XjjlywjfmxDAO dao = (XjjlywjfmxDAO) DAOFactory.build(XjjlywjfmxDAO.class, user);
            return (XjjlywjfmxVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public XjjlywjfmxVO doFindByPk(Serializable pk, User user)
        throws Exception {
			XjjlywjfmxDAO dao = (XjjlywjfmxDAO) DAOFactory.build(XjjlywjfmxDAO.class, user);
        return (XjjlywjfmxVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(XjjlywjfmxListVO params, User user)
        throws Exception {
			XjjlywjfmxDAO dao = (XjjlywjfmxDAO) DAOFactory.build(XjjlywjfmxDAO.class, user);
        return dao.query2(params,user);
    }
}
