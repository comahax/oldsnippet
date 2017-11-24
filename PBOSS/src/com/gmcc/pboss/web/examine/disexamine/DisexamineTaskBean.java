package com.gmcc.pboss.web.examine.disexamine;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;  

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO; 
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.examine.disexamine.DisexamineBO; 
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;


public class DisexamineTaskBean extends BaseBatchTaskBean {

	 

	public DisexamineTaskBean() throws Exception {
		super.setBatchName("配送商考核管理导入");
		super.setOprtype("导入");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub

	}

	protected String doStart() {
		return "序号|配送商|考核周期|扣罚金额|说明|错误信息  \r\n";
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		// TODO Auto-generated method stub
		// String loginwayid = user.getWayid();
		ResultVO resultVO = new ResultVO();
		try {
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			DisexamineBO disexamineBo = (DisexamineBO) BOFactory.build(DisexamineBO.class, user);
			//配送商信息检查
			Way way = (WayBO) BOFactory.build(WayBO.class, user);
			WayVO wayVO = way.doFindByPk(items[0].trim());
			if (wayVO == null ){
				throw  new Exception(items[0].trim()+"配送商不存在");
			}
			//考核周期检查
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy");
			String year = items[1].trim().substring(0,4);
			String month = items[1].trim().substring(4);
			if ( !format.format(date).equals(year) || date.getMonth()+1!=Integer.parseInt(month) ) {
				throw new Exception(items[1].trim()+"考核周期不为本月");
			}
			
		    disexamineBo.doDisexamineImport(items);  
			line = rowCount
					+ "|"
					+ Code2NameUtils.code2Name("#WAYIDINFO",items[0].trim(), user.getCityid()) 
					+ "|"+items[1].trim()+ "|"+items[2]+"|"+items[3].trim()+ "|"+"操作成功";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) { 
			line = rowCount + "|" + line + "|" +"操作失败:"+ e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}

}
