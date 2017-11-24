package com.sunrise.boss.ui.cms.zjty.zjtyrewardcoef.upload;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.zjty.zjtyrewardcoef.persistent.ZjtyRewardcoefVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.zjty.zjtyrewardcoef.ZjtyRewardcoefDelegate;

import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.boss.ui.commons.User;

public class AddZjtyRewardcoefCheck extends BaseCheckFormat {

	public AddZjtyRewardcoefCheck() {
		super();
	}

	private static Date getDefaultDate(int i) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, i);
		return c.getTime();
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
		WayListVO waylistvo = new WayListVO();
		DataPackage dp;
		
		// 检查列数
		if (items.length != 5) {
			throw new Exception("上传数据列数不对,应为5列,请查看说明帮助!");
		}
		
		// 历史作用月
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
//		String effectiblemont = format.format(AddZjtyRewardcoefCheck
//				.getDefaultDate(-1));
//		if (Integer.parseInt(items[0]) < Integer.parseInt(effectiblemont)) {
//			throw new BusinessException("", "作用月不能为历史作用月");
//		}
		if (StringUtils.isEmpty(items[0]) || items[0].length() > 6) {
			throw new BusinessException("", "作用月不能为空且长度不能超过6位");
		}
		try {
			format.parse(items[0]);
		} catch (Exception e) {
			throw new BusinessException("", "作用月格式不正确，正确的格式应该为YYYYMM");
		}
		// 酬金系数
		if (items[1].trim().equals("0") || items[1].trim().equals("1")
				|| items[1].trim().equals("2") || items[1].trim().equals("3")) {

		} else {
			throw new Exception("[酬金系数]不对，只能为0,1,2,3其中之一");
		}
		
		if (items[1].trim().equals("0")){
			if(Double.parseDouble(items[3])<=1.2 && Double.parseDouble(items[3])>=0){
			}else{
				throw new BusinessException("", "管理考核系数区间为0－1.2");
			}
		}
		if (items[1].trim().equals("1")){
			if(Double.parseDouble(items[3])<=1.3 && Double.parseDouble(items[3])>=1){
			}else{
				throw new BusinessException("", "综合排名系数区间为1－1.3");
			}
		}
		if (items[1].trim().equals("2")){
			if(Double.parseDouble(items[3])==1 || Double.parseDouble(items[3])==0){
			}else{
				throw new BusinessException("", "否决系数区间为0或1");
			}
		}
		if (items[1].trim().equals("3")){
			if(Double.parseDouble(items[3])<=1 && Double.parseDouble(items[3])>=0.5){
			}else{
				throw new BusinessException("", "竞标系数区间为0.5-1");
			}
		}
		// 渠道代码
		if (StringUtils.isEmpty(items[2])) {
			throw new BusinessException("", "渠道代码不能为空");
		}
		WayVO wayvo = waydelegate.doFindByPk(items[2], user);
		if (wayvo == null) {
			throw new BusinessException("", "渠道代码不存在");
		}
		
		waylistvo.set_se_wayid(items[2]);
		waylistvo.set_se_waytype("AG");
		waylistvo.set_se_waysubtype("ZJTY");
		dp = waydelegate.doQuery(waylistvo, user);
		if (dp.getDatas().size() <= 0) {
			throw new BusinessException("","上传失败, 该渠道不是自建他营渠道!");
		}
		// 发放系数
		if (StringUtils.isEmpty(items[3]) || !NumberUtils.isNumber(items[3])) {
			throw new BusinessException("", "发放系数不能为空并且必须为数字");
		}
		if (items[3].substring(items[3].indexOf('.') + 1).length() > 2) {
			throw new BusinessException("", "发放系数超过范围,只支持到小数点后两位");
		}
		// 判断记录是否已存在
		ZjtyRewardcoefVO coefvo = new ZjtyRewardcoefVO();
		ZjtyRewardcoefDelegate coefdelegate = new ZjtyRewardcoefDelegate();
		coefvo.setEffectiblemonth(items[0]);
		coefvo.setCoefid(new Short(items[1]));
		coefvo.setWayid(items[2]);
		if(coefdelegate.doFindByPk(coefvo, user)!=null){
			throw new BusinessException("", "上传失败，记录在系统已存在。");
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

	public static void main(String[] args) {

		AddZjtyRewardcoefCheck check = new AddZjtyRewardcoefCheck();

	}

}
