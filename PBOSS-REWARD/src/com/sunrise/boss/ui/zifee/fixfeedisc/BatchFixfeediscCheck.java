package com.sunrise.boss.ui.zifee.fixfeedisc;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.delegate.zifee.yxplan.YxPlanDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.PublicUtils;

/**
 * 继承BaseCheckFormat或者实现ICheckFormat接口
 * 
 * @author yangxuehong
 */
public class BatchFixfeediscCheck extends BaseCheckFormat {
	/*
	 * 批量上传操作类型（0新增、1修改、2删除）
	 */
	private int operType = 0;

	public BatchFixfeediscCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		this.operType = Integer.parseInt(parameterMap.get("operType")
				.toString());
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount,User user) throws Exception {
		if (rowCount > 10000) {
			throw new Exception("文件行数不能超过10000行");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");

		/*
		 * 根据不同的操作，上传文件列数不同。
		 */
		if (this.operType == 0 && items.length != 5) {
			throw new Exception("上传数据列数不对,应为5列,请查看说明帮助!");
		} else if (this.operType == 1 && items.length != 6) {
			throw new Exception("上传数据列数不对,应为6列,请查看说明帮助!");
		}

		isNull(items, rowCount,user);
		checkColumnsTypeAndLength(items, rowCount);
	}

	/*
	 * 营销方案标识、帐单科目标识、优惠方式不能为空
	 */
	private void isNull(String[] items, int rowCount,User user) throws Exception {
		if (StringUtils.isBlank(items[0 + this.operType]))
		{
			throw new Exception("第" + rowCount + "行营销方案标识为空！"+items[0+operType]);
		}
		else
		{
			if(!CheckUtil.checkNum(items[0+this.operType],14))
			{
				throw new Exception("营销方案标识为不长于14位长度的数字并且不能为空:"+items[0+operType]);
			}
			String areacode=new YxPlanDelegate().getAreacode(new Long(StringUtils.trim(items[0+this.operType])), user);
			if(areacode==null)
			{
				throw new Exception("营销方案标识在主表中不存在!"+items[0+operType]);
			}
			if(user.isProvinceUser())
			{
				if(!"999".equals(areacode) && !"100".equals(areacode))
				{
					throw new Exception("省级工号只能操作省级营销方案! 出错信息:<font color=red>"+items[0+this.operType]+"<font>");
				}
			}
			else
			{
				if(!areacode.equals(user.getCityid()))
				{
					throw new Exception("该登录用户只能操作本地市营销方案! 出错信息:<font color=red>"+items[0+this.operType]+"<font>");
				}
			}
		}
		if (StringUtils.isBlank(items[1 + this.operType]))
			throw new Exception("第" + rowCount + "行帐单科目标识为空！");
		if (StringUtils.isBlank(items[2 + this.operType]))
			throw new Exception("第" + rowCount + "优惠方式为空！");
	}

	/*
	 * 对导入各字段保证符合数据库设计的类型和限制在最大长度以内
	 */
	private void checkColumnsTypeAndLength(String[] items, int rowCount)
			throws Exception {
		if (this.operType == 1
				&& (!PublicUtils.isInteger(items[0]) || StringUtils
						.trimToEmpty(items[0]).length() > 10))
			throw new Exception("第" + rowCount + "行固定费优惠标识不为整数" + "或长度超过限制14！");
		if (!PublicUtils.isInteger(items[0 + this.operType])
				|| StringUtils.trimToEmpty(items[0 + this.operType]).length() > 14)
			throw new Exception("第" + rowCount + "行营销方案标识不为整数" + "或长度超过限制14！");
		if (!PublicUtils.isInteger(items[1 + this.operType])
				|| StringUtils.trimToEmpty(items[1 + this.operType]).length() > 14)
			throw new Exception("第" + rowCount + "行帐单科目标识不为整数" + "或长度超过限制14！");
		if (!PublicUtils.isInteger(items[2 + this.operType])
				|| !(Integer.parseInt(StringUtils
						.trimToEmpty(items[2 + this.operType])) == 1 || Integer
						.parseInt(StringUtils
								.trimToEmpty(items[2 + this.operType])) == 0))
			throw new Exception("第" + rowCount + "行优惠方式不为整数或超过限制"
					+ "（只能为0或者1）！");
		if (StringUtils.trimToEmpty(items[2 + this.operType]).equals("0")) {
			if (!PublicUtils.isDecimal(items[3 + this.operType], 2, 1))
				throw new Exception("第" + rowCount
						+ "行优惠方式为[折扣]时，折扣必需为小数，精度为2，且不能大于1！");
			double item5=-1;
			try{
			item5=Double.parseDouble(StringUtils
					.trimToEmpty(items[4 + this.operType]));
			}catch(Exception ex)
			{
				throw new Exception("[现金优惠]必须为数字");
			}
			if (item5 != 0) {
				throw new Exception("第" + rowCount + "行优惠方式为［折扣］时，"
						+ "现金优惠必需为0！");
			}
		} else {
			if (!PublicUtils.isDecimal(items[4 + this.operType], 2, 999999))
				throw new Exception("第" + rowCount
						+ "行优惠方式为[现金]时，现金优惠必须为数字并且不能大于999999！");
			double item4 = -1;
			try {
				item4 = Double.parseDouble(StringUtils
						.trimToEmpty(items[3 + this.operType]));
			} catch (Exception ex) {
				throw new Exception("[折扣]必须为数字");
			}
			if (item4 != 1) {
				throw new Exception("第" + rowCount + "行优惠方式为[现金]时，" + "折扣必需为1");
			}
		}
	}
}