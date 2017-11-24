package com.sunrise.boss.ui.cms.reward.chadtimportrecord;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.reward.chadtimportrecord.ChadtimportrecordDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;
import com.sunrise.boss.business.cms.reward.chadtimportrecord.persistent.ChadtimportrecordVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;

public class ChAdtImportrecordTaskBean extends BaseBatchTaskBean {
	public ChAdtImportrecordTaskBean() throws Exception {
		super.setBatchName("地市办理业务导入数据");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}

	protected String doStart() {
		return "地市办理业务导入数据 \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		try {
			
			
			//1、判断渠道编码是否存在
//			WayDelegate waydelegate=new WayDelegate();
//			WayListVO wayListVO = new WayListVO();
//			wayListVO.set_se_wayid(content[0]);
//			wayListVO.set_ne_waystate(Short.valueOf("1"));
//			DataPackage waydp = waydelegate.doQuery(wayListVO, user);
//			if(waydp.getRowCount()==0){
//				throw new Exception("渠道编码不存在");
//				line = rowCount + "   " + line + "    错误信息:" + "渠道编码不存在";
//				resultVO.setInfo(line);
//				resultVO.setOk(false);
//				return resultVO;
//			}
			
//			Set<String> set = new HashSet<String>();
//			set.add("1");
//			set.add("2");
//			set.add("3");
//			if(!set.contains(content[4])){
//				throw new Exception("导入类型不存在");	
////				line = rowCount + "   " + line + "    错误信息:" + "导入类型不存在";
////				resultVO.setInfo(line);
////				resultVO.setOk(false);
////				return resultVO;
//			}
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			ChadtimportrecordVO vo =new ChadtimportrecordVO();
			vo.setWayid(content[0]);
			vo.setMobile(content[1]);
			vo.setOpnid(content[2]);
			if(!"".equals(content[3])){
				vo.setOprtime(new Date(format.parse(content[3]).getTime()));
			}
			vo.setImporttype(Long.parseLong(content[4]));
			vo.setOpercode(user.getOpercode());
			java.util.Date date = new java.util.Date();
			vo.setRuntime(date);
			if(!"".equals(content[5])){
				vo.setAmt(Double.parseDouble(content[5]));
			}
			if(!"".equals(content[6])){
				vo.setAssegrade(Double.parseDouble(content[6]));
			}
			vo.setRemark(content[7]);
			
			ChadtimportrecordDelegate adtImportrecordDelegate =new ChadtimportrecordDelegate();
			adtImportrecordDelegate.doCreate(vo, user);
			
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