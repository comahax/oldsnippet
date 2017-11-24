package net.gmcc.pboss.domain.business.b2m.smsbosyn;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.gmcc.pboss.b2mservice.Smsbosynrequest;
import net.gmcc.pboss.b2mservice.Smsbosynresponse;
import net.gmcc.pboss.domain.additional.exception.RequestMessageException;
import net.gmcc.pboss.domain.business.service.BaseB2MService;
import net.gmcc.pboss.domain.model.realtimefail.RealtimefailVO;
import net.gmcc.pboss.domain.model.realtimesucc.RealtimesuccVO;
import net.gmcc.pboss.utils.ParamsUtil;
import net.gmcc.pboss.utils.StringUtil;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
@Service
public class SmsbosynService extends BaseB2MService {
	private static final Logger log = Logger.getLogger(SmsbosynService.class);
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	public void doBusiness(Smsbosynrequest req, Smsbosynresponse rsp){
		try{
			//校验请求信息头，构造反馈消息头
			this.checkAndSet(req.getMsgreqheader(), rsp.getMsgrspheader());
			//校验请求消息体
			this.checkReqBody(req.getMsgbody());
			
			log.info(processCode.get()+req.getMsgbody());
			log.info(processCode.get()+"-------------------------[日办理业务数据实时接口:smsbosyn]处理请求：校验请求消息体-----");
			//逻辑处理
			Smsbosynrequest.Msgbody rbody = req.getMsgbody();
			log.info("-------------------------[日办理业务数据实时接口:smsbosyn]处理请求：rbody-----"+rbody);
			String opnid = rbody.getOpnid().trim();
			String calcmonth = rbody.getCalcmonth().trim();
			String wayid = rbody.getWayid().trim();
			String mobile = rbody.getMobile().trim();
			String cityid =null;
			try{//路由信息必须为route:routetype=0，routevalue=760形式					
				String cityno = req.getMsgreqheader().getRoute();
				cityid = ParamsUtil.getRegionLetterMap().get(cityno);
			}catch(Exception e){//存在null引用，不处理异常，待业务处理类中校验报文时处理
			}
			log.info("[日办理业务数据实时接口:smsbosyn]处理请求：rbody-----opnid:"+opnid+"-----calcmonth:"+calcmonth+"-----wayid:"+wayid+"-----mobile:"+mobile);
			// 判断代理商的合法性
			boolean wayValid = this.checkWay(wayid);
			if (!wayValid) {// 渠道无效，登记失败表
				rsp.getMsgrspheader().getRetinfo().setRettype(600);
				rsp.getMsgrspheader().getRetinfo().setRetcode(600);
				rsp.getMsgrspheader().getRetinfo().setRetmsg("输入的代理商编码无效");
				RealtimefailVO failvo = new RealtimefailVO();
				//BeanUtils.copyProperties(failvo, req.getMsgbody());
				this.buildFail(failvo, req.getMsgbody());
				failvo.setRuleid("ZINC");
				failvo.setSrc("办理业务数据实时接口");
				failvo.setAdtremark("");
				dao.save(failvo);
				log.info("-------------------------[渠道无效，登记失败表：输入的代理商编码无效、办理业务数据实时接口、输入的代理商编码无效-----");
				return;
			}
			// 校验用户在网时长是否大于2年
			boolean less2Year = this.checkYear(cityid,mobile);
			if (less2Year) {// 不足2年，登记失败表
				rsp.getMsgrspheader().getRetinfo().setRettype(601);
				rsp.getMsgrspheader().getRetinfo().setRetcode(601);
				rsp.getMsgrspheader().getRetinfo().setRetmsg("用户在网时长不足2年");
				RealtimefailVO failvo = new RealtimefailVO();
				//BeanUtils.copyProperties(failvo, req.getMsgbody());
				this.buildFail(failvo, req.getMsgbody());
				failvo.setRuleid("ZINC");
				failvo.setSrc("办理业务数据实时接口");
				failvo.setAdtremark("用户在网时长不足2年");
				dao.save(failvo);
				log.info("-------------------------[渠道无效，登记失败表：用户在网时长不足2年、办理业务数据实时接口、用户在网时长不足2年-----");
				return;
			}
			// 校验过去三月都未办理该业务
			boolean less3Month = this.checkMonth(calcmonth, mobile, opnid);
			if (!less3Month) {// 少于3个月，登记失败表
				rsp.getMsgrspheader().getRetinfo().setRettype(602);
				rsp.getMsgrspheader().getRetinfo().setRetcode(602);
				rsp.getMsgrspheader().getRetinfo().setRetmsg("该用户过去三个月已办理过该业务");
				RealtimefailVO failvo = new RealtimefailVO();
				//BeanUtils.copyProperties(failvo, req.getMsgbody());
				this.buildFail(failvo, req.getMsgbody());
				failvo.setRuleid("ZINC");
				failvo.setSrc("办理业务数据实时接口");
				failvo.setAdtremark("该用户过去三个月已办理过该业务");
				dao.save(failvo);
				log.info("-------------------------[渠道无效，登记失败表：该用户过去三个月已办理过该业务、办理业务数据实时接口、该用户过去三个月已办理过该业务-----");
				return;
			}
			// 所有检验通过，登记成功表
			rsp.getMsgrspheader().getRetinfo().setRettype(0);
			rsp.getMsgrspheader().getRetinfo().setRetcode(0);
			rsp.getMsgrspheader().getRetinfo().setRetmsg("校验成功");
			RealtimesuccVO succvo = new RealtimesuccVO();
			//BeanUtils.copyProperties(succvo, req.getMsgbody());
			this.buildSucc(succvo, req.getMsgbody());
			succvo.setSrc("办理业务数据实时接口");
			succvo.setAdtremark("校验成功");
			dao.save(succvo);
			log.info(processCode.get()+"-------------------------[日办理业务数据实时接口:smsbosyn]处理请求：完成-----");
		}catch(RequestMessageException ex){
			rsp.getMsgrspheader().getRetinfo().setRettype(500);
			rsp.getMsgrspheader().getRetinfo().setRetcode(500);
			rsp.getMsgrspheader().getRetinfo().setRetmsg("报文格式异常:"+ex.getMessage());
			log.error(processCode.get()+"报文格式异常:"+ex.getMessage());
			log.error(processCode.get()+"-------------------------[日办理业务数据实时接口:smsbosyn]处理请求：结束-----");	
		}catch(Exception ex){
			rsp.getMsgrspheader().getRetinfo().setRettype(600);
			rsp.getMsgrspheader().getRetinfo().setRetcode(600);
			rsp.getMsgrspheader().getRetinfo().setRetmsg(ex.getMessage());
			ex.printStackTrace();
			log.error(processCode.get()+ex.getMessage());
			log.error(processCode.get()+"-------------------------[日办理业务数据实时接口:smsbosyn]处理请求：结束-----");
		}
	}
	
