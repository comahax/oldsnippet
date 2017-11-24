package com.gmcc.pboss.web.reward.paydetail;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.reward.paydetail.PaydetailDBParam;
import com.gmcc.pboss.business.reward.paydetail.PaydetailVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.reward.paydetail.Paydetail;
import com.gmcc.pboss.control.reward.paydetail.PaydetailBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class PaydetailTaskBean extends BaseBatchTaskBean {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3204574449638130415L;

	public PaydetailTaskBean() throws Exception {
		super.setBatchName("店补明细上传资料导入"); 
		super.setOprtype("导入");
		super.setWriteLog(true);
	}
	
	protected String doStart() {
		return "渠道编码|渠道名称|IMEI/号码|业务月|结算月|  \r\n";
	}
	
	//TODO 
	@Override
	protected ResultVO processLine(String line, int rowCount) {
 		ResultVO resultVO = new ResultVO();
 		try {
			String content[] = StringUtils.splitPreserveAllTokens(line, "|");
			Paydetail paydetail = (Paydetail) BOFactory.build(PaydetailBO.class,user);
			
			// 判断店补明细上传唯一性   暂时不用
//			PaydetailDBParam params = new PaydetailDBParam();
//			params.set_se_type("DB");
//			params.set_se_wayid(content[0]);
//			params.set_se_mobile(content[1]);
//			params.set_se_opmonth(content[2]);
//			params.set_se_calcmonth(content[3]);
//			
//			DataPackage dp = paydetail.doQuery(params);
			
			PaydetailVO vo = new PaydetailVO();
//			if (dp.getDatas().size()>0 ) {
//				vo = (PaydetailVO)dp.getDatas().get(0);
//			}
			vo.setWayid(content[0].trim());
			vo.setMobile(content[1].trim());
			vo.setOpmonth(content[2].trim());
			vo.setCalcmonth(content[3].trim());
			vo.setType("DB");
			
			paydetail.doCreate(vo);
			line = rowCount + "|"+line+"|" + "导入成功" + "|";
			
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) {
			line = rowCount + "|" + line + "|" + "出错原因:" + e.getMessage() + "|";
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		
		return resultVO;
	}
	
	
}
