package com.sunrise.boss.ui.cms.chadtclassplatformtdinfo;

import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.chadtclassplatformtdinfo.persistent.ChAdtClassplatformtdinfoVO;
import com.sunrise.boss.delegate.cms.chadtclassplatformtdinfo.ChAdtClassplatformtdinfoDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class ChAdtClassplatformtdinfoTaskBean extends BaseBatchTaskBean {
	public ChAdtClassplatformtdinfoTaskBean() throws Exception {
		super.setBatchName("��ƽ̨����ն˺������͵���");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}

	protected String doStart() {
		return "��ƽ̨����ն˺������͵��� \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		try {
			ChAdtClassplatformtdinfoDelegate chAdtClassplatformtdinfoDelegate=new ChAdtClassplatformtdinfoDelegate();
			ChAdtClassplatformtdinfoVO chAdtClassplatformtdinfoVO = new ChAdtClassplatformtdinfoVO();
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			chAdtClassplatformtdinfoVO.setTdbrandid(Integer.parseInt(content[0]));
			
			chAdtClassplatformtdinfoVO.setProductid(content[1]);
			chAdtClassplatformtdinfoVO.setComid(content[2]);
			chAdtClassplatformtdinfoVO.setStartdate(format.parse(content[3]));
			chAdtClassplatformtdinfoVO.setEnddate(format.parse(content[4]));
			chAdtClassplatformtdinfoVO.setAdtremark(content[5]);
			chAdtClassplatformtdinfoVO.setCitycode(Short.parseShort(user.getCityid()));
			
			chAdtClassplatformtdinfoDelegate.doCreate(chAdtClassplatformtdinfoVO, user);
			
			line = rowCount + "   " + line + "    �����ɹ�";
			resultVO.setOk(true);
			resultVO.setInfo(line);
			return resultVO;
			}catch (Exception ex) { // ����ʧ��
				line = rowCount + "   " + line + "    ������Ϣ:" + ex.getMessage();
				resultVO.setInfo(line);
				resultVO.setOk(false);
			}
		return resultVO;
	}


}