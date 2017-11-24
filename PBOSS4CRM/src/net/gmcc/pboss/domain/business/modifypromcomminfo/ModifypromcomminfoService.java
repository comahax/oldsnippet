package net.gmcc.pboss.domain.business.modifypromcomminfo;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
//import java.util.Map;
import java.math.BigDecimal;

//import org.apache.commons.collections.MultiHashMap;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;

import net.gmcc.pboss.pboss4crmservice.Modifypromcomminforeq;
import net.gmcc.pboss.pboss4crmservice.Msgreqheader;
import net.gmcc.pboss.pboss4crmservice.Msgrspheader;
import net.gmcc.pboss.domain.additional.exception.RequestMessageException;
import net.gmcc.pboss.domain.business.OprType;
import net.gmcc.pboss.domain.business.service.BaseCrmService;
import net.gmcc.pboss.domain.model.employee.EmployeeVO;
import net.gmcc.pboss.domain.model.employee.EmployeelogVO;
import net.gmcc.pboss.domain.model.empmodel.EmpmodelVO;
import net.gmcc.pboss.domain.model.empmodel.EmpmodellogVO;
import net.gmcc.pboss.domain.model.way.WayVO;
import net.gmcc.pboss.utils.BeanUtils;
import net.gmcc.pboss.utils.ParamsUtil;
import net.gmcc.pboss.utils.StringUtil;

@Service
public class ModifypromcomminfoService extends BaseCrmService {
	private static final Logger log = Logger.getLogger(ModifypromcomminfoService.class);
	
	public void doBusiness(Modifypromcomminforeq request, Msgrspheader rspheader)throws Exception{
		try{
			Msgreqheader reqheader = request.getMsgreqheader();
			//校验请求信息头，构造反馈消息头
			this.checkAndSet(reqheader, rspheader);
			
			//校验请求消息体
			Modifypromcomminforeq.Msgbody reqbody = request.getMsgbody();
			this.checkReqBody(reqbody);
			
			String oprtype = reqbody.getOercode();			
			String wayid = this.getWayid(request);//agentcode
		
			//Map<String, Object> objectMap = new MultiHashMap();//入库对象
			
			if("1".equals(oprtype)){
				log.info(processCode.get()+"新增推广专员");
				System.out.println(processCode.get()+"新增推广专员");
				this.doInsert(request, rspheader, wayid);//, objectMap
			}else{
				log.info(processCode.get()+"修改推广专员");
				System.out.println(processCode.get()+"修改推广专员");
				this.doUpdate(request, rspheader, wayid);//, objectMap
			}
			
			//使用这种方式集中跟新数据，由于人员模式表和日志同时写，日志记录中无法获取序列生成的模式表中记录序号
			//所以改成单独写每条数据，整个业务一次最多写4条数据
			//写数据库
			//this.executeAllDatas(objectMap);
						
		}catch(RequestMessageException e){//参数完整性校验-报文格式异常
			rspheader.getRetinfo().setRetcode(111);
			rspheader.getRetinfo().setRetmsg("报文格式异常:"+e.getMessage());
			log.info(processCode.get()+"报文格式异常:"+e.getMessage());
			System.out.println(processCode.get()+"报文格式异常:"+e.getMessage());
		}catch(Exception e){//其他异常
			e.printStackTrace();
			rspheader.getRetinfo().setRetcode(111);
			rspheader.getRetinfo().setRetmsg("操作失败");//+e.getMessage()
			log.info(processCode.get()+"操作失败");
			System.out.println(processCode.get()+"操作失败");
		}
	}
	
