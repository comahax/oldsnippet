package net.gmcc.pboss.domain.business.b2m.monthdetail;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Service;

import net.gmcc.pboss.b2mservice.Monthdetailrequest;
import net.gmcc.pboss.b2mservice.Monthdetailresponse;
import net.gmcc.pboss.domain.additional.exception.RequestMessageException;
import net.gmcc.pboss.domain.business.service.BaseB2MService;
import net.gmcc.pboss.utils.StringUtil;

@Service
public class MonthdetailService extends BaseB2MService {
	private static final Logger log = Logger.getLogger(MonthdetailService.class);
	
	public void doBusiness(Monthdetailrequest req, Monthdetailresponse rsp){
		try{
			//校验请求信息头，构造反馈消息头
			this.checkAndSet(req.getMsgreqheader(), rsp.getMsgrspheader());
			//校验请求消息体
			this.checkReqBody(req.getMsgbody());
			//逻辑处理
			String recommender = req.getMsgbody().getRecommender().trim();//推荐人号码
			String month = req.getMsgbody().getMonth().trim();//月份
			StringBuffer sql = new StringBuffer();
			sql.append("select o.name opnname,t.mobile,");
			sql.append("       to_char(t.paysum, 'fm99999999.0000') paysum,");
			sql.append("       to_char(t.runtime, 'yyyymmddhh24miss') runtime");
			sql.append("  from ch_bbc_operation o, ch_pw_employee e, ch_bbc_rewardrecord t");
			sql.append(" where e.telephone = ? and t.rewardmonth = ?");
			sql.append("   and t.opnid = o.opnid and t.wayoprcode = e.employeeid and t.commendwayid = '23'");
			SQLQuery squery = dao.createSQLQuery(sql.toString(), recommender, month);
			List result = (List)squery.list();
			if(result==null || result.size()==0){
				throw new Exception("没有符合条件的明细数据");
			}else{
				List<Monthdetailresponse.Msgbody.Details> details = rsp.getMsgbody().getDetails();
				Object[] item = null;
				for(Iterator it=result.iterator();it.hasNext();){
					item = (Object[])it.next();
					Monthdetailresponse.Msgbody.Details detail = new Monthdetailresponse.Msgbody.Details();
					detail.setBusinessname(item[0]!=null?item[0].toString():"");
					detail.setTransactor(item[1]!=null?item[1].toString():"");
					detail.setReward(item[2]!=null?item[2].toString():"");
					detail.setTime(item[3]!=null?item[3].toString():"");
					details.add(detail);
				}
			}
			log.info(processCode.get()+"-------------------------[客户端月酬金明细查询接口:monthdetail]处理请求：完成-----");	
		}catch(RequestMessageException ex){
			rsp.getMsgrspheader().getRetinfo().setRettype(500);
			rsp.getMsgrspheader().getRetinfo().setRetcode(500);
			rsp.getMsgrspheader().getRetinfo().setRetmsg("报文格式异常:"+ex.getMessage());
			log.info(processCode.get()+"报文格式异常:"+ex.getMessage());
			log.info(processCode.get()+"-------------------------[客户端月酬金明细查询接口:monthdetail]处理请求：结束-----");	
		}catch(Exception ex){
			ex.printStackTrace();
			rsp.getMsgrspheader().getRetinfo().setRettype(600);
			rsp.getMsgrspheader().getRetinfo().setRetcode(600);
			rsp.getMsgrspheader().getRetinfo().setRetmsg(ex.getMessage());
			log.info(processCode.get()+ex.getMessage());
			log.info(processCode.get()+"-------------------------[客户端月酬金明细查询接口:monthdetail]处理请求：结束-----");
		}
	}
	
	@Override
	protected void checkReqBody(Object reqbody) throws RequestMessageException {
		// TODO Auto-generated method stub
		Monthdetailrequest.Msgbody body = (Monthdetailrequest.Msgbody)reqbody;
		StringBuffer errMsg = new StringBuffer("");
		if(StringUtil.isEmpty(body.getRecommender())){
			errMsg.append("消息体中推荐人号码[recommender]不能为空");
		}
		if(!StringUtil.checkMonth(body.getMonth())){
			errMsg.append("消息体中月份[month]不能为空，且格式必须为yyyyMM");
		}
		if(!"".equals(errMsg.toString())){
			throw new RequestMessageException("请求消息体[msgbody]属性:" + errMsg.toString());
		}
	}

}
