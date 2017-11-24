package net.gmcc.pboss.domain.business.b2m.singlerecord;

import java.util.List;

import net.gmcc.pboss.b2mservice.Singlerecordrequest;
import net.gmcc.pboss.b2mservice.Singlerecordresponse;
import net.gmcc.pboss.domain.additional.exception.RequestMessageException;
import net.gmcc.pboss.domain.business.service.BaseB2MService;
import net.gmcc.pboss.utils.StringUtil;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Service;

@Service
public class SingleRecordService extends BaseB2MService{
	private static final Logger log = Logger.getLogger(SingleRecordService.class);
	public void doBusiness(Singlerecordrequest req,Singlerecordresponse rsp) throws Exception{
		try{
			//校验请求信息头，构造反馈消息头
			this.checkAndSet(req.getMsgreqheader(), rsp.getMsgrspheader());
			String route = req.getMsgreqheader().getRoute();
			//校验请求消息体
			this.checkReqBody(req.getMsgbody());
			//逻辑处理
			String recommender = req.getMsgbody().getRecommender().trim();//推荐人号码
			String transactor = req.getMsgbody().getTransactor().trim();//办理人号码
			String businessid = req.getMsgbody().getBusinessid().trim();//业务代码
			String recomtime = req.getMsgbody().getRecommondtime().trim();//推荐时间
			
			StringBuffer sql = new StringBuffer();
			sql.append("select sub.brand brand,e.telephone telephone,t.mobile mobile,");
			sql.append("       (case");
			sql.append("         when e.wayid like '%U_00000' then '个人专员'");
			sql.append("         when e.wayid = 'GMCCTEST' then '内部员工'");
			sql.append("         when w.upperwayid = 'UNPB-----' then '省级代理商'");
			sql.append("         else '市级代理商'");
			sql.append("       end) employtype,");
			sql.append("       t.opnid,o.name opnname,");
			sql.append("       to_char(t.paysum, 'fm99999999.0000') paysum,");
			sql.append("       to_char(t.runtime, 'yyyyMMddhh24miss') runtime");
			sql.append("  from cm_subs_subscriber sub,ch_bbc_operation o,ch_pw_way w,ch_pw_employee e,");
			sql.append("       ch_bbc_rewardrecord t");
			sql.append(" where e.telephone = ? and t.mobile = ? and t.opnid = ?");
			sql.append("   and t.oprtime = to_date(?, 'yyyyMMddhh24miss') and sub.region = ?");
			sql.append("   and sub.status not in('US99', 'US26', 'US27', 'US28', 'US29', 'US281', 'US282', 'US288')");
			sql.append("   and e.wayid = w.wayid and e.telephone = sub.servnumber");
			sql.append("   and t.opnid = o.opnid and t.wayoprcode = e.employeeid and t.commendwayid = '23'");
			SQLQuery squery = dao.createSQLQuery(sql.toString(), recommender, transactor, businessid, recomtime, route);
			List result = (List)squery.list();
			if(result==null || result.size()==0){
				throw new Exception("没有符合条件的数据");
			}
//			else if(result.size()>=2){
//				throw new Exception("符合条件的数据有多条");
//			}
			else{
				Object[] ret = (Object[])result.get(0);
				Singlerecordresponse.Msgbody rspbody = rsp.getMsgbody();
				rspbody.setCity(route);
				rspbody.setBrand(ret[0]!=null?ret[0].toString():"");
				rspbody.setRecommender(ret[1]!=null?ret[1].toString():"");
				rspbody.setTransactor(ret[2]!=null?ret[2].toString():"");
				rspbody.setTeletype(ret[3]!=null?ret[3].toString():"");
				rspbody.setBusinessid(ret[4]!=null?ret[4].toString():"");
				rspbody.setBusinessname(ret[5]!=null?ret[5].toString():"");
				rspbody.setReward(ret[6]!=null?ret[6].toString():"");
				rspbody.setTime(ret[7]!=null?ret[7].toString():"");
			}
			log.info(processCode.get()+"-------------------------[客户端酬金单条明细查询接口:singlerecord]处理请求：完成-----");	
		}catch(RequestMessageException ex){
			rsp.getMsgrspheader().getRetinfo().setRettype(500);
			rsp.getMsgrspheader().getRetinfo().setRetcode(500);
			rsp.getMsgrspheader().getRetinfo().setRetmsg("报文格式异常:"+ex.getMessage());
			log.info(processCode.get()+"报文格式异常:"+ex.getMessage());
			log.info(processCode.get()+"-------------------------[客户端酬金单条明细查询接口:singlerecord]处理请求：结束-----");	
		}catch(Exception ex){
			ex.printStackTrace();
			rsp.getMsgrspheader().getRetinfo().setRettype(600);
			rsp.getMsgrspheader().getRetinfo().setRetcode(600);
			rsp.getMsgrspheader().getRetinfo().setRetmsg(ex.getMessage());
			log.info(processCode.get()+ex.getMessage());
			log.info(processCode.get()+"-------------------------[客户端酬金单条明细查询接口:singlerecord]处理请求：结束-----");	
		}
	}
	
	@Override
	protected void checkReqBody(Object reqbody) throws RequestMessageException {
		// TODO Auto-generated method stub
		Singlerecordrequest.Msgbody body = (Singlerecordrequest.Msgbody)reqbody;
		StringBuffer errMsg = new StringBuffer("");
		if(StringUtil.isEmpty(body.getRecommender())){
			errMsg.append("消息体中推荐人号码[recommender]不能为空");
		}
		if(StringUtil.isEmpty(body.getTransactor())){
			errMsg.append("消息体中办理人号码[transactor]不能为空");
		}
		if(StringUtil.isEmpty(body.getBusinessid())){
			errMsg.append("消息体中业务代码[businessid]不能为空");
		}
		if(!StringUtil.checkDateTime14(body.getRecommondtime())){
			errMsg.append("消息体中推荐时间[recommendertime]不能为空，格式必须为YYYYMMDDHH24MISS");
		}
		if(!"".equals(errMsg.toString())){
			throw new RequestMessageException("请求消息体[msgbody]属性:" + errMsg.toString());
		}
	}
}
