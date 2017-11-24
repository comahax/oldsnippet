package com.sunrise.boss.ui.zifee.minconsume;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.boss.delegate.zifee.minconsume.MinconsumeDelegate;
import com.sunrise.boss.delegate.zifee.yxplan.YxPlanDelegate;

public class BatchMinconsumeCheck extends BaseCheckFormat {
	private MinconsumeDelegate minconsumeDelegate;

	private final String fixFields[] = { "营销方案标识", "生效时间间隔", "最低消费跨越周期",
			"最低消费周期数", "最低消费生效类型", "最低消费额" };

	private int batchaction = 0;

	private String resultStr = "";

	public BatchMinconsumeCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		this.batchaction = Integer.parseInt(parameterMap.get("batchaction")
				.toString());
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	private MinconsumeDelegate getMinconsumeDelegate() throws Exception {
		if (minconsumeDelegate == null) {
			return new MinconsumeDelegate();
		} else {
			return minconsumeDelegate;
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
		try {
			String[] items = StringUtils.splitPreserveAllTokens(line, "|");
			// 检查列数
			if (items.length != 6 && batchaction ==0) {
				throw new Exception("上传数据列数不对,应为6列,请查看说明帮助!");
			}
			String[] columns = { "[营销方案标识]", "[生效时间间隔]", "[最低消费跨越周期]",
					"[最低消费周期数]", "[最低消费生效类型]", "[最低消费额]" };
			if(!CheckUtil.checkNum(items[0],14))
			{
				throw new Exception("营销方案标识为不长于14位长度的数字并且不能为空:"+items[0]);
			}
			String areacode=new YxPlanDelegate().getAreacode(new Long(StringUtils.trim(items[0])), user);
			if(areacode==null)
			{
				throw new Exception("营销方案标识在主表中不存在!"+items[0]);
			}
			if (user.isProvinceUser() && StringUtils.isNotBlank(items[0])) {
				if (!"999".equals(areacode)
						&& !"100".equals(areacode)) {
					throw new Exception("省级工号只能操作省级营销方案! 出错信息:<font color=red>"
							+ items[0] + "<font>");
				}
			} else if (!user.isProvinceUser()
					&& StringUtils.isNotBlank(items[0])) {
				if (!areacode.equals(user.getCityid())) {
					throw new Exception(
							"该登录用户只能操作本地市营销方案! 出错信息:<font color=red>"
									+ items[0] + "<font>");
				}
			}
			if (batchaction == 0) {
				for (int i = 0; i <= items.length - 1; i++) {
					if ("".equals(items[i].trim()) || items[i] == null) {
						throw new Exception(columns[i] + "不能为空");
					}
				}
				checkNewVO(items,user);
			} else if (batchaction == 1) {
				checkUpdateVO(items,user);
			} else if (batchaction == 2) {
				if (rowCount == 1) {
					CheckUtil.checkHead(items, fixFields, user);
				} else {
					items = CheckUtil.checkLines(items, user);
					checkUpdateVO(items,user);
				}
			}
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

	private void checkNewVO(String[] items,User user) throws Exception {
		if (!CheckUtil.checkNum(items[0], 18)) {
			throw new Exception("[营销方案标识]不能为空或长于18位,并且只能为数字!");
		}else
		{
			//判断[营销方案标识]在系统中是否存在
			checkYxplnaid(StringUtils.trim(items[0]),user);
		}
		if (!CheckUtil.checkNum(items[1], 8)) {
			throw new Exception("[生效时间间隔]不能为空或长于8位并且只能为数字!");
		}
		if (!CheckUtil.checkNum(items[2], 14)) {
			throw new Exception("[最低消费跨越周期]不能为空或长于14位并且只能为数字!");
		}else if(new Long(items[2].trim()).longValue()-1<0)
		{
			throw new Exception("[最低消费跨越周期]为大于等于1的数字");
		}
		if (!CheckUtil.checkNum(items[3], 8)) {
			throw new Exception("[最低消费周期数]不能为空或长于8位并且只能为数字!");
		}else if(new Long(items[3].trim()).longValue()-1<0 && items[3].trim()!="-1")
		{
			throw new Exception("[最低消费周期数]为大于等于1的数字");
		}
		if (!CheckUtil.checkString(items[4], 32)) {
			throw new Exception("[最低消费生效类型]不能为空或长于32位!");
		}
		if(StringUtils.isNotBlank(items[4]))
		{
			if(!CheckUtil.getInstance().checkDictitem("PC_CONSUMEEFFECTIVETYPE", items[4].trim(), user))
			{
				throw new Exception("[最低消费生效类型]固定参数值不正确,请参考'z'或'x'");
			}
		}
		if (!CheckUtil.checkNum(items[5], 8)) {
			throw new Exception("[最低消费额]不能为空或长于8位并且只能为数字!");
		}else if(new Long(items[5].trim()).longValue()<0)
		{
			throw new Exception("[最低消费额]为大于等于0的数字");
		}
	}

	private void checkUpdateVO(String[] items,User user) throws Exception {
		if (!CheckUtil.checkNum(items[0], 18)) {
			throw new Exception("[营销方案标识]不能为空或长于18位并且只能为数字!");
		}else
		{
			checkYxplnaid(CheckUtil.dealString(items[0]),user);
		}
		if (!CheckUtil.checkNum(items[1], 8)) {
			throw new Exception("[生效时间间隔]不能为空或长于8位并且只能为数字!");
		}
		if (!CheckUtil.checkNum(items[2], 14, true)) {
			throw new Exception("[最低消费跨越周期]不能长于14位并且只能为数字!");
		}
		if (!CheckUtil.checkNum(items[3], 8, true)) {
			throw new Exception("[最低消费周期数]不能长于8位并且只能为数字!");
		}
		if (!CheckUtil.checkString(items[4], 32, true)) {
			throw new Exception("[最低消费生效类型]不能长于32位!");
		}
		if(StringUtils.isNotBlank(items[4]))
		{
			if(!CheckUtil.getInstance().checkDictitem("PC_CONSUMEEFFECTIVETYPE", items[4], user))
			{
				throw new Exception("[最低消费生效类型]固定参数值不正确,请参考'z'或'x'");
			}
		}
		if (!CheckUtil.checkNum(items[5], 8, true)) {
			throw new Exception("[最低消费额]不能长于8位并且只能为数字!");
		}
	}
	private void checkYxplnaid(String yxplanid,User user)throws Exception
	{
		if(CheckUtil.isEmpty(yxplanid))
		{
			throw new Exception("yxplanid为空!");
		}
		YxPlanVO vo=new YxPlanDelegate().doFindByPk(CheckUtil.setLong(yxplanid),user);
		if(vo==null)
		{
			throw new Exception("yxplanid:"+yxplanid+"在系统中不存在!");
		}
		if (vo != null
				&& !StringUtils.equals(vo.getAreacode(), user.getCityid())) {
			throw new Exception("yxplanid:" + yxplanid + "在系统中对应的CITYID:"
					+ vo.getAreacode() + "与当前工号登陆的CITYID:" + user.getCityid()
					+ "不一致!");
		}
	}
}
