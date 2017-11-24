/**
* auto-generated code
* Wed Feb 24 14:10:39 CST 2010
*/
package com.sunrise.boss.business.cms.waystarmonth.control;

import java.io.Serializable;

import org.apache.commons.beanutils.BeanUtils;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waystarmonth.persistent.WaystarmonthVO;
import com.sunrise.boss.business.cms.waystarmonth.persistent.WaystarmonthDAO;
import com.sunrise.boss.business.cms.waystarmonth.persistent.WaystarmonthListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;

/**
 * <p>Title: WaystarmonthControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/waystarmonth/control/WaystarmonthControlBean"
 name="WaystarmonthControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class WaystarmonthControlBean extends AbstractControlBean
    implements WaystarmonthControl {

    public WaystarmonthVO doCreate(WaystarmonthVO vo, User user)
        throws Exception {
        try{
			WaystarmonthDAO dao = (WaystarmonthDAO) DAOFactory.build(WaystarmonthDAO.class, user);
            // TODO  set the pk */
            return (WaystarmonthVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(WaystarmonthVO vo, User user)
        throws Exception {
        try{
			WaystarmonthDAO dao = (WaystarmonthDAO) DAOFactory.build(WaystarmonthDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public WaystarmonthVO doUpdate(WaystarmonthVO vo, User user)
        throws Exception {
        try{
			WaystarmonthDAO dao = (WaystarmonthDAO) DAOFactory.build(WaystarmonthDAO.class, user);
            return (WaystarmonthVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public WaystarmonthVO doFindByPk(Serializable pk, User user)
        throws Exception {
			WaystarmonthDAO dao = (WaystarmonthDAO) DAOFactory.build(WaystarmonthDAO.class, user);
        return (WaystarmonthVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(WaystarmonthListVO params, User user)
        throws Exception {
			WaystarmonthDAO dao = (WaystarmonthDAO) DAOFactory.build(WaystarmonthDAO.class, user);
        return dao.query(params);
    }
    
    public String queryEftmonthtype(User user) throws Exception{
    	String eftmonthtype= "";
    	CommonDelegate comdelegate = new CommonDelegate(SysparamVO.class);
    	Serializable pkVO=new SysparamVO();
		BeanUtils.setProperty(pkVO, "systemid","52");
		BeanUtils.setProperty(pkVO, "paramtype","channel");
		SysparamVO vo=(SysparamVO)comdelegate.doFindByPk(pkVO, user);
		eftmonthtype = vo.getParamvalue();
    	return eftmonthtype;
    }
}
