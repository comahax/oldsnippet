/**
 * auto-generated code
 * Wed Jul 28 15:30:49 CST 2010
 */
package com.gmcc.pboss.control.sales.audit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.operator.OperatorVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.sales.audit.AuditDAO;
import com.gmcc.pboss.business.sales.audit.AuditDBParam;
import com.gmcc.pboss.business.sales.audit.AuditVO;
import com.gmcc.pboss.business.sales.auditdet.AuditdetVO;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateDBParam;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateVO;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmVO;
import com.gmcc.pboss.control.base.operator.Operator;
import com.gmcc.pboss.control.base.operator.OperatorBO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.sales.auditdet.Auditdet;
import com.gmcc.pboss.control.sales.auditdet.AuditdetBO;
import com.gmcc.pboss.control.sales.ordercomcate.Ordercomcate;
import com.gmcc.pboss.control.sales.ordercomcate.OrdercomcateBO;
import com.gmcc.pboss.control.sales.smsconfirm.Smsconfirm;
import com.gmcc.pboss.control.sales.smsconfirm.SmsconfirmBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: AuditBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class AuditBO extends AbstractControlBean implements
		Audit {

	public AuditVO doCreate(AuditVO vo) throws Exception {
		try {
			AuditDAO dao = (AuditDAO) DAOFactory.build(AuditDAO.class, user);
			// TODO set the pk */
			return (AuditVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(AuditVO vo) throws Exception {
		try {
			AuditDAO dao = (AuditDAO) DAOFactory.build(AuditDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			AuditDAO dao = (AuditDAO) DAOFactory.build(AuditDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AuditVO doUpdate(AuditVO vo) throws Exception {
		try {
			AuditDAO dao = (AuditDAO) DAOFactory.build(AuditDAO.class,user);
			return (AuditVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AuditVO doFindByPk(Serializable pk) throws Exception {
		AuditDAO dao = (AuditDAO) DAOFactory.build(AuditDAO.class,user);
		return (AuditVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(AuditDBParam params)
			throws Exception {
		AuditDAO dao = (AuditDAO) DAOFactory.build(AuditDAO.class,user);
		return dao.query(params);
	}
	/**
	 * 批量提交审核
	 */
	public void doBatchSubmitAudit(String[] orderids, String auditor)
			throws Exception {
		try {
			Audit auditBO = (Audit) BOFactory.build(AuditBO.class,user);
			AuditDAO dao = (AuditDAO) DAOFactory.build(AuditDAO.class, user);
			//在“订单审核[FX_SW_AUDIT]”表中新增订单待审批记录
			AuditVO auditVO=new AuditVO();
			auditVO.setSeqid(this.doGetAuditSeqId(new Date()));//序号[SEQID]”为当前日期+库表序列
			auditVO.setAuditor(auditor);//审核人工号
			//auditVO.setOrderid(orderid);//订单ID
			auditVO.setSmsntime(new Date());//当前时间
			auditVO.setState("0");//待审批[0]
			auditVO.setPresenter(user.getOprcode());//提交人为当前工号
			auditBO.doCreate(auditVO);
			Auditdet auditdetBO = (Auditdet) BOFactory.build(AuditdetBO.class,user);
			
			String orderidss="";
			AuditdetVO auditdetVO=null;
			for(String orderid:orderids){
				if("".equals(orderidss)) orderidss=orderid;
				else orderidss+="/"+orderid;
				
				auditdetVO=new AuditdetVO();
				auditdetVO.setRecid((Long)dao.getSequence("FX_SW_AUDITDET_SEQ"));
				auditdetVO.setOrderid(orderid);
				auditdetVO.setAuditseq(auditVO.getSeqid());
				auditdetBO.doCreate(auditdetVO);
			}
			
			
			//在“订单审核[FX_SW_AUDITDET]”表中新增记录
			
			//批量发送短信
			Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
			String sysparamvalue=sysparamBO.doFindByID("52", "pboss_fx");
			if(!StringUtils.isEmpty(sysparamvalue)&& "1".equals(sysparamvalue)){//插入短信待发送表
				String sysparamvalue42=sysparamBO.doFindByID("42", "pboss_fx");
				if(!StringUtils.isEmpty(sysparamvalue42)){
					Operator operatorBO = (Operator) BOFactory.build(OperatorBO.class, user);
					OperatorVO operatorVO=operatorBO.doFindByPk(auditor);//获取审核人信息
					if(operatorVO.getContactphone()!=null && !"".equals(operatorVO.getContactphone())){
						Waitreq waitreqBO = (Waitreq) BOFactory.build(WaitreqBO.class,user);
						Smstmpl smstmplBO = (Smstmpl) BOFactory.build(SmstmplBO.class, user);
						Map<String,String> keyAndValue=new HashMap<String,String>();
						keyAndValue.put("ORDERIDS", orderidss);//订单编码
						OperatorVO presenterVO=operatorBO.doFindByPk(user.getOprcode());
						keyAndValue.put("PRESENTER", presenterVO.getOpername());//提交人
						keyAndValue.put("ORDERAMOUNT", String.valueOf(orderids.length));//订单数量
						keyAndValue.put("COMDESC", getComdesc(orderids));//订单商品描述
						String seq=auditVO.getSeqid().toString();
						keyAndValue.put("STREAM", seq.substring(seq.length()-4, seq.length()));//流水号
						String content=smstmplBO.doGenSMS("FX_ORDER_AADVICE_BATCH", keyAndValue);//获取模板信息
						if(content!=null && !"".equals(content)){
							waitreqBO.doInsert2((short)3, content,sysparamvalue42, operatorVO.getContactphone());//插入待发送表
							//新增数据到分销短信确认表（FX_SW_SMSCONFIRM），编号取库表序列，类型取审核确认（AUDITCON），确认流水号取审核序号末尾4位，
							//手机号码取“接收手机号码”，关联订单号取审核序号，状态取待回复，通知时间取当前时间，回复时间和回复描述留空。
							Smsconfirm smsconfirmBO = (Smsconfirm) BOFactory.build(SmsconfirmBO.class, user);
							SmsconfirmVO smsconfirmVO=new SmsconfirmVO();
							smsconfirmVO.setType("AUDITCON");
							smsconfirmVO.setStream(seq.substring(seq.length()-4, seq.length()));
							smsconfirmVO.setMobileno( operatorVO.getContactphone());
							smsconfirmVO.setOrderid(seq);
							smsconfirmVO.setState("WAITREP");
							smsconfirmVO.setSendtime(new Date());
							smsconfirmBO.doCreate(smsconfirmVO);
						}
					}
				}
			}
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
		
	}
	/**
	 * 获取订单编号(序号[SEQID]”为当前日期+库表序列)
	 */
	public Long doGetAuditSeqId(Date date) throws Exception {
		// TODO Auto-generated method stub
		try {
			AuditDAO dao = (AuditDAO) DAOFactory.build(AuditDAO.class, user);
			String datestr = PublicUtils.formatUtilDate(date, "yyyyMMdd");

			String sequence = dao.getSequence(
					"FX_SW_AUDIT_SEQ").toString();
			return Long.valueOf(datestr + sequence);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}
	/**
	 * 提交审核
	 * @param orderid
	 * @param auditor
	 * @throws Exception
	 */
	public void doSubmitAudit(String orderid, String auditor,boolean isSingle)throws Exception {
		try {
			Audit auditBO = (Audit) BOFactory.build(AuditBO.class,user);
			AuditDAO dao = (AuditDAO) DAOFactory.build(AuditDAO.class, user);
			//在“订单审核[FX_SW_AUDIT]”表中新增订单待审批记录
			AuditVO auditVO=new AuditVO();
			auditVO.setSeqid(this.doGetAuditSeqId(new Date()));//序号[SEQID]”为当前日期+库表序列
			auditVO.setAuditor(auditor);//审核人工号
			//auditVO.setOrderid(orderid);//订单ID
			auditVO.setSmsntime(new Date());//当前时间
			auditVO.setState("0");//待审批[0]
			auditVO.setPresenter(user.getOprcode());//提交人为当前工号
			auditBO.doCreate(auditVO);
			Auditdet auditdetBO = (Auditdet) BOFactory.build(AuditdetBO.class,user);
			
			//在“订单审核[FX_SW_AUDITDET]”表中新增记录
			AuditdetVO auditdetVO=new AuditdetVO();
			auditdetVO.setRecid((Long)dao.getSequence("FX_SW_AUDITDET_SEQ"));
			auditdetVO.setOrderid(orderid);
			auditdetVO.setAuditseq(auditVO.getSeqid());
			auditdetBO.doCreate(auditdetVO);
			
			Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
			String sysparamvalue=sysparamBO.doFindByID("52", "pboss_fx");
			if(!StringUtils.isEmpty(sysparamvalue)&& "1".equals(sysparamvalue) && isSingle){//插入短信待发送表
				String sysparamvalue42=sysparamBO.doFindByID("42", "pboss_fx");
				if(!StringUtils.isEmpty(sysparamvalue42)){
					Operator operatorBO = (Operator) BOFactory.build(OperatorBO.class, user);
					OperatorVO operatorVO=operatorBO.doFindByPk(auditor);//获取审核人信息
					if(operatorVO.getContactphone()!=null && !"".equals(operatorVO.getContactphone())){
						Waitreq waitreqBO = (Waitreq) BOFactory.build(WaitreqBO.class,user);
						Smstmpl smstmplBO = (Smstmpl) BOFactory.build(SmstmplBO.class, user);
						
						Map<String,String> keyAndValue=new HashMap<String,String>();
						keyAndValue.put("ORDERID", orderid);//订单编码
						OperatorVO presenterVO=operatorBO.doFindByPk(user.getOprcode());
						keyAndValue.put("PRESENTER", presenterVO.getOpername());//提交人
						String[] orderids={orderid};
						keyAndValue.put("COMDESC", getComdesc(orderids));//订单商品描述
						
						String seq=auditVO.getSeqid().toString();
						keyAndValue.put("STREAM", seq.substring(seq.length()-4, seq.length()));//流水号
						
						String content=smstmplBO.doGenSMS("FX_ORDER_AADVICE_SINGLE", keyAndValue);//获取模板信息
						if(content!=null && !"".equals(content)){
							waitreqBO.doInsert2((short)3, content,sysparamvalue42, operatorVO.getContactphone());//插入待发送表
							//新增数据到分销短信确认表（FX_SW_SMSCONFIRM），编号取库表序列，类型取审核确认（AUDITCON），确认流水号取审核序号末尾4位，
							//手机号码取“接收手机号码”，关联订单号取审核序号，状态取待回复，通知时间取当前时间，回复时间和回复描述留空。
							Smsconfirm smsconfirmBO = (Smsconfirm) BOFactory.build(SmsconfirmBO.class, user);
							SmsconfirmVO smsconfirmVO=new SmsconfirmVO();
							smsconfirmVO.setType("AUDITCON");
							smsconfirmVO.setStream(seq.substring(seq.length()-4, seq.length()));
							smsconfirmVO.setMobileno( operatorVO.getContactphone());
							smsconfirmVO.setOrderid(seq);
							smsconfirmVO.setState("WAITREP");
							smsconfirmVO.setSendtime(new Date());
							smsconfirmBO.doCreate(smsconfirmVO);
						}
						
					}
				}
			}
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}
	 public void doBatchAudit(String[] seqids,String state,String opinion)throws Exception {
		 try {
			Audit auditBO = (Audit) BOFactory.build(AuditBO.class,user);
			 AuditVO vo=null;
			 for(String seqid:seqids){
				vo=auditBO.doFindByPk(Long.valueOf(seqid));
				vo.setState(state);//状态
				vo.setOpinion(opinion);//审核意见
				vo.setAudittime(new Date());//审核时间为当前时间
				auditBO.doUpdate(vo);
			 }
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	 }
	 /**
	  * 封装订单商品描述
	  * @param orderids
	  * @return
	  * @throws Exception
	  */
	 private String getComdesc(String[] orderids)throws Exception {
		 Ordercomcate ordercomcateBO = (OrdercomcateBO) BOFactory.build(OrdercomcateBO.class,user);
			Comcategoryrela comcategoryrelaBO= (Comcategoryrela)BOFactory.build(ComcategoryrelaBO.class,user);//商品组合关系BO
			List<ComcategoryrelaVO> comcategList=null;//商品组合关系查询集合
			OrdercomcateDBParam params=new OrdercomcateDBParam();
			ComcategoryrelaDBParam comcategoryrelaDBParam=new ComcategoryrelaDBParam();
			List<String> list=new ArrayList<String>();
			for(String orderid:orderids){
				list.add(orderid);
			}
			params.set_pagesize("0");
			params.set_sin_orderid(list);
			List<OrdercomcateVO> cateList=ordercomcateBO.doQuery(params).getDatas();
			Map<String,Long> orderAmtMap=new HashMap<String,Long>();
			Long amtCache=null;
			for(OrdercomcateVO cate:cateList){
				if(orderAmtMap.containsKey(cate.getComcategory())){//集合中存在
					amtCache=orderAmtMap.get(cate.getComcategory());
					orderAmtMap.put(cate.getComcategory(), amtCache+cate.getOrderamt());
				}else{
					orderAmtMap.put(cate.getComcategory(), cate.getOrderamt());
				}
			}
			StringBuffer sb=new StringBuffer();
			for(String key:orderAmtMap.keySet()){
				comcategoryrelaDBParam.set_se_comcategory(key);
				comcategList=comcategoryrelaBO.doQuery(comcategoryrelaDBParam).getDatas();//商品种类
				
				if(comcategList.size()>0){
					ComcategoryrelaVO comcateg=comcategList.get(0);//取第一个商品种类
					//充值卡
					if("COMRESCARD".equals(comcateg.getRestype())){
						if(!"".equals(sb.toString()))
							sb.append(",");
						sb.append(Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", comcateg.getComcategory(), user.getCityid())+orderAmtMap.get(key)+"张");
					}//套卡
					else if("COMRESSMP".equals(comcateg.getRestype())){
						if(!"".equals(sb.toString()))
							sb.append(",");
						sb.append(Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", comcateg.getComcategory(), user.getCityid())+orderAmtMap.get(key)+"套");
					}
				}
			}
			return sb.toString();
	 }
	 //默认查询方法
	 public DataPackage doDefaultQuery(AuditDBParam params) throws Exception {
		AuditDAO dao = (AuditDAO) DAOFactory.build(AuditDAO.class, user);
		params.getQueryConditions().put("operid", user.getOprcode());
		return dao.queryByNamedSqlQuery(
				"com.gmcc.pboss.business.sales.audit.defaultquery", params, 0);
	}

	 public DataPackage doGetAuditInfo(AuditDBParam param)throws Exception {
		 AuditDAO dao = (AuditDAO) DAOFactory.build(AuditDAO.class,user);
			return dao.getAuditInfo(param);
	 }
	 
	 /**
		 * 批量提交审核2,加入：保存用户输入的备注字段值
		 */
		public void doBatchSubmitAudit2(String[] orderids, String auditor,String memo)
				throws Exception {
			try {
				Audit auditBO = (Audit) BOFactory.build(AuditBO.class,user);
				AuditDAO dao = (AuditDAO) DAOFactory.build(AuditDAO.class, user);
				//在“订单审核[FX_SW_AUDIT]”表中新增订单待审批记录
				AuditVO auditVO=new AuditVO();
				auditVO.setSeqid(this.doGetAuditSeqId(new Date()));//序号[SEQID]”为当前日期+库表序列
				auditVO.setAuditor(auditor);//审核人工号
				//auditVO.setOrderid(orderid);//订单ID
				auditVO.setSmsntime(new Date());//当前时间
				auditVO.setState("0");//待审批[0]
				auditVO.setPresenter(user.getOprcode());//提交人为当前工号
				auditVO.setMemo(memo);
				auditBO.doCreate(auditVO);
				Auditdet auditdetBO = (Auditdet) BOFactory.build(AuditdetBO.class,user);
				
				String orderidss="";
				AuditdetVO auditdetVO=null;
				for(String orderid:orderids){
					if("".equals(orderidss)) orderidss=orderid;
					else orderidss+="/"+orderid;
					
					auditdetVO=new AuditdetVO();
					auditdetVO.setRecid((Long)dao.getSequence("FX_SW_AUDITDET_SEQ"));
					auditdetVO.setOrderid(orderid);
					auditdetVO.setAuditseq(auditVO.getSeqid());
					auditdetBO.doCreate(auditdetVO);
				}
				
				
				//在“订单审核[FX_SW_AUDITDET]”表中新增记录
				
				//批量发送短信
				Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
				String sysparamvalue=sysparamBO.doFindByID("52", "pboss_fx");
				if(!StringUtils.isEmpty(sysparamvalue)&& "1".equals(sysparamvalue)){//插入短信待发送表
					String sysparamvalue42=sysparamBO.doFindByID("42", "pboss_fx");
					if(!StringUtils.isEmpty(sysparamvalue42)){
						Operator operatorBO = (Operator) BOFactory.build(OperatorBO.class, user);
						OperatorVO operatorVO=operatorBO.doFindByPk(auditor);//获取审核人信息
						if(operatorVO.getContactphone()!=null && !"".equals(operatorVO.getContactphone())){
							Waitreq waitreqBO = (Waitreq) BOFactory.build(WaitreqBO.class,user);
							Smstmpl smstmplBO = (Smstmpl) BOFactory.build(SmstmplBO.class, user);
							Map<String,String> keyAndValue=new HashMap<String,String>();
							keyAndValue.put("ORDERIDS", orderidss);//订单编码
							OperatorVO presenterVO=operatorBO.doFindByPk(user.getOprcode());
							keyAndValue.put("PRESENTER", presenterVO.getOpername());//提交人
							keyAndValue.put("ORDERAMOUNT", String.valueOf(orderids.length));//订单数量
							keyAndValue.put("COMDESC", getComdesc(orderids));//订单商品描述
							String seq=auditVO.getSeqid().toString();
							keyAndValue.put("STREAM", seq.substring(seq.length()-4, seq.length()));//流水号
							String content=smstmplBO.doGenSMS("FX_ORDER_AADVICE_BATCH", keyAndValue);//获取模板信息
							if(content!=null && !"".equals(content)){
								waitreqBO.doInsert2((short)3, content,sysparamvalue42, operatorVO.getContactphone());//插入待发送表
								//新增数据到分销短信确认表（FX_SW_SMSCONFIRM），编号取库表序列，类型取审核确认（AUDITCON），确认流水号取审核序号末尾4位，
								//手机号码取“接收手机号码”，关联订单号取审核序号，状态取待回复，通知时间取当前时间，回复时间和回复描述留空。
								Smsconfirm smsconfirmBO = (Smsconfirm) BOFactory.build(SmsconfirmBO.class, user);
								SmsconfirmVO smsconfirmVO=new SmsconfirmVO();
								smsconfirmVO.setType("AUDITCON");
								smsconfirmVO.setStream(seq.substring(seq.length()-4, seq.length()));
								smsconfirmVO.setMobileno( operatorVO.getContactphone());
								smsconfirmVO.setOrderid(seq);
								smsconfirmVO.setState("WAITREP");
								smsconfirmVO.setSendtime(new Date());
								smsconfirmBO.doCreate(smsconfirmVO);
							}
						}
					}
				}
			} catch (Exception ex) {
				throw new JOPException(ex);
			}
			
		}

}