package com.gmcc.pboss.business.cms.examine.examine.control;


import java.io.Serializable;
import java.util.Iterator;

import com.gmcc.pboss.business.cms.examine.examine.persistent.ExamineDAO;
import com.gmcc.pboss.business.cms.examine.examine.persistent.ExamineListVO;
import com.gmcc.pboss.business.cms.examine.examine.persistent.ExamineVO;
import com.gmcc.pboss.business.cms.examine.exmnitem.control.Exmnitem;
import com.gmcc.pboss.business.cms.examine.exmnitem.control.ExmnitemBO;
import com.gmcc.pboss.business.cms.examine.exmnitem.persistent.ExmnitemListVO;
import com.gmcc.pboss.business.cms.examine.exmnperiod.control.Exmnperiod;
import com.gmcc.pboss.business.cms.examine.exmnperiod.control.ExmnperiodBO;
import com.gmcc.pboss.business.cms.examine.exmnperiod.persistent.ExmnperiodListVO;
import com.gmcc.pboss.business.cms.examine.exmnperiod.persistent.ExmnperiodVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;


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
public class ExamineBO extends AbstractControlBean
    implements ExamineControl {

    public ExamineVO doCreate(ExamineVO vo)
        throws Exception {
        try{
			ExamineDAO dao = (ExamineDAO) DAOFactory.build(ExamineDAO.class, user);
            // TODO  set the pk */
            return (ExamineVO) dao.create(vo);
        } catch(Exception ex){
            
            throw ex;
        }
    }

    public void doRemove(ExamineVO vo)
        throws Exception {
        try{
			ExamineDAO dao = (ExamineDAO) DAOFactory.build(ExamineDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            
            throw ex;
        }
    }

    public ExamineVO doUpdate(ExamineVO vo)
        throws Exception {
        try{
			ExamineDAO dao = (ExamineDAO) DAOFactory.build(ExamineDAO.class, user);
            return (ExamineVO) dao.update(vo);
        } catch(Exception ex){
            
            throw ex;
        }
    }

    public ExamineVO doFindByPk(Serializable pk)
        throws Exception {
			ExamineDAO dao = (ExamineDAO) DAOFactory.build(ExamineDAO.class, user);
        return (ExamineVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExamineListVO params)
        throws Exception {
			ExamineDAO dao = (ExamineDAO) DAOFactory.build(ExamineDAO.class, user);
        return dao.query(params);
    }
    public void doRemoveExamine(String selectValue)
    throws Exception{
    	ExamineDAO dao = (ExamineDAO) DAOFactory.build(ExamineDAO.class, user);
    	String[] strs=selectValue.split("\\|");
    	//
    	Exmnitem exmnitemDelegate = (ExmnitemBO) BOFactory.build(ExmnitemBO.class,user);
    	ExmnitemListVO exmnitemListVO = new ExmnitemListVO(); 
    	exmnitemListVO.set_ne_exmnid(strs[0]);
    	exmnitemListVO.set_pagesize("0");
    	Iterator itemIt=exmnitemDelegate.doQuery(exmnitemListVO).getDatas().iterator();
    	while(itemIt.hasNext()){
    		exmnitemDelegate.doRemoveItem((Serializable)itemIt.next(),strs[1]);//删除考核项信息，包括考核指标设置信息
    	}
    	Exmnperiod exmnperiodDelegate =(ExmnperiodBO)BOFactory.build(ExmnperiodBO.class,user);
    	ExmnperiodListVO exmnperiodListVO = new ExmnperiodListVO(); 
    	exmnitemListVO.set_ne_exmnid(strs[0]);
    	exmnitemListVO.set_pagesize("0");
    	Iterator exmnperiodIt=exmnperiodDelegate.doQuery(exmnperiodListVO).getDatas().iterator();
    	while(itemIt.hasNext()){
    		exmnperiodDelegate.doRemove((ExmnperiodVO)exmnperiodIt.next());//删除考核项信息，包括考核指标设置信息
    	}
    	dao.removeByPk(Long.valueOf(strs[0]));
    }
    
    
    public DataPackage doQueryBySqlName(String sqlName,ExamineListVO param) throws Exception{
    	ExamineDAO dao = (ExamineDAO) DAOFactory.build(ExamineDAO.class, user);
		return dao.queryByNamedSqlQuery(sqlName, param);		
    }
    
    public DataPackage doQueryBySql(String queryString,ExamineListVO params) throws Exception{
    	ExamineDAO dao = (ExamineDAO) DAOFactory.build(ExamineDAO.class, user);
    	return dao.queryBySql(queryString, params,null);
    }
}
