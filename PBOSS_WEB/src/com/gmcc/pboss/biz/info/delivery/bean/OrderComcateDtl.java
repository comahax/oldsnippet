package com.gmcc.pboss.biz.info.delivery.bean;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.biz.basic.dictItem.service.DictItemService;
import com.gmcc.pboss.biz.info.delivery.dao.DeliveryDao;
import com.gmcc.pboss.common.bean.CodeReverse;
import com.gmcc.pboss.common.context.ContextUtil;
import com.gmcc.pboss.common.dictionary.CodeReverseKey;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.log.Log;
import com.gmcc.pboss.common.util.CommonUtil;

/**
 * ���˹�˾Ӫ�˲�
 * @author yuwenjun
 * @date 2009-10-3
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������������Ʒͳ����Ϣ
 */
public class OrderComcateDtl extends CodeReverse {
	private DictItemService dictItemService;
	
	/**
	 * ���͵���ѯDAO��������Ʒ��ϸ��ѯ�����ڴ�DAO�У�
	 */
	private DeliveryDao deliveryDao;
	/**
	 * ���ص�λ
	 * @return
	 */
	public String getComcateUtil(){
		try{
			if (dictItemService == null) {
				dictItemService = (DictItemService) ContextUtil.getContext().getBean("dictItemService");
				if (dictItemService ==null){
					logger.error("dictItemService����ע�����!");
					return null;
				}
			}
			String comcategory =(String) CommonUtil.getProperty(this,"comcategory");
			String value = dictItemService.getTypeByCode(comcategory);
			return this.getPropertyByValue(CodeReverseKey.COMCATEGORY_UNIT,value);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			short code = -1;
			Log.errorLog("", "", "", "getComcateUtil����", "OrderComcateDtl", code, -1, "�������:"+e.getMessage());
			return null;
		}
	}
	
	/**
	 * ���� ��Ʒ��� �������еİ��ŵ���Ϣ��
	 * @return
	 */
	public String getOdrPackageInfo(){
		/**�����֣�����SQL���������*/
		if (dictItemService == null) {
			dictItemService = (DictItemService) ContextUtil.getContext().getBean("dictItemService");
			if (dictItemService ==null){
				logger.error("dictItemService����ע�����!");
				Log.errorLog("", "", "", "getOdrPackageInfo����", "OrderComcateDtl", (short)0, -1, "dictItemService����ע�����");
				return null;
			}
		}
		try{
			String comcategory =(String) CommonUtil.getProperty(this,"comcategory");
			String comctgType = dictItemService.getTypeByCode(comcategory);
			String ordercomtype = (String) CommonUtil.getProperty(this,"ordercomtype");
			String orderid = (String) CommonUtil.getProperty(this,"orderid");
			String rtn = "";
			//��Դ����Ϊ[�׿�] �� ������Ʒ����Ϊ[�ͻ�����]ʱ
			if (ConstantsType.COMRESSMP.equals(comctgType)) {
				if (ConstantsType.ORDERCOMTYPE_CUSTORDER.equals(ordercomtype) ){
					rtn  = this.getPackageInfo(orderid, ordercomtype, comcategory);
				}
				//��Դ����Ϊ[�׿�]�Ҷ�����Ʒ����[�ǿͻ�����]			
				else {
					rtn = this.getMaxMinInfo(orderid, ordercomtype, comcategory);
				}
				
			}
			//��Դ����Ϊ��ֵ��
			else if (ConstantsType.COMRESCARD.equals(comctgType)){
				rtn = this.getMaxMinInfo(orderid, ordercomtype, comcategory);
			} 
			

			//Ϊ�˷��ظ��ͻ�չʾΪHTML����\nת��Ϊ<BR>���س���
			rtn = rtn.replaceAll("\\n", "<br>");
			return rtn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			short code = -2;
			Log.errorLog("", "", "", "getOdrPackageInfo����", "OrderComcateDtl", code, -1, "�������:"+e.getMessage());
			return null;
		}
	}
	
	/**
	 * ���ذ��š����κŷ�װ��Ϣ
	 * @param orderid ������
	 * @param ordercomtype ������������
	 * @param category ��Ʒ���� 
	 * @return �������磺���κ�-����(����)[�ָ���]�ĸ�ʽ
	 */
	private String getPackageInfo(String orderid,String ordercomtype,String category){
		short code = -3;
		if (deliveryDao == null) {
			deliveryDao = (DeliveryDao) ContextUtil.getContext().getBean("deliveryDao");
			if (deliveryDao ==null){
				logger.error("getPackageInfo:deliveryDao����ע�����!");
				Log.errorLog("", "", "", "getOdrPackageInfo����", "OrderComcateDtl", code, -1, "getPackageInfo:deliveryDao����ע�����");
				return null;
			}
		}
		List<OrderPackageInfo> rtnLst = deliveryDao.getOrderBatchNoDtl(orderid, ordercomtype, category);
		StringBuffer sb = new StringBuffer();
		String rx = "\n";//�ָ���
		boolean nonfirst = false;
		//�Է���ֵ���з�װ���������磺���κ�-����(����)[�ָ���]�ĸ�ʽ
		for(OrderPackageInfo info:rtnLst){
			//�ϲ�����֮������ӷ�
			if (nonfirst) 
				sb.append(rx);
			else 
				nonfirst = true;
			
			sb.append(info.getBatchno());
			if (StringUtils.isNotEmpty(info.getBoxnum())){
				//���ſ���Ϊ��
				sb.append('-');
				sb.append(info.getBoxnum());
			}
			sb.append('(');
			sb.append(info.getCount());
			sb.append(')');
			
			
		}
		return sb.toString();
	}//getPackageInfo
	
	/**
	 * ���������롢��С�����װ��Ϣ
	 * @param orderid ������
	 * @param ordercomtype ������������
	 * @param category ��Ʒ���� 
	 * @return �������磺��Сֵ~���ֵ����������ʽ
	 */
	private String getMaxMinInfo(String orderid,String ordercomtype,String category){
		short code = -3;
		if (deliveryDao == null) {
			deliveryDao = (DeliveryDao) ContextUtil.getContext().getBean("deliveryDao");
			if (deliveryDao ==null){
				logger.error("getPackageInfo:deliveryDao����ע�����!");
				Log.errorLog("", "", "", "getMaxMinInfo����", "OrderComcateDtl", code, -1, "getMaxMinInfo:deliveryDao����ע�����");
				return null;
			}
		}
		OrderPackageInfo dtl = deliveryDao.getMaxMinDtl(orderid, ordercomtype, category);
		
		StringBuffer sb = new StringBuffer();
		
		if (dtl != null){
			if (dtl.getMinres() != null){
				sb.append(dtl.getMinres());
				if (dtl.getMaxres()!= null) 
					sb.append('~');
			}
			
			if (dtl.getMaxres()!= null) 
				sb.append(dtl.getMaxres());

			sb.append('(');
			sb.append(dtl.getCount());
			sb.append(')');
		}
		return sb.toString();
	}
}
