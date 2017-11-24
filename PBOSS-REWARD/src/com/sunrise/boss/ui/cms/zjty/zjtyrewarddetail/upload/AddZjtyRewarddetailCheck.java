package com.sunrise.boss.ui.cms.zjty.zjtyrewarddetail.upload;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.zjty.zjtyoperation.persistent.ZjtyOperationListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.zjty.zjtyoperation.ZjtyOperationDelegate;

import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.boss.ui.commons.User;

public class AddZjtyRewarddetailCheck extends BaseCheckFormat {

	public AddZjtyRewarddetailCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	/**
	 * 文件行的内容检查
	 */
	public void checkLine(String line, int rowCount, User user)
			throws Exception {

		if (rowCount > 10000) {
			throw new Exception("文件行数不能超过10000行");
		}
		if (null == line || "".equals(line.trim())) {
			return;
		}

		String[] items = line.split("\\|");
		WayDelegate waydelegate = new WayDelegate();
		// 检查列数
		if (items.length != 15) {
			throw new Exception("上传数据列数不对,应为15列,请查看说明帮助!");
		}

		if (!doCheckLong(items[0]) || items[0].length() > 14) {
			throw new BusinessException("", "第1列[业务流水]必须为数字且长度不能大于14");
		}
//		if (StringUtils.isEmpty(items[1])) {
//			throw new BusinessException("", "第2列[业务代码]不能为空");
//		}
		
		if (items[5].trim().equals("89")){
			if (items[1].trim().equals("6401010100001")||items[1].trim().equals("6401010100002")||items[1].trim().equals("6401010100003")){
			}else{
				throw new BusinessException("", "上传失败，该业务[" + items[1] + "]不属于【自助终端】酬金类型!");
			}
		}else if(items[5].trim().equals("90")){
			if (items[1].trim().equals("6501010200003")||items[1].trim().equals("6501010500001")||items[1].trim().equals("6501010500003")){
			}else{
				throw new BusinessException("", "上传失败，该业务[" + items[1]
				                                					+ "]不属于【G3和家庭市场产品销售】酬金类型!");
			}
		}
		
//		ZjtyOperationDelegate opndelegate = new ZjtyOperationDelegate();
//		DataPackage dp;
//		ZjtyOperationListVO listVO = new ZjtyOperationListVO();
//		listVO.set_se_opnid(items[1]);
//		dp = opndelegate.doQuery(listVO, user);
//		if (dp.getDatas().size() < 1) {
//			throw new BusinessException("", "上传失败，该业务[" + items[1]
//					+ "]未上架，请先进行业务上架操作!");
//		}

		// 渠道代码
		if (StringUtils.isEmpty(items[2])) {
			throw new BusinessException("", "第3列[渠道代码]不能为空");
		}
		WayVO wayvo = waydelegate.doFindByPk(items[2], user);
		if (wayvo == null) {
			throw new BusinessException("", "第3列[渠道代码]不存在");
		}
		
		WayListVO waylistvo = new WayListVO();
		WayDelegate wayDelegate = new WayDelegate();
		DataPackage dp1;
		waylistvo.set_se_wayid(items[2]);
		waylistvo.set_se_waytype("AG");
		waylistvo.set_se_waysubtype("ZJTY");
		dp1 = wayDelegate.doQuery(waylistvo, user);
		if (dp1.getDatas().size()<=0){
			throw new BusinessException("", "上传失败,第3列["+items[2]+"]不是自建他营渠道!");
		}
		// 酬金类型
		if (items[5].trim().equals("89") || items[5].trim().equals("90")) {
			
		} else {
			throw new Exception("第6列[酬金类型]不对，只能为89-【自助终端】和90-【G3和家庭市场产品销售】其中之一");
		}
		// 酬金标准
		if (!NumberUtils.isNumber(items[6])) {
			throw new BusinessException("", "第7列[酬金标准]必须为数字");
		}

//		try {
//			if (!(checkAmtFormat(items[6], 12)))
//				throw new Exception("第7列[酬金标准]格式不对(" + items[14]
//						+ "),整数部分最多12位，如有小数部分则一定是2位!");
//		} catch (Exception e) {
//			throw new Exception("第7列[酬金标准]格式不对(" + items[6]
//					+ "),整数部分最多12位，如有小数部分则一定是2位!");
//		}

		// 计酬方式
		
			
		if (!NumberUtils.isNumber(items[7])) {
			throw new BusinessException("", "第8列[计酬方式]必须为数字");
		}
		if (items[7].trim().equals("1") || items[7].trim().equals("2")) {
			
		}else{
			throw new Exception("第8列[计酬方式]不对，只能为1,2其中之一");
		}
		if (StringUtils.isEmpty(items[7])) {
			throw new BusinessException("", "第8列[计酬方式]不能为空");
		}
		// 管理考核系数
		if (items[8].trim().equals("")){
			
		}else if (!NumberUtils.isNumber(items[8])) {
			throw new BusinessException("", "第9列[管理考核系数]必须为数字");
		}else if (Double.parseDouble(items[8]) <= 1.2
				&& Double.parseDouble(items[8]) >= 0) {
		}else{
			throw new BusinessException("", "第9列[管理考核系数]区间为0－1.2");
		}
		
		if (items[8].substring(items[8].indexOf('.') + 1).length() > 2) {
			throw new BusinessException("", "管理考核系数超过范围,只支持到小数点后两位");
		}
		
		// 综合排名系数
		if (items[9].trim().equals("")){
			
		}else if (!NumberUtils.isNumber(items[9])) {
			throw new BusinessException("", "第10列[综合排名系数]必须为数字");
		}else if (Double.parseDouble(items[9]) <= 1.3
				&& Double.parseDouble(items[9]) >= 1) {
		}else{
			throw new BusinessException("", "第10列[综合排名系数]区间为1－1.3");
		}
		
		if (items[9].substring(items[9].indexOf('.') + 1).length() > 2) {
			throw new BusinessException("", "综合排名系数超过范围,只支持到小数点后两位");
		}
		// 否决系数
		if (items[10].trim().equals("")){
		}else if (!NumberUtils.isNumber(items[10])) {
			throw new BusinessException("", "第11列[否决系数]必须为数字");
		}else if (Double.parseDouble(items[10]) == 1
				|| Double.parseDouble(items[10]) == 0) {
		}else{
			throw new BusinessException("", "第11列[否决系数]区间为0或1");
		}
		//竞标系数
		if((items[11].trim().equals(""))){
			
		}else if (!NumberUtils.isNumber(items[11])) {
			throw new BusinessException("", "第12列[竞标系数]必须为数字");
		}else if (Double.parseDouble(items[11]) <= 1
				&& Double.parseDouble(items[11]) >= 0.5) {
		}else{
			throw new BusinessException("", "第12列[竞标系数]区间为0.5-1");
		}
		
		if (items[11].substring(items[11].indexOf('.') + 1).length() > 2) {
			throw new BusinessException("", "竞标系数超过范围,只支持到小数点后两位");
		}

		// 结算月份
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		if (StringUtils.isEmpty(items[12]) || items[12].length() != 6) {
			throw new BusinessException("", "第13列[结算月]不能为空且长度必须为6位");
		}
		try {
			format.parse(items[12]);
		} catch (Exception e) {
			throw new BusinessException("", "第13列[结算月]格式不正确，正确的格式应该为YYYYMM");
		}

		// 检查[计酬金额]是否为合法
		if (items[13].trim().equals("")){
			
		}else if (!NumberUtils.isNumber(items[13])) {
			throw new BusinessException("", "第14列[计酬金额]必须为数字");
		}
		try {
			if (!(checkAmtFormat(items[13], 12)))
				throw new Exception("第14列[计酬金额]格式不对(" + items[13]
						+ "),整数部分最多12位，如有小数部分则一定是2位!");
		} catch (Exception e) {
			throw new Exception("第14列[计酬金额]格式不对(" + items[13]
					+ "),整数部分最多12位，如有小数部分则一定是2位!");
		}

		// 检查[应发金额]是否为合法
		if (StringUtils.isEmpty(items[14]) || !NumberUtils.isNumber(items[14])) {
			throw new BusinessException("", "第15列[应发金额]不能为空并且必须为数字");
		}
		try {
			if (!(checkAmtFormat(items[14], 12)))
				throw new Exception("第15列[应发金额]格式不对(" + items[14]
						+ "),整数部分最多12位，如有小数部分则一定是2位!");
		} catch (Exception e) {
			throw new Exception("第15列[应发金额]格式不对(" + items[14]
					+ "),整数部分最多12位，如有小数部分则一定是2位!");
		}
	}

	public static boolean checkDate(String date) {
		boolean ret = true;
		if (date.length() != 8)
			return false;
		try {
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
			sd.parse(date);
		} catch (Exception e) {
			return false;
		}
		return ret;
	}

	public boolean doCheckLong(String number) {
		try {
			Long.parseLong(number);
		} catch (NumberFormatException exception) {
			return false;
		}
		return true;
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

	public static void main(String[] args) {

		AddZjtyRewarddetailCheck check = new AddZjtyRewarddetailCheck();

	}

}
