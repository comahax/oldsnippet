package net.gmcc.pboss.domain.business.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import net.gmcc.pboss.comswebservice.Reqheader;
import net.gmcc.pboss.comswebservice.Rspheader;
import net.gmcc.pboss.domain.additional.exception.RequestMessageException;
import net.gmcc.pboss.domain.business.AbstractService;
import net.gmcc.pboss.utils.StringUtil;

@Transactional
public abstract class BaseService extends AbstractService{
	private static final Logger log = Logger.getLogger(BaseService.class);
	
	/**
	 * 检查请求头部
	 * 
	 * @param requestHeader
	 * @throws Exception
	 */
	protected void checkReqHeader(Reqheader requestHeader) throws RequestMessageException {
		StringBuffer errMsg = new StringBuffer();
		if(StringUtil.isEmpty(requestHeader.getPlatform()) || requestHeader.getPlatform().length()>12){
			errMsg.append("[platform]不能为空，且长度不超过12位.");
		}
		if(StringUtil.isEmpty(requestHeader.getProcessCode()) || requestHeader.getProcessCode().length()>32){
			errMsg.append("[process_code]不能为空，且长度不能超过32位.");
		}
		if(!StringUtil.checkDateTime14(requestHeader.getReqTime())){
			errMsg.append("[req_time]格式必须为YYYYMMDDHH24MISS.");
		}
		if(StringUtil.isEmpty(requestHeader.getReqSeq()) || requestHeader.getReqSeq().length()>32){
			errMsg.append("[req_seq]不能为空 ，且长度不超过32位.");
		}
		
		if (!"".equals(errMsg.toString())) {
			throw new RequestMessageException("请求头部[reqheader]属性:" + errMsg.toString());
		}		
	}
	
	/**
	 * 校验扩展头部信息
	 * 如果没有扩展头，就使用此默认实现，什么都不做；如果有扩展头信息，需要在具体子类中重写此方法
	 * @param reqExtendHeader
	 * @throws RequestMessageException
	 */
	protected void checkReqExtendHeader(Object reqExtendHeader)throws RequestMessageException{
		return;
	}
	
	/**
	 * 设置当前调用的业务标识，用于日志输出
	 * @param reqHeader 请求头
	 */
	protected void setProcessCode(Reqheader reqHeader){
		String code = "["+reqHeader.getProcessCode()+"-"+reqHeader.getReqSeq()+"]---->";
		processCode.set(code);
	}
	
	/**
	 * 根据请求头部构造返回头部
	 * @param reqheader
	 * @param rspheader
	 * @throws Exception
	 */
	protected void buildRspheader(Reqheader reqheader, Rspheader rspheader){
		if(null == rspheader){
			rspheader = new Rspheader();
		}
		rspheader.setPlatform(reqheader.getPlatform());
		rspheader.setProcessCode(reqheader.getProcessCode());
		rspheader.setReqSeq(reqheader.getReqSeq());
		rspheader.setRspTime(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		String rsp_seq = StringUtil.getSequenceId();
		rspheader.setRspSeq(rsp_seq);
		Rspheader.Retinfo ret = new Rspheader.Retinfo();
		ret.setRetcode(0);
		ret.setRetmsg("成功");
		rspheader.setRetinfo(ret);
	}
	
	/**
	 * 由于消息体部分差异较大，留待分别检验，具体子类必须实现此方法
	 * 检查MegBody的公共部分
	 */
	abstract protected void checkReqBody(Object reqbody) throws RequestMessageException;
	
	protected void checkAndSet(Reqheader reqHeader, Rspheader resHeader, Object reqBody) throws RequestMessageException {
		if (null == reqHeader) {
			throw new RequestMessageException("请求头部[reqheader]不能为空.");
		}
		
		// 设置当前调用的业务标识，用于日志输出
		this.setProcessCode(reqHeader);

		// 设置返回头部
		this.buildRspheader(reqHeader, resHeader);
		
		// 对象头部检查
		this.checkReqHeader(reqHeader);
		
		// 检查消息体
		if(null == reqBody){
			throw new RequestMessageException("消息体[reqbody]不能为空.");
		}
		this.checkReqBody(reqBody);

		// 登记系统日志
		//日志表需记录表名，主键值。这里先不写日志
		//此逻辑暂未迁移
		//LoggerUtil.insertSysLog(reqHeader, tradeType, orderID,dao);
		//改为检查流水号是否存在,判断流水号冲突,后面再进行入库
		//checkTransID(reqHeader.getTransID());		
	}
	
	protected void checkAndSet(Reqheader reqHeader, Rspheader resHeader, Object reqBody, Object extendheader) throws RequestMessageException {
		if (null == reqHeader) {
			throw new RequestMessageException("请求头部[reqheader]不能为空.");
		}		
		
		// 设置当前调用的业务标识，用于日志输出
		this.setProcessCode(reqHeader);

		// 设置返回头部
		this.buildRspheader(reqHeader, resHeader);
		
		// 对象头部检查
		this.checkReqHeader(reqHeader);
		this.checkReqExtendHeader(extendheader);
		
		// 检查消息体
		if(null == reqBody){
			throw new RequestMessageException("消息体[reqbody]不能为空.");
		}
		this.checkReqBody(reqBody);

		// 登记系统日志
		//日志表需记录表名，主键值。这里先不写日志
		//此逻辑暂未迁移
		//LoggerUtil.insertSysLog(reqHeader, tradeType, orderID,dao);
		//改为检查流水号是否存在,判断流水号冲突,后面再进行入库
		//checkTransID(reqHeader.getTransID());		
	}
}
