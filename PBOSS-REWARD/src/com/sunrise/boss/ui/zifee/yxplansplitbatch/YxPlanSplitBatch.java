package com.sunrise.boss.ui.zifee.yxplansplitbatch;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;



import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.zifee.yxplansplitvalue.persistent.YxPlanSplitValueListVO;
import com.sunrise.boss.business.zifee.yxplansplitvalue.persistent.YxPlanSplitValueVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.delegate.zifee.yxplansplitvalue.YxPlanSplitValueDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.boss.ui.commons.WebConstant;


/**
 * 
 * Title: YxPlanSplitBatch Description: Copyright: Copyright (c) 2006
 * Company: sunrise Tech Ltd.
 * 
 * @author luozhoujie
 * @version 1.0
 */
public class YxPlanSplitBatch extends BaseBatchTaskBean {

	private Logger log = Logger.getLogger(YxPlanSplitBatch.class);
	private Short oprtype;
	protected Class voClass;
	private YxPlanSplitValueDelegate delegate;
	private String allitemstr;
	private String allbrandstr;
	private boolean isBoss10Format = false;

	public YxPlanSplitBatch() {
	}
	
	public String getItemStr()throws Exception {
		  String allItem = "";		
			try {
				CommonDelegate dictitemDelegate = new CommonDelegate(
						DictitemVO.class);
				DictitemListVO dictForm = new DictitemListVO();
				dictForm.set_se_groupid("PC_YXCHAIFENITEM");
				dictForm.set_pagesize("0");
				DataPackage dp = (DataPackage)dictitemDelegate.doQuery(dictForm,user);
				if( dp.getDatas() != null ){
					List dpList = (List)dp.getDatas();							
					for( int i=0 ;i<dpList.size(); i++ ){
						DictitemVO dictVO = (DictitemVO)dpList.get(i);
						allItem=allItem+dictVO.getDictid()+",";
					}
				}
			} catch (Exception ex) {
				log.info("YxplanSplit getItemStr exception", ex);
				ex.printStackTrace();
			}
		  return allItem;
	}
	
	public String getBrandstr()throws Exception {
		  String allItem = "";
			try {
				CommonDelegate dictitemDelegate = new CommonDelegate(
						DictitemVO.class);
				DictitemListVO dictForm = new DictitemListVO();
				dictForm.set_se_groupid("ProductBrand");
				dictForm.set_pagesize("0");
				DataPackage dp = (DataPackage)dictitemDelegate.doQuery(dictForm,user);
				if( dp.getDatas() != null ){
					List dpList = (List)dp.getDatas();							
					for( int i=0 ;i<dpList.size(); i++ ){
						DictitemVO dictVO = (DictitemVO)dpList.get(i);
						allbrandstr=allbrandstr+dictVO.getDictid()+",";
					}
				}
			} catch (Exception ex) {
				log.info("YxplanSplit getBrandstr exception", ex);
				ex.printStackTrace();
			}
		  return allbrandstr;
	}
	
	protected String doStart() {
		try {
			 delegate = new YxPlanSplitValueDelegate();
			 allitemstr = getItemStr();	
			 allbrandstr = getBrandstr();
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
		oprtype=new Short(parameterMap.get("oprtype").toString());
		return "��� | �������� | Ʒ�Ʊ�ʶ | ��������ͨ����ʹ�÷� | ��������ͨ����ʹ�÷� | ������;ͨ����ʹ�÷� | �������� | �������"+"\r\n";
	}

	/**
	 * ����һ����¼
	 */
	public ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		Long billcycle;
		String[] items = line.split("\\|");
//		if(null !=items && items.length==5 && !items[1].trim().startsWith("Brand")){
//			isBoss10Format = true;//����ļ�Ϊ5�У�����boss1.0�ĵ����ʽ����20061200|0| 14446440.80| 1814262.00| 1826461.56
//		}
		isBoss10Format=(null !=items && items.length==5 && !items[1].trim().startsWith("Brand"));
		try {
			billcycle = new Long(items[0]);
			String brandid = items[1];
			if(isBoss10Format){
				brandid = exchangeBrand10To15(items[1]);
			}
			Double baseamt = Double.valueOf(items[2]);//��������ͨ����ʹ�÷�
			Double myamt = Double.valueOf(items[3]);//��������ͨ����ʹ�÷�
			Double ctamt = Double.valueOf(items[4]);//������;ͨ����ʹ�÷�
			
			//String itemid = items[2];
			//Double feeamt = Double.valueOf(items[3]);
		
			if (oprtype.shortValue() == 0 || oprtype.shortValue() == 2) { // ����/�޸�
				doInsert(billcycle, brandid, "1",baseamt);//��������ͨ����ʹ�÷�
				doInsert(billcycle, brandid, "2",ctamt);//������;ͨ����ʹ�÷�
				doInsert(billcycle, brandid, "3",myamt);//��������ͨ����ʹ�÷�
			}
			if (oprtype.shortValue() == 3) { // ɾ��
				doDelete(billcycle, brandid, "1",baseamt);//��������ͨ����ʹ�÷�
				doDelete(billcycle, brandid, "2",ctamt);//������;ͨ����ʹ�÷�
				doDelete(billcycle, brandid, "3",myamt);//��������ͨ����ʹ�÷�
			}
			resultVO.setOk(true);
			resultVO.setInfo(showInfo(resultVO, items, rowCount));
			return resultVO;
		} catch (Exception ex) { // ����ʧ��
			//ex.printStackTrace();
			msg = ex.getMessage();
			resultVO.setOk(false);
			resultVO.setInfo(showInfo(resultVO, items, rowCount)+msg);
			return resultVO;
		}
	}
	
