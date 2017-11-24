/**
 * auto-generated code
 * Tue Sep 29 10:15:34 CST 2009
 */
package com.gmcc.pboss.control.communication.rcvobj;

import java.io.Serializable;
import java.util.List;

import com.gmcc.pboss.business.communication.advinfo.AdvinfoVO;
import com.gmcc.pboss.business.communication.rcvobj.RcvobjDBParam;
import com.gmcc.pboss.business.communication.rcvobj.RcvobjVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Rcvobj </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Rcvobj extends AbstractControl {
    public RcvobjVO doCreate(RcvobjVO vo) throws Exception;

    public void doRemoveByVO(RcvobjVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RcvobjVO doUpdate(RcvobjVO vo) throws Exception;

    public RcvobjVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(RcvobjDBParam params) throws Exception;
	
    //通过标题模糊查询公告列表
	public List<AdvinfoVO> doGetAdvinfoListByTitle(String title) throws Exception;
	
    //通过公告id获取公告信息
	public AdvinfoVO doGetAdvinfoByAdvinfoid(String advinfoid) throws Exception;
	
	public DataPackage doUnionQuery(Object[] params,Class[] classvo,String[][] joins)throws Exception;
	
	//保存接收对象
	public void doSaveRcvobj(Long advinfoid, String desttype, String objinfo, Boolean createFlag, Boolean destChangeFlag)throws Exception;
}
