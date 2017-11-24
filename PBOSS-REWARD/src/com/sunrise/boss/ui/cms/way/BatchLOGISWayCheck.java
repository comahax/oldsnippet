package com.sunrise.boss.ui.cms.way;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.cms.bchcontact.persistent.BchcontactVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountListVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountVO;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.cms.bchcontact.BchcontactDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.wayaccount.WayaccountDelegate;
import com.sunrise.boss.delegate.cms.waycompact.WaycompactDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

/**
 * 物流商检查check
 * 
 * @author zhaowen
 * 
 */
public class BatchLOGISWayCheck extends BaseCheckFormat {

	private WayDelegate delegate;

	private BchcontactDelegate bchdelegate;

	private WaycompactDelegate comdelegate;

	private WayaccountDelegate accdelegate;

	public BatchLOGISWayCheck() {
		super();
		try {
			delegate = new WayDelegate();
			bchdelegate = new BchcontactDelegate();
			comdelegate = new WaycompactDelegate();
			accdelegate = new WayaccountDelegate();
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
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

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		for (int i = 0; i < items.length; i++) {
			items[i] = items[i] == null ? "" : items[i].trim();
		}
		// 检查列数
		if (items.length != 30) {
			throw new Exception("上传数据列数不对,应为30列,请查看说明帮助!");
		}
		WayVO wayVO = new WayVO();
		BchcontactVO bchcontactVO = new BchcontactVO();
		WaycompactVO waycompactVO = new WaycompactVO();
		WayaccountVO wayaccountVO = new WayaccountVO();
		// 渠道编码0
		String regex="^[a-zA-Z][a-zA-z0-9-]{0,18}$";
		if (StringUtils.isBlank(items[0]) || !items[0].matches(regex)) {
			throw new Exception("渠道编码格式不正确或长度出错，正确范围为1~18");
		}
		wayVO.setWayid(items[0]);
		bchcontactVO.setWayid(items[0]);
		waycompactVO.setWayid(items[0]);
		wayaccountVO.setWayid(items[0]);

		wayVO = delegate.doFindByPk(wayVO.getWayid(), user);

		if (wayVO == null) {
			// 渠道名称1
			// 渠道名称1
			if (StringUtils.isEmpty(items[1])
					|| items[1].getBytes().length >256) {
				throw new Exception("渠道名称不能为空且长度不能大于256");
			}

			// 上级渠道编码2
			if (!(items[2].getBytes().length>18 || "".equals(items[2])|| (items[2].indexOf("-") != -1))) {
				throw new Exception("上级渠道编码格式出错，正确长度范围为1~18");
			}

			// 合作方3
			if (!items[3].matches("\\d{0,2}")) {
				throw new Exception("合作方出错，正确为0-2位数字");
			}

			// 地市公司4
			if (items[4].getBytes().length > 14) {
				throw new Exception("地市公司长度不能大于14");
			}

			// 分公司5
			if (items[5].getBytes().length > 14) {
				throw new Exception("分公司长度不能大于14");
			}

			// 服务销售中心6
			if (items[6].getBytes().length > 14) {
				throw new Exception("服务销售中心长度不能大于14");
			}

			// 微区域7
			if (items[7].getBytes().length > 14) {
				throw new Exception("微区域长度不能大于14");
			}

			// 行政区划8
			if (items[8].getBytes().length > 18) {
				throw new Exception("行政区划长度不能大于18");
			}

			// 经度值11
			if (!StringUtils.isEmpty(items[9])) {
				int i = items[9].indexOf(".");
				String flatitude = items[9].substring(0, i);
				String blatitude = items[9].substring(i + 1);
				if (!items[9].matches("[\\d.\\d]{1,10}")
						|| flatitude.length() != 3
						|| Double.valueOf(items[9]).doubleValue() <= 100
						|| Double.valueOf(items[9]).doubleValue() >= 130) {
					throw new Exception(
							"经度格式或者值范围不对，必须为100到130之间，且整数为3位，小数为6位！");
				}
			} else {
				throw new Exception("经度格式或者值范围不对，必须为100到130之间，且整数为3位，小数为6位！");
			}

			// 纬度值12
			if (!StringUtils.isEmpty(items[10])) {
				int i = items[10].indexOf(".");
				String flongtitude = items[10].substring(0, i);
				String blongtitude = items[10].substring(i + 1);
				if (!items[10].matches("[\\d.\\d]{1,9}")
						|| flongtitude.length() != 2
						|| blongtitude.length() != 6
						|| Double.valueOf(items[10]).doubleValue() <= 18
						|| Double.valueOf(items[10]).doubleValue() >= 26) {
					throw new Exception("纬度格式或者值范围不对，必须为18到26之间，且整数为2位，小数为6位！");
				}
			} else {
				throw new Exception("纬度格式或者值范围不对，必须为18到26之间，且整数为2位，小数为6位！");
			}

			// 详细地址9
			if (items[11].getBytes().length > 128) {
				throw new Exception("详细地址长度不能大于128");
			}
		} else {
			// 渠道名称1
			if (!StringUtils.isEmpty(items[1])
					&& items[1].getBytes().length > 256) {
				throw new Exception("渠道名称不能为空且长度不能大于256");
			}

			// 上级渠道编码2
			if (!items[2].matches("\\w{0,18}")) {
				throw new Exception("渠道编码长度出错，正确范围为1~18");
			}

			// 合作方3
			if (!items[3].matches("\\d{0,2}")) {
				throw new Exception("合作方出错，正确为0-2位数字");
			}

			// 地市公司4
			if (items[4].getBytes().length > 14) {
				throw new Exception("地市公司长度不能大于14");
			}

			// 分公司5
			if (items[5].getBytes().length > 14) {
				throw new Exception("分公司长度不能大于14");
			}

			// 服务销售中心6
			if (items[6].getBytes().length > 14) {
				throw new Exception("服务销售中心长度不能大于14");
			}

			// 微区域7
			if (items[7].getBytes().length > 14) {
				throw new Exception("微区域长度不能大于14");
			}

			// 行政区划8
			if (items[8].getBytes().length > 18) {
				throw new Exception("行政区划长度不能大于18");
			}

			// 经度值11
			if (!StringUtils.isEmpty(items[9])) {
				int i = items[9].indexOf(".");
				String flatitude = items[9].substring(0, i);
				String blatitude = items[9].substring(i + 1);
				if (!items[9].matches("[\\d.\\d]{1,10}")
						|| flatitude.length() != 3
						|| Double.valueOf(items[9]).doubleValue() <= 100
						|| Double.valueOf(items[9]).doubleValue() >= 130) {
					throw new Exception(
							"经度格式或者值范围不对，必须为100到130之间，且整数为3位，小数为6位！");
				}
			}

			// 纬度值12
			if (!StringUtils.isEmpty(items[10])) {
				int i = items[10].indexOf(".");
				String flongtitude = items[10].substring(0, i);
				String blongtitude = items[10].substring(i + 1);
				if (!items[10].matches("[\\d.\\d]{1,9}")
						|| flongtitude.length() != 2
						|| blongtitude.length() != 6
						|| Double.valueOf(items[10]).doubleValue() <= 18
						|| Double.valueOf(items[10]).doubleValue() >= 26) {
					throw new Exception("纬度格式或者值范围不对，必须为18到26之间，且整数为2位，小数为6位！");
				}
			}

			// 详细地址9
			if (items[11].getBytes().length > 128) {
				throw new Exception("详细地址长度不能大于128");
			}
		}

		// 负责人姓名12-------------------------------------------
		bchcontactVO = bchdelegate.doFindByPk(bchcontactVO.getWayid(), user);
		if (bchcontactVO == null) {
			if (!StringUtils.isEmpty(items[12])
					&& items[12].getBytes().length > 64) {
				throw new Exception("负责人姓名长度不能为空且不能大于64");
			}

			// 负责人联系电话13
			if (!StringUtils.isEmpty(items[13])
					&& items[13].getBytes().length > 20) {
				throw new Exception("负责人联系电话格式不对");
			}

			// 负责人电子邮箱14
			if (!StringUtils.isEmpty(items[14])
					&& !items[14]
							.matches("[_a-zA-Z\\d\\-\\.]+@[_a-zA-Z\\d\\-]+(\\.[_a-zA-Z\\d\\-]+)+")) {
				throw new Exception("负责人电子邮箱格式不对");
			}

			// 业务联系人姓名13
			if (!StringUtils.isEmpty(items[15])
					&& items[15].getBytes().length > 64) {
				throw new Exception("业务联系人姓名不能为空且长度不能大于64");
			}

			// 业务联系人联系电话16
			if (!StringUtils.isEmpty(items[16])
					&& items[16].getBytes().length > 20) {
				throw new Exception("业务人联系电话格式不对");
			}

			// 业务联系人电子邮箱17
			if (!StringUtils.isEmpty(items[17])
					&& !items[17]
							.matches("[_a-zA-Z\\d\\-\\.]+@[_a-zA-Z\\d\\-]+(\\.[_a-zA-Z\\d\\-]+)+")) {
				throw new Exception("业务联系人电子邮箱格式不对");
			}
		}
		// 合同编码18---------------------------------------------------------------------
		waycompactVO = comdelegate.doFindByPk(waycompactVO.getWayid(), user);
		if (waycompactVO == null) {
			if (!items[18].matches("\\w{1,17}")) {
				throw new Exception("合同编码长度有错,正确范围1~17");
			}

			// 合同名称19
			if (StringUtils.isEmpty(items[19])
					|| items[19].getBytes().length > 255) {
				throw new Exception("合同名称不能为空且长度不能大于255");
			}

			// 签署合同时间20
			Date d1 = null;
			try {
				d1 = format.parse(items[20]);
			} catch (Exception e) {
				throw new Exception("签署合同时间格式不对，正确格式为[yyyy-MM-dd]");
			}

			// 合同到期日21
			Date d2 = null;
			try {
				d2 = format.parse(items[21]);
			} catch (Exception e) {
				throw new Exception("合同到期日格式不对，正确格式为[yyyy-MM-dd]");
			}

			// 判断日期先后
			if (d2.before(d1)) {
				throw new Exception("合同到期日格早于签署合同时间，发生错误");
			}

			// 法人代表20
			if (!StringUtils.isEmpty(items[22])
					&& items[22].getBytes().length > 64) {
				throw new Exception("法人代表长度不能大于64");
			}

			// 营业执照编号23
			if (StringUtils.isEmpty(items[23])
					|| items[23].getBytes().length > 64) {
				throw new Exception("营业执照编号长度不能大于64或者为空");
			}

			// 经营区域类型编码24
			if (!items[24].matches("\\d{0,2}")) {
				throw new Exception("经营区域类型，正确为0-2位数字");
			} else {
				checkJYQY(items[24], user);
			}

			// 经营范围25
			if (!items[25].matches("\\d{0,2}")) {
				throw new Exception("经营范围，正确为0-2位数字");
			}
		} else {
			if (!items[18].matches("\\w{0,17}")) {
				throw new Exception("合同编码长度有错,正确范围1~17");
			}

			// 合同名称19
			if (!StringUtils.isEmpty(items[19])
					&& items[19].getBytes().length > 255) {
				throw new Exception("合同名称不能为空且长度不能大于255");
			}

			// 签署合同时间20
			Date d1 = null;
			if (!StringUtils.isEmpty(items[20])) {
				try {
					d1 = format.parse(items[20]);
				} catch (Exception e) {
					throw new Exception("签署合同时间格式不对，正确格式为[yyyy-MM-dd]");
				}
			}

			// 合同到期日21
			Date d2 = null;
			if (!StringUtils.isEmpty(items[21])) {

				try {
					d2 = format.parse(items[21]);
				} catch (Exception e) {
					throw new Exception("合同到期日格式不对，正确格式为[yyyy-MM-dd]");
				}
			}

			// 判断日期先后
			if (!StringUtils.isEmpty(items[22])) {
				if (d2.before(d1)) {
					throw new Exception("合同到期日格早于签署合同时间，发生错误");
				}
			}
			// 法人代表20
			if (!StringUtils.isEmpty(items[22])
					&& items[22].getBytes().length > 64) {
				throw new Exception("法人代表长度不能大于64");
			}

			// 营业执照编号23
			if (!StringUtils.isEmpty(items[23])
					&& items[23].getBytes().length > 64) {
				throw new Exception("营业执照编号长度不能大于64或者为空");
			}

			// 经营区域类型编码24
			if (!items[24].matches("\\d{0,2}")) {
				throw new Exception("经营区域类型，正确为0-2位数字");
			} else {
				checkJYQY(items[24], user);
			}

			// 经营范围25
			if (!items[25].matches("\\d{0,2}")) {
				throw new Exception("经营范围，正确为0-2位数字");
			}
		}

		// 帐户标识26------------------------------------------------------
		WayaccountListVO acclistvo = new WayaccountListVO();
		acclistvo.set_ne_accid(new Integer(1));
		acclistvo.set_se_wayid(items[0]);
		DataPackage accdp = (DataPackage) accdelegate.doQuery(acclistvo, user);
		List acclist = (List) accdp.getDatas();
		if (acclist.size() == 0) {
			// 银行帐号28
			if (StringUtils.isEmpty(items[26])
					|| items[26].getBytes().length > 50) {
				throw new Exception("银行帐号长度不能大于50");
			}
			// 开户银行27
			if (StringUtils.isEmpty(items[27])
					|| items[27].getBytes().length > 128) {
				throw new Exception("开户银行不为能空且长度不能大于128");
			}
			// 开户账号名称29
			if (items[28] == null || "".equals(items[28].trim())) {
				throw new Exception("开户账号名称不能为空");
			}
			// 开户账号名称29
			if (StringUtils.isEmpty(items[28])
					|| items[28].getBytes().length > 50) {
				throw new Exception("开户账号名称长度不能大于50");
			}

			// 开户人身份证号码30
			if (items[29].getBytes().length > 32) {
				throw new Exception("开户人身份证号码长度不能大于32");
			}
		} else {
			// 银行帐号28
			if (!StringUtils.isEmpty(items[26])
					&& items[26].getBytes().length > 50) {
				throw new Exception("银行帐号长度不能大于50");
			}
			// 开户银行27
			if (!StringUtils.isEmpty(items[27])
					&& items[27].getBytes().length > 128) {
				throw new Exception("开户银行不为能空且长度不能大于128");
			}
			// 开户账号名称29
			if (!StringUtils.isEmpty(items[28])
					&& items[28].getBytes().length > 50) {
				throw new Exception("开户账号名称长度不能大于50");
			}

			// 开户人身份证号码30
			if (items[29].getBytes().length > 32) {
				throw new Exception("开户人身份证号码长度不能大于32");
			}
		}

	}

	// 检查经营区域类型编码
	public void checkJYQY(String item, User user) throws Exception {
		if ("".equals(item)) {
			return;
		}
		DictitemDelegate delegate = new DictitemDelegate();
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_groupid("CH_ORGTYPE");
		listVO.set_se_dictid(item);
		if (delegate.doQuery(listVO, user).getRowCount() <= 0) {
			throw new Exception("固定参数[区域类型编码]的值不正确");
		}
	}

	// test
	public static void main(String[] args) throws Exception {
		String string = "18.123456";
		int i = string.indexOf(".");
		String flongtitude = string.substring(0, i);
		String blongtitude = string.substring(i + 1);
		if (!string.matches("[\\d.\\d]{1,9}") || flongtitude.length() != 2
				|| blongtitude.length() != 6
				|| Integer.valueOf(flongtitude).intValue() <= 18
				|| Integer.valueOf(flongtitude).intValue() >= 26) {
			throw new Exception("经度格式或者值范围不对，必须为100到130之间，且整数为3位，小数为6位！");
		}
	}
}