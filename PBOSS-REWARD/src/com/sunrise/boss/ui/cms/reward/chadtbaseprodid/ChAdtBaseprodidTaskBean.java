package com.sunrise.boss.ui.cms.reward.chadtbaseprodid;

import java.util.Date;
import org.apache.commons.lang.StringUtils;
import com.sunrise.boss.business.cms.reward.chadtbaseprodid.persistent.ChAdtBaseprodidVO;
import com.sunrise.boss.delegate.cms.reward.chadtbaseprodid.ChAdtBaseprodidDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class ChAdtBaseprodidTaskBean extends BaseBatchTaskBean{

	public ChAdtBaseprodidTaskBean() {
		super.setBatchName("套餐产品列表设置导入");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "行号|产品标识|地市标识|套餐类型|产品名称|套餐类别|购机类型|套餐值|备注|处理结果 \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			String[] content = StringUtils.splitPreserveAllTokens(line, "|"); 
			ChAdtBaseprodidVO vo = new ChAdtBaseprodidVO();
			ChAdtBaseprodidDelegate delegate = new ChAdtBaseprodidDelegate();
			vo.setProdid(content[0].trim()); 
			vo.setCityid(content[1].trim());
			vo.setType(content[2]); 
			vo.setProdname(StringUtils.isEmpty(content[3])? "" : content[3]);
			vo.setOprtype(content[4]);
			vo.setTertype(StringUtils.isEmpty(content[5])? "" : content[5]); 
			vo.setWrapfee(Double.parseDouble(content[6].trim())); 
			vo.setAdtremark(StringUtils.isEmpty(content[7])? "" : content[7]);
			vo.setCreatetime(new Date());
			delegate.doCreate(vo, user);
			
			line = rowCount + "|" + line + "操作成功";
			resultVO.setOk(true);
			resultVO.setInfo(line);
			return resultVO;
		} catch (Exception e) {
			line = rowCount + "|" + line + "错误信息:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