	//1 新增
	private void doInsert(Modifypromcomminforeq request, Msgrspheader rspheader, 
			String wayid) throws Exception{		//, Map<String, Object> objectMap
		Modifypromcomminforeq.Msgbody reqbody = request.getMsgbody();
		
		EmployeeVO empinfo = null;
		//查询同一号码对应人员是否已存在，同一号码在人员表中只允许一个人员，若存在则修改，若不存在则插入
//		String emphql = "select e from EmployeeVO e,WayVO w where e.wayid=w.wayid and e.telephone=? and w.waytype='AG' and e.isnet=2 order by e.intime desc";
		String emphql = "select e from EmployeeVO e,WayVO w where e.wayid=w.wayid and e.telephone=? and e.isnet=2 order by e.intime desc";
		List<EmployeeVO> emplist = (ArrayList<EmployeeVO>)dao.find(emphql, reqbody.getMobileno());
		if(emplist!=null && emplist.size()>0){
			empinfo = emplist.get(0);
		}
		if(empinfo!=null){//号码对应的人员存在，修改已有数据			
			try{//UpdateEmployState
				this.updateEmployState(empinfo, reqbody, rspheader, wayid);//, objectMap
			}catch(Exception e){
				e.printStackTrace();
				rspheader.getRetinfo().setRetcode(111);
				rspheader.getRetinfo().setRetmsg("操作失败");
				EmployeelogVO logvo = this.createFailEmplogVO(reqbody, wayid, null);
				//objectMap.put(OprType.CREATE, logvo);
				this.executeBusinessLog(logvo);
			}
		}else{//号码对应人员不存在，新增数据
			String wayhql = "select w from WayVO w,WaycompactVO c where w.wayid=c.wayid and w.wayid=? and w.waystate=1 and c.isunpb=1";
			List<WayVO> waylist = (ArrayList<WayVO>)dao.find(wayhql, wayid);
			if(waylist!=null && waylist.size()>0){//渠道信息存在
				//WayVO wayinfo = waylist.get(0);
				try{//掺入数据 InsertIntoTable
					this.insertIntoTable(request, rspheader, wayid);//, objectMap
				}catch(Exception e){
					e.printStackTrace();
					rspheader.getRetinfo().setRetcode(111);
					rspheader.getRetinfo().setRetmsg("操作失败");
					EmployeelogVO emplogvo = this.createFailEmplogVO(reqbody, wayid, null);
					//objectMap.put(OprType.CREATE, emplogvo);
					this.executeBusinessLog(emplogvo);
				}
			}else{//渠道不存在
				rspheader.getRetinfo().setRetcode(1);
				rspheader.getRetinfo().setRetmsg("所属代理商不存在");
				EmployeelogVO emplogvo = this.createFailEmplogVO(reqbody, wayid, null);
				//objectMap.put(OprType.CREATE, emplogvo);
				this.executeBusinessLog(emplogvo);
			}
		}
	}
	
