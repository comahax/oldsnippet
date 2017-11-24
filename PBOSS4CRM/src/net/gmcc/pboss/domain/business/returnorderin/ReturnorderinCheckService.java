package net.gmcc.pboss.domain.business.returnorderin;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import net.gmcc.pboss.pboss4crmservice.Msgreqheader;
import net.gmcc.pboss.pboss4crmservice.Msgrspheader;
import net.gmcc.pboss.pboss4crmservice.Returnorderinreq;
import net.gmcc.pboss.domain.additional.exception.RequestMessageException;
import net.gmcc.pboss.domain.business.AbstractService;
import net.gmcc.pboss.domain.business.service.BaseCrmService;

@Service
public class ReturnorderinCheckService extends BaseCrmService {
	private static final Logger log = Logger.getLogger(ReturnorderinCheckService.class);
	
	public Boolean doBusiness(Returnorderinreq request, Msgrspheader rspheader)throws Exception{
		boolean result = false;
		try{
			Msgreqheader reqheader = request.getMsgreqheader();
			//校验请求信息头，构造反馈消息头
			this.checkAndSet(reqheader, rspheader);
			String routeValue = reqheader.getRoute().getRouteValue();
			
			//校验请求消息体
			Returnorderinreq.Msgbody reqbody = request.getMsgbody();
			this.checkReqBody(reqbody);
			result = true;
			log.info(processCode.get()+"订单入账报文校验通过");
			System.out.println(processCode.get()+"订单入账报文校验通过");
		}catch(RequestMessageException e){//参数完整性校验-报文格式异常
			rspheader.getRetinfo().setRetcode(888001);
			rspheader.getRetinfo().setRetype(600);
			rspheader.getRetinfo().setRetmsg("报文格式异常:"+e.getMessage());
			log.info(processCode.get()+"订单入账报文校验失败，报文格式异常:"+e.getMessage());
			System.out.println(processCode.get()+"订单入账报文校验失败，报文格式异常:"+e.getMessage());
		}catch(Exception e){//其他异常，主要是数据库操作异常信息
			e.printStackTrace();
			rspheader.getRetinfo().setRetcode(888002);
			rspheader.getRetinfo().setRetype(600);
			rspheader.getRetinfo().setRetmsg(e.getMessage());
			log.info(processCode.get()+e.getMessage());
			System.out.println(processCode.get()+"订单入账报文校验失败，"+e.getMessage());
		}
		return result;
	}

	@Override
	public void checkReqBody(Object reqbody) throws RequestMessageException {
		// TODO Auto-generated method stub
		if(reqbody==null){
			throw new RequestMessageException("请求体[msgbody]不能为空");
		}
		String busitype = ((Returnorderinreq.Msgbody)reqbody).getBusitype();
//		if(busitype==null || "".equals(busitype) || "null".equals(busitype)){
//			throw new RequestMessageException("请求体[busitype]不能为空");
//		}
		if(busitype==null || "".equals(busitype.trim()) || "null".equals(busitype.trim())
				|| !"0".equals(busitype.trim())){
			throw new RequestMessageException("请求体[busitype]不能为空，且取值只能为[0:入账]");
		}
		String orderid = ((Returnorderinreq.Msgbody)reqbody).getOrderid();
		if(orderid==null || "".equals(orderid) || "null".equals(orderid)){
			throw new RequestMessageException("请求体[orderid]不能为空");
		}
		String bossworkfid = ((Returnorderinreq.Msgbody)reqbody).getBossworkfid();
		if(bossworkfid == null || "".equals(bossworkfid.trim())){
			throw new RequestMessageException("请求体[bossworkfid]不能为空");
		}
		String orderresult = ((Returnorderinreq.Msgbody)reqbody).getOrderresult();
		if(orderresult == null || "".equals(orderresult.trim()) 
				||(!"0".equals(orderresult) && !"-1".equals(orderresult)) ){
			throw new RequestMessageException("请求体[orderresult]不能为空，且取值只能为[0:成功;-1:入账失败]");
		}
	}
}
