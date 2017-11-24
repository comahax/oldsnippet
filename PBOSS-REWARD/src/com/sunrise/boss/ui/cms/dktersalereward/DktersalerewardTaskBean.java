package com.sunrise.boss.ui.cms.dktersalereward;

import org.apache.commons.lang.StringUtils;
import com.sunrise.boss.business.cms.dktersalereward.persistent.DktersalerewardListVO;
import com.sunrise.boss.business.cms.dktersalereward.persistent.DktersalerewardVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.dktersalereward.DktersalerewardDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class DktersalerewardTaskBean extends BaseBatchTaskBean {

	public DktersalerewardTaskBean() {
		super.setBatchName("�����µ��ն˳���ϴ�");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "�����µ��ն˳���ϴ� \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			String[] content = StringUtils.splitPreserveAllTokens(line, "|");
			DktersalerewardDelegate delegate = new DktersalerewardDelegate();
			DktersalerewardListVO params = new DktersalerewardListVO();
			params.set_se_month(StringUtils.isEmpty(content[0]) ? "" : content[0]);
			params.set_se_ecpoperator(StringUtils.isEmpty(content[1]) ? "" : content[1]);
			params.set_se_wayname(StringUtils.isEmpty(content[2]) ? "" : content[2]);
			params.set_ne_cityid(user.getCityid());
			DataPackage dp = delegate.doQuery(params, user);
			if (dp.getDatas() != null && dp.getDatas().size() > 0) {
				DktersalerewardVO vo = (DktersalerewardVO) dp.getDatas().iterator().next();
				vo.setMonth(StringUtils.isEmpty(content[0]) ? "" : content[0]);
				vo.setEcpoperator(StringUtils.isEmpty(content[1]) ? "" : content[1]);
				vo.setWayname(StringUtils.isEmpty(content[2]) ? "" : content[2]);
				vo.setSalesuc(StringUtils.isEmpty(content[3]) ? 0 : Long.parseLong(content[3]));
				vo.setExaminesuc(StringUtils.isEmpty(content[4]) ? 0 : Long.parseLong(content[4]));
				vo.setFoundreward(StringUtils.isEmpty(content[5]) ? 0 : Double.valueOf(content[5]));
				vo.setExaminereward(StringUtils.isEmpty(content[6]) ? 0 : Double.valueOf(content[6]));
				vo.setCityid(Short.parseShort(user.getCityid()));
				delegate.doUpdate(vo, user);
			} else {
				DktersalerewardVO vo = new DktersalerewardVO();
				vo.setMonth(StringUtils.isEmpty(content[0]) ? "" : content[0]);
				vo.setEcpoperator(StringUtils.isEmpty(content[1]) ? "" : content[1]);
				vo.setWayname(StringUtils.isEmpty(content[2]) ? "" : content[2]);
				vo.setSalesuc(StringUtils.isEmpty(content[3]) ? 0 : Long.parseLong(content[3]));
				vo.setExaminesuc(StringUtils.isEmpty(content[4]) ? 0 : Long.parseLong(content[4]));
				vo.setFoundreward(StringUtils.isEmpty(content[5]) ? 0 : Double.valueOf(content[5]));
				vo.setExaminereward(StringUtils.isEmpty(content[6]) ? 0 : Double.valueOf(content[6]));
				vo.setCityid(Short.parseShort(user.getCityid()));
				delegate.doCreate(vo, user);
			}
			line = rowCount + "|" + line + "|�����ɹ�";
			resultVO.setOk(true);
			resultVO.setInfo(line);
			return resultVO;
		} catch (Exception e) {
			line = rowCount + "|" + line + "|������Ϣ:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}

}
