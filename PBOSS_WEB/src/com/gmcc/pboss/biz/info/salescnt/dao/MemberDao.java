package com.gmcc.pboss.biz.info.salescnt.dao;

import java.util.Map;

import com.gmcc.pboss.biz.info.salescnt.support.SalescntQueryParameter;

public interface MemberDao {

	public Map<String,String> getMember(SalescntQueryParameter parameter);
}
