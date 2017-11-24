package com.asisinfo.common.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.LastModified;
import org.springframework.web.servlet.mvc.multiaction.InternalPathMethodNameResolver;
import org.springframework.web.servlet.mvc.multiaction.MethodNameResolver;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import com.asisinfo.common.json.JSONUtils;

/**
 * 所有controller的基类，改写自MultiActionController
 * 主要是支持了在controller中定义Map/ResultMap类型的数据，该类可以自动将数据转换成json格式进行响应
 * @author johnson
 * @see org.springframework.web.servlet.mvc.multiaction.MultiActionController
 */
public class BaseController extends AbstractController implements LastModified {

	/** Suffix for last-modified methods */
	public static final String LAST_MODIFIED_METHOD_SUFFIX = "LastModified";

	/** Default command name used for binding command objects: "command" */
	public static final String DEFAULT_COMMAND_NAME = "command";

	/**
	 * Log category to use when no mapped handler is found for a request.
	 * @see #pageNotFoundLogger
	 */
	public static final String PAGE_NOT_FOUND_LOG_CATEGORY = "org.springframework.web.servlet.PageNotFound";


	/**
	 * Additional logger to use when no mapped handler is found for a request.
	 * @see #PAGE_NOT_FOUND_LOG_CATEGORY
	 */
	protected static final Logger pageNotFoundLogger = LoggerFactory.getLogger(PAGE_NOT_FOUND_LOG_CATEGORY);

	/** Object we'll invoke methods on. Defaults to this. */
	private Object delegate;

	/** Delegate that knows how to determine method names from incoming requests */
	private MethodNameResolver methodNameResolver = new InternalPathMethodNameResolver();

	/** List of Validators to apply to commands */
	private Validator[] validators;

	/** Optional strategy for pre-initializing data binding */
	private WebBindingInitializer webBindingInitializer;

	/** Handler methods, keyed by name */
	private final Map handlerMethodMap = new HashMap();

	/** LastModified methods, keyed by handler method name (without LAST_MODIFIED_SUFFIX) */
	private final Map lastModifiedMethodMap = new HashMap();