	//修改已有数据
	private void updateEmployState(EmployeeVO empinfo, Modifypromcomminforeq.Msgbody reqbody, Msgrspheader rspheader, 
			String wayid) //, Map<String, Object> objectMap
	throws Exception {
		if(empinfo.getEmpstatus()==1){//人员记录处于离职状态
			empinfo.setEmployeename(reqbody.getStaffname());
			empinfo.setSubname(reqbody.getStaffcode());								
			empinfo.setCardid(reqbody.getPersonid());
			empinfo.setPvtemail(reqbody.getEmail());
			empinfo.setRegdate(StringUtil.changeStrToDate14("regdate", reqbody.getRegisterdate()));
			empinfo.setIntime(StringUtil.changeStrToDate14("intime", reqbody.getEnabledate()));
			empinfo.setOuttime(StringUtil.changeStrToDate14("outtime", reqbody.getStopdate()));	
			empinfo.setWayid(wayid);//
			empinfo.setTelephone(reqbody.getMobileno());
			empinfo.setEmpstatus((byte)0);//
			empinfo.setWaytype("AG");//
			empinfo.setIsnet((byte)2);//
			empinfo.setIstenseed(StringUtil.formatShort("istenseed", reqbody.getIstenseed()));
			empinfo.setIsinternal(StringUtil.formatShort("isinternal", reqbody.getIsinternal()));
			//objectMap.put(OprType.UPDATE, empinfo);
			this.executeSingleData(OprType.UPDATE, empinfo);
			EmployeelogVO emplogvo = this.createSuccEmplogVO(reqbody, empinfo, wayid, empinfo.getEmployeeid());//null
			//objectMap.put(OprType.CREATE, emplogvo);
			this.executeBusinessLog(emplogvo);
			
			//获取模式表数据
			String modhql = "select m from EmpmodelVO m where m.employeeid=?";
			List<EmpmodelVO> modlist = (ArrayList<EmpmodelVO>)dao.find(modhql, empinfo.getEmployeeid());
			if(modlist==null || modlist.size()==0){//无数据，则插入
				EmpmodelVO modvo = new EmpmodelVO();
				modvo.setEmployeeid(empinfo.getEmployeeid());
				modvo.setModel("3");
				modvo.setState(StringUtil.formatShort("status", reqbody.getStatus()));
				//objectMap.put(OprType.CREATE, modvo);
				this.executeSingleData(OprType.CREATE, modvo);
				EmpmodellogVO modlogvo = this.createModlogVO(modvo, 0, OprType.CREATE, reqbody.getOercode());
				//objectMap.put(OprType.CREATE, modlogvo);
				this.executeBusinessLog(modlogvo);
				rspheader.getRetinfo().setRetcode(0);
				rspheader.getRetinfo().setRetmsg("成功");
			}else{//有数据，则更新
				EmpmodelVO modvo = modlist.get(0);
				modvo.setState(StringUtil.formatShort("status", reqbody.getStatus()));
				//objectMap.put(OprType.UPDATE, modvo);
				this.executeSingleData(OprType.UPDATE, modvo);
				EmpmodellogVO modlogvo = this.createModlogVO(modvo, 0, OprType.UPDATE, reqbody.getOercode());
				//objectMap.put(OprType.CREATE, modlogvo);
				this.executeBusinessLog(modlogvo);
				rspheader.getRetinfo().setRetcode(0);
				rspheader.getRetinfo().setRetmsg("成功");
			}
		}else{// 0-人员记录处于在岗状态
			//获取模式表数据
			String modhql = "select m from EmpmodelVO m where m.employeeid=?";
			List<EmpmodelVO> modlist = (ArrayList<EmpmodelVO>)dao.find(modhql, empinfo.getEmployeeid());
			if(modlist==null || modlist.size()==0){//无数据，则插入
				EmpmodelVO modvo = new EmpmodelVO();
				modvo.setEmployeeid(empinfo.getEmployeeid());
				modvo.setModel("3");
				modvo.setState(StringUtil.formatShort("status", reqbody.getStatus()));
				//objectMap.put(OprType.CREATE, modvo);
				this.executeSingleData(OprType.CREATE, modvo);
				EmpmodellogVO modlogvo = this.createModlogVO(modvo, 0, OprType.CREATE, reqbody.getOercode());
				//objectMap.put(OprType.CREATE, modlogvo);
				this.executeBusinessLog(modlogvo);
				
				rspheader.getRetinfo().setRetcode(0);
				rspheader.getRetinfo().setRetmsg("成功");
				EmployeelogVO emplogvo = this.createSuccEmplogVO(reqbody, empinfo, wayid, empinfo.getEmployeeid());//null
				//objectMap.put(OprType.CREATE, emplogvo);
				this.executeBusinessLog(emplogvo);
			}else{//有数据，进一步判断
				short reqstatus = StringUtil.formatShort("status", reqbody.getStatus());
				EmpmodelVO modvo = modlist.get(0);//应该只有一条数据，如果有多条数据那就先不处理了
				if(modvo.getState()==reqstatus){//有记录，且状态一致，报错
					rspheader.getRetinfo().setRetcode(2);
					rspheader.getRetinfo().setRetmsg("该号码已经被注册");
					EmployeelogVO logvo = this.createFailEmplogVO(reqbody, wayid, null);
					//objectMap.put(OprType.CREATE, logvo);
					this.executeBusinessLog(logvo);
				}else{
					modvo.setState(reqstatus);
					//objectMap.put(OprType.UPDATE, modvo);
					this.executeSingleData(OprType.UPDATE, modvo);
					EmpmodellogVO modlogvo = this.createModlogVO(modvo, 0, OprType.UPDATE, reqbody.getOercode());
					//objectMap.put(OprType.CREATE, modlogvo);
					this.executeSingleData(OprType.CREATE, modlogvo);
					
					rspheader.getRetinfo().setRetcode(0);
					rspheader.getRetinfo().setRetmsg("成功");
					EmployeelogVO emplogvo = this.createSuccEmplogVO(reqbody, empinfo, wayid, empinfo.getEmployeeid());//null
					//objectMap.put(OprType.CREATE, emplogvo);
					this.executeBusinessLog(emplogvo);
				}
			}
		}
	}
	
