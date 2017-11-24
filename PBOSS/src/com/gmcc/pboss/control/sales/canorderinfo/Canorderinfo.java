/**
 * auto-generated code
 * Wed Aug 10 10:50:17 CST 2011
 */
package com.gmcc.pboss.control.sales.canorderinfo;

import java.io.Serializable;
import java.util.List;

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.sales.canorderinfo.CanorderinfoDBParam;
import com.gmcc.pboss.business.sales.canorderinfo.CanorderinfoVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: canorderinfo </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public interface Canorderinfo extends AbstractControl {
    public CanorderinfoVO doCreate(CanorderinfoVO vo) throws Exception;

    public void doRemoveByVO(CanorderinfoVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CanorderinfoVO doUpdate(CanorderinfoVO vo) throws Exception;

    public CanorderinfoVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(CanorderinfoDBParam params) throws Exception;
    
    public List doStatPartnerres(CanorderinfoDBParam params) throws Exception;
        
    /**
     * ���������̶���֪ͨ
     * @param user	��ǰ�û���Ϣ
     * @param wayvo	�����������Ϣ
     * @param isReturn	1������ҳ�浥������0����������
     * @throws Exception
     */
    public CanorderinfoVO doNotceOne(DBAccessUser user,WayVO wayvo) throws Exception;
    
    /**
     * ��ȡ�׿�Ʒ�Ƽ���
     * @param brandList �׿�Ʒ�Ƽ���
     * @param user	��ǰ�û���Ϣ
     * @param wayvo	�����������Ϣ
     * @throws Exception
     */
    public List doQueryBrand(List brandList, DBAccessUser user, WayVO wayvo) throws Exception;
    
    /**
     * ��ȡ��ֵ��������Ϣ
     * @param cardList	��ֵ��������Ϣ
     * @param user	��ǰ�û���Ϣ
     * @param wayvo	�����������Ϣ
     * @throws Exception
     */
    public List doQueryStock(List cardList, DBAccessUser user, WayVO wayvo) throws Exception;
    
    /**
     * ��ȡ�հ�SIM��������Ϣ
     * @param emptyList	�հ�SIM��������Ϣ
     * @param user	��ǰ�û���Ϣ
     * @param wayvo	�����������Ϣ
     * @throws Exception
     */
    public List doQueryEmpty(List emptyList, DBAccessUser user, WayVO wayvo) throws Exception;
    
    /**
     * �����̼�顢������Լ��ģʽ���
     * @param user	��ǰ�û���Ϣ
     * @param wayvo �����������Ϣ
     * @param wayid
     * @param isReturn 1������ҳ�浥������0����������
     * @return
     * @throws Exception
     */
    public String doCheckWayAndModel(DBAccessUser user, WayVO wayvo, String wayid) throws Exception;

}
