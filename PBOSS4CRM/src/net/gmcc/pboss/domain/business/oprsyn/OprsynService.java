package net.gmcc.pboss.domain.business.oprsyn;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import net.gmcc.pboss.pboss4crmservice.Msgreqheader;
import net.gmcc.pboss.pboss4crmservice.Msgrspheader;
import net.gmcc.pboss.pboss4crmservice.Oprsynreq;
import net.gmcc.pboss.domain.additional.exception.RequestMessageException;
import net.gmcc.pboss.domain.business.OprType;
import net.gmcc.pboss.domain.business.service.BaseCrmService;
import net.gmcc.pboss.domain.model.operator.OperatorVO;
import net.gmcc.pboss.domain.model.operator.OperatorlogVO;
import net.gmcc.pboss.utils.BeanUtils;
import net.gmcc.pboss.utils.StringUtil;
import net.gmcc.pboss.utils.SystemUtil;

@Service
public class OprsynService extends BaseCrmService {
	private static final Logger log = Logger.getLogger(OprsynService.class);
	
	public void doBusiness(Oprsynreq request, Msgrspheader rspheader)throws Exception{
		try{
			Msgreqheader reqheader = request.getMsgreqheader();
			//校验请求信息头，构造反馈消息头
			this.checkAndSet(reqheader, rspheader);
			
			//校验请求消息体
			Oprsynreq.Msgbody reqbody = request.getMsgbody();
			this.checkReqBody(reqbody);
			Oprsynreq.Msgbody.Oprinfo oprinfo = reqbody.getOprinfo();
			String operid = oprinfo.getOperid();		
			String oprtype = oprinfo.getOprtype();
			//此两个字段如何使用
			//String optime = oprinfo.getOptime();
			//String oprcode = oprinfo.getOprcode();
			
			OperatorVO oprvo = this.buildOperatorVO(oprinfo);
			
			OperatorlogVO logvo = new OperatorlogVO();
			if(oprtype!=null && OprType.CREATE.equals(oprtype)){
				OperatorVO oldvo = dao.find(OperatorVO.class, operid);
				if(oldvo!=null){
					throw new RequestMessageException("请求信息[oprinfo.operid="+operid+"]工号信息已存在，新增数据主键冲突。");
				}
				this.executeSingleData(OprType.CREATE, oprvo);
				
				BeanUtils.copyProperties(logvo, oprvo);
				logvo.setOptime(new Date());
				logvo.setOprcode("CRMSYN");
				logvo.setOprtype(OprType.CREATE);
				logvo.setSuccess("success");
				this.executeBusinessLog(logvo);
				
			}else if(oprtype!=null && OprType.UPDATE.equals(oprtype)){
				OperatorVO oldvo = dao.find(OperatorVO.class, operid);
				if(oldvo==null){
					throw new RequestMessageException("请求信息[oprinfo.operid="+operid+"]工号信息不存在，不能更新数据。");
				}
				oprvo = (OperatorVO)SystemUtil.objectUpdate(oprvo, oldvo);
				this.executeSingleData(OprType.UPDATE, oprvo);
				
				BeanUtils.copyProperties(logvo, oprvo);
				logvo.setOptime(new Date());
				logvo.setOprcode("CRMSYN");
				logvo.setOprtype(OprType.UPDATE);
				logvo.setSuccess("success");
				this.executeBusinessLog(logvo);
			}else{
				throw new RequestMessageException("操作类型只能为create:新增 或者 update:更新。");
			}
		}catch(RequestMessageException e){//参数完整性校验-报文格式异常
			rspheader.getRetinfo().setRetcode(888001);
			rspheader.getRetinfo().setRetype(600);
			rspheader.getRetinfo().setRetmsg("报文格式异常:"+e.getMessage());
			log.info(processCode.get()+"报文格式异常:"+e.getMessage());
			System.out.println(processCode.get()+"报文格式异常:"+e.getMessage());
		}catch(Exception e){//其他异常，主要是数据库操作异常信息
			rspheader.getRetinfo().setRetcode(888002);
			rspheader.getRetinfo().setRetype(600);
			rspheader.getRetinfo().setRetmsg(e.getMessage());
			log.info(processCode.get()+e.getMessage());
			System.out.println(processCode.get()+e.getMessage());
		}
    	
		//System.out.println("-----I am out OprsynService.doBusiness()");
	}
	