	//插入数据
	private void insertIntoTable(Modifypromcomminforeq request, Msgrspheader rspheader, 
			String wayid) throws Exception {//, Map<String, Object> objectMap
		Modifypromcomminforeq.Msgbody reqbody = request.getMsgbody();
		//新增人员记录
		String empid = this.getEmpid(request);	
		EmployeeVO empvo = new EmployeeVO();
		empvo.setEmployeeid(empid);
		empvo.setWayid(wayid);//reqbody.getAgentcode()
		empvo.setEmployeename(reqbody.getStaffname());
		empvo.setSubname(reqbody.getStaffcode());
		empvo.setTelephone(reqbody.getMobileno());
		empvo.setCardid(reqbody.getPersonid());
		empvo.setPvtemail(reqbody.getEmail());
		empvo.setRegdate(StringUtil.changeStrToDate14("regdate", reqbody.getRegisterdate()));
		empvo.setIntime(StringUtil.changeStrToDate14("intime", reqbody.getEnabledate()));
		empvo.setOuttime(StringUtil.changeStrToDate14("outtime", reqbody.getStopdate()));
		empvo.setWaytype("AG");
		empvo.setIsnet((byte)2);
		empvo.setEmpstatus((byte)0);
		empvo.setIstenseed(StringUtil.formatShort("istenseed", reqbody.getIstenseed()));
		empvo.setIsinternal(StringUtil.formatShort("isinternal", reqbody.getIsinternal()));
		//objectMap.put(OprType.CREATE, empvo);
		this.executeSingleData(OprType.CREATE, empvo);
		
		EmpmodelVO empmodvo = new EmpmodelVO();
		empmodvo.setEmployeeid(empid);
		empmodvo.setModel("3");
		empmodvo.setState(StringUtil.formatShort("status", reqbody.getStatus()));
		//objectMap.put(OprType.CREATE, empmodvo);
		this.executeSingleData(OprType.CREATE, empmodvo);
		EmpmodellogVO modlogvo = this.createModlogVO(empmodvo, 0, OprType.CREATE, reqbody.getOercode());
		//objectMap.put(OprType.CREATE, modlogvo);
		this.executeBusinessLog(modlogvo);
		
		rspheader.getRetinfo().setRetcode(0);
		rspheader.getRetinfo().setRetmsg("成功");
		EmployeelogVO emplogvo = this.createSuccEmplogVO(reqbody, empvo, wayid, empid);
		//objectMap.put(OprType.CREATE, emplogvo);
		this.executeBusinessLog(emplogvo);
	}
	