	private void buildSucc(RealtimesuccVO vo, Smsbosynrequest.Msgbody rb)throws Exception{
	    vo.setBusivalue(Double.parseDouble(rb.getBusivalue()));
		vo.setCalcmonth(rb.getCalcmonth());
		vo.setCalcopnid(rb.getCalcopnid());
		vo.setMobile(rb.getMobile());
		vo.setCreattime(new Date());
		vo.setOpnid(rb.getOpnid());
		vo.setOprcode(rb.getOprcode());
		vo.setOprtime(new SimpleDateFormat("yyyyMMddhhmmss").parse(rb.getOprtime()));
		vo.setRuleid("ZINC");
		vo.setSrcseq(rb.getSrcseq());
		vo.setWayid(rb.getWayid());
	}
	
	private void buildFail(RealtimefailVO failvo, Smsbosynrequest.Msgbody rb) throws Exception{
		failvo.setBusivalue(Double.parseDouble(rb.getBusivalue()));
		failvo.setCalcmonth(rb.getCalcmonth());
		failvo.setCalcopnid(rb.getCalcopnid());
		failvo.setMobile(rb.getMobile());
		failvo.setCreattime(new Date());
		failvo.setOpnid(rb.getOpnid());
		failvo.setOprcode(rb.getOprcode());
		failvo.setOprtime(new SimpleDateFormat("yyyyMMddhhmmss").parse(rb.getOprtime()));
		failvo.setRuleid("ZINC");
		failvo.setSrcseq(rb.getSrcseq());
		failvo.setWayid(rb.getWayid());
	}
	
