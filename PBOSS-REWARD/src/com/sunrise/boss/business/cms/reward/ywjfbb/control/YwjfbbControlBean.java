/**
* auto-generated code
* Thu Nov 17 11:10:29 CST 2011
*/
package com.sunrise.boss.business.cms.reward.ywjfbb.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.salecredit.control.SalecreditControl;
import com.sunrise.boss.business.cms.reward.salecredit.control.SalecreditControlBean;
import com.sunrise.boss.business.cms.reward.salecredit.persistent.SalecreditDAO;
import com.sunrise.boss.business.cms.reward.salecredit.persistent.SalecreditListVO;
import com.sunrise.boss.business.cms.reward.ywjfbb.persistent.YwjfbbVO;
import com.sunrise.boss.business.cms.reward.ywjfbb.persistent.YwjfbbDAO;
import com.sunrise.boss.business.cms.reward.ywjfbb.persistent.YwjfbbListVO;

/**
 * <p>Title: YwjfbbControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/ywjfbb/control/YwjfbbControlBean"
 name="YwjfbbControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class YwjfbbControlBean extends AbstractControlBean
    implements YwjfbbControl {

    public YwjfbbVO doCreate(YwjfbbVO vo, User user)
        throws Exception {
        try{
			YwjfbbDAO dao = (YwjfbbDAO) DAOFactory.build(YwjfbbDAO.class, user);
            // TODO  set the pk */
            return (YwjfbbVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(YwjfbbVO vo, User user)
        throws Exception {
        try{
			YwjfbbDAO dao = (YwjfbbDAO) DAOFactory.build(YwjfbbDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public YwjfbbVO doUpdate(YwjfbbVO vo, User user)
        throws Exception {
        try{
			YwjfbbDAO dao = (YwjfbbDAO) DAOFactory.build(YwjfbbDAO.class, user);
            return (YwjfbbVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public YwjfbbVO doFindByPk(Serializable pk, User user)
        throws Exception {
			YwjfbbDAO dao = (YwjfbbDAO) DAOFactory.build(YwjfbbDAO.class, user);
        return (YwjfbbVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(YwjfbbListVO params, User user)
        throws Exception {
			YwjfbbDAO dao = (YwjfbbDAO) DAOFactory.build(YwjfbbDAO.class, user);
//			DataPackage dp0=dao.query2(params,user);
//			
//			SalecreditControl salecreditControl = (SalecreditControl) ControlFactory.build(SalecreditControlBean.class);
//			SalecreditListVO   listVO=new SalecreditListVO();
//			listVO.set_pagesize("0");
//			DataPackage dp=salecreditControl.doQuery(listVO, user);
			
//        return dao.query(params);
        return dao.query2(params,user);
//		return null;
    }
}
