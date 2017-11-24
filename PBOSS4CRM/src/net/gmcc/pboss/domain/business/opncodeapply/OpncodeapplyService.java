package net.gmcc.pboss.domain.business.opncodeapply;

import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Service;

import net.gmcc.pboss.comswebservice.Opncodeapplyreq;
import net.gmcc.pboss.comswebservice.Opncodeapplyrsp;
import net.gmcc.pboss.comswebservice.Reqheader;
import net.gmcc.pboss.comswebservice.Rspheader;
import net.gmcc.pboss.domain.additional.exception.RequestMessageException;
import net.gmcc.pboss.domain.business.OprType;
import net.gmcc.pboss.domain.business.service.BaseService;
import net.gmcc.pboss.domain.model.operation.OperationVO;
import net.gmcc.pboss.domain.model.operation.OperationlogVO;
import net.gmcc.pboss.domain.model.opnaudit.OpnauditVO;
import net.gmcc.pboss.utils.BeanUtils;
import net.gmcc.pboss.utils.ParamsUtil;
import net.gmcc.pboss.utils.StringUtil;

@Service
public class OpncodeapplyService extends BaseService {
	private static final Logger log = Logger.getLogger(OpncodeapplyService.class);
	
	public void doBusiness(Opncodeapplyreq req, Opncodeapplyrsp rsp)throws Exception{
		Reqheader reqhead = req.getReqheader();
		Opncodeapplyreq.Reqbody reqbody = req.getReqbody();			
		
		//构建响应消息
		Rspheader rsphead = rsp.getRspheader();
		Opncodeapplyrsp.Rspbody rspbody = rsp.getRspbody();
		try{			
			//校验请求报文
			this.checkAndSet(reqhead, rsphead, reqbody);
			rsp.setRspheader(rsphead);
			//新增记录到ch_pw_operation
			//insert into ch_pw_operation (opnid,name,parentid,state,startdate,enddate,isbusi,busibelong,opnlevel,sflag) 
			//values ('@opnid@','@OPNAME@','@PARENTID@','1','@START_DATE@','@END_DATE@ 23:59:59','1','@busibelong@',5,1);
			OperationVO vo = new OperationVO();			
			//生成opnid
			//select lpad(count(opnid)+1,5,'0')  from ch_pw_operation where isbusi=1
			String maxopnSQL = "select lpad(count(opnid)+1,5,'0')  from ch_pw_operation where isbusi=1";
			SQLQuery query = this.dao.createSQLQuery(maxopnSQL, (Object[])null);
			String maxopnid = (String)query.uniqueResult();
			if(maxopnid == null){
				throw new RequestMessageException("根据[parentid:"+reqbody.getParentid()+"]生成业务编码失败");
			}
			//Long nextopn = Long.parseLong(maxopnid)+1;
			String nextopnid = reqbody.getParentid().substring(0, 8)+maxopnid; //+ nextopn.toString().substring(nextopn.toString().length()-5);			
			vo.setOpnid(nextopnid);
			
			vo.setName(reqbody.getOpnname());
			vo.setParentid(reqbody.getParentid());
			vo.setState((byte)1);
			vo.setStartdate(StringUtil.changeStrToDate8("startdate", reqbody.getStartdate()));
			vo.setEnddate(StringUtil.changeStrToDate14("enddate", reqbody.getEnddate()+"235959"));
			vo.setIsbusi(true);
			vo.setBusibelong(reqbody.getBusibelong());
			vo.setOpnlevel((short)5);
			vo.setSflag((short)1);
			this.executeSingleData(OprType.CREATE, vo);
			//登记日志表ch_pw_operation
			OperationlogVO logvo = new OperationlogVO();
			BeanUtils.copyProperties(logvo, vo);
			logvo.setOptime(new Date());
			logvo.setOprcode("PSGM");
			logvo.setOprtype(OprType.CREATE);
			logvo.setSuccess("0");
			this.executeBusinessLog(logvo);
			//新增成功记录到ch_pw_opnaudit表
			OpnauditVO auvo = new OpnauditVO();
			auvo.setId(reqbody.getId());
			auvo.setCityid((short)reqbody.getCityid());
			auvo.setOpnid(vo.getOpnid());
			auvo.setOpnname(reqbody.getOpnname());
			auvo.setBusibelong(reqbody.getBusibelong());
			auvo.setParentid(reqbody.getParentid());
			auvo.setStartdate(StringUtil.changeStrToDate8("", reqbody.getStartdate()));
			auvo.setEnddate(StringUtil.changeStrToDate8("", reqbody.getEnddate()));
			auvo.setState((short)0);
			auvo.setOprtime(new Date());
			this.executeSingleData(OprType.CREATE, auvo);			
			//构造响应消息体
			rspbody.setId(reqbody.getId());
			rspbody.setState(0);
			rspbody.setOpnid(vo.getOpnid());
			rspbody.setParentid(reqbody.getParentid());
			rsp.setRspbody(rspbody);
			//return rsp;
		}catch(RequestMessageException e){
			String errmsg = "请求报文格式校验未通过，错误信息："+ e.getMessage();
			log.info(this.processCode.get()+errmsg);
			String info = null;
			OpnauditVO oavo = dao.find(OpnauditVO.class, reqbody.getId());
			if(oavo==null){
				info = this.insertFailOpnaudit(reqbody);;
			}			
			if(null != info){
				errmsg = errmsg +"\t"+ info;
			}
					
			//返回业务失败响应信息
			this.buildFailResponse(req,rsphead,rspbody,errmsg);
		}catch(Exception e){
			String errmsg = "请求处理失败，失败原因："+e.getMessage();
			log.info(this.processCode.get()+errmsg);
			String info = this.insertFailOpnaudit(reqbody);//如果是数据库异常，此处可能无法插入数据；异常的具体信息可查询业务日志
			if(null != info){
				errmsg = errmsg +"\t"+ info;
			}
			//返回业务失败响应信息
			this.buildFailResponse(req,rsphead,rspbody,errmsg);
		}
	}
	
