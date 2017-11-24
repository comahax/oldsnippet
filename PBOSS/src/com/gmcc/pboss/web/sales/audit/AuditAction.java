/**
 * auto-generated code
 * Wed Jul 28 15:30:49 CST 2010
 */
 package com.gmcc.pboss.web.sales.audit;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.base.operator.OperatorDBParam;
import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.business.sales.audit.AuditDBParam;
import com.gmcc.pboss.business.sales.audit.AuditVO;
import com.gmcc.pboss.business.sales.auditdet.AuditdetDBParam;
import com.gmcc.pboss.business.sales.auditdet.AuditdetVO;
import com.gmcc.pboss.business.sales.order.OrderDBParam;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.order.StockInfoVO;
import com.gmcc.pboss.business.sales.orderproce.OrderproceDBParam;
import com.gmcc.pboss.business.sales.orderproce.OrderproceVO;
import com.gmcc.pboss.control.base.operator.Operator;
import com.gmcc.pboss.control.base.operator.OperatorBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.sales.audit.Audit;
import com.gmcc.pboss.control.sales.audit.AuditBO;
import com.gmcc.pboss.control.sales.auditdet.Auditdet;
import com.gmcc.pboss.control.sales.auditdet.AuditdetBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderproce.Orderproce;
import com.gmcc.pboss.control.sales.orderproce.OrderproceBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: AuditAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class AuditAction extends BaseAction{
	
	public AuditAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new AuditForm());
		this.setParam(new AuditDBParam());

        //指定VO类
        setClsVO(AuditVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Audit.class);
		this.setClsQueryParam(AuditDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	@Override
	public String doList() throws Exception {
		AuditDBParam param=(AuditDBParam)super.getParam();
		if(param.get_orderby()==null || "".equals(param.get_orderby())){
			param.set_orderby("seqid");
			param.set_desc("1");
		}
		param.set_pagesize("20");
		if("true".equals(super.getRequest().getParameter("backFlag"))){
			param.set_pageno("1");
		}
		//默认按当天的起始时间查询
		if(null == param.get_dnl_smsntime() )
			param.set_dnl_smsntime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 00:00:00");
		if(null == param.get_dnm_smsntime() )
			param.set_dnm_smsntime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 23:59:59");
		super.setParam(param);
		Audit auditbo = (Audit)BOFactory.build(AuditBO.class, getDBAccessUser());
		DataPackage dp = auditbo.doDefaultQuery(param);
		setDp(dp);
		
		AuditForm form = (AuditForm)super.getForm();
		form.setOpercode(getDBAccessUser().getOprcode());
		super.setForm(form);
		
		return "list";
	}

	/**
	 * 提交审核验证
	 * @return
	 */
	public String doCheckAudit() {
		try{
			String selectitems=ServletActionContext.getRequest().getParameter("selectitems");
			String[] pks =selectitems.split("\\|");
			Order orderBO = (OrderBO) BOFactory.build(OrderBO.class,super.getDBAccessUser());
			Orderproce orderproceBO = (Orderproce)BOFactory.build(OrderproceBO.class,getDBAccessUser());
			OrderproceDBParam orderproceDBParam=new OrderproceDBParam();
			Audit auditBO = (Audit)BOFactory.build(AuditBO.class,getDBAccessUser());
			AuditDBParam auditDBParam=new AuditDBParam();
			
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			PrintWriter out= ServletActionContext.getResponse().getWriter();
			for(String orderid:pks){
				//验证提交记录集中存在“下一步处理”状态非审核记录
				OrderVO vo = orderBO.doFindByPk(orderid);
				orderproceDBParam.set_ne_flowid(String.valueOf(vo.getFlowid()));
				orderproceDBParam.set_se_instate(vo.getOrderstate());
				DataPackage data=orderproceBO.doQuery(orderproceDBParam);
				List<OrderproceVO> list=data.getDatas();
				String outstate=null;
				for(OrderproceVO obj:list){
					outstate=obj.getOutstate();
					break;
				}
				if(!"AUDITED".equals(outstate)){
					out.write("订单["+orderid+"]状态错误，不允许提交审核");
					return null;
				}
					
				//验证“订单审核[FX_SW_AUDIT]”表中已存在“待审核”状态的记录
				auditDBParam.set_se_orderid(orderid);
				auditDBParam.set_se_state("0");
				/*DataPackage dp=auditBO.doQuery(auditDBParam);*/
				DataPackage dp=auditBO.doGetAuditInfo(auditDBParam);
				if(dp!=null && dp.getDatas().size()!=0){
					out.write("订单["+orderid+"]存在待审核记录，不允许提交审核");
					return null;
				}
			 }
			out.write("yes");
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 审核
	 * @return
	 */
	public String doAudit() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String seqid=request.getParameter("seqid");
		String state=request.getParameter("state");
		String opinion=request.getParameter("opinion");
		Audit auditBO = (Audit)BOFactory.build(AuditBO.class,getDBAccessUser());
		AuditVO vo=auditBO.doFindByPk(Long.valueOf(seqid));
		vo.setState(state);//状态
		vo.setOpinion(opinion);//审核意见
		vo.setAudittime(new Date());//审核时间为当前时间
		auditBO.doUpdate(vo);
		setActionMessage("审核成功!");
		return doList();
		
	}
	/**
	 * 批量审核
	 * @return
	 */
	public String doBatchAudit() throws Exception{
		String[] selectItem = super.getParam().get_selectitem();
		String[] seqids = new String[selectItem.length];
		for(int i=selectItem.length-1; i>=0;i--){
			seqids[i] = selectItem[i].split("\\|")[0];
		}
		HttpServletRequest request=ServletActionContext.getRequest();
		String state=request.getParameter("state");
		String opinion=request.getParameter("opinion");
		Audit auditBO = (Audit)BOFactory.build(AuditBO.class,getDBAccessUser());
		auditBO.doBatchAudit(seqids, state, opinion);
		setActionMessage("批量审核成功!");
		return doList();
	}
	/**
	 * 提交--多级审核
	 * @return
	 */
	public String doSubmit() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String operid=request.getParameter("operid");//上级审核人
		String seqid=request.getParameter("seqid");
		String memo=request.getParameter("memo");
		Audit auditBO = (Audit)BOFactory.build(AuditBO.class,getDBAccessUser());
		//取得订单号的集合
		Auditdet auditdet = (Auditdet)BOFactory.build(AuditdetBO.class,getDBAccessUser());
		AuditdetDBParam adparam = new AuditdetDBParam();
		adparam.set_ne_auditseq(seqid);
		DataPackage auditdetdp = auditdet.doQuery(adparam);
		int i = auditdetdp.getDatas().size();
		String[] orderids = new String[i];
		Iterator it = auditdetdp.getDatas().iterator();
		for (int k=0; k<auditdetdp.getDatas().size();k++) {
			AuditdetVO tempauditvo = (AuditdetVO)it.next();
			orderids[k] = tempauditvo.getOrderid();
		}
		
		auditBO.doBatchSubmitAudit2(orderids, operid,memo);
		setActionMessage("提交成功!");
		return doList();
	}
	/**
	 * 批量提交
	 * @return
	 */
	public String doBatchSubmit() throws Exception{
		String[] selectItem = super.getParam().get_selectitem();
		String[] orderids = new String[selectItem.length];
		for(int i=selectItem.length-1; i>=0;i--){
			orderids[i] = selectItem[i].split("\\|")[1];
		}
		HttpServletRequest request=ServletActionContext.getRequest();
		String operid=request.getParameter("operid");
		Audit auditBO = (Audit)BOFactory.build(AuditBO.class,getDBAccessUser());
		auditBO.doBatchSubmitAudit(orderids, operid);
		setActionMessage("批量提交成功!");
		return doList();
	}
	/**
	 * 订单多级审核--跳转至审核页面
	 * @return
	 */
	public String doShowAuditPage() throws Exception{
		try {
			HttpServletRequest request=ServletActionContext.getRequest();
			String seqid=request.getParameter("seqid");
			AuditForm auditform = (AuditForm)super.getForm();
			Audit auditBO = (Audit)BOFactory.build(AuditBO.class,getDBAccessUser());
			AuditVO auditvo = auditBO.doFindByPk(Long.valueOf(seqid));
			BeanUtils.copyProperties(auditform, auditvo);
			
			//获取分配量数据区域
			Order order = (Order)BOFactory.build(OrderBO.class,getDBAccessUser());
			Auditdet auditdet = (Auditdet)BOFactory.build(AuditdetBO.class,getDBAccessUser());
			AuditdetDBParam adparam = new AuditdetDBParam();
			adparam.set_ne_auditseq(seqid);
			adparam.set_pagesize("0");
			DataPackage auditdetdp = auditdet.doQuery(adparam);
			int i = auditdetdp.getDatas().size();
			String[] orderids = new String[i];
			Iterator it = auditdetdp.getDatas().iterator();
			for (int k=0; k<auditdetdp.getDatas().size();k++) {
				AuditdetVO tempauditvo = (AuditdetVO)it.next();
				orderids[k] = tempauditvo.getOrderid();
			}
			Map<Object,Object> map = order.doFindStockInfo(orderids);
			DataPackage stockinfodp=(DataPackage)map.get("DP");
			List<StockInfoVO>  stockInfoList = stockinfodp.getDatas();
			auditform.setStockInfoList(stockInfoList);
			
			//将对应的订单信息进行展示
			List<String> orderidList = Arrays.asList(orderids);
			AuditDBParam adparam2 = (AuditDBParam)getParam();
			OrderDBParam orparam = new OrderDBParam();
			orparam.set_pageno(super.getParam().get_pageno());
			orparam.set_pagesize("10");
			orparam.set_sin_orderid(new ArrayList<String>(orderidList));
			
			// 设定分页信息
			adparam2.set_pageno(orparam.get_pageno());
			adparam2.set_pagesize(orparam.get_pagesize());
			
			DataPackage orderdp = order.doListForAudit(orparam);
			super.setDp(orderdp);
			
			//确认按钮是否可用
			if ((!auditvo.getAuditor().equals(getDBAccessUser().getOprcode())) || "1".equals(auditvo.getState())){
				auditform.setButtonflag("disable");
			}else{
				auditform.setButtonflag("able");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			setActionMessage(ex.getMessage());
		}
		return "audit";
	}
	
	/**
	 * 上级审核人弹出框
	 * @return
	 * @throws Exception
	 */
	public String selectUpper()throws Exception{
		String seqid = getRequest().getParameter("seqid");
		
		return "selectupper";
	}
	
}