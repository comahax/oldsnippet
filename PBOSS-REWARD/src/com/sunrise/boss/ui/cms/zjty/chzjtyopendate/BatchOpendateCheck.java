package com.sunrise.boss.ui.cms.zjty.chzjtyopendate;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class BatchOpendateCheck extends BaseCheckFormat {
	private int operType = 0;

	public BatchOpendateCheck() {
		// TODO Auto-generated constructor stub
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		this.operType = Integer.parseInt(parameterMap.get("operType")
				.toString());
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("",
					"要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		// TODO Auto-generated method stub
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		/*
		 * 根据不同的操作，上传文件列数不同。
		 */
		if (this.operType != 2 && items.length != 3) {
			throw new Exception("上传数据列数不对,应为3列,请查看说明帮助!");

		} else if (this.operType == 2 && items.length != 2) {
			throw new Exception("上传数据列数不对,应为1列,请查看说明帮助!");
		}
		if (StringUtils.isBlank(items[0]) || StringUtils.isBlank(items[1])) {
			if (this.operType != 2) {
				throw new Exception("[渠道代码]或[交接日期]不能为空");
			}
		}
		// 检查渠道代码
		WayDelegate delegate = new WayDelegate();
		WayVO vo = delegate.doFindByPk(items[0].trim(), user);
		if (vo == null) {
			throw new Exception("渠道表中不存在相关渠道代码的记录：" + items[0]);
		} else if (!"AG".equals(vo.getWaytype())
				&& !"ZJTY".equals(vo.getWaysubtype())) {
			throw new Exception("本菜单只提供自建他营类型的渠道录入和修改");
		}
		if (items[0].getBytes("GBK").length > 32) {
			throw new Exception("[渠道代码]长度应该小于32位");
		}
		if (this.operType != 2) {
			// 检查交接日期
			java.text.SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
			try {
				fmt.parse(items[1]);
			} catch (Exception ex) {
				throw new Exception("[交接日期]格式为[YYYYMMDD]");
			}
			// 检查 说明
			if (items[2].getBytes("GBK").length > 32) {
				throw new Exception("[说明]长度最大为255");
			}
		}

	}

}