	//2 更新
	private void doUpdate(Modifypromcomminforeq request, Msgrspheader rspheader,
			String wayid) throws Exception {//, Map<String, Object> objectMap
		Modifypromcomminforeq.Msgbody reqbody = request.getMsgbody();		
		String empid = reqbody.getCommissionercode();//推广专员编号
		if(StringUtil.isNotEmpty(empid)){//推广专员编码不为空
			EmployeeVO empvo = dao.find(EmployeeVO.class, empid);
			if(empvo==null){//人员不存在
				rspheader.getRetinfo().setRetcode(3);
				rspheader.getRetinfo().setRetmsg("无法找到相应的推广专员，修改不成功");
				EmployeelogVO emplogvo = this.createFailEmplogVO(reqbody, wayid, null);
				//objectMap.put(OprType.CREATE, emplogvo);
				this.executeBusinessLog(emplogvo);
			}else{//人员存在
				try{//UpdateIntoTable					
					this.updateIntoTable(empvo, reqbody, rspheader, wayid);//, objectMap
				}catch(Exception e){
					e.printStackTrace();
					rspheader.getRetinfo().setRetcode(111);
					rspheader.getRetinfo().setRetmsg("操作失败");
					EmployeelogVO logvo = this.createFailEmplogVO(reqbody, wayid, empid);
					//objectMap.put(OprType.CREATE, logvo);
					this.executeBusinessLog(logvo);
				}
			}
		}else{//推广专员号码为空
			String empidsql = "select max(EMPLOYEEID) EMPLOYEEID from CH_PW_EMPLOYEE where wayid=? and REGDATE=to_date(?,'yyyymmddhh24miss') and telephone=? and ISNET=2";
			SQLQuery squery = dao.createSQLQuery(empidsql, wayid, reqbody.getRegisterdate(), reqbody.getMobileno());
			empid = (String)squery.uniqueResult();
			if(empid==null){//获取人员ID失败
				rspheader.getRetinfo().setRetcode(3);
				rspheader.getRetinfo().setRetmsg("无法找到相应的推广专员，修改不成功");
				EmployeelogVO logvo = this.createFailEmplogVO(reqbody, wayid, empid);
				//objectMap.put(OprType.CREATE, logvo);
				this.executeBusinessLog(logvo);
			}else{//UpdateIntoTable
				try{
					EmployeeVO empvo = dao.find(EmployeeVO.class, empid);
					this.updateIntoTable(empvo, reqbody, rspheader, wayid);//, objectMap
				}catch(Exception e){
					e.printStackTrace();
					rspheader.getRetinfo().setRetcode(111);
					rspheader.getRetinfo().setRetmsg("操作失败");
					EmployeelogVO logvo = this.createFailEmplogVO(reqbody, wayid, empid);
					//objectMap.put(OprType.CREATE, logvo);
					this.executeBusinessLog(logvo);
				}
			}				
		}
	}
	
	//更新数据
	private void updateIntoTable(EmployeeVO empvo, Modifypromcomminforeq.Msgbody reqbody, 
			Msgrspheader rspheader, String wayid)throws Exception{//, Map<String, Object> objectMap
		empvo.setEmployeename(reqbody.getStaffname());
		empvo.setSubname(reqbody.getStaffcode());
		empvo.setCardid(reqbody.getPersonid());
		empvo.setPvtemail(reqbody.getEmail());
		empvo.setRegdate(StringUtil.changeStrToDate14("regdate", reqbody.getRegisterdate()));
		empvo.setIntime(StringUtil.changeStrToDate14("intime", reqbody.getEnabledate()));
		empvo.setOuttime(StringUtil.changeStrToDate14("outtime", reqbody.getStopdate()));
		empvo.setIstenseed(StringUtil.formatShort("istenseed", reqbody.getIstenseed()));
		empvo.setIsinternal(StringUtil.formatShort("isinternal", reqbody.getIsinternal()));
		//objectMap.put(OprType.UPDATE, empvo);
		
		empvo.setIsnet((byte)2);
		empvo.setEmpstatus(StringUtil.formatByte("status", reqbody.getStatus()));
		
		this.executeSingleData(OprType.UPDATE, empvo);
		
		String modhql = "select m from EmpmodelVO m where m.employeeid=?";
		List<EmpmodelVO> modlist = (ArrayList<EmpmodelVO>)dao.find(modhql, empvo.getEmployeeid());
		if(modlist!=null && modlist.size()>0){//模式记录存在，更新
			EmpmodelVO modvo = modlist.get(0);
			modvo.setState(StringUtil.formatShort("status", reqbody.getStatus()));
			//objectMap.put(OprType.UPDATE, modvo);
			this.executeSingleData(OprType.UPDATE, modvo);
			EmpmodellogVO logvo = this.createModlogVO(modvo, 0, OprType.UPDATE, reqbody.getOercode());
			//objectMap.put(OprType.CREATE, logvo);
			this.executeBusinessLog(logvo);
		}else{//如果不存在：按照C++的实现逻辑，这种情况不存在，暂时不处理
			//因为更新数据来源于新增的数据，新增数据时人员表和人员模式表同时添加数据，
			//不会存在人员表有数据而人员模式表没有			
		}
		
		rspheader.getRetinfo().setRetcode(0);
		rspheader.getRetinfo().setRetmsg("成功");
		EmployeelogVO logvo = this.createSuccEmplogVO(reqbody, empvo, wayid, empvo.getEmployeeid());
		//objectMap.put(OprType.CREATE, logvo);
		this.executeBusinessLog(logvo);
	}
	
