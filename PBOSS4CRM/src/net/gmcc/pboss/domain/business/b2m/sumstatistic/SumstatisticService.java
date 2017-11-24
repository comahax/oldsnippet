package net.gmcc.pboss.domain.business.b2m.sumstatistic;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Service;

import net.gmcc.pboss.b2mservice.Sumstatisticrequest;
import net.gmcc.pboss.b2mservice.Sumstatisticresponse;
import net.gmcc.pboss.domain.additional.exception.RequestMessageException;
import net.gmcc.pboss.domain.business.service.BaseB2MService;
import net.gmcc.pboss.utils.StringUtil;
@Service
public class SumstatisticService extends BaseB2MService {
	private static final Logger log = Logger.getLogger(SumstatisticService.class);
	public void doBusiness(Sumstatisticrequest req, Sumstatisticresponse rsp){
		try{
			//校验请求信息头，构造反馈消息头
			this.checkAndSet(req.getMsgreqheader(), rsp.getMsgrspheader());
			//校验请求消息体
			this.checkReqBody(req.getMsgbody());
			//逻辑处理
			String recommender = req.getMsgbody().getRecommender().trim();//推荐人号码
			StringBuffer sql = new StringBuffer();
			sql.append("select to_char(sum(nvl(t.paysum, 0)), 'fm99999999.0000') sumpaysum");
			sql.append("  from ch_pw_employee e, ch_bbc_rewardrecord t");
			sql.append(" where e.telephone = ?");
			sql.append("   and t.wayoprcode = e.employeeid");
			sql.append("   and t.commendwayid = '23'");
			sql.append(" group by t.wayoprcode");
			SQLQuery squery = dao.createSQLQuery(sql.toString(), recommender);
			List result = (List)squery.list();
			if(result==null || result.size()==0){
				throw new Exception("没有符合条件的统计结果");
			}
//			else if(result.size()>=2){
//				throw new Exception("符合条件的统计结果有多条");
//			}
			else{
				Object ret = (Object)result.get(0);
				Sumstatisticresponse.Msgbody body = rsp.getMsgbody();
				body.setReward(ret.toString());
			}
			log.info(processCode.get()+"-------------------------[客户端总酬金统计:sumstatistic]处理请求：完成-----");	
		}catch(RequestMessageException ex){
			rsp.getMsgrspheader().getRetinfo().setRettype(500);
			rsp.getMsgrspheader().getRetinfo().setRetcode(500);
			rsp.getMsgrspheader().getRetinfo().setRetmsg("报文格式异常:"+ex.getMessage());
			log.info(processCode.get()+"报文格式异常:"+ex.getMessage());
			log.info(processCode.get()+"-------------------------[客户端总酬金统计:sumstatistic]处理请求：结束-----");	
		}catch(Exception ex){
			ex.printStackTrace();
			rsp.getMsgrspheader().getRetinfo().setRettype(600);
			rsp.getMsgrspheader().getRetinfo().setRetcode(600);
			rsp.getMsgrspheader().getRetinfo().setRetmsg(ex.getMessage());
			log.info(processCode.get()+ex.getMessage());
			log.info(processCode.get()+"-------------------------[客户端总酬金统计:sumstatistic]处理请求：结束-----");
		}
	}
	@Override
	protected void checkReqBody(Object reqbody) throws RequestMessageException {
		// TODO Auto-generated method stub
		Sumstatisticrequest.Msgbody body = (Sumstatisticrequest.Msgbody)reqbody;
		StringBuffer errMsg = new StringBuffer("");
		if(StringUtil.isEmpty(body.getRecommender())){
			errMsg.append("消息体中推荐人号码[recommender]不能为空");
		}
		if(!"".equals(errMsg.toString())){
			throw new RequestMessageException("请求消息体[msgbody]属性:" + errMsg.toString());
		}
	}

}
