/**
* auto-generated code
* Wed Oct 18 16:15:34 CST 2006
*/
package com.sunrise.boss.business.cms.postinfolog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.postinfolog.persistent.PostinfologVO;
import com.sunrise.boss.business.cms.postinfolog.persistent.PostinfologDAO;
import com.sunrise.boss.business.cms.postinfolog.persistent.PostinfologListVO;

/**
 * <p>Title: PostinfologControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/postinfolog/control/PostinfologControlBean"
 name="PostinfologControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class PostinfologControlBean extends AbstractControlBean
    implements PostinfologControl {
	private static final long serialVersionUID = 3375819021773277587L;
	public PostinfologVO doCreate(PostinfologVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         PostinfologDAO dao = (PostinfologDAO) DAOFactory.build(PostinfologDAO.class, user);
            return (PostinfologVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(PostinfologVO vo, User user)
        throws Exception {
        try{
         PostinfologDAO dao = (PostinfologDAO) DAOFactory.build(PostinfologDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public PostinfologVO doUpdate(PostinfologVO vo, User user)
        throws Exception {
        try{
         PostinfologDAO dao = (PostinfologDAO) DAOFactory.build(PostinfologDAO.class, user);
            return (PostinfologVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public PostinfologVO doFindByPk(Serializable pk, User user)
        throws Exception {
         PostinfologDAO dao = (PostinfologDAO) DAOFactory.build(PostinfologDAO.class, user);
        return (PostinfologVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(PostinfologListVO params, User user)
        throws Exception {
         PostinfologDAO dao = (PostinfologDAO) DAOFactory.build(PostinfologDAO.class, user);
        return dao.query(params);
    }
}
