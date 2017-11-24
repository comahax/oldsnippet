/**
* auto-generated code
* Fri Aug 11 17:18:05 CST 2006
*/
package com.sunrise.boss.delegate.common.managelog;

import com.sunrise.boss.business.common.managelog.control.ManageLogControl;
import com.sunrise.boss.business.common.managelog.control.ManageLogControlBean;
import com.sunrise.boss.business.common.managelog.persistent.ManageLogVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

import java.io.Serializable;


/**
 * <p>Title: ManagelogDelegate</p>
 * <p>Description: </p>    
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author xqy
 * @version 1.0
 */
public class ManageLogDelegate {

    private ManageLogControl control;

    public ManageLogDelegate() throws Exception {
        control = (ManageLogControl) ControlFactory.build(ManageLogControlBean.class);
        if ( null == control ) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public ManageLogVO doCreate(ManageLogVO vo, User user)
        throws Exception {
		if (vo != null) {
        	return control.doCreate(vo, user);
		}
		return null;
    }
    public ManageLogVO doFindByPk(Serializable pk, User user)
        throws Exception {
		if (pk != null) {
        	return (ManageLogVO) control.doFindByPk(pk, user);
		}
		return null;
    }
//    /*
//     * manageLog:   ��¼���������־
//     * 
//     * user			����Ա����
//     * oprtype		�����ı�������ʵ����
//     * action		��������,OperAction�����ж���
//     * voOld		�޸�ǰʵ��,���������������������null
//     * voNew		�޸ĺ�ʵ��,�������������ɾ������null
//     * state		����״̬,OperState�����ж���
//     */
//    public void manageLog(User user, String oprtype, String action,
//            Object voOld, Object voNew, Integer state) throws
//		Exception {
//    		control.manageLog(user, oprtype, action, voOld, voNew, state);
//		}
}
