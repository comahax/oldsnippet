package com.sunrise.boss.ui.cms.resale;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.resale.persistent.ResaleVO;
import com.sunrise.boss.delegate.cms.resale.ResaleDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class ResaleTaskBean extends BaseBatchTaskBean {
	private ResaleDelegate delegate;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public ResaleTaskBean() throws Exception {
		super.setBatchName("社会渠道资源销售信息批量导入日志查询");
		super.setWriteLog(true);
		delegate = new ResaleDelegate();
	}

	protected String doStart() {
		return "社会渠道资源销售信息批量导入结果 \r\n";
	}

	/**
	 * 处理一条记录
	 */
	public ResultVO processLine(String line, int rowCount) {
		if (null == line || "".equals(line)) {
			return null;
		}
		ResultVO rvo = new ResultVO();
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		ResaleVO resaleVO = new ResaleVO();
		//resaleVO.setItemid(new Long(items[0]));
		try {
			ResaleVO resaleVO1 = null;
//			if (resaleVO1 != null) { // 存在相同记录，修改记录
//				//销售渠道编码
//				if (items[0] == null || items[0].equals("")) {
//					resaleVO.setWayid(resaleVO.getWayid());
//				} else {
//					resaleVO.setWayid(items[0]);
//				}
//				//分公司编码
//				if (items[1] == null || items[1].equals("")) {
//
//					resaleVO.setCountyid(resaleVO.getCountyid());
//				} else {
//					resaleVO.setCountyid(items[1]);
//				}
//				//号码
//				if (items[2] == null || items[2].equals("")) {
//
//					resaleVO.setMobile(resaleVO.getMobile());
//				} else {
//					resaleVO.setMobile(items[2]);
//				}
//
//				//品牌
//				if (items[3] == null || items[3].equals("")) {
//					resaleVO.setBrand(resaleVO.getBrand());
//				} else {
//					resaleVO.setBrand(new Long(items[3]));
//				}
//				//销售日期
//				if (items[4] == null || items[4].equals("")) {
//					resaleVO.setDaytime(resaleVO.getDaytime());
//				} else {
//					try {
//						resaleVO.setDaytime(sdf.parse(items[4]));
//					} catch (Exception e) {
//						rvo.setInfo("规划时间格式错误!");
//						rvo.setOk(false);
//					}
//				}
//				delegate.doUpdate(resaleVO, user);
//			} else { // 新增记录 
				resaleVO.setItemid(null);
				resaleVO.setWayid(items[0]);
				resaleVO.setCountyid(items[1]);
				resaleVO.setMobile(items[2]);
				resaleVO.setBrand(new Long(items[3]));
				resaleVO.setDaytime(sdf.parse(items[4]));
				delegate.doCreate(resaleVO, user);
//			}
		} catch (Exception e) {
			rvo.setInfo(e.getMessage());
			rvo.setOk(false);
		}

		if (rvo.getInfo() != null) {
			line = rowCount + "   " + line + "    " + rvo.getInfo();
			rvo.setInfo(line);
			return rvo;
		}

		line = rowCount + "   " + line + "    成功";
		rvo.setInfo(line);
		rvo.setOk(true);
		return rvo;
	}

}