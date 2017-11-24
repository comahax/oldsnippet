/**
* auto-generated code
* Thu Jul 28 10:25:58 CST 2011
*/
package com.sunrise.boss.business.cms.rewardsms.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.cntycompany.control.CntycompanyControl;
import com.sunrise.boss.business.cms.cntycompany.control.CntycompanyControlBean;
import com.sunrise.boss.business.cms.cntycompany.persistent.CntycompanyListVO;
import com.sunrise.boss.business.cms.cntycompany.persistent.CntycompanyVO;
import com.sunrise.boss.business.cms.rewardsms.persistent.RewardsmsVO;
import com.sunrise.boss.business.cms.rewardsms.persistent.RewardsmsDAO;
import com.sunrise.boss.business.cms.rewardsms.persistent.RewardsmsListVO;
import java.util.Iterator;

/**
 * <p>Title: RewardsmsControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/rewardsms/control/RewardsmsControlBean"
 name="RewardsmsControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RewardsmsControlBean extends AbstractControlBean
    implements RewardsmsControl {

    public RewardsmsVO doCreate(RewardsmsVO vo, User user)
        throws Exception {
        try{
			RewardsmsDAO dao = (RewardsmsDAO) DAOFactory.build(RewardsmsDAO.class, user);
            // TODO  set the pk */
            return (RewardsmsVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(RewardsmsVO vo, User user)
        throws Exception {
        try{
			RewardsmsDAO dao = (RewardsmsDAO) DAOFactory.build(RewardsmsDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RewardsmsVO doUpdate(RewardsmsVO vo, User user)
        throws Exception {
        try{
			RewardsmsDAO dao = (RewardsmsDAO) DAOFactory.build(RewardsmsDAO.class, user);
            return (RewardsmsVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RewardsmsVO doFindByPk(Serializable pk, User user)
        throws Exception {
			RewardsmsDAO dao = (RewardsmsDAO) DAOFactory.build(RewardsmsDAO.class, user);
        return (RewardsmsVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(RewardsmsListVO params, User user)
        throws Exception {
			RewardsmsDAO dao = (RewardsmsDAO) DAOFactory.build(RewardsmsDAO.class, user);
        return dao.query(params);
    }
    
    public RewardsmsVO doCreate1(RewardsmsVO vo, User user)
	    throws Exception {
	    try{
				RewardsmsDAO dao = (RewardsmsDAO) DAOFactory.build(RewardsmsDAO.class, user);
				// 当分公司为空的时候，新增所有分公司的信息
				if (vo.getCountyid() == null || "".equals(vo.getCountyid())) {
					// 查询该地市下所有分公司的信息
					CntycompanyControl control = (CntycompanyControl) ControlFactory.build(CntycompanyControlBean.class);
					CntycompanyListVO listvo = new CntycompanyListVO();
					listvo.set_se_citycompid(SessionFactoryRouter.conversionCityid(user.getCityid()));
					DataPackage dp = control.doQuery(listvo, user);
					// 解包
					Iterator it = dp.getDatas().iterator();
					while (it.hasNext()) {
						CntycompanyVO newvo = (CntycompanyVO)(it.next());
						RewardsmsVO vo1 = new RewardsmsVO();
						org.apache.commons.beanutils.BeanUtils.copyProperties(vo1,
								vo);
						// 当同一个地市，一个分公司的信息已经存在的时候跳过
						if (this.check(vo1,newvo.getCountycompid(),user)) {
							continue;
						}
						vo1.setCountyid(newvo.getCountycompid());
						dao.create(vo1);
					}
					
				} else {
					return (RewardsmsVO) dao.create(vo);
				}
		        // TODO  set the pk */
		        return vo;
		    } catch(Exception ex){
		        sessionContext.setRollbackOnly();
		        throw ex;
	    }
    }
    
    public boolean check(RewardsmsVO vo, String countyid, User user) throws Exception {
    	try{
    		// 查询是否已经存在了相同的信息
    		RewardsmsControl control = (RewardsmsControl) ControlFactory.build(RewardsmsControlBean.class);
    		RewardsmsListVO listvo = new RewardsmsListVO();
    		listvo.set_se_countyid(countyid);
    		listvo.set_se_calcmonth(vo.getCalcmonth());
    		DataPackage dp = control.doQuery(listvo, user);
    		
    		return (dp!=null && dp.getRowCount()>0);
    		
    	} catch(Exception ex){
    		return false;
    	}
    }
}
