/**
 * auto-generated code
 * Tue Oct 13 16:31:10 CST 2009
 */
package com.gmcc.pboss.control.sales.actfilerec;

import java.io.File;
import java.io.Serializable;

import com.gmcc.pboss.business.sales.actfilerec.ActfilerecDBParam;
import com.gmcc.pboss.business.sales.actfilerec.ActfilerecVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Actfilerec </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Actfilerec extends AbstractControl {
    public ActfilerecVO doCreate(ActfilerecVO vo) throws Exception;

    public void doRemoveByVO(ActfilerecVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ActfilerecVO doUpdate(ActfilerecVO vo) throws Exception;

    public ActfilerecVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ActfilerecDBParam params) throws Exception;
    
    /**
	 * 逐行处理文件内容
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public void doHandleFileLines(File file) throws Exception;
	
	/**
	 * 逐行处理文件内容(根据分销管理概设V1.42)
	 * @param file
	 * @throws Exception
	 */
	public void doHandleFileLines2(File file) throws Exception;

}
