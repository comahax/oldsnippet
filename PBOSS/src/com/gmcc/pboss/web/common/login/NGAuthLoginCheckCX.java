package com.gmcc.pboss.web.common.login;

import java.net.URL;

import net.gmcc.ngcrm.pboss.uniteauth.UniteAuthWebService;
import net.gmcc.ngcrm.pboss.uniteauth.UniteAuthWebServicePortType;
import com.sunrise.jop.ui.User;
import com.sunrise.ws.client.Result;

public class NGAuthLoginCheckCX implements INGLoginCheck {
	private UniteAuthWebServicePortType client;	
	public NGAuthLoginCheckCX(URL wsdlurl){
		client = new UniteAuthWebService(wsdlurl).getUniteAuthWebServiceHttpPort();
	}
	
	public Result getLogintype(User user)throws Exception{
		int step = 0;
		String operid = user.getOprcode();
		String reqstr = NGLoginUtil.buildRequestText(step, null, operid, null);
		String rspstr = client.uniteAuth(reqstr);
		NGResult ngresult = new NGResult();
		try{
			NGLoginUtil.parseResponseXML(rspstr, ngresult);
		}catch(Exception e){
			e.printStackTrace();
			log.info("��Ӧ���Ľ����쳣��"+e.getMessage());
			throw new Exception("��Ӧ���Ľ����쳣��"+e.getMessage());
		}
		Result result = new Result();
		result.setResultCode(ngresult.getCode());
		result.setResultDec(ngresult.getAuthresult());
		result.setUserType(ngresult.getAuthresult());		
		return result;
	}
	
	public Result doSimpAuth(User user) throws Exception{
		int step = 1;
		String operid = user.getOprcode();
		String password = user.getPassword();
		String reqstr = NGLoginUtil.buildRequestText(step, SIMP_LOGIN, operid, password);
		String rspstr = client.uniteAuth(reqstr);
		NGResult ngresult = new NGResult();
		try{
			NGLoginUtil.parseResponseXML(rspstr, ngresult);
		}catch(Exception e){
			e.printStackTrace();
			log.info("��Ӧ���Ľ����쳣��"+e.getMessage());
			throw new Exception("��Ӧ���Ľ����쳣��"+e.getMessage());
		}
		Result result = new Result();
		result.setResultCode(ngresult.getCode());
		result.setResultDec(ngresult.getAuthresult());
		return result;
	}
	
	public Result doSecAuth(User user) throws Exception{
		int step = 1;
		String operid = user.getOprcode();
		String password = user.getPassword();
		String reqstr = NGLoginUtil.buildRequestText(step, SEC_LOGIN, operid, password);
		String rspstr = client.uniteAuth(reqstr);
		NGResult ngresult = new NGResult();
		try{
			NGLoginUtil.parseResponseXML(rspstr, ngresult);
		}catch(Exception e){
			e.printStackTrace();
			log.info("��Ӧ���Ľ����쳣��"+e.getMessage());
			throw new Exception("��Ӧ���Ľ����쳣��"+e.getMessage());
		}
		Result result = new Result();
		result.setResultCode(ngresult.getCode());
		result.setResultDec(ngresult.getAuthresult());
		return result;
	}
	
