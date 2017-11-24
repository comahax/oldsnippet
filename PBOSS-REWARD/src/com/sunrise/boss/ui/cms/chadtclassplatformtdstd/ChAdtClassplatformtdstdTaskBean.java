package com.sunrise.boss.ui.cms.chadtclassplatformtdstd;

import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.chadtclassplatformtdstd.persistent.ChAdtClassplatformtdstdVO;
import com.sunrise.boss.delegate.cms.chadtclassplatformtdstd.ChAdtClassplatformtdstdDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class ChAdtClassplatformtdstdTaskBean extends BaseBatchTaskBean {
	public ChAdtClassplatformtdstdTaskBean() throws Exception {
		super.setBatchName("类平台裸机终端合作机型达量酬金标准导入");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}

	protected String doStart() {
		return "类平台裸机终端合作机型达量酬金标准导入 \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		try {
			
			
			ChAdtClassplatformtdstdDelegate chAdtClassplatformtdstdDelegate=new ChAdtClassplatformtdstdDelegate();
			ChAdtClassplatformtdstdVO chAdtClassplatformtdstdVO = new ChAdtClassplatformtdstdVO();
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			chAdtClassplatformtdstdVO.setComid(content[0]);
			
			chAdtClassplatformtdstdVO.setRewardtype(Short.parseShort(content[1]));
			chAdtClassplatformtdstdVO.setAcctype(Short.parseShort(content[2]));
			chAdtClassplatformtdstdVO.setSaleslower(Long.parseLong(content[3]));
			chAdtClassplatformtdstdVO.setSalesupper(Long.parseLong(content[4]));
			chAdtClassplatformtdstdVO.setRewardstd(Double.parseDouble(content[5]));
			chAdtClassplatformtdstdVO.setCitycode(Short.parseShort(user.getCityid()));
			
			chAdtClassplatformtdstdDelegate.doCreate(chAdtClassplatformtdstdVO, user);
			
			line = rowCount + "   " + line + "    操作成功";
			resultVO.setOk(true);
			resultVO.setInfo(line);
			return resultVO;
			}catch (Exception ex) { // 插入失败
				line = rowCount + "   " + line + "    错误信息:" + ex.getMessage();
				resultVO.setInfo(line);
				resultVO.setOk(false);
			}
			
		return resultVO;
	}


}