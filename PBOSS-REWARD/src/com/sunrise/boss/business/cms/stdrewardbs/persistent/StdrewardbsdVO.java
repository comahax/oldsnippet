package com.sunrise.boss.business.cms.stdrewardbs.persistent;

import java.io.Serializable;

import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardVO;
import com.sunrise.boss.common.base.db.DataPackage;

public class StdrewardbsdVO implements Serializable{
	private StdrewardVO stdrewardVO;
	private StdrewardbsVO stdrewardbsVO;
	private V_StdrewardbsVO unionVO;
	private DataPackage pack;
	public DataPackage getPack() {
		return pack; 
	}
	public void setPack(DataPackage pack) {
		this.pack = pack;
	}
	public V_StdrewardbsVO getUnionVO() {
		return unionVO;
	}
	public void setUnionVO(V_StdrewardbsVO unionVO) {
		this.unionVO = unionVO;
	}
	public StdrewardbsVO getStdrewardbsVO() {
		return stdrewardbsVO;
	}
	public void setStdrewardbsVO(StdrewardbsVO stdrewardbsVO) {
		this.stdrewardbsVO = stdrewardbsVO;
	}
	public StdrewardVO getStdrewardVO() {
		return stdrewardVO;
	}
	public void setStdrewardVO(StdrewardVO stdrewardVO) {
		this.stdrewardVO = stdrewardVO;
	}
	
}
