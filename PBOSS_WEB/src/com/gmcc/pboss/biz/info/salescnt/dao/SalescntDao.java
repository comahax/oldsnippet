package com.gmcc.pboss.biz.info.salescnt.dao;

import java.util.ArrayList;

import com.gmcc.pboss.biz.info.salescnt.support.SalescntQueryParameter;

public interface SalescntDao {

	public int getRegistersimCnt(SalescntQueryParameter parameter);
	public int getRegisternewCnt(SalescntQueryParameter parameter);
}
