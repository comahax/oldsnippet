package com.sunrise.boss.ui.cms.way;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.cms.common.AuditUtils;
import com.sunrise.boss.business.cms.custwaytype.persistent.CustwaytypeListVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.waytype.persistent.WaytypeListVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.cms.custwaytype.CustwaytypeDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.waytype.WaytypeDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class BatchWayCheck extends BaseCheckFormat {
	private static WayDelegate delegate;

	private String newFlag = "true";

	public BatchWayCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public WayDelegate getDelegate() throws Exception {
		if (delegate == null) {
			return new WayDelegate();
		} else {
			return delegate;
		}
	}

	private static final String item[] = { "渠道编码", "渠道名称", "上级渠道", "营业点标识",
			"是否共享", "渠道类别", "渠道子类别", "分公司自定义渠道类别管理", "城市级别", "渠道等级", "渠道MIS编码",
			"物业来源分类", "是否联网", "联网方式", "经营模式", "是否中心渠道", "星级", "排他性", "连锁总店编码",
			"签约状态", "营业人员数量", "管理人员数量", "终端数量", "纬度", "经度", "渠道状态", "渠道中间代码",
			"自营标志" };

	/*
	 * (non-Javadoc) 固定参数由公共模块检查
	 * 
	 * @see com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat#checkLine(java.lang.String,
	 *      int)
	 */
	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		if (null == line || "".equals(line)) {
			return;
		}
		String[] items = line.split("\\|");
		// 检查列数
		if (items.length != 28) {
			throw new Exception("上传数据列数:" + items.length + "不正确,应为28列,请查看说明帮助!");
		}

		// \渠道编码0
		this.ckString(items[0], item[0], 18, "notnull");
		if(StringUtils.isNotBlank(items[0]))
		{
			if(!AuditUtils.doCheckWayidStyle(items[0]))
			{
				throw new Exception("渠道编码格式不正确,应该只能以字母开头且只能包含字母,数字和-字符");
			}
		}
		WayVO vo = getDelegate().doFindByPk(items[0].trim(), user);
		if (vo == null) {
			newFlag = "true";
		} else {
			newFlag = "false";
		}

		// \渠道名称1
		this.ckString(items[1], item[1], 256, "no");
		// 上级渠道编码2
		this.ckString(items[2], item[2], 18, "no", newFlag);
		this.doCheckWayID(items[2].trim(), item[2], user);
		// 营业点标识3
		this.ckString(items[3], item[3], 10);
		// \是否共享4??
		this.ckString(items[4].trim(), item[4], 32, "no", newFlag);
		this.doCheckSystemParam("CH_DSTISKEYSTEP", items[4].trim(), user,
				item[4]);
		// \ 渠道类别5
		this.ckString(items[5], item[5], 4, "no", newFlag);
		if (StringUtils.isNotEmpty(items[5].trim())) {
			this.doCheckWayType(items[5].trim(), user, item[5]);
		}
		// 渠道子类别6
		this.ckString(items[6], item[6], 4);
		if (StringUtils.isNotEmpty(items[6].trim())) {
			if (StringUtils.isEmpty(items[5].trim())) {
				throw new Exception("渠道类别有值，渠道子类别才能有值");
			} else if (StringUtils.isNotEmpty(items[5].trim())) {
				this.doCheckSubWayType(items[6].trim(), items[5].trim(), user,
						item[6]);
			}
		}
		// 如果输入的渠道类别是社会渠道（AG），渠道子类别不允许是"特约代理点SAGT"，"指定专营店PSAL"，"连锁经营合作商DIS"
		// 设计修改成不允许新增实体渠道和自营渠道。
		if ( "ET".equals(items[5].trim())) {
			throw new Exception("此菜单不允许录入[自营]渠道信息,请到相关菜单录入!");
		}
		if("AG".equals(items[5].trim()))
		{
			if( !"TEMI".equals(items[6].trim()) && !"ITF".equals(items[6].trim()) && !"ECF".equals(items[6].trim()))
			{
				throw new BusinessException("","[社会网点，合作商]类别的渠道,请去专门的渠道菜单进行录入!");
			}
		}
		// // 实体渠道已经不允许"D4S","D5S","D6S"
		// if ("ET".equals(items[5].trim())) {
		// if ("D4S".equals(items[6].trim()) || "D5S".equals(items[6].trim())
		// || "D6S".equals(items[6].trim())) {
		// throw new Exception("实体渠道的\"D4S\",\"D5S\",\"D6S\"已经修改为\"G100\"");
		// }
		// }
		// 分公司自定义渠道类别管理7
		this.ckString(items[7], item[7], 4);
		this.checkCustomerWay(items[7].trim(), item[7], user);
		// \ 区域中心8
		// this.ckString(items[8], item[8], 14, "no", newFlag);
		// \ 市公司9
		// this.ckString(items[9], item[9], 14, "no", newFlag);
		// 县公司10
		// this.ckString(items[10], item[10], 14);
		// 城市级别8
		this.ckNumber(items[8], item[8], 3);
		this.doCheckSystemParam("CH_CITYLEVEL", items[8].trim(), user, item[8]);
		// 渠道级别12
		// this.ckNumber(items[12], item[12], 3);
		// 渠道等级13
		this.ckString(items[9], item[9], 4);
		this.doCheckSystemParam("CH_BCHLEVEL", items[9].trim(), user, item[9]);
		// 渠道MIS编码10
		this.ckString(items[10], item[10], 12);
		// 物业来源分类11
		this.ckNumber(items[11], item[11], 2);
		this
				.doCheckSystemParam("CH_PRTSOURCE", items[11].trim(), user,
						item[1]);
		// 是否联网12---------------------------------------------------------------------
		this.ckNumber(items[12], item[12], 2);
		this.doCheckSystemParam("CH_ISCONNECTED", items[12].trim(), user,
				item[12]);
		// 联网方式13
		this.ckNumber(items[13], item[13], 2);
		this.doCheckSystemParam("CH_CONNECTTYPE", items[13].trim(), user,
				item[13]);
		// 经营模式14
		this.ckNumber(items[14], item[14], 2);
		this.doCheckSystemParam("CH_RUNMODE", items[14].trim(), user, item[14]);
		// 是否中心渠道15
		this.ckNumber(items[15], item[15], 2);
		this.doCheckSystemParam("CH_ISCOREWAY", items[15].trim(), user,
				item[19]);
		// 星级16
		this.ckNumber(items[16], item[16], 2);
		this.doCheckSystemParam("CH_STARLEVEL", items[16].trim(), user,
				item[16]);
		// 排他性17
		this.ckNumber(items[17], item[17], 2);
		this.doCheckSystemParam("CH_PT", items[17].trim(), user, item[17]);
		// 连锁总店编码18
		this.ckString(items[18], item[18], 18);
		// 签约状态19
		this.ckNumber(items[19], item[19], 2);
		this.doCheckSystemParam("CH_SIGNSTATUS", items[19].trim(), user,
				item[19]);
		// 营业人员数量20------------------------------------------------------
		this.ckNumber(items[20], item[20], 4);
		// 管理人员数量21
		this.ckNumber(items[21], item[21], 4);
		// 终端数量22
		this.ckNumber(items[22], item[22], 4);
		// \ 纬度23
		String regex = "^\\d{2}.\\d{6}$";
		this.ckString(items[23], item[23], 15, "no", newFlag);
		if (!"".equals(items[23].trim()) && !items[23].trim().matches(regex)) {
			throw new Exception(item[23] + "值:" + items[23] + " 该值填写不正确,"
					+ item[23] + "必须是2位数字位，6小数位");
		} else if (!"".equals(items[23].trim())) {
			int latitude = Integer.parseInt(items[23].trim().substring(0, 2));
			if (latitude < 18 || latitude > 26) {
				throw new Exception(item[23] + "值必须在18到26之间");
			}
		}
		// \ 经度24
		this.ckString(items[24], item[24], 15, "no", newFlag);
		regex = "^\\d{3}.\\d{6}$";
		if (!"".equals(items[24].trim()) && !items[24].trim().matches(regex)) {
			throw new Exception(item[24] + "值:" + items[24] + "该值填写不正确,"
					+ item[24] + "必须是3位数字加6位小数位");
		} else if (!"".equals(items[24].trim())) {
			int latitude = Integer.parseInt(items[24].trim().substring(0, 3));
			if (latitude < 100 || latitude > 130) {
				throw new Exception(item[24] + "值必须在100到130之间");
			}
		}
		// \ 渠道状态25
		this.ckNumber(items[25], item[25], 3, "no", newFlag);
		this.doCheckSystemParam("CH_VALIDFLAG", items[25].trim(), user,
				item[25]);
		// 渠道中间代码26
		this.ckString(items[26], item[26], 20);
		// \ 自营标志27
		this.ckString(items[27], item[27], 4, "no", newFlag);
		this.doCheckSystemParam("CH_WAY_RUNTYPE", items[27].trim(), user,
				item[27]);
		this.newFlag = "true";
	}

	public static void main(String args[]) throws Exception {
		try {
			for (int i = 0; i < item.length; i++) {
				System.out.println(i + ":" + item[i] + "\t");
			}

		} catch (Exception w) {
			w.printStackTrace();
		}
	}

	private void ckString(String item, String msg, int length, String isnull)
			throws Exception {
		if ("NOTNULL".equalsIgnoreCase(isnull)
				|| "NO".startsWith(isnull.toUpperCase())) {
			if (StringUtils.isEmpty(item.trim())) {
				throw new Exception(msg + "不能为空");
			} else {
				ckString(item, msg, length);
			}
		}
	}

	private void ckString(String item, String msg, int length, String isnull,
			String newFlag) throws Exception {
		if ("true".equals(newFlag)) {
			this.ckString(item, msg, length, isnull);
		} else {
			this.ckString(item, msg, length);
		}
	}

	private void ckString(String item, String msg, int length) throws Exception {
		if (item.trim().getBytes("GBK").length > length) {
			throw new Exception(msg + ":" + item + " 该长度不能大于" + length + "位");
		}
	}

	private void ckNumber(String item, String msg, int length) throws Exception {
		String regex = "-?\\d{1," + length + "}";
		if (!"".equals(item.trim()) && !item.trim().matches(regex)) {
			throw new Exception(msg + ":" + item + " 该项必须为数字，且长度不能大于" + length
					+ "位");
		}
	}

	private void ckNumber(String item, String msg, int length, String isnull)
			throws Exception {
		if ("NOTNULL".equalsIgnoreCase(isnull)
				|| "NO".startsWith(isnull.toUpperCase())) {
			if (StringUtils.isEmpty(item.trim())) {
				throw new Exception(msg + "不能为空");
			} else {
				ckNumber(item, msg, length);
			}
		}
	}

	private void ckNumber(String item, String msg, int length, String isnull,
			String newFlag) throws Exception {
		if ("true".equals(newFlag)) {
			this.ckNumber(item, msg, length, isnull);
		} else {
			this.ckNumber(item, msg, length);
		}
	}

	private void doCheckSystemParam(String groupid, String dictid, User user,
			String msg) throws Exception {
		DictitemDelegate delegate = new DictitemDelegate();
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_groupid(groupid.trim());
		listVO.set_se_dictid(dictid.trim());
		if (delegate.doQuery(listVO, user).getRowCount() <= 0) {
			throw new Exception("填写的固定参数:" + msg + "的值:" + dictid + "不正确");
		}
	}

	private void doCheckWayType(String waytype, User user, String msg)
			throws Exception {
		WaytypeDelegate delegate = new WaytypeDelegate();
		WaytypeListVO listVO = new WaytypeListVO();
		listVO.set_se_waytypecode(waytype.trim());
		listVO.set_se_uppercode("-1");
		if (delegate.doQuery(listVO, user).getRowCount() <= 0) {
			throw new Exception("填写的 " + msg + " 的值:" + waytype + "不正确");
		}
	}

	// 检查上级渠道
	private void doCheckWayID(String wayid, String msg, User user)
			throws Exception {
		WayDelegate delegate = new WayDelegate();
		WayListVO listVO = new WayListVO();
		listVO.set_se_wayid(wayid);
		if (delegate.doQuery(listVO, user).getRowCount() <= 0) {
			throw new Exception("填写的 " + msg + " 的值:" + wayid + "不正确");
		}
	}

	private void doCheckSubWayType(String waytype, String uppperWaytype,
			User user, String msg) throws Exception {
		WaytypeDelegate delegate = new WaytypeDelegate();
		WaytypeListVO listVO = new WaytypeListVO();
		listVO.set_se_waytypecode(waytype.trim());
		listVO.set_se_uppercode(uppperWaytype.trim());
		if (delegate.doQuery(listVO, user).getRowCount() <= 0) {
			throw new Exception("填写的" + msg + "的值:" + waytype + "不正确,或者该渠道:"
					+ waytype + "不属于该上级渠道:" + uppperWaytype);
		}
	}

	private void checkCustomerWay(String code, String msg, User user)
			throws Exception {
		CustwaytypeDelegate delegate = new CustwaytypeDelegate();
		CustwaytypeListVO listVO = new CustwaytypeListVO();
		listVO.set_se_custwaytypecode(code.trim());
		if (delegate.doQuery(listVO, user).getRowCount() <= 0) {
			throw new Exception("填写的" + msg + "的值:" + code + "不正确");
		}

	}
}