	public String exchangeBrand10To15(String brand10){
		String brand15="";
		try{
			int brandtmp = Integer.parseInt(brand10.trim());		
			switch(brandtmp){
				case 0 : brand15="BrandGotone";break;
				case 1 : brand15="BrandSzx";break;
				case 2 : brand15="BrandMzone";break;
				case 8 : brand15="BrandLnx";break;
				case 9 : brand15="BrandDzk";break;
				default : brand15="BrandOther";
			}
		}catch(Exception e){
			log.info("YxplanSplit exchangeBrand10To15 exception", e);
			e.printStackTrace();
			//throw new Exception("Ʒ�Ʊ�ʶת��ʧ��");
		}
		return brand15;
	}

	/**
	 * ����ļ���ʽ
	 */
	public String showInfo(ResultVO resultVO, String[] items, int rowCount) {
		final String COMPART = " | "; // �ָ�
		StringBuffer resultStr = new StringBuffer();
		// ���
		resultStr.append(rowCount).append(COMPART);
		// ����
		resultStr.append(items[0]).append(COMPART);		
		// ��Ʒ��ʶ
		resultStr.append(items[1]).append(COMPART);
		// ��������ͨ����ʹ�÷�
		resultStr.append(items[2]).append(COMPART);
		// ��������ͨ����ʹ�÷�
		resultStr.append(items[3]).append(COMPART);
		// ������;ͨ����ʹ�÷�
		resultStr.append(items[4]).append(COMPART);
		// ��������
		if (oprtype.shortValue() == 0) {
			resultStr.append("����");
		}
		if (oprtype.shortValue() == 2) {
			resultStr.append("����");
		}
		if (oprtype.shortValue() == 3) {
			resultStr.append("ɾ��");
		}
		resultStr.append(COMPART);
		// ������
		if (resultVO.isOk()) {
			resultStr.append("�ɹ�");
		} else {
			resultStr.append("ʧ��");
		}
		resultStr.append(COMPART);
		return resultStr.toString();
	}

	private void doDelete(Long billcycle, String brandid, String itemid,Double feeamt)
			throws Exception {
		 String pkValue = billcycle+"|"+brandid+"|"+itemid;
		 YxPlanSplitValueVO yxplansplitvalueVO = (YxPlanSplitValueVO)delegate.doFindByPk(getDeletePkVO(pkValue),user);
		 if (yxplansplitvalueVO == null) {
		 throw new Exception("�Ҳ�����Ӧ�ļ�¼,�������ʲ�ֵ������");
		 }
		 yxplansplitvalueVO = new YxPlanSplitValueVO();
		 yxplansplitvalueVO.setBillcycle(billcycle);
		 yxplansplitvalueVO.setBrandid(brandid);
		 yxplansplitvalueVO.setItemid(itemid);
		 yxplansplitvalueVO.setSplitfee(feeamt);

		 delegate.doRemoveByVO(yxplansplitvalueVO,user);
	}

	/**
	 * �����¼
	 * 
	 */
	private void doInsert(Long billcycle, String brandid, String itemid,Double feeamt)
			throws Exception {
		
		if(allbrandstr.indexOf(brandid)==-1){
			 throw new Exception("�Ҳ�����Ӧ��Ʒ�Ʊ�ʶ,����Ʒ�Ʊ�ʶ�Ƿ����");
		 } 
		if(allitemstr.indexOf(itemid)==-1){
			 throw new Exception("�Ҳ�����Ӧ����Ŀ��ʶ,������Ŀ��ʶ�Ƿ����");
		 }
		 String pkValue = billcycle+"|"+brandid+"|"+itemid;
		 YxPlanSplitValueVO oldYxplansplitvalueVO = (YxPlanSplitValueVO)delegate.doFindByPk(getDeletePkVO(pkValue),user);
		 YxPlanSplitValueVO newYxplansplitvalueVO = new YxPlanSplitValueVO();
		 newYxplansplitvalueVO.setBillcycle(billcycle);
		 newYxplansplitvalueVO.setBrandid(brandid);
		 newYxplansplitvalueVO.setItemid(itemid);
		 newYxplansplitvalueVO.setSplitfee(feeamt);
						
		 if (oldYxplansplitvalueVO == null) {//����
			 delegate.doCreate(newYxplansplitvalueVO, user); // ������
			 oprtype = Short.valueOf("0");//Ĭ��������
		 }else{ //����
			 delegate.doUpdate(newYxplansplitvalueVO, user);
			 oprtype = Short.valueOf("2");
		 }
	}

	public void setOprtype(Short oprtype) {
		this.oprtype = oprtype;
	}
	
    /**
     * ����������ɾ��ʱ����������VO
     * ����List.jsp��ɾ����ťʱ���Ӳ�����ȡ��ɾ�����ݵ�������
     */
    protected Serializable getDeletePkVO(String pkValue) throws Exception {
        String[] pkValueArray = pkValue.split("\\|"); 
//      TODO: ������������������
        String[] pkNameArray = new String[3];
        pkNameArray[0] = "billcycle";
        pkNameArray[1] = "brandid";
        pkNameArray[2] = "itemid";
        Serializable vo = (Serializable) YxPlanSplitValueVO.class.newInstance();
        for (int j = 0; j < pkValueArray.length; j++) {
            BeanUtils.setProperty(vo, pkNameArray[j], pkValueArray[j]);
        }
       
        return vo;
    }
}