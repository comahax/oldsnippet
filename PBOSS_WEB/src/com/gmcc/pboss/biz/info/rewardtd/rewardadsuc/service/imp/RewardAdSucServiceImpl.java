package com.gmcc.pboss.biz.info.rewardtd.rewardadsuc.service.imp;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.biz.info.rewardtd.rewardadsuc.dao.RewardAdSucDao;
import com.gmcc.pboss.biz.info.rewardtd.rewardadsuc.service.RewardAdSucService;
import com.gmcc.pboss.biz.info.rewardtd.rewardadsuc.support.RewardAdSucInfo;
import com.gmcc.pboss.biz.info.rewardtd.rewardadsuc.support.RewardAdSucQueryParamProcessor;
import com.gmcc.pboss.biz.info.rewardtd.rewardadsuc.support.RewardAdSucQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.HttpDictionary;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.sun.jmx.snmp.UserAcl;

public class RewardAdSucServiceImpl extends BaseServiceImpl implements RewardAdSucService{

private RewardAdSucDao rewardAdSucDao;
	
	/**
	 * ����������ServiceCode��ServiceName��ֵ
	 */
	public  RewardAdSucServiceImpl() {
		super();
		this.serviceCode = ServiceCode.REWARDAD_SUC;
		this.serviceName = "�ն�Ԥ���Ƴ�ɹ���ϸ";
		this.isNeedLogin = true;
		this.setProcessor(new RewardAdSucQueryParamProcessor());//����в�ͬ�Ĳ�ѯ������Ҫ��query�����ж�̬set��һ���Ļ�����������д��
		
	}
	
	public ServiceResult other(LoginMember member, QueryParameter parameter) {
		ServiceResult ret = new ServiceResult();
		ret.setSuccess(false);
		ret.setRetCode(ServiceRetCode.FAIL);

		RewardAdSucQueryParameter param = (RewardAdSucQueryParameter) parameter; 
		List<RewardAdSucInfo> retlist = new ArrayList<RewardAdSucInfo>(); 
		
		//��ѯ����������
		this.setProcessor(new RewardAdSucQueryParamProcessor());
		QueryResult queryResult = this.rewardAdSucDao.getAllSQL(this.getProcessor(),parameter);
		
		//List busistat = this.rewardTdSucDao.getrewartTdSuc(param);//gai
		//�Բ�ѯ�������ݽ��з�װ������װ���������Ϊ������
		List busistat = queryResult.getData();
		
		//�л������⡷��comame�޷�����CRM�Ŀ����
		SessionFactoryContextHolder.setSessionFactoryContext(null);
		
		for (Iterator ite = busistat.iterator(); ite.hasNext();) { 
			Object obje[] = (Object[]) ite.next();
			RewardAdSucInfo info = new RewardAdSucInfo();   
			info.setName((String)obje[0]);
			info.setRewardtype((String)obje[1]);
			//Com
			//String comame = ComService.getInfo((String)obje[2]);
			
			String comame = "";
			if((String)obje[2] !=null && !"".equals((String)obje[2])){
				 comame = this.rewardAdSucDao.getComnameSuc((String)obje[2]);
			if(comame == null){
				info.setComname((String)obje[2]);
			}else{
				info.setComname(comame);
			}
			}
			
			//info.setComname(comame);
			
//			info.setComname((String)obje[2]);
			//
			
			info.setBakinfo((String)obje[3]);
			info.setMobile((String)obje[4]);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			if(null!= obje[5] && !("").equals(obje[5])){
			   info.setOprtime(df.format(obje[5])); 
			}
			info.setRewardmonth((String)obje[6]); 
			info.setAcctype((String)obje[7]); 
			info.setRewardstd(null==obje[8] ||("").equals(obje[8])?0:(new BigDecimal(obje[8].toString())).doubleValue());
			info.setPaysum(null==obje[9] || ("").equals(obje[9])?0:(new BigDecimal(obje[9].toString())).doubleValue()); 
			info.setAssegrade(null==obje[10] || ("").equals(obje[10]) ? 0 : (new BigDecimal(obje[10].toString())).doubleValue());  
			info.setWrapfee(null==obje[11] || ("").equals(obje[11]) ? 0 : (new BigDecimal(obje[11].toString())).doubleValue()); 
			info.setAssegrade2(null==obje[12] || ("").equals(obje[12]) ? 0 :(new BigDecimal(obje[12].toString())).doubleValue());   
			info.setNoncyc(null==obje[13] || ("").equals(obje[13]) ? 0 : Short.parseShort(obje[13].toString()));
			info.setBakinfo7((String)obje[14]);
			info.setBakinfo8((String)obje[15]);
			info.setFailreason("�ɹ�");  
			
			retlist.add(info);
		} 
		
		//�л��ص��п�
		SessionFactoryContextHolder.setSessionFactoryContext(member.getCityid());
		System.out.println("cityid"+member.getCityid());
		queryResult = new QueryResult(queryResult.getPage(),retlist);
		

		ret.setRetObject(null);//����getAll,ֻ����QueryResult,û�б�Ҫ����RetObject
		ret.setSuccess(true);
		ret.setRetCode(ServiceRetCode.SUCCESS);
		ret.setRetResult(new QueryResult(queryResult.getPage(),retlist)); 
		return ret;
	}

	public Map<String,String> getDictitemRestype(){
		return rewardAdSucDao.getDictitemRestype();
	}
	
	public RewardAdSucDao getRewardAdSucDao() {
		return rewardAdSucDao;
	}

	public void setRewardAdSucDao(RewardAdSucDao rewardAdSucDao) {
		this.rewardAdSucDao = rewardAdSucDao;
	}
	
}
