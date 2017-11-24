/**
* auto-generated code
* Tue Nov 22 15:32:38 CST 2011
*/
package com.sunrise.boss.business.cms.reward.ywjfjlmxb.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.ywjfjlmxb.persistent.YwjfjlmxbVO;
import com.sunrise.boss.business.cms.reward.ywjfjlmxb.persistent.YwjfjlmxbDAO;
import com.sunrise.boss.business.cms.reward.ywjfjlmxb.persistent.YwjfjlmxbListVO;

/**
 * <p>Title: YwjfjlmxbControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/ywjfjlmxb/control/YwjfjlmxbControlBean"
 name="YwjfjlmxbControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class YwjfjlmxbControlBean extends AbstractControlBean
    implements YwjfjlmxbControl {

    public YwjfjlmxbVO doCreate(YwjfjlmxbVO vo, User user)
        throws Exception {
        try{
			YwjfjlmxbDAO dao = (YwjfjlmxbDAO) DAOFactory.build(YwjfjlmxbDAO.class, user);
            // TODO  set the pk */
            return (YwjfjlmxbVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(YwjfjlmxbVO vo, User user)
        throws Exception {
        try{
			YwjfjlmxbDAO dao = (YwjfjlmxbDAO) DAOFactory.build(YwjfjlmxbDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public YwjfjlmxbVO doUpdate(YwjfjlmxbVO vo, User user)
        throws Exception {
        try{
			YwjfjlmxbDAO dao = (YwjfjlmxbDAO) DAOFactory.build(YwjfjlmxbDAO.class, user);
            return (YwjfjlmxbVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public YwjfjlmxbVO doFindByPk(Serializable pk, User user)
        throws Exception {
			YwjfjlmxbDAO dao = (YwjfjlmxbDAO) DAOFactory.build(YwjfjlmxbDAO.class, user);
        return (YwjfjlmxbVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(YwjfjlmxbListVO params, User user,String[] ids)
        throws Exception {
    	
			YwjfjlmxbDAO dao = (YwjfjlmxbDAO) DAOFactory.build(YwjfjlmxbDAO.class, user);
        return dao.query2(params,user,ids);
    }
}
