package com.sunrise.boss.ui.cms.way;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.cms.adimarea.persistent.AdimareaVO;
import com.sunrise.boss.business.cms.bchcontact.persistent.BchcontactVO;
import com.sunrise.boss.business.cms.common.AuditUtils;
import com.sunrise.boss.business.cms.distribute.cooperator.persistent.CooperatorVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountListVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountVO;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.cms.adimarea.AdimareaDelegate;
import com.sunrise.boss.delegate.cms.bchcontact.BchcontactDelegate;
import com.sunrise.boss.delegate.cms.distribute.cooperator.CooperatorDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.wayaccount.WayaccountDelegate;
import com.sunrise.boss.delegate.cms.waycompact.WaycompactDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

/**
 * 合作商/经销商 CHECK
 * 
 * @author zhaowen
 * 
 */
public class BatchSTRTWayCheck extends BaseCheckFormat {

	private WayDelegate delegate;

	private BchcontactDelegate bchdelegate;

	private WaycompactDelegate comdelegate;

	private WayaccountDelegate accdelegate;

	private CooperatorDelegate coopdelegate;

	public BatchSTRTWayCheck() {
		super();
		try {
			delegate = new WayDelegate();
			bchdelegate = new BchcontactDelegate();
			comdelegate = new WaycompactDelegate();
			accdelegate = new WayaccountDelegate();
			coopdelegate = new CooperatorDelegate();
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
		for(int i=0;i<items.length;i++)
		{
			items[i]=items[i].trim();
		}
		// 检查列数
		if (items.length != 49) {
			throw new Exception("上传数据列数不对,应为49列,请查看说明帮助!");
		}
		WayVO wayVO = new WayVO();
		BchcontactVO bchcontactVO = new BchcontactVO();
		WaycompactVO waycompactVO = new WaycompactVO();
		WayaccountVO wayaccountVO = new WayaccountVO();
		CooperatorVO cooperatorvo = new CooperatorVO();// 合作商

		// 渠道编码0
		if (items[0].getBytes("GBK").length > 18 || "".equals(items[0])) {
			throw new Exception("渠道编码格式出错，正确范围为1~18");
		}else
		{
			if(!AuditUtils.doCheckWayidStyle(items[0]))
			{
				throw new Exception("渠道编码格式不正确：应为字母开头，允许字母数字和字符-");
			}
		}

		wayVO.setWayid(items[0]);
		bchcontactVO.setWayid(items[0]);
		waycompactVO.setWayid(items[0]);
		wayaccountVO.setWayid(items[0]);
		cooperatorvo.setCooperauid(items[0]);

		wayVO = delegate.doFindByPk(wayVO.getWayid(), user);
		if (wayVO == null) {
			// 渠道名称1
			if (StringUtils.isBlank(items[1])
					|| items[1].getBytes("GBK").length > 256) {
				throw new Exception("渠道名称不能为空且长度不能大于256");
			}

			// 上级渠道编码2
			if (items[2].getBytes("GBK").length>18 ||StringUtils.isBlank(items[2])) {
				throw new Exception("上级渠道编码格式出错，正确范围为1~18");
			}

			// 合作方3
			if (!items[3].matches("\\d{0,2}")) {
				throw new Exception("合作方出错，正确为0-2位数字");
			}

			// 地市公司4
			if (items[4].getBytes("GBK").length > 14) {
				throw new Exception("地市公司长度不能大于14");
			}

			// 分公司5
			if (items[5].getBytes("GBK").length > 14) {
				throw new Exception("分公司长度不能大于14");
			}

			// 服务销售中心6
			if (items[6].getBytes("GBK").length > 14) {
				throw new Exception("服务销售中心长度不能大于14");
			}

			// 微区域7
			if (items[7].getBytes("GBK").length > 14) {
				throw new Exception("微区域长度不能大于14");
			}
			// 扣税方式
			if (!items[8].matches("\\d{0,2}")) {
				throw new Exception("扣税方式出错，正确为0-2位数字");
			} else {
				// 检查扣税方式
				checkKSFS(items[8], user);
			}
			// 合作层级
			if (!items[9].matches("\\d{0,2}")) {
				throw new Exception("合作层级出错，正确为0-2位数字");
			}

			// 行政区划10
			if (items[10].getBytes("GBK").length > 18) {
				throw new Exception("行政区划长度不能大于18");
			}

			// 经度值11
			if (!StringUtils.isBlank(items[11])) {
				int i = items[11].indexOf(".");
				String flatitude = items[11].substring(0, i);
				String blatitude = items[11].substring(i + 1);
				if (!items[11].matches("[\\d.\\d]{1,10}")
						|| flatitude.getBytes("GBK").length != 3 || blatitude.getBytes("GBK").length != 6
						|| Double.valueOf(items[11]).doubleValue() <= 100
						|| Double.valueOf(items[11]).doubleValue() >= 130) {
					throw new Exception(
							"经度格式或者值范围不对，必须为100到130之间，且整数为3位，小数为6位！");
				}
			} else {
				throw new Exception("经度格式或者值范围不对，必须为100到130之间，且整数为3位，小数为6位！");
			}

			// 纬度值12
			if (!StringUtils.isBlank(items[12])) {
				int i = items[12].indexOf(".");
				String flongtitude = items[12].substring(0, i);
				String blongtitude = items[12].substring(i + 1);
				if (!items[12].matches("[\\d.\\d]{1,9}")
						|| flongtitude.getBytes("GBK").length != 2
						|| blongtitude.getBytes("GBK").length != 6
						|| Double.valueOf(items[12]).doubleValue() <= 18
						|| Double.valueOf(items[12]).doubleValue() >= 26) {
					throw new Exception("纬度格式或者值范围不对，必须为18到26之间，且整数为2位，小数为6位！");
				}
			} else {
				throw new Exception("纬度格式或者值范围不对，必须为18到26之间，且整数为2位，小数为6位！");
			}

			// 详细地址13
			if (items[13].getBytes("GBK").length > 128) {
				throw new Exception("详细地址长度不能大于128");
			}
		} else {
			// 渠道名称1
			if (!StringUtils.isBlank(items[1])
					&& items[1].getBytes("GBK").length > 256) {
				throw new Exception("渠道名称不能为空且长度不能大于256");
			}

			// 上级渠道编码2
			if (items[2].getBytes("GBK").length>18) {
				throw new Exception("上级渠道编码长度出错，正确范围为1~18");
			}

			// 合作方3
			if (!items[3].matches("\\d{0,2}")) {
				throw new Exception("合作方出错，正确为0-2位数字");
			}

			// 地市公司4
			if (items[4].getBytes("GBK").length > 14) {
				throw new Exception("地市公司长度不能大于14");
			}

			// 分公司5
			if (items[5].getBytes("GBK").length > 14) {
				throw new Exception("分公司长度不能大于14");
			}

			// 服务销售中心6
			if (items[6].getBytes("GBK").length > 14) {
				throw new Exception("服务销售中心长度不能大于14");
			}

			// 微区域7
			if (items[7].getBytes("GBK").length > 14) {
				throw new Exception("微区域长度不能大于14");
			}
			// 扣税方式
			if (!items[8].matches("\\d{0,2}")) {
				throw new Exception("扣税方式出错，正确为0-2位数字");
			} else {
				checkKSFS(items[8], user);
			}
			// 合作层级
			if (!items[9].matches("\\d{0,2}")) {
				throw new Exception("合作层级出错，正确为0-2位数字");
			}

			// 行政区划10
			if (items[10].getBytes("GBK").length > 18) {
				throw new Exception("行政区划长度不能大于18");
			}

			// 经度值11
			if (!StringUtils.isBlank(items[11])) {
				int i = items[11].indexOf(".");
				String flatitude = items[11].substring(0, i);
				String blatitude = items[11].substring(i + 1);
				if (!items[11].matches("[\\d.\\d]{1,10}")
						|| flatitude.getBytes("GBK").length != 3
						|| Double.valueOf(items[11]).doubleValue() <= 100
						|| Double.valueOf(items[11]).doubleValue() >= 130) {
					throw new Exception(
							"经度格式或者值范围不对，必须为100到130之间，且整数为3位，小数为6位！");
				}
			}

			// 纬度值12
			if (!StringUtils.isBlank(items[12])) {
				int i = items[12].indexOf(".");
				String flongtitude = items[12].substring(0, i);
				String blongtitude = items[12].substring(i + 1);
				if (!items[12].matches("[\\d.\\d]{1,9}")
						|| flongtitude.getBytes("GBK").length != 2
						|| blongtitude.getBytes("GBK").length != 6
						|| Double.valueOf(items[12]).doubleValue() <= 18
						|| Double.valueOf(items[12]).doubleValue() >= 26) {
					throw new Exception("纬度格式或者值范围不对，必须为18到26之间，且整数为2位，小数为6位！");
				}
			}

			// 详细地址13
			if (items[13].getBytes("GBK").length > 128) {
				throw new Exception("详细地址长度不能大于128");
			}
		}

		// 负责人姓名14-------------------------------------------
		bchcontactVO = bchdelegate.doFindByPk(bchcontactVO.getWayid(), user);
		if (bchcontactVO == null) {
			if (StringUtils.isBlank(items[14])
					|| items[14].getBytes("GBK").length > 64) {
				throw new Exception("负责人姓名长度不能为空且不能大于64");
			}

			// 负责人联系电话15
			if (StringUtils.isBlank(items[15])
					|| items[15].getBytes("GBK").length > 20) {
				throw new Exception("负责人联系电话格式不对");
			}

			// 负责人电子邮箱16
			if (!StringUtils.isBlank(items[16])
					&& !items[16]
							.matches("[_a-zA-Z\\d\\-\\.]+@[_a-zA-Z\\d\\-]+(\\.[_a-zA-Z\\d\\-]+)+")) {
				throw new Exception("负责人电子邮箱格式不对");
			}

			// 业务联系人姓名17
			if (StringUtils.isBlank(items[17])
					|| items[17].getBytes("GBK").length > 64) {
				throw new Exception("业务联系人姓名不能为空且长度不能大于64");
			}

			// 业务联系人联系电话18
			if (StringUtils.isBlank(items[18])
					|| items[18].getBytes("GBK").length > 20) {
				throw new Exception("业务人联系电话格式不对");
			}

			// 业务联系人电子邮箱19
			if (!StringUtils.isBlank(items[19])
					&& !items[19]
							.matches("[_a-zA-Z\\d\\-\\.]+@[_a-zA-Z\\d\\-]+(\\.[_a-zA-Z\\d\\-]+)+")) {
				throw new Exception("业务联系人电子邮箱格式不对");
			}
			// 合作单位
		} else {
			if (!StringUtils.isBlank(items[14])
					&& items[14].getBytes("GBK").length > 64) {
				throw new Exception("负责人姓名长度不能为空且不能大于64");
			}

			// 负责人联系电话15
			if (!StringUtils.isBlank(items[15])
					&& items[15].getBytes("GBK").length > 20) {
				throw new Exception("负责人联系电话格式不对");
			}

			// 负责人电子邮箱16
			if (!StringUtils.isBlank(items[16])
					&& !items[16]
							.matches("[_a-zA-Z\\d\\-\\.]+@[_a-zA-Z\\d\\-]+(\\.[_a-zA-Z\\d\\-]+)+")) {
				throw new Exception("负责人电子邮箱格式不对");
			}

			// 业务联系人姓名17
			if (!StringUtils.isBlank(items[17])
					&& items[17].getBytes("GBK").length > 64) {
				throw new Exception("业务联系人姓名不能为空且长度不能大于64");
			}

			// 业务联系人联系电话18
			if (!StringUtils.isBlank(items[18])
					&& items[18].getBytes("GBK").length > 20) {
				throw new Exception("业务人联系电话格式不对");
			}

			// 业务联系人电子邮箱19
			if (!StringUtils.isBlank(items[19])
					&& !items[19]
							.matches("[_a-zA-Z\\d\\-\\.]+@[_a-zA-Z\\d\\-]+(\\.[_a-zA-Z\\d\\-]+)+")) {
				throw new Exception("业务联系人电子邮箱格式不对");
			}

		}

		// 合同编码20---------------------------------------------------------------------
		waycompactVO = comdelegate.doFindByPk(waycompactVO.getWayid(), user);
		if (waycompactVO == null) {
			if (!items[20].matches("\\w{1,17}")) {
				throw new Exception("合同编码长度有错,正确范围1~17");
			}

			// 合同名称21
			if (StringUtils.isBlank(items[21])
					|| items[21].getBytes("GBK").length > 255) {
				throw new Exception("合同名称不能为空且长度不能大于255");
			}

			// 签署合同时间22
			Date d1 = null;
			try {
				d1 = format.parse(items[22]);
			} catch (Exception e) {
				throw new Exception("签署合同时间格式不对，正确格式为[yyyy-MM-dd]");
			}

			// 合同到期日21
			Date d2 = null;
			try {
				d2 = format.parse(items[23]);
			} catch (Exception e) {
				throw new Exception("合同到期日格式不对，正确格式为[yyyy-MM-dd]");
			}

			// 判断日期先后
			if (d2.before(d1)) {
				throw new Exception("合同到期日格早于签署合同时间，发生错误");
			}

			// 法人代表24
			if (!StringUtils.isBlank(items[24])
					&& items[24].getBytes("GBK").length > 64) {
				throw new Exception("法人代表长度不能大于64");
			}

			// 营业执照编号25
			if (StringUtils.isBlank(items[25])
					|| items[25].getBytes("GBK").length > 64) {
				throw new Exception("营业执照编号不能为空且长度不能大于64");
			}

			// 经营区域类型编码26
			if (!items[26].matches("\\d{0,2}")) {
				throw new Exception("经营区域类型，正确为0-2位数字");
			} else {
				// 检查经营区域类型编码
				checkJYQY(items[26], user);
			}

			// 经营范围27
			if (!items[27].matches("\\d{0,2}")) {
				throw new Exception("经营范围，正确为0-2位数字");
			}
		} else {
			if (!StringUtils.isBlank(items[20])
					&& !items[20].matches("\\w{0,17}")) {
				throw new Exception("合同编码长度有错,正确范围1~17");
			}

			// 合同名称21
			if (!StringUtils.isBlank(items[21])
					&& items[21].getBytes("GBK").length > 255) {
				throw new Exception("合同名称不能为空且长度不能大于255");
			}

			// 签署合同时间22
			Date d1 = null;
			if (!StringUtils.isBlank(items[22])) {
				try {
					d1 = format.parse(items[22]);
				} catch (Exception e) {
					throw new Exception("签署合同时间格式不对，正确格式为[yyyy-MM-dd]");
				}
			}

			// 合同到期日21
			Date d2 = null;
			if (!StringUtils.isBlank(items[23])) {
				try {
					d2 = format.parse(items[23]);
				} catch (Exception e) {
					throw new Exception("合同到期日格式不对，正确格式为[yyyy-MM-dd]");
				}
			}

			// 法人代表24
			if (!StringUtils.isBlank(items[24])
					&& items[24].getBytes("GBK").length > 64) {
				throw new Exception("法人代表长度不能大于64");
			}

			// 营业执照编号25
			if (!StringUtils.isBlank(items[25])
					&& items[25].getBytes("GBK").length > 64) {
				throw new Exception("营业执照编号不能为空且长度不能大于64");
			}

			// 经营区域类型编码26
			if (!items[26].matches("\\d{0,2}")) {
				throw new Exception("经营区域类型，正确为0-2位数字");
			} else {
				// 检查经营区域类型编码的值
				checkJYQY(items[26], user);
			}

			// 经营范围27
			if (!items[27].matches("\\d{0,2}")) {
				throw new Exception("经营范围，正确为0-2位数字");
			}
		}
		// 帐户标识28------------------------------------------------------
		WayaccountListVO acclistvo = new WayaccountListVO();
		acclistvo.set_ne_accid(new Integer(1));
		acclistvo.set_se_wayid(items[0]);
		DataPackage accdp = (DataPackage) accdelegate.doQuery(acclistvo, user);
		List acclist = (List) accdp.getDatas();
		if (acclist.size() == 0) {

			// 银行帐号28
			if (StringUtils.isBlank(items[28])
					|| items[28].getBytes("GBK").length > 50) {
				throw new Exception("银行帐号长度不能大于50");
			}
			// 开户银行29
			if (StringUtils.isBlank(items[29])
					|| items[29].getBytes("GBK").length > 128) {
				throw new Exception("开户银行不为能空且长度不能大于128");
			}
			// 开户账号名称(必填)30
			if (items[30] == null || "".equals(items[30])) {
				throw new Exception("开户账号名称不能为空!");
			}

			// 开户账号名称30
			if (items[30].getBytes("GBK").length > 50) {
				throw new Exception("开户账号名称长度不能大于50");
			}

			// 开户人身份证号码31
			if (items[31].getBytes("GBK").length > 32) {
				throw new Exception("开户人身份证号码长度不能大于32");
			}

			if (!StringUtils.isBlank(items[32])
					&& items[32].getBytes("GBK").length > 128) {
				throw new Exception("送货地址长度不能超过128");
			}

			// 营业执照有效期
			if (items[36] != null && !"".equals(items[36])) {
				try {
					format.parse(items[36]);
				} catch (Exception e) {
					throw new Exception("营业执照有效期格式不对，正确格式为[yyyy-MM-dd]");
				}
			} else {
				throw new Exception("营业执照有效期格式不对，正确格式为[yyyy-MM-dd]");
			}
			// 开户日期
			if (items[38] != null && !"".equals(items[38])) {
				try {
					format.parse(items[38]);
				} catch (Exception e) {
					throw new Exception("开户日期格式不对，正确格式为[yyyy-MM-dd]");
				}
			} else {
				throw new Exception("开户日期格式不对，正确格式为[yyyy-MM-dd]");
			}

			if (items[39] != null && !"".equals(items[39])) {
				try {
					format.parse(items[39]);
				} catch (Exception e) {
					throw new Exception("生效时间格式不对，正确格式为[yyyy-MM-dd]");
				}
			} else {
				throw new Exception("生效时间格式不对，正确格式为[yyyy-MM-dd]");
			}

			if (items[40] != null && !"".equals(items[40])) {
				try {
					format.parse(items[40]);
				} catch (Exception e) {
					throw new Exception("失效时间格式不对，正确格式为[yyyy-MM-dd]");
				}
			} else {
				throw new Exception("失效时间格式不对，正确格式为[yyyy-MM-dd]");
			}
		} else {
			// 银行帐号28
			if (!StringUtils.isBlank(items[28])
					&& items[28].getBytes("GBK").length > 50) {
				throw new Exception("银行帐号长度不能大于50");
			}
			// 开户银行29
			if (!StringUtils.isBlank(items[29])
					&& items[29].getBytes("GBK").length > 128) {
				throw new Exception("开户银行不为能空且长度不能大于128");
			}
			// 开户账号名称(必填)30

			// 开户账号名称30
			if (!StringUtils.isBlank(items[30])
					&& items[30].getBytes("GBK").length > 50) {
				throw new Exception("开户账号名称长度不能大于50");
			}

			// 开户人身份证号码31
			if (items[31].getBytes("GBK").length > 32) {
				throw new Exception("开户人身份证号码长度不能大于32");
			}

			// 营业执照有效期
			if (items[36] != null && !"".equals(items[36])) {
				try {
					format.parse(items[36]);
				} catch (Exception e) {
					throw new Exception("营业执照有效期格式不对，正确格式为[yyyy-MM-dd]");
				}
			}
			// 开户日期
			if (items[38] != null && !"".equals(items[38])) {
				try {
					format.parse(items[38]);
				} catch (Exception e) {
					throw new Exception("开户日期格式不对，正确格式为[yyyy-MM-dd]");
				}
			}

			if (items[39] != null && !"".equals(items[39])) {
				try {
					format.parse(items[39]);
				} catch (Exception e) {
					throw new Exception("生效时间格式不对，正确格式为[yyyy-MM-dd]");
				}
			}
			if (items[40] != null && !"".equals(items[40])) {
				try {
					format.parse(items[40]);
				} catch (Exception e) {
					throw new Exception("失效时间格式不对，正确格式为[yyyy-MM-dd]");
				}
			}
		}

		if (!StringUtils.isBlank(items[33]) && items[33].getBytes("GBK").length > 32) {
			throw new Exception("收货联系人格式不对，长度不能大于32");
		}
		if (!StringUtils.isBlank(items[34]) && items[34].getBytes("GBK").length > 15) {
			throw new Exception("收货联系人号码格式不对，长度不能大于15");
		}
		if (!StringUtils.isBlank(items[35]) && items[35].getBytes("GBK").length > 20) {
			throw new Exception("收货人证件号码格式不对，长度不能大于20");
		}
		if (!StringUtils.isBlank(items[41]) && items[41].getBytes("GBK").length > 60) {
			throw new Exception("合作单位格式不对,长度不能超过60!");
		}
		if (!StringUtils.isBlank(items[42]) && !items[42].matches("\\d{0,3}")) {
			throw new Exception("合作商级别格式不对,必须是0-3位的数字!");
		}
		if (!StringUtils.isBlank(items[42])) {
			checkCoplevel(items[42], user);
		}
		if (!StringUtils.isBlank(items[43]) && items[43].getBytes("GBK").length > 30) {
			throw new Exception("工商号格式不对,长度不能超过30!");
		}
		if (!StringUtils.isBlank(items[44]) && !items[44].matches("\\d{0,3}")) {
			throw new Exception("证件类别格式不对,必须是0-3位的数字!");
		}
		if (!StringUtils.isBlank(items[44])) {
			checkCertitype(items[44], user);
		}
		if (!StringUtils.isBlank(items[45]) && items[45].getBytes("GBK").length > 30) {
			throw new Exception("证件编码格式不对,长度不能超过30!");
		}
		if (!StringUtils.isBlank(items[46]) && items[46].getBytes("GBK").length > 128) {
			throw new Exception("注册地址格式不对,长度不能超过128!");
		}
		if (!StringUtils.isBlank(items[47]) && !items[47].matches("\\d{0,14}")) {
			throw new Exception("注册资金格式不对,必须是0-14位的数字!");
		}
		if (!items[48].equals("0") && !items[48].equals("1")  ) {
			throw new Exception("渠道状态必须是0或1!");
		}
	}

	// 检查扣税方式
	public void checkKSFS(String item, User user) throws Exception {
		DictitemDelegate delegate = new DictitemDelegate();
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_groupid("CH_STTAXTYPE");
		listVO.set_se_dictid(item);
		if (delegate.doQuery(listVO, user).getRowCount() <= 0) {
			throw new Exception("固定参数[扣税方式]的值不正确");
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

	// 检查固定参数合作商级别
	public void checkCoplevel(String item, User user) throws Exception {
		DictitemDelegate delegate = new DictitemDelegate();
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_groupid("CH_COPLEVEL");
		listVO.set_se_dictid(item);
		if (delegate.doQuery(listVO, user).getRowCount() <= 0) {
			throw new Exception("固定参数[合作商级别]的值不正确");
		}
	}

	// 检查固定参数证件类型
	public void checkCertitype(String item, User user) throws Exception {
		DictitemDelegate delegate = new DictitemDelegate();
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_groupid("IB_CERTITYPE");
		listVO.set_se_dictid(item);
		if (delegate.doQuery(listVO, user).getRowCount() <= 0) {
			throw new Exception("固定参数[证件类型]的值不正确");
		}
	}

	// test
	public static void main(String[] args) throws Exception {
		// BatchSTRTWayCheck check = new BatchSTRTWayCheck();
		// String str =
		// "JFJMXXXXX|测试渠道|JFJM00000|1|JM|JM|||5|0|1|123.23.45.02|123.23.45.02|江门建设路101号|张三|020-31647847|abcd@abc.com|李四|0726-98564587|abc@xyz.com|45478|测试合同信息|1990-12-12|2006-01-02|王五|abcde12323|1|1|98546|中国银行|公司XX帐户|1234567897894587|广州大道368号|张三|13888888888|44052418203202235|2009-01-01|1000|2006-01-01";
		// try{
		// check.checkLine(str,0);
		// System.out.println("ok");
		// }catch(Exception e){
		// e.printStackTrace();
		// }
		// String str = "123";
		// System.out
		// .println(str.matches("\\d{0,3}"));
	}
}