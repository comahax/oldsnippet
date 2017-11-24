package com.gmcc.pboss.web.sales.order;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateDBParam;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateVO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDBParam;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.sales.comorder.Comorder;
import com.gmcc.pboss.control.sales.comorder.ComorderBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.ordercomcate.Ordercomcate;
import com.gmcc.pboss.control.sales.ordercomcate.OrdercomcateBO;
import com.gmcc.pboss.control.sales.orderresdet.Orderresdet;
import com.gmcc.pboss.control.sales.orderresdet.OrderresdetBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class OrderBatchAllocateTaskBean extends BaseBatchTaskBean{
	public OrderBatchAllocateTaskBean() throws Exception {
		super.setBatchName("订单批量数量调整"); 
		super.setOprtype("导入");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub

	}

	protected String doStart() {
		return "行号|订单编号|调整数据(商品种类#数量#备注)|处理结果|  \r\n";
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			String items[] = StringUtils.splitPreserveAllTokens(line, "\\|");
			Order order = (OrderBO) BOFactory.build(OrderBO.class, user);
			boolean result = order.doDealAllocateData(items);
			if (result) {
				//调整数据检查  
				Ordercomcate ordercomcate = (OrdercomcateBO) BOFactory.build(
						OrdercomcateBO.class, user);
				OrdercomcateDBParam ordercomcateDBParam = new OrdercomcateDBParam();
				ordercomcateDBParam.set_se_orderid(items[0]);
				String[] allocatedata = items[1].split("\\,");
				double recamt = 0d;
				OrderVO orderVo = null;
				for (int i = 0; i < allocatedata.length; i++) {
					String[] data = allocatedata[i].split("\\#");
					String meno = "";
					if (data.length == 3) {
						meno = data[2];
					}
					//更新订单商品种类信息 
					OrdercomcateDBParam ordercomcateDBParam2 = new OrdercomcateDBParam();
					ordercomcateDBParam2.set_se_comcategory(data[0]);
					ordercomcateDBParam2.set_se_orderid(items[0]);
					DataPackage dPackage = ordercomcate
							.doQuery(ordercomcateDBParam2);
					OrdercomcateVO vo = (OrdercomcateVO) dPackage.getDatas()
							.get(0); 
					ordercomcate.doAmtadjSave(vo.getRecid().toString(), data[1]
							.toString(), meno);
				} 
			}
			line = rowCount + "|"+line+"|" + "调整成功" + "|";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) {
			line = rowCount + "|" + line + "|" + "出错原因:" + e.getMessage() + "|";
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}

}
