/**
 * auto-generated code
 * Tue Oct 13 15:13:34 CST 2009
 */
package com.gmcc.pboss.control.sales.orderresdet;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDBParam;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetVO;
import com.gmcc.pboss.common.utils.tools.TiedComInfo;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Orderresdet </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Orderresdet extends AbstractControl {
    public OrderresdetVO doCreate(OrderresdetVO vo) throws Exception;

    public void doRemoveByVO(OrderresdetVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OrderresdetVO doUpdate(OrderresdetVO vo) throws Exception;

    public OrderresdetVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OrderresdetDBParam params) throws Exception;
    /**
     * ��ѯ����Ʒ���࣬���Σ����ŷ��鶩����Դ��ϸ��Ϣ
     * @return
     * @throws Exception
     */
    public DataPackage doQueryOrderresdetGroupView(OrderresdetDBParam param) throws Exception;
    /**
	 * ������Դ��ȡ
	 * @param orderresdetDBParam
	 * @return ������Ϣ
	 * @throws Exception
	 */
	public String doResdraw(OrderresdetDBParam orderresdetDBParam,boolean isUpdateOrder) throws Exception;
	/**
	 * ������Դ������ȡ
	 * @param orderresdetDBParam
	 * @return ������Ϣ
	 * @throws Exception
	 */
	public String doBatchResdraw(Map parameterMap,String orderid) throws Exception;
	
	/**
	 * �������/���͵ĳ�ȡ����
	 * ��������ƥ�䣺��Ʒ��Դ��ȡ��ɺ󣬵��ô�������������/���ͣ��ӿڷ�����
	 * ����/������Դ��ȡ��������ڴ���/������Դ������Ҫ�ٴν��г�ȡ����ȡ�߼��ο�����ĳ�ֵ������Ʒ����ȡ�߼���
	 * ͬʱ�������ݵ�������Ʒ�����FX_SW_ORDERCOMCATE���Ͷ������ô���������FX_SW_ORDERPLAN����
	 * @param brandMap Ʒ��MAP
	 * @param sysparamvalue21 ���������̲���
	 * @param comcateg ��Ʒ�����ϵ
	 * @param isbatchResdraw TODO
	 * @param comcate ������Ʒ����
	 * @param orderresdetBO ������Դ��ϸBO
	 * @param nosect �����ŶΣ�ָ���Ŷκ�ѭ���Ŷβ��У�����ΪNULL��
	 * @param isCycsect �Ƿ�ѭ���Ŷβ�ѯ
	 * @param paramMap ����MAP��
	 * @return TODO
	 * @throws Exception
	 */
	public  String doTiedComResdraw(List<TiedComInfo> tiedComInfos,String ordercomtype,Map brandMap,String sysparamvalue21,String sysparamvalue38,OrderVO orderVo,ComcategoryrelaVO comcateg, boolean isbatchResdraw) throws Exception;
	
	/**
	 * ��������������ϸ
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryExp(OrderresdetDBParam params) throws Exception;
}
