/**
* auto-generated code
* Thu Oct 26 17:37:18 CST 2006
*/
package com.sunrise.boss.business.zifee.yxplansplitvaluelog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplansplitvaluelog.persistent.YxplanSplitValuelogVO;
import com.sunrise.boss.business.zifee.yxplansplitvaluelog.persistent.YxplanSplitValuelogDAO;
import com.sunrise.boss.business.zifee.yxplansplitvaluelog.persistent.YxplanSplitValuelogListVO;

/**
 * <p>Title: YxplanSplitValuelogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/zifee/yxplansplitvaluelog/control/YxplanSplitValuelogControlBean"
 name="YxplanSplitValuelogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class YxplanSplitValuelogControlBean extends AbstractControlBean
    implements YxplanSplitValuelogControl {

    public YxplanSplitValuelogVO doCreate(YxplanSplitValuelogVO vo, User user)
        throws Exception {
        try{
			YxplanSplitValuelogDAO dao = (YxplanSplitValuelogDAO) DAOFactory.build(YxplanSplitValuelogDAO.class, user.getCityid());
            // TODO  set the pk */
            return (YxplanSplitValuelogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(YxplanSplitValuelogVO vo, User user)
        throws Exception {
        try{
			YxplanSplitValuelogDAO dao = (YxplanSplitValuelogDAO) DAOFactory.build(YxplanSplitValuelogDAO.class, user.getCityid());
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxplanSplitValuelogVO doUpdate(YxplanSplitValuelogVO vo, User user)
        throws Exception {
        try{
			YxplanSplitValuelogDAO dao = (YxplanSplitValuelogDAO) DAOFactory.build(YxplanSplitValuelogDAO.class, user.getCityid());
            return (YxplanSplitValuelogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxplanSplitValuelogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			YxplanSplitValuelogDAO dao = (YxplanSplitValuelogDAO) DAOFactory.build(YxplanSplitValuelogDAO.class, user.getCityid());
        return (YxplanSplitValuelogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(YxplanSplitValuelogListVO params, User user)
        throws Exception {
			YxplanSplitValuelogDAO dao = (YxplanSplitValuelogDAO) DAOFactory.build(YxplanSplitValuelogDAO.class, user.getCityid());
        return dao.query(params);
    }
}
