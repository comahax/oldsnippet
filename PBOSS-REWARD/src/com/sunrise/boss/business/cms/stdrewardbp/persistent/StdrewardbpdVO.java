package com.sunrise.boss.business.cms.stdrewardbp.persistent;

import java.io.Serializable;

import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardVO;

public class StdrewardbpdVO implements Serializable{
	private StdrewardbpVO stdrewardbpVO;
	private StdrewardVO stdrewardVO;
	public StdrewardbpVO getStdrewardbpVO() {
		return stdrewardbpVO;
	}
	public void setStdrewardbpVO(StdrewardbpVO stdrewardbpVO) {
		this.stdrewardbpVO = stdrewardbpVO;
	}
	public StdrewardVO getStdrewardVO() {
		return stdrewardVO;
	}
	public void setStdrewardVO(StdrewardVO stdrewardVO) {
		this.stdrewardVO = stdrewardVO;
	}
	
 }
