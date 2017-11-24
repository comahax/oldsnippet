package com.sunrise.boss.ui.cms.reward.busitocom;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;

import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.boss.ui.commons.User;

public class AddBusitocomBatchCheck extends BaseCheckFormat {

	public AddBusitocomBatchCheck() {
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
		
		//商品标识
		if (StringUtils.isEmpty(items[0])) {
			throw new BusinessException("", "第1列【商品标识】不能为空!");
		}
		
		if (items[0].length()>18){
			throw new BusinessException("", "第1列【商品标识】长度不能超过18位!");
		}
		
		if (!NumberUtils.isNumber(items[0])) {
			throw new BusinessException("", "第1列【商品标识】必须为数字");
		}
		
		//业务编码
		if (StringUtils.isEmpty(items[1])) {
			throw new BusinessException("", "第2列【业务编码】不能为空!");
		}
		
		if (items[1].length()>18){
			throw new BusinessException("", "第2列【业务编码】长度不能超过18位!");
		}
		
		if (!NumberUtils.isNumber(items[1])) {
			throw new BusinessException("", "第2列【业务编码】必须为数字");
		}
		
		if(items[1].trim().substring(0, 4).equals("0403")){
			ProvincialrightVO rightvo = new ProvincialrightVO();
			rightvo.setProopr(user.getOpercode());
			rightvo.setRightid("CH_PW_TERMINALSELL");
			CommonDelegate delegate = new CommonDelegate(ProvincialrightVO.class);
			rightvo = (ProvincialrightVO) delegate.doFindByPk(rightvo, user);
			if (rightvo == null) {
				throw new BusinessException("","第2列【业务编码】当前工号不能导入[0403]开头的业务!");
			}
		}
		
		//业务编码起始价格(元)
		if (StringUtils.isEmpty(items[2])) {
			throw new BusinessException("", "第3列【业务编码起始价格(元)】不能为空!");
		}
		
		if (items[2].length()>14){
			throw new BusinessException("", "第3列【业务编码起始价格(元)】长度不能超过18位!");
		}
		
		if (!NumberUtils.isNumber(items[2])) {
			throw new BusinessException("", "第3列【业务编码起始价格(元)】必须为数字");
		}
		
		//业务编码结束价格(元)
		if (StringUtils.isEmpty(items[3])) {
			throw new BusinessException("", "第4列【业务编码结束价格(元)】不能为空!");
		}
		
		if (items[3].length()>14){
			throw new BusinessException("", "第4列【业务编码结束价格(元)】长度不能超过18位!");
		}
		
		if (!NumberUtils.isNumber(items[3])) {
			throw new BusinessException("", "第4列【业务编码结束价格(元)】必须为数字");
		}
		
		//业务组编码
		if (StringUtils.isEmpty(items[4])) {
			throw new BusinessException("", "第5列【业务组编码】不能为空!");
		}
		
		if (items[4].length()>32){
			throw new BusinessException("", "第5列【业务组编码】长度不能超过32位!");
		}
		
		if (items[4].equals("MOBILE") || items[4].equals("TDNOTEBOOK")
				|| items[4].equals("TDDATACARD") || items[4].equals("HOMEGW")||items[4].equals("WIRESSPHONE")) {

		} else {
			throw new Exception("第5列【业务组编码】格式不正确!请查看补充说明");
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

		AddBusitocomBatchCheck check = new AddBusitocomBatchCheck();

	}

}
