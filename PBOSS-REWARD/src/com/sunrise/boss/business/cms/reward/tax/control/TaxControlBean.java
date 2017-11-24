/**
* auto-generated code
* Fri May 27 12:04:23 CST 2011
*/
package com.sunrise.boss.business.cms.reward.tax.control;

import java.io.Serializable;

import org.apache.commons.beanutils.BeanUtils;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.tax.persistent.TaxVO;
import com.sunrise.boss.business.cms.reward.tax.persistent.TaxDAO;
import com.sunrise.boss.business.cms.reward.tax.persistent.TaxListVO;
import com.sunrise.boss.business.common.sysparam.control.SysparamControl;
import com.sunrise.boss.business.common.sysparam.control.SysparamControlBean;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;

/**
 * <p>Title: TaxControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/tax/control/TaxControlBean"
 name="TaxControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class TaxControlBean extends AbstractControlBean
    implements TaxControl {

    public TaxVO doCreate(TaxVO vo, User user)
        throws Exception {
        try{
			TaxDAO dao = (TaxDAO) DAOFactory.build(TaxDAO.class, user);
            // 填入值除以100入库。
			Float vle = vo.getValue();
			if (vle != null) vo.setValue(vle/100);
			TaxVO newvo = (TaxVO)dao.create(vo);
			
			// 取得系统参数数据
	    	SysparamControl control = (SysparamControl) ControlFactory.build(SysparamControlBean.class);
	    	SysparamVO sysvo = new SysparamVO();
	    	sysvo.setSystemid(new Long(90));
	    	sysvo.setParamtype("taxrule");
	    	SysparamVO newsysvo = control.doFindByPk(sysvo,user);
	    	if (newvo.getTaxtype() != null) 
	    		newsysvo.setParamvalue(vo.getTaxtype().toString());
	    	// 更新系统参数
	    	control.doUpdate2(newsysvo, user);
			
            return newvo;
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(TaxVO vo, User user)
        throws Exception {
        try{
			TaxDAO dao = (TaxDAO) DAOFactory.build(TaxDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public TaxVO doUpdate(TaxVO vo, User user)
        throws Exception {
        try{
			TaxDAO dao = (TaxDAO) DAOFactory.build(TaxDAO.class, user);
			Float vle = vo.getValue();
			// 填入值除以100入库。
			if (vle != null) vo.setValue(vle/100);
			TaxVO newvo = (TaxVO) dao.update(vo);
			
			// 取得系统参数数据
	    	SysparamControl control = (SysparamControl) ControlFactory.build(SysparamControlBean.class);
	    	SysparamVO sysvo = new SysparamVO();
	    	sysvo.setSystemid(new Long(90));
	    	sysvo.setParamtype("taxrule");
	    	SysparamVO newsysvo = control.doFindByPk(sysvo,user);
	    	if (newvo.getTaxtype() != null) 
	    		newsysvo.setParamvalue(vo.getTaxtype().toString());
	    	// 更新系统参数
	    	control.doUpdate2(newsysvo, user);
	    	
            return newvo;
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public TaxVO doFindByPk(Serializable pk, User user)
        throws Exception {
			TaxDAO dao = (TaxDAO) DAOFactory.build(TaxDAO.class, user);
        return (TaxVO) dao.findByPk(pk);
    }
    
    public TaxVO doFindByPk2(Serializable pk, User user)
	    throws Exception {
			TaxDAO dao = (TaxDAO) DAOFactory.build(TaxDAO.class, user);
			TaxVO vo = (TaxVO) dao.findByPk(pk);
			TaxVO newvo = new TaxVO();
			BeanUtils.copyProperties(newvo, vo);
			Float vlu = new Float(0);
			if (vo.getValue() != null) vlu = vo.getValue()*100;
			newvo.setValue(vlu);
	    return newvo;
	}

    public DataPackage doQuery(TaxListVO params, User user)
        throws Exception {
			TaxDAO dao = (TaxDAO) DAOFactory.build(TaxDAO.class, user);
        return dao.queryByNamedSqlQuery("cms.reward.tax", params);
    }
}
