package com.gmcc.pboss.web.channel.busicircle;

import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.busicircle.BusicircleVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.channel.busicircle.Busicircle;
import com.gmcc.pboss.control.channel.busicircle.BusicircleBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;

public class BusicircleTaskBean extends BaseBatchTaskBean{ 
	
	public BusicircleTaskBean() throws Exception {
		super.setBatchName("商圈管理管理批量导入");
		super.setOprtype("导入");
		super.setWriteLog(true); 
	}

	protected String doStart() {
		return "行号|商圈编码|商圈名称|商圈级别|分公司|商圈地址|处理结果|  \r\n";
	}
	//渠道编码  考核方式  申请类型 调整数据
	@Override
	protected ResultVO processLine(String line, int rowCount) {
		 
		ResultVO resultVO = new ResultVO();
		try {
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");  
			Busicircle busicircleBO = (Busicircle)BOFactory.build(BusicircleBO.class, DBAccessUser.getInnerUser()) ;
			BusicircleVO VO = busicircleBO.doFindByPk(items[0]);
			BusicircleVO busicircleVO = new BusicircleVO();
			
			busicircleVO.setBuscno(items[0]);
			busicircleVO.setBuscelevel(items[2]);
			busicircleVO.setCreatetime(new Date());
			 
			busicircleVO.setCountyid(items[3]);
			busicircleVO.setCityid(user.getCityid());
			if ( null != items[1]){
			     busicircleVO.setBuscname(items[1]);	
			} 
			if (null != items[4]) {
			     busicircleVO.setBuscaddr(items[4]);	
			}
			if (null!=VO){
				BeanUtils.copyProperties(VO, busicircleVO);
				busicircleBO.doUpdate(VO);
			}else{
				busicircleBO.doCreate(busicircleVO);
			} 
 			line = rowCount
			        + "|"
			        + items[0] + "|" + items[1]+ "|"+items[2]+ "|"+items[3]+ "|"+items[4]
					+ "|"+"操作成功"+"|";
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