	private EmpmodellogVO createModlogVO(EmpmodelVO empvo, int succ, String oprtype, String oprcode){
		EmpmodellogVO logvo = new EmpmodellogVO();
		try{
			BeanUtils.copyProperties(logvo, empvo);
			logvo.setOptime(new Date());
			logvo.setOprcode(oprcode);
			logvo.setOprtype(oprtype);
			logvo.setSuccess(""+succ);			
		}catch(Exception e){
			return null;
		}
		return logvo;
	}
	private EmployeelogVO createFailEmplogVO(Modifypromcomminforeq.Msgbody reqbody, String wayid, String empid){//int succ,
		EmployeelogVO logvo = new EmployeelogVO();
		try{
			logvo.setOptime(new Date());
			logvo.setOprtype("Unpb");
			logvo.setSuccess("1");//失败
			
			logvo.setWayid(wayid);//
			logvo.setEmployeename(reqbody.getStaffname());
			logvo.setSubname(reqbody.getStaffcode());
			logvo.setTelephone(reqbody.getMobileno());
			logvo.setPvtemail(reqbody.getEmail());
			logvo.setRegdate(StringUtil.changeStrToDate14("regdate", reqbody.getRegisterdate()));
			logvo.setIntime(StringUtil.changeStrToDate14("intime", reqbody.getEnabledate()));
			logvo.setOuttime(StringUtil.changeStrToDate14("outtime", reqbody.getStopdate()));
			if(empid==null){
				logvo.setEmployeeid(reqbody.getCommissionercode());
			}else{
				logvo.setEmployeeid(empid);
			}
			logvo.setCardid(reqbody.getPersonid());			
			logvo.setEmpstatus(StringUtil.formatByte("status", reqbody.getStatus()));
			logvo.setWaytype("AG");
			logvo.setIsnet((byte)2);
			
			logvo.setOprcode(reqbody.getOercode());
		}catch(Exception e){
			return null;
		}
		return logvo;
	}
	private EmployeelogVO createSuccEmplogVO(Modifypromcomminforeq.Msgbody reqbody, EmployeeVO empvo, String wayid, String empid){//int succ,
		EmployeelogVO logvo = new EmployeelogVO();
		try{
			BeanUtils.copyProperties(logvo, empvo);
			logvo.setOptime(new Date());
			logvo.setOprtype("Unpb");
			logvo.setSuccess("0");//成功
			
			logvo.setWayid(wayid);//
			if(empid==null){
				logvo.setEmployeeid(reqbody.getCommissionercode());
			}else{
				logvo.setEmployeeid(empid);
			}
			logvo.setWaytype("AG");
			logvo.setIsnet((byte)2);
			
			logvo.setOprcode(reqbody.getOercode());						
		}catch(Exception e){
			return null;
		}
		return logvo;
	}
	
