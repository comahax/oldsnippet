/**
* auto-generated code
* Mon Feb 21 10:20:06 CST 2011
*/
package com.sunrise.boss.business.cms.reward.registersimvw.control;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.registersimvw.persistent.RegistersimvwVO;
import com.sunrise.boss.business.cms.reward.registersimvw.persistent.RegistersimvwDAO;
import com.sunrise.boss.business.cms.reward.registersimvw.persistent.RegistersimvwListVO;

/**
 * <p>Title: RegistersimvwControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/registersimvw/control/RegistersimvwControlBean"
 name="RegistersimvwControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RegistersimvwControlBean extends AbstractControlBean
    implements RegistersimvwControl {

    public RegistersimvwVO doCreate(RegistersimvwVO vo, User user)
        throws Exception {
        try{
			RegistersimvwDAO dao = (RegistersimvwDAO) DAOFactory.build(RegistersimvwDAO.class, user);
            // TODO  set the pk */
            return (RegistersimvwVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(RegistersimvwVO vo, User user)
        throws Exception {
        try{
			RegistersimvwDAO dao = (RegistersimvwDAO) DAOFactory.build(RegistersimvwDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RegistersimvwVO doUpdate(RegistersimvwVO vo, User user)
        throws Exception {
        try{
			RegistersimvwDAO dao = (RegistersimvwDAO) DAOFactory.build(RegistersimvwDAO.class, user);
            return (RegistersimvwVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RegistersimvwVO doFindByPk(Serializable pk, User user)
        throws Exception {
			RegistersimvwDAO dao = (RegistersimvwDAO) DAOFactory.build(RegistersimvwDAO.class, user);
        return (RegistersimvwVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(RegistersimvwListVO params, User user)
        throws Exception {
			RegistersimvwDAO dao = (RegistersimvwDAO) DAOFactory.build(RegistersimvwDAO.class, user);
			String starttimeStr1 = params.get_dnl_activedate();
			String endtimeStr1 = params.get_dnm_activedate();
			DataPackage dp = null;
			if(!StringUtils.isEmpty(starttimeStr1)&&!StringUtils.isEmpty(endtimeStr1))
			{
				params.getQueryConditions().put("STARTIME1", (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(starttimeStr1));
				params.getQueryConditions().put("ENDTIME1", (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(endtimeStr1));
				params.set_dnl_activedate(null);
				params.set_dnm_activedate(null);
				dp = dao.queryByNamedSqlQuery("reward.registersimvw.registersimvw.activedate", params);
				params.set_dnl_activedate(starttimeStr1);
				params.set_dnm_activedate(endtimeStr1);
			} else {
				dp = dao.queryByNamedSqlQuery("reward.registersimvw.registersimvw", params);
			}
			
        return dp;
    }
}
