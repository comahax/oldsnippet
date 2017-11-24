package com.sunrise.jop.infrastructure.control;

import javax.ejb.*;

/**
 * <p>Title: 抽象Control接口</p>
 *
 * <p>Description: 起隔离层的作用，使control和EJB没有直接的关系</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: sunrise</p>
 *
 * @author DuHuazheng && HuangBaiming
 *
 * @version 1.0
 */
public interface AbstractControl  extends EJBLocalObject, Authorizable{
}
