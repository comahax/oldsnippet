package com.gmcc.pboss.web.resource.phonestate;

import java.util.List; 
import com.gmcc.pboss.business.resource.phonestate.PhonestateDBParam;
import com.gmcc.pboss.business.resource.phonestate.PhonestateVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.resource.phonestate.PhonestateBO;  
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.TimeUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class PhonestateTaskBean extends BaseBatchTaskBean {
	
	PhonestateBO phonestateBO = null;
	public PhonestateTaskBean() throws Exception {
		super.setBatchName("号码状态批量导入查询");
		super.setOprtype("导入");
		super.setWriteLog(true);
	}
	protected String doStart() {
		return "行号|号码|商品状态|是否激活|激活时间|订单号|所属网点|资源归属渠道|销售时间|  \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try{
			phonestateBO = (PhonestateBO) BOFactory.build(PhonestateBO.class,user); 
			PhonestateDBParam params = new PhonestateDBParam();
			params.set_se_comresid(line);
		    DataPackage dp	= phonestateBO.doChooseData(params);
		    
		    List<PhonestateVO> list= (List)dp.getDatas();
		    PhonestateVO phonestateVO  = list.get(0);
		    
		    line = rowCount + "|" + line + "|" 
		    	+ (phonestateVO.getComstate() == null ? "" : Code2NameUtils.code2Name("$FX_COMSTATE", phonestateVO.getComstate().toString(), user.getCityid())) + "|" 
				+ (phonestateVO.getIsactive() == null ? "" : Code2NameUtils.code2Name("ISACHIEVE", phonestateVO.getIsactive().toString(), user.getCityid())) + "|" 
				+ (phonestateVO.getActtime() == null ? "" : TimeUtils.formatDateTime(phonestateVO.getActtime())) + "|" 
				+ (phonestateVO.getOrderid() == null ? "" : phonestateVO.getOrderid()) + "|" 
				+ (phonestateVO.getWayid() == null ? "" : phonestateVO.getWayid()) + "|" 
				+ (phonestateVO.getReswayid() == null ? "" : phonestateVO.getReswayid()) + "|" 
				+ (phonestateVO.getSaletime() == null ? "" : phonestateVO.getSaletime()) + "|";
 
			resultVO.setInfo(line);
			resultVO.setOk(true);
		}catch(Exception e){
			line = rowCount + "|" + line + "|数据不存在" + "|";
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
