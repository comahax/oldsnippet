/**
* auto-generated code
* Fri Aug 25 11:25:35 CST 2006
*/
package com.sunrise.boss.business.cms.custwaytype.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.custbchtype.persistent.CustbchtypeDAO;
import com.sunrise.boss.business.cms.custbchtype.persistent.CustbchtypeListVO;
import com.sunrise.boss.business.cms.custwaytype.persistent.CustwaytypeVO;
import com.sunrise.boss.business.cms.custwaytype.persistent.CustwaytypeDAO;
import com.sunrise.boss.business.cms.custwaytype.persistent.CustwaytypeListVO;
import com.sunrise.boss.business.cms.way.control.WayControl;
import com.sunrise.boss.business.cms.way.control.WayControlBean;

/**
 * <p>Title: CustwaytypeControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/cms/custwaytype/control/CustwaytypeControlBean"
*    name="CustwaytypeControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class CustwaytypeControlBean extends AbstractControlBean
    implements CustwaytypeControl {

    public CustwaytypeVO doCreate(CustwaytypeVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         CustwaytypeDAO dao = (CustwaytypeDAO) DAOFactory.build(CustwaytypeDAO.class, user );
            return (CustwaytypeVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(CustwaytypeVO vo, User user)
        throws Exception {
        try{
         CustwaytypeDAO dao = (CustwaytypeDAO) DAOFactory.build(CustwaytypeDAO.class, user );
         
         WayControl wayControl = (WayControl)ControlFactory.build( WayControlBean.class);
         DataPackage dp = wayControl.getByCusttype(vo.getCustwaytypecode(), user);
         if(dp.getDatas().size() > 0)
        	 throw new BusinessException("","渠道基本资料引用了该分公司自定义类别，不能删除");
         
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CustwaytypeVO doUpdate(CustwaytypeVO vo, User user)
        throws Exception {
        try{
         CustwaytypeDAO dao = (CustwaytypeDAO) DAOFactory.build(CustwaytypeDAO.class, user );
            return (CustwaytypeVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CustwaytypeVO doFindByPk(Serializable pk, User user)
        throws Exception {
         CustwaytypeDAO dao = (CustwaytypeDAO) DAOFactory.build(CustwaytypeDAO.class, user );
        return (CustwaytypeVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(CustwaytypeListVO params, User user)
        throws Exception {
         CustwaytypeDAO dao = (CustwaytypeDAO) DAOFactory.build(CustwaytypeDAO.class, user );
        return dao.query(params);
    }
    
    public DataPackage doFindByCitycompany(String cityid, User user)
        throws Exception {
    	CustwaytypeDAO dao = (CustwaytypeDAO) DAOFactory.build(CustwaytypeDAO.class, user );
    	CustwaytypeListVO listVO = new CustwaytypeListVO();
        listVO.set_se_citycompid(cityid);
        return dao.query(listVO);
     } 
}