	@Override
	public void checkReqBody(Object reqbody) throws RequestMessageException{
		if(reqbody==null){
			throw new RequestMessageException("请求体[msgbody]不能为空");
		}
		Oprsynreq.Msgbody rb = (Oprsynreq.Msgbody)reqbody;
		Oprsynreq.Msgbody.Oprinfo oprinfo = rb.getOprinfo();
		if(oprinfo==null){
			throw new RequestMessageException("请求体中[oprinfo]不能为空。");
		}
		String operid = oprinfo.getOperid();
		if(operid==null || "".equals(operid) || "null".equals(operid)){
			throw new RequestMessageException("请求体中[operid]不能为空。");
		}
		String oprtype = oprinfo.getOprtype();
		if(oprtype==null || "".equals(oprtype) || "null".equals(oprtype)){
			throw new RequestMessageException("请求体中[oprinfo.oprtype]主键不能为空，应为[create:新增;update:更新]");
		}else if(!oprtype.equals(OprType.CREATE) && !oprtype.equals(OprType.UPDATE)){
			throw new RequestMessageException("请求体中[oprinfo.oprtype]应为[create:新增;update:更新]");
		}
	}
	
	public OperatorVO buildOperatorVO(Oprsynreq.Msgbody.Oprinfo oprinfo) throws RequestMessageException{
		OperatorVO oprvo = new OperatorVO();
		try{
//			oprvo.setOptime(oprinfo.getOptime());
//			oprvo.setOprcode(oprinfo.getOprcode());
//			oprvo.setOprtype(oprinfo.getOprtype());
			oprvo.setOperid(oprinfo.getOperid());
			oprvo.setRegion(StringUtil.formatInteger("region", oprinfo.getRegion()));
			oprvo.setOpername(oprinfo.getOpername());
			oprvo.setPassword(oprinfo.getPassword());
			oprvo.setPasschgdate(StringUtil.changeStrToDate14("passchgdate", oprinfo.getPasschgdate()));
			oprvo.setOpergroup(oprinfo.getOpergroup());
			oprvo.setOpertype(oprinfo.getOpertype());
			oprvo.setOperlevel(oprinfo.getOperlevel());
			oprvo.setIsmanager(StringUtil.formatBoolean("ismanager", oprinfo.getIsmanager()));
			oprvo.setContactphone(oprinfo.getContactphone());
			oprvo.setOrgid(oprinfo.getOrgid());
			oprvo.setIsrestrict(StringUtil.formatBoolean("isrestrict", oprinfo.getIsrestrict()));
			oprvo.setStarttime(StringUtil.formatByte("starttime", oprinfo.getStarttime()));
			oprvo.setEndtime(StringUtil.formatByte("endtime", oprinfo.getEndtime()));
			oprvo.setEnablegprs(StringUtil.formatBoolean("enablegprs", oprinfo.getEnablegprs()));
			oprvo.setGprsstarttime(StringUtil.formatByte("gprsstarttime", oprinfo.getGprsstarttime()));
			oprvo.setGprsendtime(StringUtil.formatByte("gprsendtime", oprinfo.getGprsendtime()));
			oprvo.setIschkmac(StringUtil.formatBoolean("ischkmac", oprinfo.getIschkmac()));
			oprvo.setMac(oprinfo.getMac());
			oprvo.setNotes(oprinfo.getNotes());
			oprvo.setCreatedate(StringUtil.changeStrToDate14("createdate", oprinfo.getCreatedate()));
			oprvo.setStatus(StringUtil.formatBoolean("status", oprinfo.getStatus()));
			oprvo.setStatusdate(StringUtil.changeStrToDate14("statusdate", oprinfo.getStatusdate()));
			oprvo.setReleStaffId(oprinfo.getReleStaffId());
			oprvo.setStartUsingTime(StringUtil.changeStrToDate14("start_using_time", oprinfo.getStartUsingTime()));
			oprvo.setEndUsingTime(StringUtil.changeStrToDate14("end_using_time", oprinfo.getEndUsingTime()));
			oprvo.setLogintype(oprinfo.getLogintype());
			oprvo.setSmnotityflag(StringUtil.formatBoolean("smnotityflag", oprinfo.getSmnotityflag()));
		}catch(Exception e){
			throw new RequestMessageException(e.getMessage());
		}
		return oprvo;
	}
}
