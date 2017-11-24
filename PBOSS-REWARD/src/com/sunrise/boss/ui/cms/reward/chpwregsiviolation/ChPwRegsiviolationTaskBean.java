package com.sunrise.boss.ui.cms.reward.chpwregsiviolation;

import org.apache.commons.lang.StringUtils;
import com.sunrise.boss.business.cms.reward.chpwregsiviolation.persistent.ChPwRegsiviolationListVO;
import com.sunrise.boss.business.cms.reward.chpwregsiviolation.persistent.ChPwRegsiviolationVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.reward.chpwregsiviolation.ChPwRegsiviolationDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class ChPwRegsiviolationTaskBean extends BaseBatchTaskBean {

	public ChPwRegsiviolationTaskBean() {
		super.setBatchName("套卡真实身份信息违规登记上传");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "套卡真实身份信息违规登记上传结果 \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			String[] content = StringUtils.splitPreserveAllTokens(line, "|");
			ChPwRegsiviolationDelegate delegate = new ChPwRegsiviolationDelegate();
			ChPwRegsiviolationListVO params = new ChPwRegsiviolationListVO();
			params.set_se_mobile(content[0].trim());
			params.set_se_vmonth(content[1].trim());
			DataPackage dp = delegate.doQuery(params, user);
			if (dp.getDatas() != null && dp.getDatas().size() > 0) {
				line = rowCount + "|" + line + "该号码已导入，无须重复导入";
				resultVO.setOk(false);
			} else {
				ChPwRegsiviolationVO vo = new ChPwRegsiviolationVO();
				vo.setMobile(content[0].trim());
				vo.setVmonth(content[1].trim());
				vo.setRemark(content[2].trim());
				delegate.doCreate(vo, user);
				
				line = rowCount + "|" + line + "操作成功";
				resultVO.setOk(true);
			}
		} catch (Exception e) {
			line = rowCount + "|" + line + "错误信息:" + e.getMessage();
			resultVO.setOk(false);
		}
		resultVO.setInfo(line);
		return resultVO;
	}

}
