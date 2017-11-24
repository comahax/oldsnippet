package com.gmcc.pboss.control.sales.bgcontrol.ActiveNumberImport;


import java.util.Date;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface ActiveNumberImport extends AbstractControl {

	
	/**
	 * “激活号码导入”之入口方法
	 * @param cityid 地市标识
	 * @param srcpath 激活号码文件的存放路径
	 * @throws Exception
	 */
	public void doProcess(String cityid,String srcpath) throws Exception;
	
	/**
	 * <pre>
	 * 查询BOSS系统的业务日志表（CS_REC_RECEPTION）获取激活数据,
	 * 并将数据插入到号码激活记录表（FX_SN_NOACTINFO）
	 * </pre>
	 * @param cityno 地市编码(数字形式)
	 * @param today
	 * @param yesterday
	 * @return
	 * @throws Exception
	 */
	public int batchImportDataFromBOSS(String cityno, Date today,
			Date yesterday) throws Exception ;
	
	/*
	 * 合作商套卡激活数据更新
	 */
	public int doCooperatorActiveUpdate() throws Exception ;
}
