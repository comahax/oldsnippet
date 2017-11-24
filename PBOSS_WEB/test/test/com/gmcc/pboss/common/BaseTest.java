package test.com.gmcc.pboss.common;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.struts2.ServletActionContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import com.opensymphony.xwork2.ActionContext;

/**
 * 测试基础类
 */
public abstract class BaseTest extends AbstractDependencyInjectionSpringContextTests {
	private static String context = "context";
	protected transient final Log log = logger;

	protected String[] getConfigLocations() {
		super.setAutowireMode(AUTOWIRE_BY_NAME);
		return new String[] { 
				//"classpath:spring/*.xml"
//		"classpath:spring/applicationContext-action.xml",
		"classpath:spring/applicationContext-dao.xml",
		"classpath:spring/applicationContext-datasource.xml",
		"classpath:spring/applicationContext-hibernate.xml",
//		"classpath:spring/applicationContext-quartz.xml",
		"classpath:spring/applicationContext-removeService.xml",
		"classpath:spring/applicationContext-service.xml",
		"classpath:spring/applicationContext-transaction.xml"
		};
	}

	protected void onSetUpBeforeTransaction() throws Exception {
		ActionContext.getContext().setSession(new HashMap());
	}

	protected void onTearDownAfterTransaction() throws Exception {
		ActionContext.getContext().setSession(null);
	}

	public BaseTest() {
		super();
		setAutowireMode(AUTOWIRE_BY_NAME);
		init();
	}

	public BaseTest(String name) {
		super(name);
		setAutowireMode(AUTOWIRE_BY_NAME);
		init();
	}

	public void init() {
		// populate the request so getRequest().getSession() doesn't fail in
		// BaseAction.java
		ServletActionContext.setRequest(new MockHttpServletRequest());
		ServletActionContext.setServletContext(new MockServletContext());
		ServletActionContext.getServletContext().setAttribute(context, this.getApplicationContext());
		// // 初始化默认用户
		// ContextImpl impl = (ContextImpl)ContextUtil.getContext();
		// impl.defaultUser();

	}

}
