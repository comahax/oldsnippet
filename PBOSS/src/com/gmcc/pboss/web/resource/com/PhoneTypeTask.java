package com.gmcc.pboss.web.resource.com;

import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.resource.numtyperule.NumtyperuleDBParam;
import com.gmcc.pboss.business.resource.numtyperule.NumtyperuleVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.resource.com.Com;
import com.gmcc.pboss.control.resource.com.ComBO;
import com.gmcc.pboss.control.resource.numtyperule.Numtyperule;
import com.gmcc.pboss.control.resource.numtyperule.NumtyperuleBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class PhoneTypeTask extends BaseBatchTaskBean{
	List<NumtyperuleVO> typeruleList = null;//号码规则表达式列表
	public PhoneTypeTask() throws Exception {
		super.setBatchName("号码类型识别");
	}
	
	
	
	@Override
	public void doProcessFile(String fileInPath, String fileOutPath)
			throws Exception {
		// TODO Auto-generated method stub

		Numtyperule numtyperuleBO = (Numtyperule)BOFactory.build(NumtyperuleBO.class,user);
		NumtyperuleDBParam dbParam = new NumtyperuleDBParam();
		dbParam.setDataOnly(true);
		dbParam.setQueryAll(true);
		typeruleList = numtyperuleBO.doGetNumtyperuleList(dbParam );	
		super.doProcessFile(fileInPath, fileOutPath);
	}



	@Override
	protected ResultVO processLine(String line, int rowCount) {
		// TODO Auto-generated method stub
//		调用号码分类逻辑（参照资源入库逻辑）获取号码类型，如果获取成功，
//		则将类型名称填入号码类型列，如果获取号码类型失败，则号码类型列填写“获取号码类型出错”。

		ResultVO resultVO = new ResultVO();
		try{
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			Numtyperule numtyperuleBO = (Numtyperule)BOFactory.build(NumtyperuleBO.class,user);
			Long typeID = numtyperuleBO.doMatchNumber(items[0], typeruleList);
			if(null == typeID)
				line += "获取号码类型出错";
			else
				line += Code2NameUtils.code2Name("#Numtypedef",typeID.toString(),user.getCityid());
			resultVO.setInfo(line);
			resultVO.setOk(true);
		}catch(Exception e){
			line += "获取号码类型出错";
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
