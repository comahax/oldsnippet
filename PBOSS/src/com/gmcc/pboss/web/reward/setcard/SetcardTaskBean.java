package com.gmcc.pboss.web.reward.setcard;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.reward.setcard.SetcardVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.common.utils.tools.DateUtil;
import com.gmcc.pboss.control.reward.setcard.Setcard;
import com.gmcc.pboss.control.reward.setcard.SetcardBO;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class SetcardTaskBean extends BaseBatchTaskBean {
	
	public SetcardTaskBean() throws Exception {
		super.setBatchName("�׿��������ݵ���");
		super.setOprtype("����");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "��������|��������|����|����|��������|Ʒ��|  \r\n";
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			String content[] = StringUtils.splitPreserveAllTokens(line, "|");
			Setcard setcard = (Setcard) BOFactory.build(SetcardBO.class, user);

			String cityid = user.getCityid();

			SetcardVO vo = new SetcardVO();
			vo.setWayid(content[0].trim());
			vo.setActvday(content[1].trim());
			vo.setMobile(content[2].trim());
			vo.setCityid(content[3].trim());
			vo.setWaytype(content[4].trim());
			vo.setComname(content[5].trim());
			vo.setIntime(DateUtil.getCurrentDate());
			vo.setFilename(super.getFilesourcename());
			setcard.doCreate(vo);

			StringBuilder strb = new StringBuilder();
			strb.append(rowCount);
			strb.append("|");
			strb.append(line);
			strb.append("|����ɹ�|");

			resultVO.setInfo(strb.toString());
			resultVO.setOk(true);

		} catch (Exception e) {
			StringBuilder strb = new StringBuilder();
			strb.append(rowCount);
			strb.append("|");
			strb.append(line);
			strb.append("|����ԭ��:");
			strb.append(e.getMessage());
			strb.append("|");

			resultVO.setInfo(strb.toString());
			resultVO.setOk(false);
		}

		return resultVO;
	}	
}
