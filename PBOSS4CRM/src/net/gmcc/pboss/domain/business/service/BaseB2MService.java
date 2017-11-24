package net.gmcc.pboss.domain.business.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import net.gmcc.pboss.b2mservice.Msgreqheader;
import net.gmcc.pboss.b2mservice.Msgrspheader;
import net.gmcc.pboss.domain.additional.exception.RequestMessageException;
import net.gmcc.pboss.domain.business.AbstractService;


import net.gmcc.pboss.utils.ParamsUtil;
import net.gmcc.pboss.utils.StringUtil;
@Transactional
public abstract class BaseB2MService extends AbstractService {
	private static final Logger log = Logger.getLogger(BaseB2MService.class);
	
	public static final String PLATFORM_SRC = "COMS";
	/**
	 * 检查请求头部
	 * 
	 * @param requestHeader
	 * @throws Exception
	 */
	protected void checkReqHeader(Msgreqheader requestHeader) throws RequestMessageException {
		StringBuffer errMsg = new StringBuffer();
		if(StringUtil.isEmpty(requestHeader.getPlatformSrc())){
			errMsg.append("[platform_src]不能为空 ");
		}
		if(StringUtil.isEmpty(requestHeader.getProcessCode())){
			errMsg.append("[process_code]不能为空 ");
		}
		if(!StringUtil.checkDateTime14(requestHeader.getReqTime())){
			errMsg.append("[req_time]不能为空，格式必须为YYYYMMDDHH24MISS ");
		}
//		if(StringUtil.isEmpty(requestHeader.getReqSeq())){
//			errMsg.append("[req_seq]不能为空 ");
//		}
		if(StringUtil.isEmpty(requestHeader.getRoute())){
			errMsg.append("[route]不能为空 ");
		}
		if(!this.checkRoute(requestHeader)){
			errMsg.append("[route:"+requestHeader.getRoute()+"]不是有效的地市标识");
		}
		
		if (!"".equals(errMsg.toString())) {
			throw new RequestMessageException("请求头部[msgreqheader]属性:" + errMsg.toString());
		}
	}
	
	private boolean checkRoute(Msgreqheader requestHeader){
		String cityid = null;	
		String cityno = requestHeader.getRoute();
		cityid = ParamsUtil.getRegionLetterMap().get(cityno);
		if(cityid!=null && !"".equals(cityid)){
			return true;
		}else{
			return false;
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
		rspheader.setPlatformSrc(PLATFORM_SRC);
		rspheader.setProcessCode(reqheader.getProcessCode());
		rspheader.setVerifyCode(reqheader.getVerifyCode());
		rspheader.setRespTime(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		Msgrspheader.Sequence seq = new Msgrspheader.Sequence();
		seq.setReqSeq(reqheader.getReqSeq());
		String oseq = null;
		if(reqheader.getRoute()!=null){
			oseq = reqheader.getRoute()+StringUtil.getSequenceId();
		}else{
			oseq = StringUtil.getSequenceId();
		}
		seq.setOperationSeq(oseq);
		rspheader.setSequence(seq);
		Msgrspheader.Retinfo ret = new Msgrspheader.Retinfo();
		ret.setRetcode(0);
		ret.setRettype(0);
		ret.setRetmsg("成功");
		rspheader.setRetinfo(ret);		
	}
	
	protected void checkAndSet(Msgreqheader reqHeader, Msgrspheader resHeader) throws RequestMessageException {
		if (null == reqHeader) {
			//建立响应头信息，避免消息头为空，返回结果报文为空，无法向客户端展示错误原因
			resHeader.setPlatformSrc(PLATFORM_SRC);
			resHeader.setRespTime(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
			Msgrspheader.Retinfo ret = new Msgrspheader.Retinfo();
			ret.setRetcode(500);
			ret.setRettype(500);
			ret.setRetmsg("请求头部[msgreqheader]不能为空.");
			resHeader.setRetinfo(ret);
			
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
