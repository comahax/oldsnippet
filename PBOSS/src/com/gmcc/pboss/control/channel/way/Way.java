
/**
 * auto-generated code
 * Wed Jul 08 11:37:50 CST 2009
 */
package com.gmcc.pboss.control.channel.way;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.business.channel.way.WayDAO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.wayapply.WayapplyVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>Title: Way </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Way extends AbstractControl {
	public Object doFindByPk3(Serializable pk) throws Exception ;
    public WayVO doCreate(WayVO vo) throws Exception;
    
    public WayVO doCreate(WayVO vo, DBAccessUser user) throws Exception ;

    //public void doRemoveByVO(WayVO vo) throws Exception;

    //public void doRemoveByPK(Serializable pk) throws Exception;
    
    public void doDelete(WayVO vo, DBAccessUser user) throws Exception;
    
    public WayVO doUpdate(WayVO vo) throws Exception;
    
    public WayVO doUpdate(WayVO vo, DBAccessUser user) throws Exception;

    public WayVO doFindByPk(Serializable pk) throws Exception;
    
    public WayVO doFindByPk2(Serializable pk) throws Exception;

    public DataPackage doQuery(WayDBParam params) throws Exception;
    
    /**
     * ���ݵ���ID,�������Ͳ�ѯ������������Ϣ
     * @return
     * @throws Exception
     */
    public DataPackage doQueryWayByCityidAndType(String cityid,String waytype) throws Exception ;
    
	public String doQueryWaybyCityid(String cityid) throws Exception;
	
	public WayVO doGetUpperWay(String wayid) throws Exception;
	
	public WayVO doGetCitycomDirectWayByWay(String wayid) throws Exception;
	/**
	 * ��֤ĳ�����Ƿ�����ָ���������
	 * @param wayvo
	 * @param waytypeMap	��������� Key �� Value ����waytype
	 * @param waysubtype	����������� Key �� Value ����waysubtype
	 * @param runmode
	 * @return
	 * @throws Exception
	 */
	public boolean doGetwaytype(WayVO wayvo, Map waytypeMap, Map waysubtype, String runmode) throws Exception;
	
	public boolean doCheckisNetWork(String wayid) throws Exception;
	
	public List doQueryNetWork(String wayid) throws Exception;
	
	public DataPackage doQueryUpperWaysAndMeByIdOrName(String queryText,boolean showDisabled) throws Exception;
	
	public DataPackage doGetWaysOfHeadquarter() throws Exception;
	
	public DataPackage doGetWaysOfCountycom(String countyid) throws Exception;
	
	public DataPackage doGetWaysOfCitycom(String cityid) throws Exception;
	
	public DataPackage doGetWaysOfCenter(String centerid) throws Exception;
	
	public DataPackage doGetSubways(String wayid) throws Exception;
	
	public DataPackage doQuerysaleway(WayDBParam params,User user) throws Exception;
	
	public DataPackage doQuerysalewayWithOfficetel(WayDBParam params,User user) throws Exception;
	
	public DataPackage doQueryLogsway(WayDBParam params, User user)	throws Exception;
	
	public void doRemove(WayVO vo, DBAccessUser user) throws Exception;
	
	/*
	 * ��Ͻ�����ѯ
	 */
	public DataPackage doQueryEmployee (WayDBParam params, User user)throws Exception;
	
	public DataPackage doQueryByOprcode(WayDBParam params, User user) throws Exception;
	
	public WayVO doEdit(WayVO oldVO, WayVO newVO, DBAccessUser user) throws Exception;
	
	
	//�����̵���
	public void doLogiswayImport(String[] items) throws Exception;
	
	public void doDiswayImport(String[] items) throws Exception;
	/**
	 * ��ѯ�Ƿ񱾵��е�¼������ͬ���е�����
	 */
	public WayVO doFindByPkAndCityid(Serializable pk) throws Exception ;
	
	public DataPackage doQuerySubSaleway(WayDBParam params,User user) throws Exception;
	
	public WayVO doUpdateNotCon(WayVO vo) throws Exception;
	
	// ȡ�����������Ӧ�����������������
	public WayapplyVO doGetageidt(String wayid, DBAccessUser user) throws Exception;
	// �������������Ӧ�����������
	public WayapplyVO doGetsaleeidt(String wayid, DBAccessUser user) throws Exception;
	
	//��Ȩ�����������ѡ���������㣬��������Ϊ׼�������ʱ�򣬲�ѯ��������������
	public DataPackage doQueryWayinfoForapplyway(WayDBParam params) throws Exception;
	
	//��Ȩ�����������ѡ���������㣬��������Ϊ�˳������ʱ�򣬲�ѯ���������������
	public DataPackage doQueryWayinfoForExitway(WayDBParam params) throws Exception;
	 
	public DataPackage doCheckWayState(WayDBParam params) throws Exception;
	//��ѯ������������
	public DataPackage doQueryWaytype(WayDBParam params) throws Exception;
	
	//��ѯ���������
	public DataPackage doQueryImpWay(WayDBParam params, User user) throws Exception;
	//ɾ�������������Ϣ
	public WayVO doRemove(WayVO vo) throws Exception;
	// ��������ѯ������Ϣ
	public DataPackage doQueryWayByParams(WayDBParam params) throws Exception;
	// ��������������Ϣ
	public WayVO doSave(WayVO vo) throws Exception;
	// �޸������������Ϣ
	public WayVO doUpdateImpWay(WayVO vo) throws Exception;
	
	//��ѯ���ڹ�������
	public DataPackage doQueryFinanceWay(WayDBParam params, User user) throws Exception;
	//ɾ�����ڹ���������Ϣ
	public WayVO doRemoveFinanc(WayVO vo) throws Exception;
	// ��ӽ��ڹ���������Ϣ
	public WayVO doCreateFinance(WayVO vo) throws Exception;
	// �޸Ľ��ڹ���������Ϣ
	public WayVO doUpdateFinanceWay(WayVO vo) throws Exception;
	
	//��ѯ����������
	public DataPackage doQueryNetWay(WayDBParam params, User user) throws Exception;
	//ɾ��������������Ϣ
	public WayVO doRemoveNetWay(WayVO vo) throws Exception;
	// ��ӻ�����������Ϣ
	public WayVO doCreateNetWay(WayVO vo) throws Exception;
	// �޸Ļ�����������Ϣ
	public WayVO doUpdateNetWay(WayVO vo) throws Exception;
	
	// ���ݵ���ID ����ѯ�õ��к�ʡ�ı��� 
	public DataPackage doQueryWayIdByCityId(WayDBParam params, User user) throws Exception;
}