	public Result doSafewordAuth(User user)throws Exception{
		String logintype = CHALLENGE_LOGIN;
		NGResult ngresult = new NGResult();
		Result result = new Result();
		if(1==user.getStep()){
			String reqstr = NGLoginUtil.buildRequestText(user.getStep(), logintype, user.getOprcode(), null);
			String rspstr = client.uniteAuth(reqstr);			
			try{
				NGLoginUtil.parseResponseXML(rspstr, ngresult);
			}catch(Exception e){
				e.printStackTrace();
				log.info("��Ӧ���Ľ����쳣��"+e.getMessage());
				throw new Exception("��Ӧ���Ľ����쳣��"+e.getMessage());
			}
			result.setResultCode(ngresult.getCode());
			result.setResultDec(ngresult.getAuthresult());
		}else if(2==user.getStep()){
			String pwdAndSafemsg = user.getPassword()+MSG_SPLIT+user.getSafewordMessage();
			String reqstr = NGLoginUtil.buildRequestText(user.getStep(), logintype, user.getOprcode(), pwdAndSafemsg);
			String rspstr = client.uniteAuth(reqstr);			
			try{
				NGLoginUtil.parseResponseXML(rspstr, ngresult);
			}catch(Exception e){
				e.printStackTrace();
				log.info("��Ӧ���Ľ����쳣��"+e.getMessage());
				throw new Exception("��Ӧ���Ľ����쳣��"+e.getMessage());
			}
			result.setResultCode(ngresult.getCode());
			result.setResultDec(ngresult.getAuthresult());
		}else{
			log.info("�����������ֻ����[1:��ȡ��ս�룻2:��֤��ս].��ǰֵΪ"+user.getStep());
			throw new Exception("�����������ֻ����[1:��ȡ��ս�룻2:��֤��ս].��ǰֵΪ"+user.getStep());
		}		
		return result;
	}
	
	public Result doRSAAuth(User user) throws Exception{
		Result result = new Result();
		NGResult ngresult = new NGResult();
		String logintype = RSA_LOGIN;
		if(1==user.getStep()){
			String reqstr = NGLoginUtil.buildRequestText(user.getStep(), logintype, user.getOprcode(), user.getPassword());
			String rspstr = client.uniteAuth(reqstr);			
			try{
				NGLoginUtil.parseResponseXML(rspstr, ngresult);
			}catch(Exception e){
				e.printStackTrace();
				log.info("��Ӧ���Ľ����쳣��"+e.getMessage());
				throw new Exception("��Ӧ���Ľ����쳣��"+e.getMessage());
			}
			result.setResultCode(ngresult.getCode());
			result.setResultDec(ngresult.getAuthresult());
		}else if(2==user.getStep()){
			String reqstr = NGLoginUtil.buildRequestText(user.getStep(), logintype, user.getOprcode(), user.getCurToken());
			String rspstr = client.uniteAuth(reqstr);			
			try{
				NGLoginUtil.parseResponseXML(rspstr, ngresult);
			}catch(Exception e){
				e.printStackTrace();
				log.info("��Ӧ���Ľ����쳣��"+e.getMessage());
				throw new Exception("��Ӧ���Ľ����쳣��"+e.getMessage());
			}
			result.setResultCode(ngresult.getCode());
			result.setResultDec(ngresult.getAuthresult());
		}else if(3==user.getStep()){
			String tokens = user.getCurToken()+"|"+user.getNextToken();
			String reqstr = NGLoginUtil.buildRequestText(user.getStep(), logintype, user.getOprcode(), tokens);
			String rspstr = client.uniteAuth(reqstr);			
			try{
				NGLoginUtil.parseResponseXML(rspstr, ngresult);
			}catch(Exception e){
				e.printStackTrace();
				log.info("��Ӧ���Ľ����쳣��"+e.getMessage());
				throw new Exception("��Ӧ���Ľ����쳣��"+e.getMessage());
			}
			result.setResultCode(ngresult.getCode());
			result.setResultDec(ngresult.getAuthresult());
		}else{
			log.info("�����������ֻ����1��3.��ǰֵΪ"+user.getStep());
			throw new Exception("�����������ֻ����1��3.��ǰֵΪ"+user.getStep());
		}		
		return result;
	}
	
	public String getSIMP_LOGIN() {
		return SIMP_LOGIN;
	}

	public String getSEC_LOGIN() {
		return SEC_LOGIN;
	}

	public String getCHALLENGE_LOGIN() {
		return CHALLENGE_LOGIN;
	}

	public String getRSA_LOGIN() {
		return RSA_LOGIN;
	}
}