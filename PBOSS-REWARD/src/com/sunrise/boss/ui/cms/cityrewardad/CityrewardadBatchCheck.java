package com.sunrise.boss.ui.cms.cityrewardad;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.boss.ui.commons.User;

public class CityrewardadBatchCheck extends BaseCheckFormat {

	public CityrewardadBatchCheck() {
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
		if (items.length != 4) {
			throw new Exception("上传失败,数据列数不合法,应为4列,请查看说明帮助!");
		}

		// 渠道校验
		if (StringUtils.isEmpty(items[0])) {
			throw new BusinessException("", "上传失败,第1列导入[渠道编码]不能为空");
		}

		WayVO wayvo = waydelegate.doFindByPk(items[0], user);
		if (wayvo == null) {
			throw new BusinessException("", "上传失败,第1列导入[渠道编码]不存在");
		}

		WayListVO waylistvo = new WayListVO();
		WayDelegate wayDelegate = new WayDelegate();
		DataPackage dp1;
		waylistvo.set_se_wayid(items[0]);
		waylistvo.set_se_cityid(SessionFactoryRouter.conversionCityid(user
				.getCityid()));
		//waylistvo.set_se_cityid(user.getCityid());
		waylistvo.set_se_waytype("AG");
		dp1 = wayDelegate.doQuery(waylistvo, user);
		if (dp1.getDatas().size() <= 0) {
			throw new BusinessException("", "上传失败,第1列[渠道编码]非本地市的社会渠道或不存在!");
		}

		// 酬金类型
		if (StringUtils.isEmpty(items[1])) {
			throw new BusinessException("", "上传失败,第2列[酬金类型]不能为空");
		}

		if (!NumberUtils.isNumber(items[1])) {
			throw new BusinessException("", "上传失败,第2列[酬金类型]必须为数字");
		}

		if (items[1].trim().equals("3") || items[1].trim().equals("4")) {
		} else {
			throw new Exception("上传失败,第2列[酬金类型]不合法，应为 3 数据业务基本酬金 或 4 数据业务奖励酬金");
		}

		// 发放月份
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		if (StringUtils.isEmpty(items[2])) {
			throw new BusinessException("", "上传失败,第3列[发放月份]不合法,不能为空!");
		}
		if(items[2].length() != 6){
			throw new BusinessException("", "上传失败,第3列[发放月份]不合法,长度必须为6位!");
		}
		
		if(!NumberUtils.isNumber(items[2])){
			throw new BusinessException("", "上传失败,第3列[发放月份]不合法,只能为数字!");
		}
			
		try {
			format.parse(items[2]);
		} catch (Exception e) {
			throw new BusinessException("", "上传失败,第3列[发放月份]不合法,应为6位年月数字!");
		}
		
		String regex = "^([1-9]\\d{3}[0][1-9])|([1-9]\\d{3}[1][0-2])$";
		if (!items[2].matches(regex)) {
			throw new BusinessException("", "上传失败,第3列[发放月份]不合法,月份范围应为[01-12]!");
		}

		// 金额校验
		if (StringUtils.isEmpty(items[3]) || !NumberUtils.isNumber(items[3])) {
			throw new BusinessException("", "上传失败,第4列[金额]不合法,应为数字,支持两位小数");
		}
		try {
			if (!(checkAmtFormat(items[3], 10)))
				throw new Exception("上传失败,第4列[金额]不合法,(" + items[3]
						+ ")应为数字,整数部分最多10位，如有小数部分则一定是2位!");
		} catch (Exception e) {
			throw new Exception("上传失败,第4列[金额]不合法,(" + items[3]
					+ ")应为数字,整数部分最多10位，如有小数部分则一定是2位!");
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
}
