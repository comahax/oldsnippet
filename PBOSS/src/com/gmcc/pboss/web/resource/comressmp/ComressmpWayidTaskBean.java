package com.gmcc.pboss.web.resource.comressmp;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.compack.CompackBO;
import com.gmcc.pboss.control.resource.compack.Compack;
import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class ComressmpWayidTaskBean extends BaseBatchTaskBean {

	public ComressmpWayidTaskBean() throws Exception{
		super.setBatchName("套卡批量调拨");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try{
			Compack packBO = (Compack)BOFactory.build(CompackBO.class, user);
			//商品批次、包号、新渠道编码
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			Serializable pkVO = new CompackVO();
			BeanUtils.setProperty(pkVO, "batchno", items[0]);
			BeanUtils.setProperty(pkVO, "boxnum", items[1]);
			CompackVO compackVO = packBO.doFindByPk(pkVO);
			//商品包是否存在
			if(compackVO==null){
				throw new Exception("商品包数据不存在|");
			}
			//状态是否“可售”或“待分配”
			if( !"1".equals(compackVO.getPackstate()) && !"30".equals(compackVO.getPackstate()) ){
				throw new Exception("商品包状态不正确|");
			}
			Way wayBO = (Way)BOFactory.build(WayBO.class, user);
			
			/*取消同一分公司的限制*/
			////根据商品包，获取其所属渠道
			//WayVO oldWay = wayBO.doFindByPk(compackVO.getWayid());
			////获取操作员所属渠道
			//WayVO operatorWayVO = wayBO.doFindByPk(user.getWayid());
			////判断商品包所属分公司与操作员所属渠道分公司是否相同
			//if(!oldWay.getCountyid().equals(operatorWayVO.getCountyid())){
			//	throw new Exception("商品包不属于该分公司管辖|");
			//}
			
			//根据新渠道编码，判定其是否存在且状态为“1”有效
			WayVO newWay = wayBO.doFindByPk(items[2]);
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
			
			//更新商品包中的所有套卡渠道信息wayid
			//更新商品包渠道信息wayid
			packBO.doUpdateComressmp(compackVO, items[2]);
			
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
