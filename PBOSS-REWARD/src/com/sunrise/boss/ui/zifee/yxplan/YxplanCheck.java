package com.sunrise.boss.ui.zifee.yxplan;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.zifee.yxplan.YxPlanDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class YxplanCheck extends BaseCheckFormat {

	public YxplanCheck() {
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
	public void checkLine(String line, int rowCount, boolean iscustom, User user)
			throws Exception {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (rowCount > 10000) {
			throw new Exception("文件行数不能超过10000行");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		String[] fields = StringUtils.splitPreserveAllTokens(line, "|");
		// 检查列数
		if (fields.length != 36 && !iscustom) {
			throw new Exception("上传数据列数不对,应为36列,请查看说明帮助!");
		}
		String startime="";
		// 对字段逐一进行检查
		for (int i = 0; i < fields.length; i++) {
			switch (i) {

			// 营销方案标识0
			case 0:
				
				if (!fields[i].trim().matches("[0-9]{14}")) {
					throw new Exception("[营销方案标识]出错，必须为14位数字: "+fields[i]);
				}
				String areacode=new YxPlanDelegate().getAreacode(new Long(StringUtils.trim(fields[0])), user);
				if(areacode!=null)
				{
				if (user.isProvinceUser()) {
						if (!"999".equals(areacode) && !"100".equals(areacode)) {
							throw new Exception("省级工号只能操作省级营销方案! 出错信息:"
									+ fields[0]);
						}
					} else if (!user.isProvinceUser()) {
						if (!areacode.equals(user.getCityid())) {
							throw new Exception("该登录用户只能操作本地市营销方案! 出错信息:"
									+ fields[0]);
						}
					}
				}
				break;
			// 营销方案名称1
			case 1:
				if (!iscustom) {
					if (fields[i].trim().length() < 1
							|| fields[i].trim().length() > 128) {
						throw new Exception("[营销方案名称]长度不符合要求，范围应该在(1~128)");
					}
				} else {
					if (!(fields[i] == null || "".equals(fields[i].trim()))) {
						if (fields[i].trim().length() < 1
								|| fields[i].trim().length() > 128) {
							throw new Exception("[营销方案名称]长度不符合要求，范围应该在(1~128)");
						}
					}
				}
				break;
			// 全省标识2
			case 2:
				if (!fields[i].trim().equals("")
						&& !fields[i]
								.matches("^([a-z|A-Z]{2})([01]{4})([012]{1})(20\\d{2}(0[0-9]{1}|1[012]{1})(0[0-9]{1}|[12]{1}\\d{1}|3[01]{1}))(\\d{3})(\\d{6})(\\d{2})$")) {
					throw new Exception("全省标识命名不符合要求，具体请参考帮助文件");
				}
				break;

			// 启动日期3
			case 3:
				if (!iscustom) {
					try {
						format.parse(fields[i].trim());
					} catch (Exception e) {
						throw new Exception(
								"[启动日期]格式不对，正确格式为[yyyy-MM-dd HH:mm:ss]");
					}
				} else {
					if (!(fields[i] == null || "".equals(fields[i].trim()))) {
						try {
							format.parse(fields[i].trim());
						} catch (Exception e) {
							throw new Exception(
									"[启动日期]格式不对，正确格式为[yyyy-MM-dd HH:mm:ss]");
						}
					}
				}
				startime=fields[i].trim();
				break;

			// 停用日期4
			case 4:
				if (!iscustom) {
					try {
						format.parse(fields[i].trim());
					} catch (Exception e) {
						throw new Exception(
								"[停用日期]格式不对，正确格式为[yyyy-MM-dd HH:mm:ss]");
					}

				} else {
					if (!(fields[i] == null || "".equals(fields[i].trim()))) {
						try {
							format.parse(fields[i].trim());
						} catch (Exception e) {
							throw new Exception(
									"[停用日期]格式不对，正确格式为[yyyy-MM-dd HH:mm:ss]");
						}
					}
				}
				if(StringUtils.isNotEmpty(startime) && StringUtils.isNotEmpty(fields[i])){
					if(format.parse(fields[i].trim()).getTime()<format.parse(startime).getTime()){
						throw new Exception("[停用日期]不能小于[启动日期]");
					}
				}
				break;

			// 区域标识5
			case 5:
				if (!iscustom) {
					if (fields[i].trim().length() > 32
							|| fields[i].trim().length() < 1) {
						throw new Exception("[区域标识]长度不对,范围应该在(1~32)");
					}
				} else {
					if (!(fields[i] == null || "".equals(fields[i].trim()))) {
						if (fields[i].trim().length() > 32
								|| fields[i].trim().length() < 1) {
							throw new Exception("[区域标识]长度不对,范围应该在(1~32)");
						}
					}
				}
				break;

			// // 最低消费额6
			// case 6:
			// if (!fields[i].trim().equals("")) {
			// try {
			// new Double(fields[i]);
			// } catch (Exception e) {
			// throw new Exception("[最低消费额]格式不对");
			// }
			// }
			// break;
			//
			// // 最低消费跨越周期7
			// case 7:
			// if (!fields[i].trim().equals("")
			// && !fields[i].trim().matches("[0-9\\-]+")) {
			// throw new Exception("[最低消费跨越周期]格式不对,应该为数字型");
			// }
			// break;

			// 是否需要捆绑套餐8
			case 8 - 2:
				if (!fields[i].trim().equals("") && !fields[i].trim().matches("[0-1]")) {
					throw new Exception("[是否需要捆绑套餐]格式不对,只能为数字0或1");
				}
				break;

			// 捆绑期9
			case 9 - 2:
				if (!fields[i].trim().equals("")
						&& !fields[i].trim().matches("[0-9\\-]+")) {
					throw new Exception("[捆绑期]格式不对,应该为数字型");
				}
				break;

			// 是否允许预约10 $PC_BOOKFLAG
			case 10 - 2:
				if (!fields[i].trim().equals("")
						&& !CheckUtil.getInstance().checkDictitem(
								"PC_BOOKFLAG", fields[i].trim(), user)) {
					throw new Exception("[是否允许预约]的值:" + fields[i] + "不正确,请重新输入");
				}
				break;

			// 是否预收月租11
			// case 11:if
			// (!fields[i].trim().equals("")&&!fields[i].trim().matches("[0-1]")){
			// result.setCode(77);
			// result.setInfo("[是否预收月租]格式不对,只能为数字0或1");
			// };break;

			// 可享用次数11
			case 11 - 2:
				if (!fields[i].trim().equals("")
						&& !fields[i].trim().matches("[0-9\\-]+")) {
					throw new Exception("[可享用次数]格式不对,只能为数字0或1");
				}
				break;

			// 最小优惠周期数12
			case 12 - 2:
				if (!fields[i].trim().equals("")
						&& !fields[i].trim().matches("[0-9\\-]+")) {
					throw new Exception("[最小优惠周期数]格式不对,应该为数字型");
				}
				break;

			// 优惠起算偏移量13
			case 13 - 2:
				if (!fields[i].trim().equals("")
						&& !fields[i].trim().matches("[0-9\\-]+")) {
					throw new Exception("[优惠起算偏移量]格式不对,应该为数字型");
				}
				break;

			// 起算时间单元14
			case 14 - 2:
				if (fields[i].trim().length() > 32) {
					throw new Exception("[起算时间单元]长度不对,范围应该在0~32");
				}
				break;

			// 生效时间规则15
			case 15 - 2:
				if (!fields[i].trim().equals("") && !fields[i].trim().matches("[0-1]")) {

					throw new Exception("[生效时间规则]格式不对,只能为数字0或1");
				}
				;
				break;

			// 营销方案分组标识16
			case 16 - 2:
				if (!fields[i].trim().equals("")
						&& !fields[i].trim().matches("[0-9\\-]+")) {
					throw new Exception("[营销方案分组标识]格式不对,应该为数字型");
				}
				break;

			// 是否备份17
			case 17 - 2:
				if (!fields[i].trim().equals("") && !fields[i].trim().matches("[0-1]")) {
					throw new Exception("[是否备份]格式不对,只能为数字0或1");
				}
				break;

			// 是否打印到受理单18
			case 18 - 2:
				if (!fields[i].trim().equals("") && !fields[i].trim().matches("[0-1]")) {
					throw new Exception("[是否打印到受理单]格式不对,只能为数字0或1");
				}
				break;

			// 是否算费优惠19
			case 19 - 2:
				if (!fields[i].trim().equals("") && !fields[i].trim().matches("[0-1]")) {
					throw new Exception("[是否算费优惠]格式不对,只能为数字0或1");
				}
				break;

			// 是否营业费优惠20
			case 20 - 2:
				if (!fields[i].trim().equals("") && !fields[i].trim().matches("[0-1]")) {
					throw new Exception("[是否营业费优惠]格式不对,只能为数字0或1");
				}
				break;

			// 停机状态是否收取月租费22
			// case 22:if
			// (!fields[i].trim().equals("")&&!fields[i].trim().matches("[0-1]")){
			// throw new Exception("[停机状态是否收取月租费]格式不对,只能为数字0或1");
			// };break;

			// 是否网外成员优惠21
			case 21 - 2:
				if (!fields[i].trim().equals("") && !fields[i].trim().matches("[0-1]")) {
					throw new Exception("[是否网外成员优惠]格式不对,只能为数字0或1");
				}
				break;

			// 来源22
			case 22 - 2:
				if (fields[i].trim().length() > 255) {
					throw new Exception("[来源]长度不对,范围应该在0~255");
				}
				break;

			// 营销类别23
			case 23 - 2:
				if (!fields[i].trim().equals("")
						&& !fields[i].trim().matches("[0-1]{1,2}")) {
					throw new Exception("[营销类别]格式不对，正确为数字0和1两个数字的两位数组合");
				}
				break;

			// 营销方案类别24
			case 24 - 2:
				if (fields[i].trim().length() > 32) {
					throw new Exception("[营销方案类别]长度不对,范围应该在0~32");
				}
				break;

			// 上传算费方案类别25
			case 25 - 2:
				if (!iscustom) {
					if ("".equals(fields[i].trim())) {
						throw new Exception("[上传算费方案类别]出错，不能为空");
					}
					if (!fields[i].trim().matches("[012345]")) {
						throw new Exception(
								"[上传算费方案类别]格式不对,应该为0、1、2、3、4、5中的一个数值");
					}
				} else {
					if (!(fields[i] == null || "".equals(fields[i].trim()))) {

						if (!fields[i].trim().matches("[012345]")) {
							throw new Exception(
									"[上传算费方案类别]格式不对,应该为0、1、2、3、4、5中的一个数值");
						}
					}
				}
				break;

			// 优惠范围27-1
			case 26 - 2:
				if (fields[i].trim().length() > 8) {
					throw new Exception("[优惠范围]长度不对,范围应该在0~8");
				}
				break;
			// 5月11日增加|套餐类型|月结扣费优先级|两个字段
			// 套餐类型28-1
			case 27 - 2:
				if (!iscustom) {
					if (fields[i].trim().length() > 32) {
						throw new Exception("[套餐类型]长度不对,范围应该在0~32");
					}
					if ("".equals(fields[i].trim())) {
						throw new Exception("[套餐类型]不能为空");
					}
				} else {
					if (!(fields[i] == null || "".equals(fields[i].trim()))) {
						if (fields[i].trim().length() > 32) {
							throw new Exception("[套餐类型]长度不对,范围应该在0~32");
						}
						if ("".equals(fields[i].trim())) {
							throw new Exception("[套餐类型]不能为空");
						}
					}
				}
				break;
			// 月结扣费优先级29-1
			case 28 - 2:
				if (!"".equals(fields[i].trim())
						&& !fields[i].trim().matches("[12]")) {
					throw new Exception("[月结扣费优先级]格式不对,应该为1或2");
				}
				break;
			// 固定费特殊标识30-1
			case 29 - 2:
				if (!iscustom) {
					if (fields[i].trim().length() < 9
							|| !fields[i].trim().matches("[0-1]{9}")
							|| fields[i].trim().length() > 32) {
						throw new Exception("[固定费特殊标识]长度不对,只能为9位0或1的数字");
					}
				} else {
					if (!(fields[i] == null || "".equals(fields[i].trim()))) {
						if (fields[i].trim().length() < 9
								|| !fields[i].trim().matches("[0-1]{9}")
								|| fields[i].trim().length() > 32) {
							throw new Exception("[固定费特殊标识]长度不对,只能为9位0或1的数字");
						}
					}
				}
				break;
			// 特殊方案标志31-1 (11-22by Jeirmy)
			case 30 - 2:
				if (fields[i].trim().length() > 32) {
					throw new Exception("[特殊方案标志]长度不对,范围应该在0~32");
				}
				checkFlag(fields[i].trim(), "PC_SPECIALPLAN", "特殊营销方案标志", user);
				break;
			// 新增用户状态检查&可办理用户状态
			// 是否用户状态检查
			case 31 - 2:
				if (!iscustom) {
					if (!("0".equals(fields[i].trim()) || "1".equals(fields[i]
							.trim()))) {
						throw new Exception("[是否用户状态检查]的值必须是0(是)或1(否)");
					}
				} else {
					if (!(fields[i] == null || "".equals(fields[i].trim()))) {
						if (!("0".equals(fields[i].trim()) || "1"
								.equals(fields[i].trim()))) {
							throw new Exception("[是否用户状态检查]的值必须是0(是)或1(否)");
						}
					}
				}
				break;
			// 可办理户状态
			case 32 - 2:
				if (fields[i].trim().length() > 32) {
					throw new Exception("[可办理户状态]长度不对,范围应该在0~128");
				}
				checkFlag(fields[i].trim(), "US", "可办理用户状态", user);
				break;

			// 资费说明32-1
			case 33 - 2:
				if (fields[i].trim().length() > 255) {
					throw new Exception("[资费说明]长度不对,范围应该在0~255");
				}
				break;

			// 说明33-1
			case 34 - 2:
				if (fields[i].trim().length() > 2000) {
					throw new Exception("[说明]长度不对,范围应该在0~2000");
				}
				break;
			case 33:
				if ("".equals(fields[i].trim()) && !iscustom) {
					throw new Exception("[优惠属性]不能为空,长度范围应该在1~2之间");
				} else if (fields[i].trim().getBytes().length > 2) {
					throw new Exception("[优惠属性]长度不能大于2!");
				} else if (!"".equals(fields[i].trim())) {
					checkDictitem(fields[i].trim(), "PC_PRIVELGEPRO", "优惠属性",
							user);
				}
				break;
			case 34:
				if(!"".equals(fields[i].trim()) && fields[i].trim().getBytes("GBK").length>256)
				{
					throw new Exception("[优惠活动短名称]不能长于256位");
				}
				break;
			case 35:
				if (!fields[i].trim().equals("")
						&& !fields[i].trim().matches("[0-9]+$")) {
					throw new Exception("[套餐有效周期]格式不对,应该为数字型");
				}
				break;
			}
		}
	}

	public boolean checkAmtFormat(String amt, int length) {
		amt = amt.trim();
		if (amt.indexOf(".") != -1) {
			if (amt.indexOf(".") == 0)
				return false;
			if (amt.indexOf(".") > length)
				return false;
			if ((amt.length() - amt.indexOf(".")) != 3)
				return false;
		} else {
			if (amt.length() > length)
				return false;
		}
		return true;
	}

	// 检查固定参数 特殊营销方案标志,可办理用户状态的值
	public void checkFlag(String item, String groupid, String name, User user)
			throws Exception {
		if (item.indexOf(",") != -1) {
			String[] itemArr = StringUtils.splitPreserveAllTokens(item, ",");
			for (int i = 0; i < itemArr.length; i++) {
				checkDictitem(itemArr[i], groupid, name, user);
			}
		} else {
			checkDictitem(item, groupid, name, user);
		}
	}

	private void checkDictitem(String str, String groupid, String name,
			User user) throws Exception {
		if ("".equals(str)) {
			return;
		}
		DictitemDelegate delegate = new DictitemDelegate();
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_groupid(groupid);
		listVO.set_se_dictid(str);
		if (delegate.doQuery(listVO, user).getRowCount() <= 0) {
			throw new Exception("固定参数[" + name + "]的值不正确:" + str + "不是正确的固定参数");
		}
	}

	public static void main(String[] args) {
		YxplanCheck check = new YxplanCheck();
		System.out.println("123456".matches("[0-9]+$"));
	}
}
