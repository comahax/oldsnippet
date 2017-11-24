package net.gmcc.pboss.domain.business.waysyn;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import net.gmcc.pboss.pboss4crmservice.Msgreqheader;
import net.gmcc.pboss.pboss4crmservice.Msgrspheader;
import net.gmcc.pboss.pboss4crmservice.Waysynreq;
import net.gmcc.pboss.domain.additional.exception.RequestMessageException;
import net.gmcc.pboss.domain.business.AbstractService;
import net.gmcc.pboss.domain.business.OprType;
import net.gmcc.pboss.domain.business.service.BaseCrmService;
import net.gmcc.pboss.domain.model.way.WayVO;
import net.gmcc.pboss.domain.model.way.WaylogVO;
import net.gmcc.pboss.utils.StringUtil;
import net.gmcc.pboss.utils.SystemUtil;
import net.gmcc.pboss.utils.BeanUtils;

@Service
public class WaysynService extends BaseCrmService {
	private static final Logger log = Logger.getLogger(WaysynService.class);
	
	public void doBusiness(Waysynreq request, Msgrspheader rspheader)throws Exception{		
		try{		
			Msgreqheader reqheader = request.getMsgreqheader();
			//校验请求信息头，构造反馈消息头
			this.checkAndSet(reqheader, rspheader);
			
			//校验请求消息体
			Waysynreq.Msgbody reqbody = request.getMsgbody();			
			this.checkReqBody(reqbody);
			Waysynreq.Msgbody.Wayinfo wayinfo = reqbody.getWayinfo();
			String wayid = wayinfo.getWayid();
			String oprtype = wayinfo.getOprtype();
			
			WayVO wayvo = this.buildWayVO(wayinfo);
			
			WaylogVO logvo = new WaylogVO();
			if(oprtype!=null && OprType.CREATE.equals(oprtype)){
				WayVO exist = dao.find(WayVO.class, wayid);
				if(exist!=null){
					throw new RequestMessageException("新增渠道[wayid:"+wayid+"]pboss已存在");
				}			
				this.executeSingleData(OprType.CREATE, wayvo);
				
				BeanUtils.copyProperties(logvo, wayvo);
				logvo.setOptime(new Date());
				logvo.setOprcode("CRMSYN");
				logvo.setOprtype(OprType.CREATE);
				logvo.setSuccess("success");
				this.executeBusinessLog(logvo);
			}else if(oprtype!=null && OprType.UPDATE.equals(oprtype)){
				WayVO oldwayvo = dao.find(WayVO.class, wayid);
				if(oldwayvo==null){
					throw new RequestMessageException("修改渠道[wayid:"+wayid+"]pboss不存在");
				}
				wayvo = (WayVO)SystemUtil.objectUpdate(wayvo, oldwayvo);
				this.executeSingleData(OprType.UPDATE, wayvo);
				
				BeanUtils.copyProperties(logvo, wayvo);
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

	}
	
	public void checkReqBody(Object reqbody) throws RequestMessageException{
		if(reqbody==null){
			throw new RequestMessageException("请求体[msgBody]不能为空");
		}
		Waysynreq.Msgbody rb = (Waysynreq.Msgbody)reqbody;
		Waysynreq.Msgbody.Wayinfo wayinfo = rb.getWayinfo();
		if(wayinfo==null){
			throw new RequestMessageException("请求体中[wayinfo]不能为空");
		}
		String wayid = wayinfo.getWayid();
		if(wayid==null || "".equals(wayid) || "null".equals(wayid)){
			throw new RequestMessageException("请求体中[wayinfo.wayid]主键不能为空");
		}
		String oprtype = wayinfo.getOprtype();
		if(oprtype==null || "".equals(oprtype) || "null".equals(oprtype)){
			throw new RequestMessageException("请求体中[wayinfo.oprtype]主键不能为空，应为[create:新增;update:更新]");
		}else if(!oprtype.equals(OprType.CREATE) && !oprtype.equals(OprType.UPDATE)){
			throw new RequestMessageException("请求体中[wayinfo.oprtype]应为[create:新增;update:更新]");
		}
	}
	
	private WayVO buildWayVO(Waysynreq.Msgbody.Wayinfo wayinfo) throws RequestMessageException{
		WayVO wayvo = new WayVO();
		try{			
			wayvo.setWayid(wayinfo.getWayid());
			wayvo.setShortname(wayinfo.getShortname());
			wayvo.setSvbrchcode(wayinfo.getSvbrchcode());
			wayvo.setSvccode(wayinfo.getSvccode());
			wayvo.setMareacode(wayinfo.getMareacode());
			wayvo.setBuztypecode(StringUtil.formatByte("Wayinfo.buztypecode", wayinfo.getBuztypecode()));
			wayvo.setAdtypecode(StringUtil.formatByte("Wayinfo.adtypecode",wayinfo.getAdtypecode()));
			wayvo.setAddress(wayinfo.getAddress());
			wayvo.setLogiscode(wayinfo.getLogiscode());
			wayvo.setLatitude(wayinfo.getLatitude());
			wayvo.setLongtitude(wayinfo.getLongtitude());
			wayvo.setAdacode(wayinfo.getAdacode());
			wayvo.setWaymagcode(wayinfo.getWaymagcode());
			wayvo.setCatetype(StringUtil.formatByte("Wayinfo.catetype",wayinfo.getCatetype()));
			wayvo.setFormtype(StringUtil.formatByte("Wayinfo.formtype",wayinfo.getFormtype()));
			wayvo.setStarttime(StringUtil.changeStrToDate14("Wayinfo.starttime",wayinfo.getStarttime()));
			wayvo.setBuzarea(StringUtil.formatInteger("Wayinfo.buzarea",wayinfo.getBuzarea()));
			wayvo.setMainlayer(StringUtil.formatByte("Wayinfo.mainlayer",wayinfo.getMainlayer()));
			wayvo.setSublayer(StringUtil.formatByte("Wayinfo.sublayer",wayinfo.getSublayer()));
			wayvo.setBuzphoneno(wayinfo.getBuzphoneno());
			wayvo.setWayname(wayinfo.getWayname());
			wayvo.setCooperator(StringUtil.formatByte("Wayinfo.cooperator",wayinfo.getCooperator()));
			wayvo.setWaytype(wayinfo.getWaytype());
			wayvo.setWaysubtype(wayinfo.getWaysubtype());
			wayvo.setCusttype(wayinfo.getCusttype());
			wayvo.setUpperwayid(wayinfo.getUpperwayid());
			wayvo.setBusicode(wayinfo.getBusicode());
			wayvo.setCountyid(wayinfo.getCountyid());
			wayvo.setCityid(wayinfo.getCityid());
			wayvo.setCenterid(wayinfo.getCenterid());
			wayvo.setCitylevel(StringUtil.formatShort("Wayinfo.citylevel",wayinfo.getCitylevel()));
			wayvo.setWaylevel(StringUtil.formatShort("Wayinfo.waylevel",wayinfo.getWaylevel()));
			wayvo.setBchlevel(wayinfo.getBchlevel());
			wayvo.setFunction(wayinfo.getFunction());
			wayvo.setMiscode(wayinfo.getMiscode());
			wayvo.setCreatetime(StringUtil.changeStrToDate14("Wayinfo.createtime",wayinfo.getCreatetime()));
			wayvo.setDisabletime(StringUtil.changeStrToDate14("Wayinfo.disabletime",wayinfo.getDisabletime()));
			wayvo.setWaystate(StringUtil.formatShort("Wayinfo.waystate",wayinfo.getWaystate()));
			wayvo.setRunbyself(wayinfo.getRunbyself());
			wayvo.setDepotdet(wayinfo.getDepotdet());
			wayvo.setIsshare(wayinfo.getIsshare());
			wayvo.setAlarmbizamount(StringUtil.formatLong("Wayinfo.alarmbizamount",wayinfo.getAlarmbizamount()));
			wayvo.setPrtsource(StringUtil.formatByte("Wayinfo.prtsource",wayinfo.getPrtsource()));
			wayvo.setIsconnected(StringUtil.formatByte("Wayinfo.isconnected",wayinfo.getIsconnected()));
			wayvo.setConnecttype(StringUtil.formatByte("Wayinfo.connecttype",wayinfo.getConnecttype()));
			wayvo.setRunmode(StringUtil.formatByte("Wayinfo.runmode",wayinfo.getRunmode()));
			wayvo.setIscoreway(StringUtil.formatByte("Wayinfo.iscoreway",wayinfo.getIscoreway()));
			wayvo.setStarlevel(StringUtil.formatByte("Wayinfo.starlevel",wayinfo.getStarlevel()));
			wayvo.setPt(StringUtil.formatByte("Wayinfo.pt",wayinfo.getPt()));
			wayvo.setChainhead(wayinfo.getChainhead());
			wayvo.setSignstatus(StringUtil.formatByte("Wayinfo.signstatus",wayinfo.getSignstatus()));
			wayvo.setEmpnumber(StringUtil.formatShort("Wayinfo.empnumber",wayinfo.getEmpnumber()));
			wayvo.setMagnumber(StringUtil.formatShort("Wayinfo.magnumber",wayinfo.getMagnumber()));
			wayvo.setTerminumber(StringUtil.formatShort("Wayinfo.terminumber",wayinfo.getTerminumber()));
			wayvo.setUpdatedate(StringUtil.changeStrToDate14("Wayinfo.updatedate",wayinfo.getUpdatedate()));
			wayvo.setIsstraitprd(StringUtil.formatByte("Wayinfo.isstraitprd",wayinfo.getIsstraitprd()));
			wayvo.setTaxtype(StringUtil.formatByte("Wayinfo.taxtype",wayinfo.getTaxtype()));
			wayvo.setIstietong(StringUtil.formatByte("Wayinfo.istietong",wayinfo.getIstietong()));
			wayvo.setRivltype(StringUtil.formatShort("Wayinfo.rivltype",wayinfo.getRivltype()));
			wayvo.setIskzcz(StringUtil.formatShort("Wayinfo.iskzcz",wayinfo.getIskzcz()));
			wayvo.setDistype(StringUtil.formatShort("Wayinfo.distype",wayinfo.getDistype()));
			wayvo.setCalcumode(StringUtil.formatShort("Wayinfo.calcumode",wayinfo.getCalcumode()));
			wayvo.setUniformtime(wayinfo.getUniformtime());
			wayvo.setChecked(wayinfo.getChecked());			
			wayvo.setBuzmanager(wayinfo.getBuzmanager());
			wayvo.setSubrunmode(StringUtil.formatShort("Wayinfo.subrunmode",wayinfo.getSubrunmode()));
		}catch(Exception e){
			throw new RequestMessageException(e.getMessage());
		}
		return wayvo;		
	}
}
