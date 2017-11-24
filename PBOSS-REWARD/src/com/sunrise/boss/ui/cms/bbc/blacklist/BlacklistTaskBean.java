package com.sunrise.boss.ui.cms.bbc.blacklist;

import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.bbc.blacklist.persistent.BlacklistListVO;
import com.sunrise.boss.business.cms.bbc.blacklist.persistent.BlacklistVO;
import com.sunrise.boss.business.cms.nores.persistent.NoresListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.bbc.blacklist.BlacklistDelegate;
import com.sunrise.boss.delegate.cms.nores.NoresDelegate;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class BlacklistTaskBean extends BaseBatchTaskBean {

	public BlacklistTaskBean() throws Exception{
		super.setBatchName("数据业务黑名单设置");
		super.setWriteLog(true);
	}
	@Override
	protected String doStart() {
		// TODO Auto-generated method stub
		return "数据业务黑名单设置导入 \r\n";
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		
		try {
//			NoresDelegate noresDelegate=new NoresDelegate();
//			NoresListVO noresListVO=new NoresListVO();
//			noresListVO.set_se_mobileno(content[1]);
//			DataPackage dataPackage=noresDelegate.doQuery(noresListVO, user);
//			if(dataPackage.getRowCount()==0){
//				throw new Exception("您导入添加的号码有误");
//			}
			
			
			BlacklistDelegate bd=new BlacklistDelegate();
			BlacklistListVO listvo=new BlacklistListVO();
			listvo.set_se_mobile(content[1]);
			DataPackage dataPackage2=bd.doQuery(listvo, user);
			
			BlacklistVO vo=new BlacklistVO();
			vo.setName(content[0]);
			vo.setMobile(content[1]);
			vo.setFiltertype(content[2]);
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			vo.setStarttime(dateFormat.parse(content[3]));
			vo.setEndtime(dateFormat.parse(content[4]));
			
			if(dataPackage2!=null&&dataPackage2.getDatas().size()>0){
				bd.doUpdate(vo, user);
			}else{
				bd.doCreate(vo, user);
			}
			
			line = rowCount + "   " + line + "    操作成功";
			resultVO.setOk(true);
			resultVO.setInfo(line);
			return resultVO;
			
		} catch (Exception e) {
			line = rowCount + "   " + line + "    错误信息:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		
		return resultVO;
	}	
}
