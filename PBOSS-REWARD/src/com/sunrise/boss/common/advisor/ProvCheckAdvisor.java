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
		//获取登录User
		User user = null;
		for(int i=args.length;i>0;i--){
			if(User.class.isInstance(args[i-1])){
				user = (User)args[i-1];
				break;
			}
		}
		if(user != null){//如果找到User，根据号码对省公司人员做权限检查
			String phone = user.getOpercode().trim();
			if(pattern.matcher(phone).find()){//如果工号是手机号码，为省公司人员登录，无数据修改权限
				throw new Exception("该工号没有操作的权限。");
			}else{
				try{
					result = invocation.proceed();
					return result;
				}catch(Exception e){
					throw e;
				}
			}
		}else{//如果不能找到User，直接处理
			try{
				result = invocation.proceed();
				return result;
			}catch(Exception e){
				throw e;
			}
		}
		
	}
}
