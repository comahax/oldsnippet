/**
* auto-generated code
* Thu Mar 15 15:06:14 CST 2012
*/
package com.sunrise.boss.business.cms.reward.adtrewardupload.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.adtrewardupload.persistent.AdtRewarduploadVO;
import com.sunrise.boss.business.cms.reward.adtrewardupload.persistent.AdtRewarduploadDAO;
import com.sunrise.boss.business.cms.reward.adtrewardupload.persistent.AdtRewarduploadListVO;

/**
 * <p>Title: AdtRewarduploadControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/adtrewardupload/control/AdtRewarduploadControlBean"
 name="AdtRewarduploadControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class AdtRewarduploadControlBean extends AbstractControlBean
    implements AdtRewarduploadControl {

    public AdtRewarduploadVO doCreate(AdtRewarduploadVO vo, User user)
        throws Exception {
        try{
			AdtRewarduploadDAO dao = (AdtRewarduploadDAO) DAOFactory.build(AdtRewarduploadDAO.class, user);
            // TODO  set the pk */
            return (AdtRewarduploadVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(AdtRewarduploadVO vo, User user)
        throws Exception {
        try{
			AdtRewarduploadDAO dao = (AdtRewarduploadDAO) DAOFactory.build(AdtRewarduploadDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public AdtRewarduploadVO doUpdate(AdtRewarduploadVO vo, User user)
        throws Exception {
        try{
			AdtRewarduploadDAO dao = (AdtRewarduploadDAO) DAOFactory.build(AdtRewarduploadDAO.class, user);
            return (AdtRewarduploadVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public AdtRewarduploadVO doFindByPk(Serializable pk, User user)
        throws Exception {
			AdtRewarduploadDAO dao = (AdtRewarduploadDAO) DAOFactory.build(AdtRewarduploadDAO.class, user);
        return (AdtRewarduploadVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(AdtRewarduploadListVO params, User user)
        throws Exception {
			AdtRewarduploadDAO dao = (AdtRewarduploadDAO) DAOFactory.build(AdtRewarduploadDAO.class, user);
        return dao.query(params);
    }
}