	private boolean checkMonth(String calcmonth, String mobile, String opnid){
		StringBuffer sql = new StringBuffer();
		//只检查历史表有逻辑校验漏洞，更改SQL逻辑
//		sql.append("select count(1) from CH_BBC_ALLSALESHIS ");
//		sql.append("  where CALCMONTH IN (to_char(add_months(to_date(?,'yyyymm'), -1), 'yyyymm'),");
//		sql.append("    to_char(add_months(to_date(?,'yyyymm'), -2), 'yyyymm'),");
//		sql.append("    to_char(add_months(to_date(?,'yyyymm'), -3), 'yyyymm'))");
//		sql.append("   and mobile = ? and opnid = ?");
		sql.append("select count(1) ");
		sql.append("  from (select mobile from CH_BBC_ALLSALESHIS ");
		sql.append("         where CALCMONTH IN ");
		sql.append("               (to_char(add_months(to_date(?, 'yyyymm'), -1),'yyyymm'), ");
		sql.append("                to_char(add_months(to_date(?, 'yyyymm'), -2),'yyyymm'), ");
		sql.append("                to_char(add_months(to_date(?, 'yyyymm'), -3),'yyyymm')) ");
		sql.append("           and mobile = ? and opnid = ? ");
		sql.append("        union ");
		sql.append("        select mobile from CH_BBC_REALTIMEFAIL ");
		sql.append("         where calcmonth = ? ");
		sql.append("           and mobile = ? and opnid = ? ");
		sql.append("        union ");
		sql.append("        select mobile from CH_BBC_REALTIMESUCC ");
		sql.append("         where calcmonth = ? ");
		sql.append("           and mobile = ? and opnid = ? ");
		sql.append("       ) a ");
		//Integer result = dao.queryForInt(sql.toString(), -1, calcmonth, calcmonth, calcmonth, mobile, opnid);
		log.info("-------------------------[日办理业务数据实时接口:smsbosyn]SQL_checkMonth：-----"+sql);
		try {
			SQLQuery squery = dao.createSQLQuery(sql.toString(), calcmonth, calcmonth, calcmonth, mobile, opnid,
					calcmonth, mobile, opnid, 
					calcmonth, mobile, opnid);
			Integer result = ((BigDecimal)squery.uniqueResult()).intValue();
			if(result == 0){
				return true;
			}
		} catch (DataAccessException ex) {
			// TODO Auto-generated catch block
			log.error(processCode.get()+"createSQLQuery异常:"+ex.getMessage());
			log.error(processCode.get()+"-------------------------[日办理业务数据实时接口:smsbosyn]处理checkMonth_createSQLQuery请求：异常");	
			ex.printStackTrace();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			log.error(processCode.get()+"squery.uniqueResult异常:"+e.getMessage());
			log.error(processCode.get()+"-------------------------[日办理业务数据实时接口:smsbosyn]处理checkMonth_squery.uniqueResult请求：异常");	
			e.printStackTrace();
		}
		return false;
	}
	
	private boolean checkYear(String cityid,String mobile){
		StringBuffer sql = new StringBuffer();
		sql.append("select count(1) from CRM_CM_SUBS_SUBSCRIBER ");
//		sql.append("select SUBSID from CRM_CM_SUBS_SUBSCRIBER ");
		sql.append("  where SERVNUMBER = ? ");
		sql.append("   and status not in ('US99','US27') and sysdate - startdate >= 365 * 2 ");
		//Integer result = dao.queryForInt(sql.toString(), -1, mobile);
		log.info("-------------------------[日办理业务数据实时接口:smsbosyn]SQL_checkYear：-----"+sql);
		try {

			SQLQuery squery = dao.createSQLQuery(sql.toString(), mobile);
			Integer result = ((BigDecimal)squery.uniqueResult()).intValue();
			if(result == 0){
				return true;
			}
			

		}catch (DataAccessException ex) {
			// TODO Auto-generated catch block
			log.error(processCode.get()+"createSQLQuery异常:"+ex.getMessage());
			log.error(processCode.get()+"-------------------------[日办理业务数据实时接口:smsbosyn]处理checkYear_createSQLQuery请求：异常");	
			ex.getMessage();
			ex.printStackTrace();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			log.error(processCode.get()+"createSQLQuery异常:"+e);
			log.error(processCode.get()+"squery.uniqueResult异常:"+e.getMessage());
			log.error(processCode.get()+"-------------------------[日办理业务数据实时接口:smsbosyn]处理checkYear_squery.uniqueResult请求：异常");	
			e.getMessage();
			e.printStackTrace();
		}
		return false;
	}
	
