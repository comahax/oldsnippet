package com.gmcc.pboss.biz.info.rewardtd.rewardtdfail.service.imp;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.gmcc.pboss.biz.info.rewardtd.rewardtdfail.dao.RewardTdFailDao;
import com.gmcc.pboss.biz.info.rewardtd.rewardtdfail.service.RewardTdFailService;
import com.gmcc.pboss.biz.info.rewardtd.rewardtdfail.support.RewardTdFailInfo;
import com.gmcc.pboss.biz.info.rewardtd.rewardtdfail.support.RewardTdFailQueryParamProcessor;
import com.gmcc.pboss.biz.info.rewardtd.rewardtdfail.support.RewardTdFailQueryParameter;
import com.gmcc.pboss.biz.info.rewardtd.rewardtdsuc.dao.RewardTdSucDao;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;

public class RewardTdFailServiceImpl extends BaseServiceImpl implements  RewardTdFailService {

	private RewardTdFailDao rewardTdFailDao;
	private RewardTdSucDao rewardTdSucDao;
	
	/**
	 * ����������ServiceCode��ServiceName��ֵ
	 */
	public  RewardTdFailServiceImpl() {
		super();
		this.serviceCode = ServiceCode.REWARDTD_FAIL;
		this.serviceName = "�ն˼Ƴ�ʧ����ϸ";
		this.isNeedLogin = true;
		this.setProcessor(new RewardTdFailQueryParamProcessor());//����в�ͬ�Ĳ�ѯ������Ҫ��query�����ж�̬set��һ���Ļ�����������д��
		
	}
	
	public ServiceResult other(LoginMember member, QueryParameter parameter) {
		ServiceResult ret = new ServiceResult();
		ret.setSuccess(false);
		ret.setRetCode(ServiceRetCode.FAIL); 
		RewardTdFailQueryParameter param = (RewardTdFailQueryParameter) parameter; 
		List<RewardTdFailInfo> retlist = new ArrayList<RewardTdFailInfo>(); 
		
//		List busistat = this.rewardTdFailDao.getrewardTdfail(param);
		
		//��ѯ����������
		this.setProcessor(new RewardTdFailQueryParamProcessor());
		QueryResult queryResult = this.rewardTdFailDao.getAllSQL(this.getProcessor(),parameter);
		//�Բ�ѯ�������ݽ��з�װ������װ���������Ϊ������
		List busistat = queryResult.getData();
		//�л������⡷��comame�޷�����CRM�Ŀ����
		SessionFactoryContextHolder.setSessionFactoryContext(null);
		for (Iterator ite = busistat.iterator(); ite.hasNext();) {
			Object obje[] = (Object[]) ite.next();
			RewardTdFailInfo info = new RewardTdFailInfo();   
			info.setName((String)obje[0]); 
			if ( null !=obje[1] ){  
				info.setRewardtype("h".equals(obje[1].toString())?"��Լ�ն˳��":"����ն˳��"); 
			}else{
				info.setRewardtype("");
			} 
			//info.setComname((String)obje[2]);
			String comame = "";
			if((String)obje[2] !=null && !"".equals((String)obje[2])){
				 comame = this.rewardTdSucDao.getComnameSuc((String)obje[2]);
			if(comame == null){
				info.setComname((String)obje[2]);
			}else{
				info.setComname(comame);
			}
			}
			info.setBakinfo((String)obje[3]);
			info.setMobile((String)obje[4]);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			if(null!= obje[5] && !("").equals(obje[5])){
				   info.setOprtime(df.format(obje[5])); 
				} 
			info.setRewardmonth((String)obje[6]); 
			info.setAcctype(null==obje[7] ||("").equals(obje[7])?0:Short.parseShort(obje[7].toString()));
			info.setRewardstd(null==obje[8] ||("").equals(obje[8])?0:(new BigDecimal(obje[8].toString())).doubleValue());
			info.setPaysum(null==obje[9] ||("").equals(obje[9])?0:(new BigDecimal(obje[9].toString())).doubleValue()); 
			info.setAssegrade(null==obje[10] ||("").equals(obje[10])?0:(new BigDecimal(obje[10].toString())).doubleValue());
			info.setWrapfee(null==obje[11] ||("").equals(obje[11])?0:(new BigDecimal(obje[11].toString())).doubleValue());
			info.setAssegrade2(null==obje[12] ||("").equals(obje[12])?0:(new BigDecimal(obje[12].toString())).doubleValue());
			info.setNoncyc(null==obje[13] ||("").equals(obje[13])?0:Short.parseShort(obje[13].toString()));
			info.setBakinfo7((String)obje[14]);
			info.setBakinfo8((String)obje[15]);
			info.setFailreason((String)obje[16]); 
			retlist.add(info);
		} 
		
		//�л��ص��п�
		SessionFactoryContextHolder.setSessionFactoryContext(member.getCityid());
		
		queryResult = new QueryResult(queryResult.getPage(),retlist);
		ret.setRetObject(null);//����getAll,ֻ����QueryResult,û�б�Ҫ����RetObject
		ret.setSuccess(true);
		ret.setRetCode(ServiceRetCode.SUCCESS);
		ret.setRetResult(new QueryResult(queryResult.getPage(),retlist)); 
		return ret;
	}

	public RewardTdFailDao getRewardTdFailDao() {
		return rewardTdFailDao;
	}

	public void setRewardTdFailDao(RewardTdFailDao rewardTdFailDao) {
		this.rewardTdFailDao = rewardTdFailDao;
	}

	public RewardTdSucDao getRewardTdSucDao() {
		return rewardTdSucDao;
	}

	public void setRewardTdSucDao(RewardTdSucDao rewardTdSucDao) {
		this.rewardTdSucDao = rewardTdSucDao;
	}

}
