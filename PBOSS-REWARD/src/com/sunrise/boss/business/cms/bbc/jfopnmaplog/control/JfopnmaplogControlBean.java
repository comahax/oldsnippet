/**
* auto-generated code
* Thu Sep 18 15:19:11 CST 2008
*/
package com.sunrise.boss.business.cms.bbc.jfopnmaplog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.jfopnmaplog.persistent.JfopnmaplogVO;
import com.sunrise.boss.business.cms.bbc.jfopnmaplog.persistent.JfopnmaplogDAO;
import com.sunrise.boss.business.cms.bbc.jfopnmaplog.persistent.JfopnmaplogListVO;

/**
 * <p>Title: JfopnmaplogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/jfopnmaplog/control/JfopnmaplogControlBean"
 name="JfopnmaplogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class JfopnmaplogControlBean extends AbstractControlBean
    implements JfopnmaplogControl {

    public JfopnmaplogVO doCreate(JfopnmaplogVO vo, User user)
        throws Exception {
        try{
			JfopnmaplogDAO dao = (JfopnmaplogDAO) DAOFactory.build(JfopnmaplogDAO.class, user);
            // TODO  set the pk */
            return (JfopnmaplogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(JfopnmaplogVO vo, User user)
        throws Exception {
        try{
        	JfopnmaplogDAO dao = (JfopnmaplogDAO) DAOFactory.build(JfopnmaplogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public JfopnmaplogVO doUpdate(JfopnmaplogVO vo, User user)
        throws Exception {
        try{
        	JfopnmaplogDAO dao = (JfopnmaplogDAO) DAOFactory.build(JfopnmaplogDAO.class, user);
            return (JfopnmaplogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public JfopnmaplogVO doFindByPk(Serializable pk, User user)
        throws Exception {
    	JfopnmaplogDAO dao = (JfopnmaplogDAO) DAOFactory.build(JfopnmaplogDAO.class, user);
        return (JfopnmaplogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(JfopnmaplogListVO params, User user)
        throws Exception {
    	JfopnmaplogDAO dao = (JfopnmaplogDAO) DAOFactory.build(JfopnmaplogDAO.class, user);
        return dao.query(params);
    }
}