	private boolean checkWay(String wayid){		
		String sql = "select count(1) from ch_pw_waycompact c,ch_pw_way w where w.wayid=c.wayid and c.isunpb=1 and w.waystate=1 and w.wayid=?";
		log.info("-------------------------[日办理业务数据实时接口:smsbosyn]SQL_checkWay：-----"+sql);
		SQLQuery squery = dao.createSQLQuery(sql, wayid);
		Integer result = ((BigDecimal)squery.uniqueResult()).intValue();
		if(result > 0){//渠道有效存在
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	protected void checkReqBody(Object reqbody) throws RequestMessageException {
		// TODO Auto-generated method stub
		Smsbosynrequest.Msgbody body = (Smsbosynrequest.Msgbody)reqbody;		
		StringBuffer errMsg = new StringBuffer("");
		if(StringUtil.isEmpty(body.getSrcseq())){
			log.info(processCode.get()+"-------------------------[日办理业务数据实时接口:smsbosyn]处理请求body.getSrcseq()：消息体中业务流水号[srcseq]不能为空异常");	
			errMsg.append("消息体中业务流水号[srcseq]不能为空 ");
		}
		if(StringUtil.isEmpty(body.getOpnid())){
			log.info(processCode.get()+"-------------------------[日办理业务数据实时接口:smsbosyn]处理请求body.getOpnid()：消息体中发生业务编码[opnid]不能为空");
			errMsg.append("消息体中发生业务编码[opnid]不能为空  ");
		}
		if(StringUtil.isEmpty(body.getCalcopnid())){
			log.info(processCode.get()+"-------------------------[日办理业务数据实时接口:smsbosyn]处理请求calcopnid：消息体中发生业务编码[calcopnid]不能为空");
			errMsg.append("消息体中结算业务编码[calcopnid]不能为空 ");
		}
		if(!StringUtil.checkMonth(body.getCalcmonth())){
			log.info(processCode.get()+"-------------------------[日办理业务数据实时接口:smsbosyn]处理请求calcmonth：消息体中结算月份[calcmonth]不能为空，且格式必须为yyyyMM");
			errMsg.append("消息体中结算月份[calcmonth]不能为空，且格式必须为yyyyMM ");
		}
		if(StringUtil.isEmpty(body.getWayid())){
			log.info(processCode.get()+"-------------------------[日办理业务数据实时接口:smsbosyn]处理请求wayid：消息体中业务发生渠道[wayid]不能为空 ");
			errMsg.append("消息体中业务发生渠道[wayid]不能为空 ");
		}
		if(!StringUtil.checkDateTime14(body.getOprtime())){
			log.info(processCode.get()+"-------------------------[日办理业务数据实时接口:smsbosyn]处理请求oprtime：消息体中业务发生时间[oprtime]不能为空，且格式必须为YYYYMMDDHH24MISS");
			errMsg.append("消息体中业务发生时间[oprtime]不能为空，且格式必须为YYYYMMDDHH24MISS ");
		}
		if(StringUtil.isEmpty(body.getOprcode())){
			log.info(processCode.get()+"-------------------------[日办理业务数据实时接口:smsbosyn]处理请求oprcode：消息体中推广专员手机号码[oprcode]不能为空");
			errMsg.append("消息体中推广专员手机号码[oprcode]不能为空 ");
		}
		if(StringUtil.isEmpty(body.getMobile())){
			log.info(processCode.get()+"-------------------------[日办理业务数据实时接口:smsbosyn]处理请求mobile：消息体中客户号码[mobile]不能为空 ");
			errMsg.append("消息体中客户号码[mobile]不能为空 ");
		}
		if(StringUtil.isEmpty(body.getBusivalue()) || !"1".equals(body.getBusivalue().trim())){
			log.info(processCode.get()+"-------------------------[日办理业务数据实时接口:smsbosyn]处理请求busivalue：消息体中号码发生的业务量[busivalue]必须为1");
			errMsg.append("消息体中号码发生的业务量[busivalue]必须为1 ");
		}
		if(StringUtil.isEmpty(body.getRewardtype()) || !"9".equals(body.getRewardtype().trim())){
			log.info(processCode.get()+"-------------------------[日办理业务数据实时接口:smsbosyn]处理请求rewardtype：消息体中酬金类型[rewardtype]必须为9 ");
			errMsg.append("消息体中酬金类型[rewardtype]必须为9 ");
		}
		if(StringUtil.isEmpty(body.getOssrc()) || !this.isOssrcValid(body.getOssrc().trim())){
			log.info(processCode.get()+"-------------------------[日办理业务数据实时接口:smsbosyn]处理请求ossrc：消息体中业务平台来源[ossrc]必须为3-全员代理短信、4-全员代理OTA、5-全员代理WAP");
			errMsg.append("消息体中业务平台来源[ossrc]必须为3-全员代理短信、4-全员代理OTA、5-全员代理WAP ");
		}
		if(!"".equals(errMsg.toString())){
			log.info(processCode.get()+"请求消息体[msgbody]属性:" + errMsg.toString());
			throw new RequestMessageException("请求消息体[msgbody]属性:" + errMsg.toString());
		}
	}
	
	//业务平台来源	3-全员代理短信 4-全员代理OTA  5-全员代理WAP
	private boolean isOssrcValid(String ossrc){
		if( "3".equals(ossrc) || "4".equals(ossrc) || "5".equals(ossrc) ){
			return true;
		}else{
			return false;
		}
	}
}
