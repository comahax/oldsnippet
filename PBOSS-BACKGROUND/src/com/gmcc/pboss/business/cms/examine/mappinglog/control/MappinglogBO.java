package com.gmcc.pboss.business.cms.examine.mappinglog.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.mappinglog.persistent.MappinglogDAO;
import com.gmcc.pboss.business.cms.examine.mappinglog.persistent.MappinglogListVO;
import com.gmcc.pboss.business.cms.examine.mappinglog.persistent.MappinglogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: MappinglogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/mappinglog/control/MappinglogControlBean"
 name="MappinglogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class MappinglogBO extends AbstractControlBean
    implements Mappinglog {

    public MappinglogVO doCreate(MappinglogVO vo)
        throws Exception {
        try{
			MappinglogDAO dao = (MappinglogDAO) DAOFactory.build(MappinglogDAO.class, user);
            // TODO  set the pk */
            return (MappinglogVO) dao.create(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public void doRemove(MappinglogVO vo)
        throws Exception {
        try{
			MappinglogDAO dao = (MappinglogDAO) DAOFactory.build(MappinglogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public MappinglogVO doUpdate(MappinglogVO vo)
        throws Exception {
        try{
			MappinglogDAO dao = (MappinglogDAO) DAOFactory.build(MappinglogDAO.class, user);
            return (MappinglogVO) dao.update(vo);
        } catch(Exception ex){ 
            throw new JOPException(ex);
        }
    }

    public MappinglogVO doFindByPk(Serializable pk)
        throws Exception {
			MappinglogDAO dao = (MappinglogDAO) DAOFactory.build(MappinglogDAO.class, user);
        return (MappinglogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(MappinglogListVO params)
        throws Exception {
			MappinglogDAO dao = (MappinglogDAO) DAOFactory.build(MappinglogDAO.class, user);
        return dao.query(params);
    }
}