	/** Methods, keyed by exception class */
	private final Map exceptionHandlerMap = new HashMap();
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());


	/**
	 * Constructor for <code>MultiActionController</code> that looks for
	 * handler methods in the present subclass.
	 */
	public BaseController() {
		this.delegate = this;
		registerHandlerMethods(this.delegate);
		// We'll accept no handler methods found here - a delegate might be set later on.
	}

	/**
	 * Constructor for <code>MultiActionController</code> that looks for
	 * handler methods in delegate, rather than a subclass of this class.
	 * @param delegate handler object. This does not need to implement any
	 * particular interface, as everything is done using reflection.
	 */
	public BaseController(Object delegate) {
		setDelegate(delegate);
	}


	/**
	 * Set the delegate used by this class; the default is <code>this</code>,
	 * assuming that handler methods have been added by a subclass.
	 * <p>This method does not get invoked once the class is configured.
	 * @param delegate an object containing handler methods
	 * @throws IllegalStateException if no handler methods are found
	 */
	public final void setDelegate(Object delegate) {
		Assert.notNull(delegate, "Delegate must not be null");
		this.delegate = delegate;
		registerHandlerMethods(this.delegate);
		// There must be SOME handler methods.
		if (this.handlerMethodMap.isEmpty()) {
			throw new IllegalStateException("No handler methods in class [" + this.delegate.getClass() + "]");
		}
	}

	/**
	 * Set the method name resolver that this class should use.
	 * <p>Allows parameterization of handler method mappings.
	 */
	public final void setMethodNameResolver(MethodNameResolver methodNameResolver) {
		this.methodNameResolver = methodNameResolver;
	}

	/**
	 * Return the MethodNameResolver used by this class.
	 */
	public final MethodNameResolver getMethodNameResolver() {
		return this.methodNameResolver;
	}

	/**
	 * Set the {@link Validator Validators} for this controller.
	 * <p>The <code>Validators</code> must support the specified command class.
	 */
	public final void setValidators(Validator[] validators) {
		this.validators = validators;
	}

	/**
	 * Return the Validators for this controller.
	 */
	public final Validator[] getValidators() {
		return this.validators;
	}

	/**
	 * Specify a WebBindingInitializer which will apply pre-configured
	 * configuration to every DataBinder that this controller uses.
	 * <p>Allows for factoring out the entire binder configuration
	 * to separate objects, as an alternative to {@link #initBinder}.
	 */
	public final void setWebBindingInitializer(WebBindingInitializer webBindingInitializer) {
		this.webBindingInitializer = webBindingInitializer;
	}

	/**
	 * Return the WebBindingInitializer (if any) which will apply pre-configured
	 * configuration to every DataBinder that this controller uses.
	 */
	public final WebBindingInitializer getWebBindingInitializer() {
		return this.webBindingInitializer;
	}


	/**
	 * Registers all handlers methods on the delegate object.
	 */
	private void registerHandlerMethods(Object delegate) {
		this.handlerMethodMap.clear();
		this.lastModifiedMethodMap.clear();
		this.exceptionHandlerMap.clear();

		// Look at all methods in the subclass, trying to find
		// methods that are validators according to our criteria
		Method[] methods = delegate.getClass().getMethods();
		for (int i = 0; i < methods.length; i++) {
			// We're looking for methods with given parameters.
			Method method = methods[i];
			if (isExceptionHandlerMethod(method)) {
				registerExceptionHandlerMethod(method);
			}
			else if (isHandlerMethod(method)) {
				registerHandlerMethod(method);
				registerLastModifiedMethodIfExists(delegate, method);
			}
		}
	}

	/**
	 * Is the supplied method a valid handler method?
	 * <p>Does not consider <code>Controller.handleRequest</code> itself
	 * as handler method (to avoid potential stack overflow).
	 */
	private boolean isHandlerMethod(Method method) {
		Class returnType = method.getReturnType();
		if (ModelAndView.class.equals(returnType) || Map.class.isAssignableFrom(returnType) || String.class.equals(returnType) ||
				void.class.equals(returnType)) {
			Class[] parameterTypes = method.getParameterTypes();
			return (parameterTypes.length >= 2 &&
					HttpServletRequest.class.equals(parameterTypes[0]) &&
					HttpServletResponse.class.equals(parameterTypes[1]) &&
					!("handleRequest".equals(method.getName()) && parameterTypes.length == 2));
		}
		return false;
	}

	/**
	 * Is the supplied method a valid exception handler method?
	 */
	private boolean isExceptionHandlerMethod(Method method) {
		return (isHandlerMethod(method) &&
				method.getParameterTypes().length == 3 &&
				Throwable.class.isAssignableFrom(method.getParameterTypes()[2]));
	}

	/**
	 * Registers the supplied method as a request handler.
	 */
	private void registerHandlerMethod(Method method) {
		if (logger.isDebugEnabled()) {
			logger.debug("Found action method [" + method + "]");
		}
		this.handlerMethodMap.put(method.getName(), method);
	}

	/**
	 * Registers a last-modified handler method for the supplied handler method
	 * if one exists.
	 */
	private void registerLastModifiedMethodIfExists(Object delegate, Method method) {
		// Look for corresponding LastModified method.
		try {
			Method lastModifiedMethod = delegate.getClass().getMethod(
					method.getName() + LAST_MODIFIED_METHOD_SUFFIX,
					new Class[] {HttpServletRequest.class});
			Class returnType = lastModifiedMethod.getReturnType();
			if (!(long.class.equals(returnType) || Long.class.equals(returnType))) {
				throw new IllegalStateException("last-modified method [" + lastModifiedMethod +
						"] declares an invalid return type - needs to be 'long' or 'Long'");
			}
			// Put in cache, keyed by handler method name.
			this.lastModifiedMethodMap.put(method.getName(), lastModifiedMethod);
			if (logger.isDebugEnabled()) {
				logger.debug("Found last-modified method for handler method [" + method + "]");
			}
		}
		catch (NoSuchMethodException ex) {
			// No last modified method. That's ok.
		}
	}

	/**
	 * Registers the supplied method as an exception handler.
	 */
	private void registerExceptionHandlerMethod(Method method) {
		this.exceptionHandlerMap.put(method.getParameterTypes()[2], method);
		if (logger.isDebugEnabled()) {
			logger.debug("Found exception handler method [" + method + "]");
		}
	}


	//---------------------------------------------------------------------
	// Implementation of LastModified
	//---------------------------------------------------------------------

	public long getLastModified(HttpServletRequest request) {
		try {
			String handlerMethodName = this.methodNameResolver.getHandlerMethodName(request);
			Method lastModifiedMethod = (Method) this.lastModifiedMethodMap.get(handlerMethodName);
			if (lastModifiedMethod != null) {
				try {
					// Invoke the last-modified method...
					Long wrappedLong = (Long) lastModifiedMethod.invoke(this.delegate, new Object[] {request});
					return (wrappedLong != null ? wrappedLong.longValue() : -1);
				}
				catch (Exception ex) {
					// We encountered an error invoking the last-modified method.
					// We can't do anything useful except log this, as we can't throw an exception.
					logger.error("Failed to invoke last-modified method", ex);
				}
			}
		}
		catch (NoSuchRequestHandlingMethodException ex) {
			// No handler method for this request. This shouldn't happen, as this
			// method shouldn't be called unless a previous invocation of this class
			// has generated content. Do nothing, that's OK: We'll return default.
		}
		return -1L;
	}


	//---------------------------------------------------------------------
	// Implementation of AbstractController
	//---------------------------------------------------------------------

	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			String methodName = this.methodNameResolver.getHandlerMethodName(request);
			return invokeNamedMethod(methodName, request, response);
		}
		catch (NoSuchRequestHandlingMethodException ex) {
			return handleNoSuchRequestHandlingMethod(ex, request, response);
		}
	}

	
	protected ModelAndView handleNoSuchRequestHandlingMethod(
			NoSuchRequestHandlingMethodException ex, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		pageNotFoundLogger.warn(ex.getMessage());
		response.sendError(HttpServletResponse.SC_NOT_FOUND);
		return null;
	}

	protected final ModelAndView invokeNamedMethod(
			String methodName, HttpServletRequest request, HttpServletResponse response) throws Exception {

		Method method = (Method) this.handlerMethodMap.get(methodName);
		if (method == null) {
			throw new NoSuchRequestHandlingMethodException(methodName, getClass());
		}
		Class c = method.getReturnType();
		try {
			Class[] paramTypes = method.getParameterTypes();
			List params = new ArrayList(4);
			params.add(request);
			params.add(response);

			if (paramTypes.length >= 3 && paramTypes[2].equals(HttpSession.class)) {
				HttpSession session = request.getSession(false);
				if (session == null) {
					throw new HttpSessionRequiredException(
							"Pre-existing session required for handler method '" + methodName + "'");
				}
				params.add(session);
			}

			// If last parameter isn't of HttpSession type, it's a command.
			if (paramTypes.length >= 3 &&
					!paramTypes[paramTypes.length - 1].equals(HttpSession.class)) {
				Object command = newCommandObject(paramTypes[paramTypes.length - 1]);
				params.add(command);
				bind(request, command);
			}
			
			Object returnValue = method.invoke(this.delegate, params.toArray(new Object[params.size()]));
			return massageReturnValueIfNecessary(returnValue,request,response);
		}
		catch (InvocationTargetException ex) {
			// The handler method threw an exception.
			return handleException(request, response, ex.getTargetException(),c);
		}
		catch (Exception ex) {
			// The binding process threw an exception.
			return handleException(request, response, ex,c);
		}
	}


	private ModelAndView massageReturnValueIfNecessary(Object returnValue,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (returnValue instanceof ModelAndView) {
			return (ModelAndView) returnValue;
		}
		else if (returnValue instanceof Map) {
			JSONUtils.write(returnValue, response.getWriter());
			return null;
		}
		else if (returnValue instanceof String) {
			return new ModelAndView((String) returnValue);
		}
		else {
			// Either returned null or was 'void' return.
			// We'll assume that the handle method already wrote the response.
			return null;
		}
	}


	protected Object newCommandObject(Class clazz) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("Creating new command of class [" + clazz.getName() + "]");
		}
		return BeanUtils.instantiateClass(clazz);
	}

	protected void bind(HttpServletRequest request, Object command) throws Exception {
		logger.debug("Binding request parameters onto MultiActionController command");
		ServletRequestDataBinder binder = createBinder(request, command);
		binder.bind(request);
		if (this.validators != null) {
			for (int i = 0; i < this.validators.length; i++) {
				if (this.validators[i].supports(command.getClass())) {
					ValidationUtils.invokeValidator(this.validators[i], command, binder.getBindingResult());
				}
			}
		}
		binder.closeNoCatch();
	}

	protected ServletRequestDataBinder createBinder(HttpServletRequest request, Object command) throws Exception {
		ServletRequestDataBinder binder = new ServletRequestDataBinder(command, getCommandName(command));
		initBinder(request, binder);
		return binder;
	}

	
	protected String getCommandName(Object command) {
		return DEFAULT_COMMAND_NAME;
	}


	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		if (this.webBindingInitializer != null) {
			this.webBindingInitializer.initBinder(binder, new ServletWebRequest(request));
		}
		initBinder((ServletRequest) request, binder);
	}


	protected void initBinder(ServletRequest request, ServletRequestDataBinder binder) throws Exception {
	}


	private ModelAndView handleException(HttpServletRequest request, HttpServletResponse response, Throwable ex,Class c)
			throws Exception {
		logger.error(ex.getMessage(), ex);
		if(c==ModelAndView.class||c==String.class){
			ReflectionUtils.rethrowException(ex);
		}else if(Map.class.isAssignableFrom(c)){
			ResultMap map = ResultMap.defaultResultMap();
			map.fails(ex.getMessage());
			JSONUtils.write(map, response.getWriter());
		}else{
			ReflectionUtils.rethrowException(ex);
		}
		return null;
	}

}