	private void buildFailResponse(Opncodeapplyreq req, Rspheader rsphead, Opncodeapplyrsp.Rspbody rspbody, String errmsg){		
		Opncodeapplyreq.Reqbody reqbody = req.getReqbody();
		
		rsphead.getRetinfo().setRetcode(1);
		rsphead.getRetinfo().setRetmsg(errmsg);
		
		rspbody.setId(reqbody.getId());
		rspbody.setOpnid("");
		rspbody.setState(1);
		rspbody.setParentid(reqbody.getParentid());
	}
	
	private String insertFailOpnaudit(Opncodeapplyreq.Reqbody reqbody){
		try{
			//登记失败记录到ch_pw_opnaudit
			OpnauditVO auvo = new OpnauditVO();
			auvo.setId(reqbody.getId());
			auvo.setCityid((short)reqbody.getCityid());
			auvo.setOpnid(null);
			auvo.setOpnname(reqbody.getOpnname());
			auvo.setBusibelong(reqbody.getBusibelong());
			auvo.setParentid(reqbody.getParentid());
			auvo.setStartdate(StringUtil.changeStrToDate8("startdate", reqbody.getStartdate()));
			auvo.setEnddate(StringUtil.changeStrToDate8("enddate", reqbody.getEnddate()));
			auvo.setState((short)1);
			auvo.setOprtime(new Date());
			this.executeSingleData(OprType.CREATE, auvo);
			return null;
		}catch(Exception ex){	
			String errmsg = "插入失败记录报错：消息体中"+ex.getMessage();
			log.info(this.processCode.get()+errmsg);
			return errmsg;
		}
	}
	
	@Override
	public void checkReqHeader(Reqheader requestHeader) throws RequestMessageException {
		super.checkReqHeader(requestHeader);
		StringBuffer errMsg = new StringBuffer();
		if(!"PSGM".equals(requestHeader.getPlatform())){
			errMsg.append("[platform]必须为'PSGM'.");
		}
		if(!"opncodeapply".equals(requestHeader.getProcessCode())){
			errMsg.append("[process_code]必须为'opncodeapply'.");
		}
		if(!"".equals(errMsg.toString())){
			throw new RequestMessageException("业务编码注册接口,请求头部[reqheader]属性:" + errMsg.toString());
		}		
	}
	
	@Override
	public void checkReqBody(Object reqbody) throws RequestMessageException {
		// TODO Auto-generated method stub
		Opncodeapplyreq.Reqbody body = (Opncodeapplyreq.Reqbody)reqbody;
		StringBuffer errmsg = new StringBuffer();
		
		if(StringUtil.isEmpty(body.getId()) || body.getId().length()>32){
			errmsg.append("唯一ID[id]不能为空，且长度不能超过32位.");
		}else{
			OpnauditVO oavo = dao.find(OpnauditVO.class, body.getId());
			if(oavo!=null){
				errmsg.append("唯一ID[id]已存在.");
			}
		}
		
		String city = ParamsUtil.getRegionLetterMap().get(""+body.getCityid());
		if(city==null){
			errmsg.append("地市标识[cityid]不是有效地市.");
		}
		
		String parentid = body.getParentid();
		if(parentid==null || parentid.length()!=13){
			errmsg.append("所属第四级业务编码[parentid]必须为13位.");
		}else{
			OperationVO opvo = dao.find(OperationVO.class, parentid);
			if(opvo == null){
				errmsg.append("所属第四级业务编码[parentid]不存在.");
			}else if(opvo.getOpnlevel()!=4){
				errmsg.append("所属第四级业务编码[parentid]不是第四级业务编码.");
			}
		}
		
		if(StringUtil.isEmpty(body.getOpnname()) || body.getOpnname().length()>50){
			errmsg.append("业务名称[opnname]不能为空，且长度不超过50位.");
		}
		
		String busibelong = body.getBusibelong();
		if(StringUtil.isEmpty(busibelong) || busibelong.length()>10){
			errmsg.append("业务归属[busibelong]不能为空，且长度不超过10位.");
		}else if(!"SERV".equals(busibelong) && !"CARD".equals(busibelong) && !"DATA".equals(busibelong)){
			errmsg.append("业务归属[busibelong]必须为SERV、CARD、DATA三者之一.");
		}				
		
		String startdate = body.getStartdate();
		if(!StringUtil.checkDateTime8(startdate)){
			errmsg.append("生效时间[startdate]格式必须为YYYYMMDD.");
		}
		
		String enddate = body.getEnddate();
		if(!StringUtil.checkDateTime8(enddate)){
			errmsg.append("失效时间[enddate]格式必须为YYYYMMDD.");
		}
		
		if(!"".equals(errmsg.toString())){
			throw new RequestMessageException(errmsg.toString());
		}		
	}
}
