/**
* auto-generated code
* Fri Aug 11 09:34:48 CST 2006
*/
package com.sunrise.boss.business.fee.woff.woffrule.control;

import java.io.Serializable;
import java.util.Locale;

import com.sunrise.boss.business.fee.woff.woffrule.exception.WriteOffException;
import com.sunrise.boss.business.fee.woff.woffrule.persistent.WoffRuleDAO;
import com.sunrise.boss.business.fee.woff.woffrule.persistent.WoffRuleListVO;
import com.sunrise.boss.business.fee.woff.woffrule.persistent.WoffRuleVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import  com.sunrise.boss.common.utils.i18n.I18nMessage;
/**
 * <p>Title: IbRuWoffruleVoControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author liwenjing
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/fee/woff/woffrule/control/WoffRuleControlBean"
*    name="WoffRuleControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class WoffRuleControlBean extends AbstractControlBean
    implements WoffRuleControl {
	private static Locale locale=new Locale("zh","CN");
//    private static WoffRuleDAO dao = (WoffRuleDAO) DAOFactory.build(WoffRuleDAO.class);
    public WoffRuleVO doCreate(WoffRuleVO vo, User user)
        throws Exception {
    	WoffRuleDAO dao = (WoffRuleDAO) DAOFactory.build(WoffRuleDAO.class,user.getCityid());

    	if(dao.findByPk(vo)!=null)throw new WriteOffException(I18nMessage.getString("com.sunrise.boss.resource.i18n.fee.woff.WoffRule", "duplicateRecode",locale));
        try{
            return (WoffRuleVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(WoffRuleVO vo, User user)
        throws Exception {
        try{
        	WoffRuleDAO dao = (WoffRuleDAO) DAOFactory.build(WoffRuleDAO.class,user.getCityid());
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WoffRuleVO doUpdate(WoffRuleVO vo, User user)
        throws Exception {
        try{
        	WoffRuleDAO dao = (WoffRuleDAO) DAOFactory.build(WoffRuleDAO.class,user.getCityid());
            return (WoffRuleVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WoffRuleVO doFindByPk(Serializable pk, User user)
        throws Exception {
    	WoffRuleDAO dao = (WoffRuleDAO) DAOFactory.build(WoffRuleDAO.class,user.getCityid());
        return (WoffRuleVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(WoffRuleListVO params, User user)
        throws Exception {
    	WoffRuleDAO dao = (WoffRuleDAO) DAOFactory.build(WoffRuleDAO.class,user.getCityid());
        return dao.query(params);
    }
}
