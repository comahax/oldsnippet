/**
* auto-generated code
* Sat Nov 28 17:57:55 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnaudit.control;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.sunrise.boss.business.cms.examine.exmnaudit.persistent.ExmnauditDAO;
import com.sunrise.boss.business.cms.examine.exmnaudit.persistent.ExmnauditListVO;
import com.sunrise.boss.business.cms.examine.exmnaudit.persistent.ExmnauditVO;
import com.sunrise.boss.business.cms.examine.exmnaudit.persistent.VExmnauditDAO;
import com.sunrise.boss.business.cms.examine.itemgraded.persistent.ItemgradedVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.examine.exmnaudit.ExmnauditDelegate;
import com.sunrise.boss.delegate.cms.examine.itemgraded.ItemgradedDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ExmnauditControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/exmnaudit/control/ExmnauditControlBean"
 name="ExmnauditControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ExmnauditControlBean extends AbstractControlBean
    implements ExmnauditControl {

    public ExmnauditVO doCreate(ExmnauditVO vo, User user)
        throws Exception {
        try{
			ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class, user);
            // TODO  set the pk */
            return (ExmnauditVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ExmnauditVO vo, User user)
        throws Exception {
        try{
			ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExmnauditVO doUpdate(ExmnauditVO vo, User user)
        throws Exception {
        try{
			ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class, user);
            return (ExmnauditVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExmnauditVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class, user);
        return (ExmnauditVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExmnauditListVO params, User user)
        throws Exception {
			ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class, user);
        return dao.query(params);
    }
    /**
     * ���ݿ��˵Ǽ�ID�����ѯ��֤�ܷ��ջ�
     * @param itemgradeds
     * @return ���ܱ����յĿ��˵ǼǱ�ʶ����
     * @throws Exception
     */
	 public List doValidateCallbackInfo(String[] itemgradeds,User user) throws Exception{
		 ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class, user);
		 return dao.doValidateCallbackInfo(itemgradeds, user.getOpercode(), user);
	 }
	 /**
     * ɾ�����յĿ�����Ϣ�����Ϣ
     * @param itemgradeds
     * @param oprcode
     * @throws Exception
     */
    public void doRemoveCallbackInfo(String[] itemgradeds,String oprcode,User user) throws Exception{
    	ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class, user);
    	dao.removeCallbackInfo(itemgradeds, oprcode, user);
    }
    /**
	  * �������пɻ��յĿ��������ֱ�ʶ��Ϣ
	  */
	 public List doFindAllCallbackItemgradeds(User user)throws Exception{
		 ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class, user);
		 return dao.doFindAllCallbackItemgradeds(user);
	 }
	 /**
	 * ���ҿ�����Ϣ��˺Ϳ��������Ϣ�б�
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryExmnauditList(ExmnauditListVO param,User user) throws Exception{
		String oprcode=user.getOpercode();//��ǰ�û�����
		param.set_se_auditor(oprcode);//�����[AUDITOR]��Ĭ��Ϊ��ǰ����
		VExmnauditDAO dao = (VExmnauditDAO) DAOFactory.build(VExmnauditDAO.class,user);
		/*ItemgradedListVO itemgradedListVO=new ItemgradedListVO();
		Object params[] = {
				param, itemgradedListVO
   	        };
   	        Class vos[] = {
   	        		ExmnauditVO.class, ItemgradedVO.class
   	        };
   	        String joins[][] = {
   	            {
   	                "itemgradedid", "seqid"
   	            }
   	        };
   	        DataPackage dp=dao.query2(params, vos, joins);*/
		return dao.queryExmnauditInfoList(param);
	}
	/**
     * �������п��ύ������Ϣ��˵�ID����
     * @return
     * @throws Exception
     */
    public List doFindAllSubmitSeqid(User user)throws Exception{
    	 ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class, user);
    	 String registercode=user.getOpercode();
    	 return dao.doFindAllSubmitSeqid(getNowMonth(), registercode,user);
    }
    /**
     * ��֤���������
     * @param itemgradeds
     * @param oprcode
     * @return 
     * @throws Exception
     */
    public List doValidateNewAuditor(String[] reqids,String[] itemgradeds,User user) throws Exception{
    	ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class,user);
    	return dao.doValidateNewAuditor(reqids, itemgradeds,user);
    }
  
	 /**
	  * �������п���˵Ŀ�����Ϣ��˱�ʶ��Ϣ
	  */
	 public List doFindAllAuditExmnaudits(User user)throws Exception{
		 String registercode=user.getOpercode();
		 ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class,user);
	    	return dao.doFindAllAuditSeqid(getNowMonth(), registercode,user);
	 }
	 /**
	     * ɾ�����յĿ�����Ϣ�����Ϣ
	     * @param itemgradeds
	     * @param oprcode
	     * @throws Exception
	     */
	    public void doRemoveCallbackInfo(String[] itemgradeds,User user) throws Exception{
	    	ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class,user);
			 dao.removeCallbackInfo(itemgradeds, user.getOpercode(),user);
	    }
	 /**
	  * ִ�л�����ز���(ɾ����ؿ�����Ϣ�����Ϣ,���¿�����������Ϣ)--������Ϣ��˹���
	  */
	 public void doCallbackInfo(String[] selectArray,User user)throws Exception{
		 try{
			 ItemgradedDelegate itemgradedDelegate=new ItemgradedDelegate();
			 ExmnauditDelegate exmnauditDelegate=new ExmnauditDelegate();
			 this.doRemoveCallbackInfo(selectArray, user);//ɾ�����յĿ�����Ϣ�����ϢR
			 ItemgradedVO itemgradedVO=null;
			 for(int i=0;i<selectArray.length;i++){
				 /*
				  * �޸Ŀ���������
				  */
				 itemgradedVO=itemgradedDelegate.doFindByPk(Long.valueOf(selectArray[i]),user);
				 itemgradedVO.setState("1");//״̬[STATE]��Ϊ��ͨ��[1]
				 itemgradedVO.setCurauditor("");//���������Ϊ��
				 itemgradedDelegate.doUpdate(itemgradedVO,user);
			 }
		 }catch (Exception ex) {
			 sessionContext.setRollbackOnly();
	            throw ex;
		}
	 }
	 /**
	  * ִ�������ز���(���¿��������ֱ�Ϳ�����Ϣ���е�״̬Ϊ��ѡ��״̬,�ͱ���������)
	  * @param selectArray
	  * @throws Exception
	  */
	 public void doAuditInfo(String[] selectArray,String state,String auditopinion,User user)throws Exception{
		 try{
			 ItemgradedDelegate itemgradedDelegate=new ItemgradedDelegate();
			 ExmnauditDelegate exmnauditDelegate=new ExmnauditDelegate();
			 ItemgradedVO itemgradedVO=null;
			 ExmnauditVO exmnauditVO=null;
			 for(int i=0;i<selectArray.length;i++){
				 exmnauditVO=exmnauditDelegate.doFindByPk(Long.valueOf(selectArray[i]),user);
				 exmnauditVO.setState(state);
				 exmnauditVO.setAuditopinion(auditopinion);
				 exmnauditDelegate.doUpdate(exmnauditVO,user);
				 /*
				  * �޸Ŀ���������
				  */
				 itemgradedVO=itemgradedDelegate.doFindByPk(exmnauditVO.getItemgradedid(),user);
				 itemgradedVO.setState(state);//״̬[STATE]��Ϊ��ͨ��[1]
				 if("0".equals(state))
					 itemgradedVO.setCurauditor("");//���������Ϊ��
				 itemgradedDelegate.doUpdate(itemgradedVO,user);
			 }
			 sendMessage(exmnauditVO.getAuditor(),user);//�ж��Ƿ���ö���ģ��,��֪ͨ�����
		 }catch (Exception ex) {
			 sessionContext.setRollbackOnly();
	            throw ex;
		}
	 }
	 /**
	  * �ж��Ƿ���ö���ģ��,��֪ͨ�����
	  * @param auditor
	  * @throws Exception
	  */
	 private void sendMessage(String auditor,User user)throws Exception{
		//����ϵͳ��ʶ=62,��������==channel����ϵͳ��������
	    	CommonDelegate comdelegate = new CommonDelegate(SysparamVO.class);
	    	Serializable pkVO=new SysparamVO();
			BeanUtils.setProperty(pkVO, "systemid","62");
			BeanUtils.setProperty(pkVO, "paramtype","channel");
			SysparamVO vo=(SysparamVO)comdelegate.doFindByPk(pkVO, user);
			//���������ֵ[PARAMVALUE]��Ϊ1,����á�����ģ�顱֪ͨ�����Ա������������
			if(vo!=null && "1".equals( vo.getParamvalue())){
				/*
				 * �������ö��Žӿ�
				 */
			}
	 }
    /**
	 * ȡ��һ���µ������ַ���,��ʽ:yyyymm
	 * @return
	 */
	private String getNowMonth(){
		Date date=new Date();
		int year=date.getYear()+1900;
		int month=date.getMonth()+1;
		if(month==0){
			year-=1;
			month=12;
		}
		return Integer.toString(year)+(month<10?'0'+Integer.toString(month):Integer.toString(month));
	}
}
