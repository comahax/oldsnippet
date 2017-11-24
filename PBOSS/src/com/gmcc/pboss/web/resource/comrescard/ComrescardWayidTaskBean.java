package com.gmcc.pboss.web.resource.comrescard;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.comrescard.Comrescard;
import com.gmcc.pboss.control.resource.comrescard.ComrescardBO;
import com.gmcc.pboss.business.resource.comrescard.ComrescardVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.common.utils.bean.BeanUtils;


public class ComrescardWayidTaskBean extends BaseBatchTaskBean{
	
	public ComrescardWayidTaskBean() throws Exception{
		super.setBatchName("充值卡批量调拨");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try{
			Comrescard  bo = (Comrescard)BOFactory.build(ComrescardBO.class, user);
			//商品资源编码、商品标识、新渠道编码
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			Serializable pkVO = new ComrescardVO();
			BeanUtils.setProperty(pkVO, "comresid", items[0]);
			BeanUtils.setProperty(pkVO, "comid", items[1]);
			ComrescardVO comrescardVO = bo.doFindByPk(pkVO);
			//检查充值卡记录是否存在
			if(comrescardVO==null){
				throw new Exception("充值卡数据不存在|");
			}
			//检查充值卡状态是否“可售”“待分配”
			if(comrescardVO.getComstate()!=1 && comrescardVO.getComstate()!=30){//不可售且不可分配
				throw new Exception("充值卡状态不正确|");
			}
			Way wayBO = (Way)BOFactory.build(WayBO.class, user);
			
			/*取消同一分公司的限制*/
			////根据充值卡查询记录，获取其所属渠道
			//WayVO oldWay = wayBO.doFindByPk(comrescardVO.getWayid());
			////获取操作员所属渠道
			//WayVO operatorWayVO = wayBO.doFindByPk(user.getWayid());
		    ////判断充值卡所属分公司与操作员所属渠道分公司是否相同
			//if(!oldWay.getCountyid().equals(operatorWayVO.getCountyid())){
			//	throw new Exception("充值卡不属于该分公司管辖|");
			//}
			
			//根据新渠道编码获取渠道记录
			WayVO newWay = wayBO.doFindByPk(items[2]);
			//检查新渠道是否存在，状态是否为“1”有效
			if(newWay==null){
				throw new Exception("新渠道数据不存在|");
			}
			if(newWay.getWaystate()!=1){
				throw new Exception("新渠道数据无效|");
			}
			
			/*取消同一分公司的限制*/
			////检查新渠道所属分公司是否与操作员所属分公司一致，否则不归其管辖
			//if(!operatorWayVO.getCountyid().equals(newWay.getCountyid())){
			//	throw new Exception("新渠道不属于该分公司管辖|");
			//}
			
			comrescardVO.setWayid(items[2]);
			bo.doUpdate(comrescardVO);
			line=rowCount+"|"+line+"|";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		}catch(Exception e){
			line = rowCount+"|"+line+e.getMessage();
			e.printStackTrace();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}

}
