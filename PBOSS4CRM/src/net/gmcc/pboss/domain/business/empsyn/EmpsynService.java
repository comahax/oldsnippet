package net.gmcc.pboss.domain.business.empsyn;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import net.gmcc.pboss.pboss4crmservice.Msgreqheader;
import net.gmcc.pboss.pboss4crmservice.Msgrspheader;
import net.gmcc.pboss.pboss4crmservice.Empsynreq;
import net.gmcc.pboss.domain.additional.exception.RequestMessageException;
import net.gmcc.pboss.domain.business.OprType;
import net.gmcc.pboss.domain.business.service.BaseCrmService;
import net.gmcc.pboss.utils.StringUtil;
import net.gmcc.pboss.utils.SystemUtil;
import net.gmcc.pboss.utils.BeanUtils;
import net.gmcc.pboss.domain.model.employee.EmployeeVO;
import net.gmcc.pboss.domain.model.employee.EmployeelogVO;

@Service
public class EmpsynService extends BaseCrmService {
	private static final Logger log = Logger.getLogger(EmpsynService.class);
	
	public void doBusiness(Empsynreq request, Msgrspheader rspheader)throws Exception{
		try{
			Msgreqheader reqheader = request.getMsgreqheader();
			//校验请求信息头，构造反馈消息头
			this.checkAndSet(reqheader, rspheader);
			
			//校验请求消息体
			Empsynreq.Msgbody reqbody = request.getMsgbody();
			this.checkReqBody(reqbody);
			
			Empsynreq.Msgbody.Empinfo empinfo = reqbody.getEmpinfo();
			String empid = empinfo.getEmployeeid();		
			String oprtype = empinfo.getOprtype();
			
			EmployeeVO empvo = this.buildEmployeeVO(empinfo);
			
			EmployeelogVO logvo = new EmployeelogVO();
			if(oprtype!=null && OprType.CREATE.equals(oprtype)){
				EmployeeVO oldvo = dao.find(EmployeeVO.class, empid);
				if(oldvo!=null){
					throw new RequestMessageException("请求信息[empinfo.employeeid="+empinfo.getEmployeeid()+"]人员编码已存在，主键冲突。");
				}
				this.executeSingleData(OprType.CREATE, empvo);
				
				BeanUtils.copyProperties(logvo, empvo);
				logvo.setOptime(new Date());
				logvo.setOprcode("CRMSYN");
				logvo.setOprcode2(empvo.getOprcode());//
				logvo.setOprtype(OprType.CREATE);
				logvo.setSuccess("success");
				this.executeBusinessLog(logvo);
			}else if(oprtype!=null && OprType.UPDATE.equals(oprtype)){
				EmployeeVO oldvo = dao.find(EmployeeVO.class, empid);
				if(oldvo==null){
					throw new RequestMessageException("请求信息[empinfo.employeeid="+empinfo.getEmployeeid()+"]人员编码不存在，不能更新。");
				}
				empvo = (EmployeeVO)SystemUtil.objectUpdate(empvo, oldvo);
				this.executeSingleData(OprType.UPDATE, empvo);
				
				BeanUtils.copyProperties(logvo, empvo);
				logvo.setOptime(new Date());
				logvo.setOprcode("CRMSYN");
				logvo.setOprcode2(empvo.getOprcode());//
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
	}
	
	public void checkReqBody(Object reqbody) throws RequestMessageException{
		if(reqbody==null){
			throw new RequestMessageException("请求体[msgbody]不能为空");
		}
		Empsynreq.Msgbody rb = (Empsynreq.Msgbody)reqbody;
		Empsynreq.Msgbody.Empinfo empinfo = rb.getEmpinfo();
		if(empinfo==null){
			throw new RequestMessageException("请求体中[empinfo]不能为空。");
		}
		String empid = empinfo.getEmployeeid();
		if(empid==null || "".equals(empid) || "null".equals(empid)){
			throw new RequestMessageException("请求体中[employeeid]不能为空。");
		}		
		String oprtype = empinfo.getOprtype();
		if(oprtype==null || "".equals(oprtype) || "null".equals(oprtype)){
			throw new RequestMessageException("请求体中[oprinfo.oprtype]主键不能为空，应为[create:新增;update:更新]");
		}else if(!oprtype.equals(OprType.CREATE) && !oprtype.equals(OprType.UPDATE)){
			throw new RequestMessageException("请求体中[oprinfo.oprtype]应为[create:新增;update:更新]");
		}
	}
	
	private EmployeeVO buildEmployeeVO(Empsynreq.Msgbody.Empinfo empinfo)throws RequestMessageException{
		EmployeeVO empvo = new EmployeeVO();
		
		try{
			empvo.setEmployeeid(empinfo.getEmployeeid());
			empvo.setOprcode(empinfo.getOprcode());
			empvo.setEmployeename(empinfo.getEmployeename());
			empvo.setBirthday(StringUtil.changeStrToDate14("birthday", empinfo.getBirthday()));
			empvo.setSex(StringUtil.formatShort("sex", empinfo.getSex()));
			empvo.setEdulevel(StringUtil.formatShort("edulevel", empinfo.getEdulevel()));
			empvo.setNativehome(empinfo.getNativehome());
			empvo.setPolivisage(StringUtil.formatShort("polivisage", empinfo.getPolivisage()));
			empvo.setDepartment(empinfo.getDepartment());
			empvo.setServoffice(empinfo.getServoffice());
			empvo.setStation(StringUtil.formatLong("station", empinfo.getStation()));
			empvo.setJoblevel(StringUtil.formatShort("joblevel", empinfo.getJoblevel()));
			empvo.setIntime(StringUtil.changeStrToDate14("intime", empinfo.getIntime()));
			empvo.setWorktime(StringUtil.formatShort("worktime", empinfo.getWorktime()));
			empvo.setHereworktime(StringUtil.formatShort("hereworktime", empinfo.getHereworktime()));
			empvo.setEmploytype(StringUtil.formatShort("employtype", empinfo.getEmploytype()));
			empvo.setCompany(empinfo.getCompany());
			empvo.setTelephone(empinfo.getTelephone());
			empvo.setOfficetel(empinfo.getOfficetel());
			empvo.setOuttime(StringUtil.changeStrToDate14("outtime", empinfo.getOuttime()));
			empvo.setOutresult(empinfo.getOutresult());
			empvo.setHomeaddr(empinfo.getHomeaddr());
			empvo.setCardid(empinfo.getCardid());
			empvo.setWayid(empinfo.getWayid());
			empvo.setWaytype(empinfo.getWaytype());
			empvo.setPvtemail(empinfo.getPvtemail());
			empvo.setOfcphone(empinfo.getOfcphone());
			empvo.setOfcemail(empinfo.getOfcemail());
			empvo.setSpeciality(empinfo.getSpeciality());
			empvo.setCityid(empinfo.getCityid());
			empvo.setCountyid(empinfo.getCountyid());
			empvo.setSvccode(empinfo.getSvccode());
			empvo.setPosittype(empinfo.getPosittype());
			empvo.setContacttype(StringUtil.formatByte("contacttype", empinfo.getContacttype()));
			empvo.setEmpstatus(StringUtil.formatByte("empstatus", empinfo.getEmpstatus()));
			empvo.setActbank(empinfo.getActbank());
			empvo.setActno(empinfo.getActno());
			empvo.setActname(empinfo.getActname());
			empvo.setActpid(empinfo.getActpid());
			empvo.setBail(StringUtil.formatDouble("bail", empinfo.getBail()));
			empvo.setGradschool(empinfo.getGradschool());
			empvo.setGradtime(StringUtil.changeStrToDate14("gradtime", empinfo.getGradtime()));
			empvo.setIsmarried(StringUtil.formatByte("ismarried", empinfo.getIsmarried()));
			empvo.setOutreason(StringUtil.formatByte("outreason", empinfo.getOutreason()));
			empvo.setTrainlevel(empinfo.getTrainlevel());
			empvo.setHobby(empinfo.getHobby());
			empvo.setCharacter(empinfo.getCharacter());
			empvo.setAsses(empinfo.getAsses());
			empvo.setWorkhistry(empinfo.getWorkhistry());
			empvo.setPrizeorpunish(empinfo.getPrizeorpunish());
			empvo.setEmpass(empinfo.getEmpass());
			empvo.setRight(StringUtil.formatByte("right", empinfo.getRight()));
			empvo.setIsnet(StringUtil.formatByte("isnet", empinfo.getIsnet()));
			empvo.setNetpass(empinfo.getNetpass());
			empvo.setIsopen(StringUtil.formatByte("isopen", empinfo.getIsopen()));
			empvo.setSelectmobile(empinfo.getSelectmobile());
			empvo.setSubname(empinfo.getSubname());
			empvo.setRegdate(StringUtil.changeStrToDate14("regdate", empinfo.getRegdate()));
			empvo.setEmpattr(empinfo.getEmpattr());
			empvo.setEmpattrmemo(empinfo.getEmpattrmemo());
			empvo.setIstenseed(StringUtil.formatShort("istenseed", empinfo.getIstenseed()));
			empvo.setIsinternal(StringUtil.formatShort("isinternal", empinfo.getIsinternal()));
		}catch(Exception e){
			throw new RequestMessageException(e.getMessage());
		}
		
		return empvo;
	}
}
