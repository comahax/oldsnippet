/**
* auto-generated code
* Sat Nov 28 17:53:15 CST 2009
*/
package com.sunrise.boss.business.cms.examine.itemgraded.control;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.sunrise.boss.business.cms.examine.exmnaudit.persistent.ExmnauditListVO;
import com.sunrise.boss.business.cms.examine.exmnaudit.persistent.ExmnauditVO;
import com.sunrise.boss.business.cms.examine.itemgraded.persistent.ItemgradedDAO;
import com.sunrise.boss.business.cms.examine.itemgraded.persistent.ItemgradedListVO;
import com.sunrise.boss.business.cms.examine.itemgraded.persistent.ItemgradedVO;
import com.sunrise.boss.business.cms.examine.itemgraded.persistent.VItemgradedWayVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.examine.exmnaudit.ExmnauditDelegate;
import com.sunrise.boss.delegate.cms.examine.itemgraded.ItemgradedDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ItemgradedControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/itemgraded/control/ItemgradedControlBean"
 name="ItemgradedControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ItemgradedControlBean extends AbstractControlBean
    implements ItemgradedControl {

    public ItemgradedVO doCreate(ItemgradedVO vo, User user)
        throws Exception {
        try{
			ItemgradedDAO dao = (ItemgradedDAO) DAOFactory.build(ItemgradedDAO.class, user);
            // TODO  set the pk */
            return (ItemgradedVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ItemgradedVO vo, User user)
        throws Exception {
        try{
			ItemgradedDAO dao = (ItemgradedDAO) DAOFactory.build(ItemgradedDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ItemgradedVO doUpdate(ItemgradedVO vo, User user)
        throws Exception {
        try{
			ItemgradedDAO dao = (ItemgradedDAO) DAOFactory.build(ItemgradedDAO.class, user);
            return (ItemgradedVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ItemgradedVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ItemgradedDAO dao = (ItemgradedDAO) DAOFactory.build(ItemgradedDAO.class, user);
        return (ItemgradedVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ItemgradedListVO params, User user)
        throws Exception {
			ItemgradedDAO dao = (ItemgradedDAO) DAOFactory.build(ItemgradedDAO.class, user);
        return dao.query(params);
    }
    public void doSubmitAuditInfo(String[] selectArray,String auditor,String curauditor, User user)throws Exception{
    	try{	
			 ExmnauditDelegate exmnauditBO=new ExmnauditDelegate();
			 ItemgradedDelegate itemgradedBO=new ItemgradedDelegate();
			 ExmnauditVO exmnauditVO=null;
			 ItemgradedVO itemgradedVO=null;
			 for(int i=0;i<selectArray.length;i++){
				 /*
				  * ���濼����Ϣ���
				  */
				 exmnauditVO=new ExmnauditVO();
				 exmnauditVO.setPresenter(user.getOpercode());//�ύ��
				 exmnauditVO.setSubmissiontime(new Date());//�ύʱ��
				 exmnauditVO.setAuditor(auditor);//�����
				 exmnauditVO.setItemgradedid(Long.valueOf(selectArray[i]));//���˵ǼǱ�ʶ
				 exmnauditVO.setState("0");//״̬[STATE]��Ϊ�������[0]
				 exmnauditBO.doCreate(exmnauditVO,user);
				 /*
				  * �޸Ŀ���������
				  */
				 itemgradedVO=(ItemgradedVO)itemgradedBO.doFindByPk(Long.valueOf(selectArray[i]),user);
				 itemgradedVO.setState("0");//״̬[STATE]��Ϊ�������[0]
				 itemgradedVO.setCurauditor(curauditor);//���������
				 itemgradedBO.doUpdate(itemgradedVO,user);
			 }
			 sendMessage(auditor,user);//�ж��Ƿ���ö���ģ��,��֪ͨ�����
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
            throw ex;
		}
    }
    /**
	  * �������п��ύ�Ŀ��������ֱ�ʶ��Ϣ
	  */
	 public List doFindAllSubmitSeqid(User user)throws Exception{
		 ItemgradedDAO itemgradedDAO = (ItemgradedDAO) DAOFactory.build(ItemgradedDAO.class,user);
		 return itemgradedDAO.doFindAllSubmitSeqid(user.getOpercode(),user);
	 }
	 public void doCallbackInfo(String[] selectArray,User user)throws Exception{
		 try{
			 ExmnauditDelegate exmnauditBO=new ExmnauditDelegate();
			 ItemgradedDelegate itemgradedBO=new ItemgradedDelegate();
			 exmnauditBO.doRemoveCallbackInfo(selectArray, user.getOpercode(),user);//ɾ�����յĿ�����Ϣ�����ϢR
			 ItemgradedVO itemgradedVO=null;
			 for(int i=0;i<selectArray.length;i++){
				 /*
				  * �޸Ŀ���������
				  */
				 itemgradedVO=(ItemgradedVO)itemgradedBO.doFindByPk(Long.valueOf(selectArray[i]),user);
				 if(itemgradedVO!=null){
					 itemgradedVO.setState("99");//״̬[STATE]��Ϊ��δ�ύ[99]
					 itemgradedVO.setCurauditor("");//���������Ϊ��'
					 itemgradedBO.doUpdate(itemgradedVO,user);
				 }
			 }
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
	  * ɾ�����ֵǼ��������������˼�¼
	  */
	 public void doRemoveJoinExmnaudit(ItemgradedVO vo, User user)
     throws Exception{
		 	try {
				//ɾ��������������˼�¼
				ExmnauditDelegate exmnauditDelegate=new ExmnauditDelegate();
				ExmnauditListVO listVO =new ExmnauditListVO();
				listVO.set_ne_itemgradedid(vo.getSeqid()+"");
				Iterator it=exmnauditDelegate.doQuery(listVO, user).getDatas().iterator();
				ExmnauditVO exmnauditVO=null;
				while(it.hasNext()){
					exmnauditVO=(ExmnauditVO)it.next();
					exmnauditDelegate.doRemove(exmnauditVO, user);
				}
				this.doRemove(vo, user);//ɾ�����ֵǼ�
			} catch (RuntimeException ex) {
				sessionContext.setRollbackOnly();
	            throw ex;
			}
	 }

	public DataPackage doGetItemgradedWayInfo(ItemgradedListVO listvo, User user) throws Exception {
		ItemgradedDAO dao = (ItemgradedDAO) DAOFactory.build(ItemgradedDAO.class,user);
		dao.setVoClass(VItemgradedWayVO.class);
		 return dao.getItemgradedWayInfo(listvo, user);
		
	}
}
