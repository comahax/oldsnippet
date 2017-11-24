package com.gmcc.pboss.web.sales.order;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.sales.audit.AuditDBParam;
import com.gmcc.pboss.business.sales.audit.AuditVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderproce.OrderproceDBParam;
import com.gmcc.pboss.business.sales.orderproce.OrderproceVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.sales.audit.Audit;
import com.gmcc.pboss.control.sales.audit.AuditBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderproce.Orderproce;
import com.gmcc.pboss.control.sales.orderproce.OrderproceBO;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class OrderAuditTaskBean extends BaseBatchTaskBean {

	public OrderAuditTaskBean() throws Exception {
		super.setBatchName("订单批量审核");
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String itemStr = "";
		try {
			// 订单信息检查：根据订单编号查询订单表（FX_SW_ORDER），如果无数据则填写出错原因“订单不存在”，返回处理下一条记录；否则继续下一步。
			Order bo = (Order) BOFactory.build(OrderBO.class, user);
			OrderVO orderVO = bo.doFindByPk(line);
			if (null == orderVO)
				throw new Exception("订单[" + line + "]不存在");

			// 根据订单流程编号和出口状态（已审核）查询订单流程步骤表（FX_RU_ORDERPROCE），如果入口状态不等于当前订单状态则填写处理结果“订单[XXX]状态不正确”
			// （其中XXX为订单编号）
			Orderproce orderproceBO = (OrderproceBO) BOFactory.build(OrderproceBO.class, user);
			OrderproceDBParam orderproceParam = new OrderproceDBParam();
			orderproceParam.set_ne_flowid(orderVO.getFlowid().toString());
			orderproceParam.set_se_outstate("AUDITED");
			DataPackage dp = orderproceBO.doQuery(orderproceParam);

			if (null == dp || null == dp.getDatas() || dp.getDatas().size() == 0 || orderVO.getOrderstate() == null
					|| !orderVO.getOrderstate().equalsIgnoreCase(((OrderproceVO) dp.getDatas().get(0)).getInstate())) {
				throw new Exception("订单[" + line + "]状态不正确");
			}

			// 待审批记录检查：根据订单编号查询订单审核（FX_SW_AUDIT），如果存在记录且审核状态不等于1则填写处理结果“订单[XXX]未审批通过”
			// （其中XXX为订单编号），返回处理下一条记录；否则继续下一步
			Audit auditBO = (Audit) BOFactory.build(AuditBO.class, user);
			AuditDBParam auditDBParam = new AuditDBParam();
			auditDBParam.set_se_orderid(line);
			auditDBParam.set_orderby("smsntime");
			auditDBParam.set_desc("1");
			DataPackage auditDP = auditBO.doGetAuditInfo(auditDBParam);
			
			if (auditDP != null) {
				List<AuditVO> auditlist = auditDP.getDatas();
				if(!auditlist.isEmpty()){
					for(AuditVO auditVO:auditlist){
						if(!"1".equals(auditVO.getState())){
							throw new Exception("订单[" + line + "]未审批通过");
						}
						break;//这里只需要判断第一条数据，根据时间排序
					}
				}
			}
			orderVO.setOrderstate("AUDITED");
			orderVO.setStatechgtime(new Date());
			bo.doUpdate(orderVO);//更新订单状态为已审核
			bo.doNextProcess(line);// 调用【订单下一步处理公用方法】，不判断处理结果
			itemStr = rowCount + "|" + line + "|处理成功|";
			resultVO.setInfo(itemStr);
			resultVO.setOk(true);
		} catch (Exception e) {
			e.printStackTrace();
			if (!(e instanceof BusinessException)) {
				if (e.getCause() != null && e.getCause().getMessage() != null){
					itemStr = rowCount + "|" + (StringUtils.isNotBlank(line) ? line : "") + "|" + e.getCause().getMessage() + "|";
				}else{
					itemStr = rowCount + "|" + (StringUtils.isNotBlank(line) ? line : "") + "|" + e.getMessage() + "|";
				}		
				resultVO.setInfo(itemStr);
				resultVO.setOk(false);
			} else {
				itemStr = rowCount + "|" + line + "|处理成功|" + e.getMessage();
				resultVO.setInfo(itemStr);
				resultVO.setOk(true);
			}
		}
		return resultVO;
	}
}
