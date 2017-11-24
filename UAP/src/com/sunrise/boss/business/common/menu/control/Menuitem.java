package com.sunrise.boss.business.common.menu.control;

import java.io.Serializable;
import java.util.Map;

import com.sunrise.boss.business.common.menu.persistent.MenuitemDBParam;
import com.sunrise.boss.business.common.menu.persistent.MenuitemVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Functionitem </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lidl
 * @version 1.0
 */
public interface Menuitem extends AbstractControl {
	
	public DataPackage doQueryItem(Map map) throws Exception;
	
    public MenuitemVO doCreate(MenuitemVO vo) throws Exception;

    public void doRemoveByVO(MenuitemVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public MenuitemVO doUpdate(MenuitemVO vo) throws Exception;

    public MenuitemVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(MenuitemDBParam params) throws Exception;
    
    public DataPackage doQueryBySqlname(String sqlname , MenuitemDBParam params)throws Exception;
    
    /**
     * 查询用户菜单收藏信息
     * @param operId
     * @return
     * @throws Exception
     */
//    public List doQueryMenuByOperId(String operId) throws Exception;

}
