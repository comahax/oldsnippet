package com.sunrise.boss.ui.cms.resale;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.boss.delegate.cms.cntycompany.CntycompanyDelegate;
import com.sunrise.boss.business.cms.cntycompany.persistent.CntycompanyVO;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;

public class BatchResaleCheck extends BaseCheckFormat {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	private WayDelegate wayDelegate;

	WayVO wayVO = new WayVO();

	WayVO wayVO1;

	CntycompanyDelegate cntycompanyDelegate;

	CntycompanyVO cntycompanyVO = new CntycompanyVO();

	CntycompanyVO cntycompanyVO1;

	public BatchResaleCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new BusinessException("",
					"要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
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
			throw new BusinessException("", "上传数据列数不对,应为5列,请查看说明帮助!");
		}

		// 新增记录
		// 检查销售渠道编码items[0]
		if ((items[0] == null || items[0].equals("")) || items[1].length() > 18) {
			throw new BusinessException("", "销售渠道编码不对，应该为小于18位的字符串!");
		} else {
			wayVO.setWayid(items[0]);
			wayDelegate = new WayDelegate();
			wayVO1 = wayDelegate.doFindByPk(wayVO.getWayid(), user);
			if (wayVO1 == null) {
				throw new BusinessException("", "销售渠道编码不存在!");
			}
		}
		// 检查分公司编码items[1]

		if ((items[1] == null || items[1].equals("")) || items[1].length() > 14) {
			throw new BusinessException("", "分公司编码不对，应该为小于14位的字符串!");
		} else {

			cntycompanyDelegate = new CntycompanyDelegate();
			cntycompanyVO.setCountycompid(items[1]);
			cntycompanyVO1 = cntycompanyDelegate.doFindByPk(cntycompanyVO
					.getCountycompid(), user);
			if (cntycompanyVO1 != null) {
				String city = cntycompanyVO1.getCitycompid();
				String city1 = SessionFactoryRouter.conversionCityid(user
						.getCityid());
				if (city1.equals(city)) {
				} else {
					throw new BusinessException("", "分公司编码不存在!");
				}
			} else {
				throw new BusinessException("", "分公司编码不存在!");
			}
		}

		// 检查号码items[2]
		if ((items[2] == null || items[2].equals("")) || items[2].length() > 12) {
			throw new BusinessException("", "号码不对，应该为小于12位的字符串!");
		} else {
			try {
				Long temp1 = Long.valueOf(items[2]);
			} catch (Exception e1) {
				throw new BusinessException("", "上传数据的号码数据类型不对(" + items[2]
						+ "),应该是数字字符串!");
			}
		}
		// 检查品牌items[3]
		if ((items[3] == null || items[3].equals(""))) {
			throw new BusinessException("", "品牌不能为空!");
		} else if (!items[3].trim().matches("[123]")) {
			throw new Exception("[品牌]格式不对:取值应是:1(全球通)2(神州行)3(动感地带)之一");
		}

		// 检查销售日期items[4]
		if (items[4] != null && !"".equals(items[4])) {
			try {
				sdf.parse(items[4]);
			} catch (ParseException pe) {
				throw new BusinessException("", "销售日期不对,应为YYYY-MM-DD!");
			}
		}
		if (items[4].length() != 10) {
			throw new BusinessException("", "销售日期不对,应为YYYY-MM-DD!");
		}

	}    
}
