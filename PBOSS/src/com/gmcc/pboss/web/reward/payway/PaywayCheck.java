package com.gmcc.pboss.web.reward.payway;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.reward.payway.PaywayDBParam;
import com.gmcc.pboss.business.reward.payway.PaywayVO;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.reward.payway.Payway;
import com.gmcc.pboss.control.reward.payway.PaywayBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class PaywayCheck extends BaseCheckFormat {
	private User user;

	private List<String> wayIdList;

	@Override
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		user = (User) parameterMap.get("user");
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	/**
	 * 获取本地市包括省的所有渠道编码ID
	 * 
	 * @return
	 */
	public List<String> getWayIdList() throws Exception {
		wayIdList = new ArrayList<String>();

		PaywayDBParam params = new PaywayDBParam();
		params.set_pagesize("0");
		params.setDataOnly(true);
		params.setSelectFieldsString("wayid");
		params.getQueryConditions().put("cityid", user.getCityid());

		try {
			Payway payway = (Payway) BOFactory.build(PaywayBO.class, user);

			String qrySql = "com.gmcc.pboss.business.reward.payway.doQueryVWayBySql";
			DataPackage paywayDp = payway.doQueryVWayBySql(params, qrySql);
			wayIdList = (List<String>) paywayDp.getDatas();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("获取该地市包括省所有的渠道编码名称出错");
		}

		return wayIdList;
	}

	@Override
	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 3) {
			throw new Exception("上传列数不正确，应为2列!");
		}

		if (StringUtils.isBlank(content[0])
				|| content[0].trim().getBytes("GBK").length > 128) {
			throw new Exception("收款单位名称不能为空且长度不能大于128");
		}

		String wayid = content[1];
		if (StringUtils.isBlank(wayid)
				|| wayid.trim().getBytes("GBK").length > 18) {
			throw new Exception("渠道编码不能为空且长度不能大于18");
		}

		// 首次需要执行该地市的收款单位数据查询
		if (wayIdList == null) {
			getWayIdList();
		}

		if (!(wayIdList.size() > 0 && wayIdList.contains(wayid))) {
			throw new Exception("渠道编码[" + wayid + "]在渠道表不存在，请检查渠道编码后再上传");
		}
	}
}
