package com.sunrise.boss.ui.cms.dcord;

import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

/**
 * @author cx-yz
 * 
 */
public class BatchDcordCheck extends BaseCheckFormat {
	WayDelegate delegate = null;

	public BatchDcordCheck() {
		super();
		try {
			delegate = new WayDelegate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		if (null == line || "".equals(line)) {
			return;
		}

		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		// 检查列数
		if (items.length != 7 && items.length != 3) {
			throw new Exception("格式错误，字段数错误，请查看文件格式说明!");
		}

		if (items.length == 7) {
			if (items[0] == null || "".equals(items[0].trim())) {
				throw new Exception("渠道编码不能为空");
			} else {
				WayVO vo = delegate.doFindByPk(items[0], user);
				if (vo == null) {
					throw new Exception("渠道编码错误，渠道不存在");
				}
				if (vo.getCityid() == null || !vo.getCityid().equals(SessionFactoryRouter.conversionCityid(user.getCityid()))) {
					throw new Exception("渠道编码所属地市与当前工号所属地市不一致");
				}
			}

			if (items[2] == null || "".equals(items[2].trim())) {
				throw new Exception("酬金期数字段不能为空且必须是数字，不能出现非数字字符");
			} else {
				String s = items[2].trim();
				if (!s.equals("1") && !s.equals("2") && !s.equals("3")) {
					throw new Exception("酬金期数字段只能是1、2、3中的数值");
				}
			}

			if (!checkDate(items[3])) {
				throw new Exception("业务发生月格式不正确，必须为6位的数字格式的年份加月份，如201208");
			}

			if (!checkDate(items[4])) {
				throw new Exception("结算月份格式不正确，必须为6位的数字格式的年份加月份，如201208");
			}

			if (items[5] == null || "".equals(items[5].trim())) {
				throw new Exception("结算状态字段不能为空且必须是数字");
			} else {
				String stat = items[5].trim();
				if (!stat.equals("0") && !stat.equals("3") && !stat.equals("4")) {
					throw new Exception("结算状态字段只能是0、3、4中的数值");
				}
			}
		} else if (items.length == 3) {
			if (items[0] == null || "".equals(items[0].trim())) {
				throw new Exception("序列号不能为空");
			} else {
				if (!items[0].trim().matches("\\d*")) {
					throw new Exception("序列号必须为数字");
				}
			}

			if (items[1] == null || "".equals(items[1].trim())) {
				throw new Exception("结算状态字段不能为空且必须是数字");
			} else {
				String stat = items[1].trim();
				if (!stat.equals("0") && !stat.equals("3") && !stat.equals("4")) {
					throw new Exception("结算状态字段只能是0、3、4中的数值");
				}
			}
		}
	}

	/**
	 * 校验日期格式：YYYYMM
	 * 
	 * @param date
	 * @return
	 */
	private boolean checkDate(String date) {
		if (date == null || "".equals(date.trim())) {
			return false;
		} else if (!date.trim().matches("[0-9]{6}")) {
			return false;
		} else {
			int year = Integer.parseInt(date.trim().substring(0, 4));
			int month = Integer.parseInt(date.trim().substring(4));
			if (year < 1000 || month < 1 || month > 12) {
				return false;
			} else {
				return true;
			}
		}
	}
}
