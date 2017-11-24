package com.gmcc.pboss.web.base.rewardsendsms;

import java.util.Date; 
import org.apache.commons.lang.StringUtils;
import com.gmcc.pboss.business.base.rewardsendsms.RewardsendsmsDBParam;
import com.gmcc.pboss.business.base.rewardsendsms.RewardsendsmsVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.base.rewardsendsms.Rewardsendsms;
import com.gmcc.pboss.control.base.rewardsendsms.RewardsendsmsBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class RewardsendsmsTaskBean extends BaseBatchTaskBean{ 
	
	public RewardsendsmsTaskBean() throws Exception {
		super.setBatchName("酬金负责人资料录入批量导入");
		super.setOprtype("导入");
		super.setWriteLog(true); 
	}

	protected String doStart() {
		return "行号||出酬负责人号码|出酬酬金类型|处理结果|  \r\n";
	}
	//渠道编码  考核方式  申请类型 调整数据
	@Override
	protected ResultVO processLine(String line, int rowCount) {
		 
		ResultVO resultVO = new ResultVO();
		try {
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");  
			Rewardsendsms rewardsendsms = (Rewardsendsms)BOFactory.build(RewardsendsmsBO.class, DBAccessUser.getInnerUser()) ;
			RewardsendsmsDBParam param =  new RewardsendsmsDBParam(); 
			param.set_se_sendtel(items[0]);
			param.set_se_type(items[1]);
			DataPackage dp=rewardsendsms.doQuery(param);
			if(dp.getRowCount()==0){
				RewardsendsmsVO   vo = new RewardsendsmsVO();
				vo.setCityid(user.getCityid());
				vo.setCreatetime(new Date());
				vo.setSendtel(items[0]);
				vo.setType(Short.parseShort(items[1]));
				rewardsendsms.doCreate(vo);
			}else{
				throw new Exception("已存在号码" + items[0] + "出酬酬金类型为" + items[1] + "的数据");
			}
			 
 			line = rowCount + "|" + items[0] + "|" + items[1]+ "|"+ "|"+"操作成功"+"|";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) { 
			line = rowCount + "   " + line + "|处理信息:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	} 
}
