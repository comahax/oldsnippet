package com.sunrise.boss.ui.cms.zjty.chzjtyterewardstd;

import java.util.Date;
import org.apache.commons.lang.StringUtils;
import com.sunrise.boss.business.cms.zjty.chzjtyterewardstd.persistent.ChZjtyTerewardstdVO;
import com.sunrise.boss.delegate.cms.zjty.chzjtyterewardstd.ChZjtyTerewardstdDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class ChZjtyTerewardstdTaskBean extends BaseBatchTaskBean {

	public ChZjtyTerewardstdTaskBean() {
		super.setBatchName("�ն˳���׼��������");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "�к�|�ն˻���|��׼��|����׼|�������|�Ƴ�����|��ע|������ \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			String[] content = StringUtils.splitPreserveAllTokens(line, "|");
			String region = parameterMap.get("_region").toString();
			ChZjtyTerewardstdVO vo = new ChZjtyTerewardstdVO();
			ChZjtyTerewardstdDelegate delegate = new ChZjtyTerewardstdDelegate();
			vo.setComid(content[0].trim());
			vo.setStandardprice(Double.parseDouble(content[1].trim()));
			vo.setRewardstd(Double.parseDouble(content[2].trim()));
			vo.setRewardtype(Short.parseShort(content[3].trim()));
			vo.setAcctype(Short.parseShort(content[4].trim()));
			vo.setAdtremark(StringUtils.isEmpty(content[5])? "" : content[5]);
			vo.setCreatetime(new Date());
			if (region != null && region.equals("999")) {
				vo.setCitycode(Short.parseShort("999"));
			} else {
				vo.setCitycode(Short.parseShort(user.getCityid()));
			}
			delegate.doCreate(vo, user);
			
			line = rowCount + "|" + line + "�����ɹ�";
			resultVO.setOk(true);
			resultVO.setInfo(line);
			return resultVO;
		} catch (Exception e) {
			line = rowCount + "|" + line + "������Ϣ:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}

}
