/**
* auto-generated code
* Sat Nov 28 17:57:55 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnaudit.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.exmnaudit.persistent.ExmnauditDAO;
import com.sunrise.boss.business.cms.examine.exmnaudit.persistent.ExmnauditVO;
import com.sunrise.boss.business.cms.examine.exmnaudit.persistent.ExmnauditListVO;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title: ExmnauditControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ExmnauditControl extends AbstractControl {
    public ExmnauditVO doCreate(ExmnauditVO vo, User user)
        throws Exception;

    public void doRemove(ExmnauditVO vo, User user)
        throws Exception;

    public ExmnauditVO doUpdate(ExmnauditVO vo, User user)
        throws Exception;

    public ExmnauditVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ExmnauditListVO params, User user)
        throws Exception;
    /**
     * ���ݿ��˵Ǽ�ID�����ѯ��֤�ܷ��ջ�
     * @param itemgradeds
     * @return ���ܱ����յĿ��˵ǼǱ�ʶ����
     * @throws Exception
     */
	 public List doValidateCallbackInfo(String[] itemgradeds,User user) throws Exception;
	 /**
     * ɾ�����յĿ�����Ϣ�����Ϣ
     * @param itemgradeds
     * @param oprcode
     * @throws Exception
     */
    public void doRemoveCallbackInfo(String[] itemgradeds,String oprcode,User user) throws Exception;
    /**
	  * �������п��ύ�Ŀ��������ֱ�ʶ��Ϣ
	  */
	 public List doFindAllCallbackItemgradeds(User user)throws Exception;
	 /**
	 * ���ҿ�����Ϣ��˺Ϳ��������Ϣ�б�
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryExmnauditList(ExmnauditListVO params,User user) throws Exception;
	/**
     * �������п��ύ������Ϣ��˵�ID����
     * @return
     * @throws Exception
     */
    public List doFindAllSubmitSeqid(User user)throws Exception;
    /**
     * ��֤���������
     * @param itemgradeds
     * @param oprcode
     * @return 
     * @throws Exception
     */
    public List doValidateNewAuditor(String[] reqids,String[] itemgradeds,User user) throws Exception;
  
		 
	 /**
	  * �������п���˵Ŀ�����Ϣ��˱�ʶ��Ϣ
	  */
	 public List doFindAllAuditExmnaudits(User user)throws Exception;
	 /**
     * ɾ�����յĿ�����Ϣ�����Ϣ
     * @param itemgradeds
     * @param oprcode
     * @throws Exception
     */
    public void doRemoveCallbackInfo(String[] itemgradeds,User user) throws Exception;
	 /**
	  * ִ�л�����ز���(ɾ����ؿ�����Ϣ�����Ϣ,���¿�����������Ϣ)--������Ϣ��˹���
	  */
	 public void doCallbackInfo(String[] selectArray,User user)throws Exception;
	 /**
	  * ִ�������ز���(���¿��������ֱ�Ϳ�����Ϣ���е�״̬Ϊ��ѡ��״̬,�ͱ���������)
	  * @param selectArray
	  * @throws Exception
	  */
	 public void doAuditInfo(String[] selectArray,String state,String auditopinion,User user)throws Exception;
}
