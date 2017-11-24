package com.sunrise.boss.business.resmanage.filedef.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.resmanage.filedef.persistent.FiledefVO;
import com.sunrise.boss.business.resmanage.filedef.persistent.FiledefDAO;
import com.sunrise.boss.business.resmanage.filedef.persistent.FiledefListVO;

/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/resmanage/filedef/control/FiledefControlBean"
*    name="FiledefControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class FiledefControlBean extends AbstractControlBean
    implements FiledefControl {

    public FiledefVO doCreate(FiledefVO vo, User user)
        throws Exception {
        try{
			FiledefDAO dao = (FiledefDAO) DAOFactory.build(FiledefDAO.class, user.getCityid());
            // TODO  set the pk */
            return (FiledefVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(FiledefVO vo, User user)
        throws Exception {
        try{
			FiledefDAO dao = (FiledefDAO) DAOFactory.build(FiledefDAO.class, user.getCityid());
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public FiledefVO doUpdate(FiledefVO vo, User user)
        throws Exception {
        try{
			FiledefDAO dao = (FiledefDAO) DAOFactory.build(FiledefDAO.class, user.getCityid());
            return (FiledefVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public FiledefVO doFindByPk(Serializable pk, User user)
        throws Exception {
			FiledefDAO dao = (FiledefDAO) DAOFactory.build(FiledefDAO.class, user.getCityid());
        return (FiledefVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(FiledefListVO params, User user)
        throws Exception {
			FiledefDAO dao = (FiledefDAO) DAOFactory.build(FiledefDAO.class, user.getCityid());
        return dao.query(params);
    }
}
