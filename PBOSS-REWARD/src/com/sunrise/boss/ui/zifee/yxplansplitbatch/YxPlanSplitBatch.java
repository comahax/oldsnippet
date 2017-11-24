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
		return "序号 | 帐务周期 | 品牌标识 | 语音基本通话月使用费 | 语音漫游通话月使用费 | 语音长途通话月使用费 | 操作类型 | 操作结果"+"\r\n";
	}

	/**
	 * 处理一条记录
	 */
	public ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		Long billcycle;
		String[] items = line.split("\\|");
//		if(null !=items && items.length==5 && !items[1].trim().startsWith("Brand")){
//			isBoss10Format = true;//如果文件为5列，则是boss1.0的导入格式，如20061200|0| 14446440.80| 1814262.00| 1826461.56
//		}
		isBoss10Format=(null !=items && items.length==5 && !items[1].trim().startsWith("Brand"));
		try {
			billcycle = new Long(items[0]);
			String brandid = items[1];
			if(isBoss10Format){
				brandid = exchangeBrand10To15(items[1]);
			}
			Double baseamt = Double.valueOf(items[2]);//语音基本通话月使用费
			Double myamt = Double.valueOf(items[3]);//语音漫游通话月使用费
			Double ctamt = Double.valueOf(items[4]);//语音长途通话月使用费
			
			//String itemid = items[2];
			//Double feeamt = Double.valueOf(items[3]);
		
			if (oprtype.shortValue() == 0 || oprtype.shortValue() == 2) { // 增加/修改
				doInsert(billcycle, brandid, "1",baseamt);//语音基本通话月使用费
				doInsert(billcycle, brandid, "2",ctamt);//语音长途通话月使用费
				doInsert(billcycle, brandid, "3",myamt);//语音漫游通话月使用费
			}
			if (oprtype.shortValue() == 3) { // 删除
				doDelete(billcycle, brandid, "1",baseamt);//语音基本通话月使用费
				doDelete(billcycle, brandid, "2",ctamt);//语音长途通话月使用费
				doDelete(billcycle, brandid, "3",myamt);//语音漫游通话月使用费
			}
			resultVO.setOk(true);
			resultVO.setInfo(showInfo(resultVO, items, rowCount));
			return resultVO;
		} catch (Exception ex) { // 插入失败
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
			//throw new Exception("品牌标识转换失败");
		}
		return brand15;
	}

	/**
	 * 结果文件格式
	 */
	public String showInfo(ResultVO resultVO, String[] items, int rowCount) {
		final String COMPART = " | "; // 分隔
		StringBuffer resultStr = new StringBuffer();
		// 序号
		resultStr.append(rowCount).append(COMPART);
		// 帐期
		resultStr.append(items[0]).append(COMPART);		
		// 产品标识
		resultStr.append(items[1]).append(COMPART);
		// 语音基本通话月使用费
		resultStr.append(items[2]).append(COMPART);
		// 语音漫游通话月使用费
		resultStr.append(items[3]).append(COMPART);
		// 语音长途通话月使用费
		resultStr.append(items[4]).append(COMPART);
		// 操作类型
		if (oprtype.shortValue() == 0) {
			resultStr.append("增加");
		}
		if (oprtype.shortValue() == 2) {
			resultStr.append("更新");
		}
		if (oprtype.shortValue() == 3) {
			resultStr.append("删除");
		}
		resultStr.append(COMPART);
		// 办理结果
		if (resultVO.isOk()) {
			resultStr.append("成功");
		} else {
			resultStr.append("失败");
		}
		resultStr.append(COMPART);
		return resultStr.toString();
	}

	private void doDelete(Long billcycle, String brandid, String itemid,Double feeamt)
			throws Exception {
		 String pkValue = billcycle+"|"+brandid+"|"+itemid;
		 YxPlanSplitValueVO yxplansplitvalueVO = (YxPlanSplitValueVO)delegate.doFindByPk(getDeletePkVO(pkValue),user);
		 if (yxplansplitvalueVO == null) {
		 throw new Exception("找不到相应的记录,不在列帐拆分导入表中");
		 }
		 yxplansplitvalueVO = new YxPlanSplitValueVO();
		 yxplansplitvalueVO.setBillcycle(billcycle);
		 yxplansplitvalueVO.setBrandid(brandid);
		 yxplansplitvalueVO.setItemid(itemid);
		 yxplansplitvalueVO.setSplitfee(feeamt);

		 delegate.doRemoveByVO(yxplansplitvalueVO,user);
	}

	/**
	 * 插入记录
	 * 
	 */
	private void doInsert(Long billcycle, String brandid, String itemid,Double feeamt)
			throws Exception {
		
		if(allbrandstr.indexOf(brandid)==-1){
			 throw new Exception("找不到相应的品牌标识,请检查品牌标识是否存在");
		 } 
		if(allitemstr.indexOf(itemid)==-1){
			 throw new Exception("找不到相应的项目标识,请检查项目标识是否存在");
		 }
		 String pkValue = billcycle+"|"+brandid+"|"+itemid;
		 YxPlanSplitValueVO oldYxplansplitvalueVO = (YxPlanSplitValueVO)delegate.doFindByPk(getDeletePkVO(pkValue),user);
		 YxPlanSplitValueVO newYxplansplitvalueVO = new YxPlanSplitValueVO();
		 newYxplansplitvalueVO.setBillcycle(billcycle);
		 newYxplansplitvalueVO.setBrandid(brandid);
		 newYxplansplitvalueVO.setItemid(itemid);
		 newYxplansplitvalueVO.setSplitfee(feeamt);
						
		 if (oldYxplansplitvalueVO == null) {//新增
			 delegate.doCreate(newYxplansplitvalueVO, user); // 插数据
			 oprtype = Short.valueOf("0");//默认是新增
		 }else{ //更新
			 delegate.doUpdate(newYxplansplitvalueVO, user);
			 oprtype = Short.valueOf("2");
		 }
	}

	public void setOprtype(Short oprtype) {
		this.oprtype = oprtype;
	}
	
    /**
     * 按复合主键删除时，返回主键VO
     * 用于List.jsp按删除按钮时，从参数中取出删除数据的主键列
     */
    protected Serializable getDeletePkVO(String pkValue) throws Exception {
        String[] pkValueArray = pkValue.split("\\|"); 
//      TODO: 给出主键的名字数组
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