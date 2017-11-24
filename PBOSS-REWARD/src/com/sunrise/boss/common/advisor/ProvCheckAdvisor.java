package com.sunrise.boss.common.advisor;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.sunrise.boss.ui.commons.User;

public class ProvCheckAdvisor implements MethodInterceptor{
	private static Pattern pattern;
	
	static {		
		pattern = Pattern.compile("1[0-9]{10}");
	}
	
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object result = null;
//		Object object = invocation.getThis();
//		Method method = invocation.getMethod();
		Object[] args = invocation.getArguments();
//		Object target = invocation.getStaticPart();
		//��ȡ��¼User
		User user = null;
		for(int i=args.length;i>0;i--){
			if(User.class.isInstance(args[i-1])){
				user = (User)args[i-1];
				break;
			}
		}
		if(user != null){//����ҵ�User�����ݺ����ʡ��˾��Ա��Ȩ�޼��
			String phone = user.getOpercode().trim();
			if(pattern.matcher(phone).find()){//����������ֻ����룬Ϊʡ��˾��Ա��¼���������޸�Ȩ��
				throw new Exception("�ù���û�в�����Ȩ�ޡ�");
			}else{
				try{
					result = invocation.proceed();
					return result;
				}catch(Exception e){
					throw e;
				}
			}
		}else{//��������ҵ�User��ֱ�Ӵ���
			try{
				result = invocation.proceed();
				return result;
			}catch(Exception e){
				throw e;
			}
		}
		
	}
}
