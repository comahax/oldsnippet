/**
* auto-generated code
* Thu Sep 18 15:14:41 CST 2008
*/
package com.sunrise.boss.business.cms.bbc.jfopnmap.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.jfopnmap.persistent.JfopnmapVO;
import com.sunrise.boss.business.cms.bbc.jfopnmap.persistent.JfopnmapDAO;
import com.sunrise.boss.business.cms.bbc.jfopnmap.persistent.JfopnmapListVO;

/**
 * <p>Title: JfopnmapControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/jfopnmap/control/JfopnmapControlBean"
 name="JfopnmapControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class JfopnmapControlBean extends AbstractControlBean
    implements JfopnmapControl {

    public JfopnmapVO doCreate(JfopnmapVO vo, User user)
        throws Exception {
        try{
			JfopnmapDAO dao = (JfopnmapDAO) DAOFactory.build(JfopnmapDAO.class, user);
            // TODO  set the pk */
            return (JfopnmapVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(JfopnmapVO vo, User user)
        throws Exception {
        try{
			JfopnmapDAO dao = (JfopnmapDAO) DAOFactory.build(JfopnmapDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public JfopnmapVO doUpdate(JfopnmapVO vo, User user)
        throws Exception {
        try{
			JfopnmapDAO dao = (JfopnmapDAO) DAOFactory.build(JfopnmapDAO.class, user);
            return (JfopnmapVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public JfopnmapVO doFindByPk(Serializable pk, User user)
        throws Exception {
		JfopnmapDAO dao = (JfopnmapDAO) DAOFactory.build(JfopnmapDAO.class, user);
        return (JfopnmapVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(JfopnmapListVO params, User user)
        throws Exception {
		JfopnmapDAO dao = (JfopnmapDAO) DAOFactory.build(JfopnmapDAO.class, user);
        return dao.query(params);
    }
}
