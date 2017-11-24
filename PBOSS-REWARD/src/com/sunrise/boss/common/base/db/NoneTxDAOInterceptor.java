package com.sunrise.boss.common.base.db;

import java.lang.reflect.*;
import java.util.*;
import net.sf.cglib.proxy.*;
import org.apache.commons.logging.*;

import com.sunrise.boss.business.common.dblog.*;
import com.sunrise.boss.common.dproxy.*;
import com.sunrise.boss.ui.commons.*;

/**
 *
 * <p>Title: NoneTxDAOInterceptor </p>
 *
 * <p>Description: 非事务型DAO拦截器.
 * <br>不能独立运行, 必须依赖外部进行事务控制,例如EJB. </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: sunrise Tech Ltd.</p>
 *
 * @author He Kun
 *
 * @version 1.0
 * 
 * 
 * 改方法现在不使用
 */
public class NoneTxDAOInterceptor extends InterceptorHandler {
	
	private static final Log log = LogFactory.getLog(NoneTxDAOInterceptor.class);
	
    private static List interceptors = new ArrayList(3);
    
    static {
    	registerInterceptor(DBLogInterceptor.class);
    }
    
    public NoneTxDAOInterceptor() {    	
    }   
  
    public static List getInterceptors()  {
    	return interceptors;
    }
}
