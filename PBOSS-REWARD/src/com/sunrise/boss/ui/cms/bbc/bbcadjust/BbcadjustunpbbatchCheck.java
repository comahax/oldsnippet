package com.sunrise.boss.ui.cms.bbc.bbcadjust;


import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.bbc.unvrc.persistent.UnvrcVO;
import com.sunrise.boss.business.cms.nasway.persistent.NaswayVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.db.BaseListVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.StringSplit;

public class BbcadjustunpbbatchCheck extends BaseCheckFormat {
	
	private String oprType;
	/**
	 * 1.调整类别
	 * PUNISH:扣减;RETURN:返回;BONUS:奖励;
	 */
	protected static HashMap ADJUSTKIND_MAP=new HashMap();
	
	protected static HashMap ADJUSTTYPE_MAP=new HashMap();
	/**
	 * 3.调整原因类型
					扣减:
						P-YWWG:业务违规;P-QTYY 其他原因扣减
					返还:
						R-DKBH:多扣补还;R-LSBG:漏算补给;R-QTYY:其他原因返还
	 */
	protected static HashMap REASONTYPE_MAP=new HashMap();
	
	private static final Log log = LogFactory.getLog(BbcadjustunpbbatchCheck.class);
	
	public BbcadjustunpbbatchCheck() {
		ADJUSTKIND_MAP.put("PUNISH", "PUNISH");
		ADJUSTKIND_MAP.put("RETURN", "RETURN");
		REASONTYPE_MAP.put("P-YWWG", "P-YWWG");
		REASONTYPE_MAP.put("P-QTYY", "P-QTYY");
		REASONTYPE_MAP.put("R-DKBH", "R-DKBH");
		REASONTYPE_MAP.put("R-LSBG", "R-LSBG");
		REASONTYPE_MAP.put("R-QTYY", "R-QTYY");
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("","要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
		try {
			if (parameterMap.get("oprType") != null
					&& !"".equals((String) parameterMap.get("oprType"))) {
				setOprType((String) parameterMap.get("oprType"));
			}
			if (log.isInfoEnabled()) {
				log.info(oprType);
			}
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw ex;
		}
	}
	
	public void checkLine(String line, int rowCount, User user) throws Exception {
		
		String[] content =StringSplit.split(line, "|");
		CommonDelegate commondelegate = null;
		SimpleDateFormat format=new SimpleDateFormat("yyyyMM");
		format.setLenient(false);
		
		if("0".equals(getOprType())){
			if (content.length == 7) {
					;
			}else{
				throw new BusinessException("","参数不完整.应该有7项");
			}
			/**
			 * PUNISH:扣减;RETURN:返回;BONUS:奖励;
			 */
			if(StringUtils.isEmpty(content[0]) || !ADJUSTKIND_MAP.containsKey(content[0]) || content[0].length() >32){			
				throw new BusinessException("","调整类别类型不正确!");
			}
			if(StringUtils.isEmpty(content[1]) || content[1].length() >18){
				throw new BusinessException("","渠道编码不能为空!");
			}

			if (StringUtils.isEmpty(content[2])) {
				throw new BusinessException("", "作用结算月不合法,不能为空!");
			}
			if(content[2].length() != 6){
				throw new BusinessException("", "作用结算月不合法,长度必须为6位!");
			}
			
			if(!NumberUtils.isNumber(content[2])){
				throw new BusinessException("", "作用结算月不合法,只能为数字!");
			}
				
			try {
				format.parse(content[2]);
			} catch (Exception e) {
				throw new BusinessException("", "作用结算月不合法,应为6位年月数字!");
			}
			String regex = "^([1-9]\\d{3}[0][1-9])|([1-9]\\d{3}[1][0-2])$";
			if (!content[2].matches(regex)) {
				throw new BusinessException("", "作用结算月不合法,月份范围应为[01-12]!");
			}
			
			try {
				format.parse(content[6]);
			} catch (Exception e) {
				throw new BusinessException("", "酬金发生月不合法,应为6位年月数字!");
			}
			if (!content[6].matches(regex)) {
				throw new BusinessException("", "酬金发生月不合法,月份范围应为[01-12]!");
			}
			
			if(Integer.parseInt(content[2]) < Integer.parseInt(content[6])){
				throw new BusinessException("", "酬金发生月应当小于等于作用结算月!");
			}
			
//			 金额校验
			if (StringUtils.isEmpty(content[3]) || !NumberUtils.isNumber(content[3]) || Double.parseDouble(content[3]) <= 0) {
				throw new BusinessException("", "调整金额不合法,应为正数,支持两位小数");
			}
			try {
				if (!(checkAmtFormat(content[3], 10)))
					throw new Exception("调整金额不合法,(" + content[3]
							+ ")整数部分最多10位，如有小数部分则一定是2位!");
			} catch (Exception e) {
				throw new Exception("调整金额不合法,(" + content[3]
						+ ")整数部分最多10位，如有小数部分则一定是2位!");
			}
		
			if(StringUtils.isEmpty(content[4]) || !",".equals(content[4].substring(content[4].length()-1)) || content[4].length() >32){
				throw new BusinessException("","调整原因类型不正确!");
			}
			if(StringUtils.isEmpty(content[5]) || content[5].length() >500){
				throw new BusinessException("","备注不正确!");
			}
			String[] reasontype = content[4].split(",");
			for (int i=0;i<reasontype.length;i++) {
				if (!REASONTYPE_MAP.containsKey(reasontype[i])) {
					throw new BusinessException("","调整原因类型不正确!");
				}
				if(!reasontype[i].substring(0,1).equals(content[0].subSequence(0, 1))){
					throw new BusinessException("","调整类别与调整原因类型不对应,PUNISH应对应P-开头,RETURN应对应R-开头!");
				}
			}
			
		}else if("1".equals(getOprType())){
			if (content.length == 8) {
				;
			}else{
				throw new BusinessException("","参数不完整.应该有8项");
			}
			/**
			 * EMPPUNISH:扣减;EMPRETURN:返回;BONUS:奖励;
			 */
//			EMPPUNISH|FJMCQ10001|11133434556|200808|200.00|P-YWWG,P-QTYY|备注，违规扣罚|200807|
//			0             1          2          3     4           5        6           7
			if(StringUtils.isEmpty(content[0]) || !("EMPPUNISH".equals(content[0]) || "EMPRETURN".equals(content[0]))||content[0].length() >32){
				throw new BusinessException("","调整类别类型不正确!");
			}
			if(StringUtils.isEmpty(content[1]) || content[1].length() >18){
				throw new BusinessException("","渠道编码不能为空!");
			}
			if(StringUtils.isEmpty(content[2])){
				throw new BusinessException("手机号码不能为空!");
			}
			if (StringUtils.isEmpty(content[3])) {
				throw new BusinessException("", "作用结算月不合法,不能为空!");
			}
			if(content[3].length() != 6){
				throw new BusinessException("", "作用结算月不合法,长度必须为6位!");
			}
			
			if(!NumberUtils.isNumber(content[3])){
				throw new BusinessException("", "作用结算月不合法,只能为数字!");
			}
				
			try {
				format.parse(content[3]);
			} catch (Exception e) {
				throw new BusinessException("", "作用结算月不合法,应为6位年月数字!");
			}
			String regex = "^([1-9]\\d{3}[0][1-9])|([1-9]\\d{3}[1][0-2])$";
			if (!content[3].matches(regex)) {
				throw new BusinessException("", "作用结算月不合法,月份范围应为[01-12]!");
			}
			
			if(Integer.parseInt(content[3]) < Integer.parseInt(content[7])){
				throw new BusinessException("", "酬金发生月应当小于等于作用结算月!");
			}
			
//			 金额校验
			if (StringUtils.isEmpty(content[4]) || !NumberUtils.isNumber(content[4]) || Double.parseDouble(content[4]) <= 0) {
				throw new BusinessException("", "调整金额不合法,应为正数,支持两位小数");
			}
			try {
				if (!(checkAmtFormat(content[4], 10)))
					throw new Exception("调整金额不合法,(" + content[4]
							+ ")整数部分最多10位，如有小数部分则一定是2位!");
			} catch (Exception e) {
				throw new Exception("调整金额不合法,(" + content[4]
						+ ")整数部分最多10位，如有小数部分则一定是2位!");
			}
		
			if(StringUtils.isEmpty(content[5]) || !",".equals(content[5].substring(content[5].length()-1)) || content[5].length() >32){
				throw new BusinessException("","调整原因类型不正确,需以半角逗号结尾!");
			}
			if(StringUtils.isEmpty(content[6]) || content[5].length() >500){
				throw new BusinessException("","备注不正确!");
			}
			String[] reasontype = content[5].split(",");
			for (int i=0;i<reasontype.length;i++) {
				if (!REASONTYPE_MAP.containsKey(reasontype[i])) {
					throw new BusinessException("","调整原因类型不正确!");
				}
				if(!reasontype[i].substring(0,1).equals(content[0].subSequence(3, 4))){
					throw new BusinessException("","调整类别与调整原因类型不对应,EMPPUNISH应对应P-开头,EMPRETURN应对应R-开头!");
				}
			}
			
			try {
				format.parse(content[7]);
			} catch (Exception e) {
				throw new BusinessException("", "酬金发生月不合法,应为6位年月数字!");
			}
			if (!content[7].matches(regex)) {
				throw new BusinessException("", "酬金发生月不合法,月份范围应为[01-12]!");
			}
		}else{
			throw new BusinessException("","格式不正确, 请参考说明帮助");
		}
		
		BaseListVO listVO = new BaseListVO();
		//1.WAY
		commondelegate = new CommonDelegate(WayVO.class);
		HashMap map = new HashMap();
		map.put("_se_wayid", content[1]);
		listVO.setQueryConditions(map);
		if(commondelegate.doQuery(listVO, user).getDatas().size()==0){
			commondelegate = new CommonDelegate(NaswayVO.class);
			if(commondelegate.doQuery(listVO, user).getDatas().size()==0){
				commondelegate = new CommonDelegate(UnvrcVO.class);
				HashMap rcMap = new HashMap();
				rcMap.put("_se_rcid", content[1]);
				listVO.setQueryConditions(rcMap);
				if(commondelegate.doQuery(listVO, user).getDatas().size()==0){
					throw new BusinessException("","网点代码不存在");
				}
			}
		}
	}
	
	public boolean checkAmtFormat(String amt, int length) {
		amt = amt.trim();
		if (amt.indexOf(".") != -1) {
			if (amt.indexOf(".") == 0) {
				return false;
			}
			if (amt.indexOf(".") > length) {
				return false;
			}
			if ((amt.length() - amt.indexOf(".")) != 3) {
				return false;
			}
		} else {
			if (amt.length() > length) {
				return false;
			}
		}
		return true;
	}

	public String getOprType() {
		return oprType;
	}

	public void setOprType(String oprType) {
		this.oprType = oprType;
	}

}
		
