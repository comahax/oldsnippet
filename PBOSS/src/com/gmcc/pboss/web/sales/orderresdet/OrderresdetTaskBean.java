package com.gmcc.pboss.web.sales.orderresdet;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderresdet.Orderresdet;
import com.gmcc.pboss.control.sales.orderresdet.OrderresdetBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class OrderresdetTaskBean extends BaseBatchTaskBean{
	
	public OrderresdetTaskBean() throws Exception {
			super.setBatchName("订单资源批量抽取");
	}
	
	@Override
	protected String doEnd() throws Exception {
		Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
		Serializable pkVO=new SysparamVO();
		BeanUtils.setProperty(pkVO, "systemid", "27");//系统标识
		BeanUtils.setProperty(pkVO, "paramtype", "pboss_fx");//参数类型
		SysparamVO vo=(SysparamVO) sysparamBO.doFindByPk(pkVO);
		vo.setParamvalue("0");
		sysparamBO.doUpdate(vo);
		return "";
	}


	@Override
	protected ResultVO processLine(String line, int rowCount) {
		// TODO Auto-generated method stub
		ResultVO resultVO = new ResultVO();
		try{
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
	
			Map<String,String> map=new HashMap<String,String>();
			map.put("resextratype", (String)parameterMap.get("resextratype"));
			map.put("fixsectNum", (String)parameterMap.get("fixsectNum"));
			map.put("cycsectNum", (String)parameterMap.get("cycsectNum"));		
			Orderresdet orderresdetBO=(Orderresdet)BOFactory.build(OrderresdetBO.class,user);//订单资源明细BO
			String returnMesg=orderresdetBO.doBatchResdraw(map, items[0]);//批量抽取
			if(!"订单资源抽取成功".equals(returnMesg))
				throw new Exception(items[0]+"|"+returnMesg+"|");
			//调用【订单下一步处理公用方法】，不判断处理结果；返回处理下一条订单。
			Order orderBO=(Order)BOFactory.build(OrderBO.class,user);
			orderBO.doNextProcess(items[0]);
			
			line = items[0]+"|订单资源抽取成功|";
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
