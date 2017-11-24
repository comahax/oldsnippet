package net.gmcc.pboss.domain.business.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import net.gmcc.pboss.domain.additional.exception.RequestMessageException;
import net.gmcc.pboss.domain.business.AbstractService;
import net.gmcc.pboss.domain.model.operator.OperatorVO;
import net.gmcc.pboss.pboss4crmservice.Msgreqheader;
import net.gmcc.pboss.pboss4crmservice.Msgrspheader;
import net.gmcc.pboss.utils.StringUtil;

@Transactional
public abstract class BaseCrmService extends AbstractService{
	private static final Logger log = Logger.getLogger(BaseCrmService.class);
	/**
	 * 检查请求头部
	 * 
	 * @param requestHeader
	 * @throws Exception
	 */
	protected void checkReqHeader(Msgreqheader requestHeader) throws RequestMessageException {
		StringBuffer errMsg = new StringBuffer();
		if(StringUtil.isEmpty(requestHeader.getProcessCode())){
			errMsg.append("[process_code]不能为空 ");
		}
		if(!StringUtil.checkDateTime14(requestHeader.getReqTime())){
			errMsg.append("[req_time]格式必须为YYYYMMDDHH24MISS ");
		}
		if(StringUtil.isEmpty(requestHeader.getReqSeq())){
			errMsg.append("[req_seq]不能为空 ");
		}
		
		Msgreqheader.Route route = requestHeader.getRoute();
		if(route==null){
			errMsg.append("[route]不能为空 ");
		}
		else{
			try{
				if(!StringUtil.isEmpty(route.getRouteType())){
					Boolean.parseBoolean(route.getRouteType());
				}
//				else{//当前仅支持按地市路由，不支持按号码路由，所以route_type字段是否为空无关紧要
//					errMsg.append("[route_type]不能为空 ");
//				}
			}catch(Exception e){
				errMsg.append("[route_type]必须为0或1 ");
			}
			if(StringUtil.isEmpty(route.getRouteValue())){
				errMsg.append("[route_value]不能为空 ");
			}
		}
		
		Msgreqheader.Channelinfo channel=requestHeader.getChannelinfo();
		if(channel==null){
			errMsg.append("[channelinfo]不能为空 ");
		}else{
			if(StringUtil.isEmpty(channel.getOperatorid())){
				errMsg.append("[operatorid]不能为空 ");
			}else{
				try{
					OperatorVO oprvo = dao.find(OperatorVO.class, channel.getOperatorid());
					if(oprvo==null){
						errMsg.append("工号[operatorid:"+channel.getOperatorid()+"]不存在 ");
					}else{
						log.info(processCode.get() + "发起请求的操作工号为:"+channel.getOperatorid());
						System.out.println(processCode.get() + "发起请求的操作工号为:"+channel.getOperatorid());
					}
				}catch(Exception e){
					errMsg.append("工号[operatorid:"+channel.getOperatorid()+"]不存在 ");
				}
			}
		}
		
		if (!"".equals(errMsg.toString())) {
			throw new RequestMessageException("请求头部[msgreqheader]属性:" + errMsg.toString());
		}
		
	}
	
	/**
	 * 由于消息体部分差异较大，留待分别检验，具体子类必须实现此方法
	 * 检查MegBody的公共部分
	 */
	abstract protected void checkReqBody(Object reqbody) throws RequestMessageException;
	
	/**
	 * 设置当前调用的业务标识，用于日志输出
	 * @param reqHeader 请求头
	 */
	protected void setProcessCode(Msgreqheader reqHeader){
		String code = "["+reqHeader.getProcessCode()+"-"+reqHeader.getReqSeq()+"]---->";
		processCode.set(code);
	}
	
	/**
	 * 根据请求头部构造返回头部，Retinfo中的数据根据业务处理异常修改
	 * @param reqheader
	 * @param rspheader
	 * @throws Exception
	 */
	protected void buildRspheader(Msgreqheader reqheader, Msgrspheader rspheader){
		rspheader.setMenuid(reqheader.getMenuid());
		rspheader.setProcessCode(reqheader.getProcessCode());
		rspheader.setVerifyCode(reqheader.getVerifyCode());
		rspheader.setRespTime(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		Msgrspheader.Sequence seq = new Msgrspheader.Sequence();
		seq.setReqSeq(reqheader.getReqSeq());
		String oseq = null;
		if(reqheader.getRoute()!=null){
			oseq = reqheader.getRoute().getRouteValue()+StringUtil.getSequenceId();
		}else{
			oseq = StringUtil.getSequenceId();
		}
		seq.setOperationSeq(oseq);
		rspheader.setSequence(seq);
		Msgrspheader.Retinfo ret = new Msgrspheader.Retinfo();
		ret.setRetcode(0);
		ret.setRetype(0);
		ret.setRetmsg("成功");
		rspheader.setRetinfo(ret);		
	}
	
	protected void checkAndSet(Msgreqheader reqHeader, Msgrspheader resHeader) throws RequestMessageException {
		if (null == reqHeader) {
			throw new RequestMessageException("请求头部[msgreqheader]不能为空.");
		}
		
		// 设置当前调用的业务标识，用于日志输出
		this.setProcessCode(reqHeader);

		// 设置返回头部
		this.buildRspheader(reqHeader, resHeader);
		
		// 对象头部检查
		this.checkReqHeader(reqHeader);
	}
}
