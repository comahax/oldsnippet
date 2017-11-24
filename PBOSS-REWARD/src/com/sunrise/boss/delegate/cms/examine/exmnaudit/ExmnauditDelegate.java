/**
* auto-generated code
* Sat Nov 28 17:57:55 CST 2009
*/
package com.sunrise.boss.delegate.cms.examine.exmnaudit;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.exmnaudit.persistent.ExmnauditDAO;
import com.sunrise.boss.business.cms.examine.exmnaudit.persistent.ExmnauditVO;
import com.sunrise.boss.business.cms.examine.exmnaudit.persistent.ExmnauditListVO;
import com.sunrise.boss.business.cms.examine.exmnaudit.control.ExmnauditControlBean;
import com.sunrise.boss.business.cms.examine.exmnaudit.control.ExmnauditControl;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title: ExmnauditDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnauditDelegate {

    private static ExmnauditControl control;

    public ExmnauditDelegate() throws Exception {
        control = (ExmnauditControl) ControlFactory.build(ExmnauditControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ExmnauditVO doCreate(ExmnauditVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ExmnauditVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ExmnauditVO doUpdate(ExmnauditVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ExmnauditVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ExmnauditVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ExmnauditListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    /**
     * ���ݿ��˵Ǽ�ID�����ѯ��֤�ܷ��ջ�
     * @param itemgradeds
     * @return ���ܱ����յĿ��˵ǼǱ�ʶ����
     * @throws Exception
     */
	 public List doValidateCallbackInfo(String[] itemgradeds,User user) throws Exception{
		 return control.doValidateCallbackInfo(itemgradeds, user);
	 }
	 /**
     * ɾ�����յĿ�����Ϣ�����Ϣ
     * @param itemgradeds
     * @param oprcode
     * @throws Exception
     */
    public void doRemoveCallbackInfo(String[] itemgradeds,String oprcode,User user) throws Exception{
    	  control.doRemoveCallbackInfo(itemgradeds, oprcode, user);
    }
    /**
	  * �������пɻ��յĿ��������ֱ�ʶ��Ϣ
	  */
	 public List doFindAllCallbackItemgradeds(User user)throws Exception{
		 return control.doFindAllCallbackItemgradeds(user);
	 }
	 /**
	 * ���ҿ�����Ϣ��˺Ϳ��������Ϣ�б�
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryExmnauditList(ExmnauditListVO params,User user) throws Exception{
		return control.doQueryExmnauditList(params, user);
	}
	 /**
     * �������п��ύ������Ϣ��˵�ID����
     * @return
     * @throws Exception
     */
    public List doFindAllSubmitSeqid(User user)throws Exception{
    	return control.doFindAllSubmitSeqid(user);
    }
    /**
     * ��֤���������
     * @param itemgradeds
     * @param oprcode
     * @return 
     * @throws Exception
     */
    public List doValidateNewAuditor(String[] reqids,String[] itemgradeds,User user) throws Exception{
    	return control.doValidateNewAuditor(reqids, itemgradeds, user);
    }
   
	 /**
	  * �������п���˵Ŀ�����Ϣ��˱�ʶ��Ϣ
	  */
	 public List doFindAllAuditExmnaudits(User user)throws Exception{
		 return control.doFindAllAuditExmnaudits(user);
	 }
	 /**
     * ɾ�����յĿ�����Ϣ�����Ϣ
     * @param itemgradeds
     * @param oprcode
     * @throws Exception
     */
    public void doRemoveCallbackInfo(String[] itemgradeds,User user) throws Exception{
    	control.doRemoveCallbackInfo(itemgradeds,user);
    }
	 /**
	  * ִ�л�����ز���(ɾ����ؿ�����Ϣ�����Ϣ,���¿�����������Ϣ)--������Ϣ��˹���
	  */
	 public void doCallbackInfo(String[] selectArray,User user)throws Exception{
		 control.doCallbackInfo(selectArray, user);
	 }
	 /**
	  * ִ�������ز���(���¿��������ֱ�Ϳ�����Ϣ���е�״̬Ϊ��ѡ��״̬,�ͱ���������)
	  * @param selectArray
	  * @throws Exception
	  */
	 public void doAuditInfo(String[] selectArray,String state,String auditopinion,User user)throws Exception{
		 control.doAuditInfo(selectArray, state, auditopinion, user);
	 }

}
