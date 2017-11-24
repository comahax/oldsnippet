package com.gmcc.pboss.control.sales.comorder;

import java.util.List;

import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * <pre>
 * @version 1.1
 * �������������ĸ�����
 * @version 1.2
 * �����з������޸ĳɲ���do*��ͷ����ʽ��ʹComorderCheck��������Spring�й�;
 * ��Ϊ����������Spring�йܣ���鲻ͨ��ʱ�׳�����ʱ�쳣�������������ع�����
 * �������ύ����������������ý����Ǽ�鲻ͨ�����׳��쳣�������(���÷�)�����
 * ������Ӧҵ���������ǻع���
 * </pre>
 * @author Linli
 * @author zhangsiwei 
 */
public interface ComorderCheck extends AbstractControl {
	
	/**
	 * �Զ���ʱ�ν��м��
	 * @throws Exception
	 */
	public void checkLimitTime(WayVO vo) throws Exception;

	/**
	 * ��Ʒ���ඩ���������
	 * @param orderamount ��������
	 * @param comcategory ��������
	 * @throws Exception
	 */
	public void checkComcategoryUnitageMod(String comcategory,Long orderamount) throws Exception;
	
	/**
	 * ��Ʒ���ඩ��״̬���
	 * @param comcategory ��������
	 * @throws Exception
	 */
	public void checkComcategoryState(String comcategory) throws Exception;

	/**
	 * ���и�����Ϣ��������Ĵ洢
	 * @return
	 */
	public ComorderCheckHandle getHelpHandle(WayVO wayvo,List<DictitemVO> brandlist, String mode) throws Exception;
	
	/**
	 * ��Ʒ�����Ƿ��׿�
	 * @param comcategory ��������
	 * @return
	 * @throws Exception
	 */
	public ComcategoryrelaVO checkIsComressmp(String comcategory) throws Exception;
	
	/**
	 * 	�׿������ʼ�飨����Ʒ��/������Ʒ�ƣ�
		1 ����Ʒ��
		0 ������Ʒ��
	 * @param brand Ʒ��
	 * @param wayvo ����
	 * @throws Exception
	 */
	public void checkActiverate(String brand,	WayVO wayvo) throws Exception;
	
	/**
	 * ��5��Ҫ�õ�������,�����Ȼ�ȡ������
	 * @param brand Ʒ��
	 * @param orderamount ��������
	 * @param wayvo ����
	 */
	public boolean checkBaseAmount(String brand, Long orderamount, String storarea, WayVO wayvo) throws Exception;
	
	/**
	 * 6) ���¿ɶ��������
	 */
	public void checkOrderedmonthAndLimitCheck(String brand, Long orderamount, WayVO wayvo, String mode) throws Exception;
	
	/**
	 * ��׼������޼��
	 */
	public void checkOrderedNowstock(String brand, String restype, Long orderamount, WayVO wayvo, String mode) throws Exception;
			
	/**
	 * ��߿���飨Ԥ�����ģʽ��
	 */
	public void checkOrderedStockalarm(String brand, String restype, Long orderamount, WayVO wayvo, String mode) throws Exception;
	
	/**
	 * �����������
	 */
	public void checkLimit(String comcategory, Long orderamount, WayVO wayvo) throws Exception;
	
	public void checkResStock(String comcategory, Long orderamount, WayVO wayvo) throws Exception;
	
	
	/**
	 * ��ȡƷ��
	 */
	public String getBrand(String comcategory) throws Exception;
	
	public void checkOrderedCardLimit(String comcategory, String restype, Long orderamount, WayVO wayvo, String mode) throws Exception;
	
	public void checkOrderedEmptySimLimit(ComorderCheckHandle handle,String comcategory, String restype, Long orderamount, WayVO wayvo, String mode) throws Exception;
	
}
