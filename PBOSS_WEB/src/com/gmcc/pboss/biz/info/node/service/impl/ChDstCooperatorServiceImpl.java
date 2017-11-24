package com.gmcc.pboss.biz.info.node.service.impl;

import org.apache.log4j.Logger;

import com.gmcc.pboss.biz.info.node.model.ChDstCooperator;
import com.gmcc.pboss.biz.info.node.dao.ChDstCooperatorDao;
import com.gmcc.pboss.biz.info.node.service.ChDstCooperatorService;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;

public class ChDstCooperatorServiceImpl extends BaseServiceImpl implements
		ChDstCooperatorService {
	/**
	 * 注入Dao接口
	 */
	private ChDstCooperatorDao chDstCooperatorDao;
	public void setChDstCooperatorDao(ChDstCooperatorDao chDstCooperatorDao){
		this.chDstCooperatorDao = chDstCooperatorDao;
	}
	public ChDstCooperatorDao getChDstCooperatorDao(){
		return this.chDstCooperatorDao;
	}
	
	/**
	 * 根据登陆用户的渠道id查询相应的分销合作商cooperator
	 * @param wayid 渠道id
	 * @return      合作商
	 */
	public ChDstCooperator getByWayid(String wayid){
		return this.chDstCooperatorDao.getByWayid(wayid);
	}

}
