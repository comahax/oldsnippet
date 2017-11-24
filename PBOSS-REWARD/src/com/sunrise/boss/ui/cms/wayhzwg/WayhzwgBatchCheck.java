package com.sunrise.boss.ui.cms.wayhzwg;

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

public class WayhzwgBatchCheck extends BaseCheckFormat {

	public WayhzwgBatchCheck() {
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
		if (items.length != 3) {
			throw new Exception("上传失败,数据列数不合法,应为3列,请查看说明帮助!");
		}

		// 渠道校验
		if (StringUtils.isEmpty(items[0])) {
			throw new BusinessException("", "上传失败,第1列导入[渠道编码]不能为空");
		}

		WayVO wayvo = waydelegate.doFindByPk(items[0], user);
		if (wayvo == null) {
			throw new BusinessException("", "上传失败,第1列导入[渠道编码]不存在");
		}
		// 判断是否为当前地市的社会渠道编码
		WayListVO waylistvo = new WayListVO();
		WayDelegate wayDelegate = new WayDelegate();
		DataPackage dp1;
		waylistvo.set_se_wayid(items[0]);
		waylistvo.set_se_waytype("AG");
		waylistvo.set_se_cityid(SessionFactoryRouter.conversionCityid(user
				.getCityid()));
		dp1 = wayDelegate.doQuery(waylistvo, user);
		if (dp1.getDatas().size() <= 0) {
			throw new BusinessException("", "上传失败,第1列[渠道编码]非本地市的社会渠道!");
		}

		// 年月校验
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		if (StringUtils.isEmpty(items[1])) {
			throw new BusinessException("", "上传失败,第2列[违规月份]不合法,导入不能为空!");
		}
		if (items[1].length() != 6){
			throw new BusinessException("", "上传失败,第2列[违规月份]不合法,长度必须为6位!");
		}
		if (!NumberUtils.isNumber(items[1])){
			throw new BusinessException("","上传失败,第2列[违规月份]不合法,必须为数字!");
		}
		String regex = "^([1-9]\\d{3}[0][1-9])|([1-9]\\d{3}[1][0-2])$";
		if (!items[1].matches(regex)) {
			throw new BusinessException("", "上传失败,第2列[违规月份]不合法,月份范围应为[01-12]!");
		}
		try {
			format.parse(items[1]);
		} catch (Exception e) {
			throw new BusinessException("", "上传失败,第2列[违规月份]不合法，应为6位年月数字,前4位为合法年,后2位为合法月!");
		}

		// 备注校验
		if (StringUtils.isEmpty(items[2]) || items[2].length() > 600) {
			throw new BusinessException("", "上传失败,第4列[备注]不能为空!");
		}
	}
}
