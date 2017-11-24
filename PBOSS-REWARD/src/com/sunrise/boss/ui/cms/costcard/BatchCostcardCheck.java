package com.sunrise.boss.ui.cms.costcard;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class BatchCostcardCheck extends BaseCheckFormat {
	private WayDelegate wayDelegate;

	private OperationDelegate operDelegate;

	public BatchCostcardCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	private WayDelegate getWayDelegate() throws Exception {
		if (wayDelegate == null) {
			return new WayDelegate();
		} else {
			return wayDelegate;
		}
	}

	private OperationDelegate getOperDelegate() throws Exception {
		if (operDelegate == null) {
			return new OperationDelegate();
		} else {
			return operDelegate;
		}

	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		if (rowCount > 50000) {
			throw new Exception("文件行数不能超过50000行");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		// 检查列数
		if (items.length != 5) {
			throw new Exception("上传数据列数不对,应为4列,请查看说明帮助!");
		}
		String[] columns = { "[渠道编码]", "[结算月份]", "[业务长码]", "[销售数量(张)]" };
		for (int i = 0; i < items.length - 2; i++) {
			if ("".equals(items[i].trim()) || items[i] == null) {
				throw new Exception(columns[i] + "不能为空");
			}

		}
		try { // 
			if (items[0].trim().length() > 18)
				throw new Exception("[渠道编码]长度不能大于18位");
			if (!"".equals(items[0].trim())) {
				WayVO vo = getWayDelegate().doFindByPk(items[0].trim(), user);
				if (vo == null) {
					throw new Exception(columns[0] + " : " + items[0].trim()
							+ " 在系统中不存在");
				}
			}
			if (!"".equals(items[1].trim())) {
				if (items[1].trim().length() != 6)
					throw new Exception("[结算月份]长度不对,应该是6位");
				if (!items[1].trim().matches("\\d{6}")) {
					throw new Exception("[结算月份]必须是[YYYYMM]格式");
				}
				long year = new Long(items[1].trim().substring(0, 4))
						.longValue();
				long month = new Long(items[1].trim().substring(4)).longValue();
				if (year < 0) {
					throw new Exception("[年份]:" + year + "必须是[YYYY]格式");
				}
				if (month > 12 || month < 0) {
					throw new Exception("[月份]:" + month + "必须正确并且是[MM]格式");
				}
			}
			if (items[2].trim().length() > 18) {
				throw new Exception(columns[2] + ":" + items[2].trim()
						+ "长度不能大于18位");
			}
			if (!"".equals(items[2].trim())) {
				OperationVO operVO = getOperDelegate().doFindByPk(
						items[2].trim(), user);
				if (operVO == null) {
					throw new Exception(columns[2] + " : " + items[2].trim()
							+ " 在系统中不存在");
				}
			}
			if (!"".equals(items[3].trim())) {
				try {
					new Long(items[3].trim());
				} catch (Exception ex) {
					throw new Exception(columns[3] + " : " + items[3].trim()
							+ "必须为数字");
				}
			}
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}
}
