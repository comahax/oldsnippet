/**
* auto-generated code
* Tue Oct 17 17:37:23 CST 2006
*/
package com.sunrise.boss.business.cms.citycomlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.citycomlog.persistent.CitycomlogVO;
import com.sunrise.boss.business.cms.citycomlog.persistent.CitycomlogDAO;
import com.sunrise.boss.business.cms.citycomlog.persistent.CitycomlogListVO;

/**
 * <p>Title: CitycomlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/cms/citycomlog/control/CitycomlogControlBean"
*    name="CitycomlogControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class CitycomlogControlBean extends AbstractControlBean
    implements CitycomlogControl {
	private static final long serialVersionUID = 3599376336482098854L;
	public CitycomlogVO doCreate(CitycomlogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         CitycomlogDAO dao = (CitycomlogDAO) DAOFactory.build(CitycomlogDAO.class, user);
            return (CitycomlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(CitycomlogVO vo, User user)
        throws Exception {
        try{
         CitycomlogDAO dao = (CitycomlogDAO) DAOFactory.build(CitycomlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CitycomlogVO doUpdate(CitycomlogVO vo, User user)
        throws Exception {
        try{
         CitycomlogDAO dao = (CitycomlogDAO) DAOFactory.build(CitycomlogDAO.class, user);
            return (CitycomlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CitycomlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         CitycomlogDAO dao = (CitycomlogDAO) DAOFactory.build(CitycomlogDAO.class, user);
        return (CitycomlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(CitycomlogListVO params, User user)
        throws Exception {
         CitycomlogDAO dao = (CitycomlogDAO) DAOFactory.build(CitycomlogDAO.class, user);
        return dao.query(params);
    }
}
