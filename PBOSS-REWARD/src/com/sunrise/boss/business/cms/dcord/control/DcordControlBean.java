/**
* auto-generated code
* Wed Aug 15 12:26:00 CST 2012
*/
package com.sunrise.boss.business.cms.dcord.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.dcord.persistent.DcordVO;
import com.sunrise.boss.business.cms.dcord.persistent.DcordDAO;
import com.sunrise.boss.business.cms.dcord.persistent.DcordListVO;
import com.sunrise.boss.business.cms.dcord.persistent.VDcordDAO;
import com.sunrise.boss.business.cms.dcord.persistent.VDcordListVO;

/**
 * <p>Title: DcordControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/dcord/control/DcordControlBean"
 name="DcordControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class DcordControlBean extends AbstractControlBean
    implements DcordControl {

    public DcordVO doCreate(DcordVO vo, User user)
        throws Exception {
        try{
			DcordDAO dao = (DcordDAO) DAOFactory.build(DcordDAO.class, user);
            // TODO  set the pk */
            return (DcordVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(DcordVO vo, User user)
        throws Exception {
        try{
			DcordDAO dao = (DcordDAO) DAOFactory.build(DcordDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public DcordVO doUpdate(DcordVO vo, User user)
        throws Exception {
        try{
			DcordDAO dao = (DcordDAO) DAOFactory.build(DcordDAO.class, user);
            return (DcordVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public DcordVO doFindByPk(Serializable pk, User user)
        throws Exception {
			DcordDAO dao = (DcordDAO) DAOFactory.build(DcordDAO.class, user);
        return (DcordVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(DcordListVO params, User user)
        throws Exception {
			DcordDAO dao = (DcordDAO) DAOFactory.build(DcordDAO.class, user);
        return dao.query(params);
    }
    
    public DataPackage doQuery(VDcordListVO params, User user) throws Exception {
		VDcordDAO dao = (VDcordDAO) DAOFactory.build(VDcordDAO.class, user);
		params.getQueryConditions().put("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
//		DataPackage countdp = dao.queryByNamedSqlQuery("com.sunrise.boss.business.cms.vdcord.persistent.doQuery", params, dao.QUERY_TYPE_COUNT);
//		if(countdp.getRowCount()>params.getThreshhold()){
//			throw new BusinessException("","符合查询条件的数据集超过"+params.getThreshhold()+"条，请增加查询限制，再进行查询");
//		}
		DataPackage datadp = dao.queryByNamedSqlQuery("com.sunrise.boss.business.cms.vdcord.persistent.doQuery", params);//, dao.QUERY_TYPE_DATA
//		datadp.setRowCount(countdp.getRowCount());
		return datadp;
		//return dao.queryByNamedSqlQuery("com.sunrise.boss.business.cms.vdcord.persistent.doQuery", params);
    }
}
