package com.gmcc.pboss.web.channel.way;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class LogiswayTaskBean extends BaseBatchTaskBean{

	public LogiswayTaskBean() throws Exception {
		super.setBatchName("配送商管理批量导入");
		super.setOprtype("导入");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		// TODO Auto-generated method stub
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		//去空格
		for(int i=0;i<items.length;i++)
		{
			if(items[i]!=null)
				items[i]=items[i].trim();
		}
		
		try{
			Way wayBO = (WayBO)BOFactory.build(WayBO.class,user);
			wayBO.doLogiswayImport(items);
			resultVO.setOk(true);
			resultVO.setInfo(showInfo(resultVO, items, rowCount));
			return resultVO;
		}catch(Exception ex){
			msg = ex.getMessage();
			ex.printStackTrace();
			resultVO.setOk(false);
			resultVO.setInfo(showInfo(resultVO, items, rowCount) + msg);
			return resultVO;
		}
	}

	
	/**
	 * 结果文件格式
	 */
	public String showInfo(ResultVO resultVO, String[] items, int rowCount) {
		final String COMPART = " | "; // 分隔
		StringBuffer resultStr = new StringBuffer();
		// 序号
		resultStr.append(rowCount).append(COMPART);
		resultStr.append(items[0]).append(COMPART);
		resultStr.append(items[1]).append(COMPART);
		resultStr.append(items[2]).append(COMPART);
		resultStr.append(items[3]).append(COMPART);
		resultStr.append(items[4]).append(COMPART);
		resultStr.append(items[5]).append(COMPART);
		resultStr.append(items[6]).append(COMPART);
		resultStr.append(items[7]).append(COMPART);
		resultStr.append(items[8]).append(COMPART);
		resultStr.append(items[9]).append(COMPART);
		resultStr.append(items[10]).append(COMPART);
		resultStr.append(items[11]).append(COMPART);
		resultStr.append(items[12]).append(COMPART);
		resultStr.append(items[13]).append(COMPART);
		resultStr.append(items[14]).append(COMPART);
		

		resultStr.append("增加");
		resultStr.append(COMPART);
		// 办理结果
		if (resultVO.isOk()) {
			resultStr.append("成功");
		} else {
			resultStr.append("失败");
		}
		resultStr.append(COMPART);
		return resultStr.toString();
	}
}
