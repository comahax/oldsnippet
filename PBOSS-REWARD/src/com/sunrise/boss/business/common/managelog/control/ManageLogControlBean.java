/**
* auto-generated code
* Fri Aug 11 18:21:13 CST 2006
*/
package com.sunrise.boss.business.common.managelog.control;

import java.io.Serializable;

import com.sunrise.boss.business.common.managelog.persistent.ManageLogDAO;
import com.sunrise.boss.business.common.managelog.persistent.ManageLogListVO;
import com.sunrise.boss.business.common.managelog.persistent.ManageLogVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ManagelogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author xqy
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/common/managelog/control/ManageLogControlBean"
*    name="ManageLogControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class ManageLogControlBean  extends AbstractControlBean
implements ManageLogControl {

    public ManageLogVO doCreate(ManageLogVO vo, User user)
        throws Exception {
        try{
           ManageLogDAO dao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid());
            return (ManageLogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
//    public void doRemove(ManageLogVO vo, User user)
//        throws Exception {
//        try{
//            ManageLogDAO dao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid());        	
//            dao.remove(vo);
//        } catch(Exception ex){
//            sessionContext.setRollbackOnly();
//            throw ex;
//        }
//    }
//    public ManageLogVO doUpdate(ManageLogVO vo, User user)
//        throws Exception {
//        try{
//            ManageLogDAO dao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid());        	
//            return (ManageLogVO) dao.update(vo);
//        } catch(Exception ex){
//            sessionContext.setRollbackOnly();
//            throw ex;
//        }
//    }
    public ManageLogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        ManageLogDAO dao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid());    	
        return (ManageLogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(ManageLogListVO params, User user)
        throws Exception {
        ManageLogDAO dao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid());   	
        return dao.query(params);
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
//			ToStringStyle style = ManageLogToStringStyle.MANAGE_LOG_STYLE;
//			
//			ManageLogVO vo = new ManageLogVO();
//			vo.setOprcode(user.getOpercode());
//			vo.setOprtime(new Timestamp(System.currentTimeMillis()));
//			vo.setOprtype(oprtype);
//			vo.setOpraction(action);
//			vo.setOprcon1(voOld == null ? "" :
//			      ReflectionToStringBuilder.toString(voOld, style));
//			vo.setOprcon2(voNew == null ? "" :
//			      ReflectionToStringBuilder.toString(voNew, style));
//			vo.setOprstate(state);
//			
//			doCreate(vo, user);
//		}    
}
