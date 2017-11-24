package com.gmcc.pboss.web.resource.numtypedef;


import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.resource.numsortrule.NumsortruleDBParam;
import com.gmcc.pboss.business.resource.numsortrule.NumsortruleVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.resource.numsortrule.Numsortrule;
import com.gmcc.pboss.control.resource.numsortrule.NumsortruleBO;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class NumtypedefTaskBean extends BaseBatchTaskBean{
	
	public NumtypedefTaskBean() throws Exception {
		super.setBatchName("规则表达式批量导入");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		// TODO Auto-generated method stub
		ResultVO resultVO = new ResultVO();
		try{
			String typeid=(String)this.parameterMap.get("typeid");
			String typename=(String)this.parameterMap.get("typename");
			Numsortrule bo = (Numsortrule) BOFactory.build(NumsortruleBO.class, user);
			
			//规则表达式
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			NumsortruleDBParam params = new NumsortruleDBParam();
			params.set_ne_typeid(Long.valueOf(typeid));
			params.set_se_ruleexp(items[0]);
			if(bo.doQuery(params).getDatas().size()>0){
				throw new Exception(typename+"|"+ items[0]+"|已存在相同的规则表达式|");
			}
			NumsortruleVO ruleVo=new NumsortruleVO();
			ruleVo.setTypeid(Long.valueOf(typeid));
			ruleVo.setRuleexp(items[0]);
			bo.doCreate(ruleVo);
			line =typename+"|"+ items[0]+"|  |";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		}catch(Exception e){
			line = e.getMessage();
			e.printStackTrace();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
			return resultVO;
	}
	


}
