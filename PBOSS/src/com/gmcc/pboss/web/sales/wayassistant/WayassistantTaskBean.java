package com.gmcc.pboss.web.sales.wayassistant;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderresdet.Orderresdet;
import com.gmcc.pboss.control.sales.orderresdet.OrderresdetBO;
import com.gmcc.pboss.control.sales.wayassistant.WayassistantBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class WayassistantTaskBean extends BaseBatchTaskBean{
	
	public WayassistantTaskBean() throws Exception {
			super.setBatchName("商品订购辅助信息导入");
	}


	@Override
	protected ResultVO processLine(String line, int rowCount) {
		// TODO Auto-generated method stub
		ResultVO resultVO = new ResultVO();
		try{
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			
			WayassistantVO wayassistantvo=new WayassistantVO();
			wayassistantvo.setWayid(items[0]);
			wayassistantvo.setCanorder(Short.parseShort(items[1]));
			wayassistantvo.setPrintinvoice(Short.parseShort(items[2]));
			wayassistantvo.setPaytype(items[3]);
			wayassistantvo.setDelitype(items[4]);
			wayassistantvo.setOrderbetterno(Short.parseShort(items[5]));
			
			
			WayassistantBO wayassistantbo=(WayassistantBO)BOFactory.build(WayassistantBO.class,user);
			WayassistantVO  wayassistant=wayassistantbo.doFindByPk(wayassistantvo.getWayid());
			if(wayassistant==null){
				wayassistantbo.doCreate(wayassistantvo);
			}
			else{
				wayassistantbo.doUpdate(wayassistantvo);
			}
			
			line = items[0]+"资料入库成功！";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		}catch(Exception e){
			e.printStackTrace();
			line = e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
			return resultVO;
	}


}
