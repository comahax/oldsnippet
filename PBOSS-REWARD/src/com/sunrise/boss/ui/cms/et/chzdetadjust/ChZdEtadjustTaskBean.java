package com.sunrise.boss.ui.cms.et.chzdetadjust;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.chzdplatforminfo.persistent.ChZdPlatforminfoListVO;
import com.sunrise.boss.business.cms.et.chzdetadjust.persistent.ChZdEtadjustListVO;
import com.sunrise.boss.business.cms.et.chzdetadjust.persistent.ChZdEtadjustVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.chzdplatforminfo.ChZdPlatforminfoDelegate;
import com.sunrise.boss.delegate.cms.et.chzdetadjust.ChZdEtadjustDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class ChZdEtadjustTaskBean extends BaseBatchTaskBean {
	public ChZdEtadjustTaskBean() throws Exception {
		super.setBatchName("多平台终端贷款结算报表差异管理导入");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}

	protected String doStart() {
		return "多平台终端贷款结算报表差异管理导入 \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		try {
			
			//判断渠道是否存在，且是否为自营渠道			
			WayDelegate waydelegate=new WayDelegate();
			WayListVO wayListVO = new WayListVO();
			wayListVO.set_se_wayid(content[0]);
			//wayListVO.set_ne_waystate(Short.valueOf("1"));
			wayListVO.set_se_waytype("ET");
			//wayListVO.set_se_waysubtype("ZJTY");
			DataPackage waydp = waydelegate.doQuery(wayListVO, user);
			if(waydp.getRowCount()==0){
				throw new Exception("非自有渠道");
			}
			
			//判断平台商是否存在			
			ChZdPlatforminfoDelegate chzdplatforminfodelegate = new ChZdPlatforminfoDelegate();
	    	ChZdPlatforminfoListVO chzdplatforminfolistvo1 = new ChZdPlatforminfoListVO();
	    	chzdplatforminfolistvo1.set_se_zdplatform(content[1]);
			DataPackage zdplatformdb = chzdplatforminfodelegate.doQuery(chzdplatforminfolistvo1, user); 
			if(zdplatformdb.getRowCount()==0){
				throw new Exception("非正常平台商");
			}
			ChZdPlatforminfoListVO chzdplatforminfolistvo2 = new ChZdPlatforminfoListVO();
	    	chzdplatforminfolistvo2.set_se_producttype(content[2]);
			DataPackage producttypedb = chzdplatforminfodelegate.doQuery(chzdplatforminfolistvo2, user); 
			if(producttypedb.getRowCount()==0){
				throw new Exception("非正常终端型号");
			}
			
//			判断映射类型类型包括
//			1，HAPPYONLINE---欢乐在线 
//			2，XINXIJITAOKA---信息机套卡
//			3，CHANGEPLAN---套餐变更  
//			4，NEWUSER---全球通放号     
//			5，G3NETBOOK---G3上网本 
//			Set<String> set = new HashSet<String>();
//			set.add("HAPPYONLINE");
//			set.add("XINXIJITAOKA");
//			set.add("CHANGEPLAN");
//			set.add("NEWUSER");
//			set.add("G3NETBOOK");
//			if(!set.contains(content[2])){
//				throw new Exception("映射类型不存在");	
//
//			}
			
			ChZdEtadjustDelegate chzdetadjustDelegate=new ChZdEtadjustDelegate();
			ChZdEtadjustListVO listvo=new ChZdEtadjustListVO();
			listvo.set_se_wayid(content[0]);
			listvo.set_se_platform(content[1]);
			listvo.set_se_producttype(content[2]);
			listvo.set_se_batchno(content[4]);
			DataPackage dp=chzdetadjustDelegate.doQuery(listvo, user);
			if(dp!=null&&dp.getDatas().size()>0){				
				ChZdEtadjustVO chzdetadjustVO=new ChZdEtadjustVO();
//				assessVO.setSeq(((AssessVO)(dp.getDatas().iterator().next())).getSeq());
				chzdetadjustVO.setSeq(((ChZdEtadjustVO)(dp.getDatas().iterator().next())).getSeq());
				chzdetadjustVO.setWayid(content[0]);
				chzdetadjustVO.setPlatform(content[1]);
				chzdetadjustVO.setProducttype(content[2]);
				chzdetadjustVO.setMoney(new Double(content[3]));
				chzdetadjustVO.setBatchno(content[4]);				
				if(content[5]!=null && content[5].length()>0){
					chzdetadjustVO.setNote(content[5]);
				}
				chzdetadjustDelegate.doUpdate(chzdetadjustVO, user);
			}
			else{
				ChZdEtadjustVO chzdetadjustVO=new ChZdEtadjustVO();
				chzdetadjustVO.setWayid(content[0]);
				chzdetadjustVO.setPlatform(content[1]);
				chzdetadjustVO.setProducttype(content[2]);
				chzdetadjustVO.setMoney(new Double(content[3]));
				chzdetadjustVO.setBatchno(content[4]);				
				if(content[5]!=null && content[5].length()>0){
					chzdetadjustVO.setNote(content[5]);
				}
				chzdetadjustDelegate.doCreate(chzdetadjustVO, user);
			}
			
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