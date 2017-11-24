package com.gmcc.pboss.web.resource.emptysim;

import java.io.Serializable;
import org.apache.commons.lang.StringUtils;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.compack.CompackBO;
import com.gmcc.pboss.control.resource.compack.Compack;
import com.gmcc.pboss.control.resource.emptysim.Emptysim;
import com.gmcc.pboss.control.resource.emptysim.EmptysimBO;
import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.resource.emptysim.EmptysimDBParam;
import com.gmcc.pboss.business.resource.emptysim.EmptysimVO;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class EmptysimWayidTaskBean extends BaseBatchTaskBean {

	public EmptysimWayidTaskBean() throws Exception{
		super.setBatchName("空白SIM卡批量调拨");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try{ 
			//空卡序列号|商品标识|新渠道编码|
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			Emptysim emptySimBO = (Emptysim)BOFactory.build(EmptysimBO.class, user);
			
			//根据空白卡序列号和商品标识查询空白卡资源表（IM_FX_EMPTYSIM）
			EmptysimDBParam emptysimDBParam = new EmptysimDBParam();
			emptysimDBParam.set_ne_emptyno(Long.parseLong(items[0]));
			emptysimDBParam.set_ne_comid(Long.parseLong(items[1])); 
			DataPackage dp = emptySimBO.doQuery(emptysimDBParam);
			EmptysimVO  vo = null;
			if(dp.getDatas().size()==0){
				throw new Exception("空白卡数据不存在");
			}else {
				//对查询结果的状态进行判断，如果不是“可售--1”或“待分配--30”状态，填写出错原因“空白卡状态不正确”
			    vo = (EmptysimVO) dp.getDatas().get(0);
				if(vo.getUsestate() != 1 && vo.getUsestate() != 30) 
					throw new Exception("空白卡状态不正确");  
			} 
			//根据新渠道编码查询渠道表(CH_PW_WAY),如果无结果，则填写出错原因“新渠道数据不存在”
			Way wayBO = (WayBO)BOFactory.build(WayBO.class, user);
			WayVO wayVO = wayBO.doFindByPk(items[2]);
			if(null==wayVO){
				 throw new Exception("新渠道数据不存在");  
			}else{
				//对查询的新渠道信息结果的渠道状态[waystate]进行判断，如果渠道状态不为1有效，则填写错误原因“新渠道数据无效”，
				if( wayVO.getWaystate()!=1)
					 throw new Exception("新渠道数据无效");  
			} 
            //	 更新空白卡数据中的渠道标识为新渠道编码，同时登记空白卡日志表（IM_FX_EMPTYSIMLOG）。
			
			vo.setWayid(items[2]);
			emptySimBO.doUpdate(vo);
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
