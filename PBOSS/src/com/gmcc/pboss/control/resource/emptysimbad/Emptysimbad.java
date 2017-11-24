/**
 * auto-generated code
 * Wed Jul 16 15:07:03 CST 2014
 */
package com.gmcc.pboss.control.resource.emptysimbad;

import java.io.Serializable;
import com.gmcc.pboss.business.resource.emptysimbad.EmptysimbadDBParam;
import com.gmcc.pboss.business.resource.emptysimbad.EmptysimbadVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Emptysimbad </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public interface Emptysimbad extends AbstractControl {
    public EmptysimbadVO doCreate(EmptysimbadVO vo) throws Exception;

    public void doRemoveByVO(EmptysimbadVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public EmptysimbadVO doUpdate(EmptysimbadVO vo) throws Exception;

    public EmptysimbadVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(EmptysimbadDBParam params) throws Exception;

    public DataPackage doQueryComcategory(EmptysimbadDBParam params) throws Exception;

    /**
	 * 获取空白SIM卡坏卡数量
	 */
    public DataPackage doEmptySimBadCount(String wayid) throws Exception;
}
