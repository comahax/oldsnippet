package com.asisinfo.common.web;

import java.util.HashMap;
import java.util.List;

import com.asisinfo.common.pager.IPage;


/**
 * 像客户端返回的数据类型
 * @author johnson_hong
 * @created at 2013-2-5
 * @version $Id$
 */
public final class ResultMap extends HashMap<String, Object> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1863541422467539L;
	public final static String RETURN_FLAG="retFlag";
	public final static String MSG="msg";
	
	public final static int SUCCESS_FLAG = 1;
	public final static int FAILURE_FLAG = 0;
	
	public static ResultMap defaultResultMap()
	{
		ResultMap result =new ResultMap();
		result.put(RETURN_FLAG, SUCCESS_FLAG);
		return result;
	}
	
	public void fails(String msg)
	{
		this.put(RETURN_FLAG, FAILURE_FLAG);
		this.put(MSG, msg);
	}
	
	public void setPageInfo(IPage page)
	{
		put(IPage.ROWS,page == null ? null : page.getThisPageElements());
		put(IPage.PAGE_NO,page == null ? null : page.getThisPageNo());
		put(IPage.PAGE_SIZE,page == null ? null : page.getPageSize());
		put(IPage.TOTAL,page == null ? 0 : page.getTotalNumberOfElements());
		put(IPage.PAGE_COUNT,page == null ? 0 : page.getTotalNumberOfPages());
	}
	
	public void setData(List l){
		put(IPage.ROWS,l);
	}

}
