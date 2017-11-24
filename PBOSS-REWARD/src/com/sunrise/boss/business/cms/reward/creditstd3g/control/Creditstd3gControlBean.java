/**
* auto-generated code
* Sat Dec 08 10:23:53 CST 2012
*/
package com.sunrise.boss.business.cms.reward.creditstd3g.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.citycompany.persistent.CitycompanyDAO;
import com.sunrise.boss.business.cms.citycompany.persistent.CitycompanyVO;
import com.sunrise.boss.business.cms.reward.creditstd3g.persistent.Creditstd3gVO;
import com.sunrise.boss.business.cms.reward.creditstd3g.persistent.Creditstd3gDAO;
import com.sunrise.boss.business.cms.reward.creditstd3g.persistent.Creditstd3gListVO;
import com.sunrise.boss.business.cms.reward.creditstd3g.persistent.VCreditstd3gDAO;

/**
 * <p>Title: Creditstd3gControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/creditstd3g/control/Creditstd3gControlBean"
 name="Creditstd3gControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class Creditstd3gControlBean extends AbstractControlBean
    implements Creditstd3gControl {

    public Creditstd3gVO doCreate(Creditstd3gVO vo, User user)
        throws Exception {
        try{
			Creditstd3gDAO dao = (Creditstd3gDAO) DAOFactory.build(Creditstd3gDAO.class, user);
            // TODO  set the pk */
            return (Creditstd3gVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(Creditstd3gVO vo, User user)
        throws Exception {
        try{
			Creditstd3gDAO dao = (Creditstd3gDAO) DAOFactory.build(Creditstd3gDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public Creditstd3gVO doUpdate(Creditstd3gVO vo, User user)
        throws Exception {
        try{
			Creditstd3gDAO dao = (Creditstd3gDAO) DAOFactory.build(Creditstd3gDAO.class, user);
            return (Creditstd3gVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public Creditstd3gVO doFindByPk(Serializable pk, User user)
        throws Exception {
			Creditstd3gDAO dao = (Creditstd3gDAO) DAOFactory.build(Creditstd3gDAO.class, user);
        return (Creditstd3gVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(Creditstd3gListVO params, User user)
        throws Exception {
			Creditstd3gDAO dao = (Creditstd3gDAO) DAOFactory.build(Creditstd3gDAO.class, user);
        return dao.query(params);
    }
    
    public DataPackage doQuerystdset(Creditstd3gListVO params, User user)
    	throws Exception {
		VCreditstd3gDAO dao = (VCreditstd3gDAO) DAOFactory.build(VCreditstd3gDAO.class, user);
		String city = SessionFactoryRouter.conversionCityid(user.getCityid());
		CitycompanyDAO cdao = (CitycompanyDAO)DAOFactory.build(CitycompanyDAO.class, user);
		CitycompanyVO cityvo = (CitycompanyVO)cdao.findByPk(city);
		if(cityvo==null || cityvo.getCitylevel()==null){
			throw new Exception("工号所属地市级别为空");
		}
		params.getQueryConditions().put("cityid", user.getCityid());
		params.getQueryConditions().put("citylevel", cityvo.getCitylevel());

		return dao.queryByNamedSqlQuery("com.sunrise.boss.business.cms.reward.creditstd3g.persistent.doQuerystdset", params);
    }
}
