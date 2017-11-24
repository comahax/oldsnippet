package com.gmcc.pboss.business.cms.waylog.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.waylog.persistent.WaylogDAO;
import com.gmcc.pboss.business.cms.waylog.persistent.WaylogListVO;
import com.gmcc.pboss.business.cms.waylog.persistent.WaylogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: WaylogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
/**
 * @ejb.bean
 *    local-jndi-name="com/sunrise/boss/business/cms/waylog/control/WaylogControlBean"
 *    name="WaylogControl"
 *    view-type="local"
 *    type="Stateless"
 *
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class WaylogBO extends AbstractControlBean
    implements Waylog {
	private static final long serialVersionUID = -4063396310081388973L;
	public WaylogVO doCreate(WaylogVO vo)
        throws Exception {
        try{
            // TODO  set the pk */
         WaylogDAO dao = (WaylogDAO) DAOFactory.build(WaylogDAO.class, user);
            return (WaylogVO) dao.create(vo);
        } catch(Exception ex){
            throw new Exception(ex);
        }
    }
    public void doRemove(WaylogVO vo)
        throws Exception {
        try{
         WaylogDAO dao = (WaylogDAO) DAOFactory.build(WaylogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            throw new Exception(ex);
        }
    }
    public WaylogVO doUpdate(WaylogVO vo)
        throws Exception {
        try{
         WaylogDAO dao = (WaylogDAO) DAOFactory.build(WaylogDAO.class, user);
            return (WaylogVO) dao.update(vo);
        } catch(Exception ex){
            throw new Exception(ex);
        }
    }
    public WaylogVO doFindByPk(Serializable pk)
        throws Exception {
         WaylogDAO dao = (WaylogDAO) DAOFactory.build(WaylogDAO.class, user);
        return (WaylogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(WaylogListVO params)
        throws Exception {
         WaylogDAO dao = (WaylogDAO) DAOFactory.build(WaylogDAO.class, user);
        return dao.query(params);
    }
}
