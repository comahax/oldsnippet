package com.sunrise.jop.common.provcheck;

import java.util.regex.Pattern;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.jop.common.spring.AbstractAdvisor;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;

public class ProvCheckAdvisor extends AbstractAdvisor {

	private static Log log = LogFactory.getLog(ProvCheckAdvisor.class);
	
	private static Pattern pattern;
	
	static {		
		pattern = Pattern.compile("1[0-9]{10}");
	}
	
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object result = null;
		
		Object object = invocation.getThis();
//		Method method = invocation.getMethod();
//		Object[] args = invocation.getArguments();
//		Object target = invocation.getStaticPart();
		
		AbstractControl control = (AbstractControl) object;
		DBAccessUser user = control.getUser();
		String oprcode = user.getOprcode().trim();
		if(pattern.matcher(oprcode).find()){//����������ֻ����룬Ϊʡ��˾��Ա��¼���������޸�Ȩ��
			throw new Exception("�ù���û�в�����Ȩ�ޡ�");
		}else{
			try {
				result = invocation.proceed();
				return result;
			} catch (Exception e) {
				throw e;
			}
		}		
		//return result;
	}
}
