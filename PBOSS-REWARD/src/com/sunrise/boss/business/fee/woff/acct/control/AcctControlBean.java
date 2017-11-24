package com.sunrise.boss.business.fee.woff.acct.control;

import java.io.Serializable;
import java.util.Iterator;

import com.sunrise.boss.business.common.managelog.persistent.ManageLogDAO;
import com.sunrise.boss.business.common.managelog.persistent.OperAction;
import com.sunrise.boss.business.common.managelog.persistent.OperState;
import com.sunrise.boss.business.fee.woff.acct.persistent.AcctDAO;
import com.sunrise.boss.business.fee.woff.acct.persistent.AcctListVO;
import com.sunrise.boss.business.fee.woff.acct.persistent.AcctVO;
import com.sunrise.boss.business.fee.woff.acctset.persistent.AcctSetDAO;
import com.sunrise.boss.business.fee.woff.acctset.persistent.AcctSetVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.BaseListVO;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: AcctControlBean</p>
 * <p>Description:�ʵ���Ŀ����ControlBean </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author xiefufeng
 * @version 1.0
 */

/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/fee/woff/acct/control/AcctControlBean"
*    name="AcctControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class AcctControlBean extends AbstractControlBean
implements AcctControl{
	
	public AcctVO doCreateWithManageLog(AcctVO vo, Long acctsetid, User user) throws BusinessException {
        ManageLogDAO mdao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid());         
        AcctDAO acctDao = (AcctDAO) DAOFactory.build(AcctDAO.class, user.getCityid());         
        try {
            vo = (AcctVO)acctDao.create( vo );
            mdao.manageLog(user, vo.getClass().getName(), OperAction.INSERT, null,
			  		 vo, OperState.SUCCESS);       
            Integer acctlev = vo.getAcctlevel();
            if( acctlev!=null && (acctlev.intValue()==1) ) { //�ʵ���Ŀ�ȼ�Ϊ 1 ��ͨ��Ŀ
            	if( acctsetid!=null ) saveAcctSet( acctsetid, vo.getAcctid(), user );
            }
            
            return vo;
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw new BusinessException(ex.getMessage(),"create");
        }
	}
	
	/**
	 * �ø��²��������ʵ���Ŀ��Ӧ����Ŀ����и���
	 */
	public AcctVO doUpdateWithManageLog(AcctVO newvo, Integer oldAcctlev, User user) throws BusinessException {
        ManageLogDAO mdao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid());  
        AcctDAO acctDao = (AcctDAO) DAOFactory.build(AcctDAO.class, user.getCityid());     
        try {
        	newvo = (AcctVO)acctDao.update(newvo);
        	mdao.manageLog(user, newvo.getClass().getName(), OperAction.UPDATE, null,
			  		 newvo, OperState.SUCCESS); 
        	Integer newAcctLev = newvo.getAcctlevel();
        	if( newAcctLev!=null && oldAcctlev!=null && !newAcctLev.equals(oldAcctlev) ) {
        		if( (oldAcctlev.intValue()==0) && (newAcctLev.intValue()!=0) ){ //ԭ�ʵ���Ŀ�ȼ�Ϊ0 ��Ŀ��,���ʵ���Ŀ�ȼ�Ϊ��0 : 1 ��ͨ��Ŀ, 2 ��ϸ��Ŀ
        			delAcctSet( newvo.getAcctid(), null, user );
        		}else if( (oldAcctlev.intValue()!=0) && (newAcctLev.intValue()==0)){//�ɷ��ʵ���Ŀ���޸�Ϊ�ʵ���Ŀ��
        			delAcctSet( null, newvo.getAcctid(), user );
        		}
        	}

            return newvo; 
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw new BusinessException(ex.getMessage(),"update");
        }
	}
	
	public void doRemoveByPkWithManageLog(Serializable pk, User user) throws BusinessException {
        ManageLogDAO mdao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid());  
        AcctDAO acctDao = (AcctDAO) DAOFactory.build(AcctDAO.class, user.getCityid()); 
        try {
        	AcctVO vo = (AcctVO)acctDao.findByPk(pk);  
        	mdao.manageLog(user, vo.getClass().getName(), OperAction.DELETE, vo,
			  		 null, OperState.SUCCESS); 
        	acctDao.removeByPk(pk);
        	Integer acctlev = vo.getAcctlevel(); //�ʵ���Ŀ�ȼ�
            if( acctlev!=null && (acctlev.intValue()==0) ){ //�ʵ���Ŀ�ȼ�Ϊ0 ��Ŀ��
            	delAcctSet( vo.getAcctid(), null, user );
            }else if( acctlev!=null && (acctlev.intValue()!=0) ){ //�ʵ���Ŀ�ȼ���0 ��Ŀ��
            	delAcctSet( null, vo.getAcctid(), user );
            }
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw new BusinessException(ex.getMessage(),"remove");
        }
		
	}
	
    public AcctVO doFindByPk(Serializable pk, User user) throws Exception {
//        BaseDAO ordinaryDAO = new BaseDAO(AcctVO.class,user.getCityid());
		//change by liwenjing 
		BaseDAO ordinaryDAO=DAOFactory.build(AcctDAO.class, user);	  
		ordinaryDAO.setDbFlag("DB_COMMON", false);
		//ordinaryDAO.setDbFlag("DB_BOSSCOMMON", false);
        return (AcctVO)ordinaryDAO.findByPk(pk);
    }
	
	/**
	 * ɾ���ʵ���Ŀ��Ӧ����Ŀ��(�ʵ���Ŀ�ȼ�Ϊ��ͨ��Ŀʱ),����ɾ���ʵ���Ŀ��Ӧ����ͨ/��ϸ��Ŀ(�ʵ���Ŀ�ȼ�Ϊ��Ŀ��ʱ)
	 */
	public void delAcctSet( Long acctsetid, Long acctid, User user ) throws Exception{
		AcctSetDAO acctsetDao = (AcctSetDAO) DAOFactory.build(AcctSetDAO.class, user.getCityid()); 
		ManageLogDAO mdao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid());
		
		BaseListVO listvo = new BaseListVO();
		AcctSetVO setvo = null;
		listvo.set_pagesize("0");
		if(acctsetid!=null) listvo.getQueryConditions().put("_ne_acctsetid",acctsetid);
		if(acctid!=null) listvo.getQueryConditions().put("_ne_acctid",acctid);
		
		Iterator it = acctsetDao.query( listvo ).getDatas().iterator();
		while( it.hasNext() ){
			setvo = (AcctSetVO)it.next();
			mdao.manageLog(user, setvo.getClass().getName(), OperAction.DELETE, setvo,
			  		 null, OperState.SUCCESS); 
			acctsetDao.remove( setvo );
		}
	}
	
	/**
	 * ���ʵ���Ŀ���浽��Ӧ���ʵ���Ŀ����
	 */
	public void saveAcctSet( Long acctsetid, Long acctid, User user  ) throws Exception{
		AcctSetVO vo = new AcctSetVO();
		AcctSetDAO acctsetDao = (AcctSetDAO) DAOFactory.build(AcctSetDAO.class, user.getCityid()); 
		ManageLogDAO mdao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid());  
		vo.setAcctid( acctid );
		vo.setAcctsetid( acctsetid );
		acctsetDao.create( vo );
		mdao.manageLog(user, vo.getClass().getName(), OperAction.DELETE, null,
		  		 vo, OperState.SUCCESS); 
	}
	
	/**
	 * add by mys
	 */
	public Integer doGetAccttypeByAcctid(Serializable pk, User user) throws Exception{
		
		AcctDAO dao = (AcctDAO) DAOFactory.build(AcctDAO.class, user.getCityid());
		AcctVO vo = (AcctVO)dao.findByPk(pk);  
		if(null != vo && null != vo.getAccttype()){
			return vo.getAccttype();
		}	
		return null ;
	}
	 public DataPackage doQuery(AcctListVO params, User user)
     throws Exception{
		 AcctDAO dao = (AcctDAO) DAOFactory.build(AcctDAO.class, user);
		 dao.setDbFlag("DB_COMMON", false);
		// dao.setDbFlag("DB_BOSSCOMMON", false);
		 return dao.query(params);
	 }
	
	
	
}
