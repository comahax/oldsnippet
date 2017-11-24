package com.gmcc.pboss.business.cms.examine.coefficient.control;

import java.io.Serializable;


import com.gmcc.pboss.business.cms.examine.coefficient.persistent.CoefficientDAO;
import com.gmcc.pboss.business.cms.examine.coefficient.persistent.CoefficientListVO;
import com.gmcc.pboss.business.cms.examine.coefficient.persistent.CoefficientVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;



/**
 * <p>Title: CoefficientControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/coefficient/control/CoefficientControlBean"
 name="CoefficientControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class CoefficientBO extends AbstractControlBean
    implements Coefficient {

    public CoefficientVO doCreate(CoefficientVO vo)
        throws Exception {
        try{
			CoefficientDAO dao = (CoefficientDAO) DAOFactory.build(CoefficientDAO.class,user);
            // TODO  set the pk */
            return (CoefficientVO) dao.create(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public void doRemove(CoefficientVO vo)
        throws Exception {
        try{
			CoefficientDAO dao = (CoefficientDAO) DAOFactory.build(CoefficientDAO.class,user);
            dao.remove(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public CoefficientVO doUpdate(CoefficientVO vo)
        throws Exception {
        try{
			CoefficientDAO dao = (CoefficientDAO) DAOFactory.build(CoefficientDAO.class,user);
            return (CoefficientVO) dao.update(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public CoefficientVO doFindByPk(Serializable pk)
        throws Exception {
			CoefficientDAO dao = (CoefficientDAO) DAOFactory.build(CoefficientDAO.class,user);
        return (CoefficientVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(CoefficientListVO params)
        throws Exception {
			CoefficientDAO dao = (CoefficientDAO) DAOFactory.build(CoefficientDAO.class,user);
        return dao.query(params);
    }

	public DataPackage doQueryByNameSql(String nameSql, CoefficientListVO params)
			throws Exception {
		// TODO Auto-generated method stub
		CoefficientDAO dao = (CoefficientDAO) DAOFactory.build(CoefficientDAO.class,user);
		return dao.queryByNamedSqlQuery(nameSql, params);
	}
}
