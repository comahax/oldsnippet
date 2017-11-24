/**
* auto-generated code
* Thu Jan 31 15:08:13 CST 2008
*/
package com.sunrise.boss.business.cms.rewardasse.control;

import java.io.Serializable;

import org.apache.commons.beanutils.BeanUtils;

import com.sunrise.boss.business.cms.rewardasse.persistent.RewardasseDAO;
import com.sunrise.boss.business.cms.rewardasse.persistent.RewardasseListVO;
import com.sunrise.boss.business.cms.rewardasse.persistent.RewardasseVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: RewardasseControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author xiangyin
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/rewardasse/control/RewardasseControlBean"
 name="RewardasseControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RewardasseControlBean extends AbstractControlBean
    implements RewardasseControl {

    public RewardasseVO doCreate(RewardasseVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         RewardasseDAO dao = (RewardasseDAO) DAOFactory.build(RewardasseDAO.class, user);
            return (RewardasseVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(RewardasseVO vo, User user)
        throws Exception {
        try{
         RewardasseDAO dao = (RewardasseDAO) DAOFactory.build(RewardasseDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RewardasseVO doUpdate(RewardasseVO vo, User user)
        throws Exception {
        try{
         RewardasseDAO dao = (RewardasseDAO) DAOFactory.build(RewardasseDAO.class, user);
            return (RewardasseVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RewardasseVO doFindByPk(Serializable pk, User user)
        throws Exception {
         RewardasseDAO dao = (RewardasseDAO) DAOFactory.build(RewardasseDAO.class, user);
        return (RewardasseVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(RewardasseListVO params, User user)
        throws Exception {
         RewardasseDAO dao = (RewardasseDAO) DAOFactory.build(RewardasseDAO.class, user);
        return dao.query(params);
    }
    
    public boolean doQueryRewardtype(Integer rewardtype, User user)
			throws Exception {
		try {
			boolean cando = false;

			switch (rewardtype) {
			case 0:
				cando = this.queryParamvalue(new Long(2), user);
				break;
			case 1:
				cando = this.queryParamvalue(new Long(3), user);
				break;
			case 2:
				cando = this.queryParamvalue(new Long(4), user);
				break;
			case 3:
				cando = this.queryParamvalue(new Long(5), user);
				break;
			case 4:
				cando = this.queryParamvalue(new Long(6), user);
				break;
			case 5:
				cando = this.queryParamvalue(new Long(7), user);
				break;
			case 6:
				cando = this.queryParamvalue(new Long(8), user);
				break;
			case 7:
				cando = this.queryParamvalue(new Long(9), user);
				break;
			case 8:
				cando = this.queryParamvalue(new Long(10), user);
				break;
			case 30:
				cando = this.queryParamvalue(new Long(11), user);
				break;
			case 99:
				cando = this.queryParamvalue(new Long(12), user);
				break;
			case 51:
				cando = this.queryParamvalue(new Long("13"), user);
				break;
			case 52:
				cando = this.queryParamvalue(new Long("14"), user);
				break;
			case 53:
				cando = this.queryParamvalue(new Long("15"), user);
				break;
			case 54:
				cando = this.queryParamvalue(new Long("16"), user);
				break;	
			case 55:
				cando = this.queryParamvalue(new Long("17"), user);
				break;	
			}
			if (cando) {
				return true;
			}
		} catch (Exception e) {
			sessionContext.setRollbackOnly();
			throw e;
		}
		return false;
	}
    
    public Boolean queryParamvalue(Long systemid, User user) throws Exception {
		try {
			Serializable pkVO = new SysparamVO();
			CommonDelegate comdelegate = new CommonDelegate(SysparamVO.class);
			BeanUtils.setProperty(pkVO, "systemid", systemid);
			BeanUtils.setProperty(pkVO, "paramtype", "pboss_kh");
			SysparamVO sysparamVO = (SysparamVO) comdelegate.doFindByPk(pkVO,
					user);
			if ("-1".equals(sysparamVO.getParamvalue())) {
				return true;
			}
		} catch (Exception e) {
			sessionContext.setRollbackOnly();
			throw e;
		}
		return false;
	}
    
    public DataPackage doQuery4Syn(RewardasseListVO params, User user)
	    throws Exception {
	     RewardasseDAO dao = (RewardasseDAO) DAOFactory.build(RewardasseDAO.class, user);
	    return dao.getSynAssegrade(params);
	}
}
