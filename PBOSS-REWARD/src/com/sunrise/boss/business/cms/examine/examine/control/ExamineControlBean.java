/**
* auto-generated code
* Wed Nov 18 16:17:06 CST 2009
*/
package com.sunrise.boss.business.cms.examine.examine.control;

import java.io.Serializable;
import java.util.Iterator;

import com.sunrise.boss.business.cms.examine.examine.persistent.ExamineDAO;
import com.sunrise.boss.business.cms.examine.examine.persistent.ExamineListVO;
import com.sunrise.boss.business.cms.examine.examine.persistent.ExamineVO;
import com.sunrise.boss.business.cms.examine.exmnitem.persistent.ExmnitemListVO;
import com.sunrise.boss.business.cms.examine.exmnitem.persistent.ExmnitemVO;
import com.sunrise.boss.business.cms.examine.exmnperiod.persistent.ExmnperiodListVO;
import com.sunrise.boss.business.cms.examine.exmnperiod.persistent.ExmnperiodVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.cms.examine.exmnitem.ExmnitemDelegate;
import com.sunrise.boss.delegate.cms.examine.exmnperiod.ExmnperiodDelegate;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ExamineControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/examine/control/ExamineControlBean"
 name="ExamineControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ExamineControlBean extends AbstractControlBean
    implements ExamineControl {

    public ExamineVO doCreate(ExamineVO vo, User user)
        throws Exception {
        try{
			ExamineDAO dao = (ExamineDAO) DAOFactory.build(ExamineDAO.class, user);
            // TODO  set the pk */
            return (ExamineVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ExamineVO vo, User user)
        throws Exception {
        try{
			ExamineDAO dao = (ExamineDAO) DAOFactory.build(ExamineDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExamineVO doUpdate(ExamineVO vo, User user)
        throws Exception {
        try{
			ExamineDAO dao = (ExamineDAO) DAOFactory.build(ExamineDAO.class, user);
            return (ExamineVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExamineVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ExamineDAO dao = (ExamineDAO) DAOFactory.build(ExamineDAO.class, user);
        return (ExamineVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExamineListVO params, User user)
        throws Exception {
			ExamineDAO dao = (ExamineDAO) DAOFactory.build(ExamineDAO.class, user);
        return dao.query(params);
    }
    public void doRemoveExamine(String selectValue, User user)
    throws Exception{
    	try {
			ExamineDAO dao = (ExamineDAO) DAOFactory.build(ExamineDAO.class, user);
			String[] strs=selectValue.split("\\|");
			//
			ExmnitemDelegate exmnitemDelegate =new ExmnitemDelegate();	
			ExmnitemListVO exmnitemListVO = new ExmnitemListVO(); 
			exmnitemListVO.set_ne_exmnid(strs[0]);
			exmnitemListVO.set_pagesize("0");
			Iterator itemIt=exmnitemDelegate.doQuery(exmnitemListVO, user).getDatas().iterator();
			while(itemIt.hasNext()){
				exmnitemDelegate.doRemoveItem((Serializable)itemIt.next(),strs[1],user);//删除考核项信息，包括考核指标设置信息
			}
			ExmnperiodDelegate exmnperiodDelegate =new ExmnperiodDelegate();
			ExmnperiodListVO exmnperiodListVO = new ExmnperiodListVO(); 
			exmnitemListVO.set_ne_exmnid(strs[0]);
			exmnitemListVO.set_pagesize("0");
			Iterator exmnperiodIt=exmnperiodDelegate.doQuery(exmnperiodListVO, user).getDatas().iterator();
			while(itemIt.hasNext()){
				exmnperiodDelegate.doRemove((ExmnperiodVO)exmnperiodIt.next(),user);//删除考核项信息，包括考核指标设置信息
			}
			ExamineVO vo=this.doFindByPk(Long.valueOf(strs[0]), user);
			this.doRemove(vo, user);
		} catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public DataPackage doQueryExamineList(ExamineListVO params,User user)throws Exception {
    	ExamineDAO dao = (ExamineDAO) DAOFactory.build(ExamineDAO.class, user);
    	//params.set_se_state("1");
    	return dao.queryExamineList(params,SessionFactoryRouter.conversionCityid(user.getCityid()));
    }
}