	@Override
	public void checkReqBody(Object reqbody) throws RequestMessageException {
		// TODO Auto-generated method stub
		if(reqbody==null){
			throw new RequestMessageException("请求体[msgbody]不能为空");
		}
		Modifypromcomminforeq.Msgbody rb = (Modifypromcomminforeq.Msgbody)reqbody;
		if(StringUtil.isEmpty(rb.getMobileno())){
			throw new RequestMessageException("请求体中[mobileno]不能为空。");
		}else{
			String mobileno = rb.getMobileno().trim();
			boolean valid = mobileno.matches("1[0-9]{10}");
			if(!valid){
				throw new RequestMessageException("请求体中[mobileno]必须为11位有效手机号码。");
			}
		}
		if(StringUtil.isEmpty(rb.getStaffcode())){
			rb.setStaffcode(rb.getMobileno());
		}
		if(StringUtil.isEmpty(rb.getStaffname())){
			rb.setStaffname(rb.getMobileno());
		}
		if(!StringUtil.checkDateTime14(rb.getRegisterdate())){
			throw new RequestMessageException("请求体中[registerdate]格式必须为YYYYMMDDHH24MISS。");
		}
		if(!StringUtil.checkDateTime14(rb.getEnabledate())){
			throw new RequestMessageException("请求体中[enabledate]格式必须为YYYYMMDDHH24MISS。");
		}
		if(!StringUtil.checkDateTime14(rb.getStopdate())){
			throw new RequestMessageException("请求体中[stopdate]格式必须为YYYYMMDDHH24MISS。");
		}
		if(StringUtil.isEmpty(rb.getStatus())){
			throw new RequestMessageException("请求体中[status]不能为空，取值约束[0正常;1:失效]。");
		}else{
			String status = rb.getStatus();
			if(!"1".equals(status) && !"0".equals(status)){
				throw new RequestMessageException("请求体中[status]取值约束[0正常;1:失效]。");
			}
		}
		if(StringUtil.isEmpty(rb.getOercode())){
			throw new RequestMessageException("请求体中[oercode]不能为空，取值约束[0正常;1:失效]。");
		}else{
			String oprcode = rb.getOercode();
			if(!"1".equals(oprcode) && !"2".equals(oprcode)){
				throw new RequestMessageException("请求体中[status]取值约束[1:新增;2:修改]。");
			}
		}
	}
	
	private String getWayid(Modifypromcomminforeq request){
		String wayid = request.getMsgbody().getAgentcode();
		if(StringUtil.isNotEmpty(wayid)){
			return wayid;
		}
		String cityno = request.getMsgreqheader().getRoute().getRouteValue();
		String cityid = ParamsUtil.getRegionLetterMap().get(cityno);
		wayid = cityid+"U_00000";
		return wayid;
	}
	
	private String getEmpid(Modifypromcomminforeq request)throws Exception{
		String empid = null;
		String cityno = request.getMsgreqheader().getRoute().getRouteValue();
		String cityid = ParamsUtil.getRegionLetterMap().get(cityno);
		String nextvalsql = "select CH_PW_EMPLOYEE_SEQ.NEXTVAL from  dual";
		SQLQuery sq = dao.createSQLQuery(nextvalsql, null);
		//不知道为什么下面两种方式会出错
		//Long nextval = dao.queryForLong(nextvalsql, null, null);
		//Long nextval = dao.findSingleBySQL(nextvalsql, Long.class, null);
		Long nextval = ((BigDecimal)sq.uniqueResult()).longValue();
		if(nextval!=null){
			empid = cityid+"UNRC_"+nextval.toString();
		}else{
			throw new Exception("无法生成人员编码");
		}
		
		return empid;
	}

}
